import com.tencent.qphone.base.util.QLog;

public class sfj<T>
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private T jdField_a_of_type_JavaLangObject;
  private final sfk<T> jdField_a_of_type_Sfk;
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + sfj.class.getSimpleName();
  }
  
  public sfj(T paramT, sfk<T> paramsfk)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    this.jdField_a_of_type_Sfk = paramsfk;
    this.jdField_a_of_type_Int = 1;
  }
  
  public T a()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_JavaLangObject;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Int += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Int -= 1;
      if (this.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          sfm.a("Reference", " decReference 0 " + this.jdField_a_of_type_JavaLangObject);
        }
        if (this.jdField_a_of_type_JavaLangObject != null)
        {
          this.jdField_a_of_type_Sfk.a(this.jdField_a_of_type_JavaLangObject);
          this.jdField_a_of_type_JavaLangObject = null;
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     sfj
 * JD-Core Version:    0.7.0.1
 */