package com.tencent.mobileqq.troop.enterEffect;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.surfaceviewaction.ISprite;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.IImageBitmapHandle;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ImageUtil;

class TroopEnterEffectController$3$3
  implements SceneBuilder.IImageBitmapHandle
{
  TroopEnterEffectController$3$3(TroopEnterEffectController.3 param3, QQAppInterface paramQQAppInterface) {}
  
  public Bitmap a(ISprite paramISprite, String paramString1, String paramString2)
  {
    if (paramString2.equals("$AVATAR$"))
    {
      paramString1 = FaceDrawable.getDefaultDrawable(1, 3);
      paramISprite = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$3.a.jdField_a_of_type_JavaLangString, 3, paramString1, paramString1, new TroopEnterEffectController.3.3.1(this, paramISprite));
    }
    try
    {
      paramISprite = TroopUtils.a(paramISprite);
      return paramISprite;
    }
    catch (OutOfMemoryError paramISprite) {}
    if (paramString2.equals("$SVIP$"))
    {
      paramISprite = new StringBuilder();
      paramISprite.append(TroopEnterEffectController.jdField_a_of_type_JavaLangString);
      paramISprite.append(this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$3.a.jdField_a_of_type_Int);
      paramString1 = TroopEnterEffectController.a(paramISprite.toString(), this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$3.a);
      paramISprite = paramString1;
      if (paramString1 == null) {
        paramISprite = TroopEnterEffectController.a(TroopEnterEffectController.b(), this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$3.a);
      }
      paramString1 = paramISprite;
      if (paramISprite == null) {
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      }
    }
    else
    {
      paramISprite = new StringBuilder();
      paramISprite.append(paramString1);
      paramISprite.append("/");
      paramISprite.append(paramString2);
      paramString1 = ImageUtil.a(paramISprite.toString(), null);
    }
    return paramString1;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3.3
 * JD-Core Version:    0.7.0.1
 */