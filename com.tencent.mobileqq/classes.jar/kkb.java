import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class kkb
  implements DialogInterface.OnDismissListener
{
  public kkb(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    PoiMapActivity.d(this.jdField_a_of_type_ComTencentBizPoiMapActivity).setEnabled(false);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getHandler().postDelayed(new kkc(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kkb
 * JD-Core Version:    0.7.0.1
 */