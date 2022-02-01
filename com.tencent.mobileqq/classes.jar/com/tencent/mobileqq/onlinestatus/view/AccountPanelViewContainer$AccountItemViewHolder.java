package com.tencent.mobileqq.onlinestatus.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.onlinestatus.utils.WidgetUtils;
import mqq.app.MobileQQ;

public class AccountPanelViewContainer$AccountItemViewHolder
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  public AccountPanelViewContainer$AccountItemViewHolder(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363157));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378048));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371876));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380208));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363152);
  }
  
  private void a()
  {
    if (!AppSetting.d) {
      return;
    }
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject1 != null) {
      localObject1 = ((TextView)localObject1).getText().toString();
    } else {
      localObject1 = "";
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
    boolean bool2 = false;
    int i;
    if ((localObject2 != null) && ((((DragTextView)localObject2).getTag() instanceof Integer))) {
      i = ((Integer)this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.getTag()).intValue();
    } else {
      i = 0;
    }
    localObject2 = new StringBuilder();
    int j = this.jdField_a_of_type_Int;
    if (j == 2)
    {
      ((StringBuilder)localObject2).append(localMobileQQ.getString(2131719328, new Object[] { localObject1 }));
      ((StringBuilder)localObject2).append(localMobileQQ.getString(2131690703));
    }
    else if (j == 2)
    {
      ((StringBuilder)localObject2).append(localMobileQQ.getString(2131719329, new Object[] { localObject1 }));
      ((StringBuilder)localObject2).append(localMobileQQ.getString(2131690703));
    }
    else
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(localMobileQQ.getString(2131690703));
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if ((((DragTextView)localObject1).getTag(2131380208) instanceof Boolean)) {
        bool1 = ((Boolean)this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.getTag(2131380208)).booleanValue();
      }
    }
    if ((i > 0) && (!bool1))
    {
      if (i == 1)
      {
        ((StringBuilder)localObject2).append(" 有一条未读");
      }
      else if (i == 2)
      {
        ((StringBuilder)localObject2).append(" 有两条未读");
      }
      else if (i > 0)
      {
        ((StringBuilder)localObject2).append(" 有");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("条未读");
      }
    }
    else if (bool1) {
      ((StringBuilder)localObject2).append(" 有最新消息");
    }
    this.jdField_a_of_type_AndroidViewView.setContentDescription(((StringBuilder)localObject2).toString());
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt > 0)
    {
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 3;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        int j;
        if (paramBoolean) {
          j = 2130850766;
        } else {
          j = 2130850770;
        }
        WidgetUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, paramInt, j, 99, null);
      }
      else
      {
        WidgetUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, paramInt, 2130850773, 99, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131380208, Boolean.valueOf(paramBoolean));
    a();
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer.AccountItemViewHolder
 * JD-Core Version:    0.7.0.1
 */