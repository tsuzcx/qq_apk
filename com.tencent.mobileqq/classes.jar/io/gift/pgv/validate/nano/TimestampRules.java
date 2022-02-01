package io.gift.pgv.validate.nano;

import com.gift.google.protobuf.nano.Duration;
import com.gift.google.protobuf.nano.Timestamp;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class TimestampRules
  extends ExtendableMessageNano<TimestampRules>
{
  public boolean a;
  public Timestamp b;
  public Timestamp c;
  public Timestamp d;
  public Timestamp e;
  public Timestamp f;
  public boolean g;
  public boolean h;
  public Duration i;
  
  public TimestampRules()
  {
    a();
  }
  
  public TimestampRules a()
  {
    this.a = false;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = false;
    this.h = false;
    this.i = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public TimestampRules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int j = paramCodedInputByteBufferNano.readTag();
      if (j == 0) {
        break;
      }
      if (j != 8)
      {
        if (j != 18)
        {
          if (j != 26)
          {
            if (j != 34)
            {
              if (j != 42)
              {
                if (j != 50)
                {
                  if (j != 56)
                  {
                    if (j != 64)
                    {
                      if (j != 74)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, j)) {
                          return this;
                        }
                      }
                      else
                      {
                        if (this.i == null) {
                          this.i = new Duration();
                        }
                        paramCodedInputByteBufferNano.readMessage(this.i);
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readBool();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readBool();
                  }
                }
                else
                {
                  if (this.f == null) {
                    this.f = new Timestamp();
                  }
                  paramCodedInputByteBufferNano.readMessage(this.f);
                }
              }
              else
              {
                if (this.e == null) {
                  this.e = new Timestamp();
                }
                paramCodedInputByteBufferNano.readMessage(this.e);
              }
            }
            else
            {
              if (this.d == null) {
                this.d = new Timestamp();
              }
              paramCodedInputByteBufferNano.readMessage(this.d);
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new Timestamp();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else
        {
          if (this.b == null) {
            this.b = new Timestamp();
          }
          paramCodedInputByteBufferNano.readMessage(this.b);
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readBool();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    boolean bool = this.a;
    int j = k;
    if (bool) {
      j = k + CodedOutputByteBufferNano.computeBoolSize(1, bool);
    }
    Object localObject = this.b;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
    }
    localObject = this.c;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
    }
    localObject = this.d;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
    }
    localObject = this.e;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)localObject);
    }
    localObject = this.f;
    k = j;
    if (localObject != null) {
      k = j + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano)localObject);
    }
    bool = this.g;
    j = k;
    if (bool) {
      j = k + CodedOutputByteBufferNano.computeBoolSize(7, bool);
    }
    bool = this.h;
    k = j;
    if (bool) {
      k = j + CodedOutputByteBufferNano.computeBoolSize(8, bool);
    }
    localObject = this.i;
    j = k;
    if (localObject != null) {
      j = k + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    boolean bool = this.a;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(1, bool);
    }
    Object localObject = this.b;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(5, (MessageNano)localObject);
    }
    localObject = this.f;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(6, (MessageNano)localObject);
    }
    bool = this.g;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(7, bool);
    }
    bool = this.h;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(8, bool);
    }
    localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.gift.pgv.validate.nano.TimestampRules
 * JD-Core Version:    0.7.0.1
 */