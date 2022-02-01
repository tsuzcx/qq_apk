package com.tencent.turingfd.sdk.ams.ga;

import java.util.ArrayList;

public class Pyxis
{
  public static final String Be = const.get(const.Zb);
  public static final String Ce = const.get(const.cc);
  public static final String Yd = const.get(const._b);
  public static final String Zd = const.get(const.ac);
  public static final String _d = const.get(const.bc);
  public long De;
  public String Ee;
  public ArrayList<String> Fe;
  public int uid;
  
  /* Error */
  public Pyxis(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 59	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc2_w 60
    //   8: putfield 63	com/tencent/turingfd/sdk/ams/ga/Pyxis:De	J
    //   11: aload_0
    //   12: iconst_m1
    //   13: putfield 65	com/tencent/turingfd/sdk/ams/ga/Pyxis:uid	I
    //   16: aload_0
    //   17: ldc 67
    //   19: putfield 69	com/tencent/turingfd/sdk/ams/ga/Pyxis:Ee	Ljava/lang/String;
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 71	com/tencent/turingfd/sdk/ams/ga/Pyxis:Fe	Ljava/util/ArrayList;
    //   27: new 73	org/json/JSONObject
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_1
    //   37: getstatic 52	com/tencent/turingfd/sdk/ams/ga/Pyxis:Ce	Ljava/lang/String;
    //   40: invokevirtual 80	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   43: ifeq +141 -> 184
    //   46: aload_1
    //   47: getstatic 52	com/tencent/turingfd/sdk/ams/ga/Pyxis:Ce	Ljava/lang/String;
    //   50: invokevirtual 84	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   53: astore_2
    //   54: aload_2
    //   55: invokevirtual 90	org/json/JSONArray:length	()I
    //   58: pop
    //   59: aload_0
    //   60: new 92	java/util/ArrayList
    //   63: dup
    //   64: invokespecial 93	java/util/ArrayList:<init>	()V
    //   67: putfield 71	com/tencent/turingfd/sdk/ams/ga/Pyxis:Fe	Ljava/util/ArrayList;
    //   70: iconst_0
    //   71: istore_3
    //   72: iload_3
    //   73: aload_2
    //   74: invokevirtual 90	org/json/JSONArray:length	()I
    //   77: if_icmpge +27 -> 104
    //   80: aload_2
    //   81: iload_3
    //   82: invokevirtual 97	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   85: astore 4
    //   87: aload_0
    //   88: getfield 71	com/tencent/turingfd/sdk/ams/ga/Pyxis:Fe	Ljava/util/ArrayList;
    //   91: aload 4
    //   93: invokevirtual 101	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   96: pop
    //   97: iload_3
    //   98: iconst_1
    //   99: iadd
    //   100: istore_3
    //   101: goto -29 -> 72
    //   104: ldc 103
    //   106: invokestatic 109	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   109: new 111	java/io/ByteArrayInputStream
    //   112: dup
    //   113: aload_0
    //   114: getfield 71	com/tencent/turingfd/sdk/ams/ga/Pyxis:Fe	Ljava/util/ArrayList;
    //   117: iconst_0
    //   118: invokevirtual 114	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   121: checkcast 116	java/lang/String
    //   124: invokevirtual 120	java/lang/String:getBytes	()[B
    //   127: invokespecial 123	java/io/ByteArrayInputStream:<init>	([B)V
    //   130: invokevirtual 127	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   133: checkcast 129	java/security/cert/X509Certificate
    //   136: astore_2
    //   137: aload_2
    //   138: aload_0
    //   139: invokestatic 135	com/tencent/turingfd/sdk/ams/ga/Lyra:a	(Ljava/security/cert/X509Certificate;Lcom/tencent/turingfd/sdk/ams/ga/Pyxis;)V
    //   142: aload_1
    //   143: getstatic 42	com/tencent/turingfd/sdk/ams/ga/Pyxis:Zd	Ljava/lang/String;
    //   146: aload_0
    //   147: getfield 69	com/tencent/turingfd/sdk/ams/ga/Pyxis:Ee	Ljava/lang/String;
    //   150: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: aload_1
    //   155: getstatic 47	com/tencent/turingfd/sdk/ams/ga/Pyxis:_d	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 65	com/tencent/turingfd/sdk/ams/ga/Pyxis:uid	I
    //   162: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload_1
    //   167: getstatic 37	com/tencent/turingfd/sdk/ams/ga/Pyxis:Yd	Ljava/lang/String;
    //   170: aload_0
    //   171: getfield 63	com/tencent/turingfd/sdk/ams/ga/Pyxis:De	J
    //   174: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   177: pop
    //   178: aload_1
    //   179: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   182: pop
    //   183: return
    //   184: aload_0
    //   185: aload_1
    //   186: getstatic 37	com/tencent/turingfd/sdk/ams/ga/Pyxis:Yd	Ljava/lang/String;
    //   189: invokevirtual 153	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   192: putfield 63	com/tencent/turingfd/sdk/ams/ga/Pyxis:De	J
    //   195: aload_0
    //   196: aload_1
    //   197: getstatic 47	com/tencent/turingfd/sdk/ams/ga/Pyxis:_d	Ljava/lang/String;
    //   200: invokevirtual 157	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   203: putfield 65	com/tencent/turingfd/sdk/ams/ga/Pyxis:uid	I
    //   206: aload_0
    //   207: aload_1
    //   208: getstatic 42	com/tencent/turingfd/sdk/ams/ga/Pyxis:Zd	Ljava/lang/String;
    //   211: invokevirtual 161	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: putfield 69	com/tencent/turingfd/sdk/ams/ga/Pyxis:Ee	Ljava/lang/String;
    //   217: aload_1
    //   218: getstatic 32	com/tencent/turingfd/sdk/ams/ga/Pyxis:Be	Ljava/lang/String;
    //   221: invokevirtual 161	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   224: pop
    //   225: return
    //   226: astore_1
    //   227: return
    //   228: astore_2
    //   229: goto -87 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	Pyxis
    //   0	232	1	paramString1	String
    //   0	232	2	paramString2	String
    //   71	30	3	i	int
    //   85	7	4	str	String
    // Exception table:
    //   from	to	target	type
    //   27	70	226	java/lang/Exception
    //   72	97	226	java/lang/Exception
    //   104	137	226	java/lang/Exception
    //   142	183	226	java/lang/Exception
    //   184	225	226	java/lang/Exception
    //   137	142	228	java/lang/Exception
  }
  
