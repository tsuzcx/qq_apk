import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageGaussianBlurFilter;

public class muu
  extends QQAVImageFilterGroup
{
  public muu()
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
 * Qualified Name:     muu
 * JD-Core Version:    0.7.0.1
 */