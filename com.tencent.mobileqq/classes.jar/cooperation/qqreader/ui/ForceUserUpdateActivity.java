package cooperation.qqreader.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.helper.GrayUpdateManager;
import cooperation.qqreader.net.BusinessTask;
import cooperation.qqreader.net.ReaderCgiListener;
import cooperation.qqreader.utils.Config.UserConfig;
import cooperation.qqreader.utils.Log;
import cooperation.qqreader.view.FrameLoading;
import cooperation.qqreader.view.LoadingImageView;
import cooperation.qqreader.view.SimpleStyledDialog;
import cooperation.qqreader.view.SimpleStyledDialog.Builder;
import cooperation.qqreader.zzconfig.ZzConfigDataUtil;
import mqq.os.MqqHandler;

public class ForceUserUpdateActivity
  extends Activity
{
  private long jdField_a_of_type_Long = -1L;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReaderCgiListener jdField_a_of_type_CooperationQqreaderNetReaderCgiListener = new ForceUserUpdateActivity.3(this);
  private LoadingImageView jdField_a_of_type_CooperationQqreaderViewLoadingImageView;
  private SimpleStyledDialog jdField_a_of_type_CooperationQqreaderViewSimpleStyledDialog;
  private boolean jdField_a_of_type_Boolean;
  private ReaderCgiListener b = new ForceUserUpdateActivity.4(this);
  private ReaderCgiListener c = new ForceUserUpdateActivity.5(this);
  
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
    Log.a("ForceUserUpdateActivity", paramString);
    b("哎呀，升级出了点问题，再试试看吧~");
  }
  
  private void b()
  {
    if (!NetworkUtil.a()) {
      b("网络连接异常，请检查网络后重试");
    }
    do
    {
      return;
      if (!GrayUpdateManager.a()) {
        c();
      }
    } while (Config.UserConfig.d(this));
    e();
  }
  
  private void b(String paramString)
  {
    if ((isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (isDestroyed()))) {
      Log.c("ForceUserUpdateActivity", "showRetryDialog: activity 已经销毁，不显示Dialog");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_CooperationQqreaderViewSimpleStyledDialog == null) {
        this.jdField_a_of_type_CooperationQqreaderViewSimpleStyledDialog = new SimpleStyledDialog.Builder(this).a(paramString).a("退出", new ForceUserUpdateActivity.7(this)).b("重试", new ForceUserUpdateActivity.6(this)).a();
      }
    } while (this.jdField_a_of_type_CooperationQqreaderViewSimpleStyledDialog.isShowing());
    this.jdField_a_of_type_CooperationQqreaderViewSimpleStyledDialog.show();
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
    ZzConfigDataUtil.a(ZzConfigDataUtil.a, this.jdField_a_of_type_CooperationQqreaderNetReaderCgiListener);
  }
  
  private void f()
  {
    Config.UserConfig.b(this.jdField_a_of_type_AndroidContentContext, 1);
    g();
  }
  
  private void g()
  {
    long l2 = 1000L;
    long l1;
    if ((!this.jdField_a_of_type_Boolean) && (GrayUpdateManager.a()) && (Config.UserConfig.d(this.jdField_a_of_type_AndroidContentContext)))
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
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
    Log.c("cost_time_tag", "ForceUserUpdateActivity mClickToOnCreateTime=" + (System.currentTimeMillis() - getIntent().getLongExtra("key_click_leba_start_time", 0L)));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_CooperationQqreaderViewSimpleStyledDialog != null) && (this.jdField_a_of_type_CooperationQqreaderViewSimpleStyledDialog.isShowing()))
    {
      this.jdField_a_of_type_CooperationQqreaderViewSimpleStyledDialog.dismiss();
      this.jdField_a_of_type_CooperationQqreaderViewSimpleStyledDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ForceUserUpdateActivity
 * JD-Core Version:    0.7.0.1
 */