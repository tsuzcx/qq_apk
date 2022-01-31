package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import com.tencent.qphone.base.util.QLog;

class GLTextureView$2
  implements Runnable
{
  GLTextureView$2(GLTextureView paramGLTextureView) {}
  
  public void run()
  {
    GLTextureView.a(this.this$0).a(this.this$0.getWidth(), this.this$0.getHeight());
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, "TextureView mCheckAlphaTask,alpha:" + GLTextureView.a(this.this$0));
    }
    if (GLTextureView.a(this.this$0) != 1.0F) {
      GLTextureView.a(this.this$0, 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.GLTextureView.2
 * JD-Core Version:    0.7.0.1
 */