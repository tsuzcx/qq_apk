package com.tencent.trpcprotocol.qlive.live_lottery_server.announce.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class SetAnnounceRsp
  extends ExtendableMessageNano<SetAnnounceRsp>
{
  public SetAnnounceRsp()
  {
    a();
  }
  
  public SetAnnounceRsp a()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SetAnnounceRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
 * Qualified Name:     com.tencent.trpcprotocol.qlive.live_lottery_server.announce.nano.SetAnnounceRsp
 * JD-Core Version:    0.7.0.1
 */