package com.tencent.qqlive.iliveMidendRoomRankSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class CurRankInfo
  extends ExtendableMessageNano<CurRankInfo>
{
  public CurRankScore[] a;
  
  public CurRankInfo()
  {
    a();
  }
  
  public CurRankInfo a()
  {
    this.a = CurRankScore.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public CurRankInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        CurRankScore[] arrayOfCurRankScore = this.a;
        if (arrayOfCurRankScore == null) {
          i = 0;
        } else {
          i = arrayOfCurRankScore.length;
        }
        arrayOfCurRankScore = new CurRankScore[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfCurRankScore, 0, i);
          j = i;
        }
        while (j < arrayOfCurRankScore.length - 1)
        {
          arrayOfCurRankScore[j] = new CurRankScore();
          paramCodedInputByteBufferNano.readMessage(arrayOfCurRankScore[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfCurRankScore[j] = new CurRankScore();
        paramCodedInputByteBufferNano.readMessage(arrayOfCurRankScore[j]);
        this.a = arrayOfCurRankScore;
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.a;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        int j = 0;
        for (;;)
        {
          localObject = this.a;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
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
          paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.iliveMidendRoomRankSvr.nano.CurRankInfo
 * JD-Core Version:    0.7.0.1
 */