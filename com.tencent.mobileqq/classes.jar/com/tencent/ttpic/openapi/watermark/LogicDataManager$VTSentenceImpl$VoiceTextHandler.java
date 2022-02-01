package com.tencent.ttpic.openapi.watermark;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

@SuppressLint({"HandlerLeak"})
class LogicDataManager$VTSentenceImpl$VoiceTextHandler
  extends Handler
{
  private final int CHAR_ADD = 4;
  private final int WORDS_ADD = 3;
  private final int WORDS_CLEAR = 2;
  private final int WORDS_OVER = 1;
  private long lastCharAt = 0L;
  private long lastWordAt = 0L;
  
  private LogicDataManager$VTSentenceImpl$VoiceTextHandler(LogicDataManager.VTSentenceImpl paramVTSentenceImpl) {}
  
  public void addPendingChar2Queue(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 > this.lastCharAt + LogicDataManager.access$5700(this.this$1.this$0))
    {
      this.lastCharAt = l1;
      sendMessage(obtainMessage(4, paramString));
      return;
    }
    long l2 = this.lastCharAt + LogicDataManager.access$5700(this.this$1.this$0) - l1;
    this.lastCharAt = (l1 + l2);
    sendMessageDelayed(obtainMessage(4, paramString), l2);
  }
  
  public void addPendingText(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 > this.lastWordAt + LogicDataManager.access$5700(this.this$1.this$0))
    {
      this.lastWordAt = l1;
      sendMessage(obtainMessage(3, paramString));
      return;
    }
    long l2 = this.lastWordAt + LogicDataManager.access$5700(this.this$1.this$0) - l1;
    this.lastWordAt = (l1 + l2);
    sendMessageDelayed(obtainMessage(3, paramString), l2);
  }
  
  public void addPendingText(ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      addPendingText((String)paramArrayList.next());
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        LogicDataManager.VTSentenceImpl.access$6100(this.this$1);
        return;
        this.this$1.this$0.clearVoiceTexts();
      } while (LogicDataManager.access$6200(this.this$1.this$0) == null);
      LogicDataManager.access$6200(this.this$1.this$0).onSilenceTimeEvent();
      return;
    case 3: 
      LogicDataManager.access$5900(this.this$1.this$0).add((String)paramMessage.obj);
      LogUtils.e(LogicDataManager.access$5600(), "mVoiceTextDup = " + LogicDataManager.access$5900(this.this$1.this$0).toString());
      return;
    }
    synchronized (LogicDataManager.access$5200(this.this$1.this$0))
    {
      LogicDataManager.access$5200(this.this$1.this$0).offer((String)paramMessage.obj);
      LogUtils.e(LogicDataManager.access$5600(), "mVoiceTextQueue = " + LogicDataManager.access$5200(this.this$1.this$0).toString());
      return;
    }
  }
  
  public void judgeWordsClear()
  {
    if (LogicDataManager.access$6000(this.this$1.this$0) <= 10) {
      return;
    }
    removeMessages(2);
    sendMessageDelayed(obtainMessage(2), LogicDataManager.access$6000(this.this$1.this$0));
  }
  
  @Deprecated
  public void judgeWordsOver()
  {
    removeMessages(1);
    sendMessageDelayed(obtainMessage(1), 400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.VTSentenceImpl.VoiceTextHandler
 * JD-Core Version:    0.7.0.1
 */