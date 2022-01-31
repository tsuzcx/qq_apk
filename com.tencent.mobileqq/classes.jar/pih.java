import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.DrawableContainer;
import com.tencent.component.media.image.drawable.XfermodeDrawable;

public class pih
  extends phv
{
  public Xfermode a;
  
  public pih(Drawable paramDrawable, DrawableContainer paramDrawableContainer, Xfermode paramXfermode)
  {
    super(paramDrawable, paramDrawableContainer);
    this.a = paramXfermode;
  }
  
  public Drawable newDrawable()
  {
    return new XfermodeDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pih
 * JD-Core Version:    0.7.0.1
 */