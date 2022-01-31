package com.tencent.ttpic.particlesystem2d;

public class ParticleTemplate2D
{
  private double mEmitRate;
  private String mIdx = "0";
  private String mLife = "0";
  public int mMaxCount;
  private String mP0 = "0";
  private String mP1 = "0";
  private String mP2 = "0";
  private String mPosX = "0";
  private String mPosY = "0";
  private String mRotate = "0";
  private String mScale = "0";
  
  ParticleTemplate2D(int paramInt, double paramDouble, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.mMaxCount = paramInt;
    this.mEmitRate = paramDouble;
    this.mLife = paramString1;
    this.mPosX = paramString2;
    this.mPosY = paramString3;
    this.mScale = paramString4;
    this.mRotate = paramString5;
    this.mP0 = paramString6;
    this.mP1 = paramString7;
    this.mP2 = paramString8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.particlesystem2d.ParticleTemplate2D
 * JD-Core Version:    0.7.0.1
 */