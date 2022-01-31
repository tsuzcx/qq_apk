import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

class qux
  extends qjz
{
  qux(quo paramquo) {}
  
  public bbjs a(Integer paramInteger)
  {
    if (24 == paramInteger.intValue())
    {
      shb localshb = new shb();
      localshb.jdField_a_of_type_JavaLangString = qoi.a(quo.a(this.jdField_a_of_type_Quo).getSubscribeName());
      localshb.jdField_b_of_type_Boolean = false;
      localshb.c = 24;
      localshb.jdField_b_of_type_JavaLangString = "";
      Drawable localDrawable = bbef.b();
      if ((onh.w(quo.a(this.jdField_a_of_type_Quo))) || (quo.a(this.jdField_a_of_type_Quo).busiType == 1)) {}
      for (paramInteger = bayh.a(quo.a(this.jdField_a_of_type_Quo), 1, quo.a(this.jdField_a_of_type_Quo).getSubscribeUin(), 3, localDrawable, localDrawable);; paramInteger = localDrawable)
      {
        for (;;)
        {
          localshb.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramInteger;
          return localshb;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = localDrawable;
          localURLDrawableOptions.mFailedDrawable = localDrawable;
          try
          {
            if (TextUtils.isEmpty(quo.a(this.jdField_a_of_type_Quo).thirdIcon)) {}
            for (paramInteger = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");; paramInteger = new URL(quo.a(this.jdField_a_of_type_Quo).thirdIcon))
            {
              paramInteger = URLDrawable.getDrawable(paramInteger, localURLDrawableOptions);
              paramInteger.setDecodeHandler(bavw.a);
              break;
            }
            if (!QLog.isColorLevel()) {}
          }
          catch (MalformedURLException localMalformedURLException)
          {
            paramInteger = localDrawable;
          }
        }
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "configVideoItemUI() ERROR e = " + localMalformedURLException.getMessage());
      }
    }
    return super.a(paramInteger);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(24), Integer.valueOf(24));
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qux
 * JD-Core Version:    0.7.0.1
 */