package com.tencent.mobileqq.data;

public class MessageForTroopStory
  extends MessageForRichText
{
  public static final int CTR_VERSION = 1;
  public static final String KEY_COMPATIBLE_TEXT = "key_compatible_text";
  public static final String KEY_CTR_VERSION = "key_ctr_version";
  public static final String KEY_DOODLE_URL = "key_doodle_url";
  public static final String KEY_MD5 = "key_md5";
  public static final String KEY_SOURCE_ACTION_DATA = "key_source_action_data";
  public static final String KEY_SOURCE_ACTION_TYPE = "key_source_action_type";
  public static final String KEY_SOURCE_NAME = "key_source_name";
  public static final String KEY_STORY_ID = "key_story_id";
  public static final String KEY_THUMB_URL = "key_thumb_url";
  public static final String KEY_UID = "key_uid";
  public static final String KEY_UNION_ID = "key_union_id";
  public static final String KEY_VIDEO_HEIGHT = "key_video_height";
  public static final String KEY_VIDEO_WIDTH = "key_video_width";
  public static final String MSG_CONTENT = "[小视频]";
  public static final String TAG = "MessageForTroopStory";
  public String compatibleText;
  public int ctrVersion;
  public String doodleUrl;
  public String md5;
  public String sourceActionData;
  public String sourceActionType;
  public String sourceName;
  public String storyId;
  public String thumbUrl;
  public long uid;
  public String unionId;
  public int videoHeight;
  public int videoWidth;
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 50
    //   3: putfield 80	com/tencent/mobileqq/data/MessageForTroopStory:msg	Ljava/lang/String;
    //   6: new 82	java/io/ObjectInputStream
    //   9: dup
    //   10: new 84	java/io/ByteArrayInputStream
    //   13: dup
    //   14: aload_0
    //   15: getfield 88	com/tencent/mobileqq/data/MessageForTroopStory:msgData	[B
    //   18: invokespecial 91	java/io/ByteArrayInputStream:<init>	([B)V
    //   21: invokespecial 94	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_0
    //   28: aload_2
    //   29: invokevirtual 98	java/io/ObjectInputStream:readLong	()J
    //   32: putfield 100	com/tencent/mobileqq/data/MessageForTroopStory:uid	J
    //   35: aload_2
    //   36: astore_1
    //   37: aload_0
    //   38: aload_2
    //   39: invokevirtual 104	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   42: putfield 106	com/tencent/mobileqq/data/MessageForTroopStory:unionId	Ljava/lang/String;
    //   45: aload_2
    //   46: astore_1
    //   47: aload_0
    //   48: aload_2
    //   49: invokevirtual 104	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   52: putfield 108	com/tencent/mobileqq/data/MessageForTroopStory:storyId	Ljava/lang/String;
    //   55: aload_2
    //   56: astore_1
    //   57: aload_0
    //   58: aload_2
    //   59: invokevirtual 104	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   62: putfield 110	com/tencent/mobileqq/data/MessageForTroopStory:md5	Ljava/lang/String;
    //   65: aload_2
    //   66: astore_1
    //   67: aload_0
    //   68: aload_2
    //   69: invokevirtual 104	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   72: putfield 112	com/tencent/mobileqq/data/MessageForTroopStory:thumbUrl	Ljava/lang/String;
    //   75: aload_2
    //   76: astore_1
    //   77: aload_0
    //   78: aload_2
    //   79: invokevirtual 104	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   82: putfield 114	com/tencent/mobileqq/data/MessageForTroopStory:doodleUrl	Ljava/lang/String;
    //   85: aload_2
    //   86: astore_1
    //   87: aload_0
    //   88: aload_2
    //   89: invokevirtual 118	java/io/ObjectInputStream:readInt	()I
    //   92: putfield 120	com/tencent/mobileqq/data/MessageForTroopStory:videoWidth	I
    //   95: aload_2
    //   96: astore_1
    //   97: aload_0
    //   98: aload_2
    //   99: invokevirtual 118	java/io/ObjectInputStream:readInt	()I
    //   102: putfield 122	com/tencent/mobileqq/data/MessageForTroopStory:videoHeight	I
    //   105: aload_2
    //   106: astore_1
    //   107: aload_0
    //   108: aload_2
    //   109: invokevirtual 104	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   112: putfield 124	com/tencent/mobileqq/data/MessageForTroopStory:sourceName	Ljava/lang/String;
    //   115: aload_2
    //   116: astore_1
    //   117: aload_0
    //   118: aload_2
    //   119: invokevirtual 104	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   122: putfield 126	com/tencent/mobileqq/data/MessageForTroopStory:sourceActionType	Ljava/lang/String;
    //   125: aload_2
    //   126: astore_1
    //   127: aload_0
    //   128: aload_2
    //   129: invokevirtual 104	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   132: putfield 128	com/tencent/mobileqq/data/MessageForTroopStory:sourceActionData	Ljava/lang/String;
    //   135: aload_2
    //   136: astore_1
    //   137: aload_0
    //   138: aload_2
    //   139: invokevirtual 104	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   142: putfield 130	com/tencent/mobileqq/data/MessageForTroopStory:compatibleText	Ljava/lang/String;
    //   145: aload_2
    //   146: astore_1
    //   147: aload_0
    //   148: aload_2
    //   149: invokevirtual 133	java/io/ObjectInputStream:read	()I
    //   152: putfield 135	com/tencent/mobileqq/data/MessageForTroopStory:ctrVersion	I
    //   155: aload_2
    //   156: ifnull +7 -> 163
    //   159: aload_2
    //   160: invokevirtual 138	java/io/ObjectInputStream:close	()V
    //   163: return
    //   164: astore_3
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_2
    //   168: astore_1
    //   169: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +14 -> 186
    //   175: aload_2
    //   176: astore_1
    //   177: ldc 53
    //   179: iconst_2
    //   180: ldc 146
    //   182: aload_3
    //   183: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   186: aload_2
    //   187: ifnull -24 -> 163
    //   190: aload_2
    //   191: invokevirtual 138	java/io/ObjectInputStream:close	()V
    //   194: return
    //   195: astore_1
    //   196: return
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_1
    //   201: ifnull +7 -> 208
    //   204: aload_1
    //   205: invokevirtual 138	java/io/ObjectInputStream:close	()V
    //   208: aload_2
    //   209: athrow
    //   210: astore_1
    //   211: return
    //   212: astore_1
    //   213: goto -5 -> 208
    //   216: astore_2
    //   217: goto -17 -> 200
    //   220: astore_3
    //   221: goto -54 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	MessageForTroopStory
    //   26	151	1	localObjectInputStream1	java.io.ObjectInputStream
    //   195	1	1	localIOException1	java.io.IOException
    //   199	6	1	localObject1	java.lang.Object
    //   210	1	1	localIOException2	java.io.IOException
    //   212	1	1	localIOException3	java.io.IOException
    //   24	167	2	localObjectInputStream2	java.io.ObjectInputStream
    //   197	12	2	localObject2	java.lang.Object
    //   216	1	2	localObject3	java.lang.Object
    //   164	19	3	localException1	java.lang.Exception
    //   220	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   6	25	164	java/lang/Exception
    //   190	194	195	java/io/IOException
    //   6	25	197	finally
    //   159	163	210	java/io/IOException
    //   204	208	212	java/io/IOException
    //   27	35	216	finally
    //   37	45	216	finally
    //   47	55	216	finally
    //   57	65	216	finally
    //   67	75	216	finally
    //   77	85	216	finally
    //   87	95	216	finally
    //   97	105	216	finally
    //   107	115	216	finally
    //   117	125	216	finally
    //   127	135	216	finally
    //   137	145	216	finally
    //   147	155	216	finally
    //   169	175	216	finally
    //   177	186	216	finally
    //   27	35	220	java/lang/Exception
    //   37	45	220	java/lang/Exception
    //   47	55	220	java/lang/Exception
    //   57	65	220	java/lang/Exception
    //   67	75	220	java/lang/Exception
    //   77	85	220	java/lang/Exception
    //   87	95	220	java/lang/Exception
    //   97	105	220	java/lang/Exception
    //   107	115	220	java/lang/Exception
    //   117	125	220	java/lang/Exception
    //   127	135	220	java/lang/Exception
    //   137	145	220	java/lang/Exception
    //   147	155	220	java/lang/Exception
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  /* Error */
  public void serial()
  {
    // Byte code:
    //   0: new 160	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 161	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 163	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 166	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 100	com/tencent/mobileqq/data/MessageForTroopStory:uid	J
    //   26: invokevirtual 170	java/io/ObjectOutputStream:writeLong	(J)V
    //   29: aload_2
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 106	com/tencent/mobileqq/data/MessageForTroopStory:unionId	Ljava/lang/String;
    //   35: ifnonnull +221 -> 256
    //   38: ldc 172
    //   40: astore_3
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: aload_3
    //   45: invokevirtual 176	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 108	com/tencent/mobileqq/data/MessageForTroopStory:storyId	Ljava/lang/String;
    //   54: ifnonnull +212 -> 266
    //   57: ldc 172
    //   59: astore_3
    //   60: aload_2
    //   61: astore_1
    //   62: aload_2
    //   63: aload_3
    //   64: invokevirtual 176	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 110	com/tencent/mobileqq/data/MessageForTroopStory:md5	Ljava/lang/String;
    //   73: ifnonnull +203 -> 276
    //   76: ldc 172
    //   78: astore_3
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: aload_3
    //   83: invokevirtual 176	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   86: aload_2
    //   87: astore_1
    //   88: aload_0
    //   89: getfield 112	com/tencent/mobileqq/data/MessageForTroopStory:thumbUrl	Ljava/lang/String;
    //   92: ifnonnull +194 -> 286
    //   95: ldc 172
    //   97: astore_3
    //   98: aload_2
    //   99: astore_1
    //   100: aload_2
    //   101: aload_3
    //   102: invokevirtual 176	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   105: aload_2
    //   106: astore_1
    //   107: aload_0
    //   108: getfield 114	com/tencent/mobileqq/data/MessageForTroopStory:doodleUrl	Ljava/lang/String;
    //   111: ifnonnull +185 -> 296
    //   114: ldc 172
    //   116: astore_3
    //   117: aload_2
    //   118: astore_1
    //   119: aload_2
    //   120: aload_3
    //   121: invokevirtual 176	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   124: aload_2
    //   125: astore_1
    //   126: aload_2
    //   127: aload_0
    //   128: getfield 120	com/tencent/mobileqq/data/MessageForTroopStory:videoWidth	I
    //   131: invokevirtual 180	java/io/ObjectOutputStream:writeInt	(I)V
    //   134: aload_2
    //   135: astore_1
    //   136: aload_2
    //   137: aload_0
    //   138: getfield 122	com/tencent/mobileqq/data/MessageForTroopStory:videoHeight	I
    //   141: invokevirtual 180	java/io/ObjectOutputStream:writeInt	(I)V
    //   144: aload_2
    //   145: astore_1
    //   146: aload_0
    //   147: getfield 124	com/tencent/mobileqq/data/MessageForTroopStory:sourceName	Ljava/lang/String;
    //   150: ifnonnull +156 -> 306
    //   153: ldc 172
    //   155: astore_3
    //   156: aload_2
    //   157: astore_1
    //   158: aload_2
    //   159: aload_3
    //   160: invokevirtual 176	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   163: aload_2
    //   164: astore_1
    //   165: aload_0
    //   166: getfield 126	com/tencent/mobileqq/data/MessageForTroopStory:sourceActionType	Ljava/lang/String;
    //   169: ifnonnull +147 -> 316
    //   172: ldc 172
    //   174: astore_3
    //   175: aload_2
    //   176: astore_1
    //   177: aload_2
    //   178: aload_3
    //   179: invokevirtual 176	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   182: aload_2
    //   183: astore_1
    //   184: aload_0
    //   185: getfield 128	com/tencent/mobileqq/data/MessageForTroopStory:sourceActionData	Ljava/lang/String;
    //   188: ifnonnull +138 -> 326
    //   191: ldc 172
    //   193: astore_3
    //   194: aload_2
    //   195: astore_1
    //   196: aload_2
    //   197: aload_3
    //   198: invokevirtual 176	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   201: aload_2
    //   202: astore_1
    //   203: aload_0
    //   204: getfield 130	com/tencent/mobileqq/data/MessageForTroopStory:compatibleText	Ljava/lang/String;
    //   207: ifnonnull +129 -> 336
    //   210: ldc 172
    //   212: astore_3
    //   213: aload_2
    //   214: astore_1
    //   215: aload_2
    //   216: aload_3
    //   217: invokevirtual 176	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   220: aload_2
    //   221: astore_1
    //   222: aload_2
    //   223: aload_0
    //   224: getfield 135	com/tencent/mobileqq/data/MessageForTroopStory:ctrVersion	I
    //   227: invokevirtual 183	java/io/ObjectOutputStream:write	(I)V
    //   230: aload_2
    //   231: astore_1
    //   232: aload_2
    //   233: invokevirtual 186	java/io/ObjectOutputStream:flush	()V
    //   236: aload_2
    //   237: astore_1
    //   238: aload_0
    //   239: aload 4
    //   241: invokevirtual 190	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   244: putfield 88	com/tencent/mobileqq/data/MessageForTroopStory:msgData	[B
    //   247: aload_2
    //   248: ifnull +7 -> 255
    //   251: aload_2
    //   252: invokevirtual 191	java/io/ObjectOutputStream:close	()V
    //   255: return
    //   256: aload_2
    //   257: astore_1
    //   258: aload_0
    //   259: getfield 106	com/tencent/mobileqq/data/MessageForTroopStory:unionId	Ljava/lang/String;
    //   262: astore_3
    //   263: goto -222 -> 41
    //   266: aload_2
    //   267: astore_1
    //   268: aload_0
    //   269: getfield 108	com/tencent/mobileqq/data/MessageForTroopStory:storyId	Ljava/lang/String;
    //   272: astore_3
    //   273: goto -213 -> 60
    //   276: aload_2
    //   277: astore_1
    //   278: aload_0
    //   279: getfield 110	com/tencent/mobileqq/data/MessageForTroopStory:md5	Ljava/lang/String;
    //   282: astore_3
    //   283: goto -204 -> 79
    //   286: aload_2
    //   287: astore_1
    //   288: aload_0
    //   289: getfield 112	com/tencent/mobileqq/data/MessageForTroopStory:thumbUrl	Ljava/lang/String;
    //   292: astore_3
    //   293: goto -195 -> 98
    //   296: aload_2
    //   297: astore_1
    //   298: aload_0
    //   299: getfield 114	com/tencent/mobileqq/data/MessageForTroopStory:doodleUrl	Ljava/lang/String;
    //   302: astore_3
    //   303: goto -186 -> 117
    //   306: aload_2
    //   307: astore_1
    //   308: aload_0
    //   309: getfield 124	com/tencent/mobileqq/data/MessageForTroopStory:sourceName	Ljava/lang/String;
    //   312: astore_3
    //   313: goto -157 -> 156
    //   316: aload_2
    //   317: astore_1
    //   318: aload_0
    //   319: getfield 126	com/tencent/mobileqq/data/MessageForTroopStory:sourceActionType	Ljava/lang/String;
    //   322: astore_3
    //   323: goto -148 -> 175
    //   326: aload_2
    //   327: astore_1
    //   328: aload_0
    //   329: getfield 128	com/tencent/mobileqq/data/MessageForTroopStory:sourceActionData	Ljava/lang/String;
    //   332: astore_3
    //   333: goto -139 -> 194
    //   336: aload_2
    //   337: astore_1
    //   338: aload_0
    //   339: getfield 130	com/tencent/mobileqq/data/MessageForTroopStory:compatibleText	Ljava/lang/String;
    //   342: astore_3
    //   343: goto -130 -> 213
    //   346: astore_3
    //   347: aconst_null
    //   348: astore_2
    //   349: aload_2
    //   350: astore_1
    //   351: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq +14 -> 368
    //   357: aload_2
    //   358: astore_1
    //   359: ldc 53
    //   361: iconst_2
    //   362: ldc 193
    //   364: aload_3
    //   365: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   368: aload_2
    //   369: ifnull -114 -> 255
    //   372: aload_2
    //   373: invokevirtual 191	java/io/ObjectOutputStream:close	()V
    //   376: return
    //   377: astore_1
    //   378: return
    //   379: astore_2
    //   380: aconst_null
    //   381: astore_1
    //   382: aload_1
    //   383: ifnull +7 -> 390
    //   386: aload_1
    //   387: invokevirtual 191	java/io/ObjectOutputStream:close	()V
    //   390: aload_2
    //   391: athrow
    //   392: astore_1
    //   393: return
    //   394: astore_1
    //   395: goto -5 -> 390
    //   398: astore_2
    //   399: goto -17 -> 382
    //   402: astore_3
    //   403: goto -54 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	MessageForTroopStory
    //   20	339	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   377	1	1	localIOException1	java.io.IOException
    //   381	6	1	localObject1	java.lang.Object
    //   392	1	1	localIOException2	java.io.IOException
    //   394	1	1	localIOException3	java.io.IOException
    //   18	355	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   379	12	2	localObject2	java.lang.Object
    //   398	1	2	localObject3	java.lang.Object
    //   40	303	3	str	String
    //   346	19	3	localException1	java.lang.Exception
    //   402	1	3	localException2	java.lang.Exception
    //   7	233	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   9	19	346	java/lang/Exception
    //   372	376	377	java/io/IOException
    //   9	19	379	finally
    //   251	255	392	java/io/IOException
    //   386	390	394	java/io/IOException
    //   21	29	398	finally
    //   31	38	398	finally
    //   43	48	398	finally
    //   50	57	398	finally
    //   62	67	398	finally
    //   69	76	398	finally
    //   81	86	398	finally
    //   88	95	398	finally
    //   100	105	398	finally
    //   107	114	398	finally
    //   119	124	398	finally
    //   126	134	398	finally
    //   136	144	398	finally
    //   146	153	398	finally
    //   158	163	398	finally
    //   165	172	398	finally
    //   177	182	398	finally
    //   184	191	398	finally
    //   196	201	398	finally
    //   203	210	398	finally
    //   215	220	398	finally
    //   222	230	398	finally
    //   232	236	398	finally
    //   238	247	398	finally
    //   258	263	398	finally
    //   268	273	398	finally
    //   278	283	398	finally
    //   288	293	398	finally
    //   298	303	398	finally
    //   308	313	398	finally
    //   318	323	398	finally
    //   328	333	398	finally
    //   338	343	398	finally
    //   351	357	398	finally
    //   359	368	398	finally
    //   21	29	402	java/lang/Exception
    //   31	38	402	java/lang/Exception
    //   43	48	402	java/lang/Exception
    //   50	57	402	java/lang/Exception
    //   62	67	402	java/lang/Exception
    //   69	76	402	java/lang/Exception
    //   81	86	402	java/lang/Exception
    //   88	95	402	java/lang/Exception
    //   100	105	402	java/lang/Exception
    //   107	114	402	java/lang/Exception
    //   119	124	402	java/lang/Exception
    //   126	134	402	java/lang/Exception
    //   136	144	402	java/lang/Exception
    //   146	153	402	java/lang/Exception
    //   158	163	402	java/lang/Exception
    //   165	172	402	java/lang/Exception
    //   177	182	402	java/lang/Exception
    //   184	191	402	java/lang/Exception
    //   196	201	402	java/lang/Exception
    //   203	210	402	java/lang/Exception
    //   215	220	402	java/lang/Exception
    //   222	230	402	java/lang/Exception
    //   232	236	402	java/lang/Exception
    //   238	247	402	java/lang/Exception
    //   258	263	402	java/lang/Exception
    //   268	273	402	java/lang/Exception
    //   278	283	402	java/lang/Exception
    //   288	293	402	java/lang/Exception
    //   298	303	402	java/lang/Exception
    //   308	313	402	java/lang/Exception
    //   318	323	402	java/lang/Exception
    //   328	333	402	java/lang/Exception
    //   338	343	402	java/lang/Exception
  }
  
  public String toDebugString()
  {
    return "MessageForTroopStory{doodleUrl='" + this.doodleUrl + '\'' + ", uid=" + this.uid + ", unionId='" + this.unionId + '\'' + ", storyId='" + this.storyId + '\'' + ", md5='" + this.md5 + '\'' + ", thumbUrl='" + this.thumbUrl + '\'' + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", sourceName='" + this.sourceName + '\'' + ", sourceActionType='" + this.sourceActionType + '\'' + ", sourceActionData='" + this.sourceActionData + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopStory
 * JD-Core Version:    0.7.0.1
 */