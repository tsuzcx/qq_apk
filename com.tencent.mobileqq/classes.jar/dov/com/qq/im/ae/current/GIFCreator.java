package dov.com.qq.im.ae.current;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GIFCreator
{
  private static String jdField_a_of_type_JavaLangString = "GIFCreator";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private GIFCreator.Callback jdField_a_of_type_DovComQqImAeCurrentGIFCreator$Callback;
  private GifEncoder jdField_a_of_type_DovComQqImVideoGifEncoder = new GifEncoder();
  private List<String> jdField_a_of_type_JavaUtilList;
  private String b = ((IAEPath)QRoute.api(IAEPath.class)).getGifPreviewCache();
  private String c;
  private String d;
  private String e;
  
  public GIFCreator(String paramString)
  {
    this.e = paramString;
    this.jdField_a_of_type_JavaUtilList = a(paramString);
    paramString = new StringBuilder();
    paramString.append(this.b);
    paramString.append(System.currentTimeMillis());
    paramString.append(".gif");
    this.c = paramString.toString();
    paramString = new StringBuilder();
    paramString.append(this.b);
    paramString.append(System.currentTimeMillis());
    paramString.append("_compressed.gif");
    this.d = paramString.toString();
    try
    {
      paramString = new File(this.b);
      if (!paramString.isDirectory())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b);
        localStringBuilder.append(" is not a directory");
        QLog.d((String)localObject, 4, localStringBuilder.toString());
        boolean bool = paramString.mkdirs();
        paramString = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mkdirs return ");
        ((StringBuilder)localObject).append(bool);
        QLog.d(paramString, 4, ((StringBuilder)localObject).toString());
      }
    }
    catch (Exception paramString)
    {
      Object localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("check dir exception, msg = ");
      localStringBuilder.append(paramString.getMessage());
      QLog.d((String)localObject, 4, localStringBuilder.toString());
    }
    paramString = new StringBuilder();
    paramString.append("GIFCreatorHT");
    paramString.append(System.currentTimeMillis());
    paramString = new HandlerThread(paramString.toString());
    paramString.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString.getLooper());
  }
  
  private Bitmap a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    localObject2 = null;
    localObject1 = null;
    try
    {
      localObject3 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject1 = localObject3;
      localObject2 = localObject3;
      ((Bitmap)localObject3).setPremultiplied(paramBoolean);
      localObject1 = localObject3;
      localObject2 = localObject3;
      paramString = a(new File(paramString));
      localObject1 = localObject3;
      localObject2 = localObject3;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(((Bitmap)localObject3).getWidth() * ((Bitmap)localObject3).getHeight() * 4);
      if (paramString != null)
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        localByteBuffer.put(paramString);
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
      localByteBuffer.position(0);
      localObject1 = localObject3;
      localObject2 = localObject3;
      ((Bitmap)localObject3).copyPixelsFromBuffer(localByteBuffer);
      return localObject3;
    }
    catch (Exception paramString)
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("readRawBytesToBitmap exception, msg = ");
      ((StringBuilder)localObject3).append(paramString.getMessage());
      QLog.d((String)localObject2, 4, ((StringBuilder)localObject3).toString());
      return localObject1;
    }
    catch (OutOfMemoryError paramString)
    {
      label129:
      break label129;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "readRawBytesToBitmap OOM");
    return localObject2;
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(str);
          localArrayList.add(localStringBuilder.toString());
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  /* Error */
  private static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 220	java/io/File:isFile	()Z
    //   4: ifeq +133 -> 137
    //   7: new 222	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 225	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_2
    //   16: aload_2
    //   17: astore_0
    //   18: sipush 1024
    //   21: newarray byte
    //   23: astore_3
    //   24: aload_2
    //   25: astore_0
    //   26: new 227	java/io/ByteArrayOutputStream
    //   29: dup
    //   30: invokespecial 228	java/io/ByteArrayOutputStream:<init>	()V
    //   33: astore 4
    //   35: aload_2
    //   36: astore_0
    //   37: aload_2
    //   38: aload_3
    //   39: invokevirtual 232	java/io/FileInputStream:read	([B)I
    //   42: istore_1
    //   43: iload_1
    //   44: iconst_m1
    //   45: if_icmpeq +16 -> 61
    //   48: aload_2
    //   49: astore_0
    //   50: aload 4
    //   52: aload_3
    //   53: iconst_0
    //   54: iload_1
    //   55: invokevirtual 236	java/io/ByteArrayOutputStream:write	([BII)V
    //   58: goto -23 -> 35
    //   61: aload_2
    //   62: astore_0
    //   63: aload 4
    //   65: invokevirtual 240	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   68: astore_3
    //   69: aload_2
    //   70: invokevirtual 243	java/io/FileInputStream:close	()V
    //   73: aload_3
    //   74: areturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 246	java/io/IOException:printStackTrace	()V
    //   80: aload_3
    //   81: areturn
    //   82: astore_3
    //   83: goto +12 -> 95
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_0
    //   89: goto +30 -> 119
    //   92: astore_3
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_2
    //   96: astore_0
    //   97: aload_3
    //   98: invokevirtual 246	java/io/IOException:printStackTrace	()V
    //   101: aload_2
    //   102: ifnull +72 -> 174
    //   105: aload_2
    //   106: invokevirtual 243	java/io/FileInputStream:close	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 246	java/io/IOException:printStackTrace	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_2
    //   119: aload_0
    //   120: ifnull +15 -> 135
    //   123: aload_0
    //   124: invokevirtual 243	java/io/FileInputStream:close	()V
    //   127: goto +8 -> 135
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 246	java/io/IOException:printStackTrace	()V
    //   135: aload_2
    //   136: athrow
    //   137: getstatic 89	dov/com/qq/im/ae/current/GIFCreator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   140: astore_2
    //   141: new 54	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   148: astore_3
    //   149: aload_3
    //   150: ldc 248
    //   152: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_3
    //   157: aload_0
    //   158: invokevirtual 251	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   161: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_2
    //   166: iconst_4
    //   167: aload_3
    //   168: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aconst_null
    //   175: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramFile	File
    //   42	13	1	i	int
    //   15	55	2	localFileInputStream	java.io.FileInputStream
    //   86	1	2	localObject1	Object
    //   94	12	2	localObject2	Object
    //   118	18	2	localObject3	Object
    //   140	26	2	str	String
    //   23	58	3	arrayOfByte	byte[]
    //   82	1	3	localIOException1	java.io.IOException
    //   92	6	3	localIOException2	java.io.IOException
    //   148	20	3	localStringBuilder	StringBuilder
    //   33	31	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   69	73	75	java/io/IOException
    //   18	24	82	java/io/IOException
    //   26	35	82	java/io/IOException
    //   37	43	82	java/io/IOException
    //   50	58	82	java/io/IOException
    //   63	69	82	java/io/IOException
    //   7	16	86	finally
    //   7	16	92	java/io/IOException
    //   105	109	111	java/io/IOException
    //   18	24	118	finally
    //   26	35	118	finally
    //   37	43	118	finally
    //   50	58	118	finally
    //   63	69	118	finally
    //   97	101	118	finally
    //   123	127	130	java/io/IOException
  }
  
  public void a()
  {
    FileUtils.deleteDirectory(this.e);
  }
  
  public void a(GIFCreator.Callback paramCallback)
  {
    this.jdField_a_of_type_DovComQqImAeCurrentGIFCreator$Callback = paramCallback;
    QLog.d(jdField_a_of_type_JavaLangString, 4, new Object[] { "start create gif, gif path = ", this.c });
    this.jdField_a_of_type_AndroidOsHandler.post(new GIFCreator.1(this, paramCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.current.GIFCreator
 * JD-Core Version:    0.7.0.1
 */