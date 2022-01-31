import com.tencent.biz.qqstory.takevideo.dancemachine.VideoSharer;
import com.tencent.mobileqq.widget.QQToast;

class oib
  implements Runnable
{
  oib(oia paramoia, int paramInt) {}
  
  public void run()
  {
    String str = "";
    if (this.jdField_a_of_type_Int == -1) {
      str = "分享失败";
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_Oia.a.a, 1, str, 0).a();
      return;
      if (this.jdField_a_of_type_Int == -2) {
        str = "你未安装微博客户端，无法分享。";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oib
 * JD-Core Version:    0.7.0.1
 */