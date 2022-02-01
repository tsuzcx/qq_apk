package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;

public class StructMsgForHypertext$HyperSpannable
  extends URLSpan
{
  long a = -1L;
  private StructMsgForHypertext.Hypertext c = null;
  
  public StructMsgForHypertext$HyperSpannable(StructMsgForHypertext paramStructMsgForHypertext, StructMsgForHypertext.Hypertext paramHypertext)
  {
    super(paramHypertext.b);
    this.c = paramHypertext;
  }
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.a < 1000L) {
      return;
    }
    this.a = SystemClock.uptimeMillis();
    if (this.c == null) {
      return;
    }
    if ((paramView != null) && ((paramView instanceof StructMsgForHypertext.HyperTextView)) && (!((StructMsgForHypertext.HyperTextView)paramView).a())) {
      return;
    }
    Object localObject5;
    PackageManager localPackageManager;
    if ((!"web".equals(this.c.b)) && (!"auto".equals(this.c.b)) && (!"replyMsg".equals(this.c.b)) && (!"replyCmd".equals(this.c.b)) && (!"plugin".equals(this.c.b))) {
      if ("app".equals(this.c.b))
      {
        localObject5 = paramView.getContext();
        localPackageManager = ((Context)localObject5).getPackageManager();
      }
    }
    for (;;)
    {
      int i;
      Object localObject1;
      Object localObject4;
      try
      {
        if (TextUtils.isEmpty(this.c.d)) {
          localObject2 = this.c.c;
        } else {
          localObject2 = this.c.d;
        }
        i = ((String)localObject2).indexOf("://");
        if (i == -1)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = ((String)localObject2).substring(0, i);
          localObject4 = ((String)localObject2).substring(i + 3);
          localObject2 = localObject1;
          localObject1 = localObject4;
        }
      }
      catch (Exception localException2)
      {
        Object localObject2;
        localObject1 = "";
      }
      try
      {
        if (localPackageManager.getPackageInfo((String)localObject2, 1) != null)
        {
          localObject2 = localPackageManager.getLaunchIntentForPackage((String)localObject2);
          if (localObject2 != null)
          {
            ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_aio");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((Intent)localObject2).setData(Uri.parse((String)localObject1));
            }
            ((Context)localObject5).startActivity((Intent)localObject2);
          }
          else
          {
            QLog.w("StructMsg", 1, "intent is null");
          }
        }
        else if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith("http://")) || (((String)localObject1).startsWith("https://"))))
        {
          localObject2 = new Intent((Context)localObject5, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_aio");
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.b.message, (Intent)localObject2, (String)localObject1);
          ((Context)localObject5).startActivity((Intent)localObject2);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, (String)localObject1, "", "", "");
        }
      }
      catch (Exception localException1) {}
      if (QLog.isColorLevel()) {
        QLog.d("HypertextMsg", 2, localException2.getMessage(), localException2);
      }
      Object localObject3;
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith("http://")) || (((String)localObject1).startsWith("https://"))))
      {
        localObject3 = new Intent((Context)localObject5, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", (String)localObject1);
        ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_aio");
        ((Intent)localObject3).putExtra("key_isReadModeEnabled", true);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded((Intent)localObject3, (String)localObject1);
        ((Intent)localObject3).putExtra("fromAio", true);
        ((Context)localObject5).startActivity((Intent)localObject3);
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, (String)localObject1, "", "", "");
      }
      this.b.mHyperClick = true;
      break label686;
      new StructMsgClickHandler(null, paramView, this.b.message).a(this.c.b, this.c.a, this.c.c, this.c.d, this.b.message.msgseq, new Object[0]);
      this.b.mHyperClick = true;
      label686:
      int j = 0;
      if ((this.b.message instanceof MessageForStructing))
      {
        if (((MessageForStructing)this.b.message).structingMsg.mMsgServiceID != 120) {
          return;
        }
        if (!TextUtils.isEmpty(this.c.f))
        {
          localObject1 = this.b.message;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(StructMsgForHypertext.access$000(this.b));
          ((StringBuilder)localObject3).append(this.c.f);
          localObject1 = ((MessageRecord)localObject1).getExtInfoFromExtStr(((StringBuilder)localObject3).toString());
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              i = Integer.valueOf((String)localObject1).intValue();
            } else {
              i = 0;
            }
            try
            {
              if (!TextUtils.isEmpty(this.c.g))
              {
                int k = Integer.valueOf(this.c.g).intValue();
                j = k;
              }
              else
              {
                j = 0;
              }
            }
            catch (NumberFormatException localNumberFormatException1) {}
            QLog.d("StructMsg", 1, localNumberFormatException2.getMessage());
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            i = 0;
          }
        }
        else
        {
          i = 0;
        }
        if ((i != 0) && (i >= j)) {
          return;
        }
        if (!TextUtils.isEmpty(this.c.b))
        {
          BaseActivity localBaseActivity = (BaseActivity)paramView.getContext();
          paramView = localBaseActivity.getChatFragment();
          if (paramView != null)
          {
            paramView = paramView.j();
          }
          else
          {
            paramView = BaseApplicationImpl.getApplication().getRuntime();
            if ((paramView instanceof QQAppInterface)) {
              paramView = (QQAppInterface)paramView;
            } else {
              paramView = null;
            }
          }
          if (paramView == null) {
            return;
          }
          ((QidianManager)paramView.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(this.c.b, this.c.d, this.c.c, this.c.a, 1, "");
          if (!TextUtils.isEmpty(this.c.f))
          {
            i += 1;
            if (i <= j)
            {
              localObject3 = this.b.message;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(StructMsgForHypertext.access$000(this.b));
              ((StringBuilder)localObject4).append(this.c.f);
              localObject4 = ((StringBuilder)localObject4).toString();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("");
              ((StringBuilder)localObject5).append(i);
              ((MessageRecord)localObject3).saveExtInfoToExtStr((String)localObject4, ((StringBuilder)localObject5).toString());
              paramView.getMessageFacade().a(this.b.message.frienduin, this.b.message.istroop, this.b.message.uniseq, "extStr", this.b.message.extStr);
            }
          }
          localBaseActivity.getChatFragment().k().j(131078);
        }
      }
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext.HyperSpannable
 * JD-Core Version:    0.7.0.1
 */