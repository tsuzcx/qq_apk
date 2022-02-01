package com.tencent.qqlive.module.videoreport.utils;

class SystemUtils$DefaultVersionGetter
  extends SystemUtils.UIVersionGetterBySystemProperty
{
  SystemUtils$DefaultVersionGetter()
  {
    super(null, "ro.build.display.id");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.SystemUtils.DefaultVersionGetter
 * JD-Core Version:    0.7.0.1
 */