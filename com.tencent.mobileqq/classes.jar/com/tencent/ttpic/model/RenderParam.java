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
    System.arraycopy(this.position, 0, localRenderParam.position, 0, this.position.length);
    System.arraycopy(this.texCords, 0, localRenderParam.texCords, 0, this.texCords.length);
    System.arraycopy(this.texAnchor, 0, localRenderParam.texAnchor, 0, this.texAnchor.length);
    System.arraycopy(this.texRotate, 0, localRenderParam.texRotate, 0, this.texRotate.length);
    localRenderParam.texScale = this.texScale;
    localRenderParam.texture = this.texture;
    return localRenderParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.RenderParam
 * JD-Core Version:    0.7.0.1
 */