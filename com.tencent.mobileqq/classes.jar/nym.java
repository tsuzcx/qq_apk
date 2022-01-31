import android.view.MotionEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;

public class nym
  implements Runnable
{
  int jdField_a_of_type_Int = -1;
  
  public nym(MystoryListView paramMystoryListView, int[] paramArrayOfInt1, int[] paramArrayOfInt2, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfInt.length) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Int < 0)
      {
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int >= 0) {
          i = this.b[this.jdField_a_of_type_Int];
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.postDelayed(this, i);
        return;
      }
      long l = System.currentTimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int], this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getWidth() / 2, this.jdField_a_of_type_ArrayOfFloat[this.jdField_a_of_type_Int], 0);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.jdField_a_of_type_Int += 1;
    } while (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfInt.length);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.postDelayed(this, this.b[this.jdField_a_of_type_Int]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nym
 * JD-Core Version:    0.7.0.1
 */