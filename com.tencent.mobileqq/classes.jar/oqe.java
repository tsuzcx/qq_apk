import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.3;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class oqe
  extends LottieDrawable
{
  private static LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(5242880);
  private static final String jdField_a_of_type_JavaLangString = bbuv.a(ajsf.aW + ".readInjoy/resource/lottie_background_res");
  private static LruCache<String, LottieComposition> b = new LruCache(1048576);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  private static long a(String paramString)
  {
    long l = 0L;
    int i = 0;
    while (i < paramString.length())
    {
      l = (l + paramString.charAt(i)) * 131L % 53497342331L;
      i += 1;
    }
    return l;
  }
  
  @Nullable
  private File a(File[] paramArrayOfFile, String paramString)
  {
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramArrayOfFile[i];
      if (localFile.getName().equals(paramString)) {
        return localFile;
      }
      i += 1;
    }
    return null;
  }
  
  public static oqe a(String paramString)
  {
    oqe localoqe = new oqe();
    long l = a(paramString);
    String str = jdField_a_of_type_JavaLangString + File.separator + l;
    File localFile1 = new File(str);
    if (a(localFile1)) {
      localoqe.a(localFile1);
    }
    for (;;)
    {
      return localoqe;
      bbwl localbbwl = ((bbwi)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(47)).a(1);
      File localFile2 = new File(jdField_a_of_type_JavaLangString);
      if (!localFile2.exists()) {}
      for (boolean bool = localFile2.mkdirs(); bool; bool = true)
      {
        str = str + ".zip";
        localFile2 = new File(str);
        paramString = new bbwg(paramString, localFile2);
        paramString.b = 3;
        paramString.d = 60L;
        Bundle localBundle = new Bundle();
        localBundle.putLong("bgLottieResId", l);
        localBundle.putString("bgLottieResPath", str);
        localbbwl.a(paramString, new oqj(l, str, localFile2, localFile1, new WeakReference(localoqe)), localBundle);
        return localoqe;
      }
    }
  }
  
  private void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyLottieDrawable", 2, "loadLottieAnimation " + paramFile.getName());
    }
    File[] arrayOfFile = paramFile.listFiles(new oqf(this));
    Object localObject = paramFile.listFiles(new oqg(this));
    if ((arrayOfFile == null) || (localObject == null)) {}
    do
    {
      return;
      localObject = new ReadInJoyLottieDrawable.3(this, paramFile, (File[])localObject);
    } while (arrayOfFile.length <= 0);
    if ((LottieComposition)b.get(paramFile.getAbsolutePath()) == null)
    {
      ThreadManager.excute(new ReadInJoyLottieDrawable.4(this, arrayOfFile, paramFile, (Runnable)localObject), 64, null, true);
      return;
    }
    ((Runnable)localObject).run();
  }
  
  private static boolean a(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile.exists())
    {
      paramFile = paramFile.listFiles(new oqk());
      bool1 = bool2;
      if (paramFile != null)
      {
        bool1 = bool2;
        if (paramFile.length > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      cancelAnimation();
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqe
 * JD-Core Version:    0.7.0.1
 */