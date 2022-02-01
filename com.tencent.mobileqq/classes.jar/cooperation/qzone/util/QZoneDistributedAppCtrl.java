package cooperation.qzone.util;

import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vashealth.SportManager;
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
  public static final String KEY_CTRL_CMD = "key_ctrl_cmd";
  public static final String KEY_CTRL_PARAM_ENABLE = "key_ctrl_param_enable";
  public static final String KEY_DESC = "key_desc";
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
    switch (i)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.e("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i);
      }
      break;
    }
  }
  
  private void execCtrl(QZoneDistributedAppCtrl.Control paramControl)
  {
    boolean bool2 = false;
    int i = paramControl.cmd;
    if (QLog.isColorLevel()) {
      QLog.i("QZoneDistributedAppCtrl", 2, "execCtrl cmd:" + i);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    long l1;
    long l2;
    switch (i)
    {
    case 6: 
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.w("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i);
      }
    case 4: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
      do
      {
        do
        {
          return;
          killQZoneProcess();
          return;
          QZoneHelper.clearFeedsCache(BaseApplicationImpl.getContext(), mUin);
          return;
        } while (!(localObject instanceof QQAppInterface));
        QZoneHelper.clearCache((AppRuntime)localObject, true);
        return;
        killQZoneProcess();
      } while (!(localObject instanceof QQAppInterface));
      QZoneHelper.preloadQzone((QQAppInterface)localObject, "QZoneDistributedAppCtrl");
      return;
    case 7: 
      paramControl = (String)paramControl.data.get("key_upload_dbname");
      QZoneAppCtrlUploadFileLogic.uploadDB(BaseApplicationImpl.getContext(), mUin, paramControl);
      return;
    case 8: 
      QZoneAppCtrlUploadFileLogic.uploadANR(BaseApplicationImpl.getContext(), mUin);
      return;
    case 9: 
      localObject = (String)paramControl.data.get("key_trace_baseTime");
      paramControl = (String)paramControl.data.get("key_trace_offset");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        l1 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramControl)) {
          break label454;
        }
        l2 = 1800000L;
        label311:
        if (l1 > 0L) {
          break label1183;
        }
        l1 = System.currentTimeMillis();
      }
      break;
    }
    label454:
    boolean bool1;
    label1183:
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          l3 = l2;
          if (l2 <= 0L) {
            l3 = 1800000L;
          }
          l2 = l1 - l3;
          if (QLog.isDevelopLevel()) {
            QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "trace startTime: " + l2 + "ms\t offsettime: " + l3 + "\t trace endTime: " + l1 + "ms");
          }
          QZoneAppCtrlUploadFileLogic.uploadTrace(BaseApplicationImpl.getContext(), mUin, l2, l1);
          return;
          try
          {
            l1 = Long.valueOf((String)localObject).longValue();
            l1 *= 1000L;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
            l1 = 0L;
          }
        }
        break;
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
      break label311;
      String str = (String)paramControl.data.get("key_avsdk_startTime");
      paramControl = (String)paramControl.data.get("key_avsdk_endTime");
      long l3 = QZoneAppCtrlUploadFileLogic.getAvsdkTimeFromServer(str);
      l2 = QZoneAppCtrlUploadFileLogic.getAvsdkTimeFromServer(paramControl);
      if (l3 == -1L) {
        break;
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
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "avsdk log push, starttime=" + str + ",endTime=" + paramControl);
      return;
      QZoneAppCtrlUploadFileLogic.saveLogcatToFileV2(BaseApplicationImpl.getContext(), mUin);
      return;
      try
      {
        bool1 = Boolean.parseBoolean((String)paramControl.data.get("key_qzcombo_protect"));
        paramControl = (String)paramControl.data.get("key_ctrl_param_enable");
      }
      catch (Throwable paramControl)
      {
        for (;;)
        {
          try
          {
            i = Integer.parseInt((String)paramControl.data.get("key_qzapp_versioncode"));
          }
          catch (Throwable paramControl)
          {
            i = 82;
            continue;
          }
          try
          {
            paramControl = (String)paramControl.data.get("key_qzh5_url");
            onHandleComboQzProtect(bool1, i, paramControl);
            return;
          }
          catch (Throwable paramControl)
          {
            continue;
            bool1 = false;
            continue;
          }
          paramControl = paramControl;
          i = 82;
          bool1 = bool2;
          QLog.e("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 1, "error: execute CMD_COMBQZ_PROTECT", paramControl);
          paramControl = "";
        }
      }
      if (!TextUtils.isEmpty(paramControl)) {
        ServerListProvider.enableDebug(Boolean.valueOf(paramControl).booleanValue());
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_DEBUG, param：" + paramControl);
      return;
      paramControl = (String)paramControl.data.get("key_ctrl_param_enable");
      if (!TextUtils.isEmpty(paramControl))
      {
        if (!Boolean.valueOf(paramControl).booleanValue()) {
          break label881;
        }
        LocalMultiProcConfig.putString("LooperMonitor", System.currentTimeMillis() + "");
      }
      while (QLog.isDevelopLevel())
      {
        QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_PERFORMANCE_MONITOR, param：" + paramControl);
        return;
        label881:
        LocalMultiProcConfig.putString("LooperMonitor", "-1");
      }
      str = (String)paramControl.data.get("key_path_tencent");
      if (TextUtils.isEmpty(str))
      {
        str = (String)paramControl.data.get("key_path_data");
        bool1 = true;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramControl = (String)paramControl.data.get("key_upload_maxsize");
        try
        {
          l1 = Long.valueOf(paramControl).longValue();
          if (QLog.isDevelopLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("CMD_UPLOAD_CUSTOM, param：");
            if (bool1)
            {
              paramControl = "dataPath";
              QLog.w("QZoneDistributedAppCtrl", 4, paramControl + "," + str);
            }
          }
          else
          {
            QZoneAppCtrlUploadFileLogic.uploadByCustom(BaseApplicationImpl.getContext(), str, mUin, l1, bool1);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.w("QZoneDistributedAppCtrl", 4, "CMD_UPLOAD_CUSTOM, param：" + paramControl + ",error:Not long");
            }
            l1 = 1048576L;
            continue;
            paramControl = "tencentPath";
          }
        }
        str = (String)paramControl.data.get("key_wns_config_main");
        paramControl = (String)paramControl.data.get("key_wns_config_second");
        QzoneConfig.getInstance().printWNSConfig(str, paramControl);
        SportManager.d();
        return;
        paramControl = (String)paramControl.data.get("key_url");
        QZoneAppCtrlUploadFileLogic.showDirFileList(BaseApplicationImpl.getContext(), paramControl);
        return;
        handleReactDev(paramControl.data);
        return;
      }
    }
  }
  
  public static QZoneDistributedAppCtrl getInstance(String paramString)
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new QZoneDistributedAppCtrl(paramString);
      }
      return instance;
    }
  }
  
  public static void handleReactDev(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("key_rndev_bundle_url");
    paramMap = (String)paramMap.get("key_rndev_bundle_on");
    LocalMultiProcConfig.putString("Qzone.React.DevBundleUrl", str);
    LocalMultiProcConfig.putString("Qzone.React.DevBundleOn", paramMap);
    QLog.i("QZoneDistributedAppCtrl", 1, "rnbundleurl=" + str + ",rndevon=" + paramMap);
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
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneDistributedAppCtrl", 4, "recv msg " + paramMessage);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      execCtrl((QZoneDistributedAppCtrl.Control)paramMessage.obj);
    }
    for (;;)
    {
      return true;
      execCmd((QZoneDistributedAppCtrl.Control)paramMessage.obj);
    }
  }
  
  public void submitCtrl(QZoneDistributedAppCtrl.Control paramControl)
  {
    if (paramControl != null) {
      ThreadManager.executeOnNetWorkThread(new QZoneDistributedAppCtrl.1(this, paramControl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.QZoneDistributedAppCtrl
 * JD-Core Version:    0.7.0.1
 */