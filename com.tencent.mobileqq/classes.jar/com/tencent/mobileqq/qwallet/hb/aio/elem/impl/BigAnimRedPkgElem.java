package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

public class BigAnimRedPkgElem
  extends BaseRedPkgElem
{
  public Bitmap a;
  public AnimationView.AnimationInfo a;
  
  public BigAnimRedPkgElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramRedPacketInfo.specialBackground;
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = paramRedPacketInfo.specailBackgroundAnimInfo;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo != null) || (this.jdField_a_of_type_AndroidGraphicsBitmap != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.BigAnimRedPkgElem
 * JD-Core Version:    0.7.0.1
 */