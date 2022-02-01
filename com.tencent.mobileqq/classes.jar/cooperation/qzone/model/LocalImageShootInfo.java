package cooperation.qzone.model;

import android.media.ExifInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalImageShootInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocalImageShootInfo> CREATOR = new LocalImageShootInfo.1();
  private static final String TAG = "LocalImageShootInfo";
  public long captureTime;
  public GpsInfo4LocalImage gpsInfo;
  public long modifyTime;
  public String path;
  
  public LocalImageShootInfo() {}
  
  public LocalImageShootInfo(Parcel paramParcel)
  {
    this.captureTime = paramParcel.readLong();
    this.modifyTime = paramParcel.readLong();
    this.path = paramParcel.readString();
    if (paramParcel.readInt() != 0) {
      this.gpsInfo = new GpsInfo4LocalImage(paramParcel);
    }
  }
  
  private LocalImageShootInfo(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("file:///")) {
        str = paramString.replaceFirst("file://", "");
      }
    }
    paramString = new File(str);
    if ((paramString.exists()) && (!paramString.isDirectory()))
    {
      this.path = paramString.getAbsolutePath();
      this.modifyTime = paramString.lastModified();
      return;
    }
    throw new Exception();
  }
  
  public static boolean appendCaptureDate(LocalImageShootInfo paramLocalImageShootInfo)
  {
    if (paramLocalImageShootInfo == null) {
      return false;
    }
    try
    {
      if (JpegExifReader.isCrashJpeg(paramLocalImageShootInfo.path))
      {
        paramLocalImageShootInfo.captureTime = new File(paramLocalImageShootInfo.path).lastModified();
        QLog.d("LocalImageShootInfo", 4, "LocalImageShootInfo#appendCaptureDate photo exif date info parse exception, now use last modified time.");
        return false;
      }
      Object localObject = new ExifInterface(paramLocalImageShootInfo.path).getAttribute("DateTime");
      if (localObject != null)
      {
        localObject = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse((String)localObject);
        if (localObject != null)
        {
          paramLocalImageShootInfo.captureTime = ((Date)localObject).getTime();
          return true;
        }
      }
      else
      {
        paramLocalImageShootInfo.captureTime = new File(paramLocalImageShootInfo.path).lastModified();
        QLog.d("LocalImageShootInfo", 4, "LocalImageShootInfo#appendCaptureDate photo exif date info parse exception, now use last modified time.");
        return false;
      }
    }
    catch (Exception localException)
    {
      paramLocalImageShootInfo.captureTime = new File(paramLocalImageShootInfo.path).lastModified();
      QLog.d("LocalImageShootInfo", 4, "LocalImageShootInfo#appendCaptureDate photo exif date info parse exception, now use last modified time.", localException);
    }
    return false;
  }
  
  public static boolean appendGpsInfo(LocalImageShootInfo paramLocalImageShootInfo)
  {
    if (paramLocalImageShootInfo == null) {
      return false;
    }
    if (paramLocalImageShootInfo.gpsInfo != null) {
      return true;
    }
    try
    {
      if (!JpegExifReader.isCrashJpeg(paramLocalImageShootInfo.path))
      {
        ExifInterface localExifInterface = new ExifInterface(paramLocalImageShootInfo.path);
        float[] arrayOfFloat = new float[2];
        if (localExifInterface.getLatLong(arrayOfFloat))
        {
          paramLocalImageShootInfo.gpsInfo = new GpsInfo4LocalImage(arrayOfFloat[0], arrayOfFloat[1]);
          return true;
        }
      }
    }
    catch (Exception paramLocalImageShootInfo)
    {
      paramLocalImageShootInfo.printStackTrace();
    }
    return false;
  }
  
  public static LocalImageShootInfo createFrom(String paramString)
  {
    String str = null;
    Object localObject = null;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      try
      {
        paramString = new LocalImageShootInfo(paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramString = localObject;
      }
      str = paramString;
      if (paramString != null)
      {
        appendCaptureDate(paramString);
        appendGpsInfo(paramString);
        str = paramString;
      }
    }
    return str;
  }
  
  /* Error */
  public static GpsInfo4LocalImage getGpsInfoForVideo(android.media.MediaMetadataRetriever paramMediaMetadataRetriever, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +334 -> 335
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 173	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   15: getstatic 179	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 15
    //   20: if_icmplt +257 -> 277
    //   23: aload_0
    //   24: bipush 23
    //   26: invokevirtual 183	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +246 -> 277
    //   34: new 185	java/util/ArrayList
    //   37: dup
    //   38: iconst_3
    //   39: invokespecial 188	java/util/ArrayList:<init>	(I)V
    //   42: astore 7
    //   44: new 190	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   51: astore 8
    //   53: aload_1
    //   54: invokevirtual 195	java/lang/String:toCharArray	()[C
    //   57: astore 9
    //   59: aload 9
    //   61: arraylength
    //   62: istore 6
    //   64: iconst_0
    //   65: istore 5
    //   67: iconst_0
    //   68: istore 4
    //   70: goto +267 -> 337
    //   73: iload_2
    //   74: invokestatic 201	java/lang/Character:isDigit	(C)Z
    //   77: ifne +61 -> 138
    //   80: iload_2
    //   81: bipush 46
    //   83: if_icmpne +6 -> 89
    //   86: goto +52 -> 138
    //   89: new 190	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   96: astore 10
    //   98: aload 10
    //   100: ldc 203
    //   102: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 10
    //   108: aload_1
    //   109: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 10
    //   115: ldc 209
    //   117: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: ldc 13
    //   123: iconst_2
    //   124: aload 10
    //   126: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: iload 4
    //   134: istore_3
    //   135: goto +246 -> 381
    //   138: aload 8
    //   140: iload_2
    //   141: invokevirtual 218	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: iload 4
    //   147: istore_3
    //   148: goto +233 -> 381
    //   151: iload 4
    //   153: istore_3
    //   154: aload 8
    //   156: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   159: ifle +31 -> 190
    //   162: aload 7
    //   164: aload 8
    //   166: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 225	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   172: invokestatic 229	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   175: invokevirtual 233	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   178: pop
    //   179: aload 8
    //   181: iconst_0
    //   182: invokevirtual 236	java/lang/StringBuilder:setLength	(I)V
    //   185: iload 4
    //   187: iconst_1
    //   188: iadd
    //   189: istore_3
    //   190: aload 8
    //   192: iload_2
    //   193: invokevirtual 218	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: goto +184 -> 381
    //   200: aload 8
    //   202: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   205: ifle +20 -> 225
    //   208: aload 7
    //   210: aload 8
    //   212: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 225	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   218: invokestatic 229	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   221: invokevirtual 233	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   224: pop
    //   225: aload 7
    //   227: invokevirtual 239	java/util/ArrayList:size	()I
    //   230: iconst_2
    //   231: if_icmplt +46 -> 277
    //   234: new 53	cooperation/qzone/model/GpsInfo4LocalImage
    //   237: dup
    //   238: aload 7
    //   240: iconst_0
    //   241: invokevirtual 243	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   244: checkcast 221	java/lang/Double
    //   247: invokevirtual 247	java/lang/Double:floatValue	()F
    //   250: aload 7
    //   252: iconst_1
    //   253: invokevirtual 243	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   256: checkcast 221	java/lang/Double
    //   259: invokevirtual 247	java/lang/Double:floatValue	()F
    //   262: invokespecial 149	cooperation/qzone/model/GpsInfo4LocalImage:<init>	(FF)V
    //   265: astore_1
    //   266: aload_0
    //   267: invokevirtual 250	android/media/MediaMetadataRetriever:release	()V
    //   270: aload_1
    //   271: areturn
    //   272: astore_1
    //   273: aload_1
    //   274: invokevirtual 251	java/lang/NumberFormatException:printStackTrace	()V
    //   277: aload_0
    //   278: invokevirtual 250	android/media/MediaMetadataRetriever:release	()V
    //   281: aconst_null
    //   282: areturn
    //   283: astore_1
    //   284: goto +45 -> 329
    //   287: astore_1
    //   288: new 190	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   295: astore 7
    //   297: aload 7
    //   299: ldc 253
    //   301: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 7
    //   307: aload_1
    //   308: invokevirtual 256	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   311: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc 13
    //   317: iconst_2
    //   318: aload 7
    //   320: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: goto -49 -> 277
    //   329: aload_0
    //   330: invokevirtual 250	android/media/MediaMetadataRetriever:release	()V
    //   333: aload_1
    //   334: athrow
    //   335: aconst_null
    //   336: areturn
    //   337: iload 5
    //   339: iload 6
    //   341: if_icmpge -141 -> 200
    //   344: aload 9
    //   346: iload 5
    //   348: caload
    //   349: istore_2
    //   350: iload 4
    //   352: iconst_2
    //   353: if_icmpge -153 -> 200
    //   356: iload_2
    //   357: bipush 43
    //   359: if_icmpeq -208 -> 151
    //   362: iload_2
    //   363: bipush 45
    //   365: if_icmpeq -214 -> 151
    //   368: iload_2
    //   369: bipush 10
    //   371: if_icmpeq -220 -> 151
    //   374: iload_2
    //   375: ifne -302 -> 73
    //   378: goto -227 -> 151
    //   381: iload 5
    //   383: iconst_1
    //   384: iadd
    //   385: istore 5
    //   387: iload_3
    //   388: istore 4
    //   390: goto -53 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	paramMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   0	393	1	paramString	String
    //   73	302	2	c	char
    //   134	254	3	i	int
    //   68	321	4	j	int
    //   65	321	5	k	int
    //   62	280	6	m	int
    //   42	277	7	localObject	Object
    //   51	160	8	localStringBuilder1	java.lang.StringBuilder
    //   57	288	9	arrayOfChar	char[]
    //   96	29	10	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   34	64	272	java/lang/NumberFormatException
    //   73	80	272	java/lang/NumberFormatException
    //   89	132	272	java/lang/NumberFormatException
    //   138	145	272	java/lang/NumberFormatException
    //   154	185	272	java/lang/NumberFormatException
    //   190	197	272	java/lang/NumberFormatException
    //   200	225	272	java/lang/NumberFormatException
    //   225	266	272	java/lang/NumberFormatException
    //   10	30	283	finally
    //   34	64	283	finally
    //   73	80	283	finally
    //   89	132	283	finally
    //   138	145	283	finally
    //   154	185	283	finally
    //   190	197	283	finally
    //   200	225	283	finally
    //   225	266	283	finally
    //   273	277	283	finally
    //   288	326	283	finally
    //   10	30	287	java/lang/Throwable
    //   34	64	287	java/lang/Throwable
    //   73	80	287	java/lang/Throwable
    //   89	132	287	java/lang/Throwable
    //   138	145	287	java/lang/Throwable
    //   154	185	287	java/lang/Throwable
    //   190	197	287	java/lang/Throwable
    //   200	225	287	java/lang/Throwable
    //   225	266	287	java/lang/Throwable
    //   273	277	287	java/lang/Throwable
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LocalImageShootInfo)) {
      return false;
    }
    paramObject = (LocalImageShootInfo)paramObject;
    boolean bool1 = bool2;
    if (this.captureTime == paramObject.captureTime)
    {
      bool1 = bool2;
      if (this.gpsInfo.equals(paramObject)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.captureTime);
    paramParcel.writeLong(this.modifyTime);
    paramParcel.writeString(this.path);
    if (this.gpsInfo != null)
    {
      paramParcel.writeInt(1);
      this.gpsInfo.writeToParcel(paramParcel, paramInt);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.LocalImageShootInfo
 * JD-Core Version:    0.7.0.1
 */