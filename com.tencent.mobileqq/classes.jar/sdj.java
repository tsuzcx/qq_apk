import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab.SelectVideoTabFragment;

public class sdj
  extends pvq
{
  public sdj(SelectVideoTabFragment paramSelectVideoTabFragment) {}
  
  public void i(int paramInt)
  {
    super.i(paramInt);
    if ((SelectVideoTabFragment.a(this.a) != null) && (paramInt != 0) && (!SelectVideoTabFragment.a(this.a).isEmpty()))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_column_id", paramInt);
      localIntent.putExtra("arg_callback", SelectVideoTabFragment.a(this.a));
      SelectVideoTabFragment.a(this.a).setResult(3, localIntent);
      SelectVideoTabFragment.a(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdj
 * JD-Core Version:    0.7.0.1
 */