package com.tencent.mobileqq.nearby.gameroom;

import ajyc;
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
import ateg;
import ateh;
import atei;
import atel;
import bawz;
import baxt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class RecentUserInvitePanel
  extends HorizontalScrollView
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public atei a;
  List<atel> jdField_a_of_type_JavaUtilList;
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
    View localView = inflate(getContext(), 2131560853, null);
    ((ImageView)localView.findViewById(2131367427)).setImageResource(2130840947);
    ((ImageView)localView.findViewById(2131367462)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131370647);
    if (i == 0) {
      localTextView.setText(ajyc.a(2131713211));
    }
    for (;;)
    {
      localTextView.setMaxLines(2);
      localTextView.setSingleLine(false);
      localTextView.setGravity(1);
      ((Button)localView.findViewById(2131368269)).setVisibility(8);
      localView.setOnClickListener(new ateh(this));
      return localView;
      localTextView.setText(ajyc.a(2131713212));
    }
  }
  
  private View a(atel paramatel)
  {
    Object localObject1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    View localView = inflate(getContext(), 2131560853, null);
    Object localObject2 = (ImageView)localView.findViewById(2131367427);
    ImageView localImageView = (ImageView)localView.findViewById(2131367462);
    int i;
    if (paramatel.jdField_a_of_type_Int == 0)
    {
      localObject1 = baxt.a(localQQAppInterface, 1, paramatel.jdField_a_of_type_JavaLangString);
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
        localObject2 = (TextView)localView.findViewById(2131370647);
        localObject1 = "";
        if (paramatel.b != null) {
          localObject1 = (String)TextUtils.ellipsize(paramatel.b, ((TextView)localObject2).getPaint(), bawz.a(getContext(), 65.0F), TextUtils.TruncateAt.END);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = (Button)localView.findViewById(2131368269);
        ((Button)localObject1).setOnClickListener(new ateg(this, paramatel));
        a((View)localObject1, paramatel.jdField_a_of_type_Boolean);
        localView.setTag(paramatel);
        return localView;
        if (paramatel.jdField_a_of_type_Int != 1) {
          break label220;
        }
        localObject1 = baxt.a(localQQAppInterface, 4, paramatel.jdField_a_of_type_JavaLangString);
        i = 2130840945;
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
        paramView.setText(ajyc.a(2131713214));
        paramView.setAlpha(0.5F);
      }
    }
    else
    {
      return;
    }
    paramView.setText(ajyc.a(2131713213));
  }
  
  public void a(atel paramatel)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView.getTag() instanceof atel))
      {
        atel localatel = (atel)localView.getTag();
        if ((localatel.jdField_a_of_type_Int == paramatel.jdField_a_of_type_Int) && (localatel.jdField_a_of_type_JavaLangString.equals(paramatel.jdField_a_of_type_JavaLangString))) {
          a((Button)localView.findViewById(2131368269), paramatel.jdField_a_of_type_Boolean);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<atel> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = a((atel)paramList.next());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = bawz.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
    }
    if (paramBoolean)
    {
      paramList = a();
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = bawz.a(getContext(), 16.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = bawz.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setOnClickListener(atei paramatei)
  {
    this.jdField_a_of_type_Atei = paramatei;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */