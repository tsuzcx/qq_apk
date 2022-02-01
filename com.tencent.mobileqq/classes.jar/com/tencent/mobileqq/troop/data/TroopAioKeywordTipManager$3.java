package com.tencent.mobileqq.troop.data;

import java.util.List;

class TroopAioKeywordTipManager$3
  implements Runnable
{
  TroopAioKeywordTipManager$3(TroopAioKeywordTipManager paramTroopAioKeywordTipManager, List paramList1, List paramList2, int paramInt, TroopAioKeywordTipManager.Callback paramCallback) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   4: aload_0
    //   5: getfield 19	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   8: aload_0
    //   9: getfield 21	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:b	Ljava/util/List;
    //   12: aload_0
    //   13: getfield 23	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:jdField_a_of_type_Int	I
    //   16: invokevirtual 35	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:a	(Ljava/util/List;Ljava/util/List;I)Landroid/util/Pair;
    //   19: astore_3
    //   20: aload_3
    //   21: getfield 41	android/util/Pair:second	Ljava/lang/Object;
    //   24: checkcast 43	java/lang/Integer
    //   27: astore_2
    //   28: aload_3
    //   29: getfield 46	android/util/Pair:first	Ljava/lang/Object;
    //   32: checkcast 48	com/tencent/mobileqq/data/MessageRecord
    //   35: astore_3
    //   36: aload_0
    //   37: getfield 25	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$Callback;
    //   40: ifnull +20 -> 60
    //   43: invokestatic 54	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   46: new 56	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3$1
    //   49: dup
    //   50: aload_0
    //   51: aload_3
    //   52: aload_2
    //   53: invokespecial 59	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3$1:<init>	(Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/Integer;)V
    //   56: invokevirtual 65	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   59: pop
    //   60: aload_2
    //   61: ifnull +258 -> 319
    //   64: aload_0
    //   65: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   68: getfield 68	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   71: aload_2
    //   72: invokevirtual 72	java/lang/Integer:intValue	()I
    //   75: invokevirtual 78	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   78: checkcast 80	com/tencent/mobileqq/troop/data/TroopAioKeywordRuleInfo
    //   81: astore 4
    //   83: aload_0
    //   84: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   87: getfield 68	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   90: astore 5
    //   92: aload 5
    //   94: monitorenter
    //   95: aload 4
    //   97: ifnonnull +20 -> 117
    //   100: aload_0
    //   101: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   104: aload_3
    //   105: aconst_null
    //   106: aload_0
    //   107: getfield 25	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$Callback;
    //   110: invokestatic 83	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:a	(Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipInfo;Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$Callback;)V
    //   113: aload 5
    //   115: monitorexit
    //   116: return
    //   117: aload 5
    //   119: monitorexit
    //   120: aload_0
    //   121: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   124: getfield 85	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:b	Landroid/util/SparseArray;
    //   127: astore 5
    //   129: aload 5
    //   131: monitorenter
    //   132: aload_0
    //   133: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   136: getfield 85	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:b	Landroid/util/SparseArray;
    //   139: aload_2
    //   140: invokevirtual 72	java/lang/Integer:intValue	()I
    //   143: invokevirtual 78	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   146: checkcast 87	com/tencent/mobileqq/troop/data/TroopAioKeywordTipInfo
    //   149: astore 6
    //   151: aload 5
    //   153: monitorexit
    //   154: aload 6
    //   156: ifnull +67 -> 223
    //   159: aload 6
    //   161: getfield 90	com/tencent/mobileqq/troop/data/TroopAioKeywordTipInfo:version	I
    //   164: aload 4
    //   166: getfield 93	com/tencent/mobileqq/troop/data/TroopAioKeywordRuleInfo:e	I
    //   169: if_icmpeq +35 -> 204
    //   172: iconst_1
    //   173: istore_1
    //   174: iload_1
    //   175: ifeq +157 -> 332
    //   178: aload_0
    //   179: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   182: aload_2
    //   183: aload_3
    //   184: aload_0
    //   185: getfield 25	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$Callback;
    //   188: invokestatic 96	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:a	(Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;Ljava/lang/Integer;Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$Callback;)V
    //   191: return
    //   192: astore_2
    //   193: aload 5
    //   195: monitorexit
    //   196: aload_2
    //   197: athrow
    //   198: astore_2
    //   199: aload 5
    //   201: monitorexit
    //   202: aload_2
    //   203: athrow
    //   204: aload_0
    //   205: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   208: aload_3
    //   209: aload 6
    //   211: aload_0
    //   212: getfield 25	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$Callback;
    //   215: invokestatic 83	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:a	(Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipInfo;Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$Callback;)V
    //   218: iconst_0
    //   219: istore_1
    //   220: goto -46 -> 174
    //   223: aload_0
    //   224: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   227: getfield 99	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   230: aload_2
    //   231: invokestatic 105	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   234: invokestatic 110	com/tencent/mobileqq/troop/data/TroopAioKeywordHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipInfo;
    //   237: astore 5
    //   239: aload 5
    //   241: ifnull +16 -> 257
    //   244: aload 4
    //   246: getfield 93	com/tencent/mobileqq/troop/data/TroopAioKeywordRuleInfo:e	I
    //   249: aload 5
    //   251: getfield 90	com/tencent/mobileqq/troop/data/TroopAioKeywordTipInfo:version	I
    //   254: if_icmpeq +8 -> 262
    //   257: iconst_1
    //   258: istore_1
    //   259: goto -85 -> 174
    //   262: aload_0
    //   263: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   266: aload_3
    //   267: aload 5
    //   269: aload_0
    //   270: getfield 25	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$Callback;
    //   273: invokestatic 83	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:a	(Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipInfo;Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$Callback;)V
    //   276: aload_0
    //   277: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   280: getfield 85	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:b	Landroid/util/SparseArray;
    //   283: astore 4
    //   285: aload 4
    //   287: monitorenter
    //   288: aload_0
    //   289: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   292: getfield 85	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:b	Landroid/util/SparseArray;
    //   295: aload 5
    //   297: getfield 113	com/tencent/mobileqq/troop/data/TroopAioKeywordTipInfo:ruleId	I
    //   300: aload 5
    //   302: invokevirtual 117	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   305: aload 4
    //   307: monitorexit
    //   308: iconst_0
    //   309: istore_1
    //   310: goto -136 -> 174
    //   313: astore_2
    //   314: aload 4
    //   316: monitorexit
    //   317: aload_2
    //   318: athrow
    //   319: aload_0
    //   320: getfield 17	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:this$0	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;
    //   323: aconst_null
    //   324: aconst_null
    //   325: aload_0
    //   326: getfield 25	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$3:jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback	Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$Callback;
    //   329: invokestatic 83	com/tencent/mobileqq/troop/data/TroopAioKeywordTipManager:a	(Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager;Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipInfo;Lcom/tencent/mobileqq/troop/data/TroopAioKeywordTipManager$Callback;)V
    //   332: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	3
    //   173	137	1	i	int
    //   27	156	2	localInteger	java.lang.Integer
    //   192	5	2	localObject1	Object
    //   198	33	2	localObject2	Object
    //   313	5	2	localObject3	Object
    //   19	248	3	localObject4	Object
    //   149	61	6	localTroopAioKeywordTipInfo	TroopAioKeywordTipInfo
    // Exception table:
    //   from	to	target	type
    //   100	116	192	finally
    //   117	120	192	finally
    //   193	196	192	finally
    //   132	154	198	finally
    //   199	202	198	finally
    //   288	308	313	finally
    //   314	317	313	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.3
 * JD-Core Version:    0.7.0.1
 */