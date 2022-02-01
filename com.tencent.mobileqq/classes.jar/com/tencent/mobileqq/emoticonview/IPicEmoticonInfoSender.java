package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import java.io.Serializable;
import mqq.app.AppRuntime;

public abstract interface IPicEmoticonInfoSender<T, K>
  extends IEmoticonInfoSender<T>
{
  public abstract void send(T paramT, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable, boolean paramBoolean, int paramInt);
  
  public abstract void send(AppRuntime paramAppRuntime, Context paramContext, Parcelable paramParcelable, K paramK, Serializable paramSerializable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IPicEmoticonInfoSender
 * JD-Core Version:    0.7.0.1
 */