package cooperation.qzone.webviewplugin.personalize;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.StatisticCollector;
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
import cooperation.qzone.model.Size;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;
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
  public int mOpenMouth = 0;
  BroadcastReceiver mReceiver = new QZoneCoverStoreJsPlugin.4(this);
  private volatile boolean mReceiverRegistered = false;
  public int mSource = 0;
  private int mVideoCoverFrom = 0;
  public int mVipType = 0;
  String type = "";
  
  public QZoneCoverStoreJsPlugin()
  {
    this.mPluginNameSpace = "QzCover";
  }
  
  private void forwardInstallAndStartUpVideoActivity(int paramInt)
  {
    QZoneVideoCommonUtils.forwardInstallAndStartUpVideoActivity(this.mRuntime.b().getLongAccountUin(), this.mRuntime.d(), "cover_mall_record_video", new QZoneCoverStoreJsPlugin.3(this, paramInt));
  }
  
  private int generateRequestCode(int paramInt)
  {
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.d());
    int i = paramInt;
    if ((localWebUiBaseInterface instanceof WebViewPluginContainer)) {
      i = ((WebViewPluginContainer)localWebUiBaseInterface).switchRequestCode(this, (byte)paramInt);
    }
    return i;
  }
  
  private String getAid()
  {
    int i = this.mFrom;
    String str = "jhan-cover1";
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 5)
          {
            if (i != 6)
            {
              if (i != 7) {
                return "jhan-cover1";
              }
              return "jhan-ziliaocoverb";
            }
            return "jhan-cover2b";
          }
          return "jhan-cover1b";
        }
        return "jhan-ziliaocover";
      }
      str = "jhan-cover2";
    }
    return str;
  }
  
  private void lauchVideoCover(int paramInt)
  {
    if (this.mRuntime.b() != null)
    {
      if (this.mRuntime.d() == null) {
        return;
      }
      int i = this.mRuntime.d().getResources().getDimensionPixelSize(2131299920);
      if ((QZoneHelper.isBestPerformanceDevice() ^ true))
      {
        QQToast.makeText(this.mRuntime.d(), 2131915145, 0).show(i);
        return;
      }
      registerBroadcast();
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        QLog.i("CoverStore", 1, "VIDEO_COVER click select record video.");
        if (QZonePermission.requestStoragePermission(this.mRuntime.d(), new QZoneCoverStoreJsPlugin.2(this, i), 1)) {
          forwardInstallAndStartUpVideoActivity(i);
        }
      }
      else
      {
        QLog.i("CoverStore", 1, "VIDEO_COVER click select qzone video.");
        QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
        localUserInfo.qzone_uin = this.mRuntime.b().getCurrentAccountUin();
        BaseBusinessAlbumInfo localBaseBusinessAlbumInfo = new BaseBusinessAlbumInfo();
        localBaseBusinessAlbumInfo.mAlbumId = localUserInfo.qzone_uin;
        localBaseBusinessAlbumInfo.mUin = this.mRuntime.b().getLongAccountUin();
        localBaseBusinessAlbumInfo.mAlbumType = 10;
        localBaseBusinessAlbumInfo.mAnonymity = 10;
        localBaseBusinessAlbumInfo.mTitle = this.mRuntime.d().getString(2131914636);
        QZoneHelper.forwardToPersonalAlbumVideoList(this.mRuntime.d(), localUserInfo, localBaseBusinessAlbumInfo, -1, "cover_mall_record_video");
      }
    }
  }
  
  private void launchCustom(String paramString)
  {
    Object localObject;
    if ("MobileAlbum".equals(paramString))
    {
      if (this.mRuntime.b() != null)
      {
        if (this.mRuntime.d() == null) {
          return;
        }
        paramString = new ActivityURIRequest(this.mRuntime.d(), "/base/album/photolist");
        localObject = new Bundle();
        ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
        ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
        ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", true);
        ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
        paramString.extra().putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
        ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
        ((Bundle)localObject).putInt("uintype", 0);
        QZoneHelper.addSource(paramString);
        paramString.extra().putAll((Bundle)localObject);
        ((AbsBaseWebViewActivity)this.mRuntime.d()).gotoSelectPicture(this, paramString, (byte)2);
        return;
      }
      return;
    }
    if ("QzoneAlbum".equals(paramString))
    {
      if (this.mRuntime.b() == null) {
        return;
      }
      paramString = new Bundle();
      paramString.putInt("key_personal_album_enter_model", 2);
      localObject = QZoneHelper.UserInfo.getInstance();
      ((QZoneHelper.UserInfo)localObject).qzone_uin = this.mRuntime.b().getAccount();
      paramString.putString("keyAction", "actionSelectPicture");
      paramString.putBoolean("key_need_change_to_jpg", false);
      QZoneHelper.forwardToPersonalAlbumSelect(this.mRuntime.d(), (QZoneHelper.UserInfo)localObject, paramString, generateRequestCode(3));
    }
  }
  
  private void notifyH5(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    boolean bool = QLog.isColorLevel();
    Object localObject2 = "CoverStore";
    if (bool) {
      QLog.i("CoverStore", 2, "video cover setting start,notify to h5");
    }
    Object localObject1 = localObject2;
    label1091:
    label1092:
    label1106:
    for (;;)
    {
      int i;
      try
      {
        i = paramIntent.getIntExtra("intent_cover_setting_type", 0);
        if (i == 0)
        {
          localObject1 = localObject2;
          i = paramIntent.getIntExtra("PhotoConst.VIDEO_TYPE", -1);
          localObject1 = localObject2;
          Object localObject4 = paramIntent.getStringExtra("thumbnail_path");
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            return;
          }
          localObject1 = localObject2;
          localObject3 = new JSONObject();
          if (i != 2) {
            break label1092;
          }
          localObject1 = localObject2;
          ((JSONObject)localObject3).put("type", 1);
          localObject1 = localObject2;
          ((JSONObject)localObject3).put("picurl", localObject4);
          localObject1 = localObject2;
          ((JSONObject)localObject3).put("videoid", paramIntent.getStringExtra("PhotoConst.QZONE_ALBUM_VIDEO_ID"));
          localObject1 = localObject2;
          ((JSONObject)localObject3).put("videowidth", paramIntent.getIntExtra("thumbnail_width", 0));
          localObject1 = localObject2;
          ((JSONObject)localObject3).put("videoheight", paramIntent.getIntExtra("thumbnail_height", 0));
          localObject1 = localObject2;
          ((JSONObject)localObject3).put("videourl", paramIntent.getStringExtra("file_send_path"));
          paramIntent = (Intent)localObject2;
          continue;
          localObject1 = localObject2;
          QLog.w("CoverStore", 1, "unknown video type");
          return;
          localObject1 = localObject2;
          Object localObject5 = QzoneDynamicAlbumPlugin.getBitmapSize((String)localObject4);
          if (localObject5 == null) {
            return;
          }
          localObject1 = localObject2;
          double d1 = QzoneDynamicAlbumPlugin.getRatio((Size)localObject5);
          if (d1 <= 0.0D) {
            break label1106;
          }
          localObject1 = localObject2;
          i = ((Size)localObject5).width;
          double d2 = i;
          Double.isNaN(d2);
          i = (int)(d2 / d1);
          try
          {
            ((Size)localObject5).width = i;
            i = ((Size)localObject5).height;
            d2 = i;
            Double.isNaN(d2);
            i = (int)(d2 / d1);
            ((Size)localObject5).height = i;
            localObject5 = QzoneDynamicAlbumPlugin.encodeBase64File((String)localObject4, ((Size)localObject5).width, ((Size)localObject5).height);
            if (TextUtils.isEmpty((CharSequence)localObject5))
            {
              paramIntent = new StringBuilder();
              paramIntent.append("video cover pic not exist,imageBase64 empty. path=");
              paramIntent.append((String)localObject4);
              localObject2 = paramIntent.toString();
              paramIntent = "CoverStore";
              localObject1 = paramIntent;
              QLog.w(paramIntent, 1, (String)localObject2);
              return;
            }
            localObject2 = "CoverStore";
            localObject1 = localObject2;
            localObject4 = new StringBuilder();
            localObject1 = localObject2;
            ((StringBuilder)localObject4).append("data:image/jpg;base64,");
            localObject1 = localObject2;
            ((StringBuilder)localObject4).append((String)localObject5);
            localObject1 = localObject2;
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject1 = localObject2;
            ((JSONObject)localObject3).put("type", 0);
            localObject1 = localObject2;
            ((JSONObject)localObject3).put("data", localObject4);
            localObject1 = localObject2;
            ((JSONObject)localObject3).put("videowidth", paramIntent.getIntExtra("thumbnail_width", 0));
            localObject1 = localObject2;
            ((JSONObject)localObject3).put("videoheight", paramIntent.getIntExtra("thumbnail_height", 0));
            paramIntent = (Intent)localObject2;
            localObject1 = paramIntent;
            localObject2 = new StringBuilder();
            localObject1 = paramIntent;
            ((StringBuilder)localObject2).append("window.QZVideoCoverJSInterface.onSetCover(");
            localObject1 = paramIntent;
            ((StringBuilder)localObject2).append(((JSONObject)localObject3).toString());
            localObject1 = paramIntent;
            ((StringBuilder)localObject2).append(")");
            localObject1 = paramIntent;
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject1 = paramIntent;
            if (QLog.isColorLevel())
            {
              localObject1 = paramIntent;
              localObject3 = new StringBuilder();
              localObject1 = paramIntent;
              ((StringBuilder)localObject3).append("video cover notify h5:");
              localObject1 = paramIntent;
              ((StringBuilder)localObject3).append((String)localObject2);
              localObject1 = paramIntent;
              QLog.i(paramIntent, 2, ((StringBuilder)localObject3).toString());
            }
            localObject1 = paramIntent;
            callJs((String)localObject2);
            return;
          }
          catch (Exception paramIntent)
          {
            localObject1 = "CoverStore";
          }
        }
        else
        {
          if (i == 2)
          {
            localObject1 = localObject2;
            localObject3 = new JSONObject();
            localObject1 = localObject2;
            ((JSONObject)localObject3).put("coverid", paramIntent.getStringExtra("cover_id"));
            localObject1 = localObject2;
            paramIntent = new StringBuilder();
            localObject1 = localObject2;
            paramIntent.append("window.QZVideoCoverJSInterface.CancelVideoCover(");
            localObject1 = localObject2;
            paramIntent.append(((JSONObject)localObject3).toString());
            localObject1 = localObject2;
            paramIntent.append(")");
            localObject1 = localObject2;
            paramIntent = paramIntent.toString();
            localObject1 = localObject2;
            callJs(paramIntent);
            localObject1 = localObject2;
            if (!QLog.isColorLevel()) {
              break label1091;
            }
            localObject1 = localObject2;
            localObject3 = new StringBuilder();
            localObject1 = localObject2;
            ((StringBuilder)localObject3).append("video cover notify h5:");
            localObject1 = localObject2;
            ((StringBuilder)localObject3).append(paramIntent);
            localObject1 = localObject2;
            QLog.i("CoverStore", 2, ((StringBuilder)localObject3).toString());
            return;
          }
          if (i != 1) {
            break label1091;
          }
          localObject1 = localObject2;
          localObject3 = new JSONObject();
          localObject1 = localObject2;
          ((JSONObject)localObject3).put("coverid", paramIntent.getStringExtra("cover_id"));
          localObject1 = localObject2;
          paramIntent = new StringBuilder();
          localObject1 = localObject2;
          paramIntent.append("window.QZVideoCoverJSInterface.onSetVideoCover(");
          localObject1 = localObject2;
          paramIntent.append(((JSONObject)localObject3).toString());
          localObject1 = localObject2;
          paramIntent.append(")");
          localObject1 = localObject2;
          paramIntent = paramIntent.toString();
          localObject1 = localObject2;
          callJs(paramIntent);
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break label1091;
          }
          localObject1 = localObject2;
          localObject3 = new StringBuilder();
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append("video cover notify h5:");
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append(paramIntent);
          localObject1 = localObject2;
          QLog.i("CoverStore", 2, ((StringBuilder)localObject3).toString());
          return;
        }
      }
      catch (Exception paramIntent)
      {
        localObject2 = MonitorManager.a();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" exception notify H5 ");
        ((StringBuilder)localObject3).append(paramIntent);
        ((MonitorManager)localObject2).a(2, 5, ((StringBuilder)localObject3).toString(), false);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" handle exception ");
        ((StringBuilder)localObject2).append(paramIntent);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
      if (i != 0) {
        if (1 == i) {}
      }
    }
  }
  
  private void parseSourceAndFrom(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.getString("from");
      if ((!((String)localObject).equals("qzone")) && (!((String)localObject).equals("userhome"))) {
        this.mSource = 1;
      } else {
        this.mSource = 0;
      }
      this.mFrom = Integer.parseInt(paramString.getString("page"));
      this.mAid = paramString.getString("aid");
      localObject = paramString.optString("viptype", "COMMON_VIP");
      if ("STAR_VIP".equals(localObject)) {
        this.mVipType = 3;
      } else if ("COMMON_VIP".equals(localObject)) {
        this.mVipType = 1;
      } else if ("NOBLE_VIP".equals(localObject)) {
        this.mVipType = 2;
      }
      this.mOpenMouth = paramString.optInt("openmonth", 0);
      return;
    }
    catch (JSONException paramString)
    {
      Object localObject = MonitorManager.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" parse json error ");
      localStringBuilder.append(paramString);
      ((MonitorManager)localObject).a(1, 4, localStringBuilder.toString(), false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" handle exception ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("CoverStore", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private String parseUserDefineType(String paramString)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = localJSONObject.getString("type");
      localObject1 = paramString;
      localObject2 = localJSONObject.getString("from");
      localObject1 = paramString;
      if (!((String)localObject2).equals("qzone"))
      {
        localObject1 = paramString;
        if (!((String)localObject2).equals("userhome"))
        {
          localObject1 = paramString;
          this.mSource = 1;
          break label81;
        }
      }
      localObject1 = paramString;
      this.mSource = 0;
      label81:
      localObject1 = paramString;
      this.mFrom = Integer.parseInt(localJSONObject.getString("page"));
      return paramString;
    }
    catch (JSONException paramString)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" handle exception ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.e("CoverStore", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  private void parseVideoCoverData(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      try
      {
        this.mVideoCoverFrom = new JSONObject(paramString).optInt("source", 0);
        return;
      }
      catch (JSONException paramString)
      {
        Object localObject = MonitorManager.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" parse json error ");
        localStringBuilder.append(paramString);
        ((MonitorManager)localObject).a(2, 4, localStringBuilder.toString(), false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" handle exception ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("CoverStore", 2, ((StringBuilder)localObject).toString());
      }
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
      Object localObject = MonitorManager.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" parse json error ");
      localStringBuilder.append(paramString);
      ((MonitorManager)localObject).a(2, 4, localStringBuilder.toString(), false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" handle exception ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("CoverStore", 2, ((StringBuilder)localObject).toString());
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
      Object localObject = MonitorManager.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" parse json error ");
      localStringBuilder.append(paramString);
      ((MonitorManager)localObject).a(2, 4, localStringBuilder.toString(), false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" handle exception ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("CoverStore", 2, ((StringBuilder)localObject).toString());
    }
    return 0;
  }
  
  private void registerBroadcast()
  {
    if (this.mReceiverRegistered) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CoverStore", 2, "video cover registerBroadcast start");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_VIDEO_COVER_SETTING");
    if (this.mRuntime != null)
    {
      Object localObject = this.mRuntime.d();
      if ((localObject != null) && (!this.mReceiverRegistered)) {
        try
        {
          ((Activity)localObject).registerReceiver(this.mReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
          this.mReceiverRegistered = true;
          return;
        }
        catch (Exception localException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("regist receiver error:");
          ((StringBuilder)localObject).append(localException.toString());
          QLog.e("CoverStore", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void toBase64(ArrayList<String> paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject1;
        if (i < paramArrayList.size())
        {
          long l1 = System.currentTimeMillis();
          localObject1 = (String)paramArrayList.get(i);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            Object localObject2 = QzoneDynamicAlbumPlugin.getBitmapSize((String)localObject1);
            if (localObject2 != null)
            {
              double d1 = QzoneDynamicAlbumPlugin.getRatio((Size)localObject2);
              if (d1 > 0.0D)
              {
                j = ((Size)localObject2).width;
                double d2 = j;
                Double.isNaN(d2);
                j = (int)(d2 / d1);
                ((Size)localObject2).width = j;
                j = ((Size)localObject2).height;
                d2 = j;
                Double.isNaN(d2);
                j = (int)(d2 / d1);
                ((Size)localObject2).height = j;
              }
              localObject2 = QzoneDynamicAlbumPlugin.encodeBase64File((String)localObject1, ((Size)localObject2).width, ((Size)localObject2).height);
              boolean bool;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = new JSONObject();
                ((JSONObject)localObject1).put("type", this.type);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("");
                localStringBuilder.append("data:image/jpg;base64,");
                localStringBuilder.append((String)localObject2);
                ((JSONObject)localObject1).put("data", localStringBuilder.toString());
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("window.QZImagePickerJSInterface.onReceive(");
                ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
                ((StringBuilder)localObject2).append(")");
                callJs(((StringBuilder)localObject2).toString());
                bool = true;
              }
              else
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("toBase64 fail. path:");
                ((StringBuilder)localObject2).append((String)localObject1);
                QLog.e("CoverStore", 1, ((StringBuilder)localObject2).toString());
                bool = false;
              }
              long l2 = System.currentTimeMillis();
              localObject1 = new HashMap();
              if (!bool) {
                break label424;
              }
              j = 1;
              ((HashMap)localObject1).put("isSucc", Integer.valueOf(j));
              StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "Qzone.EventTransformPhotoBase64", bool, l2 - l1, 0L, (HashMap)localObject1, null);
            }
          }
          i += 1;
        }
        else
        {
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("toBase64: ");
        ((StringBuilder)localObject1).append(paramArrayList);
        QLog.e("CoverStore", 1, ((StringBuilder)localObject1).toString());
      }
      label424:
      int j = 0;
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
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
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"QzCover".equals(paramString2)) {
      return false;
    }
    if (paramString3.equals("goToPhotoWall")) {
      return true;
    }
    if (paramString3.equals("showStoreButton"))
    {
      if (this.mRuntime.d() == null) {
        return false;
      }
      paramJsBridgeListener = (TextView)this.mRuntime.d().findViewById(2131436211);
      if (paramJsBridgeListener != null)
      {
        paramJsBridgeListener.setVisibility(0);
        paramJsBridgeListener.setTextColor(-1);
        paramJsBridgeListener.setText(HardCodeUtil.a(2131909225));
        paramJsBridgeListener.setOnClickListener(new QZoneCoverStoreJsPlugin.1(this));
        return false;
      }
    }
    else
    {
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
        boolean bool = parseWidgetEnable(paramVarArgs[0]);
        paramJsBridgeListener = new Intent();
        QzonePluginProxyActivity.setActivityNameToIntent(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
        paramJsBridgeListener.putExtra("open_what", 3);
        paramJsBridgeListener.putExtra("widgetEnable", bool);
        if ((this.mRuntime.d() != null) && (this.mRuntime.b() != null))
        {
          QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.d(), this.mRuntime.b().getAccount(), paramJsBridgeListener, generateRequestCode(6));
          return false;
        }
      }
      else if (paramString3.equals("setWidget"))
      {
        int i = parseWidgetId(paramVarArgs[0]);
        paramJsBridgeListener = new Intent();
        QzonePluginProxyActivity.setActivityNameToIntent(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
        paramJsBridgeListener.putExtra("open_what", 2);
        paramJsBridgeListener.putExtra("widgetId", i);
        if ((this.mRuntime.d() != null) && (this.mRuntime.b() != null))
        {
          QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.d(), this.mRuntime.b().getAccount(), paramJsBridgeListener, generateRequestCode(5));
          return false;
        }
      }
      else
      {
        if (paramString3.equals("openYellowDiamond"))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            parseSourceAndFrom(paramVarArgs[0]);
          }
          if (this.mRuntime.b() != null)
          {
            if (this.mRuntime.d() == null) {
              return false;
            }
            paramJsBridgeListener = this.mRuntime.b().getAccount();
            paramString1 = new Intent();
            paramString2 = HardCodeUtil.a(2131909223);
            QzonePluginProxyActivity.setActivityNameToIntent(paramString1, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
            if (TextUtils.isEmpty(this.mAid)) {
              this.mAid = getAid();
            }
            paramString1.putExtra("aid", this.mAid);
            paramString1.putExtra("success_tips", paramString2);
            paramString1.putExtra("direct_go", true);
            paramString1.putExtra("viptype", this.mVipType);
            paramString1.putExtra("month", this.mOpenMouth);
            QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.d(), paramJsBridgeListener, paramString1, generateRequestCode(4), null, false, null, true);
            return false;
          }
          return false;
        }
        if (paramString3.equals("setCover"))
        {
          if ((paramVarArgs != null) && (!TextUtils.isEmpty(paramVarArgs[0]))) {
            try
            {
              if (("PhotoWallCover".equals(new JSONObject(paramVarArgs[0]).getString("coverType"))) && (this.mRuntime.d() != null))
              {
                paramJsBridgeListener = this.mRuntime.b();
                if (paramJsBridgeListener != null) {
                  return true;
                }
              }
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramString1 = new StringBuilder();
              paramString1.append(" handle exception ");
              paramString1.append(paramJsBridgeListener);
              QLog.e("CoverStore", 2, paramString1.toString());
              paramString1 = MonitorManager.a();
              paramString2 = new StringBuilder();
              paramString2.append("set cover data exception ");
              paramString2.append(paramJsBridgeListener);
              paramString1.a(2, 4, paramString2.toString(), false);
              paramJsBridgeListener = new Intent();
              QzonePluginProxyActivity.setActivityNameToIntent(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
              paramJsBridgeListener.putExtra("open_what", 4);
              paramJsBridgeListener.putExtra("cover", paramVarArgs[0]);
              if ((this.mRuntime.d() != null) && (this.mRuntime.b() != null)) {
                QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.d(), this.mRuntime.b().getAccount(), paramJsBridgeListener, generateRequestCode(7));
              }
            }
          }
          return true;
        }
        if ("setLocalCover".equals(paramString3))
        {
          if (paramVarArgs != null)
          {
            if (TextUtils.isEmpty(paramVarArgs[0])) {
              return true;
            }
            paramJsBridgeListener = new Intent();
            QzonePluginProxyActivity.setActivityNameToIntent(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
            paramJsBridgeListener.putExtra("open_what", 6);
            paramJsBridgeListener.putExtra("cover", paramVarArgs[0]);
            if ((this.mRuntime.d() != null) && (this.mRuntime.b() != null)) {
              QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.d(), this.mRuntime.b().getAccount(), paramJsBridgeListener, generateRequestCode(8));
            }
          }
          return true;
        }
        if (paramString3.equals("getWidgetEnable"))
        {
          if (this.mRuntime.b() != null)
          {
            if (this.mRuntime.d() == null) {
              return false;
            }
            paramString1 = new StringBuilder();
            paramString1.append("Widget_");
            paramString1.append(this.mRuntime.b().getCurrentAccountUin());
            paramString1 = paramString1.toString();
            paramJsBridgeListener.a(Boolean.valueOf(this.mRuntime.d().getSharedPreferences(paramString1, 4).getBoolean("WidgetShow", true)));
            return true;
          }
          return false;
        }
        if (paramString3.equals("leftButtonClick"))
        {
          if (this.mRuntime.d() == null) {
            return false;
          }
          ((TextView)this.mRuntime.d().findViewById(2131436180)).performClick();
          return true;
        }
        if ("Init".equals(paramString3))
        {
          QLog.i("CoverStore", 2, "QzCover.Init called.");
          return true;
        }
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramInt == -1)
    {
      Object localObject;
      switch (paramByte)
      {
      case 9: 
      default: 
      case 8: 
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("needJump", false)) && (this.mRuntime.d() != null))
        {
          this.mRuntime.d().finish();
          return;
        }
        break;
      case 7: 
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("need_jump", false)) && (this.mRuntime.d() != null))
        {
          this.mRuntime.d().finish();
          return;
        }
        break;
      case 4: 
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
        break;
      case 3: 
        callJs("window.QZImagePickerJSInterface.doSelectPhoto");
        toBase64(paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
        return;
      case 2: 
        callJs("window.QZImagePickerJSInterface.doSelectPhoto");
        localObject = new ArrayList();
        paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (!TextUtils.isEmpty(paramIntent)) {
          ((ArrayList)localObject).add(paramIntent);
        }
        toBase64((ArrayList)localObject);
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    registerBroadcast();
  }
  
  protected void onDestroy()
  {
    Activity localActivity = this.mRuntime.d();
    if ((localActivity != null) && (this.mReceiverRegistered)) {
      try
      {
        localActivity.unregisterReceiver(this.mReceiver);
        this.mReceiverRegistered = false;
      }
      catch (Exception localException)
      {
        QLog.e("CoverStore", 2, localException, new Object[] { "unregisterReceiver exception" });
      }
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin
 * JD-Core Version:    0.7.0.1
 */