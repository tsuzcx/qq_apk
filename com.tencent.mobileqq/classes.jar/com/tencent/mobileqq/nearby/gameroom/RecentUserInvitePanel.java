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
import anvx;
import axtc;
import axtd;
import axte;
import axth;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.Iterator;
import java.util.List;

public class RecentUserInvitePanel
  extends HorizontalScrollView
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public axte a;
  List<axth> jdField_a_of_type_JavaUtilList;
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
    View localView = inflate(getContext(), 2131561240, null);
    ((ImageView)localView.findViewById(2131368115)).setImageResource(2130841365);
    ((ImageView)localView.findViewById(2131368146)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131371803);
    if (i == 0) {
      localTextView.setText(anvx.a(2131712673));
    }
    for (;;)
    {
      localTextView.setMaxLines(2);
      localTextView.setSingleLine(false);
      localTextView.setGravity(1);
      ((Button)localView.findViewById(2131368984)).setVisibility(8);
      localView.setOnClickListener(new axtd(this));
      return localView;
      localTextView.setText(anvx.a(2131712674));
    }
  }
  
  private View a(axth paramaxth)
  {
    Object localObject1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    View localView = inflate(getContext(), 2131561240, null);
    Object localObject2 = (ImageView)localView.findViewById(2131368115);
    ImageView localImageView = (ImageView)localView.findViewById(2131368146);
    int i;
    if (paramaxth.jdField_a_of_type_Int == 0)
    {
      localObject1 = FaceDrawable.getFaceDrawable(localQQAppInterface, 1, paramaxth.jdField_a_of_type_JavaLangString);
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
        localObject2 = (TextView)localView.findViewById(2131371803);
        localObject1 = "";
        if (paramaxth.b != null) {
          localObject1 = (String)TextUtils.ellipsize(paramaxth.b, ((TextView)localObject2).getPaint(), DisplayUtil.dip2px(getContext(), 65.0F), TextUtils.TruncateAt.END);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = (Button)localView.findViewById(2131368984);
        ((Button)localObject1).setOnClickListener(new axtc(this, paramaxth));
        a((View)localObject1, paramaxth.jdField_a_of_type_Boolean);
        localView.setTag(paramaxth);
        return localView;
        if (paramaxth.jdField_a_of_type_Int != 1) {
          break label220;
        }
        localObject1 = FaceDrawable.getFaceDrawable(localQQAppInterface, 4, paramaxth.jdField_a_of_type_JavaLangString);
        i = 2130841363;
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
        paramView.setText(anvx.a(2131712676));
        paramView.setAlpha(0.5F);
      }
    }
    else
    {
      return;
    }
    paramView.setText(anvx.a(2131712675));
  }
  
  public void a(axth paramaxth)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView.getTag() instanceof axth))
      {
        axth localaxth = (axth)localView.getTag();
        if ((localaxth.jdField_a_of_type_Int == paramaxth.jdField_a_of_type_Int) && (localaxth.jdField_a_of_type_JavaLangString.equals(paramaxth.jdField_a_of_type_JavaLangString))) {
          a((Button)localView.findViewById(2131368984), paramaxth.jdField_a_of_type_Boolean);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<axth> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = a((axth)paramList.next());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = DisplayUtil.dip2px(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
    }
    if (paramBoolean)
    {
      paramList = a();
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(getContext(), 16.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setOnClickListener(axte paramaxte)
  {
    this.jdField_a_of_type_Axte = paramaxte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */