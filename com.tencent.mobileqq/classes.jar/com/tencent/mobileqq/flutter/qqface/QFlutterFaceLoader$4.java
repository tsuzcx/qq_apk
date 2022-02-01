package com.tencent.mobileqq.flutter.qqface;

import android.os.Handler.Callback;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class QFlutterFaceLoader$4
  implements Handler.Callback
{
  QFlutterFaceLoader$4(QFlutterFaceLoader paramQFlutterFaceLoader) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (List)paramMessage.obj;
      QFlutterFaceLoader.a(this.a, paramMessage);
      continue;
      paramMessage = QFlutterFaceLoader.a(this.a).keySet().iterator();
      while (paramMessage.hasNext())
      {
        Integer localInteger = (Integer)paramMessage.next();
        ArrayList localArrayList = (ArrayList)QFlutterFaceLoader.a(this.a).get(localInteger);
        QFlutterFaceLoader.a(this.a, new ArrayList(localArrayList), localInteger.intValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader.4
 * JD-Core Version:    0.7.0.1
 */