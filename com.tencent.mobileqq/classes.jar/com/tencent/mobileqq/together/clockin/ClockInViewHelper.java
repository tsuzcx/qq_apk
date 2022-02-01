package com.tencent.mobileqq.together.clockin;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusBase;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusDoneInfo;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusGroupScore;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusNotInfo;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusYesterdayFirst;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInStatusRsp;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInWriteRsp;

public class ClockInViewHelper
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new ClockInViewHelper.2(this);
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ClockAnimController jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController;
  private ClockInCallback jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInCallback = new ClockInViewHelper.1(this);
  private ClockInData jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
  private HasClockView jdField_a_of_type_ComTencentMobileqqTogetherClockinHasClockView;
  private IntegralClockView jdField_a_of_type_ComTencentMobileqqTogetherClockinIntegralClockView;
  private NoClockInView jdField_a_of_type_ComTencentMobileqqTogetherClockinNoClockInView;
  
  public ClockInViewHelper(QQAppInterface paramQQAppInterface, Context paramContext, ClockInData paramClockInData, FrameLayout paramFrameLayout, RelativeLayout paramRelativeLayout, DiniFlyAnimationView paramDiniFlyAnimationView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData = paramClockInData;
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController = new ClockAnimController();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = paramDiniFlyAnimationView;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      paramQQAppInterface = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if ((paramQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString))) {
        paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 2);
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInViewHelper", 2, "handleClockResp data || app null");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((paramObject != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString)) && (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ClockInViewHelper", 2, "handleClockResp data not match");
        return;
        if ((!paramBoolean) && (this.jdField_a_of_type_AndroidContentContext != null))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131699361), 0).a();
          return;
        }
      } while (!(paramObject instanceof oidb_0xeb7.StSignInWriteRsp));
      paramString1 = (oidb_0xeb7.SignInStatusDoneInfo)((oidb_0xeb7.StSignInWriteRsp)paramObject).doneInfo.get();
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Boolean = true;
      if (paramString1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.i = paramString1.leftTitleWrod.get();
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.k = paramString1.rightDescWord.get();
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.l = paramString1.recordUrl.get();
        paramString1 = paramString1.belowPortraitWords.get();
        if ((paramString1 != null) && (paramString1.size() > 1))
        {
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.j = ((String)paramString1.get(0));
          if (!TextUtils.isEmpty((CharSequence)paramString1.get(1))) {
            this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Long = Long.valueOf((String)paramString1.get(1)).longValue();
          }
        }
      }
      if (((oidb_0xeb7.StSignInWriteRsp)paramObject).groupScore.has())
      {
        paramString1 = (oidb_0xeb7.SignInStatusGroupScore)((oidb_0xeb7.StSignInWriteRsp)paramObject).groupScore.get();
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.m = paramString1.scoreUrl.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ClockInViewHelper", 2, "handleClockResp play anim ANIM_NOCLOCKIN_ROTATE_START");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController == null);
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController.a(1);
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInViewHelper", 2, "handleGetClockDataRsp data || app null");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramObject != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString)) && (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (paramInt == 2)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ClockInViewHelper", 2, "handleGetClockDataRsp data not match");
          return;
          if (paramBoolean) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ClockInViewHelper", 2, "handleGetClockDataRsp data isSuccess false");
      } while (this.jdField_a_of_type_AndroidWidgetFrameLayout == null);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      return;
    } while (!(paramObject instanceof oidb_0xeb7.StSignInStatusRsp));
    paramString1 = (oidb_0xeb7.StSignInStatusRsp)paramObject;
    paramString2 = (oidb_0xeb7.SignInStatusBase)paramString1.base.get();
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.e = paramString1.mantleUrl.get();
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.n = paramString1.backgroundUrl.get();
    if (paramString2 != null)
    {
      paramObject = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
      if (paramString2.status.get() == 1)
      {
        paramBoolean = true;
        label208:
        paramObject.jdField_a_of_type_Boolean = paramBoolean;
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Boolean) {
        break label446;
      }
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_Int == 1)
      {
        paramString2 = new HashMap();
        paramString2.put("op_via", "2");
        paramString2.put("A8", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramString2.put("qq_group_num", this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString);
        ClockReportUtil.a("click#aio_icon", paramString2);
      }
      if (paramString1.doneInfo.has())
      {
        paramString1 = (oidb_0xeb7.SignInStatusDoneInfo)paramString1.doneInfo.get();
        if (paramString1 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.i = paramString1.leftTitleWrod.get();
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.k = paramString1.rightDescWord.get();
          paramString2 = paramString1.belowPortraitWords.get();
          if (paramString2.size() > 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.j = ((String)paramString2.get(0));
            this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Long = Long.valueOf((String)paramString2.get(1)).longValue();
          }
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.l = paramString1.recordUrl.get();
        }
      }
    }
    for (;;)
    {
      a();
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      return;
      paramBoolean = false;
      break label208;
      label446:
      if (this.jdField_a_of_type_Int == 1)
      {
        paramString2 = new HashMap();
        paramString2.put("op_via", "1");
        paramString2.put("A8", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramString2.put("qq_group_num", this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString);
        ClockReportUtil.a("click#aio_icon", paramString2);
      }
      if (paramString1.notInfo.has())
      {
        paramString2 = (oidb_0xeb7.SignInStatusNotInfo)paramString1.notInfo.get();
        if (paramString2 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.h = paramString2.buttonWord.get();
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.f = paramString2.signDescWordLeft.get();
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.g = paramString2.signDescWordRight.get();
        }
      }
      if (paramString1.yesterday.has())
      {
        paramString1 = (oidb_0xeb7.SignInStatusYesterdayFirst)paramString1.yesterday.get();
        if (paramString1 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_b_of_type_JavaLangString = paramString1.yesterdayFirstUid.get();
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.d = paramString1.yesterdayNick.get();
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.c = paramString1.yesterdayWord.get();
        }
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinNoClockInView == null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinNoClockInView = new NoClockInView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData, this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInCallback, this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController);
    }
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) && (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController != null);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinHasClockView == null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinHasClockView = new HasClockView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData, this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInCallback, this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinIntegralClockView == null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinIntegralClockView = new IntegralClockView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController, this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData);
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInViewHelper", 2, "handleClockInBtnClick");
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370733);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString))) {
        ((TroopHandler)localObject).e(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("op_via", "1");
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString))) {
      ((HashMap)localObject).put("qq_group_num", this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      ((HashMap)localObject).put("A8", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject);
  }
  
  public void a()
  {
    if (!c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInViewHelper", 2, "checkData flase");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClockInViewHelper", 2, "mClockInData : isHasClock = " + this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinHasClockView.b(0);
      return;
    }
    c();
    d();
    e();
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinNoClockInView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinHasClockView.b(4);
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinIntegralClockView.b(8);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController.a();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinNoClockInView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinNoClockInView.b();
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinNoClockInView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinHasClockView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinHasClockView.b();
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinHasClockView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinIntegralClockView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinIntegralClockView.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInCallback = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController.deleteObservers();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.ClockInViewHelper
 * JD-Core Version:    0.7.0.1
 */