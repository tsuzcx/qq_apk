package com.tencent.tbs.reader;

import android.content.Context;

public abstract interface ITbsReader$IReaderPlugin
{
  public abstract void destroy();
  
  public abstract int downloadPlugin(Context paramContext, String paramString);
  
  public abstract int initPlugin(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.reader.ITbsReader.IReaderPlugin
 * JD-Core Version:    0.7.0.1
 */