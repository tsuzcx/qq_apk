import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class nqg
  extends ampa<nqf>
{
  public int a()
  {
    return 32;
  }
  
  public Class<nqf> a()
  {
    return nqf.class;
  }
  
  @NonNull
  public nqf a(int paramInt)
  {
    if (paramInt == 0)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return nqf.a(bbkb.e(((QQAppInterface)localAppRuntime).getApplication()));
      }
    }
    return new nqf();
  }
  
  @Nullable
  public nqf a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0)) {
      return nqf.a(paramArrayOfamph);
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(nqf paramnqf)
  {
    paramnqf.b();
    paramnqf.a();
  }
  
  public int b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return bbkb.n(((QQAppInterface)localAppRuntime).getApp());
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
 * Qualified Name:     nqg
 * JD-Core Version:    0.7.0.1
 */