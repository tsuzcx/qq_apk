package com.tencent.open.agent.auth.model;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.agent.authority.CGICallback;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import org.json.JSONObject;

public class VirtualCreatorDataSourceImpl
  implements IVirtualCreatorDataSource
{
  private void a(AccountInfo paramAccountInfo, JSONObject paramJSONObject, boolean paramBoolean, CGICallback paramCGICallback)
  {
    OpenSdkVirtualUtil.a("oidb_0xc7f_25", paramAccountInfo, paramJSONObject.toString(), new VirtualCreatorDataSourceImpl.2(this, paramCGICallback, paramAccountInfo, paramJSONObject, paramBoolean), paramBoolean);
  }
  
  public void a(long paramLong, String paramString1, String paramString2, AccountInfo paramAccountInfo, boolean paramBoolean, CGICallback paramCGICallback)
  {
    ThreadManagerV2.executeOnSubThread(new VirtualCreatorDataSourceImpl.1(this, paramLong, paramString1, paramString2, paramAccountInfo, paramCGICallback, paramBoolean));
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2, AccountInfo paramAccountInfo, boolean paramBoolean, CGICallback paramCGICallback)
  {
    // Byte code:
    //   0: new 20	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 50	org/json/JSONObject:<init>	()V
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore_1
    //   14: new 52	java/io/FileInputStream
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 55	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload_2
    //   24: invokevirtual 59	java/io/FileInputStream:available	()I
    //   27: istore 6
    //   29: iload 6
    //   31: newarray byte
    //   33: astore_1
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 63	java/io/FileInputStream:read	([B)I
    //   39: pop
    //   40: aload_1
    //   41: iconst_2
    //   42: invokestatic 69	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   45: astore 7
    //   47: ldc 71
    //   49: iconst_4
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: ldc 73
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: iload 6
    //   62: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aastore
    //   66: dup
    //   67: iconst_2
    //   68: ldc 81
    //   70: aastore
    //   71: dup
    //   72: iconst_3
    //   73: aload 7
    //   75: invokevirtual 86	java/lang/String:length	()I
    //   78: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: invokestatic 91	com/tencent/open/agent/util/SSOLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: new 20	org/json/JSONObject
    //   88: dup
    //   89: invokespecial 50	org/json/JSONObject:<init>	()V
    //   92: astore_1
    //   93: aload_1
    //   94: ldc 93
    //   96: iconst_4
    //   97: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   100: pop
    //   101: aload_1
    //   102: ldc 99
    //   104: iconst_3
    //   105: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   108: pop
    //   109: aload_1
    //   110: ldc 101
    //   112: iload 6
    //   114: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload_1
    //   119: ldc 103
    //   121: aload 7
    //   123: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   126: pop
    //   127: new 20	org/json/JSONObject
    //   130: dup
    //   131: invokespecial 50	org/json/JSONObject:<init>	()V
    //   134: astore 7
    //   136: aload 7
    //   138: ldc 108
    //   140: iconst_0
    //   141: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   144: pop
    //   145: new 110	org/json/JSONArray
    //   148: dup
    //   149: invokespecial 111	org/json/JSONArray:<init>	()V
    //   152: astore 9
    //   154: aload 9
    //   156: aload_1
    //   157: invokevirtual 114	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   160: pop
    //   161: aload 7
    //   163: ldc 116
    //   165: aload 9
    //   167: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   170: pop
    //   171: aload 8
    //   173: ldc 118
    //   175: aload_3
    //   176: getfield 123	com/tencent/open/model/AccountInfo:a	Ljava/lang/String;
    //   179: invokestatic 128	com/tencent/open/agent/util/ParseUtil:a	(Ljava/lang/String;)J
    //   182: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   185: pop
    //   186: aload 8
    //   188: ldc 133
    //   190: iconst_1
    //   191: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   194: pop
    //   195: aload 8
    //   197: ldc 135
    //   199: iconst_1
    //   200: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   203: pop
    //   204: aload 8
    //   206: ldc 137
    //   208: iconst_1
    //   209: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   212: pop
    //   213: aload 8
    //   215: ldc 139
    //   217: aload 7
    //   219: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   222: pop
    //   223: aload_0
    //   224: aload_3
    //   225: aload 8
    //   227: iload 4
    //   229: aload 5
    //   231: invokespecial 16	com/tencent/open/agent/auth/model/VirtualCreatorDataSourceImpl:a	(Lcom/tencent/open/model/AccountInfo;Lorg/json/JSONObject;ZLcom/tencent/open/agent/authority/CGICallback;)V
    //   234: aload_2
    //   235: invokestatic 144	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   238: iconst_1
    //   239: ireturn
    //   240: astore_1
    //   241: goto +35 -> 276
    //   244: astore_3
    //   245: goto +15 -> 260
    //   248: astore_3
    //   249: aload_1
    //   250: astore_2
    //   251: aload_3
    //   252: astore_1
    //   253: goto +23 -> 276
    //   256: astore_3
    //   257: aload 7
    //   259: astore_2
    //   260: aload_2
    //   261: astore_1
    //   262: ldc 71
    //   264: ldc 146
    //   266: aload_3
    //   267: invokestatic 150	com/tencent/open/agent/util/SSOLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   270: aload_2
    //   271: invokestatic 144	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   274: iconst_0
    //   275: ireturn
    //   276: aload_2
    //   277: invokestatic 144	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   280: aload_1
    //   281: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	VirtualCreatorDataSourceImpl
    //   0	282	1	paramString1	String
    //   0	282	2	paramString2	String
    //   0	282	3	paramAccountInfo	AccountInfo
    //   0	282	4	paramBoolean	boolean
    //   0	282	5	paramCGICallback	CGICallback
    //   27	86	6	i	int
    //   10	248	7	localObject	Object
    //   7	219	8	localJSONObject	JSONObject
    //   152	14	9	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   23	234	240	finally
    //   23	234	244	java/lang/Exception
    //   14	23	248	finally
    //   262	270	248	finally
    //   14	23	256	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.model.VirtualCreatorDataSourceImpl
 * JD-Core Version:    0.7.0.1
 */