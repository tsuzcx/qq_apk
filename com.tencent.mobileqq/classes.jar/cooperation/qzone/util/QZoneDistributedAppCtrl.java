package cooperation.qzone.util;

import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyService;
import cooperation.qzone.ServerListProvider;
import java.util.Map;
import mqq.app.AppRuntime;

public class QZoneDistributedAppCtrl
  implements Handler.Callback
{
  public static final int CMD_CLEAR_AD_FEEDS = 1;
  public static final int CMD_CLEAR_ALL_FEEDS = 2;
  public static final int CMD_CLEAR_CACHE = 3;
  public static final int CMD_CLEAR_TOKEN = 4;
  public static final int CMD_COMBQZ_PROTECT = 11;
  public static final int CMD_ENABLE_DEBUG = 12;
  public static final int CMD_ENABLE_PERFORMANCE_MONITOR = 13;
  public static final int CMD_PRINT_DIR_FILE_LIST = 16;
  public static final int CMD_PRINT_WNS_CONFIG = 15;
  public static final int CMD_REACT_DEVELOP_BUNDLE = 17;
  public static final int CMD_RESTART = 5;
  public static final int CMD_UPLOAD_ANR = 8;
  public static final int CMD_UPLOAD_AVSDK = 18;
  public static final int CMD_UPLOAD_CUSTOM = 14;
  public static final int CMD_UPLOAD_DB = 7;
  public static final int CMD_UPLOAD_LOGCAT = 10;
  public static final int CMD_UPLOAD_TRACE = 9;
  private static final long HalfHourMills = 1800000L;
  public static final String KEY_AVSDK_ENDTIME = "key_avsdk_endTime";
  public static final String KEY_AVSDK_STARTTIME = "key_avsdk_startTime";
  public static final String KEY_CTRL_PARAM_ENABLE = "key_ctrl_param_enable";
  public static final String KEY_PATH_DATA = "key_path_data";
  public static final String KEY_PATH_TENCENT = "key_path_tencent";
  public static final String KEY_QZAPP_VERSION_CODE = "key_qzapp_versioncode";
  public static final String KEY_QZCOMBO_PROTECT_SWITCH = "key_qzcombo_protect";
  public static final String KEY_QZH5_URL = "key_qzh5_url";
  public static final String KEY_REACT_DEVEL_BUNDLE_ON = "key_rndev_bundle_on";
  public static final String KEY_REACT_DEVEL_BUNDLE_URL = "key_rndev_bundle_url";
  public static final String KEY_TRACE_STARTTIME = "key_trace_baseTime";
  public static final String KEY_TRACE_TIMEOFFSET = "key_trace_offset";
  public static final String KEY_UPLOAD_DBNAME = "key_upload_dbname";
  public static final String KEY_UPLOAD_FILE_MAXSIZE = "key_upload_maxsize";
  public static final String KEY_URL = "key_url";
  public static final String KEY_WNS_CONFIG_MAIN = "key_wns_config_main";
  public static final String KEY_WNS_CONFIG_SECOND = "key_wns_config_second";
  static final int MSG_BASE = 0;
  static final int MSG_CMD = 2;
  static final int MSG_EXEC = 1;
  private static final String TAG = "QZoneDistributedAppCtrl";
  private static QZoneDistributedAppCtrl instance;
  private static Object lock = new Object();
  public static String mUin;
  
  QZoneDistributedAppCtrl(String paramString)
  {
    mUin = paramString;
  }
  
  private void execCmd(QZoneDistributedAppCtrl.Control paramControl)
  {
    int i = paramControl.cmd;
    if ((i != 5) && (QLog.isDevelopLevel()))
    {
      paramControl = new StringBuilder();
      paramControl.append("unknown ctrl cmd ");
      paramControl.append(i);
      QLog.e("QZoneDistributedAppCtrl", 4, paramControl.toString());
    }
  }
  
  private void execCtrl(QZoneDistributedAppCtrl.Control paramControl)
  {
    int i = paramControl.cmd;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("execCtrl cmd:");
      ((StringBuilder)localObject1).append(i);
      QLog.i("QZoneDistributedAppCtrl", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = "";
    boolean bool1 = false;
    long l3;
    long l2;
    long l1;
    switch (i)
    {
    case 6: 
    default: 
      if (!QLog.isDevelopLevel()) {
        break label1315;
      }
      paramControl = new StringBuilder();
      paramControl.append("unknown ctrl cmd ");
      paramControl.append(i);
      QLog.w("QZoneDistributedAppCtrl", 4, paramControl.toString());
      return;
    case 18: 
      localObject1 = (String)paramControl.data.get("key_avsdk_startTime");
      paramControl = (String)paramControl.data.get("key_avsdk_endTime");
      l3 = QZoneAppCtrlUploadFileLogic.getAvsdkTimeFromServer((String)localObject1);
      l2 = QZoneAppCtrlUploadFileLogic.getAvsdkTimeFromServer(paramControl);
      if (l3 == -1L) {
        return;
      }
      l1 = l2;
      if (l2 == -1L) {
        l1 = System.currentTimeMillis();
      }
      l2 = l1;
      if (l3 > l1) {
        l2 = System.currentTimeMillis();
      }
      QZoneAppCtrlUploadFileLogic.uploadAvsdk(BaseApplicationImpl.getContext(), mUin, l3, l2);
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("avsdk log push, starttime=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",endTime=");
        ((StringBuilder)localObject2).append(paramControl);
        QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, ((StringBuilder)localObject2).toString());
      }
      break;
    case 17: 
      handleReactDev(paramControl.data);
      break;
    case 16: 
      paramControl = (String)paramControl.data.get("key_url");
      QZoneAppCtrlUploadFileLogic.showDirFileList(BaseApplicationImpl.getContext(), paramControl);
      break;
    case 15: 
      localObject1 = (String)paramControl.data.get("key_wns_config_main");
      paramControl = (String)paramControl.data.get("key_wns_config_second");
      QzoneConfig.getInstance().printWNSConfig((String)localObject1, paramControl);
      break;
    case 14: 
      localObject1 = (String)paramControl.data.get("key_path_tencent");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = (String)paramControl.data.get("key_path_data");
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      paramControl = (String)paramControl.data.get("key_upload_maxsize");
      for (;;)
      {
        try
        {
          l1 = Long.valueOf(paramControl).longValue();
        }
        catch (Exception localException)
        {
          int j;
          boolean bool2;
          continue;
        }
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("CMD_UPLOAD_CUSTOM, param：");
          ((StringBuilder)localObject2).append(paramControl);
          ((StringBuilder)localObject2).append(",error:Not long");
          QLog.w("QZoneDistributedAppCtrl", 4, ((StringBuilder)localObject2).toString());
        }
        l1 = 1048576L;
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("CMD_UPLOAD_CUSTOM, param：");
        if (bool1) {
          paramControl = "dataPath";
        } else {
          paramControl = "tencentPath";
        }
        ((StringBuilder)localObject2).append(paramControl);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.w("QZoneDistributedAppCtrl", 4, ((StringBuilder)localObject2).toString());
      }
      QZoneAppCtrlUploadFileLogic.uploadByCustom(BaseApplicationImpl.getContext(), (String)localObject1, mUin, l1, bool1);
      break;
    case 13: 
      paramControl = (String)paramControl.data.get("key_ctrl_param_enable");
      if (!TextUtils.isEmpty(paramControl)) {
        if (Boolean.valueOf(paramControl).booleanValue())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          ((StringBuilder)localObject1).append("");
          LocalMultiProcConfig.putString("LooperMonitor", ((StringBuilder)localObject1).toString());
        }
        else
        {
          LocalMultiProcConfig.putString("LooperMonitor", "-1");
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CMD_ENABLE_PERFORMANCE_MONITOR, param：");
        ((StringBuilder)localObject1).append(paramControl);
        QLog.w("QZoneDistributedAppCtrl", 4, ((StringBuilder)localObject1).toString());
      }
      break;
    case 12: 
      paramControl = (String)paramControl.data.get("key_ctrl_param_enable");
      if (!TextUtils.isEmpty(paramControl)) {
        ServerListProvider.enableDebug(Boolean.valueOf(paramControl).booleanValue());
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CMD_ENABLE_DEBUG, param：");
        ((StringBuilder)localObject1).append(paramControl);
        QLog.w("QZoneDistributedAppCtrl", 4, ((StringBuilder)localObject1).toString());
      }
      break;
    case 11: 
      j = 82;
      i = j;
      try
      {
        bool2 = Boolean.parseBoolean((String)paramControl.data.get("key_qzcombo_protect"));
        i = j;
        bool1 = bool2;
        j = Integer.parseInt((String)paramControl.data.get("key_qzapp_versioncode"));
        i = j;
        bool1 = bool2;
        paramControl = (String)paramControl.data.get("key_qzh5_url");
        i = j;
        bool1 = bool2;
      }
      catch (Throwable paramControl)
      {
        QLog.e("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 1, "error: execute CMD_COMBQZ_PROTECT", paramControl);
        paramControl = (QZoneDistributedAppCtrl.Control)localObject1;
      }
      onHandleComboQzProtect(bool1, i, paramControl);
      return;
    case 10: 
      QZoneAppCtrlUploadFileLogic.saveLogcatToFileV2(BaseApplicationImpl.getContext(), mUin);
      return;
    case 9: 
      localObject1 = (String)paramControl.data.get("key_trace_baseTime");
      paramControl = (String)paramControl.data.get("key_trace_offset");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        l1 = System.currentTimeMillis();
      } else {
        try
        {
          l1 = Long.valueOf((String)localObject1).longValue();
          l1 *= 1000L;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
          l1 = 0L;
        }
      }
      if (TextUtils.isEmpty(paramControl)) {
        l2 = 1800000L;
      } else {
        try
        {
          l2 = Long.valueOf(paramControl).longValue();
          l2 *= 1000L;
        }
        catch (NumberFormatException paramControl)
        {
          paramControl.printStackTrace();
          l2 = 0L;
        }
      }
      l3 = l1;
      if (l1 <= 0L) {
        l3 = System.currentTimeMillis();
      }
      l1 = l2;
      if (l2 <= 0L) {
        l1 = 1800000L;
      }
      l2 = l3 - l1;
      if (QLog.isDevelopLevel())
      {
        paramControl = new StringBuilder();
        paramControl.append("trace startTime: ");
        paramControl.append(l2);
        paramControl.append("ms\t offsettime: ");
        paramControl.append(l1);
        paramControl.append("\t trace endTime: ");
        paramControl.append(l3);
        paramControl.append("ms");
        QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, paramControl.toString());
      }
      QZoneAppCtrlUploadFileLogic.uploadTrace(BaseApplicationImpl.getContext(), mUin, l2, l3);
      return;
    case 8: 
      QZoneAppCtrlUploadFileLogic.uploadANR(BaseApplicationImpl.getContext(), mUin);
      return;
    case 7: 
      paramControl = (String)paramControl.data.get("key_upload_dbname");
      QZoneAppCtrlUploadFileLogic.uploadDB(BaseApplicationImpl.getContext(), mUin, paramControl);
      return;
    case 5: 
      killQZoneProcess();
      if (!(localObject2 instanceof QQAppInterface)) {
        break label1315;
      }
      QZoneHelper.preloadQzone((QQAppInterface)localObject2, "QZoneDistributedAppCtrl");
      return;
    case 4: 
      return;
    case 3: 
      if (!(localObject2 instanceof QQAppInterface)) {
        break label1315;
      }
      QZoneHelper.clearCache((AppRuntime)localObject2, true);
      return;
    case 2: 
      QZoneHelper.clearFeedsCache(BaseApplicationImpl.getContext(), mUin);
      return;
    }
    killQZoneProcess();
    label1315:
  }
  
  public static QZoneDistributedAppCtrl getInstance(String paramString)
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new QZoneDistributedAppCtrl(paramString);
        }
      }
    }
    return instance;
  }
  
  public static void handleReactDev(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("key_rndev_bundle_url");
    paramMap = (String)paramMap.get("key_rndev_bundle_on");
    LocalMultiProcConfig.putString("Qzone.React.DevBundleUrl", str);
    LocalMultiProcConfig.putString("Qzone.React.DevBundleOn", paramMap);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rnbundleurl=");
    localStringBuilder.append(str);
    localStringBuilder.append(",rndevon=");
    localStringBuilder.append(paramMap);
    QLog.i("QZoneDistributedAppCtrl", 1, localStringBuilder.toString());
  }
  
  public static void killQZoneProcess()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
    BaseApplicationImpl.getContext().stopService(localIntent);
    Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
  }
  
  private void onHandleComboQzProtect(boolean paramBoolean, int paramInt, String paramString)
  {
    LocalMultiProcConfig.putBool("comboqz_protect_enable", paramBoolean);
    LocalMultiProcConfig.putInt("qzapp_vercode", paramInt);
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString)) {
        LocalMultiProcConfig.putString("qzh5_url", paramString);
      }
      LocalMultiProcConfig.putBool("qz_safe_mode_no_tip", false);
      LocalMultiProcConfig.putString("comboqz_qua", QUA.getQUA3());
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recv msg ");
      localStringBuilder.append(paramMessage);
      QLog.d("QZoneDistributedAppCtrl", 4, localStringBuilder.toString());
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      execCmd((QZoneDistributedAppCtrl.Control)paramMessage.obj);
      return true;
    }
    execCtrl((QZoneDistributedAppCtrl.Control)paramMessage.obj);
    return true;
  }
  
  public void submitCtrl(QZoneDistributedAppCtrl.Control paramControl)
  {
    if (paramControl != null) {
      ThreadManager.executeOnNetWorkThread(new QZoneDistributedAppCtrl.1(this, paramControl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.util.QZoneDistributedAppCtrl
 * JD-Core Version:    0.7.0.1
 */