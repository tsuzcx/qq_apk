import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

class may
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
  
  static may a(Resources paramResources, mbd parammbd, mav parammav)
  {
    may localmay = new may();
    if (!TextUtils.isEmpty(parammbd.a())) {
      localmay.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(parammbd.a());
    }
    localmay.jdField_a_of_type_Int = parammav.d;
    localmay.jdField_b_of_type_Int = parammav.jdField_a_of_type_Int;
    localmay.jdField_c_of_type_Int = parammav.jdField_b_of_type_Int;
    localmay.d = parammav.jdField_c_of_type_Int;
    switch (parammbd.a())
    {
    }
    do
    {
      return localmay;
      parammbd = (mbf)parammbd;
      if ((parammbd.a() instanceof BitmapDrawable)) {
        localmay.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)parammbd.a()).getBitmap();
      }
      for (;;)
      {
        switch (parammbd.k())
        {
        default: 
          return localmay;
        case 1: 
          localmay.jdField_a_of_type_Boolean = true;
          return localmay;
          parammav = parammbd.b();
          if (!TextUtils.isEmpty(parammav)) {
            localmay.jdField_a_of_type_AndroidGraphicsBitmap = mqr.a(paramResources, parammav);
          }
          break;
        }
      }
      localmay.jdField_b_of_type_Boolean = true;
      return localmay;
      localmay.jdField_c_of_type_Boolean = ((mbg)parammbd).b();
      return localmay;
      paramResources = (mbe)parammbd;
      if (paramResources.h() != -1) {
        localmay.jdField_a_of_type_Int = paramResources.h();
      }
      if (paramResources.j() != -1) {
        localmay.jdField_c_of_type_Int = paramResources.j();
      }
      if (paramResources.i() != -1) {
        localmay.d = paramResources.i();
      }
    } while (localmay.jdField_a_of_type_AndroidTextSpannableString == null);
    int j = paramResources.f();
    if (paramResources.g() == -1) {}
    for (int i = parammbd.a().length() + j;; i = paramResources.g() + j)
    {
      localmay.jdField_a_of_type_AndroidTextSpannableString.setSpan(new maz(paramResources), j, i, 33);
      paramResources = new ForegroundColorSpan(localmay.jdField_c_of_type_Int);
      localmay.jdField_a_of_type_AndroidTextSpannableString.setSpan(paramResources, j, i, 17);
      return localmay;
    }
  }
  
  static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView.setTag(2131378419, Integer.valueOf(paramInt2));
    paramTextView.setTag(2131378420, Integer.valueOf(paramInt1));
    paramTextView.setMovementMethod((luj)luj.a());
    paramTextView.setHighlightColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     may
 * JD-Core Version:    0.7.0.1
 */