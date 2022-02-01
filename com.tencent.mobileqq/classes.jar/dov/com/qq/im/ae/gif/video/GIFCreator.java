package dov.com.qq.im.ae.gif.video;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.AEPath.GIF.CACHE;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GIFCreator
{
  private static String jdField_a_of_type_JavaLangString = GIFCreator.class.getSimpleName();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private GIFCreator.Callback jdField_a_of_type_DovComQqImAeGifVideoGIFCreator$Callback;
  private GifEncoder jdField_a_of_type_DovComQqImVideoGifEncoder = new GifEncoder();
  private List<String> jdField_a_of_type_JavaUtilList;
  private String b = AEPath.GIF.CACHE.b;
  private String c;
  private String d;
  private String e;
  
  public GIFCreator(String paramString)
  {
    this.e = paramString;
    this.jdField_a_of_type_JavaUtilList = a(paramString);
    this.c = (this.b + System.currentTimeMillis() + ".gif");
    this.d = (this.b + System.currentTimeMillis() + "_compressed.gif");
    try
    {
      paramString = new File(this.b);
      if (!paramString.isDirectory())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, this.b + " is not a directory");
        boolean bool = paramString.mkdirs();
        QLog.d(jdField_a_of_type_JavaLangString, 4, "mkdirs return " + bool);
      }
      paramString = new HandlerThread("GIFCreatorHT" + System.currentTimeMillis());
      paramString.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString.getLooper());
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "check dir exception, msg = " + paramString.getMessage());
      }
    }
  }
  
  private List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new File(paramString);
    if (((File)localObject).isDirectory())
    {
      localObject = ((File)localObject).list(new GIFCreator.2(this));
      if (localObject != null)
      {
        Arrays.sort((Object[])localObject);
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i];
          localArrayList.add(paramString + File.separator + str);
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    FileUtils.a(this.e);
  }
  
  public void a(GIFCreator.Callback paramCallback)
  {
    this.jdField_a_of_type_DovComQqImAeGifVideoGIFCreator$Callback = paramCallback;
    QLog.d(jdField_a_of_type_JavaLangString, 4, new Object[] { "start create gif, gif path = ", this.c });
    this.jdField_a_of_type_AndroidOsHandler.post(new GIFCreator.1(this, paramCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.GIFCreator
 * JD-Core Version:    0.7.0.1
 */