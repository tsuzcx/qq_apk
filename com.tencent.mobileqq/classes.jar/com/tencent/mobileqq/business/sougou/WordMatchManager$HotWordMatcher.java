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
  protected int a = 0;
  protected boolean b = false;
  protected Queue<WordMatchManager.MatchTask> c = new LinkedList();
  protected WordMatchManager.MatchTask d = new WordMatchManager.MatchTask();
  
  WordMatchManager$HotWordMatcher(WordMatchManager paramWordMatchManager)
  {
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
    if (this.b)
    {
      localMatchTask = new WordMatchManager.MatchTask();
      i = this.a + 1;
      this.a = i;
      localMatchTask.a = i;
      localMatchTask.c = paramInt2;
      localMatchTask.b = paramInt1;
      localMatchTask.d = paramString;
      localMatchTask.e = new WeakReference(paramMatchCallback);
      this.c.add(localMatchTask);
      return localMatchTask.a;
    }
    if (this.d == null) {
      this.d = new WordMatchManager.MatchTask();
    }
    WordMatchManager.MatchTask localMatchTask = this.d;
    int i = this.a + 1;
    this.a = i;
    localMatchTask.a = i;
    localMatchTask.c = paramInt2;
    localMatchTask.b = paramInt1;
    localMatchTask.d = paramString;
    localMatchTask.e = new WeakReference(paramMatchCallback);
    return executeMatchTask(this.d);
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    WordMatchManager.MatchTask localMatchTask2 = this.d;
    WordMatchManager.MatchTask localMatchTask1 = null;
    if ((localMatchTask2 != null) && (paramInt == localMatchTask2.a))
    {
      this.d = null;
      return;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      localMatchTask2 = (WordMatchManager.MatchTask)localIterator.next();
      if (localMatchTask2.a == paramInt) {
        localMatchTask1 = localMatchTask2;
      }
    }
    if (localMatchTask1 != null) {
      this.c.remove(localMatchTask1);
    }
  }
  
  protected void dispatchNextTask()
  {
    this.b = false;
    if (!this.c.isEmpty())
    {
      this.d = ((WordMatchManager.MatchTask)this.c.remove());
      executeMatchTask(this.d);
      return;
    }
    this.d = null;
  }
  
  protected int executeMatchTask(WordMatchManager.MatchTask paramMatchTask)
  {
    if (!this.e.e) {
      return -3;
    }
    if ((!this.e.i.a) && (!this.e.i.b)) {
      return -3;
    }
    this.b = true;
    int j = paramMatchTask.c;
    arrayOfInt2 = null;
    try
    {
      localObject1 = paramMatchTask.d.getBytes("GB2312");
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
      arrayOfByte = this.e.a(2).getBytes();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      break label145;
    }
    try
    {
      localObject4 = this.e.a(1).getBytes();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException3)
    {
      break label131;
    }
    try
    {
      localObject2 = this.e.a(3).getBytes();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException4)
    {
      break label121;
    }
    try
    {
      localObject3 = this.e.a(4).getBytes();
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
    localObject5 = this.e.i.d;
    arrayOfInt2 = new int[((Set)localObject5).size()];
    i = 0;
    localObject5 = ((Set)localObject5).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      arrayOfInt2[i] = ((Integer)((Iterator)localObject5).next()).intValue();
      i += 1;
    }
    ThreadManager.executeOnSubThread(new WordMatchManager.HotWordMatcher.2(this, (byte[])localObject1, j, arrayOfInt2, arrayOfByte, (byte[])localObject4, (byte[])localObject2, (byte[])localObject3));
    return paramMatchTask.a;
  }
  
  protected boolean isRequestExist(int paramInt, WordMatchManager.MatchCallback paramMatchCallback)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((WordMatchManager.MatchTask)localObject).b == paramInt) && (this.d.e == paramMatchCallback)) {
      return true;
    }
    localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WordMatchManager.MatchTask localMatchTask = (WordMatchManager.MatchTask)((Iterator)localObject).next();
      if ((localMatchTask.b == paramInt) && (localMatchTask.e == paramMatchCallback)) {
        return true;
      }
    }
    return false;
  }
  
  protected void onMatchResult(WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    if (this.e.c == null) {
      return;
    }
    this.e.c.runOnUiThread(new WordMatchManager.HotWordMatcher.1(this, paramArrayOfHotWordItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordMatcher
 * JD-Core Version:    0.7.0.1
 */