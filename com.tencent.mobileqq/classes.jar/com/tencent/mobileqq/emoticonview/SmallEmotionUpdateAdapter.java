package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class SmallEmotionUpdateAdapter
  extends EmotionDownloadOrUpdateAdapter
{
  protected int f = (this.d - (int)(18.0F * this.jdField_a_of_type_Float) * 8) / 7;
  
  public SmallEmotionUpdateAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    this.b = true;
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (SmallEmotionUpdateAdapter.SmallEmotionUpdateViewHolder)paramViewHolder;
    this.a = paramViewGroup;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      if (paramView != null) {
        break label751;
      }
      paramViewHolder = EmotionPanelViewPool.a().a(7);
      paramView = new AbsListView.LayoutParams(-1, -2);
      if (paramViewHolder == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from infalter");
        }
        paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970947, null);
        paramViewHolder.setLayoutParams(paramView);
        paramViewHolder.setPadding(0, (int)(10.0F * this.jdField_a_of_type_Float), 0, 0);
        a(7, paramViewHolder);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewHolder.findViewById(2131364477));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131364482));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramViewHolder.findViewById(2131364483));
        paramViewHolder.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a(paramViewGroup);
      paramView = paramViewHolder;
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
      }
      break;
      Object localObject;
      if (paramView == null)
      {
        paramView = EmotionPanelViewPool.a().a(2);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from infalter");
          }
          paramView = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
          paramView.setOrientation(0);
          paramView.setPadding(0, (int)(this.jdField_a_of_type_Float * 18.0F), 0, 0);
          i = 0;
          for (;;)
          {
            paramViewHolder = paramView;
            if (i >= this.jdField_a_of_type_Int) {
              break;
            }
            paramViewHolder = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
            localObject = new LinearLayout.LayoutParams(this.f, this.f);
            ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_Float * 18.0F));
            paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
            paramViewHolder.setVisibility(8);
            paramViewHolder.setScaleType(ImageView.ScaleType.FIT_XY);
            paramViewHolder.setAdjustViewBounds(false);
            paramView.addView(paramViewHolder);
            i += 1;
          }
        }
        paramViewHolder = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("SmallEmotionUpdateAdapter", 2, "getEmotionView position = " + paramInt + ";itemType = " + i + ";view from cache");
          paramViewHolder = paramView;
        }
        ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
        a(2, paramViewHolder);
        paramView = (ViewGroup)paramViewHolder;
        paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[this.jdField_a_of_type_Int];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i] = ((URLImageView)paramView.getChildAt(i));
          i += 1;
        }
        paramViewHolder.setTag(paramViewGroup);
      }
      for (;;)
      {
        i = 0;
        paramView = paramViewHolder;
        if (i >= this.jdField_a_of_type_Int) {
          break;
        }
        int j = this.jdField_a_of_type_Int * paramInt + i;
        if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setTag(null);
          paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setVisibility(8);
        }
        label744:
        for (;;)
        {
          i += 1;
          break;
          localObject = paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i];
          paramView = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((paramView instanceof EmoticonInfo)) {}
          for (paramView = (EmoticonInfo)paramView;; paramView = null)
          {
            if (paramView == null) {
              break label744;
            }
            paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setTag(paramView);
            paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setOnClickListener(this);
            ((URLImageView)localObject).setImageDrawable(paramView.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float));
            ((URLImageView)localObject).setVisibility(0);
            break;
          }
        }
        paramViewHolder = paramView;
      }
      label751:
      paramViewHolder = paramView;
    }
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new SmallEmotionUpdateAdapter.SmallEmotionUpdateViewHolder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmotionUpdateAdapter
 * JD-Core Version:    0.7.0.1
 */