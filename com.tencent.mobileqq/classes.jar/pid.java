import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.3;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class pid
  extends LottieDrawable
{
  private static LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(5242880);
  private static final String jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".readInjoy/resource/lottie_background_res");
  private static LruCache<String, LottieComposition> jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(1048576);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private boolean jdField_a_of_type_Boolean = true;
  private boolean jdField_b_of_type_Boolean = true;
  
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
  
  public static pid a(String paramString)
  {
    pid localpid = new pid();
    long l = a(paramString);
    String str = jdField_a_of_type_JavaLangString + File.separator + l;
    File localFile1 = new File(str);
    if (a(localFile1)) {
      localpid.a(localFile1);
    }
    for (;;)
    {
      return localpid;
      bgoj localbgoj = ((bgog)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(47)).a(1);
      File localFile2 = new File(jdField_a_of_type_JavaLangString);
      if (!localFile2.exists()) {}
      for (boolean bool = localFile2.mkdirs(); bool; bool = true)
      {
        str = str + ".zip";
        localFile2 = new File(str);
        paramString = new bgoe(paramString, localFile2);
        paramString.b = 3;
        paramString.d = 60L;
        Bundle localBundle = new Bundle();
        localBundle.putLong("bgLottieResId", l);
        localBundle.putString("bgLottieResPath", str);
        localbgoj.a(paramString, new pii(l, str, localFile2, localFile1, new WeakReference(localpid)), localBundle);
        return localpid;
      }
    }
  }
  
  private void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyLottieDrawable", 2, "loadLottieAnimation " + paramFile.getName());
    }
    File[] arrayOfFile = paramFile.listFiles(new pie(this));
    Object localObject = paramFile.listFiles(new pif(this));
    if ((arrayOfFile == null) || (localObject == null) || (localObject.length == 0)) {}
    do
    {
      return;
      localObject = new ReadInJoyLottieDrawable.3(this, paramFile, (File[])localObject);
    } while (arrayOfFile.length <= 0);
    if ((LottieComposition)jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramFile.getAbsolutePath()) == null)
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
      paramFile = paramFile.listFiles(new pij());
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
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void playAnimation()
  {
    super.playAnimation();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLottieDrawable", 2, "playAnimation: ");
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (this.jdField_a_of_type_Boolean)) {
      cancelAnimation();
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start()
  {
    super.start();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLottieDrawable", 2, "start: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pid
 * JD-Core Version:    0.7.0.1
 */