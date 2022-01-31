package dov.com.qq.im.capture;

import ankv;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMSegmentCaptureManager;
import dov.com.qq.im.capture.banner.QIMCaptureBannerManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.qq.im.capture.paster.QIMPasterConfigManager;
import dov.com.qq.im.capture.predownload.QIMPredownManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import mqq.app.AppRuntime;

public class QIMManager
{
  public final IQIMManager[] a = new IQIMManager[15];
  
  public static AppInterface a()
  {
    return (AppInterface)a();
  }
  
  public static IQIMManager a(int paramInt)
  {
    return ankv.a.c(paramInt);
  }
  
  public static QIMManager a()
  {
    return ankv.a;
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return localAppRuntime;
    }
    return BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
  }
  
  private void a(int paramInt, IQIMManager paramIQIMManager)
  {
    this.a[paramInt] = paramIQIMManager;
  }
  
  private boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("QIMManager", 2, "check process: " + localAppRuntime);
    }
    return ((localAppRuntime instanceof QQAppInterface)) || ((localAppRuntime instanceof ToolRuntimePeak));
  }
  
  public static IQIMManager b(int paramInt)
  {
    return ankv.a.a[paramInt];
  }
  
  public void a()
  {
    IQIMManager[] arrayOfIQIMManager = this.a;
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        IQIMManager localIQIMManager = this.a[i];
        SLog.b("QIMManager", "destroy manager : %s", localIQIMManager);
        if (localIQIMManager != null) {
          localIQIMManager.b();
        }
        this.a[i] = null;
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public boolean a(int paramInt)
  {
    return this.a[paramInt] != null;
  }
  
  public IQIMManager c(int paramInt)
  {
    IQIMManager localIQIMManager1 = this.a[paramInt];
    Object localObject2;
    if (localIQIMManager1 == null)
    {
      IQIMManager localIQIMManager2;
      synchronized (this.a)
      {
        localIQIMManager2 = this.a[paramInt];
        if (localIQIMManager2 != null) {
          return localIQIMManager2;
        }
        if (!a()) {
          throw new RuntimeException("invalid process");
        }
      }
      localObject2 = localIQIMManager2;
      switch (paramInt)
      {
      default: 
        localObject2 = localIQIMManager2;
      }
      for (;;)
      {
        a(paramInt, (IQIMManager)localObject2);
        if (localObject2 != null)
        {
          ((IQIMManager)localObject2).a();
          SLog.b("QIMManager", "onInit manager : %s", localObject2);
        }
        return localObject2;
        localObject2 = new QIMPasterConfigManager();
        continue;
        localObject2 = new QIMMusicConfigManager();
        continue;
        localObject2 = new QIMPtvTemplateManager();
        continue;
        localObject2 = new PasterDataManager();
        continue;
        localObject2 = new CaptureComboManager();
        continue;
        localObject2 = new DynamicTextConfigManager();
        continue;
        localObject2 = new QIMCaptureBannerManager();
        continue;
        localObject2 = new QimMusicPlayer();
        continue;
        localObject2 = new RecognitionManager();
        continue;
        localObject2 = new QIMInformationPasterManager();
        continue;
        localObject2 = new QIMSegmentCaptureManager();
        continue;
        localObject2 = new QIMPredownManager();
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.QIMManager
 * JD-Core Version:    0.7.0.1
 */