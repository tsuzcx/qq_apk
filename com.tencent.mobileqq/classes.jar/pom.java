import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

final class pom
  implements DrawableUtil.DrawableHelper
{
  public Drawable getDrawable(Context paramContext, String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("http"))
    {
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = paramDrawable1;
      paramContext.mFailedDrawable = paramDrawable2;
      return URLDrawable.getDrawable(sfa.a(paramString, 3), paramContext);
    }
    paramDrawable1 = ImageCommon.getDrawableResourceId(paramString);
    if (paramDrawable1 != null) {
      try
      {
        paramContext = paramContext.getResources().getDrawable(paramDrawable1.intValue());
        return paramContext;
      }
      catch (Exception paramContext)
      {
        QLog.d("Q.readinjoy.proteus", 2, "getDrawable: cant find in resources dir, do nothing");
        QLog.e("Q.readinjoy.proteus", 1, paramContext, new Object[0]);
      }
    }
    QLog.e("Q.readinjoy.proteus", 2, "getDrawable: cant find path :" + paramString);
    return null;
  }
  
  public Drawable getDrawableFromNet(Context paramContext, String paramString, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2, DrawableUtil.DrawableCallBack paramDrawableCallBack)
  {
    if (paramString.startsWith("http"))
    {
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = paramDrawable1;
      paramContext.mFailedDrawable = paramDrawable2;
      paramContext.mRequestWidth = paramInt1;
      paramContext.mRequestHeight = paramInt2;
      paramContext = URLDrawable.getDrawable(sfa.a(paramString, 3), paramContext);
      paramContext.setCallback(new pon(this, paramDrawableCallBack, paramContext));
      paramContext.setURLDrawableListener(new poo(this, paramString, paramDrawableCallBack));
      paramContext.setDownloadListener(new pop(this, paramString, paramDrawableCallBack, paramContext));
      QLog.i("Q.readinjoy.proteus", 1, "getDrawable: :" + paramString);
      paramDrawableCallBack.onCallBack(true, paramContext);
      if (paramContext.getStatus() != 1)
      {
        paramContext.startDownload();
        QLog.i("Q.readinjoy.proteus", 1, "getDrawable: :" + paramString + "  startDownload ");
      }
      return paramContext;
    }
    return getDrawable(paramContext, paramString, paramDrawable1, paramDrawable2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pom
 * JD-Core Version:    0.7.0.1
 */