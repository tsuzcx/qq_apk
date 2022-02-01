package com.tencent.trpcprotocol.qlive.live_lottery_server.announce.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MapFactories.MapFactory;
import java.util.Map;

public final class SetAnnounceReq
  extends ExtendableMessageNano<SetAnnounceReq>
{
  public long a;
  public long b;
  public String c;
  public Map<Integer, String> d;
  
  public SetAnnounceReq()
  {
    a();
  }
  
  public SetAnnounceReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = "";
    this.d = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SetAnnounceReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    MapFactories.MapFactory localMapFactory = MapFactories.getMapFactory();
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          if (i != 26)
          {
            if (i != 34)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else {
              this.d = InternalNano.mergeMapEntry(paramCodedInputByteBufferNano, this.d, localMapFactory, 5, 9, null, 8, 18);
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    long l = this.a;
    int i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    l = this.b;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    i = j;
    if (!this.c.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    Map localMap = this.d;
    j = i;
    if (localMap != null) {
      j = i + InternalNano.computeMapFieldSize(localMap, 4, 5, 9);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    Map localMap = this.d;
    if (localMap != null) {
      InternalNano.serializeMapField(paramCodedOutputByteBufferNano, localMap, 4, 5, 9);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qlive.live_lottery_server.announce.nano.SetAnnounceReq
 * JD-Core Version:    0.7.0.1
 */