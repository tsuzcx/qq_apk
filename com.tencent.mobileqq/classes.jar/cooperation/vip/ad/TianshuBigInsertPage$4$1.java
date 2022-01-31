package cooperation.vip.ad;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import bdkf;
import bixy;
import bjzt;
import bjzu;
import bjzy;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;

public class TianshuBigInsertPage$4$1
  implements Runnable
{
  public TianshuBigInsertPage$4$1(bjzy parambjzy, PreloadManager.PathResult paramPathResult) {}
  
  public void run()
  {
    QLog.d("TianshuBigInsertPage", 2, "show insert page...");
    bixy.a(bjzu.a(this.jdField_a_of_type_Bjzy.a));
    bjzu.a(this.jdField_a_of_type_Bjzy.a).addView(bjzu.a(this.jdField_a_of_type_Bjzy.a));
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    localObject1 = URLDrawable.getFileDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$PathResult.filePath, (URLDrawable.URLDrawableOptions)localObject1);
    try
    {
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$PathResult.filePath, (BitmapFactory.Options)localObject2);
      QLog.d("TianshuBigInsertPage", 2, "bitmap w: " + ((BitmapFactory.Options)localObject2).outWidth + ", h: " + ((BitmapFactory.Options)localObject2).outHeight);
      int i = bdkf.a();
      i = (int)(((BitmapFactory.Options)localObject2).outHeight * 1.0F / ((BitmapFactory.Options)localObject2).outWidth * i);
      if (i > 0)
      {
        QLog.d("TianshuBigInsertPage", 2, "calc height: " + i);
        localObject2 = bjzu.a(this.jdField_a_of_type_Bjzy.a).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = i;
        bjzu.a(this.jdField_a_of_type_Bjzy.a).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    bjzu.a(this.jdField_a_of_type_Bjzy.a).setBackgroundDrawable((Drawable)localObject1);
    bjzu.a(bjzu.b(this.jdField_a_of_type_Bjzy.a));
    if ((bjzu.a(this.jdField_a_of_type_Bjzy.a) != null) && (bjzu.a(this.jdField_a_of_type_Bjzy.a).a() != null) && (bjzu.a(this.jdField_a_of_type_Bjzy.a).a().app != null) && (bjzu.a(this.jdField_a_of_type_Bjzy.a) != null)) {
      bjzt.a(bjzu.a(this.jdField_a_of_type_Bjzy.a).a().app, 101, String.valueOf(bjzu.a(this.jdField_a_of_type_Bjzy.a).iAdId.get()), bjzu.a(this.jdField_a_of_type_Bjzy.a).traceinfo.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBigInsertPage.4.1
 * JD-Core Version:    0.7.0.1
 */