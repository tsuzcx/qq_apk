package org.extra.relinker;

import android.os.Build;
import android.os.Build.VERSION;

final class SystemLibraryLoader
  implements ReLinker.LibraryLoader
{
  public void loadLibrary(String paramString)
  {
    System.loadLibrary(paramString);
  }
  
  public void loadPath(String paramString)
  {
    System.load(paramString);
  }
  
  public String mapLibraryName(String paramString)
  {
    if ((paramString.startsWith("lib")) && (paramString.endsWith(".so"))) {
      return paramString;
    }
    return System.mapLibraryName(paramString);
  }
  
  public String[] supportedAbis()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (Build.SUPPORTED_ABIS.length > 0)) {
      return Build.SUPPORTED_ABIS;
    }
    if (!TextUtils.isEmpty(Build.CPU_ABI2)) {
      return new String[] { Build.CPU_ABI, Build.CPU_ABI2 };
    }
    return new String[] { Build.CPU_ABI };
  }
  
  public String unmapLibraryName(String paramString)
  {
    return paramString.substring(3, paramString.length() - 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.extra.relinker.SystemLibraryLoader
 * JD-Core Version:    0.7.0.1
 */