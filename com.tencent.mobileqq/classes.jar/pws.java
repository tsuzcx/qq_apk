import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.1;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.2;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.3;
import com.tencent.biz.pubaccount.readinjoy.struct.WeishiRedDotInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;

public class pws
  implements Manager
{
  private QQAppInterface a;
  
  public pws(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, String paramString, long paramLong)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = bcsa.a(-1000);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.msgtype = -1000;
    a(localMessageRecord, paramString, paramLong);
    return localMessageRecord;
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, String paramString)
  {
    String str1 = paramstSimpleMetaFeed.id;
    String str2 = paramstSimpleMetaFeed.feed_desc;
    paramstSimpleMetaFeed = paramstSimpleMetaFeed.map_pass_back;
    boolean bool = a();
    vmp.b("WeishiManager", 2, "from:" + paramString + ", hasRedInfo : " + bool + ", id:" + str1 + ", feed_desc:" + str2);
    if (bool) {}
    QQMessageFacade localQQMessageFacade;
    long l;
    do
    {
      return;
      localQQMessageFacade = this.a.getMessageFacade();
      l = NetConnInfoCenter.getServerTime();
    } while (localQQMessageFacade == null);
    ThreadManager.post(new WeishiManager.3(this, str2, l, localQQMessageFacade, str1, paramString, paramstSimpleMetaFeed), 10, null, false);
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, long paramLong)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = AppConstants.WEISHI_UIN;
    paramMessageRecord.senderuin = AppConstants.WEISHI_UIN;
    paramMessageRecord.istroop = 1008;
    paramMessageRecord.msg = paramString;
    paramMessageRecord.time = paramLong;
    paramMessageRecord.createMessageUniseq();
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return TextUtils.equals(paramMessageRecord.frienduin, AppConstants.WEISHI_UIN);
  }
  
  public static void b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.map_pass_back == null) || (paramstSimpleMetaFeed.map_pass_back.size() != 0)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        } while (localObject == null);
        localObject = (pws)((QQAppInterface)localObject).getManager(QQManagerFactory.WEISHI_MANAGER);
      } while (localObject == null);
      localObject = FileUtils.readFile(((pws)localObject).b());
    } while (localObject == null);
    vmp.a("weishi-report", "load map passback length:" + localObject.length);
    vmp.b("weishi-report", "load map passback:" + vnd.a((byte[])localObject));
    paramstSimpleMetaFeed.map_pass_back.put(Integer.valueOf(1), localObject);
    paramstSimpleMetaFeed.map_ext.put("recmd_feed_key", new Gson().toJson(paramstSimpleMetaFeed.map_pass_back));
  }
  
  public WeishiRedDotInfo a()
  {
    if ((this.a == null) || (this.a.getMessageFacade() == null) || (this.a.getConversationFacade() == null)) {
      return null;
    }
    if (this.a.getMessageFacade().getConversationFacade().a(AppConstants.WEISHI_UIN, 1008) > 0)
    {
      MessageRecord localMessageRecord = this.a.getMessageFacade().getLastMsgForMsgTab(AppConstants.WEISHI_UIN, 1008);
      if ((localMessageRecord instanceof MessageForStructing)) {
        return new WeishiRedDotInfo((MessageForStructing)localMessageRecord);
      }
    }
    return null;
  }
  
  public MessageForStructing a()
  {
    if ((this.a == null) || (this.a.getMessageFacade() == null) || (this.a.getMessageFacade().getConversationFacade() == null)) {
      return null;
    }
    MessageRecord localMessageRecord = this.a.getMessageFacade().getLastMsgForMsgTab(AppConstants.WEISHI_UIN, 1008);
    if ((localMessageRecord instanceof MessageForStructing)) {
      return (MessageForStructing)localMessageRecord;
    }
    return null;
  }
  
  public MessageRecord a(String paramString, long paramLong)
  {
    if (this.a == null) {
      return null;
    }
    MessageRecord localMessageRecord = bcsa.a(-1000);
    localMessageRecord.selfuin = this.a.getCurrentAccountUin();
    a(localMessageRecord, paramString, paramLong);
    return localMessageRecord;
  }
  
  public String a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((MessageForStructing)localObject).structingMsg;
      if ((localObject != null) && (!TextUtils.isEmpty(((AbsStructMsg)localObject).mMsgActionData))) {
        return ((AbsStructMsg)localObject).mMsgActionData;
      }
    }
    return "";
  }
  
  public List<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.a == null) || (this.a.getMessageFacade() == null) || (this.a.getMessageFacade().getConversationFacade() == null)) {
      return null;
    }
    Object localObject = this.a.getMessageFacade().getLastMsgForMsgTab(AppConstants.WEISHI_UIN, 1008);
    if ((localObject instanceof MessageForStructing))
    {
      localObject = (MessageForStructing)localObject;
      if ((((MessageForStructing)localObject).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mArticleIds)))
      {
        localObject = ((MessageForStructing)localObject).structingMsg.mArticleIds.split("\\|");
        int i = 0;
        while (i < localObject.length)
        {
          localArrayList.add(Long.valueOf(localObject[i]));
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    vmm.a().a(true, paramstSimpleMetaFeed);
    a(paramstSimpleMetaFeed, "1");
  }
  
  public void a(Activity paramActivity)
  {
    if (this.a == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.a.getMessageFacade();
      } while (localObject == null);
      localObject = ((QQMessageFacade)localObject).getConversationFacade();
    } while ((localObject == null) || (((acmw)localObject).a(AppConstants.WEISHI_UIN, 1008) <= 0));
    ThreadManager.post(new WeishiManager.1(this, paramActivity), 8, null, false);
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.a == null)) {}
    QQMessageFacade localQQMessageFacade;
    do
    {
      return;
      localQQMessageFacade = this.a.getMessageFacade();
    } while (localQQMessageFacade == null);
    ThreadManager.post(new WeishiManager.2(this, localQQMessageFacade, paramString, paramLong), 10, null, false);
  }
  
  public boolean a()
  {
    return (this.a != null) && (this.a.getMessageFacade() != null) && (this.a.getMessageFacade().getConversationFacade() != null) && (this.a.getMessageFacade().getConversationFacade().a(AppConstants.WEISHI_UIN, 1008) > 0);
  }
  
  public boolean a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (vmm.a().a()) {
      return false;
    }
    a(paramstSimpleMetaFeed, "0");
    return true;
  }
  
  public String b()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_recommend_mappassback";
  }
  
  public String c()
  {
    try
    {
      long l = Long.parseLong(this.a.getCurrentAccountUin());
      String str = PreferenceManager.getDefaultPreference(this.a.getApplication(), l).getString("key_weishi_newest_feed_id", "");
      return str;
    }
    catch (Exception localException)
    {
      localException = localException;
      QLog.d("WeishiManager", 2, localException.getMessage(), localException);
      return "";
    }
    finally {}
    return "";
  }
  
  public String d()
  {
    try
    {
      long l = Long.parseLong(this.a.getCurrentAccountUin());
      String str = PreferenceManager.getDefaultPreference(this.a.getApplication(), l).getString("key_weishi_newest_feed_desc", "");
      return str;
    }
    catch (Exception localException)
    {
      localException = localException;
      QLog.d("WeishiManager", 2, localException.getMessage(), localException);
      return "";
    }
    finally {}
    return "";
  }
  
  public String e()
  {
    long l = Long.parseLong(this.a.getCurrentAccountUin());
    return PreferenceManager.getDefaultPreference(this.a.getApplication(), l).getString("key_weishi_newest_feed_from", "0");
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pws
 * JD-Core Version:    0.7.0.1
 */