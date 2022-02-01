import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public abstract interface ohf
{
  public abstract void a(Context paramContext);
  
  public abstract void a(MessageRecord paramMessageRecord);
  
  public abstract void a(List<ChatMessage> paramList, ohg paramohg);
  
  public abstract boolean a(Context paramContext, RelativeLayout paramRelativeLayout);
  
  public abstract boolean a(RelativeLayout paramRelativeLayout);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohf
 * JD-Core Version:    0.7.0.1
 */