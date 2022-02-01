package cooperation.comic;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.PreloadSuccessRateReporter;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;

public class QQComicPreloadStrategy
  extends PluginPreloadStrategy
{
  public final PluginPreloadReportUtils.HitRateHelper a;
  private boolean c;
  private String d;
  private int e = 0;
  
  QQComicPreloadStrategy(int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper = new PluginPreloadReportUtils.HitRateHelper(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    if (paramInt == 6) {
      this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = new PreloadProcHitPluginSession("comic_leba_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    do
    {
      return;
      if (paramInt == 5)
      {
        this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = new PreloadProcHitPluginSession("comic_activity_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        return;
      }
    } while (paramInt != 9999);
    this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = new PreloadProcHitPluginSession("comic_web_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
  }
  
  private String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload start");
    }
    QQComicPluginBridge.a("preload_plugin");
    if (!QIPCServerHelper.getInstance().isModuleRunning(this.jdField_c_of_type_JavaLangString)) {
      VasWebviewUtil.reportVasStatus("qqcomic", "launch_plugin_action", "0", 0, 201);
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), VipProxyPreLoadComicProcess.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("isPreloadProcess", true);
    localIntent.putExtra("preloadEntry", this.jdField_c_of_type_Int);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    PreloadSuccessRateReporter.a(BaseApplicationImpl.getApplication().getRuntime(), 1, 1, 0L);
    QQComicPluginBridge.a(localIntent);
    if ((IndividuationUrlHelper.a() instanceof Serializable)) {
      localIntent.putExtra("urlMap", (Serializable)IndividuationUrlHelper.a());
    }
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    localPluginParams.e = "comic_plugin";
    localPluginParams.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localPluginParams.f = "com.qqcomic.app.VipPreloadComicProcess";
    this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper.a(this.e, a(), this.jdField_d_of_type_Int);
    localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.b(BaseApplicationImpl.getContext(), localPluginParams);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload end");
    }
  }
  
  public void a(PluginPreloader.ExtraResult paramExtraResult)
  {
    if (paramExtraResult == null) {
      return;
    }
    this.e = paramExtraResult.jdField_a_of_type_Int;
    this.jdField_d_of_type_JavaLangString = paramExtraResult.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(PluginPreloader.ExtraResult paramExtraResult)
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qr_process_config.name(), "0|24|0|24");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length < 4) {}
    }
    for (boolean bool = "1".equals(localObject[2]);; bool = false)
    {
      if (paramExtraResult != null)
      {
        paramExtraResult.jdField_a_of_type_Int = 2;
        if (!bool) {
          break label141;
        }
      }
      label141:
      for (localObject = "preload:ok:dpc";; localObject = "preload:fail:dpc")
      {
        paramExtraResult.jdField_a_of_type_JavaLangString = ((String)localObject);
        paramExtraResult = (QQComicPreloadManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QQCOMIC_PRELOAD_MANAGER);
        if (paramExtraResult != null)
        {
          paramExtraResult.a();
          if (paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null)
          {
            this.jdField_a_of_type_Int = ((PluginPreloadStrategy.PreloadServerParam)paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Int;
            this.jdField_c_of_type_Boolean = ((PluginPreloadStrategy.PreloadServerParam)paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Boolean;
          }
        }
        return bool;
      }
    }
  }
  
  protected boolean b(PluginPreloader.ExtraResult paramExtraResult)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramExtraResult == null) {
      paramExtraResult = new PluginPreloader.ExtraResult();
    }
    for (;;)
    {
      QQComicPreloadManager localQQComicPreloadManager = (QQComicPreloadManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QQCOMIC_PRELOAD_MANAGER);
      int i;
      if (localQQComicPreloadManager != null) {
        if ((localQQComicPreloadManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null) && (((PluginPreloadStrategy.PreloadServerParam)localQQComicPreloadManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_a_of_type_Boolean))
        {
          i = 1;
          if (this.jdField_c_of_type_Int != 5) {
            break label218;
          }
          if ((i != 0) && (localQQComicPreloadManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1)) {
            break label164;
          }
          paramExtraResult.jdField_a_of_type_Int = 1;
          paramExtraResult.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          label105:
          bool2 = bool1;
          if (localQQComicPreloadManager.b.get() != null) {
            this.jdField_d_of_type_Int = ((PluginPreloadStrategy.PreloadPublicParam)localQQComicPreloadManager.b.get()).jdField_a_of_type_Int;
          }
        }
      }
      for (bool2 = bool1;; bool2 = false)
      {
        this.e = paramExtraResult.jdField_a_of_type_Int;
        this.jdField_d_of_type_JavaLangString = paramExtraResult.jdField_a_of_type_JavaLangString;
        return bool2;
        i = 0;
        break;
        label164:
        if (localQQComicPreloadManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          if (!bool1) {
            break label203;
          }
          paramExtraResult.jdField_a_of_type_Int = 2;
          paramExtraResult.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          break;
        }
        label203:
        paramExtraResult.jdField_a_of_type_Int = 2;
        paramExtraResult.jdField_a_of_type_JavaLangString = "preload:fail:publicaccount";
        break label105;
        label218:
        if (this.jdField_c_of_type_Int == 6)
        {
          if ((i != 0) && (localQQComicPreloadManager.b.get() != null))
          {
            bool1 = a((PluginPreloadStrategy.PreloadPublicParam)localQQComicPreloadManager.b.get(), String.valueOf(1113), localQQComicPreloadManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.android.animation", localQQComicPreloadManager.a(), localQQComicPreloadManager.a(), localQQComicPreloadManager.a(), paramExtraResult);
            break label105;
          }
          paramExtraResult.jdField_a_of_type_Int = 1;
          paramExtraResult.jdField_a_of_type_JavaLangString = "preload:fail:normal";
          bool1 = false;
          break label105;
        }
        if (this.jdField_c_of_type_Int == 9999)
        {
          paramExtraResult.jdField_a_of_type_Int = 1;
          paramExtraResult.jdField_a_of_type_JavaLangString = "preload:ok:web";
          break label105;
        }
        paramExtraResult.jdField_a_of_type_Int = 1;
        paramExtraResult.jdField_a_of_type_JavaLangString = "preload:fail:unknownentry";
        bool1 = false;
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.QQComicPreloadStrategy
 * JD-Core Version:    0.7.0.1
 */