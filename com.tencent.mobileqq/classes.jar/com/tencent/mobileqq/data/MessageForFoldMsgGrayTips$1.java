package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.PasswdRedBagFoldManager;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class MessageForFoldMsgGrayTips$1
  extends ClickableSpan
{
  MessageForFoldMsgGrayTips$1(MessageForFoldMsgGrayTips paramMessageForFoldMsgGrayTips, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject3 = this.a.getCurrentNickname();
    Object localObject2 = this.d.frienduin;
    Object localObject1 = new JSONObject();
    paramView = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("name", localObject3);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(1);
      ((StringBuilder)localObject3).append("");
      ((JSONObject)localObject1).put("grouptype", ((StringBuilder)localObject3).toString());
      ((JSONObject)localObject1).put("groupid", localObject2);
      localObject2 = (IPasswdRedBagService)this.a.getRuntimeService(IPasswdRedBagService.class);
      localObject3 = (PasswdRedBagFoldManager)this.a.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
      if ((TextUtils.isEmpty(this.d.redBagId)) && (!TextUtils.isEmpty(this.d.redBagIndex))) {
        this.d.redBagId = ((String)((PasswdRedBagFoldManager)localObject3).i.get(this.d.redBagIndex));
      }
      if (TextUtils.isEmpty(this.d.redBagId)) {
        return;
      }
      localObject3 = ((IPasswdRedBagService)localObject2).getAuthKeyCache();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((IPasswdRedBagService)localObject2).transType(this.d.istroop));
      localStringBuilder.append("_");
      localStringBuilder.append(this.d.frienduin);
      localStringBuilder.append("_");
      localStringBuilder.append(this.d.redBagId);
      localObject2 = (String)((Map)localObject3).get(localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      ((JSONObject)localObject1).put("listid", this.d.redBagId);
      ((JSONObject)localObject1).put("authkey", localObject2);
      paramView.put("userId", this.a.getCurrentAccountUin());
      paramView.put("viewTag", "redgiftDetail");
      paramView.put("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
      paramView.put("come_from", 2);
      paramView.put("extra_data", localObject1);
    }
    catch (Exception localException)
    {
      label351:
      break label351;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("json", paramView.toString());
    ((Bundle)localObject1).putString("callbackSn", "0");
    paramView = new Intent(this.b, PayBridgeActivity.class);
    paramView.putExtras((Bundle)localObject1);
    paramView.putExtra("pay_requestcode", 5);
    this.b.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.c);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFoldMsgGrayTips.1
 * JD-Core Version:    0.7.0.1
 */