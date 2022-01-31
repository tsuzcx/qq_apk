import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

class lpy
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
  
  static lpy a(Resources paramResources, lqd paramlqd, lpv paramlpv)
  {
    lpy locallpy = new lpy();
    if (!TextUtils.isEmpty(paramlqd.a())) {
      locallpy.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(paramlqd.a());
    }
    locallpy.jdField_a_of_type_Int = paramlpv.d;
    locallpy.jdField_b_of_type_Int = paramlpv.jdField_a_of_type_Int;
    locallpy.jdField_c_of_type_Int = paramlpv.jdField_b_of_type_Int;
    locallpy.d = paramlpv.jdField_c_of_type_Int;
    switch (paramlqd.a())
    {
    }
    do
    {
      return locallpy;
      paramlqd = (lqf)paramlqd;
      if ((paramlqd.a() instanceof BitmapDrawable)) {
        locallpy.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)paramlqd.a()).getBitmap();
      }
      for (;;)
      {
        switch (paramlqd.k())
        {
        default: 
          return locallpy;
        case 1: 
          locallpy.jdField_a_of_type_Boolean = true;
          return locallpy;
          paramlpv = paramlqd.b();
          if (!TextUtils.isEmpty(paramlpv)) {
            locallpy.jdField_a_of_type_AndroidGraphicsBitmap = mez.a(paramResources, paramlpv);
          }
          break;
        }
      }
      locallpy.jdField_b_of_type_Boolean = true;
      return locallpy;
      locallpy.jdField_c_of_type_Boolean = ((lqg)paramlqd).b();
      return locallpy;
      paramResources = (lqe)paramlqd;
      if (paramResources.h() != -1) {
        locallpy.jdField_a_of_type_Int = paramResources.h();
      }
      if (paramResources.j() != -1) {
        locallpy.jdField_c_of_type_Int = paramResources.j();
      }
      if (paramResources.i() != -1) {
        locallpy.d = paramResources.i();
      }
    } while (locallpy.jdField_a_of_type_AndroidTextSpannableString == null);
    int j = paramResources.f();
    if (paramResources.g() == -1) {}
    for (int i = paramlqd.a().length() + j;; i = paramResources.g() + j)
    {
      locallpy.jdField_a_of_type_AndroidTextSpannableString.setSpan(new lpz(paramResources), j, i, 33);
      paramResources = new ForegroundColorSpan(locallpy.jdField_c_of_type_Int);
      locallpy.jdField_a_of_type_AndroidTextSpannableString.setSpan(paramResources, j, i, 17);
      return locallpy;
    }
  }
  
  static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView.setTag(2131311054, Integer.valueOf(paramInt2));
    paramTextView.setTag(2131311055, Integer.valueOf(paramInt1));
    paramTextView.setMovementMethod((ljs)ljs.a());
    paramTextView.setHighlightColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpy
 * JD-Core Version:    0.7.0.1
 */