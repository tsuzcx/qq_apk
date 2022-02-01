package com.tencent.mobileqq.ecshop.keep;

import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.EcshopNewServlet;
import com.tencent.mobileqq.ecshop.ad.EcshopAdUtil;
import com.tencent.mobileqq.ecshop.aio.IEcshopChatPieCallback;
import com.tencent.mobileqq.ecshop.aio.IEcshopChatPieDelegate;
import com.tencent.mobileqq.ecshop.aio.IEcshopChatPieDelegate.IRefreshCallback;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import tencent.im.oidb.qqshop.qq_ad.QQAdGet;

public class EcshopMinusViewChatPie
  implements IEcshopChatPieDelegate
{
  private final IEcshopChatPieCallback a;
  private final boolean b;
  private boolean c;
  private List<ChatMessage> d;
  
  private void b(List<ChatMessage> paramList)
  {
    if (this.d.size() > 0)
    {
      paramList = (ChatMessage)this.d.get(0);
      if ((paramList != null) && (EcshopUtils.b(((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(paramList)))) {
        this.d.remove(paramList);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      paramContext.sendBroadcast(new Intent("com.tencent.mobileqq.ecshop.finish"));
      ReportUtil.a().a.clear();
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.w("EcshopMinusViewChatPie", 2, "onPageBack", paramContext);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    EcshopUtils.b(paramMessageRecord.uniseq);
  }
  
  public void a(List<Long> paramList)
  {
    EcshopAdUtil.a(this.a, paramList);
  }
  
  public void a(List<ChatMessage> paramList, IEcshopChatPieDelegate.IRefreshCallback paramIRefreshCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("messageArrayList.size: ");
      localStringBuilder.append(this.d.size());
      QLog.i("EcshopMinusViewChatPie", 2, localStringBuilder.toString());
    }
    b(paramList);
    paramList = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastAmsMessage(paramList);
    if ((paramList != null) && (EcshopUtils.b(((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(paramList))))
    {
      paramList.saveExtInfoToExtStr("add_title", "minus_view_title_first");
      this.d.add(0, paramList);
    }
    if (paramIRefreshCallback != null) {
      paramIRefreshCallback.a(this.d);
    }
    if (this.c) {
      return;
    }
    this.c = true;
    paramList = new qq_ad.QQAdGet();
    try
    {
      if (EcshopUtils.c()) {
        paramList.trigger_type.set(22);
      } else {
        paramList.trigger_type.set(18);
      }
    }
    catch (Exception localException)
    {
      label173:
      break label173;
    }
    paramList.trigger_type.set(22);
    if (QLog.isColorLevel()) {
      QLog.i("EcshopMinusViewChatPie", 2, "<<<<<<<<<<<<<<sendRequest<<<<<<<<<");
    }
    EcshopNewServlet.a(paramList.toByteArray(), "trpc.qqshop.adpush.PushService.GetAd", new EcshopMinusViewChatPie.1(this, paramIRefreshCallback));
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    paramContext = new MinusViewBotomView(paramContext);
    paramContext.setTag("echopMinusViewBotomView");
    paramContext.setBtnText(EcshopConfUtil.a());
    paramRelativeLayout.addView(paramContext);
    paramContext = (RelativeLayout.LayoutParams)paramContext.getLayoutParams();
    if (paramContext != null)
    {
      paramContext.width = -1;
      paramContext.height = -2;
      paramContext.addRule(12);
    }
    return true;
  }
  
  public boolean a(RelativeLayout paramRelativeLayout)
  {
    return (paramRelativeLayout != null) && (paramRelativeLayout.findViewWithTag("echopMinusViewBotomView") != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.keep.EcshopMinusViewChatPie
 * JD-Core Version:    0.7.0.1
 */