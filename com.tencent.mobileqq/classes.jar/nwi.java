import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class nwi
{
  int jdField_a_of_type_Int;
  protected Activity a;
  protected Map<Integer, Set<Long>> a;
  rxg jdField_a_of_type_Rxg;
  protected Map<Integer, Boolean> b = new HashMap();
  protected Map<Integer, Map<Long, qkk>> c = new HashMap();
  protected Map<Integer, qkk> d = new HashMap();
  
  protected nwi()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  protected nwi(Activity paramActivity)
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
  
  public Map<Long, qkk> a(Integer paramInteger)
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
  
  public rjg a()
  {
    return null;
  }
  
  public rkb a()
  {
    return null;
  }
  
  public void a()
  {
    bkbq.e(true);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ViewGroup paramViewGroup) {}
  
  public void a(rxg paramrxg, int paramInt)
  {
    this.jdField_a_of_type_Rxg = paramrxg;
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
  
  public Map<Long, qkk> b(Integer paramInteger)
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
    bkbq.e(false);
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void k() {}
  
  public void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nwi
 * JD-Core Version:    0.7.0.1
 */