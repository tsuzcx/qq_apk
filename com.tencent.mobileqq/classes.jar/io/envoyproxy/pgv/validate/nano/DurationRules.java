package io.envoyproxy.pgv.validate.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.Duration;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class DurationRules
  extends ExtendableMessageNano<DurationRules>
{
  public boolean a;
  public Duration b;
  public Duration c;
  public Duration d;
  public Duration e;
  public Duration f;
  public Duration[] g;
  public Duration[] h;
  
  public DurationRules()
  {
    a();
  }
  
  public DurationRules a()
  {
    this.a = false;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = Duration.a();
    this.h = Duration.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public DurationRules a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 26)
          {
            if (i != 34)
            {
              if (i != 42)
              {
                if (i != 50)
                {
                  int j;
                  Duration[] arrayOfDuration;
                  if (i != 58)
                  {
                    if (i != 66)
                    {
                      if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                        return this;
                      }
                    }
                    else
                    {
                      j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 66);
                      arrayOfDuration = this.h;
                      if (arrayOfDuration == null) {
                        i = 0;
                      } else {
                        i = arrayOfDuration.length;
                      }
                      arrayOfDuration = new Duration[j + i];
                      j = i;
                      if (i != 0)
                      {
                        System.arraycopy(this.h, 0, arrayOfDuration, 0, i);
                        j = i;
                      }
                      while (j < arrayOfDuration.length - 1)
                      {
                        arrayOfDuration[j] = new Duration();
                        paramCodedInputByteBufferNano.readMessage(arrayOfDuration[j]);
                        paramCodedInputByteBufferNano.readTag();
                        j += 1;
                      }
                      arrayOfDuration[j] = new Duration();
                      paramCodedInputByteBufferNano.readMessage(arrayOfDuration[j]);
                      this.h = arrayOfDuration;
                    }
                  }
                  else
                  {
                    j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 58);
                    arrayOfDuration = this.g;
                    if (arrayOfDuration == null) {
                      i = 0;
                    } else {
                      i = arrayOfDuration.length;
                    }
                    arrayOfDuration = new Duration[j + i];
                    j = i;
                    if (i != 0)
                    {
                      System.arraycopy(this.g, 0, arrayOfDuration, 0, i);
                      j = i;
                    }
                    while (j < arrayOfDuration.length - 1)
                    {
                      arrayOfDuration[j] = new Duration();
                      paramCodedInputByteBufferNano.readMessage(arrayOfDuration[j]);
                      paramCodedInputByteBufferNano.readTag();
                      j += 1;
                    }
                    arrayOfDuration[j] = new Duration();
                    paramCodedInputByteBufferNano.readMessage(arrayOfDuration[j]);
                    this.g = arrayOfDuration;
                  }
                }
                else
                {
                  if (this.f == null) {
                    this.f = new Duration();
                  }
                  paramCodedInputByteBufferNano.readMessage(this.f);
                }
              }
              else
              {
                if (this.e == null) {
                  this.e = new Duration();
                }
                paramCodedInputByteBufferNano.readMessage(this.e);
              }
            }
            else
            {
              if (this.d == null) {
                this.d = new Duration();
              }
              paramCodedInputByteBufferNano.readMessage(this.d);
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new Duration();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else
        {
          if (this.b == null) {
            this.b = new Duration();
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
    int j = super.computeSerializedSize();
    boolean bool = this.a;
    int i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(1, bool);
    }
    Object localObject = this.b;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
    }
    localObject = this.c;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
    }
    localObject = this.d;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
    }
    localObject = this.e;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)localObject);
    }
    localObject = this.f;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano)localObject);
    }
    localObject = this.g;
    int m = 0;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = j;
        j = 0;
        for (;;)
        {
          localObject = this.g;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    localObject = this.h;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
        for (;;)
        {
          localObject = this.h;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
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
    localObject = this.g;
    int j = 0;
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.g;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    localObject = this.h;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.h;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.envoyproxy.pgv.validate.nano.DurationRules
 * JD-Core Version:    0.7.0.1
 */