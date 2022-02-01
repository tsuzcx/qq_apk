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
  
  public void setData(Context paramContext, STORE_APP_CLIENT.StRankingList paramStRankingList)
  {
    this.mContainer.setVisibility(0);
    try
    {
      paramContext = paramContext.getResources().getDrawable(2130840321);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramContext;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramContext;
      int i = ViewUtils.a(30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
      paramContext = URLDrawable.getDrawable(paramStRankingList.avatar.get(), (URLDrawable.URLDrawableOptions)localObject);
      paramContext.setTag(URLDrawableDecodeHandler.a(ViewUtils.a(30.0F), ViewUtils.a(30.0F)));
      paramContext.setDecodeHandler(URLDrawableDecodeHandler.n);
      this.mIcon.setImageDrawable(paramContext);
      label98:
      this.mName.setText(paramStRankingList.nick.get());
      paramContext = this.mScore;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramStRankingList.score.get());
      paramContext.setText(((StringBuilder)localObject).toString());
      this.mUnit.setText(paramStRankingList.unit.get());
      paramContext = this.mRanking;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramStRankingList.ranks.get());
      ((StringBuilder)localObject).append("");
      paramContext.setText(((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter.Item
 * JD-Core Version:    0.7.0.1
 */