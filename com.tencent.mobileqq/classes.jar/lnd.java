import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.qphone.base.util.QLog;

public class lnd
{
  Context jdField_a_of_type_AndroidContentContext = null;
  lly jdField_a_of_type_Lly = null;
  lne jdField_a_of_type_Lne = null;
  lnf jdField_a_of_type_Lnf = new lnf(this);
  
  public lnd(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Lly == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return 0;
      try
      {
        paramInt = this.jdField_a_of_type_Lly.a(paramLong, paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", localRemoteException);
    return 0;
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Lly == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return null;
      try
      {
        paramArrayOfByte = this.jdField_a_of_type_Lly.a(paramArrayOfByte);
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
    this.jdField_a_of_type_Lne = null;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Lly == null)
    {
      Intent localIntent = new Intent(paramContext, AVServiceForQQ.class);
      boolean bool = paramContext.getApplicationContext().bindService(localIntent, this.jdField_a_of_type_Lnf, 1);
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "bindService result == " + bool);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Lly == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lly.a(paramString);
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "onGetQCallNickName RemoteException", paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Lly == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lly.a(paramString, paramBitmap);
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "pushStrangeFace RemoteException", paramString);
  }
  
  public void a(lne paramlne)
  {
    this.jdField_a_of_type_Lne = paramlne;
    a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Lly == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lly.a(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
  }
  
  public void b(Context paramContext)
  {
    paramContext.getApplicationContext().unbindService(this.jdField_a_of_type_Lnf);
    this.jdField_a_of_type_Lly = null;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Lly == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lly.c(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lnd
 * JD-Core Version:    0.7.0.1
 */