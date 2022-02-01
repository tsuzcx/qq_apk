package com.tencent.mobileqq.emosm.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

class EmoticonManagerServiceImpl$19
  implements Runnable
{
  EmoticonManagerServiceImpl$19(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, RecentEmotion paramRecentEmotion) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addRecentEmotionToCache key = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    String str = this.a.keyword;
    if (TextUtils.isEmpty(str))
    {
      QLog.e("EmoticonManager", 1, "addRecentEmotionToCache keyword empty");
      return;
    }
    Object localObject = this.a;
    CopyOnWriteArrayList localCopyOnWriteArrayList = EmoticonManagerServiceImpl.access$400(this.this$0, str);
    if (localCopyOnWriteArrayList != null)
    {
      int i = localCopyOnWriteArrayList.indexOf(this.a);
      if (i > -1)
      {
        localObject = (RecentEmotion)localCopyOnWriteArrayList.get(i);
        ((RecentEmotion)localObject).replace(this.a);
      }
      else
      {
        localCopyOnWriteArrayList.add(this.a);
      }
    }
    else
    {
      localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      localCopyOnWriteArrayList.add(this.a);
      this.this$0.recentEmotionData.put(str, localCopyOnWriteArrayList);
    }
    this.this$0.needToDBRecentEmotion.remove(localObject);
    this.this$0.needToDBRecentEmotion.add(0, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.19
 * JD-Core Version:    0.7.0.1
 */