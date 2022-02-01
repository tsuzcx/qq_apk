import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public class mrz
{
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, 2131166000, true, 2130841966, 2131166003, null);
  }
  
  private static Drawable a(Resources paramResources, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, Drawable paramDrawable)
  {
    Drawable localDrawable = paramResources.getDrawable(paramInt1);
    Object localObject;
    if (paramBoolean)
    {
      localObject = muq.a(paramResources, paramInt1, paramInt2);
      ((Drawable)localObject).setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localDrawable = paramResources.getDrawable(paramInt3);
      paramResources = muq.a(paramResources, paramInt3, paramInt4);
      paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      if (paramDrawable != null) {
        break label138;
      }
      paramResources = new LayerDrawable(new Drawable[] { paramResources, localObject });
      paramResources.setLayerInset(0, 0, 0, 0, 0);
      paramResources.setLayerInset(1, 0, 0, 0, 0);
    }
    for (;;)
    {
      paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      return paramResources;
      localObject = localDrawable;
      break;
      label138:
      paramResources = new LayerDrawable(new Drawable[] { paramResources, localObject, paramDrawable });
      paramResources.setLayerInset(0, 0, 0, 0, 0);
      paramResources.setLayerInset(1, 0, 0, 0, 0);
      paramResources.setLayerInset(2, 0, 0, 0, 0);
    }
  }
  
  public static Drawable a(Resources paramResources, int paramInt, Drawable paramDrawable, boolean paramBoolean)
  {
    return a(paramResources, paramInt, 2131166000, paramBoolean, 2130841966, 2131166003, paramDrawable);
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    return a(paramResources, paramInt, 2131166000, paramBoolean, 2130841966, 2131166003, null);
  }
  
  public static Drawable b(Resources paramResources, int paramInt)
  {
    Drawable localDrawable = paramResources.getDrawable(paramInt);
    paramResources = muq.a(paramResources, paramInt, 2131166000);
    paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mrz
 * JD-Core Version:    0.7.0.1
 */