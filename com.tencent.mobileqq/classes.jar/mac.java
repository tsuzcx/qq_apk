import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

class mac
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
  
  static mac a(Resources paramResources, mah parammah, lzz paramlzz)
  {
    mac localmac = new mac();
    if (!TextUtils.isEmpty(parammah.a())) {
      localmac.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(parammah.a());
    }
    localmac.jdField_a_of_type_Int = paramlzz.d;
    localmac.jdField_b_of_type_Int = paramlzz.jdField_a_of_type_Int;
    localmac.jdField_c_of_type_Int = paramlzz.jdField_b_of_type_Int;
    localmac.d = paramlzz.jdField_c_of_type_Int;
    switch (parammah.a())
    {
    }
    do
    {
      return localmac;
      parammah = (maj)parammah;
      if ((parammah.a() instanceof BitmapDrawable)) {
        localmac.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)parammah.a()).getBitmap();
      }
      for (;;)
      {
        switch (parammah.k())
        {
        default: 
          return localmac;
        case 1: 
          localmac.jdField_a_of_type_Boolean = true;
          return localmac;
          paramlzz = parammah.b();
          if (!TextUtils.isEmpty(paramlzz)) {
            localmac.jdField_a_of_type_AndroidGraphicsBitmap = mpu.a(paramResources, paramlzz);
          }
          break;
        }
      }
      localmac.jdField_b_of_type_Boolean = true;
      return localmac;
      localmac.jdField_c_of_type_Boolean = ((mak)parammah).b();
      return localmac;
      paramResources = (mai)parammah;
      if (paramResources.h() != -1) {
        localmac.jdField_a_of_type_Int = paramResources.h();
      }
      if (paramResources.j() != -1) {
        localmac.jdField_c_of_type_Int = paramResources.j();
      }
      if (paramResources.i() != -1) {
        localmac.d = paramResources.i();
      }
    } while (localmac.jdField_a_of_type_AndroidTextSpannableString == null);
    int j = paramResources.f();
    if (paramResources.g() == -1) {}
    for (int i = parammah.a().length() + j;; i = paramResources.g() + j)
    {
      localmac.jdField_a_of_type_AndroidTextSpannableString.setSpan(new mad(paramResources), j, i, 33);
      paramResources = new ForegroundColorSpan(localmac.jdField_c_of_type_Int);
      localmac.jdField_a_of_type_AndroidTextSpannableString.setSpan(paramResources, j, i, 17);
      return localmac;
    }
  }
  
  static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView.setTag(2131378262, Integer.valueOf(paramInt2));
    paramTextView.setTag(2131378263, Integer.valueOf(paramInt1));
    paramTextView.setMovementMethod((ltn)ltn.a());
    paramTextView.setHighlightColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mac
 * JD-Core Version:    0.7.0.1
 */