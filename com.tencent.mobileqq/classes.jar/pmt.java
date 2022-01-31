import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.ScaleDrawable;

public class pmt
  extends pmn
{
  public pmt(Drawable paramDrawable, ScaleDrawable paramScaleDrawable)
  {
    super(paramDrawable, paramScaleDrawable);
  }
  
  public pmt(pmt parampmt, ScaleDrawable paramScaleDrawable, Resources paramResources)
  {
    super(parampmt, paramScaleDrawable, paramResources);
  }
  
  public Drawable newDrawable()
  {
    return new ScaleDrawable(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new ScaleDrawable(this, paramResources, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pmt
 * JD-Core Version:    0.7.0.1
 */