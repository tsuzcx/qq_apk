package com.tencent.mobileqq.colornote;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import mqq.util.WeakReference;

class ColorNoteDataMsgHandler
  extends Handler
{
  private WeakReference<ColorNoteCurd> a;
  
  ColorNoteDataMsgHandler(ColorNoteCurd paramColorNoteCurd)
  {
    this.a = new WeakReference(paramColorNoteCurd);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = (ColorNoteCurd)this.a.get();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((ColorNoteCurd)localObject1).a();
    int i = paramMessage.what;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    Object localObject2;
    switch (i)
    {
    case 7: 
    case 8: 
    default: 
      return;
    case 10: 
    case 11: 
      if ((localObject1 != null) && (paramMessage.obj != null))
      {
        localObject2 = (ColorNote)paramMessage.obj;
        if (paramMessage.what != 10) {
          bool1 = false;
        }
        ((OnColorNoteCurdListener)localObject1).onUpdateColorNote((ColorNote)localObject2, bool1);
        return;
      }
      break;
    case 9: 
      if ((localObject1 != null) && (paramMessage.obj != null))
      {
        paramMessage = (Bundle)paramMessage.obj;
        ((OnColorNoteCurdListener)localObject1).onUpdateColorNoteState(paramMessage.getInt("key_service_type"), paramMessage.getString("key_sub_type"), paramMessage);
        return;
      }
      break;
    case 5: 
    case 6: 
      if (localObject1 == null) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = (Pair)paramMessage.obj;
        i = ((Integer)((Pair)localObject2).first).intValue();
        localObject2 = (String)((Pair)localObject2).second;
        if (paramMessage.what == 5) {
          break label297;
        }
        bool1 = bool2;
        ((OnColorNoteCurdListener)localObject1).onDeleteColorNote(i, (String)localObject2, bool1);
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("ColorNoteHandler", 2, paramMessage, new Object[0]);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        QLog.e("ColorNoteHandler", 2, paramMessage, new Object[0]);
        return;
      }
      if (localObject1 != null)
      {
        localObject2 = (Bundle)paramMessage.obj;
        if (paramMessage.what == 3) {
          bool1 = bool3;
        } else {
          bool1 = false;
        }
        ((OnColorNoteCurdListener)localObject1).onAddColorNote((Bundle)localObject2, bool1);
      }
      return;
      label297:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteDataMsgHandler
 * JD-Core Version:    0.7.0.1
 */