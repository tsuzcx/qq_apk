package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import anlb;
import arvg;
import arxd;
import arxk;
import arxl;
import arxm;
import arxn;
import asag;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class EmoticonMainPanel
  extends RelativeLayout
  implements asag
{
  public static long a;
  public int a;
  public View a;
  private arxm jdField_a_of_type_Arxm;
  private EmoticonPanelController jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController = new EmoticonPanelController(paramContext, this);
  public HorizontalListViewEx a;
  @Deprecated
  public boolean a;
  public int b;
  @Deprecated
  public boolean b;
  @Deprecated
  public boolean c;
  @Deprecated
  public boolean d;
  @Deprecated
  public boolean e;
  @Deprecated
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  
  public EmoticonMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    SharedPreferences localSharedPreferences;
    long l;
    do
    {
      return;
      if (paramInt == 1)
      {
        ThreadManagerV2.excute(new EmoticonMainPanel.1(paramQQAppInterface), 128, null, true);
        return;
      }
      localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
      l = localSharedPreferences.getLong("last_get_recommendemotion_time_" + paramQQAppInterface.c(), 0L);
      paramInt = localSharedPreferences.getInt("recommendSeqinterval", 7200);
    } while (System.currentTimeMillis() - l < paramInt * 1000);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "sendRecommendSSORequest send req to recommend");
    }
    ((anlb)paramQQAppInterface.a(12)).a();
    localSharedPreferences.edit().putLong("last_get_recommendemotion_time_" + paramQQAppInterface.c(), System.currentTimeMillis()).apply();
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(paramString);
  }
  
  public EmoticonPanelController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.q();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.d(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(paramInt1, paramInt2);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, paramInt3, paramBaseChatPie, false, new arxl(this, null));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3, BaseChatPie paramBaseChatPie, boolean paramBoolean, arxk paramarxk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "init");
    }
    new arxn(this, paramQQAppInterface, paramBaseChatPie, paramInt1).a(paramarxk).b(paramBoolean).a(paramString).b(paramInt3).a(paramInt2).a(this.f).c(this.jdField_a_of_type_Boolean).d(this.jdField_b_of_type_Boolean).e(this.c).f(this.d).g(this.e).h(a()).a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramBaseChatPie, false, new arxl(this, null));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramBaseChatPie, paramBoolean, new arxl(this, null));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie, boolean paramBoolean, arxk paramarxk)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramBaseChatPie, paramBoolean, paramarxk);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(paramString);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.l();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.c(paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.o();
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload begins.");
    }
    arvg.a().a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload ends.");
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.c();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(paramCanvas);
      return;
    }
    catch (StackOverflowError paramCanvas)
    {
      QLog.e("EmoticonMainPanel", 1, "dispatchDraw, StackOverflowError, stack:" + MsfSdkUtils.getStackTraceString(paramCanvas));
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_Arxm != null) && (this.jdField_a_of_type_Arxm.a(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.e();
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.f();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.b();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.h();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g();
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.r();
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.i();
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.m();
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.n();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.j();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.k();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewParent localViewParent = getParent();
    int j;
    if (localViewParent != null)
    {
      j = paramMotionEvent.getAction() & 0xFF;
      if (j != 0) {
        break label35;
      }
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label35:
      if ((j == 1) || (j == 3)) {
        localViewParent.requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.p();
  }
  
  public void setCallBack(arxd paramarxd)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(paramarxd);
  }
  
  public void setDispatchKeyEventListener(arxm paramarxm)
  {
    this.jdField_a_of_type_Arxm = paramarxm;
  }
  
  @Deprecated
  public void setEmoSettingVisibility(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.b(paramInt);
  }
  
  public void setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(paramBoolean);
  }
  
  public void setHideAllSettingTabs(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.e(paramBoolean);
  }
  
  public void setOnlySysEmotionEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.b(paramBoolean);
  }
  
  public void setSysEmotionOrder(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(paramArrayOfInt);
  }
  
  public void setVisibility(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.c(paramInt);
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel
 * JD-Core Version:    0.7.0.1
 */