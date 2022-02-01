package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;

public class VipRedPkgElem
  extends BaseRedPkgElem
{
  public Bitmap a;
  public ICustomizeStrategyFactory.AnimConfig a;
  public boolean a;
  public Drawable[] a;
  
  public VipRedPkgElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap;
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramRedPacketInfo.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$AnimConfig = paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$AnimConfig;
      this.jdField_a_of_type_Boolean = paramRedPacketInfo.b;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) || (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.VipRedPkgElem
 * JD-Core Version:    0.7.0.1
 */