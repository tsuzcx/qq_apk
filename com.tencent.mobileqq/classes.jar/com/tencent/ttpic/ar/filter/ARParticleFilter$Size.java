package com.tencent.ttpic.ar.filter;

class ARParticleFilter$Size
{
  public int height;
  public int width;
  
  ARParticleFilter$Size(ARParticleFilter paramARParticleFilter) {}
  
  ARParticleFilter$Size(ARParticleFilter paramARParticleFilter, int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public boolean isValid()
  {
    return (this.width != 0) && (this.height != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.ar.filter.ARParticleFilter.Size
 * JD-Core Version:    0.7.0.1
 */