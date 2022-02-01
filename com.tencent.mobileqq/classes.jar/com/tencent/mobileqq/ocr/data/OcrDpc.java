package com.tencent.mobileqq.ocr.data;

import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class OcrDpc
{
  public static DPCObserver a;
  public static OcrDpc a;
  private static final String b;
  public int a;
  public String a;
  public int b;
  public int c = 800;
  public int d = 1080;
  public int e = 1920;
  public int f = 100;
  public int g = 6;
  public int h = 140;
  public int i = 100;
  
  static
  {
    jdField_b_of_type_JavaLangString = DPCNames.ocrCfg.name();
    jdField_a_of_type_ComTencentMobileqqDpcDPCObserver = new OcrDpc.1();
  }
  
  public OcrDpc()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 70;
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(jdField_a_of_type_ComTencentMobileqqDpcDPCObserver);
  }
  
  public static OcrDpc a()
  {
    if (jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc != null) {
      return jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.dpc", 2, "get ocrDpc is null");
    }
    a();
    return jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 60
    //   5: invokestatic 66	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   8: checkcast 60	com/tencent/mobileqq/dpc/api/IDPCApi
    //   11: getstatic 31	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   14: invokeinterface 94 2 0
    //   19: astore_1
    //   20: new 2	com/tencent/mobileqq/ocr/data/OcrDpc
    //   23: dup
    //   24: invokespecial 95	com/tencent/mobileqq/ocr/data/OcrDpc:<init>	()V
    //   27: putstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   30: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   33: aload_1
    //   34: putfield 97	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: aload_1
    //   38: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifne +157 -> 198
    //   44: aload_1
    //   45: ldc 105
    //   47: invokevirtual 111	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: arraylength
    //   53: istore_0
    //   54: iload_0
    //   55: bipush 9
    //   57: if_icmplt +141 -> 198
    //   60: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   63: aload_1
    //   64: iconst_0
    //   65: aaload
    //   66: invokestatic 117	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   69: invokevirtual 121	java/lang/Integer:intValue	()I
    //   72: putfield 42	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_Int	I
    //   75: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   78: aload_1
    //   79: iconst_1
    //   80: aaload
    //   81: invokestatic 117	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   84: invokevirtual 121	java/lang/Integer:intValue	()I
    //   87: putfield 44	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_b_of_type_Int	I
    //   90: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   93: aload_1
    //   94: iconst_2
    //   95: aaload
    //   96: invokestatic 117	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   99: invokevirtual 121	java/lang/Integer:intValue	()I
    //   102: putfield 46	com/tencent/mobileqq/ocr/data/OcrDpc:c	I
    //   105: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   108: aload_1
    //   109: iconst_3
    //   110: aaload
    //   111: invokestatic 117	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   114: invokevirtual 121	java/lang/Integer:intValue	()I
    //   117: putfield 48	com/tencent/mobileqq/ocr/data/OcrDpc:d	I
    //   120: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   123: aload_1
    //   124: iconst_4
    //   125: aaload
    //   126: invokestatic 117	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   129: invokevirtual 121	java/lang/Integer:intValue	()I
    //   132: putfield 50	com/tencent/mobileqq/ocr/data/OcrDpc:e	I
    //   135: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   138: aload_1
    //   139: iconst_5
    //   140: aaload
    //   141: invokestatic 117	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   144: invokevirtual 121	java/lang/Integer:intValue	()I
    //   147: putfield 52	com/tencent/mobileqq/ocr/data/OcrDpc:f	I
    //   150: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   153: aload_1
    //   154: bipush 6
    //   156: aaload
    //   157: invokestatic 117	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   160: invokevirtual 121	java/lang/Integer:intValue	()I
    //   163: putfield 54	com/tencent/mobileqq/ocr/data/OcrDpc:g	I
    //   166: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   169: aload_1
    //   170: bipush 7
    //   172: aaload
    //   173: invokestatic 117	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   176: invokevirtual 121	java/lang/Integer:intValue	()I
    //   179: putfield 56	com/tencent/mobileqq/ocr/data/OcrDpc:h	I
    //   182: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   185: aload_1
    //   186: bipush 8
    //   188: aaload
    //   189: invokestatic 117	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   192: invokevirtual 121	java/lang/Integer:intValue	()I
    //   195: putfield 58	com/tencent/mobileqq/ocr/data/OcrDpc:i	I
    //   198: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +30 -> 231
    //   204: ldc 81
    //   206: iconst_2
    //   207: new 123	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   214: ldc 126
    //   216: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   222: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: ldc 2
    //   233: monitorexit
    //   234: return
    //   235: astore_1
    //   236: ldc 81
    //   238: iconst_1
    //   239: new 123	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   246: ldc 138
    //   248: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_1
    //   252: invokevirtual 141	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   255: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   267: bipush 70
    //   269: putfield 44	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_b_of_type_Int	I
    //   272: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   275: sipush 800
    //   278: putfield 46	com/tencent/mobileqq/ocr/data/OcrDpc:c	I
    //   281: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   284: sipush 1080
    //   287: putfield 48	com/tencent/mobileqq/ocr/data/OcrDpc:d	I
    //   290: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   293: sipush 1920
    //   296: putfield 50	com/tencent/mobileqq/ocr/data/OcrDpc:e	I
    //   299: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   302: bipush 100
    //   304: putfield 52	com/tencent/mobileqq/ocr/data/OcrDpc:f	I
    //   307: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   310: bipush 6
    //   312: putfield 54	com/tencent/mobileqq/ocr/data/OcrDpc:g	I
    //   315: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   318: sipush 140
    //   321: putfield 56	com/tencent/mobileqq/ocr/data/OcrDpc:h	I
    //   324: getstatic 73	com/tencent/mobileqq/ocr/data/OcrDpc:jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc	Lcom/tencent/mobileqq/ocr/data/OcrDpc;
    //   327: bipush 100
    //   329: putfield 58	com/tencent/mobileqq/ocr/data/OcrDpc:i	I
    //   332: goto -134 -> 198
    //   335: astore_1
    //   336: ldc 2
    //   338: monitorexit
    //   339: aload_1
    //   340: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   53	5	0	j	int
    //   19	167	1	localObject1	Object
    //   235	17	1	localException	java.lang.Exception
    //   335	5	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   60	198	235	java/lang/Exception
    //   3	54	335	finally
    //   60	198	335	finally
    //   198	231	335	finally
    //   236	332	335	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ocrSwitch:").append(this.jdField_a_of_type_Int).append(",picQuality:").append(this.jdField_b_of_type_Int).append(",picShortestSide:").append(this.c).append(",maxPreviewWidth:").append(this.d).append(",maxPreviewHeight:").append(this.e).append(",").append(this.f).append(",").append(this.g).append(",").append(this.h).append(",").append(this.i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.OcrDpc
 * JD-Core Version:    0.7.0.1
 */