import com.tencent.qphone.base.util.QLog;

public class rcz<T>
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private T jdField_a_of_type_JavaLangObject;
  private final rda<T> jdField_a_of_type_Rda;
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + rcz.class.getSimpleName();
  }
  
  public rcz(T paramT, rda<T> paramrda)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    this.jdField_a_of_type_Rda = paramrda;
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
          rdc.a("Reference", " decReference 0 " + this.jdField_a_of_type_JavaLangObject);
        }
        if (this.jdField_a_of_type_JavaLangObject != null)
        {
          this.jdField_a_of_type_Rda.a(this.jdField_a_of_type_JavaLangObject);
          this.jdField_a_of_type_JavaLangObject = null;
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     rcz
 * JD-Core Version:    0.7.0.1
 */