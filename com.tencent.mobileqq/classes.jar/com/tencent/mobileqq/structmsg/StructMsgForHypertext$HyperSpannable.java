package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import bdla;
import bdob;
import bdov;
import bjxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import uuc;

public class StructMsgForHypertext$HyperSpannable
  extends URLSpan
{
  long jdField_a_of_type_Long = -1L;
  private bdov jdField_a_of_type_Bdov;
  
  public StructMsgForHypertext$HyperSpannable(StructMsgForHypertext paramStructMsgForHypertext, bdov parambdov)
  {
    super(parambdov.b);
    this.jdField_a_of_type_Bdov = parambdov;
  }
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    do
    {
      return;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    } while ((this.jdField_a_of_type_Bdov == null) || ((paramView != null) && ((paramView instanceof StructMsgForHypertext.HyperTextView)) && (!((StructMsgForHypertext.HyperTextView)paramView).a())));
    label196:
    int m;
    int j;
    int i;
    int k;
    Object localObject1;
    if (("web".equals(this.jdField_a_of_type_Bdov.b)) || ("auto".equals(this.jdField_a_of_type_Bdov.b)) || ("replyMsg".equals(this.jdField_a_of_type_Bdov.b)) || ("replyCmd".equals(this.jdField_a_of_type_Bdov.b)) || ("plugin".equals(this.jdField_a_of_type_Bdov.b)))
    {
      new bdob(null, paramView, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.message).a(this.jdField_a_of_type_Bdov.b, this.jdField_a_of_type_Bdov.a, this.jdField_a_of_type_Bdov.c, this.jdField_a_of_type_Bdov.d, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.message.msgseq, new Object[0]);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.mHyperClick = true;
      if ((!(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.message instanceof MessageForStructing)) || (((MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.message).structingMsg.mMsgServiceID != 120)) {
        break label766;
      }
      m = 0;
      j = 0;
      i = 0;
      k = 0;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Bdov.f)) {
        break label1170;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.message.getExtInfoFromExtStr(StructMsgForHypertext.access$000(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext) + this.jdField_a_of_type_Bdov.f);
      j = m;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          j = m;
          i = Integer.valueOf((String)localObject1).intValue();
        }
        j = i;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bdov.g))
        {
          j = i;
          k = Integer.valueOf(this.jdField_a_of_type_Bdov.g).intValue();
        }
        if (((i != 0) && (i >= k)) || (TextUtils.isEmpty(this.jdField_a_of_type_Bdov.b))) {
          break;
        }
        localObject1 = paramView.getContext();
        paramView = ((FragmentActivity)localObject1).getChatFragment();
        if (paramView == null) {
          break label1178;
        }
        paramView = paramView.a();
        if (paramView == null) {
          break;
        }
        ((bjxa)paramView.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(this.jdField_a_of_type_Bdov.b, this.jdField_a_of_type_Bdov.d, this.jdField_a_of_type_Bdov.c, this.jdField_a_of_type_Bdov.a, 1, "");
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bdov.f))
        {
          i += 1;
          if (i <= k)
          {
            this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.message.saveExtInfoToExtStr(StructMsgForHypertext.access$000(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext) + this.jdField_a_of_type_Bdov.f, "" + i);
            paramView.getMessageFacade().updateMsgFieldByUniseq(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.message.frienduin, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.message.istroop, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.message.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.message.extStr);
          }
        }
        ((FragmentActivity)localObject1).getChatFragment().a().refresh(131077);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Context localContext;
        PackageManager localPackageManager;
        Object localObject3;
        label766:
        QLog.d("StructMsg", 1, localNumberFormatException.getMessage());
      }
      if (!"app".equals(this.jdField_a_of_type_Bdov.b)) {
        break label196;
      }
      localContext = paramView.getContext();
      localPackageManager = localContext.getPackageManager();
      localObject1 = "";
      localObject3 = localObject1;
      try
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bdov.d)) {
          continue;
        }
        localObject3 = localObject1;
        localObject2 = this.jdField_a_of_type_Bdov.c;
        localObject3 = localObject1;
        i = ((String)localObject2).indexOf("://");
        if (i != -1) {
          continue;
        }
        localObject3 = localObject1;
        if (localPackageManager.getPackageInfo((String)localObject2, 1) == null) {
          continue;
        }
        localObject3 = localObject1;
        localObject2 = localPackageManager.getLaunchIntentForPackage((String)localObject2);
        if (localObject2 == null) {
          continue;
        }
        localObject3 = localObject1;
        ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_aio");
        localObject3 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = localObject1;
          ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        }
        localObject3 = localObject1;
        localContext.startActivity((Intent)localObject2);
      }
      catch (Exception localException)
      {
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("HypertextMsg", 2, localException.getMessage(), localException);
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || ((!((String)localObject3).startsWith("http://")) && (!((String)localObject3).startsWith("https://")))) {
          continue;
        }
        Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject3);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_aio");
        localIntent.putExtra("key_isReadModeEnabled", true);
        uuc.a(localIntent, (String)localObject3);
        localIntent.putExtra("fromAio", true);
        localContext.startActivity(localIntent);
        bdla.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, (String)localObject3, "", "", "");
        continue;
        localObject3 = localIntent;
        if (TextUtils.isEmpty(localIntent)) {
          continue;
        }
        localObject3 = localIntent;
        if (localIntent.startsWith("http://")) {
          continue;
        }
        localObject3 = localIntent;
        if (!localIntent.startsWith("https://")) {
          continue;
        }
        localObject3 = localIntent;
        Object localObject2 = new Intent(localContext, QQBrowserActivity.class);
        localObject3 = localIntent;
        ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_aio");
        localObject3 = localIntent;
        ((Intent)localObject2).putExtra("url", localIntent);
        localObject3 = localIntent;
        ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
        localObject3 = localIntent;
        uuc.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.message, (Intent)localObject2, localIntent);
        localObject3 = localIntent;
        localContext.startActivity((Intent)localObject2);
        localObject3 = localIntent;
        bdla.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, localIntent, "", "", "");
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.mHyperClick = true;
      break label196;
      break;
      localObject3 = localObject1;
      localObject2 = this.jdField_a_of_type_Bdov.d;
      continue;
      localObject3 = localObject1;
      str = ((String)localObject2).substring(0, i);
      localObject3 = localObject1;
      localObject1 = ((String)localObject2).substring(i + 3);
      localObject2 = str;
      continue;
      localObject3 = localObject1;
      QLog.w("StructMsg", 1, "intent is null");
      continue;
      label1170:
      k = 0;
      i = j;
      continue;
      label1178:
      paramView = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramView instanceof QQAppInterface)) {
        paramView = (QQAppInterface)paramView;
      } else {
        paramView = null;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext.HyperSpannable
 * JD-Core Version:    0.7.0.1
 */