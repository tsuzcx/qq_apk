package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import android.os.Build;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TagUtil
{
  public static int a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof Spannable)) {
      paramCharSequence = paramCharSequence.toString();
    } else {
      paramCharSequence = (String)paramCharSequence;
    }
    int j = 0;
    int i = 0;
    while (j < paramCharSequence.length())
    {
      int k = paramCharSequence.codePointAt(j);
      if ((k >= 32) && (k <= 126))
      {
        i += 1;
      }
      else if (k >= 65535)
      {
        i += 1;
        j += 1;
      }
      else
      {
        i += 2;
      }
      j += 1;
    }
    return i;
  }
  
  public static int a(Random paramRandom, int paramInt)
  {
    if (paramInt != -1)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return 0;
          }
          return a(paramRandom, 40, 48);
        }
        return a(paramRandom, 30, 40);
      }
      return a(paramRandom, 22, 30);
    }
    return a(paramRandom, 18, 24);
  }
  
  public static int a(Random paramRandom, int paramInt1, int paramInt2)
  {
    return paramRandom.nextInt(paramInt2 - paramInt1) + paramInt1;
  }
  
  private static void a(Tag paramTag)
  {
    boolean bool = a(paramTag.jdField_a_of_type_JavaLangCharSequence);
    if (((paramTag.jdField_b_of_type_Boolean) && (paramTag.jdField_a_of_type_JavaLangCharSequence.length() <= 5)) || (!bool))
    {
      paramTag.jdField_c_of_type_Int = 0;
      return;
    }
    paramTag.jdField_c_of_type_Int = 4;
  }
  
  public static void a(List<Tag> paramList, ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo, float paramFloat)
  {
    Object localObject2 = paramProfilePersonalityLabelInfo;
    if ((localObject2 != null) && (((ProfilePersonalityLabelInfo)localObject2).personalityLabelInfos != null))
    {
      if (((ProfilePersonalityLabelInfo)localObject2).personalityLabelInfos.size() <= 0) {
        return;
      }
      Object localObject1 = new ArrayList(paramProfilePersonalityLabelInfo.getSize());
      int i1 = 0;
      int i = 0;
      while (i < ((ProfilePersonalityLabelInfo)localObject2).personalityLabelInfos.size())
      {
        ((List)localObject1).add(new Pair(Long.valueOf(((PersonalityLabelInfo)((ProfilePersonalityLabelInfo)localObject2).personalityLabelInfos.get(i)).id), ((PersonalityLabelInfo)((ProfilePersonalityLabelInfo)localObject2).personalityLabelInfos.get(i)).text));
        i += 1;
      }
      Collections.sort((List)localObject1, new TagUtil.TextLengthComparator());
      int i5 = paramProfilePersonalityLabelInfo.getSize();
      boolean bool1 = TextUtils.isEmpty(paramProfilePersonalityLabelInfo.getLatestThumbUrl()) ^ true;
      long l1 = -1L;
      long l2;
      if (bool1) {
        l2 = ((PersonalityLabelInfo)((ProfilePersonalityLabelInfo)localObject2).personalityLabelInfos.get(0)).id;
      } else {
        l2 = -1L;
      }
      if (bool1)
      {
        if (paramProfilePersonalityLabelInfo.getSize() > 1) {
          l1 = ((PersonalityLabelInfo)((ProfilePersonalityLabelInfo)localObject2).personalityLabelInfos.get(1)).id;
        }
      }
      else {
        l1 = ((PersonalityLabelInfo)((ProfilePersonalityLabelInfo)localObject2).personalityLabelInfos.get(0)).id;
      }
      localObject2 = new Random();
      int i4 = 0;
      int n = 0;
      int k = 0;
      int i2 = 0;
      int m = 0;
      bool1 = i1;
      Tag localTag;
      while (i4 < ((List)localObject1).size())
      {
        Object localObject3 = paramProfilePersonalityLabelInfo.getLabelById(((Long)((Pair)((List)localObject1).get(i4)).first).longValue());
        if ((localObject3 == null) || (!TextUtils.isEmpty(((PersonalityLabelInfo)localObject3).text)))
        {
          String str = ((PersonalityLabelInfo)localObject3).text.trim();
          localTag = new Tag();
          localTag.jdField_a_of_type_JavaLangCharSequence = str;
          boolean bool3 = a(str);
          if (l2 == ((PersonalityLabelInfo)localObject3).id)
          {
            localTag.jdField_b_of_type_Int = ((PersonalityLabelInfo)localObject3).bgColor;
            localTag.jdField_e_of_type_Int = 2;
          }
          else if (l1 == ((PersonalityLabelInfo)localObject3).id)
          {
            localTag.d = true;
            localTag.jdField_a_of_type_AndroidTextTextPaint.setFakeBoldText(true);
          }
          localTag.jdField_a_of_type_Int = ((PersonalityLabelInfo)localObject3).fgColor;
          if (localTag.jdField_e_of_type_Int == 2) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          if ((!(str instanceof Spannable)) && (bool3) && ((!bool2) || (str.length() <= 4)) && ((bool2) || (str.length() <= 6)))
          {
            i3 = n;
          }
          else
          {
            localTag.jdField_b_of_type_Boolean = true;
            localTag.jdField_e_of_type_Boolean = true;
            i3 = n + 1;
          }
          n = i3;
          i1 = k;
          if (!localTag.jdField_e_of_type_Boolean)
          {
            if ((i5 > 1) && (k < 2) && (k != i5 - 1) && (str.length() <= 6)) {
              localTag.jdField_b_of_type_Boolean = ((Random)localObject2).nextBoolean();
            } else {
              localTag.jdField_b_of_type_Boolean = true;
            }
            if (!localTag.jdField_b_of_type_Boolean)
            {
              i1 = k + 1;
              n = i3;
            }
            else
            {
              n = i3 + 1;
              i1 = k;
            }
          }
          a(localTag);
          int i6 = a(str);
          if (bool2)
          {
            if (i6 > 6)
            {
              if (i6 > 8) {
                break label682;
              }
              break label676;
            }
          }
          else {
            if (i6 > 8) {
              break label669;
            }
          }
          k = 2;
          break label685;
          label669:
          if (i6 <= 12) {
            label676:
            k = 1;
          } else {
            label682:
            k = 0;
          }
          label685:
          int i3 = k;
          if (k == 2)
          {
            i3 = k;
            if (i2 >= 3) {
              i3 = 1;
            }
          }
          if (i5 <= 1) {
            i3 = 2;
          }
          k = i2;
          if (i3 == 2) {
            k = i2 + 1;
          }
          i2 = i3;
          if (i5 <= 3)
          {
            i2 = i3;
            if (i3 == 0)
            {
              i2 = i3;
              if (m < 2) {
                i2 = 1;
              }
            }
          }
          i3 = i2;
          if (m + k < 2)
          {
            i3 = i2;
            if (i2 == 0) {
              i3 = 1;
            }
          }
          i2 = -1;
          if (m >= 4) {
            if (m >= 6) {
              i3 = i2;
            } else if (i6 >= 10) {
              i3 = i2;
            } else if ((i6 >= 8) && (((Random)localObject2).nextBoolean())) {
              i3 = i2;
            }
          }
          i2 = m;
          if (i3 > 0) {
            i2 = m + 1;
          }
          m = a((Random)localObject2, i3);
          if ((i5 <= 3) && (i6 < 8) && (bool1 < true)) {
            m = 48;
          }
          boolean bool2 = bool1;
          bool1 = bool2;
          if (m == 48) {
            j = bool2 + true;
          }
          localTag.jdField_a_of_type_Float = (m * paramFloat);
          localTag.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localTag.jdField_a_of_type_Float);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getTags ");
            ((StringBuilder)localObject3).append(localTag.jdField_a_of_type_JavaLangCharSequence);
            ((StringBuilder)localObject3).append(" sizeLevel:");
            ((StringBuilder)localObject3).append(i3);
            ((StringBuilder)localObject3).append(" size:");
            ((StringBuilder)localObject3).append(localTag.jdField_a_of_type_Float / paramFloat);
            QLog.i("TagUtil", 2, ((StringBuilder)localObject3).toString());
          }
          paramList.add(localTag);
          m = i2;
          i2 = k;
          k = i1;
        }
        i4 += 1;
      }
      paramProfilePersonalityLabelInfo = (ProfilePersonalityLabelInfo)localObject1;
      if (n == 0)
      {
        localObject1 = (Tag)paramList.get(0);
        ((Tag)localObject1).jdField_b_of_type_Boolean = true;
        a((Tag)localObject1);
      }
      int j = k;
      if (k == 0)
      {
        j = k;
        if (i5 > 1)
        {
          m = 0;
          for (;;)
          {
            j = k;
            if (m >= paramList.size()) {
              break;
            }
            localObject1 = (Tag)paramList.get(m);
            if ((!((Tag)localObject1).jdField_e_of_type_Boolean) && (((Tag)localObject1).jdField_a_of_type_JavaLangCharSequence.length() <= 4))
            {
              ((Tag)localObject1).jdField_b_of_type_Boolean = false;
              if (!a(((Tag)localObject1).jdField_a_of_type_JavaLangCharSequence)) {
                ((Tag)localObject1).jdField_c_of_type_Int = 0;
              } else {
                ((Tag)localObject1).jdField_c_of_type_Int = 4;
              }
              j = k + 1;
              break;
            }
            m += 1;
          }
        }
      }
      if (j <= 1)
      {
        m = 0;
        k = j;
        j = m;
        while (j < i5)
        {
          localObject1 = (Tag)paramList.get(j);
          localObject2 = (String)((Pair)paramProfilePersonalityLabelInfo.get(j)).second;
          if ((((Tag)localObject1).jdField_b_of_type_Boolean) && (a((String)localObject2)))
          {
            localTag = new Tag();
            localTag.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject2);
            localTag.jdField_c_of_type_Boolean = true;
            localTag.jdField_b_of_type_Boolean = false;
            localTag.jdField_a_of_type_Float = ((Tag)localObject1).jdField_a_of_type_Float;
            localTag.jdField_a_of_type_AndroidTextTextPaint.setTextSize(((Tag)localObject1).jdField_a_of_type_Float);
            paramList.add(localTag);
            m = k + 1;
            k = m;
            if (m >= 2) {
              return;
            }
          }
          j += 1;
        }
      }
    }
  }
  
  public static boolean a()
  {
    return Build.MODEL.contains("vivo X6D");
  }
  
  public static boolean a(CharSequence paramCharSequence)
  {
    String str = paramCharSequence.toString();
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("text:");
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      int j = str.codePointAt(i);
      if ((j >= 19968) && (j <= 40959))
      {
        i += 1;
      }
      else
      {
        localStringBuilder.append("index:");
        localStringBuilder.append(i);
        localStringBuilder.append(" unicode:");
        localStringBuilder.append(j);
        return false;
      }
    }
    return true;
  }
  
  private static boolean a(String paramString)
  {
    return a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagUtil
 * JD-Core Version:    0.7.0.1
 */