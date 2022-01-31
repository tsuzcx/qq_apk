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

public class mdw
  extends meu
{
  public mdw(AVActivity paramAVActivity) {}
  
  protected void a()
  {
    this.a.g(-1032L);
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int) || (this.a.jdField_g_of_type_Boolean)) && (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m)) {
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
      bool = ljs.a(this.a.getBaseContext());
      ljt.a(bool);
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
  
  protected void a(long paramLong)
  {
    if (this.a.isDestroyed()) {}
    lid locallid;
    int j;
    String str;
    int k;
    boolean bool;
    do
    {
      return;
      locallid = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (QLog.isColorLevel()) {
        QLog.w("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[" + this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop + "], ActivityState[" + this.a.b() + "], getVideoAbilityLevel[" + this.a.jdField_a_of_type_ComTencentAvVideoController.g() + "], session[" + locallid + "], seq[" + paramLong + "]");
      }
      j = this.a.jdField_b_of_type_Int;
      str = this.a.jdField_d_of_type_JavaLangString;
      k = this.a.jdField_d_of_type_Int;
      if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0)) {
        this.a.a(paramLong, "onChangeUI_DobuleAudio2MultiAudio", false);
      }
      if ((locallid.B) && (this.a.jdField_a_of_type_Mlf != null)) {
        this.a.jdField_a_of_type_Mlf.c();
      }
      if ((locallid.jdField_C_of_type_Boolean) || ((this.a.jdField_a_of_type_Mlf != null) && (this.a.jdField_a_of_type_Mlf.d() != 1)))
      {
        locallid.jdField_C_of_type_Boolean = false;
        this.a.jdField_a_of_type_Mlf.m();
      }
      bool = locallid.jdField_g_of_type_Boolean;
      if (locallid.jdField_h_of_type_Int != 11) {
        break;
      }
    } while (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(null);
    return;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.g() != 4) || (!mvh.c())) {
        break label586;
      }
    }
    long l2;
    label586:
    for (int i = 3;; i = 4)
    {
      this.a.a(i, false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, locallid.jdField_d_of_type_JavaLangString, 1, false, false, false);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.a.a("onChangeUI_DobuleAudio2MultiAudio", false);
      this.a.jdField_b_of_type_Int = locallid.jdField_d_of_type_Int;
      if (this.a.jdField_a_of_type_Men != null) {
        this.a.jdField_a_of_type_Men.f();
      }
      if (!lnz.f())
      {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong, true);
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
        }
        locallid.a(paramLong, false);
      }
      loc.a().a();
      this.a.a(paramLong, true);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong);
        if (this.a.jdField_a_of_type_Int != 4) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong);
        }
      }
      l2 = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      if (locallid.jdField_d_of_type_JavaLangString != null) {
        break label591;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
      return;
    }
    label591:
    locallid.jdField_h_of_type_Long = Long.valueOf(locallid.jdField_d_of_type_JavaLangString).longValue();
    long l1 = locallid.jdField_g_of_type_Long;
    Object localObject2;
    Object localObject1;
    if (locallid.i == 1)
    {
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder().append("onChangeUI_DobuleAudio2MultiAudio uinList[");
        if (locallid.a != null) {
          break label772;
        }
        localObject1 = "null";
        label657:
        QLog.i("double_2_multi", 4, localObject1 + "]");
      }
      localObject1 = locallid.a;
      localObject2 = new ArrayList();
      i = 0;
      label696:
      if ((localObject1 == null) || (i >= localObject1.length)) {
        break label805;
      }
      if ((localObject1[i] != l2) && (localObject1[i] != locallid.jdField_h_of_type_Long)) {
        break label786;
      }
    }
    for (;;)
    {
      i += 1;
      break label696;
      if (locallid.i != 3000) {
        break;
      }
      locallid.a = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l1));
      break;
      label772:
      localObject1 = Integer.valueOf(locallid.a.length);
      break label657;
      label786:
      ((ArrayList)localObject2).add(Long.valueOf(locallid.a[i]));
    }
    label805:
    if (((ArrayList)localObject2).size() > 0)
    {
      i = ((ArrayList)localObject2).size();
      l2 = ((Long)((ArrayList)localObject2).get(0)).longValue();
      int m = mti.c(locallid.E);
      localObject2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(m, String.valueOf(l2), String.valueOf(locallid.jdField_g_of_type_Long));
      localObject1 = localObject2;
      if (((String)localObject2).length() > 7) {
        localObject1 = ((String)localObject2).substring(0, 6) + "...";
      }
      localObject2 = localObject1;
      if (i > 1) {
        localObject2 = (String)localObject1 + alpo.a(2131701232) + i + alpo.a(2131701231);
      }
      localObject1 = String.format(this.a.getString(2131696362), new Object[] { localObject2 });
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c((String)localObject1);
      }
    }
    for (;;)
    {
      if (bool) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.onChangeUI_DobuleAudio2MultiAudio", l1, false, false);
      }
      locallid.c("onChangeUI_DobuleAudio2MultiAudio", 0);
      this.a.jdField_a_of_type_ComTencentAvVideoController.m(false);
      this.a.jdField_a_of_type_ComTencentAvVideoController.n(false);
      this.a.jdField_d_of_type_Int = locallid.i;
      if (this.a.jdField_b_of_type_Int == 4) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.a.jdField_b_of_type_Int, false, false);
      }
      this.a.jdField_d_of_type_JavaLangString = String.valueOf(locallid.jdField_g_of_type_Long);
      if (this.a.jdField_a_of_type_Mpe != null) {
        this.a.jdField_a_of_type_Mpe.a();
      }
      QLog.w("double_2_multi", 1, "onChangeUI_DobuleAudio2MultiAudio end, oldSessionType[" + j + "], oldUinType[" + k + "], oldRelationId[" + str + "], mRelationId[" + this.a.jdField_d_of_type_JavaLangString + "], sessionInfo[" + locallid + "]");
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
  
  protected void a(long paramLong, ArrayList<lqq> paramArrayList)
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
    lqq locallqq;
    String str2;
    int m;
    boolean bool2;
    boolean bool3;
    int i;
    String str1;
    boolean bool1;
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
    {
      k = this.a.jdField_a_of_type_ComTencentAvVideoController.g();
      Collections.sort(paramArrayList, new mdx(this));
      if (QLog.isColorLevel()) {
        QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onRequest_ShowVideo, after sort infoLogs[" + (String)localObject + "], seq[" + paramLong + "]");
      }
      j = 0;
      if (j < paramArrayList.size())
      {
        locallqq = (lqq)paramArrayList.get(j);
        str2 = mto.a(locallqq.jdField_a_of_type_Long);
        m = locallqq.jdField_a_of_type_Int;
        bool2 = locallqq.jdField_a_of_type_Boolean;
        bool3 = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m);
        i = mti.b(this.a.jdField_d_of_type_Int);
        str1 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str2, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long));
        if (!locallqq.jdField_b_of_type_Boolean) {
          break label1312;
        }
        if (!str2.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          localObject = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (locallqq.jdField_b_of_type_Long == 5L)
          {
            bool1 = true;
            label373:
            ((VideoLayerUI)localObject).a(paramLong, str2, m, true, bool2, bool1);
            if ((!bool2) || (locallqq.d)) {
              break label1312;
            }
            if (mto.a(str1) <= 20) {
              break label1305;
            }
            localObject = mto.a(str1, 0, 20) + "...";
            label440:
            if (m != 2) {
              break label796;
            }
            localObject = String.format(this.a.getString(2131695992), new Object[] { localObject });
            if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
              break label777;
            }
            this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(1036, (String)localObject);
            label508:
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      label511:
      if (i == 0)
      {
        AVActivity.a(this.a);
        if ((locallqq.jdField_b_of_type_Boolean) || (locallqq.jdField_a_of_type_Boolean)) {
          break label1139;
        }
        if (k == 4) {
          break label1104;
        }
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().E != 2) {
          break label1014;
        }
        azmj.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
        if (this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.a.jdField_a_of_type_AndroidGraphicsBitmap = mww.a(this.a.getApplicationContext(), 2130841777);
        }
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str2, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, locallqq.jdField_b_of_type_Boolean, locallqq.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        label595:
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
          f1 = mww.a(this.a.getApplicationContext(), f1);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, str1, f1, -1);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m);
        }
        j += 1;
        break;
        bool1 = false;
        break label373;
        label777:
        mdd.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036, (String)localObject);
        break label508;
        label796:
        localObject = String.format(this.a.getString(2131695993), new Object[] { localObject });
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_b_of_type_JavaLangString, 1, "onRequest_ShowVideo, will loading name[" + str1 + "]");
        }
        if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof MultiVideoCtrlLayerUIBase)))
        {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(1037, (String)localObject);
          break label508;
        }
        mdd.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037, (String)localObject);
        break label508;
        if ((str2.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (m == 2)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label982;
          }
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, true, bool2);
          i = 0;
          break;
        }
        label982:
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, true, bool2);
        i = 1;
        break label511;
        label1014:
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_C_of_type_Int == 10)
        {
          azmj.b(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
          break label595;
        }
        azmj.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
        break label595;
        label1104:
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str2, m, this.a.jdField_b_of_type_AndroidGraphicsBitmap, locallqq.jdField_b_of_type_Boolean, locallqq.jdField_a_of_type_Boolean);
        continue;
        label1139:
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str2, m, this.a.jdField_b_of_type_AndroidGraphicsBitmap, locallqq.jdField_b_of_type_Boolean, locallqq.jdField_a_of_type_Boolean);
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.jdField_h_of_type_Int, false);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, this.a.jdField_h_of_type_Int);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_C_of_type_Int != 2)) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.a.jdField_h_of_type_Int);
      }
      if (this.a.jdField_a_of_type_Mof != null) {
        this.a.jdField_a_of_type_Mof.b();
      }
      if (this.a.jdField_a_of_type_Mpe == null) {
        break;
      }
      this.a.jdField_a_of_type_Mpe.a();
      return;
      label1305:
      localObject = str1;
      break label440;
      label1312:
      i = 0;
    }
  }
  
  protected void a(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    boolean bool = true;
    if (this.a.isDestroyed()) {}
    while ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g())) {
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
    llm.a(paramBoolean2);
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
      if ((paramObject instanceof lnw))
      {
        paramObject = (lnw)paramObject;
        if (paramObject.jdField_a_of_type_Int != 6) {
          break label334;
        }
        if ((paramObject.jdField_b_of_type_Int & 0x1) != 1) {
          break label278;
        }
        if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.o = true;
          ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(2131372573, true, 2130841657);
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
                    this.a.jdField_a_of_type_ComTencentAvVideoController.p = true;
                    ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).H();
                  }
                  if (((paramObject.jdField_b_of_type_Int & 0x8) == 8) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    this.a.jdField_a_of_type_ComTencentAvVideoController.q = false;
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
                    this.a.jdField_a_of_type_ComTencentAvVideoController.o = false;
                    ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(2131372573, false, 2130841657);
                  }
                }
              } while (paramObject.jdField_a_of_type_Int != 5);
              if (paramObject.jdField_b_of_type_Int != 2) {
                break;
              }
            } while (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI));
            paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
            paramObject.a(2131696366, 2, 0, paramObject.a.getDimensionPixelSize(2131298914));
            return;
          } while ((paramObject.jdField_b_of_type_Int != 3) || (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)));
          paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
          paramObject.a(2131696365, 1, 0, paramObject.a.getDimensionPixelSize(2131298914));
          return;
        } while (!(paramObject instanceof lnw));
        paramObject = (lnw)paramObject;
      } while ((paramObject.jdField_a_of_type_Int != 11) || (paramObject.jdField_b_of_type_Int != 1) || (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)));
      this.a.jdField_a_of_type_ComTencentAvVideoController.r = true;
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
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().T)
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
      boolean bool = lro.b();
      if ((l2 == 14L) && (bool))
      {
        if (i != 1) {
          break label337;
        }
        if (!"SUPPORT_CREATIVECOP_TRUE".equals(str)) {
          break label213;
        }
        ((llc)this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(3, 14, "SUPPORT_CREATIVECOP_TRUE");
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
          new mez(l1, str, false, 4).a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          break;
          label311:
          localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          if (localObject != null) {
            ((lid)localObject).X = 2;
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
    if (this.a.jdField_a_of_type_Mlf != null) {
      this.a.jdField_a_of_type_Mlf.a(paramString1, paramString2);
    }
  }
  
  protected void a(ArrayList<lqq> paramArrayList)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
    {
      long l = AudioHelper.b();
      Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onChangeUI_CloseVideo, seq[" + l + "], infoLogs[" + (String)localObject + "]");
      }
      Collections.sort(paramArrayList, new mdy(this));
      int i = 0;
      if (i < paramArrayList.size())
      {
        localObject = (lqq)paramArrayList.get(i);
        String str = mto.a(((lqq)localObject).jdField_a_of_type_Long);
        boolean bool2 = ((lqq)localObject).jdField_a_of_type_Boolean;
        int j = ((lqq)localObject).jdField_a_of_type_Int;
        boolean bool1;
        if (!str.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str, j))
          {
            if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
              this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(1037);
            }
            mdd.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
          }
          VideoLayerUI localVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (((lqq)localObject).jdField_b_of_type_Long == 5L)
          {
            bool1 = true;
            label248:
            localVideoLayerUI.a(l, str, j, false, bool2, bool1);
          }
        }
        label312:
        for (;;)
        {
          i += 1;
          break;
          bool1 = false;
          break label248;
          if (((lqq)localObject).jdField_a_of_type_Int == 2) {}
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label312;
            }
            this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l, false, false);
            break;
          }
        }
      }
      this.a.h();
    }
    if (this.a.jdField_a_of_type_Mof != null) {
      this.a.jdField_a_of_type_Mof.b();
    }
    if (this.a.jdField_a_of_type_Mpe != null) {
      this.a.jdField_a_of_type_Mpe.a();
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
          bool = msp.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, "onRequest_OpenCamera");
        }
        AVActivity.a(this.a);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, true, bool);
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().J))
        {
          String str1 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
          int i = mti.b(this.a.jdField_d_of_type_Int);
          String str2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str1, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long));
          float f = 12.0F;
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str1, 1)) {
            f = 18.0F;
          }
          f = mww.a(this.a.getApplicationContext(), f);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, 1, str2, f, -1);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str1, 1, this.a.jdField_b_of_type_AndroidGraphicsBitmap, true, true);
        }
      }
    } while (this.a.jdField_a_of_type_Mpe == null);
    this.a.jdField_a_of_type_Mpe.a();
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.n)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.n = false;
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
    lid locallid = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting, cur[" + locallid + "]");
    }
    int i = this.a.jdField_b_of_type_Int;
    String str = this.a.jdField_d_of_type_JavaLangString;
    int j = this.a.jdField_d_of_type_Int;
    if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0)) {
      this.a.a(paramLong, "onChangeUI_Normal2Meeting", false);
    }
    if ((locallid.B) && (this.a.jdField_a_of_type_Mlf != null)) {
      this.a.jdField_a_of_type_Mlf.c();
    }
    if ((locallid.jdField_C_of_type_Boolean) || ((this.a.jdField_a_of_type_Mlf != null) && (this.a.jdField_a_of_type_Mlf.d() != 1)))
    {
      locallid.jdField_C_of_type_Boolean = false;
      this.a.jdField_a_of_type_Mlf.m();
    }
    boolean bool = locallid.jdField_g_of_type_Boolean;
    if (locallid.jdField_h_of_type_Int == 16) {
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
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, locallid.jdField_d_of_type_JavaLangString, 1, false, false, false);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.a.a("onChangeUI_Normal2Meeting", true);
      if (locallid.jdField_d_of_type_Int == 2)
      {
        locallid.jdField_d_of_type_Int = 1;
        if (QLog.isColorLevel()) {
          QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting video to audio .");
        }
      }
      this.a.jdField_b_of_type_Int = locallid.jdField_d_of_type_Int;
      if (this.a.jdField_b_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting illegal session type.");
        }
        this.a.jdField_b_of_type_Int = 1;
      }
      if (this.a.jdField_a_of_type_Men != null) {
        this.a.jdField_a_of_type_Men.f();
      }
      if (!lnz.f())
      {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong, true);
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
        }
        locallid.a(paramLong, false);
      }
      loc.a().a();
      this.a.a(paramLong, true);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong);
        if (this.a.jdField_a_of_type_Int != 4) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong);
        }
      }
      if (locallid.jdField_d_of_type_JavaLangString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("double_2_multi", 2, "onChangeUI_Normal2Meeting-->Peer uin is null!!!!!!!!!");
    return;
    long l = locallid.jdField_g_of_type_Long;
    locallid.jdField_h_of_type_Long = Long.valueOf(locallid.jdField_d_of_type_JavaLangString).longValue();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(null);
    }
    if (bool) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.onChangeUI_Normal2Meeting", l, false, false);
    }
    locallid.e("AVActivity.onChangeUI_Normal2Meeting", false);
    this.a.jdField_d_of_type_Int = locallid.i;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, locallid.jdField_d_of_type_Int, false, true);
    if ((locallid.j) || (locallid.aF)) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, locallid.jdField_d_of_type_Int, false, false);
    }
    this.a.jdField_d_of_type_JavaLangString = String.valueOf(locallid.jdField_g_of_type_Long);
    if (this.a.jdField_a_of_type_Mpe != null) {
      this.a.jdField_a_of_type_Mpe.a();
    }
    QLog.w("normal_2_meeting", 1, "onChangeUI_Normal2Meeting end, oldSessionType[" + i + "], oldUinType[" + j + "], oldRelationId[" + str + "], mRelationId[" + this.a.jdField_d_of_type_JavaLangString + "], sessionInfo[" + locallid + "]");
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
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(l, 2048);
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) && (this.a.jdField_a_of_type_Mlf != null)) {
      this.a.jdField_a_of_type_Mlf.n();
    }
  }
  
  protected void c()
  {
    ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(2131362964);
    if (localViewGroup != null) {
      log.a(localViewGroup);
    }
  }
  
  protected void c(int paramInt)
  {
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    if ((i == 1) || (i == 3)) {}
    while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().g()) || ((this.a.jdField_a_of_type_Men != null) && (this.a.jdField_a_of_type_Men.a())) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)) {
      return;
    }
    if ((this.a.jdField_a_of_type_Men == null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))) {
      this.a.jdField_a_of_type_Men = new men(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.a, this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI, (RelativeLayout)AVActivity.a(this.a, 2131372584));
    }
    if ((this.a.jdField_a_of_type_Men != null) && (this.a.jdField_a_of_type_Men.c()))
    {
      this.a.jdField_a_of_type_Men.e();
      azmj.b(null, "CliOper", "", "", "0X80061F6", "0X80061F6", 0, 0, "", "", "", "");
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
    if (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {}
    for (boolean bool = true;; bool = false)
    {
      localAVActivity.b(-1048L, "onChangeUI_RecordStateChange", bool);
      return;
    }
  }
  
  public void d(int paramInt)
  {
    if (this.a.jdField_a_of_type_Mlf != null) {
      this.a.jdField_a_of_type_Mlf.g(paramInt);
    }
  }
  
  protected void d(long paramLong)
  {
    mth.a("switch_camera", "onRequest_SwitchCamera", 3, new Object[] { Long.valueOf(paramLong) });
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
      if (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h())
      {
        bool1 = true;
        localAVActivity.b(l, "onChangeUI_MagicFacePlayStateChange", bool1);
      }
    }
    else
    {
      if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) && (this.a.jdField_a_of_type_Mlf != null)) {
        this.a.jdField_a_of_type_Mlf.n();
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
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {
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
    mdd.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1008, 2131695956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mdw
 * JD-Core Version:    0.7.0.1
 */