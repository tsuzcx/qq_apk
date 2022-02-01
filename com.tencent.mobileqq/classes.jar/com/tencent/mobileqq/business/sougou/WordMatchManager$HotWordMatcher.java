package com.tencent.mobileqq.business.sougou;

import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class WordMatchManager$HotWordMatcher
  implements WordMatchManager.WordMatcher
{
  protected int a;
  protected WordMatchManager.MatchTask a;
  protected Queue<WordMatchManager.MatchTask> a;
  protected boolean a;
  
  WordMatchManager$HotWordMatcher(WordMatchManager paramWordMatchManager)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchTask = new WordMatchManager.MatchTask();
    onMatchResult(null);
  }
  
  protected native boolean Match(byte[] paramArrayOfByte1, int paramInt, int[] paramArrayOfInt, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5);
  
  public int a(int paramInt1, String paramString, int paramInt2, WordMatchManager.MatchCallback paramMatchCallback)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return -4;
    }
    if (isRequestExist(paramInt1, paramMatchCallback)) {
      return -2;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localMatchTask = new WordMatchManager.MatchTask();
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localMatchTask.jdField_a_of_type_Int = i;
      localMatchTask.c = paramInt2;
      localMatchTask.b = paramInt1;
      localMatchTask.jdField_a_of_type_JavaLangString = paramString;
      localMatchTask.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMatchCallback);
      this.jdField_a_of_type_JavaUtilQueue.add(localMatchTask);
      return localMatchTask.jdField_a_of_type_Int;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchTask == null) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchTask = new WordMatchManager.MatchTask();
    }
    WordMatchManager.MatchTask localMatchTask = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchTask;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    localMatchTask.jdField_a_of_type_Int = i;
    localMatchTask.c = paramInt2;
    localMatchTask.b = paramInt1;
    localMatchTask.jdField_a_of_type_JavaLangString = paramString;
    localMatchTask.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMatchCallback);
    return executeMatchTask(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchTask);
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    WordMatchManager.MatchTask localMatchTask2 = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchTask;
    WordMatchManager.MatchTask localMatchTask1 = null;
    if ((localMatchTask2 != null) && (paramInt == localMatchTask2.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchTask = null;
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (localIterator.hasNext())
    {
      localMatchTask2 = (WordMatchManager.MatchTask)localIterator.next();
      if (localMatchTask2.jdField_a_of_type_Int == paramInt) {
        localMatchTask1 = localMatchTask2;
      }
    }
    if (localMatchTask1 != null) {
      this.jdField_a_of_type_JavaUtilQueue.remove(localMatchTask1);
    }
  }
  
  protected void dispatchNextTask()
  {
    this.jdField_a_of_type_Boolean = false;
    if (!this.jdField_a_of_type_JavaUtilQueue.isEmpty())
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchTask = ((WordMatchManager.MatchTask)this.jdField_a_of_type_JavaUtilQueue.remove());
      executeMatchTask(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchTask);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchTask = null;
  }
  
  protected int executeMatchTask(WordMatchManager.MatchTask paramMatchTask)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.c) {
      return -3;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment.b)) {
      return -3;
    }
    this.jdField_a_of_type_Boolean = true;
    int j = paramMatchTask.c;
    arrayOfInt2 = null;
    try
    {
      localObject1 = paramMatchTask.jdField_a_of_type_JavaLangString.getBytes("GB2312");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      Object localObject1;
      byte[] arrayOfByte;
      Object localObject4;
      Object localObject2;
      Object localObject3;
      label121:
      Object localObject5;
      label131:
      int i;
      break label152;
    }
    try
    {
      arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(2).getBytes();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      break label145;
    }
    try
    {
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(1).getBytes();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException3)
    {
      break label131;
    }
    try
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(3).getBytes();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException4)
    {
      break label121;
    }
    try
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(4).getBytes();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException5)
    {
      int[] arrayOfInt1 = arrayOfInt2;
      break label177;
    }
    localObject2 = null;
    localObject3 = arrayOfInt2;
    break label177;
    localObject2 = null;
    localObject3 = localObject1;
    localObject1 = localObject2;
    break label161;
    label145:
    localObject3 = localObject1;
    break label155;
    label152:
    localObject3 = null;
    label155:
    arrayOfByte = null;
    localObject1 = null;
    label161:
    localObject2 = localObject1;
    localObject4 = localObject1;
    localObject1 = localObject3;
    localObject3 = arrayOfInt2;
    label177:
    localObject5 = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment.jdField_a_of_type_JavaUtilSet;
    arrayOfInt2 = new int[((Set)localObject5).size()];
    i = 0;
    localObject5 = ((Set)localObject5).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      arrayOfInt2[i] = ((Integer)((Iterator)localObject5).next()).intValue();
      i += 1;
    }
    ThreadManager.executeOnSubThread(new WordMatchManager.HotWordMatcher.2(this, (byte[])localObject1, j, arrayOfInt2, arrayOfByte, (byte[])localObject4, (byte[])localObject2, (byte[])localObject3));
    return paramMatchTask.jdField_a_of_type_Int;
  }
  
  protected boolean isRequestExist(int paramInt, WordMatchManager.MatchCallback paramMatchCallback)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchTask;
    if ((localObject != null) && (((WordMatchManager.MatchTask)localObject).b == paramInt) && (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchTask.jdField_a_of_type_JavaLangRefWeakReference == paramMatchCallback)) {
      return true;
    }
    localObject = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WordMatchManager.MatchTask localMatchTask = (WordMatchManager.MatchTask)((Iterator)localObject).next();
      if ((localMatchTask.b == paramInt) && (localMatchTask.jdField_a_of_type_JavaLangRefWeakReference == paramMatchCallback)) {
        return true;
      }
    }
    return false;
  }
  
  protected void onMatchResult(WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new WordMatchManager.HotWordMatcher.1(this, paramArrayOfHotWordItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordMatcher
 * JD-Core Version:    0.7.0.1
 */