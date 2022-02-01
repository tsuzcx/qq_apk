import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.RegionDrawable;
import com.tencent.qphone.base.util.QLog;

public class njr
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt == 0) {
      return paramBitmap;
    }
    return a(paramBitmap, paramInt, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    long l1 = System.currentTimeMillis();
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    if (QLog.isColorLevel()) {
      QLog.i("MosaicUtil", 2, "mosaic function call");
    }
    Bitmap localBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    while (paramInt2 < paramInt4)
    {
      int i = paramInt3;
      while (i < paramInt5)
      {
        localPaint.setColor(paramBitmap.getPixel(paramInt2, i));
        int m = Math.min(j, paramInt2 + paramInt1);
        int n = Math.min(k, i + paramInt1);
        localCanvas.drawRect(paramInt2, i, m, n, localPaint);
        i += paramInt1;
      }
      paramInt2 += paramInt1;
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("MosaicUtil", 2, "DrawTime: " + (l2 - l1));
    }
    return localBitmap;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable instanceof RegionDrawable)) {
      return ((RegionDrawable)paramDrawable).getBitmap();
    }
    if ((paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicHeight() <= 0)) {}
    for (Object localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njr
 * JD-Core Version:    0.7.0.1
 */