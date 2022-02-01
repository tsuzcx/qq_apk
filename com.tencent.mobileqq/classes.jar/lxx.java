import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.qphone.base.util.QLog;

class lxx
  extends nkq
{
  lxx(lxw paramlxw, String paramString, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle arg3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAVQ.nearby.video_chat", 2, "sendNearbyVideoChatPbReq, cmd " + this.jdField_a_of_type_JavaLangString + "==>onResult, errorCode:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_Lxw.a.a)
    {
      int j = this.jdField_a_of_type_Lxw.a.a.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((lwx)this.jdField_a_of_type_Lxw.a.a.getBroadcastItem(i)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramInt, paramArrayOfByte);
            i += 1;
          }
          catch (RemoteException paramArrayOfByte)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQServiceForAVQ.nearby.video_chat", 2, "callBack RemoteException", paramArrayOfByte);
            }
          }
        }
      }
      this.jdField_a_of_type_Lxw.a.a.finishBroadcast();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lxx
 * JD-Core Version:    0.7.0.1
 */