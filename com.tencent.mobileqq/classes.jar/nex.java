import android.content.Intent;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class nex
  implements EIPCResultCallback
{
  nex(new paramnew, String paramString, int paramInt) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult == null) || (!paramEIPCResult.isSuccess()))
    {
      paramEIPCResult = new Intent("action_notify_av_game_room_changed");
      paramEIPCResult.putExtra("action_key_room_id", this.jdField_a_of_type_JavaLangString);
      paramEIPCResult.putExtra("action_key_status", this.jdField_a_of_type_Int);
      new.a(this.jdField_a_of_type_New).getApp().sendBroadcast(paramEIPCResult);
      QLog.d("AVGameClientQIPCModule", 2, "status change with broadcast " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nex
 * JD-Core Version:    0.7.0.1
 */