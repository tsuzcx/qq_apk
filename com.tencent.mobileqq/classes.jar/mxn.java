import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageGaussianBlurFilter;

public class mxn
  extends QQAVImageFilterGroup
{
  public mxn()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mxn
 * JD-Core Version:    0.7.0.1
 */