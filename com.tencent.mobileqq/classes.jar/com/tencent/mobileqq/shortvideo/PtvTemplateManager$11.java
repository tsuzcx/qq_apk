package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class PtvTemplateManager$11
  implements Runnable
{
  PtvTemplateManager$11(PtvTemplateManager paramPtvTemplateManager, File paramFile, boolean paramBoolean1, PtvTemplateManager.DoodleInfoLoadObserver paramDoodleInfoLoadObserver, boolean paramBoolean2) {}
  
  public void run()
  {
    Object localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_JavaIoFile);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    do
    {
      return;
      localObject1 = PtvTemplateManager.a((String)localObject1);
    } while ((localObject1 == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos.isEmpty()));
    this.this$0.jdField_d_of_type_JavaUtilArrayList.clear();
    ??? = ((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos.iterator();
    while (((Iterator)???).hasNext())
    {
      Object localObject4 = (PtvTemplateManager.DoodleInfo)((Iterator)???).next();
      if (localObject4 != null)
      {
        ((PtvTemplateManager.DoodleInfo)localObject4).doodleUsable = this.this$0.a((PtvTemplateManager.DoodleInfo)localObject4, true);
        if ((((PtvTemplateManager.DoodleInfo)localObject4).doodleUsable) && (this.jdField_a_of_type_Boolean))
        {
          localObject4 = VideoSDKMaterialParser.parseVideoMaterialForEdit(PtvTemplateManager.c + ((PtvTemplateManager.DoodleInfo)localObject4).doodleName, "params");
          this.this$0.jdField_d_of_type_JavaUtilArrayList.add(localObject4);
          if (QLog.isDevelopLevel()) {
            QLog.d("Doodle_Strokes_PtvTemplateManager", 4, new Object[] { "initLocalDoodleInfo add DoodleMaterial:", ((VideoMaterial)localObject4).getId() });
          }
        }
      }
    }
    synchronized (this.this$0.jdField_d_of_type_JavaLangObject)
    {
      this.this$0.a = ((PtvTemplateManager.PtvTemplateInfo)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver.a();
      }
      if ((this.b) && (PtvFilterSoLoad.a())) {
        this.this$0.b();
      }
      PtvTemplateManager.a(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.11
 * JD-Core Version:    0.7.0.1
 */