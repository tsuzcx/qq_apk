package com.tencent.mobileqq.qqfeatureswitch;

import com.tencent.featuretoggle.Toggle;

public class ToggleReleaseModel
  implements ISwitchModel
{
  public void a() {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public FeatureSwitch b(String paramString, boolean paramBoolean)
  {
    paramBoolean = Toggle.a(paramString, paramBoolean);
    FeatureSwitch localFeatureSwitch = new FeatureSwitch();
    localFeatureSwitch.mSwitchEnable = paramBoolean;
    localFeatureSwitch.mSwitchName = paramString;
    return localFeatureSwitch;
  }
  
  /* Error */
  public java.util.Map<String, FeatureSwitch> b()
  {
    // Byte code:
    //   0: invokestatic 36	com/tencent/featuretoggle/Toggle:a	()Ljava/util/Map;
    //   3: astore_3
    //   4: aload_3
    //   5: ifnonnull +15 -> 20
    //   8: ldc 38
    //   10: iconst_1
    //   11: ldc 40
    //   13: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: invokestatic 51	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   19: areturn
    //   20: new 53	java/util/HashMap
    //   23: dup
    //   24: invokespecial 54	java/util/HashMap:<init>	()V
    //   27: astore 4
    //   29: aconst_null
    //   30: astore_1
    //   31: aconst_null
    //   32: astore_2
    //   33: aload_3
    //   34: invokeinterface 60 1 0
    //   39: invokeinterface 66 1 0
    //   44: astore_3
    //   45: aload_2
    //   46: astore_1
    //   47: aload_3
    //   48: invokeinterface 72 1 0
    //   53: ifeq +124 -> 177
    //   56: aload_2
    //   57: astore_1
    //   58: aload_3
    //   59: invokeinterface 76 1 0
    //   64: checkcast 78	java/util/Map$Entry
    //   67: astore 5
    //   69: aload_2
    //   70: astore_1
    //   71: aload 5
    //   73: invokeinterface 81 1 0
    //   78: checkcast 83	java/lang/String
    //   81: astore_2
    //   82: new 22	com/tencent/mobileqq/qqfeatureswitch/FeatureSwitch
    //   85: dup
    //   86: invokespecial 23	com/tencent/mobileqq/qqfeatureswitch/FeatureSwitch:<init>	()V
    //   89: astore_1
    //   90: aload_1
    //   91: aload 5
    //   93: invokeinterface 86 1 0
    //   98: checkcast 83	java/lang/String
    //   101: invokestatic 92	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   104: putfield 27	com/tencent/mobileqq/qqfeatureswitch/FeatureSwitch:mSwitchEnable	Z
    //   107: aload_1
    //   108: aload 5
    //   110: invokeinterface 81 1 0
    //   115: checkcast 83	java/lang/String
    //   118: putfield 31	com/tencent/mobileqq/qqfeatureswitch/FeatureSwitch:mSwitchName	Ljava/lang/String;
    //   121: aload 4
    //   123: aload 5
    //   125: invokeinterface 81 1 0
    //   130: aload_1
    //   131: invokeinterface 96 3 0
    //   136: pop
    //   137: goto -92 -> 45
    //   140: astore_1
    //   141: goto +8 -> 149
    //   144: astore_3
    //   145: aload_1
    //   146: astore_2
    //   147: aload_3
    //   148: astore_1
    //   149: ldc 38
    //   151: iconst_1
    //   152: iconst_4
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: ldc 98
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: aload_2
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: ldc 100
    //   169: aastore
    //   170: dup
    //   171: iconst_3
    //   172: aload_1
    //   173: aastore
    //   174: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   177: aload 4
    //   179: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	ToggleReleaseModel
    //   30	101	1	localObject1	Object
    //   140	6	1	localException1	java.lang.Exception
    //   148	25	1	localException2	java.lang.Exception
    //   32	132	2	localObject2	Object
    //   3	56	3	localObject3	Object
    //   144	4	3	localException3	java.lang.Exception
    //   27	151	4	localHashMap	java.util.HashMap
    //   67	57	5	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   82	137	140	java/lang/Exception
    //   33	45	144	java/lang/Exception
    //   47	56	144	java/lang/Exception
    //   58	69	144	java/lang/Exception
    //   71	82	144	java/lang/Exception
  }
  
  public boolean c(String paramString, boolean paramBoolean)
  {
    return Toggle.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.ToggleReleaseModel
 * JD-Core Version:    0.7.0.1
 */