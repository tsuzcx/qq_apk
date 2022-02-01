package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.doodle.DoodleItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DefaultClassifier
  extends LiteClassifier
{
  private StringBuilder a;
  
  public DefaultClassifier(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    if (localStringBuilder == null) {
      return "";
    }
    return localStringBuilder.toString();
  }
  
  public boolean a(DoodleItem paramDoodleItem, String paramString, float paramFloat1, int paramInt, float paramFloat2)
  {
    if (paramDoodleItem != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramDoodleItem = DrawImageUtil.a(paramDoodleItem, 28, 28, paramFloat2);
      Object localObject1 = a(paramDoodleItem);
      DrawImageUtil.a(paramDoodleItem);
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = a((float[][][][])localObject1);
      paramDoodleItem = new HashSet();
      localObject1 = new LinkedList();
      paramFloat2 = Math.min(0.01F, paramFloat1);
      if (localObject2 != null)
      {
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          if ((localObject2.length > paramInt) && (localObject2[paramInt] > paramFloat2))
          {
            ((List)localObject1).add(new DefaultClassifier.ClassItem((String)this.jdField_a_of_type_JavaUtilList.get(paramInt), localObject2[paramInt]));
            if ((localObject2[paramInt] > paramFloat1) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
              paramDoodleItem.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
            }
          }
          paramInt += 1;
        }
      }
      Collections.sort((List)localObject1, new DefaultClassifier.1(this));
      localObject2 = new StringBuilder();
      paramInt = 0;
      while ((paramInt < 20) && (paramInt < ((List)localObject1).size()))
      {
        DefaultClassifier.ClassItem localClassItem = (DefaultClassifier.ClassItem)((List)localObject1).get(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localClassItem.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(":");
        localStringBuilder.append(localClassItem.jdField_a_of_type_Float);
        localStringBuilder.append("\n");
        ((StringBuilder)localObject2).append(localStringBuilder.toString());
        paramInt += 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder = ((StringBuilder)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("recog result:");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
        QLog.d("DrawClassifier.DefaultClassifier", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramDoodleItem.contains(paramString))
      {
        if (QLog.isColorLevel())
        {
          paramDoodleItem = new StringBuilder();
          paramDoodleItem.append("recognition succ:");
          paramDoodleItem.append(paramString);
          QLog.d("DrawClassifier.DefaultClassifier", 2, paramDoodleItem.toString());
        }
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramDoodleItem = new StringBuilder();
        paramDoodleItem.append("recognition failed:");
        paramDoodleItem.append(paramString);
        QLog.d("DrawClassifier.DefaultClassifier", 2, paramDoodleItem.toString());
      }
    }
    return false;
  }
  
  public float[][][][] a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return (float[][][][])null;
    }
    float[][][][] arrayOfFloat = (float[][][][])Array.newInstance(Float.TYPE, new int[] { 1, 28, 28, 1 });
    int[] arrayOfInt1 = new int[784];
    float[] arrayOfFloat1 = new float[arrayOfInt1.length];
    int[] arrayOfInt2 = new int[784];
    paramBitmap.getPixels(arrayOfInt2, 0, paramBitmap.getWidth(), 0, 0, 28, 28);
    int i = 0;
    while (i < arrayOfInt1.length)
    {
      arrayOfInt1[i] = 255;
      i += 1;
    }
    i = 0;
    while (i < arrayOfInt2.length)
    {
      arrayOfInt2[i] &= 0xFF;
      i += 1;
    }
    i = 0;
    while (i < arrayOfInt1.length)
    {
      arrayOfFloat1[i] = (1.0F - arrayOfInt1[i] / 255.0F);
      i += 1;
    }
    int m = arrayOfFloat1.length;
    i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (arrayOfFloat1[i] != 0.0F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j < 40) {
      return (float[][][][])null;
    }
    i = 0;
    while (i < arrayOfFloat[0].length)
    {
      j = 0;
      while (j < arrayOfFloat[0][i].length)
      {
        arrayOfFloat[0][i][j][0] = arrayOfFloat1[(i * 28 + j)];
        j += 1;
      }
      i += 1;
    }
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DefaultClassifier
 * JD-Core Version:    0.7.0.1
 */