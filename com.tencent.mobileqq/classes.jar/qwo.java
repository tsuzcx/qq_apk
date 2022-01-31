import java.util.ArrayList;
import java.util.Iterator;

final class qwo
  extends qwm
{
  private final int jdField_a_of_type_Int;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  
  public qwo(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (paramLong = 0L; localIterator.hasNext(); paramLong = ((Long)localIterator.next()).longValue() + paramLong) {}
    return paramLong / this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public String toString()
  {
    return "MoveAvgPredictor(" + this.jdField_a_of_type_Int + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwo
 * JD-Core Version:    0.7.0.1
 */