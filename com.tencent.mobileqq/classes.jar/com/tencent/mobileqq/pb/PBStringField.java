package com.tencent.mobileqq.pb;

public final class PBStringField
  extends PBPrimitiveField<String>
{
  public static final PBStringField __repeatHelper__ = new PBStringField("", false);
  private String value = "";
  
  public PBStringField(String paramString, boolean paramBoolean)
  {
    set(paramString, paramBoolean);
  }
  
  public void clear(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      paramObject = (String)paramObject;
    } else {
      paramObject = "";
    }
    this.value = paramObject;
    setHasFlag(false);
  }
  
  public int computeSize(int paramInt)
  {
    if (has())
    {
      Object localObject = this.value;
      if (localObject != null) {
        return CodedOutputStreamMicro.computeStringSize(paramInt, (String)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" encounter string null, null for PBStringField is forbidden!");
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    return 0;
  }
  
  protected int computeSizeDirectly(int paramInt, String paramString)
  {
    return CodedOutputStreamMicro.computeStringSize(paramInt, paramString);
  }
  
  protected void copyFrom(PBField<String> paramPBField)
  {
    paramPBField = (PBStringField)paramPBField;
    set(paramPBField.value, paramPBField.has());
  }
  
  public String get()
  {
    return this.value;
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    this.value = paramCodedInputStreamMicro.readString();
    setHasFlag(true);
  }
  
  protected String readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    return paramCodedInputStreamMicro.readString();
  }
  
  public void set(String paramString)
  {
    set(paramString, true);
  }
  
  public void set(String paramString, boolean paramBoolean)
  {
    this.value = paramString;
    setHasFlag(paramBoolean);
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
  {
    if (has()) {
      paramCodedOutputStreamMicro.writeString(paramInt, this.value);
    }
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, String paramString)
  {
    paramCodedOutputStreamMicro.writeString(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBStringField
 * JD-Core Version:    0.7.0.1
 */