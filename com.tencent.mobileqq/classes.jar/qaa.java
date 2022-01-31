import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Calendar;

public class qaa
{
  public static int a;
  private static qaa jdField_a_of_type_Qaa;
  private SparseArray<qab> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public static String a()
  {
    Calendar localCalendar = Calendar.getInstance();
    if (localCalendar == null) {
      return "";
    }
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    return String.valueOf(i) + j + k;
  }
  
  public static qaa a()
  {
    try
    {
      if (jdField_a_of_type_Qaa == null) {
        jdField_a_of_type_Qaa = new qaa();
      }
      qaa localqaa = jdField_a_of_type_Qaa;
      return localqaa;
    }
    finally {}
  }
  
  private qab a(int paramInt)
  {
    qab localqab2 = (qab)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    qab localqab1 = localqab2;
    if (localqab2 == null)
    {
      localqab1 = qac.a(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localqab1);
    }
    return localqab1;
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, int paramInt, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    qab localqab = a(paramInt);
    if (localqab == null) {
      return "";
    }
    return localqab.a(paramBaseArticleInfo, paramTemplateBean, paramViewBase);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    qab localqab = a(paramInt);
    if (localqab == null) {
      return;
    }
    localqab.a(paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    qab localqab = a(paramInt);
    if (localqab == null) {
      return;
    }
    localqab.a(paramObject);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, int paramInt)
  {
    qab localqab = a(paramInt);
    if (localqab == null) {
      return false;
    }
    return localqab.a(paramBaseArticleInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qaa
 * JD-Core Version:    0.7.0.1
 */