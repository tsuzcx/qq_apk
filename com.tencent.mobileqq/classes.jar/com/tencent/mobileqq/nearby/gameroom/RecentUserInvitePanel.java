package com.tencent.mobileqq.nearby.gameroom;

import aepk;
import aepl;
import aepm;
import aepr;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import java.util.Iterator;
import java.util.List;

public class RecentUserInvitePanel
  extends HorizontalScrollView
{
  public aepm a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  List jdField_a_of_type_JavaUtilList;
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
    View localView = inflate(getContext(), 2130970429, null);
    ((ImageView)localView.findViewById(2131364975)).setImageResource(2130839468);
    ((ImageView)localView.findViewById(2131370503)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131362754);
    if (i == 0) {
      localTextView.setText("邀请");
    }
    for (;;)
    {
      localTextView.setMaxLines(2);
      localTextView.setSingleLine(false);
      localTextView.setGravity(1);
      ((Button)localView.findViewById(2131370504)).setVisibility(8);
      localView.setOnClickListener(new aepl(this));
      return localView;
      localTextView.setText("全部群及好友");
    }
  }
  
  private View a(aepr paramaepr)
  {
    Object localObject = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    View localView = inflate(getContext(), 2130970429, null);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131364975);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131370503);
    int i;
    if (paramaepr.jdField_a_of_type_Int == 0)
    {
      localObject = FaceDrawable.a(localQQAppInterface, 1, paramaepr.jdField_a_of_type_JavaLangString);
      i = -1;
    }
    for (;;)
    {
      localImageView1.setImageDrawable((Drawable)localObject);
      if (i != -1) {
        localImageView2.setImageResource(i);
      }
      for (;;)
      {
        localObject = (TextView)localView.findViewById(2131362754);
        ((TextView)localObject).setText((String)TextUtils.ellipsize(paramaepr.b, ((TextView)localObject).getPaint(), DisplayUtil.a(getContext(), 65.0F), TextUtils.TruncateAt.END));
        localObject = (Button)localView.findViewById(2131370504);
        ((Button)localObject).setOnClickListener(new aepk(this, paramaepr));
        a((View)localObject, paramaepr.jdField_a_of_type_Boolean);
        localView.setTag(paramaepr);
        return localView;
        if (paramaepr.jdField_a_of_type_Int != 1) {
          break label205;
        }
        localObject = FaceDrawable.a(localQQAppInterface, 4, paramaepr.jdField_a_of_type_JavaLangString);
        i = 2130839466;
        break;
        localImageView2.setVisibility(8);
      }
      label205:
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
  
  public void a(aepr paramaepr)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView.getTag() instanceof aepr))
      {
        aepr localaepr = (aepr)localView.getTag();
        if ((localaepr.jdField_a_of_type_Int == paramaepr.jdField_a_of_type_Int) && (localaepr.jdField_a_of_type_JavaLangString.equals(paramaepr.jdField_a_of_type_JavaLangString))) {
          a((Button)localView.findViewById(2131370504), paramaepr.jdField_a_of_type_Boolean);
        }
      }
      i += 1;
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof Button))
    {
      paramView = (Button)paramView;
      if (paramBoolean)
      {
        paramView.setText("已邀请");
        paramView.setAlpha(0.5F);
      }
    }
    else
    {
      return;
    }
    paramView.setText("邀请");
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = a((aepr)paramList.next());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = DisplayUtil.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
    }
    if (paramBoolean)
    {
      paramList = a();
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(getContext(), 16.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setOnClickListener(aepm paramaepm)
  {
    this.jdField_a_of_type_Aepm = paramaepm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */