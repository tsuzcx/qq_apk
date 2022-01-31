import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryFeedManager.1;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

public class sfy
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private Map<String, MessageForQQStoryFeed> jdField_a_of_type_JavaUtilMap;
  
  public sfy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(100);
  }
  
  @NonNull
  public static sfy a(QQAppInterface paramQQAppInterface)
  {
    return (sfy)paramQQAppInterface.getManager(253);
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "parseJsonConfig: invoked. Message: json: " + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      return;
    }
    if (new JSONObject(paramString).optInt("enabled") == 1) {}
    for (paramString = Boolean.TRUE;; paramString = Boolean.FALSE)
    {
      this.jdField_a_of_type_JavaLangBoolean = paramString;
      return;
    }
  }
  
  @NonNull
  public MessageForQQStoryFeed a(byte[] paramArrayOfByte, String paramString)
  {
    MessageForQQStoryFeed localMessageForQQStoryFeed = new MessageForQQStoryFeed();
    localMessageForQQStoryFeed.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForQQStoryFeed.frienduin = paramString;
    localMessageForQQStoryFeed.senderuin = paramString;
    localMessageForQQStoryFeed.isread = true;
    localMessageForQQStoryFeed.msgData = paramArrayOfByte;
    localMessageForQQStoryFeed.mergeFrom(paramArrayOfByte);
    return localMessageForQQStoryFeed;
  }
  
  public void a() {}
  
  public void a(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = baig.aC(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str;
    if (i != j)
    {
      str = amnh.b(paramConfig, j, paramConfig.type.get());
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedManager", 2, "handleConfig: invoked. Message: configJson: " + str);
      }
      if (!TextUtils.isEmpty(str)) {
        break label86;
      }
    }
    label86:
    do
    {
      return;
      baig.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramConfig.version.get(), str);
      try
      {
        b(str);
        return;
      }
      catch (Exception paramConfig) {}
    } while (!QLog.isColorLevel());
    QLog.e("QQStoryFeedManager", 2, "handleConfig: failed. Message: exception: " + paramConfig);
  }
  
  public void a(@NonNull MessageForQQStoryFeed paramMessageForQQStoryFeed)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "handleAIOQQStoryFeedMessage: invoked. Message: messageForQQStoryFeed: " + paramMessageForQQStoryFeed);
    }
    if (!a())
    {
      QLog.i("QQStoryFeedManager", 1, "handleAIOQQStoryFeedMessage forbidden. ");
      return;
    }
    urp.a("aio_msg", "aio_push", 0, 0, new String[] { paramMessageForQQStoryFeed.frienduin });
    acjz localacjz = (acjz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
    Object localObject = localacjz.a(paramMessageForQQStoryFeed.frienduin, 0, 5);
    int i;
    if (localObject != null)
    {
      if (((BeancurdMsg)localObject).originTime < paramMessageForQQStoryFeed.friendActionMills) {
        break label355;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        BeancurdMsg localBeancurdMsg = new BeancurdMsg();
        localBeancurdMsg.frienduin = paramMessageForQQStoryFeed.frienduin;
        localBeancurdMsg.busiid = 5;
        localBeancurdMsg.isNeedDelHistory = true;
        localBeancurdMsg.ispush = false;
        localBeancurdMsg.originTime = paramMessageForQQStoryFeed.friendActionMills;
        localBeancurdMsg.startTime = paramMessageForQQStoryFeed.mFeedTime;
        localBeancurdMsg.validTime = paramMessageForQQStoryFeed.mKeepTime;
        localObject = null;
        if (!TextUtils.isEmpty(paramMessageForQQStoryFeed.mFeedId)) {
          localObject = new String(paramMessageForQQStoryFeed.msgData, "ISO_8859_1");
        }
        localBeancurdMsg.buffer = ((String)localObject);
        localacjz.a(localBeancurdMsg);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("QQStoryFeedManager", 2, "handleAIOQQStoryFeedMessage: parse data to MessageRecord has error. Message: " + localException.getMessage());
          }
        }
      }
      i = paramMessageForQQStoryFeed.mKeepTime;
      baig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramMessageForQQStoryFeed.frienduin, i);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForQQStoryFeed.frienduin, 0, new int[] { -2061 });
      if ((localObject != null) && (((List)localObject).size() > 0) && (((MessageForQQStoryFeed)((List)localObject).get(((List)localObject).size() - 1)).friendActionMills >= paramMessageForQQStoryFeed.friendActionMills)) {
        i = 0;
      } else {
        label355:
        i = 1;
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = new QQStoryFeedManager.1(this, paramString);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(paramString, 8, null, true);
      return;
    }
    paramString.run();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "onDestroy invoked. info: TAG: QQStoryFeedManager");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sfy
 * JD-Core Version:    0.7.0.1
 */