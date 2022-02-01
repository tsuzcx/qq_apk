package dov.com.tencent.biz.qqstory.takevideo.localmedia.baoutils.common;

import dov.com.tencent.biz.qqstory.takevideo.localmedia.baoutils.functions.Func2;

public abstract interface Callbacks$Callback<ERROR_TYPE, DATA_TYPE>
  extends Func2<ERROR_TYPE, DATA_TYPE, Void>
{
  public abstract Void a(ERROR_TYPE paramERROR_TYPE, DATA_TYPE paramDATA_TYPE);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.localmedia.baoutils.common.Callbacks.Callback
 * JD-Core Version:    0.7.0.1
 */