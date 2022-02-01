package com.tencent.mobileqq.qqexpand.widget.search;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ExpandHorizontalTagsView
  extends LinearLayout
  implements View.OnClickListener
{
  public int a;
  public ExpandHorizontalTagsView.OnItemClickListener a;
  
  public ExpandHorizontalTagsView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public ExpandHorizontalTagsView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
  }
  
  public ExpandHorizontalTagsView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -1;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ExpandHorizontalTagsView.TagInfo))
    {
      Object localObject = (ExpandHorizontalTagsView.TagInfo)paramView.getTag();
      if (((ExpandHorizontalTagsView.TagInfo)localObject).jdField_a_of_type_Int != this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Int = ((ExpandHorizontalTagsView.TagInfo)localObject).jdField_a_of_type_Int;
        ExpandHorizontalTagsView.OnItemClickListener localOnItemClickListener = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandHorizontalTagsView$OnItemClickListener;
        if (localOnItemClickListener != null) {
          localOnItemClickListener.a(((ExpandHorizontalTagsView.TagInfo)localObject).jdField_a_of_type_JavaLangString, ((ExpandHorizontalTagsView.TagInfo)localObject).jdField_a_of_type_Int);
        }
        int i = 0;
        while (i < getChildCount())
        {
          localObject = getChildAt(i);
          boolean bool;
          if (getChildAt(i) == paramView) {
            bool = true;
          } else {
            bool = false;
          }
          ((View)localObject).setSelected(bool);
          i += 1;
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnItemClickListener(ExpandHorizontalTagsView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandHorizontalTagsView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void setSearchTags(ArrayList<String> paramArrayList, int paramInt)
  {
    if (getChildCount() > 0) {
      removeAllViews();
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      int m = DisplayUtil.a(getContext(), 13.0F);
      int n = DisplayUtil.a(getContext(), 26.0F);
      int i = 0;
      int k;
      for (int j = 0; i < paramArrayList.size(); j = k)
      {
        Object localObject = (String)paramArrayList.get(i);
        k = j;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          TextView localTextView = new TextView(getContext());
          localTextView.setText((CharSequence)localObject);
          localTextView.setTag(new ExpandHorizontalTagsView.TagInfo(this, i, (String)localObject));
          localTextView.setContentDescription((CharSequence)localObject);
          if (i == paramInt)
          {
            this.jdField_a_of_type_Int = i;
            localTextView.setSelected(true);
          }
          else
          {
            localTextView.setSelected(false);
          }
          localTextView.setOnClickListener(this);
          localTextView.setTextSize(1, 14.0F);
          localTextView.setGravity(17);
          localTextView.setClickable(true);
          localTextView.setFocusable(true);
          localTextView.setPadding(m, 0, m, 0);
          localTextView.setBackgroundResource(2130845103);
          localTextView.setTextColor(getResources().getColorStateList(2131166385));
          localObject = new LinearLayout.LayoutParams(-2, n);
          if (j > 0) {
            ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(getContext(), 8.0F);
          }
          addView(localTextView, (ViewGroup.LayoutParams)localObject);
          k = j + 1;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.search.ExpandHorizontalTagsView
 * JD-Core Version:    0.7.0.1
 */