package cooperation.qzone.panorama.model;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;
import cooperation.qzone.panorama.piece.PieceCacheList;
import cooperation.qzone.panorama.piece.PieceData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class CylinderModel
  extends ShapeModel
{
  public static final int DEGREE_OFFEST = 40;
  public static final int IMAGE_RATE = 6;
  public static float INIT_ROTATE = 0.0F;
  public static final int PIECE_VERTEX_SIZE = 6;
  private static final float ROTATE_MAX_DEGREE = 55.207924F;
  private static final float SCALE_RATE = 0.5228754F;
  private static final String TAG = "CylinderModel";
  private float maxDegree = 55.207924F;
  
  public CylinderModel(boolean paramBoolean)
  {
    super(paramBoolean);
    if (paramBoolean) {
      this.pieceSize = 36;
    }
    this.rotateY = INIT_ROTATE;
  }
  
  public int getTextureType()
  {
    return 2;
  }
  
  public int getVertexType()
  {
    return 3;
  }
  
  protected void initCoordinate()
  {
    this.mScale = 0.5228754F;
    ArrayList localArrayList = ((IPanoramaUtil)QRoute.api(IPanoramaUtil.class)).getCylinderCoordinate(this.sectorDegree, false);
    Object localObject;
    if (this.isPieceLoad) {
      localObject = ((IPanoramaUtil)QRoute.api(IPanoramaUtil.class)).getCylinderCoordinate(this.sectorDegree, true);
    } else {
      localObject = null;
    }
    if (localArrayList != null)
    {
      if (localArrayList.size() != 2) {
        return;
      }
      float[] arrayOfFloat2 = (float[])localArrayList.get(0);
      if (arrayOfFloat2 == null) {
        return;
      }
      int i = arrayOfFloat2.length;
      float[] arrayOfFloat1 = arrayOfFloat2;
      if (localObject != null)
      {
        float[] arrayOfFloat3 = (float[])((ArrayList)localObject).get(0);
        arrayOfFloat1 = Arrays.copyOf(arrayOfFloat2, arrayOfFloat3.length + i);
        System.arraycopy(arrayOfFloat3, 0, arrayOfFloat1, i, arrayOfFloat3.length);
      }
      if (arrayOfFloat1 != null)
      {
        this.vertexSize = (i / 3);
        this.vertexBuffer = ByteBuffer.allocateDirect(arrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.vertexBuffer.put(arrayOfFloat1);
        this.vertexBuffer.position(0);
      }
      arrayOfFloat2 = (float[])localArrayList.get(1);
      if (arrayOfFloat2 == null) {
        return;
      }
      i = arrayOfFloat2.length;
      arrayOfFloat1 = arrayOfFloat2;
      if (localObject != null)
      {
        localObject = (float[])((ArrayList)localObject).get(1);
        arrayOfFloat1 = Arrays.copyOf(arrayOfFloat2, localObject.length + i);
        System.arraycopy(localObject, 0, arrayOfFloat1, i, localObject.length);
      }
      if (arrayOfFloat1 != null)
      {
        this.textureBuffer = ByteBuffer.allocateDirect(arrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.textureBuffer.put(arrayOfFloat1);
        this.textureBuffer.position(0);
      }
    }
  }
  
  protected void initRotate()
  {
    if ((this.imageWidth != 0) && (this.imageHeight != 0)) {
      this.sectorDegree = (360 - (6 - (int)(this.imageWidth / this.imageHeight + 0.1F)) * 40);
    } else {
      this.sectorDegree = 360.0F;
    }
    if (this.sectorDegree > 360.0F) {
      this.sectorDegree = 360.0F;
    }
    INIT_ROTATE = this.sectorDegree / 2.0F;
    this.rotateY = INIT_ROTATE;
  }
  
  public void onModelDraw()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.textureId);
    int j = this.mUProjectMatrixLocation;
    Object localObject = getMultiplyMatrix();
    int i = 0;
    GLES20.glUniformMatrix4fv(j, 1, false, (float[])localObject, 0);
    GLES20.glDrawArrays(4, 0, getVertexSize());
    if (this.pieceDataList != null) {
      while (i < this.pieceDataList.size())
      {
        localObject = (PieceData)this.pieceDataList.valueAt(i);
        j = ((PieceData)localObject).getTextureOrgObjectId();
        if (j > 0)
        {
          GLES20.glBindTexture(3553, j);
          GLES20.glDrawArrays(4, getVertexSize() + ((int)(this.sectorDegree / 10.0F) - 1 - ((PieceData)localObject).getPieceIndex()) * 6, 6);
        }
        i += 1;
      }
    }
  }
  
  public void touchOperation()
  {
    float f1 = this.mScale;
    int j = 0;
    if (f1 != 0.0F)
    {
      if (this.mScale > 0.5228754F) {
        this.mScale = 0.5228754F;
      }
      f1 = (float)(Math.toDegrees(Math.atan(this.mScale)) * 2.0D);
      double d = 55.207924F - f1;
      Double.isNaN(d);
      this.maxDegree = ((int)(d * 0.5D));
      if (Build.VERSION.SDK_INT >= 14) {
        Matrix.perspectiveM(this.projectMatrix, 0, f1, this.screenRatio, 1.0F, 500.0F);
      }
      Matrix.translateM(this.projectMatrix, 0, 0.0F, 0.0F, -2.0F);
    }
    f1 = this.rotateX;
    float f2 = this.maxDegree;
    if (f1 > f2)
    {
      this.rotateX = f2;
    }
    else
    {
      f1 = this.rotateX;
      f2 = this.maxDegree;
      if (f1 < -f2) {
        this.rotateX = (-f2);
      }
    }
    if (INIT_ROTATE != 180.0F)
    {
      int i;
      if (this.showType == 1) {
        i = 44;
      } else {
        i = 17;
      }
      f1 = this.rotateY;
      f2 = this.sectorDegree;
      float f3 = i;
      if (f1 > f2 - f3)
      {
        this.rotateY = (this.sectorDegree - f3);
        j = i;
      }
      else
      {
        j = i;
        if (this.rotateY < f3)
        {
          this.rotateY = f3;
          j = i;
        }
      }
    }
    if (this.panoramaTouchListener != null)
    {
      this.panoramaTouchListener.onTouchScale(this.mScale);
      this.panoramaTouchListener.onTouchMove(this.rotateX, this.rotateY);
    }
    Matrix.rotateM(this.modelMatrix, 0, -this.rotateX, 1.0F, 0.0F, 0.0F);
    Matrix.rotateM(this.modelMatrix, 0, -this.rotateY, 0.0F, 1.0F, 0.0F);
    Matrix.rotateM(this.modelMatrix, 0, 0.0F, 0.0F, 0.0F, 1.0F);
    if ((this.onRotateListener != null) && (this.mScale != 1.0F)) {
      this.onRotateListener.onRotate((int)this.sectorDegree - j, -this.rotateX, -this.rotateY, this.mScale);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.panorama.model.CylinderModel
 * JD-Core Version:    0.7.0.1
 */