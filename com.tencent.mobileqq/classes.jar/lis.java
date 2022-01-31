import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class lis
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public lis(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    ReadInJoyDeliverBiuActivity.a(this.a).getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ReadInJoyDeliverBiuActivity.b(this.a).getRootView().getHeight();
    int j = i - ((Rect)localObject).height();
    boolean bool;
    if (j > 100)
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "onGlobalLayout screenHeight:" + i + ", ExternalPanelheight:" + j + ", isShowKeybroad:" + bool);
      }
      i = ReadInJoyDeliverBiuActivity.a(this.a).getHeight();
      if (bool == ReadInJoyDeliverBiuActivity.a(this.a)) {
        break label394;
      }
      if (j > ReadInJoyDeliverBiuActivity.a(this.a)) {
        ReadInJoyDeliverBiuActivity.a(this.a, j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "onGlobalLayout mMAXExternalPanelheight:" + ReadInJoyDeliverBiuActivity.b(this.a));
      }
      j = i - ReadInJoyDeliverBiuActivity.c(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "onGlobalLayout contentHeight:" + i + ", fixedHeight:" + ReadInJoyDeliverBiuActivity.d(this.a) + ", maxHeight:" + j);
      }
      ReadInJoyDeliverBiuActivity.a(this.a).setMaxHeight(j);
      ReadInJoyDeliverBiuActivity.a(this.a, bool);
      localObject = this.a;
      if (i >= ReadInJoyDeliverBiuActivity.e(this.a)) {
        break label372;
      }
      j = i;
      label283:
      ReadInJoyDeliverBiuActivity.b((ReadInJoyDeliverBiuActivity)localObject, j);
      localObject = this.a;
      if (i <= ReadInJoyDeliverBiuActivity.f(this.a)) {
        break label383;
      }
      label307:
      ReadInJoyDeliverBiuActivity.c((ReadInJoyDeliverBiuActivity)localObject, i);
    }
    for (;;)
    {
      ReadInJoyDeliverBiuActivity.d(this.a, ReadInJoyDeliverBiuActivity.h(this.a));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "onGlobalLayout mExternalPanelheight:" + ReadInJoyDeliverBiuActivity.g(this.a));
      }
      return;
      bool = false;
      break;
      label372:
      j = ReadInJoyDeliverBiuActivity.e(this.a);
      break label283;
      label383:
      i = ReadInJoyDeliverBiuActivity.f(this.a);
      break label307;
      label394:
      if ((ReadInJoyDeliverBiuActivity.g(this.a) != ReadInJoyDeliverBiuActivity.h(this.a)) && (i == ReadInJoyDeliverBiuActivity.f(this.a)))
      {
        i -= ReadInJoyDeliverBiuActivity.h(this.a);
        j = i - ReadInJoyDeliverBiuActivity.i(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverBiuActivity", 2, "onGlobalLayout contentHeight:" + i + ", fixedHeight:" + ReadInJoyDeliverBiuActivity.j(this.a) + ", maxHeight:" + j);
        }
        ReadInJoyDeliverBiuActivity.b(this.a).setMaxHeight(j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lis
 * JD-Core Version:    0.7.0.1
 */