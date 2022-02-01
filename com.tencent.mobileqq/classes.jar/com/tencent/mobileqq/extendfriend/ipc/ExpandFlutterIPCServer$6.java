package com.tencent.mobileqq.extendfriend.ipc;

import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.mobileqq.flutter.channel.expand.chat.ExpandEmotionHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ExpandFlutterIPCServer$6
  implements Runnable
{
  ExpandFlutterIPCServer$6(ExpandFlutterIPCServer paramExpandFlutterIPCServer, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("data");
    if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
    {
      QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "METHOD_GET_SYS_EMOJI_FILE_PATHparams error");
      localObject1 = new EIPCResult();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("data", "");
      ((EIPCResult)localObject1).data = ((Bundle)localObject2);
      this.this$0.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject1);
      return;
    }
    localObject1 = new HashMap(ExpandEmotionHelper.a((List)localObject1));
    Object localObject2 = new Gson().toJson(localObject1);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("data", (String)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("expand.ipc.ExpandFlutterIPCServer", 1, "get sys emoj file path " + (String)localObject2);
    }
    localObject2 = new EIPCResult();
    ((EIPCResult)localObject2).data = ((Bundle)localObject1);
    this.this$0.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCServer.6
 * JD-Core Version:    0.7.0.1
 */