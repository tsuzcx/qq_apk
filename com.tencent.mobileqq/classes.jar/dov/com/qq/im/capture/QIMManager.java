package dov.com.qq.im.capture;

import android.annotation.SuppressLint;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCaptureVarManager;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.play.AEPlayShowMaterialManager;
import dov.com.qq.im.capture.banner.QIMCaptureBannerManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.CaptureTemplateManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.qq.im.capture.paster.QIMPasterConfigManager;
import dov.com.qq.im.capture.predownload.QIMPredownManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.story.QQStoryForShotManager;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QIMManager
{
  @SuppressLint({"UseSparseArrays"})
  private final HashMap<Integer, Object> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final IQIMManager[] jdField_a_of_type_ArrayOfDovComQqImCaptureIQIMManager = new IQIMManager[20];
  
  public static AppInterface a()
  {
    return (AppInterface)a();
  }
  
  public static IQIMManager a(int paramInt)
  {
    return QIMManager.InstanceHolder.a().c(paramInt);
  }
  
  public static QIMManager a()
  {
    return QIMManager.InstanceHolder.a();
  }
  
  private static AppRuntime a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return localAppRuntime;
    }
    return BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
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
    return QIMManager.InstanceHolder.a().jdField_a_of_type_ArrayOfDovComQqImCaptureIQIMManager[paramInt];
  }
  
  public void a()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfDovComQqImCaptureIQIMManager.length)
    {
      Object localObject1;
      synchronized (this.jdField_a_of_type_ArrayOfDovComQqImCaptureIQIMManager)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new Object());
        }
        localObject1 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfDovComQqImCaptureIQIMManager[paramInt] != null;
  }
  
  public IQIMManager c(int paramInt)
  {
    ??? = this.jdField_a_of_type_ArrayOfDovComQqImCaptureIQIMManager[paramInt];
    Object localObject4 = ???;
    Object localObject6;
    if (??? == null) {
      synchronized (this.jdField_a_of_type_ArrayOfDovComQqImCaptureIQIMManager)
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new Object());
        }
        localObject6 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
    }
    try
    {
      localObject4 = this.jdField_a_of_type_ArrayOfDovComQqImCaptureIQIMManager[paramInt];
      if (localObject4 != null)
      {
        return localObject4;
        localObject5 = finally;
        throw localObject5;
      }
      if (!a()) {
        throw new RuntimeException("invalid process");
      }
    }
    finally {}
    Object localObject3 = localObject5;
    switch (paramInt)
    {
    default: 
      localObject3 = localObject5;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureIQIMManager[paramInt] = localObject3;
      if (localObject3 != null)
      {
        ((IQIMManager)localObject3).onInit();
        SLog.b("QIMManager", "onInit manager : %s", localObject3);
      }
      return localObject3;
      localObject3 = new QIMPasterConfigManager();
      continue;
      localObject3 = new QIMMusicConfigManager();
      continue;
      localObject3 = new QIMPtvTemplateManager();
      continue;
      localObject3 = new PasterDataManager();
      continue;
      localObject3 = new CaptureComboManager();
      continue;
      localObject3 = new DynamicTextConfigManager();
      continue;
      localObject3 = new QIMCaptureBannerManager();
      continue;
      localObject3 = new QimMusicPlayer();
      continue;
      localObject3 = new QIMInformationPasterManager();
      continue;
      localObject3 = new QIMCaptureVarManager();
      continue;
      localObject3 = new QIMPredownManager();
      continue;
      localObject3 = new CaptureTemplateManager();
      continue;
      localObject3 = new QQStoryForShotManager();
      continue;
      localObject3 = new AEMaterialManager();
      continue;
      localObject3 = new AEPlayShowMaterialManager();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.QIMManager
 * JD-Core Version:    0.7.0.1
 */