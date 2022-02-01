package com.tencent.mobileqq.mini.entry.desktop;

import NS_MINI_INTERFACE.INTERFACE.StRankingList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;

class MiniAppDesktopAdapter$FriendsPkViewHolder$Item
{
  final View mContainer;
  final ImageView mCrown;
  final ImageView mIcon;
  final TextView mName;
  final TextView mRanking;
  final TextView mScore;
  final TextView mUnit;
  
  MiniAppDesktopAdapter$FriendsPkViewHolder$Item(MiniAppDesktopAdapter.FriendsPkViewHolder paramFriendsPkViewHolder, View paramView)
  {
    this.mContainer = paramView;
    this.mIcon = ((ImageView)paramView.findViewById(2131371117));
    this.mCrown = ((ImageView)paramView.findViewById(2131371118));
    this.mName = ((TextView)paramView.findViewById(2131371120));
    this.mRanking = ((TextView)paramView.findViewById(2131371121));
    this.mScore = ((TextView)paramView.findViewById(2131371122));
    this.mUnit = ((TextView)paramView.findViewById(2131371113));
  }
  
  public void gone()
  {
    this.mContainer.setVisibility(8);
  }
  
  public void setData(INTERFACE.StRankingList paramStRankingList)
  {
    this.mContainer.setVisibility(0);
    try
    {
      Object localObject1 = this.this$0.itemView.getResources().getDrawable(2130840321);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      int i = ViewUtils.a(30.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i;
      localObject1 = URLDrawable.getDrawable(paramStRankingList.avatar.get(), (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.a(ViewUtils.a(30.0F), ViewUtils.a(30.0F)));
      ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.n);
      this.mIcon.setImageDrawable((Drawable)localObject1);
      label104:
      this.mName.setText(paramStRankingList.nick.get());
      localObject1 = this.mScore;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramStRankingList.score.get());
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      this.mUnit.setText(paramStRankingList.unit.get());
      localObject1 = this.mRanking;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramStRankingList.ranks.get());
      ((StringBuilder)localObject2).append("");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label104;
    }
  }
  
  public void setOutOfRankStyle()
  {
    this.mRanking.setTextColor(-1605504);
    this.mRanking.setTypeface(Typeface.create("sans-serif-condensed", 2));
    this.mRanking.setScaleX(0.8F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.FriendsPkViewHolder.Item
 * JD-Core Version:    0.7.0.1
 */