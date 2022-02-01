package com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class SetViewInfoRsp
  extends ExtendableMessageNano<SetViewInfoRsp>
{
  public ViewInfo a;
  
  public SetViewInfoRsp()
  {
    a();
  }
  
  public SetViewInfoRsp a()
  {
    this.a = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SetViewInfoRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        if (this.a == null) {
          this.a = new ViewInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    ViewInfo localViewInfo = this.a;
    int i = j;
    if (localViewInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localViewInfo);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    ViewInfo localViewInfo = this.a;
    if (localViewInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localViewInfo);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.SetViewInfoRsp
 * JD-Core Version:    0.7.0.1
 */