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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func onEmosmBack begins, isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",type:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SogouEmoji", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean) && (paramObject != null))
    {
      if (paramInt != 3) {
        return;
      }
      localObject = (SogouEmoji)this.a.get();
      if (localObject == null)
      {
        QLog.d("SogouEmoji", 2, "WeakReference error");
        return;
      }
      paramObject = (EmoticonResp)paramObject;
      if (paramObject.data == null) {
        return;
      }
      paramObject = (ArrayList)paramObject.data;
      if (paramObject.size() == 0) {
        return;
      }
      paramBoolean = ((SogouEmoji)localObject).a.a(((SogouEmoji)localObject).b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("func onEmojiKeyBack begins, isTaskExist:");
        localStringBuilder.append(paramBoolean);
        QLog.d("SogouEmoji", 2, localStringBuilder.toString());
      }
      if (!paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SogouEmoji", 2, "func onEmojiKeyBack ends, task CANCELLED by user.");
        }
        return;
      }
      ((SogouEmoji)localObject).a((Emoticon)paramObject.get(0));
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func onEmojiKeyBack ends, Ready to send.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmoji.SogouEmoticonObserver
 * JD-Core Version:    0.7.0.1
 */