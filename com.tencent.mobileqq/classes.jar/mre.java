import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public class mre
{
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, 2131165905, true, 2130841491, 2131165908);
  }
  
  private static Drawable a(Resources paramResources, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    Drawable localDrawable = paramResources.getDrawable(paramInt1);
    if (paramBoolean) {}
    for (Object localObject = mts.a(paramResources, paramInt1, paramInt2);; localObject = localDrawable)
    {
      ((Drawable)localObject).setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localDrawable = paramResources.getDrawable(paramInt3);
      paramResources = mts.a(paramResources, paramInt3, paramInt4);
      paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramResources = new LayerDrawable(new Drawable[] { paramResources, localObject });
      paramResources.setLayerInset(0, 0, 0, 0, 0);
      paramResources.setLayerInset(1, 0, 0, 0, 0);
      paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      return paramResources;
    }
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    return a(paramResources, paramInt, 2131165905, paramBoolean, 2130841491, 2131165908);
  }
  
  public static Drawable b(Resources paramResources, int paramInt)
  {
    Drawable localDrawable = paramResources.getDrawable(paramInt);
    paramResources = mts.a(paramResources, paramInt, 2131165905);
    paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mre
 * JD-Core Version:    0.7.0.1
 */