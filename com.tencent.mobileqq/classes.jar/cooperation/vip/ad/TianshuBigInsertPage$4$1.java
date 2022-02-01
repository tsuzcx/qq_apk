package cooperation.vip.ad;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;

class TianshuBigInsertPage$4$1
  implements Runnable
{
  TianshuBigInsertPage$4$1(TianshuBigInsertPage.4 param4, IPreloadService.PathResult paramPathResult) {}
  
  public void run()
  {
    QLog.d("TianshuBigInsertPage", 2, "show insert page...");
    ViewUtils.removeViewFromParent(TianshuBigInsertPage.d(this.b.a));
    TianshuBigInsertPage.e(this.b.a).addView(TianshuBigInsertPage.d(this.b.a));
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    localObject1 = URLDrawable.getFileDrawable(this.a.filePath, (URLDrawable.URLDrawableOptions)localObject1);
    try
    {
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.a.filePath, (BitmapFactory.Options)localObject2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bitmap w: ");
      localStringBuilder.append(((BitmapFactory.Options)localObject2).outWidth);
      localStringBuilder.append(", h: ");
      localStringBuilder.append(((BitmapFactory.Options)localObject2).outHeight);
      QLog.d("TianshuBigInsertPage", 2, localStringBuilder.toString());
      int i = ViewUtils.getScreenWidth();
      i = (int)(((BitmapFactory.Options)localObject2).outHeight * 1.0F / ((BitmapFactory.Options)localObject2).outWidth * i);
      if (i > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("calc height: ");
        ((StringBuilder)localObject2).append(i);
        QLog.d("TianshuBigInsertPage", 2, ((StringBuilder)localObject2).toString());
        localObject2 = TianshuBigInsertPage.f(this.b.a).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = i;
        TianshuBigInsertPage.f(this.b.a).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    TianshuBigInsertPage.f(this.b.a).setBackgroundDrawable((Drawable)localObject1);
    TianshuBigInsertPage.a(TianshuBigInsertPage.g(this.b.a));
    if ((TianshuBigInsertPage.b(this.b.a) != null) && (TianshuBigInsertPage.b(this.b.a).P() != null) && (((BaseActivity)TianshuBigInsertPage.b(this.b.a).P()).app != null) && (TianshuBigInsertPage.c(this.b.a) != null)) {
      TianshuAdUtils.a(((BaseActivity)TianshuBigInsertPage.b(this.b.a).P()).app, 101, String.valueOf(TianshuBigInsertPage.c(this.b.a).iAdId.get()), TianshuBigInsertPage.c(this.b.a).traceinfo.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBigInsertPage.4.1
 * JD-Core Version:    0.7.0.1
 */