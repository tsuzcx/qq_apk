package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import mqq.app.AppRuntime;

public abstract interface IEmoticonInfoSender<T>
{
  public abstract void send(T paramT, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IEmoticonInfoSender
 * JD-Core Version:    0.7.0.1
 */