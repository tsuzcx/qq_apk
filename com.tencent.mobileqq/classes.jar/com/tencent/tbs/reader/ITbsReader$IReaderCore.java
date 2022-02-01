package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public abstract interface ITbsReader$IReaderCore
{
  public abstract void closeFile();
  
  public abstract void destroy();
  
  public abstract boolean init(Context paramContext);
  
  public abstract void onSizeChanged(Integer paramInteger1, Integer paramInteger2);
  
  public abstract int openFile(Context paramContext, Bundle paramBundle, FrameLayout paramFrameLayout, View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.reader.ITbsReader.IReaderCore
 * JD-Core Version:    0.7.0.1
 */