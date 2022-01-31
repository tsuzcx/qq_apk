import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Calendar;

public class qad
{
  public static int a;
  private static qad jdField_a_of_type_Qad;
  private SparseArray<qae> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
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
  
  public static qad a()
  {
    try
    {
      if (jdField_a_of_type_Qad == null) {
        jdField_a_of_type_Qad = new qad();
      }
      qad localqad = jdField_a_of_type_Qad;
      return localqad;
    }
    finally {}
  }
  
  private qae a(int paramInt)
  {
    qae localqae2 = (qae)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    qae localqae1 = localqae2;
    if (localqae2 == null)
    {
      localqae1 = qaf.a(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localqae1);
    }
    return localqae1;
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, int paramInt, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    qae localqae = a(paramInt);
    if (localqae == null) {
      return "";
    }
    return localqae.a(paramBaseArticleInfo, paramTemplateBean, paramViewBase);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    qae localqae = a(paramInt);
    if (localqae == null) {
      return;
    }
    localqae.a(paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    qae localqae = a(paramInt);
    if (localqae == null) {
      return;
    }
    localqae.a(paramObject);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, int paramInt)
  {
    qae localqae = a(paramInt);
    if (localqae == null) {
      return false;
    }
    return localqae.a(paramBaseArticleInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qad
 * JD-Core Version:    0.7.0.1
 */