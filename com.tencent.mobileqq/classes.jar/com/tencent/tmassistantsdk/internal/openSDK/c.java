package com.tencent.tmassistantsdk.internal.openSDK;

import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistantbase.util.a;

public class c
{
  public static String a(String paramString)
  {
    return a.b(ProtocolPackage.encrypt(paramString.getBytes(), "ji*9^&43U0X-~./(".getBytes()), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.c
 * JD-Core Version:    0.7.0.1
 */