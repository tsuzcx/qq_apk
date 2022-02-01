package org.jbox2d.common;

public class OBBViewportTransform
  implements IViewportTransform
{
  protected final OBBViewportTransform.OBB box = new OBBViewportTransform.OBB();
  private final Mat22 inv = new Mat22();
  private final Mat22 inv2 = new Mat22();
  private boolean yFlip = false;
  private final Mat22 yFlipMat = new Mat22(1.0F, 0.0F, 0.0F, -1.0F);
  private final Mat22 yFlipMatInv = this.yFlipMat.invert();
  
  public OBBViewportTransform()
  {
    this.box.R.setIdentity();
  }
  
  public Vec2 getCenter()
  {
    return this.box.center;
  }
  
  public Vec2 getExtents()
  {
    return this.box.extents;
  }
  
  public void getScreenToWorld(Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec22.set(paramVec21);
    paramVec22.subLocal(this.box.extents);
    this.box.R.invertToOut(this.inv2);
    this.inv2.mulToOut(paramVec22, paramVec22);
    if (this.yFlip) {
      this.yFlipMatInv.mulToOut(paramVec22, paramVec22);
    }
    paramVec22.addLocal(this.box.center);
  }
  
  public void getScreenVectorToWorld(Vec2 paramVec21, Vec2 paramVec22)
  {
    this.inv.set(this.box.R);
    this.inv.invertLocal();
    this.inv.mulToOut(paramVec21, paramVec22);
    if (this.yFlip) {
      this.yFlipMatInv.mulToOut(paramVec22, paramVec22);
    }
  }
  
  public Mat22 getTransform()
  {
    return this.box.R;
  }
  
  public void getWorldToScreen(Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec21.x -= this.box.center.x;
    paramVec21.y -= this.box.center.y;
    this.box.R.mulToOut(paramVec22, paramVec22);
    if (this.yFlip) {
      this.yFlipMat.mulToOut(paramVec22, paramVec22);
    }
    paramVec22.x += this.box.extents.x;
    paramVec22.y += this.box.extents.y;
  }
  
  public void getWorldVectorToScreen(Vec2 paramVec21, Vec2 paramVec22)
  {
    this.box.R.mulToOut(paramVec21, paramVec22);
    if (this.yFlip) {
      this.yFlipMatInv.mulToOut(paramVec22, paramVec22);
    }
  }
  
  public boolean isYFlip()
  {
    return this.yFlip;
  }
  
  public void mulByTransform(Mat22 paramMat22)
  {
    this.box.R.mulLocal(paramMat22);
  }
  
  public void set(OBBViewportTransform paramOBBViewportTransform)
  {
    this.box.center.set(paramOBBViewportTransform.box.center);
    this.box.extents.set(paramOBBViewportTransform.box.extents);
    this.box.R.set(paramOBBViewportTransform.box.R);
    this.yFlip = paramOBBViewportTransform.yFlip;
  }
  
  public void setCamera(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.box.center.set(paramFloat1, paramFloat2);
    Mat22.createScaleTransform(paramFloat3, this.box.R);
  }
  
  public void setCenter(float paramFloat1, float paramFloat2)
  {
    this.box.center.set(paramFloat1, paramFloat2);
  }
  
  public void setCenter(Vec2 paramVec2)
  {
    this.box.center.set(paramVec2);
  }
  
  public void setExtents(float paramFloat1, float paramFloat2)
  {
    this.box.extents.set(paramFloat1, paramFloat2);
  }
  
  public void setExtents(Vec2 paramVec2)
  {
    this.box.extents.set(paramVec2);
  }
  
  public void setTransform(Mat22 paramMat22)
  {
    this.box.R.set(paramMat22);
  }
  
  public void setYFlip(boolean paramBoolean)
  {
    this.yFlip = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.OBBViewportTransform
 * JD-Core Version:    0.7.0.1
 */