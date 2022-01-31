package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import ajte;
import ajtf;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.homework.recite.utils.HWReciteUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditItemBase.OnEditItemListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import java.util.List;

public class ReciteTextSubViewHolder
  extends ReciteSubViewHolderBase
{
  private TextView a;
  private View b;
  
  public ReciteTextSubViewHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368468));
    this.b = ((ImageView)paramView.findViewById(2131363219));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, ajte paramajte)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368468: 
      paramHWReciteItem = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
      if ((paramHWReciteItem != null) && (paramHWReciteItem.isActive())) {
        paramHWReciteItem.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      paramHWReciteItem = (HWReciteInfo)paramajte.a;
      boolean bool1 = bool2;
      if (paramHWReciteItem.a != null)
      {
        bool1 = bool2;
        if (!paramHWReciteItem.a.isEmpty()) {
          bool1 = true;
        }
      }
      paramView = ActionSheet.d(paramView.getContext());
      paramView.a(new ajtf(this, paramView, bool1, paramHWReciteItem));
      if (bool1) {
        paramView.c("更换段落");
      }
      paramView.c("更换课文");
      paramView.d("取消");
      paramView.show();
      return;
    }
    paramHWReciteItem.a().a(paramajte);
  }
  
  public void a(HWReciteItem paramHWReciteItem, ajte paramajte, HWReciteInfo paramHWReciteInfo, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(paramHWReciteInfo.c))
    {
      StringBuilder localStringBuilder = new StringBuilder("在线背诵").append(paramHWReciteInfo.b);
      if ((paramHWReciteInfo.a != null) && (!paramHWReciteInfo.a.isEmpty())) {
        localStringBuilder.append(HWReciteUtils.a(paramHWReciteInfo.a));
      }
      paramHWReciteInfo.c = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramHWReciteInfo.c);
    if (paramInt != 1)
    {
      paramHWReciteItem.b(this.jdField_a_of_type_AndroidWidgetTextView, paramajte);
      paramHWReciteItem.b(this.b, paramajte);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.ReciteTextSubViewHolder
 * JD-Core Version:    0.7.0.1
 */