public class pfs<T>
{
  private long jdField_a_of_type_Long;
  T jdField_a_of_type_JavaLangObject;
  public boolean a;
  private long b;
  
  public pfs(T paramT)
  {
    this(paramT, localObject, 600000L);
    if (localObject == null) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public pfs(T paramT, long paramLong)
  {
    this.jdField_a_of_type_JavaLangObject = paramLong;
    this.b = System.currentTimeMillis();
    Object localObject;
    this.jdField_a_of_type_Long = localObject;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    this.b = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - this.b >= this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pfs
 * JD-Core Version:    0.7.0.1
 */