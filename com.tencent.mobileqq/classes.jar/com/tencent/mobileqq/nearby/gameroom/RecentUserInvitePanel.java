package com.tencent.mobileqq.nearby.gameroom;

import alpo;
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
import auvh;
import auvi;
import auvj;
import auvm;
import bcwh;
import bcxb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class RecentUserInvitePanel
  extends HorizontalScrollView
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public auvj a;
  List<auvm> jdField_a_of_type_JavaUtilList;
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
    View localView = inflate(getContext(), 2131561035, null);
    ((ImageView)localView.findViewById(2131367555)).setImageResource(2130841062);
    ((ImageView)localView.findViewById(2131367590)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131370958);
    if (i == 0) {
      localTextView.setText(alpo.a(2131713594));
    }
    for (;;)
    {
      localTextView.setMaxLines(2);
      localTextView.setSingleLine(false);
      localTextView.setGravity(1);
      ((Button)localView.findViewById(2131368415)).setVisibility(8);
      localView.setOnClickListener(new auvi(this));
      return localView;
      localTextView.setText(alpo.a(2131713595));
    }
  }
  
  private View a(auvm paramauvm)
  {
    Object localObject1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    View localView = inflate(getContext(), 2131561035, null);
    Object localObject2 = (ImageView)localView.findViewById(2131367555);
    ImageView localImageView = (ImageView)localView.findViewById(2131367590);
    int i;
    if (paramauvm.jdField_a_of_type_Int == 0)
    {
      localObject1 = bcxb.a(localQQAppInterface, 1, paramauvm.jdField_a_of_type_JavaLangString);
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
        localObject2 = (TextView)localView.findViewById(2131370958);
        localObject1 = "";
        if (paramauvm.b != null) {
          localObject1 = (String)TextUtils.ellipsize(paramauvm.b, ((TextView)localObject2).getPaint(), bcwh.a(getContext(), 65.0F), TextUtils.TruncateAt.END);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = (Button)localView.findViewById(2131368415);
        ((Button)localObject1).setOnClickListener(new auvh(this, paramauvm));
        a((View)localObject1, paramauvm.jdField_a_of_type_Boolean);
        localView.setTag(paramauvm);
        return localView;
        if (paramauvm.jdField_a_of_type_Int != 1) {
          break label220;
        }
        localObject1 = bcxb.a(localQQAppInterface, 4, paramauvm.jdField_a_of_type_JavaLangString);
        i = 2130841060;
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
        paramView.setText(alpo.a(2131713597));
        paramView.setAlpha(0.5F);
      }
    }
    else
    {
      return;
    }
    paramView.setText(alpo.a(2131713596));
  }
  
  public void a(auvm paramauvm)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView.getTag() instanceof auvm))
      {
        auvm localauvm = (auvm)localView.getTag();
        if ((localauvm.jdField_a_of_type_Int == paramauvm.jdField_a_of_type_Int) && (localauvm.jdField_a_of_type_JavaLangString.equals(paramauvm.jdField_a_of_type_JavaLangString))) {
          a((Button)localView.findViewById(2131368415), paramauvm.jdField_a_of_type_Boolean);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<auvm> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = a((auvm)paramList.next());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = bcwh.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
    }
    if (paramBoolean)
    {
      paramList = a();
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = bcwh.a(getContext(), 16.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = bcwh.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setOnClickListener(auvj paramauvj)
  {
    this.jdField_a_of_type_Auvj = paramauvj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */