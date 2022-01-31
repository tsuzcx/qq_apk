package cooperation.qzone;

import bgzi;

public class QzoneGiftFullScreenActionManager$1
  implements Runnable
{
  public QzoneGiftFullScreenActionManager$1(bgzi parambgzi, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   4: getfield 29	bgzi:c	Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +18 -> 27
    //   12: aload_0
    //   13: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   16: aload_0
    //   17: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   20: getfield 32	bgzi:jdField_a_of_type_Ascp	Lascp;
    //   23: invokestatic 36	bgzi:b	(Lbgzi;Lascp;)V
    //   26: return
    //   27: aload_0
    //   28: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   31: aload_0
    //   32: getfield 16	cooperation/qzone/QzoneGiftFullScreenActionManager$1:a	Ljava/lang/String;
    //   35: invokestatic 38	bgzi:a	(Lbgzi;Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   42: getfield 41	bgzi:jdField_a_of_type_Asde	Lasde;
    //   45: ldc 43
    //   47: invokevirtual 48	asde:a	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +144 -> 196
    //   55: aload_0
    //   56: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   59: aload_0
    //   60: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   63: getfield 51	bgzi:jdField_a_of_type_Ascs	Lascs;
    //   66: aload_3
    //   67: invokevirtual 56	ascs:a	(Ljava/lang/String;)Lascp;
    //   70: putfield 32	bgzi:jdField_a_of_type_Ascp	Lascp;
    //   73: aload_0
    //   74: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   77: aload_0
    //   78: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   81: getfield 32	bgzi:jdField_a_of_type_Ascp	Lascp;
    //   84: invokestatic 58	bgzi:a	(Lbgzi;Lascp;)V
    //   87: aload_0
    //   88: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   91: aload_0
    //   92: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   95: getfield 51	bgzi:jdField_a_of_type_Ascs	Lascs;
    //   98: aload_3
    //   99: invokevirtual 61	ascs:a	(Ljava/lang/String;)Ljava/util/List;
    //   102: putfield 64	bgzi:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   105: aload_0
    //   106: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   109: invokestatic 67	bgzi:a	(Lbgzi;)V
    //   112: aload_0
    //   113: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   116: getfield 64	bgzi:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   119: invokeinterface 73 1 0
    //   124: astore_3
    //   125: aload_3
    //   126: invokeinterface 79 1 0
    //   131: ifeq +65 -> 196
    //   134: aload_3
    //   135: invokeinterface 83 1 0
    //   140: checkcast 85	ascn
    //   143: astore 4
    //   145: aload_0
    //   146: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   149: aload 4
    //   151: putfield 88	bgzi:jdField_a_of_type_Ascn	Lascn;
    //   154: aload 4
    //   156: aload_0
    //   157: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   160: getfield 91	bgzi:jdField_a_of_type_Asdp	Lasdp;
    //   163: putfield 92	ascn:jdField_a_of_type_Asdp	Lasdp;
    //   166: aload 4
    //   168: aload_0
    //   169: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   172: getfield 32	bgzi:jdField_a_of_type_Ascp	Lascp;
    //   175: putfield 93	ascn:jdField_a_of_type_Ascp	Lascp;
    //   178: aload 4
    //   180: invokevirtual 95	ascn:a	()Z
    //   183: istore_1
    //   184: aload_0
    //   185: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   188: getfield 97	bgzi:b	Z
    //   191: istore_2
    //   192: iload_2
    //   193: ifeq +18 -> 211
    //   196: aload_0
    //   197: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   200: aload_0
    //   201: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   204: getfield 32	bgzi:jdField_a_of_type_Ascp	Lascp;
    //   207: invokestatic 36	bgzi:b	(Lbgzi;Lascp;)V
    //   210: return
    //   211: iload_1
    //   212: ifeq -16 -> 196
    //   215: aload_0
    //   216: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   219: getfield 97	bgzi:b	Z
    //   222: istore_1
    //   223: iload_1
    //   224: ifeq -99 -> 125
    //   227: goto -31 -> 196
    //   230: astore_3
    //   231: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq +31 -> 265
    //   237: ldc 104
    //   239: iconst_2
    //   240: new 106	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   247: ldc 109
    //   249: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_3
    //   253: invokevirtual 117	java/lang/Exception:toString	()Ljava/lang/String;
    //   256: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload_0
    //   266: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   269: aload_0
    //   270: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   273: getfield 32	bgzi:jdField_a_of_type_Ascp	Lascp;
    //   276: invokestatic 36	bgzi:b	(Lbgzi;Lascp;)V
    //   279: return
    //   280: astore_3
    //   281: aload_0
    //   282: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   285: aload_0
    //   286: getfield 14	cooperation/qzone/QzoneGiftFullScreenActionManager$1:this$0	Lbgzi;
    //   289: getfield 32	bgzi:jdField_a_of_type_Ascp	Lascp;
    //   292: invokestatic 36	bgzi:b	(Lbgzi;Lascp;)V
    //   295: aload_3
    //   296: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	1
    //   7	217	1	bool1	boolean
    //   191	2	2	bool2	boolean
    //   50	85	3	localObject1	Object
    //   230	23	3	localException	java.lang.Exception
    //   280	16	3	localObject2	Object
    //   143	36	4	localascn	ascn
    // Exception table:
    //   from	to	target	type
    //   0	8	230	java/lang/Exception
    //   27	51	230	java/lang/Exception
    //   55	125	230	java/lang/Exception
    //   125	192	230	java/lang/Exception
    //   215	223	230	java/lang/Exception
    //   0	8	280	finally
    //   27	51	280	finally
    //   55	125	280	finally
    //   125	192	280	finally
    //   215	223	280	finally
    //   231	265	280	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenActionManager.1
 * JD-Core Version:    0.7.0.1
 */