import android.os.Bundle;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class odz<T extends MessageMicro<?>>
  implements BusinessObserver
{
  private Class<T> jdField_a_of_type_JavaLangClass;
  private oea<T> jdField_a_of_type_Oea;
  
  public odz(oea<T> paramoea, Class<T> paramClass)
  {
    this.jdField_a_of_type_Oea = paramoea;
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  private T a(byte[] paramArrayOfByte, Class<T> paramClass)
  {
    try
    {
      paramClass = (MessageMicro)paramClass.newInstance();
      if (paramArrayOfByte == null) {
        return null;
      }
      paramClass.mergeFrom(paramArrayOfByte);
      return paramClass;
    }
    catch (Throwable paramArrayOfByte)
    {
      Toast.makeText(BaseApplicationImpl.getContext(), 2131694775, 0).show();
      QLog.w("PublicAccountStQWebServlet", 4, "decode pb err:" + paramArrayOfByte.getMessage(), paramArrayOfByte);
    }
    return null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Oea == null) {
      return;
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Oea.a(paramInt, paramBoolean, null, paramBundle);
    }
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    if (a(arrayOfByte, this.jdField_a_of_type_JavaLangClass) == null)
    {
      this.jdField_a_of_type_Oea.a(paramInt, false, null, paramBundle);
      return;
    }
    this.jdField_a_of_type_Oea.a(paramInt, paramBoolean, a(arrayOfByte, this.jdField_a_of_type_JavaLangClass), paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odz
 * JD-Core Version:    0.7.0.1
 */