package com.tencent.qqlive.push.ProtocolVideoState.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class VideoProcessProto
  extends ExtendableMessageNano<VideoProcessProto>
{
  public int a;
  public PushOnVideoReq b;
  public PushOnVideoRes c;
  public GetRoomVideoInfoReq d;
  public GetRoomVideoInfoRes e;
  public SetVideoSwitchReq f;
  public SetVideoSwitchResp g;
  public NotifyVideoArriveByVideoSvrReq h;
  public NotifyVideoArriveByVideoSvrResp i;
  public NotifyRemoveVideoByVideoSvrReq j;
  public NotifyRemoveVideoByVideoSvrResp k;
  public NotifyVideoSvrRemoveVideoReq l;
  public NotifyVideoSvrRemoveVideoResp m;
  public int n;
  
  public VideoProcessProto()
  {
    a();
  }
  
  public VideoProcessProto a()
  {
    this.a = 0;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public VideoProcessProto a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i1 = paramCodedInputByteBufferNano.readTag();
      switch (i1)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, i1)) {
          return this;
        }
        break;
      case 112: 
        this.n = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 106: 
        if (this.m == null) {
          this.m = new NotifyVideoSvrRemoveVideoResp();
        }
        paramCodedInputByteBufferNano.readMessage(this.m);
        break;
      case 98: 
        if (this.l == null) {
          this.l = new NotifyVideoSvrRemoveVideoReq();
        }
        paramCodedInputByteBufferNano.readMessage(this.l);
        break;
      case 90: 
        if (this.k == null) {
          this.k = new NotifyRemoveVideoByVideoSvrResp();
        }
        paramCodedInputByteBufferNano.readMessage(this.k);
        break;
      case 82: 
        if (this.j == null) {
          this.j = new NotifyRemoveVideoByVideoSvrReq();
        }
        paramCodedInputByteBufferNano.readMessage(this.j);
        break;
      case 74: 
        if (this.i == null) {
          this.i = new NotifyVideoArriveByVideoSvrResp();
        }
        paramCodedInputByteBufferNano.readMessage(this.i);
        break;
      case 66: 
        if (this.h == null) {
          this.h = new NotifyVideoArriveByVideoSvrReq();
        }
        paramCodedInputByteBufferNano.readMessage(this.h);
        break;
      case 58: 
        if (this.g == null) {
          this.g = new SetVideoSwitchResp();
        }
        paramCodedInputByteBufferNano.readMessage(this.g);
        break;
      case 50: 
        if (this.f == null) {
          this.f = new SetVideoSwitchReq();
        }
        paramCodedInputByteBufferNano.readMessage(this.f);
        break;
      case 42: 
        if (this.e == null) {
          this.e = new GetRoomVideoInfoRes();
        }
        paramCodedInputByteBufferNano.readMessage(this.e);
        break;
      case 34: 
        if (this.d == null) {
          this.d = new GetRoomVideoInfoReq();
        }
        paramCodedInputByteBufferNano.readMessage(this.d);
        break;
      case 26: 
        if (this.c == null) {
          this.c = new PushOnVideoRes();
        }
        paramCodedInputByteBufferNano.readMessage(this.c);
        break;
      case 18: 
        if (this.b == null) {
          this.b = new PushOnVideoReq();
        }
        paramCodedInputByteBufferNano.readMessage(this.b);
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i2 = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.a);
    Object localObject = this.b;
    int i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
    }
    localObject = this.c;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
    }
    localObject = this.d;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
    }
    localObject = this.e;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)localObject);
    }
    localObject = this.f;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano)localObject);
    }
    localObject = this.g;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
    }
    localObject = this.h;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
    }
    localObject = this.i;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    localObject = this.j;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.computeMessageSize(10, (MessageNano)localObject);
    }
    localObject = this.k;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(11, (MessageNano)localObject);
    }
    localObject = this.l;
    int i3 = i2;
    if (localObject != null) {
      i3 = i2 + CodedOutputByteBufferNano.computeMessageSize(12, (MessageNano)localObject);
    }
    localObject = this.m;
    i1 = i3;
    if (localObject != null) {
      i1 = i3 + CodedOutputByteBufferNano.computeMessageSize(13, (MessageNano)localObject);
    }
    i3 = this.n;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(14, i3);
    }
    return i2;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeUInt32(1, this.a);
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
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
    }
    localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
    }
    localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    localObject = this.j;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(10, (MessageNano)localObject);
    }
    localObject = this.k;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(11, (MessageNano)localObject);
    }
    localObject = this.l;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(12, (MessageNano)localObject);
    }
    localObject = this.m;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(13, (MessageNano)localObject);
    }
    int i1 = this.n;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(14, i1);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.push.ProtocolVideoState.nano.VideoProcessProto
 * JD-Core Version:    0.7.0.1
 */