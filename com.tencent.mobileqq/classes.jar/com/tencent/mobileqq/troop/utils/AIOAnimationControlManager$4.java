package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;

class AIOAnimationControlManager$4
  extends DownloadListener
{
  AIOAnimationControlManager$4(AIOAnimationControlManager paramAIOAnimationControlManager) {}
  
  /* Error */
  public void onDone(DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: new 20	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$DownloadGftData
    //   3: dup
    //   4: invokespecial 21	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$DownloadGftData:<init>	()V
    //   7: astore 7
    //   9: aload_1
    //   10: invokevirtual 26	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   13: astore 8
    //   15: aload 8
    //   17: ldc 28
    //   19: invokevirtual 34	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 6
    //   24: aload 8
    //   26: ldc 36
    //   28: invokevirtual 34	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 5
    //   33: aload 8
    //   35: ldc 38
    //   37: invokevirtual 42	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   40: istore_2
    //   41: aload 8
    //   43: ldc 44
    //   45: invokevirtual 48	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   48: istore 4
    //   50: aload 7
    //   52: iconst_1
    //   53: putfield 51	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$DownloadGftData:jdField_a_of_type_Boolean	Z
    //   56: aload 7
    //   58: aload 6
    //   60: putfield 54	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$DownloadGftData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: invokestatic 59	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$DownloadGiftResStateObservable:a	()Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager$DownloadGiftResStateObservable;
    //   66: invokevirtual 62	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$DownloadGiftResStateObservable:setChanged	()V
    //   69: invokestatic 59	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$DownloadGiftResStateObservable:a	()Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager$DownloadGiftResStateObservable;
    //   72: aload 7
    //   74: invokevirtual 66	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$DownloadGiftResStateObservable:notifyObservers	(Ljava/lang/Object;)V
    //   77: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +54 -> 134
    //   83: new 74	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   90: astore 7
    //   92: aload 7
    //   94: ldc 77
    //   96: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 7
    //   102: aload 6
    //   104: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 7
    //   110: ldc 83
    //   112: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 7
    //   118: aload_1
    //   119: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: ldc 88
    //   125: iconst_2
    //   126: aload 7
    //   128: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aconst_null
    //   135: ldc 98
    //   137: ldc 98
    //   139: ldc 100
    //   141: ldc 102
    //   143: ldc 104
    //   145: iconst_0
    //   146: aload_1
    //   147: getfield 107	com/tencent/mobileqq/vip/DownloadTask:a	I
    //   150: aload 6
    //   152: ldc 100
    //   154: ldc 100
    //   156: ldc 100
    //   158: invokestatic 113	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_1
    //   162: getfield 107	com/tencent/mobileqq/vip/DownloadTask:a	I
    //   165: ifne +133 -> 298
    //   168: new 115	java/io/File
    //   171: dup
    //   172: aload 6
    //   174: iload_2
    //   175: iload 4
    //   177: invokestatic 120	com/tencent/mobileqq/troop/utils/TroopGiftUtil:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   180: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 126	java/io/File:exists	()Z
    //   188: ifeq +66 -> 254
    //   191: aload_1
    //   192: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   195: ldc 131
    //   197: ldc 133
    //   199: invokevirtual 139	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   202: astore 7
    //   204: aload_1
    //   205: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   208: aload 7
    //   210: iconst_0
    //   211: invokestatic 145	com/tencent/mobileqq/utils/FileUtils:uncompressZip	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   214: aload_1
    //   215: aload 7
    //   217: invokestatic 148	com/tencent/mobileqq/troop/utils/TroopGiftUtil:a	(Ljava/io/File;Ljava/lang/String;)V
    //   220: aload_1
    //   221: invokevirtual 151	java/io/File:delete	()Z
    //   224: pop
    //   225: goto +29 -> 254
    //   228: astore 5
    //   230: goto +16 -> 246
    //   233: astore 5
    //   235: aload 5
    //   237: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   240: aload_1
    //   241: invokevirtual 151	java/io/File:delete	()Z
    //   244: pop
    //   245: return
    //   246: aload_1
    //   247: invokevirtual 151	java/io/File:delete	()Z
    //   250: pop
    //   251: aload 5
    //   253: athrow
    //   254: aload_0
    //   255: getfield 10	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4:a	Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager;
    //   258: getfield 159	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   261: aload 6
    //   263: iconst_3
    //   264: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: invokevirtual 171	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   270: pop
    //   271: aconst_null
    //   272: ldc 98
    //   274: ldc 173
    //   276: ldc 100
    //   278: ldc 175
    //   280: ldc 177
    //   282: iconst_1
    //   283: iconst_0
    //   284: aload 5
    //   286: ldc 100
    //   288: ldc 100
    //   290: ldc 100
    //   292: invokestatic 113	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   295: goto +241 -> 536
    //   298: aload_0
    //   299: getfield 10	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4:a	Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager;
    //   302: getfield 159	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   305: astore_1
    //   306: iconst_4
    //   307: istore_2
    //   308: aload_1
    //   309: aload 6
    //   311: iconst_4
    //   312: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   315: invokevirtual 171	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   318: pop
    //   319: aload_0
    //   320: getfield 10	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4:a	Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager;
    //   323: getfield 180	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   326: invokevirtual 186	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   329: invokestatic 192	com/tencent/mobileqq/utils/NetworkUtil:getSystemNetwork	(Landroid/content/Context;)I
    //   332: istore_3
    //   333: iload_3
    //   334: iconst_1
    //   335: if_icmpne +8 -> 343
    //   338: iconst_0
    //   339: istore_2
    //   340: goto +30 -> 370
    //   343: iload_3
    //   344: iconst_2
    //   345: if_icmpne +8 -> 353
    //   348: iconst_3
    //   349: istore_2
    //   350: goto +20 -> 370
    //   353: iload_3
    //   354: iconst_3
    //   355: if_icmpne +8 -> 363
    //   358: iconst_2
    //   359: istore_2
    //   360: goto +10 -> 370
    //   363: iload_3
    //   364: iconst_4
    //   365: if_icmpne +5 -> 370
    //   368: iconst_1
    //   369: istore_2
    //   370: aload_0
    //   371: getfield 10	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4:a	Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager;
    //   374: getfield 195	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   377: instanceof 197
    //   380: ifne +141 -> 521
    //   383: aload_0
    //   384: getfield 10	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4:a	Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager;
    //   387: getfield 195	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   390: instanceof 199
    //   393: ifeq +6 -> 399
    //   396: goto +125 -> 521
    //   399: aload_0
    //   400: getfield 10	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4:a	Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager;
    //   403: getfield 195	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   406: ifnull +9 -> 415
    //   409: ldc 201
    //   411: astore_1
    //   412: goto +6 -> 418
    //   415: ldc 203
    //   417: astore_1
    //   418: invokestatic 208	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   421: aload 5
    //   423: invokevirtual 210	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Ljava/lang/String;)Z
    //   426: ifeq +8 -> 434
    //   429: iconst_2
    //   430: istore_3
    //   431: goto +5 -> 436
    //   434: iconst_1
    //   435: istore_3
    //   436: new 74	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   443: astore 7
    //   445: aload 7
    //   447: aload 6
    //   449: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 7
    //   455: ldc 100
    //   457: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 7
    //   463: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: astore 6
    //   468: new 74	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   475: astore 7
    //   477: aload 7
    //   479: iload_2
    //   480: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 7
    //   486: ldc 100
    //   488: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aconst_null
    //   493: ldc 98
    //   495: ldc 173
    //   497: ldc 100
    //   499: ldc 175
    //   501: ldc 215
    //   503: iload_3
    //   504: iconst_0
    //   505: aload 5
    //   507: aload 6
    //   509: aload_1
    //   510: aload 7
    //   512: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 113	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   518: goto +18 -> 536
    //   521: ldc 217
    //   523: ldc 219
    //   525: aload 5
    //   527: ldc 100
    //   529: ldc 100
    //   531: ldc 100
    //   533: invokestatic 224	com/tencent/mobileqq/app/NearbyFlowerManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   536: aload_0
    //   537: getfield 10	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4:a	Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager;
    //   540: getfield 195	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager:jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie	Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   543: ifnonnull +13 -> 556
    //   546: aload_0
    //   547: getfield 10	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4:a	Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager;
    //   550: getfield 227	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   553: ifnull +38 -> 591
    //   556: getstatic 228	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   559: aload_0
    //   560: getfield 10	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4:a	Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager;
    //   563: getfield 230	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager:b	Ljava/lang/String;
    //   566: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   569: ifne +22 -> 591
    //   572: aload_0
    //   573: getfield 10	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4:a	Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager;
    //   576: getfield 237	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   579: new 239	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4$1
    //   582: dup
    //   583: aload_0
    //   584: invokespecial 242	com/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4$1:<init>	(Lcom/tencent/mobileqq/troop/utils/AIOAnimationControlManager$4;)V
    //   587: invokevirtual 248	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   590: pop
    //   591: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	592	0	this	4
    //   0	592	1	paramDownloadTask	DownloadTask
    //   40	440	2	i	int
    //   332	172	3	j	int
    //   48	128	4	bool	boolean
    //   31	1	5	str1	String
    //   228	1	5	localObject1	java.lang.Object
    //   233	293	5	localException	java.lang.Exception
    //   22	486	6	str2	String
    //   7	504	7	localObject2	java.lang.Object
    //   13	29	8	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   191	220	228	finally
    //   235	240	228	finally
    //   191	220	233	java/lang/Exception
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.a().getString("GiftAnimationId");
    AIOAnimationControlManager.DownloadGftData localDownloadGftData = new AIOAnimationControlManager.DownloadGftData();
    localDownloadGftData.jdField_a_of_type_Boolean = false;
    localDownloadGftData.jdField_a_of_type_JavaLangString = str;
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().setChanged();
    AIOAnimationControlManager.DownloadGiftResStateObservable.a().notifyObservers(localDownloadGftData);
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.4
 * JD-Core Version:    0.7.0.1
 */