import android.support.annotation.Nullable;
import java.util.List;

public class pia<BEAN, VIEW extends phs<BEAN>>
  implements phr<BEAN, VIEW>
{
  private phq<BEAN> jdField_a_of_type_Phq;
  private phs<BEAN> jdField_a_of_type_Phs;
  private boolean jdField_a_of_type_Boolean;
  
  public pia(phq<BEAN> paramphq)
  {
    this.jdField_a_of_type_Phq = paramphq;
  }
  
  private void a(List<BEAN> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (this.jdField_a_of_type_Phs != null)
      {
        this.jdField_a_of_type_Phs.e();
        this.jdField_a_of_type_Phs.a(paramList, false);
        this.jdField_a_of_type_Phs.g();
        this.jdField_a_of_type_Phs.a();
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, List<BEAN> paramList)
  {
    if (paramBoolean)
    {
      a(paramList);
      return;
    }
    b(paramInt, paramList);
  }
  
  private void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, @Nullable String paramString)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Phs != null)) {
      this.jdField_a_of_type_Phs.a(paramInt, paramString);
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramBoolean) && (this.jdField_a_of_type_Phs != null))
    {
      this.jdField_a_of_type_Phs.e();
      this.jdField_a_of_type_Phs.a(paramList, false);
      this.jdField_a_of_type_Phs.g();
    }
    while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Phs == null)) {
      return;
    }
    this.jdField_a_of_type_Phs.b(paramInt, paramString);
    this.jdField_a_of_type_Phs.a(0);
  }
  
  private void b(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_Phs != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Phs.b();
      }
      a(paramInt, paramList);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Phs = null;
  }
  
  public void a(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_Phs != null)
    {
      this.jdField_a_of_type_Phs.a(paramInt);
      this.jdField_a_of_type_Phs.a(paramList, false);
      if ((paramList == null) || (paramList.isEmpty())) {
        break label82;
      }
      this.jdField_a_of_type_Phs.e();
      if (this.jdField_a_of_type_Phq.a()) {
        this.jdField_a_of_type_Phs.h();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Phs.g();
    return;
    label82:
    this.jdField_a_of_type_Phs.d();
    this.jdField_a_of_type_Phs.i();
  }
  
  public void a(VIEW paramVIEW)
  {
    this.jdField_a_of_type_Phs = paramVIEW;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Phs != null) {
      this.jdField_a_of_type_Phs.c();
    }
    this.jdField_a_of_type_Phq.a(true, new pib(this));
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Phq.a())
    {
      if (this.jdField_a_of_type_Phs != null) {
        this.jdField_a_of_type_Phs.g();
      }
      return;
    }
    if (this.jdField_a_of_type_Phs != null) {
      this.jdField_a_of_type_Phs.f();
    }
    this.jdField_a_of_type_Phq.a(new pic(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pia
 * JD-Core Version:    0.7.0.1
 */