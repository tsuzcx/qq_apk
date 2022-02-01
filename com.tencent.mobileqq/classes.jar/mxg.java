import com.tencent.mobileqq.app.BusinessObserver;

public class mxg
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, myo parammyo) {}
  
  protected void a(boolean paramBoolean, mys parammys) {}
  
  protected void b(boolean paramBoolean, myo parammyo) {}
  
  protected void c(boolean paramBoolean, myo parammyo) {}
  
  protected void d(boolean paramBoolean, myo parammyo) {}
  
  protected void e(boolean paramBoolean, myo parammyo) {}
  
  protected void f(boolean paramBoolean, myo parammyo) {}
  
  protected void g(boolean paramBoolean, myo parammyo) {}
  
  protected void h(boolean paramBoolean, myo parammyo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, (mys)paramObject);
      return;
    case 2: 
      a(paramBoolean, (myo)paramObject);
      return;
    case 3: 
      b(paramBoolean, (myo)paramObject);
      return;
    case 4: 
      c(paramBoolean, (myo)paramObject);
      return;
    case 5: 
      d(paramBoolean, (myo)paramObject);
      return;
    case 6: 
      e(paramBoolean, (myo)paramObject);
      return;
    case 7: 
      f(paramBoolean, (myo)paramObject);
      return;
    case 8: 
      g(paramBoolean, (myo)paramObject);
      return;
    case 9: 
      h(paramBoolean, (myo)paramObject);
      return;
    }
    a(paramBoolean, ((myo)paramObject).jdField_a_of_type_Int, ((myo)paramObject).jdField_a_of_type_Long, ((myo)paramObject).jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxg
 * JD-Core Version:    0.7.0.1
 */