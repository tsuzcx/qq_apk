package com.tencent.mobileqq.guild.main.item;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.guild.main.AppTroopItemShowManager;
import com.tencent.mobileqq.guild.main.IChannelListControl;
import com.tencent.mobileqq.guild.main.data.QQChannelItemData;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelApp;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IBaseChnnPreItemInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.ITextChannelPreInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QQGuildAppChannelBuilder
  extends QQGuildChannelItemBuilder
{
  private List<IBaseChnnPreItemInfo> a(List<IBaseChnnPreItemInfo> paramList1, List<IBaseChnnPreItemInfo> paramList2)
  {
    if ((paramList1 != null) && (paramList1.size() != 0) && (paramList2 != null))
    {
      if (paramList2.size() == 0) {
        return paramList1;
      }
      int i = paramList1.size();
      int j = paramList2.size();
      if (i <= j) {
        return paramList2.subList(0, i);
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramList2);
      localArrayList.addAll(paramList1.subList(j, i));
      return localArrayList;
    }
    return paramList1;
  }
  
  private void a(LinearLayout paramLinearLayout, List<IBaseChnnPreItemInfo> paramList, Context paramContext)
  {
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    int k = paramLinearLayout.getChildCount();
    int j = k;
    if (k > i)
    {
      paramLinearLayout.removeViews(i, k - i);
      j = k;
    }
    while (j < i)
    {
      paramLinearLayout.addView(LayoutInflater.from(paramContext).inflate(2131625017, null));
      j += 1;
    }
    j = 0;
    while (j < i)
    {
      Object localObject = paramLinearLayout.getChildAt(j);
      paramContext = (TextView)((View)localObject).findViewById(2131439548);
      localObject = (TextView)((View)localObject).findViewById(2131439261);
      paramContext.setVisibility(0);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(((ITextChannelPreInfo)paramList.get(j)).b());
      j += 1;
    }
  }
  
  private void a(LinearLayout paramLinearLayout, List<IBaseChnnPreItemInfo> paramList, QQGuildChannelApp paramQQGuildChannelApp)
  {
    int i = 0;
    while (i < paramLinearLayout.getChildCount())
    {
      paramLinearLayout.getChildAt(i).setOnClickListener(new QQGuildAppChannelBuilder.2(this, (ITextChannelPreInfo)paramList.get(i), paramQQGuildChannelApp));
      i += 1;
    }
  }
  
  private void a(LinearLayout paramLinearLayout, List<IBaseChnnPreItemInfo> paramList1, List<IBaseChnnPreItemInfo> paramList2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramList1.size())
    {
      ITextChannelPreInfo localITextChannelPreInfo1 = (ITextChannelPreInfo)paramList1.get(i);
      ITextChannelPreInfo localITextChannelPreInfo2 = (ITextChannelPreInfo)paramList2.get(i);
      if ((!TextUtils.equals(localITextChannelPreInfo1.a(), localITextChannelPreInfo2.a())) || (!TextUtils.equals(localITextChannelPreInfo1.b(), localITextChannelPreInfo2.b())))
      {
        Object localObject = paramLinearLayout.getChildAt(i);
        TextView localTextView = (TextView)((View)localObject).findViewById(2131439548);
        localObject = (TextView)((View)localObject).findViewById(2131439261);
        localTextView.setText(localITextChannelPreInfo1.b());
        ((TextView)localObject).setText(localITextChannelPreInfo2.b());
        localArrayList1.add(localTextView);
        localArrayList2.add(localObject);
      }
      i += 1;
    }
    if (localArrayList1.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQGuildAppChannelBuilder", 1, "no need animate");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildAppChannelBuilder", 1, "start animate");
    }
    paramLinearLayout = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramLinearLayout.addUpdateListener(new QQGuildAppChannelBuilder.1(this, localArrayList1, localArrayList2));
    paramLinearLayout.setDuration(500L);
    paramLinearLayout.start();
  }
  
  private void a(QQGuildAppChannelBuilder.ChannelHolder paramChannelHolder, String paramString, QQGuildChannelApp paramQQGuildChannelApp, Context paramContext)
  {
    AppTroopItemShowManager localAppTroopItemShowManager = AppTroopItemShowManager.a();
    Object localObject = localAppTroopItemShowManager.c(paramString);
    a(QQGuildAppChannelBuilder.ChannelHolder.e(paramChannelHolder), (List)localObject, paramContext);
    if (!localAppTroopItemShowManager.b(paramString)) {
      return;
    }
    if (localAppTroopItemShowManager.a(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("first show troop， channelId：");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("QQGuildAppChannelBuilder", 1, ((StringBuilder)localObject).toString());
      }
      a(QQGuildAppChannelBuilder.ChannelHolder.e(paramChannelHolder), paramQQGuildChannelApp.d(), paramContext);
      localAppTroopItemShowManager.a(paramString, paramQQGuildChannelApp.d());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildAppChannelBuilder", 1, "show old data first");
    }
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      paramQQGuildChannelApp = a((List)localObject, paramQQGuildChannelApp.d());
      a(QQGuildAppChannelBuilder.ChannelHolder.e(paramChannelHolder), (List)localObject, paramQQGuildChannelApp);
      localAppTroopItemShowManager.a(paramString, paramQQGuildChannelApp);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramChannelHolder = new StringBuilder();
      paramChannelHolder.append("old data is empty， channelId：");
      paramChannelHolder.append(paramString);
      QLog.i("QQGuildAppChannelBuilder", 1, paramChannelHolder.toString());
    }
  }
  
  public View a(int paramInt, Object paramObject, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(paramContext).inflate(2131624999, null);
      paramView = new QQGuildAppChannelBuilder.ChannelHolder(null);
      QQGuildAppChannelBuilder.ChannelHolder.a(paramView, (RelativeLayout)paramViewGroup.findViewById(2131430501));
      QQGuildAppChannelBuilder.ChannelHolder.a(paramView, (ImageView)paramViewGroup.findViewById(2131435219));
      QQGuildAppChannelBuilder.ChannelHolder.a(paramView, (TextView)paramViewGroup.findViewById(2131430506));
      QQGuildAppChannelBuilder.ChannelHolder.b(paramView, (TextView)paramViewGroup.findViewById(2131430512));
      QQGuildAppChannelBuilder.ChannelHolder.a(paramView, (LinearLayout)paramViewGroup.findViewById(2131447920));
      paramViewGroup.setTag(paramView);
    }
    else
    {
      paramContext = (QQGuildAppChannelBuilder.ChannelHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramContext;
    }
    QQGuildAppChannelBuilder.ChannelHolder.a(paramView).setTag(2131434556, paramObject);
    QQGuildAppChannelBuilder.ChannelHolder.a(paramView).setOnClickListener(paramOnClickListener);
    return paramViewGroup;
  }
  
  public void a(View paramView, int paramInt, QQChannelItemData paramQQChannelItemData, Context paramContext)
  {
    if (!(paramQQChannelItemData instanceof QQGuildChannelApp)) {
      return;
    }
    paramQQChannelItemData = (QQGuildChannelApp)paramQQChannelItemData;
    String str = paramQQChannelItemData.a().getChannelUin();
    paramView = (QQGuildAppChannelBuilder.ChannelHolder)paramView.getTag();
    QQGuildAppChannelBuilder.ChannelHolder.b(paramView).setText(paramQQChannelItemData.a().getChannelName());
    QQGuildAppChannelBuilder.ChannelHolder.c(paramView).setText(paramQQChannelItemData.e());
    if (TextUtils.equals(this.a.a(), paramQQChannelItemData.a().getChannelUin()))
    {
      QQGuildAppChannelBuilder.ChannelHolder.a(paramView).setBackgroundDrawable(paramContext.getResources().getDrawable(2130840760));
      QQGuildAppChannelBuilder.ChannelHolder.b(paramView).setTextColor(Color.rgb(34, 34, 34));
      QQGuildAppChannelBuilder.ChannelHolder.d(paramView).setImageResource(2130840668);
    }
    else
    {
      QQGuildAppChannelBuilder.ChannelHolder.a(paramView).setBackgroundDrawable(paramContext.getResources().getDrawable(2130840758));
      QQGuildAppChannelBuilder.ChannelHolder.b(paramView).setTextColor(Color.rgb(34, 34, 34));
      QQGuildAppChannelBuilder.ChannelHolder.d(paramView).setImageResource(2130840668);
    }
    a(paramView, str, paramQQChannelItemData, paramContext);
    a(QQGuildAppChannelBuilder.ChannelHolder.e(paramView), AppTroopItemShowManager.a().c(str), paramQQChannelItemData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.item.QQGuildAppChannelBuilder
 * JD-Core Version:    0.7.0.1
 */