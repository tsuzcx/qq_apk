package com.tencent.mobileqq.wink.editor.music.lyric.data;

import android.graphics.Paint;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lyric
{
  public int a;
  public ArrayList<Sentence> b;
  public ArrayList<SentenceUI> c = new ArrayList();
  @Deprecated
  public int d;
  private int e = 0;
  private Sentence f;
  private int g;
  
  public Lyric(int paramInt1, int paramInt2, ArrayList<Sentence> paramArrayList)
  {
    this.a = paramInt1;
    this.d = paramInt2;
    this.b = paramArrayList;
  }
  
  public int a()
  {
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    return b(paramInt);
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt)
  {
    a(paramPaint1, paramPaint2, paramInt, false, false);
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean)
  {
    a(paramPaint1, paramPaint2, paramInt, paramBoolean, false);
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c.clear();
    this.e = 0;
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Sentence localSentence = (Sentence)((Iterator)localObject).next();
        localSentence.a(paramPaint1, paramPaint2, paramInt, paramBoolean1, paramBoolean2);
        this.e += localSentence.b();
        this.c.addAll(localSentence.d);
      }
    }
  }
  
  public void a(Lyric paramLyric)
  {
    this.a = paramLyric.a;
    this.d = paramLyric.d;
    Object localObject = this.b;
    if (localObject == null) {
      this.b = new ArrayList();
    } else {
      ((ArrayList)localObject).clear();
    }
    localObject = paramLyric.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Sentence localSentence = (Sentence)((Iterator)localObject).next();
      this.b.add(localSentence.a());
    }
    this.e = paramLyric.b();
    paramLyric = new StringBuilder();
    paramLyric.append("copy -> mType : ");
    paramLyric.append(this.a);
    Log.d("Lyric", paramLyric.toString());
  }
  
  public int b()
  {
    return this.e;
  }
  
  public int b(int paramInt)
  {
    if (paramInt < 0)
    {
      Log.w("Lyric", "findLineNoByStartTime -> illegal time");
      return -1;
    }
    Object localObject = this.b;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = this.f;
      if (localObject != null)
      {
        long l1 = ((Sentence)localObject).b;
        long l2 = paramInt;
        if ((l1 < l2) && (this.f.b + this.f.c > l2)) {
          return this.g;
        }
      }
      localObject = this.b;
      int k = ((List)localObject).size();
      int j = 0;
      while (j < k)
      {
        Sentence localSentence = (Sentence)((List)localObject).get(j);
        if ((localSentence != null) && (localSentence.b > paramInt))
        {
          paramInt = j - 1;
          break label163;
        }
        j += 1;
      }
      paramInt = 0;
      label163:
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j == k) {
        i = k - 1;
      }
      this.g = i;
      this.f = ((Sentence)((List)localObject).get(i));
      return i;
    }
    Log.w("Lyric", "findLineNoByStartTime -> lyric is empty");
    return -1;
  }
  
  public int c(int paramInt)
  {
    if (paramInt < 0)
    {
      Log.w("Lyric", "findEndLineByStartTime -> illegal time");
      return 0;
    }
    ArrayList localArrayList = this.b;
    if (localArrayList == null)
    {
      Log.w("Lyric", "findEndLineByStartTime -> sentence data not found");
      return -1;
    }
    int k = localArrayList.size();
    int j = 0;
    while (j < k)
    {
      Sentence localSentence = (Sentence)localArrayList.get(j);
      if ((localSentence != null) && (paramInt <= localSentence.b))
      {
        paramInt = j - 1;
        break label96;
      }
      j += 1;
    }
    paramInt = 0;
    label96:
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (j == k) {
      i = k - 1;
    }
    return i;
  }
  
  public boolean c()
  {
    ArrayList localArrayList = this.b;
    return (localArrayList == null) || (localArrayList.size() == 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.b == null) {
      return null;
    }
    int i = 0;
    while (i < this.b.size())
    {
      Sentence localSentence = (Sentence)this.b.get(i);
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(localSentence.b);
      localStringBuilder.append(":");
      localStringBuilder.append(localSentence.a);
      localStringBuilder.append(":");
      localStringBuilder.append(localSentence.c + localSentence.b);
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.data.Lyric
 * JD-Core Version:    0.7.0.1
 */