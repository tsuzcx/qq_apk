package com.tencent.mobileqq.mini.entry.desktop;

import NS_MINI_INTERFACE.INTERFACE.StRankingList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bcuq;
import bdkf;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

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
    this.mIcon = ((ImageView)paramView.findViewById(2131370466));
    this.mCrown = ((ImageView)paramView.findViewById(2131370467));
    this.mName = ((TextView)paramView.findViewById(2131370469));
    this.mRanking = ((TextView)paramView.findViewById(2131370470));
    this.mScore = ((TextView)paramView.findViewById(2131370471));
    this.mUnit = ((TextView)paramView.findViewById(2131370462));
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
      Object localObject = this.this$0.itemView.getResources().getDrawable(2130840084);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      int i = bdkf.a(30.0F);
      localURLDrawableOptions.mRequestHeight = i;
      localURLDrawableOptions.mRequestWidth = i;
      localObject = URLDrawable.getDrawable(paramStRankingList.avatar.get(), localURLDrawableOptions);
      ((URLDrawable)localObject).setTag(bcuq.a(bdkf.a(30.0F), bdkf.a(30.0F)));
      ((URLDrawable)localObject).setDecodeHandler(bcuq.o);
      this.mIcon.setImageDrawable((Drawable)localObject);
      label104:
      this.mName.setText(paramStRankingList.nick.get());
      this.mScore.setText("" + paramStRankingList.score.get());
      this.mUnit.setText(paramStRankingList.unit.get());
      this.mRanking.setText(paramStRankingList.ranks.get() + "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.FriendsPkViewHolder.Item
 * JD-Core Version:    0.7.0.1
 */