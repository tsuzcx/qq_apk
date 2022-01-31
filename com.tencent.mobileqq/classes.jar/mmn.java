import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import java.lang.ref.WeakReference;

public class mmn
  extends Handler
{
  private WeakReference a;
  
  public mmn(ReadInJoyListViewGroup paramReadInJoyListViewGroup)
  {
    this.a = new WeakReference(paramReadInJoyListViewGroup);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReadInJoyListViewGroup localReadInJoyListViewGroup = (ReadInJoyListViewGroup)this.a.get();
    if (localReadInJoyListViewGroup == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      }
    } while (ReadInJoyListViewGroup.a(localReadInJoyListViewGroup) == null);
    ReadInJoyListViewGroup.a(localReadInJoyListViewGroup).setAnimType(2);
    localReadInJoyListViewGroup.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmn
 * JD-Core Version:    0.7.0.1
 */