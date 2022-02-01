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
    if (_emptyArray == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (_emptyArray == null) {
        _emptyArray = new TabRank[0];
      }
      return _emptyArray;
    }
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
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.tab != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.tab);
    }
    j = i;
    if (this.rank != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, this.rank);
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
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.tab = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.rank = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      this.tabName = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.tab != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.tab);
    }
    if (this.rank != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, this.rank);
    }
    if (!this.tabName.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.tabName);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protobuf.iliveGiftInfoNew.nano.TabRank
 * JD-Core Version:    0.7.0.1
 */