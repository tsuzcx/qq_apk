import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.switchface.SwitchFaceView;

public class jpu
{
  public GLCanvas a;
  public jpt[] a;
  
  public jpu(SwitchFaceView paramSwitchFaceView)
  {
    this.jdField_a_of_type_ArrayOfJpt = new jpt[2];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJpt.length)
    {
      this.jdField_a_of_type_ArrayOfJpt[i] = new jpt(paramSwitchFaceView);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpu
 * JD-Core Version:    0.7.0.1
 */