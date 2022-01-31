import android.content.Context;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.PublicAccountManager.InitDoneObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class laq
  implements Runnable
{
  public laq(PublicAccountManager paramPublicAccountManager, String paramString, QQAppInterface paramQQAppInterface, PublicAccountManager.InitDoneObserver paramInitDoneObserver, Context paramContext) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 16	laq:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   6: getfield 37	com/tencent/biz/pubaccount/PublicAccountManager:c	Ljava/util/Map;
    //   9: aload_0
    //   10: getfield 18	laq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   13: invokeinterface 43 2 0
    //   18: ifne +272 -> 290
    //   21: aload_0
    //   22: getfield 20	laq:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: invokevirtual 49	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   28: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   31: ldc 57
    //   33: aload_0
    //   34: getfield 18	laq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokevirtual 62	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   40: checkcast 57	com/tencent/mobileqq/data/PublicAccountMenuEntity
    //   43: astore 6
    //   45: aload 6
    //   47: ifnull +209 -> 256
    //   50: new 64	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse
    //   53: dup
    //   54: invokespecial 65	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:<init>	()V
    //   57: astore 5
    //   59: aload 5
    //   61: aload 6
    //   63: getfield 69	com/tencent/mobileqq/data/PublicAccountMenuEntity:data	[B
    //   66: invokevirtual 73	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   69: pop
    //   70: aload 5
    //   72: ifnull +174 -> 246
    //   75: aload 5
    //   77: getfield 77	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:button_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   80: invokevirtual 83	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   83: ifeq +163 -> 246
    //   86: aload 5
    //   88: getfield 77	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:button_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   91: invokevirtual 87	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   94: astore 7
    //   96: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +34 -> 133
    //   102: ldc 94
    //   104: iconst_2
    //   105: new 96	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   112: ldc 99
    //   114: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 7
    //   119: invokeinterface 109 1 0
    //   124: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 6
    //   135: getfield 124	com/tencent/mobileqq/data/PublicAccountMenuEntity:savedDateTime	J
    //   138: lstore_3
    //   139: aload 6
    //   141: getfield 128	com/tencent/mobileqq/data/PublicAccountMenuEntity:seqno	I
    //   144: istore_2
    //   145: aload_0
    //   146: getfield 16	laq:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   149: getfield 130	com/tencent/biz/pubaccount/PublicAccountManager:a	Ljava/util/Map;
    //   152: aload_0
    //   153: getfield 18	laq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   156: lload_3
    //   157: invokestatic 136	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   160: invokeinterface 140 3 0
    //   165: pop
    //   166: aload_0
    //   167: getfield 16	laq:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   170: aload_0
    //   171: getfield 18	laq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   174: iload_2
    //   175: invokevirtual 143	com/tencent/biz/pubaccount/PublicAccountManager:a	(Ljava/lang/String;I)V
    //   178: aload_0
    //   179: getfield 16	laq:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   182: getfield 37	com/tencent/biz/pubaccount/PublicAccountManager:c	Ljava/util/Map;
    //   185: aload_0
    //   186: getfield 18	laq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   189: aload 7
    //   191: invokeinterface 140 3 0
    //   196: pop
    //   197: aload_0
    //   198: getfield 16	laq:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   201: getfield 146	com/tencent/biz/pubaccount/PublicAccountManager:d	Ljava/util/Map;
    //   204: astore 6
    //   206: aload_0
    //   207: getfield 18	laq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   210: astore 7
    //   212: aload 5
    //   214: getfield 150	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:menu_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   217: invokevirtual 153	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   220: ifeq +12 -> 232
    //   223: aload 5
    //   225: getfield 150	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountMenuResponse:menu_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   228: invokevirtual 155	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   231: istore_1
    //   232: aload 6
    //   234: aload 7
    //   236: iload_1
    //   237: invokestatic 160	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: invokeinterface 140 3 0
    //   245: pop
    //   246: aload_0
    //   247: getfield 22	laq:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager$InitDoneObserver	Lcom/tencent/biz/pubaccount/PublicAccountManager$InitDoneObserver;
    //   250: invokeinterface 164 1 0
    //   255: return
    //   256: new 166	lar
    //   259: dup
    //   260: aload_0
    //   261: invokespecial 169	lar:<init>	(Llaq;)V
    //   264: astore 5
    //   266: aload_0
    //   267: getfield 16	laq:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager	Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   270: aload_0
    //   271: getfield 24	laq:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   274: aload_0
    //   275: getfield 20	laq:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   278: aload_0
    //   279: getfield 18	laq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   282: aload 5
    //   284: iconst_0
    //   285: invokevirtual 172	com/tencent/biz/pubaccount/PublicAccountManager:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lmqq/observer/BusinessObserver;Z)Lmqq/app/NewIntent;
    //   288: pop
    //   289: return
    //   290: aload_0
    //   291: getfield 22	laq:jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager$InitDoneObserver	Lcom/tencent/biz/pubaccount/PublicAccountManager$InitDoneObserver;
    //   294: invokeinterface 164 1 0
    //   299: return
    //   300: astore 5
    //   302: aconst_null
    //   303: astore 5
    //   305: goto -235 -> 70
    //   308: astore 7
    //   310: goto -240 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	laq
    //   1	236	1	i	int
    //   144	31	2	j	int
    //   138	19	3	l	long
    //   57	226	5	localObject1	Object
    //   300	1	5	localException1	java.lang.Exception
    //   303	1	5	localObject2	Object
    //   43	190	6	localObject3	Object
    //   94	141	7	localObject4	Object
    //   308	1	7	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   50	59	300	java/lang/Exception
    //   59	70	308	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     laq
 * JD-Core Version:    0.7.0.1
 */