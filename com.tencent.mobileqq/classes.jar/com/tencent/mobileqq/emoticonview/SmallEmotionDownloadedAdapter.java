package com.tencent.mobileqq.emoticonview;

import abzs;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class SmallEmotionDownloadedAdapter
  extends BaseEmotionAdapter
{
  BaseChatPie a;
  public EmoticonPackage a;
  protected EmoticonCallback b;
  protected int f;
  private int g;
  
  public SmallEmotionDownloadedAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.g = paramInt4;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    this.b = paramEmoticonCallback;
    this.f = ((this.d - (int)(18.0F * this.jdField_a_of_type_Float) * 8) / 7);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)paramViewHolder;
    int i;
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label868;
      }
      paramView = EmotionPanelViewPool.a().a(this.c);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.g);
        paramView.setPanelType(EmoticonPanelLinearLayout.c);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        paramView.setPadding(0, (int)(18.0F * this.jdField_a_of_type_Float), 0, 0);
        i = 0;
        for (;;)
        {
          paramViewHolder = paramView;
          if (i >= this.jdField_a_of_type_Int) {
            break;
          }
          paramViewHolder = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
          paramViewGroup = new LinearLayout.LayoutParams(this.f, this.f);
          paramViewGroup.leftMargin = ((int)(18.0F * this.jdField_a_of_type_Float));
          paramViewHolder.setLayoutParams(paramViewGroup);
          paramViewHolder.setVisibility(8);
          paramViewHolder.setScaleType(ImageView.ScaleType.FIT_XY);
          paramViewHolder.setAdjustViewBounds(false);
          paramViewHolder.setFocusable(true);
          paramViewHolder.setFocusableInTouchMode(true);
          paramView.addView(paramViewHolder);
          i += 1;
        }
      }
      paramViewHolder = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("SmallEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramViewHolder = paramView;
      }
      ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.b);
      a(this.c, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).jdField_a_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).jdField_a_of_type_ArrayOfComTencentImageURLImageView[i] = ((URLImageView)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(localObject1);
    }
    for (;;)
    {
      i = 0;
      paramView = paramViewHolder;
      int j;
      if (i < this.jdField_a_of_type_Int)
      {
        j = this.jdField_a_of_type_Int * paramInt + i;
        if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localObject1.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setTag(null);
          localObject1.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setVisibility(8);
        }
      }
      label793:
      label843:
      label854:
      label866:
      for (;;)
      {
        i += 1;
        break;
        paramViewGroup = localObject1.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i];
        paramView = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(j);
        if ((paramView instanceof EmoticonInfo)) {}
        for (paramView = (EmoticonInfo)paramView;; paramView = null)
        {
          if (paramView == null) {
            break label866;
          }
          localObject1.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setTag(paramView);
          paramViewGroup.setImageDrawable(paramView.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float));
          paramViewGroup.setVisibility(0);
          break;
          if (paramView == null)
          {
            paramViewGroup = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
            paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(46.0F * this.jdField_a_of_type_Float)));
            LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
            paramViewHolder = new RelativeLayout.LayoutParams(-2, -2);
            paramViewHolder.addRule(13, -1);
            localLinearLayout.setLayoutParams(paramViewHolder);
            paramView = EmoticonRecDressup.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, true);
            Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
            localLinearLayout.setOrientation(0);
            ((LinearLayout.LayoutParams)localObject2).gravity = 16;
            TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
            localTextView.setTextSize(14.0F);
            if (paramView.a)
            {
              paramViewHolder = "查看更多相关装扮";
              localTextView.setText(paramViewHolder);
              localTextView.setTextColor(-8947849);
              localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject2);
              paramViewHolder = new LinearLayout.LayoutParams(-2, -2);
              paramViewHolder.leftMargin = ((int)(5.0F * this.jdField_a_of_type_Float));
              paramViewHolder.gravity = 16;
              localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
              ((ImageView)localObject2).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843837));
              localLinearLayout.addView((View)localObject2, paramViewHolder);
              paramViewGroup.addView(localLinearLayout);
              ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = localLinearLayout;
              ((SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new abzs(this, paramView));
              paramViewGroup.setTag(localObject1);
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
                break label843;
              }
              paramViewHolder = "";
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
              if (!paramView.a) {
                break label854;
              }
            }
            for (paramView = "1";; paramView = "2")
            {
              VasWebviewUtil.reportCommercialDrainage(paramViewHolder, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject1, paramView);
              paramView = paramViewGroup;
              return paramView;
              paramViewHolder = "查看作者更多作品";
              break;
              paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              break label793;
            }
          }
          return paramView;
        }
      }
      label868:
      paramViewHolder = paramView;
    }
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new SmallEmotionDownloadedAdapter.SmallEmotionDownloadedViewHolder();
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 0)
    {
      if (this.g == 1) {
        return i;
      }
      return i + 1;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.g == 1) {}
    while (paramInt != getCount() - 1) {
      return 0;
    }
    return 1;
  }
  
  public int getViewTypeCount()
  {
    if (this.g == 1) {
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmotionDownloadedAdapter
 * JD-Core Version:    0.7.0.1
 */