import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class pgg
{
  private HashMap<Integer, pen> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ped jdField_a_of_type_Ped;
  private pen jdField_a_of_type_Pen = new pgh(this);
  private pen b = new pgi(this);
  private pen c = new pgj(this);
  
  public pgg(ped paramped)
  {
    this.jdField_a_of_type_Ped = paramped;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376300), this.jdField_a_of_type_Pen);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131375918), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368236), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131361876), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369851), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376448), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362032), this.c);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380137), this.c);
  }
  
  private void a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    pay.a(paramContext, paa.k + bfuc.encodeToString(String.valueOf(paramString).getBytes(), 2));
  }
  
  public void a(View paramView)
  {
    pen localpen = (pen)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
    if (localpen != null)
    {
      localpen.onClick(paramView);
      return;
    }
    QLog.e("RIJFrameworkHandleClick", 1, "onClick, has no click handler for id(" + paramView.getId() + "}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgg
 * JD-Core Version:    0.7.0.1
 */