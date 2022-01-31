package com.tencent.mobileqq.lyric.data;

import android.graphics.Paint;
import java.util.ArrayList;

public class Sentence
{
  public long a;
  public SentenceAttachInfo a;
  public String a;
  public ArrayList a;
  public long b;
  public SentenceAttachInfo b;
  public ArrayList b;
  
  public Sentence()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo = new SentenceAttachInfo();
    this.jdField_b_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo = new SentenceAttachInfo();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Sentence a()
  {
    Sentence localSentence = new Sentence();
    localSentence.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localSentence.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    localSentence.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      localSentence.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      localSentence.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    }
    localSentence.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    return localSentence;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int k = (int)paramPaint1.measureText(this.jdField_a_of_type_JavaLangString);
    int i1 = 0;
    int i = 0;
    int i2 = 0;
    int j = 0;
    if (k <= paramInt) {
      if (paramBoolean2)
      {
        paramInt = j;
        paramPaint1 = new SentenceUI(this.jdField_a_of_type_JavaLangString, i, paramInt, this.jdField_b_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramPaint1);
      }
    }
    String[] arrayOfString;
    int i6;
    do
    {
      return;
      i = paramInt - (int)paramPaint2.measureText(this.jdField_a_of_type_JavaLangString) >> 1;
      paramInt = paramInt - k >> 1;
      break;
      if (paramBoolean1)
      {
        paramPaint1 = new SentenceUI(this.jdField_a_of_type_JavaLangString, 0, 0, this.jdField_b_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramPaint1);
        return;
      }
      arrayOfString = LyricDataUtil.a(this.jdField_a_of_type_JavaLangString, paramPaint1, paramInt, paramInt);
      i6 = arrayOfString.length;
    } while (i6 <= 0);
    int n = 0;
    j = 0;
    i = 0;
    k = 0;
    int i3 = 0;
    int m = 0;
    label171:
    label183:
    Object localObject;
    int i4;
    Character localCharacter;
    if (i3 < i6)
    {
      if (!paramBoolean2) {
        break label454;
      }
      localObject = null;
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        break label678;
      }
      n += arrayOfString[i3].length();
      localObject = new ArrayList();
      i4 = m;
      m = j;
      j = k;
      k = i4;
      if (m >= this.jdField_b_of_type_JavaUtilArrayList.size()) {
        break label651;
      }
      localCharacter = (Character)this.jdField_b_of_type_JavaUtilArrayList.get(m);
      if ((i3 == 0) || (i != m)) {
        break label636;
      }
      k = n - arrayOfString[i3].length();
      i4 = localCharacter.jdField_a_of_type_Int;
      j = k;
      k = i4 - k;
      label300:
      if ((localCharacter.jdField_a_of_type_Int > n) || (localCharacter.jdField_b_of_type_Int < n)) {
        break label546;
      }
      if (i3 != 0) {
        break label493;
      }
      ((ArrayList)localObject).add(new Character(localCharacter.jdField_a_of_type_Long, localCharacter.jdField_b_of_type_Long, localCharacter.jdField_a_of_type_Int, arrayOfString[i3].length()));
      label361:
      m += 1;
      i4 = m;
      i = n;
      n = k;
      k = i4;
    }
    for (;;)
    {
      localObject = new SentenceUI(arrayOfString[i3], i1, i2, (ArrayList)localObject);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      int i5 = i3 + 1;
      i3 = k;
      i4 = m;
      m = j;
      k = n;
      j = i4;
      n = i;
      i = i3;
      i3 = i5;
      break label171;
      break;
      label454:
      i1 = (int)paramPaint2.measureText(arrayOfString[i3]);
      i2 = paramInt - (int)paramPaint1.measureText(arrayOfString[i3]) >> 1;
      i1 = paramInt - i1 >> 1;
      break label183;
      label493:
      i = localCharacter.jdField_a_of_type_Int;
      i4 = arrayOfString[i3].length();
      ((ArrayList)localObject).add(new Character(localCharacter.jdField_a_of_type_Long, localCharacter.jdField_b_of_type_Long, i - j - k, i4));
      break label361;
      label546:
      if (i3 == 0) {
        ((ArrayList)localObject).add(localCharacter);
      }
      for (;;)
      {
        i4 = k;
        m += 1;
        k = j;
        j = i4;
        break;
        i4 = localCharacter.jdField_a_of_type_Int;
        i5 = localCharacter.jdField_b_of_type_Int;
        ((ArrayList)localObject).add(new Character(localCharacter.jdField_a_of_type_Long, localCharacter.jdField_b_of_type_Long, i4 - j - k, i5 - j - k));
      }
      label636:
      i4 = j;
      j = k;
      k = i4;
      break label300;
      label651:
      i4 = k;
      i5 = j;
      k = i;
      i = n;
      j = i4;
      n = i5;
      continue;
      label678:
      i4 = k;
      i5 = j;
      k = i;
      i = n;
      j = m;
      n = i4;
      m = i5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.data.Sentence
 * JD-Core Version:    0.7.0.1
 */