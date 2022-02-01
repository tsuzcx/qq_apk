package com.tencent.mobileqq.hiboom;

import android.graphics.Bitmap;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETFont;
import java.lang.ref.WeakReference;

class HiBoomTextView$EmoticonHolder
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont = null;
  private String jdField_a_of_type_JavaLangString = null;
  private WeakReference<HiBoomTextView> jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  
  static EmoticonHolder a(HiBoomTextView paramHiBoomTextView)
  {
    EmoticonHolder localEmoticonHolder = null;
    if (paramHiBoomTextView != null)
    {
      localEmoticonHolder = new EmoticonHolder();
      localEmoticonHolder.jdField_a_of_type_Long = HiBoomTextView.a(paramHiBoomTextView);
      localEmoticonHolder.jdField_a_of_type_JavaLangString = HiBoomTextView.a(paramHiBoomTextView);
      localEmoticonHolder.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, null, 0.0F);
      localEmoticonHolder.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(HiBoomTextView.a(paramHiBoomTextView));
      localEmoticonHolder.jdField_a_of_type_AndroidGraphicsBitmap = paramHiBoomTextView.a.a();
      localEmoticonHolder.jdField_a_of_type_Int = HiBoomTextView.a(paramHiBoomTextView);
      localEmoticonHolder.jdField_b_of_type_Int = HiBoomTextView.a(paramHiBoomTextView).currentFrameIndex();
      localEmoticonHolder.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHiBoomTextView);
      localEmoticonHolder.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    return localEmoticonHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.EmoticonHolder
 * JD-Core Version:    0.7.0.1
 */