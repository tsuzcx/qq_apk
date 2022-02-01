package com.tencent.mobileqq.guild.main.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.config.QQGuildConfigBean;
import com.tencent.mobileqq.guild.main.IChannelListControl;
import com.tencent.mobileqq.guild.main.data.QQChannelItemData;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelVoice;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QQGuildVoiceChannelBuilder
  extends QQGuildChannelItemBuilder
{
  public static void a(AppInterface paramAppInterface, QQGuildVoiceChannelBuilder.ChannelHolder paramChannelHolder, String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramGuildUserAvatar != null))
    {
      if (paramChannelHolder == null) {
        return;
      }
      int i = 0;
      while (i < QQGuildVoiceChannelBuilder.ChannelHolder.a(paramChannelHolder).length)
      {
        ImageView localImageView = QQGuildVoiceChannelBuilder.ChannelHolder.a(paramChannelHolder)[i];
        if (TextUtils.equals(paramString, (String)localImageView.getTag()))
        {
          localImageView.setVisibility(0);
          localImageView.setImageDrawable(((IQQGuildAvatarApi)paramAppInterface.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramAppInterface, paramGuildUserAvatar, 0));
          return;
        }
        i += 1;
      }
    }
  }
  
  public View a(int paramInt, Object paramObject, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if (paramView != null)
    {
      paramObject = paramView;
      if ((paramView.getTag() instanceof QQGuildVoiceChannelBuilder.ChannelHolder)) {}
    }
    else
    {
      paramObject = LayoutInflater.from(paramContext).inflate(2131625018, null);
      paramView = new QQGuildVoiceChannelBuilder.ChannelHolder();
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView, (RelativeLayout)paramObject.findViewById(2131445152));
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView, (ImageView)paramObject.findViewById(2131435219));
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView, (TextView)paramObject.findViewById(2131430505));
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView, paramObject.findViewById(2131437510));
      QQGuildVoiceChannelBuilder.ChannelHolder.b(paramView, (TextView)paramObject.findViewById(2131448626));
      QQGuildVoiceChannelBuilder.ChannelHolder.c(paramView, (TextView)paramObject.findViewById(2131448578));
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView, new ImageView[8]);
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView)[0] = ((ImageView)paramObject.findViewById(2131429026));
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView)[1] = ((ImageView)paramObject.findViewById(2131429027));
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView)[2] = ((ImageView)paramObject.findViewById(2131429028));
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView)[3] = ((ImageView)paramObject.findViewById(2131429029));
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView)[4] = ((ImageView)paramObject.findViewById(2131429030));
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView)[5] = ((ImageView)paramObject.findViewById(2131429031));
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView)[6] = ((ImageView)paramObject.findViewById(2131429032));
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView)[7] = ((ImageView)paramObject.findViewById(2131429033));
      QQGuildVoiceChannelBuilder.ChannelHolder.d(paramView, (TextView)paramObject.findViewById(2131437987));
      QQGuildVoiceChannelBuilder.ChannelHolder.b(paramView, (RelativeLayout)paramObject.findViewById(2131431301));
      QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView, (LinearLayout)paramObject.findViewById(2131431310));
      paramObject.setTag(paramView);
    }
    paramObject.setOnClickListener(paramOnClickListener);
    return paramObject;
  }
  
  public void a(View paramView, int paramInt, QQChannelItemData paramQQChannelItemData, Context paramContext)
  {
    if (!(paramQQChannelItemData instanceof QQGuildChannelVoice)) {
      return;
    }
    paramQQChannelItemData = (QQGuildChannelVoice)paramQQChannelItemData;
    Object localObject1 = paramQQChannelItemData.a();
    paramView = (QQGuildVoiceChannelBuilder.ChannelHolder)paramView.getTag();
    QQGuildVoiceChannelBuilder.ChannelHolder.b(paramView).setText(((IGProChannelInfo)localObject1).getChannelName());
    if (TextUtils.equals(this.a.a(), paramQQChannelItemData.a().getChannelUin()))
    {
      QQGuildVoiceChannelBuilder.ChannelHolder.c(paramView).setBackgroundDrawable(paramContext.getResources().getDrawable(2130840760));
      QQGuildVoiceChannelBuilder.ChannelHolder.b(paramView).setTextColor(Color.rgb(34, 34, 34));
      QQGuildVoiceChannelBuilder.ChannelHolder.d(paramView).setImageResource(2130841053);
    }
    else
    {
      QQGuildVoiceChannelBuilder.ChannelHolder.c(paramView).setBackgroundDrawable(paramContext.getResources().getDrawable(2130840758));
      QQGuildVoiceChannelBuilder.ChannelHolder.b(paramView).setTextColor(Color.rgb(34, 34, 34));
      QQGuildVoiceChannelBuilder.ChannelHolder.d(paramView).setImageResource(2130841053);
    }
    int i = paramQQChannelItemData.c();
    localObject1 = QQGuildVoiceChannelBuilder.ChannelHolder.e(paramView).getLayoutParams();
    if (i == 0)
    {
      QQGuildVoiceChannelBuilder.ChannelHolder.f(paramView).setVisibility(8);
      ((ViewGroup.LayoutParams)localObject1).height = ViewUtils.dip2px(40.0F);
    }
    else
    {
      QQGuildVoiceChannelBuilder.ChannelHolder.f(paramView).setVisibility(0);
      ((ViewGroup.LayoutParams)localObject1).height = ViewUtils.dip2px(40.0F);
    }
    QQGuildVoiceChannelBuilder.ChannelHolder.e(paramView).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    if (i > 8) {
      QQGuildVoiceChannelBuilder.ChannelHolder.g(paramView).setText(String.format("+%s", new Object[] { Integer.valueOf(i - 8) }));
    } else {
      QQGuildVoiceChannelBuilder.ChannelHolder.g(paramView).setText("");
    }
    paramInt = paramQQChannelItemData.d();
    Object localObject2;
    if (paramInt >= QQGuildUtil.c().h)
    {
      QQGuildVoiceChannelBuilder.ChannelHolder.h(paramView).setVisibility(8);
    }
    else
    {
      QQGuildVoiceChannelBuilder.ChannelHolder.h(paramView).setVisibility(0);
      paramContext = Typeface.createFromAsset(paramContext.getAssets(), "guild_number.ttf");
      QQGuildVoiceChannelBuilder.ChannelHolder.i(paramView).setTypeface(paramContext);
      localObject1 = QQGuildVoiceChannelBuilder.ChannelHolder.i(paramView);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(i);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      QQGuildVoiceChannelBuilder.ChannelHolder.j(paramView).setTypeface(paramContext);
      paramContext = QQGuildVoiceChannelBuilder.ChannelHolder.j(paramView);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramInt);
      paramContext.setText(((StringBuilder)localObject1).toString());
    }
    paramContext = QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView);
    int j = paramContext.length;
    paramInt = 0;
    while (paramInt < j)
    {
      localObject1 = paramContext[paramInt];
      ((ImageView)localObject1).setTag(null);
      ((ImageView)localObject1).setVisibility(8);
      paramInt += 1;
    }
    QQGuildVoiceChannelBuilder.ChannelHolder.g(paramView).setVisibility(8);
    paramQQChannelItemData = paramQQChannelItemData.e();
    if ((paramQQChannelItemData != null) && (paramQQChannelItemData.size() > 0))
    {
      paramContext = new ArrayList();
      j = Math.min(paramQQChannelItemData.size(), 8);
      paramInt = 0;
      while (paramInt < j)
      {
        localObject1 = ((IGProUserInfo)paramQQChannelItemData.get(paramInt)).a();
        QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView)[paramInt].setVisibility(0);
        QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView)[paramInt].setTag(localObject1);
        paramContext.add(localObject1);
        paramInt += 1;
      }
      paramQQChannelItemData = this.a.b();
      paramContext = ((IGPSService)paramQQChannelItemData.getRuntimeService(IGPSService.class, "")).getGuildUsersAvatarUrls(paramContext);
      paramInt = 0;
      while (paramInt < QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView).length)
      {
        localObject1 = QQGuildVoiceChannelBuilder.ChannelHolder.a(paramView)[paramInt];
        localObject2 = (String)((ImageView)localObject1).getTag();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((ImageView)localObject1).setVisibility(0);
          if ((paramContext != null) && (paramContext.containsKey(localObject2))) {
            ((ImageView)localObject1).setImageDrawable(((IQQGuildAvatarApi)paramQQChannelItemData.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramQQChannelItemData, (GuildUserAvatar)paramContext.get(localObject2), 0));
          } else {
            ((ImageView)localObject1).setImageDrawable(((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true));
          }
          if ((paramInt == 7) && (i > 8)) {
            QQGuildVoiceChannelBuilder.ChannelHolder.g(paramView).setVisibility(0);
          }
        }
        else
        {
          ((ImageView)localObject1).setVisibility(8);
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.item.QQGuildVoiceChannelBuilder
 * JD-Core Version:    0.7.0.1
 */