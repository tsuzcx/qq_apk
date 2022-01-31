import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.av.smallscreen.SmallScreenVideoLayerUI;
import com.tencent.av.ui.AbstractOrientationEventListener;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavVideoRecordUICtrl.FadeInOutAnimation;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.av.ui.funchat.record.QavRecordUtils;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class jrc
  extends ControlUIObserver
{
  public jrc(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  protected void a() {}
  
  protected void a(String paramString)
  {
    if ((paramString != null) && (paramString.equals("1")) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().S))
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().S = true;
      SmallScreenVideoController.a(this.a, 2);
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
            break label283;
          }
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().x = true;
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().s = Math.max(this.a.jdField_a_of_type_ComTencentAvVideoController.a().s, 730);
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
          h();
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
          label283:
          if (paramString2.startsWith("SUPPORT_TRUE_7.3.5"))
          {
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().x = true;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().s = Math.max(this.a.jdField_a_of_type_ComTencentAvVideoController.a().s, 735);
            j = QavRecordUtils.a(paramString2, QavRecordDpc.a().h);
            QLog.i("SmallScreenVideoController", 1, "onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=" + j);
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Long = (j * 60 * 1000L);
            continue;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(2));
            this.a.jdField_a_of_type_ComTencentAvVideoController.O();
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().z = true;
            continue;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(4));
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().z = false;
            continue;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(6));
          }
        }
      }
    }
  }
  
  protected void a(ArrayList paramArrayList)
  {
    Object localObject;
    int k;
    int j;
    String str1;
    int m;
    boolean bool2;
    int i;
    label137:
    String str2;
    boolean bool1;
    if ((this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) && (paramArrayList != null))
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      k = this.a.jdField_a_of_type_ComTencentAvVideoController.g();
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onChangeUI_ShowVideo-->infos=" + (String)localObject);
      }
      j = 0;
      if (j < paramArrayList.size())
      {
        localObject = (VideoViewInfo)paramArrayList.get(j);
        str1 = String.valueOf(((VideoViewInfo)localObject).jdField_a_of_type_Long);
        m = ((VideoViewInfo)localObject).jdField_a_of_type_Int;
        bool2 = ((VideoViewInfo)localObject).jdField_a_of_type_Boolean;
        i = -1;
        if (this.a.jdField_d_of_type_Int == 3000)
        {
          i = 1004;
          str2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str1, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long));
          if ((!((VideoViewInfo)localObject).jdField_b_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentAvVideoController.n())) {
            break label660;
          }
          if (str1.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            break label472;
          }
          SmallScreenVideoLayerUI localSmallScreenVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
          if (((VideoViewInfo)localObject).jdField_b_of_type_Long != 5L) {
            break label466;
          }
          bool1 = true;
          label231:
          localSmallScreenVideoLayerUI.a(str1, m, true, bool2, bool1);
          i = 0;
        }
      }
    }
    for (;;)
    {
      label247:
      if (i == 0) {
        if ((!((VideoViewInfo)localObject).jdField_b_of_type_Boolean) && (!((VideoViewInfo)localObject).jdField_a_of_type_Boolean) && (k != 4))
        {
          if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) {
            break label501;
          }
          ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(str1, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, ((VideoViewInfo)localObject).jdField_b_of_type_Boolean, ((VideoViewInfo)localObject).jdField_a_of_type_Boolean);
        if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().G)
        {
          float f = UITools.a(this.a.jdField_a_of_type_AndroidContentContext, 12.0F);
          if (!str1.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(str1, m, str2, f, -1);
          }
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.b(str1, m);
        }
        j += 1;
        break;
        if (this.a.jdField_d_of_type_Int == 1)
        {
          i = 1000;
          break label137;
        }
        if (this.a.jdField_d_of_type_Int != 0) {
          break label137;
        }
        i = 0;
        break label137;
        label466:
        bool1 = false;
        break label231;
        label472:
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, bool2);
        i = 1;
        break label247;
        label501:
        ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
      }
      paramArrayList = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
      i = this.a.f;
      if (this.a.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener == null) {}
      for (bool1 = true;; bool1 = this.a.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener.jdField_b_of_type_Boolean)
      {
        paramArrayList.a(i, bool1);
        i = this.a.f;
        j = this.a.jdField_a_of_type_AndroidViewDisplay.getRotation();
        if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b((i + j * 90) % 360);
        }
        if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
          this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.a.f);
        }
        return;
      }
      label660:
      i = 0;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.jdField_b_of_type_Int == 2) {}
    do
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (!this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d())) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
      }
    } while (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI == null);
    this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.f(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onChangeUI_DobuleAudio2MultiAudio isBackground_Stop:" + this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    long l1;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          SmallScreenVideoController.a(this.a, 1);
        } while (this.a.jdField_a_of_type_ComTencentAvVideoController.a().h == 11);
        if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, false, false, false);
        }
        if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
        {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.c();
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
        }
        this.a.jdField_d_of_type_Boolean = false;
        this.a.c = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
        if (!VcSystemInfo.f())
        {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(false, false);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = false;
        }
        this.a.a(true);
        if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
        {
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
          if (this.a.jdField_b_of_type_Int != 2) {
            this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.f();
          }
        }
        l1 = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().c != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SmallScreenVideoController", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
      return;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c).longValue();
      long l2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().a = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l2));
      localObject = new ArrayList();
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().a != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().a.length != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SmallScreenVideoController", 2, "onChangeUI_DobuleAudio2MultiAudio-->uinList is null");
    return;
    int i = 0;
    if (i < this.a.jdField_a_of_type_ComTencentAvVideoController.a().a.length)
    {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().a[i] == l1) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().a[i] == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long)) {}
      for (;;)
      {
        i += 1;
        break;
        ((ArrayList)localObject).add(Long.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().a[i]));
      }
    }
    if (((ArrayList)localObject).size() > 0)
    {
      i = ((ArrayList)localObject).size();
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.size() <= 0) {
        break label1010;
      }
      i += this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.size();
    }
    label1010:
    for (;;)
    {
      l1 = ((Long)((ArrayList)localObject).get(0)).longValue();
      String str1 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1004, String.valueOf(l1), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long));
      localObject = str1;
      if (str1.length() > 9) {
        localObject = str1.substring(0, 8) + "...";
      }
      if (i > 1) {
        new StringBuilder().append((String)localObject).append("等").append(i).append("人").toString();
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().a("onChangeUI_DobuleAudio2MultiAudio", false);
        this.a.jdField_d_of_type_Int = this.a.jdField_a_of_type_ComTencentAvVideoController.a().i;
        if (this.a.c == 4) {
          this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c, false, false);
        }
        localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c) + "";
        MagicDataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (String)localObject);
        MagicDataReport.a(2, (String)localObject);
        MagicDataReport.a(2);
        return;
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenVideoController", 2, "onChangeUI_DobuleAudio2MultiAudio-->inviteList is null");
        }
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.size() > 0)
        {
          String str2 = ((AVPhoneUserInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.get(0)).telInfo.mobile;
          str1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(str2);
          localObject = str1;
          if (str1 == null) {
            localObject = PstnUtils.a(str2, 4);
          }
          i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.size();
          if (i > 1) {
            new StringBuilder().append((String)localObject).append("等").append(i).append("人").toString();
          }
        }
      }
    }
  }
  
  protected void b(ArrayList paramArrayList)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) && (paramArrayList != null))
    {
      Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onChangeUI_CloseVideo-->infos=" + (String)localObject);
      }
      int i = 0;
      if (i < paramArrayList.size())
      {
        localObject = (VideoViewInfo)paramArrayList.get(i);
        String str = String.valueOf(((VideoViewInfo)localObject).jdField_a_of_type_Long);
        boolean bool2 = ((VideoViewInfo)localObject).jdField_a_of_type_Boolean;
        int j = ((VideoViewInfo)localObject).jdField_a_of_type_Int;
        SmallScreenVideoLayerUI localSmallScreenVideoLayerUI;
        if (!str.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.b(str, j))
          {
            TipsManager.c(106);
            TipsManager.c(103);
          }
          localSmallScreenVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
          if (((VideoViewInfo)localObject).jdField_b_of_type_Long != 5L) {
            break label191;
          }
        }
        label191:
        for (boolean bool1 = true;; bool1 = false)
        {
          localSmallScreenVideoLayerUI.a(str, j, false, bool2, bool1);
          i += 1;
          break;
        }
      }
    }
  }
  
  protected void c()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(0, 0, true);
    }
  }
  
  protected void d()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(false, false);
      SmallScreenVideoController.a(this.a, 1);
    }
  }
  
  protected void e()
  {
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    if ((i == 1) || (i == 3)) {}
    while (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().c()) {
      return;
    }
  }
  
  protected void f()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.q)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.q = false;
      this.a.jdField_b_of_type_Boolean = true;
      this.a.d();
    }
  }
  
  protected void g()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b != null) {
      DoodleUtils.a(this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b);
    }
  }
  
  public void h()
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
      localView = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b.findViewById(2131366263);
      if (localView == null)
      {
        QLog.d("SmallScreenVideoController", 1, "onChangeUI_RecordStateChange view is null");
        return;
      }
      localView.clearAnimation();
      if ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().z) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().y)) {
        break;
      }
      localView.setVisibility(0);
      Object localObject = new QavVideoRecordUICtrl.FadeInOutAnimation();
      ((QavVideoRecordUICtrl.FadeInOutAnimation)localObject).setDuration(1000L);
      ((QavVideoRecordUICtrl.FadeInOutAnimation)localObject).setRepeatCount(-1);
      localView.findViewById(2131366264).startAnimation((Animation)localObject);
      int i;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().y) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().z))
      {
        ((TextView)localView.findViewById(2131366265)).setText(2131429668);
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
        ((TextView)localView.findViewById(2131366265)).setTextSize(1, 8.0F);
        return;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().y)
        {
          ((TextView)localView.findViewById(2131366265)).setText(2131429666);
          i = 0;
        }
        else
        {
          ((TextView)localView.findViewById(2131366265)).setText(2131429667);
          i = 1;
        }
      }
    }
    localView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jrc
 * JD-Core Version:    0.7.0.1
 */