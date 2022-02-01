package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import android.util.Base64;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectImage;
import java.util.ArrayList;

public class YTImageInfo
{
  public String checksum;
  public ArrayList<Float> five_points;
  public String image;
  
  public YTImageInfo(YTActReflectImage paramYTActReflectImage)
  {
    this.image = new String(Base64.encode(paramYTActReflectImage.image, 2));
    this.checksum = paramYTActReflectImage.checksum;
    this.five_points = new ArrayList();
    if (paramYTActReflectImage.xys != null)
    {
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys['°']));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys['±']));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys['²']));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys['³']));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys[64]));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys[65]));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys[90]));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys[91]));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys[102]));
      this.five_points.add(Float.valueOf(paramYTActReflectImage.xys[103]));
    }
  }
  
  /* Error */
  private void createFileWithByte(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 64	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_3
    //   15: invokevirtual 71	java/io/File:exists	()Z
    //   18: ifeq +8 -> 26
    //   21: aload_3
    //   22: invokevirtual 74	java/io/File:delete	()Z
    //   25: pop
    //   26: aload_3
    //   27: invokevirtual 77	java/io/File:createNewFile	()Z
    //   30: pop
    //   31: new 79	java/io/FileOutputStream
    //   34: dup
    //   35: aload_3
    //   36: invokespecial 82	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore_3
    //   40: new 84	java/io/BufferedOutputStream
    //   43: dup
    //   44: aload_3
    //   45: invokespecial 87	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   48: astore_1
    //   49: aload_1
    //   50: aload_2
    //   51: invokevirtual 90	java/io/BufferedOutputStream:write	([B)V
    //   54: aload_1
    //   55: invokevirtual 93	java/io/BufferedOutputStream:flush	()V
    //   58: aload_3
    //   59: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   62: goto +8 -> 70
    //   65: astore_2
    //   66: aload_2
    //   67: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   70: aload_1
    //   71: invokevirtual 100	java/io/BufferedOutputStream:close	()V
    //   74: return
    //   75: astore_2
    //   76: goto +10 -> 86
    //   79: astore_2
    //   80: goto +12 -> 92
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_1
    //   86: goto +63 -> 149
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_1
    //   92: goto +21 -> 113
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: aload 4
    //   100: astore_3
    //   101: goto +48 -> 149
    //   104: astore_2
    //   105: aconst_null
    //   106: astore 4
    //   108: aload_1
    //   109: astore_3
    //   110: aload 4
    //   112: astore_1
    //   113: aload_2
    //   114: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   117: aload_3
    //   118: ifnull +15 -> 133
    //   121: aload_3
    //   122: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   125: goto +8 -> 133
    //   128: astore_2
    //   129: aload_2
    //   130: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   133: aload_1
    //   134: ifnull +13 -> 147
    //   137: aload_1
    //   138: invokevirtual 100	java/io/BufferedOutputStream:close	()V
    //   141: return
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   147: return
    //   148: astore_2
    //   149: aload_3
    //   150: ifnull +15 -> 165
    //   153: aload_3
    //   154: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   157: goto +8 -> 165
    //   160: astore_3
    //   161: aload_3
    //   162: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   165: aload_1
    //   166: ifnull +15 -> 181
    //   169: aload_1
    //   170: invokevirtual 100	java/io/BufferedOutputStream:close	()V
    //   173: goto +8 -> 181
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   181: aload_2
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	YTImageInfo
    //   0	183	1	paramString	String
    //   0	183	2	paramArrayOfByte	byte[]
    //   8	146	3	localObject1	Object
    //   160	2	3	localIOException	java.io.IOException
    //   10	101	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   58	62	65	java/io/IOException
    //   49	58	75	finally
    //   49	58	79	java/lang/Exception
    //   40	49	83	finally
    //   40	49	89	java/lang/Exception
    //   14	26	95	finally
    //   26	40	95	finally
    //   14	26	104	java/lang/Exception
    //   26	40	104	java/lang/Exception
    //   121	125	128	java/io/IOException
    //   70	74	142	java/lang/Exception
    //   137	141	142	java/lang/Exception
    //   113	117	148	finally
    //   153	157	160	java/io/IOException
    //   169	173	176	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo
 * JD-Core Version:    0.7.0.1
 */