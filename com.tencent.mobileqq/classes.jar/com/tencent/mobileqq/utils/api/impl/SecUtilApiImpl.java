package com.tencent.mobileqq.utils.api.impl;

import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.api.ISecUtilApi;

public class SecUtilApiImpl
  implements ISecUtilApi
{
  public String getFileMd5(String paramString)
  {
    return SecUtil.getFileMd5(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.api.impl.SecUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */