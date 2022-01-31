import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

class rkm
  extends qzg
{
  rkm(rkd paramrkd) {}
  
  public ShareActionSheetBuilder.ActionSheetItem a(Integer paramInteger)
  {
    if (24 == paramInteger.intValue())
    {
      syw localsyw = new syw();
      localsyw.label = rdm.a(rkd.a(this.jdField_a_of_type_Rkd).getSubscribeName());
      localsyw.iconNeedBg = false;
      localsyw.action = 24;
      localsyw.argus = "";
      Drawable localDrawable = bdhj.b();
      if ((ors.w(rkd.a(this.jdField_a_of_type_Rkd))) || (rkd.a(this.jdField_a_of_type_Rkd).busiType == 1)) {}
      for (paramInteger = bdbk.a(rkd.a(this.jdField_a_of_type_Rkd), 1, rkd.a(this.jdField_a_of_type_Rkd).getSubscribeUin(), 3, localDrawable, localDrawable);; paramInteger = localDrawable)
      {
        for (;;)
        {
          localsyw.iconDrawable = paramInteger;
          return localsyw;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = localDrawable;
          localURLDrawableOptions.mFailedDrawable = localDrawable;
          try
          {
            if (TextUtils.isEmpty(rkd.a(this.jdField_a_of_type_Rkd).thirdIcon)) {}
            for (paramInteger = new URL("http://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");; paramInteger = new URL(rkd.a(this.jdField_a_of_type_Rkd).thirdIcon))
            {
              paramInteger = URLDrawable.getDrawable(paramInteger, localURLDrawableOptions);
              paramInteger.setDecodeHandler(bcyz.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rkm
 * JD-Core Version:    0.7.0.1
 */