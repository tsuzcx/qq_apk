import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mdb
{
  private final int jdField_a_of_type_Int = 1000;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private mdc jdField_a_of_type_Mdc = new mdc(this, Looper.getMainLooper());
  private volatile mdd jdField_a_of_type_Mdd;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int = 256;
  private volatile mdd jdField_b_of_type_Mdd;
  private boolean jdField_b_of_type_Boolean;
  
  public mdb(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_Mdd != null) && (this.jdField_a_of_type_Mdd.a())) {
      return this.jdField_a_of_type_Mdd.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_b_of_type_Mdd != null) {
      return this.jdField_b_of_type_Mdd.jdField_a_of_type_JavaLangString;
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Mdd != null) && (this.jdField_a_of_type_Mdd.a())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_Mdd = null;
      }
      String str = a();
      a(str);
      if ((this.jdField_a_of_type_Mdc != null) && (this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_Mdc.hasMessages(256))) {
        this.jdField_a_of_type_Mdc.sendEmptyMessageDelayed(256, 1000L);
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
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690159);
    case 1: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690148);
    case 2: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690160);
    case 3: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690149);
    case 4: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131694845);
    case 5: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690150);
    case 6: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690154);
    case 7: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690151);
    case 8: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690153);
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690152);
  }
  
  public void a()
  {
    if (AudioHelper.f()) {
      QLog.w("DeviceTipsController", 1, "attach, isAttach[" + this.jdField_b_of_type_Boolean + "]");
    }
    if (this.jdField_b_of_type_Boolean) {
      b();
    }
    if (!this.jdField_b_of_type_Boolean) {
      ((lin)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(this);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
  }
  
  public void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, false);
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    mdd localmdd = new mdd();
    localmdd.jdField_a_of_type_Long = System.currentTimeMillis();
    localmdd.jdField_a_of_type_Boolean = paramBoolean;
    localmdd.b = paramLong;
    localmdd.jdField_a_of_type_JavaLangString = a(paramInt);
    a(localmdd);
  }
  
  public void a(View paramView)
  {
    a((ViewGroup)paramView.findViewById(2131373629), (TextView)paramView.findViewById(2131373359));
  }
  
  public void a(mdd parammdd)
  {
    this.jdField_a_of_type_Mdd = parammdd;
    if (parammdd.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Mdd = parammdd;
    }
    if (this.jdField_a_of_type_Mdc != null)
    {
      this.jdField_a_of_type_Mdc.removeMessages(256);
      this.jdField_a_of_type_Mdc.sendEmptyMessage(256);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Mdd == this.jdField_b_of_type_Mdd) {
        this.jdField_a_of_type_Mdd = null;
      }
      this.jdField_b_of_type_Mdd = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mdc != null)
      {
        this.jdField_a_of_type_Mdc.removeMessages(256);
        this.jdField_a_of_type_Mdc.sendEmptyMessage(256);
      }
      return;
      this.jdField_a_of_type_Mdd = null;
    }
  }
  
  public void b()
  {
    if (AudioHelper.f()) {
      QLog.w("DeviceTipsController", 1, "detach, isAttach[" + this.jdField_b_of_type_Boolean + "]");
    }
    if (this.jdField_b_of_type_Boolean) {
      ((lin)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(null);
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
    this.jdField_a_of_type_Mdd = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Mdd = null;
    if (this.jdField_a_of_type_Mdc != null) {
      this.jdField_a_of_type_Mdc.removeMessages(256);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mdb
 * JD-Core Version:    0.7.0.1
 */