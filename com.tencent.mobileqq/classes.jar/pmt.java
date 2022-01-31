import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView;

public class pmt
  implements Drawable.Callback
{
  public pmt(NativeAwesomeCommentView paramNativeAwesomeCommentView, SpannableString paramSpannableString) {}
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    paramDrawable = new xdp(paramDrawable);
    this.jdField_a_of_type_AndroidTextSpannableString.setSpan(paramDrawable, 0, 1, 17);
    NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView).setText(this.jdField_a_of_type_AndroidTextSpannableString);
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pmt
 * JD-Core Version:    0.7.0.1
 */