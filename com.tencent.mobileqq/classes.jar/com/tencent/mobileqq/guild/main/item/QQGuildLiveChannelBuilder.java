package com.tencent.mobileqq.guild.main.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.main.IChannelListControl;
import com.tencent.mobileqq.guild.main.data.QQChannelItemData;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelLive;
import com.tencent.mobileqq.guild.mainframe.ui.GuildDragTextView;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;

public class QQGuildLiveChannelBuilder
  extends QQGuildChannelItemBuilder
{
  private void a(Context paramContext, View paramView, GuildDragTextView paramGuildDragTextView, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 1)
    {
      paramGuildDragTextView.setDragViewType(0, paramView);
      paramGuildDragTextView.setTextColor(paramContext.getResources().getColor(2131168174));
      paramInt1 = 3;
      i = 2130840762;
    }
    else if (paramInt1 == 2)
    {
      paramGuildDragTextView.setDragViewType(1, paramView);
      paramInt1 = 3;
      i = 2130840761;
    }
    else
    {
      paramGuildDragTextView.setDragViewType(-1, paramView);
      paramInt1 = 0;
      i = 0;
    }
    paramGuildDragTextView.setTypeface(Typeface.createFromAsset(paramContext.getAssets(), "guild_number.ttf"));
    CustomWidgetUtil.a(paramGuildDragTextView, paramInt1, paramInt2, i, 99, null);
  }
  
  private void a(Context paramContext, QQGuildLiveChannelBuilder.ChannelHolder paramChannelHolder, QQGuildChannelLive paramQQGuildChannelLive, View paramView)
  {
    long l = paramQQGuildChannelLive.e().a;
    int j = paramQQGuildChannelLive.e().b;
    int i = 2;
    if (j == 1) {
      i = 1;
    } else if (j != 2) {
      i = 0;
    }
    if ((l != 0L) && (!a(i, paramQQGuildChannelLive.a()))) {
      break label74;
    }
    i = 0;
    label74:
    a(paramContext, paramView, QQGuildLiveChannelBuilder.ChannelHolder.a(paramChannelHolder), i, (int)l);
    QQGuildLiveChannelBuilder.ChannelHolder.j(paramChannelHolder).setVisibility(QQGuildLiveChannelBuilder.ChannelHolder.a(paramChannelHolder).getVisibility());
  }
  
  public static void a(AppInterface paramAppInterface, QQGuildLiveChannelBuilder.ChannelHolder paramChannelHolder, String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramGuildUserAvatar != null))
    {
      if (paramChannelHolder == null) {
        return;
      }
      paramChannelHolder = QQGuildLiveChannelBuilder.ChannelHolder.e(paramChannelHolder);
      if (paramString.equals((String)paramChannelHolder.getTag()))
      {
        paramChannelHolder.setVisibility(0);
        paramChannelHolder.setImageDrawable(((IQQGuildAvatarApi)paramAppInterface.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramAppInterface, paramGuildUserAvatar, 0));
      }
    }
  }
  
  public static void a(QQGuildLiveChannelBuilder.ChannelHolder paramChannelHolder, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramChannelHolder == null) {
        return;
      }
      paramChannelHolder = QQGuildLiveChannelBuilder.ChannelHolder.b(paramChannelHolder);
      if (paramString1.equals((String)paramChannelHolder.getTag()))
      {
        paramChannelHolder.setVisibility(0);
        paramChannelHolder.setText(paramString2);
      }
    }
  }
  
  private boolean a(int paramInt, IGProChannelInfo paramIGProChannelInfo)
  {
    return (paramInt == 2) && (a(paramIGProChannelInfo));
  }
  
  private boolean a(IGProChannelInfo paramIGProChannelInfo)
  {
    return paramIGProChannelInfo.getLiveRoomId() != 0L;
  }
  
  public View a(int paramInt, Object paramObject, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if (paramView != null)
    {
      paramObject = paramView;
      if ((paramView.getTag() instanceof QQGuildLiveChannelBuilder.ChannelHolder)) {}
    }
    else
    {
      paramObject = LayoutInflater.from(paramContext).inflate(2131625010, null);
      paramView = new QQGuildLiveChannelBuilder.ChannelHolder();
      QQGuildLiveChannelBuilder.ChannelHolder.a(paramView, (TextView)paramObject.findViewById(2131448921));
      QQGuildLiveChannelBuilder.ChannelHolder.a(paramView, (ImageView)paramObject.findViewById(2131435219));
      QQGuildLiveChannelBuilder.ChannelHolder.b(paramView, (ImageView)paramObject.findViewById(2131429026));
      QQGuildLiveChannelBuilder.ChannelHolder.b(paramView, (TextView)paramObject.findViewById(2131439136));
      QQGuildLiveChannelBuilder.ChannelHolder.c(paramView, (TextView)paramObject.findViewById(2131449888));
      QQGuildLiveChannelBuilder.ChannelHolder.a(paramView, paramObject.findViewById(2131437383));
      QQGuildLiveChannelBuilder.ChannelHolder.a(paramView, (GuildDragTextView)paramObject.findViewById(2131449124));
      QQGuildLiveChannelBuilder.ChannelHolder.b(paramView, paramObject.findViewById(2131449125));
      QQGuildLiveChannelBuilder.ChannelHolder.a(paramView, (RelativeLayout)paramObject.findViewById(2131431301));
      QQGuildLiveChannelBuilder.ChannelHolder.c(paramView, paramObject.findViewById(2131431310));
      paramObject.setTag(paramView);
      QQGuildLiveChannelBuilder.ChannelHolder.a(paramView).setOnModeChangeListener(this.a.c());
      if (ViewUtils.getScreenWidth() > 1080) {
        QQGuildLiveChannelBuilder.ChannelHolder.b(paramView).setMaxWidth(ViewUtils.dip2px(100.0F));
      } else {
        QQGuildLiveChannelBuilder.ChannelHolder.b(paramView).setMaxWidth(ViewUtils.dip2px(70.0F));
      }
    }
    paramObject.setOnClickListener(paramOnClickListener);
    return paramObject;
  }
  
  public void a(View paramView, int paramInt, QQChannelItemData paramQQChannelItemData, Context paramContext)
  {
    if (!(paramQQChannelItemData instanceof QQGuildChannelLive)) {
      return;
    }
    QQGuildChannelLive localQQGuildChannelLive = (QQGuildChannelLive)paramQQChannelItemData;
    IGProChannelInfo localIGProChannelInfo = localQQGuildChannelLive.a();
    paramQQChannelItemData = (QQGuildLiveChannelBuilder.ChannelHolder)paramView.getTag();
    QQGuildLiveChannelBuilder.ChannelHolder.c(paramQQChannelItemData).setText(localIGProChannelInfo.getChannelName());
    if ((!a(localIGProChannelInfo)) && (localQQGuildChannelLive.e().a == 0L))
    {
      QQGuildLiveChannelBuilder.ChannelHolder.c(paramQQChannelItemData).setTextColor(Color.rgb(34, 34, 34));
      QQGuildLiveChannelBuilder.ChannelHolder.d(paramQQChannelItemData).setImageResource(2130840935);
    }
    else
    {
      QQGuildLiveChannelBuilder.ChannelHolder.c(paramQQChannelItemData).setTextColor(Color.rgb(34, 34, 34));
      QQGuildLiveChannelBuilder.ChannelHolder.d(paramQQChannelItemData).setImageResource(2130840935);
    }
    QQGuildLiveChannelBuilder.ChannelHolder.e(paramQQChannelItemData).setTag(null);
    QQGuildLiveChannelBuilder.ChannelHolder.e(paramQQChannelItemData).setVisibility(8);
    QQGuildLiveChannelBuilder.ChannelHolder.b(paramQQChannelItemData).setVisibility(8);
    QQGuildLiveChannelBuilder.ChannelHolder.f(paramQQChannelItemData).setVisibility(8);
    QQGuildLiveChannelBuilder.ChannelHolder.g(paramQQChannelItemData).setVisibility(8);
    QQGuildLiveChannelBuilder.ChannelHolder.h(paramQQChannelItemData).setVisibility(8);
    a(paramContext, paramQQChannelItemData, localQQGuildChannelLive, paramView);
    QQGuildLiveChannelBuilder.ChannelHolder.a(paramQQChannelItemData).setTag(localQQGuildChannelLive);
    paramView = QQGuildLiveChannelBuilder.ChannelHolder.i(paramQQChannelItemData).getLayoutParams();
    if (!a(localIGProChannelInfo))
    {
      QQGuildLiveChannelBuilder.ChannelHolder.h(paramQQChannelItemData).setVisibility(8);
      paramView.height = ViewUtils.dip2px(40.0F);
      QQGuildLiveChannelBuilder.ChannelHolder.i(paramQQChannelItemData).setLayoutParams(paramView);
      paramQQChannelItemData.a("");
      QQGuildLiveChannelBuilder.ChannelHolder.j(paramQQChannelItemData).setPadding(ViewUtils.dip2px(12.0F), 0, 0, 0);
      return;
    }
    paramView.height = ViewUtils.dip2px(40.0F);
    QQGuildLiveChannelBuilder.ChannelHolder.i(paramQQChannelItemData).setLayoutParams(paramView);
    QQGuildLiveChannelBuilder.ChannelHolder.h(paramQQChannelItemData).setVisibility(0);
    QQGuildLiveChannelBuilder.ChannelHolder.j(paramQQChannelItemData).setPadding(ViewUtils.dip2px(6.0F), 0, 0, 0);
    QQGuildLiveChannelBuilder.ChannelHolder.f(paramQQChannelItemData).setVisibility(0);
    if (!TextUtils.isEmpty(localIGProChannelInfo.getLiveRoomName())) {
      QQGuildLiveChannelBuilder.ChannelHolder.c(paramQQChannelItemData).setText(localIGProChannelInfo.getLiveRoomName());
    }
    paramView = this.a.b();
    QQGuildLiveChannelBuilder.ChannelHolder.e(paramQQChannelItemData).setTag(String.valueOf(localIGProChannelInfo.getLiveAnchorTinyId()));
    QQGuildLiveChannelBuilder.ChannelHolder.e(paramQQChannelItemData).setVisibility(0);
    if (localIGProChannelInfo.getLiveAnchorTinyId() != 0L)
    {
      paramView = ((IQQGuildAvatarApi)paramView.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramView, String.valueOf(localIGProChannelInfo.getLiveAnchorTinyId()));
      QQGuildLiveChannelBuilder.ChannelHolder.e(paramQQChannelItemData).setImageDrawable(paramView);
    }
    else
    {
      paramView = ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true);
      QQGuildLiveChannelBuilder.ChannelHolder.e(paramQQChannelItemData).setImageDrawable(paramView);
    }
    QQGuildLiveChannelBuilder.ChannelHolder.b(paramQQChannelItemData).setTag(String.valueOf(localIGProChannelInfo.getLiveAnchorTinyId()));
    QQGuildLiveChannelBuilder.ChannelHolder.b(paramQQChannelItemData).setVisibility(0);
    if (localIGProChannelInfo.getLiveAnchorTinyId() != 0L)
    {
      paramView = String.valueOf(localIGProChannelInfo.getLiveAnchorTinyId());
      paramQQChannelItemData.a(paramView);
      QQGuildLiveChannelBuilder.ChannelHolder.a(paramQQChannelItemData, this.a.b(), localQQGuildChannelLive.c(), paramView);
    }
    else
    {
      QQGuildLiveChannelBuilder.ChannelHolder.b(paramQQChannelItemData).setText("nickname");
    }
    paramView = localQQGuildChannelLive.d();
    QQGuildLiveChannelBuilder.ChannelHolder.g(paramQQChannelItemData).setVisibility(0);
    if (paramView != null) {
      QQGuildLiveChannelBuilder.ChannelHolder.g(paramQQChannelItemData).setText(paramContext.getString(2131890410, new Object[] { Long.valueOf(paramView.getViewer()) }));
    } else {
      QQGuildLiveChannelBuilder.ChannelHolder.g(paramQQChannelItemData).setText(paramContext.getString(2131890410, new Object[] { Integer.valueOf(0) }));
    }
    ThreadManagerV2.getUIHandlerV2().post(new QQGuildLiveChannelBuilder.1(this, paramQQChannelItemData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.item.QQGuildLiveChannelBuilder
 * JD-Core Version:    0.7.0.1
 */