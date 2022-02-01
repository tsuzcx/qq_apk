import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class ngm
{
  public int a;
  public Bitmap a;
  public String a;
  public boolean a;
  public int b;
  public String b = "";
  public int c;
  public int d;
  public int e;
  
  public ngm()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static ngm a(View paramView)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Bitmap localBitmap;
    if (paramView.getVisibility() == 0)
    {
      paramView.setDrawingCacheEnabled(true);
      localBitmap = paramView.getDrawingCache();
      if (localBitmap != null) {
        break label42;
      }
      QLog.e("GameImageData", 1, "mTipsWrapper, get drawingCache return null");
      localObject1 = localObject2;
    }
    for (;;)
    {
      paramView.setDrawingCacheEnabled(false);
      return localObject1;
      label42:
      localObject1 = new ngm();
      ((ngm)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = localBitmap.copy(Bitmap.Config.ARGB_8888, false);
      ((ngm)localObject1).c = paramView.getLeft();
      ((ngm)localObject1).d = paramView.getTop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ngm
 * JD-Core Version:    0.7.0.1
 */