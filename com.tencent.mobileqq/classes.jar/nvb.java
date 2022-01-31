import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager;

public class nvb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_a_of_type_Boolean;
  
  public nvb(KeyboardAndEmojiManager paramKeyboardAndEmojiManager) {}
  
  public void onGlobalLayout()
  {
    KeyboardAndEmojiManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager).getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
    if (i != this.jdField_a_of_type_Int)
    {
      int j = KeyboardAndEmojiManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager).getRootView().getHeight();
      if (j - i <= j / 4) {
        break label79;
      }
      this.jdField_a_of_type_Boolean = true;
      KeyboardAndEmojiManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return;
      label79:
      if (this.jdField_a_of_type_Boolean) {
        KeyboardAndEmojiManager.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvb
 * JD-Core Version:    0.7.0.1
 */