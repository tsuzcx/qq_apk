import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.qqstory.takevideo.label.QQStoryAddVideoLabelViewPart;

public class ojh
  implements TextView.OnEditorActionListener
{
  public ojh(QQStoryAddVideoLabelViewPart paramQQStoryAddVideoLabelViewPart) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      paramTextView = this.a.jdField_a_of_type_AndroidViewView$OnClickListener;
      if (paramTextView != null) {
        paramTextView.onClick(this.a.jdField_a_of_type_AndroidWidgetTextView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojh
 * JD-Core Version:    0.7.0.1
 */