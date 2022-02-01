package cooperation.qzone.remote;

public abstract interface ServiceConst
{
  public static final String CMD_REGISTER_LISTENER = "cmd.registerListener";
  public static final String CMD_UNREGISTER_LISTENER = "cmd.unregisterListener";
  public static final int CODE_EXCEPITON = 1005;
  public static final int CODE_FAIL = 1001;
  public static final int CODE_LOAD_SERVICE_FAIL = 1004;
  public static final int CODE_NO_SERVICE_FOUND = 1003;
  public static final int CODE_OK = 1000;
  public static final int CODE_TIMEOUT = 1002;
  public static final String EXTRA_ERROR = "error";
  public static final String EXTRA_NEEDCALLBACK = "needCallback";
  public static final String EXTRA_SYNC = "sync";
  public static final String EXTRA_WUP = "wup";
  public static final String INTENT_PICTURE_SERVICE = "com.qzone.preview.service.PictureService";
  public static final String INTENT_START_PROCESS_SERVICE = "com.qzone.preview.service.PictureProcessBootService";
  public static final String INTENT_WEBPLUGIN_SERVICE = "com.qzone.common.webplugin.WebPluginHandleService";
  public static final String INTENT_WECHAT_SYNC_SERVICE = "com.qzone.publish.wcsync.WechatSyncService";
  public static final String PARA_SESSION_ID = "session_id";
  public static final String SERVICE_META_NAME = "tencent.preview.service";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.remote.ServiceConst
 * JD-Core Version:    0.7.0.1
 */