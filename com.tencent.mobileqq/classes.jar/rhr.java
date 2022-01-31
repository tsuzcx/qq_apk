import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.net.URL;
import java.util.Map;

class rhr
  extends qzg
{
  rhr(rhf paramrhf) {}
  
  public ShareActionSheetBuilder.ActionSheetItem a(Integer paramInteger)
  {
    Object localObject;
    if (22 == paramInteger.intValue())
    {
      localObject = new syw();
      ((syw)localObject).label = rhf.a(this.jdField_a_of_type_Rhf).getResources().getString(2131696892);
      ((syw)localObject).iconNeedBg = true;
      ((syw)localObject).icon = 2130842765;
      ((syw)localObject).action = a(paramInteger.intValue());
      ((syw)localObject).argus = "";
      return localObject;
    }
    if (121 == paramInteger.intValue())
    {
      localObject = new syw();
      ((syw)localObject).label = alpo.a(2131716583);
      ((syw)localObject).icon = 2130842270;
      ((syw)localObject).iconNeedBg = true;
      ((syw)localObject).action = a(paramInteger.intValue());
      ((syw)localObject).argus = "";
      return localObject;
    }
    if (24 == paramInteger.intValue())
    {
      syw localsyw = new syw();
      localsyw.label = rdm.a(rhf.a(this.jdField_a_of_type_Rhf).k);
      localsyw.iconNeedBg = false;
      localsyw.action = 24;
      localsyw.argus = "";
      localObject = bdda.b();
      if (!TextUtils.isEmpty(rhf.a(this.jdField_a_of_type_Rhf).j)) {
        paramInteger = bcxb.a(rhf.a(this.jdField_a_of_type_Rhf), 1, rhf.a(this.jdField_a_of_type_Rhf).j, 3, (Drawable)localObject, (Drawable)localObject);
      }
      for (;;)
      {
        localsyw.iconDrawable = paramInteger;
        return localsyw;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        try
        {
          if (TextUtils.isEmpty(rhf.a(this.jdField_a_of_type_Rhf).n)) {}
          for (paramInteger = new URL("http://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");; paramInteger = new URL(rhf.a(this.jdField_a_of_type_Rhf).n))
          {
            paramInteger = URLDrawable.getDrawable(paramInteger, localURLDrawableOptions);
            paramInteger.setDecodeHandler(bcuq.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rhr
 * JD-Core Version:    0.7.0.1
 */