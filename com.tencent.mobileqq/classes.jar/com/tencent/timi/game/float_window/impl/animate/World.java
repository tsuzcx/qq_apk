package com.tencent.timi.game.float_window.impl.animate;

public class World
{
  private Vector3D a;
  private float b = 1.0F;
  private float c = 0.25F;
  
  public void a(Vector3D paramVector3D, float paramFloat)
  {
    this.a = paramVector3D;
    this.b = (paramVector3D.c * paramFloat / (1.0F - paramFloat));
  }
  
  public void a(Vector3D paramVector3D, Vector2D paramVector2D)
  {
    float f = this.b;
    paramVector2D.c = (f / (paramVector3D.c + f));
    f = (this.a.c - paramVector3D.c) * (this.a.a - paramVector3D.a) / this.a.c;
    paramVector2D.a = (this.a.a - f);
    f = (this.a.c - paramVector3D.c) * (this.a.b - paramVector3D.b) / this.a.c;
    paramVector2D.b = (this.a.b - f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.animate.World
 * JD-Core Version:    0.7.0.1
 */