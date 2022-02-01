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
import anzj;
import aoot;
import axzs;
import axzt;
import axzu;
import axzx;
import bhgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class RecentUserInvitePanel
  extends HorizontalScrollView
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public axzu a;
  List<axzx> jdField_a_of_type_JavaUtilList;
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
    View localView = inflate(getContext(), 2131561304, null);
    ((ImageView)localView.findViewById(2131367946)).setImageResource(2130841323);
    ((ImageView)localView.findViewById(2131367978)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131371647);
    if (i == 0) {
      localTextView.setText(anzj.a(2131712094));
    }
    for (;;)
    {
      localTextView.setMaxLines(2);
      localTextView.setSingleLine(false);
      localTextView.setGravity(1);
      ((Button)localView.findViewById(2131368801)).setVisibility(8);
      localView.setOnClickListener(new axzt(this));
      return localView;
      localTextView.setText(anzj.a(2131712095));
    }
  }
  
  private View a(axzx paramaxzx)
  {
    Object localObject1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    View localView = inflate(getContext(), 2131561304, null);
    Object localObject2 = (ImageView)localView.findViewById(2131367946);
    ImageView localImageView = (ImageView)localView.findViewById(2131367978);
    int i;
    if (paramaxzx.jdField_a_of_type_Int == 0)
    {
      localObject1 = aoot.a(localQQAppInterface, 1, paramaxzx.jdField_a_of_type_JavaLangString);
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
        localObject2 = (TextView)localView.findViewById(2131371647);
        localObject1 = "";
        if (paramaxzx.b != null) {
          localObject1 = (String)TextUtils.ellipsize(paramaxzx.b, ((TextView)localObject2).getPaint(), bhgr.a(getContext(), 65.0F), TextUtils.TruncateAt.END);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = (Button)localView.findViewById(2131368801);
        ((Button)localObject1).setOnClickListener(new axzs(this, paramaxzx));
        a((View)localObject1, paramaxzx.jdField_a_of_type_Boolean);
        localView.setTag(paramaxzx);
        return localView;
        if (paramaxzx.jdField_a_of_type_Int != 1) {
          break label220;
        }
        localObject1 = aoot.a(localQQAppInterface, 4, paramaxzx.jdField_a_of_type_JavaLangString);
        i = 2130841321;
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
        paramView.setText(anzj.a(2131712097));
        paramView.setAlpha(0.5F);
      }
    }
    else
    {
      return;
    }
    paramView.setText(anzj.a(2131712096));
  }
  
  public void a(axzx paramaxzx)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView.getTag() instanceof axzx))
      {
        axzx localaxzx = (axzx)localView.getTag();
        if ((localaxzx.jdField_a_of_type_Int == paramaxzx.jdField_a_of_type_Int) && (localaxzx.jdField_a_of_type_JavaLangString.equals(paramaxzx.jdField_a_of_type_JavaLangString))) {
          a((Button)localView.findViewById(2131368801), paramaxzx.jdField_a_of_type_Boolean);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<axzx> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = a((axzx)paramList.next());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = bhgr.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
    }
    if (paramBoolean)
    {
      paramList = a();
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = bhgr.a(getContext(), 16.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = bhgr.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setOnClickListener(axzu paramaxzu)
  {
    this.jdField_a_of_type_Axzu = paramaxzu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */