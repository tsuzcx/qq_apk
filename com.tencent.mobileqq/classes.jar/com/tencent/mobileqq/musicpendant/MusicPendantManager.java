package com.tencent.mobileqq.musicpendant;

import aetk;
import aetl;
import aetm;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MusicPendantManager
{
  private static MusicPendantManager jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantManager;
  public static String a;
  private static List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private static WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("MusicPendantManager");
  private QQPlayerService.QQPlayerCallback jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback = new aetk(this);
  public WeakReference a;
  private boolean jdField_a_of_type_Boolean;
  private SongInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  private MusicPendantManager()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  public static Intent a(Context paramContext, AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject = paramContext;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        localObject = BaseApplication.getContext();
        localObject = new Intent((Context)localObject, QQBrowserActivity.class);
        paramContext = "http://y.qq.com/m/personal_music/index.html?_wv=3&_bid=2032";
        if (paramAppInterface != null) {}
        try
        {
          paramContext = "http://y.qq.com/m/personal_music/index.html?_wv=3&_bid=2032" + "&uin=" + paramAppInterface.getCurrentAccountUin();
          paramAppInterface = paramContext;
          if (!TextUtils.isEmpty(paramString)) {
            paramAppInterface = paramContext + "&guestuin=" + paramString;
          }
          if (!paramBoolean) {
            continue;
          }
          paramContext = paramAppInterface + "&ADTAG=GXYY_GUAJIAN";
          ((Intent)localObject).putExtra("url", paramContext);
          ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
          return localObject;
        }
        catch (Exception paramAppInterface)
        {
          paramContext = (Context)localObject;
        }
        QLog.e("MusicPendantManager", 1, "openMusicPendantSettingPage() app is null.");
        continue;
      }
      catch (Exception paramAppInterface)
      {
        paramContext = null;
        continue;
      }
      QLog.e("MusicPendantManager", 1, "getPlayBarIntent() exception", paramAppInterface);
      return paramContext;
      paramContext = paramAppInterface + "&ADTAG=GXYY_TOPCELL";
    }
  }
  
  public static MusicPendantManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantManager == null) {
      jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantManager = new MusicPendantManager();
    }
    return jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantManager;
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    try
    {
      jdField_a_of_type_JavaLangString = QQPlayerService.a(6, "MusicPendantManager");
      return jdField_a_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MusicPendantManager", 1, "MusicPendantManager() exception", localException);
      }
    }
  }
  
  /* Error */
  private void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 147	com/tencent/mobileqq/musicpendant/MusicPendantManager:jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo	[Lcom/tencent/mobileqq/music/SongInfo;
    //   4: astore 7
    //   6: aload 7
    //   8: ifnull +205 -> 213
    //   11: iconst_4
    //   12: invokestatic 150	com/tencent/mobileqq/music/QQPlayerService:a	()I
    //   15: if_icmpge +37 -> 52
    //   18: ldc 39
    //   20: iconst_1
    //   21: new 74	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   28: ldc 152
    //   30: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokestatic 150	com/tencent/mobileqq/music/QQPlayerService:a	()I
    //   36: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: invokevirtual 158	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	()Landroid/content/Context;
    //   49: invokestatic 162	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   52: new 164	android/os/Bundle
    //   55: dup
    //   56: invokespecial 165	android/os/Bundle:<init>	()V
    //   59: astore 7
    //   61: lconst_0
    //   62: lstore 5
    //   64: lload 5
    //   66: lstore_3
    //   67: aload_0
    //   68: getfield 167	com/tencent/mobileqq/musicpendant/MusicPendantManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   71: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   74: ifne +14 -> 88
    //   77: aload_0
    //   78: getfield 167	com/tencent/mobileqq/musicpendant/MusicPendantManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   81: invokestatic 173	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   84: invokevirtual 176	java/lang/Long:longValue	()J
    //   87: lstore_3
    //   88: aload 7
    //   90: ldc 178
    //   92: lload_3
    //   93: invokevirtual 182	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   96: aload 7
    //   98: ldc 184
    //   100: iconst_1
    //   101: invokevirtual 188	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   104: aload 7
    //   106: invokestatic 191	com/tencent/mobileqq/music/QQPlayerService:a	(Landroid/os/Bundle;)V
    //   109: aload_0
    //   110: iconst_0
    //   111: invokevirtual 194	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	(Z)Landroid/content/Intent;
    //   114: astore 7
    //   116: aload 7
    //   118: ifnull +8 -> 126
    //   121: aload 7
    //   123: invokestatic 197	com/tencent/mobileqq/music/QQPlayerService:a	(Landroid/content/Intent;)V
    //   126: bipush 102
    //   128: invokestatic 199	com/tencent/mobileqq/music/QQPlayerService:a	(I)V
    //   131: iload_1
    //   132: iflt +90 -> 222
    //   135: iload_1
    //   136: istore_2
    //   137: iload_1
    //   138: aload_0
    //   139: getfield 147	com/tencent/mobileqq/musicpendant/MusicPendantManager:jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo	[Lcom/tencent/mobileqq/music/SongInfo;
    //   142: arraylength
    //   143: if_icmple +6 -> 149
    //   146: goto +76 -> 222
    //   149: aload_0
    //   150: getfield 51	com/tencent/mobileqq/musicpendant/MusicPendantManager:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback	Lcom/tencent/mobileqq/music/QQPlayerService$QQPlayerCallback;
    //   153: invokestatic 202	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService$QQPlayerCallback;)V
    //   156: aload_0
    //   157: invokevirtual 158	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	()Landroid/content/Context;
    //   160: getstatic 33	com/tencent/mobileqq/musicpendant/MusicPendantManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   163: aload_0
    //   164: getfield 147	com/tencent/mobileqq/musicpendant/MusicPendantManager:jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo	[Lcom/tencent/mobileqq/music/SongInfo;
    //   167: iload_2
    //   168: invokestatic 205	com/tencent/mobileqq/music/QQPlayerService:a	(Landroid/content/Context;Ljava/lang/String;[Lcom/tencent/mobileqq/music/SongInfo;I)V
    //   171: return
    //   172: astore 7
    //   174: ldc 39
    //   176: iconst_1
    //   177: ldc 207
    //   179: aload 7
    //   181: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -132 -> 52
    //   187: astore 7
    //   189: ldc 39
    //   191: iconst_1
    //   192: ldc 209
    //   194: aload 7
    //   196: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   199: return
    //   200: astore 8
    //   202: aload 8
    //   204: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   207: lload 5
    //   209: lstore_3
    //   210: goto -122 -> 88
    //   213: ldc 39
    //   215: iconst_1
    //   216: ldc 214
    //   218: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: return
    //   222: iconst_0
    //   223: istore_2
    //   224: goto -75 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	MusicPendantManager
    //   0	227	1	paramInt	int
    //   136	88	2	i	int
    //   66	144	3	l1	long
    //   62	146	5	l2	long
    //   4	118	7	localObject	Object
    //   172	8	7	localException1	Exception
    //   187	8	7	localException2	Exception
    //   200	3	8	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   11	52	172	java/lang/Exception
    //   0	6	187	java/lang/Exception
    //   52	61	187	java/lang/Exception
    //   88	116	187	java/lang/Exception
    //   121	126	187	java/lang/Exception
    //   126	131	187	java/lang/Exception
    //   137	146	187	java/lang/Exception
    //   149	171	187	java/lang/Exception
    //   174	184	187	java/lang/Exception
    //   202	207	187	java/lang/Exception
    //   213	221	187	java/lang/Exception
    //   67	88	200	java/lang/Exception
  }
  
  public static boolean a(SongInfo[] paramArrayOfSongInfo1, SongInfo[] paramArrayOfSongInfo2)
  {
    if ((paramArrayOfSongInfo1 == null) || (paramArrayOfSongInfo2 == null)) {}
    int j;
    do
    {
      return false;
      if (paramArrayOfSongInfo1 == paramArrayOfSongInfo2) {
        return true;
      }
      i = paramArrayOfSongInfo1.length;
      j = paramArrayOfSongInfo2.length;
    } while ((i != j) || (i == 0));
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label62;
      }
      if (paramArrayOfSongInfo1[i].a != paramArrayOfSongInfo2[i].a) {
        break;
      }
      i += 1;
    }
    label62:
    return true;
  }
  
  public Context a()
  {
    if (jdField_b_of_type_JavaLangRefWeakReference != null) {}
    for (Activity localActivity = (Activity)jdField_b_of_type_JavaLangRefWeakReference.get();; localActivity = null)
    {
      Object localObject = localActivity;
      if (localActivity == null) {
        localObject = BaseApplication.getContext();
      }
      return localObject;
    }
  }
  
  public Intent a(boolean paramBoolean)
  {
    Activity localActivity;
    if (jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      localActivity = (Activity)jdField_b_of_type_JavaLangRefWeakReference.get();
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
        break label50;
      }
    }
    label50:
    for (QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localQQAppInterface = null)
    {
      return a(localActivity, localQQAppInterface, this.jdField_b_of_type_JavaLangString, paramBoolean);
      localActivity = null;
      break;
    }
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public Card a()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        String str = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin();
        FriendsManager localFriendsManager = (FriendsManager)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(50);
        if (localFriendsManager != null)
        {
          if (!TextUtils.isEmpty(str)) {
            return localFriendsManager.b(str);
          }
          QLog.e("MusicPendantManager", 1, "localUserUinString is empty");
          return null;
        }
        QLog.e("MusicPendantManager", 1, "FriendsManager is null");
      }
      else
      {
        QLog.e("MusicPendantManager", 1, "mAppInterface is null");
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantManager", 1, "getLocalUserCard() exception", localException);
    }
    return null;
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        CardHandler localCardHandler = (CardHandler)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(2);
        if (localCardHandler != null) {
          localCardHandler.b(b(), paramInt1, paramInt2);
        }
      }
      else
      {
        QLog.e("MusicPendantManager", 1, "request4MusicPendantSettings() mAppInterface is null!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantManager", 1, "request4MusicPendantSettings() exception", localException);
    }
  }
  
  public void a(Card paramCard)
  {
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MusicPendantListener localMusicPendantListener = (MusicPendantListener)((WeakReference)localIterator.next()).get();
        if (localMusicPendantListener != null) {
          localMusicPendantListener.b(paramCard);
        }
      }
      return;
    }
    catch (Exception paramCard)
    {
      QLog.e("MusicPendantManager", 1, "setUin() exception", paramCard);
    }
  }
  
  public void a(MusicPendantListener paramMusicPendantListener)
  {
    List localList = jdField_a_of_type_JavaUtilList;
    if (paramMusicPendantListener != null) {}
    for (;;)
    {
      try
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() != paramMusicPendantListener)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            jdField_a_of_type_JavaUtilList.add(new WeakReference(paramMusicPendantListener));
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
          continue;
        }
        str = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin();
        if (!paramString.equalsIgnoreCase(str)) {
          continue;
        }
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        if ((!TextUtils.isEmpty(paramString)) && (!paramString.equalsIgnoreCase(this.jdField_b_of_type_JavaLangString))) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo = null;
        }
      }
      catch (Exception localException)
      {
        String str;
        boolean bool;
        QLog.e("MusicPendantManager", 1, "setUin() exception", localException);
        continue;
      }
      this.jdField_b_of_type_JavaLangString = paramString;
      return;
      str = "";
      continue;
      bool = false;
    }
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if (paramActivity != null) {}
    for (;;)
    {
      try
      {
        jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
        if (paramQQAppInterface == null) {
          break label75;
        }
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
        a(paramString);
        f();
        ThreadManager.post(new aetm(this), 8, null, true);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("MusicPendantManager", 1, "init(uinString) exception", paramString);
        return;
      }
      jdField_b_of_type_JavaLangRefWeakReference = null;
      continue;
      label75:
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public void a(SongInfo[] paramArrayOfSongInfo)
  {
    int m = 0;
    if (paramArrayOfSongInfo != null) {}
    for (;;)
    {
      int k;
      try
      {
        j = paramArrayOfSongInfo.length;
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) || (j != this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length)) {
          break label122;
        }
        k = 0;
        i = m;
        if (k < j)
        {
          if (paramArrayOfSongInfo[k].a == this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[k].a) {
            break label113;
          }
          i = 1;
        }
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo = paramArrayOfSongInfo;
        if (i != 0)
        {
          ThreadManager.post(new aetl(this), 8, null, true);
          return;
        }
        QLog.i("MusicPendantManager", 1, "setMusicPendantSongList(SongInfo) isPlayListChanged:false.");
        return;
      }
      catch (Exception paramArrayOfSongInfo)
      {
        QLog.e("MusicPendantManager", 1, "setMusicPendantSongList(SongInfo) exception", paramArrayOfSongInfo);
        return;
      }
      int j = -1;
      continue;
      label113:
      k += 1;
      continue;
      label122:
      int i = 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public SongInfo[] a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) {
          break label145;
        }
        Object localObject = QQPlayerService.a();
        if (localObject == null) {
          break label155;
        }
        localObject = ((Bundle)localObject).getLong("BUNDLE_KEY_UIN") + "";
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!this.jdField_b_of_type_JavaLangString.equalsIgnoreCase((String)localObject)) || (!jdField_a_of_type_JavaLangString.equalsIgnoreCase(QQPlayerService.a()))) {
          break label139;
        }
        int i = QQPlayerService.a();
        if ((i == 2) || (i == 1))
        {
          localObject = QQPlayerService.a();
          if (a(this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo, (SongInfo[])localObject)) {
            break label154;
          }
          a(0);
          return;
        }
        if (i == 3)
        {
          QQPlayerService.b(a());
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MusicPendantManager", 1, "play() exception", localException);
        return;
      }
      a(0);
      return;
      label139:
      a(0);
      return;
      label145:
      QLog.e("MusicPendantManager", 1, "play() mMusicPendantSongs is null!");
      label154:
      return;
      label155:
      String str = "";
    }
  }
  
  public void b(MusicPendantListener paramMusicPendantListener)
  {
    List localList = jdField_a_of_type_JavaUtilList;
    if (paramMusicPendantListener != null) {}
    int i;
    try
    {
      if (jdField_a_of_type_JavaUtilList == null) {
        break label104;
      }
      i = jdField_a_of_type_JavaUtilList.size();
    }
    finally {}
    if (i >= 0)
    {
      WeakReference localWeakReference = (WeakReference)jdField_a_of_type_JavaUtilList.get(i);
      if ((localWeakReference != null) && ((localWeakReference.get() == null) || (localWeakReference.get() == paramMusicPendantListener))) {
        jdField_a_of_type_JavaUtilList.remove(localWeakReference);
      }
    }
    else
    {
      return;
    }
    for (;;)
    {
      i -= 1;
      break;
      i -= 1;
      break;
      label104:
      i = 0;
    }
  }
  
  public void c()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) {
          break label132;
        }
        Object localObject = QQPlayerService.a();
        if (localObject == null) {
          break label142;
        }
        localObject = ((Bundle)localObject).getLong("BUNDLE_KEY_UIN") + "";
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!this.jdField_b_of_type_JavaLangString.equalsIgnoreCase((String)localObject)) || (!jdField_a_of_type_JavaLangString.equalsIgnoreCase(QQPlayerService.a()))) {
          break label126;
        }
        int i = QQPlayerService.a();
        if ((i == 2) || (i == 1))
        {
          QQPlayerService.a(a());
          return;
        }
        if (i == 3)
        {
          QQPlayerService.b(a());
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MusicPendantManager", 1, "playOrPause() exception", localException);
        return;
      }
      a(0);
      return;
      label126:
      a(0);
      return;
      label132:
      QLog.e("MusicPendantManager", 1, "playOrPause() mMusicPendantSongs is null!");
      return;
      label142:
      String str = "";
    }
  }
  
  public void d()
  {
    try
    {
      Object localObject = QQPlayerService.a();
      if (localObject != null) {}
      for (localObject = ((Bundle)localObject).getLong("BUNDLE_KEY_UIN") + ""; (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase((String)localObject)) && (jdField_a_of_type_JavaLangString.equalsIgnoreCase(QQPlayerService.a())); localObject = "")
      {
        QQPlayerService.a(a());
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantManager", 1, "pause() exception", localException);
    }
  }
  
  public void e()
  {
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MusicPendantListener localMusicPendantListener = (MusicPendantListener)((WeakReference)localIterator.next()).get();
        if (localMusicPendantListener != null) {
          localMusicPendantListener.a();
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          QLog.e("MusicPendantManager", 1, "destroy() exception1", localException1);
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
          {
            this.jdField_a_of_type_JavaLangRefWeakReference.clear();
            this.jdField_a_of_type_JavaLangRefWeakReference = null;
          }
          if (jdField_b_of_type_JavaLangRefWeakReference != null)
          {
            jdField_b_of_type_JavaLangRefWeakReference.clear();
            jdField_b_of_type_JavaLangRefWeakReference = null;
          }
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("MusicPendantManager", 1, "destroy() exception2", localException2);
        }
        a();
      }
    }
  }
  
  public void f()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        CardHandler localCardHandler = (CardHandler)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(2);
        if (localCardHandler != null) {
          localCardHandler.c(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), b());
        }
      }
      else
      {
        QLog.e("MusicPendantManager", 1, "request4MusicPendantSongList() mAppInterface is null!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantManager", 1, "request4MusicPendantSongList() exception", localException);
    }
  }
  
  public void g()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        CardHandler localCardHandler = (CardHandler)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(2);
        if (localCardHandler != null) {
          localCardHandler.b(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), b());
        }
      }
      else
      {
        QLog.e("MusicPendantManager", 1, "request4MusicPendantSettings() mAppInterface is null!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantManager", 1, "request4MusicPendantSettings() exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.musicpendant.MusicPendantManager
 * JD-Core Version:    0.7.0.1
 */