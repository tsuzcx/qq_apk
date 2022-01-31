package com.tencent.richmediabrowser.view.page;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

public class TypedArrayWarpper
{
  private TypedArray a;
  
  public TypedArrayWarpper(TypedArray paramTypedArray)
  {
    this.a = paramTypedArray;
  }
  
  public boolean getBoolean(int paramInt, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramInt >= 0) {
      bool = this.a.getBoolean(paramInt, paramBoolean);
    }
    return bool;
  }
  
  public int getColor(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getColor(paramInt1, paramInt2);
    }
    return i;
  }
  
  public ColorStateList getColorStateList(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getColorStateList(paramInt);
    }
    return null;
  }
  
  public float getDimension(int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (paramInt >= 0) {
      f = this.a.getDimension(paramInt, paramFloat);
    }
    return f;
  }
  
  public int getDimensionPixelOffset(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getDimensionPixelOffset(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int getDimensionPixelSize(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getDimensionPixelSize(paramInt1, paramInt2);
    }
    return i;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getDrawable(paramInt);
    }
    return null;
  }
  
  public float getFloat(int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (paramInt >= 0) {
      f = this.a.getFloat(paramInt, paramFloat);
    }
    return f;
  }
  
  public float getFraction(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    float f = paramFloat;
    if (paramInt1 >= 0) {
      f = this.a.getFraction(paramInt1, paramInt2, paramInt3, paramFloat);
    }
    return f;
  }
  
  public int getIndex(int paramInt)
  {
    return this.a.getIndex(paramInt);
  }
  
  public int getIndexCount()
  {
    return this.a.getIndexCount();
  }
  
  public int getInt(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getInt(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int getInteger(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getInteger(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int getLayoutDimension(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getLayoutDimension(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int getLayoutDimension(int paramInt, String paramString)
  {
    return this.a.getLayoutDimension(paramInt, paramString);
  }
  
  public String getNonResourceString(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getNonResourceString(paramInt);
    }
    return null;
  }
  
  public String getPositionDescription()
  {
    return this.a.getPositionDescription();
  }
  
  public int getResourceId(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getResourceId(paramInt1, paramInt2);
    }
    return i;
  }
  
  public Resources getResources()
  {
    return this.a.getResources();
  }
  
  public String getString(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getString(paramInt);
    }
    return null;
  }
  
  public CharSequence getText(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getText(paramInt);
    }
    return null;
  }
  
  public CharSequence[] getTextArray(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getTextArray(paramInt);
    }
    return null;
  }
  
  public boolean getValue(int paramInt, TypedValue paramTypedValue)
  {
    if (paramInt >= 0) {
      return this.a.getValue(paramInt, paramTypedValue);
    }
    return false;
  }
  
  public boolean hasValue(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.hasValue(paramInt);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public int length()
  {
    return this.a.length();
  }
  
  public TypedValue peekValue(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.peekValue(paramInt);
    }
    return null;
  }
  
  public void recycle()
  {
    this.a.recycle();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.page.TypedArrayWarpper
 * JD-Core Version:    0.7.0.1
 */