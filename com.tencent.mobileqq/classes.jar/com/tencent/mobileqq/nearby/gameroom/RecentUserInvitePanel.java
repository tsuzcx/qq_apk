package com.tencent.mobileqq.nearby.gameroom;

import ajya;
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
import atei;
import atej;
import atek;
import aten;
import baxn;
import bayh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class RecentUserInvitePanel
  extends HorizontalScrollView
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public atek a;
  List<aten> jdField_a_of_type_JavaUtilList;
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
    View localView = inflate(getContext(), 2131560852, null);
    ((ImageView)localView.findViewById(2131367427)).setImageResource(2130840944);
    ((ImageView)localView.findViewById(2131367462)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131370647);
    if (i == 0) {
      localTextView.setText(ajya.a(2131713222));
    }
    for (;;)
    {
      localTextView.setMaxLines(2);
      localTextView.setSingleLine(false);
      localTextView.setGravity(1);
      ((Button)localView.findViewById(2131368269)).setVisibility(8);
      localView.setOnClickListener(new atej(this));
      return localView;
      localTextView.setText(ajya.a(2131713223));
    }
  }
  
  private View a(aten paramaten)
  {
    Object localObject1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    View localView = inflate(getContext(), 2131560852, null);
    Object localObject2 = (ImageView)localView.findViewById(2131367427);
    ImageView localImageView = (ImageView)localView.findViewById(2131367462);
    int i;
    if (paramaten.jdField_a_of_type_Int == 0)
    {
      localObject1 = bayh.a(localQQAppInterface, 1, paramaten.jdField_a_of_type_JavaLangString);
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
        if (paramaten.b != null) {
          localObject1 = (String)TextUtils.ellipsize(paramaten.b, ((TextView)localObject2).getPaint(), baxn.a(getContext(), 65.0F), TextUtils.TruncateAt.END);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = (Button)localView.findViewById(2131368269);
        ((Button)localObject1).setOnClickListener(new atei(this, paramaten));
        a((View)localObject1, paramaten.jdField_a_of_type_Boolean);
        localView.setTag(paramaten);
        return localView;
        if (paramaten.jdField_a_of_type_Int != 1) {
          break label220;
        }
        localObject1 = bayh.a(localQQAppInterface, 4, paramaten.jdField_a_of_type_JavaLangString);
        i = 2130840942;
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
        paramView.setText(ajya.a(2131713225));
        paramView.setAlpha(0.5F);
      }
    }
    else
    {
      return;
    }
    paramView.setText(ajya.a(2131713224));
  }
  
  public void a(aten paramaten)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView.getTag() instanceof aten))
      {
        aten localaten = (aten)localView.getTag();
        if ((localaten.jdField_a_of_type_Int == paramaten.jdField_a_of_type_Int) && (localaten.jdField_a_of_type_JavaLangString.equals(paramaten.jdField_a_of_type_JavaLangString))) {
          a((Button)localView.findViewById(2131368269), paramaten.jdField_a_of_type_Boolean);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<aten> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = a((aten)paramList.next());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = baxn.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
    }
    if (paramBoolean)
    {
      paramList = a();
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = baxn.a(getContext(), 16.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = baxn.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setOnClickListener(atek paramatek)
  {
    this.jdField_a_of_type_Atek = paramatek;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */