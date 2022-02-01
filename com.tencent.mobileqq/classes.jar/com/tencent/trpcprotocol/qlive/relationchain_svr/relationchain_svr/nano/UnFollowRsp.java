package com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class UnFollowRsp
  extends ExtendableMessageNano<UnFollowRsp>
{
  public UnFollowRsp()
  {
    a();
  }
  
  public UnFollowRsp a()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public UnFollowRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    int i;
    do
    {
      i = paramCodedInputByteBufferNano.readTag();
    } while ((i != 0) && (storeUnknownField(paramCodedInputByteBufferNano, i)));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano.UnFollowRsp
 * JD-Core Version:    0.7.0.1
 */