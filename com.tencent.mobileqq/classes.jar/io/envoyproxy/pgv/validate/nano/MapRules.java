package io.envoyproxy.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class MapRules
  extends ExtendableMessageNano<MapRules>
{
  public long a;
  public long b;
  public boolean c;
  public FieldRules d;
  public FieldRules e;
  
  public MapRules()
  {
    a();
  }
  
  public MapRules a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = false;
    this.d = null;
    this.e = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public MapRules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
                  this.e = new FieldRules();
                }
                paramCodedInputByteBufferNano.readMessage(this.e);
              }
            }
            else
            {
              if (this.d == null) {
                this.d = new FieldRules();
              }
              paramCodedInputByteBufferNano.readMessage(this.d);
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readBool();
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
    boolean bool = this.c;
    i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(3, bool);
    }
    FieldRules localFieldRules = this.d;
    j = i;
    if (localFieldRules != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, localFieldRules);
    }
    localFieldRules = this.e;
    i = j;
    if (localFieldRules != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(5, localFieldRules);
    }
    return i;
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
    boolean bool = this.c;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(3, bool);
    }
    FieldRules localFieldRules = this.d;
    if (localFieldRules != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, localFieldRules);
    }
    localFieldRules = this.e;
    if (localFieldRules != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, localFieldRules);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.envoyproxy.pgv.validate.nano.MapRules
 * JD-Core Version:    0.7.0.1
 */