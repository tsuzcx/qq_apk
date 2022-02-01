package com.tencent.qqlive.roomAccess.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class SwitchStreamReply
  extends ExtendableMessageNano<SwitchStreamReply>
{
  public int a;
  public byte[] b;
  public int c;
  public byte[] d;
  public DesignatedStreamInfo e;
  
  public SwitchStreamReply()
  {
    a();
  }
  
  public SwitchStreamReply a()
  {
    this.a = 0;
    this.b = WireFormatNano.EMPTY_BYTES;
    this.c = 0;
    this.d = WireFormatNano.EMPTY_BYTES;
    this.e = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SwitchStreamReply a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 24)
          {
            if (i != 34)
            {
              if (i != 42)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else
              {
                if (this.e == null) {
                  this.e = new DesignatedStreamInfo();
                }
                paramCodedInputByteBufferNano.readMessage(this.e);
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readBytes();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readBytes();
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
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    j = i;
    if (!Arrays.equals(this.b, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(2, this.b);
    }
    k = this.c;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    j = i;
    if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
      j = i + CodedOutputByteBufferNano.computeBytesSize(4, this.d);
    }
    DesignatedStreamInfo localDesignatedStreamInfo = this.e;
    i = j;
    if (localDesignatedStreamInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(5, localDesignatedStreamInfo);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    if (!Arrays.equals(this.b, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(2, this.b);
    }
    i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(4, this.d);
    }
    DesignatedStreamInfo localDesignatedStreamInfo = this.e;
    if (localDesignatedStreamInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, localDesignatedStreamInfo);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.roomAccess.nano.SwitchStreamReply
 * JD-Core Version:    0.7.0.1
 */