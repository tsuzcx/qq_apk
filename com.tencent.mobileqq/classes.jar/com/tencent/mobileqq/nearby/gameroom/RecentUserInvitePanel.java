package com.tencent.mobileqq.nearby.gameroom;

import alud;
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
import auzq;
import auzr;
import auzs;
import auzv;
import bdaq;
import bdbk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class RecentUserInvitePanel
  extends HorizontalScrollView
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public auzs a;
  List<auzv> jdField_a_of_type_JavaUtilList;
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
    View localView = inflate(getContext(), 2131561053, null);
    ((ImageView)localView.findViewById(2131367565)).setImageResource(2130841063);
    ((ImageView)localView.findViewById(2131367600)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131370977);
    if (i == 0) {
      localTextView.setText(alud.a(2131713606));
    }
    for (;;)
    {
      localTextView.setMaxLines(2);
      localTextView.setSingleLine(false);
      localTextView.setGravity(1);
      ((Button)localView.findViewById(2131368426)).setVisibility(8);
      localView.setOnClickListener(new auzr(this));
      return localView;
      localTextView.setText(alud.a(2131713607));
    }
  }
  
  private View a(auzv paramauzv)
  {
    Object localObject1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    View localView = inflate(getContext(), 2131561053, null);
    Object localObject2 = (ImageView)localView.findViewById(2131367565);
    ImageView localImageView = (ImageView)localView.findViewById(2131367600);
    int i;
    if (paramauzv.jdField_a_of_type_Int == 0)
    {
      localObject1 = bdbk.a(localQQAppInterface, 1, paramauzv.jdField_a_of_type_JavaLangString);
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
        localObject2 = (TextView)localView.findViewById(2131370977);
        localObject1 = "";
        if (paramauzv.b != null) {
          localObject1 = (String)TextUtils.ellipsize(paramauzv.b, ((TextView)localObject2).getPaint(), bdaq.a(getContext(), 65.0F), TextUtils.TruncateAt.END);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = (Button)localView.findViewById(2131368426);
        ((Button)localObject1).setOnClickListener(new auzq(this, paramauzv));
        a((View)localObject1, paramauzv.jdField_a_of_type_Boolean);
        localView.setTag(paramauzv);
        return localView;
        if (paramauzv.jdField_a_of_type_Int != 1) {
          break label220;
        }
        localObject1 = bdbk.a(localQQAppInterface, 4, paramauzv.jdField_a_of_type_JavaLangString);
        i = 2130841061;
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
        paramView.setText(alud.a(2131713609));
        paramView.setAlpha(0.5F);
      }
    }
    else
    {
      return;
    }
    paramView.setText(alud.a(2131713608));
  }
  
  public void a(auzv paramauzv)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView.getTag() instanceof auzv))
      {
        auzv localauzv = (auzv)localView.getTag();
        if ((localauzv.jdField_a_of_type_Int == paramauzv.jdField_a_of_type_Int) && (localauzv.jdField_a_of_type_JavaLangString.equals(paramauzv.jdField_a_of_type_JavaLangString))) {
          a((Button)localView.findViewById(2131368426), paramauzv.jdField_a_of_type_Boolean);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<auzv> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = a((auzv)paramList.next());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = bdaq.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
    }
    if (paramBoolean)
    {
      paramList = a();
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = bdaq.a(getContext(), 16.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = bdaq.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setOnClickListener(auzs paramauzs)
  {
    this.jdField_a_of_type_Auzs = paramauzs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */