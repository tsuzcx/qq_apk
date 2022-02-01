import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;

public class rfb
  implements rep
{
  private req jdField_a_of_type_Req;
  private rfa jdField_a_of_type_Rfa;
  private rgh jdField_a_of_type_Rgh;
  
  public rfb(rfa paramrfa)
  {
    this.jdField_a_of_type_Rfa = paramrfa;
    this.jdField_a_of_type_Rgh = new rgh(this.jdField_a_of_type_Rfa);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rgh.a();
    this.jdField_a_of_type_Req = null;
  }
  
  public void a(UgcVideo paramUgcVideo)
  {
    if (this.jdField_a_of_type_Req != null) {
      this.jdField_a_of_type_Req.a();
    }
    this.jdField_a_of_type_Rfa.a(paramUgcVideo, null);
  }
  
  public void a(req paramreq)
  {
    this.jdField_a_of_type_Rgh.a(paramreq);
    this.jdField_a_of_type_Req = paramreq;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rgh.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rgh.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfb
 * JD-Core Version:    0.7.0.1
 */