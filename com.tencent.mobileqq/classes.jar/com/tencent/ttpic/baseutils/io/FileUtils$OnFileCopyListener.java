package com.tencent.ttpic.baseutils.io;

public abstract interface FileUtils$OnFileCopyListener
{
  public abstract void onCopyFailed();
  
  public abstract void onCopyStart();
  
  public abstract void onCopySuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.io.FileUtils.OnFileCopyListener
 * JD-Core Version:    0.7.0.1
 */