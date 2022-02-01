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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
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
import cooperation.qzone.model.Size;
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
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      return paramString;
    }
    if (!((File)localObject).canRead()) {
      return paramString;
    }
    String str1 = paramString;
    String str2;
    if (SharpPUtil.isSharpPFile((File)localObject))
    {
      try
      {
        if (!QQSharpPUtil.a(paramContext))
        {
          QLog.w("QzonePhotoWallPlugin", 1, "------ sharpp is not avaliable.");
          return paramString;
        }
        localObject = SharpPUtil.decodeSharpPByFilePath(((File)localObject).getAbsolutePath());
        str1 = paramString;
        if (localObject == null) {
          return str1;
        }
        paramContext = new StringBuilder();
        paramContext.append(String.valueOf(System.currentTimeMillis()));
        paramContext.append(".jpeg");
        String str3 = paramContext.toString();
        paramContext = new StringBuilder();
        paramContext.append(AppConstants.SDCARD_IMG_SAVE);
        paramContext.append(str3);
        paramContext = VFSAssistantUtils.getSDKPrivatePath(paramContext.toString());
        boolean bool = PhotoUtils.saveBitmapToFile((Bitmap)localObject, paramContext, Bitmap.CompressFormat.JPEG, 90, true);
        str1 = paramString;
        if (!bool) {
          return ???;
        }
        try
        {
          paramString = new StringBuilder();
          paramString.append("------ sharpp file save success:");
          paramString.append(str3);
          QLog.i("QzonePhotoWallPlugin", 1, paramString.toString());
          return paramContext;
        }
        catch (Throwable localThrowable)
        {
          paramString = paramContext;
          paramContext = localThrowable;
        }
        QLog.e("QzonePhotoWallPlugin", 1, "decodeSharpP catch an exception: ", paramContext);
      }
      catch (Throwable paramContext) {}
      str2 = paramString;
    }
    return str2;
  }
  
  private int getCompressType(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("compressType", 0);
    if (i != 1)
    {
      if (i != 2) {
        return 0;
      }
      return 3;
    }
    return 2;
  }
  
  private int getQzoneAlbumModel()
  {
    if (this.maxPickCount > 1) {
      return 1;
    }
    return 2;
  }
  
  public static double getRatio(Context paramContext, int paramInt, Size paramSize)
  {
    double d2 = 0.0D;
    double d1 = d2;
    if (paramSize != null)
    {
      int j = paramSize.width;
      int i = paramSize.height;
      int k;
      if (j < i)
      {
        k = i;
      }
      else
      {
        k = j;
        j = i;
      }
      paramContext = QZoneHelper.getImageTargetSize(paramContext, k, j, paramInt, false);
      d1 = d2;
      if (paramContext != null)
      {
        if ((k <= paramContext.width) && (j <= paramContext.height)) {
          return 0.0D;
        }
        double d3;
        if (k > j)
        {
          d1 = k;
          d2 = paramContext.width;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d2 = d1 / d2;
          d1 = j;
          d3 = paramContext.height;
          Double.isNaN(d1);
          Double.isNaN(d3);
          d1 /= d3;
        }
        else
        {
          d1 = j;
          d2 = paramContext.width;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d2 = d1 / d2;
          d1 = k;
          d3 = paramContext.height;
          Double.isNaN(d1);
          Double.isNaN(d3);
          d1 /= d3;
        }
        if (d2 > d1) {
          return d2;
        }
      }
    }
    return d1;
  }
  
  private void gotoSelectMobilePhoto()
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.parentPlugin.mRuntime.d(), "/base/album/photolist");
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", this.maxPickCount);
    ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
    ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    boolean bool;
    if (this.maxPickCount > 1) {
      bool = false;
    } else {
      bool = true;
    }
    ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", bool);
    ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", this.clipFlag);
    localActivityURIRequest.extra().putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    ((Bundle)localObject).putInt("uintype", 0);
    localActivityURIRequest.extra().putAll((Bundle)localObject);
    QZoneHelper.addSource(localActivityURIRequest);
    localObject = this.parentPlugin.mRuntime.d();
    if (localObject != null)
    {
      gotoSelectPicture((Activity)localObject, this.parentPlugin, localActivityURIRequest, this.REQUEST_PICK_PHOTO);
      return;
    }
    QLog.e("QzonePhotoWallPlugin", 1, "launchCustom MobileAlbum activity is null");
  }
  
  private static void gotoSelectPicture(Activity paramActivity, WebViewPlugin paramWebViewPlugin, ActivityURIRequest paramActivityURIRequest, byte paramByte)
  {
    int i = AbsBaseWebViewActivity.switchRequestCodeImpl(paramWebViewPlugin, paramByte);
    paramActivityURIRequest.extra().putString("keyAction", "actionSelectPicture");
    paramActivityURIRequest.extra().putInt("requestCode", i);
    QRoute.startUri(paramActivityURIRequest);
  }
  
  private void launchCustom(String paramString)
  {
    if ("MobileAlbum".equals(paramString))
    {
      if (!QZonePermission.requestStoragePermission(this.parentPlugin.mRuntime.d(), new QzonePhotoWallPlugin.1(this), 1)) {
        return;
      }
      gotoSelectMobilePhoto();
      return;
    }
    if ("QzoneAlbum".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putInt("key_personal_album_enter_model", getQzoneAlbumModel());
      paramString.putInt("_input_max", this.maxPickCount);
      paramString.putBoolean("key_multiple_model_need_download_img", true);
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = this.parentPlugin.mRuntime.b().getAccount();
      paramString.putString("keyAction", "actionSelectPicture");
      paramString.putBoolean("key_need_change_to_jpg", false);
      QZoneHelper.forwardToPersonalAlbumSelect(this.parentPlugin.mRuntime.d(), localUserInfo, paramString, this.REQUEST_PICK_PHOTO);
    }
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
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.userInfo == null) {
        this.userInfo = new JSONObject();
      }
      localJSONObject.put("userInfo", this.userInfo);
      int i;
      if (paramArrayList == null) {
        i = 0;
      } else {
        i = paramArrayList.size();
      }
      localJSONObject.put("totalPickCount", i);
      WebViewPlugin localWebViewPlugin = this.parentPlugin;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("window.QZImagePickerJSInterface.doSelectPhoto(");
      localStringBuilder.append(localJSONObject.toString());
      localStringBuilder.append(")");
      localWebViewPlugin.callJs(localStringBuilder.toString());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if ((getQzoneAlbumModel() == 2) && (paramArrayList != null) && (paramArrayList.size() != 0)) {
      identifierset.add(paramArrayList.get(0));
    }
    ThreadManager.post(new QzonePhotoWallPlugin.3(this, paramArrayList), 8, null, false);
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
        Object localObject1;
        if (i < paramArrayList.size())
        {
          localObject1 = (String)paramArrayList.get(i);
          long l1 = System.currentTimeMillis();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            String str = checkSharpP((String)localObject1, this.parentPlugin.mRuntime.d().getApplicationContext());
            identifierset.add(str);
            localObject1 = QzoneDynamicAlbumPlugin.getBitmapSize(str);
            if (localObject1 != null)
            {
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("@coverOptimize with =");
              ((StringBuilder)localObject2).append(((Size)localObject1).width);
              ((StringBuilder)localObject2).append(" height=");
              ((StringBuilder)localObject2).append(((Size)localObject1).height);
              ((StringBuilder)localObject2).append(" compressType=");
              ((StringBuilder)localObject2).append(this.compressType);
              QLog.i("QzonePhotoWallPlugin", 2, ((StringBuilder)localObject2).toString());
              if (this.compressType != 3)
              {
                double d1 = getRatio(this.parentPlugin.mRuntime.d(), this.compressType, (Size)localObject1);
                if (d1 > 0.0D)
                {
                  j = ((Size)localObject1).width;
                  double d2 = j;
                  Double.isNaN(d2);
                  j = (int)(d2 / d1);
                  ((Size)localObject1).width = j;
                  j = ((Size)localObject1).height;
                  d2 = j;
                  Double.isNaN(d2);
                  j = (int)(d2 / d1);
                  ((Size)localObject1).height = j;
                }
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("@coverOptimize change width =");
              ((StringBuilder)localObject2).append(((Size)localObject1).width);
              ((StringBuilder)localObject2).append(" height=");
              ((StringBuilder)localObject2).append(((Size)localObject1).height);
              ((StringBuilder)localObject2).append(" compressType=");
              ((StringBuilder)localObject2).append(this.compressType);
              QLog.i("QzonePhotoWallPlugin", 2, ((StringBuilder)localObject2).toString());
              localObject2 = QzoneDynamicAlbumPlugin.encodeBase64File(str, ((Size)localObject1).width, ((Size)localObject1).height);
              boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
              if (!bool) {
                try
                {
                  localObject3 = new JSONObject();
                  ((JSONObject)localObject3).put("currentIndex", i);
                  if ((getQzoneAlbumModel() == 2) || (!paramBoolean))
                  {
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append("@coverOptimize before path =");
                    ((StringBuilder)localObject4).append(str);
                    QLog.i("QzonePhotoWallPlugin", 2, ((StringBuilder)localObject4).toString());
                    localObject4 = Base64.encodeToString(str.getBytes(), 2);
                    ((JSONObject)localObject3).put("identifier", localObject4);
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append("@coverOptimize toH5 identifier =");
                    localStringBuilder.append((String)localObject4);
                    QLog.i("QzonePhotoWallPlugin", 2, localStringBuilder.toString());
                  }
                  if (this.noNeedImageData) {
                    break label949;
                  }
                  Object localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("");
                  ((StringBuilder)localObject4).append("data:image/jpg;base64,");
                  ((StringBuilder)localObject4).append((String)localObject2);
                  localObject4 = ((StringBuilder)localObject4).toString();
                  j = ((String)localObject2).length();
                  ((JSONObject)localObject3).put("imageSize", j);
                  ((JSONObject)localObject3).put("data", localObject4);
                  localObject4 = this.parentPlugin;
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("window.QZImagePickerJSInterface.onReceive(");
                  localStringBuilder.append(((JSONObject)localObject3).toString());
                  localStringBuilder.append(")");
                  ((WebViewPlugin)localObject4).callJs(localStringBuilder.toString());
                  long l2 = System.currentTimeMillis();
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("@coverOptimize  path=");
                  ((StringBuilder)localObject3).append(str);
                  ((StringBuilder)localObject3).append(" timediff=");
                  ((StringBuilder)localObject3).append(l2 - l1);
                  ((StringBuilder)localObject3).append(" length=");
                  ((StringBuilder)localObject3).append(j);
                  ((StringBuilder)localObject3).append(" compressType =");
                  ((StringBuilder)localObject3).append(this.compressType);
                  ((StringBuilder)localObject3).append(" with =");
                  ((StringBuilder)localObject3).append(((Size)localObject1).width);
                  ((StringBuilder)localObject3).append(" height=");
                  ((StringBuilder)localObject3).append(((Size)localObject1).height);
                  QLog.i("QzonePhotoWallPlugin", 2, ((StringBuilder)localObject3).toString());
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  Object localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("imageBase64 size=");
                  ((StringBuilder)localObject3).append(((String)localObject2).length());
                  ((StringBuilder)localObject3).append(",compressType=");
                  ((StringBuilder)localObject3).append(this.compressType);
                  ((StringBuilder)localObject3).append(",width=");
                  ((StringBuilder)localObject3).append(((Size)localObject1).width);
                  ((StringBuilder)localObject3).append(",height=");
                  ((StringBuilder)localObject3).append(((Size)localObject1).height);
                  ((StringBuilder)localObject3).append(",");
                  ((StringBuilder)localObject3).append(localOutOfMemoryError);
                  QLog.e("QzonePhotoWallPlugin", 2, ((StringBuilder)localObject3).toString());
                  ToastUtil.a().a(HardCodeUtil.a(2131909714), 1);
                }
              }
            }
          }
          i += 1;
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramArrayList)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("toBase64: ");
        ((StringBuilder)localObject1).append(paramArrayList);
        QLog.e("QzonePhotoWallPlugin", 1, ((StringBuilder)localObject1).toString());
      }
      label949:
      int j = 0;
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934600L) && (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.REQUEST_PICK_PHOTO))
    {
      int i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      paramString = (Intent)paramMap.get("data");
      int j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if ((i == this.REQUEST_PICK_PHOTO) && (j == -1))
      {
        if (getQzoneAlbumModel() == 1)
        {
          paramString = paramString.getStringArrayListExtra("key_cover_selected_img_path");
        }
        else
        {
          paramMap = new ArrayList();
          String str = paramString.getStringExtra("key_cover_selected_img_path");
          paramString = paramMap;
          if (!TextUtils.isEmpty(str))
          {
            paramMap.add(str);
            paramString = paramMap;
          }
        }
        pushResultToH5(paramString);
      }
      return true;
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("QZImagePicker")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if (paramString3.equals("choosePhoto"))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0))
        {
          parseSourceAndFrom(paramVarArgs[0]);
          this.compressType = 0;
          if (this.pickerType == 0)
          {
            launchCustom("MobileAlbum");
            return true;
          }
          launchCustom("QzoneAlbum");
        }
        return true;
      }
      if (paramString3.equals("getLocalImage")) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          this.compressType = getCompressType(paramJsBridgeListener);
          paramJsBridgeListener = paramJsBridgeListener.optString("identifier", "");
          boolean bool = TextUtils.isEmpty(paramJsBridgeListener);
          if (bool)
          {
            QLog.w("QzonePhotoWallPlugin", 2, "@coverOptimize  identifier is null or size is 0 ");
            return false;
          }
          paramJsBridgeListener = new String(Base64.decode(paramJsBridgeListener, 2));
          paramString1 = new ArrayList();
          paramString1.add(paramJsBridgeListener);
          paramString2 = new StringBuilder();
          paramString2.append("@coverOptimize  identifier =");
          paramString2.append(paramJsBridgeListener);
          QLog.i("QzonePhotoWallPlugin", 1, paramString2.toString());
          if (!identifierset.contains(paramJsBridgeListener))
          {
            paramString1 = new StringBuilder();
            paramString1.append("@coverOptimize  identifier is wrong identifier = ");
            paramString1.append(paramJsBridgeListener);
            QLog.w("QzonePhotoWallPlugin", 2, paramString1.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzonePhotoWallPlugin
 * JD-Core Version:    0.7.0.1
 */