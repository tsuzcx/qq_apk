import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLViewGroup;
import java.util.Comparator;

public class jka
  implements Comparator
{
  public jka(GLViewGroup paramGLViewGroup) {}
  
  public int a(GLView paramGLView1, GLView paramGLView2)
  {
    if (paramGLView1.i() >= paramGLView2.i()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jka
 * JD-Core Version:    0.7.0.1
 */