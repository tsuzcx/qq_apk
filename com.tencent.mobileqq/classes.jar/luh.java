import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;

public class luh
{
  private long jdField_a_of_type_Long;
  Object jdField_a_of_type_JavaLangObject;
  public boolean a;
  private long b;
  
  public luh(FastWebModule paramFastWebModule, Object paramObject)
  {
    this(paramFastWebModule, paramObject, 600000L);
    if (paramObject == null) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public luh(FastWebModule paramFastWebModule, Object paramObject, long paramLong)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.b = System.currentTimeMillis();
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.b = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - this.b >= this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     luh
 * JD-Core Version:    0.7.0.1
 */