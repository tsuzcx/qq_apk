package com.tencent.mobileqq.pb;

public final class PBFloatField
  extends PBPrimitiveField<Float>
{
  public static final PBFloatField __repeatHelper__ = new PBFloatField(0.0F, false);
  private float value = 0.0F;
  
  public PBFloatField(float paramFloat, boolean paramBoolean)
  {
    set(paramFloat, paramBoolean);
  }
  
  public void clear(Object paramObject)
  {
    if ((paramObject instanceof Float)) {}
    for (this.value = ((Float)paramObject).floatValue();; this.value = 0.0F)
    {
      setHasFlag(false);
      return;
    }
  }
  
  public int computeSize(int paramInt)
  {
    if (has()) {
      return CodedOutputStreamMicro.computeFloatSize(paramInt, this.value);
    }
    return 0;
  }
  
  protected int computeSizeDirectly(int paramInt, Float paramFloat)
  {
    return CodedOutputStreamMicro.computeFloatSize(paramInt, paramFloat.floatValue());
  }
  
  protected void copyFrom(PBField<Float> paramPBField)
  {
    paramPBField = (PBFloatField)paramPBField;
    set(paramPBField.value, paramPBField.has());
  }
  
  public float get()
  {
    return this.value;
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    this.value = paramCodedInputStreamMicro.readFloat();
    setHasFlag(true);
  }
  
  protected Float readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    return Float.valueOf(paramCodedInputStreamMicro.readFloat());
  }
  
  public void set(float paramFloat)
  {
    set(paramFloat, true);
  }
  
  public void set(float paramFloat, boolean paramBoolean)
  {
    this.value = paramFloat;
    setHasFlag(paramBoolean);
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
  {
    if (has()) {
      paramCodedOutputStreamMicro.writeFloat(paramInt, this.value);
    }
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, Float paramFloat)
  {
    paramCodedOutputStreamMicro.writeFloat(paramInt, paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBFloatField
 * JD-Core Version:    0.7.0.1
 */