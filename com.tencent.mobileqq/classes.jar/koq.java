import android.view.View;
import com.tencent.biz.now.NowVideoController;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.widget.AbsListView;

public class koq
  implements Runnable
{
  public koq(NowVideoController paramNowVideoController, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (NowVideoController.a(this.jdField_a_of_type_ComTencentBizNowNowVideoController) == null) {}
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_Int;
      while (i <= this.b)
      {
        Object localObject = NowVideoController.a(this.jdField_a_of_type_ComTencentBizNowNowVideoController).getChildAt(i - this.jdField_a_of_type_Int);
        if (localObject != null)
        {
          localObject = (PAVideoView)((View)localObject).findViewById(2131362177);
          if ((localObject != null) && (((PAVideoView)localObject).j == 4)) {
            ((PAVideoView)localObject).c();
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     koq
 * JD-Core Version:    0.7.0.1
 */