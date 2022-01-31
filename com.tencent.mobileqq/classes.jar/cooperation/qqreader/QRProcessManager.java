package cooperation.qqreader;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SecMsgUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloadReportUtils.HitRateHelper;
import cooperation.comic.PluginPreloadStrategy;
import cooperation.comic.PluginPreloadStrategy.PreloadPublicParam;
import cooperation.comic.PluginPreloadStrategy.PreloadServerParam;
import cooperation.comic.PluginPreloader;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.util.Calendar;
import mqq.manager.Manager;

public class QRProcessManager
  implements Manager
{
  public long a;
  protected QQAppInterface a;
  public PluginPreloadStrategy.PreloadPublicParam a;
  public PluginPreloadStrategy.PreloadServerParam a;
  public QRProcessManager.QQReaderPreloadCommonStrategy a;
  public QRProcessManager.QQReaderPreloadLebaStrategy a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public QRProcessManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = (DeviceInfoUtil.e() / 1048576L);
    c();
  }
  
  private void a(PluginPreloadReportUtils.HitRateHelper paramHitRateHelper, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRProcessManager", 2, "run startQQReaderProcess");
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), VipProxyRreLoadReaderProcess.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("isPreloadProcess", true);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "qqreaderplugin.apk";
    localPluginParams.d = "qqreader";
    localPluginParams.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localPluginParams.e = "com.qqreader.ReaderPreloadReaderProcess";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (paramHitRateHelper != null)
    {
      localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = paramHitRateHelper.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession;
      paramHitRateHelper.a(2, paramString, paramInt);
    }
    IPluginManager.a(BaseApplicationImpl.getContext(), localPluginParams);
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      c();
      if (QLog.isColorLevel()) {
        QLog.d("QRProcessManager", 2, "pluginType:1  preload:fail:dpc");
      }
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  private void c()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|24");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 1) {
        this.jdField_a_of_type_Boolean = "1".equals(localObject[0]);
      }
    }
  }
  
  private void d()
  {
    try
    {
      if (this.b) {
        return;
      }
      this.jdField_a_of_type_CooperationComicPluginPreloadStrategy$PreloadServerParam = new PluginPreloadStrategy.PreloadServerParam(769, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (this.jdField_a_of_type_CooperationComicPluginPreloadStrategy$PreloadServerParam.jdField_a_of_type_Int != -1) {
        this.b = true;
      }
      this.c = this.jdField_a_of_type_CooperationComicPluginPreloadStrategy$PreloadServerParam.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_CooperationComicPluginPreloadStrategy$PreloadPublicParam = PluginPreloadStrategy.PreloadPublicParam.a(this.jdField_a_of_type_CooperationComicPluginPreloadStrategy$PreloadServerParam.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_CooperationComicPluginPreloadStrategy$PreloadPublicParam == null) {
        this.jdField_a_of_type_CooperationComicPluginPreloadStrategy$PreloadPublicParam = new PluginPreloadStrategy.PreloadPublicParam();
      }
      return;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", SecMsgUtil.a()).getInt("usedTimes" + paramString, 0);
  }
  
  public long a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", SecMsgUtil.a()).getLong(paramString, -1L);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRProcessManager", 2, "firstTimeLoadApk");
    }
    a(null, "", 0);
  }
  
  public void a(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localObject != null) {
        PluginPreloader.a((PluginPreloadStrategy)localObject, 500L);
      }
      return;
      if (this.jdField_a_of_type_CooperationQqreaderQRProcessManager$QQReaderPreloadLebaStrategy == null) {
        this.jdField_a_of_type_CooperationQqreaderQRProcessManager$QQReaderPreloadLebaStrategy = new QRProcessManager.QQReaderPreloadLebaStrategy(this, 6);
      }
      localObject = this.jdField_a_of_type_CooperationQqreaderQRProcessManager$QQReaderPreloadLebaStrategy;
      continue;
      if (this.jdField_a_of_type_CooperationQqreaderQRProcessManager$QQReaderPreloadCommonStrategy == null) {
        this.jdField_a_of_type_CooperationQqreaderQRProcessManager$QQReaderPreloadCommonStrategy = new QRProcessManager.QQReaderPreloadCommonStrategy(this, 9999, "qqreader_qqbrowser_preload");
      }
      localObject = this.jdField_a_of_type_CooperationQqreaderQRProcessManager$QQReaderPreloadCommonStrategy;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", SecMsgUtil.a()).edit().putLong(paramString, paramLong).commit();
  }
  
  public int[] a(String paramString)
  {
    int[] arrayOfInt = new int[24];
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", SecMsgUtil.a());
    int i = 0;
    while (i < 24)
    {
      arrayOfInt[i] = localSharedPreferences.getInt("usedTimesInHour" + i + ":" + paramString, 0);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public void b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", SecMsgUtil.a());
    int i = a(str);
    localSharedPreferences.edit().putInt("usedTimes" + str, i + 1).commit();
    i = Calendar.getInstance().get(11);
    int j = localSharedPreferences.getInt("usedTimesInHour" + i + ":" + str, 0);
    localSharedPreferences.edit().putInt("usedTimesInHour" + i + ":" + str, j + 1).commit();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqreader.QRProcessManager
 * JD-Core Version:    0.7.0.1
 */