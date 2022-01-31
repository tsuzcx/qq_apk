import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

class qiv
  extends rul
{
  qiv(qim paramqim) {}
  
  public bahx a(Integer paramInteger)
  {
    if (24 == paramInteger.intValue())
    {
      rum localrum = new rum();
      localrum.jdField_a_of_type_JavaLangString = qcn.a(qim.a(this.jdField_a_of_type_Qim).getSubscribeName());
      localrum.jdField_b_of_type_Boolean = false;
      localrum.c = 24;
      localrum.jdField_b_of_type_JavaLangString = "";
      Drawable localDrawable = bacm.b();
      if ((obz.w(qim.a(this.jdField_a_of_type_Qim))) || (qim.a(this.jdField_a_of_type_Qim).busiType == 1)) {}
      for (paramInteger = azwp.a(qim.a(this.jdField_a_of_type_Qim), 1, qim.a(this.jdField_a_of_type_Qim).getSubscribeUin(), 3, localDrawable, localDrawable);; paramInteger = localDrawable)
      {
        for (;;)
        {
          localrum.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramInteger;
          return localrum;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = localDrawable;
          localURLDrawableOptions.mFailedDrawable = localDrawable;
          try
          {
            if (TextUtils.isEmpty(qim.a(this.jdField_a_of_type_Qim).thirdIcon)) {}
            for (paramInteger = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");; paramInteger = new URL(qim.a(this.jdField_a_of_type_Qim).thirdIcon))
            {
              paramInteger = URLDrawable.getDrawable(paramInteger, localURLDrawableOptions);
              paramInteger.setDecodeHandler(azue.a);
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
 * Qualified Name:     qiv
 * JD-Core Version:    0.7.0.1
 */