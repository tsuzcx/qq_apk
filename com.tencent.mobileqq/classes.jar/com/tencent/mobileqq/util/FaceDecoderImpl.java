package com.tencent.mobileqq.util;

import akhd;
import akhe;
import akhf;
import akhg;
import akhh;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.GroupIconHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class FaceDecoderImpl
  extends FaceDecoderBase
  implements FaceDecodeTask.DecodeCompletionListener
{
  private akhf jdField_a_of_type_Akhf;
  private akhg jdField_a_of_type_Akhg;
  private akhh jdField_a_of_type_Akhh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public FaceDecoderImpl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "getBitmapFromCache, mApp is null");
      }
      return null;
    }
    if ((paramInt1 == 1001) && (paramString != null) && (!GroupIconHelper.a(paramString))) {}
    for (Object localObject1 = GroupIconHelper.a(paramString);; localObject1 = paramString)
    {
      if ((paramInt1 == 4) && (!TroopUtils.a(paramString))) {
        paramInt1 = 113;
      }
      for (;;)
      {
        if (paramInt1 == 113) {
          paramByte = 1;
        }
        for (;;)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, (String)localObject1, paramByte, paramInt2, 100, true);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject1);
          Object localObject2;
          if ((localObject1 != null) && (paramInt1 == 1001))
          {
            localObject2 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
            if ((localObject2 != null) && (((DiscussionHandler)localObject2).a() != null)) {
              ((DiscussionHandler)localObject2).a().f(paramString);
            }
            if (this.jdField_a_of_type_Akhf == null)
            {
              this.jdField_a_of_type_Akhf = new akhf(this, null);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akhf);
            }
          }
          do
          {
            do
            {
              return localObject1;
            } while ((localObject1 == null) || (!QQAppInterface.a(paramInt1, paramInt2)));
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, false);
          } while (((localObject2 != null) && (((ExtensionInfo)localObject2).faceIdUpdateTime != 0L)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.TRUE);
          if (paramInt1 == 1) {}
          for (byte b = 0;; b = 1)
          {
            new akhe(this, new FaceInfo(paramInt1, paramString, true, b, paramByte, false, paramInt2)).b();
            break;
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 == 32) && (paramInt2 != 200) && (paramInt2 != 202) && (paramInt2 != 204));
      if (paramInt1 == 32) {}
      for (byte b = 1;; b = 0)
      {
        FaceInfo localFaceInfo = new FaceInfo(paramInt1, paramString, false, b, 3, false, paramInt2);
        String str = FaceInfo.a(paramInt1, paramString, paramInt2);
        if (this.jdField_b_of_type_JavaUtilHashtable.get(str) == null) {
          this.jdField_b_of_type_JavaUtilHashtable.put(str, localFaceInfo);
        }
        if (this.jdField_a_of_type_Akhg == null)
        {
          this.jdField_a_of_type_Akhg = new akhg(this, null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akhg);
        }
        if (paramInt1 != 32) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, paramInt2, paramLong);
        return;
      }
    } while (paramInt1 != 16);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString, paramInt2, paramLong);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramAppInterface)
    {
      d();
      if ((paramAppInterface instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDecoderImpl", 2, "onDecodeTaskCompletedNeedDownload, faceInfo=" + paramFaceInfo.toString());
      }
      this.jdField_b_of_type_Int -= 1;
      paramAppInterface = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(paramFaceInfo.b());
      if (paramAppInterface != null)
      {
        if (this.jdField_a_of_type_Akhg == null)
        {
          this.jdField_a_of_type_Akhg = new akhg(this, null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akhg);
        }
        FaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAppInterface);
      }
    } while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) || (this.jdField_b_of_type_Int >= this.jdField_a_of_type_Int));
    e();
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, "onDecodeTaskCompleted, faceInfo=" + paramFaceInfo.toString());
    }
    this.jdField_b_of_type_Int -= 1;
    if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (!this.jdField_a_of_type_Boolean)) {
      e();
    }
    FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.remove(paramFaceInfo.b());
    int j;
    if (localFaceInfo != null)
    {
      j = FaceInfo.r;
      if (paramBitmap == null) {
        break label161;
      }
    }
    label161:
    for (int i = FaceInfo.f;; i = FaceInfo.g)
    {
      localFaceInfo.a(j, i);
      if ((this.jdField_a_of_type_Akhd == null) || (paramBitmap == null)) {
        break;
      }
      this.jdField_a_of_type_Akhd.onDecodeTaskCompleted(this.jdField_b_of_type_Int + this.jdField_a_of_type_JavaUtilLinkedList.size(), paramFaceInfo.jdField_a_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString, paramBitmap);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    label184:
    do
    {
      Object localObject;
      do
      {
        Bitmap localBitmap;
        do
        {
          return;
          localObject = FaceInfo.a(paramInt1, paramString, paramInt2);
          byte b = 3;
          if (paramInt1 == 101) {
            b = 1;
          }
          if ((!paramBoolean) || (this.jdField_a_of_type_Boolean)) {
            break label184;
          }
          localBitmap = a(paramInt1, paramString, paramInt2, b);
          if (localBitmap == null) {
            break;
          }
          localObject = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.remove(localObject);
          if (localObject != null) {
            ((FaceInfo)localObject).a(FaceInfo.r, FaceInfo.f);
          }
        } while (this.jdField_a_of_type_Akhd == null);
        this.jdField_a_of_type_Akhd.onDecodeTaskCompleted(this.jdField_b_of_type_Int + this.jdField_a_of_type_JavaUtilLinkedList.size(), paramInt1, paramString, localBitmap);
        return;
        paramString = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(localObject);
        if (paramString != null)
        {
          a(paramString);
          return;
        }
        paramString = (FaceInfo)this.jdField_b_of_type_JavaUtilHashtable.remove(localObject);
      } while (paramString == null);
      paramString.a(FaceInfo.j);
      this.jdField_a_of_type_JavaUtilHashtable.put(localObject, paramString);
      a(paramString);
      return;
      paramString = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.remove(localObject);
    } while (paramString == null);
    paramInt2 = FaceInfo.r;
    if (!paramBoolean) {}
    for (paramInt1 = FaceInfo.g;; paramInt1 = FaceInfo.h)
    {
      paramString.a(paramInt2, paramInt1);
      return;
    }
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean3)
  {
    if ((paramString == null) || (paramString.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "requestDecodeFace fail. type=" + paramInt2 + ", uin=" + paramString);
      }
      return false;
    }
    paramInt4 = 3;
    if (paramInt3 == 0) {
      if (paramInt2 != 101)
      {
        paramInt3 = paramInt4;
        if (paramInt2 != 1001) {
          break label87;
        }
      }
    }
    label87:
    String str;
    for (paramInt3 = 1;; paramInt3 = (byte)paramInt3)
    {
      str = FaceInfo.a(paramInt2, paramString, paramInt1);
      FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(str);
      if ((localFaceInfo == null) || (localFaceInfo.a(FaceInfo.j, 300000L))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "requestDecodeFace, uin repeat. uin=" + paramString);
      }
      if ((localFaceInfo.b) && (!paramBoolean2)) {
        localFaceInfo.b = false;
      }
      return true;
    }
    paramString = new FaceInfo(paramInt2, paramString, paramBoolean2, paramByte, paramInt3, false, paramInt1, paramBoolean3, 100);
    paramString.a(FaceInfo.j);
    this.jdField_a_of_type_JavaUtilHashtable.put(str, paramString);
    a(paramString);
    return true;
  }
  
  public void d()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    akhf localakhf = this.jdField_a_of_type_Akhf;
    akhg localakhg = this.jdField_a_of_type_Akhg;
    akhh localakhh = this.jdField_a_of_type_Akhh;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Akhf = null;
    this.jdField_a_of_type_Akhh = null;
    this.jdField_a_of_type_Akhg = null;
    if (localQQAppInterface != null)
    {
      if (localakhf != null) {
        localQQAppInterface.removeObserver(localakhf);
      }
      if (localakhg != null) {
        localQQAppInterface.removeObserver(localakhg);
      }
      if (localakhh != null) {
        localQQAppInterface.removeObserver(localakhh);
      }
    }
    super.d();
  }
  
  public void e()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, " runNextTask, mReadyRequests is empty");
    }
    label204:
    do
    {
      return;
      try
      {
        localObject2 = (FaceInfo)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.FaceDecoderImpl", 2, " runNextTask, faceinfo=" + ((FaceInfo)localObject2).toString());
          }
          if (((((FaceInfo)localObject2).jdField_a_of_type_Int == 101) || (((FaceInfo)localObject2).jdField_a_of_type_Int == 1001)) && (this.jdField_a_of_type_Akhf == null))
          {
            this.jdField_a_of_type_Akhf = new akhf(this, null);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akhf);
          }
          if (((((FaceInfo)localObject2).jdField_a_of_type_Int == 4) || (((FaceInfo)localObject2).jdField_a_of_type_Int == 113)) && (!TroopUtils.a(((FaceInfo)localObject2).jdField_a_of_type_JavaLangString)))
          {
            if (this.jdField_a_of_type_Akhh == null) {
              this.jdField_a_of_type_Akhh = new akhh(this, null);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akhh);
          }
          this.jdField_b_of_type_Int += 1;
          FaceDecodeTask.a(FaceDecodeTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FaceInfo)localObject2, this));
          return;
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localObject2;
          localObject2 = localThrowable2;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject2;
        break label204;
      }
      if (localObject1 != null) {
        this.jdField_b_of_type_Int -= 1;
      }
    } while (!QLog.isColorLevel());
    NearbyUtils.a("Q.qqhead.FaceDecoderImpl", new Object[] { "runNextTask", localObject2, localObject1 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDecoderImpl
 * JD-Core Version:    0.7.0.1
 */