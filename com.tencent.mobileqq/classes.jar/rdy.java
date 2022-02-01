import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Calendar;

public class rdy
{
  public static int a;
  private static rdy jdField_a_of_type_Rdy;
  private SparseArray<rdz> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
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
  
  public static rdy a()
  {
    try
    {
      if (jdField_a_of_type_Rdy == null) {
        jdField_a_of_type_Rdy = new rdy();
      }
      rdy localrdy = jdField_a_of_type_Rdy;
      return localrdy;
    }
    finally {}
  }
  
  private rdz a(int paramInt)
  {
    rdz localrdz2 = (rdz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    rdz localrdz1 = localrdz2;
    if (localrdz2 == null)
    {
      localrdz1 = rea.a(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localrdz1);
    }
    return localrdz1;
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, int paramInt, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    rdz localrdz = a(paramInt);
    if (localrdz == null) {
      return "";
    }
    return localrdz.a(paramBaseArticleInfo, paramTemplateBean, paramViewBase);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    rdz localrdz = a(paramInt);
    if (localrdz == null) {
      return;
    }
    localrdz.a(paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    rdz localrdz = a(paramInt);
    if (localrdz == null) {
      return;
    }
    localrdz.a(paramObject);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, int paramInt)
  {
    rdz localrdz = a(paramInt);
    if (localrdz == null) {
      return false;
    }
    return localrdz.a(paramBaseArticleInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdy
 * JD-Core Version:    0.7.0.1
 */