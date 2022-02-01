import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mdf
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private mdg jdField_a_of_type_Mdg = new mdg(this, Looper.getMainLooper());
  private volatile mdh jdField_a_of_type_Mdh;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private volatile mdh jdField_b_of_type_Mdh;
  private boolean jdField_b_of_type_Boolean;
  
  public mdf(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_Mdh != null) && (this.jdField_a_of_type_Mdh.a())) {
      return this.jdField_a_of_type_Mdh.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_b_of_type_Mdh != null) {
      return this.jdField_b_of_type_Mdh.jdField_a_of_type_JavaLangString;
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Mdh != null) && (this.jdField_a_of_type_Mdh.a())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_Mdh = null;
      }
      String str = a();
      a(str);
      if ((this.jdField_a_of_type_Mdg != null) && (this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_Mdg.hasMessages(256))) {
        this.jdField_a_of_type_Mdg.sendEmptyMessageDelayed(256, 1000L);
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
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690222);
    case 1: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690209);
    case 2: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690223);
    case 3: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690210);
    case 4: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695199);
    case 5: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690211);
    case 6: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690217);
    case 7: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690212);
    case 8: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690216);
    case 9: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690213);
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690214);
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
      ((lit)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(this);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    a(a(paramInt), paramLong, paramBoolean);
  }
  
  public void a(View paramView)
  {
    a((ViewGroup)paramView.findViewById(2131373758), (TextView)paramView.findViewById(2131373488));
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    mdh localmdh = new mdh();
    localmdh.jdField_a_of_type_Long = System.currentTimeMillis();
    localmdh.jdField_a_of_type_Boolean = paramBoolean;
    localmdh.b = paramLong;
    localmdh.jdField_a_of_type_JavaLangString = paramString;
    a(localmdh);
  }
  
  public void a(mdh parammdh)
  {
    this.jdField_a_of_type_Mdh = parammdh;
    if (parammdh.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Mdh = parammdh;
    }
    if (this.jdField_a_of_type_Mdg != null)
    {
      this.jdField_a_of_type_Mdg.removeMessages(256);
      this.jdField_a_of_type_Mdg.sendEmptyMessage(256);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Mdh == this.jdField_b_of_type_Mdh) {
        this.jdField_a_of_type_Mdh = null;
      }
      this.jdField_b_of_type_Mdh = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mdg != null)
      {
        this.jdField_a_of_type_Mdg.removeMessages(256);
        this.jdField_a_of_type_Mdg.sendEmptyMessage(256);
      }
      return;
      this.jdField_a_of_type_Mdh = null;
    }
  }
  
  public void b()
  {
    if (AudioHelper.f()) {
      QLog.w("DeviceTipsController", 1, "detach, isAttach[" + this.jdField_b_of_type_Boolean + "]");
    }
    if (this.jdField_b_of_type_Boolean) {
      ((lit)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(null);
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
    this.jdField_a_of_type_Mdh = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Mdh = null;
    if (this.jdField_a_of_type_Mdg != null) {
      this.jdField_a_of_type_Mdg.removeMessages(256);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mdf
 * JD-Core Version:    0.7.0.1
 */