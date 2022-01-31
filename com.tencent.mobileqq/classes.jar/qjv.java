import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Calendar;

public class qjv
{
  public static int a;
  private static qjv jdField_a_of_type_Qjv;
  private SparseArray<qjw> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
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
  
  public static qjv a()
  {
    try
    {
      if (jdField_a_of_type_Qjv == null) {
        jdField_a_of_type_Qjv = new qjv();
      }
      qjv localqjv = jdField_a_of_type_Qjv;
      return localqjv;
    }
    finally {}
  }
  
  private qjw a(int paramInt)
  {
    qjw localqjw2 = (qjw)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    qjw localqjw1 = localqjw2;
    if (localqjw2 == null)
    {
      localqjw1 = qjx.a(paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localqjw1);
    }
    return localqjw1;
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, int paramInt, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    qjw localqjw = a(paramInt);
    if (localqjw == null) {
      return "";
    }
    return localqjw.a(paramBaseArticleInfo, paramTemplateBean, paramViewBase);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    qjw localqjw = a(paramInt);
    if (localqjw == null) {
      return;
    }
    localqjw.a(paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    qjw localqjw = a(paramInt);
    if (localqjw == null) {
      return;
    }
    localqjw.a(paramObject);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, int paramInt)
  {
    qjw localqjw = a(paramInt);
    if (localqjw == null) {
      return false;
    }
    return localqjw.a(paramBaseArticleInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qjv
 * JD-Core Version:    0.7.0.1
 */