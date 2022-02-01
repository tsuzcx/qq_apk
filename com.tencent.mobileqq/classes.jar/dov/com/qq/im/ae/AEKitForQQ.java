package dov.com.qq.im.ae;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.AEModuleConfig;
import com.tencent.aekit.api.standard.AEModuleConfig.Builder;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.sveffects.SvEffectSdkInitor;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.util.CfConfig;
import com.tencent.ttpic.video.AECoderFactory;
import dov.com.qq.im.ae.data.AEMaterialConfigParser;
import dov.com.qq.im.ae.download.AELocalConfig;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import org.light.DeviceSupportUtil;
import org.light.device.OfflineConfig;

public class AEKitForQQ
{
  private static boolean a = false;
  
  public static boolean a()
  {
    if (a) {
      return true;
    }
    if ((!AEResUtil.a(AEResInfo.b)) || (!AEResUtil.a(AEResInfo.c))) {
      return false;
    }
    LightNode.initResourcePath(AEResUtil.d(), AEResUtil.e());
    DeviceSupportUtil.init(AEResUtil.d());
    if (!b())
    {
      SLog.e("AEKitForQQ", "sdk version Limited!");
      return false;
    }
    SvEffectSdkInitor.a();
    String str = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
    AEQLog.a("AEKitForQQ", "initAEKit modelPath = " + str);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    SharedPreferences localSharedPreferences = AECameraPrefsUtil.a().a();
    AEOpenRenderConfig.setEnableStrictMode(false);
    AEModule.initialize(localBaseApplication, AEModuleConfig.newBuilder().setLoadSo(false).setLutDir(str).setModelDir(str).setSoDir(str).setAuthMode(1).setPreferences(localSharedPreferences).setEnableDebug(false).setFramebufferFetchEnable(false).setEnableResourceCheck(false).setEnableProfiler(false).setEnableDefaultBasic3(false).build());
    AECoderFactory.setAEDecoder(new AEKitForQQ.1());
    AECoderFactory.setAEEncoder(new AEKitForQQ.2());
    AEMaterialConfigParser.a = OfflineConfig.getPhonePerfLevel(localBaseApplication);
    AEQLog.a("AEKitForQQ", "[init][material_downgrade] phoneLevel = " + AEMaterialConfigParser.a);
    QLog.i("AEKitForQQ", 1, "[init][lightSdk] version = " + AELocalConfig.a);
    CfConfig.setDecryptListener(new AEKitForQQ.3());
    a = true;
    return true;
  }
  
  public static boolean b()
  {
    return (AEModule.isAeKitSupportVersion()) && (Build.VERSION.SDK_INT >= 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEKitForQQ
 * JD-Core Version:    0.7.0.1
 */