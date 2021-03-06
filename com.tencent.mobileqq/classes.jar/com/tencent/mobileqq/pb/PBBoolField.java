package com.tencent.mobileqq.pb;

public final class PBBoolField
  extends PBPrimitiveField<Boolean>
{
  public static final PBBoolField __repeatHelper__ = new PBBoolField(false, false);
  private boolean value = false;
  
  public PBBoolField(boolean paramBoolean1, boolean paramBoolean2)
  {
    set(paramBoolean1, paramBoolean2);
  }
  
  public void clear(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      this.value = ((Boolean)paramObject).booleanValue();
    } else {
      this.value = false;
    }
    setHasFlag(false);
  }
  
  public int computeSize(int paramInt)
  {
    if (has()) {
      return CodedOutputStreamMicro.computeBoolSize(paramInt, this.value);
    }
    return 0;
  }
  
  protected int computeSizeDirectly(int paramInt, Boolean paramBoolean)
  {
    return CodedOutputStreamMicro.computeBoolSize(paramInt, paramBoolean.booleanValue());
  }
  
  protected void copyFrom(PBField<Boolean> paramPBField)
  {
    paramPBField = (PBBoolField)paramPBField;
    set(paramPBField.value, paramPBField.has());
  }
  
  public boolean get()
  {
    return this.value;
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    this.value = paramCodedInputStreamMicro.readBool();
    setHasFlag(true);
  }
  
  protected Boolean readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    return Boolean.valueOf(paramCodedInputStreamMicro.readBool());
  }
  
  public void set(boolean paramBoolean)
  {
    set(paramBoolean, true);
  }
  
  public void set(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.value = paramBoolean1;
    setHasFlag(paramBoolean2);
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
  {
    if (has()) {
      paramCodedOutputStreamMicro.writeBool(paramInt, this.value);
    }
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, Boolean paramBoolean)
  {
    paramCodedOutputStreamMicro.writeBool(paramInt, paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBBoolField
 * JD-Core Version:    0.7.0.1
 */