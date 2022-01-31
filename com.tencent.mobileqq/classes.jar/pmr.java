import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.DrawableContainer;
import com.tencent.component.media.image.drawable.MatrixDrawable;

public class pmr
  extends pmn
{
  public pmr(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
  {
    super(paramDrawable, paramDrawableContainer);
  }
  
  public pmr(pmn parampmn, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    super(parampmn, paramDrawableContainer, paramResources);
  }
  
  public Drawable newDrawable()
  {
    return new MatrixDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pmr
 * JD-Core Version:    0.7.0.1
 */