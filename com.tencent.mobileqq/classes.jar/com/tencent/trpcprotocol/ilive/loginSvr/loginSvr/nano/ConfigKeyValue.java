package com.tencent.trpcprotocol.ilive.loginSvr.loginSvr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class ConfigKeyValue
  extends ExtendableMessageNano<ConfigKeyValue>
{
  public String a;
  public KeyValueItem[] b;
  
  public ConfigKeyValue()
  {
    a();
  }
  
  public ConfigKeyValue a()
  {
    this.a = "";
    this.b = KeyValueItem.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public ConfigKeyValue a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else
        {
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          KeyValueItem[] arrayOfKeyValueItem = this.b;
          if (arrayOfKeyValueItem == null) {
            i = 0;
          } else {
            i = arrayOfKeyValueItem.length;
          }
          arrayOfKeyValueItem = new KeyValueItem[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, arrayOfKeyValueItem, 0, i);
            j = i;
          }
          while (j < arrayOfKeyValueItem.length - 1)
          {
            arrayOfKeyValueItem[j] = new KeyValueItem();
            paramCodedInputByteBufferNano.readMessage(arrayOfKeyValueItem[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          arrayOfKeyValueItem[j] = new KeyValueItem();
          paramCodedInputByteBufferNano.readMessage(arrayOfKeyValueItem[j]);
          this.b = arrayOfKeyValueItem;
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
    Object localObject = this.b;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.b;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
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
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    Object localObject = this.b;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.b;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.loginSvr.loginSvr.nano.ConfigKeyValue
 * JD-Core Version:    0.7.0.1
 */