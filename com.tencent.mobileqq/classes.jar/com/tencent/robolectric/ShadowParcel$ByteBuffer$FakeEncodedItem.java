package com.tencent.robolectric;

import java.io.Serializable;

class ShadowParcel$ByteBuffer$FakeEncodedItem
  implements Serializable
{
  final boolean isEncodedAsAllZeroBytes;
  final int sizeBytes;
  final Object value;
  
  ShadowParcel$ByteBuffer$FakeEncodedItem(int paramInt, Object paramObject)
  {
    this.sizeBytes = paramInt;
    this.value = paramObject;
    this.isEncodedAsAllZeroBytes = ShadowParcel.ByteBuffer.a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.robolectric.ShadowParcel.ByteBuffer.FakeEncodedItem
 * JD-Core Version:    0.7.0.1
 */