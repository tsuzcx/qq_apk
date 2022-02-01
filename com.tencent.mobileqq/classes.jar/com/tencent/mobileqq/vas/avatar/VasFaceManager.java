package com.tencent.mobileqq.vas.avatar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLState;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.IHeadIconProcessor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
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
  extends VasManager<String>
{
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  public static Handler a;
  public static Boolean a;
  private static final ArrayList<VasFaceManager.Replayer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_a_of_type_Boolean;
  public QQAppInterface a;
  private final LongSparseArray<Object> jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
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
    paramString = paramQQAppInterface.getExtensionInfo(paramString, false);
    if (((paramString != null) && (paramString.faceId > 0)) || (SimpleUIUtil.a())) {
      return 4;
    }
    return 0;
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
      Object localObject = (HeadIconWrapper)paramListView.a(HeadIconWrapper.class);
      if (localObject != null)
      {
        localObject = ((IHeadIconProcessor)((HeadIconWrapper)localObject).a()).a();
        if ((localObject != null) && (paramListView.getTop() + ((VasAvatar)localObject).getBottom() > paramInt2)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public static VasFaceManager a(QQAppInterface paramQQAppInterface)
  {
    return ((VasExtensionManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
  }
  
  public static String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = AIOUtils.a();
    if (a()) {
      localStringBuilder.append(AppConstants.PATH_HEAD_STORE);
    } else {
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_st/");
    }
    localStringBuilder.append(paramInt);
    localStringBuilder.append(File.separatorChar);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "getFacePath failed scid is empty");
      return null;
    }
    Object localObject = paramString.split("\\.");
    if (localObject.length != 3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFacePath failed scid is ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("Q.qqhead.VasFaceManager", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    try
    {
      int i = Integer.parseInt(localObject[1]);
      if ((!"small".equals(localObject[2])) && (!"medium".equals(localObject[2])) && (!"large".equals(localObject[2])))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFacePath failed with unknown size type ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("Q.qqhead.VasFaceManager", 1, ((StringBuilder)localObject).toString());
        return null;
      }
      return a(i, localObject[2]);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFacePath failed from ");
      localStringBuilder.append(paramString);
      QLog.e("Q.qqhead.VasFaceManager", 1, localStringBuilder.toString(), localNumberFormatException);
    }
    return null;
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {
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
  }
  
  public static void a(ApngDrawable paramApngDrawable)
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
  }
  
  private void a(ChatAdapter1 paramChatAdapter1, int paramInt, VasAvatar paramVasAvatar)
  {
    if (paramVasAvatar != null)
    {
      paramChatAdapter1 = (ChatMessage)paramChatAdapter1.getItem(paramInt);
      if (paramChatAdapter1 != null)
      {
        long l = paramChatAdapter1.uniseq;
        if (this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(l) == null)
        {
          paramChatAdapter1 = paramVasAvatar.getDrawable();
          if ((paramChatAdapter1 instanceof URLDrawable))
          {
            paramChatAdapter1 = ((URLDrawable)paramChatAdapter1).getCurrDrawable();
            if ((paramChatAdapter1 instanceof ApngDrawable)) {
              a((ApngDrawable)paramChatAdapter1);
            }
          }
        }
      }
    }
  }
  
  public static void a(String paramString, ApngDrawable paramApngDrawable)
  {
    int i;
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
      Object localObject;
      if (i >= 0)
      {
        localObject = (ApngImage)((VasFaceManager.Replayer)jdField_a_of_type_JavaUtilArrayList.get(i)).a.get();
        if (localObject == null) {
          jdField_a_of_type_JavaUtilArrayList.remove(i);
        } else if (localObject != paramApngDrawable.getImage()) {}
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("registerNewFace: ");
          ((StringBuilder)localObject).append(paramApngDrawable.getImage());
          QLog.e("Q.qqhead.VasFaceManager", 2, ((StringBuilder)localObject).toString());
        }
        jdField_a_of_type_JavaUtilArrayList.add(new VasFaceManager.Replayer(paramString, paramApngDrawable, jdField_a_of_type_AndroidOsHandler));
        return;
      }
    }
  }
  
  private static boolean a()
  {
    if (jdField_a_of_type_JavaLangBoolean == null) {
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(SystemUtil.a());
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static void b()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("resume: ");
      ((StringBuilder)???).append(jdField_a_of_type_JavaUtilArrayList.size());
      QLog.i("Q.qqhead.VasFaceManager", 2, ((StringBuilder)???).toString());
    }
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
      else
      {
        jdField_a_of_type_Boolean = false;
        return;
      }
    }
  }
  
  private void b(ExtensionInfo paramExtensionInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFaceIdChanged uin: ");
      ((StringBuilder)localObject).append(paramExtensionInfo.uin);
      ((StringBuilder)localObject).append(" newId: ");
      ((StringBuilder)localObject).append(paramExtensionInfo.faceId);
      ((StringBuilder)localObject).append(" faceUpdateTime: ");
      ((StringBuilder)localObject).append(paramExtensionInfo.faceIdUpdateTime);
      QLog.d("Q.qqhead.VasFaceManager", 2, ((StringBuilder)localObject).toString());
    }
    a(paramExtensionInfo.uin, null);
    if (paramExtensionInfo.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("my_store_face_id", paramExtensionInfo.faceId);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public void a(int paramInt, String paramString, VasManager.CompleteListener<String> paramCompleteListener, Object paramObject)
  {
    Object localObject = AIOUtils.a();
    ((StringBuilder)localObject).append("face.");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    a((String)localObject, paramCompleteListener, paramObject);
    ThreadManagerV2.excute(new VasFaceManager.1(this, a(paramInt, paramString), (String)localObject), 128, null, true);
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    HashSet localHashSet = new HashSet();
    if ((paramExtensionInfo != null) && (!TextUtils.isEmpty(paramExtensionInfo.uin)))
    {
      b(paramExtensionInfo);
      localHashSet.add(paramExtensionInfo.uin);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(46, true, localHashSet);
    }
  }
  
  public void a(ListView paramListView, ChatAdapter1 paramChatAdapter1, int paramInt)
  {
    int k = paramListView.getContext().getResources().getDimensionPixelSize(2131299168);
    int n = paramListView.getFirstVisiblePosition();
    int m = paramListView.getChildCount();
    int i1 = paramListView.getHeaderViewsCount();
    int j = 0;
    int i;
    if (n < i1) {
      i = 0;
    } else {
      i = n - i1;
    }
    m = Math.min(paramChatAdapter1.getCount(), m + n - i1);
    if (n < i1) {
      j = i1 - n;
    }
    if (paramInt == 0)
    {
      while (i < m)
      {
        a(paramChatAdapter1, i, a(paramListView, j, k));
        i += 1;
        j += 1;
      }
      this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentUtilLongSparseArray.a() == 0) {
      while (i < m)
      {
        if (a(paramListView, j, k) != null)
        {
          ChatMessage localChatMessage = (ChatMessage)paramChatAdapter1.getItem(i);
          if (localChatMessage != null) {
            this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(localChatMessage.uniseq, this);
          }
        }
        i += 1;
        j += 1;
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("download store face scid: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" errorCode: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("Q.qqhead.VasFaceManager", 1, ((StringBuilder)localObject).toString());
    if (paramInt == 0) {
      localObject = a(paramString);
    } else {
      localObject = null;
    }
    a(paramString, localObject);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(46, true, localHashSet);
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
      ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtensionInfo(paramString, true);
      int i;
      if (localExtensionInfo == null)
      {
        localExtensionInfo = new ExtensionInfo();
        localExtensionInfo.uin = paramString;
        i = 0;
      }
      else
      {
        i = localExtensionInfo.faceId;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleFaceId uin: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" oldId: ");
      localStringBuilder.append(i);
      localStringBuilder.append(" newId: ");
      localStringBuilder.append(paramInt);
      QLog.d("Q.qqhead.VasFaceManager", 1, localStringBuilder.toString());
      if (i != paramInt) {
        b(Arrays.asList(new String[] { paramString }));
      }
      paramString = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localExtensionInfo.setStatus(1000);
      localExtensionInfo.faceId = paramInt;
      localExtensionInfo.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
      localExtensionInfo.timestamp = System.currentTimeMillis();
      paramString.a(localExtensionInfo);
      a(localExtensionInfo);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "", paramString);
    }
  }
  
  public void b(String paramString, VasManager.CompleteListener<String> paramCompleteListener, Object paramObject)
  {
    a(paramString, paramCompleteListener, paramObject);
    ThreadManagerV2.excute(new VasFaceManager.2(this, paramString), 32, null, true);
  }
  
  /* Error */
  public void b(Collection<String> paramCollection)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/tencent/mobileqq/vas/avatar/VasFaceManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 603	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   7: invokevirtual 609	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore 5
    //   12: aconst_null
    //   13: astore_2
    //   14: aconst_null
    //   15: astore_3
    //   16: aload 5
    //   18: invokevirtual 615	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 4
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: astore_2
    //   29: aload 4
    //   31: invokevirtual 620	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: astore_2
    //   40: aload_1
    //   41: invokeinterface 533 1 0
    //   46: astore_1
    //   47: aload 4
    //   49: astore_3
    //   50: aload 4
    //   52: astore_2
    //   53: aload_1
    //   54: invokeinterface 538 1 0
    //   59: ifeq +109 -> 168
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: astore_2
    //   68: aload_1
    //   69: invokeinterface 541 1 0
    //   74: checkcast 232	java/lang/String
    //   77: astore 6
    //   79: aload 4
    //   81: astore_3
    //   82: aload 4
    //   84: astore_2
    //   85: aload 5
    //   87: ldc_w 622
    //   90: aload 6
    //   92: invokevirtual 626	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   95: checkcast 622	com/tencent/mobileqq/data/Setting
    //   98: astore 7
    //   100: aload 7
    //   102: ifnull -55 -> 47
    //   105: aload 4
    //   107: astore_3
    //   108: aload 4
    //   110: astore_2
    //   111: aload 7
    //   113: lconst_0
    //   114: putfield 629	com/tencent/mobileqq/data/Setting:updateTimestamp	J
    //   117: aload 4
    //   119: astore_3
    //   120: aload 4
    //   122: astore_2
    //   123: aload_0
    //   124: getfield 59	com/tencent/mobileqq/vas/avatar/VasFaceManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   127: aload 7
    //   129: invokevirtual 633	com/tencent/mobileqq/app/QQAppInterface:updateSettingTableCache	(Lcom/tencent/mobileqq/data/Setting;)V
    //   132: aload 4
    //   134: astore_3
    //   135: aload 4
    //   137: astore_2
    //   138: aload_0
    //   139: getfield 59	com/tencent/mobileqq/vas/avatar/VasFaceManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   142: iconst_1
    //   143: aload 6
    //   145: sipush 200
    //   148: invokevirtual 637	com/tencent/mobileqq/app/QQAppInterface:removeFaceIconCache	(ILjava/lang/String;I)V
    //   151: aload 4
    //   153: astore_3
    //   154: aload 4
    //   156: astore_2
    //   157: aload 5
    //   159: aload 7
    //   161: invokevirtual 641	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   164: pop
    //   165: goto -118 -> 47
    //   168: aload 4
    //   170: astore_3
    //   171: aload 4
    //   173: astore_2
    //   174: aload 4
    //   176: invokevirtual 643	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   179: aload 4
    //   181: ifnull +34 -> 215
    //   184: aload 4
    //   186: astore_2
    //   187: goto +24 -> 211
    //   190: astore_1
    //   191: goto +30 -> 221
    //   194: astore_1
    //   195: aload_2
    //   196: astore_3
    //   197: ldc 220
    //   199: iconst_1
    //   200: ldc_w 645
    //   203: aload_1
    //   204: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   207: aload_2
    //   208: ifnull +7 -> 215
    //   211: aload_2
    //   212: invokevirtual 648	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   215: aload 5
    //   217: invokevirtual 651	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   220: return
    //   221: aload_3
    //   222: ifnull +7 -> 229
    //   225: aload_3
    //   226: invokevirtual 648	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   229: aload 5
    //   231: invokevirtual 651	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   234: goto +5 -> 239
    //   237: aload_1
    //   238: athrow
    //   239: goto -2 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	VasFaceManager
    //   0	242	1	paramCollection	Collection<String>
    //   13	199	2	localObject1	Object
    //   15	211	3	localObject2	Object
    //   21	164	4	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   10	220	5	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   77	67	6	str	String
    //   98	62	7	localSetting	com.tencent.mobileqq.data.Setting
    // Exception table:
    //   from	to	target	type
    //   16	23	190	finally
    //   29	34	190	finally
    //   40	47	190	finally
    //   53	62	190	finally
    //   68	79	190	finally
    //   85	100	190	finally
    //   111	117	190	finally
    //   123	132	190	finally
    //   138	151	190	finally
    //   157	165	190	finally
    //   174	179	190	finally
    //   197	207	190	finally
    //   16	23	194	java/lang/Exception
    //   29	34	194	java/lang/Exception
    //   40	47	194	java/lang/Exception
    //   53	62	194	java/lang/Exception
    //   68	79	194	java/lang/Exception
    //   85	100	194	java/lang/Exception
    //   111	117	194	java/lang/Exception
    //   123	132	194	java/lang/Exception
    //   138	151	194	java/lang/Exception
    //   157	165	194	java/lang/Exception
    //   174	179	194	java/lang/Exception
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasFaceManager
 * JD-Core Version:    0.7.0.1
 */