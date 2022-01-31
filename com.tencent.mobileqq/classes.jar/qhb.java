import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;

public class qhb
{
  private qgr jdField_a_of_type_Qgr;
  @Nullable
  private qgu jdField_a_of_type_Qgu;
  
  public qhb(qgr paramqgr)
  {
    this.jdField_a_of_type_Qgr = paramqgr;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qgu = null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b("", paramInt1, paramInt2, paramInt3);
  }
  
  public void a(long paramLong, String paramString1, @Nullable qfz paramqfz, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Qgu != null) {
      this.jdField_a_of_type_Qgu.a(paramLong, paramString1, paramqfz, paramString2, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(@Nullable String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Qgr.a(new qhc(this, paramInt1, paramInt2, paramInt3, paramString));
  }
  
  public void a(qgu paramqgu)
  {
    this.jdField_a_of_type_Qgu = paramqgu;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    RIJRedPacketManager.a().c();
    if (paramInt1 == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Qgr.a(i, paramString, "", new qhd(this, paramInt1, paramInt2, paramInt3));
      return;
      if (paramInt1 == 3) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qhb
 * JD-Core Version:    0.7.0.1
 */