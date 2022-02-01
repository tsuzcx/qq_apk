import com.tencent.av.business.manager.pendant.PendantItem;

public class lpn
{
  public int a;
  private lpo jdField_a_of_type_Lpo;
  private lpq jdField_a_of_type_Lpq;
  public int b;
  private lpo b;
  public int c = 0;
  private int d = 0;
  
  public lpn(lpq paramlpq)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Lpq = paramlpq;
  }
  
  public int a(lpc paramlpc)
  {
    int i = 0;
    if (paramlpc.e == 270) {
      i = 1;
    }
    do
    {
      return i;
      if (paramlpc.e == 90) {
        return 2;
      }
    } while (paramlpc.e != 180);
    return 3;
  }
  
  public int a(lpc paramlpc, lqh paramlqh)
  {
    int k = a(paramlpc);
    int j = 0;
    int i = j;
    if (paramlqh.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null)
    {
      i = j;
      if (paramlqh.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null)
      {
        i = j;
        if (k == 0)
        {
          i = j;
          if (paramlqh.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.needHMirror) {
            i = 1;
          }
        }
      }
    }
    return i;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Lpo == null) {
      this.jdField_a_of_type_Lpo = new lpo();
    }
    if (this.jdField_b_of_type_Lpo == null) {
      this.jdField_b_of_type_Lpo = new lpo();
    }
  }
  
  public void a(lpc paramlpc, lqh paramlqh)
  {
    this.d = a(paramlpc, paramlqh);
    this.jdField_a_of_type_Int = a(paramlpc);
  }
  
  public void a(lpc paramlpc, lqh paramlqh, lpx paramlpx, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Lpo == null) {}
    do
    {
      int j;
      int i;
      do
      {
        return;
        this.jdField_b_of_type_Int = a(paramlpc, paramlqh);
        this.c = a(paramlpc);
        if (this.c != 1)
        {
          j = paramInt1;
          i = paramInt2;
          if (this.c != 2) {}
        }
        else
        {
          i = paramInt1;
          j = paramInt2;
        }
        this.jdField_a_of_type_Lpo.a(this.c, this.jdField_b_of_type_Int);
      } while (!this.jdField_a_of_type_Lpo.a());
      if (this.jdField_a_of_type_Lpq.a != null) {
        this.jdField_a_of_type_Lpq.a.a("extraRenderIn");
      }
      paramlpc = this.jdField_a_of_type_Lpo.a(paramlpx, j, i);
      if (paramlpc != null)
      {
        this.jdField_a_of_type_Lpq.a(11, paramlpx, paramlpc);
        paramlpx.jdField_a_of_type_Int = paramlpc.jdField_a_of_type_Int;
        paramlpx.jdField_b_of_type_Int = paramlpc.jdField_b_of_type_Int;
        paramlpc.a();
      }
    } while (this.jdField_a_of_type_Lpq.a == null);
    this.jdField_a_of_type_Lpq.a.b("extraRenderIn");
  }
  
  public void a(lpx paramlpx, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    int k = 2;
    if (this.jdField_b_of_type_Lpo == null) {
      return;
    }
    int i;
    if ((!paramBoolean1) && (!paramBoolean2)) {
      i = 0;
    }
    for (;;)
    {
      label22:
      int j;
      if (i != 0)
      {
        j = this.d;
        i = this.jdField_a_of_type_Int;
        label39:
        if (i != 1) {
          break label226;
        }
        i = k;
      }
      for (;;)
      {
        this.jdField_b_of_type_Lpo.a(i, j);
        if (!this.jdField_b_of_type_Lpo.a()) {
          break;
        }
        if (this.jdField_a_of_type_Lpq.a != null) {
          this.jdField_a_of_type_Lpq.a.a("extraRenderOut");
        }
        lpx locallpx = this.jdField_b_of_type_Lpo.a(paramlpx, paramInt1, paramInt2);
        if (locallpx != null)
        {
          this.jdField_a_of_type_Lpq.a(12, paramlpx, locallpx);
          paramlpx.jdField_a_of_type_Int = locallpx.jdField_a_of_type_Int;
          paramlpx.jdField_b_of_type_Int = locallpx.jdField_b_of_type_Int;
          locallpx.a();
        }
        if (this.jdField_a_of_type_Lpq.a == null) {
          break;
        }
        this.jdField_a_of_type_Lpq.a.b("extraRenderOut");
        return;
        if ((paramBoolean1) && (paramBoolean2))
        {
          i = 1;
          break label22;
        }
        if ((!paramBoolean1) && (paramBoolean2))
        {
          i = 0;
          break label22;
        }
        if ((!paramBoolean1) || (paramBoolean2)) {
          break label256;
        }
        i = 0;
        break label22;
        j = this.jdField_b_of_type_Int;
        i = this.c;
        break label39;
        label226:
        if (i == 2) {
          i = 1;
        } else if (i == 3) {
          i = 3;
        } else {
          i = 0;
        }
      }
      label256:
      i = 0;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Lpo != null)
    {
      this.jdField_a_of_type_Lpo.a();
      this.jdField_a_of_type_Lpo = null;
    }
    if (this.jdField_b_of_type_Lpo != null)
    {
      this.jdField_b_of_type_Lpo.a();
      this.jdField_b_of_type_Lpo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpn
 * JD-Core Version:    0.7.0.1
 */