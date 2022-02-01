package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import android.widget.ListAdapter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;

public class AIOSingleReporter
{
  private static AIOSingleReporter a = new AIOSingleReporter();
  private HashMap<String, HashSet<Long>> b;
  private HashSet<Object> c;
  private HashMap<Object, MessageForShortVideo> d;
  private HashSet<Object> e;
  
  public static AIOSingleReporter a()
  {
    return a;
  }
  
  public void a(ChatXListView paramChatXListView)
  {
    HashSet localHashSet = this.c;
    if (localHashSet != null)
    {
      if (localHashSet.size() == 0) {
        return;
      }
      long l1 = SystemClock.uptimeMillis();
      localHashSet = new HashSet();
      int i = paramChatXListView.getFirstVisiblePosition();
      int k = paramChatXListView.getLastVisiblePosition();
      int j = paramChatXListView.getHeaderViewsCount();
      if (i <= j) {
        i = j;
      }
      while ((i >= j) && (i <= k))
      {
        try
        {
          ChatMessage localChatMessage = (ChatMessage)paramChatXListView.getAdapter().getItem(i);
          if ((localChatMessage != null) && ((localChatMessage instanceof MessageForShortVideo)))
          {
            long l2 = localChatMessage.uniseq;
            if (this.c.contains(Long.valueOf(l2))) {
              localHashSet.add(Long.valueOf(l2));
            }
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          localIndexOutOfBoundsException.printStackTrace();
        }
        i += 1;
      }
      this.c = localHashSet;
      paramChatXListView = new StringBuilder();
      paramChatXListView.append("markVisibleView cost time: ");
      paramChatXListView.append(SystemClock.uptimeMillis() - l1);
      QLog.d("ShortVideoUtils", 2, paramChatXListView.toString());
    }
  }
  
  public void a(Object paramObject, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramObject != null) && (paramMessageForShortVideo != null))
    {
      if (this.d == null) {
        this.d = new HashMap();
      }
      this.d.put(paramObject, paramMessageForShortVideo);
    }
  }
  
  public void a(Object paramObject, boolean paramBoolean)
  {
    if (paramObject == null) {
      return;
    }
    if (this.c == null) {
      this.c = new HashSet();
    }
    if (paramBoolean)
    {
      this.c.add(paramObject);
      return;
    }
    this.c.remove(paramObject);
  }
  
  public boolean a(long paramLong, String paramString)
  {
    HashMap localHashMap = this.b;
    if (localHashMap != null)
    {
      paramString = (HashSet)localHashMap.get(paramString);
      if (paramString != null)
      {
        bool = paramString.contains(Long.valueOf(paramLong));
        break label41;
      }
    }
    boolean bool = false;
    label41:
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("hasReported(): uniseq=");
      paramString.append(paramLong);
      paramString.append(" result = ");
      paramString.append(bool);
      QLog.d("AIOSingleReporter", 2, paramString.toString());
    }
    return bool;
  }
  
  public boolean a(MessageRecord paramMessageRecord, String paramString)
  {
    HashMap localHashMap = this.b;
    if (localHashMap != null)
    {
      paramString = (HashSet)localHashMap.get(paramString);
      if (paramString != null)
      {
        bool = paramString.contains(Long.valueOf(paramMessageRecord.uniseq));
        break label42;
      }
    }
    boolean bool = false;
    label42:
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("hasReported(): mr.uniseq=");
      paramString.append(paramMessageRecord.uniseq);
      paramString.append(" result = ");
      paramString.append(bool);
      QLog.d("AIOSingleReporter", 2, paramString.toString());
    }
    return bool;
  }
  
  public boolean a(Object paramObject)
  {
    HashSet localHashSet = this.c;
    if (localHashSet != null) {
      return localHashSet.contains(paramObject);
    }
    return false;
  }
  
  public MessageForShortVideo b(Object paramObject)
  {
    if (paramObject != null)
    {
      HashMap localHashMap = this.d;
      if (localHashMap != null) {
        return (MessageForShortVideo)localHashMap.get(paramObject);
      }
    }
    return null;
  }
  
  public void b()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.b = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((HashSet)localObject).clear();
      this.c = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((HashSet)localObject).clear();
      this.e = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.d = null;
    }
  }
  
  public void b(long paramLong, String paramString)
  {
    if (paramLong == 0L) {
      return;
    }
    if (this.b == null) {
      this.b = new HashMap();
    }
    HashSet localHashSet2 = (HashSet)this.b.get(paramString);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      this.b.put(paramString, localHashSet1);
    }
    localHashSet1.add(Long.valueOf(paramLong));
  }
  
  public void b(MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (this.b == null) {
      this.b = new HashMap();
    }
    HashSet localHashSet2 = (HashSet)this.b.get(paramString);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      this.b.put(paramString, localHashSet1);
    }
    localHashSet1.add(Long.valueOf(paramMessageRecord.uniseq));
  }
  
  public boolean c(Object paramObject)
  {
    HashSet localHashSet = this.e;
    if (localHashSet != null) {
      return localHashSet.contains(paramObject);
    }
    return false;
  }
  
  public void d(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if (this.e == null) {
      this.e = new HashSet();
    }
    this.e.add(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AIOSingleReporter
 * JD-Core Version:    0.7.0.1
 */