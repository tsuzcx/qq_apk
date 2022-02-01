package com.tencent.mobileqq.magicface.drawable;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class PngFrameManager$4$1
  extends DownloadListener
{
  PngFrameManager$4$1(PngFrameManager.4 param4, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【pngZip】");
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0.a != null) {
        if (paramDownloadTask.a() != 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0.a.obtainMessage(226, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.a).sendToTarget();
        }
        else
        {
          try
          {
            FileUtils.uncompressZip(this.jdField_a_of_type_JavaLangString, EmotionPanelConstans.pngFramePath.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.a.jdField_a_of_type_JavaLangString), false);
          }
          catch (IOException paramDownloadTask)
          {
            paramDownloadTask.printStackTrace();
          }
          new File(this.jdField_a_of_type_JavaLangString).delete();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0.b(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.getEmoticon().epId);
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0.a.obtainMessage(225, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.a).sendToTarget();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.4.1
 * JD-Core Version:    0.7.0.1
 */