package com.tencent.ttpic.model;

public class RenderParam
{
  public String id;
  public float[] position = new float[12];
  public float[] texAnchor = new float[2];
  public float[] texCords = new float[12];
  public float[] texRotate = { 0.0F, 0.0F, 0.0F };
  public float texScale = 1.0F;
  public int texture;
  
  public RenderParam copy()
  {
    RenderParam localRenderParam = new RenderParam();
    localRenderParam.id = this.id;
    float[] arrayOfFloat = this.position;
    System.arraycopy(arrayOfFloat, 0, localRenderParam.position, 0, arrayOfFloat.length);
    arrayOfFloat = this.texCords;
    System.arraycopy(arrayOfFloat, 0, localRenderParam.texCords, 0, arrayOfFloat.length);
    arrayOfFloat = this.texAnchor;
    System.arraycopy(arrayOfFloat, 0, localRenderParam.texAnchor, 0, arrayOfFloat.length);
    arrayOfFloat = this.texRotate;
    System.arraycopy(arrayOfFloat, 0, localRenderParam.texRotate, 0, arrayOfFloat.length);
    localRenderParam.texScale = this.texScale;
    localRenderParam.texture = this.texture;
    return localRenderParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.RenderParam
 * JD-Core Version:    0.7.0.1
 */