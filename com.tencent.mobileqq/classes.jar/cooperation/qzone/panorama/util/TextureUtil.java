package cooperation.qzone.panorama.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import cooperation.qzone.panorama.piece.PieceCacheList;
import cooperation.qzone.panorama.piece.PieceData;
import cooperation.qzone.util.QZLog;

public class TextureUtil
{
  private static final String TAG = "TextureUtil";
  
  public static void deleteTexture(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    GLES20.glFinish();
  }
  
  public static void deleteTexture(PieceCacheList paramPieceCacheList)
  {
    if (paramPieceCacheList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramPieceCacheList.size())
      {
        PieceData localPieceData = (PieceData)paramPieceCacheList.valueAt(i);
        if (localPieceData != null) {
          localPieceData.recycleOrgTexture();
        }
        i += 1;
      }
    }
  }
  
  public static int genTextureId(Bitmap paramBitmap, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      QZLog.e("TextureUtil", "glGenTextures: fail 0 ");
      return 0;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      QZLog.e("TextureUtil", "loadTexture: bitmap  == null || isRecycled");
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      return 0;
    }
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    if (paramBoolean)
    {
      GLES20.glTexParameteri(3553, 10241, 9728);
      GLES20.glTexParameteri(3553, 10240, 9728);
    }
    for (;;)
    {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      GLES20.glGenerateMipmap(3553);
      GLES20.glBindTexture(3553, 0);
      return arrayOfInt[0];
      GLES20.glTexParameteri(3553, 10241, 9728);
      GLES20.glTexParameteri(3553, 10240, 9729);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.util.TextureUtil
 * JD-Core Version:    0.7.0.1
 */