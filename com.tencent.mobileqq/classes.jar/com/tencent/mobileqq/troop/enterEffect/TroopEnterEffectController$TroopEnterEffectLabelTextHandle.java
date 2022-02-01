package com.tencent.mobileqq.troop.enterEffect;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.ISprite;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.ILabelTextHandle;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.ColorSpan;
import com.tencent.mobileqq.widget.ColorClearableEditText.Paragraph;
import com.tencent.mobileqq.widget.ColorClearableEditText.SpanComparator;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class TroopEnterEffectController$TroopEnterEffectLabelTextHandle
  implements SceneBuilder.ILabelTextHandle
{
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopEnterEffectData jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectData;
  private ColorClearableEditText.SpanComparator jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$SpanComparator = new ColorClearableEditText.SpanComparator();
  List<ColorClearableEditText.Paragraph> jdField_a_of_type_JavaUtilList;
  
  public TroopEnterEffectController$TroopEnterEffectLabelTextHandle(TroopEnterEffectController paramTroopEnterEffectController, QQAppInterface paramQQAppInterface, TroopEnterEffectData paramTroopEnterEffectData)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectData = paramTroopEnterEffectData;
  }
  
  private void a(List<ColorClearableEditText.Paragraph> paramList, Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, int paramInt1, int paramInt2)
  {
    Object localObject = (ColorClearableEditText.Paragraph)paramList.get(0);
    if (((ColorClearableEditText.Paragraph)localObject).c == 3)
    {
      localObject = (ColorSpan)((ColorClearableEditText.Paragraph)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
      if (((ColorSpan)localObject).a == 2)
      {
        paramPaint.setColor(((ColorSpan)localObject).b);
      }
      else if (((ColorSpan)localObject).a == 3)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime instanceof QQAppInterface)) {
          paramPaint.setShader(ColorNickManager.a((QQAppInterface)localAppRuntime).a(((ColorSpan)localObject).b, paramList, paramFloat1, paramFloat2, paramRect, paramPaint, paramInt1, paramInt2));
        }
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramRect = (ColorClearableEditText.Paragraph)paramList.next();
      paramInt1 = paramRect.c;
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          for (;;)
          {
            paramRect = (EmoticonSpan)paramRect.jdField_a_of_type_AndroidTextStyleCharacterStyle;
            paramInt2 = paramRect.getDrawable().getBounds().height();
            paramInt1 = (int)paramFloat2;
            paramInt2 = (int)(paramInt2 + paramFloat2);
            paramRect.draw(paramCanvas, "", 0, 0, paramFloat1, paramInt1, paramInt2, paramInt2, paramPaint);
            paramFloat1 += paramRect.getDrawable().getBounds().width();
          }
        }
      }
      else
      {
        paramCanvas.drawText(paramRect.jdField_a_of_type_JavaLangString, paramFloat1, paramFloat2 + paramFloat3, paramPaint);
        paramFloat1 += paramPaint.measureText(paramRect.jdField_a_of_type_JavaLangString);
      }
    }
    paramPaint.setShader(null);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString, Paint paramPaint)
  {
    return ColorNickManager.a(this.jdField_a_of_type_JavaUtilList, paramPaint, this.jdField_a_of_type_AndroidGraphicsRect);
  }
  
  public String a(ISprite paramISprite, String paramString)
  {
    return paramString.replace("$NICK$", ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectData.b, 1, 0));
  }
  
  public void a(int paramInt, String paramString, Paint paramPaint)
  {
    this.jdField_a_of_type_JavaUtilList = ColorNickManager.a(paramInt, paramString, paramPaint, this.jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$SpanComparator, 32);
  }
  
  public boolean a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Paint paramPaint)
  {
    a(this.jdField_a_of_type_JavaUtilList, paramCanvas, paramPaint, paramFloat1, paramFloat2, paramFloat3, this.jdField_a_of_type_AndroidGraphicsRect, paramInt1, paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectLabelTextHandle
 * JD-Core Version:    0.7.0.1
 */