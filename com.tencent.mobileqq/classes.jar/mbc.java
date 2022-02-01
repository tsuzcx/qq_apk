import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

class mbc
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
  
  static mbc a(Resources paramResources, mbh parammbh, maz parammaz)
  {
    mbc localmbc = new mbc();
    if (!TextUtils.isEmpty(parammbh.a())) {
      localmbc.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(parammbh.a());
    }
    localmbc.jdField_a_of_type_Int = parammaz.d;
    localmbc.jdField_b_of_type_Int = parammaz.jdField_a_of_type_Int;
    localmbc.jdField_c_of_type_Int = parammaz.jdField_b_of_type_Int;
    localmbc.d = parammaz.jdField_c_of_type_Int;
    switch (parammbh.a())
    {
    }
    do
    {
      return localmbc;
      parammbh = (mbj)parammbh;
      if ((parammbh.a() instanceof BitmapDrawable)) {
        localmbc.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)parammbh.a()).getBitmap();
      }
      for (;;)
      {
        switch (parammbh.k())
        {
        default: 
          return localmbc;
        case 1: 
          localmbc.jdField_a_of_type_Boolean = true;
          return localmbc;
          parammaz = parammbh.b();
          if (!TextUtils.isEmpty(parammaz)) {
            localmbc.jdField_a_of_type_AndroidGraphicsBitmap = mqx.a(paramResources, parammaz);
          }
          break;
        }
      }
      localmbc.jdField_b_of_type_Boolean = true;
      return localmbc;
      localmbc.jdField_c_of_type_Boolean = ((mbk)parammbh).b();
      return localmbc;
      paramResources = (mbi)parammbh;
      if (paramResources.h() != -1) {
        localmbc.jdField_a_of_type_Int = paramResources.h();
      }
      if (paramResources.j() != -1) {
        localmbc.jdField_c_of_type_Int = paramResources.j();
      }
      if (paramResources.i() != -1) {
        localmbc.d = paramResources.i();
      }
    } while (localmbc.jdField_a_of_type_AndroidTextSpannableString == null);
    int j = paramResources.f();
    if (paramResources.g() == -1) {}
    for (int i = parammbh.a().length() + j;; i = paramResources.g() + j)
    {
      localmbc.jdField_a_of_type_AndroidTextSpannableString.setSpan(new mbd(paramResources), j, i, 33);
      paramResources = new ForegroundColorSpan(localmbc.jdField_c_of_type_Int);
      localmbc.jdField_a_of_type_AndroidTextSpannableString.setSpan(paramResources, j, i, 17);
      return localmbc;
    }
  }
  
  static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView.setTag(2131378474, Integer.valueOf(paramInt2));
    paramTextView.setTag(2131378475, Integer.valueOf(paramInt1));
    paramTextView.setMovementMethod((lue)lue.a());
    paramTextView.setHighlightColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mbc
 * JD-Core Version:    0.7.0.1
 */