import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class mby
  extends meu
{
  mby(mbw parammbw) {}
  
  protected void a()
  {
    if (this.a.jdField_a_of_type_Mcb != null) {
      this.a.jdField_a_of_type_Mcb.a(0, 0, true);
    }
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 1, "onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[" + this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop + "], seq[" + paramLong + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      do
      {
        return;
        mbw.a(this.a, 1);
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      } while (((lid)localObject).jdField_h_of_type_Int == 11);
      if (this.a.jdField_a_of_type_Mcb != null) {
        this.a.jdField_a_of_type_Mcb.a(((lid)localObject).jdField_d_of_type_JavaLangString, 1, false, false, false);
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramLong);
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
      }
      this.a.jdField_d_of_type_Boolean = false;
      this.a.c = ((lid)localObject).jdField_d_of_type_Int;
      this.a.jdField_d_of_type_Int = ((lid)localObject).f;
      if (!lnz.f())
      {
        this.a.jdField_a_of_type_Mcb.a(false, false);
        ((lid)localObject).a(paramLong, false);
      }
      this.a.a(true);
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
        if (this.a.jdField_b_of_type_Int != 2) {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.e();
        }
      }
      if (((lid)localObject).jdField_d_of_type_JavaLangString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
    return;
    ((lid)localObject).jdField_h_of_type_Long = Long.valueOf(((lid)localObject).jdField_d_of_type_JavaLangString).longValue();
    long l = ((lid)localObject).g;
    if (((lid)localObject).i == 3000) {
      ((lid)localObject).a = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l));
    }
    ((lid)localObject).c("onChangeUI_DobuleAudio2MultiAudio", 0);
    this.a.jdField_a_of_type_ComTencentAvVideoController.m(false);
    this.a.jdField_a_of_type_ComTencentAvVideoController.n(false);
    this.a.e = ((lid)localObject).i;
    if (this.a.c == 4) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.a.c, false, false);
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().jdField_d_of_type_JavaLangString) + "";
    ljx.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (String)localObject);
    ljx.a(2, (String)localObject);
    ljx.a(2);
  }
  
  protected void a(long paramLong, ArrayList<lqq> paramArrayList)
  {
    Object localObject;
    int k;
    int j;
    String str1;
    int m;
    boolean bool2;
    int i;
    label153:
    String str2;
    boolean bool1;
    if ((this.a.jdField_a_of_type_Mcb != null) && (paramArrayList != null))
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      k = this.a.jdField_a_of_type_ComTencentAvVideoController.g();
      if (QLog.isColorLevel()) {
        QLog.w("SmallScreenVideoController", 1, "onRequest_ShowVideo, seq[" + paramLong + "], infoLogs[" + (String)localObject + "]");
      }
      j = 0;
      if (j < paramArrayList.size())
      {
        localObject = (lqq)paramArrayList.get(j);
        str1 = String.valueOf(((lqq)localObject).jdField_a_of_type_Long);
        m = ((lqq)localObject).jdField_a_of_type_Int;
        bool2 = ((lqq)localObject).jdField_a_of_type_Boolean;
        i = -1;
        if (this.a.e == 3000)
        {
          i = 1004;
          str2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str1, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().g));
          if ((!((lqq)localObject).jdField_b_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentAvVideoController.o())) {
            break label694;
          }
          if (str1.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            break label499;
          }
          mcb localmcb = this.a.jdField_a_of_type_Mcb;
          if (((lqq)localObject).jdField_b_of_type_Long != 5L) {
            break label493;
          }
          bool1 = true;
          label248:
          localmcb.a(str1, m, true, bool2, bool1);
          i = 0;
        }
      }
    }
    for (;;)
    {
      label265:
      if (i == 0) {
        if ((!((lqq)localObject).jdField_b_of_type_Boolean) && (!((lqq)localObject).jdField_a_of_type_Boolean) && (k != 4))
        {
          if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().E != 2) {
            break label530;
          }
          azqs.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Mcb.a(str1, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, ((lqq)localObject).jdField_b_of_type_Boolean, ((lqq)localObject).jdField_a_of_type_Boolean);
        if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().J)
        {
          float f = mww.a(this.a.jdField_a_of_type_AndroidContentContext, 12.0F);
          if (!str1.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            this.a.jdField_a_of_type_Mcb.a(str1, m, str2, f, -1);
          }
          this.a.jdField_a_of_type_Mcb.a(str1, m);
        }
        j += 1;
        break;
        if (this.a.e == 1)
        {
          i = 1000;
          break label153;
        }
        if (this.a.e != 0) {
          break label153;
        }
        i = 0;
        break label153;
        label493:
        bool1 = false;
        break label248;
        label499:
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong);
        this.a.jdField_a_of_type_Mcb.a(true, bool2);
        i = 1;
        break label265;
        label530:
        azqs.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
      }
      paramArrayList = this.a.jdField_a_of_type_Mcb;
      i = this.a.g;
      if (this.a.jdField_a_of_type_Mef == null) {}
      for (bool1 = true;; bool1 = this.a.jdField_a_of_type_Mef.jdField_b_of_type_Boolean)
      {
        paramArrayList.a(i, bool1);
        i = this.a.g;
        j = this.a.jdField_a_of_type_AndroidViewDisplay.getRotation();
        if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b((i + j * 90) % 360);
        }
        if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
          this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.a.g);
        }
        return;
      }
      label694:
      i = 0;
    }
  }
  
  protected void a(String paramString)
  {
    if ((paramString != null) && (paramString.equals("1")) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().T))
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(true);
      mbw.a(this.a, 2);
    }
  }
  
  protected void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  protected void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "Qav.Record, onChangeUi_ReceiveRecordMsg, from=" + paramString1 + ", data=" + paramString2);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    for (;;)
    {
      return;
      try
      {
        i = Integer.parseInt(paramString2);
        if (i == -1)
        {
          QLog.d("SmallScreenVideoController", 1, "onChangeUi_ReceiveRecordMsg, parse int failed, try parse SUPPORT, data=" + paramString2);
          if (TextUtils.isEmpty(paramString2)) {
            continue;
          }
          if (!"SUPPORT_TRUE".equals(paramString2)) {
            break label288;
          }
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().A = true;
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().t = Math.max(this.a.jdField_a_of_type_ComTencentAvVideoController.a().t, 730);
        }
        j = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenVideoController", 2, "onChangeUi_ReceiveRecordMsg, session type=" + j);
        }
        switch (i)
        {
        case 2: 
        case 4: 
        case 6: 
        case 7: 
        default: 
          d();
          return;
        }
      }
      catch (NumberFormatException paramString1)
      {
        for (;;)
        {
          int j;
          QLog.d("SmallScreenVideoController", 1, "Qav.Record, onChangeUi_ReceiveRecordMsg, " + paramString1.getMessage());
          int i = -1;
          continue;
          label288:
          if (paramString2.startsWith("SUPPORT_TRUE_7.3.5"))
          {
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().A = true;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().t = Math.max(this.a.jdField_a_of_type_ComTencentAvVideoController.a().t, 735);
            j = mqk.a(paramString2, mqg.a().jdField_h_of_type_Int);
            QLog.i("SmallScreenVideoController", 1, "onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=" + j);
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().c = (j * 60 * 1000L);
            continue;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(2));
            this.a.jdField_a_of_type_ComTencentAvVideoController.E();
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().C = true;
            continue;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(4));
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().C = false;
            continue;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(6));
          }
        }
      }
    }
  }
  
  protected void a(ArrayList<lqq> paramArrayList)
  {
    if ((this.a.jdField_a_of_type_Mcb != null) && (paramArrayList != null))
    {
      Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onChangeUI_CloseVideo-->infos=" + (String)localObject);
      }
      int i = 0;
      if (i < paramArrayList.size())
      {
        localObject = (lqq)paramArrayList.get(i);
        String str = String.valueOf(((lqq)localObject).jdField_a_of_type_Long);
        boolean bool2 = ((lqq)localObject).jdField_a_of_type_Boolean;
        int j = ((lqq)localObject).jdField_a_of_type_Int;
        mcb localmcb;
        if (!str.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          if (this.a.jdField_a_of_type_Mcb.b(str, j))
          {
            mdd.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
            mdd.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
          }
          localmcb = this.a.jdField_a_of_type_Mcb;
          if (((lqq)localObject).jdField_b_of_type_Long != 5L) {
            break label207;
          }
        }
        label207:
        for (boolean bool1 = true;; bool1 = false)
        {
          localmcb.a(str, j, false, bool2, bool1);
          i += 1;
          break;
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (this.a.jdField_b_of_type_Int == 2) {}
    do
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (!this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong);
      }
    } while (this.a.jdField_a_of_type_Mcb == null);
    this.a.jdField_a_of_type_Mcb.a(true, paramBoolean);
    this.a.jdField_a_of_type_Mcb.c(paramLong, this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.n)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.n = false;
      this.a.jdField_b_of_type_Boolean = true;
      this.a.d();
    }
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("normal_2_meeting", 1, "onChangeUI_Normal2Meeting, isBackground_Stop[" + this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop + "], seq[" + paramLong + "], session[" + this.a.jdField_a_of_type_ComTencentAvVideoController.a() + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lid locallid;
    do
    {
      do
      {
        return;
        mbw.a(this.a, 1);
        locallid = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      } while (locallid.jdField_h_of_type_Int == 16);
      if (this.a.jdField_a_of_type_Mcb != null) {
        this.a.jdField_a_of_type_Mcb.a(locallid.jdField_d_of_type_JavaLangString, 1, false, false, false);
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramLong);
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
      }
      locallid.d("onChangeUI_Normal2Meeting", true);
      this.a.jdField_d_of_type_Boolean = true;
      this.a.c = 1;
      this.a.jdField_d_of_type_Int = locallid.f;
      if (!lnz.f())
      {
        this.a.jdField_a_of_type_Mcb.a(false, false);
        locallid.a(paramLong, false);
      }
      this.a.a(true);
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
        if (this.a.jdField_b_of_type_Int != 2) {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.e();
        }
      }
      if (locallid.jdField_d_of_type_JavaLangString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("double_2_multi", 2, "onChangeUI_Normal2Meeting-->Peer uin is null!");
    return;
    locallid.e("SmallScreen.onChangeUI_Normal2Meeting", false);
    this.a.e = 0;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.a.c, false, true);
  }
  
  protected void c()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b != null) {
      log.a(this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b);
    }
  }
  
  protected void c(long paramLong)
  {
    if (this.a.jdField_a_of_type_Mcb != null)
    {
      this.a.jdField_a_of_type_Mcb.a(false, false);
      mbw.a(this.a, 1);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onChangeUI_RecordStateChange:");
    }
    if ((this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b == null)) {}
    View localView;
    label310:
    for (;;)
    {
      return;
      localView = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b.findViewById(2131375511);
      if (localView == null)
      {
        QLog.d("SmallScreenVideoController", 1, "onChangeUI_RecordStateChange view is null");
        return;
      }
      localView.clearAnimation();
      if ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().C) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().B)) {
        break;
      }
      localView.setVisibility(0);
      Object localObject = new mli();
      ((mli)localObject).setDuration(1000L);
      ((mli)localObject).setRepeatCount(-1);
      localView.findViewById(2131375515).startAnimation((Animation)localObject);
      int i;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().B) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().C))
      {
        ((TextView)localView.findViewById(2131375523)).setText(2131696238);
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label310;
        }
        localObject = Build.MANUFACTURER;
        String str = Build.MODEL;
        if ((!"Xiaomi".equalsIgnoreCase((String)localObject)) || (!"MI MAX".equalsIgnoreCase(str))) {
          break;
        }
        ((TextView)localView.findViewById(2131375523)).setTextSize(1, 8.0F);
        return;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().B)
        {
          ((TextView)localView.findViewById(2131375523)).setText(2131696239);
          i = 0;
        }
        else
        {
          ((TextView)localView.findViewById(2131375523)).setText(2131696237);
          i = 1;
        }
      }
    }
    localView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mby
 * JD-Core Version:    0.7.0.1
 */