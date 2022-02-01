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
  private static AIOSingleReporter jdField_a_of_type_ComTencentMobileqqUtilsAIOSingleReporter = new AIOSingleReporter();
  private HashMap<String, HashSet<Long>> jdField_a_of_type_JavaUtilHashMap;
  private HashSet<Object> jdField_a_of_type_JavaUtilHashSet;
  private HashMap<Object, MessageForShortVideo> jdField_b_of_type_JavaUtilHashMap;
  private HashSet<Object> jdField_b_of_type_JavaUtilHashSet;
  
  public static AIOSingleReporter a()
  {
    return jdField_a_of_type_ComTencentMobileqqUtilsAIOSingleReporter;
  }
  
  public MessageForShortVideo a(Object paramObject)
  {
    if (paramObject != null)
    {
      HashMap localHashMap = this.jdField_b_of_type_JavaUtilHashMap;
      if (localHashMap != null) {
        return (MessageForShortVideo)localHashMap.get(paramObject);
      }
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilHashSet;
    if (localObject != null)
    {
      ((HashSet)localObject).clear();
      this.jdField_a_of_type_JavaUtilHashSet = null;
    }
    localObject = this.jdField_b_of_type_JavaUtilHashSet;
    if (localObject != null)
    {
      ((HashSet)localObject).clear();
      this.jdField_b_of_type_JavaUtilHashSet = null;
    }
    localObject = this.jdField_b_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.jdField_b_of_type_JavaUtilHashMap = null;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (paramLong == 0L) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    HashSet localHashSet2 = (HashSet)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localHashSet1);
    }
    localHashSet1.add(Long.valueOf(paramLong));
  }
  
  public void a(ChatXListView paramChatXListView)
  {
    HashSet localHashSet = this.jdField_a_of_type_JavaUtilHashSet;
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
            if (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(l2))) {
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
      this.jdField_a_of_type_JavaUtilHashSet = localHashSet;
      paramChatXListView = new StringBuilder();
      paramChatXListView.append("markVisibleView cost time: ");
      paramChatXListView.append(SystemClock.uptimeMillis() - l1);
      QLog.d("ShortVideoUtils", 2, paramChatXListView.toString());
    }
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    HashSet localHashSet2 = (HashSet)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localHashSet1);
    }
    localHashSet1.add(Long.valueOf(paramMessageRecord.uniseq));
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilHashSet == null) {
      this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    }
    this.jdField_b_of_type_JavaUtilHashSet.add(paramObject);
  }
  
  public void a(Object paramObject, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramObject != null) && (paramMessageForShortVideo != null))
    {
      if (this.jdField_b_of_type_JavaUtilHashMap == null) {
        this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(paramObject, paramMessageForShortVideo);
    }
  }
  
  public void a(Object paramObject, boolean paramBoolean)
  {
    if (paramObject == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashSet == null) {
      this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramObject);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashSet.remove(paramObject);
  }
  
  public boolean a(long paramLong, String paramString)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
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
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
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
    HashSet localHashSet = this.jdField_a_of_type_JavaUtilHashSet;
    if (localHashSet != null) {
      return localHashSet.contains(paramObject);
    }
    return false;
  }
  
  public boolean b(Object paramObject)
  {
    HashSet localHashSet = this.jdField_b_of_type_JavaUtilHashSet;
    if (localHashSet != null) {
      return localHashSet.contains(paramObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AIOSingleReporter
 * JD-Core Version:    0.7.0.1
 */