package com.tencent.mobileqq.ecshop.aio;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.EcshopAdHandler;
import com.tencent.mobileqq.ecshop.ad.EcshopAdUtil;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfProcessor;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.ecshop.conf.QQShopConfigUtil;
import com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil;
import com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil.IGetRedPointCallback;
import com.tencent.mobileqq.ecshop.redpoint.RedPointInfo;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.ecshop.view.controller.TabLayoutController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class EcshopQggChatPie
  implements IEcshopChatPieDelegate, QQShopRedPointUtil.IGetRedPointCallback
{
  private TabLayoutController a;
  private final boolean b;
  private final IEcshopChatPieCallback c;
  
  public EcshopQggChatPie(Intent paramIntent, IEcshopChatPieCallback paramIEcshopChatPieCallback)
  {
    this.b = paramIntent.getBooleanExtra("req_qgg_hide_tab", false);
    this.c = paramIEcshopChatPieCallback;
    ((EcshopAdHandler)((AppInterface)AppUtils.a()).getBusinessHandler(EcshopAdHandler.class.getName())).a(this);
    QQShopRedPointUtil.a(this);
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      paramContext.sendBroadcast(new Intent("com.tencent.mobileqq.ecshop.finish"));
      QQShopRedPointUtil.a();
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.w("EcshopMinusViewChatPie", 2, "onPageBack", paramContext);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord) {}
  
  public void a(@NotNull ArrayList<RedPointInfo> paramArrayList)
  {
    TabLayoutController localTabLayoutController = this.a;
    if (localTabLayoutController != null) {
      localTabLayoutController.a(paramArrayList);
    }
  }
  
  public void a(List<Long> paramList)
  {
    EcshopAdUtil.a(this.c, paramList);
  }
  
  public void a(List<ChatMessage> paramList, IEcshopChatPieDelegate.IRefreshCallback paramIRefreshCallback)
  {
    if (paramList.size() > 0)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        localChatMessage.removeExtInfoToExtStr("add_title");
        if (EcshopUtils.d(localChatMessage) == 1) {
          localIterator.remove();
        }
      }
    }
    if (paramIRefreshCallback != null) {
      paramIRefreshCallback.a(paramList);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    if (a()) {
      return false;
    }
    paramContext = EcshopConfProcessor.a();
    if (EcshopConfUtil.a(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EcshopMinusViewChatPie", 2, "initPublicAccountMenu new qqshop pubaccount return");
      }
      if (QQShopConfigUtil.a(paramContext))
      {
        LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(paramRelativeLayout.getContext()).inflate(2131628311, paramRelativeLayout, false);
        paramRelativeLayout.addView(localLinearLayout);
        paramRelativeLayout = new TabLayoutController(localLinearLayout);
        paramRelativeLayout.a(paramContext.k, paramContext.e);
        paramRelativeLayout.a(1);
        paramRelativeLayout.a(QQShopRedPointUtil.b());
        this.a = paramRelativeLayout;
        return true;
      }
    }
    return false;
  }
  
  public boolean a(RelativeLayout paramRelativeLayout)
  {
    return (!a()) && (EcshopConfUtil.b()) && (paramRelativeLayout != null) && (paramRelativeLayout.findViewWithTag("echopCustomTabView") != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.aio.EcshopQggChatPie
 * JD-Core Version:    0.7.0.1
 */