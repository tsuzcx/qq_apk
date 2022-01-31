import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.View;
import java.io.InputStream;

public class mtp
  extends BitmapDrawable
{
  private ColorStateList a;
  
  public mtp(Resources paramResources, Bitmap paramBitmap, int paramInt)
  {
    super(paramResources, paramBitmap);
    this.a = paramResources.getColorStateList(paramInt);
    onStateChange(getState());
  }
  
  public mtp(Resources paramResources, InputStream paramInputStream, int paramInt)
  {
    super(paramResources, paramInputStream);
    this.a = paramResources.getColorStateList(paramInt);
    onStateChange(getState());
  }
  
  public static mtp a(Resources paramResources, int paramInt1, int paramInt2)
  {
    return new mtp(paramResources, paramResources.openRawResource(paramInt1), paramInt2);
  }
  
  public static mtp a(Resources paramResources, Bitmap paramBitmap, int paramInt)
  {
    return new mtp(paramResources, paramBitmap, paramInt);
  }
  
  @TargetApi(16)
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    mtp localmtp = a(paramView.getResources(), paramInt1, paramInt2);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(localmtp);
      return;
    }
    paramView.setBackgroundDrawable(localmtp);
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.a.getColorForState(paramArrayOfInt, 0);
    if (i != 0) {
      setColorFilter(i, PorterDuff.Mode.MULTIPLY);
    }
    for (;;)
    {
      invalidateSelf();
      return super.onStateChange(paramArrayOfInt);
      clearColorFilter();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mtp
 * JD-Core Version:    0.7.0.1
 */