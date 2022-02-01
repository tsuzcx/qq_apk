package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class LaunchParam
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParam> CREATOR = new LaunchParam.1();
  public static final int LAUNCH_SCENE_1017 = 1017;
  public static final int LAUNCH_SCENE_1025 = 1025;
  public static final int LAUNCH_SCENE_1034 = 1034;
  public static final int LAUNCH_SCENE_1053 = 1053;
  public static final int LAUNCH_SCENE_1059 = 1059;
  public static final int LAUNCH_SCENE_1069 = 1069;
  public static final int LAUNCH_SCENE_1095 = 1095;
  public static final int LAUNCH_SCENE_1096 = 1096;
  public static final int LAUNCH_SCENE_1103 = 1103;
  public static final int LAUNCH_SCENE_AD_BANNER_POPUP = 2094;
  public static final int LAUNCH_SCENE_AD_SCHEME = 2054;
  public static final int LAUNCH_SCENE_AIO_PANEL = 2053;
  public static final int LAUNCH_SCENE_APP_STORE_GAME_LIST = 2002;
  public static final int LAUNCH_SCENE_APP_STORE_TOP_LIST = 2001;
  public static final int LAUNCH_SCENE_ARK_BATTLE = 2072;
  public static final int LAUNCH_SCENE_ARK_INNER_TEMPLATE_MESSAGE = 2061;
  public static final int LAUNCH_SCENE_ARK_SEARCH_OPEN_CARD = 2075;
  public static final int LAUNCH_SCENE_ARK_UNKNOWN = 2059;
  public static final int LAUNCH_SCENE_COLOR_NOTE = 1131;
  public static final int LAUNCH_SCENE_CONTACTS = 2006;
  public static final int LAUNCH_SCENE_DESKTOP_BOUTIQUE_RECOMMEND = 3008;
  public static final int LAUNCH_SCENE_DESKTOP_DITTO_QUICK_MATCH = 3013;
  public static final int LAUNCH_SCENE_DESKTOP_DITTO_RECOMMEND = 3012;
  public static final int LAUNCH_SCENE_DESKTOP_EVERYONE_PLAYING = 3007;
  public static final int LAUNCH_SCENE_DESKTOP_FRIENDS_PK = 3009;
  public static final int LAUNCH_SCENE_DESKTOP_FRIENDS_PLAYING_MORE = 3004;
  public static final int LAUNCH_SCENE_DESKTOP_MORE = 3005;
  public static final int LAUNCH_SCENE_DESKTOP_MY_APP = 3003;
  public static final int LAUNCH_SCENE_DESKTOP_POPULARITY_LIST = 3010;
  public static final int LAUNCH_SCENE_DESKTOP_RECENT_APP = 3001;
  public static final int LAUNCH_SCENE_DESKTOP_RECOMMEND_APP = 3002;
  public static final int LAUNCH_SCENE_DESKTOP_SEARCH_APP = 2077;
  public static final int LAUNCH_SCENE_DESKTOP_SEARCH_BAR = 3006;
  public static final int LAUNCH_SCENE_DESKTOP_SHORTCUT = 1023;
  public static final int LAUNCH_SCENE_DESKTOP_TOP_BANNER = 3011;
  public static final int LAUNCH_SCENE_FILE_TENCENT_DOC = 2012;
  public static final int LAUNCH_SCENE_FILE_WEIYUN = 2011;
  public static final int LAUNCH_SCENE_FLOAT_DRAG_AD = 2115;
  public static final int LAUNCH_SCENE_INTIMATE_RELATIONSHIP_PLAY_TOGETHER = 2064;
  public static final int LAUNCH_SCENE_KUOLIE_RECOMM = 2065;
  public static final int LAUNCH_SCENE_LEBA = 2007;
  public static final int LAUNCH_SCENE_LEBA_MINIAPP = 2050;
  public static final int LAUNCH_SCENE_MAIN_ENTRY = 1001;
  public static final int LAUNCH_SCENE_MINI_APP_ONCE_SUBSCRIBE = 2105;
  public static final int LAUNCH_SCENE_MINI_APP_PROFILE = 1024;
  public static final int LAUNCH_SCENE_MINI_APP_SUBSCRIBE = 2085;
  public static final int LAUNCH_SCENE_MINI_CODE_FROM_ALBUM = 1049;
  public static final int LAUNCH_SCENE_MINI_CODE_FROM_LONG_PRESS = 1048;
  public static final int LAUNCH_SCENE_MINI_CODE_FROM_SCAN = 1047;
  public static final int LAUNCH_SCENE_NAVIGATE_FROM_MINI_APP = 1038;
  public static final int LAUNCH_SCENE_OPEN_BY_MINI_APP = 1037;
  public static final int LAUNCH_SCENE_PROFILE_CARD = 2062;
  public static final int LAUNCH_SCENE_PUBLIC_ACCOUNT_MEMNU = 1035;
  public static final int LAUNCH_SCENE_PUBLIC_ACCOUNT_MESSAGE_CARD = 1074;
  public static final int LAUNCH_SCENE_PUBLIC_ACCOUNT_TEMPLATE_MESSAGE = 1043;
  public static final int LAUNCH_SCENE_QQ_WALLET = 1019;
  public static final int LAUNCH_SCENE_QQ_X_MAN = 2093;
  public static final int LAUNCH_SCENE_QR_CODE_FROM_ALBUM = 1013;
  public static final int LAUNCH_SCENE_QR_CODE_FROM_LONG_PRESS = 1012;
  public static final int LAUNCH_SCENE_QR_CODE_FROM_SCAN = 1011;
  public static final int LAUNCH_SCENE_QUN = 2010;
  public static final int LAUNCH_SCENE_QZONE = 2009;
  public static final int LAUNCH_SCENE_QZONE_FRIEND_PLAYING_NINE = 2092;
  public static final int LAUNCH_SCENE_QZONE_FRIEND_PLAYING_THIRD = 2090;
  public static final int LAUNCH_SCENE_QZONE_SHUOSHUO_LIST = 2060;
  public static final int LAUNCH_SCENE_SCHEME = 2016;
  public static final int LAUNCH_SCENE_SEARCH = 2005;
  public static final int LAUNCH_SCENE_SEARCH_HAS_USED = 1027;
  public static final int LAUNCH_SCENE_SEARCH_RESULT_FIND = 1006;
  public static final int LAUNCH_SCENE_SEARCH_RESULT_TOP = 1005;
  public static final int LAUNCH_SCENE_SHARE_C2C = 1007;
  public static final int LAUNCH_SCENE_SHARE_GROUP = 1008;
  public static final int LAUNCH_SCENE_SHARE_OPEN_SDK = 1036;
  public static final int LAUNCH_SCENE_SHARE_QZONE = 2003;
  public static final int LAUNCH_SCENE_SHARE_TICKET = 1044;
  public static final int LAUNCH_SCENE_SPLASH = 2004;
  public static final int LAUNCH_SCENE_STORY_CAMERA_PLAY_SHOW = 2083;
  public static final int LAUNCH_SCENE_TEMPLATE_MESSAGE = 1014;
  public static final int LAUNCH_SCENE_UNKNOWN = 9999;
  public static final int LAUNCH_SCENE_USER_TOP_ENTRY = 1022;
  public static final int LAUNCH_SCENE_WEATHER = 2066;
  public static final int LAUNCH_SCENE_WEBVIEW_HOOK = 2014;
  public static final String LAUNCH_VIA_QQ_X_MAN = "2016_4";
  public static final String MINI_APPID_COLLECTION_PAGE = "101495732";
  public static final int STATE_LOADING = 1;
  public static final int STATE_NONE = 0;
  public EntryModel entryModel;
  public String entryPath;
  public String envVersion;
  public String extendData;
  public String extraKey;
  public String fakeUrl;
  public int fromBackToMiniApp;
  public String fromEnvVersion;
  public String fromMiniAppId;
  public MiniAppInfo fromMiniAppInfo;
  public boolean isFakeAppInfo;
  public boolean isFlutterMode;
  public long launchClickTimeMillis;
  public String miniAppId;
  public String navigateExtData;
  public String privateExtraData;
  public String reportData;
  public int scene = 1001;
  public String shareTicket;
  public int tempState = 0;
  public long timestamp;
  
  public static boolean isCollectionPage(String paramString)
  {
    return "101495732".equals(paramString);
  }
  
  private static String standardEntryPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = "";
    int i = paramString.indexOf("?");
    Object localObject = paramString;
    if (i != -1)
    {
      localObject = paramString.substring(0, i);
      str = paramString.substring(i + 1, paramString.length());
    }
    paramString = (String)localObject;
    if (!((String)localObject).toLowerCase().endsWith(".html")) {
      paramString = (String)localObject + ".html";
    }
    localObject = new StringBuilder().append(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (paramString = "";; paramString = "?" + str) {
      return paramString;
    }
  }
  
  public void clone(LaunchParam paramLaunchParam)
  {
    if (paramLaunchParam == null) {
      return;
    }
    this.scene = paramLaunchParam.scene;
    this.miniAppId = paramLaunchParam.miniAppId;
    this.extraKey = paramLaunchParam.extraKey;
    this.entryPath = paramLaunchParam.entryPath;
    this.navigateExtData = paramLaunchParam.navigateExtData;
    this.fromMiniAppId = paramLaunchParam.fromMiniAppId;
    this.launchClickTimeMillis = paramLaunchParam.launchClickTimeMillis;
    this.tempState = paramLaunchParam.tempState;
    this.timestamp = paramLaunchParam.timestamp;
    this.shareTicket = paramLaunchParam.shareTicket;
    this.envVersion = paramLaunchParam.envVersion;
    this.reportData = paramLaunchParam.reportData;
    this.extendData = paramLaunchParam.extendData;
    this.entryModel = paramLaunchParam.entryModel;
    this.fromBackToMiniApp = paramLaunchParam.fromBackToMiniApp;
    this.isFakeAppInfo = paramLaunchParam.isFakeAppInfo;
    this.isFlutterMode = paramLaunchParam.isFlutterMode;
    this.fromEnvVersion = paramLaunchParam.fromEnvVersion;
    this.fromMiniAppInfo = paramLaunchParam.fromMiniAppInfo;
    this.privateExtraData = paramLaunchParam.privateExtraData;
  }
  
  public void createFrom(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.scene = paramParcel.readInt();
    this.miniAppId = paramParcel.readString();
    this.extraKey = paramParcel.readString();
    this.entryPath = paramParcel.readString();
    this.navigateExtData = paramParcel.readString();
    this.fromMiniAppId = paramParcel.readString();
    this.launchClickTimeMillis = paramParcel.readLong();
    this.tempState = paramParcel.readInt();
    this.timestamp = paramParcel.readLong();
    this.shareTicket = paramParcel.readString();
    this.envVersion = paramParcel.readString();
    this.reportData = paramParcel.readString();
    this.extendData = paramParcel.readString();
    this.entryModel = ((EntryModel)paramParcel.readParcelable(EntryModel.class.getClassLoader()));
    this.fromBackToMiniApp = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.isFakeAppInfo = bool1;
      if (paramParcel.readInt() != 1) {
        break label200;
      }
    }
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isFlutterMode = bool1;
      this.fromEnvVersion = paramParcel.readString();
      this.fromMiniAppInfo = ((MiniAppInfo)paramParcel.readParcelable(MiniAppInfo.class.getClassLoader()));
      this.privateExtraData = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean fromBackToMiniApp()
  {
    return this.fromBackToMiniApp == 1;
  }
  
  public String getScheme()
  {
    Object localObject2 = "mqqapi://microapp/open?mini_appid=" + this.miniAppId;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.entryPath)) {
      localObject1 = (String)localObject2 + "&entryPath=" + this.entryPath;
    }
    localObject2 = localObject1;
    if (!TextUtils.isEmpty(this.extendData)) {
      localObject2 = (String)localObject1 + "&extraData=" + this.extendData;
    }
    return localObject2;
  }
  
  public boolean isValid()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    switch (this.scene)
    {
    default: 
      if (TextUtils.isEmpty(this.miniAppId))
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(this.fakeUrl)) {
          break;
        }
      }
      else
      {
        bool1 = true;
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
        } while (!TextUtils.isEmpty(this.fakeUrl));
        return false;
      } while ((!TextUtils.isEmpty(this.miniAppId)) && (!TextUtils.isEmpty(this.fromMiniAppId)));
      return false;
    } while (!TextUtils.isEmpty(this.fakeUrl));
    return false;
  }
  
  public void standardize()
  {
    this.entryPath = standardEntryPath(this.entryPath);
  }
  
  public String toString()
  {
    return "LaunchParam{scene=" + this.scene + ", miniAppId='" + this.miniAppId + '\'' + ", extraKey='" + this.extraKey + '\'' + ", entryPath='" + this.entryPath + '\'' + ", extendData='" + this.extendData + '\'' + ", navigateExtData='" + this.navigateExtData + '\'' + ", fromMiniAppId='" + this.fromMiniAppId + '\'' + ", fakeUrl='" + this.fakeUrl + '\'' + ", timestamp=" + this.timestamp + ", launchClickTimeMillis=" + this.launchClickTimeMillis + ", tempState=" + this.tempState + ", shareTicket=" + this.shareTicket + ", envVersion=" + this.envVersion + ", reportData=" + this.reportData + ", fromBackToMiniApp=" + this.fromBackToMiniApp + ", isFakeAppInfo=" + this.isFakeAppInfo + ", isFlutterMode=" + this.isFlutterMode + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.miniAppId);
    paramParcel.writeString(this.extraKey);
    paramParcel.writeString(this.entryPath);
    paramParcel.writeString(this.navigateExtData);
    paramParcel.writeString(this.fromMiniAppId);
    paramParcel.writeLong(this.launchClickTimeMillis);
    paramParcel.writeInt(this.tempState);
    paramParcel.writeLong(this.timestamp);
    paramParcel.writeString(this.shareTicket);
    paramParcel.writeString(this.envVersion);
    paramParcel.writeString(this.reportData);
    paramParcel.writeString(this.extendData);
    paramParcel.writeParcelable(this.entryModel, paramInt);
    paramParcel.writeInt(this.fromBackToMiniApp);
    if (this.isFakeAppInfo)
    {
      i = 1;
      paramParcel.writeInt(i);
      if (!this.isFlutterMode) {
        break label184;
      }
    }
    label184:
    for (int i = j;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.fromEnvVersion);
      paramParcel.writeParcelable(this.fromMiniAppInfo, paramInt);
      paramParcel.writeString(this.privateExtraData);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.LaunchParam
 * JD-Core Version:    0.7.0.1
 */