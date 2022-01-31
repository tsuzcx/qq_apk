package com.tencent.mobileqq.business.sougou;

import android.os.Looper;
import anyn;
import anyo;
import anyp;
import anyr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class WordMatchManager$HotWordMatcher
  implements anyr
{
  protected int a;
  protected anyp a;
  protected Queue<anyp> a;
  protected boolean a;
  
  WordMatchManager$HotWordMatcher(WordMatchManager paramWordMatchManager)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_Anyp = new anyp();
    onMatchResult(null);
  }
  
  protected native boolean Match(byte[] paramArrayOfByte1, int paramInt, int[] paramArrayOfInt, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5);
  
  public int a(int paramInt1, String paramString, int paramInt2, anyo paramanyo)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return -4;
    }
    if (isRequestExist(paramInt1, paramanyo)) {
      return -2;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localanyp = new anyp();
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localanyp.jdField_a_of_type_Int = i;
      localanyp.c = paramInt2;
      localanyp.b = paramInt1;
      localanyp.jdField_a_of_type_JavaLangString = paramString;
      localanyp.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanyo);
      this.jdField_a_of_type_JavaUtilQueue.add(localanyp);
      return localanyp.jdField_a_of_type_Int;
    }
    if (this.jdField_a_of_type_Anyp == null) {
      this.jdField_a_of_type_Anyp = new anyp();
    }
    anyp localanyp = this.jdField_a_of_type_Anyp;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    localanyp.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_Anyp.c = paramInt2;
    this.jdField_a_of_type_Anyp.b = paramInt1;
    this.jdField_a_of_type_Anyp.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Anyp.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanyo);
    return executeMatchTask(this.jdField_a_of_type_Anyp);
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
      if ((this.jdField_a_of_type_Anyp != null) && (paramInt == this.jdField_a_of_type_Anyp.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Anyp = null;
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
      if (localIterator.hasNext())
      {
        anyp localanyp = (anyp)localIterator.next();
        if (localanyp.jdField_a_of_type_Int != paramInt) {
          break label92;
        }
        localObject = localanyp;
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
      this.jdField_a_of_type_Anyp = ((anyp)this.jdField_a_of_type_JavaUtilQueue.remove());
      executeMatchTask(this.jdField_a_of_type_Anyp);
      return;
    }
    this.jdField_a_of_type_Anyp = null;
  }
  
  protected int executeMatchTask(anyp paramanyp)
  {
    Object localObject5 = null;
    if (!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.c) {}
    while ((!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_Anyn.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_Anyn.b)) {
      return -3;
    }
    this.jdField_a_of_type_Boolean = true;
    int j = paramanyp.c;
    try
    {
      arrayOfByte4 = paramanyp.jdField_a_of_type_JavaLangString.getBytes("GB2312");
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
    localObject7 = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_Anyn.jdField_a_of_type_JavaUtilSet;
    localObject6 = new int[((Set)localObject7).size()];
    localObject7 = ((Set)localObject7).iterator();
    i = 0;
    while (((Iterator)localObject7).hasNext())
    {
      localObject6[i] = ((Integer)((Iterator)localObject7).next()).intValue();
      i += 1;
    }
    ThreadManager.executeOnSubThread(new WordMatchManager.HotWordMatcher.2(this, arrayOfByte4, j, (int[])localObject6, arrayOfByte3, arrayOfByte2, arrayOfByte1, localObject5));
    return paramanyp.jdField_a_of_type_Int;
  }
  
  protected boolean isRequestExist(int paramInt, anyo paramanyo)
  {
    if ((this.jdField_a_of_type_Anyp != null) && (this.jdField_a_of_type_Anyp.b == paramInt) && (this.jdField_a_of_type_Anyp.jdField_a_of_type_JavaLangRefWeakReference == paramanyo)) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (localIterator.hasNext())
    {
      anyp localanyp = (anyp)localIterator.next();
      if ((localanyp.b == paramInt) && (localanyp.jdField_a_of_type_JavaLangRefWeakReference == paramanyo)) {
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