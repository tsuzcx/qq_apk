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
    ViewUtils.a(TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a));
    TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a).addView(TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a));
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    localObject1 = URLDrawable.getFileDrawable(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult.filePath, (URLDrawable.URLDrawableOptions)localObject1);
    try
    {
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult.filePath, (BitmapFactory.Options)localObject2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bitmap w: ");
      localStringBuilder.append(((BitmapFactory.Options)localObject2).outWidth);
      localStringBuilder.append(", h: ");
      localStringBuilder.append(((BitmapFactory.Options)localObject2).outHeight);
      QLog.d("TianshuBigInsertPage", 2, localStringBuilder.toString());
      int i = ViewUtils.a();
      i = (int)(((BitmapFactory.Options)localObject2).outHeight * 1.0F / ((BitmapFactory.Options)localObject2).outWidth * i);
      if (i > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("calc height: ");
        ((StringBuilder)localObject2).append(i);
        QLog.d("TianshuBigInsertPage", 2, ((StringBuilder)localObject2).toString());
        localObject2 = TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = i;
        TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a).setBackgroundDrawable((Drawable)localObject1);
    TianshuBigInsertPage.a(TianshuBigInsertPage.b(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a));
    if ((TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a) != null) && (TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a).a() != null) && (((BaseActivity)TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a).a()).app != null) && (TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a) != null)) {
      TianshuAdUtils.a(((BaseActivity)TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a).a()).app, 101, String.valueOf(TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a).iAdId.get()), TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage$4.a).traceinfo.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBigInsertPage.4.1
 * JD-Core Version:    0.7.0.1
 */