package com.tencent.xweb.skia_canvas;

import android.util.Log;

final class XWebLibraryLoader$1
  implements IXWebLibraryLoader
{
  public boolean afterLoad()
  {
    return false;
  }
  
  public boolean beforeLoad()
  {
    return false;
  }
  
  public boolean load(String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Exception localException)
    {
      Log.e(XWebLibraryLoader.class.getSimpleName(), String.format("%s load fail %s", new Object[] { paramString, localException }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.XWebLibraryLoader.1
 * JD-Core Version:    0.7.0.1
 */