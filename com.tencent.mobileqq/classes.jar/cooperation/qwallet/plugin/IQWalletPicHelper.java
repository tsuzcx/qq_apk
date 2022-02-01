package cooperation.qwallet.plugin;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQWalletPicHelper
  extends QRouteApi
{
  public abstract void decodeDrawable(Drawable paramDrawable, IQWalletPicHelper.OnDecodeListener paramOnDecodeListener);
  
  public abstract Drawable getNetDrawableForAIO(String paramString, Drawable paramDrawable);
  
  public abstract URLDrawable getNetDrawableForQWallet(String paramString, Drawable paramDrawable1, Drawable paramDrawable2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.IQWalletPicHelper
 * JD-Core Version:    0.7.0.1
 */