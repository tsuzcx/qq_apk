import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

class mah
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
  
  static mah a(Resources paramResources, mam parammam, mae parammae)
  {
    mah localmah = new mah();
    if (!TextUtils.isEmpty(parammam.a())) {
      localmah.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(parammam.a());
    }
    localmah.jdField_a_of_type_Int = parammae.d;
    localmah.jdField_b_of_type_Int = parammae.jdField_a_of_type_Int;
    localmah.jdField_c_of_type_Int = parammae.jdField_b_of_type_Int;
    localmah.d = parammae.jdField_c_of_type_Int;
    switch (parammam.a())
    {
    }
    do
    {
      return localmah;
      parammam = (mao)parammam;
      if ((parammam.a() instanceof BitmapDrawable)) {
        localmah.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)parammam.a()).getBitmap();
      }
      for (;;)
      {
        switch (parammam.k())
        {
        default: 
          return localmah;
        case 1: 
          localmah.jdField_a_of_type_Boolean = true;
          return localmah;
          parammae = parammam.b();
          if (!TextUtils.isEmpty(parammae)) {
            localmah.jdField_a_of_type_AndroidGraphicsBitmap = mqa.a(paramResources, parammae);
          }
          break;
        }
      }
      localmah.jdField_b_of_type_Boolean = true;
      return localmah;
      localmah.jdField_c_of_type_Boolean = ((map)parammam).b();
      return localmah;
      paramResources = (man)parammam;
      if (paramResources.h() != -1) {
        localmah.jdField_a_of_type_Int = paramResources.h();
      }
      if (paramResources.j() != -1) {
        localmah.jdField_c_of_type_Int = paramResources.j();
      }
      if (paramResources.i() != -1) {
        localmah.d = paramResources.i();
      }
    } while (localmah.jdField_a_of_type_AndroidTextSpannableString == null);
    int j = paramResources.f();
    if (paramResources.g() == -1) {}
    for (int i = parammam.a().length() + j;; i = paramResources.g() + j)
    {
      localmah.jdField_a_of_type_AndroidTextSpannableString.setSpan(new mai(paramResources), j, i, 33);
      paramResources = new ForegroundColorSpan(localmah.jdField_c_of_type_Int);
      localmah.jdField_a_of_type_AndroidTextSpannableString.setSpan(paramResources, j, i, 17);
      return localmah;
    }
  }
  
  static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView.setTag(2131378186, Integer.valueOf(paramInt2));
    paramTextView.setTag(2131378187, Integer.valueOf(paramInt1));
    paramTextView.setMovementMethod((ltr)ltr.a());
    paramTextView.setHighlightColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mah
 * JD-Core Version:    0.7.0.1
 */