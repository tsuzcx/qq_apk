package com.tencent.mobileqq.vas.avatar;

import aciy;
import acka;
import ajed;
import ajfb;
import ajjj;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import awnu;
import azzu;
import baov;
import bapa;
import bapb;
import beey;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLState;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class VasFaceManager
  extends bapa<String>
{
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  public static Handler a;
  public static Boolean a;
  private static final ArrayList<VasFaceManager.Replayer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_a_of_type_Boolean;
  private final beey<Object> jdField_a_of_type_Beey = new beey();
  public QQAppInterface a;
  private LinkedHashMap<String, Object> jdField_a_of_type_JavaUtilLinkedHashMap = new VasFaceManager.3(this, 20, 0.75F, true);
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public VasFaceManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramString = paramQQAppInterface.a(paramString, false);
    if (((paramString != null) && (paramString.faceId > 0)) || (awnu.b())) {
      i = 4;
    }
    return i;
  }
  
  public static Bundle a()
  {
    if (jdField_a_of_type_AndroidOsBundle == null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_loop", 3);
      localBundle.putBoolean("key_double_bitmap", true);
      localBundle.putBoolean("key_draw_round", true);
      localBundle.putBoolean("key_get_reset_loop", false);
      localBundle.putBoolean("key_stop_on_first", true);
      localBundle.putIntArray("key_tagId_arr", new int[] { 9, 10, 2, 1, 0, 11 });
      localBundle.putString("key_name", "-face-");
      jdField_a_of_type_AndroidOsBundle = localBundle;
    }
    return jdField_a_of_type_AndroidOsBundle;
  }
  
  public static Bundle a(boolean paramBoolean)
  {
    Bundle localBundle1 = a();
    if (paramBoolean)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putAll(localBundle1);
      localBundle2.remove("key_loop");
      return localBundle2;
    }
    return localBundle1;
  }
  
  private VasAvatar a(ListView paramListView, int paramInt1, int paramInt2)
  {
    if (!(paramListView.getChildAt(paramInt1) instanceof BaseChatItemLayout)) {
      return null;
    }
    paramListView = (BaseChatItemLayout)paramListView.getChildAt(paramInt1);
    if (paramListView != null)
    {
      VasAvatar localVasAvatar = paramListView.a;
      if ((localVasAvatar != null) && (paramListView.getTop() + localVasAvatar.getBottom() > paramInt2)) {
        return localVasAvatar;
      }
    }
    return null;
  }
  
  public static VasFaceManager a(QQAppInterface paramQQAppInterface)
  {
    return ((baov)paramQQAppInterface.getManager(235)).a;
  }
  
  public static String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = aciy.a();
    if (a()) {
      localStringBuilder.append(ajed.bD);
    }
    for (;;)
    {
      localStringBuilder.append(paramInt).append(File.separatorChar).append(paramString).append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_st/");
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "getFacePath failed scid is empty");
      return null;
    }
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length != 3)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "getFacePath failed scid is " + paramString);
      return null;
    }
    int i;
    try
    {
      i = Integer.parseInt(arrayOfString[1]);
      if ((!"small".equals(arrayOfString[2])) && (!"medium".equals(arrayOfString[2])) && (!"large".equals(arrayOfString[2])))
      {
        QLog.e("Q.qqhead.VasFaceManager", 1, "getFacePath failed with unknown size type " + paramString);
        return null;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "getFacePath failed from " + paramString, localNumberFormatException);
      return null;
    }
    return a(i, localNumberFormatException[2]);
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {}
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      int i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
      while (i >= 0)
      {
        ((VasFaceManager.Replayer)jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        i -= 1;
      }
      jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public static void a(ApngDrawable paramApngDrawable)
  {
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i >= 0)
        {
          VasFaceManager.Replayer localReplayer = (VasFaceManager.Replayer)jdField_a_of_type_JavaUtilArrayList.get(i);
          ApngImage localApngImage = (ApngImage)localReplayer.a.get();
          if (localApngImage == null) {
            jdField_a_of_type_JavaUtilArrayList.remove(i);
          } else if (localApngImage == paramApngDrawable.getImage()) {
            localReplayer.c();
          }
        }
        else
        {
          return;
        }
      }
      i -= 1;
    }
  }
  
  public static void a(String paramString, ApngDrawable paramApngDrawable)
  {
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i >= 0)
        {
          ApngImage localApngImage = (ApngImage)((VasFaceManager.Replayer)jdField_a_of_type_JavaUtilArrayList.get(i)).a.get();
          if (localApngImage == null) {
            jdField_a_of_type_JavaUtilArrayList.remove(i);
          } else if (localApngImage != paramApngDrawable.getImage()) {}
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.qqhead.VasFaceManager", 2, "registerNewFace: " + paramApngDrawable.getImage());
          }
          jdField_a_of_type_JavaUtilArrayList.add(new VasFaceManager.Replayer(paramString, paramApngDrawable, jdField_a_of_type_AndroidOsHandler));
          return;
        }
      }
      i -= 1;
    }
  }
  
  private static boolean a()
  {
    if (jdField_a_of_type_JavaLangBoolean == null) {
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(azzu.a());
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.VasFaceManager", 2, "resume: " + jdField_a_of_type_JavaUtilArrayList.size());
    }
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i >= 0)
        {
          VasFaceManager.Replayer localReplayer = (VasFaceManager.Replayer)jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((ApngImage)localReplayer.a.get() != null) {
            localReplayer.b();
          } else {
            jdField_a_of_type_JavaUtilArrayList.remove(i);
          }
        }
      }
      jdField_a_of_type_Boolean = false;
      return;
      i -= 1;
    }
  }
  
  private void b(ExtensionInfo paramExtensionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.VasFaceManager", 2, "onFaceIdChanged uin: " + paramExtensionInfo.uin + " newId: " + paramExtensionInfo.faceId + " faceUpdateTime: " + paramExtensionInfo.faceIdUpdateTime);
    }
    a(paramExtensionInfo.uin, null);
    if (paramExtensionInfo.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
      localEditor.putInt("my_store_face_id", paramExtensionInfo.faceId);
      localEditor.commit();
    }
  }
  
  public void a(int paramInt, String paramString, bapb<String> parambapb, Object paramObject)
  {
    String str = "face." + paramInt + "." + paramString;
    a(str, parambapb, paramObject);
    ThreadManagerV2.excute(new VasFaceManager.1(this, a(paramInt, paramString), str), 128, null, true);
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    HashSet localHashSet = new HashSet();
    if ((paramExtensionInfo != null) && (!TextUtils.isEmpty(paramExtensionInfo.uin)))
    {
      b(paramExtensionInfo);
      localHashSet.add(paramExtensionInfo.uin);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(46, true, localHashSet);
    }
  }
  
  public void a(ListView paramListView, acka paramacka, int paramInt)
  {
    int j = 0;
    int k = paramListView.getContext().getResources().getDimensionPixelSize(2131167766);
    int n = paramListView.getFirstVisiblePosition();
    int m = paramListView.getChildCount();
    int i1 = paramListView.getHeaderViewsCount();
    if (n < i1) {}
    Object localObject;
    for (int i = 0;; i = n - i1)
    {
      m = Math.min(paramacka.getCount(), m + n - i1);
      if (n < i1) {
        j = i1 - n;
      }
      if (paramInt != 0) {
        break label213;
      }
      while (i < m)
      {
        localObject = a(paramListView, j, k);
        if (localObject != null)
        {
          ChatMessage localChatMessage = (ChatMessage)paramacka.getItem(i);
          if (localChatMessage != null)
          {
            long l = localChatMessage.uniseq;
            if (this.jdField_a_of_type_Beey.a(l) == null)
            {
              localObject = ((VasAvatar)localObject).getDrawable();
              if ((localObject instanceof URLDrawable))
              {
                localObject = ((URLDrawable)localObject).getCurrDrawable();
                if ((localObject instanceof ApngDrawable)) {
                  a((ApngDrawable)localObject);
                }
              }
            }
          }
        }
        j += 1;
        i += 1;
      }
    }
    this.jdField_a_of_type_Beey.a();
    for (;;)
    {
      return;
      label213:
      if (this.jdField_a_of_type_Beey.a() == 0) {
        while (i < m)
        {
          if (a(paramListView, j, k) != null)
          {
            localObject = (ChatMessage)paramacka.getItem(i);
            if (localObject != null) {
              this.jdField_a_of_type_Beey.a(((ChatMessage)localObject).uniseq, this);
            }
          }
          j += 1;
          i += 1;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.d("Q.qqhead.VasFaceManager", 1, "download store face scid: " + paramString + " errorCode: " + paramInt);
    if ((paramInt <= 0) || (paramInt == 0)) {}
    for (String str = a(paramString);; str = null)
    {
      a(paramString, str);
      return;
    }
  }
  
  public void a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(URLState.getMemoryCacheKey(paramURL.toString(), paramURLDrawableOptions), Boolean.TRUE);
  }
  
  public void a(Collection<ExtensionInfo> paramCollection)
  {
    HashSet localHashSet = new HashSet();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      ExtensionInfo localExtensionInfo = (ExtensionInfo)paramCollection.next();
      if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.uin)))
      {
        b(localExtensionInfo);
        localHashSet.add(localExtensionInfo.uin);
      }
    }
    if (!localHashSet.isEmpty()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(46, true, localHashSet);
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return new File(paramString).exists();
    }
    return false;
  }
  
  public void b(String paramString, int paramInt)
  {
    try
    {
      ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, true);
      if (localExtensionInfo == null)
      {
        localExtensionInfo = new ExtensionInfo();
        localExtensionInfo.uin = paramString;
      }
      for (int i = 0;; i = localExtensionInfo.faceId)
      {
        QLog.d("Q.qqhead.VasFaceManager", 1, "handleFaceId uin: " + paramString + " oldId: " + i + " newId: " + paramInt);
        if (i != paramInt) {
          b(Arrays.asList(new String[] { paramString }));
        }
        paramString = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        localExtensionInfo.setStatus(1000);
        localExtensionInfo.faceId = paramInt;
        localExtensionInfo.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
        localExtensionInfo.timestamp = System.currentTimeMillis();
        paramString.a(localExtensionInfo);
        a(localExtensionInfo);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "", paramString);
    }
  }
  
  public void b(String paramString, bapb<String> parambapb, Object paramObject)
  {
    a(paramString, parambapb, paramObject);
    ThreadManagerV2.excute(new VasFaceManager.2(this, paramString), 32, null, true);
  }
  
  /* Error */
  public void b(Collection<String> paramCollection)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/tencent/mobileqq/vas/avatar/VasFaceManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 576	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Latmq;
    //   7: invokevirtual 582	atmq:createEntityManager	()Latmp;
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: aload 4
    //   16: invokevirtual 587	atmp:a	()Latmr;
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual 590	atmr:a	()V
    //   24: aload_1
    //   25: invokeinterface 509 1 0
    //   30: astore_1
    //   31: aload_1
    //   32: invokeinterface 514 1 0
    //   37: ifeq +99 -> 136
    //   40: aload_1
    //   41: invokeinterface 517 1 0
    //   46: checkcast 218	java/lang/String
    //   49: astore_3
    //   50: aload 4
    //   52: ldc_w 592
    //   55: aload_3
    //   56: invokevirtual 595	atmp:a	(Ljava/lang/Class;Ljava/lang/String;)Latmo;
    //   59: checkcast 592	com/tencent/mobileqq/data/Setting
    //   62: astore 5
    //   64: aload 5
    //   66: ifnull -35 -> 31
    //   69: aload 5
    //   71: lconst_0
    //   72: putfield 598	com/tencent/mobileqq/data/Setting:updateTimestamp	J
    //   75: aload_0
    //   76: getfield 59	com/tencent/mobileqq/vas/avatar/VasFaceManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   79: aload 5
    //   81: invokevirtual 601	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;)V
    //   84: aload_0
    //   85: getfield 59	com/tencent/mobileqq/vas/avatar/VasFaceManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   88: iconst_1
    //   89: aload_3
    //   90: sipush 200
    //   93: invokevirtual 604	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)V
    //   96: aload 4
    //   98: aload 5
    //   100: invokevirtual 607	atmp:a	(Latmo;)Z
    //   103: pop
    //   104: goto -73 -> 31
    //   107: astore_3
    //   108: aload_2
    //   109: astore_1
    //   110: aload_3
    //   111: astore_2
    //   112: ldc 206
    //   114: iconst_1
    //   115: ldc_w 609
    //   118: aload_2
    //   119: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 610	atmr:b	()V
    //   130: aload 4
    //   132: invokevirtual 611	atmp:a	()V
    //   135: return
    //   136: aload_2
    //   137: invokevirtual 612	atmr:c	()V
    //   140: aload_2
    //   141: ifnull +7 -> 148
    //   144: aload_2
    //   145: invokevirtual 610	atmr:b	()V
    //   148: aload 4
    //   150: invokevirtual 611	atmp:a	()V
    //   153: return
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 610	atmr:b	()V
    //   165: aload 4
    //   167: invokevirtual 611	atmp:a	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: goto -16 -> 157
    //   176: astore_3
    //   177: aload_1
    //   178: astore_2
    //   179: aload_3
    //   180: astore_1
    //   181: goto -24 -> 157
    //   184: astore_2
    //   185: aload_3
    //   186: astore_1
    //   187: goto -75 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	VasFaceManager
    //   0	190	1	paramCollection	Collection<String>
    //   19	160	2	localObject1	Object
    //   184	1	2	localException1	Exception
    //   13	77	3	str	String
    //   107	4	3	localException2	Exception
    //   176	10	3	localObject2	Object
    //   10	156	4	localatmp	atmp
    //   62	37	5	localSetting	com.tencent.mobileqq.data.Setting
    // Exception table:
    //   from	to	target	type
    //   20	31	107	java/lang/Exception
    //   31	64	107	java/lang/Exception
    //   69	104	107	java/lang/Exception
    //   136	140	107	java/lang/Exception
    //   14	20	154	finally
    //   20	31	172	finally
    //   31	64	172	finally
    //   69	104	172	finally
    //   136	140	172	finally
    //   112	122	176	finally
    //   14	20	184	java/lang/Exception
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasFaceManager
 * JD-Core Version:    0.7.0.1
 */