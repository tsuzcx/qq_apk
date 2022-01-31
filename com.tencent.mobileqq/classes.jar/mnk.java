import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.report.AVReport;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mnk
  extends mnh
{
  public mnk(VideoInviteActivity paramVideoInviteActivity)
  {
    super(paramVideoInviteActivity);
    this.jdField_a_of_type_Int = 1;
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())
    {
      mtq.e(false, true);
      bdgm.b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, a(2131695920), a(2131695917), null, new mnm(this), null);
      bool = true;
    }
    return bool;
  }
  
  public void BtnOnClick(View paramView)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getIntent().getBooleanExtra("isDoubleVideoMeeting", false);
    long l = AudioHelper.b();
    QLog.d("VideoInviteUILock", 1, "avideo BtnOnClick, id[" + mgu.a(paramView.getId()) + "], isDoubleVideoMeeting[" + bool + "], seq[" + l + "]");
    switch (paramView.getId())
    {
    default: 
    case 2131372756: 
    case 2131362956: 
    case 2131362968: 
      do
      {
        return;
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l, true);
        if (bool)
        {
          a("0X80051FF");
          return;
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean)
        {
          a("0X8004202");
          return;
        }
        a("0X8004206");
        return;
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean = true;
        AVReport.a().R = SystemClock.elapsedRealtime();
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c(l);
        return;
      } while (a());
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c(l);
      a("0X8004207");
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, true);
    if (bool) {
      paramView = "0X8005200";
    }
    for (;;)
    {
      a(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        paramView = "0X800439F";
      } else {
        paramView = "0X80043B1";
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageButton != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
      }
    }
  }
  
  public void a(Context paramContext, String paramString, Intent paramIntent)
  {
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramString)) {}
    do
    {
      return;
      if ("android.intent.action.SCREEN_OFF".equals(paramString))
      {
        l = AudioHelper.b();
        if (QLog.isColorLevel()) {
          QLog.w("VideoInviteUILock", 2, "ACTION_SCREEN_OFF, seq[" + l + "]");
        }
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().a("backgroundReason", "4");
        lfh.a = "4";
        if (muz.b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity))
        {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l);
          if ((mwk.a() != null) && (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().e)) {
            mwk.a().b();
          }
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
        for (paramContext = null;; paramContext = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())
        {
          boolean bool = mti.b(paramContext);
          if (QLog.isColorLevel()) {
            QLog.w("VideoInviteUILock", 1, "ACTION_SCREEN_OFF avCallBtnState[" + bool + "], seq[" + l + "]");
          }
          if (bool) {
            mwk.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, l);
          }
          if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
            break;
          }
          a("0X8004208");
          return;
        }
        a("0X8004209");
        return;
      }
    } while (!"android.intent.action.SCREEN_ON".equals(paramString));
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("VideoInviteUILock", 2, "ACTION_SCREEN_ON, seq[" + l + "]");
    }
    if ((this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_i_of_type_Boolean)) {
      mwk.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b(l);
      if ((Build.VERSION.SDK_INT > 19) || (VideoController.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity))) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a("ACTION_SCREEN_ON");
      return;
      mwk.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
  }
  
  public void a(mnh parammnh)
  {
    super.a(parammnh);
    AVReport.a().s = this.jdField_b_of_type_Long;
    AVReport.a().t = this.c;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      AVReport.a().s = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().t = SystemClock.elapsedRealtime();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        azqs.b(null, "CliOper", "", "", "0X8004200", "0X8004200", 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_i_of_type_Int), "");
      } else {
        azqs.b(null, "CliOper", "", "", "0X8004204", "0X8004204", 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_i_of_type_Int), "");
      }
    }
  }
  
  public void d()
  {
    super.d();
    long l = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setContentView(2131559651);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(524288);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(1024);
    if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(2097152);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b();
    new mmi((RelativeLayout)a(2131372891)).a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(l);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131372799));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559606);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(new mnl(this, l));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131379766));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131379767));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Lid.jdField_i_of_type_Int == 9500)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131362968, 8);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131362967, 8);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h();
      Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_JavaLangString + a(2131690319);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setTitle((CharSequence)localObject);
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mkb != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mkb.b();
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mkb = new mkb(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(), 1, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, null);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(true);
      if ((alsf.a() == 20.0F) || (alsf.a() == 18.0F) || (alsf.a() == 17.0F))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if (this.jdField_b_of_type_Int <= 540)
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = a().getDimensionPixelSize(2131297810);
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if ((alsf.a() == 20.0F) && (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372756, 1, a().getDimensionPixelSize(2131297460));
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131362968, 2, a().getDimensionPixelSize(2131297460));
        }
        if ((this.jdField_b_of_type_Int <= 800) || ((mww.a()) && (this.jdField_b_of_type_Int <= 1280))) {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372752, 4, 0);
        }
      }
      k();
      if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        break label785;
      }
      a("0X800439D");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteUILock", 2, "video invite Lock onCreate OK");
      }
      return;
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setText(2131696402);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131362968, 8);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131362967, 11);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131362967, 2, a().getDimensionPixelSize(2131297640));
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372753, 2130841616);
        mww.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, a(2131696401));
        break;
      }
      mww.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, a(2131721357));
      break;
      label785:
      a("0X80043FC");
    }
  }
  
  public void j()
  {
    super.j();
    QLog.d("VideoInviteUILock", 1, "onDestroy");
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(-1047L);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mkb != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mkb.b();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mkb = null;
    }
  }
  
  void k()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131379766);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = mww.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if (i <= 320)
    {
      localLayoutParams.topMargin = a().getDimensionPixelSize(2131297589);
      localLayoutParams.width = a().getDimensionPixelSize(2131297585);
      localLayoutParams.height = a().getDimensionPixelSize(2131297585);
    }
    for (;;)
    {
      localImageView.setLayoutParams(localLayoutParams);
      return;
      if (i <= 480)
      {
        localLayoutParams.topMargin = a().getDimensionPixelSize(2131297590);
        localLayoutParams.width = a().getDimensionPixelSize(2131297586);
        localLayoutParams.height = a().getDimensionPixelSize(2131297586);
      }
      else
      {
        localLayoutParams.topMargin = a().getDimensionPixelSize(2131297592);
        localLayoutParams.width = a().getDimensionPixelSize(2131297588);
        localLayoutParams.height = a().getDimensionPixelSize(2131297588);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mnk
 * JD-Core Version:    0.7.0.1
 */