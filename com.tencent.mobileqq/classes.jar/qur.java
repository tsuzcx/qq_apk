import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Calendar;

public class qur
{
  public static int a;
  private static qur jdField_a_of_type_Qur;
  private SparseArray<qus> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
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
  
  public static qur a()
  {
    try
    {
      if (jdField_a_of_type_Qur == null) {
        jdField_a_of_type_Qur = new qur();
      }
      qur localqur = jdField_a_of_type_Qur;
      return localqur;
    }
    finally {}
  }
  
  private qus a(int paramInt)
  {
    qus localqus2 = (qus)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    qus localqus1 = localqus2;
    if (localqus2 == null)
    {
      localqus1 = qut.a(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localqus1);
    }
    return localqus1;
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, int paramInt, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    qus localqus = a(paramInt);
    if (localqus == null) {
      return "";
    }
    return localqus.a(paramBaseArticleInfo, paramTemplateBean, paramViewBase);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    qus localqus = a(paramInt);
    if (localqus == null) {
      return;
    }
    localqus.a(paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    qus localqus = a(paramInt);
    if (localqus == null) {
      return;
    }
    localqus.a(paramObject);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, int paramInt)
  {
    qus localqus = a(paramInt);
    if (localqus == null) {
      return false;
    }
    return localqus.a(paramBaseArticleInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qur
 * JD-Core Version:    0.7.0.1
 */