import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Calendar;

public class rbp
{
  public static int a;
  private static rbp jdField_a_of_type_Rbp;
  private SparseArray<rbq> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
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
  
  public static rbp a()
  {
    try
    {
      if (jdField_a_of_type_Rbp == null) {
        jdField_a_of_type_Rbp = new rbp();
      }
      rbp localrbp = jdField_a_of_type_Rbp;
      return localrbp;
    }
    finally {}
  }
  
  private rbq a(int paramInt)
  {
    rbq localrbq2 = (rbq)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    rbq localrbq1 = localrbq2;
    if (localrbq2 == null)
    {
      localrbq1 = rbr.a(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localrbq1);
    }
    return localrbq1;
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, int paramInt, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    rbq localrbq = a(paramInt);
    if (localrbq == null) {
      return "";
    }
    return localrbq.a(paramBaseArticleInfo, paramTemplateBean, paramViewBase);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    rbq localrbq = a(paramInt);
    if (localrbq == null) {
      return;
    }
    localrbq.a(paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    rbq localrbq = a(paramInt);
    if (localrbq == null) {
      return;
    }
    localrbq.a(paramObject);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, int paramInt)
  {
    rbq localrbq = a(paramInt);
    if (localrbq == null) {
      return false;
    }
    return localrbq.a(paramBaseArticleInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbp
 * JD-Core Version:    0.7.0.1
 */