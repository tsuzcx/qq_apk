import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class soc<T>
{
  public Context a;
  private HashMap<String, soc> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<T> jdField_a_of_type_JavaUtilList;
  private soc jdField_a_of_type_Soc;
  protected sod a;
  protected soe a;
  private boolean jdField_a_of_type_Boolean;
  public View b;
  
  public soc(Context paramContext, int paramInt)
  {
    this.b = LayoutInflater.from(paramContext).inflate(paramInt, null, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public soc(Context paramContext, View paramView)
  {
    this.b = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public soc a()
  {
    return this.jdField_a_of_type_Soc;
  }
  
  public soc a(String paramString)
  {
    return (soc)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public abstract sod a();
  
  public abstract soe a();
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((soc)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a();
    }
  }
  
  public abstract void a(Context paramContext, View paramView);
  
  public void a(String paramString, soc paramsoc)
  {
    paramsoc.jdField_a_of_type_Soc = this;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramsoc);
  }
  
  public abstract void a(List<T> paramList);
  
  public void a(soe paramsoe)
  {
    this.jdField_a_of_type_Soe = paramsoe;
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
    if (this.jdField_a_of_type_Soe == null) {
      this.jdField_a_of_type_Soe = a();
    }
    if (this.jdField_a_of_type_Sod == null) {
      this.jdField_a_of_type_Sod = a();
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
        ((soc)this.jdField_a_of_type_JavaUtilHashMap.get(str)).l();
      }
      break;
      if (this.jdField_a_of_type_Sod != null) {
        this.jdField_a_of_type_Sod.a();
      } else {
        a(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     soc
 * JD-Core Version:    0.7.0.1
 */