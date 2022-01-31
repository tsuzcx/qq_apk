import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.data.MessageRecord;

public class mhb
  implements KandianMergeManager.MessageObserver
{
  public mhb(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void a(MessageRecord paramMessageRecord) {}
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    this.a.a().runOnUiThread(new mhd(this));
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    this.a.a().runOnUiThread(new mhc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhb
 * JD-Core Version:    0.7.0.1
 */