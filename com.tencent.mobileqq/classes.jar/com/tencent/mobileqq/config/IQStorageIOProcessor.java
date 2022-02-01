package com.tencent.mobileqq.config;

import java.io.File;

public abstract interface IQStorageIOProcessor<RESULT, PARAM>
{
  public abstract RESULT a(File paramFile, PARAM paramPARAM);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.IQStorageIOProcessor
 * JD-Core Version:    0.7.0.1
 */