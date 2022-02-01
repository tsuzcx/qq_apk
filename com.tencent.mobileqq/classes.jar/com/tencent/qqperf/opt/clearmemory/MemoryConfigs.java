package com.tencent.qqperf.opt.clearmemory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.MobileQQ;

public class MemoryConfigs
{
  public float a;
  public int a;
  public long a;
  public ClearMemoryConfig a;
  public String a;
  public boolean a;
  public float b;
  public long b;
  private String b;
  public boolean b;
  public float c;
  public boolean c;
  public float d;
  public boolean d;
  public boolean e;
  
  /* Error */
  public MemoryConfigs()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 21	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc 23
    //   7: putfield 25	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: aload_0
    //   11: fconst_0
    //   12: putfield 27	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Float	F
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 29	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Boolean	Z
    //   20: aload_0
    //   21: bipush 15
    //   23: putfield 31	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Int	I
    //   26: aload_0
    //   27: ldc2_w 32
    //   30: putfield 35	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Long	J
    //   33: aload_0
    //   34: ldc 36
    //   36: putfield 38	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_b_of_type_Float	F
    //   39: aload_0
    //   40: ldc 36
    //   42: putfield 40	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_c_of_type_Float	F
    //   45: aload_0
    //   46: ldc 42
    //   48: putfield 44	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 46	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_b_of_type_Boolean	Z
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 48	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_c_of_type_Boolean	Z
    //   61: aload_0
    //   62: iconst_1
    //   63: putfield 50	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_d_of_type_Boolean	Z
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 52	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:e	Z
    //   71: aload_0
    //   72: ldc 53
    //   74: putfield 55	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_d_of_type_Float	F
    //   77: aload_0
    //   78: ldc2_w 56
    //   81: putfield 59	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_b_of_type_Long	J
    //   84: invokestatic 64	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/MagnifierSDK;
    //   87: invokevirtual 67	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/monitor/base/IAPMModuleCelling;
    //   90: invokeinterface 72 1 0
    //   95: astore_1
    //   96: aload_0
    //   97: new 74	com/tencent/qqperf/opt/clearmemory/ClearMemoryConfig
    //   100: dup
    //   101: ldc 76
    //   103: invokespecial 79	com/tencent/qqperf/opt/clearmemory/ClearMemoryConfig:<init>	(Ljava/lang/String;)V
    //   106: putfield 81	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig	Lcom/tencent/qqperf/opt/clearmemory/ClearMemoryConfig;
    //   109: aload_0
    //   110: getfield 81	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig	Lcom/tencent/qqperf/opt/clearmemory/ClearMemoryConfig;
    //   113: iconst_1
    //   114: putfield 82	com/tencent/qqperf/opt/clearmemory/ClearMemoryConfig:jdField_a_of_type_Boolean	Z
    //   117: aload_0
    //   118: invokespecial 84	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:a	()V
    //   121: aload_1
    //   122: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne +12 -> 137
    //   128: aload_1
    //   129: ldc 92
    //   131: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +4 -> 138
    //   137: return
    //   138: aload_1
    //   139: ldc 100
    //   141: invokevirtual 104	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   144: astore_1
    //   145: aload_1
    //   146: arraylength
    //   147: iconst_1
    //   148: if_icmple +246 -> 394
    //   151: aload_1
    //   152: ldc 106
    //   154: invokestatic 112	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   157: checkcast 106	com/tencent/mobileqq/dpc/api/IDPCApi
    //   160: invokeinterface 116 1 0
    //   165: aload_1
    //   166: arraylength
    //   167: irem
    //   168: aaload
    //   169: astore_1
    //   170: aload_1
    //   171: ldc 118
    //   173: invokevirtual 104	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   176: astore_1
    //   177: aload_1
    //   178: arraylength
    //   179: bipush 7
    //   181: if_icmplt -44 -> 137
    //   184: aload_1
    //   185: iconst_1
    //   186: aaload
    //   187: ldc 120
    //   189: invokevirtual 104	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   192: astore_2
    //   193: aload_2
    //   194: iconst_0
    //   195: aaload
    //   196: ldc 122
    //   198: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifeq +46 -> 247
    //   204: aload_0
    //   205: iconst_1
    //   206: putfield 29	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Boolean	Z
    //   209: aload_0
    //   210: aload_2
    //   211: iconst_1
    //   212: aaload
    //   213: invokestatic 128	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   216: putfield 31	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Int	I
    //   219: aload_0
    //   220: getfield 31	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Int	I
    //   223: bipush 50
    //   225: if_icmple +9 -> 234
    //   228: aload_0
    //   229: bipush 50
    //   231: putfield 31	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Int	I
    //   234: aload_0
    //   235: getfield 31	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Int	I
    //   238: iconst_1
    //   239: if_icmpge +8 -> 247
    //   242: aload_0
    //   243: iconst_1
    //   244: putfield 31	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Int	I
    //   247: aload_0
    //   248: aload_1
    //   249: iconst_2
    //   250: aaload
    //   251: putfield 25	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   254: aload_0
    //   255: aload_1
    //   256: iconst_4
    //   257: aaload
    //   258: invokestatic 134	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   261: invokevirtual 138	java/lang/Float:floatValue	()F
    //   264: putfield 27	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Float	F
    //   267: aload_0
    //   268: getfield 27	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Float	F
    //   271: fconst_1
    //   272: fcmpl
    //   273: ifle +8 -> 281
    //   276: aload_0
    //   277: fconst_1
    //   278: putfield 27	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Float	F
    //   281: aload_0
    //   282: aload_1
    //   283: bipush 6
    //   285: aaload
    //   286: invokestatic 142	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   289: putfield 38	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_b_of_type_Float	F
    //   292: aload_1
    //   293: arraylength
    //   294: bipush 9
    //   296: if_icmplt +8 -> 304
    //   299: aload_0
    //   300: aload_1
    //   301: invokespecial 145	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:a	([Ljava/lang/String;)V
    //   304: aload_1
    //   305: arraylength
    //   306: bipush 10
    //   308: if_icmplt +20 -> 328
    //   311: ldc 122
    //   313: aload_1
    //   314: bipush 9
    //   316: aaload
    //   317: invokevirtual 149	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   320: ifeq +100 -> 420
    //   323: aload_0
    //   324: iconst_1
    //   325: putfield 52	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:e	Z
    //   328: aload_1
    //   329: arraylength
    //   330: bipush 11
    //   332: if_icmplt +39 -> 371
    //   335: aload_1
    //   336: bipush 10
    //   338: aaload
    //   339: ldc 120
    //   341: invokevirtual 104	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   344: astore_2
    //   345: aload_2
    //   346: arraylength
    //   347: iconst_2
    //   348: if_icmplt +23 -> 371
    //   351: aload_0
    //   352: aload_2
    //   353: iconst_0
    //   354: aaload
    //   355: invokestatic 142	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   358: putfield 55	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_d_of_type_Float	F
    //   361: aload_0
    //   362: aload_2
    //   363: iconst_1
    //   364: aaload
    //   365: invokestatic 155	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   368: putfield 59	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_b_of_type_Long	J
    //   371: aload_0
    //   372: aload_1
    //   373: invokespecial 157	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:b	([Ljava/lang/String;)V
    //   376: return
    //   377: astore_1
    //   378: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   381: ifeq -244 -> 137
    //   384: ldc 165
    //   386: iconst_2
    //   387: ldc 167
    //   389: aload_1
    //   390: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   393: return
    //   394: aload_1
    //   395: iconst_0
    //   396: aaload
    //   397: astore_1
    //   398: goto -228 -> 170
    //   401: astore_2
    //   402: aload_0
    //   403: fconst_0
    //   404: putfield 27	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Float	F
    //   407: goto -126 -> 281
    //   410: astore_2
    //   411: aload_0
    //   412: ldc 171
    //   414: putfield 38	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_b_of_type_Float	F
    //   417: goto -125 -> 292
    //   420: aload_0
    //   421: iconst_0
    //   422: putfield 52	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:e	Z
    //   425: goto -97 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	MemoryConfigs
    //   95	278	1	localObject1	Object
    //   377	18	1	localException1	Exception
    //   397	1	1	localObject2	Object
    //   192	171	2	arrayOfString	String[]
    //   401	1	2	localException2	Exception
    //   410	1	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   170	234	377	java/lang/Exception
    //   234	247	377	java/lang/Exception
    //   247	254	377	java/lang/Exception
    //   292	304	377	java/lang/Exception
    //   304	328	377	java/lang/Exception
    //   328	371	377	java/lang/Exception
    //   371	376	377	java/lang/Exception
    //   402	407	377	java/lang/Exception
    //   411	417	377	java/lang/Exception
    //   420	425	377	java/lang/Exception
    //   254	281	401	java/lang/Exception
    //   281	292	410	java/lang/Exception
  }
  
  private void a()
  {
    Object localObject = MobileQQ.getContext().getSharedPreferences("MemoryManagerMemoryStat", 4);
    if (((SharedPreferences)localObject).getInt(this.jdField_b_of_type_JavaLangString, -1) == -1)
    {
      int i = new Random().nextInt(1000);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(this.jdField_b_of_type_JavaLangString, i);
      if (Build.VERSION.SDK_INT < 9) {
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    else
    {
      if (0.001F < Math.random()) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
      ((SharedPreferences.Editor)localObject).apply();
      break;
    }
  }
  
  private void a(String[] paramArrayOfString)
  {
    for (;;)
    {
      try
      {
        paramArrayOfString = paramArrayOfString[8].split(";");
        if (paramArrayOfString.length < 5) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig == null)
        {
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig = new ClearMemoryConfig(this.jdField_a_of_type_JavaLangString);
          if (paramArrayOfString[0].equals("1"))
          {
            this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.b = Integer.parseInt(paramArrayOfString[1]);
            Object localObject = paramArrayOfString[2].split(",");
            if (localObject.length >= 4)
            {
              localObject = new ClearMemoryConfig.MemoryLevelInfo(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Float.parseFloat(localObject[2]), Float.parseFloat(localObject[3]));
              this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_AndroidUtilSparseArray.put(1, localObject);
            }
            localObject = paramArrayOfString[3].split(",");
            if (localObject.length >= 4)
            {
              localObject = new ClearMemoryConfig.MemoryLevelInfo(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Float.parseFloat(localObject[2]), Float.parseFloat(localObject[3]));
              this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_AndroidUtilSparseArray.put(2, localObject);
            }
            paramArrayOfString = paramArrayOfString[4].split(",");
            if (paramArrayOfString.length >= 4)
            {
              paramArrayOfString = new ClearMemoryConfig.MemoryLevelInfo(Integer.parseInt(paramArrayOfString[0]), Integer.parseInt(paramArrayOfString[1]), Float.parseFloat(paramArrayOfString[2]), Float.parseFloat(paramArrayOfString[3]));
              this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_AndroidUtilSparseArray.put(3, paramArrayOfString);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.Memory.MemoryConfigs", 2, "mClearMemoryConfig= " + this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          continue;
        }
        if (!paramArrayOfString[0].equals("0")) {
          break label324;
        }
      }
      catch (Exception paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
      this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = false;
      continue;
      label324:
      if (MobileQQ.sProcessId == 1) {
        this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = true;
      } else if (paramArrayOfString[0].equals("3")) {
        this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = true;
      } else if (paramArrayOfString[0].equals("4")) {
        this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = false;
      } else {
        this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length >= 12)
    {
      if ("1".equalsIgnoreCase(paramArrayOfString[11])) {
        this.jdField_d_of_type_Boolean = true;
      }
    }
    else {
      return;
    }
    this.jdField_d_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.MemoryConfigs
 * JD-Core Version:    0.7.0.1
 */