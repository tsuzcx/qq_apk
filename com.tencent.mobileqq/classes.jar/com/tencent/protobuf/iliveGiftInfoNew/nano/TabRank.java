package com.tencent.protobuf.iliveGiftInfoNew.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class TabRank
  extends MessageNano
{
  private static volatile TabRank[] _emptyArray;
  public int rank;
  public int tab;
  public String tabName;
  
  public TabRank()
  {
    clear();
  }
  
  public static TabRank[] emptyArray()
  {
    if (_emptyArray == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (_emptyArray == null) {
          _emptyArray = new TabRank[0];
        }
      }
    }
    return _emptyArray;
  }
  
  public static TabRank parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    return new TabRank().mergeFrom(paramCodedInputByteBufferNano);
  }
  
  public static TabRank parseFrom(byte[] paramArrayOfByte)
  {
    return (TabRank)MessageNano.mergeFrom(new TabRank(), paramArrayOfByte);
  }
  
  public TabRank clear()
  {
    this.tab = 0;
    this.rank = 0;
    this.tabName = "";
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.tab;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    k = this.rank;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    i = j;
    if (!this.tabName.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.tabName);
    }
    return i;
  }
  
  public TabRank mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
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
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else {
            this.tabName = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.rank = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.tab = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.tab;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    i = this.rank;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    if (!this.tabName.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.tabName);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.TabRank
 * JD-Core Version:    0.7.0.1
 */