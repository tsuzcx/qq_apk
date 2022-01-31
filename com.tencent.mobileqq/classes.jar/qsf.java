import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.net.URL;
import java.util.Map;

class qsf
  extends qjz
{
  qsf(qrt paramqrt) {}
  
  public bbjs a(Integer paramInteger)
  {
    Object localObject;
    if (22 == paramInteger.intValue())
    {
      localObject = new shb();
      ((shb)localObject).jdField_a_of_type_JavaLangString = qrt.a(this.jdField_a_of_type_Qrt).getResources().getString(2131696717);
      ((shb)localObject).jdField_b_of_type_Boolean = true;
      ((shb)localObject).jdField_b_of_type_Int = 2130842585;
      ((shb)localObject).c = a(paramInteger.intValue());
      ((shb)localObject).jdField_b_of_type_JavaLangString = "";
      return localObject;
    }
    if (121 == paramInteger.intValue())
    {
      localObject = new shb();
      ((shb)localObject).jdField_a_of_type_JavaLangString = ajya.a(2131716211);
      ((shb)localObject).jdField_b_of_type_Int = 2130842117;
      ((shb)localObject).jdField_b_of_type_Boolean = true;
      ((shb)localObject).c = a(paramInteger.intValue());
      ((shb)localObject).jdField_b_of_type_JavaLangString = "";
      return localObject;
    }
    if (24 == paramInteger.intValue())
    {
      shb localshb = new shb();
      localshb.jdField_a_of_type_JavaLangString = qoi.a(qrt.a(this.jdField_a_of_type_Qrt).k);
      localshb.jdField_b_of_type_Boolean = false;
      localshb.c = 24;
      localshb.jdField_b_of_type_JavaLangString = "";
      localObject = bbef.b();
      if (!TextUtils.isEmpty(qrt.a(this.jdField_a_of_type_Qrt).j)) {
        paramInteger = bayh.a(qrt.a(this.jdField_a_of_type_Qrt), 1, qrt.a(this.jdField_a_of_type_Qrt).j, 3, (Drawable)localObject, (Drawable)localObject);
      }
      for (;;)
      {
        localshb.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramInteger;
        return localshb;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        try
        {
          if (TextUtils.isEmpty(qrt.a(this.jdField_a_of_type_Qrt).E)) {}
          for (paramInteger = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");; paramInteger = new URL(qrt.a(this.jdField_a_of_type_Qrt).E))
          {
            paramInteger = URLDrawable.getDrawable(paramInteger, localURLDrawableOptions);
            paramInteger.setDecodeHandler(bavw.a);
            break;
          }
        }
        catch (Exception paramInteger)
        {
          paramInteger = (Integer)localObject;
        }
      }
    }
    return super.a(paramInteger);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(45), Integer.valueOf(22));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(22), Integer.valueOf(121));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(24), Integer.valueOf(24));
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsf
 * JD-Core Version:    0.7.0.1
 */