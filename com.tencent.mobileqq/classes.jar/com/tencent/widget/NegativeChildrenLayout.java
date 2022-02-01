package com.tencent.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class NegativeChildrenLayout
  extends LinearLayout
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new NegativeChildrenLayout.1(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  KandianNegativeWindow.iClickInterface jdField_a_of_type_ComTencentWidgetKandianNegativeWindow$iClickInterface;
  ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public NegativeChildrenLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  public NegativeChildrenLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560357, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131371004));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131367017);
    paramContext = this.jdField_a_of_type_AndroidViewView.findViewById(2131377830);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramContext.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    localLayoutParams.rightMargin = 0;
    paramContext.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
  }
  
  private void a(View paramView, DislikeInfo paramDislikeInfo)
  {
    if (paramView == null) {
      return;
    }
    if ((paramDislikeInfo == null) || (TextUtils.isEmpty(paramDislikeInfo.a)))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(0);
    paramView.setTag(paramDislikeInfo);
    a(paramView, paramDislikeInfo, "", false);
  }
  
  private void a(View paramView, DislikeInfo paramDislikeInfo, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        ImageView localImageView = (ImageView)paramView.findViewById(2131370265);
        TextView localTextView1 = (TextView)paramView.findViewById(2131379706);
        TextView localTextView2 = (TextView)paramView.findViewById(2131369375);
        j = 8;
        str = "";
        if (!paramBoolean) {
          continue;
        }
        i = 0;
        paramView = str;
        localTextView2.setText(paramView);
        localImageView.setVisibility(i);
        if (paramString != null) {
          localTextView1.setText(paramString);
        }
      }
      catch (Exception paramView)
      {
        int j;
        String str;
        int i;
        continue;
      }
      paramView = "";
      if (paramDislikeInfo != null) {
        paramView = paramDislikeInfo.toString();
      }
      QLog.e("NegativeChildrenLayout", 1, "updateItemData:" + paramView + " ,name:" + paramString);
      return;
      paramView = str;
      i = j;
      if (paramDislikeInfo != null)
      {
        paramView = str;
        i = j;
        if (!TextUtils.isEmpty(paramDislikeInfo.a))
        {
          paramView = paramDislikeInfo.a;
          i = j;
        }
      }
    }
  }
  
  public void a(DislikeInfo paramDislikeInfo)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 6) {}
    while ((paramDislikeInfo == null) || (TextUtils.isEmpty(paramDislikeInfo.a))) {
      return;
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560358, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localView.setTag(paramDislikeInfo);
    this.jdField_a_of_type_JavaUtilArrayList.add(localView);
  }
  
  public void setData(ArrayList<DislikeInfo> paramArrayList, String paramString, KandianNegativeWindow.iClickInterface paramiClickInterface)
  {
    if (paramArrayList == null) {
      return;
    }
    setVisibility(0);
    this.jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_AndroidViewView, null, paramString, true);
    int i = 0;
    while ((i < paramArrayList.size()) && (i < 6))
    {
      if (i > this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
        a((DislikeInfo)paramArrayList.get(i));
      }
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a((View)this.jdField_a_of_type_JavaUtilArrayList.get(i), (DislikeInfo)paramArrayList.get(i));
        this.jdField_a_of_type_Int = i;
      }
      i += 1;
    }
    setLastSeparateLineUnvis();
    i = this.jdField_a_of_type_Int + 1;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      a((View)this.jdField_a_of_type_JavaUtilArrayList.get(i), null);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow$iClickInterface = paramiClickInterface;
  }
  
  public void setLastSeparateLineUnvis()
  {
    int i = 0;
    View localView2;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      View localView1 = (View)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localView2 = localView1.findViewById(2131377830);
      if (i != this.jdField_a_of_type_Int) {
        break label68;
      }
      localView1.setBackgroundResource(2130843154);
    }
    label68:
    for (int j = 4;; j = 0)
    {
      if (localView2 != null) {
        localView2.setVisibility(j);
      }
      i += 1;
      break;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.NegativeChildrenLayout
 * JD-Core Version:    0.7.0.1
 */