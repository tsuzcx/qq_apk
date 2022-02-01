package com.tencent.mobileqq.magicface.drawable;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;

class PngFrameManager$3
  implements Runnable
{
  PngFrameManager$3(PngFrameManager paramPngFrameManager, String paramString, PngFrameManager.RandomDrawableParam paramRandomDrawableParam) {}
  
  public void run()
  {
    if (FileUtils.fileExists(this.jdField_a_of_type_JavaLangString))
    {
      ??? = PngGifEngine.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangObject = ???;
      synchronized (this.this$0)
      {
        if (this.this$0.jdField_a_of_type_AndroidOsHandler != null) {
          this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(227, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
        }
        return;
      }
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.getEmoticon().eId;
    ??? = new DownloadTask(EmotionPanelConstans.emoticonAIOPreviewExtensionUrl.replace("[eIdSub]", ((String)???).substring(0, 2)).replace("[eId]", (CharSequence)???).replace("[width]", "200").replace("[height]", "200"), new File(this.jdField_a_of_type_JavaLangString));
    ((DownloadTask)???).n = true;
    this.this$0.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.startDownload((DownloadTask)???, new PngFrameManager.3.1(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.3
 * JD-Core Version:    0.7.0.1
 */