import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.texture.YUVTexture.GLRenderListener;
import com.tencent.av.ui.GLVideoView;
import com.tencent.qphone.base.util.QLog;

public class jvi
  implements YUVTexture.GLRenderListener
{
  public jvi(GLVideoView paramGLVideoView, VideoAppInterface paramVideoAppInterface) {}
  
  public void a()
  {
    GLVideoView.a(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GLVideoView.a(this.jdField_a_of_type_ComTencentAvUiGLVideoView), 2, "onRenderInfoNotify width: " + paramInt1 + ", height: " + paramInt2 + ", angle: " + paramInt3);
    }
    GLVideoView.d(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      String str = this.jdField_a_of_type_ComTencentAvUiGLVideoView.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), str, paramArrayOfByte });
    }
  }
  
  public void b()
  {
    GLVideoView.b(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
  }
  
  public void c()
  {
    GLVideoView.c(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jvi
 * JD-Core Version:    0.7.0.1
 */