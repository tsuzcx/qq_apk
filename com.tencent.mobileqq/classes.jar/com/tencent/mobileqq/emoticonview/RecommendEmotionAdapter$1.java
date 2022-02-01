package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

class RecommendEmotionAdapter$1
  implements Runnable
{
  RecommendEmotionAdapter$1(RecommendEmotionAdapter paramRecommendEmotionAdapter, RecommendEmotionAdapter.RecommendEffectHolder paramRecommendEffectHolder) {}
  
  public void run()
  {
    for (int i = 1;; i = -1) {
      synchronized (this.this$0.mEffectLock)
      {
        File localFile = VasUpdateUtil.a(this.this$0.app.getAppRuntime(), 1003L, "emotionRecommendEffect", null, this.this$0.mDownloadEffect.compareAndSet(false, true), this.this$0.callBacker);
        if (localFile == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect effectFile = null, id:" + this.val$rHolder.recommendPkg.id + ", index:" + this.val$rHolder.index);
          }
          if (this.this$0.mWaitToShowList == null) {
            this.this$0.mWaitToShowList = new ArrayList();
          }
          if (this.this$0.mWaitToShowList.size() <= 0) {
            continue;
          }
          i = ((RecommendEmotionAdapter.RecommendEffectHolder)this.this$0.mWaitToShowList.get(0)).index;
          if (this.val$rHolder.index < i)
          {
            this.this$0.mWaitToShowList.add(0, this.val$rHolder);
            i = 0;
          }
        }
        else
        {
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect postShow, id:" + this.val$rHolder.recommendPkg.id + ", index:" + this.val$rHolder.index);
            }
            this.val$rHolder.effectFile = localFile;
            this.this$0.mUiHandler.sendMessage(this.this$0.mUiHandler.obtainMessage(102, this.val$rHolder));
          }
          return;
        }
        this.this$0.mWaitToShowList.add(this.val$rHolder);
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */