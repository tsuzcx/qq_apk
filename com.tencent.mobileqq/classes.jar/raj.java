import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;

public class raj
{
  private qzz jdField_a_of_type_Qzz;
  @Nullable
  private rac jdField_a_of_type_Rac;
  
  public raj(qzz paramqzz)
  {
    this.jdField_a_of_type_Qzz = paramqzz;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rac = null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b("", paramInt1, paramInt2, paramInt3);
  }
  
  public void a(long paramLong, String paramString1, @Nullable qzh paramqzh, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Rac != null) {
      this.jdField_a_of_type_Rac.a(paramLong, paramString1, paramqzh, paramString2, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(@Nullable String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Qzz.a(new rak(this, paramInt1, paramInt2, paramInt3, paramString));
  }
  
  public void a(rac paramrac)
  {
    this.jdField_a_of_type_Rac = paramrac;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    RIJRedPacketManager.a().c();
    if (paramInt1 == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Qzz.a(i, paramString, "", new ral(this, paramInt1, paramInt2, paramInt3));
      return;
      if (paramInt1 == 3) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     raj
 * JD-Core Version:    0.7.0.1
 */