package com.tencent.mobileqq.util;

import ajzx;
import ajzy;
import ajzz;
import akaa;
import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FaceDownloader;
import com.tencent.mobileqq.app.NearByFaceDownloader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class FaceManager
  implements Manager
{
  ajzy jdField_a_of_type_Ajzy;
  ajzz jdField_a_of_type_Ajzz;
  akaa jdField_a_of_type_Akaa;
  MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  NearByFaceDownloader jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  List jdField_a_of_type_JavaUtilList;
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  List b;
  List c;
  
  public FaceManager(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof NearbyAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramAppInterface);
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.sImageCache;
    }
    while (!(paramAppInterface instanceof QQAppInterface)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
    this.jdField_a_of_type_Ajzz = new ajzz(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Ajzz);
    this.jdField_a_of_type_Ajzy = new ajzy(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Ajzy);
    this.jdField_a_of_type_Akaa = new akaa(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akaa);
    this.jdField_a_of_type_JavaUtilList = new Vector();
    this.b = new Vector();
    this.c = new Vector();
  }
  
  public static byte a(int paramInt)
  {
    if (paramInt == 32) {
      return 1;
    }
    return 2;
  }
  
  private void a(int paramInt, Object paramObject, boolean paramBoolean, Object... paramVarArgs)
  {
    Object localObject;
    boolean bool;
    if (((paramObject instanceof FaceDrawableImpl.InternalFriendListObserver)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localObject = (FaceDrawableImpl.InternalFriendListObserver)paramObject;
      if ((TextUtils.isEmpty(((FaceDrawableImpl.InternalFriendListObserver)localObject).a)) || (!((FaceDrawableImpl.InternalFriendListObserver)localObject).a.equals((String)paramVarArgs[0]))) {
        break label201;
      }
      bool = true;
    }
    for (;;)
    {
      if (bool)
      {
        paramObject = new ajzx(this, paramObject, paramInt, paramBoolean, paramVarArgs);
        ThreadManager.getUIHandler().post(paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("FaceManager", 2, "dispatchMessage , needDis:" + bool + ",type: " + paramInt + ",args: " + paramVarArgs);
        }
      }
      return;
      if (((paramObject instanceof FaceDrawableImpl.InternalDiscussionObserver)) && (paramVarArgs != null) && (paramVarArgs.length > 1))
      {
        localObject = (FaceDrawableImpl.InternalDiscussionObserver)paramObject;
        if ((!TextUtils.isEmpty(((FaceDrawableImpl.InternalDiscussionObserver)localObject).a)) && (((FaceDrawableImpl.InternalDiscussionObserver)localObject).a.equals((String)paramVarArgs[1])))
        {
          bool = true;
          continue;
        }
      }
      bool = false;
      continue;
      label201:
      bool = false;
    }
  }
  
  public Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache)
    {
      Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          localBitmap1 = localBitmap2;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
          {
            long l = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
            localBitmap1 = localBitmap2;
            if (System.currentTimeMillis() - l > 86400000L)
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
              this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
              localBitmap1 = null;
            }
          }
        }
      }
      return localBitmap1;
    }
  }
  
  public FaceDownloader a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader = new NearByFaceDownloader(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      }
      NearByFaceDownloader localNearByFaceDownloader = this.jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader;
      return localNearByFaceDownloader;
    }
    finally {}
  }
  
  public Setting a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramString);
  }
  
  public String a(FaceInfo paramFaceInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (SystemUtil.a()) {
      localStringBuilder.append(AppConstants.bo);
    }
    for (;;)
    {
      localStringBuilder.append("stranger_").append(Integer.toString(paramFaceInfo.b)).append("_");
      String str = MD5.toMD5(paramFaceInfo.a);
      str = MD5.toMD5(str + paramFaceInfo.a);
      localStringBuilder.append(MD5.toMD5(str + paramFaceInfo.a));
      localStringBuilder.append(".jpg_");
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext()) {
          a(paramInt, (FaceDrawableImpl.FaceObserver)localIterator.next(), paramBoolean, paramVarArgs);
        }
      }
    }
  }
  
  public void a(Setting paramSetting)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramSetting);
  }
  
  public void a(FaceInfo paramFaceInfo)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader = new NearByFaceDownloader(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppNearByFaceDownloader.a(paramFaceInfo);
      return;
    }
    finally {}
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      if ((paramObject instanceof FaceDrawableImpl.FaceObserver)) {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          if (!this.jdField_a_of_type_JavaUtilList.contains(paramObject)) {
            this.jdField_a_of_type_JavaUtilList.add((FaceDrawableImpl.FaceObserver)paramObject);
          }
          return;
        }
      }
      if ((paramObject instanceof FaceDrawableImpl.DisFaceObserver)) {
        synchronized (this.b)
        {
          if (!this.b.contains(paramObject)) {
            this.b.add((FaceDrawableImpl.DisFaceObserver)paramObject);
          }
          return;
        }
      }
    } while (!(paramObject instanceof FaceDrawableImpl.NewTroopFaceObserver));
    synchronized (this.c)
    {
      if (!this.c.contains(paramObject)) {
        this.c.add((FaceDrawableImpl.NewTroopFaceObserver)paramObject);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
      return;
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {
      return;
    }
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap, paramByte);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
      return;
    }
  }
  
  public void a(ArrayList paramArrayList, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramArrayList, paramLong);
  }
  
  public boolean a(FaceInfo paramFaceInfo)
  {
    paramFaceInfo = a(paramFaceInfo);
    if (TextUtils.isEmpty(paramFaceInfo)) {
      return false;
    }
    return new File(paramFaceInfo).exists();
  }
  
  public final void b(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    if ((this.b != null) && (this.b.size() > 0)) {
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext()) {
          a(paramInt, (FaceDrawableImpl.DisFaceObserver)localIterator.next(), paramBoolean, paramVarArgs);
        }
      }
    }
  }
  
  public void b(Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      if ((paramObject instanceof FaceDrawableImpl.FaceObserver)) {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.remove(paramObject);
          return;
        }
      }
      if ((paramObject instanceof FaceDrawableImpl.DisFaceObserver)) {
        synchronized (this.b)
        {
          this.b.remove(paramObject);
          return;
        }
      }
    } while (!(paramObject instanceof FaceDrawableImpl.NewTroopFaceObserver));
    synchronized (this.c)
    {
      this.c.remove(paramObject);
      return;
    }
  }
  
  public final void c(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    if ((this.c != null) && (this.c.size() > 0)) {
      synchronized (this.c)
      {
        Iterator localIterator = this.c.iterator();
        if (localIterator.hasNext()) {
          a(paramInt, (FaceDrawableImpl.NewTroopFaceObserver)localIterator.next(), paramBoolean, paramVarArgs);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajzz);
      this.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajzy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akaa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceManager
 * JD-Core Version:    0.7.0.1
 */