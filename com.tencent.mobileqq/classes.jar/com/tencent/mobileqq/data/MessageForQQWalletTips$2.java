package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.lang.ref.SoftReference;
import java.util.Map;
import org.json.JSONObject;

class MessageForQQWalletTips$2
  extends ClickableSpan
{
  MessageForQQWalletTips$2(MessageForQQWalletTips paramMessageForQQWalletTips, SoftReference paramSoftReference1, SoftReference paramSoftReference2, int paramInt1, QQAppInterface paramQQAppInterface, Context paramContext, QWalletAIOLifeCycleHelper paramQWalletAIOLifeCycleHelper, IPasswdRedBagService paramIPasswdRedBagService, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    paramView = (Context)this.a.get();
    Object localObject1 = (QQAppInterface)this.b.get();
    if (localObject1 != null)
    {
      if (paramView == null) {
        return;
      }
      Object localObject2 = MessageForQQWalletTips.access$000();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("rich click, msgtype: ");
      ((StringBuilder)localObject3).append(this.i.msgType);
      ((StringBuilder)localObject3).append(", msgsubtype: ");
      ((StringBuilder)localObject3).append(this.i.subType);
      ((StringBuilder)localObject3).append(",isEq:");
      ((StringBuilder)localObject3).append(TextUtils.equals(((QQAppInterface)localObject1).getCurrentAccountUin(), this.i.reciverUin));
      QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      if ((this.c == 1) && (!TextUtils.isEmpty(this.i.bytes_jumpurl)))
      {
        QLog.i(MessageForQQWalletTips.access$000(), 2, "gold red package...");
        localObject1 = QwUtils.a(this.i.bytes_jumpurl, MessageForQQWalletTips.access$100(this.i, this.d), true);
        int j = this.i.bytes_jumpurl.indexOf(':');
        if (j == -1) {
          return;
        }
        localObject2 = this.i.bytes_jumpurl.substring(0, j);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
        if ((((String)localObject2).compareTo("http") != 0) && (((String)localObject2).compareTo("https") != 0))
        {
          if (((String)localObject2).compareTo("mqqapi") == 0) {
            ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doJumpAction(this.e, (String)localObject1);
          }
        }
        else
        {
          localObject1 = new Intent(this.e, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", this.i.bytes_jumpurl);
          ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
          paramView.startActivity((Intent)localObject1);
        }
        return;
      }
      if ((MessageForQQWalletTips.access$200(this.i) == 524288) && (this.f != null))
      {
        localObject2 = this.g;
        if (localObject2 != null)
        {
          localObject2 = ((IPasswdRedBagService)localObject2).getPasswdRedBagInfoById(MessageForQQWalletTips.access$300(this.i));
          if ((localObject2 != null) && (!((PasswdRedBagInfo)localObject2).f) && (!((PasswdRedBagInfo)localObject2).g) && (!((PasswdRedBagInfo)localObject2).a()))
          {
            if (!StringUtil.isEmpty(this.g.getLastIdiomPinyin(((PasswdRedBagInfo)localObject2).i))) {
              this.f.a(MessageForQQWalletTips.access$300(this.i), ((PasswdRedBagInfo)localObject2).i, this.i.subChannel);
            }
            return;
          }
        }
      }
      if (TextUtils.isEmpty(MessageForQQWalletTips.access$300(this.i)))
      {
        QLog.i(MessageForQQWalletTips.access$000(), 2, "error, listId is null");
        return;
      }
      localObject2 = MessageForQQWalletTips.access$400(this.i, (QQAppInterface)localObject1);
      localObject3 = (String)((Map)localObject2).get("grouptype");
      String str1 = (String)((Map)localObject2).get("name");
      String str2 = (String)((Map)localObject2).get("groupId");
      JSONObject localJSONObject = new JSONObject();
      localObject2 = new JSONObject();
      try
      {
        localJSONObject.put("listid", MessageForQQWalletTips.access$300(this.i));
        localJSONObject.put("name", str1);
        localJSONObject.put("grouptype", localObject3);
        localJSONObject.put("groupid", str2);
        if (this.i.authKey != null) {
          localJSONObject.put("authkey", this.i.authKey);
        }
        ((JSONObject)localObject2).put("userId", ((QQAppInterface)localObject1).getCurrentAccountUin());
        ((JSONObject)localObject2).put("viewTag", "redgiftDetail");
        ((JSONObject)localObject2).put("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
        ((JSONObject)localObject2).put("come_from", 2);
        ((JSONObject)localObject2).put("extra_data", localJSONObject);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("json", ((JSONObject)localObject2).toString());
      localBundle.putString("callbackSn", "0");
      localObject2 = new Intent(paramView, PayBridgeActivity.class);
      ((Intent)localObject2).putExtras(localBundle);
      ((Intent)localObject2).putExtra("pay_requestcode", 5);
      paramView.startActivity((Intent)localObject2);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.h);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips.2
 * JD-Core Version:    0.7.0.1
 */