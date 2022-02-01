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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.guild.main.IChannelListControl;
import com.tencent.mobileqq.guild.main.data.QQChannelItemData;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelText;
import com.tencent.mobileqq.guild.mainframe.ui.GuildDragTextView;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import java.util.Locale;

public class QQGuildChannelTextBuilder
  extends QQGuildChannelItemBuilder
{
  private void a(Context paramContext, View paramView, DragTextView paramDragTextView, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 1)
    {
      paramDragTextView.setDragViewType(0, paramView);
      paramDragTextView.setTextColor(paramContext.getResources().getColor(2131168174));
      paramInt1 = 3;
      i = 2130840762;
    }
    else if (paramInt1 == 2)
    {
      paramDragTextView.setDragViewType(1, paramView);
      paramInt1 = 3;
      i = 2130840761;
    }
    else
    {
      paramDragTextView.setDragViewType(-1, paramView);
      paramInt1 = 0;
      i = 0;
    }
    paramDragTextView.setTypeface(Typeface.createFromAsset(paramContext.getAssets(), "guild_number.ttf"));
    CustomWidgetUtil.a(paramDragTextView, paramInt1, paramInt2, i, 99, null);
    if (paramInt2 > 0) {
      paramDragTextView.setContentDescription(String.format(Locale.CHINA, paramContext.getResources().getString(2131890341), new Object[] { Integer.valueOf(paramInt2) }));
    }
  }
  
  private void a(Context paramContext, QQGuildChannelTextBuilder.ChannelHolder paramChannelHolder, QQGuildChannelText paramQQGuildChannelText, View paramView, boolean paramBoolean)
  {
    long l = paramQQGuildChannelText.b().a;
    int j = paramQQGuildChannelText.b().b;
    int i = 2;
    if (j == 1) {
      i = 1;
    } else if (j != 2) {
      i = 0;
    }
    if (l == 0L) {
      i = 0;
    }
    a(paramContext, paramView, QQGuildChannelTextBuilder.ChannelHolder.a(paramChannelHolder), i, (int)l);
  }
  
  public View a(int paramInt, Object paramObject, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof QQGuildChannelTextBuilder.ChannelHolder))) {
      break label118;
    }
    paramView = LayoutInflater.from(paramContext).inflate(2131625016, null);
    paramObject = new QQGuildChannelTextBuilder.ChannelHolder(null);
    QQGuildChannelTextBuilder.ChannelHolder.a(paramObject, (RelativeLayout)paramView.findViewById(2131445152));
    QQGuildChannelTextBuilder.ChannelHolder.a(paramObject, (ImageView)paramView.findViewById(2131435219));
    QQGuildChannelTextBuilder.ChannelHolder.a(paramObject, (TextView)paramView.findViewById(2131430505));
    QQGuildChannelTextBuilder.ChannelHolder.a(paramObject, (GuildDragTextView)paramView.findViewById(2131449124));
    paramView.setTag(paramObject);
    QQGuildChannelTextBuilder.ChannelHolder.a(paramObject).setOnModeChangeListener(this.a.c());
    label118:
    paramView.setOnClickListener(paramOnClickListener);
    return paramView;
  }
  
  public void a(View paramView, int paramInt, QQChannelItemData paramQQChannelItemData, Context paramContext)
  {
    if (!(paramQQChannelItemData instanceof QQGuildChannelText)) {
      return;
    }
    paramQQChannelItemData = (QQGuildChannelText)paramQQChannelItemData;
    IGProChannelInfo localIGProChannelInfo = paramQQChannelItemData.a();
    QQGuildChannelTextBuilder.ChannelHolder localChannelHolder = (QQGuildChannelTextBuilder.ChannelHolder)paramView.getTag();
    QQGuildChannelTextBuilder.ChannelHolder.b(localChannelHolder).setText(localIGProChannelInfo.getChannelName());
    boolean bool = TextUtils.equals(this.a.a(), paramQQChannelItemData.a().getChannelUin());
    if (bool) {
      QQGuildChannelTextBuilder.ChannelHolder.c(localChannelHolder).setBackgroundDrawable(paramContext.getResources().getDrawable(2130840760));
    } else {
      QQGuildChannelTextBuilder.ChannelHolder.c(localChannelHolder).setBackgroundDrawable(paramContext.getResources().getDrawable(2130840758));
    }
    if (paramQQChannelItemData.b().a != 0L) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((!bool) && (paramInt == 0))
    {
      QQGuildChannelTextBuilder.ChannelHolder.b(localChannelHolder).setTextColor(Color.rgb(34, 34, 34));
      QQGuildChannelTextBuilder.ChannelHolder.d(localChannelHolder).setImageResource(2130841035);
    }
    else
    {
      QQGuildChannelTextBuilder.ChannelHolder.b(localChannelHolder).setTextColor(Color.rgb(34, 34, 34));
      QQGuildChannelTextBuilder.ChannelHolder.d(localChannelHolder).setImageResource(2130841035);
    }
    a(paramContext, localChannelHolder, paramQQChannelItemData, paramView, bool);
    QQGuildChannelTextBuilder.ChannelHolder.a(localChannelHolder).setTag(paramQQChannelItemData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.item.QQGuildChannelTextBuilder
 * JD-Core Version:    0.7.0.1
 */