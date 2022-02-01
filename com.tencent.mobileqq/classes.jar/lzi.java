import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI.1;
import com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI.2;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lzi
  extends SmallScreenVideoControlUI
{
  Runnable jdField_a_of_type_JavaLangRunnable = new SmallScreenDoubleVideoControlUI.2(this);
  boolean jdField_a_of_type_Boolean = false;
  
  public lzi(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, mct parammct)
  {
    super(paramVideoAppInterface, paramSmallScreenService, parammct);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695252);
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if (i == 5)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().am)
      {
        t();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.e())
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().am)
      {
        t();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().l())
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (j > 18)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().am) && (this.jdField_a_of_type_ComTencentAvVideoController.a().an))
      {
        t();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().am)
    {
      t();
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<setInvitingState(), resId =" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().j == 1011) && (paramInt != 2131695252) && (paramInt != 2131719190) && (!this.jdField_a_of_type_ComTencentAvVideoController.f)) {}
    while ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt <= 0)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    super.a(paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onInviteReached remotePhoneState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().o + " # remoteTerminal = " + this.jdField_a_of_type_ComTencentAvVideoController.a().l + " # phoneOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().n + " # pcOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().m + " # subState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long + " # isPeerNetworkWell = " + this.jdField_a_of_type_ComTencentAvVideoController.a().r);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().h()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ai) || (this.jdField_a_of_type_ComTencentAvVideoController.a().j == 1011)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString.contains(paramString1)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().o < 0) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695366);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onPeerSwitchTerminal, bStartSwitch : " + paramBoolean);
    }
    paramString = lln.a();
    if (paramBoolean)
    {
      paramString.b = false;
      paramString.e = 0;
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenDoubleVideoControlUI", 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + paramString.e + ", mIsPeerSupport = " + paramString.b);
      }
      lzq.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
      return;
    }
    paramString.c();
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 2131695366;
    int j = 2131695252;
    super.a(paramBoolean);
    lff locallff = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenDoubleVideoControlUI", 1, "onCreate, matchStatus[" + locallff.a.b + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.f) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695251);
    }
    do
    {
      return;
      if ((locallff.a.b > 0) && (locallff.a.b != 5))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695261);
        return;
      }
    } while (locallff.l());
    if (locallff.k())
    {
      if (locallff.S) {}
      for (i = 2131694898;; i = 2131719258)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(i);
        return;
      }
    }
    if (locallff.h())
    {
      if (locallff.ai) {
        i = 2131695252;
      }
      if (locallff.j != 1011) {
        break label340;
      }
      i = j;
    }
    label271:
    label340:
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i);
      return;
      if (locallff.j())
      {
        if ((locallff.jdField_d_of_type_Int == 0) && (locallff.e))
        {
          j = i;
          if (locallff.f != 1) {
            if (locallff.f != 2) {
              break label271;
            }
          }
        }
        for (j = i;; j = 2131695087)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(j);
          return;
        }
      }
      if ((!locallff.o()) && (!locallff.p())) {
        break;
      }
      if (locallff.j == 1011) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695268);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new SmallScreenDoubleVideoControlUI.1(this, l), 150L);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if ((!paramBoolean1) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      if (!paramBoolean2) {
        break label50;
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().g) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
      }
    }
    label50:
    while (this.jdField_a_of_type_ComTencentAvVideoController.a().g) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
  }
  
  public void b()
  {
    super.b();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, ">>>onStart(), ts=" + l1);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().h()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().o >= 0) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j != 1011) {
        break label167;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695252);
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isDevelopLevel())
      {
        QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<onStart(), ts=" + l2);
        QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
      }
      return;
      label167:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695366);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
    }
    if (paramBoolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
    t();
  }
  
  public void c()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.e()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().l()) || (j <= 18) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().am)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    t();
  }
  
  public void d()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0))
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long != 1L) {
        t();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_ComTencentAvVideoController.e()) {
                break;
              }
              if (this.jdField_a_of_type_Boolean) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
              }
            } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
            t();
            return;
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().l());
          if (j <= 18) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().an);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
      } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
      t();
      return;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
    t();
  }
  
  public void e()
  {
    super.e();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, ">>>onResume(), ts=" + System.currentTimeMillis());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long != 1L)) {
      t();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<onResume(), ts=" + l2);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzi
 * JD-Core Version:    0.7.0.1
 */