package com.tencent.mobileqq.ecshop.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.EcshopAdHandler;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopPublicAccountChatPieTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class EcshopAdViewHelper$4
  implements View.OnClickListener
{
  EcshopAdViewHelper$4(EcshopAdViewHelper paramEcshopAdViewHelper, int paramInt, JSONObject paramJSONObject, MessageRecord paramMessageRecord, Context paramContext, EcshopAdViewHelper.DeleteMsgListener paramDeleteMsgListener, AppInterface paramAppInterface) {}
  
  public void onClick(View paramView)
  {
    int i = this.a;
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          localObject = this.e;
          if (localObject != null) {
            ((EcshopAdViewHelper.DeleteMsgListener)localObject).a(this.c);
          } else {
            ((IEcshopPublicAccountChatPieTempApi)QRoute.api(IEcshopPublicAccountChatPieTempApi.class)).startDelAnimAndDelMsg((ChatMessage)this.c);
          }
          ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).doArkAppContainerOnEvent(this.c, 2);
          ((EcshopAdHandler)this.f.getBusinessHandler(EcshopAdHandler.class.getName())).a(7, this.c);
          QQToast.makeText(paramView.getContext(), paramView.getContext().getResources().getString(2131889234), 1).show();
        }
      }
      else
      {
        localObject = this.e;
        if (localObject != null) {
          ((EcshopAdViewHelper.DeleteMsgListener)localObject).a(this.c);
        } else {
          ((IEcshopPublicAccountChatPieTempApi)QRoute.api(IEcshopPublicAccountChatPieTempApi.class)).startDelAnimAndDelMsg((ChatMessage)this.c);
        }
        ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).doArkAppContainerOnEvent(this.c, 2);
        ((EcshopAdHandler)this.f.getBusinessHandler(EcshopAdHandler.class.getName())).a(8, this.c);
        QQToast.makeText(paramView.getContext(), paramView.getResources().getString(2131889234), 1).show();
      }
    }
    else
    {
      localObject = this.b.optString("action_url", "");
      if (!StringUtil.isEmpty((String)localObject))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("url", (String)localObject);
        localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3046055438");
        if (this.c != null) {
          localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.c.frienduin);
        }
        localIntent.putExtra("big_brother_source_key", (String)localObject);
        RouteUtils.a(this.d, localIntent, "/base/browser");
      }
    }
    if ((EcshopAdViewHelper.a(this.g) != null) && (EcshopAdViewHelper.a(this.g).isShowing())) {
      EcshopAdViewHelper.a(this.g).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper.4
 * JD-Core Version:    0.7.0.1
 */