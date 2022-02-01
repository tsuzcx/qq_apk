package com.tencent.richmediabrowser.core;

import android.content.Intent;

public abstract interface IBaseModelBuilder
{
  public abstract void buildComplete();
  
  public abstract void buildModel();
  
  public abstract void buildParams(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.IBaseModelBuilder
 * JD-Core Version:    0.7.0.1
 */