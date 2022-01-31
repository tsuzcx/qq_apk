import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.filter.EffectFilterTools.DataReport;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.zimu.ARZimuTask;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcControllerImpl.DeviceCMDTLV;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ChildGuideUi;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VoiceChangeChooseDialog;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.ResidentTip;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import mqq.os.MqqHandler;

public class jsc
  extends ControlUIObserver
{
  private int jdField_a_of_type_Int;
  
  public jsc(AVActivity paramAVActivity) {}
  
  protected void a() {}
  
  protected void a(int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 1)) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().d;
    }
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a(true, paramInt);
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI);
    }
  }
  
  protected void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, " onChangeUI_receiveTransferMsg ");
    }
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.d == 9500) {
      if ((paramObject instanceof VcControllerImpl.DeviceCMDTLV))
      {
        paramObject = (VcControllerImpl.DeviceCMDTLV)paramObject;
        if (paramObject.jdField_a_of_type_Int != 6) {
          break label354;
        }
        if ((paramObject.jdField_b_of_type_Int & 0x1) != 1) {
          break label300;
        }
        if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))
        {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.r = true;
          ((DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(2131365398, true, 2130840158);
        }
      }
    }
    label299:
    label300:
    label354:
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
                break label299;
                break label299;
                break label299;
                break label299;
                for (;;)
                {
                  if (((paramObject.jdField_b_of_type_Int & 0x4) == 4) && ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.s = true;
                    ((DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI).ae();
                  }
                  if (((paramObject.jdField_b_of_type_Int & 0x8) == 8) && ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.t = false;
                    DoubleVideoCtrlUI localDoubleVideoCtrlUI = (DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI;
                    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jsf(this, localDoubleVideoCtrlUI), 500L);
                  }
                  if (((paramObject.jdField_b_of_type_Int & 0x2) == 2) && ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    paramObject = (DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI;
                    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean = false;
                    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jsg(this, paramObject), 500L);
                  }
                  return;
                  if (((paramObject.jdField_b_of_type_Int & 0x1) == 0) && ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.r = false;
                    ((DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(2131365398, false, 2130840158);
                  }
                }
              } while (paramObject.jdField_a_of_type_Int != 5);
              if (paramObject.jdField_b_of_type_Int != 2) {
                break;
              }
            } while (!(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI));
            paramObject = (DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI;
            paramObject.a(2131429242, 2, 0, paramObject.a.getDimensionPixelSize(2131558448));
            return;
          } while ((paramObject.jdField_b_of_type_Int != 3) || (!(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)));
          paramObject = (DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI;
          paramObject.a(2131429243, 1, 0, paramObject.a.getDimensionPixelSize(2131558448));
          return;
        } while (!(paramObject instanceof VcControllerImpl.DeviceCMDTLV));
        paramObject = (VcControllerImpl.DeviceCMDTLV)paramObject;
      } while ((paramObject.jdField_a_of_type_Int != 11) || (paramObject.jdField_b_of_type_Int != 1) || (!(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)));
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.u = true;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, "receiveTransferMsg xiaowei Device");
  }
  
  protected void a(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (ResidentTip)paramObject1;
    paramObject2 = (Drawable)paramObject2;
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.a.setRotation(0.0F);
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(paramObject1.jdField_a_of_type_Int, paramObject2, paramObject1.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void a(String paramString)
  {
    if (paramString != null)
    {
      if (!paramString.equals("1")) {
        break label62;
      }
      if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().S)
      {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.a(null);
        if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.isResume()) {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().S = false;
        }
      }
    }
    label62:
    while (!paramString.startsWith("START")) {
      return;
    }
    paramString = paramString.substring("START_".length());
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a(paramString);
  }
  
  protected void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString1, paramInt1, paramString2, paramInt2);
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(paramString1, paramString2);
    }
  }
  
  protected void a(ArrayList paramArrayList)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_Int == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, "onChangeUI_ShowVideo ignore ");
      }
      return;
    }
    Object localObject;
    int k;
    int j;
    VideoViewInfo localVideoViewInfo;
    String str2;
    int m;
    boolean bool2;
    boolean bool3;
    int i;
    label223:
    String str1;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      k = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.g();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, "onChangeUI_ShowVideo-->infos=" + (String)localObject);
      }
      Collections.sort(paramArrayList, new jsd(this));
      j = 0;
      if (j < paramArrayList.size())
      {
        localVideoViewInfo = (VideoViewInfo)paramArrayList.get(j);
        str2 = CharacterUtil.a(localVideoViewInfo.jdField_a_of_type_Long);
        m = localVideoViewInfo.jdField_a_of_type_Int;
        bool2 = localVideoViewInfo.jdField_a_of_type_Boolean;
        bool3 = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m);
        i = -1;
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.d == 3000)
        {
          i = 1004;
          str1 = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str2, String.valueOf(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long));
          if (!localVideoViewInfo.jdField_b_of_type_Boolean) {
            break label1054;
          }
          if (str2.equals(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            break label708;
          }
          localObject = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (localVideoViewInfo.jdField_b_of_type_Long != 5L) {
            break label652;
          }
          bool1 = true;
          label304:
          ((VideoLayerUI)localObject).a(str2, m, true, bool2, bool1);
          if ((!bool2) || (localVideoViewInfo.d)) {
            break label1054;
          }
          if (CharacterUtil.a(str1) <= 20) {
            break label1047;
          }
          localObject = CharacterUtil.a(str1, 0, 20) + "...";
          label370:
          if (m != 2) {
            break label658;
          }
          localObject = String.format(this.jdField_a_of_type_ComTencentAvUiAVActivity.getString(2131428976), new Object[] { localObject });
          TipsManager.a(106, (String)localObject);
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106, (String)localObject, true);
          label423:
          i = 0;
        }
      }
    }
    for (;;)
    {
      label425:
      if (i == 0)
      {
        if ((localVideoViewInfo.jdField_b_of_type_Boolean) || (localVideoViewInfo.jdField_a_of_type_Boolean)) {
          break label861;
        }
        if (k == 4) {
          break label827;
        }
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) {
          break label737;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
        label501:
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        if ((!bool3) && (!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().G))
        {
          float f = 10.0F;
          if (bool2) {
            f = 14.0F;
          }
          f = UITools.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.getApplicationContext(), f);
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, str1, f, -1);
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str2, m);
        }
        j += 1;
        break;
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.d == 1)
        {
          i = 1000;
          break label223;
        }
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.d != 0) {
          break label223;
        }
        i = 0;
        break label223;
        label652:
        bool1 = false;
        break label304;
        label658:
        localObject = String.format(this.jdField_a_of_type_ComTencentAvUiAVActivity.getString(2131428975), new Object[] { localObject });
        TipsManager.a(103, (String)localObject);
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103, (String)localObject, true);
        break label423;
        label708:
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, bool2);
        i = 1;
        break label425;
        label737:
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)
        {
          ReportController.b(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
          break label501;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
        break label501;
        label827:
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, this.jdField_a_of_type_ComTencentAvUiAVActivity.c, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        continue;
        label861:
        if (!localVideoViewInfo.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, this.jdField_a_of_type_ComTencentAvUiAVActivity.c, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        } else {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        }
      }
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.h, false);
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(this.jdField_a_of_type_ComTencentAvUiAVActivity.h);
      }
      if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.h);
      }
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog.a();
      return;
      label1047:
      localObject = str1;
      break label370;
      label1054:
      i = 0;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_Int == 4) {}
    boolean bool;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
        }
      } while (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
      bool = paramBoolean;
      if (!paramBoolean) {
        bool = RedBagUtil.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, "onChangeUI_OpenCamera");
      }
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, bool);
    } while ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().d != 4) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().G));
    String str1 = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i;
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.d == 3000) {
      i = 1004;
    }
    for (;;)
    {
      String str2 = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str1, String.valueOf(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long));
      float f = 10.0F;
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str1, 1)) {
        f = 14.0F;
      }
      f = UITools.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.getApplicationContext(), f);
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, 1, str2, f, -1);
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, 1, this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_AndroidGraphicsBitmap, true, true);
      return;
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.d == 1) {
        i = 1000;
      } else {
        i = -1;
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    boolean bool = true;
    AVActivity localAVActivity;
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      if ((!paramBoolean1) && (!paramBoolean2)) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.p(true);
      }
      if ((paramBoolean1) && (paramBoolean2)) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.p(false);
      }
      ARZimuTask.a(paramBoolean2);
      this.jdField_a_of_type_ComTencentAvUiAVActivity.a(Integer.valueOf(6503), Boolean.valueOf(paramBoolean2), null);
      localAVActivity = this.jdField_a_of_type_ComTencentAvUiAVActivity;
      if ((paramBoolean1) || (paramBoolean2)) {
        break label97;
      }
    }
    label97:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      localAVActivity.i(paramBoolean1);
      return;
    }
  }
  
  protected void b()
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 1, "onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[" + this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop + "], ActivityState[" + this.jdField_a_of_type_ComTencentAvUiAVActivity.b() + "]");
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController == null) {}
    boolean bool;
    long l2;
    long l1;
    Object localObject1;
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0)) {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.h(false);
        }
        if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().y) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
        }
        if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().z) || ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a() != 1)))
        {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().z = false;
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.m();
        }
        bool = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean;
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().h == 11)
        {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(null);
          return;
        }
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          AVActivity.a(this.jdField_a_of_type_ComTencentAvUiAVActivity, 1, false);
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 1, false, false, false);
        }
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
        }
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_g_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().d;
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a(false);
        }
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiChildGuideUi.f();
        }
        if (!VcSystemInfo.f())
        {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(true);
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, false);
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = false;
        }
        DoodleLogic.a().a();
        this.jdField_a_of_type_ComTencentAvUiAVActivity.a(true);
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.f();
          if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_Int != 4) {
            this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.g();
          }
        }
        l2 = Long.valueOf(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
      return;
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString).longValue();
      l1 = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long;
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l1));
      localObject1 = new ArrayList();
      if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong != null) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong.length != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, "onChangeUI_DobuleAudio2MultiAudio-->uinList is null");
    return;
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong.length)
    {
      if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong[i] == l2) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong[i] == this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long)) {}
      for (;;)
      {
        i += 1;
        break;
        ((ArrayList)localObject1).add(Long.valueOf(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong[i]));
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      i = ((ArrayList)localObject1).size();
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.size() <= 0) {
        break label1323;
      }
      i += this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.size();
    }
    label1323:
    for (;;)
    {
      l2 = ((Long)((ArrayList)localObject1).get(0)).longValue();
      Object localObject2 = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1004, String.valueOf(l2), String.valueOf(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long));
      localObject1 = localObject2;
      if (((String)localObject2).length() > 7) {
        localObject1 = ((String)localObject2).substring(0, 6) + "...";
      }
      localObject2 = localObject1;
      if (i > 1) {
        localObject2 = (String)localObject1 + "等" + i + "人";
      }
      localObject1 = String.format(this.jdField_a_of_type_ComTencentAvUiAVActivity.getString(2131429133), new Object[] { localObject2 });
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.d((String)localObject1);
      }
      for (;;)
      {
        if (bool) {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.onChangeUI_DobuleAudio2MultiAudio", l1, false, false);
        }
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().a("onChangeUI_DobuleAudio2MultiAudio", false);
        this.jdField_a_of_type_ComTencentAvUiAVActivity.d = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().i;
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_Int != 4) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_Int, false, false);
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, "onChangeUI_DobuleAudio2MultiAudio-->inviteList is null");
        }
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.size() > 0)
        {
          String str = ((AVPhoneUserInfo)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.get(0)).telInfo.mobile;
          localObject2 = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a(str);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = PstnUtils.a(str, 4);
          }
          i = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_JavaUtilArrayList.size();
          localObject2 = localObject1;
          if (i > 1) {
            localObject2 = (String)localObject1 + "等" + i + "人";
          }
          localObject1 = String.format(this.jdField_a_of_type_ComTencentAvUiAVActivity.getString(2131429133), new Object[] { localObject2 });
          if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
            this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.d((String)localObject1);
          }
        }
      }
    }
  }
  
  protected void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a(paramInt);
    }
  }
  
  @TargetApi(11)
  protected void b(Object paramObject)
  {
    paramObject = (ResidentTip)paramObject;
    String str;
    boolean bool;
    if (QLog.isColorLevel())
    {
      str = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onChangeUI_ShowTips, ResidentTip[").append(paramObject).append("], order[").append(this.jdField_a_of_type_Int).append("], mTipsManager[");
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        bool = true;
        QLog.w(str, 1, bool + "]");
      }
    }
    else if ((paramObject != null) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null))
    {
      str = paramObject.jdField_a_of_type_JavaLangString;
      if (str == null) {
        break label167;
      }
      if (paramObject.jdField_a_of_type_Int >= this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Int = paramObject.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.a.setRotation(0.0F);
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(paramObject.jdField_a_of_type_Int, str, true);
      }
    }
    label167:
    while (paramObject.jdField_a_of_type_Int < this.jdField_a_of_type_Int)
    {
      return;
      bool = false;
      break;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(paramObject.jdField_a_of_type_Int);
  }
  
  protected void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (!this.jdField_a_of_type_ComTencentAvUiAVActivity.a())) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(paramString);
    }
  }
  
  protected void b(ArrayList paramArrayList)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, "onChangeUI_CloseVideo, " + (String)localObject);
      }
      Collections.sort(paramArrayList, new jse(this));
      int i = 0;
      if (i < paramArrayList.size())
      {
        localObject = (VideoViewInfo)paramArrayList.get(i);
        String str = CharacterUtil.a(((VideoViewInfo)localObject).jdField_a_of_type_Long);
        boolean bool2 = ((VideoViewInfo)localObject).jdField_a_of_type_Boolean;
        int j = ((VideoViewInfo)localObject).jdField_a_of_type_Int;
        VideoLayerUI localVideoLayerUI;
        if (!str.equals(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str, j)) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null))
          {
            TipsManager.c(103);
            this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103);
          }
          localVideoLayerUI = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (((VideoViewInfo)localObject).jdField_b_of_type_Long != 5L) {
            break label226;
          }
        }
        label226:
        for (boolean bool1 = true;; bool1 = false)
        {
          localVideoLayerUI.a(str, j, false, bool2, bool1);
          i += 1;
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setVisibility(8);
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog.a();
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {}
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity.m();
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((2 == this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().d) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_g_of_type_Boolean)) && (!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.n)) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.b("onChangeUI_ShowControlUI");
    }
  }
  
  protected void c(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().d;
    if ((i == 1) || (i == 3)) {}
    while ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().c()) || ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiChildGuideUi.a())) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiChildGuideUi == null) && ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiChildGuideUi = new ChildGuideUi(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvUiAVActivity, this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI, (RelativeLayout)AVActivity.a(this.jdField_a_of_type_ComTencentAvUiAVActivity, 2131365844));
    }
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiChildGuideUi.c()))
    {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiChildGuideUi.e();
      ReportController.b(null, "CliOper", "", "", "0X80061F6", "0X80061F6", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.h(paramInt);
  }
  
  protected void c(Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.f();
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, "onChangeUI_NotifyChangedZimuPeer id=" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("SUPPORT"))) {
      g(2);
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, "onChangeUI_ChildLockStateChange: " + paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.n();
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils == null) {
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils.c()) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().ak) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.g(true);
    }
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f()) {}
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, false);
      if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils.c()) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = false;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils != null)
    {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(true);
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a(false);
      }
    }
    AVActivity.a(this.jdField_a_of_type_ComTencentAvUiAVActivity, 1, false);
  }
  
  protected void d(int paramInt)
  {
    if (paramInt == 1) {
      AVActivity.a(this.jdField_a_of_type_ComTencentAvUiAVActivity, true);
    }
    while (paramInt != 2) {
      return;
    }
    AVActivity.a(this.jdField_a_of_type_ComTencentAvUiAVActivity, true, 0);
  }
  
  protected void e()
  {
    AVActivity.a(this.jdField_a_of_type_ComTencentAvUiAVActivity);
  }
  
  protected void e(int paramInt)
  {
    AVActivity.b(this.jdField_a_of_type_ComTencentAvUiAVActivity, true, paramInt);
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.H();
    }
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.q)
    {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.q = false;
      this.jdField_a_of_type_ComTencentAvUiAVActivity.e = true;
      this.jdField_a_of_type_ComTencentAvUiAVActivity.finish();
    }
  }
  
  protected void f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if (paramInt != 4) {
        break label115;
      }
      boolean bool = EffectFilterTools.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.getBaseContext());
      EffectFilterTools.DataReport.a(bool);
      if (bool)
      {
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel == null) {
          this.jdField_a_of_type_ComTencentAvUiAVActivity.j();
        }
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a("onChangeUI_EffectToolbarSelected");
        bool = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(), bool);
        ThreadManager.getUIHandler().post(new jsh(this));
      }
    }
    label115:
    do
    {
      return;
      if (paramInt == 2)
      {
        MagicDataReport.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString) + "");
        AVActivity.a(this.jdField_a_of_type_ComTencentAvUiAVActivity, "1");
        AVActivity.a(this.jdField_a_of_type_ComTencentAvUiAVActivity, 2, false);
      }
    } while (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel == null);
    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setVisibility(8);
  }
  
  protected void g()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131365830);
    if (localViewGroup != null) {
      DoodleUtils.a(localViewGroup);
    }
  }
  
  public void g(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.g(paramInt);
    }
  }
  
  public void h()
  {
    AVActivity localAVActivity = this.jdField_a_of_type_ComTencentAvUiAVActivity;
    if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()) {}
    for (boolean bool = true;; bool = false)
    {
      localAVActivity.i(bool);
      return;
    }
  }
  
  protected void h(int paramInt)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, "onChangeUI_MagicFacePlayStateChange: " + paramInt);
    }
    AVActivity localAVActivity;
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      localAVActivity = this.jdField_a_of_type_ComTencentAvUiAVActivity;
      if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.g())
      {
        bool1 = true;
        localAVActivity.i(bool1);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.n();
      }
      localAVActivity = this.jdField_a_of_type_ComTencentAvUiAVActivity;
      if (paramInt != 5) {
        break label144;
      }
    }
    label144:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localAVActivity.e(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void i() {}
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvCameraCameraUtils.d();
    }
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.n(false);
    }
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.n(true);
    }
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.ad();
    }
  }
  
  public void n()
  {
    AVActivity localAVActivity;
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      localAVActivity = this.jdField_a_of_type_ComTencentAvUiAVActivity;
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      localAVActivity.i(bool);
      return;
    }
  }
  
  protected void o()
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    com.tencent.mobileqq.utils.AudioHelper.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.c_(true);
    }
  }
  
  protected void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, "onChangeUI_SmallView_Position_change");
    }
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((2 == this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().d) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_g_of_type_Boolean))) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.b("onChangeUI_SmallView_Position_change");
    }
  }
  
  protected void q()
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, 2, "onChangeUI_quitDoubleScreenStatus");
    }
    AVActivity.a(this.jdField_a_of_type_ComTencentAvUiAVActivity, 1, false);
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.a()) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a("onChangeUI_quitDoubleScreenStatus");
    }
    b(2);
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3))
    {
      FaceItem localFaceItem = (FaceItem)((EffectFaceManager)this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a();
      if ((localFaceItem == null) || (!localFaceItem.isInteract()) || (!"face".equalsIgnoreCase(localFaceItem.getType()))) {
        break label171;
      }
    }
    label171:
    for (boolean bool = true;; bool = false)
    {
      AVLog.c(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_b_of_type_JavaLangString, "onChangeUI_quitDoubleScreenStatus isIntactiveFace:" + bool);
      if (bool) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity.a(Integer.valueOf(6101), null, Boolean.valueOf(false));
      }
      return;
    }
  }
  
  protected void r()
  {
    CharSequence localCharSequence = this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getText(2131429591);
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a(localCharSequence, 3000, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jsc
 * JD-Core Version:    0.7.0.1
 */