  /* Error */
  public Pyxis(java.security.cert.Certificate[] paramArrayOfCertificate)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 59	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc2_w 60
    //   8: putfield 63	com/tencent/turingfd/sdk/ams/ga/Pyxis:De	J
    //   11: aload_0
    //   12: iconst_m1
    //   13: putfield 65	com/tencent/turingfd/sdk/ams/ga/Pyxis:uid	I
    //   16: aload_0
    //   17: ldc 67
    //   19: putfield 69	com/tencent/turingfd/sdk/ams/ga/Pyxis:Ee	Ljava/lang/String;
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 71	com/tencent/turingfd/sdk/ams/ga/Pyxis:Fe	Ljava/util/ArrayList;
    //   27: aload_1
    //   28: ifnull +153 -> 181
    //   31: new 92	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 93	java/util/ArrayList:<init>	()V
    //   38: astore 4
    //   40: new 86	org/json/JSONArray
    //   43: dup
    //   44: invokespecial 163	org/json/JSONArray:<init>	()V
    //   47: astore_3
    //   48: iconst_0
    //   49: istore_2
    //   50: iload_2
    //   51: aload_1
    //   52: arraylength
    //   53: if_icmpge +64 -> 117
    //   56: aload_1
    //   57: iload_2
    //   58: aaload
    //   59: astore 6
    //   61: aload 6
    //   63: invokevirtual 168	java/security/cert/Certificate:getEncoded	()[B
    //   66: iconst_2
    //   67: invokestatic 174	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   70: pop
    //   71: aload 6
    //   73: invokestatic 177	com/tencent/turingfd/sdk/ams/ga/Lyra:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   76: astore 5
    //   78: iload_2
    //   79: ifne +16 -> 95
    //   82: aload 6
    //   84: checkcast 129	java/security/cert/X509Certificate
    //   87: astore 6
    //   89: aload 6
    //   91: aload_0
    //   92: invokestatic 135	com/tencent/turingfd/sdk/ams/ga/Lyra:a	(Ljava/security/cert/X509Certificate;Lcom/tencent/turingfd/sdk/ams/ga/Pyxis;)V
    //   95: aload_3
    //   96: aload 5
    //   98: invokevirtual 180	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   101: pop
    //   102: aload 4
    //   104: aload 5
    //   106: invokevirtual 101	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   109: pop
    //   110: iload_2
    //   111: iconst_1
    //   112: iadd
    //   113: istore_2
    //   114: goto -64 -> 50
    //   117: aload_0
    //   118: aload 4
    //   120: putfield 71	com/tencent/turingfd/sdk/ams/ga/Pyxis:Fe	Ljava/util/ArrayList;
    //   123: new 73	org/json/JSONObject
    //   126: dup
    //   127: invokespecial 181	org/json/JSONObject:<init>	()V
    //   130: astore_1
    //   131: aload_1
    //   132: getstatic 52	com/tencent/turingfd/sdk/ams/ga/Pyxis:Ce	Ljava/lang/String;
    //   135: aload_3
    //   136: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload_1
    //   141: getstatic 42	com/tencent/turingfd/sdk/ams/ga/Pyxis:Zd	Ljava/lang/String;
    //   144: aload_0
    //   145: getfield 69	com/tencent/turingfd/sdk/ams/ga/Pyxis:Ee	Ljava/lang/String;
    //   148: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload_1
    //   153: getstatic 47	com/tencent/turingfd/sdk/ams/ga/Pyxis:_d	Ljava/lang/String;
    //   156: aload_0
    //   157: getfield 65	com/tencent/turingfd/sdk/ams/ga/Pyxis:uid	I
    //   160: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload_1
    //   165: getstatic 37	com/tencent/turingfd/sdk/ams/ga/Pyxis:Yd	Ljava/lang/String;
    //   168: aload_0
    //   169: getfield 63	com/tencent/turingfd/sdk/ams/ga/Pyxis:De	J
    //   172: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   175: pop
    //   176: aload_1
    //   177: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   180: pop
    //   181: return
    //   182: astore_1
    //   183: return
    //   184: astore 6
    //   186: goto -91 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	Pyxis
    //   0	189	1	paramArrayOfCertificate	java.security.cert.Certificate[]
    //   49	65	2	i	int
    //   47	89	3	localJSONArray	org.json.JSONArray
    //   38	81	4	localArrayList	ArrayList
    //   76	29	5	str	String
    //   59	31	6	localObject	Object
    //   184	1	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   31	48	182	java/lang/Exception
    //   50	56	182	java/lang/Exception
    //   61	78	182	java/lang/Exception
    //   82	89	182	java/lang/Exception
    //   95	110	182	java/lang/Exception
    //   117	181	182	java/lang/Exception
    //   89	95	184	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Pyxis
 * JD-Core Version:    0.7.0.1
 */