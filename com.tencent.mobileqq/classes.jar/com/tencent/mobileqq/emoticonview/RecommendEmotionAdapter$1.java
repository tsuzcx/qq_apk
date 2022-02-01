package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class RecommendEmotionAdapter$1
  implements Runnable
{
  RecommendEmotionAdapter$1(RecommendEmotionAdapter paramRecommendEmotionAdapter, RecommendEmotionAdapter.RecommendEffectHolder paramRecommendEffectHolder) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (this.this$0.mEffectLock)
      {
        Object localObject2 = this.this$0.app.getAppRuntime();
        Object localObject4 = this.this$0.mDownloadEffect;
        i = 1;
        localObject2 = VasUpdateUtil.a((AppRuntime)localObject2, 1003L, "emotionRecommendEffect", null, ((AtomicBoolean)localObject4).compareAndSet(false, true), this.this$0.callBacker);
        if (localObject2 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("emoticon Effect effectFile = null, id:");
            ((StringBuilder)localObject4).append(this.val$rHolder.recommendPkg.id);
            ((StringBuilder)localObject4).append(", index:");
            ((StringBuilder)localObject4).append(this.val$rHolder.index);
            QLog.d("RecommendEmotionAdapter", 2, ((StringBuilder)localObject4).toString());
          }
          if (this.this$0.mWaitToShowList == null) {
            this.this$0.mWaitToShowList = new ArrayList();
          }
          if (this.this$0.mWaitToShowList.size() > 0)
          {
            i = ((RecommendEmotionAdapter.RecommendEffectHolder)this.this$0.mWaitToShowList.get(0)).index;
            if (this.val$rHolder.index < i)
            {
              this.this$0.mWaitToShowList.add(0, this.val$rHolder);
              break label362;
            }
            this.this$0.mWaitToShowList.add(this.val$rHolder);
            break label362;
          }
        }
        else
        {
          if (i != 0)
          {
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("emoticon Effect postShow, id:");
              ((StringBuilder)localObject4).append(this.val$rHolder.recommendPkg.id);
              ((StringBuilder)localObject4).append(", index:");
              ((StringBuilder)localObject4).append(this.val$rHolder.index);
              QLog.d("RecommendEmotionAdapter", 2, ((StringBuilder)localObject4).toString());
            }
            this.val$rHolder.effectFile = ((File)localObject2);
            this.this$0.mUiHandler.sendMessage(this.this$0.mUiHandler.obtainMessage(102, this.val$rHolder));
          }
          return;
        }
      }
      int i = -1;
      continue;
      label362:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */