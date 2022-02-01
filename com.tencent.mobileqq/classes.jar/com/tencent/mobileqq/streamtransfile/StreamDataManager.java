package com.tencent.mobileqq.streamtransfile;

import QQService.StreamData;
import QQService.StreamInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class StreamDataManager
{
  public static String a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.size() > 0))
    {
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StreamFileInfo localStreamFileInfo = (StreamFileInfo)localHashMap.get(str);
        if ((localStreamFileInfo.e() == paramInt1) && (localStreamFileInfo.a() == paramInt2)) {
          return str;
        }
      }
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ptt_reserve.ReserveStruct paramReserveStruct)
  {
    Object localObject1 = a(paramStreamInfo.iMsgId, 1);
    long l1 = paramStreamInfo.lFromUIN;
    long l2 = paramStreamInfo.lToUIN;
    if (localObject1 == null)
    {
      localObject1 = TransFileUtil.getTransferFilePath(String.valueOf(l2), null, 2, null);
      int i = Utils.a(paramStreamInfo.pttFormat);
      localObject2 = MessageForPtt.getLocalFilePath(i, (String)localObject1);
      a(paramQQAppInterface, i, (String)localObject2, 1, paramStreamInfo.iMsgId);
      a((String)localObject2, (short)paramStreamInfo.msgSeq);
      b((String)localObject2, paramStreamInfo.random);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onReceiveStreamAction  key is:");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(",msgSeq is:");
        ((StringBuilder)localObject1).append(paramStreamInfo.msgSeq);
        ((StringBuilder)localObject1).append(",random is:");
        ((StringBuilder)localObject1).append(paramStreamInfo.random);
        QLog.d("StreamDataManager", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    Object localObject2 = new Bundle();
    im_msg_body.GeneralFlags localGeneralFlags = new im_msg_body.GeneralFlags();
    try
    {
      localGeneralFlags.mergeFrom(paramReserveStruct.bytes_general_flags.get().toByteArray());
    }
    catch (InvalidProtocolBufferMicroException paramReserveStruct)
    {
      QLog.e("StreamDataManager", 1, "pb merge failed.", paramReserveStruct);
    }
    ((Bundle)localObject2).putInt("DiyTextId", localGeneralFlags.uint32_bubble_diy_text_id.get());
    ((Bundle)localObject2).putInt("DiyPendantId", (int)paramLong4);
    a(paramQQAppInterface, String.valueOf(l1), (String)localObject1, -1000L, paramStreamInfo, paramStreamData, paramLong1, paramLong2, paramLong3, (Bundle)localObject2);
  }
  
  public static void a(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null)
      {
        int i = paramString.b().size();
        paramString.a((short)i);
        if (i >= 1) {
          ((StreamDataInfo)paramString.b().get(paramString.b().size() - 1)).a(true);
        }
      }
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.b = paramLong;
      }
    }
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, long paramLong1, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    a(paramString1, paramQQAppInterface, paramString2, paramLong1, false, paramInt1, paramInt2, paramLong2, paramBundle);
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, long paramLong1, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    Object localObject = StreamMemoryPool.a();
    paramInt1 = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getPttRecordTime(paramInt1);
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString1)))
    {
      localObject = (StreamFileInfo)((HashMap)localObject).get(paramString1);
      ((StreamFileInfo)localObject).a = paramBoolean;
      if (localObject != null)
      {
        if (((StreamFileInfo)localObject).a() == 0)
        {
          localObject = ((StreamFileInfo)localObject).b();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = ((List)localObject).iterator();
            s = -1;
            while (((Iterator)localObject).hasNext())
            {
              StreamDataInfo localStreamDataInfo = (StreamDataInfo)((Iterator)localObject).next();
              if ((localStreamDataInfo.b() == localStreamDataInfo.a().length) && (!localStreamDataInfo.e()))
              {
                s = localStreamDataInfo.c();
                localStreamDataInfo.b(true);
              }
              else if ((!localStreamDataInfo.e()) && (localStreamDataInfo.d()))
              {
                s = localStreamDataInfo.c();
                localStreamDataInfo.b(true);
              }
            }
            break label200;
          }
        }
        short s = -1;
        label200:
        if ((s != -1) && (paramLong1 != 0L)) {
          a(paramQQAppInterface, paramString2, paramString1, paramLong1, s, paramInt1, paramInt2, paramLong2, paramBundle);
        }
      }
    }
  }
  
  public static void a(String paramString, short paramShort)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.c(paramShort);
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramBoolean);
      }
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong2, long paramLong3, long paramLong4, Bundle paramBundle)
  {
    ITransFileController localITransFileController = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    if (!localITransFileController.containsProcessor(localStringBuilder.toString(), paramLong1))
    {
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = new BuddyTransfileProcessor(paramString1, paramString2, false, null, null, 2, -1, false, (TransFileControllerImpl)localITransFileController, paramLong1);
        paramQQAppInterface.setId(paramLong1);
        paramQQAppInterface.getFileMsg().filePath = paramString2;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(paramString2);
        localStringBuilder.append(paramLong1);
        paramString1 = localStringBuilder.toString();
        paramQQAppInterface.setKey(paramString1);
        localITransFileController.addProcessor(paramString1, paramQQAppInterface);
        paramQQAppInterface.startReceiveOneStreamPack(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
        return true;
      }
      return false;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(paramString1);
    paramQQAppInterface.append(paramString2);
    paramQQAppInterface.append(paramLong1);
    paramQQAppInterface = (BuddyTransfileProcessor)localITransFileController.findProcessor(paramQQAppInterface.toString());
    if (paramQQAppInterface != null) {
      paramQQAppInterface.startReceiveOneStreamPack(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, short paramShort, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    ITransFileController localITransFileController = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
    if (!localITransFileController.containsProcessor(paramString1, paramLong1))
    {
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = new BuddyTransfileProcessor(paramString1, paramString2, true, null, null, 2, -1, false, (TransFileControllerImpl)localITransFileController, paramLong1);
        paramQQAppInterface.setId(paramLong1);
        paramQQAppInterface.createStreamThreadPool();
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append(paramLong1);
        paramQQAppInterface.setKey(paramString2.toString());
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append(paramLong1);
        localITransFileController.addProcessor(paramString2.toString(), paramQQAppInterface);
        paramQQAppInterface.startSendOneStreamPack(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
        return true;
      }
      return false;
    }
    paramQQAppInterface = (BuddyTransfileProcessor)localITransFileController.findProcessor(paramString1, paramLong1);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.startSendOneStreamPack(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
    }
    return false;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    return a(paramString, paramArrayOfByte, paramInt, paramShort, false);
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt, short paramShort, boolean paramBoolean)
  {
    Object localObject1 = StreamMemoryPool.a();
    int i = 0;
    if ((localObject1 != null) && (((HashMap)localObject1).containsKey(paramString)))
    {
      StreamFileInfo localStreamFileInfo = (StreamFileInfo)((HashMap)localObject1).get(paramString);
      if (!paramBoolean) {
        try
        {
          localStreamFileInfo.a(paramArrayOfByte, paramInt);
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StreamDataManager", 2, "write fail", paramString);
          }
        }
      }
      Object localObject2;
      if (localStreamFileInfo.a() == 0)
      {
        paramString = localStreamFileInfo.b();
        if (paramString.size() == 0)
        {
          localObject1 = new StreamDataInfo(localStreamFileInfo.d);
          System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject1).a(), 0, paramInt);
          ((StreamDataInfo)localObject1).a(paramInt);
          paramShort = localStreamFileInfo.f();
          s = (short)(paramShort + 1);
          ((StreamDataInfo)localObject1).a(paramShort);
          paramString.add(localObject1);
          localStreamFileInfo.b(s);
          return true;
        }
        localObject1 = (StreamDataInfo)paramString.get(paramString.size() - 1);
        localObject2 = ((StreamDataInfo)localObject1).a();
        if (((StreamDataInfo)localObject1).b() < localObject2.length)
        {
          i = localObject2.length - ((StreamDataInfo)localObject1).b();
          if (i >= paramInt)
          {
            System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject1).a(), ((StreamDataInfo)localObject1).b(), paramInt);
            ((StreamDataInfo)localObject1).a(((StreamDataInfo)localObject1).b() + paramInt);
            return true;
          }
          if (paramInt <= i)
          {
            System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject1).a(), ((StreamDataInfo)localObject1).b(), paramInt);
            ((StreamDataInfo)localObject1).a(((StreamDataInfo)localObject1).b() + paramInt);
            return true;
          }
          System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject1).a(), ((StreamDataInfo)localObject1).b(), i);
          ((StreamDataInfo)localObject1).a(((StreamDataInfo)localObject1).a().length);
          paramInt -= i;
          localObject1 = new StreamDataInfo(localStreamFileInfo.d);
          System.arraycopy(paramArrayOfByte, i, ((StreamDataInfo)localObject1).a(), 0, paramInt);
          ((StreamDataInfo)localObject1).a(paramInt);
          paramShort = localStreamFileInfo.f();
          s = (short)(paramShort + 1);
          ((StreamDataInfo)localObject1).a(paramShort);
          paramString.add(localObject1);
          localStreamFileInfo.b(s);
          return true;
        }
        localObject1 = new StreamDataInfo(localStreamFileInfo.d);
        System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject1).a(), 0, paramInt);
        ((StreamDataInfo)localObject1).a(paramInt);
        paramShort = localStreamFileInfo.f();
        short s = (short)(paramShort + 1);
        ((StreamDataInfo)localObject1).a(paramShort);
        paramString.add(localObject1);
        localStreamFileInfo.b(s);
        return true;
      }
      if (localStreamFileInfo.a() == 1)
      {
        localObject2 = localStreamFileInfo.b();
        paramInt = paramArrayOfByte.length;
        while (paramInt > 0)
        {
          if (((List)localObject2).size() == 0)
          {
            paramString = new StreamDataInfo(localStreamFileInfo.d);
            ((List)localObject2).add(paramString);
          }
          else
          {
            localObject1 = (StreamDataInfo)((List)localObject2).get(((List)localObject2).size() - 1);
            paramString = (String)localObject1;
            if (((StreamDataInfo)localObject1).a().length - ((StreamDataInfo)localObject1).b() <= 0)
            {
              paramString = new StreamDataInfo(localStreamFileInfo.d);
              ((List)localObject2).add(paramString);
            }
          }
          int k = paramString.a().length - paramString.b();
          int j = k;
          if (k >= paramInt) {
            j = paramInt;
          }
          System.arraycopy(paramArrayOfByte, i, paramString.a(), paramString.b(), j);
          i += j;
          paramInt -= j;
          paramString.a(paramString.b() + j);
          paramString.a(paramShort);
        }
        localStreamFileInfo.b((short)(paramShort + 1));
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (!localHashMap.containsKey(paramString)))
    {
      paramAppRuntime = new StreamFileInfo(paramAppRuntime, paramInt1, paramString, paramInt2);
      paramAppRuntime.a(paramInt3);
      try
      {
        localHashMap.put(paramString, paramAppRuntime);
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public static File b(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.c();
      }
    }
    return null;
  }
  
  public static void b(String paramString, long paramLong)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.c = paramLong;
      }
    }
  }
  
  public static byte[] b(String paramString, short paramShort)
  {
    Object localObject = StreamMemoryPool.a();
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString)))
    {
      paramString = (StreamFileInfo)((HashMap)localObject).get(paramString);
      if (paramString != null)
      {
        localObject = (StreamDataInfo)paramString.b().get(paramShort - 1);
        paramString = ((StreamDataInfo)localObject).a();
        paramShort = ((StreamDataInfo)localObject).b();
        if (paramShort != paramString.length)
        {
          localObject = new byte[paramShort];
          System.arraycopy(paramString, 0, localObject, 0, paramShort);
          return localObject;
        }
        return paramString;
      }
    }
    return null;
  }
  
  public static int c(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.b().size();
      }
    }
    return 0;
  }
  
  public static void c(String paramString, long paramLong)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramLong);
      }
    }
  }
  
  public static boolean c(String paramString, short paramShort)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    return (localHashMap == null) || (!localHashMap.containsKey(paramString)) || (((StreamFileInfo)localHashMap.get(paramString)).f() != paramShort);
  }
  
  public static int d(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.e();
      }
    }
    return -1;
  }
  
  public static int d(String paramString, short paramShort)
  {
    Object localObject = StreamMemoryPool.a();
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString)))
    {
      paramString = (StreamFileInfo)((HashMap)localObject).get(paramString);
      if (paramString != null)
      {
        if (paramShort <= paramString.b().size()) {
          return ((StreamDataInfo)paramString.b().get(paramShort - 1)).b();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getRecordedSize error shPackSeq: ");
        ((StringBuilder)localObject).append(paramShort);
        ((StringBuilder)localObject).append("sfi.getStreamData().size(): ");
        ((StringBuilder)localObject).append(paramString.b().size());
        QLog.w("StreamDataManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    return 0;
  }
  
  public static short e(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.g();
      }
    }
    return -1;
  }
  
  public static void f(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.h();
      }
    }
  }
  
  public static short g(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.d();
      }
    }
    return 0;
  }
  
  public static int h(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null)
      {
        int j = paramString.b().size();
        int i = j;
        if (j >= 1)
        {
          paramString = paramString.b();
          int k = j - 1;
          i = j;
          if (!((StreamDataInfo)paramString.get(k)).e()) {
            i = k;
          }
        }
        return i;
      }
    }
    return 0;
  }
  
  public static boolean i(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a;
      }
    }
    return false;
  }
  
  public static short j(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.f();
      }
    }
    return 0;
  }
  
  public static boolean k(String paramString)
  {
    List localList = StreamMemoryPool.b();
    if ((localList != null) && (!localList.contains(paramString)))
    {
      localList.add(paramString);
      return true;
    }
    return false;
  }
  
  public static boolean l(String paramString)
  {
    List localList = StreamMemoryPool.b();
    if ((localList != null) && (localList.contains(paramString)))
    {
      localList.remove(paramString);
      return true;
    }
    return false;
  }
  
  public static boolean m(String paramString)
  {
    List localList = StreamMemoryPool.b();
    return (localList != null) && (localList.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.StreamDataManager
 * JD-Core Version:    0.7.0.1
 */