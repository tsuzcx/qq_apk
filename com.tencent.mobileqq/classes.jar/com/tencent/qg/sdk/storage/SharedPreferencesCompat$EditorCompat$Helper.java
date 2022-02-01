package com.tencent.qg.sdk.storage;

import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;

class SharedPreferencesCompat$EditorCompat$Helper
{
  public void apply(@NonNull SharedPreferences.Editor paramEditor)
  {
    try
    {
      paramEditor.apply();
      return;
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      label7:
      break label7;
    }
    paramEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.storage.SharedPreferencesCompat.EditorCompat.Helper
 * JD-Core Version:    0.7.0.1
 */