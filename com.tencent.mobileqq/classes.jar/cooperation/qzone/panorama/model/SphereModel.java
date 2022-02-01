package cooperation.qzone.panorama.model;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

public class SphereModel
  extends ShapeModel
{
  public static final float INIT_ROTATE = 90.0F;
  private static final String TAG = "SphereModel";
  
  public SphereModel(boolean paramBoolean)
  {
    super(paramBoolean);
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
    Object localObject = ((IPanoramaUtil)QRoute.api(IPanoramaUtil.class)).getSphereCoordinate();
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() != 2) {
        return;
      }
      float[] arrayOfFloat = (float[])((ArrayList)localObject).get(0);
      if (arrayOfFloat != null)
      {
        this.vertexSize = (arrayOfFloat.length / 3);
        this.vertexBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.vertexBuffer.put(arrayOfFloat);
        this.vertexBuffer.position(0);
      }
      localObject = (float[])((ArrayList)localObject).get(1);
      if (localObject != null)
      {
        this.textureBuffer = ByteBuffer.allocateDirect(localObject.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.textureBuffer.put((float[])localObject);
        this.textureBuffer.position(0);
      }
    }
  }
  
  protected void initRotate()
  {
    this.rotateY = 90.0F;
  }
  
  public void onModelDraw()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.textureId);
    GLES20.glUniformMatrix4fv(this.mUProjectMatrixLocation, 1, false, getMultiplyMatrix(), 0);
    GLES20.glDrawArrays(4, 0, getVertexSize());
  }
  
  public void touchOperation()
  {
    if (this.rotateX > 90.0F) {
      this.rotateX = 90.0F;
    } else if (this.rotateX < -90.0F) {
      this.rotateX = -90.0F;
    }
    if (this.mScale != 0.0F)
    {
      float f = (float)(Math.toDegrees(Math.atan(this.mScale)) * 2.0D);
      if (Build.VERSION.SDK_INT >= 14) {
        Matrix.perspectiveM(this.projectMatrix, 0, f, this.screenRatio, 1.0F, 500.0F);
      }
      Matrix.translateM(this.projectMatrix, 0, 0.0F, 0.0F, -2.0F);
    }
    Matrix.rotateM(this.modelMatrix, 0, -this.rotateX, 1.0F, 0.0F, 0.0F);
    Matrix.rotateM(this.modelMatrix, 0, -this.rotateY, 0.0F, 1.0F, 0.0F);
    Matrix.rotateM(this.modelMatrix, 0, 0.0F, 0.0F, 0.0F, 1.0F);
    if (this.onRotateListener != null) {
      this.onRotateListener.onRotate((int)this.sectorDegree, -this.rotateX, -this.rotateY, this.mScale);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.panorama.model.SphereModel
 * JD-Core Version:    0.7.0.1
 */