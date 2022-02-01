import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;

public class ryq
  implements ryc
{
  private ryd jdField_a_of_type_Ryd;
  private ryp jdField_a_of_type_Ryp;
  private rzw jdField_a_of_type_Rzw;
  
  public ryq(ryp paramryp)
  {
    this.jdField_a_of_type_Ryp = paramryp;
    this.jdField_a_of_type_Rzw = new rzw(this.jdField_a_of_type_Ryp);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rzw.a();
    this.jdField_a_of_type_Ryd = null;
  }
  
  public void a(UgcVideo paramUgcVideo)
  {
    if (this.jdField_a_of_type_Ryd != null) {
      this.jdField_a_of_type_Ryd.a();
    }
    this.jdField_a_of_type_Ryp.a(paramUgcVideo, null);
  }
  
  public void a(ryd paramryd)
  {
    this.jdField_a_of_type_Rzw.a(paramryd);
    this.jdField_a_of_type_Ryd = paramryd;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rzw.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rzw.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryq
 * JD-Core Version:    0.7.0.1
 */