package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class DetectCodecTimerCallbackReq
  extends ExtendableMessageNano<DetectCodecTimerCallbackReq>
{
  public String[] a;
  
  public DetectCodecTimerCallbackReq()
  {
    a();
  }
  
  public DetectCodecTimerCallbackReq a()
  {
    this.a = WireFormatNano.EMPTY_STRING_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public DetectCodecTimerCallbackReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        String[] arrayOfString = this.a;
        if (arrayOfString == null) {
          i = 0;
        } else {
          i = arrayOfString.length;
        }
        arrayOfString = new String[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfString, 0, i);
          j = i;
        }
        while (j < arrayOfString.length - 1)
        {
          arrayOfString[j] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfString[j] = paramCodedInputByteBufferNano.readString();
        this.a = arrayOfString;
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i1 = super.computeSerializedSize();
    Object localObject = this.a;
    int i = i1;
    if (localObject != null)
    {
      i = i1;
      if (localObject.length > 0)
      {
        i = 0;
        int j = 0;
        int m;
        for (int k = 0;; k = m)
        {
          localObject = this.a;
          if (i >= localObject.length) {
            break;
          }
          localObject = localObject[i];
          int n = j;
          m = k;
          if (localObject != null)
          {
            m = k + 1;
            n = j + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          i += 1;
          j = n;
        }
        i = i1 + j + k * 1;
      }
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.a;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(1, (String)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.DetectCodecTimerCallbackReq
 * JD-Core Version:    0.7.0.1
 */