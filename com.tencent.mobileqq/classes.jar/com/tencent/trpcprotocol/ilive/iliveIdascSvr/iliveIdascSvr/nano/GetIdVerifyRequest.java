package com.tencent.trpcprotocol.ilive.iliveIdascSvr.iliveIdascSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GetIdVerifyRequest
  extends ExtendableMessageNano<GetIdVerifyRequest>
{
  public GetIdVerifyRequest()
  {
    a();
  }
  
  public GetIdVerifyRequest a()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetIdVerifyRequest a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveIdascSvr.iliveIdascSvr.nano.GetIdVerifyRequest
 * JD-Core Version:    0.7.0.1
 */