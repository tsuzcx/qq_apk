package com.tencent.tfm.metrics.api;

import java.util.List;

public abstract interface DimensionProvider
{
  public abstract List<String> getDimensionKeys();
  
  public abstract String getDimensionValue(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.api.DimensionProvider
 * JD-Core Version:    0.7.0.1
 */