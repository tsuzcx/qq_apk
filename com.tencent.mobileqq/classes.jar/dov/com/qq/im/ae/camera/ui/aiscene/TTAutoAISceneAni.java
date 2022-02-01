package dov.com.qq.im.ae.camera.ui.aiscene;

import com.tencent.biz.common.util.ZipUtils;
import dov.com.qq.im.ae.AEPath.AISCENE.FILES;
import dov.com.qq.im.ae.data.AEPreDownloadResMetaData;
import java.io.File;

public class TTAutoAISceneAni
{
  private static final String a = TTAutoAISceneAni.class.getSimpleName();
  
  public static AEPreDownloadResMetaData a()
  {
    AEPreDownloadResMetaData localAEPreDownloadResMetaData = new AEPreDownloadResMetaData();
    localAEPreDownloadResMetaData.d = "https://sqdd.myapp.com/myapp/qqteam/QIM/zhinenglvjingdonghua/AutoAISceneAni.zip";
    localAEPreDownloadResMetaData.f = "AutoAISceneAni";
    localAEPreDownloadResMetaData.e = "6f6632b8106fe070a560abcec6051f0d";
    localAEPreDownloadResMetaData.a = "AutoAISceneAni";
    localAEPreDownloadResMetaData.s = AEPath.AISCENE.FILES.c;
    localAEPreDownloadResMetaData.t = AEPath.AISCENE.FILES.b;
    return localAEPreDownloadResMetaData;
  }
  
  public static void a(AEPreDownloadResMetaData paramAEPreDownloadResMetaData)
  {
    try
    {
      File localFile = new File(paramAEPreDownloadResMetaData.c());
      if (!localFile.exists()) {
        return;
      }
      ZipUtils.unZipFile(localFile, paramAEPreDownloadResMetaData.b());
      return;
    }
    catch (Exception paramAEPreDownloadResMetaData) {}
  }
  
  public static AEPreDownloadResMetaData b()
  {
    AEPreDownloadResMetaData localAEPreDownloadResMetaData = new AEPreDownloadResMetaData();
    localAEPreDownloadResMetaData.d = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/aiScreenAndroid/AISceneLoading.zip";
    localAEPreDownloadResMetaData.e = "da407ead2fb260d6b2570450f2e1bebd";
    localAEPreDownloadResMetaData.f = "AISceneLoading";
    localAEPreDownloadResMetaData.a = "AISceneLoading";
    localAEPreDownloadResMetaData.s = AEPath.AISCENE.FILES.c;
    localAEPreDownloadResMetaData.t = AEPath.AISCENE.FILES.b;
    return localAEPreDownloadResMetaData;
  }
  
  public static AEPreDownloadResMetaData c()
  {
    AEPreDownloadResMetaData localAEPreDownloadResMetaData = new AEPreDownloadResMetaData();
    localAEPreDownloadResMetaData.d = "https://qd.myapp.com/myapp/qqteam/shenqidegongneng/AISceneGuide19082601Android.zip";
    localAEPreDownloadResMetaData.e = "dcb9d44eb8872db03a17fe57ce231a76";
    localAEPreDownloadResMetaData.f = "AISceneGuide";
    localAEPreDownloadResMetaData.a = "AISceneGuide";
    localAEPreDownloadResMetaData.s = AEPath.AISCENE.FILES.c;
    localAEPreDownloadResMetaData.t = AEPath.AISCENE.FILES.b;
    return localAEPreDownloadResMetaData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.TTAutoAISceneAni
 * JD-Core Version:    0.7.0.1
 */