import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class nqf
  extends ampb<nqe>
{
  public int a()
  {
    return 35;
  }
  
  public Class<nqe> a()
  {
    return nqe.class;
  }
  
  @NonNull
  public nqe a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        boolean bool = scu.d((QQAppInterface)localObject);
        return nqe.a(scu.a((QQAppInterface)localObject), scu.b((QQAppInterface)localObject), bool);
      }
    }
    return new nqe();
  }
  
  @Nullable
  public nqe a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaSubscribeRedDotProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return nqe.a(paramArrayOfampi);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(nqe paramnqe)
  {
    paramnqe.a();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      return bbjn.z(((QQAppInterface)localObject).getApp(), ((QQAppInterface)localObject).getAccount());
    }
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqf
 * JD-Core Version:    0.7.0.1
 */