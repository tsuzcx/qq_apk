package com.tencent.mobileqq.lyric.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import java.util.ArrayList;

public class SentenceUI
{
  public final int a;
  public SentenceAttachInfo a;
  public final String a;
  public final ArrayList<Character> a;
  public final int b;
  public SentenceAttachInfo b;
  public final int c;
  private final int d;
  
  public SentenceUI(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<Character> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo = new SentenceAttachInfo();
    this.jdField_b_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo = new SentenceAttachInfo();
    this.jdField_a_of_type_Int = paramInt1;
    this.d = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.c = paramInt4;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public SentenceUI(String paramString, int paramInt1, int paramInt2, ArrayList<Character> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo = new SentenceAttachInfo();
    this.jdField_b_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo = new SentenceAttachInfo();
    this.jdField_a_of_type_Int = paramInt1;
    this.d = paramInt2;
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public long a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return ((Character)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2)
  {
    a(paramCanvas, paramInt1, paramInt2, paramPaint1, paramPaint2, null, null, 1);
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt3)
  {
    paramInt1 += this.jdField_a_of_type_Int;
    paramBitmap1 = this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo;
    if ((paramBitmap1 != null) && (paramBitmap1.a != null) && (!this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo.a.isRecycled()))
    {
      paramBitmap1 = new Rect(paramInt1 - this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo.c - this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo.a.getWidth(), (int)(paramInt2 - paramPaint1.getTextSize()), paramInt1 - this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo.c, (int)(this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo.a.getHeight() + paramInt2 - paramPaint1.getTextSize()));
      paramCanvas.drawBitmap(this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceAttachInfo.a, null, paramBitmap1, null);
    }
    paramBitmap1 = this.jdField_a_of_type_JavaLangString;
    float f1 = paramInt1 - paramInt3;
    float f4 = paramInt2 - paramInt3;
    paramCanvas.drawText(paramBitmap1, f1, f4, paramPaint2);
    paramBitmap1 = this.jdField_a_of_type_JavaLangString;
    float f2 = paramInt1;
    paramCanvas.drawText(paramBitmap1, f2, f4, paramPaint2);
    paramBitmap1 = this.jdField_a_of_type_JavaLangString;
    float f3 = paramInt1 + paramInt3;
    paramCanvas.drawText(paramBitmap1, f3, f4, paramPaint2);
    paramBitmap1 = this.jdField_a_of_type_JavaLangString;
    f4 = paramInt2;
    paramCanvas.drawText(paramBitmap1, f3, f4, paramPaint2);
    paramBitmap1 = this.jdField_a_of_type_JavaLangString;
    float f5 = paramInt2 + paramInt3;
    paramCanvas.drawText(paramBitmap1, f3, f5, paramPaint2);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, f2, f5, paramPaint2);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, f1, f5, paramPaint2);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, f1, f4, paramPaint2);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, f2, f4, paramPaint1);
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, Paint paramPaint3, int paramInt3, float paramFloat1, float paramFloat2, int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    int i = this.d;
    paramFloat2 += i;
    float f = paramInt2;
    paramFloat1 = paramFloat2 + paramFloat1;
    paramPaint3.setShader(new LinearGradient(paramFloat2, f, paramFloat1, f, paramArrayOfInt, paramArrayOfFloat, Shader.TileMode.CLAMP));
    if (paramInt3 > 0)
    {
      paramArrayOfInt = (Character)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt3 - 1);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString.substring(0, paramArrayOfInt.jdField_b_of_type_Int), paramInt1 + i, f, paramPaint2);
    }
    paramPaint2 = (Character)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt3);
    if (paramInt3 == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      paramPaint2 = this.jdField_a_of_type_JavaLangString.substring(paramPaint2.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString.length());
    } else {
      paramPaint2 = this.jdField_a_of_type_JavaLangString.substring(paramPaint2.jdField_a_of_type_Int, paramPaint2.jdField_b_of_type_Int);
    }
    paramCanvas.drawText(paramPaint2, paramFloat2, f, paramPaint3);
    if (paramInt3 < this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
    {
      paramPaint2 = (Character)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt3 + 1);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString.substring(paramPaint2.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString.length()), paramFloat1, f, paramPaint1);
    }
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = this.d;
    } else {
      i = this.jdField_a_of_type_Int;
    }
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1 + i, paramInt2, paramPaint);
  }
  
  public long b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      localObject = (Character)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      return ((Character)localObject).jdField_a_of_type_Long + ((Character)localObject).jdField_b_of_type_Long;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.data.SentenceUI
 * JD-Core Version:    0.7.0.1
 */