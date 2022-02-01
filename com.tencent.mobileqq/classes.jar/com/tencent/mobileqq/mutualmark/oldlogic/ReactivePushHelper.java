package com.tencent.mobileqq.mutualmark.oldlogic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.mutualmark.MutualMarkGrayTipsHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils.ImageUrlTemplateInfo;
import com.tencent.mobileqq.mutualmark.UrlBottomImageSpan;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ToDegradeInfo;

public class ReactivePushHelper
{
  public static SpannableStringBuilder a(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (!TextUtils.isEmpty(paramSpannableStringBuilder))
    {
      if (paramContext == null) {
        return paramSpannableStringBuilder;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateReactiveIconResource start:");
      ((StringBuilder)localObject1).append(paramSpannableStringBuilder);
      QLog.i("ReactivePushHelper", 1, ((StringBuilder)localObject1).toString());
      localObject3 = paramSpannableStringBuilder.toString();
      localObject2 = localObject3;
    }
    for (;;)
    {
      try
      {
        int k = ViewUtils.dpToPx(16.0F);
        localObject2 = localObject3;
        Object localObject4 = MutualMarkUtils.c();
        localObject2 = localObject3;
        ArrayList localArrayList = new ArrayList();
        localObject2 = localObject3;
        Object localObject5 = MutualMarkUtils.e((String)localObject3);
        localObject1 = localObject3;
        Object localObject6;
        if (localObject5 != null)
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (!((ArrayList)localObject5).isEmpty())
          {
            localObject2 = localObject3;
            localObject5 = ((ArrayList)localObject5).iterator();
            i = 0;
            localObject2 = localObject3;
            if (((Iterator)localObject5).hasNext())
            {
              localObject2 = localObject3;
              localObject6 = (MutualMarkUtils.ImageUrlTemplateInfo)((Iterator)localObject5).next();
              localObject2 = localObject3;
              j = i;
              if (TextUtils.isEmpty(((MutualMarkUtils.ImageUrlTemplateInfo)localObject6).d)) {
                break label763;
              }
              localObject2 = localObject3;
              UrlBottomImageSpan localUrlBottomImageSpan = new UrlBottomImageSpan(paramContext, 0, ((MutualMarkUtils.ImageUrlTemplateInfo)localObject6).d, ViewUtils.dpToPx(16.0F), null);
              localObject1 = "[icon]";
              localObject2 = localObject3;
              if (!TextUtils.isEmpty(((MutualMarkUtils.ImageUrlTemplateInfo)localObject6).e))
              {
                localObject2 = localObject3;
                localObject1 = ((MutualMarkUtils.ImageUrlTemplateInfo)localObject6).e;
              }
              localObject2 = localObject3;
              ((MutualMarkUtils.ImageUrlTemplateInfo)localObject6).a += i;
              localObject2 = localObject3;
              ((MutualMarkUtils.ImageUrlTemplateInfo)localObject6).b += i;
              localObject2 = localObject3;
              paramSpannableStringBuilder.replace(((MutualMarkUtils.ImageUrlTemplateInfo)localObject6).a, ((MutualMarkUtils.ImageUrlTemplateInfo)localObject6).b, (CharSequence)localObject1);
              localObject2 = localObject3;
              paramSpannableStringBuilder.setSpan(localUrlBottomImageSpan, ((MutualMarkUtils.ImageUrlTemplateInfo)localObject6).a, ((MutualMarkUtils.ImageUrlTemplateInfo)localObject6).a + ((String)localObject1).length(), 33);
              localObject2 = localObject3;
              j = i + (((MutualMarkUtils.ImageUrlTemplateInfo)localObject6).a + ((String)localObject1).length() - ((MutualMarkUtils.ImageUrlTemplateInfo)localObject6).b);
              break label763;
            }
            localObject2 = localObject3;
            localObject1 = paramSpannableStringBuilder.toString();
          }
        }
        localObject2 = localObject1;
        localObject3 = ((List)localObject4).iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = localObject1;
          localObject4 = (String)((Iterator)localObject3).next();
          localObject2 = localObject1;
          j = ((String)localObject1).indexOf((String)localObject4);
          i = j;
          if (j == -1) {
            continue;
          }
          if (i >= 0)
          {
            localObject2 = localObject1;
            localObject5 = localArrayList.iterator();
            localObject2 = localObject1;
            if (!((Iterator)localObject5).hasNext()) {
              break label768;
            }
            localObject2 = localObject1;
            localObject6 = (Pair)((Iterator)localObject5).next();
            localObject2 = localObject1;
            if (i < ((Integer)((Pair)localObject6).first).intValue()) {
              continue;
            }
            localObject2 = localObject1;
            if (i >= ((Integer)((Pair)localObject6).second).intValue()) {
              continue;
            }
            j = 1;
            if (j == 0)
            {
              localObject2 = localObject1;
              if (MutualMarkUtils.b.containsKey(localObject4))
              {
                localObject2 = localObject1;
                localObject5 = (Integer)MutualMarkUtils.b.get(localObject4);
                if (localObject5 != null)
                {
                  localObject2 = localObject1;
                  if (((Integer)localObject5).intValue() != 0)
                  {
                    localObject2 = localObject1;
                    localObject5 = paramContext.getResources().getDrawable(((Integer)localObject5).intValue());
                    if (localObject5 != null)
                    {
                      localObject2 = localObject1;
                      ((Drawable)localObject5).setBounds(0, 0, k, k);
                      localObject2 = localObject1;
                      paramSpannableStringBuilder.setSpan(new ImageSpan((Drawable)localObject5, 0), i, ((String)localObject4).length() + i, 33);
                      localObject2 = localObject1;
                      localArrayList.add(new Pair(Integer.valueOf(i), Integer.valueOf(((String)localObject4).length() + i)));
                    }
                  }
                }
              }
            }
            localObject2 = localObject1;
            i = ((String)localObject1).indexOf((String)localObject4, i + ((String)localObject4).length());
            continue;
          }
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateReactiveIconResource exception:");
        ((StringBuilder)localObject1).append(paramContext);
        QLog.e("ReactivePushHelper", 1, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
      paramContext = new StringBuilder();
      paramContext.append("removeReactiveIconResource end:");
      paramContext.append((String)localObject1);
      QLog.i("ReactivePushHelper", 1, paramContext.toString());
      return paramSpannableStringBuilder;
      label763:
      int i = j;
      continue;
      label768:
      int j = 0;
    }
  }
  
  public static SpannableStringBuilder a(Context paramContext, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null)) {
      return a(paramContext, new SpannableStringBuilder(paramString));
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeReactiveIconResource start:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("ReactivePushHelper", 1, ((StringBuilder)localObject).toString());
    paramString = paramString.replaceAll("[icon]", "");
    localObject = MutualMarkUtils.e(paramString).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString = paramString.replaceAll(((MutualMarkUtils.ImageUrlTemplateInfo)((Iterator)localObject).next()).c, "");
    }
    localObject = MutualMarkUtils.c().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (paramString.contains(str)) {
        paramString = paramString.replaceAll(str, "");
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeReactiveIconResource end:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("ReactivePushHelper", 1, ((StringBuilder)localObject).toString());
    return paramString;
  }
  
  private static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, PushMsg0x210C7Info paramPushMsg0x210C7Info, int paramInt2, int paramInt3, long paramLong, String paramString5)
  {
    Object localObject = paramString2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insertGrayTips uin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" grayTips:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" nick:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" lNotifyTime:");
      localStringBuilder.append(paramLong);
      QLog.i("ReactivePushHelper", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString2 = (String)localObject;
    if (((String)localObject).contains("#nick")) {
      paramString2 = ((String)localObject).replaceAll("#nick", paramString3);
    }
    paramString3 = new StringBuilder(paramString2);
    paramString2 = MutualMarkGrayTipsHelper.a(paramAppInterface, paramString5, paramString3);
    paramString3 = new UniteGrayTipParam(paramString5, paramString5, paramString3.toString(), 0, paramInt1, paramInt2, MessageCache.c());
    paramString5 = new MessageForUniteGrayTip();
    paramString5.hasRead = 0;
    paramString5.subType = paramInt3;
    paramString5.initGrayTipMsg(paramAppInterface, paramString3);
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString5.tipParam.p = paramString4;
    }
    else
    {
      paramString4 = paramString5.tipParam;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("_reactive_");
      ((StringBuilder)localObject).append(paramPushMsg0x210C7Info.b);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramLong);
      paramString4.p = ((StringBuilder)localObject).toString();
    }
    MutualMarkGrayTipsHelper.a(paramString3, paramString2);
    paramString5.saveExtInfoToExtStr("mutualmark_WillDowngradeSoon", "true");
    UniteGrayTipMsgUtil.a(paramAppInterface, paramString5);
    ReportController.b(paramAppInterface, "dc00898", "", "", "0X800A1BC", "0X800A1BC", 0, 0, "", "", "", "");
    long l = System.currentTimeMillis() / 1000L;
    if (a(paramAppInterface, paramLong, l, "0"))
    {
      paramString2 = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getLastMessage(paramString5.frienduin, paramString5.istroop);
      ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).setIncomingMsg(paramString2);
      ((QQAppInterface)paramAppInterface).handleReceivedMessage(1, true, true);
      ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).setIncomingMsg(null);
      ReportController.b(paramAppInterface, "dc00898", "", "", "0X800A1BE", "0X800A1BE", 1, 0, "", "", "", "");
      b(paramAppInterface, paramLong, l, "0");
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("ShowNotification, localtime:");
        paramAppInterface.append(l);
        paramAppInterface.append(" servertime:");
        paramAppInterface.append(paramLong);
        paramAppInterface.append(" frienduin:");
        paramAppInterface.append(paramString1);
        QLog.d("ReactivePushHelper", 2, paramAppInterface.toString());
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("decodeC2CMsgPkgSubMsgType0xc7 app:");
    ((StringBuilder)localObject).append(paramAppInterface);
    ((StringBuilder)localObject).append("  changeInfo:");
    ((StringBuilder)localObject).append(paramRelationalChainChange);
    ((StringBuilder)localObject).append("  msginfo:");
    ((StringBuilder)localObject).append(paramPushMsg0x210C7Info);
    QLog.i("ReactivePushHelper", 1, ((StringBuilder)localObject).toString());
    if ((paramAppInterface != null) && (paramRelationalChainChange != null))
    {
      if (paramPushMsg0x210C7Info == null) {
        return;
      }
      long l = paramRelationalChainChange.uint64_src_uin.get();
      localObject = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
      if (TextUtils.equals(paramAppInterface.getCurrentAccountUin(), String.valueOf(l)))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        int i = paramRelationalChainChange.uint32_change_type.get();
        FriendsManager localFriendsManager = (FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Friends localFriends = localFriendsManager.m((String)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeC2CMsgPkgSubMsgType0xc7 friend:");
        localStringBuilder.append(localFriends);
        localStringBuilder.append(" changeType:");
        localStringBuilder.append(i);
        QLog.i("ReactivePushHelper", 1, localStringBuilder.toString());
        if ((localFriends != null) && (!localFriends.isFriend()))
        {
          QLog.i("ReactivePushHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 is not friend");
          return;
        }
        if (localFriendsManager.x((String)localObject) == null) {
          new ExtensionInfo().uin = ((String)localObject);
        }
        if ((i != 1) && (i != 2) && (i != 3)) {
          switch (i)
          {
          default: 
          case 10001: 
            a(paramAppInterface, paramRelationalChainChange, (String)localObject, paramPushMsg0x210C7Info);
          }
        }
      }
    }
  }
  
  private static void a(AppInterface paramAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, String paramString, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    boolean bool = paramRelationalChainChange.msg_to_degrade_info.has();
    Object localObject = null;
    submsgtype0xc7.ToDegradeInfo localToDegradeInfo;
    if (bool) {
      localToDegradeInfo = (submsgtype0xc7.ToDegradeInfo)paramRelationalChainChange.msg_to_degrade_info.get();
    } else {
      localToDegradeInfo = null;
    }
    if (localToDegradeInfo == null) {
      return;
    }
    paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject;
    if (localToDegradeInfo.bytes_nick.has()) {
      paramRelationalChainChange = localToDegradeInfo.bytes_nick.get().toStringUtf8();
    }
    long l;
    if (localToDegradeInfo.notify_time.has()) {
      l = localToDegradeInfo.notify_time.get();
    } else {
      l = 0L;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onWillDowngradeSoon, nick:");
      ((StringBuilder)localObject).append(paramRelationalChainChange);
      ((StringBuilder)localObject).append(" notifytime:");
      ((StringBuilder)localObject).append(l);
      QLog.i("ReactivePushHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (!a(paramAppInterface, l, paramString)) {
      return;
    }
    if (TextUtils.isEmpty(paramRelationalChainChange))
    {
      paramRelationalChainChange = ContactUtils.g(paramAppInterface, paramString);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onWillDowngradeSoon, local nick:");
        ((StringBuilder)localObject).append(paramRelationalChainChange);
        QLog.i("ReactivePushHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (localToDegradeInfo.uint32_graytip_type.has()) {
      i = localToDegradeInfo.uint32_graytip_type.get();
    } else {
      i = 0;
    }
    int i = MutualMarkGrayTipsHelper.a(i);
    bool = localToDegradeInfo.bytes_duplicate_removal.has();
    String str = "";
    if (bool) {
      localObject = localToDegradeInfo.bytes_duplicate_removal.get().toStringUtf8();
    } else {
      localObject = "";
    }
    if (localToDegradeInfo.bytes_wildcard_wording.has()) {
      str = localToDegradeInfo.bytes_wildcard_wording.get().toStringUtf8();
    }
    if ((!TextUtils.isEmpty(str)) && (!MutualMarkUtils.a(paramAppInterface))) {
      a(paramAppInterface, paramString, str, paramRelationalChainChange, i, (String)localObject, paramPushMsg0x210C7Info, 2097155, 0, l, paramString);
    }
    b(paramAppInterface, l, paramString);
  }
  
  private static boolean a(AppInterface paramAppInterface, long paramLong1, long paramLong2, String paramString)
  {
    return false;
  }
  
  private static boolean a(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    if (paramAppInterface == null) {
      return false;
    }
    long l = SharedPreUtils.y(BaseApplicationImpl.getContext(), paramAppInterface.getCurrentUin(), paramString);
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("needShowTips, LastTime:");
      paramAppInterface.append(l);
      paramAppInterface.append(" servertime:");
      paramAppInterface.append(paramLong);
      paramAppInterface.append(" frienduin:");
      paramAppInterface.append(paramString);
      QLog.d("ReactivePushHelper", 2, paramAppInterface.toString());
    }
    if (l == 0L) {
      return true;
    }
    return paramLong != l;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (paramQQAppInterface == null) {
        return false;
      }
      if (paramMessage.msgtype != -5040) {
        return false;
      }
      try
      {
        paramQQAppInterface = (MessageForUniteGrayTip)paramQQAppInterface.getMessageFacade().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
      }
      catch (Exception paramQQAppInterface)
      {
        paramMessage = new StringBuilder();
        paramMessage.append("query msg exception:");
        paramMessage.append(paramQQAppInterface.toString());
        QLog.i("ReactivePushHelper", 1, paramMessage.toString());
        paramQQAppInterface = null;
      }
      if (paramQQAppInterface == null)
      {
        QLog.i("ReactivePushHelper", 1, "query msg, msg is null");
        return false;
      }
      if ((paramQQAppInterface.tipParam != null) && (MutualMarkUtils.c(paramQQAppInterface.tipParam.i)))
      {
        QLog.i("ReactivePushHelper", 1, "isReactivePushTips : true");
        return true;
      }
    }
    return false;
  }
  
  private static void b(AppInterface paramAppInterface, long paramLong1, long paramLong2, String paramString)
  {
    if (paramAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveShowNotificationTime, time:");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" localtime:");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(" frienduin:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ReactivePushHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong2);
    localObject = ((StringBuilder)localObject).toString();
    SharedPreUtils.e(BaseApplicationImpl.getContext(), paramAppInterface.getCurrentUin(), (String)localObject, paramString);
  }
  
  private static void b(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    if (paramAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveShowTipsTime, time:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" frienduin:");
      localStringBuilder.append(paramString);
      QLog.d("ReactivePushHelper", 2, localStringBuilder.toString());
    }
    SharedPreUtils.a(BaseApplicationImpl.getContext(), paramAppInterface.getCurrentUin(), paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.ReactivePushHelper
 * JD-Core Version:    0.7.0.1
 */