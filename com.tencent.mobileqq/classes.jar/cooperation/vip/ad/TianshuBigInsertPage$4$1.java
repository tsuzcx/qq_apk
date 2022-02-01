package cooperation.vip.ad;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import bgtn;
import blqo;
import bmsk;
import bmsl;
import bmsp;
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
  public TianshuBigInsertPage$4$1(bmsp parambmsp, PreloadManager.PathResult paramPathResult) {}
  
  public void run()
  {
    QLog.d("TianshuBigInsertPage", 2, "show insert page...");
    blqo.a(bmsl.a(this.jdField_a_of_type_Bmsp.a));
    bmsl.a(this.jdField_a_of_type_Bmsp.a).addView(bmsl.a(this.jdField_a_of_type_Bmsp.a));
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    localObject1 = URLDrawable.getFileDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$PathResult.filePath, (URLDrawable.URLDrawableOptions)localObject1);
    try
    {
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$PathResult.filePath, (BitmapFactory.Options)localObject2);
      QLog.d("TianshuBigInsertPage", 2, "bitmap w: " + ((BitmapFactory.Options)localObject2).outWidth + ", h: " + ((BitmapFactory.Options)localObject2).outHeight);
      int i = bgtn.a();
      i = (int)(((BitmapFactory.Options)localObject2).outHeight * 1.0F / ((BitmapFactory.Options)localObject2).outWidth * i);
      if (i > 0)
      {
        QLog.d("TianshuBigInsertPage", 2, "calc height: " + i);
        localObject2 = bmsl.a(this.jdField_a_of_type_Bmsp.a).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = i;
        bmsl.a(this.jdField_a_of_type_Bmsp.a).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    bmsl.a(this.jdField_a_of_type_Bmsp.a).setBackgroundDrawable((Drawable)localObject1);
    bmsl.a(bmsl.b(this.jdField_a_of_type_Bmsp.a));
    if ((bmsl.a(this.jdField_a_of_type_Bmsp.a) != null) && (bmsl.a(this.jdField_a_of_type_Bmsp.a).a() != null) && (bmsl.a(this.jdField_a_of_type_Bmsp.a).a().app != null) && (bmsl.a(this.jdField_a_of_type_Bmsp.a) != null)) {
      bmsk.a(bmsl.a(this.jdField_a_of_type_Bmsp.a).a().app, 101, String.valueOf(bmsl.a(this.jdField_a_of_type_Bmsp.a).iAdId.get()), bmsl.a(this.jdField_a_of_type_Bmsp.a).traceinfo.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBigInsertPage.4.1
 * JD-Core Version:    0.7.0.1
 */