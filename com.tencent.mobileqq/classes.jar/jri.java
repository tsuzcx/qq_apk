import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.switchface.SwitchFaceView;

public class jri
{
  public GLCanvas a;
  public jrh[] a;
  
  public jri(SwitchFaceView paramSwitchFaceView)
  {
    this.jdField_a_of_type_ArrayOfJrh = new jrh[2];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJrh.length)
    {
      this.jdField_a_of_type_ArrayOfJrh[i] = new jrh(paramSwitchFaceView);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jri
 * JD-Core Version:    0.7.0.1
 */