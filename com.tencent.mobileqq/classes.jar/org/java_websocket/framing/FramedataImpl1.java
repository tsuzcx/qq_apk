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
    if (paramOpcode != null)
    {
      switch (FramedataImpl1.1.$SwitchMap$org$java_websocket$enums$Opcode[paramOpcode.ordinal()])
      {
      default: 
        throw new IllegalArgumentException("Supplied opcode is invalid");
      case 6: 
        return new ContinuousFrame();
      case 5: 
        return new CloseFrame();
      case 4: 
        return new BinaryFrame();
      case 3: 
        return new TextFrame();
      case 2: 
        return new PongFrame();
      }
      return new PingFrame();
    }
    throw new IllegalArgumentException("Supplied opcode cannot be null");
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
    }
    else
    {
      localByteBuffer1.mark();
      ByteBuffer localByteBuffer2 = this.unmaskedpayload;
      localByteBuffer2.position(localByteBuffer2.limit());
      localByteBuffer2 = this.unmaskedpayload;
      localByteBuffer2.limit(localByteBuffer2.capacity());
      if (localByteBuffer1.remaining() > this.unmaskedpayload.remaining())
      {
        localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.unmaskedpayload.capacity());
        this.unmaskedpayload.flip();
        localByteBuffer2.put(this.unmaskedpayload);
        localByteBuffer2.put(localByteBuffer1);
        this.unmaskedpayload = localByteBuffer2;
      }
      else
      {
        this.unmaskedpayload.put(localByteBuffer1);
      }
      this.unmaskedpayload.rewind();
      localByteBuffer1.reset();
    }
    this.fin = paramFramedata.isFin();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (FramedataImpl1)paramObject;
      if (this.fin != paramObject.fin) {
        return false;
      }
      if (this.transferemasked != paramObject.transferemasked) {
        return false;
      }
      if (this.rsv1 != paramObject.rsv1) {
        return false;
      }
      if (this.rsv2 != paramObject.rsv2) {
        return false;
      }
      if (this.rsv3 != paramObject.rsv3) {
        return false;
      }
      if (this.optcode != paramObject.optcode) {
        return false;
      }
      ByteBuffer localByteBuffer = this.unmaskedpayload;
      if (localByteBuffer != null) {
        return localByteBuffer.equals(paramObject.unmaskedpayload);
      }
      return paramObject.unmaskedpayload == null;
    }
    return false;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Framedata{ optcode:");
    localStringBuilder.append(getOpcode());
    localStringBuilder.append(", fin:");
    localStringBuilder.append(isFin());
    localStringBuilder.append(", rsv1:");
    localStringBuilder.append(isRSV1());
    localStringBuilder.append(", rsv2:");
    localStringBuilder.append(isRSV2());
    localStringBuilder.append(", rsv3:");
    localStringBuilder.append(isRSV3());
    localStringBuilder.append(", payloadlength:[pos:");
    localStringBuilder.append(this.unmaskedpayload.position());
    localStringBuilder.append(", len:");
    localStringBuilder.append(this.unmaskedpayload.remaining());
    localStringBuilder.append("], payload:");
    String str;
    if (this.unmaskedpayload.remaining() > 1000) {
      str = "(too big to display)";
    } else {
      str = new String(this.unmaskedpayload.array());
    }
    localStringBuilder.append(str);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.framing.FramedataImpl1
 * JD-Core Version:    0.7.0.1
 */