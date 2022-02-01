package org.extra.relinker;

public abstract interface ReLinker$LibraryLoader
{
  public abstract void loadLibrary(String paramString);
  
  public abstract void loadPath(String paramString);
  
  public abstract String mapLibraryName(String paramString);
  
  public abstract String[] supportedAbis();
  
  public abstract String unmapLibraryName(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.extra.relinker.ReLinker.LibraryLoader
 * JD-Core Version:    0.7.0.1
 */