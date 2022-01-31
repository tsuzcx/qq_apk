import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.qphone.base.util.QLog;

public class maf
{
  Context jdField_a_of_type_AndroidContentContext = null;
  lza jdField_a_of_type_Lza = null;
  mag jdField_a_of_type_Mag = null;
  mah jdField_a_of_type_Mah = new mah(this);
  
  public maf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Lza == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return 0;
      try
      {
        paramInt = this.jdField_a_of_type_Lza.a(paramLong, paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", localRemoteException);
    return 0;
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Lza == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return null;
      try
      {
        paramArrayOfByte = this.jdField_a_of_type_Lza.a(paramArrayOfByte);
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
    this.jdField_a_of_type_Mag = null;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Lza == null)
    {
      Intent localIntent = new Intent(paramContext, AVServiceForQQ.class);
      boolean bool = paramContext.getApplicationContext().bindService(localIntent, this.jdField_a_of_type_Mah, 1);
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "bindService result == " + bool);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Lza == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lza.a(paramString);
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "onGetQCallNickName RemoteException", paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Lza == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lza.a(paramString, paramBitmap);
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "pushStrangeFace RemoteException", paramString);
  }
  
  public void a(mag parammag)
  {
    this.jdField_a_of_type_Mag = parammag;
    a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Lza == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lza.a(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
  }
  
  public void b(Context paramContext)
  {
    paramContext.getApplicationContext().unbindService(this.jdField_a_of_type_Mah);
    this.jdField_a_of_type_Lza = null;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Lza == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lza.c(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     maf
 * JD-Core Version:    0.7.0.1
 */