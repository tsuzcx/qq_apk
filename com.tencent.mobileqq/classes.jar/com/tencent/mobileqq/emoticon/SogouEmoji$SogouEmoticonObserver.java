package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class SogouEmoji$SogouEmoticonObserver
  extends EmoticonObserver
{
  final WeakReference<SogouEmoji> a;
  
  public SogouEmoji$SogouEmoticonObserver(SogouEmoji paramSogouEmoji)
  {
    this.a = new WeakReference(paramSogouEmoji);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func onEmosmBack begins, isSuccess:" + paramBoolean + ",type:" + paramInt);
    }
    if ((!paramBoolean) || (paramObject == null) || (paramInt != 3)) {}
    do
    {
      SogouEmoji localSogouEmoji;
      do
      {
        do
        {
          do
          {
            return;
            localSogouEmoji = (SogouEmoji)this.a.get();
            if (localSogouEmoji == null)
            {
              QLog.d("SogouEmoji", 2, "WeakReference error");
              return;
            }
            paramObject = (EmoticonResp)paramObject;
          } while (paramObject.data == null);
          paramObject = (ArrayList)paramObject.data;
        } while (paramObject.size() == 0);
        paramBoolean = localSogouEmoji.a.a(localSogouEmoji.b);
        if (QLog.isColorLevel()) {
          QLog.d("SogouEmoji", 2, "func onEmojiKeyBack begins, isTaskExist:" + paramBoolean);
        }
        if (paramBoolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SogouEmoji", 2, "func onEmojiKeyBack ends, task CANCELLED by user.");
      return;
      localSogouEmoji.a((Emoticon)paramObject.get(0));
    } while (!QLog.isColorLevel());
    QLog.d("SogouEmoji", 2, "func onEmojiKeyBack ends, Ready to send.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmoji.SogouEmoticonObserver
 * JD-Core Version:    0.7.0.1
 */