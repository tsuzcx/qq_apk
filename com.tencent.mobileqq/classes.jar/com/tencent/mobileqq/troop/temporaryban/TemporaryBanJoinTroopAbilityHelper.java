package com.tencent.mobileqq.troop.temporaryban;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import trpc.mizarproto.passthrough.FunctionLockMsg.FunctionLockBeatRsp;
import trpc.mizarproto.passthrough.FunctionLockMsg.FunctionLockBtn;

public class TemporaryBanJoinTroopAbilityHelper
{
  private String a;
  private List<FunctionLockMsg.FunctionLockBtn> b;
  
  private DialogInterface.OnClickListener a(String paramString, Context paramContext)
  {
    return new TemporaryBanJoinTroopAbilityHelper.2(this, paramContext, paramString);
  }
  
  private DialogInterface.OnClickListener a(String paramString, Context paramContext, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return b();
      }
      return b(paramString, paramContext);
    }
    return a(paramString, paramContext);
  }
  
  public static TemporaryBanJoinTroopAbilityHelper a()
  {
    return TemporaryBanJoinTroopAbilityHelper.Holder.a();
  }
  
  private DialogInterface.OnClickListener b()
  {
    return new TemporaryBanJoinTroopAbilityHelper.1(this);
  }
  
  private DialogInterface.OnClickListener b(String paramString, Context paramContext)
  {
    return new TemporaryBanJoinTroopAbilityHelper.3(this, paramContext, paramString);
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, FunctionLockMsg.FunctionLockBeatRsp paramFunctionLockBeatRsp, String paramString)
  {
    if ((paramAppInterface != null) && ((paramContext instanceof Activity)) && (paramFunctionLockBeatRsp != null))
    {
      this.a = paramFunctionLockBeatRsp.wording.get();
      this.b = paramFunctionLockBeatRsp.btns.get();
      if (!TextUtils.isEmpty(this.a))
      {
        paramAppInterface = this.b;
        if ((paramAppInterface != null) && (!paramAppInterface.isEmpty()))
        {
          if (this.b.size() == 1)
          {
            paramAppInterface = (FunctionLockMsg.FunctionLockBtn)this.b.get(0);
            DialogUtil.a(paramContext, 230, null, this.a, paramAppInterface.woding.get(), null, a(paramAppInterface.url.get(), paramContext, paramAppInterface.jump_type.get()), null).show();
          }
          else
          {
            paramAppInterface = (FunctionLockMsg.FunctionLockBtn)this.b.get(0);
            paramFunctionLockBeatRsp = (FunctionLockMsg.FunctionLockBtn)this.b.get(1);
            DialogUtil.a(paramContext, 230, null, this.a, paramAppInterface.woding.get(), paramFunctionLockBeatRsp.woding.get(), a(paramFunctionLockBeatRsp.url.get(), paramContext, paramFunctionLockBeatRsp.jump_type.get()), a(paramAppInterface.url.get(), paramContext, paramAppInterface.jump_type.get())).show();
          }
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("showTips Succ troopUin = ");
            paramAppInterface.append(paramString);
            QLog.d("JoinTroopTemporaryBanHelper", 2, paramAppInterface.toString());
          }
          return;
        }
      }
      QLog.e("JoinTroopTemporaryBanHelper", 1, "showTips Server return data error!");
      return;
    }
    QLog.e("JoinTroopTemporaryBanHelper", 1, "showTips arg error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.temporaryban.TemporaryBanJoinTroopAbilityHelper
 * JD-Core Version:    0.7.0.1
 */