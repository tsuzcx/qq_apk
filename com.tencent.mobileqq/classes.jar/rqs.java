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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class rqs
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, sgr
{
  private Handler jdField_a_of_type_AndroidOsHandler = new rqt(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup = (ViewGroup)LayoutInflater.from(BaseApplication.getContext()).inflate(2131560043, null, false);
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private rgo jdField_a_of_type_Rgo;
  private sgs jdField_a_of_type_Sgs;
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
  
  private void a(int paramInt)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    this.jdField_a_of_type_AndroidWidgetImageButton.clearAnimation();
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageDrawable(localResources.getDrawable(2130843258));
      this.jdField_a_of_type_AndroidWidgetImageButton.setTag(Integer.valueOf(1));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageDrawable(localResources.getDrawable(2130843257));
    this.jdField_a_of_type_AndroidWidgetImageButton.setTag(Integer.valueOf(2));
  }
  
  private void a(long paramLong)
  {
    int i = (int)(paramLong / 1000L);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(pai.a(i));
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageButton.getVisibility() == 0;
  }
  
  private boolean b()
  {
    return this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376995));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380665));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372727));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380513));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380667));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380534));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365196));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379877));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void e()
  {
    int i = (int)this.jdField_a_of_type_Sgs.a() / 1000;
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(i);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(i);
    a(0L);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(pai.a(i));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(pai.a(0));
  }
  
  private void f()
  {
    this.jdField_a_of_type_Sgs = new sgs(1000);
    this.jdField_a_of_type_Sgs.a(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Sgs.d(true);
    this.jdField_a_of_type_Sgs.e(false);
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 0) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  private void i()
  {
    if (b())
    {
      h();
      return;
    }
    j();
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0) {
      return;
    }
    if (this.jdField_a_of_type_Sgs.g()) {
      a(1);
    }
    for (;;)
    {
      rwv.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, 300);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      if (!this.jdField_a_of_type_Sgs.h()) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
      return;
      if (this.jdField_a_of_type_Sgs.h()) {
        a(2);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Sgs.l();
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
    d();
    f();
    this.jdField_a_of_type_Sgs.a(paramViewGroup);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void a(rgo paramrgo)
  {
    if (paramrgo == null) {
      return;
    }
    this.jdField_a_of_type_Rgo = paramrgo;
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramrgo.d);
    ThreadManager.getUIHandler().post(new SelectVideoUIDelegate.1(this, paramrgo));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Sgs.k();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Sgs.m();
  }
  
  public void onBufferEnd() {}
  
  public void onBufferStart() {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.jdField_a_of_type_AndroidWidgetImageButton.getId()) {
      switch (a(paramView))
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Sgs.c();
      continue;
      this.jdField_a_of_type_Sgs.d();
      continue;
      if (i == this.jdField_c_of_type_AndroidViewViewGroup.getId()) {
        i();
      }
    }
  }
  
  public void onCompletion() {}
  
  public void onFirstFrameRendered() {}
  
  public void onProgressChanged(long paramLong)
  {
    a(paramLong);
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
    this.jdField_a_of_type_Sgs.b(i * 1000);
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoEnd(int paramInt) {}
  
  public void onVideoError(int paramInt1, int paramInt2, String paramString) {}
  
  public void onVideoOpen() {}
  
  public void onVideoPause()
  {
    if (a()) {
      a(1);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
  }
  
  public void onVideoPrepared()
  {
    g();
    this.jdField_a_of_type_Sgs.c();
    ThreadManager.getUIHandler().post(new SelectVideoUIDelegate.2(this));
  }
  
  public void onVideoRestart()
  {
    a(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void onVideoStart()
  {
    a(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void onVideoStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rqs
 * JD-Core Version:    0.7.0.1
 */