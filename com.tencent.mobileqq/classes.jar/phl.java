import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class phl
{
  private Context jdField_a_of_type_AndroidContentContext;
  private HashMap<Integer, pen> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ped jdField_a_of_type_Ped;
  private pen jdField_a_of_type_Pen = new phr(this);
  private pen b = new phs(this);
  private pen c = new pht(this);
  private pen d = new phu(this);
  private pen e = new phv(this);
  private pen f = new phw(this);
  private pen g = new phx(this);
  private pen h = new phm(this);
  private pen i = new phn(this);
  private pen j = new pho(this);
  private pen k = new phq(this);
  
  public phl(ped paramped)
  {
    this.jdField_a_of_type_Ped = paramped;
    this.jdField_a_of_type_AndroidContentContext = paramped.a().a();
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131375923), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368469), this.c);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369172), this.c);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369823), this.d);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376417), this.d);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369822), this.jdField_a_of_type_Pen);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376416), this.jdField_a_of_type_Pen);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368344), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380598), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131366601), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380674), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380591), this.f);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131373115), this.g);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369853), this.h);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376450), this.h);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367711), this.i);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367713), this.i);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368470), this.j);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362033), this.k);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362112), this.k);
  }
  
  public void a(View paramView)
  {
    pen localpen = (pen)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
    if (localpen != null)
    {
      localpen.onClick(paramView);
      return;
    }
    QLog.e("RIJVideoHandleClick", 1, "onClick, has no click handler for id(" + paramView.getId() + "}");
  }
  
  public boolean a(View paramView)
  {
    if (paramView.getId() == 2131368469)
    {
      b(paramView);
      return true;
    }
    return false;
  }
  
  public void b(View paramView)
  {
    paramView = (sjy)paramView.getTag();
    paramView = this.jdField_a_of_type_Ped.a(paramView.a);
    if (paramView == null) {
      return;
    }
    if (oof.b() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      phy.a(true, bool, paramView, (Activity)this.jdField_a_of_type_Ped.a().a(), this.jdField_a_of_type_Ped.a().b(), this.jdField_a_of_type_Ped.a().a(), this.jdField_a_of_type_Ped.a().a());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phl
 * JD-Core Version:    0.7.0.1
 */