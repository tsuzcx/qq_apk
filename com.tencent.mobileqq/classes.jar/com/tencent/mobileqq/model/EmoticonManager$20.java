package com.tencent.mobileqq.model;

import android.text.TextUtils;
import askf;
import aukp;
import aukr;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonManager$20
  implements Runnable
{
  public EmoticonManager$20(askf paramaskf, List paramList) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    aukr localaukr = this.this$0.a.a();
    for (;;)
    {
      int i;
      try
      {
        localaukr.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveRecentEmotionToDB:");
        i = this.a.size() - 1;
        if (i >= 0)
        {
          RecentEmotion localRecentEmotion1 = (RecentEmotion)this.a.get(i);
          if (localRecentEmotion1 == null) {
            break label364;
          }
          String str1 = localRecentEmotion1.epId;
          String str2 = localRecentEmotion1.eId;
          String str3 = localRecentEmotion1.keyword;
          localStringBuilder.append("emotion=").append(localRecentEmotion1);
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
            break label364;
          }
          RecentEmotion localRecentEmotion2 = (RecentEmotion)this.this$0.a.a(RecentEmotion.class, "epId=? and eId=? and keyword=?", new String[] { str1, str2, str3 });
          RecentEmotion localRecentEmotion3 = new RecentEmotion();
          localRecentEmotion3.epId = str1;
          localRecentEmotion3.eId = str2;
          localRecentEmotion3.keyword = str3;
          localRecentEmotion3.exposeNum = localRecentEmotion1.exposeNum;
          localRecentEmotion3.setStatus(1000);
          if (localRecentEmotion2 != null) {
            this.this$0.a.b(localRecentEmotion2);
          }
          askf.a(this.this$0, localRecentEmotion3);
        }
      }
      catch (Exception localException)
      {
        QLog.e("EmoticonManager", 2, "saveRecentEmotionToDB e = " + localException.getMessage());
        localaukr.b();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, "saveRecentEmotionToDB_Time: " + (System.currentTimeMillis() - l));
        }
        return;
        localaukr.c();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, localException.toString());
        }
        localaukr.b();
        continue;
      }
      finally
      {
        localaukr.b();
      }
      label364:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.20
 * JD-Core Version:    0.7.0.1
 */