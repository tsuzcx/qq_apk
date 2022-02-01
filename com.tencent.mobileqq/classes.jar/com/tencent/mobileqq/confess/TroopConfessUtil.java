package com.tencent.mobileqq.confess;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity;
import com.tencent.mobileqq.activity.aio.confess.ConfessPanel;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.data.TroopConfessMsg;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class TroopConfessUtil
{
  public static final String a = HardCodeUtil.a(2131912544);
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    try
    {
      localObject = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).d();
      if (localObject == null) {
        localObject = "https://ti.qq.com/honest-say/group-received.html?_bid=3104&_wv=9191&_qStyle=1";
      } else {
        localObject = ((ConfessConfig)localObject).v;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Object localObject;
        StringBuilder localStringBuilder;
        String str;
        continue;
        if (paramInt1 == 1) {
          str = "aio_card_say";
        } else {
          str = "aio_card_insert";
        }
      }
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&");
    localStringBuilder.append("adtag");
    localStringBuilder.append("=");
    localStringBuilder.append(str);
    localStringBuilder.append("&");
    localStringBuilder.append("quin");
    localStringBuilder.append("=");
    localStringBuilder.append(NearbyURLSafeUtil.b(paramString1));
    localStringBuilder.append("&");
    localStringBuilder.append("topicId");
    localStringBuilder.append("=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("&");
    localStringBuilder.append("sUin");
    localStringBuilder.append("=");
    localStringBuilder.append(NearbyURLSafeUtil.b(paramString2));
    localStringBuilder.append("&");
    localStringBuilder.append("rUin");
    localStringBuilder.append("=");
    localStringBuilder.append(NearbyURLSafeUtil.b(paramString3));
    paramString1 = localStringBuilder.toString();
    paramString2 = new Intent(paramContext, QQBrowserActivity.class);
    paramString2.putExtra("url", paramString1);
    paramContext.startActivity(paramString2);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("onGroupAioConfessClick ");
      paramContext.append(paramString1);
      QLog.i("Q.msg.TroopConfess", 2, paramContext.toString());
    }
    ThreadManager.post(new TroopConfessUtil.1(paramQQAppInterface, paramString3, paramInt1), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramBoolean);
    }
  }
  
  public static void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    if ((paramList1 != null) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.TroopConfess", 2, "decodeTroopConfessMsgElem");
      }
      paramMsg = paramList.iterator();
      while (paramMsg.hasNext())
      {
        paramStringBuilder = (im_msg_body.Elem)paramMsg.next();
        if ((paramStringBuilder.common_elem.has()) && (paramStringBuilder.common_elem.uint32_service_type.get() == 21) && (paramStringBuilder.common_elem.uint32_business_type.get() == 3) && (paramStringBuilder.common_elem.bytes_pb_elem.has()))
        {
          try
          {
            paramList = new hummer_commelem.MsgElemInfo_servtype21();
            try
            {
              paramList.mergeFrom(paramStringBuilder.common_elem.bytes_pb_elem.get().toByteArray());
            }
            catch (InvalidProtocolBufferMicroException paramStringBuilder) {}
            paramStringBuilder.printStackTrace();
          }
          catch (InvalidProtocolBufferMicroException paramStringBuilder)
          {
            paramList = null;
          }
          if (paramList == null) {
            return;
          }
          paramStringBuilder = new TroopConfessMsg();
          paramStringBuilder.convertFrom(paramList);
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.TroopConfess", 2, String.format("decodeTroopConfessMsgElem %s", new Object[] { paramStringBuilder.toString() }));
          }
          paramList = (MessageForTroopConfess)MessageRecordFactory.a(-2067);
          paramList.msgtype = -2067;
          paramList.msg = paramStringBuilder.getSimpleMsg();
          paramList.msgData = paramStringBuilder.getBytes();
          paramList.isToSelf = paramStringBuilder.isToSelf();
          if (paramList.msgData == null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg.TroopConfess", 2, "decode msgData null");
            }
          }
          else {
            paramList1.add(paramList);
          }
        }
      }
    }
  }
  
  public static boolean a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie != null)
    {
      if (paramBaseChatPie.bm() == null) {
        return false;
      }
      int i = ConfessPanel.a(paramBaseChatPie.bm().getResources().getDisplayMetrics().widthPixels);
      int j = ConfessPanel.a(paramBaseChatPie);
      i = ConfessPanel.a(paramBaseChatPie.aX().getResources(), i, j);
      if (QLog.isColorLevel()) {
        QLog.i("TroopConfessUtil", 2, String.format("showConfessPanel dstHeight=%d", new Object[] { Integer.valueOf(i) }));
      }
      String str = paramBaseChatPie.aX().getIntent().getStringExtra("url");
      Intent localIntent = new Intent(paramBaseChatPie.aX(), ConfessHalfScreenActivity.class);
      localIntent.putExtra("finish_animation_up_down", true);
      localIntent.putExtra("url", str);
      localIntent.putExtra("isTransparentTitle", true);
      localIntent.putExtra("confessDstHeight", i);
      localIntent.addFlags(603979776);
      paramBaseChatPie.aX().startActivityForResult(localIntent, 15002);
      paramBaseChatPie.aX().overridePendingTransition(2130771996, 0);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.n();
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isOpenTroopMessage) {
      return true;
    }
    int i = paramMessageRecord.istroop;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (paramQQAppInterface.m()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
    boolean bool = false;
    if (!paramBoolean) {
      localITroopInfoHandler.a(paramString, false);
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramString);
    paramBoolean = bool;
    if (paramQQAppInterface != null)
    {
      paramBoolean = bool;
      if ((paramQQAppInterface.dwGroupFlagExt3 & 0x2000) == 0L) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.msgtype == -2067;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString2 = paramString2.split("\\|");
      if (paramString2 != null)
      {
        int j = paramString2.length;
        int i = 0;
        while (i < j)
        {
          if (paramString2[i].equalsIgnoreCase(paramString1)) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  public static Object[] a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TroopConfessUtil.getTroopMembers ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("Q.msg.TroopConfess", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool1 = BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface;
    ArrayList localArrayList = null;
    if (bool1) {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return null;
    }
    String str = ((QQAppInterface)localObject1).getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    Object localObject2 = (TroopManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject2 != null)
    {
      localObject2 = ((TroopManager)localObject2).f(paramString);
      if (localObject2 != null)
      {
        if (Utils.a(str, ((TroopInfo)localObject2).troopowneruin)) {
          i = 2;
        } else if (a(str, ((TroopInfo)localObject2).Administrator)) {
          i = 1;
        } else {
          i = 0;
        }
        j = i;
        if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x80) != 0L) {
          break label192;
        }
        bool1 = true;
        break label196;
      }
    }
    int j = 0;
    label192:
    bool1 = false;
    int i = j;
    label196:
    boolean bool2;
    if ((i <= 0) && (!bool1)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.TroopConfess", 2, String.format("TroopConfessUtil.getTroopMembers canInvite=%s memLevel:%d", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i) }));
    }
    if (!bool2)
    {
      if (i > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      return new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), null };
    }
    Object localObject1 = ((QQAppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    if (localObject1 != null)
    {
      paramString = ((EntityManager)localObject1).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
      ((EntityManager)localObject1).close();
    }
    else
    {
      paramString = null;
    }
    localObject1 = localArrayList;
    if (paramString != null)
    {
      localArrayList = new ArrayList(paramString.size());
      paramString = paramString.iterator();
      for (;;)
      {
        localObject1 = localArrayList;
        if (!paramString.hasNext()) {
          break;
        }
        localObject1 = (TroopMemberInfo)paramString.next();
        if (Utils.e(((TroopMemberInfo)localObject1).memberuin)) {
          localArrayList.add(((TroopMemberInfo)localObject1).memberuin);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      if (localObject1 == null) {
        j = 0;
      } else {
        j = ((ArrayList)localObject1).size();
      }
      QLog.i("Q.msg.TroopConfess", 2, String.format("TroopConfessUtil.getTroopMembers findUins:%d", new Object[] { Integer.valueOf(j) }));
    }
    if (i > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    return new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), localObject1 };
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = paramString1.split("&");
      int i = 0;
      while (i < localObject.length)
      {
        String[] arrayOfString = JumpParser.a(localObject[i], "=");
        if ((arrayOfString.length == 2) && ("url_prefix".equals(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1])))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(arrayOfString[0]);
          ((StringBuilder)localObject).append("=");
          ((StringBuilder)localObject).append(arrayOfString[1]);
          String str2 = ((StringBuilder)localObject).toString();
          String str1 = new String(Base64Util.decode(arrayOfString[1], 0));
          localObject = str1;
          if (!str1.contains("&gc=")) {
            localObject = String.format("%s&gc=%s", new Object[] { str1, NearbyURLSafeUtil.b(paramString2) });
          }
          paramString2 = Base64Util.encodeToString(((String)localObject).getBytes(), 2);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(arrayOfString[0]);
          ((StringBuilder)localObject).append("=");
          ((StringBuilder)localObject).append(paramString2);
          paramString2 = paramString1.replace(str2, ((StringBuilder)localObject).toString());
          return paramString2;
        }
        i += 1;
      }
      return paramString1;
    }
    catch (Exception paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.TroopConfess", 2, paramString2.getMessage(), paramString2);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b(paramBoolean);
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = TroopBusinessUtil.a(paramMessageRecord);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if (paramMessageRecord.a == 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    return (a(paramMessageRecord)) && (b(paramMessageRecord));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TroopConfessUtil
 * JD-Core Version:    0.7.0.1
 */