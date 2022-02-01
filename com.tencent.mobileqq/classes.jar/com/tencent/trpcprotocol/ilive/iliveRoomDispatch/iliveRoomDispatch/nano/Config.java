package com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class Config
  extends MessageNano
{
  public AppidRouteConfig[] a;
  public RoomidRouteConfig[] a;
  
  public Config()
  {
    a();
  }
  
  public Config a()
  {
    this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig = RoomidRouteConfig.a();
    this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig = AppidRouteConfig.a();
    this.cachedSize = -1;
    return this;
  }
  
  public Config a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      Object localObject;
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 10: 
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig == null) {}
        for (i = 0;; i = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig.length)
        {
          localObject = new RoomidRouteConfig[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new RoomidRouteConfig();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
        }
        localObject[j] = new RoomidRouteConfig();
        paramCodedInputByteBufferNano.readMessage(localObject[j]);
        this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig = ((RoomidRouteConfig[])localObject);
        break;
      }
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
      if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig == null) {}
      for (i = 0;; i = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig.length)
      {
        localObject = new AppidRouteConfig[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = new AppidRouteConfig();
          paramCodedInputByteBufferNano.readMessage(localObject[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
      }
      localObject[j] = new AppidRouteConfig();
      paramCodedInputByteBufferNano.readMessage(localObject[j]);
      this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig = ((AppidRouteConfig[])localObject);
    }
  }
  
  public int computeSerializedSize()
  {
    int m = 0;
    int j = super.computeSerializedSize();
    int i = j;
    Object localObject;
    if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig != null)
    {
      i = j;
      if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig.length > 0)
      {
        i = j;
        j = 0;
        while (j < this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig.length)
        {
          localObject = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    int k = i;
    if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig != null)
    {
      k = i;
      if (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig.length) {
            break;
          }
          localObject = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig[j];
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
    int j = 0;
    int i;
    Object localObject;
    if ((this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig != null) && (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig.length > 0))
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig.length)
      {
        localObject = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoRoomidRouteConfig[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if ((this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig != null) && (this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig.length > 0))
    {
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig.length)
      {
        localObject = this.jdField_a_of_type_ArrayOfComTencentTrpcprotocolIliveIliveRoomDispatchIliveRoomDispatchNanoAppidRouteConfig[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.Config
 * JD-Core Version:    0.7.0.1
 */