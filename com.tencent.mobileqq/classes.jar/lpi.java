import com.tencent.av.business.manager.pendant.PendantItem;

public class lpi
{
  public int a;
  private lpj jdField_a_of_type_Lpj;
  private lpl jdField_a_of_type_Lpl;
  private int b = 0;
  
  public lpi(lpl paramlpl)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Lpl = paramlpl;
  }
  
  public int a(lox paramlox, lqc paramlqc)
  {
    int j = 0;
    int i = j;
    if (paramlqc.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null)
    {
      i = j;
      if (paramlqc.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null)
      {
        i = j;
        if (paramlqc.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.needHMirror) {
          i = 1;
        }
      }
    }
    return i;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Lpj == null) {
      this.jdField_a_of_type_Lpj = new lpj();
    }
  }
  
  public void a(lox paramlox, lqc paramlqc)
  {
    this.b = a(paramlox, paramlqc);
  }
  
  public void a(lox paramlox, lqc paramlqc, lps paramlps, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Lpj == null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Int = a(paramlox, paramlqc);
        this.jdField_a_of_type_Lpj.a(this.jdField_a_of_type_Int);
      } while (!this.jdField_a_of_type_Lpj.a());
      if (this.jdField_a_of_type_Lpl.a != null) {
        this.jdField_a_of_type_Lpl.a.a("extraRenderIn");
      }
      paramlox = this.jdField_a_of_type_Lpj.a(paramlps, paramInt1, paramInt2);
      if (paramlox != null)
      {
        this.jdField_a_of_type_Lpl.a(11, paramlps, paramlox);
        paramlps.jdField_a_of_type_Int = paramlox.jdField_a_of_type_Int;
        paramlps.b = paramlox.b;
        paramlox.a();
      }
    } while (this.jdField_a_of_type_Lpl.a == null);
    this.jdField_a_of_type_Lpl.a.b("extraRenderIn");
  }
  
  public void a(lps paramlps, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.jdField_a_of_type_Lpj == null) {
      return;
    }
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      i = j;
      label23:
      if (i == 0) {
        break label201;
      }
    }
    label201:
    for (int i = this.b;; i = this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Lpj.a(i);
      if (!this.jdField_a_of_type_Lpj.a()) {
        break;
      }
      if (this.jdField_a_of_type_Lpl.a != null) {
        this.jdField_a_of_type_Lpl.a.a("extraRenderOut");
      }
      lps locallps = this.jdField_a_of_type_Lpj.a(paramlps, paramInt1, paramInt2);
      if (locallps != null)
      {
        this.jdField_a_of_type_Lpl.a(12, paramlps, locallps);
        paramlps.jdField_a_of_type_Int = locallps.jdField_a_of_type_Int;
        paramlps.b = locallps.b;
        locallps.a();
      }
      if (this.jdField_a_of_type_Lpl.a == null) {
        break;
      }
      this.jdField_a_of_type_Lpl.a.b("extraRenderOut");
      return;
      if ((paramBoolean1) && (paramBoolean2))
      {
        i = 1;
        break label23;
      }
      if (!paramBoolean1)
      {
        i = j;
        if (paramBoolean2) {
          break label23;
        }
      }
      i = j;
      if (!paramBoolean1) {
        break label23;
      }
      i = j;
      if (paramBoolean2) {
        break label23;
      }
      i = j;
      break label23;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Lpj != null)
    {
      this.jdField_a_of_type_Lpj.a();
      this.jdField_a_of_type_Lpj = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lpi
 * JD-Core Version:    0.7.0.1
 */