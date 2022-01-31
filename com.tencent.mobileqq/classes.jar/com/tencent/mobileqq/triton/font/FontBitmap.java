package com.tencent.mobileqq.triton.font;

import android.graphics.Bitmap;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;

@TTNativeModule(name="FontBitmap")
public class FontBitmap
{
  static final String NAME = "FontBitmap";
  @TTNativeCall
  public float ascent;
  @TTNativeCall
  public Bitmap bitmap;
  @TTNativeCall
  public float descent;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.FontBitmap
 * JD-Core Version:    0.7.0.1
 */