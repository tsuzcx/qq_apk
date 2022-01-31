package cooperation.qqreader.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import bbfj;
import bgup;
import bgvh;
import bgvu;
import bgvv;
import bgvw;
import bgvx;
import bgvy;
import bgwd;
import bgwf;
import bgwv;
import bgwy;
import bgwz;
import com.tencent.mobileqq.app.ThreadManager;
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
  private bgvh jdField_a_of_type_Bgvh = new bgvu(this);
  private bgwv jdField_a_of_type_Bgwv;
  private LoadingImageView jdField_a_of_type_CooperationQqreaderViewLoadingImageView;
  private boolean jdField_a_of_type_Boolean;
  private bgvh b = new bgvv(this);
  private bgvh c = new bgvw(this);
  
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
    bgwf.a("ForceUserUpdateActivity", paramString);
    b("哎呀，升级出了点问题，再试试看吧~");
  }
  
  private void b()
  {
    if (!bbfj.a()) {
      b("网络连接异常，请检查网络后重试");
    }
    do
    {
      return;
      if (!bgup.a()) {
        c();
      }
    } while (bgwd.d(this));
    e();
  }
  
  private void b(String paramString)
  {
    if ((isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (isDestroyed()))) {
      bgwf.c("ForceUserUpdateActivity", "showRetryDialog: activity 已经销毁，不显示Dialog");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bgwv == null) {
        this.jdField_a_of_type_Bgwv = new bgwy(this).a(paramString).a("退出", new bgvy(this)).b("重试", new bgvx(this)).a();
      }
    } while (this.jdField_a_of_type_Bgwv.isShowing());
    this.jdField_a_of_type_Bgwv.show();
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
    bgwz.a(bgwz.a, this.jdField_a_of_type_Bgvh);
  }
  
  private void f()
  {
    bgwd.b(this.jdField_a_of_type_AndroidContentContext, 1);
    g();
  }
  
  private void g()
  {
    long l2 = 1000L;
    long l1;
    if ((!this.jdField_a_of_type_Boolean) && (bgup.a()) && (bgwd.d(this.jdField_a_of_type_AndroidContentContext)))
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
    bgwf.c("cost_time_tag", "ForceUserUpdateActivity mClickToOnCreateTime=" + (System.currentTimeMillis() - getIntent().getLongExtra("key_click_leba_start_time", 0L)));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Bgwv != null) && (this.jdField_a_of_type_Bgwv.isShowing()))
    {
      this.jdField_a_of_type_Bgwv.dismiss();
      this.jdField_a_of_type_Bgwv = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.ui.ForceUserUpdateActivity
 * JD-Core Version:    0.7.0.1
 */