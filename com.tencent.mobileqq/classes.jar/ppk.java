import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ppk
{
  private HashMap<Integer, pnq> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private pne jdField_a_of_type_Pne;
  private pnq jdField_a_of_type_Pnq = new ppl(this);
  private pnq b = new ppm(this);
  private pnq c = new ppn(this);
  
  public ppk(pne parampne)
  {
    this.jdField_a_of_type_Pne = parampne;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376555), this.jdField_a_of_type_Pnq);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376165), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368381), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131361878), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131370021), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376703), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362037), this.c);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380472), this.c);
  }
  
  private void a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    pkh.a(paramContext, pjj.k + bhcu.encodeToString(String.valueOf(paramString).getBytes(), 2));
  }
  
  public void a(View paramView)
  {
    pnq localpnq = (pnq)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
    if (localpnq != null)
    {
      localpnq.onClick(paramView);
      return;
    }
    QLog.e("RIJFrameworkHandleClick", 1, "onClick, has no click handler for id(" + paramView.getId() + "}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppk
 * JD-Core Version:    0.7.0.1
 */