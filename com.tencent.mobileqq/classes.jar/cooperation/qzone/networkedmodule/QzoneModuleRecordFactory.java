package cooperation.qzone.networkedmodule;

import anef;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneAlphaConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import java.lang.reflect.Method;
import java.util.HashMap;

public class QzoneModuleRecordFactory
{
  private static final String TAG = "QzoneModuleRecordFactory";
  private static volatile QzoneModuleRecordFactory sFactory;
  private HashMap mMethodMap = new HashMap();
  
  private QzoneModuleRecordFactory()
  {
    this.mMethodMap.putAll(loadMethods(this, QzoneModuleRecordFactory.class));
  }
  
  public static QzoneModuleRecordFactory getInstance()
  {
    if (sFactory == null) {}
    try
    {
      if (sFactory == null) {
        sFactory = new QzoneModuleRecordFactory();
      }
      return sFactory;
    }
    finally {}
  }
  
  private HashMap loadMethods(Object paramObject, Class paramClass)
  {
    HashMap localHashMap = new HashMap();
    paramClass = paramClass.getMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramClass[i];
      if (localObject.isAnnotationPresent(QzoneModuleId.class))
      {
        localObject.setAccessible(true);
        String str = ((QzoneModuleId)localObject.getAnnotation(QzoneModuleId.class)).a();
        anef localanef = new anef(null);
        localanef.jdField_a_of_type_JavaLangObject = paramObject;
        localanef.jdField_a_of_type_JavaLangReflectMethod = localObject;
        localHashMap.put(str, localanef);
      }
      i += 1;
    }
    return localHashMap;
  }
  
  @QzoneModuleId(a="upload.so")
  public QzoneModuleConfigManager.QzoneModuleRecord createQzoneUploadSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "QzoneUploadSo", "http://d3g.qq.com/sngapp/app/update/20180122195952_6159/qzoneuploadso.zip");
    String str2 = QzoneConfig.getInstance().getConfig("PhotoUpload", "QzoneUploadSoMD5", "6891db6aea9bb1116006649e93e0feba");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("upload.so").d(str1).e(str2);
    return localQzoneModuleRecordBuilder.a();
  }
  
  public QzoneModuleConfigManager.QzoneModuleRecord createRecord(String paramString)
  {
    paramString = (anef)this.mMethodMap.get(paramString);
    if (paramString != null) {
      try
      {
        paramString = (QzoneModuleConfigManager.QzoneModuleRecord)paramString.jdField_a_of_type_JavaLangReflectMethod.invoke(paramString.jdField_a_of_type_JavaLangObject, new Object[0]);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneModuleRecordFactory", 1, "catch an exception:", paramString);
      }
    }
    return null;
  }
  
  @QzoneModuleId(a="libandroidndkbeauty.so")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForAntiBeautyDMSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySo", "https://d3g.qq.com/sngapp/app/update/20180518104407_5319/libandroidndkbeauty.so");
    String str2 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoMD5", "1047ac302378fe17735c98f67d470496");
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoLength", 4741347);
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("libandroidndkbeauty.so").d(str1).e(str2).a(i);
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="pictureMarkerSo.so")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForAntishakeDMSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuidePictureQulatitySo", "http://d3g.qq.com/sngapp/app/update/20170410195647_4697/pictureMarkerSo.so");
    String str2 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuidePictureQulatitySoMD5", "010471CCEB0614FE6577630F892B967D");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("pictureMarkerSo.so").d(str1).e(str2);
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="qzlive_live_audio.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForLiveAudioSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginAudioUrl", "http://d3g.qq.com/sngapp/app/update/20160803113848_6187/qzoneliveaudio.jar");
    String str2 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginAudioMd5", "73bf723be02a6b71b17a0d47888c4e04");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("qzlive_live_audio.jar").d(str1).e(str2);
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="qzlive_res1_yt_facedetect.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForLivePtuDMSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginPtuAlgoUrl", "http://d3g.qq.com/sngapp/app/update/20171116212855_6472/res1_yt_facedetect.so");
    String str2 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginPtuAlgoMd5", "9166d4f7d413c946df0951dd303766dd");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("qzlive_res1_yt_facedetect.jar").d(str1).e(str2);
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="qzlive_res1_yt_seg_and_hand.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForLivePtuSegAndHandDetect()
  {
    String str1 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginSegAndHandUrl", "http://d3g.qq.com/sngapp/app/update/20180110162244_5632/res1_yt_seg_and_hand.so");
    String str2 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginSegAndHandMd5", "586bcad62ef42fc352676e485dc38d96");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("qzlive_res1_yt_seg_and_hand.jar").d(str1).e(str2);
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="osk_exoplayer2_bundle.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForOskPlayer()
  {
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libOskPlayerJarConfig", "http://d3g.qq.com/sngapp/app/update/20170728155227_6686/osk_exoplayer2_bundle.jar|f9d35ec8e90af758354bb174abc12df4");
    String[] arrayOfString = str2.split("\\|");
    String str1 = "";
    Object localObject1 = "";
    int i = 0;
    if (i < arrayOfString.length)
    {
      if (i == 0) {
        localObject2 = arrayOfString[i];
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
        if (i == 1)
        {
          str1 = arrayOfString[i];
          localObject2 = localObject1;
        }
      }
    }
    Object localObject2 = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    ((QzoneModuleConfigManager.QzoneModuleRecordBuilder)localObject2).a("osk_exoplayer2_bundle.jar").d((String)localObject1).e(str1).f("com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer").b("1").c(QUA.a());
    QLog.i("QzoneModuleRecordFactory", 1, "oskplayerconfig:" + str2);
    return ((QzoneModuleConfigManager.QzoneModuleRecordBuilder)localObject2).a();
  }
  
  @QzoneModuleId(a="filterengine.bundle.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForPtuFilterEngineJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libFilterEngineJarUrl", "http://d3g.qq.com/sngapp/app/update/20170117164907_3213/filterengine.bundle.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libFilterEngineJarMD5", "4d5cfa42acc64e9fadecff38bdde6cbd");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("filterengine.bundle.jar").d(str1).e(str2).f("com.tencent.filterengine.bundle.BuildConfig").b("1").c(QUA.a());
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="libalgo_rithm_jni.so")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForPtuJniSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libAlgorithmJniSoUrl", "http://d3g.qq.com/sngapp/app/update/20170117162505_7464/libalgo_rithm_jni.so");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libAlgorithmJniSoMD5", "3dcc7162dd785eb4bfa4fb6689efd7e9");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("libalgo_rithm_jni.so").d(str1).e(str2).b("1").c(QUA.a());
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="libsuperresolution.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForSuperResolutionSo()
  {
    String str1 = QzoneAlphaConfig.a().a("QZoneSetting", "libSuperResolutionJarUrl", "http://d3g.qq.com/sngapp/app/update/20180130110722_3483/libsuperresolution.jar");
    String str2 = QzoneAlphaConfig.a().a("QZoneSetting", "libSuperResolutionJarMD5", "1253f1740798b155b56802560fc9b471");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("libsuperresolution.jar").d(str1).e(str2).b("1").c(QUA.a());
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="tag_classify.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForTagClassifySo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "photo_tag_classify_file", "http://d3g.qq.com/sngapp/app/update/20180329102523_4877/pic_tag_sdk.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "photo_classify_file_md5", "6b5338544a7c9baff2af16413d3d5119");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("tag_classify.jar").d(str1).e(str2);
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="test_log.dex")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForTest()
  {
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("test_log.dex").d("http://d3g.qq.com/sngapp/app/update/20161212150740_4388/qzonemodule_mapsdk.jar").e("158c17d81b2aa6c0f8347aaa64dd015b").f("com.tencent.tencentmap.mapsdk.map.Projection").b("1").c(QUA.a());
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="upload.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForUploadJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libUploadJarUrl", "http://d3g.qq.com/sngapp/app/update/20170620132203_7720/upload.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libUploadJarMD5", "995588e6c55101d00a7ec4576df955d6");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("upload.jar").d(str1).e(str2).g("3-31;3-32;3-33;3-34;3-35;3-36;3-37;3-38;3-39;3-40;3-41;3-42;3-43;3-44;3-45;3-46;3-47;3-48;3-49;3-50;3-51;3-52;3-53;3-54;3-55;3-56;3-57;3-58;3-59;3-60;3-61;3-62;3-63;3-64;3-65;3-66;3-67;3-68;3-69;3-70;3-71;3-72;3-73;3-74;3-75;3-76;3-77;3-78;3-79;3-80;3-81;3-125;3-126;3-127;3-128;3-197;3-198;3-199;3-5892;3-5788;3-5884;3-5889;3-5890;3-5800;3-5801;3-5802;3-5803;3-5804;3-5805;3-5811;3-5812;3-5814;3-5815;3-5816;3-5817;3-5841;3-5862;3-5863;3-5877;3-5878;3-5879;3-5880;3-5881;3-5882;3-5883;3-5885;3-5886;3-5887;3-5888;3-5891;3-5893;3-5894;3-5895;3-5896;3-5897;3-5898;3-5899;3-5900;3-5901;3-5902;3-5903;3-5904;3-5905;3-5906;3-5907;3-5908;3-5909;3-5910;3-5911;3-5912;3-5939;3-5913;3-5914;3-5915;3-5916;3-5917;3-5918;3-5919;3-5920;3-5921;3-5922;3-5923;3-5924;3-5925;3-5926;3-5927;3-5928;3-5929;3-5930;3-5931;3-5932;3-5933;3-5934;3-5935;3-5936;3-5937;3-5938;3-5940;3-5941;3-5942;3-5943;3-5944;3-5945;3-5946;3-5947;3-5948;3-5949;3-5950;3-5951;3-5952").f("com.tencent.upload.impl.UploadServiceProxy").b("1").a(150).c(QUA.a());
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="frameanimation.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecordForVoiceShuoshuoAnimation()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "VoiceShuoshuoAnimation", "http://d3g.qq.com/sngapp/app/update/20170628223109_9590/frameanimation.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "VoiceShuoshuoAnimationMD5", "3F2512458A3F6EB1E23775FB9C8743A2");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("frameanimation.jar").d(str1).e(str2);
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="cyber_clink.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecrodForDLNAJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "cyberClinkUrl", "http://d3g.qq.com/sngapp/app/update/20180126175258_8812/cyber_clink.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "cyberClinkJarMD5", "afd22e03d959372c4261122b5c48720c");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("cyber_clink.jar").d(str1).f("com.qzone.album.business.dlna.DLNAServiceImpl").e(str2);
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="qzlive_filterbundle.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecrodForLiveFilterBundle()
  {
    String str1 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginFilterBundleUrl", "http://d3g.qq.com/sngapp/app/update/20171105201346_3221/filterengine.bundle_qzone_7.6.jar");
    String str2 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginFilterBundleMd5", "b11e343a1096d3b6331b32e2b1bada88");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("qzlive_filterbundle.jar").d(str1).e(str2);
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="p2v_effect.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecrodForP2VEffectJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "p2vEffectUrl", "https://d3g.qq.com/sngapp/app/update/20180523193621_6462/p2v_effect.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "p2vEffectJarMD5", "a224ca83ac93e70cb401a5062a3c142b");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("p2v_effect.jar").d(str1).f("com.tencent.mobileqq.activity.richmedia.p2veffect.P2VEffectsController").e(str2);
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="p2v_material.zip")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecrodForP2VEffectMaterial()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "p2vMaterialUrl", "http://d3g.qq.com/sngapp/app/update/20180124144756_2643/p2v_material.zip");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "p2vMaterialMD5", "f61e9058b09761852fda262a13c353fc");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("p2v_material.zip").d(str1).e(str2);
    return localQzoneModuleRecordBuilder.a();
  }
  
  @QzoneModuleId(a="xmpcore.jar")
  public QzoneModuleConfigManager.QzoneModuleRecord createRecrodForXMPCoreJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "xmpcoreUrl", "http://d3g.qq.com/sngapp/app/update/20171220130606_8640/xmpcore.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "XMPcoreJarMD5", "a0c5ac44fc2d0e35187f0c1479db48b2");
    QzoneModuleConfigManager.QzoneModuleRecordBuilder localQzoneModuleRecordBuilder = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
    localQzoneModuleRecordBuilder.a("xmpcore.jar").d(str1).e(str2);
    return localQzoneModuleRecordBuilder.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleRecordFactory
 * JD-Core Version:    0.7.0.1
 */