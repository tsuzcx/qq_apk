package com.tencent.mobileqq.qqexpand.ipc;

import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandEmotionHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ExpandFlutterIPCServer$7
  implements Runnable
{
  ExpandFlutterIPCServer$7(ExpandFlutterIPCServer paramExpandFlutterIPCServer, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.a.getStringArrayList("data");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = new HashMap(ExpandEmotionHelper.a((List)localObject1));
      localObject2 = new Gson().toJson(localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("data", (String)localObject2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get sys emoj file path ");
        localStringBuilder.append((String)localObject2);
        QLog.d("expand.ipc.ExpandFlutterIPCServer", 1, localStringBuilder.toString());
      }
      localObject2 = new EIPCResult();
      ((EIPCResult)localObject2).data = ((Bundle)localObject1);
      this.this$0.callbackResult(this.b, (EIPCResult)localObject2);
      return;
    }
    QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "METHOD_GET_SYS_EMOJI_FILE_PATHparams error");
    localObject1 = new EIPCResult();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("data", "");
    ((EIPCResult)localObject1).data = ((Bundle)localObject2);
    this.this$0.callbackResult(this.b, (EIPCResult)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.7
 * JD-Core Version:    0.7.0.1
 */