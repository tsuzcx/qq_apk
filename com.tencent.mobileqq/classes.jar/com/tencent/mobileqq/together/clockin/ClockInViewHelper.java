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
  private QQAppInterface a;
  private Context b;
  private FrameLayout c;
  private ClockInData d;
  private NoClockInView e;
  private HasClockView f;
  private IntegralClockView g;
  private RelativeLayout h;
  private DiniFlyAnimationView i;
  private ClockAnimController j;
  private int k = 1;
  private ClockInCallback l = new ClockInViewHelper.1(this);
  private TroopClockInObserver m = new ClockInViewHelper.2(this);
  
  public ClockInViewHelper(QQAppInterface paramQQAppInterface, Context paramContext, ClockInData paramClockInData, FrameLayout paramFrameLayout, RelativeLayout paramRelativeLayout, DiniFlyAnimationView paramDiniFlyAnimationView, int paramInt)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.c = paramFrameLayout;
    this.d = paramClockInData;
    this.j = new ClockAnimController();
    this.h = paramRelativeLayout;
    this.i = paramDiniFlyAnimationView;
    this.k = paramInt;
    paramQQAppInterface = this.a;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.addObserver(this.m);
      paramQQAppInterface = (ITroopClockInHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_CLOCKIN_HANDLER);
      if (paramQQAppInterface != null)
      {
        paramContext = this.d;
        if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.a))) {
          paramQQAppInterface.a(this.d.a, this.a.getCurrentAccountUin(), 2);
        }
      }
    }
  }
  
  private void a(oidb_0xeb7.StSignInStatusRsp paramStSignInStatusRsp)
  {
    Object localObject = (oidb_0xeb7.SignInStatusBase)paramStSignInStatusRsp.base.get();
    this.d.g = paramStSignInStatusRsp.mantleUrl.get();
    this.d.q = paramStSignInStatusRsp.backgroundUrl.get();
    if (localObject != null)
    {
      ClockInData localClockInData = this.d;
      boolean bool;
      if (((oidb_0xeb7.SignInStatusBase)localObject).status.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localClockInData.b = bool;
    }
    if (this.d.b)
    {
      this.d.c = false;
      if (this.k == 1)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("op_via", "2");
        ((HashMap)localObject).put("A8", this.a.getCurrentAccountUin());
        ((HashMap)localObject).put("qq_group_num", this.d.a);
        ClockReportUtil.a("click#aio_icon", (HashMap)localObject);
      }
      if (paramStSignInStatusRsp.doneInfo.has())
      {
        paramStSignInStatusRsp = (oidb_0xeb7.SignInStatusDoneInfo)paramStSignInStatusRsp.doneInfo.get();
        if (paramStSignInStatusRsp != null)
        {
          this.d.k = paramStSignInStatusRsp.leftTitleWrod.get();
          this.d.n = paramStSignInStatusRsp.rightDescWord.get();
          localObject = paramStSignInStatusRsp.belowPortraitWords.get();
          if (((List)localObject).size() > 1)
          {
            this.d.m = ((String)((List)localObject).get(0));
            this.d.l = Long.valueOf((String)((List)localObject).get(1)).longValue();
          }
          this.d.o = paramStSignInStatusRsp.recordUrl.get();
        }
      }
    }
    else
    {
      if (this.k == 1)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("op_via", "1");
        ((HashMap)localObject).put("A8", this.a.getCurrentAccountUin());
        ((HashMap)localObject).put("qq_group_num", this.d.a);
        ClockReportUtil.a("click#aio_icon", (HashMap)localObject);
      }
      if (paramStSignInStatusRsp.notInfo.has())
      {
        localObject = (oidb_0xeb7.SignInStatusNotInfo)paramStSignInStatusRsp.notInfo.get();
        if (localObject != null)
        {
          this.d.j = ((oidb_0xeb7.SignInStatusNotInfo)localObject).buttonWord.get();
          this.d.h = ((oidb_0xeb7.SignInStatusNotInfo)localObject).signDescWordLeft.get();
          this.d.i = ((oidb_0xeb7.SignInStatusNotInfo)localObject).signDescWordRight.get();
        }
      }
      if (paramStSignInStatusRsp.yesterday.has())
      {
        paramStSignInStatusRsp = (oidb_0xeb7.SignInStatusYesterdayFirst)paramStSignInStatusRsp.yesterday.get();
        if (paramStSignInStatusRsp != null)
        {
          this.d.d = paramStSignInStatusRsp.yesterdayFirstUid.get();
          this.d.f = paramStSignInStatusRsp.yesterdayNick.get();
          this.d.e = paramStSignInStatusRsp.yesterdayWord.get();
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject)
  {
    if ((this.d != null) && (this.a != null))
    {
      if ((paramObject != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(this.d.a)) && (paramString2.equals(this.a.getCurrentAccountUin())))
      {
        if (!paramBoolean)
        {
          paramString1 = this.b;
          if (paramString1 != null)
          {
            QQToast.makeText(paramString1, 1, HardCodeUtil.a(2131897497), 0).show();
            return;
          }
        }
        if ((paramObject instanceof oidb_0xeb7.StSignInWriteRsp))
        {
          paramString1 = (oidb_0xeb7.StSignInWriteRsp)paramObject;
          paramString2 = (oidb_0xeb7.SignInStatusDoneInfo)paramString1.doneInfo.get();
          paramObject = this.d;
          paramObject.b = true;
          if (paramString2 != null)
          {
            paramObject.k = paramString2.leftTitleWrod.get();
            this.d.n = paramString2.rightDescWord.get();
            this.d.o = paramString2.recordUrl.get();
            paramString2 = paramString2.belowPortraitWords.get();
            if ((paramString2 != null) && (paramString2.size() > 1))
            {
              this.d.m = ((String)paramString2.get(0));
              if (!TextUtils.isEmpty((CharSequence)paramString2.get(1))) {
                this.d.l = Long.valueOf((String)paramString2.get(1)).longValue();
              }
            }
          }
          if (paramString1.groupScore.has())
          {
            paramString1 = (oidb_0xeb7.SignInStatusGroupScore)paramString1.groupScore.get();
            this.d.p = paramString1.scoreUrl.get();
          }
          if (QLog.isColorLevel()) {
            QLog.d("ClockInViewHelper", 2, "handleClockResp play anim ANIM_NOCLOCKIN_ROTATE_START");
          }
          paramString1 = this.j;
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
    if ((this.d != null) && (this.a != null))
    {
      if ((paramObject != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(this.d.a)) && (paramString2.equals(this.a.getCurrentAccountUin())) && (paramInt == 2))
      {
        if (!paramBoolean)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ClockInViewHelper", 2, "handleGetClockDataRsp data isSuccess false");
            paramString1 = this.c;
            if (paramString1 != null) {
              paramString1.setVisibility(8);
            }
          }
        }
        else if ((paramObject instanceof oidb_0xeb7.StSignInStatusRsp))
        {
          a((oidb_0xeb7.StSignInStatusRsp)paramObject);
          a();
          paramString1 = this.c;
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
  
  private boolean e()
  {
    return (this.a != null) && (this.b != null) && (this.c != null) && (this.d != null) && (this.h != null) && (this.i != null) && (this.j != null);
  }
  
  private void f()
  {
    if (this.e == null) {
      this.e = new NoClockInView(this.b, this.a, this.c, this.d, this.l, this.j);
    }
  }
  
  private void g()
  {
    if (this.f == null) {
      this.f = new HasClockView(this.b, this.a, this.c, this.d, this.l, this.j);
    }
  }
  
  private void h()
  {
    if (this.g == null) {
      this.g = new IntegralClockView(this.i, this.h, this.b, this.j, this.d);
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInViewHelper", 2, "handleClockInBtnClick");
    }
    Object localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject1 = ((FrameLayout)localObject1).findViewById(2131437632);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    localObject1 = this.a;
    if (localObject1 != null)
    {
      localObject1 = (ITroopClockInHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.TROOP_CLOCKIN_HANDLER);
      if (localObject1 != null)
      {
        localObject2 = this.d;
        if ((localObject2 != null) && (!TextUtils.isEmpty(((ClockInData)localObject2).a))) {
          ((ITroopClockInHandler)localObject1).a(this.d.a, this.a.getCurrentAccountUin());
        }
      }
    }
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("op_via", "1");
    Object localObject2 = this.d;
    if ((localObject2 != null) && (!TextUtils.isEmpty(((ClockInData)localObject2).a))) {
      ((HashMap)localObject1).put("qq_group_num", this.d.a);
    }
    localObject2 = this.a;
    if ((localObject2 != null) && (!TextUtils.isEmpty(((QQAppInterface)localObject2).getCurrentAccountUin()))) {
      ((HashMap)localObject1).put("A8", this.a.getCurrentAccountUin());
    }
    ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject1);
  }
  
  public void a()
  {
    if (!e())
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
      localStringBuilder.append(this.d.b);
      QLog.d("ClockInViewHelper", 2, localStringBuilder.toString());
    }
    if (this.d.b)
    {
      g();
      this.f.b(0);
      return;
    }
    f();
    g();
    h();
    this.e.b(0);
    this.f.b(4);
    this.g.b(8);
  }
  
  public void b()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((NoClockInView)localObject).b();
      this.e = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((HasClockView)localObject).b();
      this.f = null;
    }
    localObject = this.g;
    if (localObject != null) {
      ((IntegralClockView)localObject).a();
    }
    this.l = null;
    localObject = this.j;
    if (localObject != null) {
      ((ClockAnimController)localObject).deleteObservers();
    }
    localObject = this.m;
    if (localObject != null) {
      this.a.removeObserver((BusinessObserver)localObject);
    }
  }
  
  public boolean c()
  {
    ClockAnimController localClockAnimController = this.j;
    if (localClockAnimController != null) {
      return localClockAnimController.a();
    }
    return false;
  }
  
  public boolean d()
  {
    ClockInData localClockInData = this.d;
    return (localClockInData != null) && (localClockInData.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.ClockInViewHelper
 * JD-Core Version:    0.7.0.1
 */