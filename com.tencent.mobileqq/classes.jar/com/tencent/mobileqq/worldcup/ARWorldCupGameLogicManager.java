package com.tencent.mobileqq.worldcup;

import akxo;
import akxp;
import akxq;
import akxs;
import akxt;
import akxu;
import akxw;
import akxx;
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
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = ARWorldCupGameLogicManager.class.getSimpleName();
  }
  
  private ARWorldCupGameLogicManager()
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BigScreenShowInfo = null;
  }
  
  public static ARWorldCupGameLogicManager a()
  {
    return akxx.a();
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
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager$RenderProxy.b() + "dialogImg.png";; localObject = null)
    {
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.a("退出活动", "继续游戏", "任意门已打开，穿越时空留下你的精彩瞬间，是否要放弃？", (String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.a(new akxt(this));
        ReportController.b(null, "dc00898", "", "", "0X8009320", "0X8009320", 1, 0, "1", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.a();
        this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.setOnDismissListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.show();
        localObject = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.getWindow().getAttributes();
        ((WindowManager.LayoutParams)localObject).width = -1;
        ((WindowManager.LayoutParams)localObject).height = -1;
        this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
        return;
      }
      if (paramInt != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.a("退出活动", "查看精彩轨迹", "这次穿越时空已留下精彩轨迹，去查看可以保留你的专属轨迹。", (String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog.a(new akxu(this));
      paramInt = 2;
      if (a() <= 9) {}
      for (localObject = "2";; localObject = "3")
      {
        ReportController.b(null, "dc00898", "", "", "0X8009320", "0X8009320", paramInt, 0, (String)localObject, "", "", "");
        break;
        paramInt = 3;
      }
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
    ThreadManager.getUIHandler().post(new akxs(this));
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
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)) {
      return;
    }
    ThreadManager.getUIHandler().post(new akxw(this, paramInt, paramString));
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
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new akxp(this));
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
      this.jdField_a_of_type_AndroidOsHandler = new akxo(this);
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
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 56	com/tencent/mobileqq/worldcup/ARWorldCupGameLogicManager:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   6: ifnull +14 -> 20
    //   9: aload_1
    //   10: ifnull +10 -> 20
    //   13: aload_0
    //   14: getfield 48	com/tencent/mobileqq/worldcup/ARWorldCupGameLogicManager:jdField_a_of_type_Boolean	Z
    //   17: ifeq +4 -> 21
    //   20: return
    //   21: new 105	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   28: aload_1
    //   29: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 388
    //   35: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 394	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   44: astore_2
    //   45: new 105	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   52: aload_1
    //   53: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 396
    //   59: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 394	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   68: astore_1
    //   69: aload_1
    //   70: astore_3
    //   71: aload_2
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull -54 -> 20
    //   77: aload_3
    //   78: ifnull -58 -> 20
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 48	com/tencent/mobileqq/worldcup/ARWorldCupGameLogicManager:jdField_a_of_type_Boolean	Z
    //   86: invokestatic 250	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   89: new 398	akxv
    //   92: dup
    //   93: aload_0
    //   94: aload_3
    //   95: aload_1
    //   96: invokespecial 401	akxv:<init>	(Lcom/tencent/mobileqq/worldcup/ARWorldCupGameLogicManager;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    //   99: invokevirtual 259	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   102: pop
    //   103: return
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_1
    //   107: goto -34 -> 73
    //   110: astore_1
    //   111: aload_2
    //   112: astore_1
    //   113: goto -40 -> 73
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_1
    //   119: goto -46 -> 73
    //   122: astore_1
    //   123: aload_2
    //   124: astore_1
    //   125: goto -52 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	ARWorldCupGameLogicManager
    //   0	128	1	paramString	String
    //   44	80	2	localBitmap	android.graphics.Bitmap
    //   1	94	3	str	String
    // Exception table:
    //   from	to	target	type
    //   21	45	104	java/lang/Exception
    //   45	69	110	java/lang/Exception
    //   21	45	116	java/lang/OutOfMemoryError
    //   45	69	122	java/lang/OutOfMemoryError
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
    ThreadManager.getUIHandler().post(new akxq(this, paramBoolean));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager
 * JD-Core Version:    0.7.0.1
 */