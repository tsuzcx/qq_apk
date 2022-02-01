package cooperation.qzone.panorama.model;

import android.opengl.GLES20;
import android.opengl.Matrix;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;
import cooperation.qzone.panorama.piece.PieceCacheList;
import java.nio.FloatBuffer;

public abstract class ShapeModel
{
  protected int imageHeight;
  protected int imageWidth;
  protected boolean isPieceLoad;
  protected int mAPositionLocation;
  protected int mATextureCoordLocation;
  protected float mScale = 1.0F;
  protected int mUProjectMatrixLocation;
  protected float[] modelMatrix = new float[16];
  protected ShapeModel.OnRotateListener onRotateListener;
  protected PanoramaTouchListener panoramaTouchListener;
  protected PieceCacheList pieceDataList;
  protected int pieceSize = 1;
  protected float[] projectMatrix = new float[16];
  protected float rotateX;
  protected float rotateY;
  protected float screenRatio;
  protected float sectorDegree = 360.0F;
  protected int showType;
  protected FloatBuffer textureBuffer;
  protected int textureId;
  protected FloatBuffer vertexBuffer;
  protected int vertexSize;
  
  public ShapeModel(boolean paramBoolean)
  {
    this.isPieceLoad = paramBoolean;
  }
  
  protected float[] getMultiplyMatrix()
  {
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(arrayOfFloat, 0);
    Matrix.multiplyMM(arrayOfFloat, 0, this.projectMatrix, 0, this.modelMatrix, 0);
    Matrix.setIdentityM(this.modelMatrix, 0);
    return arrayOfFloat;
  }
  
  public PieceCacheList getPieceDataList()
  {
    return this.pieceDataList;
  }
  
  public int getPieceSize()
  {
    return this.pieceSize;
  }
  
  public float getSectorDegree()
  {
    return this.sectorDegree;
  }
  
  public FloatBuffer getTextureBuffer()
  {
    return this.textureBuffer;
  }
  
  public abstract int getTextureType();
  
  public FloatBuffer getVertexBuffer()
  {
    return this.vertexBuffer;
  }
  
  public int getVertexSize()
  {
    return this.vertexSize;
  }
  
  public abstract int getVertexType();
  
  protected abstract void initCoordinate();
  
  protected void initLocation(int paramInt)
  {
    this.mAPositionLocation = GLES20.glGetAttribLocation(paramInt, "aPosition");
    this.mUProjectMatrixLocation = GLES20.glGetUniformLocation(paramInt, "uProjectMatrix");
    this.mATextureCoordLocation = GLES20.glGetAttribLocation(paramInt, "aTextureCoord");
  }
  
  protected void initMatrix()
  {
    Matrix.setIdentityM(this.modelMatrix, 0);
    Matrix.setIdentityM(this.projectMatrix, 0);
  }
  
  public void initModel(int paramInt)
  {
    initRotate();
    if ((this.vertexBuffer == null) || (this.textureBuffer == null)) {
      initCoordinate();
    }
    initLocation(paramInt);
    initVertexArray();
    initTextureArray();
    initMatrix();
  }
  
  protected abstract void initRotate();
  
  protected void initTextureArray()
  {
    if (getTextureBuffer() != null)
    {
      getTextureBuffer().position(0);
      GLES20.glVertexAttribPointer(this.mATextureCoordLocation, getTextureType(), 5126, false, 0, getTextureBuffer());
      GLES20.glEnableVertexAttribArray(this.mATextureCoordLocation);
    }
  }
  
  protected void initVertexArray()
  {
    if (getVertexBuffer() != null)
    {
      getVertexBuffer().position(0);
      GLES20.glVertexAttribPointer(this.mAPositionLocation, getVertexType(), 5126, false, 0, getVertexBuffer());
      GLES20.glEnableVertexAttribArray(this.mAPositionLocation);
    }
  }
  
  public boolean isPieceLoad()
  {
    return this.isPieceLoad;
  }
  
  public abstract void onModelDraw();
  
  public void setImageSize(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public void setOnRotateListener(ShapeModel.OnRotateListener paramOnRotateListener)
  {
    this.onRotateListener = paramOnRotateListener;
  }
  
  public void setPanoramaTouchListener(PanoramaTouchListener paramPanoramaTouchListener)
  {
    this.panoramaTouchListener = paramPanoramaTouchListener;
  }
  
  public void setPieceDataList(PieceCacheList paramPieceCacheList)
  {
    this.pieceDataList = paramPieceCacheList;
  }
  
  public void setRotate(float paramFloat1, float paramFloat2)
  {
    this.rotateX += paramFloat1;
    this.rotateY += paramFloat2;
  }
  
  public void setScale(float paramFloat)
  {
    this.mScale = paramFloat;
  }
  
  public void setScreenRatio(float paramFloat)
  {
    this.screenRatio = paramFloat;
    if (this.showType == 1)
    {
      if ((this instanceof CylinderModel)) {
        this.mScale = 0.5228754F;
      }
    }
    else {
      return;
    }
    this.mScale = 0.4142652F;
  }
  
  public void setShowType(int paramInt)
  {
    this.showType = paramInt;
  }
  
  public void setTextureId(int paramInt)
  {
    this.textureId = paramInt;
  }
  
  public abstract void touchOperation();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.model.ShapeModel
 * JD-Core Version:    0.7.0.1
 */