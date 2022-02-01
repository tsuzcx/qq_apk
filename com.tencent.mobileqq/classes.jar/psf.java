import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class psf
{
  private Context jdField_a_of_type_AndroidContentContext;
  private HashMap<Integer, pnq> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private pne jdField_a_of_type_Pne;
  private pnq jdField_a_of_type_Pnq = new psn(this);
  private pnq b = new pso(this);
  private pnq c = new psp(this);
  private pnq d = new psr(this);
  private pnq e = new pss(this);
  private pnq f = new pst(this);
  private pnq g = new psg(this);
  private pnq h = new psh(this);
  private pnq i = new psi(this);
  private pnq j = new psj(this);
  private pnq k = new psl(this);
  
  public psf(pne parampne)
  {
    this.jdField_a_of_type_Pne = parampne;
    this.jdField_a_of_type_AndroidContentContext = parampne.a().a();
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376170), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368626), this.c);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369334), this.c);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369993), this.d);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376672), this.d);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369992), this.jdField_a_of_type_Pnq);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376671), this.jdField_a_of_type_Pnq);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368501), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380944), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131366712), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131381023), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380937), this.f);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131373326), this.g);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131370023), this.h);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376705), this.h);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367847), this.i);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367849), this.i);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368627), this.j);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362038), this.k);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362116), this.k);
  }
  
  public void a(View paramView)
  {
    pnq localpnq = (pnq)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
    if (localpnq != null)
    {
      localpnq.onClick(paramView);
      return;
    }
    QLog.e("RIJVideoHandleClick", 1, "onClick, has no click handler for id(" + paramView.getId() + "}");
  }
  
  public boolean a(View paramView)
  {
    if (paramView.getId() == 2131368626)
    {
      b(paramView);
      return true;
    }
    return false;
  }
  
  public void b(View paramView)
  {
    paramView = (sxh)paramView.getTag();
    paramView = this.jdField_a_of_type_Pne.a(paramView.a);
    if (paramView == null) {
      return;
    }
    qgx.a().a(this.jdField_a_of_type_AndroidContentContext, 2, new psm(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psf
 * JD-Core Version:    0.7.0.1
 */