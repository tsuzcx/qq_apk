package cooperation.qzone.util;

import amks;
import amkt;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
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
  private static QZoneDistributedAppCtrl jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static String a;
  
  QZoneDistributedAppCtrl(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static QZoneDistributedAppCtrl a(String paramString)
  {
    if (jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl == null) {
        jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl = new QZoneDistributedAppCtrl(paramString);
      }
      return jdField_a_of_type_CooperationQzoneUtilQZoneDistributedAppCtrl;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    new Handler(Looper.getMainLooper()).post(new amkt(paramString2, paramString1));
  }
  
  public static void a(Map paramMap)
  {
    String str = (String)paramMap.get("key_rndev_bundle_url");
    paramMap = (String)paramMap.get("key_rndev_bundle_on");
    LocalMultiProcConfig.putString("Qzone.React.DevBundleUrl", str);
    LocalMultiProcConfig.putString("Qzone.React.DevBundleOn", paramMap);
    QLog.i("QZoneDistributedAppCtrl", 1, "rnbundleurl=" + str + ",rndevon=" + paramMap);
    if ("on".equals(paramMap)) {
      a("进入React开发模式", "成功！！！");
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString)
  {
    LocalMultiProcConfig.putBool("comboqz_protect_enable", paramBoolean);
    LocalMultiProcConfig.putInt("qzapp_vercode", paramInt);
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString)) {
        LocalMultiProcConfig.putString("qzh5_url", paramString);
      }
      LocalMultiProcConfig.putBool("qz_safe_mode_no_tip", false);
      LocalMultiProcConfig.putString("comboqz_qua", QUA.a());
    }
  }
  
  private void b(QZoneDistributedAppCtrl.Control paramControl)
  {
    boolean bool2 = false;
    int i = paramControl.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.i("QZoneDistributedAppCtrl", 2, "execCtrl cmd:" + i);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    long l1;
    long l2;
    switch (i)
    {
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
          a();
          return;
          QZoneHelper.a(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
          return;
        } while (!(localObject instanceof QQAppInterface));
        QZoneHelper.a((AppRuntime)localObject, true);
        return;
        a();
      } while (!(localObject instanceof QQAppInterface));
      QZoneHelper.a((QQAppInterface)localObject, "QZoneDistributedAppCtrl");
      return;
    case 6: 
      a("点击上报成功", (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_url"));
      return;
    case 7: 
      paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_upload_dbname");
      QZoneAppCtrlUploadFileLogic.a(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, paramControl);
      return;
    case 8: 
      QZoneAppCtrlUploadFileLogic.a(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
      return;
    case 9: 
      localObject = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_trace_baseTime");
      paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_trace_offset");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        l1 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramControl)) {
          break label473;
        }
        l2 = 1800000L;
        label333:
        if (l1 > 0L) {
          break label1211;
        }
        l1 = System.currentTimeMillis();
      }
      break;
    }
    label473:
    boolean bool1;
    label907:
    label1211:
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
          QZoneAppCtrlUploadFileLogic.a(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, l2, l1);
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
      break label333;
      String str = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_avsdk_startTime");
      paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_avsdk_endTime");
      long l3 = QZoneAppCtrlUploadFileLogic.a(str);
      l2 = QZoneAppCtrlUploadFileLogic.a(paramControl);
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
      QZoneAppCtrlUploadFileLogic.b(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, l3, l2);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "avsdk log push, starttime=" + str + ",endTime=" + paramControl);
      return;
      QZoneAppCtrlUploadFileLogic.c(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
      return;
      try
      {
        bool1 = Boolean.parseBoolean((String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_qzcombo_protect"));
        paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_ctrl_param_enable");
      }
      catch (Throwable paramControl)
      {
        for (;;)
        {
          try
          {
            i = Integer.parseInt((String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_qzapp_versioncode"));
          }
          catch (Throwable paramControl)
          {
            i = 82;
            continue;
          }
          try
          {
            paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_qzh5_url");
            a(bool1, i, paramControl);
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
      paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_ctrl_param_enable");
      if (!TextUtils.isEmpty(paramControl))
      {
        if (!Boolean.valueOf(paramControl).booleanValue()) {
          break label907;
        }
        LocalMultiProcConfig.putString("LooperMonitor", System.currentTimeMillis() + "");
      }
      while (QLog.isDevelopLevel())
      {
        QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_PERFORMANCE_MONITOR, param：" + paramControl);
        return;
        LocalMultiProcConfig.putString("LooperMonitor", "-1");
      }
      str = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_path_tencent");
      if (TextUtils.isEmpty(str))
      {
        str = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_path_data");
        bool1 = true;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_upload_maxsize");
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
            QZoneAppCtrlUploadFileLogic.a(BaseApplicationImpl.getContext(), str, jdField_a_of_type_JavaLangString, l1, bool1);
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
        str = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_wns_config_main");
        paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_wns_config_second");
        QzoneConfig.getInstance().printWNSConfig(str, paramControl);
        return;
        paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_url");
        QZoneAppCtrlUploadFileLogic.b(BaseApplicationImpl.getContext(), paramControl);
        return;
        a(paramControl.jdField_a_of_type_JavaUtilMap);
        return;
      }
    }
  }
  
  private void c(QZoneDistributedAppCtrl.Control paramControl)
  {
    int i = paramControl.jdField_a_of_type_Int;
    switch (i)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.e("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i);
      }
    case 5: 
      return;
    }
    paramControl = (String)paramControl.jdField_a_of_type_JavaUtilMap.get("key_url");
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QQBrowserDelegationActivity.class);
    localIntent.setFlags(localIntent.getFlags() | 0x10000000);
    localIntent.putExtra("post_data", "");
    localIntent.putExtra("url", paramControl);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.setData(Uri.parse(paramControl));
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public void a()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
    BaseApplicationImpl.getContext().stopService(localIntent);
    Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
  }
  
  public void a(QZoneDistributedAppCtrl.Control paramControl)
  {
    if (paramControl != null) {
      ThreadManager.executeOnNetWorkThread(new amks(this, paramControl));
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
      b((QZoneDistributedAppCtrl.Control)paramMessage.obj);
    }
    for (;;)
    {
      return true;
      c((QZoneDistributedAppCtrl.Control)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.QZoneDistributedAppCtrl
 * JD-Core Version:    0.7.0.1
 */