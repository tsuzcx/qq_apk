import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.data.MessageRecord;

public class mlz
  implements KandianMergeManager.MessageObserver
{
  public mlz(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void a(MessageRecord paramMessageRecord) {}
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    this.a.a().runOnUiThread(new mmb(this));
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    this.a.a().runOnUiThread(new mma(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mlz
 * JD-Core Version:    0.7.0.1
 */