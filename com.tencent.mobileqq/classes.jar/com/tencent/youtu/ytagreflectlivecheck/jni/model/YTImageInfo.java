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
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 64	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 71	java/io/File:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_1
    //   23: invokevirtual 74	java/io/File:delete	()Z
    //   26: pop
    //   27: aload_1
    //   28: invokevirtual 77	java/io/File:createNewFile	()Z
    //   31: pop
    //   32: new 79	java/io/FileOutputStream
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 82	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   40: astore_3
    //   41: new 84	java/io/BufferedOutputStream
    //   44: dup
    //   45: aload_3
    //   46: invokespecial 87	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: astore_1
    //   50: aload_1
    //   51: aload_2
    //   52: invokevirtual 90	java/io/BufferedOutputStream:write	([B)V
    //   55: aload_1
    //   56: invokevirtual 93	java/io/BufferedOutputStream:flush	()V
    //   59: aload_3
    //   60: ifnull +7 -> 67
    //   63: aload_3
    //   64: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 97	java/io/BufferedOutputStream:close	()V
    //   75: return
    //   76: astore_2
    //   77: aload_2
    //   78: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   81: goto -14 -> 67
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   89: return
    //   90: astore_3
    //   91: aconst_null
    //   92: astore_1
    //   93: aload 4
    //   95: astore_2
    //   96: aload_3
    //   97: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   108: aload_2
    //   109: ifnull -34 -> 75
    //   112: aload_2
    //   113: invokevirtual 97	java/io/BufferedOutputStream:close	()V
    //   116: return
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   122: return
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   128: goto -20 -> 108
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_3
    //   134: aload 5
    //   136: astore_2
    //   137: aload_3
    //   138: ifnull +7 -> 145
    //   141: aload_3
    //   142: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   145: aload_2
    //   146: ifnull +7 -> 153
    //   149: aload_2
    //   150: invokevirtual 97	java/io/BufferedOutputStream:close	()V
    //   153: aload_1
    //   154: athrow
    //   155: astore_3
    //   156: aload_3
    //   157: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   160: goto -15 -> 145
    //   163: astore_2
    //   164: aload_2
    //   165: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   168: goto -15 -> 153
    //   171: astore_1
    //   172: aload 5
    //   174: astore_2
    //   175: goto -38 -> 137
    //   178: astore 4
    //   180: aload_1
    //   181: astore_2
    //   182: aload 4
    //   184: astore_1
    //   185: goto -48 -> 137
    //   188: astore 4
    //   190: aload_1
    //   191: astore_3
    //   192: aload 4
    //   194: astore_1
    //   195: goto -58 -> 137
    //   198: astore_2
    //   199: aload_3
    //   200: astore_1
    //   201: aload_2
    //   202: astore_3
    //   203: aload 4
    //   205: astore_2
    //   206: goto -110 -> 96
    //   209: astore_2
    //   210: aload_3
    //   211: astore 4
    //   213: aload_2
    //   214: astore_3
    //   215: aload_1
    //   216: astore_2
    //   217: aload 4
    //   219: astore_1
    //   220: goto -124 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	YTImageInfo
    //   0	223	1	paramString	String
    //   0	223	2	paramArrayOfByte	byte[]
    //   40	24	3	localFileOutputStream	java.io.FileOutputStream
    //   90	7	3	localException	java.lang.Exception
    //   133	9	3	localObject1	Object
    //   155	2	3	localIOException	java.io.IOException
    //   191	24	3	localObject2	Object
    //   4	90	4	localObject3	Object
    //   178	5	4	localObject4	Object
    //   188	16	4	localObject5	Object
    //   211	7	4	localObject6	Object
    //   1	172	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   63	67	76	java/io/IOException
    //   71	75	84	java/lang/Exception
    //   15	27	90	java/lang/Exception
    //   27	41	90	java/lang/Exception
    //   112	116	117	java/lang/Exception
    //   104	108	123	java/io/IOException
    //   15	27	131	finally
    //   27	41	131	finally
    //   141	145	155	java/io/IOException
    //   149	153	163	java/lang/Exception
    //   41	50	171	finally
    //   50	59	178	finally
    //   96	100	188	finally
    //   41	50	198	java/lang/Exception
    //   50	59	209	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo
 * JD-Core Version:    0.7.0.1
 */