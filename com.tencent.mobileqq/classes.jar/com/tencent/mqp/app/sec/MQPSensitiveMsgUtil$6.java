package com.tencent.mqp.app.sec;

import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class MQPSensitiveMsgUtil$6
  extends ClickableSpan
{
  MQPSensitiveMsgUtil$6(String paramString, int paramInt, long paramLong, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    paramView = MobileQQ.sMobileQQ.waitAppRuntime(null);
    int k = 0;
    int i = 0;
    int j = k;
    Iterator localIterator;
    Object localObject1;
    if (paramView != null)
    {
      paramView = (QQMessageFacade)paramView.getManager(QQManagerFactory.MGR_MSG_FACADE);
      j = k;
      if (paramView != null)
      {
        paramView = paramView.a(this.a, this.b, this.c);
        if (paramView == null) {
          return;
        }
        String str1 = paramView.getExtInfoFromExtStr("sens_msg_attr");
        if (!TextUtils.isEmpty(str1))
        {
          try
          {
            j = Integer.parseInt(str1);
            i = j;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        else if (this.d.bankcode_elems.has())
        {
          localIterator = this.d.bankcode_elems.get().iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            localObject1 = (bankcode_info.BankcodeElem)localIterator.next();
            if (((bankcode_info.BankcodeElem)localObject1).bankcode_attr.has()) {
              j = ((bankcode_info.BankcodeElem)localObject1).bankcode_attr.get();
            } else {
              j = 0;
            }
            if (j > i) {
              i = j;
            }
          }
        }
        paramView = paramView.getExtInfoFromExtStr("sens_msg_need_mask");
        j = i;
        if (!TextUtils.isEmpty(paramView))
        {
          bool = Boolean.parseBoolean(paramView);
          break label216;
        }
      }
    }
    boolean bool = true;
    i = j;
    label216:
    if (!this.e)
    {
      if (!bool) {
        return;
      }
      paramView = (Bundle)AntiFraudConfigFileUtil.a().a("SensMsgTipsCfg", "Action", 1, i);
      if (paramView == null) {
        return;
      }
      localIterator = paramView.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = paramView.getBundle((String)localIterator.next());
        if ((localObject2 != null) && (((Bundle)localObject2).getString("Type").compareToIgnoreCase("showAlert") == 0))
        {
          localObject1 = ((Bundle)localObject2).getString("AlertTitle");
          String str2 = ((Bundle)localObject2).getString("AlertText");
          String str3 = ((Bundle)localObject2).getString("AlertOtherBtnText");
          localObject2 = ((Bundle)localObject2).getString("AlertCancelBtnText");
          MQPSensitiveMsgUtil.a(this.a, this.b, this.c, (String)localObject1, str2, str3, (String)localObject2);
        }
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(true);
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.6
 * JD-Core Version:    0.7.0.1
 */