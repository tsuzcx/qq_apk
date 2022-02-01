package com.tencent.mobileqq.streamtransfile.impl;

import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.streamtransfile.IStreamDataManager;
import com.tencent.mobileqq.streamtransfile.StreamFileInfo;
import com.tencent.mobileqq.streamtransfile.StreamMemoryPool;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class StreamDataManagerImpl
  implements IStreamDataManager
{
  public static final String TAG = "StreamDataManagerImpl";
  
  public Map.Entry<String, StreamFileInfo> getStreamFileInfoEntryByMsg(long paramLong1, long paramLong2)
  {
    Object localObject1 = StreamMemoryPool.a();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getStreamFileInfoEntryByMsg  try get random is:");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append(",msgSeq is:");
      ((StringBuilder)localObject2).append(paramLong2);
      QLog.d("StreamDataManagerImpl", 2, ((StringBuilder)localObject2).toString());
    }
    if ((localObject1 != null) && (((HashMap)localObject1).size() > 0))
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        StreamFileInfo localStreamFileInfo = (StreamFileInfo)((Map.Entry)localObject2).getValue();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getStreamFileInfoEntryByMsg  random is:");
          localStringBuilder.append(MessageUtils.a((int)localStreamFileInfo.b));
          localStringBuilder.append(",msgSeq is:");
          localStringBuilder.append(localStreamFileInfo.a);
          QLog.d("StreamDataManagerImpl", 2, localStringBuilder.toString());
        }
        if ((MessageUtils.a((int)localStreamFileInfo.b) == paramLong1) && (paramLong2 == localStreamFileInfo.a)) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  public boolean removeStreamTaskToMemoryPool(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString))) {
      try
      {
        localHashMap.remove(paramString);
        return true;
      }
      finally {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.impl.StreamDataManagerImpl
 * JD-Core Version:    0.7.0.1
 */