import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.data.MessageRecord;

public class mii
  implements KandianMergeManager.MessageObserver
{
  public mii(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void a(MessageRecord paramMessageRecord) {}
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    this.a.a().runOnUiThread(new mik(this));
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    this.a.a().runOnUiThread(new mij(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mii
 * JD-Core Version:    0.7.0.1
 */