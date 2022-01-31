import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class tav<T>
{
  public Context a;
  private HashMap<String, tav> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<T> jdField_a_of_type_JavaUtilList;
  private tav jdField_a_of_type_Tav;
  protected taw a;
  protected tax a;
  private boolean jdField_a_of_type_Boolean;
  public View b;
  
  public tav(Context paramContext, int paramInt)
  {
    this.b = LayoutInflater.from(paramContext).inflate(paramInt, null, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public tav(Context paramContext, View paramView)
  {
    this.b = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public tav a()
  {
    return this.jdField_a_of_type_Tav;
  }
  
  public tav a(String paramString)
  {
    return (tav)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public abstract taw a();
  
  public abstract tax a();
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((tav)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a();
    }
  }
  
  public abstract void a(Context paramContext, View paramView);
  
  public void a(String paramString, tav paramtav)
  {
    paramtav.jdField_a_of_type_Tav = this;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramtav);
  }
  
  public abstract void a(List<T> paramList);
  
  public void a(tax paramtax)
  {
    this.jdField_a_of_type_Tax = paramtax;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public abstract void b();
  
  public void b(List<T> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void c(List<T> paramList)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.b != null) {
      this.b.setVisibility(0);
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    a(paramList);
  }
  
  public void k()
  {
    if (this.b != null) {
      this.b.setVisibility(8);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.b != null) {
      this.b.setVisibility(0);
    }
    if (this.jdField_a_of_type_Tax == null) {
      this.jdField_a_of_type_Tax = a();
    }
    if (this.jdField_a_of_type_Taw == null) {
      this.jdField_a_of_type_Taw = a();
    }
    a(this.jdField_a_of_type_AndroidContentContext, this.b);
    b();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      a(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((tav)this.jdField_a_of_type_JavaUtilHashMap.get(str)).l();
      }
      break;
      if (this.jdField_a_of_type_Taw != null) {
        this.jdField_a_of_type_Taw.a();
      } else {
        a(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tav
 * JD-Core Version:    0.7.0.1
 */