package com.tencent.mobileqq.mutualmark.oldlogic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
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
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
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
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramContext == null)) {
      return paramSpannableStringBuilder;
    }
    QLog.i("ReactivePushHelper", 1, "updateReactiveIconResource start:" + paramSpannableStringBuilder);
    localObject1 = paramSpannableStringBuilder.toString();
    try
    {
      k = ViewUtils.b(16.0F);
      localObject3 = MutualMarkUtils.a();
      localArrayList = new ArrayList();
      localObject2 = MutualMarkUtils.a((String)localObject1);
      if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
        break label604;
      }
      i = 0;
      localObject4 = ((ArrayList)localObject2).iterator();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        int k;
        Object localObject3;
        ArrayList localArrayList;
        int i;
        Object localObject4;
        Object localObject5;
        UrlBottomImageSpan localUrlBottomImageSpan;
        Object localObject2 = paramContext;
        paramContext = (Context)localObject1;
        QLog.e("ReactivePushHelper", 1, "updateReactiveIconResource exception:" + localObject2);
        continue;
        break label607;
      }
    }
    if (((Iterator)localObject4).hasNext())
    {
      localObject5 = (MutualMarkUtils.ImageUrlTemplateInfo)((Iterator)localObject4).next();
      if (!TextUtils.isEmpty(((MutualMarkUtils.ImageUrlTemplateInfo)localObject5).jdField_b_of_type_JavaLangString))
      {
        localUrlBottomImageSpan = new UrlBottomImageSpan(paramContext, 0, ((MutualMarkUtils.ImageUrlTemplateInfo)localObject5).jdField_b_of_type_JavaLangString, ViewUtils.b(16.0F), null);
        localObject2 = "[icon]";
        if (!TextUtils.isEmpty(((MutualMarkUtils.ImageUrlTemplateInfo)localObject5).c)) {
          localObject2 = ((MutualMarkUtils.ImageUrlTemplateInfo)localObject5).c;
        }
        ((MutualMarkUtils.ImageUrlTemplateInfo)localObject5).jdField_a_of_type_Int += i;
        ((MutualMarkUtils.ImageUrlTemplateInfo)localObject5).jdField_b_of_type_Int += i;
        paramSpannableStringBuilder.replace(((MutualMarkUtils.ImageUrlTemplateInfo)localObject5).jdField_a_of_type_Int, ((MutualMarkUtils.ImageUrlTemplateInfo)localObject5).jdField_b_of_type_Int, (CharSequence)localObject2);
        paramSpannableStringBuilder.setSpan(localUrlBottomImageSpan, ((MutualMarkUtils.ImageUrlTemplateInfo)localObject5).jdField_a_of_type_Int, ((MutualMarkUtils.ImageUrlTemplateInfo)localObject5).jdField_a_of_type_Int + ((String)localObject2).length(), 33);
        i = ((MutualMarkUtils.ImageUrlTemplateInfo)localObject5).jdField_a_of_type_Int + ((String)localObject2).length() - ((MutualMarkUtils.ImageUrlTemplateInfo)localObject5).jdField_b_of_type_Int + i;
        break label607;
      }
    }
    else
    {
      localObject2 = paramSpannableStringBuilder.toString();
      localObject1 = localObject2;
      for (;;)
      {
        try
        {
          localObject2 = ((List)localObject3).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject3 = (String)((Iterator)localObject2).next();
          i = ((String)localObject1).indexOf((String)localObject3);
          if ((i == -1) || (i < 0)) {
            continue;
          }
          localObject4 = localArrayList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            continue;
          }
          localObject5 = (Pair)((Iterator)localObject4).next();
          if ((i < ((Integer)((Pair)localObject5).first).intValue()) || (i >= ((Integer)((Pair)localObject5).second).intValue())) {
            continue;
          }
          j = 1;
        }
        catch (Throwable localThrowable)
        {
          paramContext = (Context)localObject1;
          continue;
          int j = 0;
          continue;
        }
        if ((j == 0) && (MutualMarkUtils.b.containsKey(localObject3)))
        {
          localObject4 = (Integer)MutualMarkUtils.b.get(localObject3);
          if ((localObject4 != null) && (((Integer)localObject4).intValue() != 0))
          {
            localObject4 = paramContext.getResources().getDrawable(((Integer)localObject4).intValue());
            if (localObject4 != null)
            {
              ((Drawable)localObject4).setBounds(0, 0, k, k);
              paramSpannableStringBuilder.setSpan(new ImageSpan((Drawable)localObject4, 0), i, ((String)localObject3).length() + i, 33);
              localArrayList.add(new Pair(Integer.valueOf(i), Integer.valueOf(((String)localObject3).length() + i)));
            }
          }
        }
        i = ((String)localObject1).indexOf((String)localObject3, ((String)localObject3).length() + i);
      }
      paramContext = (Context)localObject1;
      QLog.i("ReactivePushHelper", 1, "removeReactiveIconResource end:" + paramContext);
      return paramSpannableStringBuilder;
    }
  }
  
  public static SpannableStringBuilder a(Context paramContext, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {
      return null;
    }
    return a(paramContext, new SpannableStringBuilder(paramString));
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    QLog.i("ReactivePushHelper", 1, "removeReactiveIconResource start:" + paramString);
    paramString = paramString.replaceAll("[icon]", "");
    Iterator localIterator = MutualMarkUtils.a(paramString).iterator();
    while (localIterator.hasNext()) {
      paramString = paramString.replaceAll(((MutualMarkUtils.ImageUrlTemplateInfo)localIterator.next()).jdField_a_of_type_JavaLangString, "");
    }
    localIterator = MutualMarkUtils.a().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramString.contains(str)) {
        paramString = paramString.replaceAll(str, "");
      }
    }
    QLog.i("ReactivePushHelper", 1, "removeReactiveIconResource end:" + paramString);
    return paramString;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReactivePushHelper", 2, "saveShowNotificationTime, time:" + paramLong1 + " localtime:" + paramLong2 + " frienduin:" + paramString);
    }
    String str = "" + paramLong1 + "_" + paramLong2;
    SharedPreUtils.e(BaseApplicationImpl.getContext(), paramQQAppInterface.getCurrentUin(), str, paramString);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReactivePushHelper", 2, "saveShowTipsTime, time:" + paramLong + " frienduin:" + paramString);
    }
    SharedPreUtils.a(BaseApplicationImpl.getContext(), paramQQAppInterface.getCurrentUin(), paramString, paramLong);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, PushMsg0x210C7Info paramPushMsg0x210C7Info, int paramInt2, int paramInt3, long paramLong, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReactivePushHelper", 2, "insertGrayTips uin:" + paramString1 + " grayTips:" + paramString2 + " nick:" + paramString3 + " lNotifyTime:" + paramLong);
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Object localObject = paramString2;
    if (paramString2.contains("#nick")) {
      localObject = paramString2.replaceAll("#nick", paramString3);
    }
    paramString3 = new StringBuilder((String)localObject);
    paramString2 = MutualMarkGrayTipsHelper.a(paramQQAppInterface, paramString5, paramString3);
    paramString3 = paramString3.toString();
    paramString5 = new UniteGrayTipParam(paramString5, paramString5, paramString3, 0, paramInt1, paramInt2, MessageCache.a());
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).hasRead = 0;
    ((MessageForUniteGrayTip)localObject).subType = paramInt3;
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString5);
    if (!TextUtils.isEmpty(paramString4)) {}
    for (((MessageForUniteGrayTip)localObject).tipParam.d = paramString4;; ((MessageForUniteGrayTip)localObject).tipParam.d = (paramString1 + "_reactive_" + paramPushMsg0x210C7Info.b + "_" + paramLong))
    {
      MutualMarkGrayTipsHelper.a(paramQQAppInterface, paramString3, paramString5, paramString2);
      ((MessageForUniteGrayTip)localObject).saveExtInfoToExtStr("mutualmark_WillDowngradeSoon", "true");
      UniteGrayTipUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A1BC", "0X800A1BC", 0, 0, "", "", "", "");
      long l = System.currentTimeMillis() / 1000L;
      if (!a(paramQQAppInterface, paramLong, l, "0")) {
        break;
      }
      paramString2 = paramQQAppInterface.getMessageFacade().a(((MessageForUniteGrayTip)localObject).frienduin, ((MessageForUniteGrayTip)localObject).istroop);
      paramQQAppInterface.getMessageFacade().b(paramString2);
      paramQQAppInterface.handleReceivedMessage(1, true, true);
      paramQQAppInterface.getMessageFacade().b(null);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A1BE", "0X800A1BE", 1, 0, "", "", "", "");
      a(paramQQAppInterface, paramLong, l, "0");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReactivePushHelper", 2, "ShowNotification, localtime:" + l + " servertime:" + paramLong + " frienduin:" + paramString1);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    QLog.i("ReactivePushHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 app:" + paramQQAppInterface + "  changeInfo:" + paramRelationalChainChange + "  msginfo:" + paramPushMsg0x210C7Info);
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramPushMsg0x210C7Info == null)) {}
    long l;
    String str;
    do
    {
      return;
      l = paramRelationalChainChange.uint64_src_uin.get();
      str = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
    } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), String.valueOf(l))) || (TextUtils.isEmpty(str)));
    int i = paramRelationalChainChange.uint32_change_type.get();
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Friends localFriends = localFriendsManager.e(str);
    QLog.i("ReactivePushHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 friend:" + localFriends + " changeType:" + i);
    if ((localFriends != null) && (!localFriends.isFriend()))
    {
      QLog.i("ReactivePushHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 is not friend");
      return;
    }
    if (localFriendsManager.a(str) == null) {
      new ExtensionInfo().uin = str;
    }
    switch (i)
    {
    case 1: 
    case 2: 
    case 3: 
    case 10002: 
    case 10003: 
    case 10004: 
    default: 
      return;
    }
    a(paramQQAppInterface, paramRelationalChainChange, str, paramPushMsg0x210C7Info);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, String paramString, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    Object localObject;
    if (paramRelationalChainChange.msg_to_degrade_info.has())
    {
      localObject = (submsgtype0xc7.ToDegradeInfo)paramRelationalChainChange.msg_to_degrade_info.get();
      if (localObject != null) {
        break label34;
      }
    }
    label34:
    long l;
    label78:
    do
    {
      return;
      localObject = null;
      break;
      if (!((submsgtype0xc7.ToDegradeInfo)localObject).bytes_nick.has()) {
        break label303;
      }
      paramRelationalChainChange = ((submsgtype0xc7.ToDegradeInfo)localObject).bytes_nick.get().toStringUtf8();
      if (!((submsgtype0xc7.ToDegradeInfo)localObject).notify_time.has()) {
        break label308;
      }
      l = ((submsgtype0xc7.ToDegradeInfo)localObject).notify_time.get();
      if (QLog.isColorLevel()) {
        QLog.i("ReactivePushHelper", 2, "onWillDowngradeSoon, nick:" + paramRelationalChainChange + " notifytime:" + l);
      }
    } while (!a(paramQQAppInterface, l, paramString));
    String str;
    if (TextUtils.isEmpty(paramRelationalChainChange))
    {
      str = ContactUtils.m(paramQQAppInterface, paramString);
      paramRelationalChainChange = str;
      if (QLog.isColorLevel())
      {
        QLog.i("ReactivePushHelper", 2, "onWillDowngradeSoon, local nick:" + str);
        paramRelationalChainChange = str;
      }
    }
    for (;;)
    {
      int i;
      if (((submsgtype0xc7.ToDegradeInfo)localObject).uint32_graytip_type.has())
      {
        i = ((submsgtype0xc7.ToDegradeInfo)localObject).uint32_graytip_type.get();
        label205:
        i = MutualMarkGrayTipsHelper.a(i);
        if (!((submsgtype0xc7.ToDegradeInfo)localObject).bytes_duplicate_removal.has()) {
          break label320;
        }
        str = ((submsgtype0xc7.ToDegradeInfo)localObject).bytes_duplicate_removal.get().toStringUtf8();
        label236:
        if (!((submsgtype0xc7.ToDegradeInfo)localObject).bytes_wildcard_wording.has()) {
          break label327;
        }
      }
      label303:
      label308:
      label320:
      label327:
      for (localObject = ((submsgtype0xc7.ToDegradeInfo)localObject).bytes_wildcard_wording.get().toStringUtf8();; localObject = "")
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!MutualMarkUtils.a(paramQQAppInterface))) {
          a(paramQQAppInterface, paramString, (String)localObject, paramRelationalChainChange, i, str, paramPushMsg0x210C7Info, 2097155, 0, l, paramString);
        }
        a(paramQQAppInterface, l, paramString);
        return;
        paramRelationalChainChange = null;
        break;
        l = 0L;
        break label78;
        i = 0;
        break label205;
        str = "";
        break label236;
      }
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString)
  {
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (paramQQAppInterface == null) {}
    long l;
    do
    {
      return false;
      l = SharedPreUtils.a(BaseApplicationImpl.getContext(), paramQQAppInterface.getCurrentUin(), paramString);
      if (QLog.isColorLevel()) {
        QLog.d("ReactivePushHelper", 2, "needShowTips, LastTime:" + l + " servertime:" + paramLong + " frienduin:" + paramString);
      }
      if (l == 0L) {
        return true;
      }
    } while (paramLong == l);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if ((paramMessage == null) || (paramQQAppInterface == null)) {
      return false;
    }
    if (paramMessage.msgtype != -5040) {
      return false;
    }
    try
    {
      paramQQAppInterface = (MessageForUniteGrayTip)paramQQAppInterface.getMessageFacade().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
      if (paramQQAppInterface == null)
      {
        QLog.i("ReactivePushHelper", 1, "query msg, msg is null");
        return false;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        QLog.i("ReactivePushHelper", 1, "query msg exception:" + paramQQAppInterface.toString());
        paramQQAppInterface = null;
      }
      if ((paramQQAppInterface.tipParam != null) && (MutualMarkUtils.b(paramQQAppInterface.tipParam.jdField_b_of_type_Int)))
      {
        QLog.i("ReactivePushHelper", 1, "isReactivePushTips : true");
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.ReactivePushHelper
 * JD-Core Version:    0.7.0.1
 */