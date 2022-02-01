package com.tencent.mobileqq.emosm.favroaming;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.widget.QQToast;

class EmoticonFromGroupManager$1
  implements Handler.Callback
{
  EmoticonFromGroupManager$1(EmoticonFromGroupManager paramEmoticonFromGroupManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return true;
      }
      if (paramMessage.obj != null)
      {
        paramMessage = (EmoticonFromGroupEntity)paramMessage.obj;
        this.a.a(paramMessage);
        return true;
      }
      QQToast.a(EmoticonFromGroupManager.a(this.a), 1, 2131689646, 0).b(2131299168);
      return true;
    }
    QQToast.a(EmoticonFromGroupManager.a(this.a), 2131692690, 0).b(2131299168);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.1
 * JD-Core Version:    0.7.0.1
 */