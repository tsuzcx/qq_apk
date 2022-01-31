import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;

public class rcg
  extends ProtoUtils.TroopProtocolObserver
{
  public rcg(UserInfoModule paramUserInfoModule, APICallback paramAPICallback) {}
  
  /* Error */
  public void a(int paramInt, byte[] paramArrayOfByte, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +83 -> 86
    //   6: getstatic 33	com/tencent/mobileqq/Doraemon/impl/commonModule/UserInfoModule:a	Ljava/lang/String;
    //   9: iconst_2
    //   10: new 35	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   17: ldc 38
    //   19: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 11	rcg:jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule	Lcom/tencent/mobileqq/Doraemon/impl/commonModule/UserInfoModule;
    //   26: invokestatic 45	com/tencent/mobileqq/Doraemon/impl/commonModule/UserInfoModule:a	(Lcom/tencent/mobileqq/Doraemon/impl/commonModule/UserInfoModule;)Lcom/tencent/mobileqq/Doraemon/DoraemonAPIManager;
    //   29: getfield 48	com/tencent/mobileqq/Doraemon/DoraemonAPIManager:a	Ljava/lang/String;
    //   32: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 50
    //   37: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 11	rcg:jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule	Lcom/tencent/mobileqq/Doraemon/impl/commonModule/UserInfoModule;
    //   44: invokestatic 53	com/tencent/mobileqq/Doraemon/impl/commonModule/UserInfoModule:a	(Lcom/tencent/mobileqq/Doraemon/impl/commonModule/UserInfoModule;)Lrcj;
    //   47: getfield 56	rcj:a	Ljava/lang/String;
    //   50: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 58
    //   55: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 11	rcg:jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule	Lcom/tencent/mobileqq/Doraemon/impl/commonModule/UserInfoModule;
    //   62: invokestatic 53	com/tencent/mobileqq/Doraemon/impl/commonModule/UserInfoModule:a	(Lcom/tencent/mobileqq/Doraemon/impl/commonModule/UserInfoModule;)Lrcj;
    //   65: getfield 61	rcj:b	Ljava/lang/String;
    //   68: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 63
    //   73: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: iload_1
    //   77: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: iload_1
    //   87: ifne +7 -> 94
    //   90: aload_2
    //   91: ifnonnull +14 -> 105
    //   94: aload_0
    //   95: getfield 13	rcg:jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback	Lcom/tencent/mobileqq/Doraemon/APICallback;
    //   98: iload_1
    //   99: ldc 76
    //   101: invokestatic 81	com/tencent/mobileqq/Doraemon/util/DoraemonUtil:a	(Lcom/tencent/mobileqq/Doraemon/APICallback;ILjava/lang/String;)V
    //   104: return
    //   105: new 83	tencent/im/oidb/cmd0xb6e/Oidb_0xb6e$RspBody
    //   108: dup
    //   109: invokespecial 84	tencent/im/oidb/cmd0xb6e/Oidb_0xb6e$RspBody:<init>	()V
    //   112: astore_3
    //   113: aload_3
    //   114: aload_2
    //   115: invokevirtual 88	tencent/im/oidb/cmd0xb6e/Oidb_0xb6e$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   118: pop
    //   119: aload_3
    //   120: astore_2
    //   121: aload_2
    //   122: ifnull +229 -> 351
    //   125: new 90	com/tencent/mobileqq/Doraemon/APIParam
    //   128: dup
    //   129: invokespecial 91	com/tencent/mobileqq/Doraemon/APIParam:<init>	()V
    //   132: astore_3
    //   133: aload_3
    //   134: ldc 93
    //   136: iconst_0
    //   137: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: invokevirtual 103	com/tencent/mobileqq/Doraemon/APIParam:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: pop
    //   144: new 105	org/json/JSONArray
    //   147: dup
    //   148: invokespecial 106	org/json/JSONArray:<init>	()V
    //   151: astore 4
    //   153: aload_2
    //   154: getfield 110	tencent/im/oidb/cmd0xb6e/Oidb_0xb6e$RspBody:rpt_friends_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   157: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   160: invokeinterface 122 1 0
    //   165: astore_2
    //   166: aload_2
    //   167: invokeinterface 127 1 0
    //   172: ifeq +113 -> 285
    //   175: aload_2
    //   176: invokeinterface 131 1 0
    //   181: checkcast 133	tencent/im/oidb/cmd0xb6e/Oidb_0xb6e$AppFriendsInfo
    //   184: astore 7
    //   186: aload 7
    //   188: getfield 137	tencent/im/oidb/cmd0xb6e/Oidb_0xb6e$AppFriendsInfo:openid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   191: invokevirtual 141	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   194: astore 5
    //   196: aload 7
    //   198: getfield 145	tencent/im/oidb/cmd0xb6e/Oidb_0xb6e$AppFriendsInfo:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   201: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   204: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   207: astore 6
    //   209: aload 7
    //   211: getfield 158	tencent/im/oidb/cmd0xb6e/Oidb_0xb6e$AppFriendsInfo:figure_url_qq	Lcom/tencent/mobileqq/pb/PBStringField;
    //   214: invokevirtual 141	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   217: astore 7
    //   219: aload 5
    //   221: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne -58 -> 166
    //   227: new 166	org/json/JSONObject
    //   230: dup
    //   231: invokespecial 167	org/json/JSONObject:<init>	()V
    //   234: astore 8
    //   236: aload 8
    //   238: ldc 168
    //   240: aload 5
    //   242: invokevirtual 173	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   245: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   248: pop
    //   249: aload 8
    //   251: ldc 178
    //   253: aload 6
    //   255: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload 8
    //   261: ldc 180
    //   263: aload 7
    //   265: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 4
    //   271: aload 8
    //   273: invokevirtual 183	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   276: pop
    //   277: goto -111 -> 166
    //   280: astore_2
    //   281: aload_2
    //   282: invokevirtual 186	org/json/JSONException:printStackTrace	()V
    //   285: aload_3
    //   286: ldc 188
    //   288: aload 4
    //   290: invokevirtual 189	org/json/JSONArray:toString	()Ljava/lang/String;
    //   293: invokevirtual 103	com/tencent/mobileqq/Doraemon/APIParam:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   296: pop
    //   297: invokestatic 192	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   300: ifeq +32 -> 332
    //   303: getstatic 33	com/tencent/mobileqq/Doraemon/impl/commonModule/UserInfoModule:a	Ljava/lang/String;
    //   306: iconst_2
    //   307: new 35	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   314: ldc 194
    //   316: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_3
    //   320: invokevirtual 195	com/tencent/mobileqq/Doraemon/APIParam:toString	()Ljava/lang/String;
    //   323: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: aload_0
    //   333: getfield 13	rcg:jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback	Lcom/tencent/mobileqq/Doraemon/APICallback;
    //   336: aload_3
    //   337: invokestatic 198	com/tencent/mobileqq/Doraemon/util/DoraemonUtil:a	(Lcom/tencent/mobileqq/Doraemon/APICallback;Lcom/tencent/mobileqq/Doraemon/APIParam;)V
    //   340: return
    //   341: astore_3
    //   342: aconst_null
    //   343: astore_2
    //   344: aload_3
    //   345: invokevirtual 199	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   348: goto -227 -> 121
    //   351: aload_0
    //   352: getfield 13	rcg:jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback	Lcom/tencent/mobileqq/Doraemon/APICallback;
    //   355: iconst_m1
    //   356: ldc 201
    //   358: invokestatic 81	com/tencent/mobileqq/Doraemon/util/DoraemonUtil:a	(Lcom/tencent/mobileqq/Doraemon/APICallback;ILjava/lang/String;)V
    //   361: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	rcg
    //   0	362	1	paramInt	int
    //   0	362	2	paramArrayOfByte	byte[]
    //   0	362	3	paramBundle	android.os.Bundle
    //   151	138	4	localJSONArray	org.json.JSONArray
    //   194	47	5	str1	java.lang.String
    //   207	47	6	str2	java.lang.String
    //   184	80	7	localObject	java.lang.Object
    //   234	38	8	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   153	166	280	org/json/JSONException
    //   166	277	280	org/json/JSONException
    //   113	119	341	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rcg
 * JD-Core Version:    0.7.0.1
 */