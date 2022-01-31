package com.tencent.mobileqq.business.sougou;

import amdf;
import amdg;
import amdh;
import amdj;
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
  implements amdj
{
  protected int a;
  protected amdh a;
  protected Queue<amdh> a;
  protected boolean a;
  
  WordMatchManager$HotWordMatcher(WordMatchManager paramWordMatchManager)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_Amdh = new amdh();
    onMatchResult(null);
  }
  
  protected native boolean Match(byte[] paramArrayOfByte1, int paramInt, int[] paramArrayOfInt, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5);
  
  public int a(int paramInt1, String paramString, int paramInt2, amdg paramamdg)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return -4;
    }
    if (isRequestExist(paramInt1, paramamdg)) {
      return -2;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localamdh = new amdh();
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localamdh.jdField_a_of_type_Int = i;
      localamdh.c = paramInt2;
      localamdh.b = paramInt1;
      localamdh.jdField_a_of_type_JavaLangString = paramString;
      localamdh.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramamdg);
      this.jdField_a_of_type_JavaUtilQueue.add(localamdh);
      return localamdh.jdField_a_of_type_Int;
    }
    if (this.jdField_a_of_type_Amdh == null) {
      this.jdField_a_of_type_Amdh = new amdh();
    }
    amdh localamdh = this.jdField_a_of_type_Amdh;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    localamdh.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_Amdh.c = paramInt2;
    this.jdField_a_of_type_Amdh.b = paramInt1;
    this.jdField_a_of_type_Amdh.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Amdh.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramamdg);
    return executeMatchTask(this.jdField_a_of_type_Amdh);
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
      if ((this.jdField_a_of_type_Amdh != null) && (paramInt == this.jdField_a_of_type_Amdh.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Amdh = null;
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
      if (localIterator.hasNext())
      {
        amdh localamdh = (amdh)localIterator.next();
        if (localamdh.jdField_a_of_type_Int != paramInt) {
          break label92;
        }
        localObject = localamdh;
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
      this.jdField_a_of_type_Amdh = ((amdh)this.jdField_a_of_type_JavaUtilQueue.remove());
      executeMatchTask(this.jdField_a_of_type_Amdh);
      return;
    }
    this.jdField_a_of_type_Amdh = null;
  }
  
  protected int executeMatchTask(amdh paramamdh)
  {
    Object localObject5 = null;
    if (!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.c) {}
    while ((!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_Amdf.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_Amdf.b)) {
      return -3;
    }
    this.jdField_a_of_type_Boolean = true;
    int j = paramamdh.c;
    try
    {
      arrayOfByte4 = paramamdh.jdField_a_of_type_JavaLangString.getBytes("GB2312");
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
    localObject7 = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_Amdf.jdField_a_of_type_JavaUtilSet;
    localObject6 = new int[((Set)localObject7).size()];
    localObject7 = ((Set)localObject7).iterator();
    i = 0;
    while (((Iterator)localObject7).hasNext())
    {
      localObject6[i] = ((Integer)((Iterator)localObject7).next()).intValue();
      i += 1;
    }
    ThreadManager.executeOnSubThread(new WordMatchManager.HotWordMatcher.2(this, arrayOfByte4, j, (int[])localObject6, arrayOfByte3, arrayOfByte2, arrayOfByte1, localObject5));
    return paramamdh.jdField_a_of_type_Int;
  }
  
  protected boolean isRequestExist(int paramInt, amdg paramamdg)
  {
    if ((this.jdField_a_of_type_Amdh != null) && (this.jdField_a_of_type_Amdh.b == paramInt) && (this.jdField_a_of_type_Amdh.jdField_a_of_type_JavaLangRefWeakReference == paramamdg)) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (localIterator.hasNext())
    {
      amdh localamdh = (amdh)localIterator.next();
      if ((localamdh.b == paramInt) && (localamdh.jdField_a_of_type_JavaLangRefWeakReference == paramamdg)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordMatcher
 * JD-Core Version:    0.7.0.1
 */