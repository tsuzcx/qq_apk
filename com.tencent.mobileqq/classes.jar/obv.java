import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;
import java.util.Locale;

public class obv
  implements Runnable
{
  public obv(NewMessageYellowBar paramNewMessageYellowBar, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.getDefault(), "%d个小视频更新", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar.jdField_a_of_type_AndroidViewAnimationAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obv
 * JD-Core Version:    0.7.0.1
 */