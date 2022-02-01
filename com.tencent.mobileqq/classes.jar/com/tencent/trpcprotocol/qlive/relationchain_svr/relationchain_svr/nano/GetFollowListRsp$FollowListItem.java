package com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;

public final class GetFollowListRsp$FollowListItem
  extends ExtendableMessageNano<FollowListItem>
{
  private static volatile FollowListItem[] g;
  public long a;
  public String b;
  public String c;
  public long d;
  public long e;
  public boolean f;
  
  public GetFollowListRsp$FollowListItem()
  {
    b();
  }
  
  public static FollowListItem[] a()
  {
    if (g == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (g == null) {
          g = new FollowListItem[0];
        }
      }
    }
    return g;
  }
  
  public FollowListItem a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 32)
            {
              if (i != 40)
              {
                if (i != 48)
                {
                  if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readBool();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt64();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt64();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  public FollowListItem b()
  {
    this.a = 0L;
    this.b = "";
    this.c = "";
    this.d = 0L;
    this.e = 0L;
    this.f = false;
    this.unknownFieldData = null;
    this.cachedSize = -1;
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
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    i = j;
    if (!this.c.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    l = this.d;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    l = this.e;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(5, l);
    }
    boolean bool = this.f;
    j = i;
    if (bool) {
      j = i + CodedOutputByteBufferNano.computeBoolSize(6, bool);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    l = this.e;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(5, l);
    }
    boolean bool = this.f;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(6, bool);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano.GetFollowListRsp.FollowListItem
 * JD-Core Version:    0.7.0.1
 */