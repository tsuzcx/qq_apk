import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.InputViewHideListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class nav
  implements TextView.OnEditorActionListener
{
  public nav(StoryInputBarView paramStoryInputBarView) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramTextView = paramTextView.getText().toString();
      if (paramTextView.length() <= 0) {
        break label122;
      }
      this.a.setKeyBoardState(false);
      this.a.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.a(paramTextView, this.a.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      this.a.c();
      this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      if (StoryInputBarView.a(this.a) != null) {
        StoryInputBarView.a(this.a).f();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory:StoryInputBarView", 2, "onEditorAction vaule=" + paramTextView);
      }
    }
    return false;
    label122:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nav
 * JD-Core Version:    0.7.0.1
 */