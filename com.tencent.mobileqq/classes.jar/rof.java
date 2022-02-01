import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;

public class rof
  implements rnu
{
  private rnv jdField_a_of_type_Rnv;
  private roe jdField_a_of_type_Roe;
  private rpl jdField_a_of_type_Rpl;
  
  public rof(roe paramroe)
  {
    this.jdField_a_of_type_Roe = paramroe;
    this.jdField_a_of_type_Rpl = new rpl(this.jdField_a_of_type_Roe);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rpl.a();
    this.jdField_a_of_type_Rnv = null;
  }
  
  public void a(UgcVideo paramUgcVideo)
  {
    if (this.jdField_a_of_type_Rnv != null) {
      this.jdField_a_of_type_Rnv.a();
    }
    this.jdField_a_of_type_Roe.a(paramUgcVideo, null);
  }
  
  public void a(rnv paramrnv)
  {
    this.jdField_a_of_type_Rpl.a(paramrnv);
    this.jdField_a_of_type_Rnv = paramrnv;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rpl.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rpl.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rof
 * JD-Core Version:    0.7.0.1
 */