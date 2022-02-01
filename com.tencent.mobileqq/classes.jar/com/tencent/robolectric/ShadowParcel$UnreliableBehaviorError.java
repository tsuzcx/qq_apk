package com.tencent.robolectric;

import java.util.Locale;

class ShadowParcel$UnreliableBehaviorError
  extends Error
{
  ShadowParcel$UnreliableBehaviorError(Class<?> paramClass, int paramInt, ShadowParcel.ByteBuffer.FakeEncodedItem paramFakeEncodedItem, String paramString)
  {
    super(String.format(localLocale, "Looking for %s at position %d, found %s [%s] taking %d bytes, %s", new Object[] { str, Integer.valueOf(paramInt), paramClass, paramFakeEncodedItem.value, Integer.valueOf(paramFakeEncodedItem.sizeBytes), paramString }));
  }
  
  ShadowParcel$UnreliableBehaviorError(String paramString)
  {
    super(paramString);
  }
  
  ShadowParcel$UnreliableBehaviorError(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.robolectric.ShadowParcel.UnreliableBehaviorError
 * JD-Core Version:    0.7.0.1
 */