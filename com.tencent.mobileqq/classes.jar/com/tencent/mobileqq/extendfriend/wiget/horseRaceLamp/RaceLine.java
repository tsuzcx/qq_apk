package com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp;

import com.tencent.mobileqq.extendfriend.bean.TagInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class RaceLine
{
  private final int jdField_a_of_type_Int = 7;
  private ArrayList<Tag> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b = -1;
  private int c = -1;
  private int d = 0;
  private int e = 0;
  
  public RaceLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
  }
  
  private int a()
  {
    switch (this.b)
    {
    default: 
      return 0;
    case 0: 
      return -30;
    case 1: 
      return -80;
    case 2: 
      return -10;
    }
    return -60;
  }
  
  private void a(ArrayList<TagInfo> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        a(new Tag((TagInfo)paramArrayList.get(i)));
        i += 1;
      }
    }
  }
  
  public ArrayList<Tag> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    int m = 0;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      QLog.e("RaceLine horserace", 2, "一个都没有，没法复制啊大哥");
      return;
    }
    int j = 0;
    int i = 0;
    for (int k = 0; j < this.jdField_a_of_type_JavaUtilArrayList.size(); k = n)
    {
      int i1 = ((Tag)this.jdField_a_of_type_JavaUtilArrayList.get(j)).d();
      n = k + i1;
      k = i;
      if (i < i1) {
        k = i1;
      }
      j += 1;
      i = k;
    }
    int n = this.c + i;
    float f2 = 0.0F;
    float f1;
    if (k < n)
    {
      f1 = n / k;
      if (f1 <= 7.0F) {
        break label306;
      }
      f1 = 7.0F;
    }
    label306:
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      j = 0;
      for (;;)
      {
        k = m;
        if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        TagInfo localTagInfo = ((Tag)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a;
        if (localTagInfo != null) {
          localArrayList.add(new TagInfo(localTagInfo.jdField_a_of_type_Int, localTagInfo.jdField_a_of_type_JavaLangString, localTagInfo.b));
        }
        j += 1;
      }
      for (;;)
      {
        f2 = f1;
        if (k >= f1) {
          break;
        }
        a(localArrayList);
        k += 1;
      }
      QLog.d("RaceLine horserace", 2, "finalWid: " + n + " parent: " + this.c + " maxTagwid:" + i + " copyTime : " + f2);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    int m = 0;
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 2)
    {
      QLog.e("RaceLine horserace", 2, "tag 数量连2个都没有，不滑了哦～嘤嘤嘤嘤嘤～");
      return;
    }
    if ((this.c == -1) || (this.c < 10))
    {
      QLog.e("RaceLine horserace", 2, "mParentWidth err num");
      return;
    }
    Tag localTag1;
    int k;
    Tag localTag2;
    if (paramInt > 0)
    {
      for (i = -1; j < this.jdField_a_of_type_JavaUtilArrayList.size(); i = k)
      {
        localTag1 = (Tag)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        localTag1.b(localTag1.a() + paramInt);
        m = localTag1.a();
        k = i;
        if (m > 0)
        {
          k = i;
          if (m < this.c)
          {
            k = i;
            if (i == -1) {
              k = j;
            }
          }
        }
        j += 1;
      }
      if (i == -1)
      {
        QLog.e("RaceLine horserace", 2, "SubIndex out of range");
        return;
      }
      paramInt = i;
      if (paramInt >= 0)
      {
        localTag1 = (Tag)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (localTag1.a() > this.c)
        {
          localTag2 = localTag1.b();
          if (localTag2 != null) {
            break label242;
          }
          QLog.e("RaceLine horserace", 2, "rightBro is null " + paramInt + "  index:" + this.b);
        }
        for (;;)
        {
          paramInt -= 1;
          break;
          label242:
          localTag1.b(localTag2.a() - localTag1.c());
        }
      }
      paramInt = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      label271:
      if (paramInt > i)
      {
        localTag1 = (Tag)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (localTag1.a() > this.c)
        {
          localTag2 = localTag1.b();
          if (localTag2 != null) {
            break label357;
          }
          QLog.e("RaceLine horserace", 2, "rightBro is null " + paramInt + "  index:" + this.b);
        }
      }
      for (;;)
      {
        paramInt -= 1;
        break label271;
        break;
        label357:
        localTag1.b(localTag2.a() - localTag1.c());
      }
    }
    j = 0;
    for (int i = -1; j < this.jdField_a_of_type_JavaUtilArrayList.size(); i = k)
    {
      localTag1 = (Tag)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      localTag1.b(localTag1.a() + paramInt);
      k = localTag1.a();
      int n = localTag1.c() + k;
      k = i;
      if (n > 0)
      {
        k = i;
        if (n < this.c)
        {
          k = i;
          if (i == -1) {
            k = j;
          }
        }
      }
      j += 1;
    }
    if (i == -1)
    {
      QLog.e("RaceLine horserace", 2, "SubIndex out of range");
      return;
    }
    paramInt = i;
    j = m;
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localTag1 = (Tag)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localTag1.a() + localTag1.c() < 0)
      {
        localTag2 = localTag1.a();
        if (localTag2 != null) {
          break label587;
        }
        QLog.e("RaceLine horserace", 2, "leftBro is null " + paramInt + "  index:" + this.b);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        label587:
        j = localTag2.a();
        localTag1.b(localTag2.c() + j);
      }
    }
    label608:
    if (j < i)
    {
      localTag1 = (Tag)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localTag1.a() + localTag1.c() < 0)
      {
        localTag2 = localTag1.a();
        if (localTag2 != null) {
          break label696;
        }
        QLog.e("RaceLine horserace", 2, "leftBro is null " + j + "  index:" + this.b);
      }
    }
    for (;;)
    {
      j += 1;
      break label608;
      break;
      label696:
      paramInt = localTag2.a();
      localTag1.b(localTag2.c() + paramInt);
    }
  }
  
  public void a(Tag paramTag)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ((Tag)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a(paramTag);
      ((Tag)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).b(paramTag);
      paramTag.b((Tag)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      paramTag.a((Tag)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramTag);
      return;
      paramTag.a(paramTag);
      paramTag.b(paramTag);
    }
  }
  
  public void b()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Tag localTag1 = (Tag)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      int j = this.b;
      if (i == 0)
      {
        localTag1.b(a() + 0);
        localTag1.c(this.d * j + (j + 1) * this.e);
      }
      for (;;)
      {
        i += 1;
        break;
        Tag localTag2 = (Tag)this.jdField_a_of_type_JavaUtilArrayList.get(i - 1);
        int k = localTag2.a();
        localTag1.b(localTag2.c() + k);
        localTag1.c(this.d * j + (j + 1) * this.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.RaceLine
 * JD-Core Version:    0.7.0.1
 */