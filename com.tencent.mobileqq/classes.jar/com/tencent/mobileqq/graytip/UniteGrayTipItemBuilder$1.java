package com.tencent.mobileqq.graytip;

import android.os.Handler;
import android.os.Looper;
import avoy;
import beqz;
import beyq;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import java.io.File;
import java.net.URL;

public class UniteGrayTipItemBuilder$1
  implements Runnable
{
  public UniteGrayTipItemBuilder$1(avoy paramavoy, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    File localFile = beqz.a(beyq.a((MessageForPic)this.a, 1, null).toString());
    if ((localFile == null) || (!localFile.exists())) {
      new Handler(Looper.getMainLooper()).post(new UniteGrayTipItemBuilder.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */