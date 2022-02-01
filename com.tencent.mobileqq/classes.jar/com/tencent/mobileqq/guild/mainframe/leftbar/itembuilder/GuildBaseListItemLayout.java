package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.helper.GuildAnimatorHelper.AnimatorInfo;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildBaseItemViewHolder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator.IGuildMFAnimator;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator.LeftBarJoinGuildAnimator;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator.LeftBarJoinGuildItemSwitchEnlargeAnimator;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator.LeftBarJoinGuildItemSwitchLessenAnimator;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator.LeftBarJoinGuildLocalAnimator;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildBaseLeftItemData;
import com.tencent.mobileqq.guild.mainframe.ui.GuildDragTextView;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.concurrent.ConcurrentHashMap;

public class GuildBaseListItemLayout
  extends FrameLayout
{
  private static String a = "GuildBaseListItemLayout";
  private int b = 0;
  private long c = 0L;
  private GuildBaseItemViewHolder d = new GuildBaseItemViewHolder();
  private ConcurrentHashMap<Integer, IGuildMFAnimator> e = new ConcurrentHashMap();
  
  public GuildBaseListItemLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  private void e()
  {
    setClipChildren(false);
    setId(2131437329);
    LayoutInflater.from(getContext()).inflate(2131625082, this, true);
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    f();
    g();
  }
  
  private void f()
  {
    this.d.b = findViewById(2131437329);
    this.d.a = findViewById(2131439852);
    this.d.d = findViewById(2131429023);
    this.d.c = findViewById(2131437328);
    this.d.e = ((RadiusFrameLayout)findViewById(2131434939));
    this.d.f = ((ImageView)findViewById(2131434993));
    this.d.g = ((GuildDragTextView)findViewById(2131449126));
  }
  
  private void g()
  {
    this.e.put(Integer.valueOf(GuildMainFrameConstants.u), new LeftBarJoinGuildAnimator(this));
    this.e.put(Integer.valueOf(GuildMainFrameConstants.v), new LeftBarJoinGuildLocalAnimator(this));
    this.e.put(Integer.valueOf(GuildMainFrameConstants.w), new LeftBarJoinGuildItemSwitchEnlargeAnimator(this));
    this.e.put(Integer.valueOf(GuildMainFrameConstants.x), new LeftBarJoinGuildItemSwitchLessenAnimator(this));
  }
  
  @RequiresApi(api=21)
  public View a()
  {
    if (this.d.h == null) {
      return this;
    }
    GuildBaseItemViewHolder localGuildBaseItemViewHolder = getHolder();
    Object localObject = (FrameLayout.LayoutParams)localGuildBaseItemViewHolder.f.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = GuildListItemBaseBuilder.a;
    ((FrameLayout.LayoutParams)localObject).height = GuildListItemBaseBuilder.a;
    if (localGuildBaseItemViewHolder.h.e())
    {
      localGuildBaseItemViewHolder.d.setSelected(true);
      localGuildBaseItemViewHolder.g.setOnModeChangeListener(localGuildBaseItemViewHolder.h.c.h());
      localGuildBaseItemViewHolder.g.setTag(localGuildBaseItemViewHolder.h);
      localGuildBaseItemViewHolder.e.setElevation(0.0F);
    }
    else
    {
      localGuildBaseItemViewHolder.d.setSelected(false);
      localGuildBaseItemViewHolder.g.setOnModeChangeListener(null);
      localGuildBaseItemViewHolder.g.setTag(null);
      if (Build.VERSION.SDK_INT >= 28)
      {
        localGuildBaseItemViewHolder.e.setOutlineAmbientShadowColor(getResources().getColor(2131166254));
        localGuildBaseItemViewHolder.e.setOutlineSpotShadowColor(getResources().getColor(2131166254));
        localGuildBaseItemViewHolder.e.setElevation(ViewUtils.dpToPx(8.0F));
      }
      else
      {
        localGuildBaseItemViewHolder.e.setElevation(ViewUtils.dpToPx(5.0F));
      }
    }
    localGuildBaseItemViewHolder.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localGuildBaseItemViewHolder.f.setImageDrawable(localGuildBaseItemViewHolder.h.d.c);
    localObject = localGuildBaseItemViewHolder.c.getLayoutParams();
    if (localGuildBaseItemViewHolder.h.d.d)
    {
      localGuildBaseItemViewHolder.a.setVisibility(0);
      ((ViewGroup.LayoutParams)localObject).height = ViewUtils.dpToPx(71.0F);
    }
    else
    {
      localGuildBaseItemViewHolder.a.setVisibility(8);
      ((ViewGroup.LayoutParams)localObject).height = ViewUtils.dpToPx(61.0F);
    }
    localGuildBaseItemViewHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localGuildBaseItemViewHolder.g.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "guild_number.ttf"));
    localGuildBaseItemViewHolder.g.setVisibility(8);
    return this;
  }
  
  public void a(GuildAnimatorHelper.AnimatorInfo paramAnimatorInfo, Object paramObject)
  {
    if (paramAnimatorInfo == null) {
      return;
    }
    IGuildMFAnimator localIGuildMFAnimator = (IGuildMFAnimator)this.e.get(Integer.valueOf(paramAnimatorInfo.a));
    if (localIGuildMFAnimator != null)
    {
      this.b = paramAnimatorInfo.a;
      this.c = System.currentTimeMillis();
      localIGuildMFAnimator.a(paramAnimatorInfo, paramObject);
    }
  }
  
  public boolean a(GuildListItemBaseBuilder paramGuildListItemBaseBuilder)
  {
    return (this.d.h == null) || (paramGuildListItemBaseBuilder == null) || (this.d.h.d.equals(paramGuildListItemBaseBuilder.d));
  }
  
  public void b()
  {
    int i = this.b;
    if (i != 0)
    {
      ((IGuildMFAnimator)this.e.get(Integer.valueOf(i))).a();
      this.b = 0;
      this.c = 0L;
    }
  }
  
  public void c()
  {
    this.b = 0;
    this.c = 0L;
    getHolder().h.a(this);
  }
  
  public boolean d()
  {
    if (this.b != 0)
    {
      if (System.currentTimeMillis() - this.c > 2000L)
      {
        b();
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isAnimatorIng true but time longer animatorBeginTime:");
        localStringBuilder.append(this.c);
        localStringBuilder.append(" curTime:");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.i(str, 1, localStringBuilder.toString());
        return false;
      }
      return true;
    }
    return false;
  }
  
  public GuildBaseItemViewHolder getHolder()
  {
    return this.d;
  }
  
  public void setBuilder(GuildListItemBaseBuilder paramGuildListItemBaseBuilder)
  {
    this.d.h = paramGuildListItemBaseBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildBaseListItemLayout
 * JD-Core Version:    0.7.0.1
 */