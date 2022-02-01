package com.tencent.mobileqq.flutter.qqface;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class QFlutterFaceLoader$2
  extends BroadcastReceiver
{
  QFlutterFaceLoader$2(QFlutterFaceLoader paramQFlutterFaceLoader) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!"com.tencent.qqhead.changed".equals(paramIntent.getAction())) {
        return;
      }
      paramContext = paramIntent.getStringExtra("uin");
      int k = paramIntent.getIntExtra("faceType", -1);
      int j = 0;
      QLog.i("QFlutter.qqface", 1, String.format("mQQFaceChangeReceiver.onReceive uin=%s", new Object[] { paramContext }));
      if (!TextUtils.isEmpty(paramContext))
      {
        paramIntent = DecodeRequest.a(k, paramContext);
        int m = paramIntent.length;
        int i = 0;
        while (i < m)
        {
          Object localObject = paramIntent[i];
          QFlutterFaceLoader.c(this.a).remove(localObject);
          i += 1;
        }
        paramContext = DecodeRequest.b(k, paramContext);
        k = paramContext.length;
        i = j;
        while (i < k)
        {
          paramIntent = paramContext[i];
          QFlutterFaceLoader.a(this.a).remove(paramIntent);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader.2
 * JD-Core Version:    0.7.0.1
 */