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
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
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
    paramContext = LayoutInflater.from(paramContext).inflate(2131560245, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131370638));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131366870);
    paramContext = this.jdField_a_of_type_AndroidViewView.findViewById(2131377256);
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
    if ((paramDislikeInfo != null) && (!TextUtils.isEmpty(paramDislikeInfo.a)))
    {
      paramView.setVisibility(0);
      paramView.setTag(paramDislikeInfo);
      a(paramView, paramDislikeInfo, "", false);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void a(View paramView, DislikeInfo paramDislikeInfo, String paramString, boolean paramBoolean)
  {
    String str = "";
    try
    {
      localImageView = (ImageView)paramView.findViewById(2131369933);
      localTextView1 = (TextView)paramView.findViewById(2131379046);
      localTextView2 = (TextView)paramView.findViewById(2131369103);
      int j = 8;
      if (paramBoolean)
      {
        i = 0;
        break label170;
      }
      i = j;
      if (paramDislikeInfo == null) {
        break label170;
      }
      i = j;
      if (TextUtils.isEmpty(paramDislikeInfo.a)) {
        break label170;
      }
      paramView = paramDislikeInfo.a;
      i = j;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        ImageView localImageView;
        TextView localTextView1;
        TextView localTextView2;
        int i;
        continue;
        paramView = "";
      }
    }
    localTextView2.setText(paramView);
    localImageView.setVisibility(i);
    if (paramString != null) {
      localTextView1.setText(paramString);
    }
    paramView = str;
    if (paramDislikeInfo != null) {
      paramView = paramDislikeInfo.toString();
    }
    paramDislikeInfo = new StringBuilder();
    paramDislikeInfo.append("updateItemData:");
    paramDislikeInfo.append(paramView);
    paramDislikeInfo.append(" ,name:");
    paramDislikeInfo.append(paramString);
    QLog.e("NegativeChildrenLayout", 1, paramDislikeInfo.toString());
  }
  
  public void a(DislikeInfo paramDislikeInfo)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 6) {
      return;
    }
    if (paramDislikeInfo != null)
    {
      if (TextUtils.isEmpty(paramDislikeInfo.a)) {
        return;
      }
      View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560246, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView.setTag(paramDislikeInfo);
      this.jdField_a_of_type_JavaUtilArrayList.add(localView);
    }
  }
  
  public void setData(ArrayList<DislikeInfo> paramArrayList, String paramString, KandianNegativeWindow.iClickInterface paramiClickInterface)
  {
    if (paramArrayList == null) {
      return;
    }
    int i = 0;
    setVisibility(0);
    this.jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_AndroidViewView, null, paramString, true);
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
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      View localView1 = (View)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      View localView2 = localView1.findViewById(2131377256);
      int j;
      if (i == this.jdField_a_of_type_Int)
      {
        j = 4;
        localView1.setBackgroundResource(2130843062);
      }
      else
      {
        j = 0;
      }
      if (localView2 != null) {
        localView2.setVisibility(j);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.NegativeChildrenLayout
 * JD-Core Version:    0.7.0.1
 */