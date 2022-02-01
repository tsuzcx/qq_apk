import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;

class mae
  implements bkzq
{
  mae(mac parammac, boolean paramBoolean) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (!this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    switch (i)
    {
    default: 
    case 0: 
      do
      {
        return;
        paramView = lbz.a().a();
      } while (!paramView.A());
      ((mxd)VideoController.a().a.a(15)).d(paramView);
      return;
    case 1: 
      paramView = lbz.a().a();
      VideoController localVideoController = VideoController.a();
      if (paramView.z != -1) {}
      for (;;)
      {
        localVideoController.a(paramView.d, 237);
        localVideoController.b(237);
        localVideoController.b(paramView.d, paramView.z);
        paramView.a("onClick_quit", false);
        paramView.b("onClick_quit", 0);
        return;
        paramView.z = 0;
      }
    }
    this.jdField_a_of_type_Mac.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mae
 * JD-Core Version:    0.7.0.1
 */