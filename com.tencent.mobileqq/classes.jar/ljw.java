import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.redpacket.config.AVRedPacketConfigManager.1;
import com.tencent.av.redpacket.config.AVRedPacketConfigManager.2;
import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ljw
  implements alje, Handler.Callback, Manager
{
  public aljb a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public AVRedPacketConfig a;
  public QQAppInterface a;
  public Object a;
  public String a;
  public lls a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public volatile boolean a;
  public String b;
  public lls b;
  public volatile boolean b;
  public volatile boolean c;
  
  public ljw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Aljb = ((aljb)paramQQAppInterface.getManager(191));
    this.jdField_a_of_type_Aljb.a(this);
  }
  
  public int a()
  {
    AVRedPacketConfig localAVRedPacketConfig = a();
    if (localAVRedPacketConfig == null) {}
    for (int i = 0;; i = localAVRedPacketConfig.version)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketConfigManger", 2, "getConfigVersion:" + i);
      }
      return i;
    }
  }
  
  public AVRedPacketConfig a()
  {
    return a(true);
  }
  
  public AVRedPacketConfig a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig == null) && (paramBoolean))
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketConfigManger", 2, "getAVRedPacketConfig:" + this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig);
      }
    }
    return this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig;
  }
  
  MqqHandler a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("QAV_RedPacketResDownload", 0);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        QLog.w("AVRedPacketConfigManger", 1, "getDownloadHandle, 创建mDownloadHandleThread");
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
        QLog.w("AVRedPacketConfigManger", 1, "getDownloadHandle, 创建mDownloadHandle");
      }
      MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
      return localMqqHandler;
    }
    finally {}
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig == null)
      {
        this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig = AVRedPacketConfig.readFromFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketConfigManger", 2, "loadConfigFromFile,redPacketConfig =   " + this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig);
        }
      }
      return;
    }
  }
  
  public void a(AVRedPacketConfig paramAVRedPacketConfig, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "onGetConfig ,isNewConfig = " + paramBoolean + ",config = " + paramAVRedPacketConfig);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig = paramAVRedPacketConfig;
      lls locallls = this.jdField_a_of_type_Lls;
      if (locallls != null) {}
      try
      {
        this.jdField_a_of_type_Lls.a(true, paramAVRedPacketConfig);
        this.jdField_a_of_type_Boolean = false;
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig != null)) {
          this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.saveToFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketConfigManger", 2, "onGetConfig finish, isGettingConfig =" + this.jdField_a_of_type_Boolean);
        }
        return;
      }
      catch (RemoteException paramAVRedPacketConfig)
      {
        for (;;)
        {
          paramAVRedPacketConfig.printStackTrace();
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_MqqOsMqqHandler = null;
        QLog.w("AVRedPacketConfigManger", 1, "clearDownloadHandle[" + paramString + "], 释放mDownloadHandle");
      }
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
        this.jdField_a_of_type_AndroidOsHandlerThread = null;
        QLog.w("AVRedPacketConfigManger", 1, "clearDownloadHandle[" + paramString + "], 释放mDownloadHandleThread");
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "onDownloadUpdate,url =   " + paramString1 + ",md5 = " + paramString2 + ",percent = " + paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "onDownloadFinish,url =   " + paramString1 + ",md5 = " + paramString2 + ",errCode = " + paramInt + ",path = " + paramString3 + ",userData = " + paramObject);
    }
    String str = null;
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label182;
      }
      paramObject = this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resURL;
      ljg.a(i, paramInt);
      if (!paramString3.endsWith("/")) {
        break label204;
      }
    }
    label182:
    label204:
    for (str = paramString3;; str = paramString3 + File.separator)
    {
      if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(paramObject)))
      {
        paramString3 = a();
        if (paramString3 == null) {
          break label230;
        }
        paramString3.post(new AVRedPacketConfigManager.2(this, paramInt, str, paramString2, i, paramString1));
      }
      return;
      paramObject = str;
      if (i != 2) {
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResUrl;
      break;
    }
    label230:
    QLog.w("AVRedPacketConfigManger", 1, "onDownloadFinish, downloadHandle is null");
  }
  
  public void a(lls paramlls)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "downloadRes");
    }
    if (this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig == null)
    {
      QLog.d("AVRedPacketConfigManger", 1, "downloadRes, redPacketConfig is null");
      return;
    }
    Object localObject = (axxj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
    ((axxj)localObject).a(this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resURL);
    ((axxj)localObject).a(this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResUrl);
    localObject = a();
    if (localObject != null)
    {
      ((MqqHandler)localObject).post(new AVRedPacketConfigManager.1(this, paramlls));
      return;
    }
    QLog.w("AVRedPacketConfigManger", 1, "downloadRes, downloadHandle is null");
  }
  
  public void b()
  {
    a(a(), false);
    ljg.a(false);
  }
  
  public void b(String paramString)
  {
    paramString = AVRedPacketConfig.parse(paramString);
    if (paramString == null) {
      AVRedPacketConfig.deleteLocalConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    for (;;)
    {
      ljg.a(true);
      return;
      a(paramString, true);
    }
  }
  
  public void b(lls paramlls)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "getAVRedPacketConfig,start");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketConfigManger", 2, "getAVRedPacketConfig,isGettingConfig =   " + this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Lls = paramlls;
      if (!this.jdField_a_of_type_Boolean)
      {
        paramlls = this.jdField_a_of_type_Lls;
        if (paramlls == null) {}
      }
      try
      {
        this.jdField_a_of_type_Lls.a(true, this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig);
        return;
      }
      catch (RemoteException paramlls)
      {
        for (;;)
        {
          paramlls.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("AVRedPacketConfigManger", 2, "getAVRedPacketConfig,error    ", paramlls);
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {
      mct.f();
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Aljb.b(this);
    a("onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljw
 * JD-Core Version:    0.7.0.1
 */