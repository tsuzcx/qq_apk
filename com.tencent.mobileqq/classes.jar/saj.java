import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryFileView;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter.HistoryFileItemHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class saj
  implements View.OnClickListener
{
  public saj(ChatHistoryFileView paramChatHistoryFileView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {
      return;
    }
    paramView = (FileManagerEntity)((ChatHistoryFileAdapter.HistoryFileItemHolder)paramView.getTag()).a;
    this.a.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     saj
 * JD-Core Version:    0.7.0.1
 */