package com.tencent.ttpic.util;

class AudioUtil$Complex
{
  public double image;
  public double real;
  
  public AudioUtil$Complex()
  {
    this.real = 0.0D;
    this.image = 0.0D;
  }
  
  public AudioUtil$Complex(double paramDouble)
  {
    this.real = paramDouble;
    this.image = 0.0D;
  }
  
  public AudioUtil$Complex(double paramDouble1, double paramDouble2)
  {
    this.real = paramDouble1;
    this.image = paramDouble2;
  }
  
  public AudioUtil$Complex(int paramInt1, int paramInt2)
  {
    this.real = Integer.valueOf(paramInt1).floatValue();
    this.image = Integer.valueOf(paramInt2).floatValue();
  }
  
  public Complex cc(Complex paramComplex)
  {
    Complex localComplex = new Complex();
    double d1 = this.real;
    double d2 = paramComplex.real;
    double d3 = this.image;
    double d4 = paramComplex.image;
    localComplex.real = (d1 * d2 - d3 * d4);
    localComplex.image = (this.real * d4 + d3 * paramComplex.real);
    return localComplex;
  }
  
  public Complex cut(Complex paramComplex)
  {
    Complex localComplex = new Complex();
    this.real -= paramComplex.real;
    this.image -= paramComplex.image;
    return localComplex;
  }
  
  public int getIntValue()
  {
    double d1 = this.real;
    double d2 = this.image;
    return (int)Math.round(Math.sqrt(d1 * d1 - d2 * d2));
  }
  
  public Complex sum(Complex paramComplex)
  {
    Complex localComplex = new Complex();
    this.real += paramComplex.real;
    this.image += paramComplex.image;
    return localComplex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.AudioUtil.Complex
 * JD-Core Version:    0.7.0.1
 */