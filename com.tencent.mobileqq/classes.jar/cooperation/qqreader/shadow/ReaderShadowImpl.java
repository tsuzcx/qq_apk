package cooperation.qqreader.shadow;

import android.content.Context;
import android.os.Bundle;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.CdnPmUpdater;
import com.tencent.mobileqq.intervideo.DataLocalTmpPmUpdater;
import com.tencent.mobileqq.intervideo.IVLoggerFactory;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import cooperation.qqreader.utils.Log;
import cooperation.qqreader.utils.ReportUtils;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ReaderShadowImpl
  implements IShadow
{
  private static ReaderShadowImpl jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl;
  private PluginManager jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  private ReaderShadowImpl()
  {
    setILoggerFactory();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = ThreadManagerExecutor.getSingleThreadExecutorService(192);
  }
  
  private PluginManager a(Context paramContext, String paramString)
  {
    new DataLocalTmpPmUpdater("Reader");
    CdnPmUpdater localCdnPmUpdater = new CdnPmUpdater(paramContext, "Reader", paramString, "5");
    boolean bool;
    if ((localCdnPmUpdater.wasUpdating()) || (localCdnPmUpdater.getLatest() == null))
    {
      bool = true;
      Log.d("ReaderShadowImpl", "needWaitingUpdate:" + bool);
      paramString = localCdnPmUpdater.update();
      if (!bool) {
        break label209;
      }
    }
    for (;;)
    {
      try
      {
        paramString = (File)paramString.get();
        if ((paramString == null) || (ReaderPmFileVerifyHelper.a(paramContext, paramString))) {
          break label220;
        }
        bool = paramString.delete();
        Log.a("ReaderShadowImpl", "[loadPluginManager] pm apk is invalid and delete result=" + bool);
        paramContext = null;
        if (paramContext == null) {
          break label218;
        }
        return new DynamicPluginManager(new ReaderStablePmUpdater(localCdnPmUpdater, paramContext));
        bool = false;
      }
      catch (ExecutionException paramString)
      {
        Log.a("ReaderShadowImpl", "[loadPluginManager] ExecutionException:", paramString);
        ReportUtils.a(paramContext, -101, "cdn update ExecutionException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (InterruptedException paramString)
      {
        Log.a("ReaderShadowImpl", "[loadPluginManager] InterruptedException:", paramString);
        ReportUtils.a(paramContext, -102, "cdn update InterruptedException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      label209:
      paramString = localCdnPmUpdater.getLatest();
      continue;
      label218:
      return null;
      label220:
      paramContext = paramString;
    }
  }
  
  public static ReaderShadowImpl a()
  {
    if (jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl == null) {
        jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl = new ReaderShadowImpl();
      }
      return jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl;
    }
    finally {}
  }
  
  public void enter(Context paramContext, long paramLong, String paramString1, String paramString2, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ReaderShadowImpl.1(this, paramContext, paramString1, paramString2, paramLong, paramBundle, paramEnterCallback));
  }
  
  public PluginManager getPluginManager(Context paramContext, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager == null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager = a(paramContext, paramString1);
    }
    return this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  }
  
  public boolean hasPluginManager()
  {
    return this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager != null;
  }
  
  public void setILoggerFactory()
  {
    if (LoggerFactory.getILoggerFactory() == null) {
      LoggerFactory.setILoggerFactory(IVLoggerFactory.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.shadow.ReaderShadowImpl
 * JD-Core Version:    0.7.0.1
 */