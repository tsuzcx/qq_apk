package com.tencent.mobileqq.medalwall;

import java.util.Locale;

class ParticleSystem$Particle
{
  public static int a;
  public int b;
  public long c;
  public float d;
  public float e;
  public float f;
  public float g;
  public int h;
  public int i;
  public float j;
  public float k;
  public float l;
  public float m;
  public float n;
  public float o;
  public float p;
  public float q;
  
  public ParticleSystem$Particle()
  {
    int i1 = a;
    a = i1 + 1;
    this.b = i1;
  }
  
  public String toString()
  {
    return String.format(Locale.getDefault(), "[id:%d, start: %d, x: %f, y: %f, vx: %f, vy: %f, size: %d", new Object[] { Integer.valueOf(this.b), Long.valueOf(this.c), Float.valueOf(this.d), Float.valueOf(this.e), Float.valueOf(this.f), Float.valueOf(this.g), Integer.valueOf(this.i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.ParticleSystem.Particle
 * JD-Core Version:    0.7.0.1
 */