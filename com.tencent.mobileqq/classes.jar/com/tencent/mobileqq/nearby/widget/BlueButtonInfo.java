package com.tencent.mobileqq.nearby.widget;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class BlueButtonInfo
  extends ButtonInfo
{
  public BlueButtonInfo(String paramString, NearbyCustomDialog.OnClickListener paramOnClickListener)
  {
    super(paramString, paramOnClickListener);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130838491);
    this.jdField_a_of_type_Int = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.BlueButtonInfo
 * JD-Core Version:    0.7.0.1
 */