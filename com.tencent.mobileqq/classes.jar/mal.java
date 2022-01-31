import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

class mal
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
  
  static mal a(Resources paramResources, maq parammaq, mai parammai)
  {
    mal localmal = new mal();
    if (!TextUtils.isEmpty(parammaq.a())) {
      localmal.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(parammaq.a());
    }
    localmal.jdField_a_of_type_Int = parammai.d;
    localmal.jdField_b_of_type_Int = parammai.jdField_a_of_type_Int;
    localmal.jdField_c_of_type_Int = parammai.jdField_b_of_type_Int;
    localmal.d = parammai.jdField_c_of_type_Int;
    switch (parammaq.a())
    {
    }
    do
    {
      return localmal;
      parammaq = (mas)parammaq;
      if ((parammaq.a() instanceof BitmapDrawable)) {
        localmal.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)parammaq.a()).getBitmap();
      }
      for (;;)
      {
        switch (parammaq.k())
        {
        default: 
          return localmal;
        case 1: 
          localmal.jdField_a_of_type_Boolean = true;
          return localmal;
          parammai = parammaq.b();
          if (!TextUtils.isEmpty(parammai)) {
            localmal.jdField_a_of_type_AndroidGraphicsBitmap = mpv.a(paramResources, parammai);
          }
          break;
        }
      }
      localmal.jdField_b_of_type_Boolean = true;
      return localmal;
      localmal.jdField_c_of_type_Boolean = ((mat)parammaq).b();
      return localmal;
      paramResources = (mar)parammaq;
      if (paramResources.h() != -1) {
        localmal.jdField_a_of_type_Int = paramResources.h();
      }
      if (paramResources.j() != -1) {
        localmal.jdField_c_of_type_Int = paramResources.j();
      }
      if (paramResources.i() != -1) {
        localmal.d = paramResources.i();
      }
    } while (localmal.jdField_a_of_type_AndroidTextSpannableString == null);
    int j = paramResources.f();
    if (paramResources.g() == -1) {}
    for (int i = parammaq.a().length() + j;; i = paramResources.g() + j)
    {
      localmal.jdField_a_of_type_AndroidTextSpannableString.setSpan(new mam(paramResources), j, i, 33);
      paramResources = new ForegroundColorSpan(localmal.jdField_c_of_type_Int);
      localmal.jdField_a_of_type_AndroidTextSpannableString.setSpan(paramResources, j, i, 17);
      return localmal;
    }
  }
  
  static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView.setTag(2131376865, Integer.valueOf(paramInt2));
    paramTextView.setTag(2131376866, Integer.valueOf(paramInt1));
    paramTextView.setMovementMethod((lue)lue.a());
    paramTextView.setHighlightColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mal
 * JD-Core Version:    0.7.0.1
 */