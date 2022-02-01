package com.tencent.mobileqq.friends.intimate;

import NS_MINI_APP_MISC.MISC.StAppPlayingInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.util.List;

public class IntimatePlayTogetherMiniGameCardView$IntimatePlayTogetherAdapter
  extends RecyclerView.Adapter<IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherViewHolder>
{
  private List<MISC.StAppPlayingInfo> a;
  private final String b;
  private final View.OnClickListener c;
  private int d = 9999;
  private boolean e;
  private ColorStateList f;
  private int g;
  
  public IntimatePlayTogetherMiniGameCardView$IntimatePlayTogetherAdapter(List<MISC.StAppPlayingInfo> paramList, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.a = paramList;
    this.b = paramString;
    this.c = paramOnClickListener;
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131890995;
    }
    return 2131890998;
  }
  
  private void a(IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherViewHolder paramIntimatePlayTogetherViewHolder)
  {
    try
    {
      if (this.f != null)
      {
        paramIntimatePlayTogetherViewHolder.b().setTextColor(this.f);
        paramIntimatePlayTogetherViewHolder.d().setTextColor(this.f);
        return;
      }
      paramIntimatePlayTogetherViewHolder.b().setTextColor(this.g);
      paramIntimatePlayTogetherViewHolder.d().setTextColor(this.g);
      return;
    }
    catch (Throwable paramIntimatePlayTogetherViewHolder)
    {
      QLog.e("IntimatePlayTogetherMin", 1, "updateThemeTextColor error", paramIntimatePlayTogetherViewHolder);
    }
  }
  
  public IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625195, null, false));
  }
  
  public void a(int paramInt)
  {
    this.e = true;
    this.g = paramInt;
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    this.e = true;
    this.f = paramColorStateList;
  }
  
  public void a(IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherViewHolder paramIntimatePlayTogetherViewHolder, int paramInt)
  {
    MISC.StAppPlayingInfo localStAppPlayingInfo = (MISC.StAppPlayingInfo)this.a.get(paramInt);
    if (localStAppPlayingInfo != null)
    {
      boolean bool = MiniGamePlayTogetherHandler.a(localStAppPlayingInfo.appMetaInfo);
      paramIntimatePlayTogetherViewHolder.itemView.setOnClickListener(new IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherAdapter.1(this, localStAppPlayingInfo, bool));
      paramIntimatePlayTogetherViewHolder.f().setVisibility(0);
      paramIntimatePlayTogetherViewHolder.c().setVisibility(0);
      paramIntimatePlayTogetherViewHolder.d().setVisibility(0);
      if (localStAppPlayingInfo.appMetaInfo != null)
      {
        paramIntimatePlayTogetherViewHolder.b().setText(localStAppPlayingInfo.appMetaInfo.appName.get());
        paramIntimatePlayTogetherViewHolder.a().setImageDrawable(((IMiniAppService)QRoute.api(IMiniAppService.class)).getIcon(paramIntimatePlayTogetherViewHolder.a().getContext(), localStAppPlayingInfo.appMetaInfo.icon.get(), true));
      }
      IntimatePlayTogetherMiniGameCardView.a(paramIntimatePlayTogetherViewHolder.c(), this.b);
      if ((localStAppPlayingInfo.myRank.get() != 0) && (localStAppPlayingInfo.friendRank.get() != 0))
      {
        if (localStAppPlayingInfo.myRank.get() == localStAppPlayingInfo.friendRank.get())
        {
          paramIntimatePlayTogetherViewHolder.d().setText(2131890990);
        }
        else
        {
          TextView localTextView = paramIntimatePlayTogetherViewHolder.d();
          int i;
          if (localStAppPlayingInfo.myRank.get() < localStAppPlayingInfo.friendRank.get()) {
            i = 2131890992;
          } else {
            i = 2131890991;
          }
          localTextView.setText(i);
        }
        paramIntimatePlayTogetherViewHolder.e().setText(a(bool));
      }
      else if ((localStAppPlayingInfo.myRank.get() == 0) && (localStAppPlayingInfo.friendRank.get() > 0))
      {
        paramIntimatePlayTogetherViewHolder.d().setText(String.format(paramIntimatePlayTogetherViewHolder.itemView.getContext().getString(2131890993), new Object[] { Integer.valueOf(localStAppPlayingInfo.friendRank.get()) }));
        paramIntimatePlayTogetherViewHolder.e().setText(a(bool));
      }
      else
      {
        paramIntimatePlayTogetherViewHolder.f().setVisibility(8);
        paramIntimatePlayTogetherViewHolder.c().setVisibility(8);
        paramIntimatePlayTogetherViewHolder.d().setVisibility(8);
        paramIntimatePlayTogetherViewHolder.e().setText(a(bool));
      }
      if (this.e) {
        a(paramIntimatePlayTogetherViewHolder);
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramIntimatePlayTogetherViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int getItemCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherAdapter
 * JD-Core Version:    0.7.0.1
 */