import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mcm
{
  private final int jdField_a_of_type_Int = 1000;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private mcn jdField_a_of_type_Mcn = new mcn(this, Looper.getMainLooper());
  private volatile mco jdField_a_of_type_Mco;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int = 256;
  private boolean jdField_b_of_type_Boolean;
  
  public mcm(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_Mco != null) && (this.jdField_a_of_type_Mco.a())) {
      return this.jdField_a_of_type_Mco.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private void a(ViewGroup paramViewGroup, TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Mco != null) && (this.jdField_a_of_type_Mco.a())) {}
    for (int i = 1;; i = 0)
    {
      a(a());
      if ((this.jdField_a_of_type_Mcn != null) && (i != 0) && (!this.jdField_a_of_type_Mcn.hasMessages(256))) {
        this.jdField_a_of_type_Mcn.sendEmptyMessageDelayed(256, 1000L);
      }
      return;
    }
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690266);
    case 1: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690257);
    case 2: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690267);
    case 3: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690258);
    case 4: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695763);
    case 5: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690259);
    case 6: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690261);
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690260);
  }
  
  public void a()
  {
    if (AudioHelper.e()) {
      QLog.w("DeviceTipsController", 1, "attach, isAttach[" + this.jdField_b_of_type_Boolean + "]");
    }
    if (this.jdField_b_of_type_Boolean) {
      b();
    }
    if (!this.jdField_b_of_type_Boolean) {
      ((ljf)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(this);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
  }
  
  public void a(int paramInt, long paramLong)
  {
    mco localmco = new mco();
    localmco.jdField_a_of_type_Long = System.currentTimeMillis();
    localmco.b = paramLong;
    localmco.jdField_a_of_type_JavaLangString = a(paramInt);
    a(localmco);
  }
  
  public void a(View paramView)
  {
    a((ViewGroup)paramView.findViewById(2131372508), (TextView)paramView.findViewById(2131372238));
  }
  
  public void a(mco parammco)
  {
    this.jdField_a_of_type_Mco = parammco;
    if (this.jdField_a_of_type_Mcn != null)
    {
      this.jdField_a_of_type_Mcn.removeMessages(256);
      this.jdField_a_of_type_Mcn.sendEmptyMessage(256);
    }
  }
  
  public void b()
  {
    if (AudioHelper.e()) {
      QLog.w("DeviceTipsController", 1, "detach, isAttach[" + this.jdField_b_of_type_Boolean + "]");
    }
    if (this.jdField_b_of_type_Boolean) {
      ((ljf)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(null);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void c()
  {
    a();
  }
  
  public void d() {}
  
  public void e()
  {
    if (this.jdField_b_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_Mco = null;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Mcn != null) {
      this.jdField_a_of_type_Mcn.removeMessages(256);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mcm
 * JD-Core Version:    0.7.0.1
 */