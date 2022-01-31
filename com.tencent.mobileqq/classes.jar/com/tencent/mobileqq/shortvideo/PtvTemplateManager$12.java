package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import awdy;
import awlw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class PtvTemplateManager$12
  implements Runnable
{
  PtvTemplateManager$12(PtvTemplateManager paramPtvTemplateManager, File paramFile, boolean paramBoolean, awdy paramawdy, AppInterface paramAppInterface) {}
  
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
          localObject4 = PtvTemplateManager.c + ((PtvTemplateManager.DoodleInfo)localObject4).doodleName;
          VideoMaterial localVideoMaterial = QQTemplateParser.parseVideoMaterial((String)localObject4, "params");
          if (localVideoMaterial != null)
          {
            localVideoMaterial.setDataPath((String)localObject4);
            this.this$0.jdField_d_of_type_JavaUtilArrayList.add(localVideoMaterial);
            if (QLog.isDevelopLevel()) {
              QLog.d("Doodle_Strokes_PtvTemplateManager", 4, new Object[] { "initLocalDoodleInfo add DoodleMaterial:", localVideoMaterial.getId() });
            }
          }
        }
      }
    }
    synchronized (this.this$0.jdField_d_of_type_JavaLangObject)
    {
      this.this$0.a = ((PtvTemplateManager.PtvTemplateInfo)localObject1);
      if (this.jdField_a_of_type_Awdy != null) {
        this.jdField_a_of_type_Awdy.a();
      }
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) && (awlw.c())) {
        this.this$0.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      PtvTemplateManager.a(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.12
 * JD-Core Version:    0.7.0.1
 */