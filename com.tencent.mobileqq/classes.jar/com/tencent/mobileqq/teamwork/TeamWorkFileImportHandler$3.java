package com.tencent.mobileqq.teamwork;

import beav;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$3
  implements Runnable
{
  public TeamWorkFileImportHandler$3(beav parambeav, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Lbeav;
    //   4: getfield 37	beav:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   14: lstore_3
    //   15: aload_0
    //   16: getfield 18	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   19: ifnull +34 -> 53
    //   22: aload_0
    //   23: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   26: invokevirtual 49	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:b	()Z
    //   29: ifeq +24 -> 53
    //   32: aload_0
    //   33: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   36: getfield 53	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:g	Z
    //   39: ifne +14 -> 53
    //   42: aload_0
    //   43: getfield 18	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   46: ldc 55
    //   48: iconst_1
    //   49: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   52: pop
    //   53: aload_0
    //   54: getfield 18	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   57: aload_0
    //   58: getfield 16	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Lbeav;
    //   61: getfield 37	beav:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   64: invokevirtual 67	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   67: invokestatic 72	bebo:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 10
    //   72: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   75: lstore 5
    //   77: aload_0
    //   78: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   81: getfield 75	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_Int	I
    //   84: aload_0
    //   85: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_Int	I
    //   88: if_icmpeq +32 -> 120
    //   91: ldc 77
    //   93: iconst_2
    //   94: new 79	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   101: ldc 82
    //   103: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_Int	I
    //   110: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 98	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: return
    //   120: ldc 100
    //   122: astore 9
    //   124: aload 10
    //   126: ifnull +283 -> 409
    //   129: aload_0
    //   130: getfield 16	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Lbeav;
    //   133: aload 10
    //   135: aload_0
    //   136: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   139: invokestatic 103	beav:a	(Lbeav;Ljava/lang/String;Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;)Z
    //   142: istore 7
    //   144: new 57	org/json/JSONObject
    //   147: dup
    //   148: aload 10
    //   150: invokespecial 106	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   153: ldc 108
    //   155: invokevirtual 112	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 8
    //   160: aload 8
    //   162: astore 9
    //   164: ldc 113
    //   166: invokestatic 118	anzj:a	(I)Ljava/lang/String;
    //   169: astore 8
    //   171: aload_0
    //   172: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   175: getfield 121	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:e	I
    //   178: iconst_3
    //   179: if_icmpne +252 -> 431
    //   182: ldc 123
    //   184: astore 8
    //   186: lload 5
    //   188: lload_3
    //   189: lsub
    //   190: lstore_3
    //   191: aload_0
    //   192: getfield 16	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Lbeav;
    //   195: getfield 37	beav:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   198: astore 11
    //   200: aload_0
    //   201: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   204: getfield 126	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:d	I
    //   207: istore_2
    //   208: iload 7
    //   210: ifeq +278 -> 488
    //   213: iconst_1
    //   214: istore_1
    //   215: aload 11
    //   217: ldc 128
    //   219: ldc 100
    //   221: ldc 100
    //   223: ldc 130
    //   225: ldc 130
    //   227: iload_2
    //   228: iload_1
    //   229: new 79	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   236: lload_3
    //   237: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   240: ldc 100
    //   242: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: ldc 100
    //   250: aload 8
    //   252: aload 9
    //   254: invokestatic 138	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   257: ldc 77
    //   259: ldc 140
    //   261: lload_3
    //   262: invokestatic 146	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   265: aload_0
    //   266: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   269: getfield 149	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   272: invokestatic 154	bedq:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   275: iload 7
    //   277: ifne -267 -> 10
    //   280: aload_0
    //   281: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   284: invokevirtual 49	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:b	()Z
    //   287: ifne +224 -> 511
    //   290: aload_0
    //   291: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   294: getfield 157	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:c	Ljava/lang/String;
    //   297: invokestatic 162	auog:b	(Ljava/lang/String;)Z
    //   300: ifeq +211 -> 511
    //   303: ldc 77
    //   305: ldc 164
    //   307: ldc 166
    //   309: aload_0
    //   310: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   313: getfield 149	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   316: invokestatic 154	bedq:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload_0
    //   320: getfield 16	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Lbeav;
    //   323: aload_0
    //   324: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   327: invokevirtual 169	beav:c	(Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;)V
    //   330: aload_0
    //   331: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   334: astore 8
    //   336: iconst_0
    //   337: istore_2
    //   338: iload_2
    //   339: istore_1
    //   340: aload 10
    //   342: invokestatic 175	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   345: ifne +18 -> 363
    //   348: new 57	org/json/JSONObject
    //   351: dup
    //   352: aload 10
    //   354: invokespecial 106	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   357: ldc 177
    //   359: invokevirtual 181	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   362: istore_1
    //   363: iload_1
    //   364: sipush 20003
    //   367: if_icmpeq -357 -> 10
    //   370: iload_1
    //   371: sipush 20005
    //   374: if_icmpeq -364 -> 10
    //   377: aload 8
    //   379: iconst_0
    //   380: putfield 183	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:a	Z
    //   383: aload_0
    //   384: getfield 16	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Lbeav;
    //   387: aload 8
    //   389: invokevirtual 185	beav:a	(Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;)V
    //   392: return
    //   393: astore 8
    //   395: ldc 77
    //   397: iconst_1
    //   398: aload 8
    //   400: invokevirtual 186	java/lang/Exception:toString	()Ljava/lang/String;
    //   403: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: goto -242 -> 164
    //   409: ldc 77
    //   411: ldc 164
    //   413: ldc 190
    //   415: aload_0
    //   416: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   419: getfield 149	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   422: invokestatic 154	bedq:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   425: iconst_0
    //   426: istore 7
    //   428: goto -264 -> 164
    //   431: aload_0
    //   432: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   435: getfield 121	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:e	I
    //   438: bipush 6
    //   440: if_icmpne +10 -> 450
    //   443: ldc 192
    //   445: astore 8
    //   447: goto -261 -> 186
    //   450: aload_0
    //   451: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   454: getfield 121	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:e	I
    //   457: bipush 7
    //   459: if_icmpne +10 -> 469
    //   462: ldc 194
    //   464: astore 8
    //   466: goto -280 -> 186
    //   469: aload_0
    //   470: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   473: getfield 121	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:e	I
    //   476: bipush 9
    //   478: if_icmpne -292 -> 186
    //   481: ldc 196
    //   483: astore 8
    //   485: goto -299 -> 186
    //   488: iconst_2
    //   489: istore_1
    //   490: goto -275 -> 215
    //   493: astore 9
    //   495: ldc 77
    //   497: iconst_1
    //   498: aload 9
    //   500: invokevirtual 197	org/json/JSONException:toString	()Ljava/lang/String;
    //   503: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   506: iload_2
    //   507: istore_1
    //   508: goto -145 -> 363
    //   511: aload_0
    //   512: getfield 16	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Lbeav;
    //   515: invokestatic 200	beav:a	(Lbeav;)Landroid/os/Handler;
    //   518: ifnull -508 -> 10
    //   521: aload_0
    //   522: getfield 16	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Lbeav;
    //   525: invokestatic 200	beav:a	(Lbeav;)Landroid/os/Handler;
    //   528: sipush 8002
    //   531: invokevirtual 206	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   534: astore 8
    //   536: aload 8
    //   538: aload_0
    //   539: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   542: putfield 212	android/os/Message:obj	Ljava/lang/Object;
    //   545: aload_0
    //   546: getfield 16	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Lbeav;
    //   549: invokestatic 200	beav:a	(Lbeav;)Landroid/os/Handler;
    //   552: aload 8
    //   554: invokevirtual 216	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   557: pop
    //   558: return
    //   559: astore 8
    //   561: goto -508 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	this	3
    //   214	294	1	i	int
    //   207	300	2	j	int
    //   14	248	3	l1	long
    //   75	112	5	l2	long
    //   142	285	7	bool	boolean
    //   158	230	8	localObject1	Object
    //   393	6	8	localException	java.lang.Exception
    //   445	108	8	localObject2	Object
    //   559	1	8	localJSONException1	org.json.JSONException
    //   122	131	9	localObject3	Object
    //   493	6	9	localJSONException2	org.json.JSONException
    //   70	283	10	str	java.lang.String
    //   198	18	11	localQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   144	160	393	java/lang/Exception
    //   340	363	493	org/json/JSONException
    //   42	53	559	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.3
 * JD-Core Version:    0.7.0.1
 */