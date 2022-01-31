import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troop.widget.ExpandableTextView.OnExpandStateListener;

public class sci
  implements ExpandableTextView.OnExpandStateListener
{
  public sci(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(TextView paramTextView, View paramView, boolean paramBoolean)
  {
    paramView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sci
 * JD-Core Version:    0.7.0.1
 */