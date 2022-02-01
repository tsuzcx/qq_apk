import com.tencent.av.business.manager.pendant.PendantItem;

public class lov
{
  public int a;
  private low jdField_a_of_type_Low;
  private loy jdField_a_of_type_Loy;
  private int b = 0;
  
  public lov(loy paramloy)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Loy = paramloy;
  }
  
  public int a(lok paramlok, lpp paramlpp)
  {
    int j = 0;
    int i = j;
    if (paramlpp.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null)
    {
      i = j;
      if (paramlpp.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null)
      {
        i = j;
        if (paramlpp.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.needHMirror) {
          i = 1;
        }
      }
    }
    return i;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Low == null) {
      this.jdField_a_of_type_Low = new low();
    }
  }
  
  public void a(lok paramlok, lpp paramlpp)
  {
    this.b = a(paramlok, paramlpp);
  }
  
  public void a(lok paramlok, lpp paramlpp, lpf paramlpf, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Low == null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Int = a(paramlok, paramlpp);
        this.jdField_a_of_type_Low.a(this.jdField_a_of_type_Int);
      } while (!this.jdField_a_of_type_Low.a());
      if (this.jdField_a_of_type_Loy.a != null) {
        this.jdField_a_of_type_Loy.a.a("extraRenderIn");
      }
      paramlok = this.jdField_a_of_type_Low.a(paramlpf, paramInt1, paramInt2);
      if (paramlok != null)
      {
        this.jdField_a_of_type_Loy.a(11, paramlpf, paramlok);
        paramlpf.jdField_a_of_type_Int = paramlok.jdField_a_of_type_Int;
        paramlpf.b = paramlok.b;
        paramlok.a();
      }
    } while (this.jdField_a_of_type_Loy.a == null);
    this.jdField_a_of_type_Loy.a.b("extraRenderIn");
  }
  
  public void a(lpf paramlpf, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.jdField_a_of_type_Low == null) {
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
      this.jdField_a_of_type_Low.a(i);
      if (!this.jdField_a_of_type_Low.a()) {
        break;
      }
      if (this.jdField_a_of_type_Loy.a != null) {
        this.jdField_a_of_type_Loy.a.a("extraRenderOut");
      }
      lpf locallpf = this.jdField_a_of_type_Low.a(paramlpf, paramInt1, paramInt2);
      if (locallpf != null)
      {
        this.jdField_a_of_type_Loy.a(12, paramlpf, locallpf);
        paramlpf.jdField_a_of_type_Int = locallpf.jdField_a_of_type_Int;
        paramlpf.b = locallpf.b;
        locallpf.a();
      }
      if (this.jdField_a_of_type_Loy.a == null) {
        break;
      }
      this.jdField_a_of_type_Loy.a.b("extraRenderOut");
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
    if (this.jdField_a_of_type_Low != null)
    {
      this.jdField_a_of_type_Low.a();
      this.jdField_a_of_type_Low = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lov
 * JD-Core Version:    0.7.0.1
 */