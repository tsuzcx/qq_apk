package cooperation.qzone.widget;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.Set;

class FastAnimationDrawable$1
  extends LruCache<Integer, BitmapDrawable>
{
  FastAnimationDrawable$1(FastAnimationDrawable paramFastAnimationDrawable, int paramInt)
  {
    super(paramInt);
  }
  
  protected void entryRemoved(boolean paramBoolean, Integer paramInteger, BitmapDrawable paramBitmapDrawable1, BitmapDrawable paramBitmapDrawable2)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      FastAnimationDrawable.access$000(this.this$0).add(new SoftReference(paramBitmapDrawable1.getBitmap()));
      if (QLog.isColorLevel()) {
        QLog.d("FastAnimationDrawable", 2, "remove key:" + paramInteger + " bitmap:" + paramBitmapDrawable1.getBitmap());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.widget.FastAnimationDrawable.1
 * JD-Core Version:    0.7.0.1
 */