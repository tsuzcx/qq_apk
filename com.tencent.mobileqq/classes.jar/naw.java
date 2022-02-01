import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import com.tencent.avgame.gameroom.AVGameLottieHelper.2;
import com.tencent.avgame.gameroom.AVGameLottieHelper.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import org.jetbrains.annotations.Nullable;

public class naw
{
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, nbb paramnbb)
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(paramContext, paramString1, new naz(paramInt1, paramContext, paramInt2, paramInt3, paramString2, paramnbb));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("AVGameLottieHelper", 1, "fromAssetFileName fail", paramContext);
      bkdz.a().post(new AVGameLottieHelper.4(paramnbb));
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, nbb paramnbb)
  {
    paramString1 = mzu.a() + paramString1;
    paramString2 = mzu.a() + paramString2;
    if (QLog.isColorLevel()) {
      QLog.d("AVGameLottieHelper", 2, "loadLottieAnim  animJsonPath = " + paramString1 + ",animImageDirPath = " + paramString2);
    }
    if ((bhmi.b(paramString1)) && (bhmi.b(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVGameLottieHelper", 2, "loadLottieAnim loadLottieAnimFromFile");
      }
      b(paramContext, paramString1, paramString2, paramInt1, paramInt2, paramnbb);
    }
  }
  
  @Nullable
  private static Bitmap b(String paramString)
  {
    Object localObject = BaseApplicationImpl.sImageCache.get(paramString);
    if ((localObject != null) && ((localObject instanceof Bitmap))) {
      return (Bitmap)localObject;
    }
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inScaled = false;
      localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      BaseApplicationImpl.sImageCache.put(paramString, localObject);
      return localObject;
    }
    catch (Throwable paramString)
    {
      QLog.i("AVGameLottieHelper", 1, "getBitmap error " + paramString.getMessage());
    }
    return null;
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, nbb paramnbb)
  {
    try
    {
      LottieComposition.Factory.fromInputStream(paramContext, new FileInputStream(paramString1), new nax(paramInt1, paramInt2, paramContext, paramString2, paramnbb));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("AVGameLottieHelper", 1, "fromAssetFileName fail", paramContext);
      bkdz.a().post(new AVGameLottieHelper.2(paramnbb));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     naw
 * JD-Core Version:    0.7.0.1
 */