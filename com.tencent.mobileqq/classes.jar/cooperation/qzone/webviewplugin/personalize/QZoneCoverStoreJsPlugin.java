package cooperation.qzone.webviewplugin.personalize;

import amno;
import amnp;
import amnq;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.MTAReportController;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.Size;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneCoverStoreJsPlugin
  extends WebViewPlugin
{
  public int a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new amnq(this);
  public String a;
  private volatile boolean jdField_a_of_type_Boolean;
  public int b;
  String b;
  public int c;
  public int d;
  private int e;
  
  public QZoneCoverStoreJsPlugin()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.mPluginNameSpace = "QzCover";
  }
  
  private int a(int paramInt)
  {
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    int i = paramInt;
    if ((localWebUiBaseInterface instanceof WebViewPluginContainer)) {
      i = ((WebViewPluginContainer)localWebUiBaseInterface).a(this, (byte)paramInt);
    }
    return i;
  }
  
  private int a(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).getInt("widgetId");
      return i;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private String a()
  {
    switch (this.jdField_b_of_type_Int)
    {
    case 4: 
    default: 
      return "jhan-cover1";
    case 1: 
      return "jhan-cover1";
    case 5: 
      return "jhan-cover1b";
    case 2: 
      return "jhan-cover2";
    case 6: 
      return "jhan-cover2b";
    case 3: 
      return "jhan-ziliaocover";
    }
    return "jhan-ziliaocoverb";
  }
  
  private String a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.getString("type");
      try
      {
        String str = localJSONObject.getString("from");
        if ((str.equals("qzone")) || (str.equals("userhome"))) {}
        for (this.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Int = 1)
        {
          this.jdField_b_of_type_Int = Integer.parseInt(localJSONObject.getString("page"));
          return paramString;
        }
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1) {}
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        paramString = "";
      }
    }
    return paramString;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      IntentFilter localIntentFilter;
      Activity localActivity;
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.i("CoverStore", 2, "video cover registerBroadcast start");
          }
          localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_VIDEO_COVER_SETTING");
        } while (this.mRuntime == null);
        localActivity = this.mRuntime.a();
      } while ((localActivity == null) || (this.jdField_a_of_type_Boolean));
      try
      {
        localActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("CoverStore", 2, "regist receiver error:" + localException.toString());
  }
  
  private void a(int paramInt)
  {
    if ((this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
      return;
    }
    int j = this.mRuntime.a().getResources().getDimensionPixelSize(2131558448);
    if (!QZoneHelper.d()) {}
    for (int i = 1; i != 0; i = 0)
    {
      QQToast.a(this.mRuntime.a(), 2131432785, 0).b(j);
      return;
    }
    a();
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      QLog.i("CoverStore", 1, "VIDEO_COVER click select qzone video.");
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.mRuntime.a().getCurrentAccountUin();
      BaseBusinessAlbumInfo localBaseBusinessAlbumInfo = new BaseBusinessAlbumInfo();
      localBaseBusinessAlbumInfo.jdField_a_of_type_JavaLangString = localUserInfo.jdField_a_of_type_JavaLangString;
      localBaseBusinessAlbumInfo.jdField_a_of_type_Long = this.mRuntime.a().getLongAccountUin();
      localBaseBusinessAlbumInfo.c = 10;
      localBaseBusinessAlbumInfo.d = 10;
      localBaseBusinessAlbumInfo.jdField_b_of_type_JavaLangString = this.mRuntime.a().getString(2131432723);
      QZoneHelper.b(this.mRuntime.a(), localUserInfo, localBaseBusinessAlbumInfo, -1, "cover_mall_record_video");
      return;
    }
    QLog.i("CoverStore", 1, "VIDEO_COVER click select record video.");
    QZoneVideoCommonUtils.a(this.mRuntime.a().getLongAccountUin(), this.mRuntime.a(), "cover_mall_record_video", new amnp(this, j));
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    label448:
    label458:
    do
    {
      int i;
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.i("CoverStore", 2, "video cover setting start,notify to h5");
          }
          for (;;)
          {
            try
            {
              i = paramIntent.getIntExtra("intent_cover_setting_type", 0);
              if (i != 0) {
                break label458;
              }
              i = paramIntent.getIntExtra("PhotoConst.VIDEO_TYPE", -1);
              str = paramIntent.getStringExtra("thumbnail_path");
              if (TextUtils.isEmpty(str)) {
                break;
              }
              localJSONObject = new JSONObject();
              if (i == 2)
              {
                localJSONObject.put("type", 1);
                localJSONObject.put("picurl", str);
                localJSONObject.put("videoid", paramIntent.getStringExtra("PhotoConst.QZONE_ALBUM_VIDEO_ID"));
                localJSONObject.put("videowidth", paramIntent.getIntExtra("thumbnail_width", 0));
                localJSONObject.put("videoheight", paramIntent.getIntExtra("thumbnail_height", 0));
                localJSONObject.put("videourl", paramIntent.getStringExtra("file_send_path"));
                paramIntent = "window.QZVideoCoverJSInterface.onSetCover(" + localJSONObject.toString() + ")";
                if (QLog.isColorLevel()) {
                  QLog.i("CoverStore", 2, "video cover notify h5:" + paramIntent);
                }
                callJs(paramIntent);
                return;
              }
            }
            catch (Exception paramIntent)
            {
              paramIntent.printStackTrace();
              QLog.e("CoverStore", 1, paramIntent, new Object[] { "toBase64 error " });
              return;
            }
            if ((i != 0) && (1 != i)) {
              break label448;
            }
            Object localObject = QzoneDynamicAlbumPlugin.a(str);
            if (localObject == null) {
              break;
            }
            double d1 = QzoneDynamicAlbumPlugin.a((QzoneDynamicAlbumPlugin.Size)localObject);
            if (d1 > 0.0D)
            {
              ((QzoneDynamicAlbumPlugin.Size)localObject).jdField_a_of_type_Int = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject).jdField_a_of_type_Int / d1));
              ((QzoneDynamicAlbumPlugin.Size)localObject).jdField_b_of_type_Int = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject).jdField_b_of_type_Int / d1));
            }
            localObject = QzoneDynamicAlbumPlugin.a(str, ((QzoneDynamicAlbumPlugin.Size)localObject).jdField_a_of_type_Int, ((QzoneDynamicAlbumPlugin.Size)localObject).jdField_b_of_type_Int);
            if (TextUtils.isEmpty((CharSequence)localObject))
            {
              QLog.w("CoverStore", 1, "video cover pic not exist,imageBase64 empty. path=" + str);
              return;
            }
            String str = "data:image/jpg;base64," + (String)localObject;
            localJSONObject.put("type", 0);
            localJSONObject.put("data", str);
            localJSONObject.put("videowidth", paramIntent.getIntExtra("thumbnail_width", 0));
            localJSONObject.put("videoheight", paramIntent.getIntExtra("thumbnail_height", 0));
          }
          QLog.w("CoverStore", 1, "unknown video type");
          return;
          if (i != 2) {
            break;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("coverid", paramIntent.getStringExtra("cover_id"));
          paramIntent = "window.QZVideoCoverJSInterface.CancelVideoCover(" + localJSONObject.toString() + ")";
          callJs(paramIntent);
        } while (!QLog.isColorLevel());
        QLog.i("CoverStore", 2, "video cover notify h5:" + paramIntent);
        return;
      } while (i != 1);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("coverid", paramIntent.getStringExtra("cover_id"));
      paramIntent = "window.QZVideoCoverJSInterface.onSetVideoCover(" + localJSONObject.toString() + ")";
      callJs(paramIntent);
    } while (!QLog.isColorLevel());
    QLog.i("CoverStore", 2, "video cover notify h5:" + paramIntent);
  }
  
  private void a(String paramString)
  {
    if ("MobileAlbum".equals(paramString)) {
      if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {}
    }
    while ((!"QzoneAlbum".equals(paramString)) || (this.mRuntime.a() == null))
    {
      return;
      paramString = new Intent(this.mRuntime.a(), PhotoListActivity.class);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", true);
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
      paramString.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      ((Bundle)localObject).putInt("uintype", 0);
      paramString.putExtras((Bundle)localObject);
      ((AbsBaseWebViewActivity)this.mRuntime.a()).a(this, paramString, (byte)2);
      return;
    }
    paramString = new Bundle();
    paramString.putInt("key_personal_album_enter_model", 2);
    Object localObject = QZoneHelper.UserInfo.a();
    ((QZoneHelper.UserInfo)localObject).jdField_a_of_type_JavaLangString = this.mRuntime.a().getAccount();
    paramString.putString("keyAction", "actionSelectPicture");
    paramString.putBoolean("key_need_change_to_jpg", false);
    QZoneHelper.a(this.mRuntime.a(), (QZoneHelper.UserInfo)localObject, paramString, a(3));
  }
  
  private void a(ArrayList paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      Object localObject1;
      try
      {
        if (i < paramArrayList.size())
        {
          long l1 = System.currentTimeMillis();
          localObject1 = (String)paramArrayList.get(i);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label335;
          }
          Object localObject2 = QzoneDynamicAlbumPlugin.a((String)localObject1);
          if (localObject2 == null) {
            break label335;
          }
          double d1 = QzoneDynamicAlbumPlugin.a((QzoneDynamicAlbumPlugin.Size)localObject2);
          if (d1 > 0.0D)
          {
            ((QzoneDynamicAlbumPlugin.Size)localObject2).jdField_a_of_type_Int = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject2).jdField_a_of_type_Int / d1));
            ((QzoneDynamicAlbumPlugin.Size)localObject2).jdField_b_of_type_Int = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject2).jdField_b_of_type_Int / d1));
          }
          localObject2 = QzoneDynamicAlbumPlugin.a((String)localObject1, ((QzoneDynamicAlbumPlugin.Size)localObject2).jdField_a_of_type_Int, ((QzoneDynamicAlbumPlugin.Size)localObject2).jdField_b_of_type_Int);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label296;
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("type", this.jdField_b_of_type_JavaLangString);
          ((JSONObject)localObject1).put("data", "" + "data:image/jpg;base64," + (String)localObject2);
          callJs("window.QZImagePickerJSInterface.onReceive(" + ((JSONObject)localObject1).toString() + ")");
          j = 1;
          long l2 = System.currentTimeMillis();
          localObject1 = new Properties();
          if (j == 0) {
            break label329;
          }
          j = 1;
          ((Properties)localObject1).put("isSucc", Integer.valueOf(j));
          MTAReportController.a(BaseApplication.getContext()).reportTimeKVEvent("Qzone.EventTransformPhotoBase64", (Properties)localObject1, (int)(l2 - l1));
        }
      }
      catch (Exception paramArrayList)
      {
        QLog.e("CoverStore", 1, "toBase64: " + paramArrayList);
      }
      return;
      label296:
      QLog.e("CoverStore", 1, "toBase64 fail. path:" + (String)localObject1);
      int j = 0;
      continue;
      label329:
      j = 0;
      continue;
      label335:
      i += 1;
    }
  }
  
  private boolean a(String paramString)
  {
    try
    {
      boolean bool = new JSONObject(paramString).getBoolean("enable");
      return bool;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        str = paramString.getString("from");
        if ((str.equals("qzone")) || (str.equals("userhome")))
        {
          this.jdField_a_of_type_Int = 0;
          this.jdField_b_of_type_Int = Integer.parseInt(paramString.getString("page"));
          this.jdField_a_of_type_JavaLangString = paramString.getString("aid");
          str = paramString.optString("viptype", "COMMON_VIP");
          if ("STAR_VIP".equals(str))
          {
            this.c = 3;
            this.d = paramString.optInt("openmonth", 0);
          }
        }
        else
        {
          this.jdField_a_of_type_Int = 1;
          continue;
        }
        if (!"COMMON_VIP".equals(str)) {
          break label134;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      this.c = 1;
      continue;
      label134:
      if ("NOBLE_VIP".equals(str)) {
        this.c = 2;
      }
    }
  }
  
  private void c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    try
    {
      this.e = new JSONObject(paramString).optInt("source", 0);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934600L)
    {
      int i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      Intent localIntent = (Intent)paramMap.get("data");
      int j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if ((i == a(2)) || (i == a(3)))
      {
        if (j == -1)
        {
          callJs("window.QZImagePickerJSInterface.doSelectPhoto");
          paramString = new ArrayList();
          paramMap = localIntent.getStringExtra("key_cover_selected_img_path");
          if (!TextUtils.isEmpty(paramMap))
          {
            paramString.add(paramMap);
            a(paramString);
          }
        }
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"QzCover".equals(paramString2)) {
      return false;
    }
    if (paramString3.equals("goToPhotoWall"))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        b(paramVarArgs[0]);
      }
      return true;
    }
    if (paramString3.equals("showStoreButton"))
    {
      if (this.mRuntime.a() == null) {
        return false;
      }
      paramJsBridgeListener = (TextView)this.mRuntime.a().findViewById(2131363410);
      if (paramJsBridgeListener != null)
      {
        paramJsBridgeListener.setVisibility(0);
        paramJsBridgeListener.setTextColor(-1);
        paramJsBridgeListener.setText("背景商城");
        paramJsBridgeListener.setOnClickListener(new amno(this));
      }
    }
    do
    {
      for (;;)
      {
        return false;
        if (paramString3.equals("goToUserDefine"))
        {
          this.jdField_b_of_type_JavaLangString = a(paramVarArgs[0]);
          a(this.jdField_b_of_type_JavaLangString);
          return true;
        }
        if ("forwardSelectVideoCover".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            c(paramVarArgs[0]);
          }
          a(this.e);
          return true;
        }
        if (paramString3.equals("setWidgetEnable"))
        {
          boolean bool = a(paramVarArgs[0]);
          paramJsBridgeListener = new Intent();
          QzonePluginProxyActivity.a(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
          paramJsBridgeListener.putExtra("open_what", 3);
          paramJsBridgeListener.putExtra("widgetEnable", bool);
          if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {
            QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, a(6));
          }
        }
        else if (paramString3.equals("setWidget"))
        {
          int i = a(paramVarArgs[0]);
          paramJsBridgeListener = new Intent();
          QzonePluginProxyActivity.a(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
          paramJsBridgeListener.putExtra("open_what", 2);
          paramJsBridgeListener.putExtra("widgetId", i);
          if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {
            QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, a(5));
          }
        }
        else
        {
          if (!paramString3.equals("openYellowDiamond")) {
            break;
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            b(paramVarArgs[0]);
          }
          if ((this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
            return false;
          }
          paramJsBridgeListener = this.mRuntime.a().getAccount();
          paramString1 = new Intent();
          paramString2 = this.mRuntime.a().getResources().getString(2131432614);
          QzonePluginProxyActivity.a(paramString1, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            this.jdField_a_of_type_JavaLangString = a();
          }
          paramString1.putExtra("aid", this.jdField_a_of_type_JavaLangString);
          paramString1.putExtra("success_tips", paramString2);
          paramString1.putExtra("direct_go", true);
          paramString1.putExtra("viptype", this.c);
          paramString1.putExtra("month", this.d);
          QzonePluginProxyActivity.a(this.mRuntime.a(), paramJsBridgeListener, paramString1, a(4));
        }
      }
      if (paramString3.equals("setCover"))
      {
        if ((paramVarArgs != null) && (!TextUtils.isEmpty(paramVarArgs[0]))) {
          try
          {
            if (("PhotoWallCover".equals(new JSONObject(paramVarArgs[0]).getString("coverType"))) && (this.mRuntime.a() != null))
            {
              paramJsBridgeListener = this.mRuntime.a();
              if (paramJsBridgeListener != null) {
                return true;
              }
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            paramJsBridgeListener = new Intent();
            QzonePluginProxyActivity.a(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
            paramJsBridgeListener.putExtra("open_what", 4);
            paramJsBridgeListener.putExtra("cover", paramVarArgs[0]);
            if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {
              QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, a(7));
            }
          }
        }
        return true;
      }
      if ("setLocalCover".equals(paramString3))
      {
        if ((paramVarArgs == null) || (TextUtils.isEmpty(paramVarArgs[0]))) {
          return true;
        }
        paramJsBridgeListener = new Intent();
        QzonePluginProxyActivity.a(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
        paramJsBridgeListener.putExtra("open_what", 6);
        paramJsBridgeListener.putExtra("cover", paramVarArgs[0]);
        if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {
          QzonePluginProxyActivity.a(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, a(8));
        }
        return true;
      }
      if (paramString3.equals("getWidgetEnable"))
      {
        if ((this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
          return false;
        }
        paramString1 = "Widget_" + this.mRuntime.a().getCurrentAccountUin();
        paramJsBridgeListener.a(Boolean.valueOf(this.mRuntime.a().getSharedPreferences(paramString1, 4).getBoolean("WidgetShow", true)));
        return true;
      }
      if (paramString3.equals("leftButtonClick"))
      {
        if (this.mRuntime.a() == null) {
          return false;
        }
        ((TextView)this.mRuntime.a().findViewById(2131363227)).performClick();
        return true;
      }
    } while (!"Init".equals(paramString3));
    QLog.i("CoverStore", 2, "QzCover.Init called.");
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramInt == -1) {}
    Object localObject;
    switch (paramByte)
    {
    case 1: 
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    default: 
    case 7: 
    case 8: 
    case 4: 
      for (;;)
      {
        return;
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("need_jump", false)) && (this.mRuntime.a() != null))
        {
          this.mRuntime.a().finish();
          return;
          if ((paramIntent != null) && (paramIntent.getBooleanExtra("needJump", false)) && (this.mRuntime.a() != null))
          {
            this.mRuntime.a().finish();
            return;
            if (paramInt == -1)
            {
              localObject = this.mRuntime.a();
              if (localObject != null)
              {
                ((CustomWebView)localObject).c("window.QzCoverJSInterface.onReceive({type:\"YellowInfo\",data:{vipType:\"normalVip\"}});");
                if (paramIntent != null) {
                  try
                  {
                    paramIntent = paramIntent.getExtras().getString("qzone_vip_open_succ_str");
                    if (!TextUtils.isEmpty(paramIntent))
                    {
                      paramIntent = new JSONObject(paramIntent);
                      dispatchJsEvent("openVipInfo", paramIntent, paramIntent);
                      return;
                    }
                  }
                  catch (Exception paramIntent)
                  {
                    QLog.e("CoverStore", 2, paramIntent.getMessage());
                    return;
                  }
                }
              }
            }
          }
        }
      }
    case 2: 
      callJs("window.QZImagePickerJSInterface.doSelectPhoto");
      localObject = new ArrayList();
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(paramIntent)) {
        ((ArrayList)localObject).add(paramIntent);
      }
      a((ArrayList)localObject);
      return;
    }
    callJs("window.QZImagePickerJSInterface.doSelectPhoto");
    a(paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
  }
  
  protected void onCreate()
  {
    super.onCreate();
    a();
  }
  
  protected void onDestroy()
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (this.jdField_a_of_type_Boolean)) {}
    try
    {
      localActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("CoverStore", 2, localException, new Object[] { "unregisterReceiver exception" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin
 * JD-Core Version:    0.7.0.1
 */