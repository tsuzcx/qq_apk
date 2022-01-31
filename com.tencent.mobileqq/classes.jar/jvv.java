import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;

class jvv
  implements View.OnLayoutChangeListener
{
  jvv(jvt paramjvt) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MemberPagerAdapter", 2, String.format("container : left[%s], top[%s], right[%s], bottom[%s], oldLeft[%s], oldTop[%s], oldRight[%s], oldBottom[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jvv
 * JD-Core Version:    0.7.0.1
 */