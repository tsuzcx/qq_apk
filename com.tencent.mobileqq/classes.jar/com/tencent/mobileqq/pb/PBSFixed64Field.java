package com.tencent.mobileqq.pb;

public final class PBSFixed64Field
  extends PBPrimitiveField<Long>
{
  public static final PBSFixed64Field __repeatHelper__ = new PBSFixed64Field(0L, false);
  private long value = 0L;
  
  public PBSFixed64Field(long paramLong, boolean paramBoolean)
  {
    set(paramLong, paramBoolean);
  }
  
  public void clear(Object paramObject)
  {
    long l;
    if ((paramObject instanceof Long)) {
      l = ((Long)paramObject).longValue();
    } else {
      l = 0L;
    }
    this.value = l;
    setHasFlag(false);
  }
  
  public int computeSize(int paramInt)
  {
    if (has()) {
      return CodedOutputStreamMicro.computeSFixed64Size(paramInt, this.value);
    }
    return 0;
  }
  
  protected int computeSizeDirectly(int paramInt, Long paramLong)
  {
    return CodedOutputStreamMicro.computeSFixed64Size(paramInt, paramLong.longValue());
  }
  
  protected void copyFrom(PBField<Long> paramPBField)
  {
    paramPBField = (PBSFixed64Field)paramPBField;
    set(paramPBField.value, paramPBField.has());
  }
  
  public long get()
  {
    return this.value;
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    this.value = paramCodedInputStreamMicro.readSFixed64();
    setHasFlag(true);
  }
  
  protected Long readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    return Long.valueOf(paramCodedInputStreamMicro.readSFixed64());
  }
  
  public void set(long paramLong)
  {
    set(paramLong, true);
  }
  
  public void set(long paramLong, boolean paramBoolean)
  {
    this.value = paramLong;
    setHasFlag(paramBoolean);
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
  {
    if (has()) {
      paramCodedOutputStreamMicro.writeSFixed64(paramInt, this.value);
    }
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, Long paramLong)
  {
    paramCodedOutputStreamMicro.writeSFixed64(paramInt, paramLong.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBSFixed64Field
 * JD-Core Version:    0.7.0.1
 */