package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class SogouEmoji$3
  implements Runnable
{
  SogouEmoji$3(SogouEmoji paramSogouEmoji, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("func pullSingleEmojiKey begins, packId=");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append(",exprId:");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(",isNewTask:");
      ((StringBuilder)localObject1).append(this.c);
      QLog.d("SogouEmoji", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.this$0.e.syncFindEmoticonPackageById(this.a) == null)
    {
      localObject1 = this.this$0;
      ((SogouEmoji)localObject1).d = ((SogouEmoji)localObject1).h.a(this.a, this.b);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt(SogouEmoji.a, this.this$0.d);
      ((Bundle)localObject1).putString(SogouEmoji.b, this.b);
      EmojiListenerManager.a().addEmotionJsonDownloadListener(this.this$0.i);
      this.this$0.f.startDownloadEmosmJson(this.a, EmojiManagerServiceConstant.JSON_EMOSM_MALL, (Bundle)localObject1, false);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("func pullSingleEmojiKey ends, fail to search 【the pack】 from db, try get json from srv, mCurTaskId:");
        ((StringBuilder)localObject1).append(this.this$0.d);
        QLog.d("SogouEmoji", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject2 = this.this$0.e.syncFindEmoticonById(this.a, this.b);
    if (localObject2 == null)
    {
      localObject1 = this.this$0;
      ((SogouEmoji)localObject1).d = ((SogouEmoji)localObject1).h.a(this.a, this.b);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt(SogouEmoji.a, this.this$0.d);
      ((Bundle)localObject1).putString(SogouEmoji.b, this.b);
      EmojiListenerManager.a().addEmotionJsonDownloadListener(this.this$0.i);
      this.this$0.f.startDownloadEmosmJson(this.a, EmojiManagerServiceConstant.JSON_EMOSM_MALL, (Bundle)localObject1, false);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("func pullSingleEmojiKey ends, fail to search 【the emotion】 from db, try get json from srv, mCurTaskId:");
        ((StringBuilder)localObject1).append(this.this$0.d);
        QLog.d("SogouEmoji", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(localObject2);
    if (this.c)
    {
      localObject2 = this.this$0;
      ((SogouEmoji)localObject2).d = ((SogouEmoji)localObject2).h.a(this.a, this.b);
    }
    this.this$0.a(this.a, (ArrayList)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func pullSingleEmojiKey ends, everything is ok, try get keys from svr");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmoji.3
 * JD-Core Version:    0.7.0.1
 */