package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.config.GuildCoverInfo;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.helper.GuildAnimatorHelper;
import com.tencent.mobileqq.guild.mainframe.helper.GuildAnimatorHelper.AnimatorInfo;
import com.tencent.mobileqq.guild.mainframe.helper.GuildLeftBarSelHelper;
import com.tencent.mobileqq.guild.mainframe.helper.GuildLeftBarSelHelper.SelItem;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildBaseItemViewHolder;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildLeftBarController;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildListController;
import com.tencent.mobileqq.guild.mainframe.leftbar.animation.ColorAniData;
import com.tencent.mobileqq.guild.mainframe.leftbar.animation.LeftBarAnimationUtils;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildBaseLeftItemData;
import com.tencent.mobileqq.guild.mainframe.ui.GuildDragTextView;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Comparator;

public abstract class GuildListItemBaseBuilder
  implements View.OnClickListener
{
  public static final int a = ViewUtils.dpToPx(48.0F);
  public static final int b = ViewUtils.dpToPx(90.0F);
  public static Comparator<GuildListItemBaseBuilder> e = new GuildListItemBaseBuilder.1();
  public GuildMainViewContext c;
  public GuildBaseLeftItemData d;
  
  public GuildListItemBaseBuilder(GuildMainViewContext paramGuildMainViewContext, GuildBaseLeftItemData paramGuildBaseLeftItemData)
  {
    this.c = paramGuildMainViewContext;
    this.d = paramGuildBaseLeftItemData;
    b();
  }
  
  private String a(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return "#ffE5E5E5";
      }
      if (paramBoolean) {
        paramString = GuildCoverInfo.a(paramString).f();
      } else {
        paramString = GuildCoverInfo.a(paramString).g();
      }
      if (paramString != null)
      {
        if (TextUtils.isEmpty(paramString)) {
          return "#ffE5E5E5";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("#ff");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getGradientStartColor:");
          localStringBuilder.append(paramString);
          QLog.d("GuildListItemBaseBuilder", 1, localStringBuilder.toString());
        }
        return paramString;
      }
    }
    return "#ffE5E5E5";
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = a(paramString1, true);
    String str1 = a(paramString1, false);
    String str2 = a(paramString2, true);
    paramString2 = a(paramString2, false);
    if (((String)localObject).equals(str2)) {
      return;
    }
    this.c.c().i().j();
    paramString1 = this.c.h();
    int i = Color.parseColor((String)localObject);
    int j = Color.parseColor(str1);
    int k = Color.parseColor(str2);
    int m = Color.parseColor(paramString2);
    paramString2 = new ColorAniData(i, j);
    localObject = new ColorAniData(k, m);
    LeftBarAnimationUtils.a(paramString1, LeftBarAnimationUtils.b, paramString2, (ColorAniData)localObject).start();
  }
  
  private int f()
  {
    Object localObject = ((GuildLeftBarSelHelper)this.c.a(GuildMainFrameConstants.b)).i();
    String str = a(((GuildLeftBarSelHelper.SelItem)localObject).b, true);
    localObject = a(((GuildLeftBarSelHelper.SelItem)localObject).b, false);
    return QQGuildUIUtil.a(0.5F, Color.parseColor(str), Color.parseColor((String)localObject));
  }
  
  private void g()
  {
    String str = a(((GuildLeftBarSelHelper)this.c.a(GuildMainFrameConstants.b)).i().b, true);
    DragFrameLayout localDragFrameLayout = this.c.h();
    GradientDrawable localGradientDrawable = (GradientDrawable)localDragFrameLayout.getBackground();
    if (str.equals("#ffE5E5E5"))
    {
      int i = Color.parseColor(str);
      localGradientDrawable.setColors(new int[] { i, i });
      localDragFrameLayout.setBackground(localGradientDrawable);
      return;
    }
    localGradientDrawable.setColors(new int[] { Color.parseColor(str), Color.parseColor("#ffffffff") });
    localDragFrameLayout.setBackground(localGradientDrawable);
  }
  
  public abstract int a();
  
  public final int a(GuildListItemBaseBuilder paramGuildListItemBaseBuilder)
  {
    if ((this.d != null) && (paramGuildListItemBaseBuilder != null) && (paramGuildListItemBaseBuilder.d != null))
    {
      if (a() != paramGuildListItemBaseBuilder.a()) {
        return a() - paramGuildListItemBaseBuilder.a();
      }
      return b(paramGuildListItemBaseBuilder);
    }
    return 0;
  }
  
  @SuppressLint({"NewApi"})
  public View a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView = (GuildBaseListItemLayout)paramView;
    paramView.setBuilder(this);
    g();
    return paramView.a();
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramViewGroup);
    }
    return b(localView);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    return new GuildBaseListItemLayout(paramViewGroup.getContext());
  }
  
  public Object a(GuildAnimatorHelper.AnimatorInfo paramAnimatorInfo)
  {
    return null;
  }
  
  @RequiresApi(api=23)
  public String a(View paramView, GuildBaseItemViewHolder paramGuildBaseItemViewHolder, @Nullable IGuildUnreadCntService.UnreadCntInfo paramUnreadCntInfo)
  {
    String str = "";
    if (paramUnreadCntInfo == null) {
      return "";
    }
    paramGuildBaseItemViewHolder.i = paramUnreadCntInfo;
    int i = (int)paramUnreadCntInfo.a;
    GuildDragTextView localGuildDragTextView = paramGuildBaseItemViewHolder.g;
    if (i <= 0)
    {
      localGuildDragTextView.setVisibility(8);
      return "";
    }
    if (i > 99)
    {
      paramGuildBaseItemViewHolder = new StringBuilder();
      paramGuildBaseItemViewHolder.append(String.valueOf(99));
      paramGuildBaseItemViewHolder.append("+");
      paramGuildBaseItemViewHolder = paramGuildBaseItemViewHolder.toString();
    }
    else
    {
      paramGuildBaseItemViewHolder = String.valueOf(i);
    }
    LayerDrawable localLayerDrawable1 = (LayerDrawable)this.c.b().getDrawable(2130840991);
    localLayerDrawable1.getDrawable(0).setColorFilter(f(), PorterDuff.Mode.SRC);
    LayerDrawable localLayerDrawable2 = (LayerDrawable)this.c.b().getDrawable(2130840816);
    localLayerDrawable2.getDrawable(0).setColorFilter(f(), PorterDuff.Mode.SRC);
    if (paramUnreadCntInfo.b == 1)
    {
      localGuildDragTextView.setTextColor(this.c.b().getResources().getColor(2131168174));
      localGuildDragTextView.setDragViewType(0, paramView);
      localGuildDragTextView.setText(paramGuildBaseItemViewHolder);
      localGuildDragTextView.setBackground(localLayerDrawable1);
      paramView = String.format(this.c.b().getString(2131890496), new Object[] { String.valueOf(i) });
    }
    else if (paramUnreadCntInfo.b == 2)
    {
      localGuildDragTextView.setDragViewType(1, paramView);
      localGuildDragTextView.setBackground(localLayerDrawable2);
      localGuildDragTextView.setText("");
      paramView = this.c.b().getString(2131890491);
    }
    else
    {
      localGuildDragTextView.setVisibility(8);
      paramView = str;
    }
    localGuildDragTextView.setVisibility(0);
    return paramView;
  }
  
  public void a(View paramView, Bundle paramBundle)
  {
    this.d.e = paramBundle;
    Object localObject = (GuildLeftBarSelHelper)this.c.a(GuildMainFrameConstants.b);
    GuildLeftBarSelHelper.SelItem localSelItem = ((GuildLeftBarSelHelper)localObject).i();
    ((GuildLeftBarSelHelper)localObject).a(new GuildLeftBarSelHelper.SelItem(this.d.a, this.d.b));
    int j = 1;
    int i;
    if ((localSelItem != null) && (localSelItem.equals(((GuildLeftBarSelHelper)localObject).i()))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      localObject = (GuildAnimatorHelper)this.c.a(GuildMainFrameConstants.g);
      i = j;
      if (paramBundle != null)
      {
        i = j;
        if (paramBundle.getBoolean("addJoinItem", false)) {
          i = 0;
        }
      }
      if ((i != 0) && (localSelItem != null)) {
        a(localSelItem.b, this.d.b);
      }
    }
    if (localSelItem != null) {
      this.c.a(localSelItem.a, localSelItem.b);
    }
    b(paramView);
  }
  
  public void a(View paramView, GuildAnimatorHelper.AnimatorInfo paramAnimatorInfo)
  {
    a(paramView);
    e(paramView);
    ((GuildBaseListItemLayout)paramView).a(paramAnimatorInfo, a(paramAnimatorInfo));
  }
  
  public void a(GuildBaseItemViewHolder paramGuildBaseItemViewHolder)
  {
    LayerDrawable localLayerDrawable;
    if (paramGuildBaseItemViewHolder.i.b == 1)
    {
      localLayerDrawable = (LayerDrawable)this.c.b().getDrawable(2130840991);
      localLayerDrawable.getDrawable(0).setColorFilter(f(), PorterDuff.Mode.SRC);
      paramGuildBaseItemViewHolder.g.setBackground(localLayerDrawable);
      return;
    }
    if (paramGuildBaseItemViewHolder.i.b == 2)
    {
      localLayerDrawable = (LayerDrawable)this.c.b().getDrawable(2130840816);
      localLayerDrawable.getDrawable(0).setColorFilter(f(), PorterDuff.Mode.SRC);
      paramGuildBaseItemViewHolder.g.setBackground(localLayerDrawable);
    }
  }
  
  public int b(GuildListItemBaseBuilder paramGuildListItemBaseBuilder)
  {
    return 0;
  }
  
  public final View b(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView.setClickable(true);
    paramView.setOnClickListener(this);
    GuildAnimatorHelper localGuildAnimatorHelper = (GuildAnimatorHelper)this.c.a(GuildMainFrameConstants.g);
    GuildAnimatorHelper.AnimatorInfo localAnimatorInfo = localGuildAnimatorHelper.a(this.d.a, this.d.b);
    if ((localAnimatorInfo != null) && (localAnimatorInfo.a != 0)) {
      if (localAnimatorInfo.a())
      {
        localGuildAnimatorHelper.b(this.d.a, this.d.b);
      }
      else
      {
        localGuildAnimatorHelper.b(this.d.a, this.d.b);
        a(paramView, localAnimatorInfo);
        return paramView;
      }
    }
    if (d(paramView))
    {
      if (!c(paramView))
      {
        QLog.i("GuildListItemBaseBuilder", 1, "updateItemView isAnimatorIng checkBuilder:false");
        e(paramView);
        a(paramView);
      }
      QLog.i("GuildListItemBaseBuilder", 1, "updateItemView isAnimatorIng");
      return paramView;
    }
    a(paramView);
    return paramView;
  }
  
  public abstract void b();
  
  public void c() {}
  
  public boolean c(View paramView)
  {
    return ((GuildBaseListItemLayout)paramView).a(this);
  }
  
  public int d()
  {
    return this.d.a;
  }
  
  public boolean d(View paramView)
  {
    return ((GuildBaseListItemLayout)paramView).d();
  }
  
  public void e(View paramView)
  {
    ((GuildBaseListItemLayout)paramView).b();
  }
  
  public boolean e()
  {
    GuildLeftBarSelHelper.SelItem localSelItem = ((GuildLeftBarSelHelper)this.c.a(GuildMainFrameConstants.b)).i();
    return (localSelItem != null) && (localSelItem.equals(new GuildLeftBarSelHelper.SelItem(this.d.a, this.d.b)));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131437329) {
      a(paramView, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBaseBuilder
 * JD-Core Version:    0.7.0.1
 */