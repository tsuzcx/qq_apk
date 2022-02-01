package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.util.PhotoUtils;
import cooperation.qzone.util.QZonePermission;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class QzonePhotoWallPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final int COMPRESS_HD = 2;
  public static final int COMPRESS_NORMAL = 0;
  public static final int COMPRESS_RAW = 3;
  public static final boolean DEFULAT_NEEDIMAGEDATA = false;
  public static final String NAMESPACE = "QZImagePicker";
  private static final String TAG = "QzonePhotoWallPlugin";
  public static Set<String> identifierset = new HashSet();
  private byte REQUEST_PICK_PHOTO = 115;
  private boolean clipFlag = false;
  int compressType = 0;
  public int mFrom = 4;
  public int mSource = 0;
  int maxPickCount = 3;
  private boolean noNeedImageData = false;
  int pickerType = 0;
  JSONObject userInfo = null;
  
  public static String checkSharpP(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return paramString;
      localObject = new File(paramString);
    } while ((!((File)localObject).exists()) || (!((File)localObject).canRead()) || (!SharpPUtil.isSharpPFile((File)localObject)));
    try
    {
      if (!QQSharpPUtil.a(paramContext))
      {
        QLog.w("QzonePhotoWallPlugin", 1, "------ sharpp is not avaliable.");
        return paramString;
      }
    }
    catch (Throwable paramContext) {}
    for (;;)
    {
      QLog.e("QzonePhotoWallPlugin", 1, "decodeSharpP catch an exception: ", paramContext);
      return paramString;
      localObject = SharpPUtil.decodeSharpPByFilePath(((File)localObject).getAbsolutePath());
      if (localObject == null) {
        break;
      }
      String str = String.valueOf(System.currentTimeMillis()) + ".jpeg";
      paramContext = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE + str);
      boolean bool = PhotoUtils.saveBitmapToFile((Bitmap)localObject, paramContext, Bitmap.CompressFormat.JPEG, 90, true);
      if (!bool) {
        break;
      }
      try
      {
        QLog.i("QzonePhotoWallPlugin", 1, "------ sharpp file save success:" + str);
        return paramContext;
      }
      catch (Throwable localThrowable)
      {
        paramString = paramContext;
        paramContext = localThrowable;
      }
    }
  }
  
  private int getCompressType(JSONObject paramJSONObject)
  {
    switch (paramJSONObject.optInt("compressType", 0))
    {
    default: 
      return 0;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  private int getQzoneAlbumModel()
  {
    if (this.maxPickCount > 1) {
      return 1;
    }
    return 2;
  }
  
  public static double getRatio(Context paramContext, int paramInt, QzoneDynamicAlbumPlugin.Size paramSize)
  {
    if (paramSize != null)
    {
      int i = paramSize.width;
      int j = paramSize.height;
      int k;
      if (i < j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        paramContext = QZoneHelper.getImageTargetSize(paramContext, k, j, paramInt, false);
        double d3;
        if ((paramContext == null) || ((k <= paramContext.width) && (j <= paramContext.height)))
        {
          d3 = 0.0D;
          return d3;
        }
        double d1;
        if (k > j) {
          d1 = k / paramContext.width;
        }
        for (double d2 = j / paramContext.height;; d2 = k / paramContext.height)
        {
          d3 = d1;
          if (d1 > d2) {
            break;
          }
          return d2;
          d1 = j / paramContext.width;
        }
        k = i;
      }
    }
    return 0.0D;
  }
  
  private void gotoSelectMobilePhoto()
  {
    Intent localIntent = new Intent(this.parentPlugin.mRuntime.a(), NewPhotoListActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", this.maxPickCount);
    ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
    ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    if (this.maxPickCount > 1) {}
    for (boolean bool = false;; bool = true)
    {
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", bool);
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", this.clipFlag);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      ((Bundle)localObject).putInt("uintype", 0);
      localIntent.putExtras((Bundle)localObject);
      QZoneHelper.addSource(localIntent);
      localObject = this.parentPlugin.mRuntime.a();
      if (localObject == null) {
        break;
      }
      gotoSelectPicture((Activity)localObject, this.parentPlugin, localIntent, this.REQUEST_PICK_PHOTO);
      return;
    }
    QLog.e("QzonePhotoWallPlugin", 1, "launchCustom MobileAlbum activity is null");
  }
  
  private static void gotoSelectPicture(Activity paramActivity, WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = AbsBaseWebViewActivity.switchRequestCodeImpl(paramWebViewPlugin, paramByte);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i);
    paramActivity.startActivity(paramIntent);
  }
  
  private void launchCustom(String paramString)
  {
    if ("MobileAlbum".equals(paramString)) {
      if (QZonePermission.requestStoragePermission(this.parentPlugin.mRuntime.a(), new QzonePhotoWallPlugin.1(this), 1)) {}
    }
    while (!"QzoneAlbum".equals(paramString))
    {
      return;
      gotoSelectMobilePhoto();
      return;
    }
    paramString = new Bundle();
    paramString.putInt("key_personal_album_enter_model", getQzoneAlbumModel());
    paramString.putInt("_input_max", this.maxPickCount);
    paramString.putBoolean("key_multiple_model_need_download_img", true);
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.parentPlugin.mRuntime.a().getAccount();
    paramString.putString("keyAction", "actionSelectPicture");
    paramString.putBoolean("key_need_change_to_jpg", false);
    QZoneHelper.forwardToPersonalAlbumSelect(this.parentPlugin.mRuntime.a(), localUserInfo, paramString, this.REQUEST_PICK_PHOTO);
  }
  
  private void parseSourceAndFrom(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.pickerType = paramString.getInt("pickerType");
      this.maxPickCount = paramString.getInt("maxPickCount");
      this.compressType = getCompressType(paramString);
      this.userInfo = paramString.optJSONObject("userInfo");
      this.clipFlag = paramString.optBoolean("clipByH5");
      this.noNeedImageData = paramString.optBoolean("noNeedImageData", false);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void pushResultToH5(ArrayList<String> paramArrayList)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.userInfo == null) {
          this.userInfo = new JSONObject();
        }
        localJSONObject.put("userInfo", this.userInfo);
        if (paramArrayList != null) {
          continue;
        }
        i = 0;
        localJSONObject.put("totalPickCount", i);
        this.parentPlugin.callJs("window.QZImagePickerJSInterface.doSelectPhoto(" + localJSONObject.toString() + ")");
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      if ((getQzoneAlbumModel() == 2) && (paramArrayList != null) && (paramArrayList.size() != 0)) {
        identifierset.add(paramArrayList.get(0));
      }
      ThreadManager.post(new QzonePhotoWallPlugin.3(this, paramArrayList), 8, null, false);
      return;
      i = paramArrayList.size();
    }
  }
  
  private void startTobase64(ArrayList<String> paramArrayList)
  {
    ThreadManager.post(new QzonePhotoWallPlugin.2(this, paramArrayList), 8, null, false);
  }
  
  private void toBase64(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramArrayList.size())
        {
          Object localObject = (String)paramArrayList.get(i);
          long l1 = System.currentTimeMillis();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            String str2 = checkSharpP((String)localObject, this.parentPlugin.mRuntime.a().getApplicationContext());
            identifierset.add(str2);
            localObject = QzoneDynamicAlbumPlugin.getBitmapSize(str2);
            if (localObject != null)
            {
              QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize with =" + ((QzoneDynamicAlbumPlugin.Size)localObject).width + " height=" + ((QzoneDynamicAlbumPlugin.Size)localObject).height + " compressType=" + this.compressType);
              if (this.compressType != 3)
              {
                double d = getRatio(this.parentPlugin.mRuntime.a(), this.compressType, (QzoneDynamicAlbumPlugin.Size)localObject);
                if (d > 0.0D)
                {
                  ((QzoneDynamicAlbumPlugin.Size)localObject).width = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject).width / d));
                  ((QzoneDynamicAlbumPlugin.Size)localObject).height = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject).height / d));
                }
              }
              QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize change width =" + ((QzoneDynamicAlbumPlugin.Size)localObject).width + " height=" + ((QzoneDynamicAlbumPlugin.Size)localObject).height + " compressType=" + this.compressType);
              String str1 = QzoneDynamicAlbumPlugin.encodeBase64File(str2, ((QzoneDynamicAlbumPlugin.Size)localObject).width, ((QzoneDynamicAlbumPlugin.Size)localObject).height);
              boolean bool = TextUtils.isEmpty(str1);
              if (!bool) {
                try
                {
                  JSONObject localJSONObject = new JSONObject();
                  localJSONObject.put("currentIndex", i);
                  String str3;
                  if ((getQzoneAlbumModel() == 2) || (!paramBoolean))
                  {
                    QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize before path =" + str2);
                    str3 = Base64.encodeToString(str2.getBytes(), 2);
                    localJSONObject.put("identifier", str3);
                    QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize toH5 identifier =" + str3);
                  }
                  int j = 0;
                  if (!this.noNeedImageData)
                  {
                    str3 = "" + "data:image/jpg;base64," + str1;
                    j = str1.length();
                    localJSONObject.put("imageSize", j);
                    localJSONObject.put("data", str3);
                  }
                  this.parentPlugin.callJs("window.QZImagePickerJSInterface.onReceive(" + localJSONObject.toString() + ")");
                  long l2 = System.currentTimeMillis();
                  QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize  path=" + str2 + " timediff=" + (l2 - l1) + " length=" + j + " compressType =" + this.compressType + " with =" + ((QzoneDynamicAlbumPlugin.Size)localObject).width + " height=" + ((QzoneDynamicAlbumPlugin.Size)localObject).height);
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  QLog.e("QzonePhotoWallPlugin", 2, "imageBase64 size=" + str1.length() + ",compressType=" + this.compressType + ",width=" + ((QzoneDynamicAlbumPlugin.Size)localObject).width + ",height=" + ((QzoneDynamicAlbumPlugin.Size)localObject).height + "," + localOutOfMemoryError);
                  ToastUtil.a().a(HardCodeUtil.a(2131712117), 1);
                }
              }
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramArrayList)
      {
        QLog.e("QzonePhotoWallPlugin", 1, "toBase64: " + paramArrayList);
      }
      i += 1;
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934600L) && (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.REQUEST_PICK_PHOTO))
    {
      int i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      Intent localIntent = (Intent)paramMap.get("data");
      int j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if ((i == this.REQUEST_PICK_PHOTO) && (j == -1))
      {
        if (getQzoneAlbumModel() != 1) {
          break label130;
        }
        paramString = localIntent.getStringArrayListExtra("key_cover_selected_img_path");
      }
      for (;;)
      {
        pushResultToH5(paramString);
        return true;
        label130:
        paramString = new ArrayList();
        paramMap = localIntent.getStringExtra("key_cover_selected_img_path");
        if (!TextUtils.isEmpty(paramMap)) {
          paramString.add(paramMap);
        }
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!paramString2.equals("QZImagePicker")) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if (!paramString3.equals("choosePhoto")) {
          break;
        }
        bool1 = bool2;
      } while (paramVarArgs == null);
      bool1 = bool2;
    } while (paramVarArgs.length <= 0);
    parseSourceAndFrom(paramVarArgs[0]);
    this.compressType = 0;
    if (this.pickerType == 0)
    {
      launchCustom("MobileAlbum");
      return true;
    }
    launchCustom("QzoneAlbum");
    return true;
    if (paramString3.equals("getLocalImage")) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        this.compressType = getCompressType(paramJsBridgeListener);
        paramJsBridgeListener = paramJsBridgeListener.optString("identifier", "");
        if (TextUtils.isEmpty(paramJsBridgeListener))
        {
          QLog.w("QzonePhotoWallPlugin", 2, "@coverOptimize  identifier is null or size is 0 ");
          return false;
        }
        paramJsBridgeListener = new String(Base64.decode(paramJsBridgeListener, 2));
        paramString1 = new ArrayList();
        paramString1.add(paramJsBridgeListener);
        QLog.i("QzonePhotoWallPlugin", 1, "@coverOptimize  identifier =" + paramJsBridgeListener);
        if (!identifierset.contains(paramJsBridgeListener))
        {
          QLog.w("QzonePhotoWallPlugin", 2, "@coverOptimize  identifier is wrong identifier = " + paramJsBridgeListener);
          return false;
        }
        this.noNeedImageData = false;
        startTobase64(paramString1);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if ((paramByte == this.REQUEST_PICK_PHOTO) && (paramInt == -1))
    {
      ArrayList localArrayList2 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      ArrayList localArrayList1;
      if (localArrayList2 != null)
      {
        localArrayList1 = localArrayList2;
        if (!localArrayList2.isEmpty()) {}
      }
      else
      {
        localArrayList2 = new ArrayList(1);
        paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        localArrayList1 = localArrayList2;
        if (!TextUtils.isEmpty(paramIntent))
        {
          localArrayList2.add(paramIntent);
          localArrayList1 = localArrayList2;
        }
      }
      pushResultToH5(localArrayList1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzonePhotoWallPlugin
 * JD-Core Version:    0.7.0.1
 */