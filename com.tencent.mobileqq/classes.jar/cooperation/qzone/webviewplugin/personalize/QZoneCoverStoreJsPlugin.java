package cooperation.qzone.webviewplugin.personalize;

import amtj;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import bguj;
import bgve;
import bgvf;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.Size;
import cooperation.vip.manager.MonitorManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneCoverStoreJsPlugin
  extends WebViewPlugin
{
  public static final String ACTION_OPEN_VIP_INFO_SUCC = "openVipInfo";
  public static final String ACTION_VIDEO_COVER_SETTING = "com.tencent.mobileqq.action.ACTION_VIDEO_COVER_SETTING";
  public static final String FORWARD_VIDEO_COVER = "forwardSelectVideoCover";
  public static final String GET_WIDGET_ENABLE = "getWidgetEnable";
  public static final String INIT_PLUGIN = "Init";
  public static final String LAUNCH_CUSTOM = "goToUserDefine";
  public static final String LAUNCH_PHOTOWALL = "goToPhotoWall";
  public static final String LEFT_BUTTON_CLICK = "leftButtonClick";
  private static final String MTA_TRANSFORM_PHOTO_TO_BASE_64 = "Qzone.EventTransformPhotoBase64";
  private static final int NOTIFY_H5_VIDEO_TYPE_ALBUM_PIC = 1;
  private static final int NOTIFY_H5_VIDEO_TYPE_BASE64_PIC = 0;
  public static final int OPEN_WHAT_MOBILE_ALUBM = 0;
  public static final int OPEN_WHAT_QZONE_ALBUM = 1;
  public static final int OPEN_WHAT_QZONE_VIDEO = 5;
  public static final int OPEN_WHAT_SET_COVER = 4;
  public static final int OPEN_WHAT_SET_LOCAL_COVER = 6;
  public static final int OPEN_WHAT_SET_WIDGET_ENABLE = 3;
  public static final int OPEN_WHAT_SET_WIDGET_ID = 2;
  public static final String OPEN_YELLOW_DIAMOND = "openYellowDiamond";
  public static final String PERMISSION = "com.tencent.msg.permission.pushnotify";
  public static final String PKG_NAME = "QzCover";
  public static final String SET_ACTIVITY_NAME = "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity";
  public static final String SET_COVER = "setCover";
  public static final String SET_LOCAL_COVER = "setLocalCover";
  public static final String SET_WIDGET = "setWidget";
  public static final String SET_WIDGET_ENABLE = "setWidgetEnable";
  public static final String SHOW_RIGHT_VIEW = "showStoreButton";
  public static final String TAG = "CoverStore";
  public static final int VIDEO_COVER_SOURCE_QZONE_VIDEO = 1;
  public static final int VIDEO_COVER_SOURCE_RECORD_VIDEO = 2;
  public String mAid = "";
  public int mFrom = 4;
  public int mOpenMouth;
  BroadcastReceiver mReceiver = new QZoneCoverStoreJsPlugin.4(this);
  private volatile boolean mReceiverRegistered;
  public int mSource = 0;
  private int mVideoCoverFrom;
  public int mVipType;
  String type = "";
  
  public QZoneCoverStoreJsPlugin()
  {
    this.mPluginNameSpace = "QzCover";
  }
  
  private void forwardInstallAndStartUpVideoActivity(int paramInt)
  {
    QZoneVideoCommonUtils.forwardInstallAndStartUpVideoActivity(this.mRuntime.a().getLongAccountUin(), this.mRuntime.a(), "cover_mall_record_video", new QZoneCoverStoreJsPlugin.3(this, paramInt));
  }
  
  private int generateRequestCode(int paramInt)
  {
    bguj localbguj = this.mRuntime.a(this.mRuntime.a());
    int i = paramInt;
    if ((localbguj instanceof bgvf)) {
      i = ((bgvf)localbguj).switchRequestCode(this, (byte)paramInt);
    }
    return i;
  }
  
  private String getAid()
  {
    switch (this.mFrom)
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
  
  private void lauchVideoCover(int paramInt)
  {
    if ((this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {}
    int j;
    do
    {
      return;
      j = this.mRuntime.a().getResources().getDimensionPixelSize(2131299076);
      if (!QZoneHelper.isBestPerformanceDevice()) {}
      for (int i = 1; i != 0; i = 0)
      {
        QQToast.a(this.mRuntime.a(), 2131717153, 0).b(j);
        return;
      }
      registerBroadcast();
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        QLog.i("CoverStore", 1, "VIDEO_COVER click select qzone video.");
        QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
        localUserInfo.qzone_uin = this.mRuntime.a().getCurrentAccountUin();
        BaseBusinessAlbumInfo localBaseBusinessAlbumInfo = new BaseBusinessAlbumInfo();
        localBaseBusinessAlbumInfo.mAlbumId = localUserInfo.qzone_uin;
        localBaseBusinessAlbumInfo.mUin = this.mRuntime.a().getLongAccountUin();
        localBaseBusinessAlbumInfo.mAlbumType = 10;
        localBaseBusinessAlbumInfo.mAnonymity = 10;
        localBaseBusinessAlbumInfo.mTitle = this.mRuntime.a().getString(2131716646);
        QZoneHelper.forwardToPersonalAlbumVideoList(this.mRuntime.a(), localUserInfo, localBaseBusinessAlbumInfo, -1, "cover_mall_record_video");
        return;
      }
      QLog.i("CoverStore", 1, "VIDEO_COVER click select record video.");
    } while (!QZonePermission.requestStoragePermission(this.mRuntime.a(), new QZoneCoverStoreJsPlugin.2(this, j), 1));
    forwardInstallAndStartUpVideoActivity(j);
  }
  
  private void launchCustom(String paramString)
  {
    if ("MobileAlbum".equals(paramString)) {
      if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {}
    }
    while ((!"QzoneAlbum".equals(paramString)) || (this.mRuntime.a() == null))
    {
      return;
      paramString = new Intent(this.mRuntime.a(), NewPhotoListActivity.class);
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
      QZoneHelper.addSource(paramString);
      paramString.putExtras((Bundle)localObject);
      ((AbsBaseWebViewActivity)this.mRuntime.a()).a(this, paramString, (byte)2);
      return;
    }
    paramString = new Bundle();
    paramString.putInt("key_personal_album_enter_model", 2);
    Object localObject = QZoneHelper.UserInfo.getInstance();
    ((QZoneHelper.UserInfo)localObject).qzone_uin = this.mRuntime.a().getAccount();
    paramString.putString("keyAction", "actionSelectPicture");
    paramString.putBoolean("key_need_change_to_jpg", false);
    QZoneHelper.forwardToPersonalAlbumSelect(this.mRuntime.a(), (QZoneHelper.UserInfo)localObject, paramString, generateRequestCode(3));
  }
  
  private void notifyH5(Intent paramIntent)
  {
    if (paramIntent == null) {}
    label487:
    label497:
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
                break label497;
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
              MonitorManager.a().a(2, 5, " exception notify H5 " + paramIntent, false);
              QLog.e("CoverStore", 2, " handle exception " + paramIntent);
              return;
            }
            if ((i != 0) && (1 != i)) {
              break label487;
            }
            Object localObject = QzoneDynamicAlbumPlugin.getBitmapSize(str);
            if (localObject == null) {
              break;
            }
            double d = QzoneDynamicAlbumPlugin.getRatio((QzoneDynamicAlbumPlugin.Size)localObject);
            if (d > 0.0D)
            {
              ((QzoneDynamicAlbumPlugin.Size)localObject).width = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject).width / d));
              ((QzoneDynamicAlbumPlugin.Size)localObject).height = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject).height / d));
            }
            localObject = QzoneDynamicAlbumPlugin.encodeBase64File(str, ((QzoneDynamicAlbumPlugin.Size)localObject).width, ((QzoneDynamicAlbumPlugin.Size)localObject).height);
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
  
  private void parseSourceAndFrom(String paramString)
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
          this.mSource = 0;
          this.mFrom = Integer.parseInt(paramString.getString("page"));
          this.mAid = paramString.getString("aid");
          str = paramString.optString("viptype", "COMMON_VIP");
          if ("STAR_VIP".equals(str))
          {
            this.mVipType = 3;
            this.mOpenMouth = paramString.optInt("openmonth", 0);
          }
        }
        else
        {
          this.mSource = 1;
          continue;
        }
        if (!"COMMON_VIP".equals(str)) {
          break label189;
        }
      }
      catch (JSONException paramString)
      {
        MonitorManager.a().a(1, 4, " parse json error " + paramString, false);
        QLog.e("CoverStore", 2, " handle exception " + paramString);
        return;
      }
      this.mVipType = 1;
      continue;
      label189:
      if ("NOBLE_VIP".equals(str)) {
        this.mVipType = 2;
      }
    }
  }
  
  private String parseUserDefineType(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.getString("type");
      try
      {
        String str = localJSONObject.getString("from");
        if ((str.equals("qzone")) || (str.equals("userhome"))) {}
        for (this.mSource = 0;; this.mSource = 1)
        {
          this.mFrom = Integer.parseInt(localJSONObject.getString("page"));
          return paramString;
        }
        QLog.e("CoverStore", 2, " handle exception " + localJSONException1);
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
  
  private void parseVideoCoverData(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    try
    {
      this.mVideoCoverFrom = new JSONObject(paramString).optInt("source", 0);
      return;
    }
    catch (JSONException paramString)
    {
      MonitorManager.a().a(2, 4, " parse json error " + paramString, false);
      QLog.e("CoverStore", 2, " handle exception " + paramString);
    }
  }
  
  private boolean parseWidgetEnable(String paramString)
  {
    try
    {
      boolean bool = new JSONObject(paramString).getBoolean("enable");
      return bool;
    }
    catch (JSONException paramString)
    {
      MonitorManager.a().a(2, 4, " parse json error " + paramString, false);
      QLog.e("CoverStore", 2, " handle exception " + paramString);
    }
    return false;
  }
  
  private int parseWidgetId(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).getInt("widgetId");
      return i;
    }
    catch (JSONException paramString)
    {
      MonitorManager.a().a(2, 4, " parse json error " + paramString, false);
      QLog.e("CoverStore", 2, " handle exception " + paramString);
    }
    return 0;
  }
  
  private void registerBroadcast()
  {
    if (this.mReceiverRegistered) {}
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
    } while ((localActivity == null) || (this.mReceiverRegistered));
    try
    {
      localActivity.registerReceiver(this.mReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      this.mReceiverRegistered = true;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CoverStore", 2, "regist receiver error:" + localException.toString());
    }
  }
  
  private void toBase64(ArrayList<String> paramArrayList)
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
            break label339;
          }
          Object localObject2 = QzoneDynamicAlbumPlugin.getBitmapSize((String)localObject1);
          if (localObject2 == null) {
            break label339;
          }
          double d = QzoneDynamicAlbumPlugin.getRatio((QzoneDynamicAlbumPlugin.Size)localObject2);
          if (d > 0.0D)
          {
            ((QzoneDynamicAlbumPlugin.Size)localObject2).width = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject2).width / d));
            ((QzoneDynamicAlbumPlugin.Size)localObject2).height = ((int)(((QzoneDynamicAlbumPlugin.Size)localObject2).height / d));
          }
          localObject2 = QzoneDynamicAlbumPlugin.encodeBase64File((String)localObject1, ((QzoneDynamicAlbumPlugin.Size)localObject2).width, ((QzoneDynamicAlbumPlugin.Size)localObject2).height);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label300;
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("type", this.type);
          ((JSONObject)localObject1).put("data", "" + "data:image/jpg;base64," + (String)localObject2);
          callJs("window.QZImagePickerJSInterface.onReceive(" + ((JSONObject)localObject1).toString() + ")");
          bool = true;
          long l2 = System.currentTimeMillis();
          localObject1 = new HashMap();
          if (!bool) {
            break label333;
          }
          j = 1;
          ((HashMap)localObject1).put("isSucc", Integer.valueOf(j));
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "Qzone.EventTransformPhotoBase64", bool, l2 - l1, 0L, (HashMap)localObject1, null);
        }
      }
      catch (Exception paramArrayList)
      {
        QLog.e("CoverStore", 1, "toBase64: " + paramArrayList);
      }
      return;
      label300:
      QLog.e("CoverStore", 1, "toBase64 fail. path:" + (String)localObject1);
      boolean bool = false;
      continue;
      label333:
      int j = 0;
      continue;
      label339:
      i += 1;
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934600L)
    {
      int i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      Intent localIntent = (Intent)paramMap.get("data");
      int j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if ((i == generateRequestCode(2)) || (i == generateRequestCode(3)))
      {
        if (j == -1)
        {
          callJs("window.QZImagePickerJSInterface.doSelectPhoto");
          paramString = new ArrayList();
          paramMap = localIntent.getStringExtra("key_cover_selected_img_path");
          if (!TextUtils.isEmpty(paramMap))
          {
            paramString.add(paramMap);
            toBase64(paramString);
          }
        }
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!"QzCover".equals(paramString2)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramString3.equals("goToPhotoWall"));
    if (paramString3.equals("showStoreButton"))
    {
      if (this.mRuntime.a() == null) {
        return false;
      }
      paramJsBridgeListener = (TextView)this.mRuntime.a().findViewById(2131369099);
      if (paramJsBridgeListener != null)
      {
        paramJsBridgeListener.setVisibility(0);
        paramJsBridgeListener.setTextColor(-1);
        paramJsBridgeListener.setText(amtj.a(2131710744));
        paramJsBridgeListener.setOnClickListener(new QZoneCoverStoreJsPlugin.1(this));
      }
    }
    label801:
    do
    {
      for (;;)
      {
        return false;
        if (paramString3.equals("goToUserDefine"))
        {
          this.type = parseUserDefineType(paramVarArgs[0]);
          launchCustom(this.type);
          return true;
        }
        if ("forwardSelectVideoCover".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            parseVideoCoverData(paramVarArgs[0]);
          }
          lauchVideoCover(this.mVideoCoverFrom);
          return true;
        }
        if (paramString3.equals("setWidgetEnable"))
        {
          bool1 = parseWidgetEnable(paramVarArgs[0]);
          paramJsBridgeListener = new Intent();
          QzonePluginProxyActivity.setActivityNameToIntent(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
          paramJsBridgeListener.putExtra("open_what", 3);
          paramJsBridgeListener.putExtra("widgetEnable", bool1);
          if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {
            QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, generateRequestCode(6));
          }
        }
        else if (paramString3.equals("setWidget"))
        {
          int i = parseWidgetId(paramVarArgs[0]);
          paramJsBridgeListener = new Intent();
          QzonePluginProxyActivity.setActivityNameToIntent(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
          paramJsBridgeListener.putExtra("open_what", 2);
          paramJsBridgeListener.putExtra("widgetId", i);
          if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null)) {
            QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, generateRequestCode(5));
          }
        }
        else if (paramString3.equals("openYellowDiamond"))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            parseSourceAndFrom(paramVarArgs[0]);
          }
          if ((this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
            return false;
          }
          paramJsBridgeListener = this.mRuntime.a().getAccount();
          paramString1 = new Intent();
          paramString2 = amtj.a(2131710742);
          QzonePluginProxyActivity.setActivityNameToIntent(paramString1, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
          if (TextUtils.isEmpty(this.mAid)) {
            this.mAid = getAid();
          }
          paramString1.putExtra("aid", this.mAid);
          paramString1.putExtra("success_tips", paramString2);
          paramString1.putExtra("direct_go", true);
          paramString1.putExtra("viptype", this.mVipType);
          paramString1.putExtra("month", this.mOpenMouth);
          QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.a(), paramJsBridgeListener, paramString1, generateRequestCode(4), null, false, null, true);
        }
        else
        {
          if (!paramString3.equals("setCover")) {
            break label801;
          }
          bool1 = bool2;
          if (paramVarArgs == null) {
            break;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(paramVarArgs[0])) {
            break;
          }
        }
        try
        {
          if (("PhotoWallCover".equals(new JSONObject(paramVarArgs[0]).getString("coverType"))) && (this.mRuntime.a() != null))
          {
            paramJsBridgeListener = this.mRuntime.a();
            bool1 = bool2;
            if (paramJsBridgeListener != null) {
              break;
            }
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            QLog.e("CoverStore", 2, " handle exception " + paramJsBridgeListener);
            MonitorManager.a().a(2, 4, "set cover data exception " + paramJsBridgeListener, false);
          }
        }
      }
      paramJsBridgeListener = new Intent();
      QzonePluginProxyActivity.setActivityNameToIntent(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
      paramJsBridgeListener.putExtra("open_what", 4);
      paramJsBridgeListener.putExtra("cover", paramVarArgs[0]);
      bool1 = bool2;
      if (this.mRuntime.a() == null) {
        break;
      }
      bool1 = bool2;
      if (this.mRuntime.a() == null) {
        break;
      }
      QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, generateRequestCode(7));
      return true;
      if ("setLocalCover".equals(paramString3))
      {
        bool1 = bool2;
        if (paramVarArgs == null) {
          break;
        }
        bool1 = bool2;
        if (TextUtils.isEmpty(paramVarArgs[0])) {
          break;
        }
        paramJsBridgeListener = new Intent();
        QzonePluginProxyActivity.setActivityNameToIntent(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
        paramJsBridgeListener.putExtra("open_what", 6);
        paramJsBridgeListener.putExtra("cover", paramVarArgs[0]);
        bool1 = bool2;
        if (this.mRuntime.a() == null) {
          break;
        }
        bool1 = bool2;
        if (this.mRuntime.a() == null) {
          break;
        }
        QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramJsBridgeListener, generateRequestCode(8));
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
        ((TextView)this.mRuntime.a().findViewById(2131369068)).performClick();
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
                ((CustomWebView)localObject).callJs("window.QzCoverJSInterface.onReceive({type:\"YellowInfo\",data:{vipType:\"normalVip\"}});");
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
      toBase64((ArrayList)localObject);
      return;
    }
    callJs("window.QZImagePickerJSInterface.doSelectPhoto");
    toBase64(paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
  }
  
  public void onCreate()
  {
    super.onCreate();
    registerBroadcast();
  }
  
  public void onDestroy()
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (this.mReceiverRegistered)) {}
    try
    {
      localActivity.unregisterReceiver(this.mReceiver);
      this.mReceiverRegistered = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin
 * JD-Core Version:    0.7.0.1
 */