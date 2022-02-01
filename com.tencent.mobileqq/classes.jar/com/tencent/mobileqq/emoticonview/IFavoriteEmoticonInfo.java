package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.widget.EditText;
import mqq.app.AppRuntime;

public abstract interface IFavoriteEmoticonInfo
{
  public abstract Drawable getBigDrawable(Context paramContext, float paramFloat, int paramInt1, int paramInt2);
  
  public abstract String getEid();
  
  public abstract String getPath();
  
  public abstract String getResID();
  
  public abstract String getUrl();
  
  public abstract void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable);
  
  public abstract void setPath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */