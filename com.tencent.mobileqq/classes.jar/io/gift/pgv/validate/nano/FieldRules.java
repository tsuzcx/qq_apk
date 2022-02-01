package io.gift.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class FieldRules
  extends ExtendableMessageNano<FieldRules>
{
  public MessageRules a;
  private int b = 0;
  private Object c;
  
  public FieldRules()
  {
    b();
  }
  
  public FieldRules a()
  {
    this.b = 0;
    this.c = null;
    return this;
  }
  
  public FieldRules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
        break;
      case 178: 
        if (this.b != 22) {
          this.c = new TimestampRules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 22;
        break;
      case 170: 
        if (this.b != 21) {
          this.c = new DurationRules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 21;
        break;
      case 162: 
        if (this.b != 20) {
          this.c = new AnyRules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 20;
        break;
      case 154: 
        if (this.b != 19) {
          this.c = new MapRules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 19;
        break;
      case 146: 
        if (this.b != 18) {
          this.c = new RepeatedRules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 18;
        break;
      case 138: 
        if (this.a == null) {
          this.a = new MessageRules();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
        break;
      case 130: 
        if (this.b != 16) {
          this.c = new EnumRules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 16;
        break;
      case 122: 
        if (this.b != 15) {
          this.c = new BytesRules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 15;
        break;
      case 114: 
        if (this.b != 14) {
          this.c = new StringRules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 14;
        break;
      case 106: 
        if (this.b != 13) {
          this.c = new BoolRules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 13;
        break;
      case 98: 
        if (this.b != 12) {
          this.c = new SFixed64Rules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 12;
        break;
      case 90: 
        if (this.b != 11) {
          this.c = new SFixed32Rules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 11;
        break;
      case 82: 
        if (this.b != 10) {
          this.c = new Fixed64Rules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 10;
        break;
      case 74: 
        if (this.b != 9) {
          this.c = new Fixed32Rules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 9;
        break;
      case 66: 
        if (this.b != 8) {
          this.c = new SInt64Rules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 8;
        break;
      case 58: 
        if (this.b != 7) {
          this.c = new SInt32Rules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 7;
        break;
      case 50: 
        if (this.b != 6) {
          this.c = new UInt64Rules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 6;
        break;
      case 42: 
        if (this.b != 5) {
          this.c = new UInt32Rules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 5;
        break;
      case 34: 
        if (this.b != 4) {
          this.c = new Int64Rules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 4;
        break;
      case 26: 
        if (this.b != 3) {
          this.c = new Int32Rules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 3;
        break;
      case 18: 
        if (this.b != 2) {
          this.c = new DoubleRules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 2;
        break;
      case 10: 
        if (this.b != 1) {
          this.c = new FloatRules();
        }
        paramCodedInputByteBufferNano.readMessage((MessageNano)this.c);
        this.b = 1;
      }
    }
    return this;
  }
  
  public FieldRules b()
  {
    this.a = null;
    a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.b == 1) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)this.c);
    }
    j = i;
    if (this.b == 2) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)this.c);
    }
    i = j;
    if (this.b == 3) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)this.c);
    }
    j = i;
    if (this.b == 4) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)this.c);
    }
    i = j;
    if (this.b == 5) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)this.c);
    }
    j = i;
    if (this.b == 6) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano)this.c);
    }
    i = j;
    if (this.b == 7) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)this.c);
    }
    j = i;
    if (this.b == 8) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)this.c);
    }
    i = j;
    if (this.b == 9) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)this.c);
    }
    j = i;
    if (this.b == 10) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(10, (MessageNano)this.c);
    }
    i = j;
    if (this.b == 11) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(11, (MessageNano)this.c);
    }
    j = i;
    if (this.b == 12) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(12, (MessageNano)this.c);
    }
    i = j;
    if (this.b == 13) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(13, (MessageNano)this.c);
    }
    j = i;
    if (this.b == 14) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(14, (MessageNano)this.c);
    }
    i = j;
    if (this.b == 15) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(15, (MessageNano)this.c);
    }
    j = i;
    if (this.b == 16) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(16, (MessageNano)this.c);
    }
    MessageRules localMessageRules = this.a;
    i = j;
    if (localMessageRules != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(17, localMessageRules);
    }
    j = i;
    if (this.b == 18) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(18, (MessageNano)this.c);
    }
    i = j;
    if (this.b == 19) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(19, (MessageNano)this.c);
    }
    j = i;
    if (this.b == 20) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(20, (MessageNano)this.c);
    }
    i = j;
    if (this.b == 21) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(21, (MessageNano)this.c);
    }
    j = i;
    if (this.b == 22) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(22, (MessageNano)this.c);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.b == 1) {
      paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)this.c);
    }
    if (this.b == 2) {
      paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)this.c);
    }
    if (this.b == 3) {
      paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)this.c);
    }
    if (this.b == 4) {
      paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)this.c);
    }
    if (this.b == 5) {
      paramCodedOutputByteBufferNano.writeMessage(5, (MessageNano)this.c);
    }
    if (this.b == 6) {
      paramCodedOutputByteBufferNano.writeMessage(6, (MessageNano)this.c);
    }
    if (this.b == 7) {
      paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)this.c);
    }
    if (this.b == 8) {
      paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)this.c);
    }
    if (this.b == 9) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)this.c);
    }
    if (this.b == 10) {
      paramCodedOutputByteBufferNano.writeMessage(10, (MessageNano)this.c);
    }
    if (this.b == 11) {
      paramCodedOutputByteBufferNano.writeMessage(11, (MessageNano)this.c);
    }
    if (this.b == 12) {
      paramCodedOutputByteBufferNano.writeMessage(12, (MessageNano)this.c);
    }
    if (this.b == 13) {
      paramCodedOutputByteBufferNano.writeMessage(13, (MessageNano)this.c);
    }
    if (this.b == 14) {
      paramCodedOutputByteBufferNano.writeMessage(14, (MessageNano)this.c);
    }
    if (this.b == 15) {
      paramCodedOutputByteBufferNano.writeMessage(15, (MessageNano)this.c);
    }
    if (this.b == 16) {
      paramCodedOutputByteBufferNano.writeMessage(16, (MessageNano)this.c);
    }
    MessageRules localMessageRules = this.a;
    if (localMessageRules != null) {
      paramCodedOutputByteBufferNano.writeMessage(17, localMessageRules);
    }
    if (this.b == 18) {
      paramCodedOutputByteBufferNano.writeMessage(18, (MessageNano)this.c);
    }
    if (this.b == 19) {
      paramCodedOutputByteBufferNano.writeMessage(19, (MessageNano)this.c);
    }
    if (this.b == 20) {
      paramCodedOutputByteBufferNano.writeMessage(20, (MessageNano)this.c);
    }
    if (this.b == 21) {
      paramCodedOutputByteBufferNano.writeMessage(21, (MessageNano)this.c);
    }
    if (this.b == 22) {
      paramCodedOutputByteBufferNano.writeMessage(22, (MessageNano)this.c);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.gift.pgv.validate.nano.FieldRules
 * JD-Core Version:    0.7.0.1
 */