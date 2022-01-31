import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.net.URL;
import java.util.Map;

class qgk
  extends rul
{
  qgk(qfy paramqfy) {}
  
  public bahx a(Integer paramInteger)
  {
    Object localObject;
    if (22 == paramInteger.intValue())
    {
      localObject = new rum();
      ((rum)localObject).jdField_a_of_type_JavaLangString = qfy.a(this.jdField_a_of_type_Qfy).getResources().getString(2131631004);
      ((rum)localObject).jdField_b_of_type_Boolean = true;
      ((rum)localObject).jdField_b_of_type_Int = 2130842501;
      ((rum)localObject).c = a(paramInteger.intValue());
      ((rum)localObject).jdField_b_of_type_JavaLangString = "";
      return localObject;
    }
    if (121 == paramInteger.intValue())
    {
      localObject = new rum();
      ((rum)localObject).jdField_a_of_type_JavaLangString = ajjy.a(2131650409);
      ((rum)localObject).jdField_b_of_type_Int = 2130842024;
      ((rum)localObject).jdField_b_of_type_Boolean = true;
      ((rum)localObject).c = a(paramInteger.intValue());
      ((rum)localObject).jdField_b_of_type_JavaLangString = "";
      return localObject;
    }
    if (24 == paramInteger.intValue())
    {
      rum localrum = new rum();
      localrum.jdField_a_of_type_JavaLangString = qcn.a(qfy.a(this.jdField_a_of_type_Qfy).k);
      localrum.jdField_b_of_type_Boolean = false;
      localrum.c = 24;
      localrum.jdField_b_of_type_JavaLangString = "";
      localObject = bacm.b();
      if (!TextUtils.isEmpty(qfy.a(this.jdField_a_of_type_Qfy).j)) {
        paramInteger = azwp.a(qfy.a(this.jdField_a_of_type_Qfy), 1, qfy.a(this.jdField_a_of_type_Qfy).j, 3, (Drawable)localObject, (Drawable)localObject);
      }
      for (;;)
      {
        localrum.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramInteger;
        return localrum;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        try
        {
          if (TextUtils.isEmpty(qfy.a(this.jdField_a_of_type_Qfy).E)) {}
          for (paramInteger = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");; paramInteger = new URL(qfy.a(this.jdField_a_of_type_Qfy).E))
          {
            paramInteger = URLDrawable.getDrawable(paramInteger, localURLDrawableOptions);
            paramInteger.setDecodeHandler(azue.a);
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
 * Qualified Name:     qgk
 * JD-Core Version:    0.7.0.1
 */