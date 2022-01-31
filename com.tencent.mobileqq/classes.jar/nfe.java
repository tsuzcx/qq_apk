import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class nfe
  extends alzl<nfd>
{
  public int a()
  {
    return 35;
  }
  
  public Class<nfd> a()
  {
    return nfd.class;
  }
  
  @NonNull
  public nfd a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        boolean bool = rqc.d((QQAppInterface)localObject);
        return nfd.a(rqc.a((QQAppInterface)localObject), rqc.b((QQAppInterface)localObject), bool);
      }
    }
    return new nfd();
  }
  
  @Nullable
  public nfd a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaSubscribeRedDotProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return nfd.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(nfd paramnfd)
  {
    paramnfd.a();
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
      return baig.z(((QQAppInterface)localObject).getApp(), ((QQAppInterface)localObject).getAccount());
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
 * Qualified Name:     nfe
 * JD-Core Version:    0.7.0.1
 */