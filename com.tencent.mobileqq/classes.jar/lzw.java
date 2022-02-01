import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
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

class lzw
  extends mct
{
  lzw(lzu paramlzu) {}
  
  protected void a()
  {
    if (this.a.jdField_a_of_type_Lzz != null) {
      this.a.jdField_a_of_type_Lzz.a(0, 0, true);
    }
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 1, "onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[" + this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop + "], seq[" + paramLong + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      do
      {
        return;
        lzu.a(this.a, 1);
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      } while (((lff)localObject).i == 11);
      if (this.a.jdField_a_of_type_Lzz != null) {
        this.a.jdField_a_of_type_Lzz.a(((lff)localObject).jdField_d_of_type_JavaLangString, 1, false, false, false);
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramLong);
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
      }
      this.a.jdField_d_of_type_Boolean = false;
      this.a.c = ((lff)localObject).jdField_d_of_type_Int;
      this.a.jdField_d_of_type_Int = ((lff)localObject).f;
      if (!llk.e())
      {
        this.a.jdField_a_of_type_Lzz.a(false, false);
        ((lff)localObject).a(paramLong, false);
      }
      this.a.a(true);
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
        if (this.a.jdField_b_of_type_Int != 2) {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.e();
        }
      }
      if (((lff)localObject).jdField_d_of_type_JavaLangString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
    return;
    ((lff)localObject).h = Long.valueOf(((lff)localObject).jdField_d_of_type_JavaLangString).longValue();
    long l = ((lff)localObject).g;
    if (((lff)localObject).j == 3000) {
      ((lff)localObject).a = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l));
    }
    ((lff)localObject).d("onChangeUI_DobuleAudio2MultiAudio", 0);
    this.a.jdField_a_of_type_ComTencentAvVideoController.l(false);
    this.a.jdField_a_of_type_ComTencentAvVideoController.m(false);
    this.a.e = ((lff)localObject).j;
    if (this.a.c == 4) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.a.c, false, false);
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().jdField_d_of_type_JavaLangString) + "";
    lha.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (String)localObject);
    lha.a(2, (String)localObject);
    lha.a(2);
  }
  
  protected void a(long paramLong, ArrayList<lob> paramArrayList)
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
    if ((this.a.jdField_a_of_type_Lzz != null) && (paramArrayList != null))
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      k = this.a.jdField_a_of_type_ComTencentAvVideoController.h();
      if (QLog.isColorLevel()) {
        QLog.w("SmallScreenVideoController", 1, "onRequest_ShowVideo, seq[" + paramLong + "], infoLogs[" + (String)localObject + "]");
      }
      j = 0;
      if (j < paramArrayList.size())
      {
        localObject = (lob)paramArrayList.get(j);
        str1 = String.valueOf(((lob)localObject).jdField_a_of_type_Long);
        m = ((lob)localObject).jdField_a_of_type_Int;
        bool2 = ((lob)localObject).jdField_a_of_type_Boolean;
        i = -1;
        if (this.a.e == 3000)
        {
          i = 1004;
          str2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str1, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().g));
          if ((!((lob)localObject).jdField_b_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentAvVideoController.o())) {
            break label706;
          }
          if (str1.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            break label511;
          }
          lzz locallzz = this.a.jdField_a_of_type_Lzz;
          if ((((lob)localObject).jdField_b_of_type_Long != 5L) && (((lob)localObject).jdField_b_of_type_Long != 14L)) {
            break label505;
          }
          bool1 = true;
          label260:
          locallzz.a(str1, m, true, bool2, bool1);
          i = 0;
        }
      }
    }
    for (;;)
    {
      label277:
      if (i == 0) {
        if ((!((lob)localObject).jdField_b_of_type_Boolean) && (!((lob)localObject).jdField_a_of_type_Boolean) && (k != 4))
        {
          if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) {
            break label542;
          }
          bdll.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Lzz.a(str1, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, ((lob)localObject).jdField_b_of_type_Boolean, ((lob)localObject).jdField_a_of_type_Boolean);
        if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().J)
        {
          float f = mvd.a(this.a.jdField_a_of_type_AndroidContentContext, 12.0F);
          if (!str1.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            this.a.jdField_a_of_type_Lzz.a(str1, m, str2, f, -1);
          }
          this.a.jdField_a_of_type_Lzz.a(str1, m);
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
        label505:
        bool1 = false;
        break label260;
        label511:
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong);
        this.a.jdField_a_of_type_Lzz.a(true, bool2);
        i = 1;
        break label277;
        label542:
        bdll.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
      }
      paramArrayList = this.a.jdField_a_of_type_Lzz;
      i = this.a.g;
      if (this.a.jdField_a_of_type_Mcd == null) {}
      for (bool1 = true;; bool1 = this.a.jdField_a_of_type_Mcd.jdField_b_of_type_Boolean)
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
      label706:
      i = 0;
    }
  }
  
  protected void a(String paramString)
  {
    if ((paramString != null) && (paramString.equals("1")) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().U))
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(true);
      lzu.a(this.a, 2);
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
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().u = Math.max(this.a.jdField_a_of_type_ComTencentAvVideoController.a().u, 730);
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
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().u = Math.max(this.a.jdField_a_of_type_ComTencentAvVideoController.a().u, 735);
            j = mom.a(paramString2, moi.a().h);
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
  
  protected void a(ArrayList<lob> paramArrayList)
  {
    if ((this.a.jdField_a_of_type_Lzz != null) && (paramArrayList != null))
    {
      Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onChangeUI_CloseVideo-->infos=" + (String)localObject);
      }
      int i = 0;
      if (i < paramArrayList.size())
      {
        localObject = (lob)paramArrayList.get(i);
        String str = String.valueOf(((lob)localObject).jdField_a_of_type_Long);
        boolean bool2 = ((lob)localObject).jdField_a_of_type_Boolean;
        int j = ((lob)localObject).jdField_a_of_type_Int;
        lzz locallzz;
        if (!str.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          if (this.a.jdField_a_of_type_Lzz.b(str, j))
          {
            mbb.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
            mbb.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
          }
          locallzz = this.a.jdField_a_of_type_Lzz;
          if ((((lob)localObject).jdField_b_of_type_Long != 5L) && (((lob)localObject).jdField_b_of_type_Long != 14L)) {
            break label219;
          }
        }
        label219:
        for (boolean bool1 = true;; bool1 = false)
        {
          locallzz.a(str, j, false, bool2, bool1);
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
    } while (this.a.jdField_a_of_type_Lzz == null);
    this.a.jdField_a_of_type_Lzz.a(true, paramBoolean);
    this.a.jdField_a_of_type_Lzz.c(paramLong, this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.m)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.m = false;
      this.a.jdField_b_of_type_Boolean = true;
      this.a.d();
    }
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("normal_2_meeting", 1, "onChangeUI_Normal2Meeting, isBackground_Stop[" + this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop + "], seq[" + paramLong + "], session[" + this.a.jdField_a_of_type_ComTencentAvVideoController.a() + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lff locallff;
    do
    {
      do
      {
        return;
        lzu.a(this.a, 1);
        locallff = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      } while (locallff.i == 16);
      if (this.a.jdField_a_of_type_Lzz != null) {
        this.a.jdField_a_of_type_Lzz.a(locallff.jdField_d_of_type_JavaLangString, 1, false, false, false);
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramLong);
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
      }
      locallff.e("onChangeUI_Normal2Meeting", true);
      this.a.jdField_d_of_type_Boolean = true;
      this.a.c = 1;
      this.a.jdField_d_of_type_Int = locallff.f;
      if (!llk.e())
      {
        this.a.jdField_a_of_type_Lzz.a(false, false);
        locallff.a(paramLong, false);
      }
      this.a.a(true);
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
        if (this.a.jdField_b_of_type_Int != 2) {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.e();
        }
      }
      if (locallff.jdField_d_of_type_JavaLangString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("double_2_multi", 2, "onChangeUI_Normal2Meeting-->Peer uin is null!");
    return;
    locallff.f("SmallScreen.onChangeUI_Normal2Meeting", false);
    this.a.e = 0;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.a.c, false, true);
  }
  
  protected void c()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null) {}
    for (Object localObject = null;; localObject = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1))
    {
      if (localObject != null) {
        llr.a((ViewGroup)localObject);
      }
      return;
    }
  }
  
  protected void c(long paramLong)
  {
    if (this.a.jdField_a_of_type_Lzz != null)
    {
      this.a.jdField_a_of_type_Lzz.a(false, false);
      lzu.a(this.a, 1);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onChangeUI_RecordStateChange:");
    }
    Object localObject1;
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null)
    {
      localObject1 = null;
      if ((this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (localObject1 != null)) {
        break label67;
      }
    }
    label319:
    for (;;)
    {
      return;
      localObject1 = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1);
      break;
      label67:
      localObject1 = ((SmallScreenRelativeLayout)localObject1).findViewById(2131376374);
      if (localObject1 == null)
      {
        QLog.d("SmallScreenVideoController", 1, "onChangeUI_RecordStateChange view is null");
        return;
      }
      ((View)localObject1).clearAnimation();
      if ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().C) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().B)) {
        break label321;
      }
      ((View)localObject1).setVisibility(0);
      Object localObject2 = new mjg();
      ((mjg)localObject2).setDuration(1000L);
      ((mjg)localObject2).setRepeatCount(-1);
      ((View)localObject1).findViewById(2131376378).startAnimation((Animation)localObject2);
      int i;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().B) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().C))
      {
        ((TextView)((View)localObject1).findViewById(2131376386)).setText(2131695161);
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label319;
        }
        localObject2 = Build.MANUFACTURER;
        String str = Build.MODEL;
        if ((!"Xiaomi".equalsIgnoreCase((String)localObject2)) || (!"MI MAX".equalsIgnoreCase(str))) {
          break;
        }
        ((TextView)((View)localObject1).findViewById(2131376386)).setTextSize(1, 8.0F);
        return;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().B)
        {
          ((TextView)((View)localObject1).findViewById(2131376386)).setText(2131695162);
          i = 0;
        }
        else
        {
          ((TextView)((View)localObject1).findViewById(2131376386)).setText(2131695160);
          i = 1;
        }
      }
    }
    label321:
    ((View)localObject1).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzw
 * JD-Core Version:    0.7.0.1
 */