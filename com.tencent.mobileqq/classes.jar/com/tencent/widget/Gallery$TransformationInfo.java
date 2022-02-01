package com.tencent.widget;

import android.graphics.Matrix;
import android.view.ViewDebug.ExportedProperty;

class Gallery$TransformationInfo
{
  private final Matrix mMatrix = new Matrix();
  boolean mMatrixDirty = false;
  private boolean mMatrixIsIdentity = true;
  @ViewDebug.ExportedProperty
  float mPivotX = 0.0F;
  @ViewDebug.ExportedProperty
  float mPivotY = 0.0F;
  @ViewDebug.ExportedProperty
  float mRotation = 0.0F;
  @ViewDebug.ExportedProperty
  float mScaleX = 1.0F;
  @ViewDebug.ExportedProperty
  float mScaleY = 1.0F;
  @ViewDebug.ExportedProperty
  float mTranslationX = 0.0F;
  @ViewDebug.ExportedProperty
  float mTranslationY = 0.0F;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.Gallery.TransformationInfo
 * JD-Core Version:    0.7.0.1
 */