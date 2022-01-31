import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.net.URL;
import java.util.Map;

class qsi
  extends qkc
{
  qsi(qrw paramqrw) {}
  
  public bbje a(Integer paramInteger)
  {
    Object localObject;
    if (22 == paramInteger.intValue())
    {
      localObject = new she();
      ((she)localObject).jdField_a_of_type_JavaLangString = qrw.a(this.jdField_a_of_type_Qrw).getResources().getString(2131696716);
      ((she)localObject).jdField_b_of_type_Boolean = true;
      ((she)localObject).jdField_b_of_type_Int = 2130842584;
      ((she)localObject).c = a(paramInteger.intValue());
      ((she)localObject).jdField_b_of_type_JavaLangString = "";
      return localObject;
    }
    if (121 == paramInteger.intValue())
    {
      localObject = new she();
      ((she)localObject).jdField_a_of_type_JavaLangString = ajyc.a(2131716200);
      ((she)localObject).jdField_b_of_type_Int = 2130842116;
      ((she)localObject).jdField_b_of_type_Boolean = true;
      ((she)localObject).c = a(paramInteger.intValue());
      ((she)localObject).jdField_b_of_type_JavaLangString = "";
      return localObject;
    }
    if (24 == paramInteger.intValue())
    {
      she localshe = new she();
      localshe.jdField_a_of_type_JavaLangString = qol.a(qrw.a(this.jdField_a_of_type_Qrw).k);
      localshe.jdField_b_of_type_Boolean = false;
      localshe.c = 24;
      localshe.jdField_b_of_type_JavaLangString = "";
      localObject = bbdr.b();
      if (!TextUtils.isEmpty(qrw.a(this.jdField_a_of_type_Qrw).j)) {
        paramInteger = baxt.a(qrw.a(this.jdField_a_of_type_Qrw), 1, qrw.a(this.jdField_a_of_type_Qrw).j, 3, (Drawable)localObject, (Drawable)localObject);
      }
      for (;;)
      {
        localshe.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramInteger;
        return localshe;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        try
        {
          if (TextUtils.isEmpty(qrw.a(this.jdField_a_of_type_Qrw).E)) {}
          for (paramInteger = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");; paramInteger = new URL(qrw.a(this.jdField_a_of_type_Qrw).E))
          {
            paramInteger = URLDrawable.getDrawable(paramInteger, localURLDrawableOptions);
            paramInteger.setDecodeHandler(bavi.a);
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
 * Qualified Name:     qsi
 * JD-Core Version:    0.7.0.1
 */