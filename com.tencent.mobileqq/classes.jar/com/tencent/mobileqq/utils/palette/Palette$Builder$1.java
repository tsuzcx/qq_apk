package com.tencent.mobileqq.utils.palette;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;

class Palette$Builder$1
  extends AsyncTask<Bitmap, Void, Palette>
{
  @Nullable
  protected Palette a(Bitmap... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.b.a();
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      Log.e("Palette", "Exception thrown during async generate", paramVarArgs);
    }
    return null;
  }
  
  protected void a(@Nullable Palette paramPalette)
  {
    this.a.a(paramPalette);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.Palette.Builder.1
 * JD-Core Version:    0.7.0.1
 */