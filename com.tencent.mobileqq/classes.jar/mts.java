import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.View;
import java.io.InputStream;

public class mts
  extends BitmapDrawable
{
  private ColorStateList a;
  
  public mts(Resources paramResources, Bitmap paramBitmap, int paramInt)
  {
    super(paramResources, paramBitmap);
    this.a = paramResources.getColorStateList(paramInt);
    onStateChange(getState());
  }
  
  public mts(Resources paramResources, InputStream paramInputStream, int paramInt)
  {
    super(paramResources, paramInputStream);
    this.a = paramResources.getColorStateList(paramInt);
    onStateChange(getState());
  }
  
  public static mts a(Resources paramResources, int paramInt1, int paramInt2)
  {
    return new mts(paramResources, paramResources.openRawResource(paramInt1), paramInt2);
  }
  
  public static mts a(Resources paramResources, Bitmap paramBitmap, int paramInt)
  {
    return new mts(paramResources, paramBitmap, paramInt);
  }
  
  @TargetApi(16)
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    mts localmts = a(paramView.getResources(), paramInt1, paramInt2);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(localmts);
      return;
    }
    paramView.setBackgroundDrawable(localmts);
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
 * Qualified Name:     mts
 * JD-Core Version:    0.7.0.1
 */