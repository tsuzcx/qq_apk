import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AVActivity.MyControlUIObserver.3;
import com.tencent.av.ui.AVActivity.MyControlUIObserver.4;
import com.tencent.av.ui.AVActivity.MyControlUIObserver.5;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import mqq.os.MqqHandler;

public class mbu
  extends mct
{
  public mbu(AVActivity paramAVActivity) {}
  
  protected void a()
  {
    this.a.g(-1032L);
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int) || (this.a.jdField_g_of_type_Boolean)) && (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(-1032L, "onChangeUI_ShowControlUI");
    }
  }
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt1, paramInt2, paramString);
    }
  }
  
  protected void a(int paramInt, long paramLong)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.a.isDestroyed())) {}
    do
    {
      return;
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "OnNotify_Effect_Toolbar_Selected, btnId[" + paramInt + "], seq[" + paramLong + "]");
      if (paramInt == 100) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
      }
      if (paramInt != 4) {
        break;
      }
      bool = lgv.a(this.a.getBaseContext());
      lgw.a(bool);
    } while (!bool);
    if (this.a.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel == null) {
      this.a.g();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() != 3) && (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() != 4)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a("onChangeUI_EffectToolbarSelected");
    }
    boolean bool = this.a.jdField_a_of_type_ComTencentAvVideoController.a().e;
    this.a.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), bool);
    ThreadManager.getUIHandler().post(new AVActivity.MyControlUIObserver.4(this));
    return;
    this.a.h();
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtuResCheck", 2, "onCheckPtuResRet, [" + paramInt + "," + paramBoolean + "]");
    }
    if ((paramInt == borf.b.jdField_a_of_type_Int) && (paramBoolean) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.runOnUiThread(new AVActivity.MyControlUIObserver.5(this));
    }
  }
  
  protected void a(long paramLong)
  {
    if (this.a.isDestroyed()) {}
    lff locallff;
    int j;
    String str;
    int k;
    boolean bool;
    do
    {
      return;
      locallff = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (QLog.isColorLevel()) {
        QLog.w("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[" + this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop + "], ActivityState[" + this.a.b() + "], getVideoAbilityLevel[" + this.a.jdField_a_of_type_ComTencentAvVideoController.h() + "], session[" + locallff + "], seq[" + paramLong + "]");
      }
      j = this.a.jdField_b_of_type_Int;
      str = this.a.jdField_d_of_type_JavaLangString;
      k = this.a.jdField_d_of_type_Int;
      if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0)) {
        this.a.a(paramLong, "onChangeUI_DobuleAudio2MultiAudio", false);
      }
      if ((locallff.B) && (this.a.jdField_a_of_type_Mjd != null)) {
        this.a.jdField_a_of_type_Mjd.c();
      }
      if ((locallff.C) || ((this.a.jdField_a_of_type_Mjd != null) && (this.a.jdField_a_of_type_Mjd.d() != 1)))
      {
        locallff.C = false;
        this.a.jdField_a_of_type_Mjd.m();
      }
      bool = locallff.jdField_g_of_type_Boolean;
      if (locallff.i != 11) {
        break;
      }
    } while (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(null);
    return;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.h() != 4) || (!mtl.c())) {
        break label586;
      }
    }
    long l2;
    label586:
    for (int i = 3;; i = 4)
    {
      this.a.a(i, false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, locallff.jdField_d_of_type_JavaLangString, 1, false, false, false);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.a.a("onChangeUI_DobuleAudio2MultiAudio", false);
      this.a.jdField_b_of_type_Int = locallff.jdField_d_of_type_Int;
      if (this.a.jdField_a_of_type_Mcm != null) {
        this.a.jdField_a_of_type_Mcm.f();
      }
      if (!llk.e())
      {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong, true);
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
        }
        locallff.a(paramLong, false);
      }
      lln.a().a();
      this.a.a(paramLong, true);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong);
        if (this.a.jdField_a_of_type_Int != 4) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong);
        }
      }
      l2 = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      if (locallff.jdField_d_of_type_JavaLangString != null) {
        break label591;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
      return;
    }
    label591:
    locallff.h = Long.valueOf(locallff.jdField_d_of_type_JavaLangString).longValue();
    long l1 = locallff.jdField_g_of_type_Long;
    Object localObject2;
    Object localObject1;
    if (locallff.jdField_j_of_type_Int == 1)
    {
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder().append("onChangeUI_DobuleAudio2MultiAudio uinList[");
        if (locallff.a != null) {
          break label772;
        }
        localObject1 = "null";
        label657:
        QLog.i("double_2_multi", 4, localObject1 + "]");
      }
      localObject1 = locallff.a;
      localObject2 = new ArrayList();
      i = 0;
      label696:
      if ((localObject1 == null) || (i >= localObject1.length)) {
        break label805;
      }
      if ((localObject1[i] != l2) && (localObject1[i] != locallff.h)) {
        break label786;
      }
    }
    for (;;)
    {
      i += 1;
      break label696;
      if (locallff.jdField_j_of_type_Int != 3000) {
        break;
      }
      locallff.a = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l1));
      break;
      label772:
      localObject1 = Integer.valueOf(locallff.a.length);
      break label657;
      label786:
      ((ArrayList)localObject2).add(Long.valueOf(locallff.a[i]));
    }
    label805:
    if (((ArrayList)localObject2).size() > 0)
    {
      i = ((ArrayList)localObject2).size();
      l2 = ((Long)((ArrayList)localObject2).get(0)).longValue();
      int m = mrl.c(locallff.F);
      localObject2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(m, String.valueOf(l2), String.valueOf(locallff.jdField_g_of_type_Long));
      localObject1 = localObject2;
      if (((String)localObject2).length() > 7) {
        localObject1 = ((String)localObject2).substring(0, 6) + "...";
      }
      localObject2 = localObject1;
      if (i > 1) {
        localObject2 = (String)localObject1 + anzj.a(2131699776) + i + anzj.a(2131699775);
      }
      localObject1 = String.format(this.a.getString(2131695289), new Object[] { localObject2 });
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c((String)localObject1);
      }
    }
    for (;;)
    {
      if (bool) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.onChangeUI_DobuleAudio2MultiAudio", l1, false, false, -1);
      }
      locallff.d("onChangeUI_DobuleAudio2MultiAudio", 0);
      this.a.jdField_a_of_type_ComTencentAvVideoController.l(false);
      this.a.jdField_a_of_type_ComTencentAvVideoController.m(false);
      this.a.jdField_d_of_type_Int = locallff.jdField_j_of_type_Int;
      if (this.a.jdField_b_of_type_Int == 4) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.a.jdField_b_of_type_Int, false, false);
      }
      this.a.jdField_d_of_type_JavaLangString = String.valueOf(locallff.jdField_g_of_type_Long);
      if (this.a.jdField_a_of_type_Mng != null) {
        this.a.jdField_a_of_type_Mng.a();
      }
      QLog.w("double_2_multi", 1, "onChangeUI_DobuleAudio2MultiAudio end, oldSessionType[" + j + "], oldUinType[" + k + "], oldRelationId[" + str + "], mRelationId[" + this.a.jdField_d_of_type_JavaLangString + "], sessionInfo[" + locallff + "]");
      return;
      if (QLog.isColorLevel()) {
        QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->inviteList is null");
      }
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onNotify_MenuView_Changed, menuType[" + paramInt + "], seq[" + paramLong + "]");
    this.a.g(paramLong);
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  protected void a(long paramLong, ArrayList<lob> paramArrayList)
  {
    if ((this.a.jdField_a_of_type_Int == 4) || (this.a.jdField_a_of_type_Int == 5) || (this.a.jdField_a_of_type_Int == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onRequest_ShowVideo ignore ");
      }
      return;
    }
    Object localObject = null;
    if (paramArrayList != null) {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onRequest_ShowVideo, infoLogs[" + (String)localObject + "], seq[" + paramLong + "]");
    }
    int k;
    int j;
    lob locallob;
    String str2;
    int m;
    boolean bool2;
    boolean bool3;
    int i;
    String str1;
    boolean bool1;
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
    {
      k = this.a.jdField_a_of_type_ComTencentAvVideoController.h();
      Collections.sort(paramArrayList, new mbv(this));
      if (QLog.isColorLevel()) {
        QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onRequest_ShowVideo, after sort infoLogs[" + (String)localObject + "], seq[" + paramLong + "]");
      }
      j = 0;
      if (j < paramArrayList.size())
      {
        locallob = (lob)paramArrayList.get(j);
        str2 = mrs.a(locallob.jdField_a_of_type_Long);
        m = locallob.jdField_a_of_type_Int;
        bool2 = locallob.jdField_a_of_type_Boolean;
        bool3 = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m);
        i = mrl.b(this.a.jdField_d_of_type_Int);
        str1 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str2, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long));
        if (!locallob.jdField_b_of_type_Boolean) {
          break label1324;
        }
        if (!str2.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          localObject = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if ((locallob.jdField_b_of_type_Long == 5L) || (locallob.jdField_b_of_type_Long == 14L))
          {
            bool1 = true;
            label385:
            ((VideoLayerUI)localObject).a(paramLong, str2, m, true, bool2, bool1);
            if ((!bool2) || (locallob.d)) {
              break label1324;
            }
            if (mrs.a(str1) <= 20) {
              break label1317;
            }
            localObject = mrs.a(str1, 0, 20) + "...";
            label452:
            if (m != 2) {
              break label808;
            }
            localObject = String.format(this.a.getString(2131694916), new Object[] { localObject });
            if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
              break label789;
            }
            this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(1036, (String)localObject);
            label520:
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      label523:
      if (i == 0)
      {
        AVActivity.a(this.a);
        if ((locallob.jdField_b_of_type_Boolean) || (locallob.jdField_a_of_type_Boolean)) {
          break label1151;
        }
        if (k == 4) {
          break label1116;
        }
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) {
          break label1026;
        }
        bdll.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
        label607:
        if (this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.a.jdField_a_of_type_AndroidGraphicsBitmap = mvd.a(this.a.getApplicationContext(), 2130842108);
        }
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str2, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, locallob.jdField_b_of_type_Boolean, locallob.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        if ((!bool3) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().J))
        {
          float f2 = 12.0F;
          float f1 = f2;
          if (bool2)
          {
            f1 = f2;
            if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() != 3) {
              f1 = 18.0F;
            }
          }
          f1 = mvd.a(this.a.getApplicationContext(), f1);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, str1, f1, -1);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m);
        }
        j += 1;
        break;
        bool1 = false;
        break label385;
        label789:
        mbb.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036, (String)localObject);
        break label520;
        label808:
        localObject = String.format(this.a.getString(2131694917), new Object[] { localObject });
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_b_of_type_JavaLangString, 1, "onRequest_ShowVideo, will loading name[" + str1 + "]");
        }
        if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof MultiVideoCtrlLayerUIBase)))
        {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(1037, (String)localObject);
          break label520;
        }
        mbb.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037, (String)localObject);
        break label520;
        if ((str2.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (m == 2)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label994;
          }
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, true, bool2);
          i = 0;
          break;
        }
        label994:
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, true, bool2);
        i = 1;
        break label523;
        label1026:
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)
        {
          bdll.b(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
          break label607;
        }
        bdll.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
        break label607;
        label1116:
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str2, m, this.a.jdField_b_of_type_AndroidGraphicsBitmap, locallob.jdField_b_of_type_Boolean, locallob.jdField_a_of_type_Boolean);
        continue;
        label1151:
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str2, m, this.a.jdField_b_of_type_AndroidGraphicsBitmap, locallob.jdField_b_of_type_Boolean, locallob.jdField_a_of_type_Boolean);
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.h, false);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, this.a.h);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.a.h);
      }
      if (this.a.jdField_a_of_type_Mmf != null) {
        this.a.jdField_a_of_type_Mmf.b();
      }
      if (this.a.jdField_a_of_type_Mng == null) {
        break;
      }
      this.a.jdField_a_of_type_Mng.a();
      return;
      label1317:
      localObject = str1;
      break label452;
      label1324:
      i = 0;
    }
  }
  
  protected void a(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    boolean bool = true;
    if (this.a.isDestroyed()) {}
    while ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h())) {
      return;
    }
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l(true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.n();
    }
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l(false);
    }
    if ((paramBoolean1) && (!paramBoolean2))
    {
      this.a.a(paramLong1, 50L);
      this.a.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong1, this.a, 2, 2);
    }
    lir.a(paramBoolean2);
    this.a.a(Integer.valueOf(6503), Boolean.valueOf(paramBoolean2), null);
    AVActivity localAVActivity = this.a;
    if ((!paramBoolean1) && (!paramBoolean2)) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      localAVActivity.b(paramLong1, "onNotify_SwitchToolbarAnimation", paramBoolean1);
      return;
    }
  }
  
  protected void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, " onChangeUI_receiveTransferMsg ");
    }
    if (this.a.jdField_d_of_type_Int == 9500) {
      if ((paramObject instanceof llh))
      {
        paramObject = (llh)paramObject;
        if (paramObject.jdField_a_of_type_Int != 6) {
          break label334;
        }
        if ((paramObject.jdField_b_of_type_Int & 0x1) != 1) {
          break label278;
        }
        if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.n = true;
          ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(2131373338, true, 2130841985);
        }
      }
    }
    label277:
    label278:
    label334:
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
              do
              {
                break label277;
                break label277;
                break label277;
                break label277;
                for (;;)
                {
                  if (((paramObject.jdField_b_of_type_Int & 0x4) == 4) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    this.a.jdField_a_of_type_ComTencentAvVideoController.o = true;
                    ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).I();
                  }
                  if (((paramObject.jdField_b_of_type_Int & 0x8) == 8) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    this.a.jdField_a_of_type_ComTencentAvVideoController.p = false;
                    DoubleVideoCtrlUI localDoubleVideoCtrlUI = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
                    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.MyControlUIObserver.3(this, localDoubleVideoCtrlUI), 500L);
                  }
                  if (((paramObject.jdField_b_of_type_Int & 0x2) == 2) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
                    this.a.jdField_a_of_type_ComTencentAvVideoController.a().b(0L, false);
                  }
                  return;
                  if (((paramObject.jdField_b_of_type_Int & 0x1) == 0) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    this.a.jdField_a_of_type_ComTencentAvVideoController.n = false;
                    ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(2131373338, false, 2130841985);
                  }
                }
              } while (paramObject.jdField_a_of_type_Int != 5);
              if (paramObject.jdField_b_of_type_Int != 2) {
                break;
              }
            } while (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI));
            paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
            paramObject.a(2131695293, 2, 0, paramObject.a.getDimensionPixelSize(2131299011));
            return;
          } while ((paramObject.jdField_b_of_type_Int != 3) || (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)));
          paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
          paramObject.a(2131695292, 1, 0, paramObject.a.getDimensionPixelSize(2131299011));
          return;
        } while (!(paramObject instanceof llh));
        paramObject = (llh)paramObject;
      } while ((paramObject.jdField_a_of_type_Int != 11) || (paramObject.jdField_b_of_type_Int != 1) || (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)));
      this.a.jdField_a_of_type_ComTencentAvVideoController.q = true;
    } while (!QLog.isColorLevel());
    QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "receiveTransferMsg xiaowei Device");
  }
  
  protected void a(String paramString)
  {
    if (paramString != null)
    {
      if (!paramString.equals("1")) {
        break label63;
      }
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().U)
      {
        this.a.b(null);
        if (!this.a.isResume()) {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(false);
        }
      }
    }
    label63:
    while (!paramString.startsWith("START")) {
      return;
    }
    paramString = paramString.substring("START_".length());
    this.a.b(paramString);
  }
  
  protected void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString1, paramInt1, paramString2, paramInt2);
    }
  }
  
  protected void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAVFunChatMessage == null)) {
      if (QLog.isColorLevel()) {
        QLog.i(this.a.jdField_b_of_type_JavaLangString, 2, "onReceiveCreativeCopMsg, invalid params.");
      }
    }
    for (;;)
    {
      return;
      long l1 = AudioHelper.b();
      int i = paramAVFunChatMessage.enum_operator.get();
      long l2 = paramAVFunChatMessage.uint64_type.get();
      String str = paramAVFunChatMessage.str_msg.get();
      boolean bool = loy.b();
      if ((l2 == 14L) && (bool))
      {
        if (i != 1) {
          break label337;
        }
        if (!"SUPPORT_CREATIVECOP_TRUE".equals(str)) {
          break label213;
        }
        ((lih)this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(3, 14, "SUPPORT_CREATIVECOP_TRUE");
      }
      while (QLog.isColorLevel())
      {
        QLog.i(this.a.jdField_b_of_type_JavaLangString, 2, "onReceiveCreativeCopMsg, fromUin[" + paramString + "], msg[" + paramAVFunChatMessage.uint64_type.get() + ", " + paramAVFunChatMessage.enum_operator.get() + ", " + paramAVFunChatMessage.str_msg.get() + "]");
        return;
        label213:
        if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i())) {
          this.a.h(false);
        }
        Object localObject;
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          localObject = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
          if (localObject == null) {
            break label311;
          }
          ((EffectSettingUi)localObject).setSelectedBtn(2);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(str)) {
            break label335;
          }
          new mcy(l1, str, false, 4).a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          break;
          label311:
          localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          if (localObject != null) {
            ((lff)localObject).Y = 2;
          }
        }
        label335:
        continue;
        label337:
        if (i == 0) {
          this.a.a(Integer.valueOf(6101), null, Boolean.valueOf(false));
        }
      }
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_Mjd != null) {
      this.a.jdField_a_of_type_Mjd.a(paramString1, paramString2);
    }
  }
  
  protected void a(ArrayList<lob> paramArrayList)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
    {
      long l = AudioHelper.b();
      Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onChangeUI_CloseVideo, seq[" + l + "], infoLogs[" + (String)localObject + "]");
      }
      Collections.sort(paramArrayList, new mbw(this));
      int i = 0;
      if (i < paramArrayList.size())
      {
        localObject = (lob)paramArrayList.get(i);
        String str = mrs.a(((lob)localObject).jdField_a_of_type_Long);
        boolean bool2 = ((lob)localObject).jdField_a_of_type_Boolean;
        int j = ((lob)localObject).jdField_a_of_type_Int;
        boolean bool1;
        if (!str.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str, j))
          {
            if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
              this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(1037);
            }
            mbb.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
          }
          VideoLayerUI localVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if ((((lob)localObject).jdField_b_of_type_Long == 5L) || (((lob)localObject).jdField_b_of_type_Long == 14L))
          {
            bool1 = true;
            label260:
            localVideoLayerUI.a(l, str, j, false, bool2, bool1);
          }
        }
        label324:
        for (;;)
        {
          i += 1;
          break;
          bool1 = false;
          break label260;
          if (((lob)localObject).jdField_a_of_type_Int == 2) {}
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label324;
            }
            this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l, false, false);
            break;
          }
        }
      }
      this.a.h();
    }
    if (this.a.jdField_a_of_type_Mmf != null) {
      this.a.jdField_a_of_type_Mmf.b();
    }
    if (this.a.jdField_a_of_type_Mng != null) {
      this.a.jdField_a_of_type_Mng.a();
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (this.a.jdField_a_of_type_Int == 4) {}
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        boolean bool = paramBoolean;
        if (!paramBoolean) {
          bool = mqr.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, "onRequest_OpenCamera");
        }
        AVActivity.a(this.a);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, true, bool);
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().J))
        {
          String str1 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
          int i = mrl.b(this.a.jdField_d_of_type_Int);
          String str2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str1, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long));
          float f = 12.0F;
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str1, 1)) {
            f = 18.0F;
          }
          f = mvd.a(this.a.getApplicationContext(), f);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, 1, str2, f, -1);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str1, 1, this.a.jdField_b_of_type_AndroidGraphicsBitmap, true, true);
        }
      }
    } while (this.a.jdField_a_of_type_Mng == null);
    this.a.jdField_a_of_type_Mng.a();
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.m)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.m = false;
      this.a.e = true;
      this.a.finish();
    }
  }
  
  protected void b(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  protected void b(int paramInt, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ChatRoomUtil", 4, "onNotify_ChatRoom_InputPanelChange, lastPanelState[" + paramInt + "], seq[" + paramLong + "]");
    }
    this.a.a(paramLong, 1);
  }
  
  protected void b(long paramLong)
  {
    lff locallff = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting, cur[" + locallff + "]");
    }
    int i = this.a.jdField_b_of_type_Int;
    String str = this.a.jdField_d_of_type_JavaLangString;
    int j = this.a.jdField_d_of_type_Int;
    if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0)) {
      this.a.a(paramLong, "onChangeUI_Normal2Meeting", false);
    }
    if ((locallff.B) && (this.a.jdField_a_of_type_Mjd != null)) {
      this.a.jdField_a_of_type_Mjd.c();
    }
    if ((locallff.C) || ((this.a.jdField_a_of_type_Mjd != null) && (this.a.jdField_a_of_type_Mjd.d() != 1)))
    {
      locallff.C = false;
      this.a.jdField_a_of_type_Mjd.m();
    }
    boolean bool = locallff.jdField_g_of_type_Boolean;
    if (locallff.i == 16) {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(null);
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        this.a.a(4, false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, locallff.jdField_d_of_type_JavaLangString, 1, false, false, false);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.a.a("onChangeUI_Normal2Meeting", true);
      if (locallff.jdField_d_of_type_Int == 2)
      {
        locallff.jdField_d_of_type_Int = 1;
        if (QLog.isColorLevel()) {
          QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting video to audio .");
        }
      }
      this.a.jdField_b_of_type_Int = locallff.jdField_d_of_type_Int;
      if (this.a.jdField_b_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting illegal session type.");
        }
        this.a.jdField_b_of_type_Int = 1;
      }
      if (this.a.jdField_a_of_type_Mcm != null) {
        this.a.jdField_a_of_type_Mcm.f();
      }
      if (!llk.e())
      {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong, true);
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
        }
        locallff.a(paramLong, false);
      }
      lln.a().a();
      this.a.a(paramLong, true);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong);
        if (this.a.jdField_a_of_type_Int != 4) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong);
        }
      }
      if (locallff.jdField_d_of_type_JavaLangString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("double_2_multi", 2, "onChangeUI_Normal2Meeting-->Peer uin is null!!!!!!!!!");
    return;
    long l = locallff.jdField_g_of_type_Long;
    locallff.h = Long.valueOf(locallff.jdField_d_of_type_JavaLangString).longValue();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(null);
    }
    if (bool) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.onChangeUI_Normal2Meeting", l, false, false, -1);
    }
    locallff.f("AVActivity.onChangeUI_Normal2Meeting", false);
    this.a.jdField_d_of_type_Int = locallff.jdField_j_of_type_Int;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, locallff.jdField_d_of_type_Int, false, true);
    if ((locallff.jdField_j_of_type_Boolean) || (locallff.aG)) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, locallff.jdField_d_of_type_Int, false, false);
    }
    this.a.jdField_d_of_type_JavaLangString = String.valueOf(locallff.jdField_g_of_type_Long);
    if (this.a.jdField_a_of_type_Mng != null) {
      this.a.jdField_a_of_type_Mng.a();
    }
    QLog.w("normal_2_meeting", 1, "onChangeUI_Normal2Meeting end, oldSessionType[" + i + "], oldUinType[" + j + "], oldRelationId[" + str + "], mRelationId[" + this.a.jdField_d_of_type_JavaLangString + "], sessionInfo[" + locallff + "]");
  }
  
  protected void b(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g(paramString);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onChangeUI_ChildLockStateChange, lock[" + paramBoolean + "], seq[" + l + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(l, 2048);
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) && (this.a.jdField_a_of_type_Mjd != null)) {
      this.a.jdField_a_of_type_Mjd.n();
    }
  }
  
  protected void c()
  {
    ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(2131363100);
    if (localViewGroup != null) {
      llr.a(localViewGroup);
    }
  }
  
  protected void c(int paramInt)
  {
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    if ((i == 1) || (i == 3)) {}
    while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().h()) || ((this.a.jdField_a_of_type_Mcm != null) && (this.a.jdField_a_of_type_Mcm.a())) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)) {
      return;
    }
    if ((this.a.jdField_a_of_type_Mcm == null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))) {
      this.a.jdField_a_of_type_Mcm = new mcm(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.a, this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI, (RelativeLayout)AVActivity.a(this.a, 2131373349));
    }
    if ((this.a.jdField_a_of_type_Mcm != null) && (this.a.jdField_a_of_type_Mcm.c()))
    {
      this.a.jdField_a_of_type_Mcm.e();
      bdll.b(null, "CliOper", "", "", "0X80061F6", "0X80061F6", 0, 0, "", "", "", "");
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramInt);
  }
  
  protected void c(long paramLong)
  {
    this.a.a(paramLong);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onChangeUI_NotifyChangedZimuPeer id=" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("SUPPORT"))) {
      d(2);
    }
  }
  
  public void d()
  {
    AVActivity localAVActivity = this.a;
    if (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()) {}
    for (boolean bool = true;; bool = false)
    {
      localAVActivity.b(-1048L, "onChangeUI_RecordStateChange", bool);
      return;
    }
  }
  
  public void d(int paramInt)
  {
    if (this.a.jdField_a_of_type_Mjd != null) {
      this.a.jdField_a_of_type_Mjd.g(paramInt);
    }
  }
  
  protected void d(long paramLong)
  {
    mrk.a("switch_camera", "onRequest_SwitchCamera", 3, new Object[] { Long.valueOf(paramLong) });
    if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.d(paramLong);
    }
  }
  
  protected void e() {}
  
  protected void e(int paramInt)
  {
    boolean bool2 = true;
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onChangeUI_MagicFacePlayStateChange, state[" + paramInt + "], seq[" + l + "]");
    }
    AVActivity localAVActivity;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      localAVActivity = this.a;
      if (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())
      {
        bool1 = true;
        localAVActivity.b(l, "onChangeUI_MagicFacePlayStateChange", bool1);
      }
    }
    else
    {
      if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) && (this.a.jdField_a_of_type_Mjd != null)) {
        this.a.jdField_a_of_type_Mjd.n();
      }
      localAVActivity = this.a;
      if (paramInt != 5) {
        break label169;
      }
    }
    label169:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localAVActivity.d(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void e(long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.C(paramLong);
    }
  }
  
  protected void f()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.j(false);
    }
  }
  
  protected void f(long paramLong)
  {
    AVActivity.a(this.a, paramLong);
  }
  
  protected void g()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.j(true);
    }
  }
  
  public void h()
  {
    AVActivity localAVActivity;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      localAVActivity = this.a;
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()) {
        break label42;
      }
    }
    label42:
    for (boolean bool = true;; bool = false)
    {
      localAVActivity.b(-1050L, "onRequest_RefreshRecordBtn", bool);
      return;
    }
  }
  
  protected void i()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onChangeUI_SmallView_Position_change, seq[" + l + "]");
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int) || (this.a.jdField_g_of_type_Boolean))) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(l, "onChangeUI_SmallView_Position_change");
    }
  }
  
  protected void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_b_of_type_JavaLangString, 2, "onChangeUI_quitDoubleScreenStatus");
    }
    this.a.h(true);
  }
  
  protected void k()
  {
    mbb.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1008, 2131694880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mbu
 * JD-Core Version:    0.7.0.1
 */