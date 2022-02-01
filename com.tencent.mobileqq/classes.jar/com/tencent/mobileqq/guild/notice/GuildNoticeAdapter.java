package com.tencent.mobileqq.guild.notice;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.data.QQGuildDTConstant;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice.GuildNoticeAction;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice.GuildNoticeCover;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice.GuildNoticeText;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.FadeIconImageView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GuildNoticeAdapter
  extends BaseAdapter
{
  private final int a = 1;
  private final int b = 2;
  private final int c = 7;
  private GuildMainViewContext d;
  private List<GuildNotice> e = new ArrayList();
  private GuildNoticeViewModel f;
  
  public GuildNoticeAdapter(GuildMainViewContext paramGuildMainViewContext)
  {
    this.d = paramGuildMainViewContext;
  }
  
  private Drawable a(GuildNotice paramGuildNotice)
  {
    IQQGuildAvatarApi localIQQGuildAvatarApi = (IQQGuildAvatarApi)this.d.b().getAppRuntime().getRuntimeService(IQQGuildAvatarApi.class, "");
    Drawable localDrawable = this.d.b().getResources().getDrawable(2130840970);
    if (paramGuildNotice.g.a == 1) {
      return localIQQGuildAvatarApi.getAvatarDrawable(paramGuildNotice.g.c, 0, true);
    }
    if (paramGuildNotice.g.a == 2) {
      localDrawable = localIQQGuildAvatarApi.getAvatarDrawable(this.d.a(), String.valueOf(paramGuildNotice.g.b));
    }
    return localDrawable;
  }
  
  private View a(Context paramContext, long paramLong)
  {
    paramContext = new TextView(paramContext);
    paramContext.setText(a(paramLong));
    paramContext.setTextColor(Color.parseColor("#FFB0B3BF"));
    paramContext.setTextSize(10.0F);
    paramContext.setPadding(0, 0, ViewUtils.dip2px(18.0F), 0);
    return paramContext;
  }
  
  private View a(Context paramContext, GuildNotice.GuildNoticeAction paramGuildNoticeAction, GuildNotice paramGuildNotice)
  {
    paramContext = new FadeIconImageView(paramContext);
    paramContext.setTag(Integer.valueOf(paramGuildNoticeAction.a));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(29.0F), ViewUtils.dpToPx(29.0F));
    if (paramGuildNoticeAction.a == 1)
    {
      paramContext.setImageResource(2130840968);
      localLayoutParams.setMargins(0, 0, ViewUtils.dpToPx(14.0F), 0);
      QQGuildUtil.a(paramContext, "em_sgrp_auditnotification_refuse", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    }
    else if (paramGuildNoticeAction.a == 2)
    {
      paramContext.setImageResource(2130840969);
      localLayoutParams.setMargins(0, 0, ViewUtils.dpToPx(18.0F), 0);
      QQGuildUtil.a(paramContext, "em_sgrp_auditnotification_agree", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    }
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setOnClickListener(new GuildNoticeAdapter.2(this, paramGuildNotice, paramGuildNoticeAction, paramContext));
    return paramContext;
  }
  
  private String a(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat("MM-dd");
    SimpleDateFormat localSimpleDateFormat3 = new SimpleDateFormat("HH:mm");
    Date localDate1 = new Date(paramLong * 1000L);
    Date localDate2 = new Date(NetConnInfoCenter.getServerTime() * 1000L);
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.setTime(localDate1);
    localCalendar2.setTime(localDate2);
    if ((!localDate1.after(localDate2)) && (localCalendar1.get(1) == localCalendar2.get(1)))
    {
      int i = localCalendar1.get(6);
      if (localCalendar2.get(6) == i) {
        return localSimpleDateFormat3.format(localDate1);
      }
      return localSimpleDateFormat2.format(localDate1);
    }
    return localSimpleDateFormat1.format(localDate1);
  }
  
  private Map<String, Object> a(String paramString)
  {
    Object localObject = ((IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString);
    HashMap localHashMap = new HashMap();
    if (paramString == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setDtElement guildInfo get is null, guildId=");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("GuildNoticeAdapter", 2, ((StringBuilder)localObject).toString());
      }
      return localHashMap;
    }
    localHashMap.put("sgrp_channel_id", paramString);
    localHashMap.put("sgrp_user_type", Integer.valueOf(QQGuildDTConstant.a(((IGProGuildInfo)localObject).getUserType())));
    return localHashMap;
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout, GuildNotice paramGuildNotice)
  {
    paramLinearLayout.removeAllViews();
    if (paramGuildNotice.k == null) {
      return;
    }
    if (paramGuildNotice.k.size() == 0)
    {
      paramLinearLayout.addView(a(paramContext, paramGuildNotice.c));
      return;
    }
    int i = 0;
    while (i < paramGuildNotice.k.size())
    {
      paramLinearLayout.addView(a(paramContext, (GuildNotice.GuildNoticeAction)paramGuildNotice.k.get(i), paramGuildNotice));
      i += 1;
    }
  }
  
  private void a(GuildNotice paramGuildNotice, GuildNoticeAdapter.ViewHolder paramViewHolder)
  {
    IGPSService localIGPSService = (IGPSService)this.d.a().getRuntimeService(IGPSService.class, "");
    String str1 = localIGPSService.getGuildName(paramGuildNotice.f);
    String str2 = localIGPSService.getGuildAvatarUrl(paramGuildNotice.f, 100);
    if ((str1 != null) && (str2 != null))
    {
      paramGuildNotice = ((IQQGuildAvatarApi)this.d.b().getAppRuntime().getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(str2, 0, true);
      GuildNoticeAdapter.ViewHolder.b(paramViewHolder).setImageDrawable(paramGuildNotice);
      if (TextUtils.isEmpty(str1))
      {
        GuildNoticeAdapter.ViewHolder.c(paramViewHolder).setText(2131890525);
        return;
      }
      GuildNoticeAdapter.ViewHolder.c(paramViewHolder).setText(str1);
      return;
    }
    localIGPSService.fetchGuildInfoForGuest(paramGuildNotice.f, new GuildNoticeAdapter.InnerGuildInfoCallback(paramViewHolder, this.d, paramGuildNotice.f));
  }
  
  private String b(GuildNotice paramGuildNotice)
  {
    if (((GuildNotice.GuildNoticeText)paramGuildNotice.h.get(0)).a == 1) {
      return ((GuildNotice.GuildNoticeText)paramGuildNotice.h.get(0)).c;
    }
    if (((GuildNotice.GuildNoticeText)paramGuildNotice.h.get(0)).a == 2) {
      return ((IGPSService)QQGuildUtil.a(IGPSService.class, "")).getGuildUserNick(String.valueOf(((GuildNotice.GuildNoticeText)paramGuildNotice.h.get(0)).b));
    }
    return "";
  }
  
  private String c(GuildNotice paramGuildNotice)
  {
    if (paramGuildNotice.i != null)
    {
      Iterator localIterator = paramGuildNotice.i.iterator();
      paramGuildNotice = "";
      for (;;)
      {
        localObject1 = paramGuildNotice;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (GuildNotice.GuildNoticeText)localIterator.next();
        Object localObject2;
        if (((GuildNotice.GuildNoticeText)localObject1).a == 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramGuildNotice);
          ((StringBuilder)localObject2).append(((GuildNotice.GuildNoticeText)localObject1).c);
          paramGuildNotice = ((StringBuilder)localObject2).toString();
        }
        else if (((GuildNotice.GuildNoticeText)localObject1).a == 3)
        {
          localObject2 = (IGPSService)this.d.a().getRuntimeService(IGPSService.class, "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((GuildNotice.GuildNoticeText)localObject1).b);
          localStringBuilder.append("");
          localObject1 = ((IGPSService)localObject2).getGuildInfo(localStringBuilder.toString());
          if (localObject1 != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramGuildNotice);
            ((StringBuilder)localObject2).append(((IGProGuildInfo)localObject1).getGuildName());
            paramGuildNotice = ((StringBuilder)localObject2).toString();
          }
        }
      }
    }
    Object localObject1 = "";
    return localObject1;
  }
  
  public GuildNotice a(int paramInt)
  {
    if (paramInt < this.e.size()) {
      return (GuildNotice)this.e.get(paramInt);
    }
    throw new IndexOutOfBoundsException("ChannelNoticeAdapter is IndexOutOfBoundsException");
  }
  
  public void a(GuildNoticeViewModel paramGuildNoticeViewModel)
  {
    this.f = paramGuildNoticeViewModel;
  }
  
  public void a(@NonNull List<GuildNotice> paramList)
  {
    this.e = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.e.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625101, null);
      paramView = new GuildNoticeAdapter.ViewHolder(null);
      GuildNoticeAdapter.ViewHolder.a(paramView, (RoundImageView)localView.findViewById(2131434619));
      GuildNoticeAdapter.ViewHolder.a(paramView, (TextView)localView.findViewById(2131434758));
      GuildNoticeAdapter.ViewHolder.b(paramView, (TextView)localView.findViewById(2131434757));
      GuildNoticeAdapter.ViewHolder.a(paramView).getPaint().setFakeBoldText(true);
      GuildNoticeAdapter.ViewHolder.c(paramView, (TextView)localView.findViewById(2131434756));
      GuildNoticeAdapter.ViewHolder.a(paramView, (LinearLayout)localView.findViewById(2131434683));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (GuildNoticeAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = a(paramInt);
    if ((((GuildNotice)localObject).g.a != 3) && (((GuildNotice.GuildNoticeText)((GuildNotice)localObject).h.get(0)).a != 3))
    {
      GuildNoticeAdapter.ViewHolder.b(paramView).setImageDrawable(a((GuildNotice)localObject));
      GuildNoticeAdapter.ViewHolder.c(paramView).setText(b((GuildNotice)localObject));
    }
    else
    {
      a((GuildNotice)localObject, paramView);
    }
    GuildNoticeAdapter.ViewHolder.b(paramView).setmRadius(ViewUtils.dpToPx(24.0F), false);
    GuildNoticeAdapter.ViewHolder.c(paramView).getPaint().setFakeBoldText(true);
    GuildNoticeAdapter.ViewHolder.a(paramView).setText(c((GuildNotice)localObject));
    GuildNoticeAdapter.ViewHolder.a(paramView).getPaint().setFakeBoldText(true);
    GuildNoticeAdapter.ViewHolder.d(paramView).setText(((GuildNotice.GuildNoticeText)((GuildNotice)localObject).j.get(0)).c);
    a(paramViewGroup.getContext(), GuildNoticeAdapter.ViewHolder.e(paramView), (GuildNotice)localObject);
    localView.setOnClickListener(new GuildNoticeAdapter.1(this, (GuildNotice)localObject));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeAdapter
 * JD-Core Version:    0.7.0.1
 */