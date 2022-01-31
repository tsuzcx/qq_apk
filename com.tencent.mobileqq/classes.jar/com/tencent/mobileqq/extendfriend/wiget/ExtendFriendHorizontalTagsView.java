package com.tencent.mobileqq.extendfriend.wiget;

import actj;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aola;
import aolb;
import java.util.ArrayList;

public class ExtendFriendHorizontalTagsView
  extends LinearLayout
  implements View.OnClickListener
{
  public int a;
  public aola a;
  
  public ExtendFriendHorizontalTagsView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public ExtendFriendHorizontalTagsView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
  }
  
  public ExtendFriendHorizontalTagsView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -1;
  }
  
  public void onClick(View paramView)
  {
    aolb localaolb;
    if ((paramView.getTag() instanceof aolb))
    {
      localaolb = (aolb)paramView.getTag();
      if (localaolb.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Int = localaolb.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Aola != null) {
      this.jdField_a_of_type_Aola.a(localaolb.jdField_a_of_type_JavaLangString, localaolb.jdField_a_of_type_Int);
    }
    int i = 0;
    label64:
    if (i < getChildCount())
    {
      if (getChildAt(i) != paramView) {
        break label97;
      }
      getChildAt(i).setSelected(true);
    }
    for (;;)
    {
      i += 1;
      break label64;
      break;
      label97:
      getChildAt(i).setSelected(false);
    }
  }
  
  public void setOnItemClickListener(aola paramaola)
  {
    this.jdField_a_of_type_Aola = paramaola;
  }
  
  public void setSearchTags(ArrayList<String> paramArrayList, int paramInt)
  {
    if (getChildCount() > 0) {
      removeAllViews();
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    int m = actj.a(13.0F, getResources());
    int n = actj.a(26.0F, getResources());
    int i = 0;
    int j = 0;
    label50:
    Object localObject;
    int k;
    TextView localTextView;
    if (i < paramArrayList.size())
    {
      localObject = (String)paramArrayList.get(i);
      k = j;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localTextView = new TextView(getContext());
        localTextView.setText((CharSequence)localObject);
        localTextView.setTag(new aolb(this, i, (String)localObject));
        localTextView.setContentDescription((CharSequence)localObject);
        if (i != paramInt) {
          break label261;
        }
        this.jdField_a_of_type_Int = i;
        localTextView.setSelected(true);
      }
    }
    for (;;)
    {
      localTextView.setOnClickListener(this);
      localTextView.setTextSize(1, 14.0F);
      localTextView.setGravity(17);
      localTextView.setClickable(true);
      localTextView.setFocusable(true);
      localTextView.setPadding(m, 0, m, 0);
      localTextView.setBackgroundResource(2130844346);
      localTextView.setTextColor(getResources().getColorStateList(2131166219));
      localObject = new LinearLayout.LayoutParams(-2, n);
      if (j > 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = actj.a(8.0F, getResources());
      }
      addView(localTextView, (ViewGroup.LayoutParams)localObject);
      k = j + 1;
      i += 1;
      j = k;
      break label50;
      break;
      label261:
      localTextView.setSelected(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendHorizontalTagsView
 * JD-Core Version:    0.7.0.1
 */