package cooperation.qzone.panorama.model;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;
import cooperation.qzone.panorama.piece.PieceCacheList;
import cooperation.qzone.panorama.piece.PieceData;
import cooperation.qzone.util.PanoramaUtil;
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
    ArrayList localArrayList = PanoramaUtil.getInstance().getCylinderCoordinate(this.sectorDegree, false);
    if (this.isPieceLoad) {}
    for (Object localObject = PanoramaUtil.getInstance().getCylinderCoordinate(this.sectorDegree, true);; localObject = null)
    {
      if ((localArrayList == null) || (localArrayList.size() != 2)) {}
      float[] arrayOfFloat1;
      do
      {
        float[] arrayOfFloat2;
        do
        {
          do
          {
            return;
            arrayOfFloat2 = (float[])localArrayList.get(0);
          } while (arrayOfFloat2 == null);
          i = arrayOfFloat2.length;
          arrayOfFloat1 = arrayOfFloat2;
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
        } while (arrayOfFloat2 == null);
        int i = arrayOfFloat2.length;
        arrayOfFloat1 = arrayOfFloat2;
        if (localObject != null)
        {
          localObject = (float[])((ArrayList)localObject).get(1);
          arrayOfFloat1 = Arrays.copyOf(arrayOfFloat2, localObject.length + i);
          System.arraycopy(localObject, 0, arrayOfFloat1, i, localObject.length);
        }
      } while (arrayOfFloat1 == null);
      this.textureBuffer = ByteBuffer.allocateDirect(arrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.textureBuffer.put(arrayOfFloat1);
      this.textureBuffer.position(0);
      return;
    }
  }
  
  protected void initRotate()
  {
    if ((this.imageWidth != 0) && (this.imageHeight != 0)) {}
    for (this.sectorDegree = (360 - (6 - (int)(this.imageWidth / this.imageHeight + 0.1F)) * 40);; this.sectorDegree = 360.0F)
    {
      if (this.sectorDegree > 360.0F) {
        this.sectorDegree = 360.0F;
      }
      INIT_ROTATE = this.sectorDegree / 2.0F;
      this.rotateY = INIT_ROTATE;
      return;
    }
  }
  
  public void onModelDraw()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.textureId);
    GLES20.glUniformMatrix4fv(this.mUProjectMatrixLocation, 1, false, getMultiplyMatrix(), 0);
    GLES20.glDrawArrays(4, 0, getVertexSize());
    if (this.pieceDataList != null)
    {
      int i = 0;
      while (i < this.pieceDataList.size())
      {
        PieceData localPieceData = (PieceData)this.pieceDataList.valueAt(i);
        int j = localPieceData.getTextureOrgObjectId();
        if (j > 0)
        {
          GLES20.glBindTexture(3553, j);
          j = getVertexSize();
          GLES20.glDrawArrays(4, ((int)(this.sectorDegree / 10.0F) - 1 - localPieceData.getPieceIndex()) * 6 + j, 6);
        }
        i += 1;
      }
    }
  }
  
  public void touchOperation()
  {
    if (this.mScale != 0.0F)
    {
      if (this.mScale > 0.5228754F) {
        this.mScale = 0.5228754F;
      }
      float f = (float)(Math.toDegrees(Math.atan(this.mScale)) * 2.0D);
      this.maxDegree = ((int)((55.207924F - f) * 0.5D));
      if (Build.VERSION.SDK_INT >= 14) {
        Matrix.perspectiveM(this.projectMatrix, 0, f, this.screenRatio, 1.0F, 500.0F);
      }
      Matrix.translateM(this.projectMatrix, 0, 0.0F, 0.0F, -2.0F);
    }
    int i;
    if (this.rotateX > this.maxDegree)
    {
      this.rotateX = this.maxDegree;
      if (INIT_ROTATE == 180.0F) {
        break label337;
      }
      if (this.showType != 1) {
        break label312;
      }
      i = 44;
      label133:
      if (this.rotateY <= this.sectorDegree - i) {
        break label318;
      }
      this.rotateY = (this.sectorDegree - i);
    }
    for (;;)
    {
      if (this.panoramaTouchListener != null)
      {
        this.panoramaTouchListener.onTouchScale(this.mScale);
        this.panoramaTouchListener.onTouchMove(this.rotateX, this.rotateY);
      }
      Matrix.rotateM(this.modelMatrix, 0, -this.rotateX, 1.0F, 0.0F, 0.0F);
      Matrix.rotateM(this.modelMatrix, 0, -this.rotateY, 0.0F, 1.0F, 0.0F);
      Matrix.rotateM(this.modelMatrix, 0, 0.0F, 0.0F, 0.0F, 1.0F);
      if ((this.onRotateListener != null) && (this.mScale != 1.0F)) {
        this.onRotateListener.onRotate((int)this.sectorDegree - i, -this.rotateX, -this.rotateY, this.mScale);
      }
      return;
      if (this.rotateX >= -this.maxDegree) {
        break;
      }
      this.rotateX = (-this.maxDegree);
      break;
      label312:
      i = 17;
      break label133;
      label318:
      if (this.rotateY < i) {
        this.rotateY = i;
      }
      continue;
      label337:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.model.CylinderModel
 * JD-Core Version:    0.7.0.1
 */