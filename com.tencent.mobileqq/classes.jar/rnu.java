import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity;
import java.util.List;

public class rnu
  extends Handler
{
  public rnu(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (List)paramMessage.obj;
    ReadInJoyNewSearchActivity.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rnu
 * JD-Core Version:    0.7.0.1
 */