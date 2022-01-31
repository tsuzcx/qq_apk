import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoUIDelegate.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoUIDelegate.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class qwy
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, roc
{
  private Handler jdField_a_of_type_AndroidOsHandler = new qwz(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup = (ViewGroup)LayoutInflater.from(BaseApplication.getContext()).inflate(2131559879, null, false);
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private qnz jdField_a_of_type_Qnz;
  private rod jdField_a_of_type_Rod;
  private boolean jdField_a_of_type_Boolean;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  private int a(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {
      return ((Integer)paramView).intValue();
    }
    return 1;
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageButton.getVisibility() == 0;
  }
  
  private void b(int paramInt)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    this.jdField_a_of_type_AndroidWidgetImageButton.clearAnimation();
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageDrawable(localResources.getDrawable(2130842823));
      this.jdField_a_of_type_AndroidWidgetImageButton.setTag(Integer.valueOf(1));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageDrawable(localResources.getDrawable(2130842822));
    this.jdField_a_of_type_AndroidWidgetImageButton.setTag(Integer.valueOf(2));
  }
  
  private void b(long paramLong)
  {
    int i = (int)(paramLong / 1000L);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(orc.a(i));
  }
  
  private boolean b()
  {
    return this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0;
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376271));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379746));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372057));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379596));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379748));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379616));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364889));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378985));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void o()
  {
    int i = (int)this.jdField_a_of_type_Rod.a() / 1000;
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(i);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(i);
    b(0L);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(orc.a(i));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(orc.a(0));
  }
  
  private void p()
  {
    this.jdField_a_of_type_Rod = new rod(1000);
    this.jdField_a_of_type_Rod.a(this);
  }
  
  private void q()
  {
    this.jdField_a_of_type_Rod.d(true);
    this.jdField_a_of_type_Rod.e(false);
  }
  
  private void r()
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 0) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  private void s()
  {
    if (b())
    {
      r();
      return;
    }
    t();
  }
  
  private void t()
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0) {
      return;
    }
    if (this.jdField_a_of_type_Rod.f()) {
      b(1);
    }
    for (;;)
    {
      rdm.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, 300);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      if (!this.jdField_a_of_type_Rod.g()) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
      return;
      if (this.jdField_a_of_type_Rod.g()) {
        b(2);
      }
    }
  }
  
  public void L_()
  {
    b(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rod.h();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString) {}
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null)
    {
      QLog.e("RIJUGC.SelectVideoUIDelegate", 1, "attachVideoView failed for containerView is null.");
      return;
    }
    this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup;
    paramViewGroup.setEnabled(false);
    n();
    p();
    this.jdField_a_of_type_Rod.a(paramViewGroup);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void a(qnz paramqnz)
  {
    if (paramqnz == null) {
      return;
    }
    this.jdField_a_of_type_Qnz = paramqnz;
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramqnz.d);
    ThreadManager.getUIHandler().post(new SelectVideoUIDelegate.1(this, paramqnz));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rod.g();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rod.i();
  }
  
  public void d()
  {
    q();
    this.jdField_a_of_type_Rod.a();
    ThreadManager.getUIHandler().post(new SelectVideoUIDelegate.2(this));
  }
  
  public void e()
  {
    b(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void f()
  {
    if (a()) {
      b(1);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
  }
  
  public void f_(int paramInt) {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.jdField_a_of_type_AndroidWidgetImageButton.getId()) {
      switch (a(paramView))
      {
      }
    }
    while (i != this.jdField_c_of_type_AndroidViewViewGroup.getId())
    {
      return;
      this.jdField_a_of_type_Rod.a();
      return;
      this.jdField_a_of_type_Rod.b();
      return;
    }
    s();
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.jdField_a_of_type_Boolean = false;
    int i = paramSeekBar.getProgress();
    this.jdField_a_of_type_Rod.b(i * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qwy
 * JD-Core Version:    0.7.0.1
 */