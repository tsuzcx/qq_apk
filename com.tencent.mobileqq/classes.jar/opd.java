import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class opd
  extends aqwt<opa>
{
  public static opa a()
  {
    return (opa)aqxe.a().a(593);
  }
  
  @NonNull
  public opa a(int paramInt)
  {
    return new opa();
  }
  
  @Nullable
  public opa a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0)) {
      return new opa();
    }
    return opa.a(paramArrayOfaqxa[0].a);
  }
  
  public void a(opa paramopa) {}
  
  public Class<opa> clazz()
  {
    return opa.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 593;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opd
 * JD-Core Version:    0.7.0.1
 */