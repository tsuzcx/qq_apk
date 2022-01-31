package com.tencent.widget;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

public class KandianPopupWindowForAd
  extends KandianPopupWindow
{
  public KandianPopupWindowForAd(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (i < this.jdField_b_of_type_ArrayOfInt.length) {
      if (paramView.getId() != this.jdField_b_of_type_ArrayOfInt[i]) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        this.jdField_b_of_type_JavaUtilArrayList.remove(localDislikeInfo);
        if (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener != null) {
          this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener.a(paramView, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaUtilArrayList, localDislikeInfo);
        }
        dismiss();
      }
      return;
      i += 1;
      break;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.KandianPopupWindowForAd
 * JD-Core Version:    0.7.0.1
 */