package com.tencent.tbs.log.file.clean;

import java.io.File;

public abstract interface CleanStrategy
{
  public abstract boolean shouldClean(File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.log.file.clean.CleanStrategy
 * JD-Core Version:    0.7.0.1
 */