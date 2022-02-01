package com.tencent.mobileqq.flutter.qqface;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QFlutterFaceLoader$1
  extends BroadcastReceiver
{
  QFlutterFaceLoader$1(QFlutterFaceLoader paramQFlutterFaceLoader) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!"com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())) {
        return;
      }
      int j = paramIntent.getIntExtra("faceType", -1);
      paramContext = paramIntent.getStringArrayListExtra("uinList");
      paramIntent = paramIntent.getStringArrayListExtra("headPathList");
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceive, faceType: ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", uinList: ");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append(", pathList: ");
        ((StringBuilder)localObject).append(paramIntent);
        QLog.d("QFlutter.qqface", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramContext != null) && (!paramContext.isEmpty()) && (paramIntent != null) && (!paramIntent.isEmpty()) && (paramContext.size() == paramIntent.size()))
      {
        localObject = new ArrayList();
        int i = 0;
        while (i < paramContext.size())
        {
          String str1 = (String)paramIntent.get(i);
          String str2 = (String)paramContext.get(i);
          DecodeRequest localDecodeRequest = new DecodeRequest(j, str2, 3);
          if (QFlutterFaceLoader.a(this.a, localDecodeRequest))
          {
            QFlutterFaceLoader.a(this.a, j, str2);
            ((ArrayList)localObject).add(localDecodeRequest);
            QFlutterFaceLoader.a(this.a).put(localDecodeRequest.c, str1);
          }
          i += 1;
        }
        if (!((ArrayList)localObject).isEmpty())
        {
          paramContext = QFlutterFaceLoader.a(this.a).obtainMessage(0);
          paramContext.obj = localObject;
          QFlutterFaceLoader.a(this.a).sendMessage(paramContext);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader.1
 * JD-Core Version:    0.7.0.1
 */