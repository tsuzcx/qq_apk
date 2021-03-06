package com.tencent.mobileqq.pb;

public final class PBDoubleField
  extends PBPrimitiveField<Double>
{
  public static final PBDoubleField __repeatHelper__ = new PBDoubleField(0.0D, false);
  private double value = 0.0D;
  
  public PBDoubleField(double paramDouble, boolean paramBoolean)
  {
    set(paramDouble, paramBoolean);
  }
  
  public void clear(Object paramObject)
  {
    double d;
    if ((paramObject instanceof Double)) {
      d = ((Double)paramObject).doubleValue();
    } else {
      d = 0.0D;
    }
    this.value = d;
    setHasFlag(false);
  }
  
  public int computeSize(int paramInt)
  {
    if (has()) {
      return CodedOutputStreamMicro.computeDoubleSize(paramInt, this.value);
    }
    return 0;
  }
  
  protected int computeSizeDirectly(int paramInt, Double paramDouble)
  {
    return CodedOutputStreamMicro.computeDoubleSize(paramInt, paramDouble.doubleValue());
  }
  
  protected void copyFrom(PBField<Double> paramPBField)
  {
    paramPBField = (PBDoubleField)paramPBField;
    set(paramPBField.value, paramPBField.has());
  }
  
  public double get()
  {
    return this.value;
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    this.value = paramCodedInputStreamMicro.readDouble();
    setHasFlag(true);
  }
  
  protected Double readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    return Double.valueOf(paramCodedInputStreamMicro.readDouble());
  }
  
  public void set(double paramDouble)
  {
    set(paramDouble, true);
  }
  
  public void set(double paramDouble, boolean paramBoolean)
  {
    this.value = paramDouble;
    setHasFlag(paramBoolean);
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
  {
    if (has()) {
      paramCodedOutputStreamMicro.writeDouble(paramInt, this.value);
    }
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, Double paramDouble)
  {
    paramCodedOutputStreamMicro.writeDouble(paramInt, paramDouble.doubleValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBDoubleField
 * JD-Core Version:    0.7.0.1
 */