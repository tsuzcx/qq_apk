package com.tencent.mobileqq.colornote.launcher;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;

public abstract interface ILauncher
{
  public abstract int getType();
  
  public abstract void launch(Context paramContext, ColorNote paramColorNote);
  
  public abstract void onCreate(Context paramContext, ColorNote paramColorNote, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.launcher.ILauncher
 * JD-Core Version:    0.7.0.1
 */