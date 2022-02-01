package com.tencent.trpcprotocol.qlive.config_center_svr.config_center_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GetStaticConfigReq
  extends ExtendableMessageNano<GetStaticConfigReq>
{
  public GetStaticConfigReq()
  {
    a();
  }
  
  public GetStaticConfigReq a()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetStaticConfigReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
 * Qualified Name:     com.tencent.trpcprotocol.qlive.config_center_svr.config_center_svr.nano.GetStaticConfigReq
 * JD-Core Version:    0.7.0.1
 */