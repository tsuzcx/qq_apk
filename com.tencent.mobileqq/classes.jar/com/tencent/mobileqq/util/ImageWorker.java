package com.tencent.mobileqq.util;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import java.util.Map;
import java.util.WeakHashMap;

public class ImageWorker
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable();
  private ImageCache jdField_a_of_type_ComTencentMobileqqUtilImageCache;
  private Map jdField_a_of_type_JavaUtilMap = new WeakHashMap();
  protected int b;
  
  public ImageWorker(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqUtilImageCache = new ImageCache(ReflectionUtil.a(paramContext) / 8);
  }
  
  public ImageCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUtilImageCache;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageWorker
 * JD-Core Version:    0.7.0.1
 */