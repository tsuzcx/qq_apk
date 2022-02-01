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
    if ((paramObject != null) && (this.jdField_b_of_type_JavaUtilHashMap != null)) {
      return (MessageForShortVideo)this.jdField_b_of_type_JavaUtilHashMap.get(paramObject);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashSet != null)
    {
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      this.jdField_a_of_type_JavaUtilHashSet = null;
    }
    if (this.jdField_b_of_type_JavaUtilHashSet != null)
    {
      this.jdField_b_of_type_JavaUtilHashSet.clear();
      this.jdField_b_of_type_JavaUtilHashSet = null;
    }
    if (this.jdField_b_of_type_JavaUtilHashMap != null)
    {
      this.jdField_b_of_type_JavaUtilHashMap.clear();
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
    if ((this.jdField_a_of_type_JavaUtilHashSet == null) || (this.jdField_a_of_type_JavaUtilHashSet.size() == 0)) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    HashSet localHashSet = new HashSet();
    int i = paramChatXListView.getFirstVisiblePosition();
    int k = paramChatXListView.getLastVisiblePosition();
    int j = paramChatXListView.getHeaderViewsCount();
    if (i > j) {}
    for (;;)
    {
      if ((i < j) || (i > k)) {
        break label147;
      }
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
        for (;;)
        {
          localIndexOutOfBoundsException.printStackTrace();
        }
      }
      i += 1;
      continue;
      i = j;
    }
    label147:
    this.jdField_a_of_type_JavaUtilHashSet = localHashSet;
    QLog.d("ShortVideoUtils", 2, "markVisibleView cost time: " + (SystemClock.uptimeMillis() - l1));
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
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      paramString = (HashSet)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (paramString == null) {}
    }
    for (boolean bool = paramString.contains(Long.valueOf(paramLong));; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOSingleReporter", 2, "hasReported(): uniseq=" + paramLong + " result = " + bool);
      }
      return bool;
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      paramString = (HashSet)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (paramString == null) {}
    }
    for (boolean bool = paramString.contains(Long.valueOf(paramMessageRecord.uniseq));; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOSingleReporter", 2, "hasReported(): mr.uniseq=" + paramMessageRecord.uniseq + " result = " + bool);
      }
      return bool;
    }
  }
  
  public boolean a(Object paramObject)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilHashSet != null) {
      bool = this.jdField_a_of_type_JavaUtilHashSet.contains(paramObject);
    }
    return bool;
  }
  
  public boolean b(Object paramObject)
  {
    boolean bool = false;
    if (this.jdField_b_of_type_JavaUtilHashSet != null) {
      bool = this.jdField_b_of_type_JavaUtilHashSet.contains(paramObject);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AIOSingleReporter
 * JD-Core Version:    0.7.0.1
 */