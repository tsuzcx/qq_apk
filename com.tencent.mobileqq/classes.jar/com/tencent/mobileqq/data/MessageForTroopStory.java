package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.HardCodeUtil;

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
  public static final String MSG_CONTENT = HardCodeUtil.a(2131904464);
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
    //   1: getstatic 76	com/tencent/mobileqq/data/MessageForTroopStory:MSG_CONTENT	Ljava/lang/String;
    //   4: putfield 88	com/tencent/mobileqq/data/MessageForTroopStory:msg	Ljava/lang/String;
    //   7: new 90	java/io/ObjectInputStream
    //   10: dup
    //   11: new 92	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: getfield 96	com/tencent/mobileqq/data/MessageForTroopStory:msgData	[B
    //   19: invokespecial 99	java/io/ByteArrayInputStream:<init>	([B)V
    //   22: invokespecial 102	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore_2
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 106	java/io/ObjectInputStream:readLong	()J
    //   33: putfield 108	com/tencent/mobileqq/data/MessageForTroopStory:uid	J
    //   36: aload_1
    //   37: astore_2
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 112	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   43: putfield 114	com/tencent/mobileqq/data/MessageForTroopStory:unionId	Ljava/lang/String;
    //   46: aload_1
    //   47: astore_2
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 112	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   53: putfield 116	com/tencent/mobileqq/data/MessageForTroopStory:storyId	Ljava/lang/String;
    //   56: aload_1
    //   57: astore_2
    //   58: aload_0
    //   59: aload_1
    //   60: invokevirtual 112	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   63: putfield 118	com/tencent/mobileqq/data/MessageForTroopStory:md5	Ljava/lang/String;
    //   66: aload_1
    //   67: astore_2
    //   68: aload_0
    //   69: aload_1
    //   70: invokevirtual 112	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   73: putfield 120	com/tencent/mobileqq/data/MessageForTroopStory:thumbUrl	Ljava/lang/String;
    //   76: aload_1
    //   77: astore_2
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 112	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   83: putfield 122	com/tencent/mobileqq/data/MessageForTroopStory:doodleUrl	Ljava/lang/String;
    //   86: aload_1
    //   87: astore_2
    //   88: aload_0
    //   89: aload_1
    //   90: invokevirtual 126	java/io/ObjectInputStream:readInt	()I
    //   93: putfield 128	com/tencent/mobileqq/data/MessageForTroopStory:videoWidth	I
    //   96: aload_1
    //   97: astore_2
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 126	java/io/ObjectInputStream:readInt	()I
    //   103: putfield 130	com/tencent/mobileqq/data/MessageForTroopStory:videoHeight	I
    //   106: aload_1
    //   107: astore_2
    //   108: aload_0
    //   109: aload_1
    //   110: invokevirtual 112	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   113: putfield 132	com/tencent/mobileqq/data/MessageForTroopStory:sourceName	Ljava/lang/String;
    //   116: aload_1
    //   117: astore_2
    //   118: aload_0
    //   119: aload_1
    //   120: invokevirtual 112	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   123: putfield 134	com/tencent/mobileqq/data/MessageForTroopStory:sourceActionType	Ljava/lang/String;
    //   126: aload_1
    //   127: astore_2
    //   128: aload_0
    //   129: aload_1
    //   130: invokevirtual 112	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   133: putfield 136	com/tencent/mobileqq/data/MessageForTroopStory:sourceActionData	Ljava/lang/String;
    //   136: aload_1
    //   137: astore_2
    //   138: aload_0
    //   139: aload_1
    //   140: invokevirtual 112	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   143: putfield 138	com/tencent/mobileqq/data/MessageForTroopStory:compatibleText	Ljava/lang/String;
    //   146: aload_1
    //   147: astore_2
    //   148: aload_0
    //   149: aload_1
    //   150: invokevirtual 141	java/io/ObjectInputStream:read	()I
    //   153: putfield 143	com/tencent/mobileqq/data/MessageForTroopStory:ctrVersion	I
    //   156: aload_1
    //   157: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   160: return
    //   161: astore_3
    //   162: goto +12 -> 174
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_2
    //   168: goto +34 -> 202
    //   171: astore_3
    //   172: aconst_null
    //   173: astore_1
    //   174: aload_1
    //   175: astore_2
    //   176: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +14 -> 193
    //   182: aload_1
    //   183: astore_2
    //   184: ldc 51
    //   186: iconst_2
    //   187: ldc 154
    //   189: aload_3
    //   190: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   193: aload_1
    //   194: ifnull +6 -> 200
    //   197: goto -41 -> 156
    //   200: return
    //   201: astore_1
    //   202: aload_2
    //   203: ifnull +7 -> 210
    //   206: aload_2
    //   207: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   210: goto +5 -> 215
    //   213: aload_1
    //   214: athrow
    //   215: goto -2 -> 213
    //   218: astore_1
    //   219: return
    //   220: astore_2
    //   221: goto -11 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	MessageForTroopStory
    //   25	132	1	localObjectInputStream	java.io.ObjectInputStream
    //   165	1	1	localObject1	java.lang.Object
    //   173	21	1	localObject2	java.lang.Object
    //   201	13	1	localObject3	java.lang.Object
    //   218	1	1	localIOException1	java.io.IOException
    //   27	180	2	localObject4	java.lang.Object
    //   220	1	2	localIOException2	java.io.IOException
    //   161	1	3	localException1	java.lang.Exception
    //   171	19	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   28	36	161	java/lang/Exception
    //   38	46	161	java/lang/Exception
    //   48	56	161	java/lang/Exception
    //   58	66	161	java/lang/Exception
    //   68	76	161	java/lang/Exception
    //   78	86	161	java/lang/Exception
    //   88	96	161	java/lang/Exception
    //   98	106	161	java/lang/Exception
    //   108	116	161	java/lang/Exception
    //   118	126	161	java/lang/Exception
    //   128	136	161	java/lang/Exception
    //   138	146	161	java/lang/Exception
    //   148	156	161	java/lang/Exception
    //   7	26	165	finally
    //   7	26	171	java/lang/Exception
    //   28	36	201	finally
    //   38	46	201	finally
    //   48	56	201	finally
    //   58	66	201	finally
    //   68	76	201	finally
    //   78	86	201	finally
    //   88	96	201	finally
    //   98	106	201	finally
    //   108	116	201	finally
    //   118	126	201	finally
    //   128	136	201	finally
    //   138	146	201	finally
    //   148	156	201	finally
    //   176	182	201	finally
    //   184	193	201	finally
    //   156	160	218	java/io/IOException
    //   206	210	220	java/io/IOException
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
    //   0: new 168	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 169	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_1
    //   13: new 171	java/io/ObjectOutputStream
    //   16: dup
    //   17: aload 4
    //   19: invokespecial 174	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_2
    //   23: aload_2
    //   24: aload_0
    //   25: getfield 108	com/tencent/mobileqq/data/MessageForTroopStory:uid	J
    //   28: invokevirtual 178	java/io/ObjectOutputStream:writeLong	(J)V
    //   31: aload_0
    //   32: getfield 114	com/tencent/mobileqq/data/MessageForTroopStory:unionId	Ljava/lang/String;
    //   35: astore_1
    //   36: ldc 180
    //   38: astore_3
    //   39: aload_1
    //   40: ifnonnull +9 -> 49
    //   43: ldc 180
    //   45: astore_1
    //   46: goto +8 -> 54
    //   49: aload_0
    //   50: getfield 114	com/tencent/mobileqq/data/MessageForTroopStory:unionId	Ljava/lang/String;
    //   53: astore_1
    //   54: aload_2
    //   55: aload_1
    //   56: invokevirtual 184	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 116	com/tencent/mobileqq/data/MessageForTroopStory:storyId	Ljava/lang/String;
    //   63: ifnonnull +9 -> 72
    //   66: ldc 180
    //   68: astore_1
    //   69: goto +8 -> 77
    //   72: aload_0
    //   73: getfield 116	com/tencent/mobileqq/data/MessageForTroopStory:storyId	Ljava/lang/String;
    //   76: astore_1
    //   77: aload_2
    //   78: aload_1
    //   79: invokevirtual 184	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: getfield 118	com/tencent/mobileqq/data/MessageForTroopStory:md5	Ljava/lang/String;
    //   86: ifnonnull +9 -> 95
    //   89: ldc 180
    //   91: astore_1
    //   92: goto +8 -> 100
    //   95: aload_0
    //   96: getfield 118	com/tencent/mobileqq/data/MessageForTroopStory:md5	Ljava/lang/String;
    //   99: astore_1
    //   100: aload_2
    //   101: aload_1
    //   102: invokevirtual 184	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 120	com/tencent/mobileqq/data/MessageForTroopStory:thumbUrl	Ljava/lang/String;
    //   109: ifnonnull +9 -> 118
    //   112: ldc 180
    //   114: astore_1
    //   115: goto +8 -> 123
    //   118: aload_0
    //   119: getfield 120	com/tencent/mobileqq/data/MessageForTroopStory:thumbUrl	Ljava/lang/String;
    //   122: astore_1
    //   123: aload_2
    //   124: aload_1
    //   125: invokevirtual 184	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   128: aload_0
    //   129: getfield 122	com/tencent/mobileqq/data/MessageForTroopStory:doodleUrl	Ljava/lang/String;
    //   132: ifnonnull +9 -> 141
    //   135: ldc 180
    //   137: astore_1
    //   138: goto +8 -> 146
    //   141: aload_0
    //   142: getfield 122	com/tencent/mobileqq/data/MessageForTroopStory:doodleUrl	Ljava/lang/String;
    //   145: astore_1
    //   146: aload_2
    //   147: aload_1
    //   148: invokevirtual 184	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   151: aload_2
    //   152: aload_0
    //   153: getfield 128	com/tencent/mobileqq/data/MessageForTroopStory:videoWidth	I
    //   156: invokevirtual 188	java/io/ObjectOutputStream:writeInt	(I)V
    //   159: aload_2
    //   160: aload_0
    //   161: getfield 130	com/tencent/mobileqq/data/MessageForTroopStory:videoHeight	I
    //   164: invokevirtual 188	java/io/ObjectOutputStream:writeInt	(I)V
    //   167: aload_0
    //   168: getfield 132	com/tencent/mobileqq/data/MessageForTroopStory:sourceName	Ljava/lang/String;
    //   171: ifnonnull +9 -> 180
    //   174: ldc 180
    //   176: astore_1
    //   177: goto +8 -> 185
    //   180: aload_0
    //   181: getfield 132	com/tencent/mobileqq/data/MessageForTroopStory:sourceName	Ljava/lang/String;
    //   184: astore_1
    //   185: aload_2
    //   186: aload_1
    //   187: invokevirtual 184	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   190: aload_0
    //   191: getfield 134	com/tencent/mobileqq/data/MessageForTroopStory:sourceActionType	Ljava/lang/String;
    //   194: ifnonnull +9 -> 203
    //   197: ldc 180
    //   199: astore_1
    //   200: goto +8 -> 208
    //   203: aload_0
    //   204: getfield 134	com/tencent/mobileqq/data/MessageForTroopStory:sourceActionType	Ljava/lang/String;
    //   207: astore_1
    //   208: aload_2
    //   209: aload_1
    //   210: invokevirtual 184	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   213: aload_0
    //   214: getfield 136	com/tencent/mobileqq/data/MessageForTroopStory:sourceActionData	Ljava/lang/String;
    //   217: ifnonnull +9 -> 226
    //   220: ldc 180
    //   222: astore_1
    //   223: goto +8 -> 231
    //   226: aload_0
    //   227: getfield 136	com/tencent/mobileqq/data/MessageForTroopStory:sourceActionData	Ljava/lang/String;
    //   230: astore_1
    //   231: aload_2
    //   232: aload_1
    //   233: invokevirtual 184	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   236: aload_0
    //   237: getfield 138	com/tencent/mobileqq/data/MessageForTroopStory:compatibleText	Ljava/lang/String;
    //   240: ifnonnull +8 -> 248
    //   243: aload_3
    //   244: astore_1
    //   245: goto +8 -> 253
    //   248: aload_0
    //   249: getfield 138	com/tencent/mobileqq/data/MessageForTroopStory:compatibleText	Ljava/lang/String;
    //   252: astore_1
    //   253: aload_2
    //   254: aload_1
    //   255: invokevirtual 184	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   258: aload_2
    //   259: aload_0
    //   260: getfield 143	com/tencent/mobileqq/data/MessageForTroopStory:ctrVersion	I
    //   263: invokevirtual 191	java/io/ObjectOutputStream:write	(I)V
    //   266: aload_2
    //   267: invokevirtual 194	java/io/ObjectOutputStream:flush	()V
    //   270: aload_0
    //   271: aload 4
    //   273: invokevirtual 198	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   276: putfield 96	com/tencent/mobileqq/data/MessageForTroopStory:msgData	[B
    //   279: aload_2
    //   280: invokevirtual 199	java/io/ObjectOutputStream:close	()V
    //   283: return
    //   284: astore_1
    //   285: goto +48 -> 333
    //   288: astore_3
    //   289: goto +16 -> 305
    //   292: astore_3
    //   293: aload_1
    //   294: astore_2
    //   295: aload_3
    //   296: astore_1
    //   297: goto +36 -> 333
    //   300: astore_1
    //   301: aload_3
    //   302: astore_2
    //   303: aload_1
    //   304: astore_3
    //   305: aload_2
    //   306: astore_1
    //   307: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +14 -> 324
    //   313: aload_2
    //   314: astore_1
    //   315: ldc 51
    //   317: iconst_2
    //   318: ldc 201
    //   320: aload_3
    //   321: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   324: aload_2
    //   325: ifnull +7 -> 332
    //   328: aload_2
    //   329: invokevirtual 199	java/io/ObjectOutputStream:close	()V
    //   332: return
    //   333: aload_2
    //   334: ifnull +7 -> 341
    //   337: aload_2
    //   338: invokevirtual 199	java/io/ObjectOutputStream:close	()V
    //   341: aload_1
    //   342: athrow
    //   343: astore_1
    //   344: return
    //   345: astore_2
    //   346: goto -5 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	MessageForTroopStory
    //   12	243	1	str1	String
    //   284	10	1	localObject1	java.lang.Object
    //   296	1	1	localObject2	java.lang.Object
    //   300	4	1	localException1	java.lang.Exception
    //   306	36	1	localObject3	java.lang.Object
    //   343	1	1	localIOException1	java.io.IOException
    //   22	316	2	localObject4	java.lang.Object
    //   345	1	2	localIOException2	java.io.IOException
    //   10	234	3	str2	String
    //   288	1	3	localException2	java.lang.Exception
    //   292	10	3	localObject5	java.lang.Object
    //   304	17	3	localObject6	java.lang.Object
    //   7	265	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   23	36	284	finally
    //   49	54	284	finally
    //   54	66	284	finally
    //   72	77	284	finally
    //   77	89	284	finally
    //   95	100	284	finally
    //   100	112	284	finally
    //   118	123	284	finally
    //   123	135	284	finally
    //   141	146	284	finally
    //   146	174	284	finally
    //   180	185	284	finally
    //   185	197	284	finally
    //   203	208	284	finally
    //   208	220	284	finally
    //   226	231	284	finally
    //   231	243	284	finally
    //   248	253	284	finally
    //   253	279	284	finally
    //   23	36	288	java/lang/Exception
    //   49	54	288	java/lang/Exception
    //   54	66	288	java/lang/Exception
    //   72	77	288	java/lang/Exception
    //   77	89	288	java/lang/Exception
    //   95	100	288	java/lang/Exception
    //   100	112	288	java/lang/Exception
    //   118	123	288	java/lang/Exception
    //   123	135	288	java/lang/Exception
    //   141	146	288	java/lang/Exception
    //   146	174	288	java/lang/Exception
    //   180	185	288	java/lang/Exception
    //   185	197	288	java/lang/Exception
    //   203	208	288	java/lang/Exception
    //   208	220	288	java/lang/Exception
    //   226	231	288	java/lang/Exception
    //   231	243	288	java/lang/Exception
    //   248	253	288	java/lang/Exception
    //   253	279	288	java/lang/Exception
    //   13	23	292	finally
    //   307	313	292	finally
    //   315	324	292	finally
    //   13	23	300	java/lang/Exception
    //   279	283	343	java/io/IOException
    //   328	332	343	java/io/IOException
    //   337	341	345	java/io/IOException
  }
  
  public String toDebugString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MessageForTroopStory{doodleUrl='");
    localStringBuilder.append(this.doodleUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uid=");
    localStringBuilder.append(this.uid);
    localStringBuilder.append(", unionId='");
    localStringBuilder.append(this.unionId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", storyId='");
    localStringBuilder.append(this.storyId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thumbUrl='");
    localStringBuilder.append(this.thumbUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoWidth=");
    localStringBuilder.append(this.videoWidth);
    localStringBuilder.append(", videoHeight=");
    localStringBuilder.append(this.videoHeight);
    localStringBuilder.append(", sourceName='");
    localStringBuilder.append(this.sourceName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sourceActionType='");
    localStringBuilder.append(this.sourceActionType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sourceActionData='");
    localStringBuilder.append(this.sourceActionData);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopStory
 * JD-Core Version:    0.7.0.1
 */