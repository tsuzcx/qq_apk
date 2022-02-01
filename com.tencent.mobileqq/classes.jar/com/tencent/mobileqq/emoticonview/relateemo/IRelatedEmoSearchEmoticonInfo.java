package com.tencent.mobileqq.emoticonview.relateemo;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import mqq.app.AppRuntime;

public abstract interface IRelatedEmoSearchEmoticonInfo
{
  public abstract void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.IRelatedEmoSearchEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */