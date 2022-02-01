import android.content.res.Resources;
import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView;
import com.tencent.image.URLDrawable.DownloadListener;

public class qdq
  implements URLDrawable.DownloadListener
{
  public qdq(NativeAwesomeCommentView paramNativeAwesomeCommentView, SpannableString paramSpannableString) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    aayd localaayd = new aayd(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView.getResources().getDrawable(2130842704));
    this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localaayd, 0, 1, 17);
    NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView).setText(this.jdField_a_of_type_AndroidTextSpannableString);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdq
 * JD-Core Version:    0.7.0.1
 */