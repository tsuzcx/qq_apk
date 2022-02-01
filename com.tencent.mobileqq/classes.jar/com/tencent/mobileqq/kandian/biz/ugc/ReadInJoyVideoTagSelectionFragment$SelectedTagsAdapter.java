package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;

class ReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter
  extends ReadInJoyVideoTagSelectionFragment.TagsAdapter
{
  ReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public boolean a()
  {
    return getCount() == 5;
  }
  
  public boolean a(@NonNull TagInfo paramTagInfo)
  {
    int i = getCount();
    super.a(paramTagInfo);
    return i != getCount();
  }
  
  @NonNull
  public View getView(int paramInt, @Nullable View paramView, @NonNull ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramView.setSelected(true);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyVideoTagSelectionFragment.SelectedTagsAdapter
 * JD-Core Version:    0.7.0.1
 */