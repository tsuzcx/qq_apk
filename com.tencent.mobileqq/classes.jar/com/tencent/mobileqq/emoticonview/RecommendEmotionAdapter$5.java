package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.emoticonview.ipc.proxy.VasQuickUpdateManagerProxy;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class RecommendEmotionAdapter$5
  extends CallBacker
{
  RecommendEmotionAdapter$5(RecommendEmotionAdapter paramRecommendEmotionAdapter) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (1003L == paramLong)
    {
      if (!"emotionRecommendEffect".equals(paramString1)) {
        return;
      }
      ((VasQuickUpdateManagerProxy)this.this$0.app.getRuntimeService(IVasQuickUpdateService.class)).removeCallBacker(this.this$0.callBacker);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("emoticon Effect callBacker errorCode:");
        paramString1.append(paramInt1);
        paramString1.append(", httpCode:");
        paramString1.append(paramInt2);
        QLog.d("RecommendEmotionAdapter", 2, paramString1.toString());
      }
      paramString1 = this.this$0.mEffectLock;
      if (paramInt1 == 0) {}
      try
      {
        if ((this.this$0.mWaitToShowList != null) && (this.this$0.mWaitToShowList.size() > 0))
        {
          paramString2 = VasUpdateUtil.a(this.this$0.app.getAppRuntime(), 1003L, "emotionRecommendEffect", null, false, null);
          if (paramString2 != null)
          {
            paramInt1 = 0;
            while ((paramInt1 < this.this$0.mWaitToShowList.size()) && (paramInt1 < 2))
            {
              paramString3 = (RecommendEmotionAdapter.RecommendEffectHolder)this.this$0.mWaitToShowList.get(paramInt1);
              paramString3.effectFile = paramString2;
              this.this$0.mUiHandler.sendMessage(this.this$0.mUiHandler.obtainMessage(102, paramString3));
              paramInt1 += 1;
            }
            this.this$0.mWaitToShowList.clear();
          }
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.5
 * JD-Core Version:    0.7.0.1
 */