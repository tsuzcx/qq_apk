public abstract class swk
{
  protected int a;
  protected swi a;
  
  public abstract void a();
  
  public void a(swi paramswi)
  {
    this.jdField_a_of_type_Swi = paramswi;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int < 1)
    {
      this.jdField_a_of_type_Int += 1;
      urk.d("Q.qqstory.net:BatchNetHandler", String.format("retry request , retry count = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Swi != null) {
      this.jdField_a_of_type_Swi.a(this);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Swi != null) {
      this.jdField_a_of_type_Swi.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swk
 * JD-Core Version:    0.7.0.1
 */