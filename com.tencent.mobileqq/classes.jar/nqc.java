import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class nqc
  extends ampa<nqb>
{
  public int a()
  {
    return 35;
  }
  
  public Class<nqb> a()
  {
    return nqb.class;
  }
  
  @NonNull
  public nqb a(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        boolean bool = scr.d((QQAppInterface)localObject);
        return nqb.a(scr.a((QQAppInterface)localObject), scr.b((QQAppInterface)localObject), bool);
      }
    }
    return new nqb();
  }
  
  @Nullable
  public nqb a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaSubscribeRedDotProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0)) {
      return nqb.a(paramArrayOfamph);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(nqb paramnqb)
  {
    paramnqb.a();
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
      return bbkb.z(((QQAppInterface)localObject).getApp(), ((QQAppInterface)localObject).getAccount());
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
 * Qualified Name:     nqc
 * JD-Core Version:    0.7.0.1
 */