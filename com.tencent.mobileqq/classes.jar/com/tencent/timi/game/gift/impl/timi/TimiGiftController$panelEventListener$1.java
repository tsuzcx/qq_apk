package com.tencent.timi.game.gift.impl.timi;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnPanelEventListener;
import com.tencent.timi.game.gift.impl.receiver.IReceiverCore;
import com.tencent.timi.game.gift.impl.sdk.GiftSdkProvider;
import com.tencent.timi.game.utils.Logger;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/gift/impl/timi/TimiGiftController$panelEventListener$1", "Lcom/tencent/mobileqq/qqgift/mvvm/business/view/IQQGiftPanelView$OnPanelEventListener;", "onPanelHide", "", "onPanelItemClick", "data", "Lcom/tencent/mobileqq/qqgift/data/service/GiftServiceData;", "position", "", "onPanelItemSelected", "onPanelShow", "onRechargeClick", "onSendGiftCallback", "isSuccess", "errCode", "onSendGiftClick", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGiftController$panelEventListener$1
  implements IQQGiftPanelView.OnPanelEventListener
{
  public boolean a()
  {
    return false;
  }
  
  public boolean a(@Nullable GiftServiceData paramGiftServiceData, int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean, @Nullable GiftServiceData paramGiftServiceData, int paramInt)
  {
    paramGiftServiceData = new StringBuilder();
    paramGiftServiceData.append("onSendGiftCallback: ");
    paramGiftServiceData.append(paramBoolean);
    paramGiftServiceData.append(' ');
    paramGiftServiceData.append(paramInt);
    Logger.c("TimiGiftPresenter", paramGiftServiceData.toString());
    return false;
  }
  
  public boolean b()
  {
    TimiGiftController.d(this.a).b();
    TimiGiftController.a(this.a, false);
    TimiGiftController.h(this.a).setGiftPanelView(null);
    return false;
  }
  
  public boolean b(@Nullable GiftServiceData paramGiftServiceData, int paramInt)
  {
    if (paramGiftServiceData != null)
    {
      Object localObject = TimiGiftController.g(this.a);
      if (localObject != null)
      {
        localObject = ((GiftSdkProvider)localObject).c();
        if (localObject != null) {
          ((IQQGiftResDownloadModule)localObject).a(paramGiftServiceData.g, (IQQGiftPanelResDownloadCallback)new TimiGiftController.panelEventListener.1.onPanelItemSelected.1(this));
        }
      }
    }
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean c(@Nullable GiftServiceData paramGiftServiceData, int paramInt)
  {
    if (paramGiftServiceData != null)
    {
      boolean bool = TimiGiftController.a(this.a, paramGiftServiceData);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("intercept: ");
      ((StringBuilder)localObject1).append(bool);
      Logger.c("TimiGiftPresenter", ((StringBuilder)localObject1).toString());
      if (bool) {
        return true;
      }
      if (paramGiftServiceData.p != null)
      {
        Object localObject2 = (String)paramGiftServiceData.p.get("sender_nick");
        if (localObject2 != null)
        {
          String str1 = (String)paramGiftServiceData.p.get("sender_avatar");
          if (str1 != null)
          {
            localObject1 = (String)paramGiftServiceData.p.get("receiver_uin");
            if (localObject1 != null)
            {
              long l = Long.parseLong((String)localObject1);
              String str2 = (String)paramGiftServiceData.p.get("receiver_nick");
              if (str2 != null)
              {
                String str3 = (String)paramGiftServiceData.p.get("receiver_avatar");
                if (str3 != null)
                {
                  localObject1 = new GiftAnimData();
                  ((GiftAnimData)localObject1).a = paramGiftServiceData.a;
                  ((GiftAnimData)localObject1).b = paramGiftServiceData.d;
                  ((GiftAnimData)localObject1).c = paramGiftServiceData.b;
                  ((GiftAnimData)localObject1).d = paramGiftServiceData.g;
                  ((GiftAnimData)localObject1).e = paramGiftServiceData.h;
                  ((GiftAnimData)localObject1).g = TimiGiftController.i(this.a).uid.get();
                  ((GiftAnimData)localObject1).h = ((String)localObject2);
                  ((GiftAnimData)localObject1).k = str1;
                  ((GiftAnimData)localObject1).i = l;
                  ((GiftAnimData)localObject1).j = str2;
                  ((GiftAnimData)localObject1).l = str3;
                  ((GiftAnimData)localObject1).m = paramGiftServiceData.e;
                  ((GiftAnimData)localObject1).n = paramGiftServiceData.m;
                  ((GiftAnimData)localObject1).o = paramGiftServiceData.n;
                  ((GiftAnimData)localObject1).f = 100;
                  localObject2 = TimiGiftController.g(this.a);
                  if (localObject2 != null)
                  {
                    localObject2 = ((GiftSdkProvider)localObject2).a();
                    if (localObject2 != null) {
                      ((IQQGiftAnimationEngine)localObject2).b((GiftAnimData)localObject1);
                    }
                  }
                  TimiGiftController.h(this.a).a();
                  if ((paramGiftServiceData.d == 1) && (paramGiftServiceData.e == 1)) {
                    this.a.b();
                  }
                  return false;
                }
              }
            }
          }
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftController.panelEventListener.1
 * JD-Core Version:    0.7.0.1
 */