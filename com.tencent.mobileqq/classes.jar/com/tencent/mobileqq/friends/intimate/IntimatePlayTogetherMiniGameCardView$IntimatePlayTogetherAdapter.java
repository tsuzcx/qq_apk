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
  private int jdField_a_of_type_Int = 9999;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final String jdField_a_of_type_JavaLangString;
  private List<MISC.StAppPlayingInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public IntimatePlayTogetherMiniGameCardView$IntimatePlayTogetherAdapter(List<MISC.StAppPlayingInfo> paramList, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131693491;
    }
    return 2131693494;
  }
  
  private void a(IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherViewHolder paramIntimatePlayTogetherViewHolder)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
      {
        paramIntimatePlayTogetherViewHolder.a().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        paramIntimatePlayTogetherViewHolder.b().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        return;
      }
      paramIntimatePlayTogetherViewHolder.a().setTextColor(this.b);
      paramIntimatePlayTogetherViewHolder.b().setTextColor(this.b);
      return;
    }
    catch (Throwable paramIntimatePlayTogetherViewHolder)
    {
      QLog.e("IntimatePlayTogetherMin", 1, "updateThemeTextColor error", paramIntimatePlayTogetherViewHolder);
    }
  }
  
  public IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559399, null, false));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = paramInt;
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
  }
  
  public void a(IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherViewHolder paramIntimatePlayTogetherViewHolder, int paramInt)
  {
    MISC.StAppPlayingInfo localStAppPlayingInfo = (MISC.StAppPlayingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    boolean bool;
    if (localStAppPlayingInfo != null)
    {
      bool = MiniGamePlayTogetherHandler.a(localStAppPlayingInfo.appMetaInfo);
      paramIntimatePlayTogetherViewHolder.itemView.setOnClickListener(new IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherAdapter.1(this, localStAppPlayingInfo, bool));
      paramIntimatePlayTogetherViewHolder.a().setVisibility(0);
      paramIntimatePlayTogetherViewHolder.a().setVisibility(0);
      paramIntimatePlayTogetherViewHolder.b().setVisibility(0);
      if (localStAppPlayingInfo.appMetaInfo != null)
      {
        paramIntimatePlayTogetherViewHolder.a().setText(localStAppPlayingInfo.appMetaInfo.appName.get());
        paramIntimatePlayTogetherViewHolder.a().setImageDrawable(((IMiniAppService)QRoute.api(IMiniAppService.class)).getIcon(paramIntimatePlayTogetherViewHolder.a().getContext(), localStAppPlayingInfo.appMetaInfo.icon.get(), true));
      }
      IntimatePlayTogetherMiniGameCardView.a(paramIntimatePlayTogetherViewHolder.a(), this.jdField_a_of_type_JavaLangString);
      if ((localStAppPlayingInfo.myRank.get() == 0) || (localStAppPlayingInfo.friendRank.get() == 0)) {
        break label281;
      }
      if (localStAppPlayingInfo.myRank.get() != localStAppPlayingInfo.friendRank.get()) {
        break label238;
      }
      paramIntimatePlayTogetherViewHolder.b().setText(2131693486);
      paramIntimatePlayTogetherViewHolder.a().setText(a(bool));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        a(paramIntimatePlayTogetherViewHolder);
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramIntimatePlayTogetherViewHolder, paramInt, getItemId(paramInt));
      return;
      label238:
      TextView localTextView = paramIntimatePlayTogetherViewHolder.b();
      if (localStAppPlayingInfo.myRank.get() < localStAppPlayingInfo.friendRank.get()) {}
      for (int i = 2131693488;; i = 2131693487)
      {
        localTextView.setText(i);
        break;
      }
      label281:
      if ((localStAppPlayingInfo.myRank.get() == 0) && (localStAppPlayingInfo.friendRank.get() > 0))
      {
        paramIntimatePlayTogetherViewHolder.b().setText(String.format(paramIntimatePlayTogetherViewHolder.itemView.getContext().getString(2131693489), new Object[] { Integer.valueOf(localStAppPlayingInfo.friendRank.get()) }));
        paramIntimatePlayTogetherViewHolder.a().setText(a(bool));
      }
      else
      {
        paramIntimatePlayTogetherViewHolder.a().setVisibility(8);
        paramIntimatePlayTogetherViewHolder.a().setVisibility(8);
        paramIntimatePlayTogetherViewHolder.b().setVisibility(8);
        paramIntimatePlayTogetherViewHolder.a().setText(a(bool));
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int getItemCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherAdapter
 * JD-Core Version:    0.7.0.1
 */