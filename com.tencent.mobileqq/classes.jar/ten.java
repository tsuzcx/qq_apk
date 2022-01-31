import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ten
{
  public ConcurrentHashMap<String, Object> a;
  public teo a;
  public boolean a;
  public final String b;
  public boolean b;
  
  public ten()
  {
    this.jdField_b_of_type_JavaLangString = ("Q.qqstory.share" + getClass().getSimpleName());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public <T> T a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      urk.a(this.jdField_b_of_type_JavaLangString, "getResult key %s, result %s, stack = %s", String.valueOf(paramString), String.valueOf(localObject), vlk.a(7));
      return localObject;
    }
    urk.a(this.jdField_b_of_type_JavaLangString, "getResult key %s, result null, stack = %s", String.valueOf(paramString), vlk.a(7));
    return null;
  }
  
  public final ten a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    return this;
  }
  
  public abstract void a();
  
  public void a(String paramString, Object paramObject)
  {
    urk.a(this.jdField_b_of_type_JavaLangString, "putResult key %s, value %s, stack = %s", String.valueOf(paramString), String.valueOf(paramObject), vlk.a(7));
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramObject);
    }
  }
  
  protected abstract void a(Map<String, Object> paramMap);
  
  public final void a(boolean paramBoolean)
  {
    urk.a(this.jdField_b_of_type_JavaLangString, "onJobFinish %b, stack = %s", Boolean.valueOf(paramBoolean), vlk.a(7));
    if (this.jdField_a_of_type_Teo != null) {
      this.jdField_a_of_type_Teo.b(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected final void b(boolean paramBoolean)
  {
    urk.a(this.jdField_b_of_type_JavaLangString, "onRunFinish %b, stack = %s", Boolean.valueOf(paramBoolean), vlk.a(7));
    if (this.jdField_a_of_type_Teo != null) {
      this.jdField_a_of_type_Teo.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ten
 * JD-Core Version:    0.7.0.1
 */