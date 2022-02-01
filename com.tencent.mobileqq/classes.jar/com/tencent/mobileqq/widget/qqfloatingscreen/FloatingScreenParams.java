package com.tencent.mobileqq.widget.qqfloatingscreen;

import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class FloatingScreenParams
  implements Cloneable
{
  static final int DEFAULT_LENGTH = 500;
  public static final float DEFAULT_SCREEN_RATIO = 0.5625F;
  private static final float HORIZONTAL_MAX = 0.92F;
  private static final float HORIZONTAL_MIN = 0.5F;
  public static final int SHAPE_HORIZONTAL = 1;
  public static final int SHAPE_SQUARE = 3;
  public static final int SHAPE_VERTICAL = 2;
  private static final float SQUARE_MAX = 0.6F;
  private static final float SQUARE_MIN = 0.24F;
  private static final float VERTICAL_MAX = 0.6F;
  private static final float VERTICAL_MIN = 0.24F;
  private static boolean mShowPadding = true;
  private boolean mCanMove = true;
  private boolean mCanZoom = true;
  private int mFloatingCenterX;
  private int mFloatingCenterY = 200;
  private boolean mHasZoomed;
  private int mHeight;
  private int mHorizontalWidthMax = 500;
  private int mHorizontalWidthMin = 500;
  private int mInitialHeight = 500;
  private int mInitialWidth = 500;
  private int mOuterPadding = 2;
  private int mRoundCorner = 12;
  private int mScreenLonger = 500;
  private float mScreenRatio = 0.5625F;
  private int mShapeType = 1;
  private int mSquareLength = 300;
  private int mSquareWidthMax = 500;
  private int mSquareWidthMin = 500;
  private int mVerticalWidthMax = 500;
  private int mVerticalWidthMin = 500;
  private int mWidth;
  private float mZoomRatio = 1.0F;
  
  private FloatingScreenParams()
  {
    initParam();
  }
  
  private int getFixedWith(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.max(paramInt3, Math.min(paramInt1, paramInt2));
  }
  
  private float getZoomRatio()
  {
    return this.mZoomRatio;
  }
  
  private void initMaxWidth(int paramInt)
  {
    this.mHorizontalWidthMax = ((int)(paramInt * 0.92F));
    this.mHorizontalWidthMin = ((int)(paramInt * 0.5F));
    this.mVerticalWidthMax = ((int)(paramInt * 0.6F));
    this.mVerticalWidthMin = ((int)(paramInt * 0.24F));
    this.mSquareWidthMax = ((int)(paramInt * 0.6F));
    this.mSquareWidthMin = ((int)(paramInt * 0.24F));
  }
  
  private void setCanMove(boolean paramBoolean)
  {
    this.mCanMove = paramBoolean;
  }
  
  private void setCanZoom(boolean paramBoolean)
  {
    this.mCanZoom = paramBoolean;
  }
  
  public FloatingScreenParams clone()
  {
    try
    {
      FloatingScreenParams localFloatingScreenParams = (FloatingScreenParams)super.clone();
      return localFloatingScreenParams;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  boolean getCanMove()
  {
    return this.mCanMove;
  }
  
  public boolean getCanZoom()
  {
    return this.mCanZoom;
  }
  
  int getFloatingCenterX()
  {
    return this.mFloatingCenterX;
  }
  
  int getFloatingCenterY()
  {
    return this.mFloatingCenterY;
  }
  
  int getHeight()
  {
    return this.mHeight;
  }
  
  int getInitialHeight()
  {
    try
    {
      double d = Math.ceil(getHeight() / getZoomRatio());
      return (int)d;
    }
    catch (Exception localException) {}
    return getHeight();
  }
  
  int getInitialWidth()
  {
    try
    {
      double d = Math.ceil(getWidth() / getZoomRatio());
      return (int)d;
    }
    catch (Exception localException) {}
    return getWidth();
  }
  
  public int getInnerRoundCorner()
  {
    if (mShowPadding) {
      return this.mRoundCorner - this.mOuterPadding;
    }
    return this.mRoundCorner;
  }
  
  int getOuterHeight()
  {
    if (mShowPadding) {
      return this.mHeight + this.mOuterPadding * 2;
    }
    return this.mHeight;
  }
  
  public int getOuterRoundCorner()
  {
    return this.mRoundCorner;
  }
  
  int getOuterWidth()
  {
    if (mShowPadding) {
      return this.mWidth + this.mOuterPadding * 2;
    }
    return this.mWidth;
  }
  
  int getReboundSize()
  {
    int i = getWidth();
    switch (getShapeType())
    {
    default: 
      return getFixedWith(i, this.mHorizontalWidthMax, this.mHorizontalWidthMin);
    case 2: 
      return getFixedWith(i, this.mVerticalWidthMax, this.mVerticalWidthMin);
    }
    return getFixedWith(i, this.mSquareWidthMax, this.mSquareWidthMin);
  }
  
  int getRoundCorner()
  {
    return this.mRoundCorner;
  }
  
  public float getScreenRatio()
  {
    return this.mScreenRatio;
  }
  
  int getShapeType()
  {
    return this.mShapeType;
  }
  
  int getWidth()
  {
    return this.mWidth;
  }
  
  public void initParam()
  {
    Object localObject = BaseApplicationImpl.sApplication.getResources();
    if (localObject != null)
    {
      this.mScreenLonger = ((Resources)localObject).getDimensionPixelSize(2131298489);
      this.mSquareLength = ((Resources)localObject).getDimensionPixelSize(2131298491);
      this.mRoundCorner = ((Resources)localObject).getDimensionPixelSize(2131298490);
      this.mOuterPadding = ((Resources)localObject).getDimensionPixelSize(2131298492);
    }
    this.mWidth = this.mScreenLonger;
    this.mHeight = ((int)(this.mWidth * this.mScreenRatio));
    if (QLog.isColorLevel()) {
      QLog.d("FSParams", 2, new Object[] { "param corner:", Integer.valueOf(this.mRoundCorner), ", pad:", Integer.valueOf(this.mOuterPadding), ", width:", Integer.valueOf(this.mWidth), ", height:", Integer.valueOf(this.mHeight) });
    }
    localObject = (WindowManager)BaseApplicationImpl.sApplication.getSystemService("window");
    int j;
    if (localObject != null)
    {
      i = ((WindowManager)localObject).getDefaultDisplay().getHeight();
      j = ((WindowManager)localObject).getDefaultDisplay().getWidth();
      if (i / 2 - 214 - this.mHeight / 2 <= 0) {
        break label232;
      }
    }
    label232:
    for (int i = i / 2 - 214 - this.mHeight / 2;; i = 200)
    {
      this.mFloatingCenterY = i;
      initMaxWidth(j);
      return;
    }
  }
  
  public void setFloatingCenterX(int paramInt)
  {
    this.mFloatingCenterX = paramInt;
  }
  
  public void setFloatingCenterY(int paramInt)
  {
    this.mFloatingCenterY = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setScreenRatio(float paramFloat)
  {
    if (this.mScreenRatio != paramFloat)
    {
      this.mScreenRatio = paramFloat;
      setShapeType(this.mShapeType);
    }
  }
  
  void setShapeType(int paramInt)
  {
    int i;
    if (paramInt >= 1)
    {
      i = paramInt;
      if (paramInt <= 3) {}
    }
    else
    {
      i = 1;
    }
    this.mShapeType = i;
    switch (i)
    {
    default: 
      return;
    case 1: 
      setWidth(this.mScreenLonger);
      setHeight((int)(this.mScreenLonger * this.mScreenRatio));
      return;
    case 2: 
      setWidth((int)(this.mScreenLonger * this.mScreenRatio));
      setHeight(this.mScreenLonger);
      return;
    }
    setWidth(this.mSquareLength);
    setHeight(this.mSquareLength);
  }
  
  public void setShowPadding(boolean paramBoolean)
  {
    mShowPadding = paramBoolean;
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
  
  void updateZoomRatio(float paramFloat)
  {
    if (!this.mHasZoomed)
    {
      this.mInitialWidth = getWidth();
      this.mInitialHeight = getHeight();
      this.mZoomRatio = 1.0F;
      this.mHasZoomed = true;
    }
    int i = (int)(this.mInitialWidth * paramFloat);
    int j = (int)(this.mInitialHeight * paramFloat);
    setWidth(i);
    setHeight(j);
    switch (getShapeType())
    {
    }
    for (;;)
    {
      this.mZoomRatio = paramFloat;
      return;
      this.mScreenLonger = i;
      continue;
      this.mScreenLonger = j;
      continue;
      this.mSquareLength = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams
 * JD-Core Version:    0.7.0.1
 */