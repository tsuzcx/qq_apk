import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Calendar;

public class poi
{
  public static int a;
  private static poi jdField_a_of_type_Poi;
  private SparseArray<poj> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
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
  
  public static poi a()
  {
    try
    {
      if (jdField_a_of_type_Poi == null) {
        jdField_a_of_type_Poi = new poi();
      }
      poi localpoi = jdField_a_of_type_Poi;
      return localpoi;
    }
    finally {}
  }
  
  private poj a(int paramInt)
  {
    poj localpoj2 = (poj)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    poj localpoj1 = localpoj2;
    if (localpoj2 == null)
    {
      localpoj1 = pok.a(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localpoj1);
    }
    return localpoj1;
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, int paramInt, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    poj localpoj = a(paramInt);
    if (localpoj == null) {
      return "";
    }
    return localpoj.a(paramBaseArticleInfo, paramTemplateBean, paramViewBase);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    poj localpoj = a(paramInt);
    if (localpoj == null) {
      return;
    }
    localpoj.a(paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    poj localpoj = a(paramInt);
    if (localpoj == null) {
      return;
    }
    localpoj.a(paramObject);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, int paramInt)
  {
    poj localpoj = a(paramInt);
    if (localpoj == null) {
      return false;
    }
    return localpoj.a(paramBaseArticleInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     poi
 * JD-Core Version:    0.7.0.1
 */