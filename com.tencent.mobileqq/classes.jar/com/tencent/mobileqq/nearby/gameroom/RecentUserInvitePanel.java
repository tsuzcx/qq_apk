package com.tencent.mobileqq.nearby.gameroom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anni;
import aoch;
import axgz;
import axha;
import axhb;
import axhe;
import bggq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class RecentUserInvitePanel
  extends HorizontalScrollView
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public axhb a;
  List<axhe> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public RecentUserInvitePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RecentUserInvitePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private View a()
  {
    int i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    View localView = inflate(getContext(), 2131561266, null);
    ((ImageView)localView.findViewById(2131367877)).setImageResource(2130841313);
    ((ImageView)localView.findViewById(2131367908)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131371539);
    if (i == 0) {
      localTextView.setText(anni.a(2131711985));
    }
    for (;;)
    {
      localTextView.setMaxLines(2);
      localTextView.setSingleLine(false);
      localTextView.setGravity(1);
      ((Button)localView.findViewById(2131368727)).setVisibility(8);
      localView.setOnClickListener(new axha(this));
      return localView;
      localTextView.setText(anni.a(2131711986));
    }
  }
  
  private View a(axhe paramaxhe)
  {
    Object localObject1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    View localView = inflate(getContext(), 2131561266, null);
    Object localObject2 = (ImageView)localView.findViewById(2131367877);
    ImageView localImageView = (ImageView)localView.findViewById(2131367908);
    int i;
    if (paramaxhe.jdField_a_of_type_Int == 0)
    {
      localObject1 = aoch.a(localQQAppInterface, 1, paramaxhe.jdField_a_of_type_JavaLangString);
      i = -1;
    }
    for (;;)
    {
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      if (i != -1) {
        localImageView.setImageResource(i);
      }
      for (;;)
      {
        localObject2 = (TextView)localView.findViewById(2131371539);
        localObject1 = "";
        if (paramaxhe.b != null) {
          localObject1 = (String)TextUtils.ellipsize(paramaxhe.b, ((TextView)localObject2).getPaint(), bggq.a(getContext(), 65.0F), TextUtils.TruncateAt.END);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = (Button)localView.findViewById(2131368727);
        ((Button)localObject1).setOnClickListener(new axgz(this, paramaxhe));
        a((View)localObject1, paramaxhe.jdField_a_of_type_Boolean);
        localView.setTag(paramaxhe);
        return localView;
        if (paramaxhe.jdField_a_of_type_Int != 1) {
          break label220;
        }
        localObject1 = aoch.a(localQQAppInterface, 4, paramaxhe.jdField_a_of_type_JavaLangString);
        i = 2130841311;
        break;
        localImageView.setVisibility(8);
      }
      label220:
      i = -1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
    setHorizontalScrollBarEnabled(false);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof Button))
    {
      paramView = (Button)paramView;
      if (paramBoolean)
      {
        paramView.setText(anni.a(2131711988));
        paramView.setAlpha(0.5F);
      }
    }
    else
    {
      return;
    }
    paramView.setText(anni.a(2131711987));
  }
  
  public void a(axhe paramaxhe)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView.getTag() instanceof axhe))
      {
        axhe localaxhe = (axhe)localView.getTag();
        if ((localaxhe.jdField_a_of_type_Int == paramaxhe.jdField_a_of_type_Int) && (localaxhe.jdField_a_of_type_JavaLangString.equals(paramaxhe.jdField_a_of_type_JavaLangString))) {
          a((Button)localView.findViewById(2131368727), paramaxhe.jdField_a_of_type_Boolean);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<axhe> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = a((axhe)paramList.next());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = bggq.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
    }
    if (paramBoolean)
    {
      paramList = a();
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = bggq.a(getContext(), 16.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = bggq.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setOnClickListener(axhb paramaxhb)
  {
    this.jdField_a_of_type_Axhb = paramaxhb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */