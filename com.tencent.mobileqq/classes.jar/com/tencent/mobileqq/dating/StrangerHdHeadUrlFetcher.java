package com.tencent.mobileqq.dating;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.CustomHandler;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class StrangerHdHeadUrlFetcher
  implements Handler.Callback
{
  protected long a;
  protected QQAppInterface a;
  private AvatarObserver a;
  protected EntityManager a;
  protected Set<String> a;
  protected ConcurrentHashMap<String, String> a;
  protected MqqHandler a;
  protected boolean a;
  
  public StrangerHdHeadUrlFetcher(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new StrangerHdHeadUrlFetcher.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    this.jdField_a_of_type_JavaUtilSet = new HashSet(20);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    if (paramInt1 == 4)
    {
      localStringBuilder.append("troop_");
      localStringBuilder.append(paramString);
    }
    else if (paramInt1 == 32)
    {
      localStringBuilder.append("stranger_");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
    }
    else if (paramInt1 == 16)
    {
      localStringBuilder.append("qcall_");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
    }
    else
    {
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt, String paramString, byte paramByte1, byte paramByte2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(String.valueOf(640));
    return MsfSdkUtils.insertMtype("QQHeadIcon", localStringBuilder.toString());
  }
  
  private void a(String paramString)
  {
    Set localSet = this.jdField_a_of_type_JavaUtilSet;
    if (paramString == null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      break label34;
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      label34:
      if (this.jdField_a_of_type_JavaUtilSet.isEmpty())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    finally {}
  }
  
  public String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramInt == 200) || (paramInt == 202) || (paramInt == 204)))
    {
      String str = a(32, paramInt, paramString);
      ??? = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      Object localObject1 = ???;
      if (TextUtils.isEmpty((CharSequence)???))
      {
        Setting localSetting = (Setting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(Setting.class, str);
        localObject1 = ???;
        if (localSetting != null)
        {
          localObject1 = ???;
          if (!TextUtils.isEmpty(localSetting.url))
          {
            localObject1 = a(32, localSetting.url, localSetting.bHeadType, localSetting.bFaceFlags);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject1);
            synchronized (this.jdField_a_of_type_JavaUtilSet)
            {
              this.jdField_a_of_type_JavaUtilSet.remove(str);
            }
          }
        }
      }
      ThreadManager.post(new StrangerHdHeadUrlFetcher.1(this, paramString, paramInt, paramBoolean, str), 8, null, false);
      return localObject1;
    }
    DatingUtil.a("StrangerHdHeadUrlFetcher", new Object[] { "uinOrMobileNum is null or empty" });
    return "";
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilSet.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l = Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      if ((l >= 0L) && (l <= 60000L))
      {
        if (!this.jdField_a_of_type_JavaUtilSet.isEmpty()) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageAtTime(1, 60000L);
        }
      }
      else {
        a(null);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.StrangerHdHeadUrlFetcher
 * JD-Core Version:    0.7.0.1
 */