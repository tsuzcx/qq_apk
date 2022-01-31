package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;

public class QPSingleUpdStateCfg
{
  public int a;
  public long a;
  String a;
  public int b;
  public long b;
  public long c;
  
  public QPSingleUpdStateCfg()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 3;
    Object localObject = BaseApplication.getContext();
    this.jdField_a_of_type_JavaLangString = (((Context)localObject).getFilesDir().getAbsolutePath() + "/TxSingleUpd/UpdState.cfg");
    localObject = new File(this.jdField_a_of_type_JavaLangString);
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
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 72	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 18	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: invokespecial 73	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +190 -> 207
    //   20: new 75	java/io/DataOutputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 78	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_2
    //   29: aload_2
    //   30: astore_3
    //   31: aload_2
    //   32: ifnull +45 -> 77
    //   35: aload_2
    //   36: aload_0
    //   37: getfield 80	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_a_of_type_Long	J
    //   40: invokevirtual 84	java/io/DataOutputStream:writeLong	(J)V
    //   43: aload_2
    //   44: aload_0
    //   45: getfield 86	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_b_of_type_Long	J
    //   48: invokevirtual 84	java/io/DataOutputStream:writeLong	(J)V
    //   51: aload_2
    //   52: aload_0
    //   53: getfield 88	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:c	J
    //   56: invokevirtual 84	java/io/DataOutputStream:writeLong	(J)V
    //   59: aload_2
    //   60: aload_0
    //   61: getfield 20	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_a_of_type_Int	I
    //   64: invokevirtual 92	java/io/DataOutputStream:writeInt	(I)V
    //   67: aload_2
    //   68: aload_0
    //   69: getfield 94	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_b_of_type_Int	I
    //   72: invokevirtual 92	java/io/DataOutputStream:writeInt	(I)V
    //   75: aload_2
    //   76: astore_3
    //   77: aload_3
    //   78: ifnull +7 -> 85
    //   81: aload_3
    //   82: invokevirtual 97	java/io/DataOutputStream:close	()V
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   93: return
    //   94: astore_2
    //   95: aload_2
    //   96: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   99: goto -14 -> 85
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   107: return
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_3
    //   111: aload_2
    //   112: astore_1
    //   113: aload_3
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull +7 -> 123
    //   119: aload_2
    //   120: invokevirtual 97	java/io/DataOutputStream:close	()V
    //   123: aload_1
    //   124: ifnull -31 -> 93
    //   127: aload_1
    //   128: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   131: return
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   137: return
    //   138: astore_2
    //   139: aload_2
    //   140: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   143: goto -20 -> 123
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_3
    //   150: ifnull +7 -> 157
    //   153: aload_3
    //   154: invokevirtual 97	java/io/DataOutputStream:close	()V
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   165: aload_2
    //   166: athrow
    //   167: astore_3
    //   168: aload_3
    //   169: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   172: goto -15 -> 157
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   180: goto -15 -> 165
    //   183: astore_2
    //   184: goto -35 -> 149
    //   187: astore 4
    //   189: aload_2
    //   190: astore_3
    //   191: aload 4
    //   193: astore_2
    //   194: goto -45 -> 149
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_2
    //   200: goto -85 -> 115
    //   203: astore_3
    //   204: goto -89 -> 115
    //   207: aconst_null
    //   208: astore_3
    //   209: goto -132 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	QPSingleUpdStateCfg
    //   15	75	1	localFileOutputStream	java.io.FileOutputStream
    //   102	2	1	localIOException1	IOException
    //   108	1	1	localException1	java.lang.Exception
    //   112	16	1	localIOException2	IOException
    //   132	2	1	localIOException3	IOException
    //   148	14	1	localObject1	Object
    //   175	2	1	localIOException4	IOException
    //   3	73	2	localDataOutputStream	java.io.DataOutputStream
    //   94	18	2	localIOException5	IOException
    //   114	6	2	localObject2	Object
    //   138	2	2	localIOException6	IOException
    //   146	20	2	localObject3	Object
    //   183	7	2	localObject4	Object
    //   193	1	2	localObject5	Object
    //   197	1	2	localException2	java.lang.Exception
    //   199	1	2	localObject6	Object
    //   1	153	3	localObject7	Object
    //   167	2	3	localIOException7	IOException
    //   190	1	3	localObject8	Object
    //   203	1	3	localException3	java.lang.Exception
    //   208	1	3	localObject9	Object
    //   187	5	4	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   81	85	94	java/io/IOException
    //   89	93	102	java/io/IOException
    //   4	16	108	java/lang/Exception
    //   127	131	132	java/io/IOException
    //   119	123	138	java/io/IOException
    //   4	16	146	finally
    //   153	157	167	java/io/IOException
    //   161	165	175	java/io/IOException
    //   20	29	183	finally
    //   35	75	187	finally
    //   20	29	197	java/lang/Exception
    //   35	75	203	java/lang/Exception
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 37	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 18	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 57	java/io/File:exists	()Z
    //   16: ifne +32 -> 48
    //   19: aload_0
    //   20: lconst_0
    //   21: putfield 80	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_a_of_type_Long	J
    //   24: aload_0
    //   25: lconst_0
    //   26: putfield 86	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_b_of_type_Long	J
    //   29: aload_0
    //   30: lconst_0
    //   31: putfield 88	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:c	J
    //   34: aload_0
    //   35: iconst_3
    //   36: putfield 20	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_a_of_type_Int	I
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 94	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_b_of_type_Int	I
    //   44: aload_0
    //   45: invokevirtual 62	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:a	()V
    //   48: new 100	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: getfield 18	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +184 -> 245
    //   64: new 103	java/io/DataInputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 106	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore_3
    //   73: aload_3
    //   74: astore_2
    //   75: aload_3
    //   76: ifnull +45 -> 121
    //   79: aload_0
    //   80: aload_3
    //   81: invokevirtual 110	java/io/DataInputStream:readLong	()J
    //   84: putfield 80	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_a_of_type_Long	J
    //   87: aload_0
    //   88: aload_3
    //   89: invokevirtual 110	java/io/DataInputStream:readLong	()J
    //   92: putfield 86	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_b_of_type_Long	J
    //   95: aload_0
    //   96: aload_3
    //   97: invokevirtual 110	java/io/DataInputStream:readLong	()J
    //   100: putfield 88	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:c	J
    //   103: aload_0
    //   104: aload_3
    //   105: invokevirtual 114	java/io/DataInputStream:readInt	()I
    //   108: putfield 20	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_a_of_type_Int	I
    //   111: aload_0
    //   112: aload_3
    //   113: invokevirtual 114	java/io/DataInputStream:readInt	()I
    //   116: putfield 94	com/tencent/qqprotect/singleupdate/QPSingleUpdStateCfg:jdField_b_of_type_Int	I
    //   119: aload_3
    //   120: astore_2
    //   121: aload_2
    //   122: ifnull +7 -> 129
    //   125: aload_2
    //   126: invokevirtual 115	java/io/DataInputStream:close	()V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 116	java/io/FileInputStream:close	()V
    //   137: return
    //   138: astore_2
    //   139: aload_2
    //   140: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   143: goto -14 -> 129
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   151: return
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_2
    //   156: ifnull +7 -> 163
    //   159: aload_2
    //   160: invokevirtual 115	java/io/DataInputStream:close	()V
    //   163: aload_1
    //   164: ifnull -27 -> 137
    //   167: aload_1
    //   168: invokevirtual 116	java/io/FileInputStream:close	()V
    //   171: return
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   177: return
    //   178: astore_2
    //   179: aload_2
    //   180: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   183: goto -20 -> 163
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_1
    //   189: aconst_null
    //   190: astore_3
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 115	java/io/DataInputStream:close	()V
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 116	java/io/FileInputStream:close	()V
    //   207: aload_2
    //   208: athrow
    //   209: astore_3
    //   210: aload_3
    //   211: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   214: goto -15 -> 199
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   222: goto -15 -> 207
    //   225: astore_2
    //   226: aconst_null
    //   227: astore_3
    //   228: goto -37 -> 191
    //   231: astore_2
    //   232: goto -41 -> 191
    //   235: astore_3
    //   236: goto -81 -> 155
    //   239: astore_2
    //   240: aload_3
    //   241: astore_2
    //   242: goto -87 -> 155
    //   245: aconst_null
    //   246: astore_2
    //   247: goto -126 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	QPSingleUpdStateCfg
    //   59	75	1	localFileInputStream	java.io.FileInputStream
    //   146	2	1	localIOException1	IOException
    //   152	1	1	localException1	java.lang.Exception
    //   154	14	1	localObject1	Object
    //   172	2	1	localIOException2	IOException
    //   188	16	1	localObject2	Object
    //   217	2	1	localIOException3	IOException
    //   1	125	2	localObject3	Object
    //   138	22	2	localIOException4	IOException
    //   178	2	2	localIOException5	IOException
    //   186	22	2	localObject4	Object
    //   225	1	2	localObject5	Object
    //   231	1	2	localObject6	Object
    //   239	1	2	localException2	java.lang.Exception
    //   241	6	2	localObject7	Object
    //   72	124	3	localDataInputStream	java.io.DataInputStream
    //   209	2	3	localIOException6	IOException
    //   227	1	3	localObject8	Object
    //   235	6	3	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   125	129	138	java/io/IOException
    //   133	137	146	java/io/IOException
    //   2	48	152	java/lang/Exception
    //   48	60	152	java/lang/Exception
    //   167	171	172	java/io/IOException
    //   159	163	178	java/io/IOException
    //   2	48	186	finally
    //   48	60	186	finally
    //   195	199	209	java/io/IOException
    //   203	207	217	java/io/IOException
    //   64	73	225	finally
    //   79	119	231	finally
    //   64	73	235	java/lang/Exception
    //   79	119	239	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdStateCfg
 * JD-Core Version:    0.7.0.1
 */