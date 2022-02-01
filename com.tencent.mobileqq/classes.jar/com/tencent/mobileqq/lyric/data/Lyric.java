package com.tencent.mobileqq.lyric.data;

import android.graphics.Paint;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lyric
{
  public int a;
  private Sentence a;
  public ArrayList<Sentence> a;
  @Deprecated
  public int b;
  public ArrayList<SentenceUI> b;
  private int c = 0;
  private int d;
  
  public Lyric(int paramInt1, int paramInt2, ArrayList<Sentence> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    return b(paramInt);
  }
  
  public List<Sentence> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence = null;
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt)
  {
    a(paramPaint1, paramPaint2, paramInt, false, false);
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.c = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Sentence localSentence = (Sentence)localIterator.next();
        localSentence.a(paramPaint1, paramPaint2, paramInt, paramBoolean1, paramBoolean2);
        this.c += localSentence.a();
        this.jdField_b_of_type_JavaUtilArrayList.addAll(localSentence.jdField_a_of_type_JavaUtilArrayList);
      }
    }
  }
  
  public void a(Lyric paramLyric)
  {
    this.jdField_a_of_type_Int = paramLyric.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramLyric.jdField_b_of_type_Int;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = paramLyric.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Sentence localSentence = (Sentence)localIterator.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(localSentence.a());
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.c = paramLyric.b();
    Log.d("Lyric", "copy -> mType : " + this.jdField_a_of_type_Int);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int b(int paramInt)
  {
    if (paramInt < 0)
    {
      Log.w("Lyric", "findLineNoByStartTime -> illegal time");
      return -1;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      Log.w("Lyric", "findLineNoByStartTime -> lyric is empty");
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence != null) && (this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence.jdField_a_of_type_Long < paramInt) && (this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence.jdField_a_of_type_Long + this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence.b > paramInt)) {
      return this.d;
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int k = localArrayList.size();
    int j = 0;
    if (j < k)
    {
      Sentence localSentence = (Sentence)localArrayList.get(j);
      if (localSentence == null) {}
      while (localSentence.jdField_a_of_type_Long <= paramInt)
      {
        j += 1;
        break;
      }
    }
    for (paramInt = j - 1;; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j == k) {}
      for (paramInt = k - 1;; paramInt = i)
      {
        this.d = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence = ((Sentence)localArrayList.get(paramInt));
        return paramInt;
      }
    }
  }
  
  public int c()
  {
    if (a()) {
      return 0;
    }
    Sentence localSentence = (Sentence)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    long l = localSentence.jdField_a_of_type_Long;
    return (int)(localSentence.b + l);
  }
  
  public int c(int paramInt)
  {
    int i;
    if (paramInt < 0)
    {
      Log.w("Lyric", "findEndLineByStartTime -> illegal time");
      i = 0;
      return i;
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null)
    {
      Log.w("Lyric", "findEndLineByStartTime -> sentence data not found");
      return -1;
    }
    int k = localArrayList.size();
    int j = 0;
    if (j < k)
    {
      Sentence localSentence = (Sentence)localArrayList.get(j);
      if (localSentence == null) {}
      while (paramInt > localSentence.jdField_a_of_type_Long)
      {
        j += 1;
        break;
      }
    }
    for (paramInt = j - 1;; paramInt = 0)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j != k) {
        break;
      }
      return k - 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Sentence localSentence = (Sentence)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(localSentence.jdField_a_of_type_Long);
      localStringBuilder.append(":");
      localStringBuilder.append(localSentence.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(":");
      localStringBuilder.append(localSentence.b + localSentence.jdField_a_of_type_Long);
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.data.Lyric
 * JD-Core Version:    0.7.0.1
 */