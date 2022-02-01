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
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      return localArrayList.size();
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
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Sentence localSentence = (Sentence)((Iterator)localObject).next();
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
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    } else {
      ((ArrayList)localObject).clear();
    }
    localObject = paramLyric.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Sentence localSentence = (Sentence)((Iterator)localObject).next();
      this.jdField_a_of_type_JavaUtilArrayList.add(localSentence.a());
    }
    this.c = paramLyric.b();
    paramLyric = new StringBuilder();
    paramLyric.append("copy -> mType : ");
    paramLyric.append(this.jdField_a_of_type_Int);
    Log.d("Lyric", paramLyric.toString());
  }
  
  public boolean a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    return (localArrayList == null) || (localArrayList.size() == 0);
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
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence;
      if (localObject != null)
      {
        long l1 = ((Sentence)localObject).jdField_a_of_type_Long;
        long l2 = paramInt;
        if ((l1 < l2) && (this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence.jdField_a_of_type_Long + this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence.b > l2)) {
          return this.d;
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      int k = ((List)localObject).size();
      int j = 0;
      while (j < k)
      {
        Sentence localSentence = (Sentence)((List)localObject).get(j);
        if ((localSentence != null) && (localSentence.jdField_a_of_type_Long > paramInt))
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
      this.d = i;
      this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence = ((Sentence)((List)localObject).get(i));
      return i;
    }
    Log.w("Lyric", "findLineNoByStartTime -> lyric is empty");
    return -1;
  }
  
  public int c()
  {
    if (a()) {
      return 0;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    localObject = (Sentence)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    return (int)(((Sentence)localObject).jdField_a_of_type_Long + ((Sentence)localObject).b);
  }
  
  public int c(int paramInt)
  {
    if (paramInt < 0)
    {
      Log.w("Lyric", "findEndLineByStartTime -> illegal time");
      return 0;
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
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
      if ((localSentence != null) && (paramInt <= localSentence.jdField_a_of_type_Long))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.data.Lyric
 * JD-Core Version:    0.7.0.1
 */