import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Calendar;

public class rnv
{
  public static int a;
  private static rnv jdField_a_of_type_Rnv;
  private SparseArray<rnw> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
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
  
  public static rnv a()
  {
    try
    {
      if (jdField_a_of_type_Rnv == null) {
        jdField_a_of_type_Rnv = new rnv();
      }
      rnv localrnv = jdField_a_of_type_Rnv;
      return localrnv;
    }
    finally {}
  }
  
  private rnw a(int paramInt)
  {
    rnw localrnw2 = (rnw)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    rnw localrnw1 = localrnw2;
    if (localrnw2 == null)
    {
      localrnw1 = rnx.a(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localrnw1);
    }
    return localrnw1;
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, int paramInt, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    rnw localrnw = a(paramInt);
    if (localrnw == null) {
      return "";
    }
    return localrnw.a(paramBaseArticleInfo, paramTemplateBean, paramViewBase);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    rnw localrnw = a(paramInt);
    if (localrnw == null) {
      return;
    }
    localrnw.a(paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    rnw localrnw = a(paramInt);
    if (localrnw == null) {
      return;
    }
    localrnw.a(paramObject);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, int paramInt)
  {
    rnw localrnw = a(paramInt);
    if (localrnw == null) {
      return false;
    }
    return localrnw.a(paramBaseArticleInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnv
 * JD-Core Version:    0.7.0.1
 */