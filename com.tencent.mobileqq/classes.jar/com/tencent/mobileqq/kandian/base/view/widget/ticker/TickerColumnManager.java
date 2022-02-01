package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class TickerColumnManager
{
  private final TickerDrawMetrics jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics;
  final ArrayList<TickerColumn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<Character> jdField_a_of_type_JavaUtilSet;
  boolean jdField_a_of_type_Boolean = false;
  private TickerCharacterList[] jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetTickerTickerCharacterList;
  ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  
  TickerColumnManager(TickerDrawMetrics paramTickerDrawMetrics)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics = paramTickerDrawMetrics;
  }
  
  float a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b();
      i += 1;
    }
    return f;
  }
  
  void a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
  }
  
  void a(float paramFloat)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramFloat, this.jdField_b_of_type_Boolean);
      i += 1;
    }
  }
  
  void a(Canvas paramCanvas, Paint paramPaint)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      TickerColumn localTickerColumn = (TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localTickerColumn.a(paramCanvas, paramPaint);
      paramCanvas.translate(localTickerColumn.a(), 0.0F);
      i += 1;
    }
  }
  
  void a(ArrayList<String> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  void a(char[] paramArrayOfChar)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetTickerTickerCharacterList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        if (((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a() > 0.0F) {
          i += 1;
        } else {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
      }
      int[] arrayOfInt = LevenshteinUtils.a(a(), paramArrayOfChar, this.jdField_a_of_type_JavaUtilSet);
      int n = 0;
      i = 0;
      int i1 = 1;
      int m = 1;
      int k;
      for (int j = 0; n < arrayOfInt.length; j = k)
      {
        k = arrayOfInt[n];
        int i4;
        int i2;
        int i3;
        if (k != 0) {
          if (k != 1) {
            if (k == 2)
            {
              ((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(i1, '\000', this.jdField_b_of_type_Boolean);
              i4 = i + 1;
              i = i4;
              i2 = i1;
              i3 = m;
              k = j;
              if (!this.jdField_a_of_type_Boolean) {
                break label458;
              }
              i = i4;
            }
          }
        }
        for (;;)
        {
          i2 = i1 + m;
          i3 = m + 1;
          k = j;
          break;
          paramArrayOfChar = new StringBuilder();
          paramArrayOfChar.append("Unknown action: ");
          paramArrayOfChar.append(arrayOfInt[n]);
          throw new IllegalArgumentException(paramArrayOfChar.toString());
          this.jdField_a_of_type_JavaUtilArrayList.add(i, new TickerColumn(this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetTickerTickerCharacterList, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics));
          TickerColumn localTickerColumn = (TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          char[] arrayOfChar2 = null;
          ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
          char[] arrayOfChar1 = arrayOfChar2;
          if (localArrayList != null)
          {
            arrayOfChar1 = arrayOfChar2;
            if (localArrayList.size() > n)
            {
              arrayOfChar2 = ((String)this.jdField_b_of_type_JavaUtilArrayList.get(n)).toCharArray();
              arrayOfChar1 = arrayOfChar2;
              if (arrayOfChar2 != null)
              {
                k = arrayOfChar2.length;
                if (arrayOfChar2.length > 0) {
                  bool = true;
                } else {
                  bool = false;
                }
                k -= 1;
                arrayOfChar1 = arrayOfChar2;
                break label356;
              }
            }
          }
          boolean bool = false;
          k = 0;
          label356:
          localTickerColumn.a(i1, paramArrayOfChar[j], this.jdField_b_of_type_Boolean, bool, arrayOfChar1, 0, k);
          i4 = i + 1;
          int i5 = j + 1;
          i = i4;
          i2 = i1;
          i3 = m;
          k = i5;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          i = i4;
          j = i5;
          if (localTickerColumn.a() == localTickerColumn.b())
          {
            i = i4;
            i2 = i1;
            i3 = m;
            k = i5;
            if (i1 <= 1) {
              break;
            }
            i = i4;
            j = i5;
          }
        }
        label458:
        n += 1;
        i1 = i2;
        m = i3;
      }
      return;
    }
    paramArrayOfChar = new IllegalStateException("Need to call #setCharacterLists first.");
    for (;;)
    {
      throw paramArrayOfChar;
    }
  }
  
  void a(String... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetTickerTickerCharacterList = new TickerCharacterList[paramVarArgs.length];
    int j = 0;
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetTickerTickerCharacterList[i] = new TickerCharacterList(paramVarArgs[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    i = j;
    while (i < paramVarArgs.length)
    {
      this.jdField_a_of_type_JavaUtilSet.addAll(this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetTickerTickerCharacterList[i].a());
      i += 1;
    }
  }
  
  char[] a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return arrayOfChar;
  }
  
  TickerCharacterList[] a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetTickerTickerCharacterList;
  }
  
  float b()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += ((TickerColumn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return f;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerColumnManager
 * JD-Core Version:    0.7.0.1
 */