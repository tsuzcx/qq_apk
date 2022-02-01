import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil.1;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.PhoneInfo;

public class ofj
{
  public static int a()
  {
    switch (NetworkUtil.getSystemNetwork(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 1;
  }
  
  public static String a()
  {
    return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis()));
  }
  
  public static oeq a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "getAdvertisementItem:" + paramMessageRecord.senderuin);
    }
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg instanceof AbsShareMsg)))
      {
        Object localObject2 = (AbsShareMsg)localMessageForStructing.structingMsg;
        Object localObject1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList1 = new ArrayList();
        int i = 0;
        localObject2 = ((AbsShareMsg)localObject2).mStructMsgItemLists.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (bdnu)((Iterator)localObject2).next();
          int j = i;
          if ((localObject3 instanceof bdnv))
          {
            localObject3 = (bdnv)localObject3;
            j = i;
            if (((bdnv)localObject3).a != null)
            {
              j = i;
              if (((bdnv)localObject3).a.size() > 0)
              {
                localObject3 = ((bdnv)localObject3).a.iterator();
                for (;;)
                {
                  j = i;
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  Object localObject4 = (bdnu)((Iterator)localObject3).next();
                  if ((localObject4 instanceof bdte))
                  {
                    localObject4 = (bdte)localObject4;
                    if ((!TextUtils.isEmpty(((bdte)localObject4).ac)) && (!TextUtils.isEmpty(((bdte)localObject4).ad)))
                    {
                      localObject4 = new oer(i, ((bdte)localObject4).ac, ((bdte)localObject4).ad);
                      i += 1;
                      ((ArrayList)localObject1).add(localObject4);
                      localArrayList2.add(((oer)localObject4).b);
                      localArrayList1.add(((oer)localObject4).a);
                    }
                  }
                }
              }
            }
          }
          i = j;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AD_Util", 2, "messageRecord.senderuin:" + paramMessageRecord.senderuin + "messageForStructing.structingMsg.mCommonData:" + localMessageForStructing.structingMsg.mCommonData + "list.size():" + ((ArrayList)localObject1).size());
        }
        if ((!TextUtils.isEmpty(paramMessageRecord.senderuin)) && (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mCommonData)) && (((ArrayList)localObject1).size() > 0))
        {
          localObject1 = new oeq(paramMessageRecord.senderuin, localMessageForStructing.structingMsg.mMsgUrl, (ArrayList)localObject1, localMessageForStructing.structingMsg.mCommonData);
          if (((oeq)localObject1).b())
          {
            ((oeq)localObject1).c = String.valueOf(localMessageForStructing.structingMsg.msgId);
            if (!paramBoolean)
            {
              ((oeq)localObject1).a = NetConnInfoCenter.getServerTimeMillis();
              paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_push_time", String.valueOf(((oeq)localObject1).a));
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AD_Util", 2, "start preload msgid:" + ((oeq)localObject1).c);
              }
              ThreadManager.executeOnSubThread(new PublicAccountAdUtil.1(localArrayList1));
              if (paramQQAppInterface == null) {
                break;
              }
              paramQQAppInterface = (ofd)paramQQAppInterface.getManager(QQManagerFactory.PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER);
              if (paramQQAppInterface != null) {
                paramQQAppInterface.a((oeq)localObject1);
              }
              return localObject1;
              paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("recent_list_advertisement_message_push_time");
              try
              {
                ((oeq)localObject1).a = Long.parseLong(paramMessageRecord);
              }
              catch (Exception paramMessageRecord)
              {
                ((oeq)localObject1).a = 0L;
              }
            }
          }
          return null;
          return localObject1;
        }
      }
    }
    return null;
  }
  
  public static oidb_cmd0x886.PhoneInfo a()
  {
    oidb_cmd0x886.PhoneInfo localPhoneInfo = new oidb_cmd0x886.PhoneInfo();
    Object localObject = ujw.a();
    String str = ujw.c();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = MD5Utils.toMD5(((String)localObject).toLowerCase()).toLowerCase();
      localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localPhoneInfo.uint32_muid_type.set(1);
      localObject = str;
    }
    for (;;)
    {
      int i = a();
      localPhoneInfo.uint32_conn.set(i);
      i = 0;
      try
      {
        int j = DeviceInfoUtil.getCarrier();
        i = j;
      }
      catch (Exception localException)
      {
        label79:
        break label79;
      }
      localPhoneInfo.uint32_carrier.set(i);
      str = DeviceInfoUtil.getDeviceOSVersion();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8(str));
      str = DeviceInfoUtil.getQQVersion();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8(str));
      i = AppSetting.a();
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      str = dw.a(dw.a());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8(str));
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localPhoneInfo.bytes_client_mac.set(ByteStringMicro.copyFromUtf8((String)localObject));
      }
      localPhoneInfo.uint32_os_type.set(2);
      return localPhoneInfo;
      localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject = str.replaceAll(":", "").toUpperCase();
        str = MD5Utils.toMD5((String)localObject).toLowerCase();
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
        localPhoneInfo.uint32_muid_type.set(3);
      }
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    if ("1".equalsIgnoreCase(paramMessageRecord.getExtInfoFromExtStr("recent_list_advertisement_message"))) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofj
 * JD-Core Version:    0.7.0.1
 */