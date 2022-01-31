package cooperation.qzone.networkedmodule;

import bggi;
import bgyi;
import bhgu;
import bhgv;
import bhgz;
import bhhe;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.lang.reflect.Method;
import java.util.HashMap;

public class QzoneModuleRecordFactory
{
  private static final String TAG = "QzoneModuleRecordFactory";
  private static volatile QzoneModuleRecordFactory sFactory;
  private HashMap<String, bhhe> mMethodMap = new HashMap();
  
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
  
  private HashMap<String, bhhe> loadMethods(Object paramObject, Class<?> paramClass)
  {
    HashMap localHashMap = new HashMap();
    paramClass = paramClass.getMethods();
    int j = paramClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = paramClass[i];
        try
        {
          if (localObject.isAnnotationPresent(bhgz.class))
          {
            localObject.setAccessible(true);
            String str = ((bhgz)localObject.getAnnotation(bhgz.class)).a();
            bhhe localbhhe = new bhhe(null);
            localbhhe.jdField_a_of_type_JavaLangObject = paramObject;
            localbhhe.jdField_a_of_type_JavaLangReflectMethod = localObject;
            localHashMap.put(str, localbhhe);
          }
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.w("QzoneModuleRecordFactory", 1, "catch an exception:", localThrowable);
          }
        }
      }
    }
    return localHashMap;
  }
  
  @bhgz(a="upload.so")
  public bhgu createQzoneUploadSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "QzoneUploadSo", "https://d3g.qq.com/sngapp/app/update/20200113193058_6341/qzoneuploadso.zip");
    String str2 = QzoneConfig.getInstance().getConfig("PhotoUpload", "QzoneUploadSoMD5", "0bdd196ce6962895dbe3634ab1d55d2a");
    bhgv localbhgv = new bhgv();
    localbhgv.a("upload.so").d(str1).e(str2);
    return localbhgv.a();
  }
  
  public bhgu createRecord(String paramString)
  {
    paramString = (bhhe)this.mMethodMap.get(paramString);
    if (paramString != null) {
      try
      {
        paramString = (bhgu)paramString.jdField_a_of_type_JavaLangReflectMethod.invoke(paramString.jdField_a_of_type_JavaLangObject, new Object[0]);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneModuleRecordFactory", 1, "catch an exception:", paramString);
      }
    }
    return null;
  }
  
  @bhgz(a="libandroidndkbeauty.so")
  public bhgu createRecordForAntiBeautyDMSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySo", "https://d3g.qq.com/sngapp/app/update/20180518104407_5319/libandroidndkbeauty.so");
    String str2 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoMD5", "1047ac302378fe17735c98f67d470496");
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoLength", 4741347);
    bhgv localbhgv = new bhgv();
    localbhgv.a("libandroidndkbeauty.so").d(str1).e(str2).a(i);
    return localbhgv.a();
  }
  
  @bhgz(a="pictureMarkerSo.zip")
  public bhgu createRecordForAntishakeDMSo()
  {
    String str2;
    String str1;
    if (AppSetting.b)
    {
      str2 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuidePictureQulatitySo64", "https://d3g.qq.com/sngapp/app/update/20191105214335_3222/gifAntishake64.zip");
      str1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuidePictureQulatitySoMD564", "fff43d114068dc1ead91c92db27b9f22");
    }
    for (long l = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuidePictureQulatitySoLength64", 1680425);; l = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuidePictureQulatitySoLength", 1312085))
    {
      bhgv localbhgv = new bhgv();
      localbhgv.a("pictureMarkerSo.zip").d(str2).e(str1).a(l);
      return localbhgv.a();
      str2 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuidePictureQulatitySo", "https://d3g.qq.com/sngapp/app/update/20190529163630_2122/photoQulatitySo.zip");
      str1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuidePictureQulatitySoMD5", "2111365a079cdbdc66ddfc31f140c474");
    }
  }
  
  @bhgz(a="qzlive_live_audio.jar")
  public bhgu createRecordForLiveAudioSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginAudioUrl", "http://d3g.qq.com/sngapp/app/update/20160803113848_6187/qzoneliveaudio.jar");
    String str2 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginAudioMd5", "73bf723be02a6b71b17a0d47888c4e04");
    bhgv localbhgv = new bhgv();
    localbhgv.a("qzlive_live_audio.jar").d(str1).e(str2);
    return localbhgv.a();
  }
  
  @bhgz(a="qzlive_res1_yt_facedetect.jar")
  public bhgu createRecordForLivePtuDMSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginPtuAlgoUrl", "https://d3g.qq.com/sngapp/app/update/20191226133414_2167/res1_yt_facedetect.so");
    String str2 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginPtuAlgoMd5", "1cdaf8508cc7343f796ef21b5e65c2b6");
    bhgv localbhgv = new bhgv();
    localbhgv.a("qzlive_res1_yt_facedetect.jar").d(str1).e(str2);
    return localbhgv.a();
  }
  
  @bhgz(a="qzlive_res1_yt_seg_and_hand.jar")
  public bhgu createRecordForLivePtuSegAndHandDetect()
  {
    String str1 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginSegAndHandUrl", "http://d3g.qq.com/sngapp/app/update/20180110162244_5632/res1_yt_seg_and_hand.so");
    String str2 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginSegAndHandMd5", "586bcad62ef42fc352676e485dc38d96");
    bhgv localbhgv = new bhgv();
    localbhgv.a("qzlive_res1_yt_seg_and_hand.jar").d(str1).e(str2);
    return localbhgv.a();
  }
  
  @bhgz(a="osk_exoplayer2_bundle.jar")
  public bhgu createRecordForOskPlayer()
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
    Object localObject2 = new bhgv();
    ((bhgv)localObject2).a("osk_exoplayer2_bundle.jar").d((String)localObject1).e(str1).f("com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer").b("1").c(bgyi.a());
    QLog.i("QzoneModuleRecordFactory", 1, "oskplayerconfig:" + str2);
    return ((bhgv)localObject2).a();
  }
  
  @bhgz(a="filterengine.bundle.jar")
  public bhgu createRecordForPtuFilterEngineJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libFilterEngineJarUrl", "http://d3g.qq.com/sngapp/app/update/20170117164907_3213/filterengine.bundle.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libFilterEngineJarMD5", "4d5cfa42acc64e9fadecff38bdde6cbd");
    bhgv localbhgv = new bhgv();
    localbhgv.a("filterengine.bundle.jar").d(str1).e(str2).f("com.tencent.filterengine.bundle.BuildConfig").b("1").c(bgyi.a());
    return localbhgv.a();
  }
  
  @bhgz(a="libalgo_rithm_jni.so")
  public bhgu createRecordForPtuJniSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libAlgorithmJniSoUrl", "http://d3g.qq.com/sngapp/app/update/20170117162505_7464/libalgo_rithm_jni.so");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libAlgorithmJniSoMD5", "3dcc7162dd785eb4bfa4fb6689efd7e9");
    bhgv localbhgv = new bhgv();
    localbhgv.a("libalgo_rithm_jni.so").d(str1).e(str2).b("1").c(bgyi.a());
    return localbhgv.a();
  }
  
  @bhgz(a="libsuperresolution.jar")
  public bhgu createRecordForSuperResolutionSo()
  {
    String str2;
    if (AppSetting.b) {
      str2 = bggi.a().a("QZoneSetting", "libSuperResolutionJarUrl_64", "https://d3g.qq.com/sngapp/app/update/20191105145019_6289/libsuperresolution.jar");
    }
    for (String str1 = bggi.a().a("QZoneSetting", "libSuperResolutionJarMD5_64", "f12dae831c929686229d1666fffcb012");; str1 = bggi.a().a("QZoneSetting", "libSuperResolutionJarMD5", "6dc8f2f6f95d50ef6daef91c0f1595ec"))
    {
      bhgv localbhgv = new bhgv();
      localbhgv.a("libsuperresolution.jar").d(str2).e(str1).b("1").c(bgyi.a());
      return localbhgv.a();
      str2 = bggi.a().a("QZoneSetting", "libSuperResolutionJarUrl", "https://d3g.qq.com/sngapp/app/update/20181204152623_3844/libsuperresolution.jar");
    }
  }
  
  @bhgz(a="tag_classify.jar")
  public bhgu createRecordForTagClassifySo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "photo_tag_classify_file", "http://d3g.qq.com/sngapp/app/update/20180329102523_4877/pic_tag_sdk.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "photo_classify_file_md5", "6b5338544a7c9baff2af16413d3d5119");
    bhgv localbhgv = new bhgv();
    localbhgv.a("tag_classify.jar").d(str1).e(str2);
    return localbhgv.a();
  }
  
  @bhgz(a="test_log.dex")
  public bhgu createRecordForTest()
  {
    bhgv localbhgv = new bhgv();
    localbhgv.a("test_log.dex").d("http://d3g.qq.com/sngapp/app/update/20161212150740_4388/qzonemodule_mapsdk.jar").e("158c17d81b2aa6c0f8347aaa64dd015b").f("com.tencent.tencentmap.mapsdk.map.Projection").b("1").c(bgyi.a());
    return localbhgv.a();
  }
  
  @bhgz(a="upload.jar")
  public bhgu createRecordForUploadJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libUploadJarUrl", "https://d3g.qq.com/sngapp/app/update/20200225165213_5410/upload.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libUploadJarMD5", "f0cee072f5851282b04dc809a834dd0d");
    bhgv localbhgv = new bhgv();
    localbhgv.a("upload.jar").d(str1).e(str2).g("3-31;3-32;3-33;3-34;3-35;3-36;3-37;3-38;3-39;3-40;3-41;3-42;3-43;3-44;3-45;3-46;3-47;3-48;3-49;3-50;3-51;3-52;3-53;3-54;3-55;3-56;3-57;3-58;3-59;3-60;3-61;3-62;3-63;3-64;3-65;3-66;3-67;3-68;3-69;3-70;3-71;3-72;3-73;3-74;3-75;3-76;3-77;3-78;3-79;3-80;3-81;3-125;3-126;3-127;3-128;3-197;3-198;3-199;3-5892;3-5788;3-5884;3-5889;3-5890;3-5800;3-5801;3-5802;3-5803;3-5804;3-5805;3-5811;3-5812;3-5814;3-5815;3-5816;3-5817;3-5841;3-5862;3-5863;3-5877;3-5878;3-5879;3-5880;3-5881;3-5882;3-5883;3-5885;3-5886;3-5887;3-5888;3-5891;3-5893;3-5894;3-5895;3-5896;3-5897;3-5898;3-5899;3-5900;3-5901;3-5902;3-5903;3-5904;3-5905;3-5906;3-5907;3-5908;3-5909;3-5910;3-5911;3-5912;3-5939;3-5913;3-5914;3-5915;3-5916;3-5917;3-5918;3-5919;3-5920;3-5921;3-5922;3-5923;3-5924;3-5925;3-5926;3-5927;3-5928;3-5929;3-5930;3-5931;3-5932;3-5933;3-5934;3-5935;3-5936;3-5937;3-5938;3-5940;3-5941;3-5942;3-5943;3-5944;3-5945;3-5946;3-5947;3-5948;3-5949;3-5950;3-5951;3-5952").f("com.tencent.upload.impl.UploadServiceProxy").b("1").a(150).c(bgyi.a());
    return localbhgv.a();
  }
  
  @bhgz(a="frameanimation.jar")
  public bhgu createRecordForVoiceShuoshuoAnimation()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "VoiceShuoshuoAnimation", "http://d3g.qq.com/sngapp/app/update/20170628223109_9590/frameanimation.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "VoiceShuoshuoAnimationMD5", "3F2512458A3F6EB1E23775FB9C8743A2");
    long l = QzoneConfig.getInstance().getConfig("QZoneSetting", "VoiceShuoshuoAnimationLength", 1739513);
    bhgv localbhgv = new bhgv();
    localbhgv.a("frameanimation.jar").d(str1).e(str2).a(l);
    return localbhgv.a();
  }
  
  @bhgz(a="vip_tar_engine.jar")
  public bhgu createRecrodForARTarEngineJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "vip_tar_engine.jar", "https://d3g.qq.com/sngapp/app/update/20191114160352_6351/vip_tar_engine.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "vip_tar_engine_md5", "3c4cd9ff849e9b6576ffa6d8fe60bcaa");
    String str3 = QzoneConfig.getInstance().getConfig("QZoneSetting", "version", "3");
    bhgv localbhgv = new bhgv();
    localbhgv.a("vip_tar_engine.jar").d(str1).e(str2).b(str3).c(bgyi.a());
    return localbhgv.a();
  }
  
  @bhgz(a="libTar.so")
  public bhgu createRecrodForARTarEngineSo()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "libTar.so", "https://d3g.qq.com/sngapp/app/update/20191106212848_5780/libTAR.so");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "lib_tar_so_md5", "3a0222c4b9d441a4cf4a3ac620f5dfbc");
    String str3 = QzoneConfig.getInstance().getConfig("QZoneSetting", "version", "1");
    bhgv localbhgv = new bhgv();
    localbhgv.a("libTar.so").d(str1).e(str2).b(str3).c(bgyi.a());
    return localbhgv.a();
  }
  
  @bhgz(a="animatedWebp.so")
  public bhgu createRecrodForAnimatedWebp()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "animatedWebp", "https://d3g.qq.com/sngapp/app/update/20190724163607_2917/libanimwebp_jni.so");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "animatedWebpMD5", "4c8590a921c2722051416111dfd57122");
    bhgv localbhgv = new bhgv();
    localbhgv.a("animatedWebp.so").d(str1).e(str2);
    return localbhgv.a();
  }
  
  @bhgz(a="cyber_clink_version_2.jar")
  public bhgu createRecrodForDLNAJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "cyberClinkUrl", "https://d3g.qq.com/sngapp/app/update/20180824143533_9249/cyber_clink.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "cyberClinkJarMD5", "1fa71f228a6daff1fb04f7148f2c95d7");
    bhgv localbhgv = new bhgv();
    localbhgv.a("cyber_clink_version_2.jar").d(str1).f("com.qzone.album.business.dlna.DLNAServiceImpl").e(str2);
    return localbhgv.a();
  }
  
  @bhgz(a="qzlive_filterbundle.jar")
  public bhgu createRecrodForLiveFilterBundle()
  {
    String str1 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginFilterBundleUrl", "http://d3g.qq.com/sngapp/app/update/20171105201346_3221/filterengine.bundle_qzone_7.6.jar");
    String str2 = QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginFilterBundleMd5", "b11e343a1096d3b6331b32e2b1bada88");
    bhgv localbhgv = new bhgv();
    localbhgv.a("qzlive_filterbundle.jar").d(str1).e(str2);
    return localbhgv.a();
  }
  
  @bhgz(a="xmpcore.jar")
  public bhgu createRecrodForXMPCoreJar()
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "xmpcoreUrl", "http://d3g.qq.com/sngapp/app/update/20171220130606_8640/xmpcore.jar");
    String str2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "XMPcoreJarMD5", "a0c5ac44fc2d0e35187f0c1479db48b2");
    bhgv localbhgv = new bhgv();
    localbhgv.a("xmpcore.jar").d(str1).e(str2);
    return localbhgv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleRecordFactory
 * JD-Core Version:    0.7.0.1
 */