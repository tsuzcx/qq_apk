package com.tencent.viola.commons;

public class ImageAdapterHolder
{
  public static String BUNDLE_HEIGHT = "bundle_img_real_height";
  public static String BUNDLE_WIDTH = "bundle_img_real_width";
  private ImageAdapterHolder.ImageListener mImageListener;
  private ImageAdapterHolder.ImgSpanListener mImgSpanListener;
  
  public ImageAdapterHolder.ImageListener getImageListener()
  {
    return this.mImageListener;
  }
  
  public ImageAdapterHolder.ImgSpanListener getImgSpanListener()
  {
    return this.mImgSpanListener;
  }
  
  public void setImageListener(ImageAdapterHolder.ImageListener paramImageListener)
  {
    this.mImageListener = paramImageListener;
  }
  
  public void setImgSpanListener(ImageAdapterHolder.ImgSpanListener paramImgSpanListener)
  {
    this.mImgSpanListener = paramImgSpanListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.commons.ImageAdapterHolder
 * JD-Core Version:    0.7.0.1
 */