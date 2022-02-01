package com.tencent.mobileqq.tritonaudio.webaudio;

class WebAudioManager$5$1
  implements AudioDecoder.OnDecodeProcessListener
{
  WebAudioManager$5$1(WebAudioManager.5 param5, AudioDecoder paramAudioDecoder) {}
  
  /* Error */
  @androidx.annotation.RequiresApi(api=16)
  public void onDecodeProcess(byte[] paramArrayOfByte, android.media.MediaFormat paramMediaFormat, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 29
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   7: getfield 35	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:this$0	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;
    //   10: invokestatic 39	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager:access$100	(Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;)Ljava/util/HashMap;
    //   13: aload_0
    //   14: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   17: getfield 43	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:val$decodeId	I
    //   20: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: invokevirtual 55	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   26: ifne +41 -> 67
    //   29: aload_0
    //   30: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   33: getfield 35	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:this$0	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;
    //   36: invokestatic 39	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager:access$100	(Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;)Ljava/util/HashMap;
    //   39: aload_0
    //   40: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   43: getfield 43	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:val$decodeId	I
    //   46: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: new 57	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$DecodeAsPlayStatus
    //   52: dup
    //   53: aload_0
    //   54: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   57: getfield 35	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:this$0	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;
    //   60: invokespecial 60	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$DecodeAsPlayStatus:<init>	(Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;)V
    //   63: invokevirtual 64	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: aload_0
    //   68: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   71: getfield 35	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:this$0	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;
    //   74: invokestatic 39	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager:access$100	(Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;)Ljava/util/HashMap;
    //   77: aload_0
    //   78: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   81: getfield 43	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:val$decodeId	I
    //   84: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: invokevirtual 68	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 57	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$DecodeAsPlayStatus
    //   93: astore 7
    //   95: aload_0
    //   96: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   99: getfield 35	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:this$0	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;
    //   102: invokestatic 71	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager:access$200	(Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;)Ljava/util/HashMap;
    //   105: aload_0
    //   106: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   109: getfield 43	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:val$decodeId	I
    //   112: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: invokevirtual 68	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast 73	java/util/ArrayList
    //   121: astore 6
    //   123: aload 6
    //   125: astore_2
    //   126: aload 6
    //   128: ifnonnull +11 -> 139
    //   131: new 73	java/util/ArrayList
    //   134: dup
    //   135: invokespecial 74	java/util/ArrayList:<init>	()V
    //   138: astore_2
    //   139: iload 4
    //   141: ifeq +14 -> 155
    //   144: aload 7
    //   146: iconst_3
    //   147: invokestatic 78	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$DecodeAsPlayStatus:access$302	(Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$DecodeAsPlayStatus;I)I
    //   150: pop
    //   151: ldc 29
    //   153: monitorexit
    //   154: return
    //   155: aload_1
    //   156: aload_0
    //   157: getfield 16	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:val$audioDecoder	Lcom/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder;
    //   160: invokevirtual 84	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:getSampleRate	()I
    //   163: aload_0
    //   164: getfield 16	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:val$audioDecoder	Lcom/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder;
    //   167: invokevirtual 87	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:getChannelCount	()I
    //   170: aload_0
    //   171: getfield 16	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:val$audioDecoder	Lcom/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder;
    //   174: invokevirtual 90	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:getBitsPerChannel	()I
    //   177: invokestatic 96	com/tencent/mobileqq/tritonaudio/webaudio/AudioNativeManager:loadRawData	([BIII)I
    //   180: istore 5
    //   182: aload_2
    //   183: iload 5
    //   185: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: invokevirtual 99	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   191: pop
    //   192: aload_0
    //   193: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   196: getfield 35	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:this$0	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;
    //   199: invokestatic 71	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager:access$200	(Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;)Ljava/util/HashMap;
    //   202: aload_0
    //   203: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   206: getfield 43	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:val$decodeId	I
    //   209: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aload_2
    //   213: invokevirtual 64	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   216: pop
    //   217: aload 7
    //   219: invokestatic 103	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$DecodeAsPlayStatus:access$300	(Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$DecodeAsPlayStatus;)I
    //   222: tableswitch	default:+201 -> 423, 0:+100->322, 1:+26->248, 2:+110->332
    //   249: ifeq +63 -> 312
    //   252: new 105	org/json/JSONObject
    //   255: dup
    //   256: invokespecial 106	org/json/JSONObject:<init>	()V
    //   259: astore_1
    //   260: aload_1
    //   261: ldc 108
    //   263: aload_0
    //   264: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   267: getfield 43	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:val$decodeId	I
    //   270: invokevirtual 111	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   273: pop
    //   274: aload_1
    //   275: ldc 113
    //   277: ldc 115
    //   279: invokevirtual 118	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   282: pop
    //   283: aload_0
    //   284: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   287: getfield 122	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:val$argument	Lcom/tencent/mobileqq/triton/script/Argument;
    //   290: ifnull +22 -> 312
    //   293: aload_0
    //   294: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   297: getfield 122	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:val$argument	Lcom/tencent/mobileqq/triton/script/Argument;
    //   300: ldc 124
    //   302: aload_1
    //   303: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   306: invokeinterface 134 3 0
    //   311: pop
    //   312: ldc 29
    //   314: monitorexit
    //   315: return
    //   316: astore_1
    //   317: ldc 29
    //   319: monitorexit
    //   320: aload_1
    //   321: athrow
    //   322: aload 7
    //   324: iconst_1
    //   325: invokestatic 78	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$DecodeAsPlayStatus:access$302	(Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$DecodeAsPlayStatus;I)I
    //   328: pop
    //   329: goto -81 -> 248
    //   332: aload 7
    //   334: invokestatic 138	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$DecodeAsPlayStatus:access$400	(Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$DecodeAsPlayStatus;)Ljava/util/ArrayList;
    //   337: astore_1
    //   338: aload_1
    //   339: ifnull -91 -> 248
    //   342: aload_1
    //   343: invokevirtual 142	java/util/ArrayList:isEmpty	()Z
    //   346: ifne -98 -> 248
    //   349: aload_1
    //   350: invokevirtual 146	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   353: astore_1
    //   354: aload_1
    //   355: invokeinterface 151 1 0
    //   360: ifeq -112 -> 248
    //   363: aload_1
    //   364: invokeinterface 155 1 0
    //   369: checkcast 45	java/lang/Integer
    //   372: invokevirtual 158	java/lang/Integer:intValue	()I
    //   375: iload 5
    //   377: invokestatic 162	com/tencent/mobileqq/tritonaudio/webaudio/AudioNativeManager:setQueueBuffer	(II)V
    //   380: goto -26 -> 354
    //   383: astore_1
    //   384: aload_0
    //   385: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   388: getfield 35	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:this$0	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;
    //   391: invokestatic 166	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager:access$500	(Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;)Lcom/tencent/mobileqq/triton/utils/LogDelegate;
    //   394: ifnull -82 -> 312
    //   397: aload_0
    //   398: getfield 14	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5$1:this$1	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5;
    //   401: getfield 35	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager$5:this$0	Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;
    //   404: invokestatic 166	com/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager:access$500	(Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;)Lcom/tencent/mobileqq/triton/utils/LogDelegate;
    //   407: getstatic 172	com/tencent/mobileqq/triton/utils/LogDelegate$Level:ERROR	Lcom/tencent/mobileqq/triton/utils/LogDelegate$Level;
    //   410: ldc 174
    //   412: ldc 176
    //   414: aload_1
    //   415: invokeinterface 182 5 0
    //   420: goto -108 -> 312
    //   423: goto -175 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	1
    //   0	426	1	paramArrayOfByte	byte[]
    //   0	426	2	paramMediaFormat	android.media.MediaFormat
    //   0	426	3	paramBoolean1	boolean
    //   0	426	4	paramBoolean2	boolean
    //   180	196	5	i	int
    //   121	6	6	localArrayList	java.util.ArrayList
    //   93	240	7	localDecodeAsPlayStatus	WebAudioManager.DecodeAsPlayStatus
    // Exception table:
    //   from	to	target	type
    //   3	67	316	finally
    //   67	123	316	finally
    //   131	139	316	finally
    //   144	154	316	finally
    //   155	248	316	finally
    //   252	260	316	finally
    //   260	312	316	finally
    //   312	315	316	finally
    //   317	320	316	finally
    //   322	329	316	finally
    //   332	338	316	finally
    //   342	354	316	finally
    //   354	380	316	finally
    //   384	420	316	finally
    //   260	312	383	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.5.1
 * JD-Core Version:    0.7.0.1
 */