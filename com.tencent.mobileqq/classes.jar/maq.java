import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

class maq
{
  int jdField_a_of_type_Int = -1;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  SpannableString jdField_a_of_type_AndroidTextSpannableString = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = -1;
  boolean jdField_c_of_type_Boolean = false;
  int d = -1;
  
  static maq a(Resources paramResources, mav parammav, man paramman)
  {
    maq localmaq = new maq();
    if (!TextUtils.isEmpty(parammav.a())) {
      localmaq.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(parammav.a());
    }
    localmaq.jdField_a_of_type_Int = paramman.d;
    localmaq.jdField_b_of_type_Int = paramman.jdField_a_of_type_Int;
    localmaq.jdField_c_of_type_Int = paramman.jdField_b_of_type_Int;
    localmaq.d = paramman.jdField_c_of_type_Int;
    switch (parammav.a())
    {
    }
    do
    {
      return localmaq;
      parammav = (max)parammav;
      if ((parammav.a() instanceof BitmapDrawable)) {
        localmaq.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)parammav.a()).getBitmap();
      }
      for (;;)
      {
        switch (parammav.k())
        {
        default: 
          return localmaq;
        case 1: 
          localmaq.jdField_a_of_type_Boolean = true;
          return localmaq;
          paramman = parammav.b();
          if (!TextUtils.isEmpty(paramman)) {
            localmaq.jdField_a_of_type_AndroidGraphicsBitmap = mpy.a(paramResources, paramman);
          }
          break;
        }
      }
      localmaq.jdField_b_of_type_Boolean = true;
      return localmaq;
      localmaq.jdField_c_of_type_Boolean = ((may)parammav).b();
      return localmaq;
      paramResources = (maw)parammav;
      if (paramResources.h() != -1) {
        localmaq.jdField_a_of_type_Int = paramResources.h();
      }
      if (paramResources.j() != -1) {
        localmaq.jdField_c_of_type_Int = paramResources.j();
      }
      if (paramResources.i() != -1) {
        localmaq.d = paramResources.i();
      }
    } while (localmaq.jdField_a_of_type_AndroidTextSpannableString == null);
    int j = paramResources.f();
    if (paramResources.g() == -1) {}
    for (int i = parammav.a().length() + j;; i = paramResources.g() + j)
    {
      localmaq.jdField_a_of_type_AndroidTextSpannableString.setSpan(new mar(paramResources), j, i, 33);
      paramResources = new ForegroundColorSpan(localmaq.jdField_c_of_type_Int);
      localmaq.jdField_a_of_type_AndroidTextSpannableString.setSpan(paramResources, j, i, 17);
      return localmaq;
    }
  }
  
  static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView.setTag(2131376863, Integer.valueOf(paramInt2));
    paramTextView.setTag(2131376864, Integer.valueOf(paramInt1));
    paramTextView.setMovementMethod((luj)luj.a());
    paramTextView.setHighlightColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     maq
 * JD-Core Version:    0.7.0.1
 */