import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.PlayingPttHistoryInfo;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class rwf
  implements AbsListView.OnScrollListener
{
  public rwf(ChatHistory paramChatHistory) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.a.m = paramInt;
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      return;
    }
    if ((this.a.a != null) && (this.a.a.jdField_a_of_type_Int == 1) && (!this.a.a.jdField_a_of_type_Boolean)) {
      this.a.a.d();
    }
    AbstractGifImage.pauseAll();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwf
 * JD-Core Version:    0.7.0.1
 */