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
    localComplex.real = (this.real * paramComplex.real - this.image * paramComplex.image);
    localComplex.image = (this.real * paramComplex.image + this.image * paramComplex.real);
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
    return (int)Math.round(Math.sqrt(this.real * this.real - this.image * this.image));
  }
  
  public Complex sum(Complex paramComplex)
  {
    Complex localComplex = new Complex();
    this.real += paramComplex.real;
    this.image += paramComplex.image;
    return localComplex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.AudioUtil.Complex
 * JD-Core Version:    0.7.0.1
 */