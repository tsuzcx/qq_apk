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

class lzo
  extends mck
{
  lzo(lzm paramlzm) {}
  
  protected void a()
  {
    if (this.a.jdField_a_of_type_Lzr != null) {
      this.a.jdField_a_of_type_Lzr.a(0, 0, true);
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
        lzm.a(this.a, 1);
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      } while (((lgf)localObject).jdField_h_of_type_Int == 11);
      if (this.a.jdField_a_of_type_Lzr != null) {
        this.a.jdField_a_of_type_Lzr.a(((lgf)localObject).jdField_d_of_type_JavaLangString, 1, false, false, false);
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramLong);
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
      }
      this.a.jdField_d_of_type_Boolean = false;
      this.a.c = ((lgf)localObject).jdField_d_of_type_Int;
      this.a.jdField_d_of_type_Int = ((lgf)localObject).f;
      if (!lmb.f())
      {
        this.a.jdField_a_of_type_Lzr.a(false, false);
        ((lgf)localObject).a(paramLong, false);
      }
      this.a.a(true);
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
        if (this.a.jdField_b_of_type_Int != 2) {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.e();
        }
      }
      if (((lgf)localObject).jdField_d_of_type_JavaLangString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
    return;
    ((lgf)localObject).jdField_h_of_type_Long = Long.valueOf(((lgf)localObject).jdField_d_of_type_JavaLangString).longValue();
    long l = ((lgf)localObject).g;
    if (((lgf)localObject).i == 3000) {
      ((lgf)localObject).a = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l));
    }
    ((lgf)localObject).b("onChangeUI_DobuleAudio2MultiAudio", mqr.a(((lgf)localObject).i));
    this.a.jdField_a_of_type_ComTencentAvVideoController.m(false);
    this.a.jdField_a_of_type_ComTencentAvVideoController.n(false);
    this.a.e = ((lgf)localObject).i;
    if (this.a.c == 4) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.a.c, false, false);
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().jdField_d_of_type_JavaLangString) + "";
    lhz.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (String)localObject);
    lhz.a(2, (String)localObject);
    lhz.a(2);
  }
  
  protected void a(long paramLong, ArrayList<los> paramArrayList)
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
    if ((this.a.jdField_a_of_type_Lzr != null) && (paramArrayList != null))
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      k = this.a.jdField_a_of_type_ComTencentAvVideoController.g();
      if (QLog.isColorLevel()) {
        QLog.w("SmallScreenVideoController", 1, "onRequest_ShowVideo, seq[" + paramLong + "], infoLogs[" + (String)localObject + "]");
      }
      j = 0;
      if (j < paramArrayList.size())
      {
        localObject = (los)paramArrayList.get(j);
        str1 = String.valueOf(((los)localObject).jdField_a_of_type_Long);
        m = ((los)localObject).jdField_a_of_type_Int;
        bool2 = ((los)localObject).jdField_a_of_type_Boolean;
        i = -1;
        if (this.a.e == 3000)
        {
          i = 1004;
          str2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str1, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().g));
          if ((!((los)localObject).jdField_b_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentAvVideoController.o())) {
            break label694;
          }
          if (str1.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            break label499;
          }
          lzr locallzr = this.a.jdField_a_of_type_Lzr;
          if (((los)localObject).jdField_b_of_type_Long != 5L) {
            break label493;
          }
          bool1 = true;
          label248:
          locallzr.a(str1, m, true, bool2, bool1);
          i = 0;
        }
      }
    }
    for (;;)
    {
      label265:
      if (i == 0) {
        if ((!((los)localObject).jdField_b_of_type_Boolean) && (!((los)localObject).jdField_a_of_type_Boolean) && (k != 4))
        {
          if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().E != 2) {
            break label530;
          }
          axqw.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Lzr.a(str1, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, ((los)localObject).jdField_b_of_type_Boolean, ((los)localObject).jdField_a_of_type_Boolean);
        if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().I)
        {
          float f = muf.a(this.a.jdField_a_of_type_AndroidContentContext, 12.0F);
          if (!str1.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            this.a.jdField_a_of_type_Lzr.a(str1, m, str2, f, -1);
          }
          this.a.jdField_a_of_type_Lzr.a(str1, m);
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
        this.a.jdField_a_of_type_Lzr.a(true, bool2);
        i = 1;
        break label265;
        label530:
        axqw.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
      }
      paramArrayList = this.a.jdField_a_of_type_Lzr;
      i = this.a.g;
      if (this.a.jdField_a_of_type_Mbv == null) {}
      for (bool1 = true;; bool1 = this.a.jdField_a_of_type_Mbv.jdField_b_of_type_Boolean)
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
    if ((paramString != null) && (paramString.equals("1")) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().S))
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(true);
      lzm.a(this.a, 2);
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
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().z = true;
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
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().z = true;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().t = Math.max(this.a.jdField_a_of_type_ComTencentAvVideoController.a().t, 735);
            j = mnt.a(paramString2, mnp.a().jdField_h_of_type_Int);
            QLog.i("SmallScreenVideoController", 1, "onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=" + j);
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().c = (j * 60 * 1000L);
            continue;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(2));
            this.a.jdField_a_of_type_ComTencentAvVideoController.E();
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().B = true;
            continue;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(4));
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().B = false;
            continue;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(6));
          }
        }
      }
    }
  }
  
  protected void a(ArrayList<los> paramArrayList)
  {
    if ((this.a.jdField_a_of_type_Lzr != null) && (paramArrayList != null))
    {
      Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onChangeUI_CloseVideo-->infos=" + (String)localObject);
      }
      int i = 0;
      if (i < paramArrayList.size())
      {
        localObject = (los)paramArrayList.get(i);
        String str = String.valueOf(((los)localObject).jdField_a_of_type_Long);
        boolean bool2 = ((los)localObject).jdField_a_of_type_Boolean;
        int j = ((los)localObject).jdField_a_of_type_Int;
        lzr locallzr;
        if (!str.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          if (this.a.jdField_a_of_type_Lzr.b(str, j))
          {
            mat.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
            mat.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
          }
          locallzr = this.a.jdField_a_of_type_Lzr;
          if (((los)localObject).jdField_b_of_type_Long != 5L) {
            break label207;
          }
        }
        label207:
        for (boolean bool1 = true;; bool1 = false)
        {
          locallzr.a(str, j, false, bool2, bool1);
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
    } while (this.a.jdField_a_of_type_Lzr == null);
    this.a.jdField_a_of_type_Lzr.a(true, paramBoolean);
    this.a.jdField_a_of_type_Lzr.c(paramLong, this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
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
    if (this.a.jdField_a_of_type_Lzr != null)
    {
      this.a.jdField_a_of_type_Lzr.a(false, false);
      lzm.a(this.a, 1);
    }
  }
  
  protected void c()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b != null) {
      lmi.a(this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b);
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
      localView = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b.findViewById(2131374988);
      if (localView == null)
      {
        QLog.d("SmallScreenVideoController", 1, "onChangeUI_RecordStateChange view is null");
        return;
      }
      localView.clearAnimation();
      if ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().B) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().A)) {
        break;
      }
      localView.setVisibility(0);
      Object localObject = new mit();
      ((mit)localObject).setDuration(1000L);
      ((mit)localObject).setRepeatCount(-1);
      localView.findViewById(2131374992).startAnimation((Animation)localObject);
      int i;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().A) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().B))
      {
        ((TextView)localView.findViewById(2131375000)).setText(2131696073);
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
        ((TextView)localView.findViewById(2131375000)).setTextSize(1, 8.0F);
        return;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().A)
        {
          ((TextView)localView.findViewById(2131375000)).setText(2131696074);
          i = 0;
        }
        else
        {
          ((TextView)localView.findViewById(2131375000)).setText(2131696072);
          i = 1;
        }
      }
    }
    localView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lzo
 * JD-Core Version:    0.7.0.1
 */