package com.tencent.mobileqq.worldcup;

import alff;
import alfg;
import alfh;
import alfj;
import alfk;
import alfl;
import alfm;
import alfo;
import alfp;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Paint;
import android.os.Handler;
import android.text.TextPaint;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable.IWorldCupGameEndCallBack;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ARWorldCupGameLogicManager
  implements DialogInterface.OnDismissListener
{
  public static final String a;
  public volatile float a;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public ARWorldCupGlobalSceneRenderable.IWorldCupGameEndCallBack a;
  private AREngine jdField_a_of_type_ComTencentMobileqqArArengineAREngine;
  private ScanTorchActivity jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity;
  private volatile ARWorldCupBackConfirmDialog jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog;
  private ARWorldCupGameLogicManager.RenderProxy jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy;
  private ARWorldCupGameTouchView jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView;
  public volatile ARWorldCupVideoInfo.BigScreenShowInfo a;
  volatile ARWorldCupVideoInfo.PlayGuideShowInfo jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$PlayGuideShowInfo = null;
  private ARWorldCupVideoInfo jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ARWorldCupGameLogicManager.class.getSimpleName();
  }
  
  private ARWorldCupGameLogicManager()
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static ARWorldCupGameLogicManager a()
  {
    return alfp.a();
  }
  
  private void a(float paramFloat)
  {
    int j = 0;
    if (paramFloat < 0.0F) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$PlayGuideShowInfo;
    int i;
    if (localObject != null)
    {
      i = j;
      if (((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject).b > 0.0F)
      {
        i = j;
        if (paramFloat >= ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject).b)
        {
          this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$PlayGuideShowInfo = null;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "OnLoopPlayTick GUIDE_360_HIDDEN.");
          a(0, null);
          i = 1;
        }
      }
      label66:
      if ((this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo != null) && (i != 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo.a(paramFloat);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$PlayGuideShowInfo = ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject);
          if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$PlayGuideShowInfo.c != ARWorldCupVideoInfo.a) {
            break label233;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 1, "OnLoopPlayTick GUIDE_360_LOOP_TEXT_SHOW." + ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject).jdField_a_of_type_JavaLangString + "|" + paramFloat + "|" + ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject).jdField_a_of_type_Float);
          a(1, ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject).jdField_a_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo;
      if ((localObject == null) || (((ARWorldCupVideoInfo.BigScreenShowInfo)localObject).jdField_a_of_type_Float <= 0.0F) || (paramFloat < ((ARWorldCupVideoInfo.BigScreenShowInfo)localObject).jdField_a_of_type_Float)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo = null;
      if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.j();
      return;
      i = 1;
      break label66;
      label233:
      if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$PlayGuideShowInfo.c == ARWorldCupVideoInfo.b)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "OnLoopPlayTick GUIDE_360_LOOP_BUTTON_SHOW." + ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject).jdField_a_of_type_JavaLangString + "|" + paramFloat + "|" + ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject).jdField_a_of_type_Float);
        a(2, ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject).jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog = new ARWorldCupBackConfirmDialog(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.b() + "dialogImg.png";
      localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.b());
      if (localObject2 != null) {
        localObject2 = ((ARWorldCupVideoInfo)localObject2).a(paramInt);
      }
    }
    for (;;)
    {
      String str1;
      String str2;
      if (paramInt == 0)
      {
        localARWorldCupBackConfirmDialog = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog;
        if (localObject2 == null)
        {
          str1 = "退出活动";
          if (localObject2 != null) {
            break label229;
          }
          str2 = "继续穿越";
          label108:
          if (localObject2 != null) {
            break label238;
          }
        }
        label229:
        label238:
        for (localObject2 = "任意门已打开，穿越时空留下你的精彩瞬间，是否要放弃？";; localObject2 = ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject2).jdField_a_of_type_JavaLangString)
        {
          localARWorldCupBackConfirmDialog.a(str1, str2, (String)localObject2, (String)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.a(new alfk(this));
          ReportController.b(null, "dc00898", "", "", "0X8009320", "0X8009320", 1, 0, "1", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.a();
          this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.setOnDismissListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.show();
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.getWindow().getAttributes();
          ((WindowManager.LayoutParams)localObject1).width = -1;
          ((WindowManager.LayoutParams)localObject1).height = -1;
          this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
          return;
          str1 = ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject2).b;
          break;
          str2 = ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject2).c;
          break label108;
        }
      }
      if (paramInt != 1) {
        break;
      }
      ARWorldCupBackConfirmDialog localARWorldCupBackConfirmDialog = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog;
      if (localObject2 == null)
      {
        str1 = "退出活动";
        label265:
        if (localObject2 != null) {
          break label355;
        }
        str2 = "查看精彩轨迹";
        label273:
        if (localObject2 != null) {
          break label364;
        }
        localObject2 = "这次穿越时空已留下精彩轨迹，去查看可以保留你的专属轨迹。";
        label280:
        localARWorldCupBackConfirmDialog.a(str1, str2, (String)localObject2, (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.a(new alfl(this));
        paramInt = 2;
        if (a() > 9) {
          break label372;
        }
      }
      for (localObject1 = "2";; localObject1 = "3")
      {
        ReportController.b(null, "dc00898", "", "", "0X8009320", "0X8009320", paramInt, 0, (String)localObject1, "", "", "");
        break;
        str1 = ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject2).b;
        break label265;
        label355:
        str2 = ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject2).c;
        break label273;
        label364:
        localObject2 = ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject2).jdField_a_of_type_JavaLangString;
        break label280;
        label372:
        paramInt = 3;
      }
      localObject2 = null;
      continue;
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.i();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.c();
    }
    return 0;
  }
  
  public ARWorldCupVideoInfo a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo = ARWorldCupGameUtil.a(paramString);
    }
    return this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo;
  }
  
  public void a()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "TryDismissDialog");
    ThreadManager.getUIHandler().post(new alfj(this));
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.a(paramInt);
      return;
    }
    String str = jdField_a_of_type_JavaLangString;
    if ("switchGameStatus " + paramInt + "|" + this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy != null) {}
    for (;;)
    {
      QLog.d(str, 2, new Object[] { Boolean.valueOf(bool) });
      return;
      bool = false;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    ThreadManager.getUIHandler().post(new alfo(this, paramInt, paramString));
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramLong < 0L) {}
    label67:
    label453:
    label460:
    label464:
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$PlayGuideShowInfo;
      int i;
      if (localObject1 != null)
      {
        if ((((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject1).b <= 0.0F) || ((float)paramLong < ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject1).b * 1000.0F)) {
          break label460;
        }
        this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$PlayGuideShowInfo = null;
        QLog.i(jdField_a_of_type_JavaLangString, 1, "OnVideoPlayTick GUIDE_360_HIDDEN.");
        a(0, null);
        i = 1;
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo == null) || (i == 0)) {
          break label464;
        }
        ARWorldCupVideoInfo.PlayGuideShowInfo localPlayGuideShowInfo = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo.a(paramLong, paramInt);
        if (localPlayGuideShowInfo == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$PlayGuideShowInfo = localPlayGuideShowInfo;
        String str;
        if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$PlayGuideShowInfo.c == ARWorldCupVideoInfo.a)
        {
          str = localPlayGuideShowInfo.jdField_a_of_type_JavaLangString;
          if ((paramInt != 6) || (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity == null)) {
            break label453;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.e();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
            break label453;
          }
          paramInt = ViewUtils.b(120.0F);
          TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetTextView.getPaint();
          Object localObject2 = localObject1;
          if (localTextPaint.measureText((String)localObject1) > paramInt)
          {
            do
            {
              localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
              localObject1 = localObject2;
            } while (localTextPaint.measureText((String)localObject2 + "...") >= paramInt);
            localObject2 = (String)localObject2 + "...";
          }
          localObject1 = (String)localObject2 + "\n";
        }
        for (localObject1 = (String)localObject1 + str;; localObject1 = str)
        {
          QLog.i(jdField_a_of_type_JavaLangString, 1, "OnVideoPlayTick GUIDE_360_LOOP_TEXT_SHOW." + (String)localObject1 + "|" + paramLong + "|" + localPlayGuideShowInfo.jdField_a_of_type_Float);
          a(1, (String)localObject1);
          return;
          i = 1;
          break label67;
          if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$PlayGuideShowInfo.c != ARWorldCupVideoInfo.b) {
            break;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 1, "OnVideoPlayTick GUIDE_360_LOOP_BUTTON_SHOW." + localPlayGuideShowInfo.jdField_a_of_type_JavaLangString + "|" + paramLong + "|" + localPlayGuideShowInfo.jdField_a_of_type_Float);
          a(2, localPlayGuideShowInfo.jdField_a_of_type_JavaLangString);
          return;
        }
        i = 0;
      }
    }
  }
  
  public void a(View paramView)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "setCameraTranvesalDoorTouchView " + paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(FrameLayout paramFrameLayout, TextView paramTextView, Button paramButton)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_AndroidWidgetButton = paramButton;
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new alfg(this));
  }
  
  public void a(AppInterface paramAppInterface, ScanTorchActivity paramScanTorchActivity, AREngine paramAREngine, ARWorldCupGameTouchView paramARWorldCupGameTouchView)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity = paramScanTorchActivity;
    this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine = paramAREngine;
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView = paramARWorldCupGameTouchView;
    if ((this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy != null) && (paramARWorldCupGameTouchView != null))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "init " + paramARWorldCupGameTouchView.getChildCount());
      paramARWorldCupGameTouchView.a();
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView);
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
      this.jdField_a_of_type_AndroidOsHandler = new alff(this);
      return;
    }
    paramAppInterface = jdField_a_of_type_JavaLangString;
    paramScanTorchActivity = new StringBuilder().append("init ");
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d(paramAppInterface, 2, bool);
      break;
    }
  }
  
  public void a(ARWorldCupGlobalSceneRenderable.IWorldCupGameEndCallBack paramIWorldCupGameEndCallBack)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "setGameEndCallBack");
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable$IWorldCupGameEndCallBack = paramIWorldCupGameEndCallBack;
  }
  
  public void a(ARWorldCupGameLogicManager.RenderProxy paramRenderProxy)
  {
    if (paramRenderProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy = paramRenderProxy;
      if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView);
      }
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
    }
  }
  
  public void a(ARWorldCupVideoInfo.BigScreenShowInfo paramBigScreenShowInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo = paramBigScreenShowInfo;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetButton == null) || (paramString == null) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new alfm(this, paramString));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "setRecogRes failed.");
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "showCameraTranvesalDoorTouchView " + paramBoolean);
    ThreadManager.getUIHandler().post(new alfh(this, paramBoolean));
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy != null) && (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramBoolean);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "insertWorldCupSpark failed.");
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ARWorldGC ARWorldCupGameLogicManager uninit");
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy = null;
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView.setOnTouchListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable$IWorldCupGameEndCallBack = null;
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine = null;
    this.jdField_a_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    h();
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.isShowing());
  }
  
  public void c()
  {
    a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView.b();
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView.c();
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView.setVisibility(4);
    }
    a(false);
    h();
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog != null) || (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy == null)) {
      return false;
    }
    if (a() == 3)
    {
      b(0);
      return true;
    }
    if ((a() > 3) && (a() < 13))
    {
      b(1);
      return true;
    }
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.f();
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "cleanWorldCupSparks failed.");
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy != null) && (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.c()) && (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.d());
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.g();
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "zoomOutWorldCupSparks failed.");
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Float < 0.0F) {
      this.jdField_a_of_type_Float = 0.0F;
    }
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1001)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 100L);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    }
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$PlayGuideShowInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo = null;
  }
  
  public void h()
  {
    g();
    a(0, null);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog) {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager
 * JD-Core Version:    0.7.0.1
 */