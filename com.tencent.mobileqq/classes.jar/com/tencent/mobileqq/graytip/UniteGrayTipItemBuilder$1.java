package com.tencent.mobileqq.graytip;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.io.File;
import java.net.URL;

class UniteGrayTipItemBuilder$1
  implements Runnable
{
  UniteGrayTipItemBuilder$1(UniteGrayTipItemBuilder paramUniteGrayTipItemBuilder, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    File localFile = AbsDownloader.getFile(URLDrawableHelper.getURL((MessageForPic)this.a, 1, null).toString());
    if ((localFile == null) || (!localFile.exists())) {
      new Handler(Looper.getMainLooper()).post(new UniteGrayTipItemBuilder.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */