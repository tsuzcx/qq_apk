package com.tencent.mobileqq.profilecard.bussiness.stickynote;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class QzoneStickyNoteManager$3
  implements InvocationHandler
{
  QzoneStickyNoteManager$3(QzoneStickyNoteManager paramQzoneStickyNoteManager) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    boolean bool;
    if ("onLoad".equals(paramObject))
    {
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 2))
      {
        int i = ((Integer)paramArrayOfObject[0]).intValue();
        bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
        QzoneStickyNoteManager.access$600(this.this$0, i, bool);
      }
    }
    else if (("onLoadFinish".equals(paramObject)) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1))
    {
      bool = ((Boolean)paramArrayOfObject[0]).booleanValue();
      QzoneStickyNoteManager.access$700(this.this$0, bool);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.stickynote.QzoneStickyNoteManager.3
 * JD-Core Version:    0.7.0.1
 */