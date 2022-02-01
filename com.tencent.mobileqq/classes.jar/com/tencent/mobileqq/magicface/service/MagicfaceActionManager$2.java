package com.tencent.mobileqq.magicface.service;

class MagicfaceActionManager$2
  implements Runnable
{
  MagicfaceActionManager$2(MagicfaceActionManager paramMagicfaceActionManager, int paramInt1, int paramInt2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   4: getfield 32	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:c	Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +31 -> 40
    //   12: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +11 -> 26
    //   18: ldc 40
    //   20: iconst_2
    //   21: ldc 42
    //   23: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_0
    //   27: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   30: astore_2
    //   31: aload_2
    //   32: aload_2
    //   33: getfield 49	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   36: invokevirtual 52	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:b	(Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   39: return
    //   40: aload_0
    //   41: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   44: aload_0
    //   45: getfield 17	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:a	I
    //   48: invokevirtual 55	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(I)V
    //   51: aconst_null
    //   52: astore_2
    //   53: aload_0
    //   54: getfield 19	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:b	I
    //   57: ifne +19 -> 76
    //   60: aload_0
    //   61: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   64: getfield 58	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader	Lcom/tencent/mobileqq/magicface/model/MagicfaceResLoader;
    //   67: ldc 60
    //   69: invokevirtual 65	com/tencent/mobileqq/magicface/model/MagicfaceResLoader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_2
    //   73: goto +24 -> 97
    //   76: aload_0
    //   77: getfield 19	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:b	I
    //   80: iconst_1
    //   81: if_icmpne +16 -> 97
    //   84: aload_0
    //   85: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   88: getfield 58	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader	Lcom/tencent/mobileqq/magicface/model/MagicfaceResLoader;
    //   91: ldc 67
    //   93: invokevirtual 65	com/tencent/mobileqq/magicface/model/MagicfaceResLoader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   96: astore_2
    //   97: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +11 -> 111
    //   103: ldc 40
    //   105: iconst_2
    //   106: ldc 69
    //   108: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_2
    //   112: ifnull +188 -> 300
    //   115: aload_0
    //   116: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   119: aload_0
    //   120: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   123: getfield 72	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder	Lcom/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder;
    //   126: aload_2
    //   127: invokevirtual 77	com/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   130: putfield 49	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   133: aload_0
    //   134: getfield 19	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:b	I
    //   137: iconst_1
    //   138: if_icmpne +10 -> 148
    //   141: aload_0
    //   142: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   145: invokevirtual 80	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:e	()V
    //   148: aload_0
    //   149: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   152: aload_0
    //   153: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   156: getfield 49	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   159: invokevirtual 82	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:a	(Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   162: aload_0
    //   163: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   166: aload_0
    //   167: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   170: getfield 72	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder	Lcom/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder;
    //   173: aload_2
    //   174: invokevirtual 85	com/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder:a	(Ljava/lang/String;)Ljava/util/List;
    //   177: putfield 88	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   180: aload_0
    //   181: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   184: invokevirtual 90	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:d	()V
    //   187: aload_0
    //   188: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   191: getfield 88	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   194: invokeinterface 96 1 0
    //   199: astore_2
    //   200: aload_2
    //   201: invokeinterface 101 1 0
    //   206: ifeq +94 -> 300
    //   209: aload_2
    //   210: invokeinterface 105 1 0
    //   215: checkcast 107	com/tencent/mobileqq/magicface/magicfaceaction/Action
    //   218: astore_3
    //   219: aload_0
    //   220: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   223: aload_3
    //   224: putfield 110	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction	Lcom/tencent/mobileqq/magicface/magicfaceaction/Action;
    //   227: aload_3
    //   228: aload_0
    //   229: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   232: getfield 113	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager	Lcom/tencent/mobileqq/magicface/service/MagicfacePlayManager;
    //   235: putfield 114	com/tencent/mobileqq/magicface/magicfaceaction/Action:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager	Lcom/tencent/mobileqq/magicface/service/MagicfacePlayManager;
    //   238: aload_3
    //   239: aload_0
    //   240: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   243: getfield 49	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   246: putfield 115	com/tencent/mobileqq/magicface/magicfaceaction/Action:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   249: aload_3
    //   250: invokevirtual 117	com/tencent/mobileqq/magicface/magicfaceaction/Action:a	()Z
    //   253: istore_1
    //   254: aload_0
    //   255: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   258: getfield 119	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:b	Z
    //   261: ifeq +6 -> 267
    //   264: goto +36 -> 300
    //   267: aload_3
    //   268: getfield 121	com/tencent/mobileqq/magicface/magicfaceaction/Action:d	Z
    //   271: ifeq +13 -> 284
    //   274: aload_0
    //   275: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   278: invokevirtual 123	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:c	()V
    //   281: goto +19 -> 300
    //   284: iload_1
    //   285: ifeq +15 -> 300
    //   288: aload_0
    //   289: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   292: getfield 119	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:b	Z
    //   295: istore_1
    //   296: iload_1
    //   297: ifeq -97 -> 200
    //   300: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq +65 -> 368
    //   306: goto +54 -> 360
    //   309: astore_2
    //   310: goto +72 -> 382
    //   313: astore_2
    //   314: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +37 -> 354
    //   320: new 125	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   327: astore_3
    //   328: aload_3
    //   329: ldc 128
    //   331: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_3
    //   336: aload_2
    //   337: invokevirtual 136	java/lang/Exception:toString	()Ljava/lang/String;
    //   340: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: ldc 40
    //   346: iconst_2
    //   347: aload_3
    //   348: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +11 -> 368
    //   360: ldc 40
    //   362: iconst_2
    //   363: ldc 42
    //   365: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: aload_0
    //   369: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   372: astore_2
    //   373: aload_2
    //   374: aload_2
    //   375: getfield 49	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   378: invokevirtual 52	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:b	(Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   381: return
    //   382: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +11 -> 396
    //   388: ldc 40
    //   390: iconst_2
    //   391: ldc 42
    //   393: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: aload_0
    //   397: getfield 15	com/tencent/mobileqq/magicface/service/MagicfaceActionManager$2:this$0	Lcom/tencent/mobileqq/magicface/service/MagicfaceActionManager;
    //   400: astore_3
    //   401: aload_3
    //   402: aload_3
    //   403: getfield 49	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   406: invokevirtual 52	com/tencent/mobileqq/magicface/service/MagicfaceActionManager:b	(Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   409: goto +5 -> 414
    //   412: aload_2
    //   413: athrow
    //   414: goto -2 -> 412
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	this	2
    //   7	290	1	bool	boolean
    //   30	180	2	localObject1	Object
    //   309	1	2	localObject2	Object
    //   313	24	2	localException	java.lang.Exception
    //   372	41	2	localMagicfaceActionManager	MagicfaceActionManager
    //   218	185	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	309	finally
    //   40	51	309	finally
    //   53	73	309	finally
    //   76	97	309	finally
    //   97	111	309	finally
    //   115	148	309	finally
    //   148	200	309	finally
    //   200	264	309	finally
    //   267	281	309	finally
    //   288	296	309	finally
    //   314	354	309	finally
    //   0	8	313	java/lang/Exception
    //   40	51	313	java/lang/Exception
    //   53	73	313	java/lang/Exception
    //   76	97	313	java/lang/Exception
    //   97	111	313	java/lang/Exception
    //   115	148	313	java/lang/Exception
    //   148	200	313	java/lang/Exception
    //   200	264	313	java/lang/Exception
    //   267	281	313	java/lang/Exception
    //   288	296	313	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfaceActionManager.2
 * JD-Core Version:    0.7.0.1
 */