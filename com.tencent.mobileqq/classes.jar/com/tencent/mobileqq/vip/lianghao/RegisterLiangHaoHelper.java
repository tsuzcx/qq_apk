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
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private RegisterLHAssistant jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant;
  private RegisterLiangHaoHelper.CheckCallBack jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper$CheckCallBack;
  private LiangHaoRsp jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp;
  private CheckRegisterLiangHao.RequestCallBack jdField_a_of_type_ComTencentMobileqqVipLianghaoNetCheckRegisterLiangHao$RequestCallBack;
  private GetRegisterLiangHaoList.RequestCallBack jdField_a_of_type_ComTencentMobileqqVipLianghaoNetGetRegisterLiangHaoList$RequestCallBack;
  private RegisterLiangHaoChoiceLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView;
  private RegisterLiangHaoPayFailLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  private String jdField_a_of_type_JavaLangString;
  private GetRegisterLiangHaoList.RequestCallBack b;
  
  public RegisterLiangHaoHelper(Context paramContext, RegisterLHAssistant paramRegisterLHAssistant)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant = paramRegisterLHAssistant;
  }
  
  private boolean a()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    if ((localContext instanceof RegisterByNicknameAndPwdActivity)) {
      return ((RegisterByNicknameAndPwdActivity)localContext).checkNickAndPwd();
    }
    if ((localContext instanceof RegisterPersonalInfoActivity)) {
      return ((RegisterPersonalInfoActivity)localContext).a();
    }
    return false;
  }
  
  private void c()
  {
    LiangHaoRsp localLiangHaoRsp = this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp;
    if (localLiangHaoRsp != null)
    {
      if (localLiangHaoRsp.a == null) {
        return;
      }
      a().a(this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp);
      int i = this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp.a.size();
      if (i > 4)
      {
        localLiangHaoRsp = this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp;
        localLiangHaoRsp.a = localLiangHaoRsp.a.subList(4, i);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp.a.clear();
    }
  }
  
  public RegisterLiangHaoChoiceLayoutView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView = new RegisterLiangHaoChoiceLayoutView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView.setLiangHaoHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView;
  }
  
  public RegisterLiangHaoPayFailLayoutView a(LiangHaoPayFailData paramLiangHaoPayFailData)
  {
    if (paramLiangHaoPayFailData == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView = new RegisterLiangHaoPayFailLayoutView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setUin(paramLiangHaoPayFailData.a);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setLiangHaoHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp;
    if ((localObject != null) && (((LiangHaoRsp)localObject).a != null) && (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp.a.size() >= 4))
    {
      c();
      return;
    }
    if (this.b == null) {
      this.b = new RegisterLiangHaoHelper.2(this);
    }
    localObject = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new GetRegisterLiangHaoList((String)localObject, i, this.b).a();
  }
  
  public void a(LiangHaoUinData paramLiangHaoUinData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant != null)
    {
      if (!a()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant.c();
      LiangHaoBuyFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant.a(), paramLiangHaoUinData);
    }
  }
  
  public void a(String paramString, RegisterLiangHaoHelper.CheckCallBack paramCheckCallBack)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper$CheckCallBack = paramCheckCallBack;
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoNetGetRegisterLiangHaoList$RequestCallBack == null) {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoNetGetRegisterLiangHaoList$RequestCallBack = new RegisterLiangHaoHelper.1(this);
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new GetRegisterLiangHaoList(paramString, i, this.jdField_a_of_type_ComTencentMobileqqVipLianghaoNetGetRegisterLiangHaoList$RequestCallBack).a();
  }
  
  public void a(String paramString, CheckRegisterLiangHao.RequestCallBack paramRequestCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoNetCheckRegisterLiangHao$RequestCallBack = paramRequestCallBack;
    new CheckRegisterLiangHao(paramString, paramRequestCallBack).a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant != null)
    {
      if (!a()) {
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((LiangHaoRsp)localObject1).b))) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoRsp.b;
      } else {
        localObject1 = "https://haoma.qq.com/m/clientReg/index.html";
      }
      if (((String)localObject1).indexOf("?") < 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?phone=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&phone=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      Object localObject2 = new Intent();
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant.a());
      ((Intent)localObject2).putExtra("lh_reg_from", 1);
      LoginUtils.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, "/base/browser");
    }
  }
  
  public void b(LiangHaoUinData paramLiangHaoUinData)
  {
    RegisterLHAssistant localRegisterLHAssistant = this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant;
    if (localRegisterLHAssistant == null) {
      return;
    }
    LiangHaoBuyFragment.b(this.jdField_a_of_type_AndroidContentContext, localRegisterLHAssistant.a(), paramLiangHaoUinData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.RegisterLiangHaoHelper
 * JD-Core Version:    0.7.0.1
 */