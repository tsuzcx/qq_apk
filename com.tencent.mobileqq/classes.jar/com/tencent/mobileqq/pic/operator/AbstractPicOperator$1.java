package com.tencent.mobileqq.pic.operator;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack;
import java.util.ArrayList;

class AbstractPicOperator$1
  extends Handler
{
  AbstractPicOperator$1(AbstractPicOperator paramAbstractPicOperator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = this.a.b;
    String str = this.a.a;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("what:");
    ((StringBuilder)localObject3).append(paramMessage.what);
    ((StringBuilder)localObject3).append(",result:");
    ((StringBuilder)localObject3).append(paramMessage.arg1);
    ((StringBuilder)localObject3).append(",obj:");
    ((StringBuilder)localObject3).append(paramMessage.obj);
    Logger.a((String)localObject1, str, "dispatchMessage", ((StringBuilder)localObject3).toString());
    if (this.a.d == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 6: 
      paramMessage = (PicResult)paramMessage.obj;
      this.a.d.a(((Integer)paramMessage.d).intValue());
      return;
    case 5: 
      localObject3 = paramMessage.obj;
      str = null;
      localObject1 = str;
      if (localObject3 == null) {
        break;
      }
    }
    try
    {
      localObject1 = (ArrayList)paramMessage.obj;
      this.a.d.a(paramMessage.arg1, (ArrayList)localObject1);
      return;
      int i = paramMessage.arg1;
      paramMessage = (PicResult)paramMessage.obj;
      this.a.d.d(i, paramMessage);
      return;
      i = paramMessage.arg1;
      paramMessage = (PicResult)paramMessage.obj;
      this.a.d.c(i, paramMessage);
      return;
      i = paramMessage.arg1;
      paramMessage = (PicResult)paramMessage.obj;
      this.a.d.b(i, paramMessage);
      return;
      paramMessage = (PicResult)paramMessage.obj;
      if ((paramMessage.d instanceof Integer))
      {
        this.a.d.a_(((Integer)paramMessage.d).intValue(), paramMessage.g);
        return;
        i = paramMessage.arg1;
        paramMessage = (PicResult)paramMessage.obj;
        this.a.d.a(i, paramMessage);
      }
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        Object localObject2 = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.AbstractPicOperator.1
 * JD-Core Version:    0.7.0.1
 */