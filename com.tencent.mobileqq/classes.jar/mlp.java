import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
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
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mlp
  extends mlm
{
  public mlp(VideoInviteActivity paramVideoInviteActivity)
  {
    super(paramVideoInviteActivity);
    this.jdField_a_of_type_Int = 1;
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())
    {
      msa.e(false, true);
      bhdj.b(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, a(2131695194), a(2131695191), null, new mlr(this), null);
      bool = true;
    }
    return bool;
  }
  
  public void BtnOnClick(View paramView)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getIntent().getBooleanExtra("isDoubleVideoMeeting", false);
    long l = AudioHelper.b();
    QLog.d("VideoInviteUILock", 1, "avideo BtnOnClick, id[" + mez.a(paramView.getId()) + "], isDoubleVideoMeeting[" + bool + "], seq[" + l + "]");
    switch (paramView.getId())
    {
    default: 
    case 2131373624: 
    case 2131363128: 
    case 2131363140: 
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
        lvy.a().R = SystemClock.elapsedRealtime();
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
        lci.a = "4";
        if (mtj.c(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity))
        {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l);
          if ((muy.a() != null) && (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().e)) {
            muy.a().b();
          }
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
        for (paramContext = null;; paramContext = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())
        {
          boolean bool = mrr.b(paramContext);
          if (QLog.isColorLevel()) {
            QLog.w("VideoInviteUILock", 1, "ACTION_SCREEN_OFF avCallBtnState[" + bool + "], seq[" + l + "]");
          }
          if (bool) {
            muy.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, l);
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
      muy.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b(l);
      if ((Build.VERSION.SDK_INT > 19) || (VideoController.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity))) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a("ACTION_SCREEN_ON");
      return;
      muy.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
  }
  
  public void a(mlm parammlm)
  {
    super.a(parammlm);
    lvy.a().s = this.jdField_b_of_type_Long;
    lvy.a().t = this.c;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      lvy.a().s = SystemClock.elapsedRealtime();
      return;
    }
    lvy.a().t = SystemClock.elapsedRealtime();
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
        bdla.b(null, "CliOper", "", "", "0X8004200", "0X8004200", 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_i_of_type_Int), "");
      } else {
        bdla.b(null, "CliOper", "", "", "0X8004204", "0X8004204", 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_i_of_type_Int), "");
      }
    }
  }
  
  public void d()
  {
    super.d();
    long l = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setContentView(2131559833);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(524288);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(1024);
    if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.getWindow().addFlags(2097152);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b();
    new mkn((RelativeLayout)a(2131373759)).a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(l);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131373668));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559788);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(new mlq(this, l));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131380975));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131380976));
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Lfe.j == 9500)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363140, 8);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363139, 8);
      Object localObject = nad.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_c_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.h();
      localObject = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_d_of_type_JavaLangString + a(2131690224);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.setTitle((CharSequence)localObject);
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mif != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mif.b();
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mif = new mif(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(), 1, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, null);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(true);
      if ((FontSettingManager.getFontLevel() == 20.0F) || (FontSettingManager.getFontLevel() == 18.0F) || (FontSettingManager.getFontLevel() == 17.0F))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if (this.jdField_b_of_type_Int <= 540)
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = a().getDimensionPixelSize(2131297961);
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if ((FontSettingManager.getFontLevel() == 20.0F) && (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373624, 1, a().getDimensionPixelSize(2131297607));
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131363140, 2, a().getDimensionPixelSize(2131297607));
        }
        if ((this.jdField_b_of_type_Int <= 800) || ((mvk.a()) && (this.jdField_b_of_type_Int <= 1280))) {
          this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373620, 4, 0);
        }
      }
      k();
      if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_Boolean) {
        break label814;
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
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView.setText(2131695683);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363140, 8);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131363139, 11);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131363139, 2, a().getDimensionPixelSize(2131297787));
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373621, 2130841986);
        mvk.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, a(2131695682));
        break;
      }
      mvk.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_b_of_type_AndroidWidgetTextView, a(2131719983));
      break;
      label814:
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
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mif != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mif.b();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_Mif = null;
    }
  }
  
  void k()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.findViewById(2131380975);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = mvk.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity);
    if (i <= 320)
    {
      localLayoutParams.topMargin = a().getDimensionPixelSize(2131297736);
      localLayoutParams.width = a().getDimensionPixelSize(2131297732);
      localLayoutParams.height = a().getDimensionPixelSize(2131297732);
    }
    for (;;)
    {
      localImageView.setLayoutParams(localLayoutParams);
      return;
      if (i <= 480)
      {
        localLayoutParams.topMargin = a().getDimensionPixelSize(2131297737);
        localLayoutParams.width = a().getDimensionPixelSize(2131297733);
        localLayoutParams.height = a().getDimensionPixelSize(2131297733);
      }
      else
      {
        localLayoutParams.topMargin = a().getDimensionPixelSize(2131297739);
        localLayoutParams.width = a().getDimensionPixelSize(2131297735);
        localLayoutParams.height = a().getDimensionPixelSize(2131297735);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mlp
 * JD-Core Version:    0.7.0.1
 */