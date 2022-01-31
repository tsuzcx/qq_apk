package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;
import org.java_websocket.util.ByteBufferUtils;

public abstract class FramedataImpl1
  implements Framedata
{
  private boolean fin;
  private Opcode optcode;
  private boolean rsv1;
  private boolean rsv2;
  private boolean rsv3;
  private boolean transferemasked;
  private ByteBuffer unmaskedpayload;
  
  public FramedataImpl1(Opcode paramOpcode)
  {
    this.optcode = paramOpcode;
    this.unmaskedpayload = ByteBufferUtils.getEmptyByteBuffer();
    this.fin = true;
    this.transferemasked = false;
    this.rsv1 = false;
    this.rsv2 = false;
    this.rsv3 = false;
  }
  
  public static FramedataImpl1 get(Opcode paramOpcode)
  {
    if (paramOpcode == null) {
      throw new IllegalArgumentException("Supplied opcode cannot be null");
    }
    switch (FramedataImpl1.1.$SwitchMap$org$java_websocket$enums$Opcode[paramOpcode.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Supplied opcode is invalid");
    case 1: 
      return new PingFrame();
    case 2: 
      return new PongFrame();
    case 3: 
      return new TextFrame();
    case 4: 
      return new BinaryFrame();
    case 5: 
      return new CloseFrame();
    }
    return new ContinuousFrame();
  }
  
  public void append(Framedata paramFramedata)
  {
    ByteBuffer localByteBuffer1 = paramFramedata.getPayloadData();
    if (this.unmaskedpayload == null)
    {
      this.unmaskedpayload = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.unmaskedpayload.put(localByteBuffer1);
      localByteBuffer1.reset();
      this.fin = paramFramedata.isFin();
      return;
    }
    localByteBuffer1.mark();
    this.unmaskedpayload.position(this.unmaskedpayload.limit());
    this.unmaskedpayload.limit(this.unmaskedpayload.capacity());
    if (localByteBuffer1.remaining() > this.unmaskedpayload.remaining())
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.unmaskedpayload.capacity());
      this.unmaskedpayload.flip();
      localByteBuffer2.put(this.unmaskedpayload);
      localByteBuffer2.put(localByteBuffer1);
      this.unmaskedpayload = localByteBuffer2;
    }
    for (;;)
    {
      this.unmaskedpayload.rewind();
      localByteBuffer1.reset();
      break;
      this.unmaskedpayload.put(localByteBuffer1);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return bool1;
                    bool1 = bool3;
                  } while (paramObject == null);
                  bool1 = bool3;
                } while (getClass() != paramObject.getClass());
                paramObject = (FramedataImpl1)paramObject;
                bool1 = bool3;
              } while (this.fin != paramObject.fin);
              bool1 = bool3;
            } while (this.transferemasked != paramObject.transferemasked);
            bool1 = bool3;
          } while (this.rsv1 != paramObject.rsv1);
          bool1 = bool3;
        } while (this.rsv2 != paramObject.rsv2);
        bool1 = bool3;
      } while (this.rsv3 != paramObject.rsv3);
      bool1 = bool3;
    } while (this.optcode != paramObject.optcode);
    if (this.unmaskedpayload != null) {
      bool1 = this.unmaskedpayload.equals(paramObject.unmaskedpayload);
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject.unmaskedpayload != null) {
        bool1 = false;
      }
    }
  }
  
  public Opcode getOpcode()
  {
    return this.optcode;
  }
  
  public ByteBuffer getPayloadData()
  {
    return this.unmaskedpayload;
  }
  
  public boolean getTransfereMasked()
  {
    return this.transferemasked;
  }
  
  public int hashCode()
  {
    int i1 = 1;
    int i;
    int i2;
    int j;
    label36:
    int k;
    label45:
    int m;
    label55:
    int n;
    if (this.fin)
    {
      i = 1;
      i2 = this.optcode.hashCode();
      if (this.unmaskedpayload == null) {
        break label113;
      }
      j = this.unmaskedpayload.hashCode();
      if (!this.transferemasked) {
        break label118;
      }
      k = 1;
      if (!this.rsv1) {
        break label123;
      }
      m = 1;
      if (!this.rsv2) {
        break label129;
      }
      n = 1;
      label65:
      if (!this.rsv3) {
        break label135;
      }
    }
    for (;;)
    {
      return (n + (m + (k + (j + (i * 31 + i2) * 31) * 31) * 31) * 31) * 31 + i1;
      i = 0;
      break;
      label113:
      j = 0;
      break label36;
      label118:
      k = 0;
      break label45;
      label123:
      m = 0;
      break label55;
      label129:
      n = 0;
      break label65;
      label135:
      i1 = 0;
    }
  }
  
  public boolean isFin()
  {
    return this.fin;
  }
  
  public boolean isRSV1()
  {
    return this.rsv1;
  }
  
  public boolean isRSV2()
  {
    return this.rsv2;
  }
  
  public boolean isRSV3()
  {
    return this.rsv3;
  }
  
  public abstract void isValid();
  
  public void setFin(boolean paramBoolean)
  {
    this.fin = paramBoolean;
  }
  
  public void setPayload(ByteBuffer paramByteBuffer)
  {
    this.unmaskedpayload = paramByteBuffer;
  }
  
  public void setRSV1(boolean paramBoolean)
  {
    this.rsv1 = paramBoolean;
  }
  
  public void setRSV2(boolean paramBoolean)
  {
    this.rsv2 = paramBoolean;
  }
  
  public void setRSV3(boolean paramBoolean)
  {
    this.rsv3 = paramBoolean;
  }
  
  public void setTransferemasked(boolean paramBoolean)
  {
    this.transferemasked = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Framedata{ optcode:").append(getOpcode()).append(", fin:").append(isFin()).append(", rsv1:").append(isRSV1()).append(", rsv2:").append(isRSV2()).append(", rsv3:").append(isRSV3()).append(", payloadlength:[pos:").append(this.unmaskedpayload.position()).append(", len:").append(this.unmaskedpayload.remaining()).append("], payload:");
    if (this.unmaskedpayload.remaining() > 1000) {}
    for (String str = "(too big to display)";; str = new String(this.unmaskedpayload.array())) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.java_websocket.framing.FramedataImpl1
 * JD-Core Version:    0.7.0.1
 */