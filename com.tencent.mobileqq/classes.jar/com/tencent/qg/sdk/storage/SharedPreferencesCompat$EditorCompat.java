package com.tencent.qg.sdk.storage;

import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;

public final class SharedPreferencesCompat$EditorCompat
{
  private static EditorCompat sInstance;
  private final SharedPreferencesCompat.EditorCompat.Helper mHelper = new SharedPreferencesCompat.EditorCompat.Helper();
  
  public static EditorCompat getInstance()
  {
    if (sInstance == null) {
      sInstance = new EditorCompat();
    }
    return sInstance;
  }
  
  public void apply(@NonNull SharedPreferences.Editor paramEditor)
  {
    this.mHelper.apply(paramEditor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qg.sdk.storage.SharedPreferencesCompat.EditorCompat
 * JD-Core Version:    0.7.0.1
 */