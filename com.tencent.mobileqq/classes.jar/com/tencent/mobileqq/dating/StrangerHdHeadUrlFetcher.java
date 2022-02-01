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
  protected QQAppInterface a;
  protected EntityManager b;
  protected Set<String> c;
  protected ConcurrentHashMap<String, String> d;
  protected boolean e;
  protected long f;
  protected MqqHandler g;
  private AvatarObserver h = new StrangerHdHeadUrlFetcher.2(this);
  
  public StrangerHdHeadUrlFetcher(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.d = new ConcurrentHashMap(20);
    this.c = new HashSet(20);
    this.e = false;
    this.g = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
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
    Set localSet = this.c;
    if (paramString == null) {}
    try
    {
      this.c.clear();
      break label34;
      this.c.remove(paramString);
      label34:
      if (this.c.isEmpty())
      {
        this.a.removeObserver(this.h);
        this.e = false;
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
      ??? = (String)this.d.get(str);
      Object localObject1 = ???;
      if (TextUtils.isEmpty((CharSequence)???))
      {
        Setting localSetting = (Setting)this.b.find(Setting.class, str);
        localObject1 = ???;
        if (localSetting != null)
        {
          localObject1 = ???;
          if (!TextUtils.isEmpty(localSetting.url))
          {
            localObject1 = a(32, localSetting.url, localSetting.bHeadType, localSetting.bFaceFlags);
            this.d.put(str, localObject1);
            synchronized (this.c)
            {
              this.c.remove(str);
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
    synchronized (this.c)
    {
      this.a.removeObserver(this.h);
      this.e = false;
      this.c.clear();
      this.d.clear();
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l = Math.abs(System.currentTimeMillis() - this.f);
      if ((l >= 0L) && (l <= 60000L))
      {
        if (!this.c.isEmpty()) {
          this.g.sendEmptyMessageAtTime(1, 60000L);
        }
      }
      else {
        a(null);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.StrangerHdHeadUrlFetcher
 * JD-Core Version:    0.7.0.1
 */