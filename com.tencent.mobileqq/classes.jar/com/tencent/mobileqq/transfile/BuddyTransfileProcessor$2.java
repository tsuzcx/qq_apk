package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import bdnl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;

class BuddyTransfileProcessor$2
  implements Runnable
{
  BuddyTransfileProcessor$2(BuddyTransfileProcessor paramBuddyTransfileProcessor, String paramString, short paramShort, long paramLong, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    FileMsg localFileMsg;
    if ((bdnl.b(this.this$0.file.filePath) != 0) && (!this.this$0.setPttRecordFinishTime))
    {
      localFileMsg = this.this$0.file;
      BuddyTransfileProcessor localBuddyTransfileProcessor = this.this$0;
      long l = System.nanoTime();
      localBuddyTransfileProcessor.mStartTime = l;
      localFileMsg.startTime = l;
      this.this$0.setPttRecordFinishTime = true;
    }
    this.this$0.app.getMsgHandler().a(this.val$selfUin, BuddyTransfileProcessor.access$100(this.this$0), this.this$0.file.filePath, this.val$shPackSeq, BuddyTransfileProcessor.access$200(this.this$0), BuddyTransfileProcessor.access$300(this.this$0), this.this$0.voiceType, this.this$0.voiceLength, this.val$subBubbleId, this.val$params);
    this.this$0.app.sendAppDataIncerment(this.this$0.app.getAccount(), true, NetworkUtil.getNetworkType(this.this$0.app.getApp()), 2, 0, bdnl.a(this.this$0.file.filePath, this.val$shPackSeq));
    if (!this.val$isresend)
    {
      localFileMsg = this.this$0.file;
      localFileMsg.transferedSize += bdnl.a(this.this$0.file.filePath, this.val$shPackSeq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.2
 * JD-Core Version:    0.7.0.1
 */