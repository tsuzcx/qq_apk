import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.activity.ChatHistory.PlayingPttHistoryInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;

public class rwx
  implements View.OnClickListener
{
  public rwx(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, PicEmoticonInfo paramPicEmoticonInfo) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      paramView = paramView.getTag();
      String str = EmoticonUtils.o.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a = new ChatHistory.PlayingPttHistoryInfo(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a.a(1, localView, paramView, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwx
 * JD-Core Version:    0.7.0.1
 */