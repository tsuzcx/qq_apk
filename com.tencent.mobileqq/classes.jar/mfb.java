import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mfb
{
  private final int jdField_a_of_type_Int = 1000;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private mfc jdField_a_of_type_Mfc = new mfc(this, Looper.getMainLooper());
  private volatile mfd jdField_a_of_type_Mfd;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int = 256;
  private volatile mfd jdField_b_of_type_Mfd;
  private boolean jdField_b_of_type_Boolean;
  
  public mfb(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_Mfd != null) && (this.jdField_a_of_type_Mfd.a())) {
      return this.jdField_a_of_type_Mfd.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_b_of_type_Mfd != null) {
      return this.jdField_b_of_type_Mfd.jdField_a_of_type_JavaLangString;
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Mfd != null) && (this.jdField_a_of_type_Mfd.a())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_Mfd = null;
      }
      String str = a();
      a(str);
      if ((this.jdField_a_of_type_Mfc != null) && (this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_Mfc.hasMessages(256))) {
        this.jdField_a_of_type_Mfc.sendEmptyMessageDelayed(256, 1000L);
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
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690317);
    case 1: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690307);
    case 2: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690318);
    case 3: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690308);
    case 4: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695925);
    case 5: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690309);
    case 6: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690312);
    case 7: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690310);
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690311);
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
      ((lli)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(this);
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
    mfd localmfd = new mfd();
    localmfd.jdField_a_of_type_Long = System.currentTimeMillis();
    localmfd.jdField_a_of_type_Boolean = paramBoolean;
    localmfd.b = paramLong;
    localmfd.jdField_a_of_type_JavaLangString = a(paramInt);
    a(localmfd);
  }
  
  public void a(View paramView)
  {
    a((ViewGroup)paramView.findViewById(2131372890), (TextView)paramView.findViewById(2131372620));
  }
  
  public void a(mfd parammfd)
  {
    this.jdField_a_of_type_Mfd = parammfd;
    if (parammfd.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Mfd = parammfd;
    }
    if (this.jdField_a_of_type_Mfc != null)
    {
      this.jdField_a_of_type_Mfc.removeMessages(256);
      this.jdField_a_of_type_Mfc.sendEmptyMessage(256);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Mfd == this.jdField_b_of_type_Mfd) {
        this.jdField_a_of_type_Mfd = null;
      }
      this.jdField_b_of_type_Mfd = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mfc != null)
      {
        this.jdField_a_of_type_Mfc.removeMessages(256);
        this.jdField_a_of_type_Mfc.sendEmptyMessage(256);
      }
      return;
      this.jdField_a_of_type_Mfd = null;
    }
  }
  
  public void b()
  {
    if (AudioHelper.e()) {
      QLog.w("DeviceTipsController", 1, "detach, isAttach[" + this.jdField_b_of_type_Boolean + "]");
    }
    if (this.jdField_b_of_type_Boolean) {
      ((lli)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(null);
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
    this.jdField_a_of_type_Mfd = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Mfd = null;
    if (this.jdField_a_of_type_Mfc != null) {
      this.jdField_a_of_type_Mfc.removeMessages(256);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mfb
 * JD-Core Version:    0.7.0.1
 */