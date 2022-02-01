package com.tencent.mobileqq.comment.danmaku.api.impl;

import com.tencent.mobileqq.comment.danmaku.api.IDanmakuDecode;

public class DanmakuDecodeImpl
  implements IDanmakuDecode
{
  private static final String TAG = "DanmakuDecodeImpl";
  
  /* Error */
  public java.util.List<com.tencent.mobileqq.comment.DanmuItemBean> decodeCommentList(java.util.List<com.tencent.mobileqq.comment.oidb.oidb_0xdea.Comment> paramList, long paramLong, android.graphics.Paint paramPaint, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +837 -> 838
    //   4: aload_1
    //   5: invokeinterface 25 1 0
    //   10: ifeq +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: invokestatic 31	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   18: invokevirtual 35	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   21: astore 16
    //   23: aload 16
    //   25: instanceof 37
    //   28: ifeq +13 -> 41
    //   31: aload 16
    //   33: checkcast 37	com/tencent/mobileqq/app/QQAppInterface
    //   36: astore 16
    //   38: goto +6 -> 44
    //   41: aconst_null
    //   42: astore 16
    //   44: aload 16
    //   46: ifnonnull +5 -> 51
    //   49: aconst_null
    //   50: areturn
    //   51: new 39	java/util/ArrayList
    //   54: dup
    //   55: aload_1
    //   56: invokeinterface 43 1 0
    //   61: invokespecial 46	java/util/ArrayList:<init>	(I)V
    //   64: astore 18
    //   66: new 48	com/tencent/mobileqq/service/message/MessagePBElemDecoder
    //   69: dup
    //   70: invokespecial 49	com/tencent/mobileqq/service/message/MessagePBElemDecoder:<init>	()V
    //   73: astore 19
    //   75: aload_1
    //   76: invokeinterface 53 1 0
    //   81: astore 20
    //   83: aload 20
    //   85: invokeinterface 58 1 0
    //   90: ifeq +703 -> 793
    //   93: aload 20
    //   95: invokeinterface 62 1 0
    //   100: checkcast 64	com/tencent/mobileqq/comment/oidb/oidb_0xdea$Comment
    //   103: astore_1
    //   104: new 66	tencent/im/msg/im_msg_body$MsgBody
    //   107: dup
    //   108: invokespecial 67	tencent/im/msg/im_msg_body$MsgBody:<init>	()V
    //   111: astore 17
    //   113: aload 17
    //   115: aload_1
    //   116: getfield 71	com/tencent/mobileqq/comment/oidb/oidb_0xdea$Comment:bytes_comment_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   119: invokevirtual 77	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   122: invokevirtual 83	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   125: invokevirtual 87	tencent/im/msg/im_msg_body$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   128: pop
    //   129: new 89	tencent/im/msg/im_msg_body$RichText
    //   132: dup
    //   133: invokespecial 90	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   136: astore 21
    //   138: aload 21
    //   140: aload 17
    //   142: getfield 94	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   145: invokevirtual 97	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   148: checkcast 89	tencent/im/msg/im_msg_body$RichText
    //   151: invokevirtual 98	tencent/im/msg/im_msg_body$RichText:toByteArray	()[B
    //   154: invokevirtual 99	tencent/im/msg/im_msg_body$RichText:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   157: pop
    //   158: aload 21
    //   160: getfield 103	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   163: invokevirtual 108	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   166: astore 21
    //   168: aload_1
    //   169: getfield 112	com/tencent/mobileqq/comment/oidb/oidb_0xdea$Comment:uint64_comment_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   172: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   175: lstore 7
    //   177: aload_1
    //   178: getfield 120	com/tencent/mobileqq/comment/oidb/oidb_0xdea$Comment:uint64_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   181: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   184: lstore 9
    //   186: aload_1
    //   187: getfield 124	com/tencent/mobileqq/comment/oidb/oidb_0xdea$Comment:uint32_comment_ctime	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   190: invokevirtual 128	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   193: i2l
    //   194: lstore 11
    //   196: aload_1
    //   197: getfield 131	com/tencent/mobileqq/comment/oidb/oidb_0xdea$Comment:uint64_comment_location	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   200: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   203: lstore 13
    //   205: new 133	com/tencent/mobileqq/troop/data/MessageInfo
    //   208: dup
    //   209: invokespecial 134	com/tencent/mobileqq/troop/data/MessageInfo:<init>	()V
    //   212: astore 17
    //   214: aload 17
    //   216: lload_2
    //   217: invokestatic 140	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   220: putfield 143	com/tencent/mobileqq/troop/data/MessageInfo:a	Ljava/lang/String;
    //   223: aload 17
    //   225: iconst_1
    //   226: putfield 147	com/tencent/mobileqq/troop/data/MessageInfo:b	I
    //   229: aload 19
    //   231: aload 21
    //   233: new 149	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   240: lload 9
    //   242: aload 17
    //   244: invokevirtual 153	com/tencent/mobileqq/service/message/MessagePBElemDecoder:a	(Ljava/util/List;Ljava/lang/StringBuilder;JLcom/tencent/mobileqq/troop/data/MessageInfo;)Lcom/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext;
    //   247: astore 22
    //   249: aload 22
    //   251: getfield 158	com/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext:c	Ljava/lang/String;
    //   254: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   257: ifeq +6 -> 263
    //   260: goto -177 -> 83
    //   263: aload 22
    //   265: getfield 166	com/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext:a	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   268: getfield 171	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:mAnonymousNickName	Ljava/lang/String;
    //   271: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   274: ifeq +94 -> 368
    //   277: aload 22
    //   279: getfield 175	com/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext:d	Lcom/tencent/mobileqq/data/AtTroopMemberInfo;
    //   282: ifnull +86 -> 368
    //   285: aload 22
    //   287: getfield 158	com/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext:c	Ljava/lang/String;
    //   290: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   293: ifne +75 -> 368
    //   296: aload 22
    //   298: getfield 158	com/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext:c	Ljava/lang/String;
    //   301: invokevirtual 178	java/lang/String:length	()I
    //   304: aload 22
    //   306: getfield 175	com/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext:d	Lcom/tencent/mobileqq/data/AtTroopMemberInfo;
    //   309: getfield 184	com/tencent/mobileqq/data/AtTroopMemberInfo:textLen	S
    //   312: iconst_1
    //   313: iadd
    //   314: if_icmple +54 -> 368
    //   317: aload 22
    //   319: getfield 158	com/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext:c	Ljava/lang/String;
    //   322: aload 22
    //   324: getfield 187	com/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext:e	Ljava/lang/String;
    //   327: invokevirtual 191	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   330: ifeq +38 -> 368
    //   333: aload 22
    //   335: getfield 158	com/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext:c	Ljava/lang/String;
    //   338: aload 22
    //   340: getfield 175	com/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext:d	Lcom/tencent/mobileqq/data/AtTroopMemberInfo;
    //   343: getfield 184	com/tencent/mobileqq/data/AtTroopMemberInfo:textLen	S
    //   346: iconst_1
    //   347: iadd
    //   348: invokevirtual 195	java/lang/String:substring	(I)Ljava/lang/String;
    //   351: astore 17
    //   353: aload 17
    //   355: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   358: ifne +10 -> 368
    //   361: aload 22
    //   363: aload 17
    //   365: putfield 158	com/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext:c	Ljava/lang/String;
    //   368: aload_1
    //   369: getfield 198	com/tencent/mobileqq/comment/oidb/oidb_0xdea$Comment:bytes_nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   372: invokevirtual 77	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   375: invokevirtual 202	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   378: astore 17
    //   380: aload_1
    //   381: getfield 205	com/tencent/mobileqq/comment/oidb/oidb_0xdea$Comment:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   384: invokevirtual 128	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   387: istore 6
    //   389: aload 17
    //   391: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   394: ifeq +57 -> 451
    //   397: aload 16
    //   399: lload_2
    //   400: invokestatic 140	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   403: lload 7
    //   405: invokestatic 140	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   408: invokestatic 210	com/tencent/mobileqq/utils/ContactUtils:b	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   411: astore 17
    //   413: aload 17
    //   415: astore_1
    //   416: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq +137 -> 556
    //   422: ldc 10
    //   424: iconst_2
    //   425: iconst_2
    //   426: anewarray 4	java/lang/Object
    //   429: dup
    //   430: iconst_0
    //   431: ldc 217
    //   433: aastore
    //   434: dup
    //   435: iconst_1
    //   436: lload 9
    //   438: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   441: aastore
    //   442: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   445: aload 17
    //   447: astore_1
    //   448: goto +108 -> 556
    //   451: aload 17
    //   453: astore_1
    //   454: iload 6
    //   456: iconst_4
    //   457: if_icmpne +99 -> 556
    //   460: aload 16
    //   462: getstatic 230	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   465: invokevirtual 234	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   468: checkcast 236	com/tencent/mobileqq/app/FriendsManager
    //   471: lload 7
    //   473: invokestatic 140	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   476: invokevirtual 239	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   479: astore 23
    //   481: aload 17
    //   483: astore_1
    //   484: aload 23
    //   486: ifnull +70 -> 556
    //   489: aload 17
    //   491: astore_1
    //   492: aload 23
    //   494: invokevirtual 244	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   497: ifeq +59 -> 556
    //   500: aload 17
    //   502: astore_1
    //   503: aload 23
    //   505: getfield 247	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   508: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   511: ifne +45 -> 556
    //   514: aload 23
    //   516: getfield 247	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   519: astore 17
    //   521: aload 17
    //   523: astore_1
    //   524: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +29 -> 556
    //   530: ldc 10
    //   532: iconst_2
    //   533: iconst_2
    //   534: anewarray 4	java/lang/Object
    //   537: dup
    //   538: iconst_0
    //   539: ldc 249
    //   541: aastore
    //   542: dup
    //   543: iconst_1
    //   544: lload 9
    //   546: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   549: aastore
    //   550: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   553: aload 17
    //   555: astore_1
    //   556: aload 4
    //   558: aload_1
    //   559: iload 5
    //   561: invokestatic 254	com/tencent/mobileqq/comment/DanmuUtil:a	(Landroid/graphics/Paint;Ljava/lang/String;I)Ljava/lang/String;
    //   564: astore_1
    //   565: new 256	com/tencent/mobileqq/comment/DanmuItemBean
    //   568: dup
    //   569: lload 7
    //   571: lload 9
    //   573: lload 11
    //   575: lload 13
    //   577: aload 22
    //   579: getfield 158	com/tencent/mobileqq/service/message/MessagePBElemDecoder$DecodeSrcMsgContext:c	Ljava/lang/String;
    //   582: aload_1
    //   583: invokespecial 259	com/tencent/mobileqq/comment/DanmuItemBean:<init>	(JJJJLjava/lang/String;Ljava/lang/String;)V
    //   586: astore 17
    //   588: aload 18
    //   590: aload 17
    //   592: invokeinterface 263 2 0
    //   597: pop
    //   598: aload 21
    //   600: invokeinterface 53 1 0
    //   605: astore 21
    //   607: aload 21
    //   609: invokeinterface 58 1 0
    //   614: ifeq -531 -> 83
    //   617: aload 21
    //   619: invokeinterface 62 1 0
    //   624: checkcast 265	tencent/im/msg/im_msg_body$Elem
    //   627: astore_1
    //   628: aload_1
    //   629: getfield 269	tencent/im/msg/im_msg_body$Elem:anon_group_msg	Ltencent/im/msg/im_msg_body$AnonymousGroupMsg;
    //   632: invokevirtual 274	tencent/im/msg/im_msg_body$AnonymousGroupMsg:has	()Z
    //   635: ifeq -28 -> 607
    //   638: aload_1
    //   639: getfield 269	tencent/im/msg/im_msg_body$Elem:anon_group_msg	Ltencent/im/msg/im_msg_body$AnonymousGroupMsg;
    //   642: invokevirtual 275	tencent/im/msg/im_msg_body$AnonymousGroupMsg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   645: checkcast 271	tencent/im/msg/im_msg_body$AnonymousGroupMsg
    //   648: astore 22
    //   650: aload 22
    //   652: getfield 278	tencent/im/msg/im_msg_body$AnonymousGroupMsg:str_anon_nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   655: invokevirtual 77	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   658: invokevirtual 83	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   661: astore_1
    //   662: aload 22
    //   664: getfield 281	tencent/im/msg/im_msg_body$AnonymousGroupMsg:uint32_flags	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   667: invokevirtual 128	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   670: ifle +170 -> 840
    //   673: iconst_1
    //   674: istore 15
    //   676: goto +3 -> 679
    //   679: aload 17
    //   681: iload 15
    //   683: putfield 285	com/tencent/mobileqq/comment/DanmuItemBean:g	Z
    //   686: aload_1
    //   687: ifnonnull +10 -> 697
    //   690: ldc_w 287
    //   693: astore_1
    //   694: goto +12 -> 706
    //   697: new 136	java/lang/String
    //   700: dup
    //   701: aload_1
    //   702: invokespecial 290	java/lang/String:<init>	([B)V
    //   705: astore_1
    //   706: aload 17
    //   708: aload_1
    //   709: putfield 293	com/tencent/mobileqq/comment/DanmuItemBean:h	Ljava/lang/String;
    //   712: aload 17
    //   714: aload 22
    //   716: getfield 296	tencent/im/msg/im_msg_body$AnonymousGroupMsg:uint32_head_portrait	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   719: invokevirtual 128	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   722: putfield 299	com/tencent/mobileqq/comment/DanmuItemBean:i	I
    //   725: ldc 10
    //   727: iconst_1
    //   728: iconst_2
    //   729: anewarray 4	java/lang/Object
    //   732: dup
    //   733: iconst_0
    //   734: ldc_w 301
    //   737: aastore
    //   738: dup
    //   739: iconst_1
    //   740: aload 17
    //   742: aastore
    //   743: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   746: goto -139 -> 607
    //   749: astore_1
    //   750: goto +4 -> 754
    //   753: astore_1
    //   754: new 149	java/lang/StringBuilder
    //   757: dup
    //   758: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   761: astore 17
    //   763: aload 17
    //   765: ldc_w 303
    //   768: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: aload 17
    //   774: aload_1
    //   775: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: ldc 10
    //   781: iconst_1
    //   782: aload 17
    //   784: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   787: invokestatic 316	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   790: goto -707 -> 83
    //   793: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   796: ifeq +39 -> 835
    //   799: new 149	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   806: astore_1
    //   807: aload_1
    //   808: ldc_w 318
    //   811: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload_1
    //   816: aload 18
    //   818: invokevirtual 319	java/lang/Object:toString	()Ljava/lang/String;
    //   821: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: ldc 10
    //   827: iconst_2
    //   828: aload_1
    //   829: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 316	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   835: aload 18
    //   837: areturn
    //   838: aconst_null
    //   839: areturn
    //   840: iconst_0
    //   841: istore 15
    //   843: goto -164 -> 679
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	846	0	this	DanmakuDecodeImpl
    //   0	846	1	paramList	java.util.List<com.tencent.mobileqq.comment.oidb.oidb_0xdea.Comment>
    //   0	846	2	paramLong	long
    //   0	846	4	paramPaint	android.graphics.Paint
    //   0	846	5	paramInt	int
    //   387	71	6	i	int
    //   175	395	7	l1	long
    //   184	388	9	l2	long
    //   194	380	11	l3	long
    //   203	373	13	l4	long
    //   674	168	15	bool	boolean
    //   21	440	16	localObject1	Object
    //   111	672	17	localObject2	Object
    //   64	772	18	localArrayList	java.util.ArrayList
    //   73	157	19	localMessagePBElemDecoder	com.tencent.mobileqq.service.message.MessagePBElemDecoder
    //   81	13	20	localIterator	java.util.Iterator
    //   136	482	21	localObject3	Object
    //   247	468	22	localObject4	Object
    //   479	36	23	localFriends	com.tencent.mobileqq.data.Friends
    // Exception table:
    //   from	to	target	type
    //   556	607	749	java/lang/Exception
    //   607	673	749	java/lang/Exception
    //   679	686	749	java/lang/Exception
    //   697	706	749	java/lang/Exception
    //   706	746	749	java/lang/Exception
    //   104	260	753	java/lang/Exception
    //   263	368	753	java/lang/Exception
    //   368	413	753	java/lang/Exception
    //   416	445	753	java/lang/Exception
    //   460	481	753	java/lang/Exception
    //   492	500	753	java/lang/Exception
    //   503	521	753	java/lang/Exception
    //   524	553	753	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.danmaku.api.impl.DanmakuDecodeImpl
 * JD-Core Version:    0.7.0.1
 */