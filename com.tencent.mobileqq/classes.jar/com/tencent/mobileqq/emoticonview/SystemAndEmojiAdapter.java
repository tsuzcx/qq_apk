package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class SystemAndEmojiAdapter
  extends BaseEmotionAdapter
{
  public BaseChatPie a;
  protected int f;
  protected int g;
  private int h = -1;
  private int i;
  
  public SystemAndEmojiAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.i = paramInt4;
    this.f = ((int)(this.jdField_a_of_type_Float * 30.0F));
    this.g = ((this.d - (int)(18.0F * this.jdField_a_of_type_Float) * 2 - this.f * 7) / 6);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    SystemAndEmojiAdapter.SystemAndEmojiHolder localSystemAndEmojiHolder = (SystemAndEmojiAdapter.SystemAndEmojiHolder)paramViewHolder;
    if (getItemViewType(paramInt) == 0)
    {
      paramViewHolder = paramView;
      if (paramView == null)
      {
        paramViewHolder = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView = new LinearLayout.LayoutParams(-2, -2);
        paramView.topMargin = ((int)(6.0F * this.jdField_a_of_type_Float));
        paramView.leftMargin = ((int)(18.0F * this.jdField_a_of_type_Float));
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setTextSize(8.0F);
        paramViewGroup.setTextColor(-4473925);
        paramViewHolder.addView(paramViewGroup, paramView);
        localSystemAndEmojiHolder.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup;
        paramViewHolder.setTag(localSystemAndEmojiHolder);
      }
      paramView = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int * paramInt);
      if (!(paramView instanceof SystemAndEmojiEmoticonInfo)) {
        break label957;
      }
    }
    label957:
    for (paramView = (SystemAndEmojiEmoticonInfo)paramView;; paramView = null)
    {
      if (paramView != null) {}
      for (paramView = paramView.c;; paramView = "")
      {
        localSystemAndEmojiHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
        if (QLog.isColorLevel()) {
          QLog.d("SystemAndEmojiAdapter", 2, "getEmoticonView cost = " + (System.currentTimeMillis() - l1));
        }
        return paramViewHolder;
        int j;
        if (paramView == null)
        {
          paramView = EmotionPanelViewPool.a().a(this.c);
          if (paramView == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SystemAndEmojiAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
            }
            paramView = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.i);
            paramView.setPanelType(EmoticonPanelLinearLayout.jdField_a_of_type_Int);
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            paramView.setOrientation(0);
            j = 0;
            paramViewHolder = paramView;
            if (j < this.jdField_a_of_type_Int)
            {
              paramViewHolder = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
              paramViewGroup = new LinearLayout.LayoutParams(this.f, this.f);
              if (j == 0) {}
              for (paramViewGroup.leftMargin = ((int)(18.0F * this.jdField_a_of_type_Float));; paramViewGroup.leftMargin = this.g)
              {
                paramViewHolder.setLayoutParams(paramViewGroup);
                paramViewHolder.setVisibility(8);
                paramViewHolder.setScaleType(ImageView.ScaleType.FIT_XY);
                paramViewHolder.setAdjustViewBounds(false);
                paramViewHolder.setFocusable(true);
                paramViewHolder.setFocusableInTouchMode(true);
                paramView.addView(paramViewHolder);
                j += 1;
                break;
              }
            }
          }
          else
          {
            paramViewHolder = paramView;
            if (QLog.isColorLevel())
            {
              QLog.d("SystemAndEmojiAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
              paramViewHolder = paramView;
            }
          }
          ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
          a(this.c, paramViewHolder);
          paramView = (ViewGroup)paramViewHolder;
          localSystemAndEmojiHolder.jdField_a_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[this.jdField_a_of_type_Int];
          j = 0;
          while (j < this.jdField_a_of_type_Int)
          {
            localSystemAndEmojiHolder.jdField_a_of_type_ArrayOfComTencentImageURLImageView[j] = ((URLImageView)paramView.getChildAt(j));
            j += 1;
          }
          paramViewHolder.setTag(localSystemAndEmojiHolder);
        }
        for (;;)
        {
          j = (int)(12.0F * this.jdField_a_of_type_Float);
          if ((paramInt == 1) || (paramInt == 5)) {
            j = (int)(7.0F * this.jdField_a_of_type_Float);
          }
          paramViewHolder.setPadding(0, j, 0, 0);
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("SystemAndEmojiAdapter", 2, "inflater view cost = " + (l2 - l1));
          }
          j = 0;
          while (j < this.jdField_a_of_type_Int)
          {
            int k = this.jdField_a_of_type_Int * paramInt + j;
            if (k > this.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localSystemAndEmojiHolder.jdField_a_of_type_ArrayOfComTencentImageURLImageView[j].setVisibility(8);
              j += 1;
            }
            else
            {
              URLImageView localURLImageView = localSystemAndEmojiHolder.jdField_a_of_type_ArrayOfComTencentImageURLImageView[j];
              paramView = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(k);
              if ((paramView instanceof SystemAndEmojiEmoticonInfo)) {}
              for (paramView = (SystemAndEmojiEmoticonInfo)paramView;; paramView = null)
              {
                if (paramView == null)
                {
                  localURLImageView.setVisibility(8);
                  break;
                }
                localSystemAndEmojiHolder.jdField_a_of_type_ArrayOfComTencentImageURLImageView[j].setTag(paramView);
                if (paramView.b == -1)
                {
                  localURLImageView.setVisibility(8);
                  break;
                }
                localURLImageView.setVisibility(0);
                l2 = System.currentTimeMillis();
                paramViewGroup = paramView.a(false);
                if (QLog.isColorLevel()) {
                  QLog.d("SystemAndEmojiAdapter", 2, "getdrawable cost = " + (System.currentTimeMillis() - l2));
                }
                localURLImageView.setImageDrawable(paramViewGroup);
                if (paramView.jdField_a_of_type_Int == 1)
                {
                  paramViewGroup = EmotcationConstants.a[paramView.b];
                  paramView = paramViewGroup;
                  if (paramViewGroup != null)
                  {
                    paramView = paramViewGroup;
                    if (paramViewGroup.startsWith("/"))
                    {
                      paramView = paramViewGroup;
                      if (paramViewGroup.length() > 1) {
                        paramView = paramViewGroup.substring(1);
                      }
                    }
                  }
                  if (paramView == null) {
                    break;
                  }
                  localURLImageView.setContentDescription(paramView);
                  break;
                }
                if (paramView.jdField_a_of_type_Int == 2)
                {
                  localURLImageView.setContentDescription(EmotcationConstants.a(paramView.b));
                  break;
                }
                localURLImageView.setContentDescription("未知");
                break;
              }
            }
          }
          break;
          paramViewHolder = paramView;
        }
      }
    }
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new SystemAndEmojiAdapter.SystemAndEmojiHolder();
  }
  
  public void a(List paramList)
  {
    int j = 0;
    super.a(paramList);
    if (SystemEmoticonInfo.b.length > 0)
    {
      int k = SystemEmoticonInfo.b[0];
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label119;
      }
      int m = paramList.size();
      if (j >= m) {
        break label119;
      }
      Object localObject = (EmotionPanelData)paramList.get(j);
      if ((localObject == null) || (!(localObject instanceof SystemAndEmojiEmoticonInfo))) {
        break label112;
      }
      localObject = (SystemAndEmojiEmoticonInfo)localObject;
      if ((((SystemAndEmojiEmoticonInfo)localObject).jdField_a_of_type_Boolean) || (((SystemAndEmojiEmoticonInfo)localObject).b != k)) {
        break label112;
      }
    }
    for (;;)
    {
      if (j != -1) {
        this.h = (j / this.jdField_a_of_type_Int);
      }
      return;
      label112:
      j += 1;
      break;
      label119:
      j = -1;
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView != null) && (this.h >= 0))
    {
      int k = this.h - 2;
      int j = k;
      if (k < 0) {
        j = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setSelection(j);
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(paramInt * 7);
    if ((localObject instanceof SystemAndEmojiEmoticonInfo)) {}
    for (localObject = (SystemAndEmojiEmoticonInfo)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        if (((SystemAndEmojiEmoticonInfo)localObject).jdField_a_of_type_Int == 3) {
          return 0;
        }
        return 1;
      }
      return -1;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiAdapter
 * JD-Core Version:    0.7.0.1
 */