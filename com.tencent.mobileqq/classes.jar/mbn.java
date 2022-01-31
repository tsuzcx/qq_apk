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

public class mbn
  extends SmallScreenVideoControlUI
{
  Runnable jdField_a_of_type_JavaLangRunnable = new SmallScreenDoubleVideoControlUI.2(this);
  boolean jdField_a_of_type_Boolean = false;
  
  public mbn(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, meu parammeu)
  {
    super(paramVideoAppInterface, paramSmallScreenService, parammeu);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696327);
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if (i == 5)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().al)
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
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().al)
      {
        t();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k())
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (j > 18)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().al) && (this.jdField_a_of_type_ComTencentAvVideoController.a().am))
      {
        t();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().al)
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1011) && (paramInt != 2131696327) && (paramInt != 2131721304) && (!this.jdField_a_of_type_ComTencentAvVideoController.f)) {}
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
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onInviteReached remotePhoneState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().n + " # remoteTerminal = " + this.jdField_a_of_type_ComTencentAvVideoController.a().k + " # phoneOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().m + " # pcOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().l + " # subState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long + " # isPeerNetworkWell = " + this.jdField_a_of_type_ComTencentAvVideoController.a().r);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().g()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ah) || (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1011)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString.contains(paramString1)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().n < 0) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696441);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onPeerSwitchTerminal, bStartSwitch : " + paramBoolean);
    }
    paramString = loc.a();
    if (paramBoolean)
    {
      paramString.b = false;
      paramString.e = 0;
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenDoubleVideoControlUI", 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + paramString.e + ", mIsPeerSupport = " + paramString.b);
      }
      mbt.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
      return;
    }
    paramString.c();
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 2131696441;
    int j = 2131696327;
    super.a(paramBoolean);
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenDoubleVideoControlUI", 1, "onCreate, matchStatus[" + locallid.a.b + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.f) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696326);
    }
    do
    {
      return;
      if ((locallid.a.b > 0) && (locallid.a.b != 5))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696336);
        return;
      }
    } while (locallid.k());
    if (locallid.j())
    {
      if (locallid.R) {}
      for (i = 2131695976;; i = 2131721374)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(i);
        return;
      }
    }
    if (locallid.g())
    {
      if (locallid.ah) {
        i = 2131696327;
      }
      if (locallid.i != 1011) {
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
      if (locallid.i())
      {
        if ((locallid.jdField_d_of_type_Int == 0) && (locallid.e))
        {
          j = i;
          if (locallid.f != 1) {
            if (locallid.f != 2) {
              break label271;
            }
          }
        }
        for (j = i;; j = 2131696164)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(j);
          return;
        }
      }
      if ((!locallid.n()) && (!locallid.o())) {
        break;
      }
      if (locallid.i == 1011) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696343);
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().g()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().n >= 0) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().i != 1011) {
        break label167;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696327);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696441);
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
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.e()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().k()) || (j <= 18) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().al)) {
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
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().k());
          if (j <= 18) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().am);
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().k()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long != 1L)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mbn
 * JD-Core Version:    0.7.0.1
 */