package com.tencent.mobileqq.vip.lianghao;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoPayFailData;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoRsp;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoUinData;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment;
import com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao;
import com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao.RequestCallBack;
import com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList;
import com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.RequestCallBack;
import com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoChoiceLayoutView;
import com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoPayFailLayoutView;
import java.util.List;

public class RegisterLiangHaoHelper
{
  private Context a;
  private String b;
  private int c = 0;
  private LiangHaoRsp d;
  private RegisterLiangHaoChoiceLayoutView e;
  private RegisterLiangHaoPayFailLayoutView f;
  private GetRegisterLiangHaoList.RequestCallBack g;
  private GetRegisterLiangHaoList.RequestCallBack h;
  private RegisterLiangHaoHelper.CheckCallBack i;
  private CheckRegisterLiangHao.RequestCallBack j;
  private RegisterLHAssistant k;
  
  public RegisterLiangHaoHelper(Context paramContext, RegisterLHAssistant paramRegisterLHAssistant)
  {
    this.a = paramContext;
    this.k = paramRegisterLHAssistant;
  }
  
  private void d()
  {
    LiangHaoRsp localLiangHaoRsp = this.d;
    if (localLiangHaoRsp != null)
    {
      if (localLiangHaoRsp.f == null) {
        return;
      }
      b().a(this.d);
      int m = this.d.f.size();
      if (m > 4)
      {
        localLiangHaoRsp = this.d;
        localLiangHaoRsp.f = localLiangHaoRsp.f.subList(4, m);
        return;
      }
      this.d.f.clear();
    }
  }
  
  private boolean e()
  {
    Context localContext = this.a;
    if ((localContext instanceof RegisterByNicknameAndPwdActivity)) {
      return ((RegisterByNicknameAndPwdActivity)localContext).checkNickAndPwd();
    }
    if ((localContext instanceof RegisterPersonalInfoActivity)) {
      return ((RegisterPersonalInfoActivity)localContext).a();
    }
    return false;
  }
  
  public RegisterLiangHaoPayFailLayoutView a(LiangHaoPayFailData paramLiangHaoPayFailData)
  {
    if (paramLiangHaoPayFailData == null) {
      return null;
    }
    if (this.f == null)
    {
      this.f = new RegisterLiangHaoPayFailLayoutView(this.a);
      this.f.setUin(paramLiangHaoPayFailData.a);
      this.f.setLiangHaoHelper(this);
    }
    return this.f;
  }
  
  public void a()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((LiangHaoRsp)localObject).f != null) && (this.d.f.size() >= 4))
    {
      d();
      return;
    }
    if (this.h == null) {
      this.h = new RegisterLiangHaoHelper.2(this);
    }
    localObject = this.b;
    int m = this.c;
    this.c = (m + 1);
    new GetRegisterLiangHaoList((String)localObject, m, this.h).a();
  }
  
  public void a(LiangHaoUinData paramLiangHaoUinData)
  {
    if (this.k != null)
    {
      if (!e()) {
        return;
      }
      this.k.d();
      LiangHaoBuyFragment.a(this.a, this.k.c(), paramLiangHaoUinData);
    }
  }
  
  public void a(String paramString, RegisterLiangHaoHelper.CheckCallBack paramCheckCallBack)
  {
    this.b = paramString;
    this.i = paramCheckCallBack;
    if (this.g == null) {
      this.g = new RegisterLiangHaoHelper.1(this);
    }
    int m = this.c;
    this.c = (m + 1);
    new GetRegisterLiangHaoList(paramString, m, this.g).a();
  }
  
  public void a(String paramString, CheckRegisterLiangHao.RequestCallBack paramRequestCallBack)
  {
    this.j = paramRequestCallBack;
    new CheckRegisterLiangHao(paramString, paramRequestCallBack).a();
  }
  
  public RegisterLiangHaoChoiceLayoutView b()
  {
    if (this.e == null)
    {
      this.e = new RegisterLiangHaoChoiceLayoutView(this.a);
      this.e.setLiangHaoHelper(this);
    }
    return this.e;
  }
  
  public void b(LiangHaoUinData paramLiangHaoUinData)
  {
    RegisterLHAssistant localRegisterLHAssistant = this.k;
    if (localRegisterLHAssistant == null) {
      return;
    }
    LiangHaoBuyFragment.b(this.a, localRegisterLHAssistant.c(), paramLiangHaoUinData);
  }
  
  public void c()
  {
    if (this.k != null)
    {
      if (!e()) {
        return;
      }
      Object localObject1 = this.d;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((LiangHaoRsp)localObject1).d))) {
        localObject1 = this.d.d;
      } else {
        localObject1 = "https://haoma.qq.com/m/clientReg/index.html";
      }
      if (((String)localObject1).indexOf("?") < 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?phone=");
        ((StringBuilder)localObject2).append(this.b);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&phone=");
        ((StringBuilder)localObject2).append(this.b);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      Object localObject2 = new Intent();
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtras(this.k.c());
      ((Intent)localObject2).putExtra("lh_reg_from", 1);
      LoginUtils.a(this.a, (Intent)localObject2, "/base/browser");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.RegisterLiangHaoHelper
 * JD-Core Version:    0.7.0.1
 */