import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class nhw
{
  int jdField_a_of_type_Int;
  protected Activity a;
  protected Map<Integer, Set<Long>> a;
  qvd jdField_a_of_type_Qvd;
  protected Map<Integer, Boolean> b = new HashMap();
  protected Map<Integer, Map<Long, pov>> c = new HashMap();
  protected Map<Integer, pov> d = new HashMap();
  
  protected nhw()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  protected nhw(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public ViewGroup a()
  {
    return null;
  }
  
  public Map<Long, pov> a(Integer paramInteger)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    paramInteger = (Map)this.c.get(paramInteger);
    if ((paramInteger != null) && (!paramInteger.isEmpty())) {
      localConcurrentHashMap.putAll(paramInteger);
    }
    return localConcurrentHashMap;
  }
  
  public Set<Long> a(Integer paramInteger)
  {
    Set localSet = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.jdField_a_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public qhp a()
  {
    return null;
  }
  
  public qik a()
  {
    return null;
  }
  
  public void a()
  {
    bgmq.f(true);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ViewGroup paramViewGroup) {}
  
  public void a(qvd paramqvd, int paramInt)
  {
    this.jdField_a_of_type_Qvd = paramqvd;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a(Integer paramInteger)
  {
    paramInteger = (Boolean)this.b.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  public Map<Long, pov> b(Integer paramInteger)
  {
    Map localMap = (Map)this.c.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new ConcurrentHashMap();
      this.c.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    bgmq.f(false);
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void k() {}
  
  public void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhw
 * JD-Core Version:    0.7.0.1
 */