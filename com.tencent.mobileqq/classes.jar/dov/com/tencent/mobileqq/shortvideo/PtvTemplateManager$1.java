package dov.com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class PtvTemplateManager$1
  implements Runnable
{
  PtvTemplateManager$1(PtvTemplateManager paramPtvTemplateManager, File paramFile, PtvTemplateManager.DoodleInfoLoadObserver paramDoodleInfoLoadObserver, AppInterface paramAppInterface) {}
  
  public void run()
  {
    Object localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_JavaIoFile);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    do
    {
      return;
      localObject1 = PtvTemplateManager.a((String)localObject1);
    } while ((localObject1 == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos.isEmpty()));
    ??? = ((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos.iterator();
    int i = 0;
    label52:
    if (((Iterator)???).hasNext())
    {
      PtvTemplateManager.DoodleInfo localDoodleInfo = (PtvTemplateManager.DoodleInfo)((Iterator)???).next();
      if (localDoodleInfo == null) {
        break label194;
      }
      localDoodleInfo.doodleUsable = this.this$0.a(localDoodleInfo, true);
      if ((i != 0) || (localDoodleInfo.doodleUsable)) {
        i = 1;
      }
    }
    label194:
    for (;;)
    {
      for (;;)
      {
        break label52;
        i = 0;
        continue;
        synchronized (PtvTemplateManager.a())
        {
          PtvTemplateManager.a(this.this$0, (PtvTemplateManager.PtvTemplateInfo)localObject1);
          if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver != null) {
            this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver.a();
          }
          if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
          {
            if (!PtvFilterSoLoad.a()) {
              break;
            }
            PtvTemplateManager.a(this.this$0, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
            return;
          }
        }
      }
      if (i == 0) {
        break;
      }
      this.this$0.a(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.1
 * JD-Core Version:    0.7.0.1
 */