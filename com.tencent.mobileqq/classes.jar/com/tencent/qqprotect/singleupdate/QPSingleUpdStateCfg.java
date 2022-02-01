package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;

public class QPSingleUpdStateCfg
{
  String a = null;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  public int e = 3;
  public int f = 0;
  
  public QPSingleUpdStateCfg()
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((Context)localObject).getFilesDir().getAbsolutePath());
    localStringBuilder.append("/TxSingleUpd/UpdState.cfg");
    this.a = localStringBuilder.toString();
    localObject = new File(this.a);
    if (!((File)localObject).exists()) {
      try
      {
        ((File)localObject).createNewFile();
        a();
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
    }
    b();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: new 83	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 21	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:a	Ljava/lang/String;
    //   8: invokespecial 84	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: new 86	java/io/DataOutputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 89	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_3
    //   21: aload_3
    //   22: aload_0
    //   23: getfield 23	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:b	J
    //   26: invokevirtual 93	java/io/DataOutputStream:writeLong	(J)V
    //   29: aload_3
    //   30: aload_0
    //   31: getfield 25	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:c	J
    //   34: invokevirtual 93	java/io/DataOutputStream:writeLong	(J)V
    //   37: aload_3
    //   38: aload_0
    //   39: getfield 27	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:d	J
    //   42: invokevirtual 93	java/io/DataOutputStream:writeLong	(J)V
    //   45: aload_3
    //   46: aload_0
    //   47: getfield 29	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:e	I
    //   50: invokevirtual 97	java/io/DataOutputStream:writeInt	(I)V
    //   53: aload_3
    //   54: aload_0
    //   55: getfield 31	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:f	I
    //   58: invokevirtual 97	java/io/DataOutputStream:writeInt	(I)V
    //   61: aload_3
    //   62: ifnull +15 -> 77
    //   65: aload_3
    //   66: invokevirtual 100	java/io/DataOutputStream:close	()V
    //   69: goto +8 -> 77
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   77: aload_2
    //   78: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   81: return
    //   82: astore_1
    //   83: aload_2
    //   84: astore 4
    //   86: aload_3
    //   87: astore_2
    //   88: goto +30 -> 118
    //   91: aload_3
    //   92: astore_1
    //   93: goto +65 -> 158
    //   96: astore_1
    //   97: aconst_null
    //   98: astore_3
    //   99: aload_2
    //   100: astore 4
    //   102: aload_3
    //   103: astore_2
    //   104: goto +14 -> 118
    //   107: aconst_null
    //   108: astore_1
    //   109: goto +49 -> 158
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: astore 4
    //   118: aload_2
    //   119: ifnull +15 -> 134
    //   122: aload_2
    //   123: invokevirtual 100	java/io/DataOutputStream:close	()V
    //   126: goto +8 -> 134
    //   129: astore_2
    //   130: aload_2
    //   131: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   134: aload 4
    //   136: ifnull +16 -> 152
    //   139: aload 4
    //   141: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   144: goto +8 -> 152
    //   147: astore_2
    //   148: aload_2
    //   149: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   152: aload_1
    //   153: athrow
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_2
    //   157: astore_1
    //   158: aload_1
    //   159: ifnull +15 -> 174
    //   162: aload_1
    //   163: invokevirtual 100	java/io/DataOutputStream:close	()V
    //   166: goto +8 -> 174
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   174: aload_2
    //   175: ifnull +13 -> 188
    //   178: aload_2
    //   179: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   182: return
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   188: return
    //   189: astore_1
    //   190: goto -36 -> 154
    //   193: astore_1
    //   194: goto -87 -> 107
    //   197: astore_1
    //   198: goto -107 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	QPSingleUpdStateCfg
    //   72	2	1	localIOException1	IOException
    //   82	1	1	localObject1	Object
    //   92	1	1	localDataOutputStream1	java.io.DataOutputStream
    //   96	1	1	localObject2	Object
    //   108	1	1	localObject3	Object
    //   112	41	1	localObject4	Object
    //   157	6	1	localObject5	Object
    //   169	2	1	localIOException2	IOException
    //   183	2	1	localIOException3	IOException
    //   189	1	1	localException1	java.lang.Exception
    //   193	1	1	localException2	java.lang.Exception
    //   197	1	1	localException3	java.lang.Exception
    //   11	112	2	localObject6	Object
    //   129	2	2	localIOException4	IOException
    //   147	2	2	localIOException5	IOException
    //   155	24	2	localObject7	Object
    //   20	83	3	localDataOutputStream2	java.io.DataOutputStream
    //   84	56	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   65	69	72	java/io/IOException
    //   21	61	82	finally
    //   12	21	96	finally
    //   0	12	112	finally
    //   122	126	129	java/io/IOException
    //   139	144	147	java/io/IOException
    //   162	166	169	java/io/IOException
    //   77	81	183	java/io/IOException
    //   178	182	183	java/io/IOException
    //   0	12	189	java/lang/Exception
    //   12	21	193	java/lang/Exception
    //   21	61	197	java/lang/Exception
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 48	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 21	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:a	Ljava/lang/String;
    //   13: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 68	java/io/File:exists	()Z
    //   19: ifne +32 -> 51
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 23	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:b	J
    //   27: aload_0
    //   28: lconst_0
    //   29: putfield 25	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:c	J
    //   32: aload_0
    //   33: lconst_0
    //   34: putfield 27	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:d	J
    //   37: aload_0
    //   38: iconst_3
    //   39: putfield 29	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:e	I
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 31	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:f	I
    //   47: aload_0
    //   48: invokevirtual 73	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:a	()V
    //   51: new 103	java/io/FileInputStream
    //   54: dup
    //   55: aload_0
    //   56: getfield 21	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:a	Ljava/lang/String;
    //   59: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   62: astore_1
    //   63: new 106	java/io/DataInputStream
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 109	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore_2
    //   72: aload_0
    //   73: aload_2
    //   74: invokevirtual 113	java/io/DataInputStream:readLong	()J
    //   77: putfield 23	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:b	J
    //   80: aload_0
    //   81: aload_2
    //   82: invokevirtual 113	java/io/DataInputStream:readLong	()J
    //   85: putfield 25	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:c	J
    //   88: aload_0
    //   89: aload_2
    //   90: invokevirtual 113	java/io/DataInputStream:readLong	()J
    //   93: putfield 27	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:d	J
    //   96: aload_0
    //   97: aload_2
    //   98: invokevirtual 117	java/io/DataInputStream:readInt	()I
    //   101: putfield 29	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:e	I
    //   104: aload_0
    //   105: aload_2
    //   106: invokevirtual 117	java/io/DataInputStream:readInt	()I
    //   109: putfield 31	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:f	I
    //   112: aload_2
    //   113: ifnull +15 -> 128
    //   116: aload_2
    //   117: invokevirtual 118	java/io/DataInputStream:close	()V
    //   120: goto +8 -> 128
    //   123: astore_2
    //   124: aload_2
    //   125: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   128: aload_1
    //   129: invokevirtual 119	java/io/FileInputStream:close	()V
    //   132: return
    //   133: astore 4
    //   135: aload_2
    //   136: astore_3
    //   137: aload_1
    //   138: astore_2
    //   139: aload 4
    //   141: astore_1
    //   142: goto +25 -> 167
    //   145: goto +61 -> 206
    //   148: astore 4
    //   150: aload_1
    //   151: astore_2
    //   152: aload 4
    //   154: astore_1
    //   155: goto +12 -> 167
    //   158: aload 4
    //   160: astore_2
    //   161: goto +45 -> 206
    //   164: astore_1
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_3
    //   168: ifnull +15 -> 183
    //   171: aload_3
    //   172: invokevirtual 118	java/io/DataInputStream:close	()V
    //   175: goto +8 -> 183
    //   178: astore_3
    //   179: aload_3
    //   180: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   183: aload_2
    //   184: ifnull +15 -> 199
    //   187: aload_2
    //   188: invokevirtual 119	java/io/FileInputStream:close	()V
    //   191: goto +8 -> 199
    //   194: astore_2
    //   195: aload_2
    //   196: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   199: aload_1
    //   200: athrow
    //   201: aconst_null
    //   202: astore_1
    //   203: aload 4
    //   205: astore_2
    //   206: aload_2
    //   207: ifnull +15 -> 222
    //   210: aload_2
    //   211: invokevirtual 118	java/io/DataInputStream:close	()V
    //   214: goto +8 -> 222
    //   217: astore_2
    //   218: aload_2
    //   219: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   222: aload_1
    //   223: ifnull +13 -> 236
    //   226: aload_1
    //   227: invokevirtual 119	java/io/FileInputStream:close	()V
    //   230: return
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   236: return
    //   237: astore_1
    //   238: goto -37 -> 201
    //   241: astore_2
    //   242: goto -84 -> 158
    //   245: astore_3
    //   246: goto -101 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	QPSingleUpdStateCfg
    //   62	93	1	localObject1	Object
    //   164	36	1	localObject2	Object
    //   202	25	1	localObject3	Object
    //   231	2	1	localIOException1	IOException
    //   237	1	1	localException1	java.lang.Exception
    //   71	46	2	localDataInputStream	java.io.DataInputStream
    //   123	13	2	localIOException2	IOException
    //   138	50	2	localObject4	Object
    //   194	2	2	localIOException3	IOException
    //   205	6	2	localObject5	Object
    //   217	2	2	localIOException4	IOException
    //   241	1	2	localException2	java.lang.Exception
    //   4	168	3	localObject6	Object
    //   178	2	3	localIOException5	IOException
    //   245	1	3	localException3	java.lang.Exception
    //   1	1	4	localObject7	Object
    //   133	7	4	localObject8	Object
    //   148	56	4	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   116	120	123	java/io/IOException
    //   72	112	133	finally
    //   63	72	148	finally
    //   5	51	164	finally
    //   51	63	164	finally
    //   171	175	178	java/io/IOException
    //   187	191	194	java/io/IOException
    //   210	214	217	java/io/IOException
    //   128	132	231	java/io/IOException
    //   226	230	231	java/io/IOException
    //   5	51	237	java/lang/Exception
    //   51	63	237	java/lang/Exception
    //   63	72	241	java/lang/Exception
    //   72	112	245	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdStateCfg
 * JD-Core Version:    0.7.0.1
 */