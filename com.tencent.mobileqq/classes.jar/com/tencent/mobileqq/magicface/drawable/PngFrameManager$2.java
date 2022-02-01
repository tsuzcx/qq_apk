package com.tencent.mobileqq.magicface.drawable;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import java.io.File;

class PngFrameManager$2
  implements Runnable
{
  PngFrameManager$2(PngFrameManager paramPngFrameManager, PngFrameManager.RandomDrawableParam paramRandomDrawableParam) {}
  
  public void run()
  {
    File localFile = new File(EmotionPanelConstans.emoticonJsonFilePath.replace("[epId]", this.a.jdField_a_of_type_JavaLangString));
    IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
    ??? = localIEmoticonManagerService.syncFindEmoticonPackageById(this.a.jdField_a_of_type_JavaLangString);
    Object localObject1 = ???;
    if (??? == null)
    {
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = this.a.jdField_a_of_type_JavaLangString;
      ((EmoticonPackage)localObject1).aio = true;
    }
    synchronized (this.this$0)
    {
      if (this.this$0.jdField_a_of_type_AndroidOsHandler != null) {
        if (localFile.exists())
        {
          this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil.a(localFile);
          this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
          ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
          localIEmoticonManagerService.saveEmoticonPackage((EmoticonPackage)localObject1);
        }
        else
        {
          DownloadTask localDownloadTask = new DownloadTask(EmoticonPanelUtils.a(this.a.jdField_a_of_type_JavaLangString), localFile);
          localDownloadTask.j = true;
          if ((DownloaderFactory.a(localDownloadTask, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) && (this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil != null) && (this.this$0.jdField_a_of_type_AndroidOsHandler != null))
          {
            this.a.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil.a(localFile);
            ((EmoticonPackage)localObject1).rscType = this.a.jdField_a_of_type_Int;
            localIEmoticonManagerService.saveEmoticonPackage((EmoticonPackage)localObject1);
            this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(224, this.a).sendToTarget();
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.2
 * JD-Core Version:    0.7.0.1
 */