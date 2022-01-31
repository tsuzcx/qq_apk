package com.tencent.mobileqq.business.sougou;

import android.os.Looper;
import anue;
import anuf;
import anug;
import anui;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class WordMatchManager$HotWordMatcher
  implements anui
{
  protected int a;
  protected anug a;
  protected Queue<anug> a;
  protected boolean a;
  
  WordMatchManager$HotWordMatcher(WordMatchManager paramWordMatchManager)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_Anug = new anug();
    onMatchResult(null);
  }
  
  protected native boolean Match(byte[] paramArrayOfByte1, int paramInt, int[] paramArrayOfInt, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5);
  
  public int a(int paramInt1, String paramString, int paramInt2, anuf paramanuf)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return -4;
    }
    if (isRequestExist(paramInt1, paramanuf)) {
      return -2;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localanug = new anug();
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localanug.jdField_a_of_type_Int = i;
      localanug.c = paramInt2;
      localanug.b = paramInt1;
      localanug.jdField_a_of_type_JavaLangString = paramString;
      localanug.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanuf);
      this.jdField_a_of_type_JavaUtilQueue.add(localanug);
      return localanug.jdField_a_of_type_Int;
    }
    if (this.jdField_a_of_type_Anug == null) {
      this.jdField_a_of_type_Anug = new anug();
    }
    anug localanug = this.jdField_a_of_type_Anug;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    localanug.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_Anug.c = paramInt2;
    this.jdField_a_of_type_Anug.b = paramInt1;
    this.jdField_a_of_type_Anug.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Anug.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanuf);
    return executeMatchTask(this.jdField_a_of_type_Anug);
  }
  
  public void a(int paramInt)
  {
    Object localObject = null;
    if (paramInt <= 0) {}
    label92:
    label93:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Anug != null) && (paramInt == this.jdField_a_of_type_Anug.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Anug = null;
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
      if (localIterator.hasNext())
      {
        anug localanug = (anug)localIterator.next();
        if (localanug.jdField_a_of_type_Int != paramInt) {
          break label92;
        }
        localObject = localanug;
      }
      for (;;)
      {
        break;
        if (localObject == null) {
          break label93;
        }
        this.jdField_a_of_type_JavaUtilQueue.remove(localObject);
        return;
      }
    }
  }
  
  protected void dispatchNextTask()
  {
    this.jdField_a_of_type_Boolean = false;
    if (!this.jdField_a_of_type_JavaUtilQueue.isEmpty())
    {
      this.jdField_a_of_type_Anug = ((anug)this.jdField_a_of_type_JavaUtilQueue.remove());
      executeMatchTask(this.jdField_a_of_type_Anug);
      return;
    }
    this.jdField_a_of_type_Anug = null;
  }
  
  protected int executeMatchTask(anug paramanug)
  {
    Object localObject5 = null;
    if (!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.c) {}
    while ((!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_Anue.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_Anue.b)) {
      return -3;
    }
    this.jdField_a_of_type_Boolean = true;
    int j = paramanug.c;
    try
    {
      arrayOfByte4 = paramanug.jdField_a_of_type_JavaLangString.getBytes("GB2312");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      for (;;)
      {
        byte[] arrayOfByte1;
        Object localObject6;
        label119:
        Object localObject7;
        int i;
        Object localObject1 = null;
        arrayOfByte2 = null;
        arrayOfByte3 = null;
        byte[] arrayOfByte4 = null;
      }
    }
    try
    {
      arrayOfByte3 = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(2).getBytes();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      Object localObject2 = null;
      arrayOfByte2 = null;
      arrayOfByte3 = null;
      break label119;
    }
    try
    {
      arrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(1).getBytes();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException3)
    {
      Object localObject3 = null;
      arrayOfByte2 = null;
      break label119;
    }
    try
    {
      arrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(3).getBytes();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException4)
    {
      Object localObject4 = null;
      break label119;
    }
    try
    {
      localObject6 = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(4).getBytes();
      localObject5 = localObject6;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException5)
    {
      break label119;
    }
    localObject7 = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_Anue.jdField_a_of_type_JavaUtilSet;
    localObject6 = new int[((Set)localObject7).size()];
    localObject7 = ((Set)localObject7).iterator();
    i = 0;
    while (((Iterator)localObject7).hasNext())
    {
      localObject6[i] = ((Integer)((Iterator)localObject7).next()).intValue();
      i += 1;
    }
    ThreadManager.executeOnSubThread(new WordMatchManager.HotWordMatcher.2(this, arrayOfByte4, j, (int[])localObject6, arrayOfByte3, arrayOfByte2, arrayOfByte1, localObject5));
    return paramanug.jdField_a_of_type_Int;
  }
  
  protected boolean isRequestExist(int paramInt, anuf paramanuf)
  {
    if ((this.jdField_a_of_type_Anug != null) && (this.jdField_a_of_type_Anug.b == paramInt) && (this.jdField_a_of_type_Anug.jdField_a_of_type_JavaLangRefWeakReference == paramanuf)) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (localIterator.hasNext())
    {
      anug localanug = (anug)localIterator.next();
      if ((localanug.b == paramInt) && (localanug.jdField_a_of_type_JavaLangRefWeakReference == paramanuf)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordMatcher
 * JD-Core Version:    0.7.0.1
 */