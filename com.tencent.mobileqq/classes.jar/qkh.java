import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class qkh
  extends qkk
{
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private int b;
  
  public qkh(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = 2000;
  }
  
  private void c()
  {
    int i = (int)Math.sqrt((float)this.jdField_a_of_type_Long * this.jdField_a_of_type_Float * 1024.0D);
    if (i > 0) {
      this.b = i;
    }
  }
  
  public long a(long paramLong)
  {
    long l2 = 0L;
    double d = Math.sqrt(paramLong);
    long l1;
    while ((this.jdField_a_of_type_Int + d > this.b) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilArrayList.remove(0)).longValue();
      this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int - Math.sqrt(l1)));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int + d));
    int i = this.b / 2;
    Object localObject = (List)this.jdField_a_of_type_JavaUtilArrayList.clone();
    Collections.sort((List)localObject);
    Long localLong;
    if (this.jdField_a_of_type_Int > i)
    {
      localObject = ((List)localObject).iterator();
      l1 = 0L;
      do
      {
        paramLong = l2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localLong = (Long)((Iterator)localObject).next();
        paramLong = (l1 + Math.sqrt(localLong.longValue()));
        l1 = paramLong;
      } while (paramLong <= i);
    }
    for (paramLong = localLong.longValue();; paramLong = ((Long)((List)localObject).get(((List)localObject).size() - 1)).longValue())
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Float * 2.0F) {
        c();
      }
      return paramLong;
    }
  }
  
  public void a()
  {
    c();
    super.a();
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Int = 0;
  }
  
  public String toString()
  {
    return "ExoPredictor(" + this.b + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qkh
 * JD-Core Version:    0.7.0.1
 */