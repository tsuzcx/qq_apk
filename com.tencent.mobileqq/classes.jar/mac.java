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

public class mac
  extends lzz
{
  public mac(VideoInviteActivity paramVideoInviteActivity)
  {
    super(paramVideoInviteActivity);
    this.jdField_a_of_type_Int = 1;
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())
    {
      mga.e(false, true);
      babr.b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, a(2131630070), a(2131630067), null, new mae(this), null);
      bool = true;
    }
    return bool;
  }
  
  public void BtnOnClick(View paramView)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getIntent().getBooleanExtra("isDoubleVideoMeeting", false);
    long l = AudioHelper.b();
    QLog.d("VideoInviteUILock", 1, "avideo BtnOnClick, id[" + ltq.a(paramView.getId()) + "], isDoubleVideoMeeting[" + bool + "], seq[" + l + "]");
    switch (paramView.getId())
    {
    default: 
    case 2131306670: 
    case 2131297382: 
    case 2131297394: 
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
        ksu.a = "4";
        if (mhj.b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity))
        {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l);
          if ((miu.a() != null) && (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().e)) {
            miu.a().b();
          }
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
        for (paramContext = null;; paramContext = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())
        {
          boolean bool = mfs.b(paramContext);
          if (QLog.isColorLevel()) {
            QLog.w("VideoInviteUILock", 1, "ACTION_SCREEN_OFF avCallBtnState[" + bool + "], seq[" + l + "]");
          }
          if (bool) {
            miu.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, l);
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
      miu.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b(l);
      if ((Build.VERSION.SDK_INT > 19) || (VideoController.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity))) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a("ACTION_SCREEN_ON");
      return;
      miu.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
  }
  
  public void a(lzz paramlzz)
  {
    super.a(paramlzz);
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
        awqx.b(null, "CliOper", "", "", "0X8004200", "0X8004200", 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_i_of_type_Int), "");
      } else {
        awqx.b(null, "CliOper", "", "", "0X8004204", "0X8004204", 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_i_of_type_Int), "");
      }
    }
  }
  
  public void d()
  {
    super.d();
    long l = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setContentView(2131494028);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(524288);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(1024);
    if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(2097152);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b();
    new lza((RelativeLayout)a(2131306797)).a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(l);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131306713));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131493985);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(new mad(this, l));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131313193));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131313194));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Kvq.jdField_i_of_type_Int == 9500)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131297394, 8);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131297393, 8);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h();
      Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_JavaLangString + a(2131624707);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setTitle((CharSequence)localObject);
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Lwx != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Lwx.b();
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Lwx = new lwx(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(), 1, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, null);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(true);
      if ((ajia.a() == 20.0F) || (ajia.a() == 18.0F) || (ajia.a() == 17.0F))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if (this.jdField_b_of_type_Int <= 540)
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = a().getDimensionPixelSize(2131166700);
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if ((ajia.a() == 20.0F) && (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131306670, 1, a().getDimensionPixelSize(2131166352));
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131297394, 2, a().getDimensionPixelSize(2131166352));
        }
        if ((this.jdField_b_of_type_Int <= 800) || ((mjg.a()) && (this.jdField_b_of_type_Int <= 1280))) {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131306666, 4, 0);
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
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setText(2131630524);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131297394, 8);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131297393, 11);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131297393, 2, a().getDimensionPixelSize(2131166530));
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131306667, 2130841377);
        mjg.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, a(2131630523));
        break;
      }
      mjg.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, a(2131654895));
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
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Lwx != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Lwx.b();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Lwx = null;
    }
  }
  
  void k()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131313193);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = mjg.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if (i <= 320)
    {
      localLayoutParams.topMargin = a().getDimensionPixelSize(2131166479);
      localLayoutParams.width = a().getDimensionPixelSize(2131166475);
      localLayoutParams.height = a().getDimensionPixelSize(2131166475);
    }
    for (;;)
    {
      localImageView.setLayoutParams(localLayoutParams);
      return;
      if (i <= 480)
      {
        localLayoutParams.topMargin = a().getDimensionPixelSize(2131166480);
        localLayoutParams.width = a().getDimensionPixelSize(2131166476);
        localLayoutParams.height = a().getDimensionPixelSize(2131166476);
      }
      else
      {
        localLayoutParams.topMargin = a().getDimensionPixelSize(2131166482);
        localLayoutParams.width = a().getDimensionPixelSize(2131166478);
        localLayoutParams.height = a().getDimensionPixelSize(2131166478);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mac
 * JD-Core Version:    0.7.0.1
 */