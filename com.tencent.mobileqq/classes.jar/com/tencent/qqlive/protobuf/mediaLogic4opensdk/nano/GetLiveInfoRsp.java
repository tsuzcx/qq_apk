package com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GetLiveInfoRsp
  extends ExtendableMessageNano<GetLiveInfoRsp>
{
  public int a;
  public StreamInfo b;
  
  public GetLiveInfoRsp()
  {
    a();
  }
  
  public GetLiveInfoRsp a()
  {
    this.a = 0;
    this.b = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetLiveInfoRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
        {
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else
        {
          if (this.b == null) {
            this.b = new StreamInfo();
          }
          paramCodedInputByteBufferNano.readMessage(this.b);
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a);
    StreamInfo localStreamInfo = this.b;
    int i = j;
    if (localStreamInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(2, localStreamInfo);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
    StreamInfo localStreamInfo = this.b;
    if (localStreamInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, localStreamInfo);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.GetLiveInfoRsp
 * JD-Core Version:    0.7.0.1
 */