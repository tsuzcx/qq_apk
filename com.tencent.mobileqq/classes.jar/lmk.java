import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PathMeasure;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class lmk
{
  private final ArrayList<lml> a = new ArrayList(1);
  
  public void a(float paramFloat)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((lml)this.a.get(i)).a(paramFloat);
      i += 1;
    }
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getResources();
    this.a.clear();
    if (paramInt1 != 0)
    {
      Object localObject1 = paramContext.openRawResource(paramInt1);
      try
      {
        localObject1 = new BufferedReader(new InputStreamReader((InputStream)localObject1), 512);
        Object localObject2;
        do
        {
          localObject2 = new lml((BufferedReader)localObject1);
          ((BufferedReader)localObject1).readLine();
          ((BufferedReader)localObject1).readLine();
          TypedArray localTypedArray = paramContext.obtainTypedArray(paramInt2);
          int i = localTypedArray.length();
          BitmapDrawable[] arrayOfBitmapDrawable = new BitmapDrawable[i];
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            arrayOfBitmapDrawable[paramInt1] = ((BitmapDrawable)localTypedArray.getDrawable(paramInt1));
            paramInt1 += 1;
          }
          ((lml)localObject2).a(arrayOfBitmapDrawable);
          localTypedArray.recycle();
          this.a.add(localObject2);
          if (((BufferedReader)localObject1).readLine() == null) {
            return;
          }
          localObject2 = ((BufferedReader)localObject1).readLine();
        } while (localObject2 != null);
        return;
      }
      catch (IOException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ParticleEffect", 2, "WL_DEBUG loadEmitters ex = " + paramContext);
        }
      }
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((lml)this.a.get(i)).a(paramCanvas);
      i += 1;
    }
  }
  
  public void a(PathMeasure paramPathMeasure)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((lml)this.a.get(i)).a(paramPathMeasure);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lmk
 * JD-Core Version:    0.7.0.1
 */