import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

class mda
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
  
  static mda a(Resources paramResources, mdf parammdf, mcx parammcx)
  {
    mda localmda = new mda();
    if (!TextUtils.isEmpty(parammdf.a())) {
      localmda.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(parammdf.a());
    }
    localmda.jdField_a_of_type_Int = parammcx.d;
    localmda.jdField_b_of_type_Int = parammcx.jdField_a_of_type_Int;
    localmda.jdField_c_of_type_Int = parammcx.jdField_b_of_type_Int;
    localmda.d = parammcx.jdField_c_of_type_Int;
    switch (parammdf.a())
    {
    }
    do
    {
      return localmda;
      parammdf = (mdh)parammdf;
      if ((parammdf.a() instanceof BitmapDrawable)) {
        localmda.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)parammdf.a()).getBitmap();
      }
      for (;;)
      {
        switch (parammdf.k())
        {
        default: 
          return localmda;
        case 1: 
          localmda.jdField_a_of_type_Boolean = true;
          return localmda;
          parammcx = parammdf.b();
          if (!TextUtils.isEmpty(parammcx)) {
            localmda.jdField_a_of_type_AndroidGraphicsBitmap = msp.a(paramResources, parammcx);
          }
          break;
        }
      }
      localmda.jdField_b_of_type_Boolean = true;
      return localmda;
      localmda.jdField_c_of_type_Boolean = ((mdi)parammdf).b();
      return localmda;
      paramResources = (mdg)parammdf;
      if (paramResources.h() != -1) {
        localmda.jdField_a_of_type_Int = paramResources.h();
      }
      if (paramResources.j() != -1) {
        localmda.jdField_c_of_type_Int = paramResources.j();
      }
      if (paramResources.i() != -1) {
        localmda.d = paramResources.i();
      }
    } while (localmda.jdField_a_of_type_AndroidTextSpannableString == null);
    int j = paramResources.f();
    if (paramResources.g() == -1) {}
    for (int i = parammdf.a().length() + j;; i = paramResources.g() + j)
    {
      localmda.jdField_a_of_type_AndroidTextSpannableString.setSpan(new mdb(paramResources), j, i, 33);
      paramResources = new ForegroundColorSpan(localmda.jdField_c_of_type_Int);
      localmda.jdField_a_of_type_AndroidTextSpannableString.setSpan(paramResources, j, i, 17);
      return localmda;
    }
  }
  
  static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView.setTag(2131377433, Integer.valueOf(paramInt2));
    paramTextView.setTag(2131377434, Integer.valueOf(paramInt1));
    paramTextView.setMovementMethod((lwl)lwl.a());
    paramTextView.setHighlightColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mda
 * JD-Core Version:    0.7.0.1
 */