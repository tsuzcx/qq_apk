package com.tencent.mobileqq.transfile;

import QQService.StreamData;
import QQService.StreamInfo;
import aixa;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class TransFileController
  extends BaseTransFileController
{
  public QQAppInterface a;
  ArrayList a;
  ArrayList b;
  public ConcurrentHashMap b;
  
  public TransFileController(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(TransferRequest paramTransferRequest)
  {
    return a(paramTransferRequest.f, paramTransferRequest.e, paramTransferRequest.b);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1))) {
      return paramString1 + "_" + paramInt;
    }
    return paramString2 + "_" + paramInt;
  }
  
  private void a(TransferRequest paramTransferRequest, BaseTransProcessor paramBaseTransProcessor)
  {
    try
    {
      if (paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult.jdField_a_of_type_Int == -2)
      {
        RichMediaUtil.a(paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Boolean, paramTransferRequest.b, String.valueOf(paramTransferRequest.jdField_a_of_type_Long), "callwait", "");
        paramBaseTransProcessor.wait();
        RichMediaUtil.a(paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Boolean, paramTransferRequest.b, String.valueOf(paramTransferRequest.jdField_a_of_type_Long), "waitfin", "");
      }
      return;
    }
    catch (InterruptedException paramTransferRequest)
    {
      paramTransferRequest.printStackTrace();
    }
  }
  
  private void a(TransferRequest paramTransferRequest, BaseTransProcessor paramBaseTransProcessor, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "sync ";
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
      }
      ??? = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (??? == null) {
        break label418;
      }
      if (!(??? instanceof BaseDownloadProcessor)) {}
    }
    label418:
    do
    {
      do
      {
        long l;
        TransferRequest localTransferRequest;
        do
        {
          synchronized ((BaseDownloadProcessor)???)
          {
            l = ((BaseDownloadProcessor)???).c();
            localTransferRequest = ((BaseDownloadProcessor)???).a();
            RichMediaUtil.a(paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Boolean, paramTransferRequest.b, String.valueOf(paramTransferRequest.jdField_a_of_type_Long), str + "startDownloadProcessor", "status:" + l + ",key:" + paramString);
            if ((l == -1L) || (l == 2002L) || (l == 2001L))
            {
              paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult = localTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
              if (paramTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack != null) {
                ((BaseDownloadProcessor)???).jdField_b_of_type_JavaUtilArrayList.add(paramTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack);
              }
              if (paramBoolean) {
                a(paramTransferRequest, (BaseTransProcessor)???);
              }
            }
            for (;;)
            {
              return;
              str = "aync ";
              break;
              if ((l == 2004L) || (l == 2005L))
              {
                if (paramBaseTransProcessor == null) {
                  continue;
                }
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramBaseTransProcessor);
                paramBaseTransProcessor.c(paramString);
                if (paramBaseTransProcessor.c() != 0) {
                  continue;
                }
                PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTransferRequest);
                paramBaseTransProcessor.ar_();
                if (!paramBoolean) {
                  continue;
                }
                try
                {
                  RichMediaUtil.a(paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Boolean, paramTransferRequest.b, String.valueOf(paramTransferRequest.jdField_a_of_type_Long), "callwait", "");
                  ???.wait();
                }
                catch (InterruptedException paramTransferRequest)
                {
                  paramTransferRequest.printStackTrace();
                }
              }
            }
          }
        } while (l != 2003L);
        paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult = localTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
        if (paramTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack != null)
        {
          paramBaseTransProcessor = new DownCallBack.DownResult();
          paramBaseTransProcessor.jdField_a_of_type_Int = 0;
          paramBaseTransProcessor.b = paramTransferRequest.h;
          paramBaseTransProcessor.jdField_c_of_type_JavaLangString = paramTransferRequest.f;
          paramBaseTransProcessor.jdField_c_of_type_Int = paramTransferRequest.b;
          paramBaseTransProcessor.d = paramTransferRequest.g;
          paramTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(paramBaseTransProcessor);
        }
        return;
        RichMediaUtil.a(paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Boolean, paramTransferRequest.b, String.valueOf(paramTransferRequest.jdField_a_of_type_Long), str + "startDownloadProcessor", "firs time ,key:" + paramString);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramBaseTransProcessor);
        paramBaseTransProcessor.c(paramString);
      } while (paramBaseTransProcessor.c() != 0);
      PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTransferRequest);
      paramBaseTransProcessor.ar_();
    } while (!paramBoolean);
    try
    {
      a(paramTransferRequest, paramBaseTransProcessor);
      return;
    }
    finally {}
  }
  
  private boolean a(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null) {
      if (!(paramIHttpCommunicatorListener instanceof C2CPicUploadProcessor))
      {
        bool1 = bool2;
        if (!(paramIHttpCommunicatorListener instanceof GroupPicUploadProcessor)) {}
      }
      else
      {
        paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
        bool1 = bool2;
        if (paramIHttpCommunicatorListener.c() != 1003L)
        {
          bool1 = bool2;
          if (paramIHttpCommunicatorListener.d() != 1003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null)
    {
      bool1 = bool2;
      if ((paramIHttpCommunicatorListener instanceof StructLongMessageDownloadProcessor))
      {
        bool1 = bool2;
        if (((BaseTransProcessor)paramIHttpCommunicatorListener).c() != 2003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean c(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null) {
      if (!(paramIHttpCommunicatorListener instanceof JSPttUploadProcessor))
      {
        bool1 = bool2;
        if (!(paramIHttpCommunicatorListener instanceof JSPttDownloadProcessor)) {}
      }
      else
      {
        paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
        bool1 = bool2;
        if (paramIHttpCommunicatorListener.c() != 1003L)
        {
          bool1 = bool2;
          if (paramIHttpCommunicatorListener.d() != 2003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)))
    {
      paramString1 = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof BaseTransProcessor)) {
        return ((BaseTransProcessor)paramString1).f();
      }
    }
    return 0;
  }
  
  public BaseTransProcessor a(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest == null) {
      return null;
    }
    if (paramTransferRequest.b == 131078)
    {
      if (paramTransferRequest.jdField_a_of_type_Boolean) {
        return new MultiMsgUpProcessor(this, paramTransferRequest);
      }
      return new MultiMsgDownloadProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.b == 262153)
    {
      if (paramTransferRequest.jdField_a_of_type_Boolean) {
        return new ScribblePicUploadProcessor(this, paramTransferRequest);
      }
      return new ScribblePicDownloadProcessor(this, paramTransferRequest);
    }
    if ((paramTransferRequest.b == 52) && (paramTransferRequest.jdField_a_of_type_Boolean)) {
      return new ForwardSdkShareProcessor(this, paramTransferRequest);
    }
    if (paramTransferRequest.jdField_a_of_type_Int == 1026)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "getProcessor UIN_TYPE_HOTCHAT_TOPIC  isUp = " + paramTransferRequest.jdField_a_of_type_Boolean);
      }
      if (paramTransferRequest.jdField_a_of_type_Boolean) {
        return new GroupPicUploadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.b == 2) {
        return new GroupPttDownloadProcessor(this, paramTransferRequest);
      }
      return null;
    }
    if ((paramTransferRequest.jdField_a_of_type_Int == 1) || (paramTransferRequest.jdField_a_of_type_Int == 3000))
    {
      if (paramTransferRequest.jdField_a_of_type_Boolean)
      {
        if ((paramTransferRequest.b == 6) || (paramTransferRequest.b == 17) || (paramTransferRequest.b == 9)) {
          return new ShortVideoUploadProcessor(this, paramTransferRequest);
        }
        if (paramTransferRequest.b == 20) {
          return new ShortVideoForwardProcessor(this, paramTransferRequest);
        }
        if (paramTransferRequest.b == 55) {
          return new TroopEffectsPicUploadProcessor(this, paramTransferRequest);
        }
        return new GroupPicUploadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.b == 2) {
        return new GroupPttDownloadProcessor(this, paramTransferRequest);
      }
      if ((paramTransferRequest.b == 1) || (paramTransferRequest.b == 65537) || (paramTransferRequest.b == 131075)) {
        return new GroupPicDownloadProcessor(this, paramTransferRequest);
      }
      if ((paramTransferRequest.b == 6) || (paramTransferRequest.b == 7) || (paramTransferRequest.b == 17) || (paramTransferRequest.b == 18) || (paramTransferRequest.b == 9) || (paramTransferRequest.b == 16)) {
        return new ShortVideoDownloadProcessor(this, paramTransferRequest);
      }
    }
    else
    {
      if (paramTransferRequest.jdField_a_of_type_Boolean)
      {
        if (paramTransferRequest.b == 2) {
          return new C2CPttUploadProcessor(this, paramTransferRequest);
        }
        if (paramTransferRequest.b == 32) {
          return new JSPttUploadProcessor(this, paramTransferRequest);
        }
        if ((paramTransferRequest.b == 6) || (paramTransferRequest.b == 17) || (paramTransferRequest.b == 9)) {
          return new ShortVideoUploadProcessor(this, paramTransferRequest);
        }
        if ((paramTransferRequest.b == 8) || (paramTransferRequest.b == 64) || (paramTransferRequest.b == 22) || (paramTransferRequest.b == 21) || (paramTransferRequest.b == 34) || (paramTransferRequest.b == 35) || (paramTransferRequest.b == 36) || (paramTransferRequest.b == 37) || (paramTransferRequest.b == 38) || (paramTransferRequest.b == 48) || (paramTransferRequest.b == 23) || (paramTransferRequest.b == 39) || (paramTransferRequest.b == 40) || (paramTransferRequest.b == 41) || (paramTransferRequest.b == 50) || (paramTransferRequest.b == 51) || (paramTransferRequest.b == 54) || (paramTransferRequest.b == 56)) {
          return new NearbyPeoplePhotoUploadProcessor(this, paramTransferRequest);
        }
        if (paramTransferRequest.b == 20) {
          return new ShortVideoForwardProcessor(this, paramTransferRequest);
        }
        if (paramTransferRequest.b == 24) {
          return new BDHCommonUploadProcessor(this, paramTransferRequest);
        }
        if ((paramTransferRequest.b == 196609) || (paramTransferRequest.b == 196610) || (paramTransferRequest.b == 327681)) {
          return new StoryUploadProcessor(this, paramTransferRequest);
        }
        return new C2CPicUploadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.b == 2) {
        return new C2CPttDownloadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.b == 32) {
        return new JSPttDownloadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.b == 33) {
        return new PAAudioPttDownloadProcessor(this, paramTransferRequest);
      }
      if ((paramTransferRequest.b == 6) || (paramTransferRequest.b == 7) || (paramTransferRequest.b == 17) || (paramTransferRequest.b == 18) || (paramTransferRequest.b == 9) || (paramTransferRequest.b == 16)) {
        return new ShortVideoDownloadProcessor(this, paramTransferRequest);
      }
      if ((paramTransferRequest.b == 1) || (paramTransferRequest.b == 65537) || (paramTransferRequest.b == 131075)) {
        return new C2CPicDownloadProcessor(this, paramTransferRequest);
      }
      if (paramTransferRequest.b == 131079) {
        return new StructLongMessageDownloadProcessor(this, paramTransferRequest);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, paramTransferRequest.toString());
    }
    return null;
  }
  
  public TransferResult a(TransferRequest paramTransferRequest)
  {
    paramTransferRequest.jdField_a_of_type_Boolean = false;
    paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult = new TransferResult();
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (paramTransferRequest.b == 131076)
      {
        localObject = new UrlDownloader(this, paramTransferRequest);
        a(paramTransferRequest, (BaseTransProcessor)localObject, a(paramTransferRequest), true);
      }
    }
    for (;;)
    {
      return paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
      if ((paramTransferRequest.jdField_a_of_type_Int == 1) || (paramTransferRequest.jdField_a_of_type_Int == 3000))
      {
        localObject = new GroupPicDownloadProcessor(this, paramTransferRequest);
        break;
      }
      localObject = new C2CPicDownloadProcessor(this, paramTransferRequest);
      break;
      localObject = paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
      ((TransferResult)localObject).jdField_a_of_type_Int = -1;
      ((TransferResult)localObject).jdField_a_of_type_Long = 9366L;
      ((TransferResult)localObject).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public IHttpCommunicatorListener a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public IHttpCommunicatorListener a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramLong);
  }
  
  public String a(String paramString, long paramLong)
  {
    return paramString + paramLong;
  }
  
  public void a(long paramLong1, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2)
  {
    String str = paramString2 + paramLong1;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = a(paramString2, paramLong1);
      if ((localIHttpCommunicatorListener instanceof ForwardImageProcessor)) {
        ((ForwardImageProcessor)localIHttpCommunicatorListener).a();
      }
    }
    paramString1 = new ForwardImageProcessor(paramLong1, paramString1, paramQQAppInterface, paramInt1, paramString2, paramString3, paramString4, paramString5, paramLong2, paramInt2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ptt_reserve.ReserveStruct paramReserveStruct)
  {
    Object localObject2 = StreamDataManager.a(paramStreamInfo.iMsgId, 1);
    long l1 = paramStreamInfo.lFromUIN;
    long l2 = paramStreamInfo.lToUIN;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = BuddyTransfileProcessor.a(String.valueOf(l2), null, 2, null);
      int i = Utils.a(paramStreamInfo.pttFormat);
      localObject2 = MessageForPtt.getLocalFilePath(i, (String)localObject1);
      StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject2, 1, paramStreamInfo.iMsgId);
      StreamDataManager.a((String)localObject2, (short)paramStreamInfo.msgSeq);
      StreamDataManager.b((String)localObject2, paramStreamInfo.random);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.TransFileController", 2, "onReceiveStreamAction  key is:" + (String)localObject2 + ",msgSeq is:" + paramStreamInfo.msgSeq + ",random is:" + paramStreamInfo.random);
        localObject1 = localObject2;
      }
    }
    localObject2 = new Bundle();
    im_msg_body.GeneralFlags localGeneralFlags = new im_msg_body.GeneralFlags();
    try
    {
      localGeneralFlags.mergeFrom(paramReserveStruct.bytes_general_flags.get().toByteArray());
      ((Bundle)localObject2).putInt("DiyTextId", localGeneralFlags.uint32_bubble_diy_text_id.get());
      ((Bundle)localObject2).putInt("DiyPendantId", (int)paramLong4);
      a(String.valueOf(l1), (String)localObject1, -1000L, paramStreamInfo, paramStreamData, paramLong1, paramLong2, paramLong3, (Bundle)localObject2);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramReserveStruct)
    {
      for (;;)
      {
        QLog.e("Q.richmedia.TransFileController", 1, "pb merge failed.", paramReserveStruct);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    ThreadManager.postImmediately(new aixa(this, paramString, paramIntent, paramQQAppInterface), null, true);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (a((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).a.jdField_c_of_type_JavaLangString)) && (((BaseTransProcessor)localObject).k))
          {
            ((BaseTransProcessor)localObject).b();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "resume pic:" + ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Iterator localIterator = a(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        if (((localIHttpCommunicatorListener instanceof BuddyTransfileProcessor)) && (paramString.equals(((BuddyTransfileProcessor)localIHttpCommunicatorListener).a.p)))
        {
          ((BaseTransProcessor)localIHttpCommunicatorListener).h();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
        break;
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (a((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long))
          {
            ((BaseTransProcessor)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, TransFileController.OnCancelListener paramOnCancelListener)
  {
    if (paramString == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (a((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).a.jdField_c_of_type_JavaLangString)) && (((BaseTransProcessor)localObject).b()))
          {
            ((BaseTransProcessor)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long);
            }
            if (((BaseTransProcessor)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              localArrayList.add(((BaseTransProcessor)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          }
        }
      }
    } while (paramOnCancelListener == null);
    paramOnCancelListener.a(localArrayList);
  }
  
  public void a(String paramString, IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramIHttpCommunicatorListener);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseTransProcessor))) {
        break label171;
      }
      localObject = (BaseTransProcessor)localObject;
      if ((!((BaseTransProcessor)localObject).m) || (((BaseTransProcessor)localObject).k)) {
        break label171;
      }
      ((BaseTransProcessor)localObject).c();
      if (((BaseTransProcessor)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((BaseTransProcessor)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend key:" + ((BaseTransProcessor)localObject).a());
      }
      bool = true;
    }
    label171:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseUploadProcessor))) {
        break label175;
      }
      localObject = (BaseUploadProcessor)localObject;
      if ((((BaseUploadProcessor)localObject).a == null) || (!((BaseUploadProcessor)localObject).a.i)) {
        break label175;
      }
      ((BaseUploadProcessor)localObject).u = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicReport", 2, "initAllPSProcessorEnterAioTime ,Processor:" + localObject + ",time = " + paramLong);
      }
      bool = true;
    }
    label175:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicReport", 2, "initAllPSProcessorEnterAioTime result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean a(TransferRequest paramTransferRequest)
  {
    try
    {
      boolean bool = super.a(paramTransferRequest);
      return bool;
    }
    finally
    {
      paramTransferRequest = finally;
      throw paramTransferRequest;
    }
  }
  
  /* Error */
  public boolean a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 40	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: lload_2
    //   14: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 145	com/tencent/mobileqq/transfile/TransFileController:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 259	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +31 -> 60
    //   32: aload_0
    //   33: getfield 145	com/tencent/mobileqq/transfile/TransFileController:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: aload_1
    //   37: invokevirtual 149	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 313	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 612	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:c	()V
    //   52: iconst_1
    //   53: istore 4
    //   55: aload_0
    //   56: monitorexit
    //   57: iload 4
    //   59: ireturn
    //   60: iconst_0
    //   61: istore 4
    //   63: goto -8 -> 55
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	TransFileController
    //   0	71	1	paramString	String
    //   0	71	2	paramLong	long
    //   53	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	44	66	finally
    //   48	52	66	finally
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return b(paramString1 + paramString2);
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      paramString2 = (BuddyTransfileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.h();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong1, StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong2, long paramLong3, long paramLong4, Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1 + paramString2 + paramLong1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        BuddyTransfileProcessor localBuddyTransfileProcessor = new BuddyTransfileProcessor(paramString1, paramString2, false, null, null, 2, -1, false, this, paramLong1);
        localBuddyTransfileProcessor.a(paramLong1);
        localBuddyTransfileProcessor.a().jdField_c_of_type_JavaLangString = paramString2;
        localBuddyTransfileProcessor.c(paramString1 + paramString2 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramString2 + paramLong1, localBuddyTransfileProcessor);
        localBuddyTransfileProcessor.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (BuddyTransfileProcessor)a(paramString1 + paramString2 + paramLong1);
    if (paramString1 != null) {
      paramString1.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong1, short paramShort, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1 + paramLong1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramString2 = new BuddyTransfileProcessor(paramString1, paramString2, true, null, null, 2, -1, false, this, paramLong1);
        paramString2.a(paramLong1);
        paramString2.f();
        paramString2.c(paramString1 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramLong1, paramString2);
        paramString2.a(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (BuddyTransfileProcessor)a(paramString1, paramString2, paramLong1);
    if (paramString1 != null) {
      paramString1.a(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
    }
    return false;
  }
  
  public int b(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)))
    {
      paramString1 = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof BaseTransProcessor)) {
        return (int)((BaseTransProcessor)paramString1).c();
      }
    }
    return -1;
  }
  
  public TransferResult b(TransferRequest paramTransferRequest)
  {
    paramTransferRequest.jdField_a_of_type_Boolean = false;
    paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult = new TransferResult();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        Object localObject1;
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
        {
          localObject1 = paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
          ((TransferResult)localObject1).jdField_a_of_type_Int = -1;
          ((TransferResult)localObject1).jdField_a_of_type_Long = 9366L;
          ((TransferResult)localObject1).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          paramTransferRequest = paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
          return paramTransferRequest;
        }
        try
        {
          if (paramTransferRequest.b == 131076)
          {
            localObject1 = new UrlDownloader(this, paramTransferRequest);
            a(paramTransferRequest, (BaseTransProcessor)localObject1, a(paramTransferRequest), false);
            return paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
          }
          if ((paramTransferRequest.jdField_a_of_type_Int == 1) || (paramTransferRequest.jdField_a_of_type_Int == 3000))
          {
            localObject1 = new GroupPicDownloadProcessor(this, paramTransferRequest);
            continue;
            paramTransferRequest = finally;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          localObject2 = paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
          ((TransferResult)localObject2).jdField_a_of_type_Int = -1;
          ((TransferResult)localObject2).jdField_a_of_type_Long = 9366L;
          ((TransferResult)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          paramTransferRequest = paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
          return paramTransferRequest;
        }
      }
      Object localObject2 = new C2CPicDownloadProcessor(this, paramTransferRequest);
      continue;
      localObject2 = paramTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
      ((TransferResult)localObject2).jdField_a_of_type_Int = -1;
      ((TransferResult)localObject2).jdField_a_of_type_Long = 9366L;
      ((TransferResult)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public void b() {}
  
  public void b(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (c((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long))
          {
            ((BaseTransProcessor)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel JSPTT:" + ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseTransProcessor))) {
        break label211;
      }
      localObject = (BaseTransProcessor)localObject;
      if ((!((BaseTransProcessor)localObject).n) || (((BaseTransProcessor)localObject).k)) {
        break label211;
      }
      ((BaseTransProcessor)localObject).c();
      if (((BaseTransProcessor)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((BaseTransProcessor)localObject).a());
      }
      localStringBuilder.append(((BaseTransProcessor)localObject).a());
      localStringBuilder.append(",");
      bool = true;
    }
    label211:
    for (;;)
    {
      break;
      if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
        QLog.d("short_video", 2, "pauseAllShortVideoReceive key:" + localStringBuilder);
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoReceive result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean b(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && ((paramString instanceof BaseTransProcessor)))
    {
      paramString = (BaseTransProcessor)paramString;
      if ((paramString.l) && (paramString.k))
      {
        paramString.b();
        if (QLog.isColorLevel()) {
          QLog.d("raw_photo", 2, "resumeRawSend ,key:" + paramString.a());
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean b(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        paramString = paramString + paramLong;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
        {
          paramString = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (paramString != null)
          {
            if ((paramString instanceof ShortVideoUploadProcessor)) {
              ((ShortVideoUploadProcessor)paramString).c();
            }
          }
          else
          {
            bool = true;
            return bool;
          }
          if (!(paramString instanceof ShortVideoForwardProcessor)) {
            continue;
          }
          ((ShortVideoForwardProcessor)paramString).c();
          continue;
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  public boolean b(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramString2 + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      paramString2 = (BuddyTransfileProcessor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.h();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    long l;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      l = System.currentTimeMillis();
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().b();
      a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.TransFileController", 2, "destroy transfilecontroller:" + this + " elapsed:" + (System.currentTimeMillis() - l));
      }
      return;
    }
  }
  
  public void c(String paramString, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if (b((IHttpCommunicatorListener)localObject))
      {
        ThreadManager.getSubThreadHandler().removeCallbacks((StructLongMessageDownloadProcessor)localObject);
        localObject = (BaseTransProcessor)localObject;
        if ((paramString.equals(((BaseTransProcessor)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long))
        {
          ((BaseTransProcessor)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("cancelpic", 2, "cancel PALongMsg:" + ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long);
          }
        }
      }
    }
  }
  
  public boolean c()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseTransProcessor))) {
        break label178;
      }
      localObject = (BaseTransProcessor)localObject;
      if ((!((BaseTransProcessor)localObject).l) || (((BaseTransProcessor)localObject).k)) {
        break label178;
      }
      ((BaseTransProcessor)localObject).c();
      if (((BaseTransProcessor)localObject).a() != null) {
        this.jdField_b_of_type_JavaUtilArrayList.add(((BaseTransProcessor)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend key:" + ((BaseTransProcessor)localObject).a());
      }
      bool = true;
    }
    label178:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool1;
    for (boolean bool2 = false; localIterator.hasNext(); bool2 = bool1)
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      bool1 = bool2;
      if (a((IHttpCommunicatorListener)localObject))
      {
        localObject = (BaseTransProcessor)localObject;
        bool1 = bool2;
        if (paramString.equals(((BaseTransProcessor)localObject).a.jdField_c_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (!((BaseTransProcessor)localObject).k)
          {
            ((BaseTransProcessor)localObject).c();
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("cancelpic", 2, "pause pic:" + ((BaseTransProcessor)localObject).a.jdField_a_of_type_Long);
              bool1 = bool2;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean c(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        paramString = paramString + paramLong;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
        {
          IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (localIHttpCommunicatorListener != null)
          {
            if ((localIHttpCommunicatorListener instanceof ShortVideoUploadProcessor)) {
              ((ShortVideoUploadProcessor)localIHttpCommunicatorListener).c();
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
            bool = true;
            return bool;
          }
          if (!(localIHttpCommunicatorListener instanceof ShortVideoForwardProcessor)) {
            continue;
          }
          ((ShortVideoForwardProcessor)localIHttpCommunicatorListener).c();
          continue;
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend keys size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = a((String)localIterator.next());
      if ((localObject != null) && ((localObject instanceof BaseTransProcessor)))
      {
        localObject = (BaseTransProcessor)localObject;
        if (((BaseTransProcessor)localObject).k)
        {
          ((BaseTransProcessor)localObject).b();
          localStringBuilder.append(((BaseTransProcessor)localObject).a());
          localStringBuilder.append(",");
        }
      }
    }
    if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend , key: " + localStringBuilder);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public boolean d(String paramString)
  {
    if (paramString == null) {}
    label90:
    label91:
    for (;;)
    {
      return false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if ((!a(localIHttpCommunicatorListener)) || (!paramString.equals(((BaseTransProcessor)localIHttpCommunicatorListener).a.jdField_c_of_type_JavaLangString))) {
          break label90;
        }
        i += 1;
      }
      for (;;)
      {
        break;
        if (i <= 1) {
          break label91;
        }
        return true;
      }
    }
  }
  
  public boolean d(String paramString, long paramLong)
  {
    paramString = paramString + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localIHttpCommunicatorListener instanceof ShortVideoDownloadProcessor))
      {
        ((ShortVideoDownloadProcessor)localIHttpCommunicatorListener).c();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return true;
      }
    }
    return false;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "resumeLastRawSend keys size:" + this.jdField_b_of_type_JavaUtilArrayList.size());
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      b((String)localIterator.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransFileController
 * JD-Core Version:    0.7.0.1
 */