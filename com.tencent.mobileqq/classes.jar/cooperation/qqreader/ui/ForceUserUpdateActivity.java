package cooperation.qqreader.ui;

import Override;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.TextView;
import bhnv;
import bmpi;
import bmqa;
import bmql;
import bmqm;
import bmqn;
import bmqo;
import bmqp;
import bmqu;
import bmqw;
import bmrk;
import bmrn;
import bmro;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.net.BusinessTask;
import cooperation.qqreader.view.FrameLoading;
import cooperation.qqreader.view.LoadingImageView;
import mqq.os.MqqHandler;

public class ForceUserUpdateActivity
  extends Activity
{
  private long jdField_a_of_type_Long = -1L;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmqa jdField_a_of_type_Bmqa = new bmql(this);
  private bmrk jdField_a_of_type_Bmrk;
  private LoadingImageView jdField_a_of_type_CooperationQqreaderViewLoadingImageView;
  private boolean jdField_a_of_type_Boolean;
  private bmqa b = new bmqm(this);
  private bmqa c = new bmqn(this);
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_CooperationQqreaderViewLoadingImageView.setVisibility(8);
    ThreadManager.getUIHandler().postDelayed(new ForceUserUpdateActivity.1(this), 300L);
  }
  
  private void a(int paramInt)
  {
    paramInt = Math.max(paramInt, 5);
    ThreadManager.getUIHandler().postDelayed(new ForceUserUpdateActivity.2(this), paramInt * 1000);
  }
  
  private void a(String paramString)
  {
    bmqw.a("ForceUserUpdateActivity", paramString);
    b("哎呀，升级出了点问题，再试试看吧~");
  }
  
  private void b()
  {
    if (!bhnv.a()) {
      b("网络连接异常，请检查网络后重试");
    }
    do
    {
      return;
      if (!bmpi.a()) {
        c();
      }
    } while (bmqu.d(this));
    e();
  }
  
  private void b(String paramString)
  {
    if ((isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (isDestroyed()))) {
      bmqw.c("ForceUserUpdateActivity", "showRetryDialog: activity 已经销毁，不显示Dialog");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bmrk == null) {
        this.jdField_a_of_type_Bmrk = new bmrn(this).a(paramString).a("退出", new bmqp(this)).b("重试", new bmqo(this)).a();
      }
    } while (this.jdField_a_of_type_Bmrk.isShowing());
    this.jdField_a_of_type_Bmrk.show();
  }
  
  private void c()
  {
    BusinessTask localBusinessTask = new BusinessTask("QueryUserGrayUpdateStateTask");
    localBusinessTask.a(this.b, false);
    localBusinessTask.a();
  }
  
  private void d()
  {
    BusinessTask localBusinessTask = new BusinessTask("UpdateToQQBookstoreTask");
    localBusinessTask.a(this.c, false);
    localBusinessTask.a();
  }
  
  private void e()
  {
    bmro.a(bmro.a, this.jdField_a_of_type_Bmqa);
  }
  
  private void f()
  {
    bmqu.b(this.jdField_a_of_type_AndroidContentContext, 1);
    g();
  }
  
  private void g()
  {
    long l2 = 1000L;
    long l1;
    if ((!this.jdField_a_of_type_Boolean) && (bmpi.a()) && (bmqu.d(this.jdField_a_of_type_AndroidContentContext)))
    {
      if (this.jdField_a_of_type_Long <= 0L) {
        break label74;
      }
      l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (1000L - l1 <= 0L) {
        break label79;
      }
      l1 = l2;
    }
    label74:
    label79:
    for (;;)
    {
      ThreadManager.getUIHandler().postDelayed(new ForceUserUpdateActivity.8(this), l1);
      return;
      l1 = 0L;
      break;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    this.jdField_a_of_type_AndroidContentContext = this;
    paramBundle = new FrameLoading(this);
    paramBundle.setBackgroundColor(-1);
    setContentView(paramBundle);
    this.jdField_a_of_type_AndroidWidgetTextView = paramBundle.jdField_a_of_type_AndroidWidgetTextView;
    this.jdField_a_of_type_CooperationQqreaderViewLoadingImageView = paramBundle.jdField_a_of_type_CooperationQqreaderViewLoadingImageView;
    this.jdField_a_of_type_AndroidWidgetTextView.setText("正在升级到新书城，请稍等...");
    a();
    b();
    bmqw.c("cost_time_tag", "ForceUserUpdateActivity mClickToOnCreateTime=" + (System.currentTimeMillis() - getIntent().getLongExtra("key_click_leba_start_time", 0L)));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Bmrk != null) && (this.jdField_a_of_type_Bmrk.isShowing()))
    {
      this.jdField_a_of_type_Bmrk.dismiss();
      this.jdField_a_of_type_Bmrk = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.ui.ForceUserUpdateActivity
 * JD-Core Version:    0.7.0.1
 */