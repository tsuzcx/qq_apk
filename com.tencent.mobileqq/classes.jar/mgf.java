import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public class mgf
{
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, 2131100315, 2130841411, 2131100318);
  }
  
  static Drawable a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable = paramResources.getDrawable(paramInt1);
    mit localmit = mit.a(paramResources, paramInt1, paramInt2);
    localmit.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    localDrawable = paramResources.getDrawable(paramInt3);
    paramResources = mit.a(paramResources, paramInt3, paramInt4);
    paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramResources = new LayerDrawable(new Drawable[] { paramResources, localmit });
    paramResources.setLayerInset(0, 0, 0, 0, 0);
    paramResources.setLayerInset(1, 0, 0, 0, 0);
    paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return paramResources;
  }
  
  public static Drawable b(Resources paramResources, int paramInt)
  {
    Drawable localDrawable = paramResources.getDrawable(paramInt);
    paramResources = mit.a(paramResources, paramInt, 2131100315);
    paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mgf
 * JD-Core Version:    0.7.0.1
 */