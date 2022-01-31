package cooperation.qzone.webviewplugin;

import ancj;
import anck;
import ancl;
import ancm;
import ancn;
import anco;
import ancp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.AudioManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.DeviceApiPlugin;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.DynamicPhotoData;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.QZLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneDynamicAlbumPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  static File jdField_a_of_type_JavaIoFile;
  public static final String a;
  private static int[] jdField_a_of_type_ArrayOfInt;
  static File jdField_b_of_type_JavaIoFile = new File(Environment.getExternalStorageDirectory().getPath() + "/Tencent/Qzone/qzoneothers/");
  private static String jdField_c_of_type_JavaLangString;
  private byte jdField_a_of_type_Byte = 111;
  private int jdField_a_of_type_Int = 274;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new anck(this);
  public Handler a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private List jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private List jdField_d_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_d_of_type_Boolean;
  private List jdField_e_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_e_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/Tencent/Qzone/qzonedynamicalbum/";
  }
  
  public QzoneDynamicAlbumPlugin()
  {
    this.jdField_a_of_type_AndroidOsHandler = new ancn(this);
  }
  
  public static double a(QzoneDynamicAlbumPlugin.Size paramSize)
  {
    if (jdField_a_of_type_ArrayOfInt == null) {
      jdField_a_of_type_ArrayOfInt = a();
    }
    if (paramSize != null)
    {
      int i = paramSize.jdField_a_of_type_Int;
      int j = paramSize.b;
      int k;
      if (i < j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        double d3;
        if ((k <= jdField_a_of_type_ArrayOfInt[0]) && (j <= jdField_a_of_type_ArrayOfInt[1]))
        {
          d3 = 0.0D;
          return d3;
        }
        double d1;
        if (k > j) {
          d1 = k / jdField_a_of_type_ArrayOfInt[0];
        }
        for (double d2 = j / jdField_a_of_type_ArrayOfInt[1];; d2 = k / jdField_a_of_type_ArrayOfInt[1])
        {
          d3 = d1;
          if (d1 > d2) {
            break;
          }
          return d2;
          d1 = j / jdField_a_of_type_ArrayOfInt[0];
        }
        k = i;
      }
    }
    return 0.0D;
  }
  
  public static double a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      paramInputStream.close();
      label27:
      i = localOptions.outWidth;
      j = localOptions.outHeight;
      double d1 = 0.0D;
      if ((paramInt1 != -1) && (paramInt2 != -1))
      {
        d1 = i / paramInt1;
        d2 = j / paramInt2;
        if (d1 > d2) {
          return d1;
        }
      }
    }
    catch (IOException paramInputStream)
    {
      int j;
      do
      {
        int i;
        double d2;
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
        return d2;
        if (paramInt1 != -1) {
          return i / paramInt1;
        }
      } while (paramInt2 == -1);
      return j / paramInt2;
    }
    catch (OutOfMemoryError paramInputStream)
    {
      break label27;
    }
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = JpegExifReader.getRotationDegree(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return paramBitmap;
  }
  
  public static BitmapFactory.Options a(Uri paramUri, Context paramContext, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    InputStream localInputStream = paramContext.getContentResolver().openInputStream(paramUri);
    double d1 = a(localInputStream, paramInt1, paramInt2);
    paramInt2 = (int)d1;
    paramInt1 = paramInt2;
    if (d1 > paramInt2) {
      paramInt1 = paramInt2 + 1;
    }
    localOptions.inSampleSize = paramInt1;
    localOptions.inJustDecodeBounds = true;
    localInputStream.close();
    paramUri = paramContext.getContentResolver().openInputStream(paramUri);
    try
    {
      BitmapFactory.decodeStream(paramUri, null, localOptions);
      paramUri.close();
      localOptions.inJustDecodeBounds = false;
      return localOptions;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        QLog.e("QzoneDynamicAlbumPlugin", 1, "getSizeCrop" + paramContext);
      }
    }
  }
  
  @TargetApi(11)
  public static WebResourceResponse a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse start :" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return null;
        String str = paramString.replace("http://www.dynamicalbumlocalimage.com", "");
        try
        {
          str = URLDecoder.decode(str, "UTF-8");
          if (QLog.isDevelopLevel()) {
            QLog.i("QzoneDynamicAlbumPlugin", 4, "image filePath :" + str);
          }
          localFile = new File(str);
          if ((jdField_c_of_type_JavaLangString != null) && (jdField_c_of_type_JavaLangString.equals("https://h5.qzone.qq.com/dynamic/album/list?_ws&_wv=2098179&_wwv=4&_proxy=1")))
          {
            QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse -  getThumbnail:" + paramString);
            InputStream localInputStream = a(str);
            if (localInputStream != null) {
              return new WebResourceResponse("image/*", "utf-8", localInputStream);
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          File localFile;
          Object localObject;
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            localObject = null;
          }
          if (!localFile.exists())
          {
            if (QLog.isDevelopLevel())
            {
              QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse local file not exists :" + (String)localObject);
              return null;
            }
          }
          else {
            try
            {
              localObject = new FileInputStream((String)localObject);
              if (QLog.isDevelopLevel()) {
                QLog.i("QzoneDynamicAlbumPlugin", 4, "getImageResponse ****************** :" + paramString);
              }
              return new WebResourceResponse("image/*", "utf-8", (InputStream)localObject);
            }
            catch (FileNotFoundException localFileNotFoundException)
            {
              localFileNotFoundException.printStackTrace();
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("QzoneDynamicAlbumPlugin", 2, "getImageResponse get local file fail:" + paramString);
    return null;
  }
  
  public static QzoneDynamicAlbumPlugin.Size a(String paramString)
  {
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeFile(paramString, localOptions);
      localOptions.inJustDecodeBounds = false;
      return new QzoneDynamicAlbumPlugin.Size(localOptions.outWidth, localOptions.outHeight);
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        QLog.e("QzoneDynamicAlbumPlugin", 1, "getBitmapSize: OutOfMemoryError" + paramString);
      }
    }
  }
  
  private static InputStream a(String paramString)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    float f = Math.min(((BitmapFactory.Options)localObject).outWidth / 400, ((BitmapFactory.Options)localObject).outHeight / 300);
    int i = 1;
    while (i < f) {
      i *= 2;
    }
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      localObject = new ByteArrayOutputStream();
      paramString.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      paramString = new ByteArrayInputStream(((ByteArrayOutputStream)localObject).toByteArray());
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("QzoneDynamicAlbumPlugin", 1, "getThumbnail:outOfMemortError " + paramString);
    }
    return null;
  }
  
  /* Error */
  public static String a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_1
    //   7: aload_0
    //   8: iload_2
    //   9: iload_3
    //   10: invokestatic 322	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Landroid/net/Uri;Landroid/content/Context;II)Landroid/graphics/BitmapFactory$Options;
    //   13: astore 6
    //   15: aload_0
    //   16: invokevirtual 179	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: aload_1
    //   20: invokevirtual 185	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   23: astore 5
    //   25: aload 5
    //   27: astore_0
    //   28: aload 5
    //   30: aload 6
    //   32: aload_1
    //   33: invokevirtual 325	android/net/Uri:getPath	()Ljava/lang/String;
    //   36: invokestatic 327	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Ljava/lang/String;)I
    //   39: iload 4
    //   41: invokestatic 330	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;IZ)Ljava/lang/String;
    //   44: astore_1
    //   45: aload 5
    //   47: invokestatic 334	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   50: pop
    //   51: aload_1
    //   52: areturn
    //   53: astore_1
    //   54: aconst_null
    //   55: astore 5
    //   57: aload 5
    //   59: astore_0
    //   60: ldc 192
    //   62: iconst_1
    //   63: new 25	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 336
    //   73: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload 5
    //   88: invokestatic 334	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore 5
    //   98: aload_0
    //   99: astore_1
    //   100: aload 5
    //   102: invokestatic 334	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   105: pop
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: astore 5
    //   112: goto -12 -> 100
    //   115: astore_1
    //   116: goto -59 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramContext	Context
    //   0	119	1	paramUri	Uri
    //   0	119	2	paramInt1	int
    //   0	119	3	paramInt2	int
    //   0	119	4	paramBoolean	boolean
    //   23	88	5	localObject	Object
    //   13	18	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   6	25	53	java/lang/Exception
    //   6	25	94	finally
    //   28	45	108	finally
    //   60	86	108	finally
    //   28	45	115	java/lang/Exception
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 297	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: invokespecial 298	java/io/ByteArrayOutputStream:<init>	()V
    //   10: astore 7
    //   12: aload 7
    //   14: astore 6
    //   16: aload_1
    //   17: getfield 190	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   20: iconst_1
    //   21: if_icmpgt +25 -> 46
    //   24: aload 7
    //   26: astore 6
    //   28: aload_1
    //   29: getfield 343	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   32: invokestatic 346	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Ljava/lang/String;)Z
    //   35: ifeq +11 -> 46
    //   38: iload 5
    //   40: istore 4
    //   42: iload_3
    //   43: ifeq +143 -> 186
    //   46: aload 7
    //   48: astore 6
    //   50: aload_1
    //   51: getstatic 352	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   54: putfield 355	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   57: aload 7
    //   59: astore 6
    //   61: aload_1
    //   62: iconst_1
    //   63: putfield 358	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   66: aload 7
    //   68: astore 6
    //   70: aload_1
    //   71: iconst_1
    //   72: putfield 361	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   75: aload 7
    //   77: astore 6
    //   79: aload_0
    //   80: aconst_null
    //   81: aload_1
    //   82: invokestatic 119	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   85: astore 8
    //   87: aload 7
    //   89: astore 6
    //   91: ldc 192
    //   93: iconst_1
    //   94: new 25	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 363
    //   104: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: getfield 127	android/graphics/BitmapFactory$Options:outWidth	I
    //   111: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: ldc_w 368
    //   117: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: getfield 130	android/graphics/BitmapFactory$Options:outHeight	I
    //   124: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 219	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 8
    //   135: astore_1
    //   136: iload_2
    //   137: ifeq +14 -> 151
    //   140: aload 7
    //   142: astore 6
    //   144: aload 8
    //   146: iload_2
    //   147: invokestatic 370	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   150: astore_1
    //   151: iload 5
    //   153: istore 4
    //   155: aload_1
    //   156: ifnull +30 -> 186
    //   159: aload 7
    //   161: astore 6
    //   163: aload_1
    //   164: getstatic 373	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   167: bipush 60
    //   169: aload 7
    //   171: invokevirtual 308	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   174: pop
    //   175: aload 7
    //   177: astore 6
    //   179: aload_1
    //   180: invokevirtual 172	android/graphics/Bitmap:recycle	()V
    //   183: iconst_1
    //   184: istore 4
    //   186: iload 4
    //   188: ifne +102 -> 290
    //   191: aload 7
    //   193: astore 6
    //   195: ldc 192
    //   197: iconst_1
    //   198: ldc_w 375
    //   201: invokestatic 219	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload 7
    //   206: astore 6
    //   208: sipush 4096
    //   211: newarray byte
    //   213: astore_1
    //   214: aload 7
    //   216: astore 6
    //   218: aload_0
    //   219: aload_1
    //   220: invokevirtual 379	java/io/InputStream:read	([B)I
    //   223: istore_2
    //   224: iload_2
    //   225: iconst_m1
    //   226: if_icmpeq +64 -> 290
    //   229: aload 7
    //   231: astore 6
    //   233: aload 7
    //   235: aload_1
    //   236: iconst_0
    //   237: iload_2
    //   238: invokevirtual 383	java/io/ByteArrayOutputStream:write	([BII)V
    //   241: goto -27 -> 214
    //   244: astore_0
    //   245: aload 7
    //   247: astore 6
    //   249: ldc 192
    //   251: iconst_1
    //   252: ldc_w 385
    //   255: aload_0
    //   256: invokestatic 388	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   259: aload 7
    //   261: invokestatic 334	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   264: pop
    //   265: aconst_null
    //   266: areturn
    //   267: astore 8
    //   269: aload 7
    //   271: astore 6
    //   273: ldc 192
    //   275: iconst_1
    //   276: ldc_w 390
    //   279: aload 8
    //   281: invokestatic 388	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   284: aconst_null
    //   285: astore 8
    //   287: goto -200 -> 87
    //   290: aload 7
    //   292: astore 6
    //   294: aload 7
    //   296: invokevirtual 314	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   299: iconst_2
    //   300: invokestatic 396	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   303: astore_0
    //   304: aload 7
    //   306: invokestatic 334	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   309: pop
    //   310: aload_0
    //   311: areturn
    //   312: astore_0
    //   313: aconst_null
    //   314: astore 7
    //   316: aload 7
    //   318: astore 6
    //   320: ldc 192
    //   322: iconst_1
    //   323: ldc_w 390
    //   326: aload_0
    //   327: invokestatic 388	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   330: aload 7
    //   332: invokestatic 334	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   335: pop
    //   336: aconst_null
    //   337: areturn
    //   338: astore_0
    //   339: aconst_null
    //   340: astore 6
    //   342: aload 6
    //   344: invokestatic 334	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   347: pop
    //   348: aload_0
    //   349: athrow
    //   350: astore_0
    //   351: goto -9 -> 342
    //   354: astore_0
    //   355: goto -39 -> 316
    //   358: astore_0
    //   359: aconst_null
    //   360: astore 7
    //   362: goto -117 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramInputStream	InputStream
    //   0	365	1	paramOptions	BitmapFactory.Options
    //   0	365	2	paramInt	int
    //   0	365	3	paramBoolean	boolean
    //   40	147	4	i	int
    //   1	151	5	j	int
    //   14	329	6	localByteArrayOutputStream1	ByteArrayOutputStream
    //   10	351	7	localByteArrayOutputStream2	ByteArrayOutputStream
    //   85	60	8	localBitmap	Bitmap
    //   267	13	8	localOutOfMemoryError	OutOfMemoryError
    //   285	1	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	24	244	java/lang/Exception
    //   28	38	244	java/lang/Exception
    //   50	57	244	java/lang/Exception
    //   61	66	244	java/lang/Exception
    //   70	75	244	java/lang/Exception
    //   79	87	244	java/lang/Exception
    //   91	133	244	java/lang/Exception
    //   144	151	244	java/lang/Exception
    //   163	175	244	java/lang/Exception
    //   179	183	244	java/lang/Exception
    //   195	204	244	java/lang/Exception
    //   208	214	244	java/lang/Exception
    //   218	224	244	java/lang/Exception
    //   233	241	244	java/lang/Exception
    //   273	284	244	java/lang/Exception
    //   294	304	244	java/lang/Exception
    //   79	87	267	java/lang/OutOfMemoryError
    //   3	12	312	java/lang/OutOfMemoryError
    //   3	12	338	finally
    //   16	24	350	finally
    //   28	38	350	finally
    //   50	57	350	finally
    //   61	66	350	finally
    //   70	75	350	finally
    //   79	87	350	finally
    //   91	133	350	finally
    //   144	151	350	finally
    //   163	175	350	finally
    //   179	183	350	finally
    //   195	204	350	finally
    //   208	214	350	finally
    //   218	224	350	finally
    //   233	241	350	finally
    //   249	259	350	finally
    //   273	284	350	finally
    //   294	304	350	finally
    //   320	330	350	finally
    //   16	24	354	java/lang/OutOfMemoryError
    //   28	38	354	java/lang/OutOfMemoryError
    //   50	57	354	java/lang/OutOfMemoryError
    //   61	66	354	java/lang/OutOfMemoryError
    //   70	75	354	java/lang/OutOfMemoryError
    //   91	133	354	java/lang/OutOfMemoryError
    //   144	151	354	java/lang/OutOfMemoryError
    //   163	175	354	java/lang/OutOfMemoryError
    //   179	183	354	java/lang/OutOfMemoryError
    //   195	204	354	java/lang/OutOfMemoryError
    //   208	214	354	java/lang/OutOfMemoryError
    //   218	224	354	java/lang/OutOfMemoryError
    //   233	241	354	java/lang/OutOfMemoryError
    //   273	284	354	java/lang/OutOfMemoryError
    //   294	304	354	java/lang/OutOfMemoryError
    //   3	12	358	java/lang/Exception
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, false);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str1 = paramString;
    if (paramString.startsWith("/")) {}
    try
    {
      str1 = "file:///" + Uri.encode(paramString.substring(1));
      paramString = Uri.parse(str1);
      return a(BaseApplicationImpl.getContext(), paramString, paramInt1, paramInt2, paramBoolean);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QzoneDynamicAlbumPlugin", 1, "compressImage with some: URL encode failed");
        String str2 = paramString;
      }
    }
  }
  
  private String a(String[] paramArrayOfString)
  {
    QzoneDynamicAlbumPlugin.Size localSize = a(paramArrayOfString[1]);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", "http://www.dynamicalbumlocalimage.com" + paramArrayOfString[1]);
      if (localSize != null)
      {
        localJSONObject.put("width", localSize.jdField_a_of_type_Int);
        localJSONObject.put("height", localSize.b);
      }
      paramArrayOfString = a(paramArrayOfString[0]);
      if (paramArrayOfString != null)
      {
        localJSONObject.put("poiX", paramArrayOfString[1]);
        localJSONObject.put("poiY", paramArrayOfString[0]);
        localJSONObject.put("poiName", "");
      }
      paramArrayOfString = localJSONObject.toString();
      return paramArrayOfString;
    }
    catch (JSONException paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return "";
  }
  
  private void a(Bundle paramBundle)
  {
    try
    {
      int i = paramBundle.getInt("param.DynamicMin");
      int j = paramBundle.getInt("param.DynamicMax");
      paramBundle = paramBundle.getString("param.DynamicCmd");
      if (!TextUtils.isEmpty(paramBundle))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", 0);
        localJSONObject.put("msg", "success");
        localJSONObject.put("maxNum", j);
        localJSONObject.put("minNum", i);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramBundle, new String[] { localJSONObject.toString() });
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject4 = paramBundle.getStringArrayList("param.DynamicCloudPhotolist");
    Object localObject3 = paramBundle.getStringArrayList("param.DynamicCloudPhotolistAlbumId");
    Object localObject2 = paramBundle.getStringArrayList("param.DynamicCloudPhotolistlloc");
    Object localObject1 = paramBundle.getIntegerArrayList("param.DynamicCloudPhotoHeight");
    paramBundle = paramBundle.getIntegerArrayList("param.DynamicCloudPhotoWidth");
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_e_of_type_JavaUtilList.clear();
    if ((localObject4 != null) && (((List)localObject4).size() > 0))
    {
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        this.jdField_a_of_type_JavaUtilArrayList.add(str);
      }
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        this.jdField_b_of_type_JavaUtilList.add(localObject4);
      }
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        this.jdField_c_of_type_JavaUtilList.add(localObject3);
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        this.jdField_d_of_type_JavaUtilList.add(localObject2);
      }
    }
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject1 = (Integer)paramBundle.next();
        this.jdField_e_of_type_JavaUtilList.add(localObject1);
      }
    }
    if (paramBoolean) {
      if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
        break label488;
      }
    }
    label488:
    for (paramBundle = (String)this.jdField_b_of_type_JavaUtilList.get(0);; paramBundle = null)
    {
      if (this.jdField_c_of_type_JavaUtilList.size() > 0) {}
      for (localObject1 = (String)this.jdField_c_of_type_JavaUtilList.get(0);; localObject1 = null)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {}
        for (localObject2 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);; localObject2 = null)
        {
          RemoteHandleManager.a().a().a(paramBundle, (String)localObject1, (String)localObject2, this.jdField_b_of_type_JavaUtilList.size());
          return;
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    int j = 0;
    QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid - start");
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject1 = paramString.getJSONArray("photosPath");
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getString(i);
          if (!((String)localObject2).startsWith("http://www.dynamicalbumlocalimage.com")) {
            break label213;
          }
          localObject2 = new File(((String)localObject2).replace("http://www.dynamicalbumlocalimage.com", ""));
          QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid - isValid:true");
          if (((File)localObject2).exists()) {
            break label213;
          }
          i = j;
          paramString = paramString.getString("callback");
          localObject1 = new JSONObject();
          if (i != 0)
          {
            QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid SUCCESS!");
            ((JSONObject)localObject1).put("code", 0);
            ((JSONObject)localObject1).put("msg", "success");
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
            return;
          }
          QLog.d("QzoneDynamicAlbumPlugin", 4, "isDraftPhotosValid FAILE");
          ((JSONObject)localObject1).put("code", -1);
          ((JSONObject)localObject1).put("msg", "fail");
          continue;
        }
        i = 1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      continue;
      label213:
      i += 1;
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    QLog.d("QzoneDynamicAlbumPlugin", 4, "pickDynamicAlbumImage start!");
    if (paramArrayList != null) {}
    for (int i = paramArrayList.size();; i = 0)
    {
      new ArrayList();
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        if (jdField_a_of_type_ArrayOfInt == null) {
          jdField_a_of_type_ArrayOfInt = a();
        }
        if (jdField_a_of_type_JavaIoFile == null) {
          jdField_a_of_type_JavaIoFile = new File(jdField_a_of_type_JavaLangString);
        }
        ThreadManager.post(new anco(this, paramArrayList, i), 5, null, true);
      }
      return;
    }
  }
  
  private void a(List paramList)
  {
    int i = 0;
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin getDynamicAlbumImage " + paramList.size() + " " + (String)paramList.get(0));
      }
      if (jdField_a_of_type_ArrayOfInt != null) {}
    }
    else
    {
      return;
    }
    String[] arrayOfString = new String[paramList.size()];
    while (i < paramList.size()) {
      if (paramList.get(i) == null)
      {
        i += 1;
      }
      else
      {
        Object localObject = (String)paramList.get(i);
        int j = a((String)localObject);
        QzoneDynamicAlbumPlugin.Size localSize = a((String)localObject);
        float[] arrayOfFloat = a((String)localObject);
        double d1 = a(localSize);
        if (((j == 90) || (j == 270)) && (localSize != null))
        {
          j = localSize.jdField_a_of_type_Int;
          localSize.jdField_a_of_type_Int = localSize.b;
          localSize.b = j;
        }
        localObject = new JSONObject();
        arrayOfString[i] = (jdField_a_of_type_JavaLangString + (new Date().getTime() + i));
        for (;;)
        {
          try
          {
            ((JSONObject)localObject).put("url", "http://www.dynamicalbumlocalimage.com" + arrayOfString[i]);
            if (localSize != null)
            {
              if (d1 <= 0.0D) {
                continue;
              }
              ((JSONObject)localObject).put("width", (int)(localSize.jdField_a_of_type_Int / d1));
              ((JSONObject)localObject).put("height", (int)(localSize.b / d1));
            }
            if (arrayOfFloat != null)
            {
              ((JSONObject)localObject).put("poiX", arrayOfFloat[1]);
              ((JSONObject)localObject).put("poiY", arrayOfFloat[0]);
              ((JSONObject)localObject).put("poiName", "");
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            continue;
          }
          this.jdField_a_of_type_JavaUtilList.add(((JSONObject)localObject).toString());
          break;
          ((JSONObject)localObject).put("width", localSize.jdField_a_of_type_Int);
          ((JSONObject)localObject).put("height", localSize.b);
        }
      }
    }
    ThreadManager.post(new ancp(this, paramList, arrayOfString), 5, null, true);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      DeviceApiPlugin.a(true, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), false);
      return;
    }
    DeviceApiPlugin.a(false, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), false);
    ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(null);
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_1
    //   10: invokestatic 142	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: new 36	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 10
    //   28: aload 10
    //   30: invokevirtual 265	java/io/File:exists	()Z
    //   33: ifeq -17 -> 16
    //   36: aload_1
    //   37: invokestatic 327	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Ljava/lang/String;)I
    //   40: istore 5
    //   42: new 269	java/io/FileInputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   50: astore 6
    //   52: aload 10
    //   54: invokestatic 665	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   57: aload_0
    //   58: iload_3
    //   59: iload 4
    //   61: invokestatic 667	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:b	(Landroid/net/Uri;Landroid/content/Context;II)Landroid/graphics/BitmapFactory$Options;
    //   64: astore_0
    //   65: new 36	java/io/File
    //   68: dup
    //   69: aload_2
    //   70: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore_1
    //   74: getstatic 596	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   77: invokevirtual 265	java/io/File:exists	()Z
    //   80: ifne +10 -> 90
    //   83: getstatic 596	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   86: invokevirtual 670	java/io/File:mkdirs	()Z
    //   89: pop
    //   90: aload_1
    //   91: invokevirtual 265	java/io/File:exists	()Z
    //   94: ifne +8 -> 102
    //   97: aload_1
    //   98: invokevirtual 673	java/io/File:createNewFile	()Z
    //   101: pop
    //   102: new 675	java/io/FileOutputStream
    //   105: dup
    //   106: aload_1
    //   107: invokespecial 678	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   110: astore_1
    //   111: aload_0
    //   112: getfield 190	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   115: iconst_1
    //   116: if_icmpgt +13 -> 129
    //   119: aload_0
    //   120: getfield 343	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   123: invokestatic 346	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Ljava/lang/String;)Z
    //   126: ifne +113 -> 239
    //   129: aload_0
    //   130: getstatic 352	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   133: putfield 355	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   136: aload_0
    //   137: iconst_1
    //   138: putfield 358	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   141: aload_0
    //   142: iconst_1
    //   143: putfield 361	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   146: aload 6
    //   148: aconst_null
    //   149: aload_0
    //   150: invokestatic 119	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   153: astore_0
    //   154: aload_0
    //   155: astore_2
    //   156: iload 5
    //   158: ifeq +10 -> 168
    //   161: aload_0
    //   162: iload 5
    //   164: invokestatic 370	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +47 -> 216
    //   172: aload_2
    //   173: getstatic 373	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   176: bipush 60
    //   178: aload_1
    //   179: invokevirtual 308	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   182: pop
    //   183: aload_2
    //   184: invokevirtual 172	android/graphics/Bitmap:recycle	()V
    //   187: aload_1
    //   188: invokevirtual 681	java/io/OutputStream:close	()V
    //   191: aload 6
    //   193: invokevirtual 124	java/io/InputStream:close	()V
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 681	java/io/OutputStream:close	()V
    //   204: aload 6
    //   206: ifnull +8 -> 214
    //   209: aload 6
    //   211: invokevirtual 124	java/io/InputStream:close	()V
    //   214: iconst_1
    //   215: ireturn
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 681	java/io/OutputStream:close	()V
    //   224: aload 6
    //   226: ifnull -210 -> 16
    //   229: aload 6
    //   231: invokevirtual 124	java/io/InputStream:close	()V
    //   234: iconst_0
    //   235: ireturn
    //   236: astore_0
    //   237: iconst_0
    //   238: ireturn
    //   239: sipush 1024
    //   242: newarray byte
    //   244: astore_0
    //   245: aload 6
    //   247: aload_0
    //   248: invokevirtual 379	java/io/InputStream:read	([B)I
    //   251: istore_3
    //   252: iload_3
    //   253: iconst_m1
    //   254: if_icmpeq -67 -> 187
    //   257: aload_1
    //   258: aload_0
    //   259: iconst_0
    //   260: iload_3
    //   261: invokevirtual 682	java/io/OutputStream:write	([BII)V
    //   264: goto -19 -> 245
    //   267: astore_2
    //   268: aload_1
    //   269: astore_0
    //   270: aload_2
    //   271: astore_1
    //   272: aload_1
    //   273: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   276: aload_0
    //   277: ifnull +7 -> 284
    //   280: aload_0
    //   281: invokevirtual 681	java/io/OutputStream:close	()V
    //   284: aload 6
    //   286: ifnull -270 -> 16
    //   289: aload 6
    //   291: invokevirtual 124	java/io/InputStream:close	()V
    //   294: iconst_0
    //   295: ireturn
    //   296: astore_0
    //   297: iconst_0
    //   298: ireturn
    //   299: astore_0
    //   300: aconst_null
    //   301: astore_1
    //   302: aload_1
    //   303: ifnull +7 -> 310
    //   306: aload_1
    //   307: invokevirtual 681	java/io/OutputStream:close	()V
    //   310: aload_0
    //   311: athrow
    //   312: astore_1
    //   313: aload 6
    //   315: astore_0
    //   316: aload_1
    //   317: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   320: aload_0
    //   321: ifnull -305 -> 16
    //   324: aload_0
    //   325: invokevirtual 124	java/io/InputStream:close	()V
    //   328: iconst_0
    //   329: ireturn
    //   330: astore_0
    //   331: iconst_0
    //   332: ireturn
    //   333: astore_0
    //   334: aconst_null
    //   335: astore_1
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 124	java/io/InputStream:close	()V
    //   344: aload_0
    //   345: athrow
    //   346: astore_0
    //   347: aload 7
    //   349: astore_0
    //   350: goto -196 -> 154
    //   353: astore_0
    //   354: goto -130 -> 224
    //   357: astore_0
    //   358: goto -154 -> 204
    //   361: astore_0
    //   362: goto -148 -> 214
    //   365: astore_0
    //   366: goto -82 -> 284
    //   369: astore_1
    //   370: goto -60 -> 310
    //   373: astore_1
    //   374: goto -30 -> 344
    //   377: astore_0
    //   378: aload 6
    //   380: astore_1
    //   381: goto -45 -> 336
    //   384: astore_2
    //   385: aload_0
    //   386: astore_1
    //   387: aload_2
    //   388: astore_0
    //   389: goto -53 -> 336
    //   392: astore_1
    //   393: aload 9
    //   395: astore_0
    //   396: goto -80 -> 316
    //   399: astore_0
    //   400: goto -98 -> 302
    //   403: astore_2
    //   404: aload_0
    //   405: astore_1
    //   406: aload_2
    //   407: astore_0
    //   408: goto -106 -> 302
    //   411: astore_1
    //   412: aload 8
    //   414: astore_0
    //   415: goto -143 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramContext	Context
    //   0	418	1	paramString1	String
    //   0	418	2	paramString2	String
    //   0	418	3	paramInt1	int
    //   0	418	4	paramInt2	int
    //   40	123	5	i	int
    //   50	329	6	localFileInputStream	FileInputStream
    //   7	341	7	localObject1	Object
    //   1	412	8	localObject2	Object
    //   4	390	9	localObject3	Object
    //   26	27	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   229	234	236	java/io/IOException
    //   111	129	267	java/lang/Exception
    //   129	146	267	java/lang/Exception
    //   146	154	267	java/lang/Exception
    //   161	168	267	java/lang/Exception
    //   172	187	267	java/lang/Exception
    //   187	196	267	java/lang/Exception
    //   239	245	267	java/lang/Exception
    //   245	252	267	java/lang/Exception
    //   257	264	267	java/lang/Exception
    //   289	294	296	java/io/IOException
    //   74	90	299	finally
    //   90	102	299	finally
    //   102	111	299	finally
    //   52	74	312	java/lang/Exception
    //   200	204	312	java/lang/Exception
    //   220	224	312	java/lang/Exception
    //   280	284	312	java/lang/Exception
    //   306	310	312	java/lang/Exception
    //   310	312	312	java/lang/Exception
    //   324	328	330	java/io/IOException
    //   42	52	333	finally
    //   146	154	346	java/lang/OutOfMemoryError
    //   220	224	353	java/io/IOException
    //   200	204	357	java/io/IOException
    //   209	214	361	java/io/IOException
    //   280	284	365	java/io/IOException
    //   306	310	369	java/io/IOException
    //   340	344	373	java/io/IOException
    //   52	74	377	finally
    //   200	204	377	finally
    //   220	224	377	finally
    //   280	284	377	finally
    //   306	310	377	finally
    //   310	312	377	finally
    //   316	320	384	finally
    //   42	52	392	java/lang/Exception
    //   111	129	399	finally
    //   129	146	399	finally
    //   146	154	399	finally
    //   161	168	399	finally
    //   172	187	399	finally
    //   187	196	399	finally
    //   239	245	399	finally
    //   245	252	399	finally
    //   257	264	399	finally
    //   272	276	403	finally
    //   74	90	411	java/lang/Exception
    //   90	102	411	java/lang/Exception
    //   102	111	411	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.equalsIgnoreCase("image/jpeg")) && (!paramString.equalsIgnoreCase("image/png")))
      {
        bool1 = bool2;
        if (!paramString.equalsIgnoreCase("image/gif")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static float[] a(String paramString)
  {
    if (JpegExifReader.isCrashJpeg(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new ExifInterface(paramString);
        float[] arrayOfFloat = new float[2];
        boolean bool = paramString.getLatLong(arrayOfFloat);
        if (bool) {
          return arrayOfFloat;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public static int[] a()
  {
    int[] arrayOfInt = new int[2];
    int i = QzoneConfig.getInstance().getConfig("MiniVideo", "MinCpu", 1150);
    long l1 = DeviceInfoUtil.a();
    long l2 = QzoneConfig.getInstance().getConfig("MiniVideo", "MinRam", 700);
    long l3 = DeviceInfoUtil.e() / 1048576L;
    long l4 = QzoneConfig.getInstance().getConfig("MiniVideo", "MinRuntimeRam", 150);
    long l5 = DeviceInfoUtil.f() / 1048576L;
    if (QLog.isColorLevel()) {
      QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin freeSizeMB " + l5);
    }
    if ((Long.valueOf(l1).longValue() >= i) && (l3 >= l2) && (l5 >= l4))
    {
      arrayOfInt[0] = 1600;
      arrayOfInt[1] = 1600;
      return arrayOfInt;
    }
    arrayOfInt[0] = 640;
    arrayOfInt[1] = 640;
    return arrayOfInt;
  }
  
  public static double b(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      paramInputStream.close();
      i = localOptions.outWidth;
      j = localOptions.outHeight;
      if (i < j) {
        if ((j <= paramInt1) && (i <= paramInt2))
        {
          d3 = 0.0D;
          return d3;
        }
      }
    }
    catch (IOException paramInputStream)
    {
      double d3;
      for (;;)
      {
        paramInputStream.printStackTrace();
      }
      double d1;
      if (j > i) {
        d1 = j / paramInt1;
      }
      for (double d2 = i / paramInt2;; d2 = j / paramInt2)
      {
        d3 = d1;
        if (d1 > d2) {
          break;
        }
        return d2;
        d1 = i / paramInt1;
      }
    }
    catch (OutOfMemoryError paramInputStream)
    {
      for (;;)
      {
        continue;
        int k = i;
        int i = j;
        int j = k;
      }
    }
  }
  
  public static BitmapFactory.Options b(Uri paramUri, Context paramContext, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    InputStream localInputStream = paramContext.getContentResolver().openInputStream(paramUri);
    double d1 = b(localInputStream, paramInt1, paramInt2);
    paramInt2 = (int)d1;
    paramInt1 = paramInt2;
    if (d1 > paramInt2) {
      paramInt1 = paramInt2 + 1;
    }
    localOptions.inSampleSize = paramInt1;
    localOptions.inJustDecodeBounds = true;
    localInputStream.close();
    paramUri = paramContext.getContentResolver().openInputStream(paramUri);
    try
    {
      BitmapFactory.decodeStream(paramUri, null, localOptions);
      label80:
      paramUri.close();
      localOptions.inJustDecodeBounds = false;
      return localOptions;
    }
    catch (OutOfMemoryError paramContext)
    {
      break label80;
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      QZLog.d("dynamic.Album", 2, "requestPlayMusic start:" + paramString + ";isChating:" + this.jdField_e_of_type_Boolean);
      Object localObject = new JSONObject();
      if (this.jdField_e_of_type_Boolean)
      {
        ((JSONObject)localObject).put("isCanPlayMusic", "false");
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      ((JSONObject)localObject).put("isCanPlayMusic", "true");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      localObject = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
      if (localObject != null)
      {
        ((AudioManager)localObject).requestAudioFocus(null, 3, 1);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QZLog.e("dynamic.Album", 2, new Object[] { "requestPlayMusic get jsonException, cmd:" + paramString });
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      QZLog.d("dynamic.Album", 2, "requestPlayMusic get an Exception, cmd:" + paramString);
      localException.printStackTrace();
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).optJSONArray("photoList");
      ((JSONObject)localObject1).getString("callback");
      localObject1 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject2 = paramString.get(i);
        if ((localObject2 != null) && ((localObject2 instanceof String)))
        {
          localObject2 = (String)localObject2;
          ((ArrayList)localObject1).add(localObject2);
          if (((String)localObject2).startsWith("http://www.dynamicalbumlocalimage.com")) {
            localArrayList.add(((String)localObject2).replace("http://www.dynamicalbumlocalimage.com", ""));
          }
        }
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void d()
  {
    RemoteHandleManager.a().a().a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private void d(String paramString)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        JSONArray localJSONArray = paramString.optJSONArray("photoList");
        Object localObject1 = paramString.optJSONObject("data");
        String str1 = paramString.getString("callback");
        localJSONObject = new JSONObject();
        ArrayList localArrayList = new ArrayList();
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          i = 0;
          paramString = null;
          if (i < localJSONArray.length())
          {
            localObject2 = localJSONArray.getJSONObject(i);
            localObject3 = ((JSONObject)localObject2).getString("photoUrl");
            if (localObject3 == null) {
              break label740;
            }
            paramString = ((JSONObject)localObject2).getString("albumId");
            str2 = ((JSONObject)localObject2).getString("photoId");
            if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localObject3)))
            {
              int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject3);
              paramString = new DynamicPhotoData((String)localObject3, ((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getString("desc"), (String)this.jdField_b_of_type_JavaUtilList.get(j), (String)this.jdField_c_of_type_JavaUtilList.get(j));
              if (paramString == null) {
                break label743;
              }
              localArrayList.add(paramString);
              break label743;
            }
            if ((paramString != null) && (str2 != null))
            {
              paramString = new DynamicPhotoData((String)localObject3, ((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getString("desc"), paramString, str2);
              continue;
            }
            paramString = new DynamicPhotoData((String)localObject3, ((JSONObject)localObject2).getString("title"), ((JSONObject)localObject2).getString("desc"));
            continue;
          }
        }
        paramString = ((JSONObject)localObject1).getString("mgz_name");
        Object localObject3 = ((JSONObject)localObject1).getString("mgz_desc");
        String str2 = ((JSONObject)localObject1).getString("tmplt_id");
        String str3 = ((JSONObject)localObject1).getString("music_id");
        String str4 = ((JSONObject)localObject1).getString("lrc_id");
        String str5 = ((JSONObject)localObject1).getString("climax_start");
        String str6 = ((JSONObject)localObject1).getString("climax_endure");
        i = ((JSONObject)localObject1).getInt("isDraft");
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putParcelableArrayList("DYNAMIC_ALBUM_PHOTOLIST", localArrayList);
        ((Bundle)localObject2).putString("mgz_name", paramString);
        ((Bundle)localObject2).putString("mgz_desc", (String)localObject3);
        ((Bundle)localObject2).putString("tmplt_id", str2);
        ((Bundle)localObject2).putString("music_id", str3);
        ((Bundle)localObject2).putString("lrc_id", str4);
        ((Bundle)localObject2).putString("climax_start", str5);
        ((Bundle)localObject2).putString("climax_endure", str6);
        ((Bundle)localObject2).putBoolean("EDIT_IMAGE", false);
        ((Bundle)localObject2).putBoolean("APPEND_IMAGE", false);
        ((Bundle)localObject2).putBoolean("SHOW_RECNET_IMAGE", false);
        ((Bundle)localObject2).putString("SHARE_SOURCE", "动感影集");
        if (i == 1)
        {
          ((Bundle)localObject2).putBoolean("dynamic_album_is_from_draft", true);
          localObject3 = QZoneHelper.UserInfo.a();
          ((QZoneHelper.UserInfo)localObject3).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount();
          localObject1 = "";
          paramString = (String)localObject1;
          if (localJSONArray != null)
          {
            paramString = (String)localObject1;
            if (localJSONArray.length() > 0) {
              paramString = localJSONArray.getJSONObject(0).getString("photoUrl");
            }
          }
          if ((localArrayList.size() > 0) && (!TextUtils.isEmpty(paramString)))
          {
            localObject1 = paramString;
            if (paramString.startsWith("http://www.dynamicalbumlocalimage.com")) {
              localObject1 = paramString.replace("http://www.dynamicalbumlocalimage.com", "");
            }
            QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), (Bundle)localObject2, (QZoneHelper.UserInfo)localObject3, (String)localObject1, "动感影集", null, this.jdField_a_of_type_Int);
            QLog.d("QzoneDynamicAlbumPlugin", 4, "entryWriteMoodAsync SUCCESS!");
            localJSONObject.put("code", 0);
            localJSONObject.put("msg", "success");
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str1, new String[] { localJSONObject.toString() });
          }
        }
        else
        {
          ((Bundle)localObject2).putBoolean("dynamic_album_is_from_draft", false);
          continue;
        }
        QLog.d("QzoneDynamicAlbumPlugin", 4, "entryWriteMoodAsync FAILE");
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      localJSONObject.put("code", -1);
      localJSONObject.put("msg", "fail");
      continue;
      label740:
      continue;
      label743:
      i += 1;
    }
  }
  
  private void e(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          JSONArray localJSONArray = new JSONArray();
          int m = this.jdField_a_of_type_JavaUtilArrayList.size();
          int i = 0;
          if (i < m)
          {
            JSONObject localJSONObject = new JSONObject();
            if (i < this.jdField_b_of_type_JavaUtilList.size())
            {
              localObject1 = (String)this.jdField_b_of_type_JavaUtilList.get(i);
              if (i >= this.jdField_c_of_type_JavaUtilList.size()) {
                break label401;
              }
              localObject2 = (String)this.jdField_c_of_type_JavaUtilList.get(i);
              if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
                break label408;
              }
              str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
              if (i >= this.jdField_d_of_type_JavaUtilList.size()) {
                break label415;
              }
              j = ((Integer)this.jdField_d_of_type_JavaUtilList.get(i)).intValue();
              if (i >= this.jdField_e_of_type_JavaUtilList.size()) {
                break label420;
              }
              k = ((Integer)this.jdField_e_of_type_JavaUtilList.get(i)).intValue();
              localJSONObject.put("albumid", localObject1);
              localJSONObject.put("lloc", localObject2);
              localJSONObject.put("url", str);
              localJSONObject.put("height", Integer.valueOf(j));
              localJSONObject.put("width", Integer.valueOf(k));
              localJSONArray.put(localJSONObject);
              i += 1;
            }
          }
          else
          {
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("photoList", localJSONArray);
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("data", localObject1);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
          }
        }
        else
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("code", -1);
          ((JSONObject)localObject1).put("msg", "fail");
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      Object localObject1 = "";
      continue;
      label401:
      Object localObject2 = "";
      continue;
      label408:
      String str = "";
      continue;
      label415:
      int j = 0;
      continue;
      label420:
      int k = 0;
    }
  }
  
  private void f(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label174;
        }
        localObject1 = new JSONArray();
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).put(new JSONObject((String)((Iterator)localObject2).next()));
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("photoList", localObject1);
    ((JSONObject)localObject2).put("totalNumPreSelected", this.jdField_a_of_type_JavaUtilList.size());
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", 0);
    ((JSONObject)localObject1).put("msg", "success");
    ((JSONObject)localObject1).put("data", localObject2);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
    return;
    label174:
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", -1);
    ((JSONObject)localObject1).put("msg", "fail");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
  }
  
  private void g(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).getString("callback");
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = ((JSONObject)localObject1).optJSONArray("photoList");
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).get(i);
            if ((localObject2 == null) || (!(localObject2 instanceof String))) {
              break label253;
            }
            localObject2 = (String)localObject2;
            if (!((String)localObject2).startsWith("http://www.dynamicalbumlocalimage.com")) {
              break label253;
            }
            localObject2 = ((String)localObject2).replace("http://www.dynamicalbumlocalimage.com", "");
            Object localObject3 = a((String)localObject2);
            if (localObject3 == null) {
              return;
            }
            localObject2 = a((String)localObject2, ((QzoneDynamicAlbumPlugin.Size)localObject3).jdField_a_of_type_Int, ((QzoneDynamicAlbumPlugin.Size)localObject3).b);
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("code", 0);
              ((JSONObject)localObject3).put("msg", "success");
              ((JSONObject)localObject3).put("data", localObject2);
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject3).toString() });
            }
            else
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("code", -1);
              ((JSONObject)localObject2).put("msg", "fail");
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label253:
      i += 1;
    }
  }
  
  private void h(String paramString)
  {
    try
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_JavaLangString = paramString;
      int i = new JSONObject(paramString).optInt("maxSelectNum");
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), PhotoListActivity.class);
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", i);
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", false);
      paramString.putExtra("PhotoConst.IS_FROM_DYNAMIC_ALBUM", true);
      paramString.putExtra("PhotoConst.IS_NO_PANORAMA", true);
      paramString.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Bundle)localObject).putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      ((Bundle)localObject).putInt("uintype", 0);
      paramString.putExtras((Bundle)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if (localObject != null)
      {
        ((WebViewFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramString, this.jdField_a_of_type_Byte);
        return;
      }
      ((AbsBaseWebViewActivity)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a()).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramString, this.jdField_a_of_type_Byte);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public Object a(String paramString, long paramLong)
  {
    if ((paramLong == 8L) && (paramString.startsWith("http://www.dynamicalbumlocalimage.com")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin getImageResponse " + paramString);
      }
      return a(paramString);
    }
    return super.a(paramString, paramLong);
  }
  
  public void a()
  {
    super.a();
    RemoteHandleManager.a().b(this);
    RemoteHandleManager.a().a().i();
    DeviceApiPlugin.a(false, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), false);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneDynamicAlbumPlugin", 2, "unregiser fail");
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.a(paramIntent, paramByte, paramInt);
    if (paramByte == this.jdField_a_of_type_Byte)
    {
      this.jdField_c_of_type_Boolean = false;
      if (paramInt == -1) {
        a(paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      }
    }
    else
    {
      return;
    }
    a(null, 0);
  }
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    super.a(paramWebViewPlugin);
    if (!(paramWebViewPlugin.mRuntime.a() instanceof QQBrowserActivity)) {
      return;
    }
    if (paramWebViewPlugin.mRuntime.a() != null) {}
    for (Object localObject = paramWebViewPlugin.mRuntime.a().g;; localObject = "")
    {
      jdField_c_of_type_JavaLangString = (String)localObject;
      if ((TextUtils.isEmpty(jdField_c_of_type_JavaLangString)) || (!jdField_c_of_type_JavaLangString.contains("qzone.qq.com/dynamic"))) {
        break;
      }
      if (jdField_a_of_type_JavaIoFile == null) {
        jdField_a_of_type_JavaIoFile = new File(jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.stopping");
      ((IntentFilter)localObject).addAction("com.tencent.process.starting");
      ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
      ((IntentFilter)localObject).addAction("tencent.av.v2q.StopVideoChat");
      paramWebViewPlugin.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      RemoteHandleManager.a().a(this);
      paramWebViewPlugin.mRuntime.a().getHandler(QzoneDynamicAlbumPlugin.class).post(new ancj(this));
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    int i = localAudioManager.getStreamMaxVolume(3);
    int j = localAudioManager.getStreamVolume(3);
    if (localAudioManager.getRingerMode() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (!TextUtils.isEmpty(paramString)) {
        paramString = new JSONObject();
      }
      try
      {
        paramString.put("type", paramInt);
        paramString.put("isMute", bool);
        paramString.put("maxVolume", i);
        paramString.put("currentVolume", j);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("qbrowserVolumeChange", paramString, paramString);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void a(List paramList, int paramInt)
  {
    String str;
    try
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        return;
      }
      str = new JSONObject(this.jdField_b_of_type_JavaLangString).optString("callback");
      if (TextUtils.isEmpty(str)) {
        return;
      }
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label194;
      }
      localObject = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((JSONArray)localObject).put(new JSONObject((String)paramList.next()));
      }
      paramList = new JSONObject();
    }
    catch (JSONException paramList)
    {
      paramList.printStackTrace();
      return;
    }
    paramList.put("photoList", localObject);
    paramList.put("totalNumPreSelected", paramInt);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("code", 0);
    ((JSONObject)localObject).put("msg", "success");
    ((JSONObject)localObject).put("data", paramList);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { ((JSONObject)localObject).toString() });
    return;
    label194:
    paramList = new JSONObject();
    paramList.put("code", -1);
    paramList.put("msg", "fail");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { paramList.toString() });
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("qzDynamicAlbum")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    for (paramJsBridgeListener = "" + paramJsBridgeListener.a;; paramJsBridgeListener = paramVarArgs[0])
    {
      QLog.d("QzoneDynamicAlbumPlugin", 4, "NAMESPACE = " + paramString2 + ";method = " + paramString3 + ";args = " + paramJsBridgeListener);
      if (!"deletePhotos".equals(paramString3)) {
        break;
      }
      c(paramJsBridgeListener);
      return true;
    }
    if ("saveDynamicAlbum".equals(paramString3)) {
      return true;
    }
    if ("getPhotos".equals(paramString3))
    {
      QZLog.d("dynamic.Album", 4, "handleJsRequest - getPhotos - isFromAlbum:" + this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_Boolean) {
        e(paramJsBridgeListener);
      }
      for (;;)
      {
        return true;
        f(paramJsBridgeListener);
      }
    }
    if ("getCloudPhotoUrl".equals(paramString3)) {
      e(paramJsBridgeListener);
    }
    do
    {
      for (;;)
      {
        return false;
        if ("dynamicSendSuccess".equals(paramString3))
        {
          d();
        }
        else
        {
          if (!"isDraftPhotosValid".equals(paramString3)) {
            break;
          }
          a(paramJsBridgeListener);
        }
      }
      if ("getSelectNum".equals(paramString3))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(QzoneDynamicAlbumPlugin.class).post(new ancl(this, paramJsBridgeListener));
        return true;
      }
      if ("entryWriteMoodAsync".equals(paramString3))
      {
        d(paramJsBridgeListener);
        return true;
      }
      if ("toBase64".equals(paramString3))
      {
        g(paramJsBridgeListener);
        return true;
      }
      if ("openImagePicker".equals(paramString3))
      {
        h(paramJsBridgeListener);
        return true;
      }
      if ("cancel".equals(paramString3))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(QzoneDynamicAlbumPlugin.class).post(new ancm(this));
        return true;
      }
      if ("requestPlayMusic".equals(paramString3))
      {
        b(paramJsBridgeListener);
        return true;
      }
      if ("startPlay".equals(paramString3))
      {
        a(true);
        return true;
      }
    } while (!"endPlay".equals(paramString3));
    a(false);
    return true;
  }
  
  public boolean a(String paramString, long paramLong, Map paramMap)
  {
    int i;
    Object localObject;
    int j;
    if ((paramLong == 8589934600L) && ((Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.jdField_a_of_type_Byte) || (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.jdField_a_of_type_Int)))
    {
      i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      localObject = (Intent)paramMap.get("data");
      j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if (i != this.jdField_a_of_type_Byte) {
        break label179;
      }
      if (j != -1) {
        break label170;
      }
      a(((Intent)localObject).getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("qzone.qq.com/dynamic")))
      {
        return super.a(paramString, paramLong, paramMap);
        label170:
        a(null, 0);
        continue;
        label179:
        if ((i != this.jdField_a_of_type_Int) || (j != -1)) {
          continue;
        }
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("isPublishDynamicMood", true);
          JSONObject localJSONObject = new JSONObject();
          JSONArray localJSONArray = new JSONArray();
          localJSONArray.put("*.qzone.qq.com");
          localJSONObject.put("echo", false);
          localJSONObject.put("broadcast", true);
          localJSONObject.put("domains", localJSONArray);
          a("publishDynamicMood", (JSONObject)localObject, localJSONObject);
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() != null)) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    if (paramString.contains("qzone.qq.com/dynamic/album/coverList")) {
      RemoteHandleManager.a().a().l();
    }
    if (paramLong == 2L)
    {
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        a(null, 0);
      }
    }
    for (;;)
    {
      return super.a(paramString, paramLong, paramMap);
      if (paramLong == 8589934597L) {
        this.jdField_d_of_type_Boolean = false;
      } else if (paramLong == 8589934608L) {
        a("qbrowserVolumeChange", 2);
      } else if (paramLong == 8589934609L) {
        a("qbrowserVolumeChange", 1);
      } else if (paramLong == 8589934601L) {
        RemoteHandleManager.a().a().j();
      }
    }
  }
  
  public void b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("com.tencent.qq.qzone.playInterruptBegin", localJSONObject1, localJSONObject2);
  }
  
  public void c()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("com.tencent.qq.qzone.playWillBeInterruptEnd", localJSONObject1, localJSONObject2);
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    QZLog.d("dynamic.Album", 4, "onWebEvent: event - " + paramString);
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramString.equals("cmd.getDynamicPhoto"))
      {
        this.jdField_a_of_type_Boolean = paramBundle.getBoolean("param.DynamicIsFromAlbum", false);
        QZLog.d("dynamic.Album", 4, "onWebEvent - getBoolean - isFromAlbum:" + this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          a(paramBundle, true);
          return;
        }
        a(paramBundle.getStringArrayList("param.DynamicPhotolist"));
        return;
      }
      if (paramString.equals("cmd.getDynamicSelnum"))
      {
        a(paramBundle);
        return;
      }
    } while (!paramString.equals("cmd.getDynamicCloudPhoto"));
    a(paramBundle, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin
 * JD-Core Version:    0.7.0.1
 */