import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.qphone.base.util.QLog;

public class lxx
{
  Context jdField_a_of_type_AndroidContentContext = null;
  lws jdField_a_of_type_Lws = null;
  lxy jdField_a_of_type_Lxy = null;
  lxz jdField_a_of_type_Lxz = new lxz(this);
  
  public lxx(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Lws == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return 0;
      try
      {
        paramInt = this.jdField_a_of_type_Lws.a(paramLong, paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", localRemoteException);
    return 0;
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Lws == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return null;
      try
      {
        paramArrayOfByte = this.jdField_a_of_type_Lws.a(paramArrayOfByte);
        return paramArrayOfByte;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "processQCallPush RemoteException", paramArrayOfByte);
    return null;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Lxy = null;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Lws == null)
    {
      Intent localIntent = new Intent(paramContext, AVServiceForQQ.class);
      boolean bool = paramContext.getApplicationContext().bindService(localIntent, this.jdField_a_of_type_Lxz, 1);
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "bindService result == " + bool);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Lws == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lws.a(paramString);
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "onGetQCallNickName RemoteException", paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Lws == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lws.a(paramString, paramBitmap);
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "pushStrangeFace RemoteException", paramString);
  }
  
  public void a(lxy paramlxy)
  {
    this.jdField_a_of_type_Lxy = paramlxy;
    a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Lws == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lws.a(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
  }
  
  public void b(Context paramContext)
  {
    paramContext.getApplicationContext().unbindService(this.jdField_a_of_type_Lxz);
    this.jdField_a_of_type_Lws = null;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Lws == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lws.c(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lxx
 * JD-Core Version:    0.7.0.1
 */