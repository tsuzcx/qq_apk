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

public class mlj
  extends mlg
{
  public mlj(VideoInviteActivity paramVideoInviteActivity)
  {
    super(paramVideoInviteActivity);
    this.jdField_a_of_type_Int = 1;
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())
    {
      mru.e(false, true);
      bhlq.b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, a(2131694840), a(2131694837), null, new mll(this), null);
      bool = true;
    }
    return bool;
  }
  
  public void BtnOnClick(View paramView)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getIntent().getBooleanExtra("isDoubleVideoMeeting", false);
    long l = AudioHelper.b();
    QLog.d("VideoInviteUILock", 1, "avideo BtnOnClick, id[" + meu.a(paramView.getId()) + "], isDoubleVideoMeeting[" + bool + "], seq[" + l + "]");
    switch (paramView.getId())
    {
    default: 
    case 2131373495: 
    case 2131363092: 
    case 2131363104: 
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
        lcj.a = "4";
        if (mtd.b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity))
        {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l);
          if ((mur.a() != null) && (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().e)) {
            mur.a().b();
          }
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
        for (paramContext = null;; paramContext = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())
        {
          boolean bool = mrl.b(paramContext);
          if (QLog.isColorLevel()) {
            QLog.w("VideoInviteUILock", 1, "ACTION_SCREEN_OFF avCallBtnState[" + bool + "], seq[" + l + "]");
          }
          if (bool) {
            mur.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, l);
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
      mur.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b(l);
      if ((Build.VERSION.SDK_INT > 19) || (VideoController.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity))) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a("ACTION_SCREEN_ON");
      return;
      mur.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
  }
  
  public void a(mlg parammlg)
  {
    super.a(parammlg);
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
        bdll.b(null, "CliOper", "", "", "0X8004200", "0X8004200", 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_i_of_type_Int), "");
      } else {
        bdll.b(null, "CliOper", "", "", "0X8004204", "0X8004204", 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_i_of_type_Int), "");
      }
    }
  }
  
  public void d()
  {
    super.d();
    long l = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setContentView(2131559794);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(524288);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(1024);
    if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(2097152);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b();
    new mkh((RelativeLayout)a(2131373630)).a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(l);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131373539));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559750);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(new mlk(this, l));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131380901));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131380902));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Lff.j == 9500)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363104, 8);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363103, 8);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h();
      Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_JavaLangString + a(2131690161);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setTitle((CharSequence)localObject);
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mia != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mia.b();
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mia = new mia(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(), 1, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, null);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(true);
      if ((anxh.a() == 20.0F) || (anxh.a() == 18.0F) || (anxh.a() == 17.0F))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if (this.jdField_b_of_type_Int <= 540)
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = a().getDimensionPixelSize(2131297903);
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if ((anxh.a() == 20.0F) && (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373495, 1, a().getDimensionPixelSize(2131297551));
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131363104, 2, a().getDimensionPixelSize(2131297551));
        }
        if ((this.jdField_b_of_type_Int <= 800) || ((mvd.a()) && (this.jdField_b_of_type_Int <= 1280))) {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373491, 4, 0);
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
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setText(2131695327);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363104, 8);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131363103, 11);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131363103, 2, a().getDimensionPixelSize(2131297731));
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373492, 2130841931);
        mvd.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, a(2131695326));
        break;
      }
      mvd.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, a(2131719245));
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
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mia != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mia.b();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mia = null;
    }
  }
  
  void k()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131380901);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = mvd.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if (i <= 320)
    {
      localLayoutParams.topMargin = a().getDimensionPixelSize(2131297680);
      localLayoutParams.width = a().getDimensionPixelSize(2131297676);
      localLayoutParams.height = a().getDimensionPixelSize(2131297676);
    }
    for (;;)
    {
      localImageView.setLayoutParams(localLayoutParams);
      return;
      if (i <= 480)
      {
        localLayoutParams.topMargin = a().getDimensionPixelSize(2131297681);
        localLayoutParams.width = a().getDimensionPixelSize(2131297677);
        localLayoutParams.height = a().getDimensionPixelSize(2131297677);
      }
      else
      {
        localLayoutParams.topMargin = a().getDimensionPixelSize(2131297683);
        localLayoutParams.width = a().getDimensionPixelSize(2131297679);
        localLayoutParams.height = a().getDimensionPixelSize(2131297679);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlj
 * JD-Core Version:    0.7.0.1
 */