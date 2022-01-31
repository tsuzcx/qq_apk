package com.tencent.mobileqq.extendfriend.wiget;

import aepi;
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
import aqic;
import aqid;
import java.util.ArrayList;

public class ExtendFriendHorizontalTagsView
  extends LinearLayout
  implements View.OnClickListener
{
  public int a;
  public aqic a;
  
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
    aqid localaqid;
    if ((paramView.getTag() instanceof aqid))
    {
      localaqid = (aqid)paramView.getTag();
      if (localaqid.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Int = localaqid.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Aqic != null) {
      this.jdField_a_of_type_Aqic.a(localaqid.jdField_a_of_type_JavaLangString, localaqid.jdField_a_of_type_Int);
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
  
  public void setOnItemClickListener(aqic paramaqic)
  {
    this.jdField_a_of_type_Aqic = paramaqic;
  }
  
  public void setSearchTags(ArrayList<String> paramArrayList, int paramInt)
  {
    if (getChildCount() > 0) {
      removeAllViews();
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    int m = aepi.a(13.0F, getResources());
    int n = aepi.a(26.0F, getResources());
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
        localTextView.setTag(new aqid(this, i, (String)localObject));
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
      localTextView.setBackgroundResource(2130844775);
      localTextView.setTextColor(getResources().getColorStateList(2131166268));
      localObject = new LinearLayout.LayoutParams(-2, n);
      if (j > 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = aepi.a(8.0F, getResources());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendHorizontalTagsView
 * JD-Core Version:    0.7.0.1
 */