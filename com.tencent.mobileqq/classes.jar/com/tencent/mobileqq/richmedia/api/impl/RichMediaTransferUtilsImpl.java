package com.tencent.mobileqq.richmedia.api.impl;

import com.tencent.mobileqq.richmedia.IRichMediaIpSaver;
import com.tencent.mobileqq.richmedia.RichMediaIpSaver;
import com.tencent.mobileqq.richmedia.api.IRichMediaTransferUtils;

public class RichMediaTransferUtilsImpl
  implements IRichMediaTransferUtils
{
  public static final String TAG = "RichMediaTransferUtilsImpl";
  
  public IRichMediaIpSaver createRichMediaIpSaver()
  {
    return new RichMediaIpSaver();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.api.impl.RichMediaTransferUtilsImpl
 * JD-Core Version:    0.7.0.1
 */