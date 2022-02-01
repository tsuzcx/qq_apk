import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mck
{
  private final int jdField_a_of_type_Int = 1000;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private mcl jdField_a_of_type_Mcl = new mcl(this, Looper.getMainLooper());
  private volatile mcm jdField_a_of_type_Mcm;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int = 256;
  private volatile mcm jdField_b_of_type_Mcm;
  private boolean jdField_b_of_type_Boolean;
  
  public mck(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_Mcm != null) && (this.jdField_a_of_type_Mcm.a())) {
      return this.jdField_a_of_type_Mcm.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_b_of_type_Mcm != null) {
      return this.jdField_b_of_type_Mcm.jdField_a_of_type_JavaLangString;
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Mcm != null) && (this.jdField_a_of_type_Mcm.a())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_Mcm = null;
      }
      String str = a();
      a(str);
      if ((this.jdField_a_of_type_Mcl != null) && (this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_Mcl.hasMessages(256))) {
        this.jdField_a_of_type_Mcl.sendEmptyMessageDelayed(256, 1000L);
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
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690184);
    case 1: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690171);
    case 2: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690185);
    case 3: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690172);
    case 4: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131694983);
    case 5: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690173);
    case 6: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690179);
    case 7: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690174);
    case 8: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690178);
    case 9: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690175);
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690176);
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
      ((lih)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(this);
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
    mcm localmcm = new mcm();
    localmcm.jdField_a_of_type_Long = System.currentTimeMillis();
    localmcm.jdField_a_of_type_Boolean = paramBoolean;
    localmcm.b = paramLong;
    localmcm.jdField_a_of_type_JavaLangString = a(paramInt);
    a(localmcm);
  }
  
  public void a(View paramView)
  {
    a((ViewGroup)paramView.findViewById(2131373545), (TextView)paramView.findViewById(2131373275));
  }
  
  public void a(mcm parammcm)
  {
    this.jdField_a_of_type_Mcm = parammcm;
    if (parammcm.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Mcm = parammcm;
    }
    if (this.jdField_a_of_type_Mcl != null)
    {
      this.jdField_a_of_type_Mcl.removeMessages(256);
      this.jdField_a_of_type_Mcl.sendEmptyMessage(256);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Mcm == this.jdField_b_of_type_Mcm) {
        this.jdField_a_of_type_Mcm = null;
      }
      this.jdField_b_of_type_Mcm = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mcl != null)
      {
        this.jdField_a_of_type_Mcl.removeMessages(256);
        this.jdField_a_of_type_Mcl.sendEmptyMessage(256);
      }
      return;
      this.jdField_a_of_type_Mcm = null;
    }
  }
  
  public void b()
  {
    if (AudioHelper.f()) {
      QLog.w("DeviceTipsController", 1, "detach, isAttach[" + this.jdField_b_of_type_Boolean + "]");
    }
    if (this.jdField_b_of_type_Boolean) {
      ((lih)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(null);
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
    this.jdField_a_of_type_Mcm = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Mcm = null;
    if (this.jdField_a_of_type_Mcl != null) {
      this.jdField_a_of_type_Mcl.removeMessages(256);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mck
 * JD-Core Version:    0.7.0.1
 */