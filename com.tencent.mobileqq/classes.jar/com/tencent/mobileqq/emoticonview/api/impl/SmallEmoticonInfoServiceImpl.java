package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.ISmallEmoticonInfoService;

public class SmallEmoticonInfoServiceImpl
  implements ISmallEmoticonInfoService
{
  public ISmallEmoticonInfo createSmallEmoticonInfo(String paramString)
  {
    return new SmallEmoticonInfo(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.SmallEmoticonInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */