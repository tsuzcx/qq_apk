import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.report.AVReport;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.VideoInviteUIFull.1;
import com.tencent.av.utils.PopupDialog;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mkr
  extends mkq
{
  private lzb a;
  
  public mkr(VideoInviteActivity paramVideoInviteActivity)
  {
    super(paramVideoInviteActivity);
    this.jdField_a_of_type_Int = 2;
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())
    {
      mqz.e(false, true);
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteUIFull", 2, "startVideo phone is calling!");
      }
      String str1 = a(2131695754);
      String str2 = a(2131695757);
      PopupDialog.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getApplicationContext(), 230, str2, str1, 2131690596, 2131694793, new mks(this), null);
      bool = true;
    }
    return bool;
  }
  
  private void b(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    lcl.d("VideoInviteUIFull", "DestroyUI isQuit[" + paramBoolean + "], mPeerUin[" + this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_c_of_type_JavaLangString + "], mIsDoubleVideoMeeting[" + this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.i + "], seq[" + l + "]");
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
    if (localVideoController == null) {}
    lgf locallgf;
    do
    {
      return;
      locallgf = localVideoController.a();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.e = paramBoolean;
      localVideoController.a(true);
      localVideoController.i(false);
      if (this.jdField_a_of_type_Lzb != null) {
        this.jdField_a_of_type_Lzb.a(l, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.e);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
    } while (paramBoolean);
    int i = lzj.a(locallgf.K);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.overridePendingTransition(0, i);
  }
  
  private void k()
  {
    ImageView localImageView = (ImageView)super.a(2131362928);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = muf.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if (i <= 320)
    {
      localLayoutParams.topMargin = super.a().getDimensionPixelSize(2131297568);
      localLayoutParams.width = super.a().getDimensionPixelSize(2131297564);
      localLayoutParams.height = super.a().getDimensionPixelSize(2131297564);
    }
    for (;;)
    {
      localImageView.setLayoutParams(localLayoutParams);
      return;
      if (i <= 480)
      {
        localLayoutParams.topMargin = super.a().getDimensionPixelSize(2131297569);
        localLayoutParams.width = super.a().getDimensionPixelSize(2131297565);
        localLayoutParams.height = super.a().getDimensionPixelSize(2131297565);
      }
      else
      {
        localLayoutParams.topMargin = super.a().getDimensionPixelSize(2131297571);
        localLayoutParams.width = super.a().getDimensionPixelSize(2131297567);
        localLayoutParams.height = super.a().getDimensionPixelSize(2131297567);
      }
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    long l = AudioHelper.b();
    QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, id[" + mej.a(paramView.getId()) + "], seq[" + l + "]");
    boolean bool = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.i;
    switch (paramView.getId())
    {
    default: 
    case 2131372372: 
    case 2131362922: 
    case 2131362934: 
      do
      {
        do
        {
          return;
          QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, REFUSE");
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l, true);
          if (bool)
          {
            a("0X80051FF");
            return;
          }
          if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean)
          {
            a("0X8004398");
            return;
          }
          a("0X80043F6");
          return;
        } while (a());
        QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, ACCEPT");
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean = true;
        AVReport.a().R = SystemClock.elapsedRealtime();
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c(l);
        if (bool)
        {
          a("0X80051FE");
          return;
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean)
        {
          a("0X8004397");
          return;
        }
        a("0X80043F5");
        return;
        QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, ACCEPT_BY_AUDIO");
      } while (a());
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c(l);
      a("0X80043F7");
      return;
    case 2131362933: 
      QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, MSG_REPLY");
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, false);
      if (bool) {
        paramView = "0X8005200";
      }
      for (;;)
      {
        a(paramView);
        return;
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
          paramView = "0X80043A5";
        } else {
          paramView = "0X80043AB";
        }
      }
    }
    QLog.d("VideoInviteUIFull", 1, "onClick HIDE ");
    paramView = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
    if (paramView != null) {
      paramView.a("backgroundReason", "3");
    }
    c();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372372, false);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131362934, false);
    }
  }
  
  public void a(Context paramContext, String paramString, Intent paramIntent)
  {
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramString))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if (paramContext != null)
      {
        mtt.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if (paramContext.equals("homekey"))
        {
          if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
            break label83;
          }
          a("0X8004399");
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a("backgroundReason", "1");
          ldj.a = "1";
        }
      }
    }
    label83:
    while (!"android.intent.action.SCREEN_OFF".equals(paramString)) {
      for (;;)
      {
        return;
        a("0X80043F8");
      }
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a("backgroundReason", "4");
    ldj.a = "4";
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a("ACTION_SCREEN_OFF");
  }
  
  public void a(mkq parammkq)
  {
    super.a(parammkq);
    AVReport.a().u = this.jdField_b_of_type_Long;
    AVReport.a().v = this.jdField_c_of_type_Long;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      AVReport.a().u = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().v = SystemClock.elapsedRealtime();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        break label24;
      }
      a("0X800439A");
    }
    for (;;)
    {
      return false;
      label24:
      a("0X80043F9");
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.runOnUiThread(new VideoInviteUIFull.1(this));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteUIFull", 2, "onBackPressed");
    }
    if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean)
    {
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
      if (localVideoController != null) {
        localVideoController.c();
      }
      ldj.a = "3";
      if (this.jdField_a_of_type_Lzb != null) {
        this.jdField_a_of_type_Lzb.a();
      }
      b(false);
    }
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setContentView(2131559598);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(2097152);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().clearFlags(524288);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().clearFlags(1024);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b();
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131372412).setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.f();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(-1046L);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)super.a(2131372415));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559556);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.e();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.a(2131362928));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.a(2131362931));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setText(2131720794);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
    Object localObject;
    label411:
    int i;
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Lgf.i == 9500)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131362934, 8);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131362933, 8);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h();
      if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        break label866;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372372, super.a(2131690270), this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Lgf.C);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131362922, super.a(2131690253), this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Lgf.C);
      localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_JavaLangString + super.a(2131690268);
      muf.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView, (String)localObject);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setTitle((CharSequence)localObject);
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mho != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mho.b();
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mho = new mho(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(), 1, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteUIFull", 2, "video invite full onCreate OK");
      }
      if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        break label953;
      }
      i = 1;
      label523:
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a().g != 2) {
        break label958;
      }
    }
    label953:
    label958:
    for (int j = 2;; j = 3)
    {
      axqw.b(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", i, j, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(true);
      this.jdField_a_of_type_Lzb = lzb.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      new mjr((RelativeLayout)a(2131372507)).a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
      if (ajwe.a() >= 17.0F)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if (this.jdField_c_of_type_Int <= 540)
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = a().getDimensionPixelSize(2131297789);
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if ((this.jdField_b_of_type_Int <= 800) || ((muf.a()) && (this.jdField_b_of_type_Int <= 1280)))
        {
          localObject = (RelativeLayout)super.a(2131362911);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
          localLayoutParams.bottomMargin = 0;
          ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
          localObject = (RelativeLayout)super.a(2131362918);
          localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
          localLayoutParams.bottomMargin = 0;
          ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        }
      }
      k();
      if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        break label963;
      }
      a("0X8004396");
      return;
      if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131362934, 4);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131362933, 0);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setText(2131696227);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setAcceptDrawableTop(super.a().getDrawable(2130841456));
      break;
      label866:
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372372, super.a(2131690270));
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131362922, super.a(2131690253));
      localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_JavaLangString + super.a(2131690268);
      muf.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView, (String)localObject);
      break label411;
      i = 2;
      break label523;
    }
    label963:
    a("0X80043F4");
  }
  
  public void j()
  {
    super.j();
    QLog.d("VideoInviteUIFull", 1, "onDestroy");
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.f();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(-1045L);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mho != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mho.b();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mho = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mkr
 * JD-Core Version:    0.7.0.1
 */