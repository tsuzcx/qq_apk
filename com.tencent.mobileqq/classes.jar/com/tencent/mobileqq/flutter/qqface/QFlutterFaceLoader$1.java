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
    if ((paramIntent == null) || (!"com.tencent.qqhead.getheadresp".equals(paramIntent.getAction()))) {}
    do
    {
      int j;
      ArrayList localArrayList;
      do
      {
        return;
        j = paramIntent.getIntExtra("faceType", -1);
        paramContext = paramIntent.getStringArrayListExtra("uinList");
        localArrayList = paramIntent.getStringArrayListExtra("headPathList");
        if (QLog.isColorLevel()) {
          QLog.d("QFlutter.qqface", 2, "onReceive, faceType: " + j + ", uinList: " + paramContext + ", pathList: " + localArrayList);
        }
      } while ((paramContext == null) || (paramContext.isEmpty()) || (localArrayList == null) || (localArrayList.isEmpty()) || (paramContext.size() != localArrayList.size()));
      paramIntent = new ArrayList();
      int i = 0;
      while (i < paramContext.size())
      {
        String str1 = (String)localArrayList.get(i);
        String str2 = (String)paramContext.get(i);
        DecodeRequest localDecodeRequest = new DecodeRequest(j, str2, 3);
        if (QFlutterFaceLoader.a(this.a, localDecodeRequest))
        {
          QFlutterFaceLoader.a(this.a, j, str2);
          paramIntent.add(localDecodeRequest);
          QFlutterFaceLoader.a(this.a).put(localDecodeRequest.c, str1);
        }
        i += 1;
      }
    } while (paramIntent.isEmpty());
    paramContext = QFlutterFaceLoader.a(this.a).obtainMessage(0);
    paramContext.obj = paramIntent;
    QFlutterFaceLoader.a(this.a).sendMessage(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader.1
 * JD-Core Version:    0.7.0.1
 */