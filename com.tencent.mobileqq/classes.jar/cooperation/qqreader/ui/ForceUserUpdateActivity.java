package cooperation.qqreader.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import badq;
import bflt;
import bfmg;
import bfmt;
import bfmu;
import bfmv;
import bfmw;
import bfmx;
import bfnc;
import bfne;
import bfnx;
import bfoa;
import bfob;
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
  private bfmg jdField_a_of_type_Bfmg = new bfmt(this);
  private bfnx jdField_a_of_type_Bfnx;
  private LoadingImageView jdField_a_of_type_CooperationQqreaderViewLoadingImageView;
  private boolean jdField_a_of_type_Boolean;
  private bfmg b = new bfmu(this);
  private bfmg c = new bfmv(this);
  
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
    bfne.a("ForceUserUpdateActivity", paramString);
    b("哎呀，升级出了点问题，再试试看吧~");
  }
  
  private void b()
  {
    if (!badq.a()) {
      b("网络连接异常，请检查网络后重试");
    }
    do
    {
      return;
      if (!bflt.a()) {
        c();
      }
    } while (bfnc.c(this));
    e();
  }
  
  private void b(String paramString)
  {
    if ((isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (isDestroyed()))) {
      bfne.b("ForceUserUpdateActivity", "showRetryDialog: activity 已经销毁，不显示Dialog");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bfnx == null) {
        this.jdField_a_of_type_Bfnx = new bfoa(this).a(paramString).a("退出", new bfmx(this)).b("重试", new bfmw(this)).a();
      }
    } while (this.jdField_a_of_type_Bfnx.isShowing());
    this.jdField_a_of_type_Bfnx.show();
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
    bfob.a(bfob.a, this.jdField_a_of_type_Bfmg);
  }
  
  private void f()
  {
    bfnc.b(this.jdField_a_of_type_AndroidContentContext, 1);
    g();
  }
  
  private void g()
  {
    long l2 = 1000L;
    long l1;
    if ((!this.jdField_a_of_type_Boolean) && (bflt.a()) && (bfnc.c(this.jdField_a_of_type_AndroidContentContext)))
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
    bfne.d("cost_time_tag", "ForceUserUpdateActivity mClickToOnCreateTime=" + (System.currentTimeMillis() - getIntent().getLongExtra("key_click_leba_start_time", 0L)));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Bfnx != null) && (this.jdField_a_of_type_Bfnx.isShowing()))
    {
      this.jdField_a_of_type_Bfnx.dismiss();
      this.jdField_a_of_type_Bfnx = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.ui.ForceUserUpdateActivity
 * JD-Core Version:    0.7.0.1
 */