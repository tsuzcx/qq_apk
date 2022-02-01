import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;

public class rmb
  implements rlp
{
  private rlq jdField_a_of_type_Rlq;
  private rma jdField_a_of_type_Rma;
  private rnh jdField_a_of_type_Rnh;
  
  public rmb(rma paramrma)
  {
    this.jdField_a_of_type_Rma = paramrma;
    this.jdField_a_of_type_Rnh = new rnh(this.jdField_a_of_type_Rma);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rnh.a();
    this.jdField_a_of_type_Rlq = null;
  }
  
  public void a(UgcVideo paramUgcVideo)
  {
    if (this.jdField_a_of_type_Rlq != null) {
      this.jdField_a_of_type_Rlq.a();
    }
    this.jdField_a_of_type_Rma.a(paramUgcVideo, null);
  }
  
  public void a(rlq paramrlq)
  {
    this.jdField_a_of_type_Rnh.a(paramrlq);
    this.jdField_a_of_type_Rlq = paramrlq;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rnh.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rnh.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rmb
 * JD-Core Version:    0.7.0.1
 */