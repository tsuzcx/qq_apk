package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;

public abstract interface FaceDecodeTask$DecodeCompletionListener
{
  public abstract void a(AppInterface paramAppInterface, FaceInfo paramFaceInfo);
  
  public abstract void a(FaceInfo paramFaceInfo, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDecodeTask.DecodeCompletionListener
 * JD-Core Version:    0.7.0.1
 */