package com.tencent.mobileqq.filemanager.core;

class FileIPv6Detecter$1
  implements Runnable
{
  FileIPv6Detecter$1(FileIPv6Detecter paramFileIPv6Detecter, FileIPv6StrateyController.IPInfo paramIPInfo, long paramLong, FileIPv6StrateyController.DomainInfo paramDomainInfo) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 31	java/net/Socket
    //   3: dup
    //   4: invokespecial 32	java/net/Socket:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 18	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6StrateyController$IPInfo	Lcom/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$IPInfo;
    //   13: getfield 37	com/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$IPInfo:jdField_a_of_type_Int	I
    //   16: istore_2
    //   17: iload_2
    //   18: istore_1
    //   19: iload_2
    //   20: ifne +6 -> 26
    //   23: bipush 80
    //   25: istore_1
    //   26: aload 5
    //   28: new 39	java/net/InetSocketAddress
    //   31: dup
    //   32: aload_0
    //   33: getfield 18	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6StrateyController$IPInfo	Lcom/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$IPInfo;
    //   36: invokevirtual 42	com/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$IPInfo:a	()Ljava/lang/String;
    //   39: iload_1
    //   40: invokespecial 45	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   43: sipush 6000
    //   46: invokevirtual 49	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   49: aload 5
    //   51: invokevirtual 52	java/net/Socket:close	()V
    //   54: goto +10 -> 64
    //   57: astore 5
    //   59: aload 5
    //   61: invokevirtual 55	java/lang/Exception:printStackTrace	()V
    //   64: iconst_0
    //   65: istore_1
    //   66: goto +32 -> 98
    //   69: astore 6
    //   71: goto +244 -> 315
    //   74: astore 6
    //   76: aload 6
    //   78: invokevirtual 55	java/lang/Exception:printStackTrace	()V
    //   81: aload 5
    //   83: invokevirtual 52	java/net/Socket:close	()V
    //   86: goto +10 -> 96
    //   89: astore 5
    //   91: aload 5
    //   93: invokevirtual 55	java/lang/Exception:printStackTrace	()V
    //   96: iconst_1
    //   97: istore_1
    //   98: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   101: lstore_3
    //   102: new 63	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   109: astore 5
    //   111: aload 5
    //   113: ldc 66
    //   115: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 5
    //   121: iload_1
    //   122: iconst_1
    //   123: ixor
    //   124: invokevirtual 73	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 5
    //   130: ldc 75
    //   132: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 5
    //   138: lload_3
    //   139: aload_0
    //   140: getfield 20	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:jdField_a_of_type_Long	J
    //   143: lsub
    //   144: invokevirtual 78	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 5
    //   150: ldc 80
    //   152: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 5
    //   158: aload_0
    //   159: getfield 22	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6StrateyController$DomainInfo	Lcom/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$DomainInfo;
    //   162: getfield 85	com/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$DomainInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   165: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 5
    //   171: ldc 87
    //   173: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 5
    //   179: aload_0
    //   180: getfield 22	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6StrateyController$DomainInfo	Lcom/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$DomainInfo;
    //   183: getfield 88	com/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$DomainInfo:jdField_a_of_type_Int	I
    //   186: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 5
    //   192: ldc 93
    //   194: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 5
    //   200: aload_0
    //   201: getfield 18	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6StrateyController$IPInfo	Lcom/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$IPInfo;
    //   204: getfield 94	com/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   207: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 5
    //   213: ldc 87
    //   215: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 5
    //   221: aload_0
    //   222: getfield 18	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6StrateyController$IPInfo	Lcom/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$IPInfo;
    //   225: getfield 37	com/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$IPInfo:jdField_a_of_type_Int	I
    //   228: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 5
    //   234: ldc 96
    //   236: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: ldc 98
    //   242: iconst_1
    //   243: aload 5
    //   245: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_0
    //   252: getfield 16	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:this$0	Lcom/tencent/mobileqq/filemanager/core/FileIPv6Detecter;
    //   255: aload_0
    //   256: getfield 22	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6StrateyController$DomainInfo	Lcom/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$DomainInfo;
    //   259: invokestatic 112	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter:a	(Lcom/tencent/mobileqq/filemanager/core/FileIPv6Detecter;Lcom/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$DomainInfo;)Lcom/tencent/mobileqq/filemanager/core/FileIPv6Detecter$DomainDetectResult;
    //   262: astore 5
    //   264: aload 5
    //   266: ifnull +48 -> 314
    //   269: aload 5
    //   271: iconst_0
    //   272: putfield 118	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$DomainDetectResult:b	Z
    //   275: aload 5
    //   277: iload_1
    //   278: iconst_1
    //   279: ixor
    //   280: putfield 120	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$DomainDetectResult:a	Z
    //   283: aload_0
    //   284: getfield 16	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:this$0	Lcom/tencent/mobileqq/filemanager/core/FileIPv6Detecter;
    //   287: iload_1
    //   288: iconst_1
    //   289: ixor
    //   290: aload_0
    //   291: getfield 22	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6StrateyController$DomainInfo	Lcom/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$DomainInfo;
    //   294: getfield 85	com/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$DomainInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   297: aload_0
    //   298: getfield 18	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6StrateyController$IPInfo	Lcom/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$IPInfo;
    //   301: invokevirtual 42	com/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$IPInfo:a	()Ljava/lang/String;
    //   304: aload_0
    //   305: getfield 18	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter$1:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6StrateyController$IPInfo	Lcom/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$IPInfo;
    //   308: getfield 37	com/tencent/mobileqq/filemanager/core/FileIPv6StrateyController$IPInfo:jdField_a_of_type_Int	I
    //   311: invokestatic 123	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter:a	(Lcom/tencent/mobileqq/filemanager/core/FileIPv6Detecter;ZLjava/lang/String;Ljava/lang/String;I)V
    //   314: return
    //   315: aload 5
    //   317: invokevirtual 52	java/net/Socket:close	()V
    //   320: goto +10 -> 330
    //   323: astore 5
    //   325: aload 5
    //   327: invokevirtual 55	java/lang/Exception:printStackTrace	()V
    //   330: aload 6
    //   332: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	1
    //   18	272	1	i	int
    //   16	4	2	j	int
    //   101	38	3	l	long
    //   7	43	5	localSocket	java.net.Socket
    //   57	25	5	localException1	java.lang.Exception
    //   89	3	5	localException2	java.lang.Exception
    //   109	207	5	localObject1	Object
    //   323	3	5	localException3	java.lang.Exception
    //   69	1	6	localObject2	Object
    //   74	257	6	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   49	54	57	java/lang/Exception
    //   9	17	69	finally
    //   26	49	69	finally
    //   76	81	69	finally
    //   9	17	74	java/lang/Exception
    //   26	49	74	java/lang/Exception
    //   81	86	89	java/lang/Exception
    //   315	320	323	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6Detecter.1
 * JD-Core Version:    0.7.0.1
 */