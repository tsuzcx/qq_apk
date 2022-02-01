package com.tencent.mobileqq.guild.audio.data;

import com.tencent.mobileqq.guild.audio.ITRTCAudioRoom.TRTCVolumeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TRTCUserInfoList
{
  private volatile List<TRTCUserInfo> a = Collections.synchronizedList(new ArrayList());
  
  public final List<TRTCUserInfo> a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((TRTCUserInfo)((Iterator)localObject).next()).a.equals(paramString)) {
        return;
      }
    }
    localObject = new TRTCUserInfo();
    ((TRTCUserInfo)localObject).a = paramString;
    this.a.add(localObject);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      TRTCUserInfo localTRTCUserInfo = (TRTCUserInfo)localIterator.next();
      if (localTRTCUserInfo.a.equals(paramString)) {
        localTRTCUserInfo.b = paramBoolean;
      }
    }
  }
  
  public void a(ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        return;
      }
      ITRTCAudioRoom.TRTCVolumeInfo localTRTCVolumeInfo = (ITRTCAudioRoom.TRTCVolumeInfo)paramArrayList.next();
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext())
      {
        TRTCUserInfo localTRTCUserInfo = (TRTCUserInfo)localIterator.next();
        if (!localTRTCVolumeInfo.a.equals(localTRTCUserInfo.a)) {
          break;
        }
        localTRTCUserInfo.c = localTRTCVolumeInfo.b;
      }
    }
  }
  
  public void b()
  {
    this.a.clear();
  }
  
  public void b(String paramString)
  {
    int i = 0;
    while (i < this.a.size())
    {
      if (((TRTCUserInfo)this.a.get(i)).a.equals(paramString))
      {
        this.a.remove(i);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.data.TRTCUserInfoList
 * JD-Core Version:    0.7.0.1
 */