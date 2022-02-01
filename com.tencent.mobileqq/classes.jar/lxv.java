import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.qphone.base.util.QLog;

class lxv
  extends ntf
{
  lxv(lxu paramlxu, String paramString, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle arg3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAVQ.nearby.video_chat", 2, "sendNearbyVideoChatPbReq, cmd " + this.jdField_a_of_type_JavaLangString + "==>onResult, errorCode:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_Lxu.a.a)
    {
      int j = this.jdField_a_of_type_Lxu.a.a.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((lwv)this.jdField_a_of_type_Lxu.a.a.getBroadcastItem(i)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramInt, paramArrayOfByte);
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
      this.jdField_a_of_type_Lxu.a.a.finishBroadcast();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lxv
 * JD-Core Version:    0.7.0.1
 */