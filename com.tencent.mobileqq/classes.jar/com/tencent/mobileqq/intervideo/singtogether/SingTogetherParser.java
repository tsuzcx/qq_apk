package com.tencent.mobileqq.intervideo.singtogether;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherParser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherControlManager.CacheHolder;
import com.tencent.mobileqq.together.TogetherParser;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.aio.media.aio_media.ResultInfo;
import tencent.aio.media.aio_media.RspLatestPlayingState;
import tencent.aio.media.aio_media.TypeKSing;
import tencent.im.oidb.cmd0x857.TroopTips0x857.SingChangePushInfo;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.KSingRelationInfo;

public class SingTogetherParser
  implements TogetherParser
{
  private QQAppInterface a;
  
  public SingTogetherParser(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, long paramLong5)
  {
    SingTogetherSession localSingTogetherSession = (SingTogetherSession)TogetherUtils.a(4, 2, String.valueOf(paramLong2));
    if (paramInt2 == 1)
    {
      String str;
      if (paramLong1 == 0L) {
        str = "";
      } else {
        str = String.valueOf(paramLong1);
      }
      localSingTogetherSession.r = str;
    }
    if ((paramInt2 == 1) || (paramInt2 == 3) || (paramInt2 == 4)) {
      localSingTogetherSession.a = paramInt1;
    }
    a(paramQQAppInterface, localSingTogetherSession, paramInt2, paramLong1, paramString, paramLong3, paramLong4, null);
    if (((paramInt2 == 5) || (paramInt2 == 2)) && (!TextUtils.isEmpty(paramString))) {
      WatchTogetherParser.a(paramQQAppInterface, paramLong2, 0, paramString, paramInt2, paramLong4, paramLong5, 131087);
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    Oidb_0xd50.KSingRelationInfo localKSingRelationInfo = new Oidb_0xd50.KSingRelationInfo();
    try
    {
      localKSingRelationInfo.mergeFrom(paramArrayOfByte);
      int i = localKSingRelationInfo.flag.get();
      return i == 1;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    a(paramString, -1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, Object paramObject)
  {
    if (!(paramObject instanceof TroopTips0x857.SingChangePushInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, params not right");
      }
      return;
    }
    TroopTips0x857.SingChangePushInfo localSingChangePushInfo = (TroopTips0x857.SingChangePushInfo)paramObject;
    if (localSingChangePushInfo != null)
    {
      long l1;
      if (localSingChangePushInfo.uint64_seq.has()) {
        l1 = localSingChangePushInfo.uint64_seq.get();
      } else {
        l1 = -1L;
      }
      boolean bool = localSingChangePushInfo.uint32_action_type.has();
      int j = -1;
      int i;
      if (bool) {
        i = localSingChangePushInfo.uint32_action_type.get();
      } else {
        i = -1;
      }
      long l2;
      if (localSingChangePushInfo.uint64_group_id.has()) {
        l2 = localSingChangePushInfo.uint64_group_id.get();
      } else {
        l2 = -1L;
      }
      long l3;
      if (localSingChangePushInfo.uint64_oper_uin.has()) {
        l3 = localSingChangePushInfo.uint64_oper_uin.get();
      } else {
        l3 = -1L;
      }
      if (localSingChangePushInfo.uint32_join_nums.has()) {
        j = localSingChangePushInfo.uint32_join_nums.get();
      }
      if (localSingChangePushInfo.bytes_gray_tips.has()) {
        paramObject = localSingChangePushInfo.bytes_gray_tips.get().toStringUtf8();
      } else {
        paramObject = null;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleSingTogetherGroupPush, seq=");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(", actionType=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", groupid=");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append(", uin=");
        ((StringBuilder)localObject).append(l3);
        ((StringBuilder)localObject).append(", joinNum=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", tips=");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("SingTogetherParser", 2, ((StringBuilder)localObject).toString());
      }
      long l4 = ((TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(4, 1, l2);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleSingTogetherGroupPush, oldSeq=");
        ((StringBuilder)localObject).append(l4);
        QLog.d("SingTogetherParser", 2, ((StringBuilder)localObject).toString());
      }
      if (l1 < l4)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("handleSingTogetherGroupPush, skip pushinfo, old seq=");
          paramQQAppInterface.append(l4);
          QLog.d("SingTogetherParser", 2, paramQQAppInterface.toString());
        }
        return;
      }
      SingTogetherSession localSingTogetherSession = (SingTogetherSession)TogetherUtils.a(4, 1, String.valueOf(l2));
      if (i == 1)
      {
        if (l3 == -1L) {
          localObject = "";
        } else {
          localObject = String.valueOf(l3);
        }
        localSingTogetherSession.r = ((String)localObject);
      }
      if ((i == 1) || (i == 3) || (i == 4)) {
        localSingTogetherSession.o = j;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleSingTogetherGroupPush, session");
        ((StringBuilder)localObject).append(localSingTogetherSession);
        QLog.d("SingTogetherParser", 2, ((StringBuilder)localObject).toString());
      }
      a(paramQQAppInterface, localSingTogetherSession, i, l3, paramObject, l1, paramLong1, localSingChangePushInfo);
      if (((i == 5) || (i == 2)) && (!TextUtils.isEmpty(paramObject)) && (l2 != -1L)) {
        WatchTogetherParser.a(paramQQAppInterface, l2, 1, paramObject, i, paramLong1, paramLong2, 131087);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, pushinfo is null.");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SingTogetherSession paramSingTogetherSession, int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3, TroopTips0x857.SingChangePushInfo paramSingChangePushInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherParser", 2, "handleSingTogetherPush");
    }
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    localTogetherControlManager.a(4, paramSingTogetherSession.m, paramSingTogetherSession.n, paramLong2);
    SingTogetherSession localSingTogetherSession2 = (SingTogetherSession)localTogetherControlManager.a(paramSingTogetherSession.l, paramSingTogetherSession.m, paramSingTogetherSession.n);
    SingTogetherSession localSingTogetherSession1;
    if (localSingTogetherSession2 != null)
    {
      if ((paramInt == 1) || (paramInt == 3) || (paramInt == 4)) {
        localSingTogetherSession2.o = paramSingTogetherSession.o;
      }
      if ((paramInt == 1) && (!TextUtils.isEmpty(paramSingTogetherSession.r))) {
        localSingTogetherSession2.r = paramSingTogetherSession.r;
      }
      if ((paramInt != 1) && (paramInt != 3))
      {
        localSingTogetherSession1 = localSingTogetherSession2;
        if (paramInt != 4) {}
      }
      else
      {
        localSingTogetherSession2.a = paramSingTogetherSession.a;
        localSingTogetherSession1 = localSingTogetherSession2;
      }
    }
    else
    {
      localTogetherControlManager.a(paramSingTogetherSession.l, paramSingTogetherSession.m, paramSingTogetherSession.n, paramSingTogetherSession);
      localSingTogetherSession1 = paramSingTogetherSession;
    }
    if (paramInt == 1)
    {
      TogetherUtils.a(paramQQAppInterface, localSingTogetherSession1.n, true, localSingTogetherSession1.m, 16777216);
    }
    else if (paramInt == 2)
    {
      localSingTogetherSession1.p = 3;
      localSingTogetherSession1.q = 3;
      TogetherUtils.a(paramQQAppInterface, localSingTogetherSession1.n, false, localSingTogetherSession1.m, 16777216);
    }
    else if ((paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramLong1))) && ((paramInt == 3) || (paramInt == 4) || (paramInt == 5)))
    {
      TogetherUtils.a(paramQQAppInterface, localSingTogetherSession1.n, true, localSingTogetherSession1.m, 16777216);
    }
    if (localSingTogetherSession1.m == 2)
    {
      paramSingTogetherSession = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(localSingTogetherSession1.n);
      if ((paramSingTogetherSession == null) || (!paramSingTogetherSession.isFriend())) {
        return;
      }
    }
    if (!TextUtils.isEmpty(localSingTogetherSession1.n))
    {
      paramSingTogetherSession = localTogetherControlManager.b(4, localSingTogetherSession1.m, localSingTogetherSession1.n, 1003);
      paramSingTogetherSession.a.putInt("action_type", paramInt);
      paramSingTogetherSession.a.putString("tips", paramString);
      paramSingTogetherSession.a.putLong("seq", paramLong2);
      paramSingTogetherSession.a.putLong("msgSeq", paramLong3);
      paramSingTogetherSession.b = paramSingChangePushInfo;
      if ((!paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramLong1))) && ((paramInt == 2) || (paramInt == 4) || (paramInt == 3)))
      {
        a(true, localSingTogetherSession1, 1003, "");
        return;
      }
      localTogetherControlManager.a(4, localSingTogetherSession1.m, localSingTogetherSession1.n, 1003);
      return;
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 230	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4: astore 18
    //   6: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +93 -> 102
    //   12: new 143	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   19: astore 19
    //   21: aload 19
    //   23: ldc_w 292
    //   26: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 19
    //   32: lload_3
    //   33: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 19
    //   39: ldc_w 294
    //   42: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 19
    //   48: lload 5
    //   50: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 19
    //   56: ldc_w 296
    //   59: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 19
    //   65: aload 18
    //   67: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 19
    //   73: ldc_w 298
    //   76: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 19
    //   82: iload 7
    //   84: invokevirtual 301	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 92
    //   90: iconst_2
    //   91: aload 19
    //   93: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: goto +3 -> 102
    //   102: aload_2
    //   103: ifnull +688 -> 791
    //   106: aload 18
    //   108: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   111: ifne +680 -> 791
    //   114: iload 7
    //   116: ifne +126 -> 242
    //   119: new 303	tencent/im/s2c/msgtype0x210/submsgtype0x127/submsgtype0x127$MsgBody
    //   122: dup
    //   123: invokespecial 304	tencent/im/s2c/msgtype0x210/submsgtype0x127/submsgtype0x127$MsgBody:<init>	()V
    //   126: astore 18
    //   128: aload 18
    //   130: aload_2
    //   131: invokevirtual 305	tencent/im/s2c/msgtype0x210/submsgtype0x127/submsgtype0x127$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   134: pop
    //   135: aload 18
    //   137: getfield 309	tencent/im/s2c/msgtype0x210/submsgtype0x127/submsgtype0x127$MsgBody:join_state	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   140: invokevirtual 312	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   143: istore 8
    //   145: aload 18
    //   147: getfield 313	tencent/im/s2c/msgtype0x210/submsgtype0x127/submsgtype0x127$MsgBody:uint32_action_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   150: invokevirtual 74	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   153: istore 9
    //   155: aload 18
    //   157: getfield 314	tencent/im/s2c/msgtype0x210/submsgtype0x127/submsgtype0x127$MsgBody:uint64_oper_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   160: invokevirtual 107	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   163: ifeq +644 -> 807
    //   166: aload 18
    //   168: getfield 314	tencent/im/s2c/msgtype0x210/submsgtype0x127/submsgtype0x127$MsgBody:uint64_oper_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   171: invokevirtual 110	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   174: lstore 10
    //   176: goto +3 -> 179
    //   179: aload 18
    //   181: getfield 317	tencent/im/s2c/msgtype0x210/submsgtype0x127/submsgtype0x127$MsgBody:uint64_friend_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   184: invokevirtual 107	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   187: ifeq +626 -> 813
    //   190: aload 18
    //   192: getfield 317	tencent/im/s2c/msgtype0x210/submsgtype0x127/submsgtype0x127$MsgBody:uint64_friend_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   195: invokevirtual 110	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   198: lstore 12
    //   200: goto +3 -> 203
    //   203: aload 18
    //   205: getfield 318	tencent/im/s2c/msgtype0x210/submsgtype0x127/submsgtype0x127$MsgBody:uint64_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   208: invokevirtual 107	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   211: ifeq +608 -> 819
    //   214: aload 18
    //   216: getfield 318	tencent/im/s2c/msgtype0x210/submsgtype0x127/submsgtype0x127$MsgBody:uint64_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   219: invokevirtual 110	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   222: lstore 14
    //   224: goto +3 -> 227
    //   227: aload 18
    //   229: getfield 319	tencent/im/s2c/msgtype0x210/submsgtype0x127/submsgtype0x127$MsgBody:bytes_gray_tips	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   232: invokevirtual 135	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   235: invokevirtual 141	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   238: astore_2
    //   239: goto +123 -> 362
    //   242: new 321	tencent/im/s2c/msgtype0x210/submsgtype0x129/submsgtype0x129$MsgBody
    //   245: dup
    //   246: invokespecial 322	tencent/im/s2c/msgtype0x210/submsgtype0x129/submsgtype0x129$MsgBody:<init>	()V
    //   249: astore 18
    //   251: aload 18
    //   253: aload_2
    //   254: invokevirtual 323	tencent/im/s2c/msgtype0x210/submsgtype0x129/submsgtype0x129$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   257: pop
    //   258: aload 18
    //   260: getfield 324	tencent/im/s2c/msgtype0x210/submsgtype0x129/submsgtype0x129$MsgBody:join_state	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   263: invokevirtual 312	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   266: istore 8
    //   268: aload 18
    //   270: getfield 325	tencent/im/s2c/msgtype0x210/submsgtype0x129/submsgtype0x129$MsgBody:uint32_action_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   273: invokevirtual 74	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   276: istore 9
    //   278: aload 18
    //   280: getfield 326	tencent/im/s2c/msgtype0x210/submsgtype0x129/submsgtype0x129$MsgBody:uint64_oper_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   283: invokevirtual 107	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   286: ifeq +539 -> 825
    //   289: aload 18
    //   291: getfield 326	tencent/im/s2c/msgtype0x210/submsgtype0x129/submsgtype0x129$MsgBody:uint64_oper_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   294: invokevirtual 110	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   297: lstore 10
    //   299: goto +3 -> 302
    //   302: aload 18
    //   304: getfield 327	tencent/im/s2c/msgtype0x210/submsgtype0x129/submsgtype0x129$MsgBody:uint64_friend_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   307: invokevirtual 107	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   310: ifeq +521 -> 831
    //   313: aload 18
    //   315: getfield 327	tencent/im/s2c/msgtype0x210/submsgtype0x129/submsgtype0x129$MsgBody:uint64_friend_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   318: invokevirtual 110	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   321: lstore 12
    //   323: goto +3 -> 326
    //   326: aload 18
    //   328: getfield 328	tencent/im/s2c/msgtype0x210/submsgtype0x129/submsgtype0x129$MsgBody:uint64_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   331: invokevirtual 107	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   334: ifeq +503 -> 837
    //   337: aload 18
    //   339: getfield 328	tencent/im/s2c/msgtype0x210/submsgtype0x129/submsgtype0x129$MsgBody:uint64_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   342: invokevirtual 110	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   345: lstore 14
    //   347: goto +3 -> 350
    //   350: aload 18
    //   352: getfield 329	tencent/im/s2c/msgtype0x210/submsgtype0x129/submsgtype0x129$MsgBody:bytes_gray_tips	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   355: invokevirtual 135	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   358: invokevirtual 141	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   361: astore_2
    //   362: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +141 -> 506
    //   368: new 143	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   375: astore 18
    //   377: aload 18
    //   379: ldc_w 331
    //   382: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 18
    //   388: iload 9
    //   390: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload 18
    //   396: ldc_w 333
    //   399: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload 18
    //   405: lload 12
    //   407: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 18
    //   413: ldc_w 335
    //   416: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 18
    //   422: lload 10
    //   424: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 18
    //   430: ldc_w 337
    //   433: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 18
    //   439: aload_2
    //   440: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 18
    //   446: ldc_w 339
    //   449: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 18
    //   455: lload 14
    //   457: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 18
    //   463: ldc_w 341
    //   466: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 18
    //   472: iload 8
    //   474: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload 18
    //   480: ldc_w 343
    //   483: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 18
    //   489: iload 7
    //   491: invokevirtual 301	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: ldc 92
    //   497: iconst_2
    //   498: aload 18
    //   500: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   506: lload 12
    //   508: lconst_0
    //   509: lcmp
    //   510: ifne +52 -> 562
    //   513: new 143	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   520: astore_1
    //   521: aload_1
    //   522: ldc_w 345
    //   525: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload_1
    //   530: lload 12
    //   532: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload_1
    //   537: ldc_w 347
    //   540: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload_1
    //   545: lload 10
    //   547: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: ldc 92
    //   553: iconst_1
    //   554: aload_1
    //   555: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: return
    //   562: iload 7
    //   564: ifeq +286 -> 850
    //   567: iload 9
    //   569: iconst_1
    //   570: if_icmpeq +43 -> 613
    //   573: iload 9
    //   575: iconst_2
    //   576: if_icmpeq +37 -> 613
    //   579: new 143	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   586: astore_1
    //   587: aload_1
    //   588: ldc_w 349
    //   591: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload_1
    //   596: iload 9
    //   598: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: ldc 92
    //   604: iconst_1
    //   605: aload_1
    //   606: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: return
    //   613: aload_1
    //   614: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   617: astore 18
    //   619: aload 18
    //   621: ldc_w 355
    //   624: lconst_0
    //   625: invokeinterface 361 4 0
    //   630: lstore 16
    //   632: lload 14
    //   634: ldc2_w 362
    //   637: ldiv
    //   638: lload 16
    //   640: lcmp
    //   641: ifge +202 -> 843
    //   644: ldc_w 365
    //   647: iconst_2
    //   648: anewarray 4	java/lang/Object
    //   651: dup
    //   652: iconst_0
    //   653: lload 14
    //   655: ldc2_w 362
    //   658: ldiv
    //   659: invokestatic 370	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   662: aastore
    //   663: dup
    //   664: iconst_1
    //   665: lload 16
    //   667: invokestatic 370	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   670: aastore
    //   671: invokestatic 374	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   674: astore_1
    //   675: ldc 92
    //   677: iconst_1
    //   678: aload_1
    //   679: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   682: return
    //   683: aload_1
    //   684: getstatic 174	com/tencent/mobileqq/app/QQManagerFactory:TOGETHER_CONTROLLER_MANAGER	I
    //   687: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   690: checkcast 182	com/tencent/mobileqq/together/TogetherControlManager
    //   693: iconst_4
    //   694: iconst_2
    //   695: lload 12
    //   697: invokevirtual 185	com/tencent/mobileqq/together/TogetherControlManager:a	(IIJ)J
    //   700: lstore 16
    //   702: lload 14
    //   704: lload 16
    //   706: lcmp
    //   707: ifge +42 -> 749
    //   710: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   713: ifeq +140 -> 853
    //   716: new 143	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   723: astore_1
    //   724: aload_1
    //   725: ldc 189
    //   727: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload_1
    //   732: lload 16
    //   734: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: ldc 92
    //   740: iconst_2
    //   741: aload_1
    //   742: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   748: return
    //   749: aload_0
    //   750: aload_1
    //   751: iload 8
    //   753: iload 9
    //   755: lload 10
    //   757: lload 12
    //   759: lload 14
    //   761: aload_2
    //   762: lload_3
    //   763: lload 5
    //   765: invokespecial 376	com/tencent/mobileqq/intervideo/singtogether/SingTogetherParser:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IIJJJLjava/lang/String;JJ)V
    //   768: return
    //   769: astore_1
    //   770: goto +4 -> 774
    //   773: astore_1
    //   774: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq +29 -> 806
    //   780: ldc 92
    //   782: iconst_2
    //   783: ldc_w 378
    //   786: aload_1
    //   787: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   790: return
    //   791: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   794: ifeq +12 -> 806
    //   797: ldc 92
    //   799: iconst_2
    //   800: ldc_w 383
    //   803: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   806: return
    //   807: lconst_0
    //   808: lstore 10
    //   810: goto -631 -> 179
    //   813: lconst_0
    //   814: lstore 12
    //   816: goto -613 -> 203
    //   819: lconst_0
    //   820: lstore 14
    //   822: goto -595 -> 227
    //   825: lconst_0
    //   826: lstore 10
    //   828: goto -526 -> 302
    //   831: lconst_0
    //   832: lstore 12
    //   834: goto -508 -> 326
    //   837: lconst_0
    //   838: lstore 14
    //   840: goto -490 -> 350
    //   843: goto -160 -> 683
    //   846: astore_1
    //   847: goto -73 -> 774
    //   850: goto -167 -> 683
    //   853: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	854	0	this	SingTogetherParser
    //   0	854	1	paramQQAppInterface	QQAppInterface
    //   0	854	2	paramArrayOfByte	byte[]
    //   0	854	3	paramLong1	long
    //   0	854	5	paramLong2	long
    //   0	854	7	paramBoolean	boolean
    //   143	609	8	i	int
    //   153	601	9	j	int
    //   174	653	10	l1	long
    //   198	635	12	l2	long
    //   222	617	14	l3	long
    //   630	103	16	l4	long
    //   4	616	18	localObject	Object
    //   19	73	19	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   675	682	769	java/lang/Exception
    //   683	702	769	java/lang/Exception
    //   710	748	769	java/lang/Exception
    //   749	768	769	java/lang/Exception
    //   119	176	773	java/lang/Exception
    //   179	200	773	java/lang/Exception
    //   203	224	773	java/lang/Exception
    //   227	239	773	java/lang/Exception
    //   242	299	773	java/lang/Exception
    //   302	323	773	java/lang/Exception
    //   326	347	773	java/lang/Exception
    //   350	362	773	java/lang/Exception
    //   362	506	773	java/lang/Exception
    //   513	561	773	java/lang/Exception
    //   579	612	773	java/lang/Exception
    //   613	619	773	java/lang/Exception
    //   619	675	846	java/lang/Exception
  }
  
  public void a(ToServiceMsg paramToServiceMsg, aio_media.RspLatestPlayingState paramRspLatestPlayingState)
  {
    int k = -1;
    int j;
    if (paramToServiceMsg != null) {
      j = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
    } else {
      j = -1;
    }
    Object localObject1 = "";
    if (paramToServiceMsg != null) {
      localObject2 = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
    } else {
      localObject2 = "";
    }
    int i;
    if (paramToServiceMsg != null) {
      i = paramToServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY");
    } else {
      i = -1;
    }
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherParser", 2, "handleGetSingPlayingState, req == null || resp == null || data == null");
      }
      return;
    }
    boolean bool3 = true;
    if ((j != 2) && (j != 1))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("sessionType not right =");
        paramToServiceMsg.append(j);
        QLog.d("SingTogetherParser", 2, paramToServiceMsg.toString());
      }
      return;
    }
    Object localObject4 = (TogetherControlManager)this.a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    paramToServiceMsg = (SingTogetherSession)((TogetherControlManager)localObject4).a(4, j, (String)localObject2);
    Object localObject3 = paramToServiceMsg;
    if (paramToServiceMsg == null)
    {
      localObject3 = (SingTogetherSession)TogetherUtils.a(4, j, (String)localObject2);
      ((TogetherControlManager)localObject4).a(4, j, (String)localObject2, (TogetherSession)localObject3);
    }
    boolean bool4 = ((SingTogetherSession)localObject3).g();
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject2 = localObject1;
    if (bool4) {
      localObject2 = localObject1;
    }
    for (;;)
    {
      try
      {
        localObject4 = (aio_media.ResultInfo)paramRspLatestPlayingState.msg_result.get();
        if (localObject4 != null)
        {
          localObject2 = localObject1;
          k = ((aio_media.ResultInfo)localObject4).uint32_result.get();
        }
        if (k == 0)
        {
          localObject2 = localObject1;
          StringBuilder localStringBuilder = new StringBuilder("handleGetPlayingState seesion=");
          try
          {
            ((SingTogetherSession)localObject3).p = paramRspLatestPlayingState.enum_aio_state.get();
            ((SingTogetherSession)localObject3).q = paramRspLatestPlayingState.enum_user_state.get();
            if (!paramRspLatestPlayingState.uint64_create_uin.has()) {
              break label1105;
            }
            paramToServiceMsg = Long.valueOf(paramRspLatestPlayingState.uint64_create_uin.get());
            ((SingTogetherSession)localObject3).r = String.valueOf(paramToServiceMsg);
            ((SingTogetherSession)localObject3).t = ((aio_media.ResultInfo)localObject4).uint64_svr_time.get();
            ((SingTogetherSession)localObject3).x = paramRspLatestPlayingState.uint64_aio_identification.get();
            localStringBuilder.append(" status=");
            localStringBuilder.append(((SingTogetherSession)localObject3).p);
            localStringBuilder.append(" userState=");
            localStringBuilder.append(((SingTogetherSession)localObject3).q);
            localStringBuilder.append(" creator=");
            localStringBuilder.append(((SingTogetherSession)localObject3).r);
            localStringBuilder.append(" timeStamp=");
            localStringBuilder.append(((SingTogetherSession)localObject3).t);
            if (paramRspLatestPlayingState.msg_ksing_info.has())
            {
              ((SingTogetherSession)localObject3).d = paramRspLatestPlayingState.msg_ksing_info.uint32_type.get();
              ((SingTogetherSession)localObject3).b = paramRspLatestPlayingState.msg_ksing_info.uint64_id.get();
              ((SingTogetherSession)localObject3).c = paramRspLatestPlayingState.msg_ksing_info.bytes_name.get().toStringUtf8();
              ((SingTogetherSession)localObject3).e = paramRspLatestPlayingState.msg_ksing_info.bytes_jump.get().toStringUtf8();
              ((SingTogetherSession)localObject3).f = paramRspLatestPlayingState.msg_ksing_info.bytes_cover.get().toStringUtf8();
              ((SingTogetherSession)localObject3).h = paramRspLatestPlayingState.msg_ksing_info.bytes_song.get().toStringUtf8();
              ((SingTogetherSession)localObject3).g = paramRspLatestPlayingState.msg_ksing_info.uint64_singer.get();
              localStringBuilder.append(" roomType=");
              localStringBuilder.append(((SingTogetherSession)localObject3).d);
              localStringBuilder.append(" roomId=");
              localStringBuilder.append(((SingTogetherSession)localObject3).b);
              localStringBuilder.append(" roomName=");
              localStringBuilder.append(((SingTogetherSession)localObject3).c);
              localStringBuilder.append(" jumpUrl=");
              localStringBuilder.append(((SingTogetherSession)localObject3).e);
              localStringBuilder.append(" roomCover=");
              localStringBuilder.append(((SingTogetherSession)localObject3).f);
              localStringBuilder.append(" songName=");
              localStringBuilder.append(((SingTogetherSession)localObject3).h);
              localStringBuilder.append(" singerUin=");
              localStringBuilder.append(((SingTogetherSession)localObject3).g);
            }
            if (j == 1)
            {
              ((SingTogetherSession)localObject3).o = paramRspLatestPlayingState.uint32_joined_num.get();
              localStringBuilder.append(" joinNum=");
              localStringBuilder.append(((SingTogetherSession)localObject3).o);
            }
            else
            {
              if (paramRspLatestPlayingState.enum_c2c_join_state.has()) {
                j = paramRspLatestPlayingState.enum_c2c_join_state.get();
              } else {
                j = ((SingTogetherSession)localObject3).a;
              }
              ((SingTogetherSession)localObject3).a = j;
              localStringBuilder.append(" c2cStatus=");
              localStringBuilder.append(((SingTogetherSession)localObject3).a);
            }
            paramToServiceMsg = (ToServiceMsg)localObject1;
            bool1 = bool3;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("SingTogetherParser", 2, localStringBuilder.toString());
            paramToServiceMsg = (ToServiceMsg)localObject1;
            bool1 = bool3;
          }
          catch (Exception paramToServiceMsg)
          {
            bool1 = true;
            continue;
          }
        }
        else
        {
          paramToServiceMsg = (ToServiceMsg)localObject1;
          if (localObject4 != null)
          {
            paramToServiceMsg = (ToServiceMsg)localObject1;
            localObject2 = localObject1;
            if (((aio_media.ResultInfo)localObject4).bytes_errmsg.get() != null)
            {
              localObject2 = localObject1;
              paramToServiceMsg = ((aio_media.ResultInfo)localObject4).bytes_errmsg.get().toStringUtf8();
            }
          }
          localObject2 = paramToServiceMsg;
          QLog.d("SingTogetherParser", 1, String.format("handleGetSingPlayingState, result = %s, errTips = %s", new Object[] { Integer.valueOf(k), paramToServiceMsg }));
          bool1 = false;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        localObject1 = localObject2;
        QLog.d("SingTogetherParser", 1, "handleGetSingPlayingState exception", paramToServiceMsg);
        paramToServiceMsg = (ToServiceMsg)localObject1;
      }
      localObject2 = paramToServiceMsg;
      bool2 = bool1;
      if (!TextUtils.isEmpty(((SingTogetherSession)localObject3).r)) {
        if (((SingTogetherSession)localObject3).m == 2)
        {
          ContactUtils.j(this.a, ((SingTogetherSession)localObject3).r);
          localObject2 = paramToServiceMsg;
          bool2 = bool1;
        }
        else
        {
          ContactUtils.b(this.a, ((SingTogetherSession)localObject3).n, ((SingTogetherSession)localObject3).r);
          bool2 = bool1;
          localObject2 = paramToServiceMsg;
        }
      }
      a(bool2, (SingTogetherSession)localObject3, i, (String)localObject2);
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetSingPlayingState, isSuccess=");
        paramToServiceMsg.append(bool2);
        paramToServiceMsg.append(", session= ");
        paramToServiceMsg.append(localObject3);
        paramToServiceMsg.append(", by=");
        paramToServiceMsg.append(i);
        QLog.d("SingTogetherParser", 2, paramToServiceMsg.toString());
      }
      return;
      label1105:
      paramToServiceMsg = "";
    }
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = ((TogetherControlManager)this.a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(4, 2, String.valueOf(paramObject));
    if ((paramObject instanceof SingTogetherSession))
    {
      paramObject.p = 3;
      paramObject.q = 3;
      TogetherUtils.a(this.a, paramObject.n, false, paramObject.m, 16777216);
      a(true, (SingTogetherSession)paramObject, 1007, "");
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = ((TogetherControlManager)this.a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(4, 1, paramString);
    if ((paramString instanceof SingTogetherSession))
    {
      paramString.p = 3;
      paramString.q = 3;
      TogetherUtils.a(this.a, paramString.n, false, paramString.m, 16777216);
      a(true, (SingTogetherSession)paramString, 1007, "");
    }
  }
  
  public void a(boolean paramBoolean, SingTogetherSession paramSingTogetherSession, int paramInt, String paramString)
  {
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)this.a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    TogetherControlManager.CacheHolder localCacheHolder = localTogetherControlManager.b(4, paramSingTogetherSession.m, paramSingTogetherSession.n, paramInt);
    if ((paramBoolean) && (paramInt == 1003))
    {
      int i = localCacheHolder.a.getInt("action_type");
      String str = localCacheHolder.a.getString("tips");
      long l1 = localCacheHolder.a.getLong("seq");
      long l2 = localCacheHolder.a.getLong("msgSeq");
      localTogetherControlManager.a(paramSingTogetherSession, i, str, l1, l2, localCacheHolder.b);
      localTogetherControlManager.b(paramSingTogetherSession, i, str, l1, l2, localCacheHolder.b);
    }
    if (paramSingTogetherSession.p == 3) {
      TogetherUtils.a(this.a, paramSingTogetherSession.n, false, paramSingTogetherSession.m, 16777216);
    } else {
      TogetherUtils.a(this.a, paramSingTogetherSession.n, true, paramSingTogetherSession.m, 16777216);
    }
    localTogetherControlManager.a(paramBoolean, paramSingTogetherSession, paramInt, paramString);
    localTogetherControlManager.c(4, paramSingTogetherSession.m, paramSingTogetherSession.n, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.SingTogetherParser
 * JD-Core Version:    0.7.0.1
 */