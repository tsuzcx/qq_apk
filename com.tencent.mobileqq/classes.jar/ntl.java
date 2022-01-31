import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ntl
  extends aokh<ntk>
{
  public int a()
  {
    return 35;
  }
  
  public Class<ntk> a()
  {
    return ntk.class;
  }
  
  @NonNull
  public ntk a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        boolean bool = suk.d((QQAppInterface)localObject);
        return ntk.a(suk.a((QQAppInterface)localObject), suk.b((QQAppInterface)localObject), bool);
      }
    }
    return new ntk();
  }
  
  @Nullable
  public ntk a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaSubscribeRedDotProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return ntk.a(paramArrayOfaoko);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(ntk paramntk)
  {
    paramntk.a();
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
      return bdne.z(((QQAppInterface)localObject).getApp(), ((QQAppInterface)localObject).getAccount());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ntl
 * JD-Core Version:    0.7.0.1
 */