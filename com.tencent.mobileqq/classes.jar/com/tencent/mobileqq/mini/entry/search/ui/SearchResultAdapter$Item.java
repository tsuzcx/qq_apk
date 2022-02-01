package com.tencent.mobileqq.mini.entry.search.ui;

import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StRankingList;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;

class SearchResultAdapter$Item
{
  final View mContainer;
  final ImageView mCrown;
  final ImageView mIcon;
  final TextView mName;
  final TextView mRanking;
  final TextView mScore;
  final TextView mUnit;
  
  SearchResultAdapter$Item(View paramView)
  {
    this.mContainer = paramView;
    this.mIcon = ((ImageView)paramView.findViewById(2131371497));
    this.mCrown = ((ImageView)paramView.findViewById(2131371498));
    this.mName = ((TextView)paramView.findViewById(2131371500));
    this.mRanking = ((TextView)paramView.findViewById(2131371501));
    this.mScore = ((TextView)paramView.findViewById(2131371502));
    this.mUnit = ((TextView)paramView.findViewById(2131371493));
  }
  
  public void gone()
  {
    this.mContainer.setVisibility(8);
  }
  
  public void setData(Context paramContext, STORE_APP_CLIENT.StRankingList paramStRankingList)
  {
    this.mContainer.setVisibility(0);
    try
    {
      paramContext = paramContext.getResources().getDrawable(2130840452);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramContext;
      localURLDrawableOptions.mFailedDrawable = paramContext;
      int i = ViewUtils.a(30.0F);
      localURLDrawableOptions.mRequestHeight = i;
      localURLDrawableOptions.mRequestWidth = i;
      paramContext = URLDrawable.getDrawable(paramStRankingList.avatar.get(), localURLDrawableOptions);
      paramContext.setTag(URLDrawableDecodeHandler.a(ViewUtils.a(30.0F), ViewUtils.a(30.0F)));
      paramContext.setDecodeHandler(URLDrawableDecodeHandler.p);
      this.mIcon.setImageDrawable(paramContext);
      label98:
      this.mName.setText(paramStRankingList.nick.get());
      this.mScore.setText("" + paramStRankingList.score.get());
      this.mUnit.setText(paramStRankingList.unit.get());
      this.mRanking.setText(paramStRankingList.ranks.get() + "");
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      break label98;
    }
  }
  
  public void setOutOfRankStyle()
  {
    this.mRanking.setTextColor(-1605504);
    this.mRanking.setTypeface(Typeface.create("sans-serif-condensed", 2));
    this.mRanking.setScaleX(0.8F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter.Item
 * JD-Core Version:    0.7.0.1
 */