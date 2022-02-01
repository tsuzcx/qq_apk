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
    synchronized (this.b.this$0)
    {
      if (this.b.this$0.e != null) {
        if (paramDownloadTask.e() != 3)
        {
          this.b.this$0.e.obtainMessage(226, this.b.a).sendToTarget();
        }
        else
        {
          try
          {
            FileUtils.uncompressZip(this.a, EmotionPanelConstans.pngFramePath.replace("[epId]", this.b.a.d), false);
          }
          catch (IOException paramDownloadTask)
          {
            paramDownloadTask.printStackTrace();
          }
          new File(this.a).delete();
          this.b.this$0.b(this.b.a.c.a.getEmoticon().epId);
          this.b.this$0.e.obtainMessage(225, this.b.a).sendToTarget();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.4.1
 * JD-Core Version:    0.7.0.1
 */