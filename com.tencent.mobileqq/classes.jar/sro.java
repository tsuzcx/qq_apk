import java.util.ArrayList;
import java.util.Iterator;

abstract class sro
{
  protected long a;
  private ArrayList<sro> a;
  protected long b;
  
  sro()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  abstract long a(long paramLong);
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((sro)localIterator.next()).a();
    }
    this.b = 0L;
  }
  
  public void a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((sro)localIterator.next()).a(paramLong);
    }
    this.b = a(paramLong);
    if (this.b < 0L) {
      this.b = 0L;
    }
    if ((float)Math.abs(this.b - this.jdField_a_of_type_Long) / (float)this.jdField_a_of_type_Long < 0.2F)
    {
      this.jdField_a_of_type_Long = Math.max(this.b, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_a_of_type_Long = this.b;
  }
  
  protected void a(sro paramsro)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramsro) < 0) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramsro);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((sro)localIterator.next()).b();
    }
    this.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sro
 * JD-Core Version:    0.7.0.1
 */