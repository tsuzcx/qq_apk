package cooperation.qzone;

class QzoneGiftFullScreenActionManager$1
  implements Runnable
{
  QzoneGiftFullScreenActionManager$1(QzoneGiftFullScreenActionManager paramQzoneGiftFullScreenActionManager, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   4: getfield 29	cooperation/qzone/QzoneGiftFullScreenActionManager:isRelease	Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +17 -> 26
    //   12: aload_0
    //   13: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   16: astore_2
    //   17: aload_2
    //   18: aload_2
    //   19: getfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:actionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   22: invokestatic 37	cooperation/qzone/QzoneGiftFullScreenActionManager:access$300	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   25: return
    //   26: aload_0
    //   27: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   30: aload_0
    //   31: getfield 16	cooperation/qzone/QzoneGiftFullScreenActionManager$1:val$path	Ljava/lang/String;
    //   34: invokestatic 40	cooperation/qzone/QzoneGiftFullScreenActionManager:access$000	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   41: getfield 44	cooperation/qzone/QzoneGiftFullScreenActionManager:magicfaceResLoader	Lcom/tencent/mobileqq/magicface/model/MagicfaceResLoader;
    //   44: ldc 46
    //   46: invokevirtual 52	com/tencent/mobileqq/magicface/model/MagicfaceResLoader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +204 -> 255
    //   54: aload_0
    //   55: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   58: aload_0
    //   59: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   62: getfield 56	cooperation/qzone/QzoneGiftFullScreenActionManager:magicfaceActionDecoder	Lcom/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder;
    //   65: aload_2
    //   66: invokevirtual 61	com/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   69: putfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:actionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   72: aload_0
    //   73: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   76: aload_0
    //   77: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   80: getfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:actionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   83: invokestatic 64	cooperation/qzone/QzoneGiftFullScreenActionManager:access$100	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   86: aload_0
    //   87: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   90: aload_0
    //   91: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   94: getfield 56	cooperation/qzone/QzoneGiftFullScreenActionManager:magicfaceActionDecoder	Lcom/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder;
    //   97: aload_2
    //   98: invokevirtual 67	com/tencent/mobileqq/magicface/magicfaceaction/MagicfaceActionDecoder:a	(Ljava/lang/String;)Ljava/util/List;
    //   101: putfield 71	cooperation/qzone/QzoneGiftFullScreenActionManager:magicfaceActions	Ljava/util/List;
    //   104: aload_0
    //   105: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   108: invokestatic 75	cooperation/qzone/QzoneGiftFullScreenActionManager:access$200	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;)V
    //   111: aload_0
    //   112: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   115: getfield 71	cooperation/qzone/QzoneGiftFullScreenActionManager:magicfaceActions	Ljava/util/List;
    //   118: invokeinterface 81 1 0
    //   123: astore_2
    //   124: aload_2
    //   125: invokeinterface 87 1 0
    //   130: ifeq +125 -> 255
    //   133: aload_2
    //   134: invokeinterface 91 1 0
    //   139: checkcast 93	com/tencent/mobileqq/magicface/magicfaceaction/Action
    //   142: astore_3
    //   143: aload_0
    //   144: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   147: aload_3
    //   148: putfield 97	cooperation/qzone/QzoneGiftFullScreenActionManager:currentMagicfaceAction	Lcom/tencent/mobileqq/magicface/magicfaceaction/Action;
    //   151: aload_3
    //   152: aload_0
    //   153: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   156: getfield 101	cooperation/qzone/QzoneGiftFullScreenActionManager:magicfacePlayManager	Lcom/tencent/mobileqq/magicface/service/MagicfacePlayManager;
    //   159: putfield 103	com/tencent/mobileqq/magicface/magicfaceaction/Action:jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager	Lcom/tencent/mobileqq/magicface/service/MagicfacePlayManager;
    //   162: aload_3
    //   163: aload_0
    //   164: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   167: getfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:actionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   170: putfield 105	com/tencent/mobileqq/magicface/magicfaceaction/Action:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   173: aload_3
    //   174: invokevirtual 107	com/tencent/mobileqq/magicface/magicfaceaction/Action:a	()Z
    //   177: istore_1
    //   178: aload_0
    //   179: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   182: getfield 110	cooperation/qzone/QzoneGiftFullScreenActionManager:isShutDown	Z
    //   185: ifeq +6 -> 191
    //   188: goto +67 -> 255
    //   191: iload_1
    //   192: ifeq +63 -> 255
    //   195: aload_0
    //   196: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   199: getfield 110	cooperation/qzone/QzoneGiftFullScreenActionManager:isShutDown	Z
    //   202: istore_1
    //   203: iload_1
    //   204: ifeq -80 -> 124
    //   207: goto +48 -> 255
    //   210: astore_2
    //   211: goto +58 -> 269
    //   214: astore_2
    //   215: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +37 -> 255
    //   221: new 117	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   228: astore_3
    //   229: aload_3
    //   230: ldc 120
    //   232: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_3
    //   237: aload_2
    //   238: invokevirtual 128	java/lang/Exception:toString	()Ljava/lang/String;
    //   241: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: ldc 130
    //   247: iconst_2
    //   248: aload_3
    //   249: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload_0
    //   256: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   259: astore_2
    //   260: aload_2
    //   261: aload_2
    //   262: getfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:actionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   265: invokestatic 37	cooperation/qzone/QzoneGiftFullScreenActionManager:access$300	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   268: return
    //   269: aload_0
    //   270: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lcooperation/qzone/QzoneGiftFullScreenActionManager;
    //   273: astore_3
    //   274: aload_3
    //   275: aload_3
    //   276: getfield 33	cooperation/qzone/QzoneGiftFullScreenActionManager:actionGlobalData	Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   279: invokestatic 37	cooperation/qzone/QzoneGiftFullScreenActionManager:access$300	(Lcooperation/qzone/QzoneGiftFullScreenActionManager;Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   282: goto +5 -> 287
    //   285: aload_2
    //   286: athrow
    //   287: goto -2 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	1
    //   7	197	1	bool	boolean
    //   16	118	2	localObject1	Object
    //   210	1	2	localObject2	Object
    //   214	24	2	localException	java.lang.Exception
    //   259	27	2	localQzoneGiftFullScreenActionManager	QzoneGiftFullScreenActionManager
    //   142	134	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	210	finally
    //   26	50	210	finally
    //   54	124	210	finally
    //   124	188	210	finally
    //   195	203	210	finally
    //   215	255	210	finally
    //   0	8	214	java/lang/Exception
    //   26	50	214	java/lang/Exception
    //   54	124	214	java/lang/Exception
    //   124	188	214	java/lang/Exception
    //   195	203	214	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenActionManager.1
 * JD-Core Version:    0.7.0.1
 */