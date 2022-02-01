package com.tencent.mobileqq.mtt;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaAccessHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQAudioHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MttBrowerWrapper
{
  public static void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageRecord paramMessageRecord)
  {
    a(paramContext, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramMessageRecord, null);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageRecord paramMessageRecord, String paramString2)
  {
    if (QRUtils.b(paramString1))
    {
      paramMessageRecord = new Intent(paramContext, JoinDiscussionActivity.class);
      int i = paramString1.indexOf("dc/ft?k=");
      if (i > 0) {
        paramMessageRecord.putExtra("innerSig", paramString1.substring(i + 8));
      } else {
        paramMessageRecord.putExtra("innerSig", paramString1);
      }
      paramContext.startActivity(paramMessageRecord);
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).isViolaUrlFromWeb(paramString1)))
    {
      ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).startViolaPage(paramContext, null, ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).getviolaurlfromweb(paramString1), null);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gotoWebViewBrowser_");
    ((StringBuilder)localObject).append(paramString1);
    QQAudioHelper.b(((StringBuilder)localObject).toString());
    localObject = new Intent(paramContext, QQBrowserDelegationActivity.class);
    ((Intent)localObject).putExtra("param_force_internal_browser", paramBoolean4);
    ((Intent)localObject).putExtra("key_isReadModeEnabled", paramBoolean1);
    ((Intent)localObject).putExtra("big_brother_source_key", paramString2);
    if ((paramContext instanceof BaseActivity)) {
      ((Intent)localObject).putExtra("uin", ((BaseActivity)paramContext).getAppRuntime().getAccount());
    }
    ((Intent)localObject).putExtra("useDefBackText", paramBoolean3);
    ((Intent)localObject).putExtra("injectrecommend", paramBoolean2);
    if (paramMessageRecord != null)
    {
      ((Intent)localObject).putExtra("curtype", paramMessageRecord.istroop);
      ((Intent)localObject).putExtra("friendUin", paramMessageRecord.frienduin);
      if (paramMessageRecord.istroop == 0) {
        ((Intent)localObject).putExtra("articalChannelId", 2);
      } else if (paramMessageRecord.istroop == 1) {
        ((Intent)localObject).putExtra("articalChannelId", 3);
      } else if (paramMessageRecord.istroop == 3000) {
        ((Intent)localObject).putExtra("articalChannelId", 4);
      }
    }
    ((Intent)localObject).putExtra("url", paramString1);
    ((Intent)localObject).putExtra("fromOneCLickCLose", true);
    ((Intent)localObject).putExtra("fromAio", true);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(paramMessageRecord, (Intent)localObject, paramString1);
    paramString2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((paramString2 instanceof QQAppInterface)) {
      AIOOpenWebMonitor.a((Intent)localObject, (QQAppInterface)paramString2, paramMessageRecord);
    }
    WebAccelerator.a(paramContext, (Intent)localObject, paramString1);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mtt.MttBrowerWrapper
 * JD-Core Version:    0.7.0.1
 */