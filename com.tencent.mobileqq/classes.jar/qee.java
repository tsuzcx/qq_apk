import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;

class qee
{
  private final Drawable a;
  private final Drawable b;
  
  qee(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.a = paramContext.getDrawable(2130837561);
    this.b = paramContext.getDrawable(2130837565);
  }
  
  private Drawable a(Drawable paramDrawable)
  {
    return new LayerDrawable(new Drawable[] { paramDrawable, this.b });
  }
  
  private Drawable b(Drawable paramDrawable)
  {
    paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
    paramDrawable.setColorFilter(2147483647, PorterDuff.Mode.MULTIPLY);
    return paramDrawable;
  }
  
  Drawable a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    paramDrawable = new LayerDrawable(new Drawable[] { this.a, paramDrawable });
    paramDrawable.setLayerInset(1, paramInt1, paramInt2, paramInt1, paramInt2);
    return paramDrawable;
  }
  
  StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable2);
    localStateListDrawable.addState(new int[0], paramDrawable1);
    return localStateListDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qee
 * JD-Core Version:    0.7.0.1
 */