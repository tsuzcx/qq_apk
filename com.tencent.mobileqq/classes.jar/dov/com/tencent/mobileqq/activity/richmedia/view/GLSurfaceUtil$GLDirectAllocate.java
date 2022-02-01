package dov.com.tencent.mobileqq.activity.richmedia.view;

import java.nio.ByteBuffer;

public class GLSurfaceUtil$GLDirectAllocate
{
  public static ByteBuffer a(int paramInt1, int paramInt2)
  {
    try
    {
      if (GLSurfaceUtil.c)
      {
        ByteBuffer localByteBuffer1 = CameraGLSurfaceView.allocate(paramInt1, paramInt2);
        GLSurfaceUtil.b = true;
        ByteBuffer localByteBuffer2 = localByteBuffer1;
        if (localByteBuffer1 == null)
        {
          localByteBuffer2 = ByteBuffer.allocateDirect(paramInt2);
          GLSurfaceUtil.b = false;
        }
        return localByteBuffer2;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.view.GLSurfaceUtil.GLDirectAllocate
 * JD-Core Version:    0.7.0.1
 */