package com.tencent.mobileqq.pb;

public final class PBBytesField
  extends PBPrimitiveField<ByteStringMicro>
{
  public static final PBBytesField __repeatHelper__ = new PBBytesField(ByteStringMicro.EMPTY, false);
  private ByteStringMicro value = ByteStringMicro.EMPTY;
  
  public PBBytesField(ByteStringMicro paramByteStringMicro, boolean paramBoolean)
  {
    set(paramByteStringMicro, paramBoolean);
  }
  
  public void clear(Object paramObject)
  {
    if ((paramObject instanceof ByteStringMicro)) {
      paramObject = (ByteStringMicro)paramObject;
    } else {
      paramObject = ByteStringMicro.EMPTY;
    }
    this.value = paramObject;
    setHasFlag(false);
  }
  
  public int computeSize(int paramInt)
  {
    if (has()) {
      return CodedOutputStreamMicro.computeBytesSize(paramInt, this.value);
    }
    return 0;
  }
  
  protected int computeSizeDirectly(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    return CodedOutputStreamMicro.computeBytesSize(paramInt, paramByteStringMicro);
  }
  
  protected void copyFrom(PBField<ByteStringMicro> paramPBField)
  {
    paramPBField = (PBBytesField)paramPBField;
    set(paramPBField.value, paramPBField.has());
  }
  
  public ByteStringMicro get()
  {
    return this.value;
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    this.value = paramCodedInputStreamMicro.readBytes();
    setHasFlag(true);
  }
  
  protected ByteStringMicro readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    return paramCodedInputStreamMicro.readBytes();
  }
  
  public void set(ByteStringMicro paramByteStringMicro)
  {
    set(paramByteStringMicro, true);
  }
  
  public void set(ByteStringMicro paramByteStringMicro, boolean paramBoolean)
  {
    this.value = paramByteStringMicro;
    setHasFlag(paramBoolean);
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
  {
    if (has()) {
      paramCodedOutputStreamMicro.writeBytes(paramInt, this.value);
    }
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, ByteStringMicro paramByteStringMicro)
  {
    paramCodedOutputStreamMicro.writeBytes(paramInt, paramByteStringMicro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBBytesField
 * JD-Core Version:    0.7.0.1
 */