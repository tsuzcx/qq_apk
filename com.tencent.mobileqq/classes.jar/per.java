import com.tencent.chirp.PcmPlayer;

public class per
  extends Thread
{
  public volatile boolean a;
  
  private per(PcmPlayer paramPcmPlayer)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: iconst_2
    //   3: istore_2
    //   4: new 25	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   12: invokestatic 30	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Ljava/lang/String;
    //   15: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 5
    //   20: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +32 -> 55
    //   26: ldc 41
    //   28: iconst_2
    //   29: new 43	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   36: ldc 46
    //   38: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload 5
    //   43: invokevirtual 54	java/io/File:length	()J
    //   46: invokevirtual 57	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload 5
    //   57: invokevirtual 68	java/io/File:exists	()Z
    //   60: ifne +36 -> 96
    //   63: aload_0
    //   64: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   67: invokestatic 71	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   70: ifnull +16 -> 86
    //   73: aload_0
    //   74: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   77: invokestatic 71	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   80: iconst_1
    //   81: invokeinterface 77 2 0
    //   86: aload_0
    //   87: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   90: aconst_null
    //   91: invokestatic 80	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Lper;)Lper;
    //   94: pop
    //   95: return
    //   96: aload_0
    //   97: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   100: invokestatic 83	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)I
    //   103: newarray byte
    //   105: astore 4
    //   107: new 85	java/io/FileInputStream
    //   110: dup
    //   111: aload 5
    //   113: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   116: astore 5
    //   118: new 90	java/io/BufferedInputStream
    //   121: dup
    //   122: aload 5
    //   124: invokespecial 93	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   127: astore 6
    //   129: aload_0
    //   130: getfield 16	per:jdField_a_of_type_Boolean	Z
    //   133: ifeq +19 -> 152
    //   136: aload 6
    //   138: aload 4
    //   140: iconst_0
    //   141: aload 4
    //   143: arraylength
    //   144: invokevirtual 97	java/io/BufferedInputStream:read	([BII)I
    //   147: istore_3
    //   148: iload_3
    //   149: ifgt +56 -> 205
    //   152: aload_0
    //   153: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   156: invokestatic 100	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   159: invokevirtual 105	android/media/AudioTrack:stop	()V
    //   162: aload 5
    //   164: ifnull +8 -> 172
    //   167: aload 5
    //   169: invokevirtual 108	java/io/FileInputStream:close	()V
    //   172: aload_0
    //   173: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   176: invokestatic 71	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   179: ifnull +16 -> 195
    //   182: aload_0
    //   183: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   186: invokestatic 71	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   189: iconst_0
    //   190: invokeinterface 77 2 0
    //   195: aload_0
    //   196: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   199: aconst_null
    //   200: invokestatic 80	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Lper;)Lper;
    //   203: pop
    //   204: return
    //   205: aload_0
    //   206: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   209: invokestatic 100	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   212: aload 4
    //   214: iconst_0
    //   215: iload_3
    //   216: invokevirtual 111	android/media/AudioTrack:write	([BII)I
    //   219: pop
    //   220: goto -91 -> 129
    //   223: astore 4
    //   225: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +13 -> 241
    //   231: ldc 41
    //   233: iconst_2
    //   234: ldc 113
    //   236: aload 4
    //   238: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload_0
    //   242: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   245: invokestatic 100	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   248: invokevirtual 105	android/media/AudioTrack:stop	()V
    //   251: aload 5
    //   253: ifnull +8 -> 261
    //   256: aload 5
    //   258: invokevirtual 108	java/io/FileInputStream:close	()V
    //   261: aload_0
    //   262: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   265: invokestatic 71	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   268: ifnull +16 -> 284
    //   271: aload_0
    //   272: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   275: invokestatic 71	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   278: iconst_2
    //   279: invokeinterface 77 2 0
    //   284: aload_0
    //   285: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   288: aconst_null
    //   289: invokestatic 80	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Lper;)Lper;
    //   292: pop
    //   293: return
    //   294: astore 4
    //   296: aconst_null
    //   297: astore 5
    //   299: iconst_0
    //   300: istore_1
    //   301: aload_0
    //   302: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   305: invokestatic 100	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   308: invokevirtual 105	android/media/AudioTrack:stop	()V
    //   311: aload 5
    //   313: ifnull +8 -> 321
    //   316: aload 5
    //   318: invokevirtual 108	java/io/FileInputStream:close	()V
    //   321: aload_0
    //   322: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   325: invokestatic 71	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   328: ifnull +26 -> 354
    //   331: aload_0
    //   332: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   335: invokestatic 71	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   338: astore 5
    //   340: iload_1
    //   341: ifeq +25 -> 366
    //   344: iload_2
    //   345: istore_1
    //   346: aload 5
    //   348: iload_1
    //   349: invokeinterface 77 2 0
    //   354: aload_0
    //   355: getfield 11	per:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   358: aconst_null
    //   359: invokestatic 80	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Lper;)Lper;
    //   362: pop
    //   363: aload 4
    //   365: athrow
    //   366: iconst_0
    //   367: istore_1
    //   368: goto -22 -> 346
    //   371: astore 4
    //   373: goto -201 -> 172
    //   376: astore 4
    //   378: goto -117 -> 261
    //   381: astore 5
    //   383: goto -62 -> 321
    //   386: astore 4
    //   388: iconst_0
    //   389: istore_1
    //   390: goto -89 -> 301
    //   393: astore 4
    //   395: goto -94 -> 301
    //   398: astore 4
    //   400: aconst_null
    //   401: astore 5
    //   403: goto -178 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	per
    //   1	389	1	i	int
    //   3	342	2	j	int
    //   147	69	3	k	int
    //   105	108	4	arrayOfByte	byte[]
    //   223	14	4	localException1	java.lang.Exception
    //   294	70	4	localObject1	java.lang.Object
    //   371	1	4	localException2	java.lang.Exception
    //   376	1	4	localException3	java.lang.Exception
    //   386	1	4	localObject2	java.lang.Object
    //   393	1	4	localObject3	java.lang.Object
    //   398	1	4	localException4	java.lang.Exception
    //   18	329	5	localObject4	java.lang.Object
    //   381	1	5	localException5	java.lang.Exception
    //   401	1	5	localObject5	java.lang.Object
    //   127	10	6	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   118	129	223	java/lang/Exception
    //   129	148	223	java/lang/Exception
    //   205	220	223	java/lang/Exception
    //   107	118	294	finally
    //   167	172	371	java/lang/Exception
    //   256	261	376	java/lang/Exception
    //   316	321	381	java/lang/Exception
    //   118	129	386	finally
    //   129	148	386	finally
    //   205	220	386	finally
    //   225	241	393	finally
    //   107	118	398	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     per
 * JD-Core Version:    0.7.0.1
 */