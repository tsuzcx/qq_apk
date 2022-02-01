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
        this.a.d(paramMessage);
        return true;
      }
      QQToast.makeText(EmoticonFromGroupManager.a(this.a), 1, 2131886257, 0).show(2131299920);
      return true;
    }
    QQToast.makeText(EmoticonFromGroupManager.a(this.a), 2131889761, 0).show(2131299920);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.1
 * JD-Core Version:    0.7.0.1
 */