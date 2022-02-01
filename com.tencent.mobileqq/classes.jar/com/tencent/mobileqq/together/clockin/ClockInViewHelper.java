package com.tencent.mobileqq.together.clockin;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.clockin.api.ITroopClockInHandler;
import com.tencent.mobileqq.troop.clockin.api.TroopClockInObserver;
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
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ClockAnimController jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController;
  private ClockInCallback jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInCallback = new ClockInViewHelper.1(this);
  private ClockInData jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
  private HasClockView jdField_a_of_type_ComTencentMobileqqTogetherClockinHasClockView;
  private IntegralClockView jdField_a_of_type_ComTencentMobileqqTogetherClockinIntegralClockView;
  private NoClockInView jdField_a_of_type_ComTencentMobileqqTogetherClockinNoClockInView;
  private TroopClockInObserver jdField_a_of_type_ComTencentMobileqqTroopClockinApiTroopClockInObserver = new ClockInViewHelper.2(this);
  
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
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopClockinApiTroopClockInObserver);
      paramQQAppInterface = (ITroopClockInHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_CLOCKIN_HANDLER);
      if (paramQQAppInterface != null)
      {
        paramContext = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
        if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString))) {
          paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 2);
        }
      }
    }
  }
  
  private void a(oidb_0xeb7.StSignInStatusRsp paramStSignInStatusRsp)
  {
    Object localObject = (oidb_0xeb7.SignInStatusBase)paramStSignInStatusRsp.base.get();
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.e = paramStSignInStatusRsp.mantleUrl.get();
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.n = paramStSignInStatusRsp.backgroundUrl.get();
    if (localObject != null)
    {
      ClockInData localClockInData = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
      boolean bool;
      if (((oidb_0xeb7.SignInStatusBase)localObject).status.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localClockInData.jdField_a_of_type_Boolean = bool;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("op_via", "2");
        ((HashMap)localObject).put("A8", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((HashMap)localObject).put("qq_group_num", this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString);
        ClockReportUtil.a("click#aio_icon", (HashMap)localObject);
      }
      if (paramStSignInStatusRsp.doneInfo.has())
      {
        paramStSignInStatusRsp = (oidb_0xeb7.SignInStatusDoneInfo)paramStSignInStatusRsp.doneInfo.get();
        if (paramStSignInStatusRsp != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.i = paramStSignInStatusRsp.leftTitleWrod.get();
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.k = paramStSignInStatusRsp.rightDescWord.get();
          localObject = paramStSignInStatusRsp.belowPortraitWords.get();
          if (((List)localObject).size() > 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.j = ((String)((List)localObject).get(0));
            this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Long = Long.valueOf((String)((List)localObject).get(1)).longValue();
          }
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.l = paramStSignInStatusRsp.recordUrl.get();
        }
      }
    }
    else
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("op_via", "1");
        ((HashMap)localObject).put("A8", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((HashMap)localObject).put("qq_group_num", this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString);
        ClockReportUtil.a("click#aio_icon", (HashMap)localObject);
      }
      if (paramStSignInStatusRsp.notInfo.has())
      {
        localObject = (oidb_0xeb7.SignInStatusNotInfo)paramStSignInStatusRsp.notInfo.get();
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.h = ((oidb_0xeb7.SignInStatusNotInfo)localObject).buttonWord.get();
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.f = ((oidb_0xeb7.SignInStatusNotInfo)localObject).signDescWordLeft.get();
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.g = ((oidb_0xeb7.SignInStatusNotInfo)localObject).signDescWordRight.get();
        }
      }
      if (paramStSignInStatusRsp.yesterday.has())
      {
        paramStSignInStatusRsp = (oidb_0xeb7.SignInStatusYesterdayFirst)paramStSignInStatusRsp.yesterday.get();
        if (paramStSignInStatusRsp != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_b_of_type_JavaLangString = paramStSignInStatusRsp.yesterdayFirstUid.get();
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.d = paramStSignInStatusRsp.yesterdayNick.get();
          this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.c = paramStSignInStatusRsp.yesterdayWord.get();
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if ((paramObject != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString)) && (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        if (!paramBoolean)
        {
          paramString1 = this.jdField_a_of_type_AndroidContentContext;
          if (paramString1 != null)
          {
            QQToast.a(paramString1, 1, HardCodeUtil.a(2131699466), 0).a();
            return;
          }
        }
        if ((paramObject instanceof oidb_0xeb7.StSignInWriteRsp))
        {
          paramString1 = (oidb_0xeb7.StSignInWriteRsp)paramObject;
          paramString2 = (oidb_0xeb7.SignInStatusDoneInfo)paramString1.doneInfo.get();
          paramObject = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
          paramObject.jdField_a_of_type_Boolean = true;
          if (paramString2 != null)
          {
            paramObject.i = paramString2.leftTitleWrod.get();
            this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.k = paramString2.rightDescWord.get();
            this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.l = paramString2.recordUrl.get();
            paramString2 = paramString2.belowPortraitWords.get();
            if ((paramString2 != null) && (paramString2.size() > 1))
            {
              this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.j = ((String)paramString2.get(0));
              if (!TextUtils.isEmpty((CharSequence)paramString2.get(1))) {
                this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Long = Long.valueOf((String)paramString2.get(1)).longValue();
              }
            }
          }
          if (paramString1.groupScore.has())
          {
            paramString1 = (oidb_0xeb7.SignInStatusGroupScore)paramString1.groupScore.get();
            this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.m = paramString1.scoreUrl.get();
          }
          if (QLog.isColorLevel()) {
            QLog.d("ClockInViewHelper", 2, "handleClockResp play anim ANIM_NOCLOCKIN_ROTATE_START");
          }
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController;
          if (paramString1 != null) {
            paramString1.a(1);
          }
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ClockInViewHelper", 2, "handleClockResp data not match");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClockInViewHelper", 2, "handleClockResp data || app null");
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if ((paramObject != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString)) && (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (paramInt == 2))
      {
        if (!paramBoolean)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ClockInViewHelper", 2, "handleGetClockDataRsp data isSuccess false");
            paramString1 = this.jdField_a_of_type_AndroidWidgetFrameLayout;
            if (paramString1 != null) {
              paramString1.setVisibility(8);
            }
          }
        }
        else if ((paramObject instanceof oidb_0xeb7.StSignInStatusRsp))
        {
          a((oidb_0xeb7.StSignInStatusRsp)paramObject);
          a();
          paramString1 = this.jdField_a_of_type_AndroidWidgetFrameLayout;
          if (paramString1 != null) {
            paramString1.setVisibility(0);
          }
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ClockInViewHelper", 2, "handleGetClockDataRsp data not match");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClockInViewHelper", 2, "handleGetClockDataRsp data || app null");
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
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localObject1 != null)
    {
      localObject1 = ((FrameLayout)localObject1).findViewById(2131370370);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 != null)
    {
      localObject1 = (ITroopClockInHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.TROOP_CLOCKIN_HANDLER);
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
        if ((localObject2 != null) && (!TextUtils.isEmpty(((ClockInData)localObject2).jdField_a_of_type_JavaLangString))) {
          ((ITroopClockInHandler)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
      }
    }
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("op_via", "1");
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
    if ((localObject2 != null) && (!TextUtils.isEmpty(((ClockInData)localObject2).jdField_a_of_type_JavaLangString))) {
      ((HashMap)localObject1).put("qq_group_num", this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject2 != null) && (!TextUtils.isEmpty(((QQAppInterface)localObject2).getCurrentAccountUin()))) {
      ((HashMap)localObject1).put("A8", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject1);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mClockInData : isHasClock = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Boolean);
      QLog.d("ClockInViewHelper", 2, localStringBuilder.toString());
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
    ClockAnimController localClockAnimController = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController;
    if (localClockAnimController != null) {
      return localClockAnimController.a();
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinNoClockInView;
    if (localObject != null)
    {
      ((NoClockInView)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinNoClockInView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinHasClockView;
    if (localObject != null)
    {
      ((HasClockView)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinHasClockView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinIntegralClockView;
    if (localObject != null) {
      ((IntegralClockView)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInCallback = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockAnimController;
    if (localObject != null) {
      ((ClockAnimController)localObject).deleteObservers();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopClockinApiTroopClockInObserver;
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)localObject);
    }
  }
  
  public boolean b()
  {
    ClockInData localClockInData = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
    return (localClockInData != null) && (localClockInData.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.ClockInViewHelper
 * JD-Core Version:    0.7.0.1
 */