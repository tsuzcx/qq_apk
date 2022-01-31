import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageGaussianBlurFilter;

public class mux
  extends QQAVImageFilterGroup
{
  public mux()
  {
    super(null);
    int i = 0;
    while (i < 3)
    {
      addFilter(new QQAVImageGaussianBlurFilter());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mux
 * JD-Core Version:    0.7.0.1
 */