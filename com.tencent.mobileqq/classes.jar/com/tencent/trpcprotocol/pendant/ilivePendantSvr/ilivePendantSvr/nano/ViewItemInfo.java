package com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class ViewItemInfo
  extends ExtendableMessageNano<ViewItemInfo>
{
  public String a;
  public String b;
  public PendantInfoData c;
  
  public ViewItemInfo()
  {
    a();
  }
  
  public ViewItemInfo a()
  {
    this.a = "";
    this.b = "";
    this.c = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public ViewItemInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 18)
        {
          if (i != 26)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new PendantInfoData();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.a.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    PendantInfoData localPendantInfoData = this.c;
    i = j;
    if (localPendantInfoData != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, localPendantInfoData);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    PendantInfoData localPendantInfoData = this.c;
    if (localPendantInfoData != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, localPendantInfoData);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.ViewItemInfo
 * JD-Core Version:    0.7.0.1
 */