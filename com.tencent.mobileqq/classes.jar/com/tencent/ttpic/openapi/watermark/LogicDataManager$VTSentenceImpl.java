package com.tencent.ttpic.openapi.watermark;

import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.VTChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class LogicDataManager$VTSentenceImpl
  implements VoiceTextRecognizer.VTChangeListener
{
  private String lastWord = "";
  private String mCurrentPendingText = "";
  private String mCurrentText;
  private boolean segmentImmediately = true;
  private int segmentStart;
  private LogicDataManager.VTSentenceImpl.VoiceTextHandler vtHandler = new LogicDataManager.VTSentenceImpl.VoiceTextHandler(this, null);
  private ArrayList<String> wordCache = new ArrayList();
  private int wordCursor;
  
  private LogicDataManager$VTSentenceImpl(LogicDataManager paramLogicDataManager) {}
  
  private void onWordsComplete()
  {
    if (this.wordCache.isEmpty()) {
      return;
    }
    String str = (String)this.wordCache.get(this.wordCache.size() - 1);
    if ((LogicDataManager.access$5800(this.this$0) > 0) && (this.segmentImmediately)) {
      if (str.length() > this.segmentStart)
      {
        str = str.substring(this.segmentStart, str.length());
        if (LogicDataManager.access$5700(this.this$0) <= 0) {
          break label154;
        }
        this.vtHandler.addPendingText(str);
      }
    }
    for (;;)
    {
      this.wordCache.clear();
      this.wordCursor = 0;
      this.segmentStart = 0;
      this.lastWord = "";
      LogUtils.e(LogicDataManager.access$5600(), "mVoiceTextDup = " + LogicDataManager.access$5900(this.this$0).toString());
      return;
      label154:
      LogicDataManager.access$5900(this.this$0).add(str);
      continue;
      if ((LogicDataManager.access$5800(this.this$0) > 0) && (!this.segmentImmediately))
      {
        ArrayList localArrayList = new ArrayList();
        int k = str.length() / LogicDataManager.access$5800(this.this$0);
        if (str.length() % LogicDataManager.access$5800(this.this$0) == 0) {}
        for (int i = 0;; i = 1)
        {
          int j = 0;
          while (j < k + i)
          {
            int m = LogicDataManager.access$5800(this.this$0) * j;
            localArrayList.add(str.substring(m, Math.min(LogicDataManager.access$5800(this.this$0) + m, str.length())));
            j += 1;
          }
        }
        if (LogicDataManager.access$5700(this.this$0) > 0) {
          this.vtHandler.addPendingText(localArrayList);
        } else {
          LogicDataManager.access$5900(this.this$0).addAll(localArrayList);
        }
      }
      else if (LogicDataManager.access$5700(this.this$0) > 0)
      {
        this.vtHandler.addPendingText(str);
      }
      else
      {
        LogicDataManager.access$5900(this.this$0).add(str);
      }
    }
  }
  
  public void clearAllTexts()
  {
    this.wordCache.clear();
    this.wordCursor = 0;
    this.segmentStart = 0;
    this.lastWord = "";
    this.mCurrentPendingText = "";
    this.vtHandler.removeCallbacksAndMessages(null);
  }
  
  public String getCurrentPendingText()
  {
    return this.mCurrentPendingText;
  }
  
  public String getCurrentText()
  {
    return this.mCurrentText;
  }
  
  public void onError(int paramInt)
  {
    LogUtils.e(LogicDataManager.access$5600(), "VTSentenceImpl -> onError : " + paramInt);
  }
  
  public void onVTChanged(String paramString)
  {
    paramString = StringUtils.removeNoisyChar(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      onWordsComplete();
      return;
    }
    LogUtils.d(LogicDataManager.access$5600(), "Before verify => " + paramString);
    if (!this.lastWord.equals(paramString))
    {
      this.lastWord = paramString;
      this.wordCache.add(paramString);
      this.mCurrentText = paramString;
      for (;;)
      {
        synchronized (LogicDataManager.access$5200(this.this$0))
        {
          if (this.wordCursor >= paramString.length()) {
            break;
          }
          if (LogicDataManager.access$5700(this.this$0) > 0)
          {
            localObject2 = this.vtHandler;
            i = this.wordCursor;
            this.wordCursor = (i + 1);
            ((LogicDataManager.VTSentenceImpl.VoiceTextHandler)localObject2).addPendingChar2Queue(String.valueOf(paramString.charAt(i)));
          }
        }
        Object localObject2 = LogicDataManager.access$5200(this.this$0);
        int i = this.wordCursor;
        this.wordCursor = (i + 1);
        ((Queue)localObject2).offer(String.valueOf(paramString.charAt(i)));
      }
      LogUtils.e(LogicDataManager.access$5600(), "mVoiceTextQueue = " + LogicDataManager.access$5200(this.this$0).toString());
      if (LogicDataManager.access$5800(this.this$0) > 0)
      {
        if (this.segmentStart < paramString.length()) {
          this.mCurrentPendingText = paramString.substring(this.segmentStart, paramString.length());
        }
        if ((LogicDataManager.access$5800(this.this$0) <= 0) || (!this.segmentImmediately)) {
          break label408;
        }
        label272:
        if (this.segmentStart + LogicDataManager.access$5800(this.this$0) > paramString.length()) {
          break label374;
        }
        ??? = paramString.substring(this.segmentStart, this.segmentStart + LogicDataManager.access$5800(this.this$0));
        if (LogicDataManager.access$5700(this.this$0) <= 0) {
          break label357;
        }
        this.vtHandler.addPendingText((String)???);
      }
      for (;;)
      {
        this.segmentStart += LogicDataManager.access$5800(this.this$0);
        break label272;
        this.mCurrentPendingText = paramString;
        break;
        label357:
        LogicDataManager.access$5900(this.this$0).add(???);
      }
      label374:
      LogUtils.e(LogicDataManager.access$5600(), "mVoiceTextDup = " + LogicDataManager.access$5900(this.this$0).toString());
    }
    label408:
    this.vtHandler.judgeWordsClear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.VTSentenceImpl
 * JD-Core Version:    0.7.0.1
 */