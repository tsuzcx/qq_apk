package com.tencent.mobileqq.model;

import aufn;
import awgf;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

public class EmoticonManager$6
  implements Runnable
{
  public EmoticonManager$6(aufn paramaufn, String paramString1, String paramString2) {}
  
  public void run()
  {
    Emoticon localEmoticon = (Emoticon)this.this$0.a.a(Emoticon.class, "epId=? and eId=?", new String[] { this.a, this.b });
    if (localEmoticon != null)
    {
      this.this$0.b.put(localEmoticon.getMapKey(), localEmoticon);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "hit db, put into cache");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.6
 * JD-Core Version:    0.7.0.1
 */