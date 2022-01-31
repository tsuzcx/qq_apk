import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

class qva
  extends qkc
{
  qva(qur paramqur) {}
  
  public bbje a(Integer paramInteger)
  {
    if (24 == paramInteger.intValue())
    {
      she localshe = new she();
      localshe.jdField_a_of_type_JavaLangString = qol.a(qur.a(this.jdField_a_of_type_Qur).getSubscribeName());
      localshe.jdField_b_of_type_Boolean = false;
      localshe.c = 24;
      localshe.jdField_b_of_type_JavaLangString = "";
      Drawable localDrawable = bbdr.b();
      if ((onk.w(qur.a(this.jdField_a_of_type_Qur))) || (qur.a(this.jdField_a_of_type_Qur).busiType == 1)) {}
      for (paramInteger = baxt.a(qur.a(this.jdField_a_of_type_Qur), 1, qur.a(this.jdField_a_of_type_Qur).getSubscribeUin(), 3, localDrawable, localDrawable);; paramInteger = localDrawable)
      {
        for (;;)
        {
          localshe.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramInteger;
          return localshe;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = localDrawable;
          localURLDrawableOptions.mFailedDrawable = localDrawable;
          try
          {
            if (TextUtils.isEmpty(qur.a(this.jdField_a_of_type_Qur).thirdIcon)) {}
            for (paramInteger = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");; paramInteger = new URL(qur.a(this.jdField_a_of_type_Qur).thirdIcon))
            {
              paramInteger = URLDrawable.getDrawable(paramInteger, localURLDrawableOptions);
              paramInteger.setDecodeHandler(bavi.a);
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
 * Qualified Name:     qva
 * JD-Core Version:    0.7.0.1
 */