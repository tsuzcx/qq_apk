package com.tencent.mobileqq.listentogether;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x857.TroopTips0x857.MediaChangePushInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f.MediaUserInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f.MsgBody;

public class ListenTogetherPushHelper
{
  private static String a = "ListenTogether.PushHelper";
  private static String b = "is_open_with_open";
  private static final String c = HardCodeUtil.a(2131891216);
  private static final String d = HardCodeUtil.a(2131891220);
  
  private static void a(int paramInt1, String paramString1, int paramInt2, String paramString2, UniteGrayTipParam paramUniteGrayTipParam)
  {
    if (paramInt2 == 31)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, String.format("dealGrayTipsJoin uinType=%d uin=%s subType=%d operUin=%s", new Object[] { Integer.valueOf(paramInt1), MobileQQ.getShortUinStr(paramString1), Integer.valueOf(paramInt2), paramString2 }));
      }
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a((QQAppInterface)localObject);
      if (paramInt1 == 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      boolean bool = localListenTogetherManager.d(paramInt1, paramString1);
      paramString2 = TogetherUtils.a(16, ListenTogetherUtils.a((QQAppInterface)localObject, paramString1, paramInt1, paramString2));
      localObject = BaseApplicationImpl.getApplication().getResources();
      if (bool)
      {
        paramString1 = "";
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append(" ");
        paramString1.append(d);
        paramString1 = paramString1.toString();
      }
      paramString1 = ((Resources)localObject).getString(2131891241, new Object[] { paramString2, paramString1 });
      paramUniteGrayTipParam.g = paramString1;
      paramInt1 = paramString1.indexOf(d);
      if (paramInt1 != -1)
      {
        paramString1 = new Bundle();
        paramString1.putInt("key_action", 59);
        paramUniteGrayTipParam.a(paramInt1, d.length() + paramInt1, paramString1);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, TroopTips0x857.MediaChangePushInfo paramMediaChangePushInfo)
  {
    if (paramMediaChangePushInfo != null)
    {
      Bundle localBundle = new Bundle();
      int i;
      if (paramMediaChangePushInfo.uint32_msg_type.has()) {
        i = paramMediaChangePushInfo.uint32_msg_type.get();
      } else {
        i = -1;
      }
      if (paramMediaChangePushInfo.bytes_msg_info.has()) {
        paramMediaChangePushInfo.bytes_msg_info.get().toStringUtf8();
      }
      String str1;
      if (paramMediaChangePushInfo.uint64_group_id.has()) {
        str1 = String.valueOf(paramMediaChangePushInfo.uint64_group_id.get());
      } else {
        str1 = "";
      }
      String str2;
      if (paramMediaChangePushInfo.uint64_oper_uin.has()) {
        str2 = String.valueOf(paramMediaChangePushInfo.uint64_oper_uin.get());
      } else {
        str2 = "";
      }
      String str3;
      if (paramMediaChangePushInfo.bytes_gray_tips.has()) {
        str3 = paramMediaChangePushInfo.bytes_gray_tips.get().toStringUtf8();
      } else {
        str3 = "";
      }
      long l1;
      if (paramMediaChangePushInfo.uint64_msg_seq.has()) {
        l1 = paramMediaChangePushInfo.uint64_msg_seq.get();
      } else {
        l1 = 0L;
      }
      int j;
      if (paramMediaChangePushInfo.uint32_join_nums.has()) {
        j = paramMediaChangePushInfo.uint32_join_nums.get();
      } else {
        j = 0;
      }
      boolean bool = paramMediaChangePushInfo.is_join_when_start.get();
      localBundle.putBoolean(b, bool);
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeGroupPush, msg_type = ");
        localStringBuilder.append(i);
        localStringBuilder.append(" groupUin = ");
        localStringBuilder.append(str1);
        localStringBuilder.append(" oper_uin = ");
        localStringBuilder.append(str2);
        localStringBuilder.append(" gray_tips = ");
        localStringBuilder.append(str3);
        localStringBuilder.append(" timeStamp = ");
        localStringBuilder.append(l1);
        localStringBuilder.append(" joinedNum = ");
        localStringBuilder.append(j);
        localStringBuilder.append(" isOpenWithJoin = ");
        localStringBuilder.append(bool);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      Object localObject = (ListenTogetherManager)paramQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
      long l2 = ((ListenTogetherManager)localObject).f(1, str1);
      if (l1 < l2)
      {
        QLog.d(a, 1, String.format("decodeGroupPush, filter oldTimeStamp: %s, timeStamp: %s, msyType: %s, groupUin: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), str1 }));
        return;
      }
      if ((i == 31) || (i == 32)) {
        ((ListenTogetherManager)localObject).a(1, str1, paramLong1, l1, ListenTogetherUtils.a(1, j, 0));
      }
      if (i == 16) {
        paramMediaChangePushInfo = Integer.valueOf(paramMediaChangePushInfo.uint32_play_mode.get());
      } else {
        paramMediaChangePushInfo = null;
      }
      ((ListenTogetherManager)localObject).a(1, str1, paramLong1, str2, i, l1, paramMediaChangePushInfo);
      a(paramQQAppInterface, str1, 1, str3, i, str2, paramLong1, paramLong2, localBundle);
      return;
    }
    QLog.d(a, 1, "decodeGroupPush, pushInfo == null");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    int i;
    if ((paramInt2 == 31) && (TextUtils.isEmpty(paramString3))) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if ((paramInt2 == 31) && (paramInt1 != 1)) {
      j = 0;
    } else {
      j = 1;
    }
    int k;
    if ((paramInt2 == 31) && (paramString3.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()))) {
      k = 0;
    } else {
      k = 1;
    }
    int m;
    if ((paramInt2 != 31) && (TextUtils.isEmpty(paramString2))) {
      m = 0;
    } else {
      m = 1;
    }
    boolean bool2 = paramBundle.getBoolean(b, false);
    int n;
    if ((paramInt2 == 31) && (bool2)) {
      n = 0;
    } else {
      n = 1;
    }
    if (!((bool1 ^ true) & i & j & k & m & n)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insertGrayTips begin uin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" uinType:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" grayTips:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" sub_type:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" operUin:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" msgSeq:");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" msgTime:");
      localStringBuilder.append(paramLong2);
      QLog.i(paramBundle, 2, localStringBuilder.toString());
    }
    if ((paramInt2 != 1) && (paramInt2 != 3) && (paramInt2 != 2) && (paramInt2 != 4)) {
      i = -5020;
    } else {
      i = -5040;
    }
    paramBundle = new UniteGrayTipParam(paramString1, paramString1, paramString2, paramInt1, i, 131083, MessageCache.c());
    a(paramString2, paramInt2, paramBundle);
    a(paramInt1, paramString1, paramInt2, paramString3, paramBundle);
    paramString2 = new MessageForUniteGrayTip();
    paramString2.hasRead = 0;
    paramString2.subType = paramInt2;
    paramString2.initGrayTipMsg(paramQQAppInterface, paramBundle);
    paramString3 = paramString2.tipParam;
    paramBundle = new StringBuilder();
    paramBundle.append(paramString1);
    paramBundle.append("_");
    paramBundle.append(paramInt1);
    paramBundle.append("_listen_together_");
    paramBundle.append(paramLong1);
    paramBundle.append("_");
    paramBundle.append(paramLong2);
    paramString3.p = paramBundle.toString();
    bool1 = UniteGrayTipMsgUtil.a(paramQQAppInterface, paramString2);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = a;
      paramString1 = new StringBuilder();
      paramString1.append("insertGrayTips end  res:");
      paramString1.append(bool1);
      paramString1.append(" grayTipKey:");
      paramString1.append(paramString2.tipParam.p);
      QLog.i(paramQQAppInterface, 2, paramString1.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("decodePush0x210_0x11f, msgSeq = ");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append(" msgTime = ");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append(" selfUin:");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(" isOffline = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    int i;
    String str2;
    long l1;
    if ((paramArrayOfByte != null) && (!TextUtils.isEmpty(str1)))
    {
      SubMsgType0x11f.MsgBody localMsgBody;
      Object localObject3;
      label228:
      long l2;
      label295:
      try
      {
        localMsgBody = new SubMsgType0x11f.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        i = localMsgBody.uint32_msg_type.get();
        str2 = String.valueOf(localMsgBody.uint64_oper_uin.get());
        if (!localMsgBody.uint64_msg_seq.has()) {
          break label885;
        }
        l1 = localMsgBody.uint64_msg_seq.get();
        localObject1 = localMsgBody.rpt_msg_media_uin.get();
        paramArrayOfByte = "";
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label900;
        }
        localObject3 = ((List)localObject1).iterator();
        localObject1 = "";
        if (!((Iterator)localObject3).hasNext()) {
          break label897;
        }
        SubMsgType0x11f.MediaUserInfo localMediaUserInfo = (SubMsgType0x11f.MediaUserInfo)((Iterator)localObject3).next();
        localObject2 = String.valueOf(localMediaUserInfo.uint64_to_uin.get());
        int j = localMediaUserInfo.uint32_join_state.get();
        if (!str1.equals(localObject2)) {
          break label891;
        }
        localObject1 = ListenTogetherUtils.a(2, 0, j);
      }
      catch (Throwable paramQQAppInterface) {}
      str1 = localMsgBody.bytes_gray_tips.get().toStringUtf8();
      if (QLog.isColorLevel())
      {
        localObject2 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("decodePush0x210_0x11f, msg_type = ");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append(" friend_uin = ");
        ((StringBuilder)localObject3).append(paramArrayOfByte);
        ((StringBuilder)localObject3).append(" oper_uin = ");
        ((StringBuilder)localObject3).append(str2);
        ((StringBuilder)localObject3).append(" gray_tips = ");
        ((StringBuilder)localObject3).append(str1);
        ((StringBuilder)localObject3).append(" timeStamp = ");
        ((StringBuilder)localObject3).append(l1);
        ((StringBuilder)localObject3).append(" statusTips = ");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if ((!TextUtils.isEmpty(paramArrayOfByte)) && (!TextUtils.isEmpty(str2)))
      {
        if (!paramBoolean) {
          break label909;
        }
        if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
        {
          paramQQAppInterface = a;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("filter offline msg, msgType:");
          paramArrayOfByte.append(i);
          QLog.d(paramQQAppInterface, 1, paramArrayOfByte.toString());
          return;
        }
        localObject2 = paramQQAppInterface.getPreferences();
        l2 = l1;
        long l3 = ((SharedPreferences)localObject2).getLong("inccheckupdatetimeStamp17", 0L);
        if (l2 / 1000L < l3)
        {
          QLog.d(a, 1, String.format("filter offline msg, timestamp: %s < incUpdateTimeStamp: %s", new Object[] { Long.valueOf(l2 / 1000L), Long.valueOf(l3) }));
          return;
        }
        label594:
        localObject2 = (ListenTogetherManager)paramQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
        l2 = ((ListenTogetherManager)localObject2).f(2, paramArrayOfByte);
        if (l1 <= l2) {
          paramQQAppInterface = a;
        }
      }
      try
      {
        QLog.d(paramQQAppInterface, 1, String.format("decodePush0x210_0x11f, filter oldTimeStamp: %s, timeStamp: %s, msyType: %s, friendUin: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), paramArrayOfByte }));
        return;
      }
      catch (Throwable paramQQAppInterface) {}
      if ((i != 31) && (i != 32)) {
        break label703;
      }
      ((ListenTogetherManager)localObject2).a(2, paramArrayOfByte, paramLong1, l1, (String)localObject1);
      label703:
      if (i != 16) {
        break label912;
      }
      localObject1 = Integer.valueOf(localMsgBody.uint32_play_mode.get());
    }
    for (;;)
    {
      ((ListenTogetherManager)localObject2).a(2, paramArrayOfByte, paramLong1, str2, i, l1, localObject1);
      localObject1 = new Bundle();
      a(paramQQAppInterface, paramArrayOfByte, 0, str1, i, str2, paramLong1, paramLong2, (Bundle)localObject1);
      return;
      paramQQAppInterface = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("filter friendUin: ");
      ((StringBuilder)localObject1).append(paramArrayOfByte);
      ((StringBuilder)localObject1).append(", operatorUin: ");
      ((StringBuilder)localObject1).append(str2);
      QLog.d(paramQQAppInterface, 1, ((StringBuilder)localObject1).toString());
      return;
      paramArrayOfByte = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodePush0x210_0x11f decode error, e=");
      ((StringBuilder)localObject1).append(paramQQAppInterface.toString());
      QLog.i(paramArrayOfByte, 1, ((StringBuilder)localObject1).toString());
      return;
      QLog.i(a, 1, "decodePush0x210_0x11f pbData = null");
      return;
      label885:
      l1 = 0L;
      break;
      label891:
      paramArrayOfByte = (byte[])localObject2;
      break label228;
      label897:
      break label295;
      label900:
      paramArrayOfByte = "";
      localObject1 = paramArrayOfByte;
      break label295;
      label909:
      break label594;
      label912:
      localObject1 = null;
    }
  }
  
  private static void a(String paramString, int paramInt, UniteGrayTipParam paramUniteGrayTipParam)
  {
    if ((paramInt == 1) || (paramInt == 3))
    {
      paramInt = paramString.indexOf(c);
      if (paramInt != -1)
      {
        paramString = new Bundle();
        paramString.putInt("key_action", 46);
        paramUniteGrayTipParam.a(paramInt, paramInt + 4, paramString);
        return;
      }
      QLog.d(a, 1, String.format("grayTips: %s don't contain keyword", new Object[] { paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherPushHelper
 * JD-Core Version:    0.7.0.1
 */