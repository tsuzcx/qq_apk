package com.tencent.trpcprotocol.qlive.qlive_real_name_auth_svr.qlive_real_name_auth_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GetMQQAuthReq
  extends ExtendableMessageNano<GetMQQAuthReq>
{
  public GetMQQAuthReq()
  {
    a();
  }
  
  public GetMQQAuthReq a()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetMQQAuthReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
 * Qualified Name:     com.tencent.trpcprotocol.qlive.qlive_real_name_auth_svr.qlive_real_name_auth_svr.nano.GetMQQAuthReq
 * JD-Core Version:    0.7.0.1
 */