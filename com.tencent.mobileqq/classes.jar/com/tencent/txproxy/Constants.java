package com.tencent.txproxy;

public class Constants
{
  public static final String APPID_HY = "Hy";
  public static final String APPID_LIVE = "Live";
  public static final String APPID_OD = "Od";
  public static final int PROXY_VERSION = 7;
  
  public class Action
  {
    public static final String ACTION_INC_UPDATE = "com.tencent.od.incupdate";
    public static final String ACTION_INC_UPDATE_PROGRESS = "com.tencent.od.incupdateprogress";
    public static final String ACTION_INC_UPDATE_RESULT = "com.tencent.od.incupdateresult";
    public static final String ACTION_LAUNCH_VAS_PLUGIN = "com.tencent.xplatform.launchdplugin";
    public static final String ACTION_LAUNCH_VAS_PLUGIN_RESULT = "com.tencent.xplatform.launchdplugin.result";
    public static final String ACTION_PLATFORM_STARTED = "com.tencent.xplatform.started";
    public static final String ACTION_PREINSTALL_PLUGIN = "com.tencent.xplatform.preinstall_plugin";
    public static final String ACTION_PREINSTALL_VAS_PLUGIN_RESULT = "com.tencent.xplatform.preinstall.result";
    public static final String ACTION_UNLOAD_PLUGIN = "com.tencent.xplatform.unload.plugin";
    
    public Action() {}
  }
  
  public class ChannelType
  {
    public static final int TYTE_QIQI = 1;
    public static final int TYTE_QQ = 2;
    public static final int TYTE_XAPP = 3;
    
    public ChannelType() {}
  }
  
  public static class CheckFlag
  {
    public static final int CHECK_FAIL = 2;
    public static final int CHECK_SUCCESS = 1;
    public static final int NO_FLAG = 0;
  }
  
  public static class Command
  {
    public static final String IPC_CMD_OPENROOM_RESULT = "cmd_openroom_result";
  }
  
  public static class DownloadEngine
  {
    public static final int DOWNLOAD_ENGINE_DEFAULT = 0;
    public static final int DOWNLOAD_ENGINE_HOST_DEFAULT = 1;
    public static final int DOWNLOAD_ENGINE_HOST_HELLY = 2;
  }
  
  public static class DownloadFlag
  {
    public static final int FIRST_DOWNLOAD = 1;
    public static final int FORCE_DOWNLOAD = 3;
    public static final int NORMAL_DOWNLOAD = 2;
    public static final int NO_FLAG = 0;
    public static final int RETRY_DOWNLOAD = 4;
  }
  
  public static class ErrorCode
  {
    public static final int ERROR_START_FAIL = 1002;
    public static final int ERR_DOWNLOAD_FAIL = 1000;
    public static final int ERR_LOAD_FAIL = 1001;
    public static final int ERR_OPENPARAMS_INVALID = 1;
  }
  
  public static class Flag
  {
    public static final int FLAG_STOP_EXCECUTE_NEXT = 1000;
  }
  
  public class Key
  {
    public static final String ADDR_CITY = "addrCity";
    public static final String ADDR_COUNTRY = "addrCountry";
    public static final String ADDR_PROV = "addrProv";
    public static final String AGE = "age";
    public static final String APP_ID = "appid";
    public static final String AUTH_ID = "authid";
    public static final String AUTH_KEY = "authkey";
    public static final String AUTH_TYPE = "authtype";
    public static final String BIRTH_DAY = "birthday";
    public static final String BIRTH_MONTH = "birthmonth";
    public static final String BIRTH_YEAR = "birthyear";
    public static final String BLOOD_TYPE = "bloodtype";
    public static final String CHANNEL_ID = "sourceChannelId";
    public static final String DOWNLOAD_HOST = "downloadhost";
    public static final String FROM_ID = "fromid";
    public static final String GENDER = "gender";
    public static final String HOMETOWN_CITY = "hometownCity";
    public static final String HOMETOWN_COUNTRY = "hometownCountry";
    public static final String HOMETOWN_PROV = "hometownProv";
    public static final String HOST_ID = "hostid";
    public static final String HOST_TYPE = "hosttype";
    public static final String LOG_HOST = "loghost";
    public static final String NICK_NAME = "nickname";
    public static final String PACKAGE_NAME = "packagename";
    public static final String PLUGINFLAG = "pluginflag";
    public static final String PLUGIN_ID = "pluginid";
    public static final String PROGRESS = "progress";
    public static final String PROXY_VERSION = "proxy_version";
    public static final String REPORT_HOST = "reporthost";
    public static final String RESULT_CODE = "resultCode";
    public static final String RESULT_DESC = "resultDesc";
    public static final String ROOM_ID = "roomid";
    public static final String ROOM_NAME = "roomname";
    public static final String SOURCE_ID = "sourceID";
    public static final String SOURCE_VERSION = "sourceVersion";
    public static final String UPDATEXPLATFORM = "update_xplatform";
    public static final String USER_DATA = "userdata";
    public static final String VAS_NAME = "vasname";
    public static final String VAS_SCHEMA = "vasschema";
    public static final String VAS_TYPE = "vastype";
    
    public Key() {}
  }
  
  public static class PluginStatus
  {
    public static final int DOWNLOADED = 2;
    public static final int DOWNLOADING = 1;
    public static final int IDLE = 0;
    public static final int LOADED = 6;
    public static final int LOADING = 5;
    public static final int PREINSTALED = 4;
    public static final int PREINSTALLING = 3;
    public static final int STARTED = 8;
    public static final int STARTING = 7;
  }
  
  public class VasType
  {
    public static final int VAS_HYLIVE = 3;
    public static final int VAS_NOW = 4;
    public static final int VAS_OD = 2;
    
    public VasType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.txproxy.Constants
 * JD-Core Version:    0.7.0.1
 */