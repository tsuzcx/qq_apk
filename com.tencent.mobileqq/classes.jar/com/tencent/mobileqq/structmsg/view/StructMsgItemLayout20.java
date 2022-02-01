package com.tencent.mobileqq.structmsg.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler.ReportInfo;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.ecshop.temp.api.impl.EcshopMessageApiImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class StructMsgItemLayout20
  extends AbsStructMsgItem
{
  boolean aA;
  String aB;
  String aC;
  String aD;
  String az;
  
  View a(View paramView, Context paramContext, String paramString)
  {
    try
    {
      i = Integer.parseInt(this.az);
    }
    catch (Exception localException)
    {
      int i;
      label12:
      Object localObject;
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      int j;
      break label12;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("content type:");
    ((StringBuilder)localObject).append(this.az);
    QLog.e("StructMsgItemLayout20", 1, ((StringBuilder)localObject).toString());
    i = 0;
    if (paramView == null)
    {
      localObject = new StructMsgItemLayout20.Holder(this);
      paramView = View.inflate(paramContext, 2131628309, null);
      ((StructMsgItemLayout20.Holder)localObject).a = ((SingleLineTextView)paramView.findViewById(2131439121));
      ((StructMsgItemLayout20.Holder)localObject).b = ((ImageView)paramView.findViewById(2131435219));
      ((StructMsgItemLayout20.Holder)localObject).c = ((TextView)paramView.findViewById(2131433513));
      ((StructMsgItemLayout20.Holder)localObject).d = paramView.findViewById(2131437622);
      paramView.setTag(localObject);
    }
    else
    {
      localObject = (StructMsgItemLayout20.Holder)paramView.getTag();
    }
    ((StructMsgItemLayout20.Holder)localObject).a.setText(paramString);
    if (i == 1)
    {
      ((StructMsgItemLayout20.Holder)localObject).b.setVisibility(8);
      ((StructMsgItemLayout20.Holder)localObject).a.setTextColor(Color.parseColor("#777777"));
      ((StructMsgItemLayout20.Holder)localObject).a.setTextSize(14.0F);
      ((StructMsgItemLayout20.Holder)localObject).a.setCompoundDrawables(null, null);
      ((StructMsgItemLayout20.Holder)localObject).c.setText(this.aC);
      ((StructMsgItemLayout20.Holder)localObject).c.setEnabled(true);
      ((StructMsgItemLayout20.Holder)localObject).c.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839496));
      paramView.setTag(2131442952, this.d);
      ((StructMsgItemLayout20.Holder)localObject).c.setTag(2131442952, this.d);
    }
    else if (i == 0)
    {
      ((StructMsgItemLayout20.Holder)localObject).b.setVisibility(0);
      paramString = paramContext.getResources().getDrawable(2130841060);
      if (!TextUtils.isEmpty(this.aB))
      {
        i = AIOUtils.b(40.0F, paramContext.getResources());
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = paramString;
        localURLDrawableOptions.mFailedDrawable = paramString;
        paramString = URLDrawable.getDrawable(this.aB, localURLDrawableOptions);
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        paramString.setTag(URLDrawableDecodeHandler.b(i, i, i / 2));
        paramString.setDecodeHandler(URLDrawableDecodeHandler.d);
        ((StructMsgItemLayout20.Holder)localObject).b.setImageDrawable(paramString);
      }
      else
      {
        ((StructMsgItemLayout20.Holder)localObject).b.setImageDrawable(paramString);
      }
      if (this.aA)
      {
        paramString = paramContext.getResources().getDrawable(2130842755);
        ((StructMsgItemLayout20.Holder)localObject).a.setCompoundDrawablePadding(AIOUtils.b(3.0F, paramContext.getResources()));
        paramString.setBounds(0, 0, AIOUtils.b(15.0F, paramContext.getResources()), AIOUtils.b(15.0F, paramContext.getResources()));
        ((StructMsgItemLayout20.Holder)localObject).a.setCompoundDrawables(null, paramString);
      }
      else
      {
        ((StructMsgItemLayout20.Holder)localObject).a.setCompoundDrawables(null, null);
      }
      ((StructMsgItemLayout20.Holder)localObject).a.setTextColor(Color.parseColor("#000000"));
      ((StructMsgItemLayout20.Holder)localObject).a.setTextSize(17.0F);
      ((StructMsgItemLayout20.Holder)localObject).c.setTag(localObject);
      if (((IPublicAccountDataManager)((BaseActivity)paramContext).app.getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(Long.parseLong(this.aD))))
      {
        ((StructMsgItemLayout20.Holder)localObject).c.setBackgroundDrawable(null);
        ((StructMsgItemLayout20.Holder)localObject).c.setText(HardCodeUtil.a(2131911904));
        ((StructMsgItemLayout20.Holder)localObject).c.setEnabled(false);
      }
      else
      {
        ((StructMsgItemLayout20.Holder)localObject).c.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839496));
        ((StructMsgItemLayout20.Holder)localObject).c.setText(HardCodeUtil.a(2131899712));
        ((StructMsgItemLayout20.Holder)localObject).c.setEnabled(true);
      }
      paramView.setTag(2131442954, this.aD);
      ((StructMsgItemLayout20.Holder)localObject).c.setTag(2131442954, this.aD);
    }
    i = AIOUtils.b(17.0F, paramContext.getResources());
    j = AIOUtils.b(16.0F, paramContext.getResources());
    ((StructMsgItemLayout20.Holder)localObject).c.setPadding(j, 0, j, 0);
    ((StructMsgItemLayout20.Holder)localObject).c.post(new StructMsgItemLayout20.1(this, i, (StructMsgItemLayout20.Holder)localObject));
    paramView.setOnClickListener(this);
    ((StructMsgItemLayout20.Holder)localObject).c.setOnClickListener(this);
    return paramView;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    f();
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    super.a(paramStructMsgNode);
    f();
    return true;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramBundle = (LinearLayout)paramView;
      if (paramBundle.getChildCount() == this.ax.size())
      {
        int i = 0;
        localIterator = this.ax.iterator();
        for (;;)
        {
          paramView = paramBundle;
          if (!localIterator.hasNext()) {
            break;
          }
          paramView = (AbsStructMsgElement)localIterator.next();
          paramView.ar = this.ar;
          if ("content".equals(paramView.b))
          {
            paramView = ((StructMsgItemContent)paramView).aA;
            a(paramBundle.getChildAt(i), paramContext, paramView);
            return paramBundle;
          }
          i += 1;
        }
      }
    }
    paramBundle = new LinearLayout(paramContext);
    Iterator localIterator = this.ax.iterator();
    for (;;)
    {
      paramView = paramBundle;
      if (!localIterator.hasNext()) {
        break;
      }
      paramView = (AbsStructMsgElement)localIterator.next();
      paramView.ar = this.ar;
      if (("content".equals(paramView.b)) && ((paramView instanceof StructMsgItemContent))) {
        paramBundle.addView(a(null, paramContext, ((StructMsgItemContent)paramView).aA), new LinearLayout.LayoutParams(-1, -2));
      }
    }
    return paramView;
  }
  
  protected int c()
  {
    return 20;
  }
  
  public String e()
  {
    return "Layout20";
  }
  
  void f()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.j);
        this.az = localJSONObject.optString("contentType");
        if (localJSONObject.optInt("isCert") == 1)
        {
          bool = true;
          this.aA = bool;
          this.aB = localJSONObject.optString("faceUrl");
          this.aC = localJSONObject.optString("btnText");
          this.aD = localJSONObject.optString("puin");
          return;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception:");
        localStringBuilder.append(localException);
        QLog.e("StructMsgItemLayout20", 1, localStringBuilder.toString());
        return;
      }
      boolean bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = Integer.parseInt(this.az);
    localObject3 = paramView.getContext();
    Object localObject4;
    if ((localObject3 instanceof BaseActivity))
    {
      localObject2 = (BaseActivity)localObject3;
      localObject1 = ((BaseActivity)localObject2).getChatFragment();
      if (localObject1 != null) {
        localObject1 = ((ChatFragment)localObject1).j();
      }
      for (;;)
      {
        break;
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject1 instanceof QQAppInterface)) {
          localObject1 = (QQAppInterface)localObject1;
        } else {
          localObject1 = null;
        }
      }
      if (localObject1 != null)
      {
        localObject4 = (EcshopReportHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
        if (i == 1)
        {
          if (((IEcshopReportApi)QRoute.api(IEcshopReportApi.class)).isReportForClick(this.ak))
          {
            EcshopMessageApiImpl.enterGdtCanvasActivity((BaseQQAppInterface)localObject1, this, (Activity)localObject3);
            break label558;
          }
          localObject2 = (String)paramView.getTag(2131442952);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label558;
          }
          localObject4 = new Intent((Context)localObject3, QQBrowserActivity.class);
          ((Intent)localObject4).putExtra("url", (String)localObject2);
          ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
          ((Intent)localObject4).putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.ap));
          ((Context)localObject3).startActivity((Intent)localObject4);
        }
      }
    }
    try
    {
      if (this.as == null) {
        break label558;
      }
      localObject2 = new IEcshopAdHandler.ReportInfo();
      ((IEcshopAdHandler.ReportInfo)localObject2).a = 6;
      localObject2 = ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).rebuildReportParam((IEcshopAdHandler.ReportInfo)localObject2, this.as.message);
      ((IEcshopAdHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a((IEcshopAdHandler.ReportInfo)localObject2, null);
    }
    catch (Exception localException1)
    {
      try
      {
        Object localObject5;
        ((IEcshopAdHandler.ReportInfo)localObject2).t = Long.parseLong((String)localObject3);
        localObject2 = ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).rebuildReportParam((IEcshopAdHandler.ReportInfo)localObject2, this.as.message);
        ((IEcshopAdHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a((IEcshopAdHandler.ReportInfo)localObject2, null);
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localException1 = localException1;
        }
      }
      catch (Exception localException2)
      {
        break label515;
      }
    }
    if (i == 0)
    {
      localObject3 = (String)paramView.getTag(2131442954);
      if (paramView.getId() == 2131430424)
      {
        localObject5 = new Intent();
        ((Intent)localObject5).putExtra("source", 115);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfile((Intent)localObject5, (AppInterface)localObject1, (Context)localObject2, (String)localObject3, -5);
        ((EcshopReportHandler)localObject4).a(134247086, this.as.uin, this.as.message.getExtInfoFromExtStr("public_account_msg_id"), null, null, Long.parseLong((String)localObject3), false);
      }
      else if (paramView.getId() == 2131433513)
      {
        localObject4 = (StructMsgItemLayout20.Holder)paramView.getTag();
        ((StructMsgItemLayout20.Holder)localObject4).c.setVisibility(4);
        ((StructMsgItemLayout20.Holder)localObject4).d.setVisibility(0);
        localObject5 = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
        ((IPublicAccountObserver)localObject5).setOnCallback(new StructMsgItemLayout20.PubObserverCallback(this, (StructMsgItemLayout20.Holder)localObject4));
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin((AppInterface)localObject1, (Context)localObject2, (String)localObject3, (IPublicAccountObserver)localObject5, true, 3);
        localObject2 = new IEcshopAdHandler.ReportInfo();
        ((IEcshopAdHandler.ReportInfo)localObject2).a = 5;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20
 * JD-Core Version:    0.7.0.1
 */