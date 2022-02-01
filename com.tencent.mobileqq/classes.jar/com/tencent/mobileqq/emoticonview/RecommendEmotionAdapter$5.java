package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class RecommendEmotionAdapter$5
  extends VasQuickUpdateManager.CallBacker
{
  RecommendEmotionAdapter$5(RecommendEmotionAdapter paramRecommendEmotionAdapter) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((1003L != paramLong) || (!"emotionRecommendEffect".equals(paramString1))) {
      return;
    }
    if (this.this$0.app != null) {
      ((VasQuickUpdateManager)this.this$0.app.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).removeCallBacker(this.this$0.callBacker);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect callBacker errorCode:" + paramInt1 + ", httpCode:" + paramInt2 + ", apngSoLoaded:" + VasApngIPCModule.getInstance().isLoaded());
    }
    paramString1 = this.this$0.mEffectLock;
    if (paramInt1 == 0) {}
    try
    {
      if ((this.this$0.mWaitToShowList != null) && (this.this$0.mWaitToShowList.size() > 0))
      {
        paramString2 = VasQuickUpdateManager.getFileFromLocal(this.this$0.app, 1003L, "emotionRecommendEffect", null, false, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.5
 * JD-Core Version:    0.7.0.1
 */