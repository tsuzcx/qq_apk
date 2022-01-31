import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;

public class pvl
  implements View.OnClickListener
{
  public pvl(PTSFragment paramPTSFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getContext();
    Intent localIntent = new Intent(paramView, AccountDetailActivity.class);
    localIntent.putExtra("uin", String.valueOf(3434959637L));
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("source", 121);
    paramView.startActivity(localIntent);
    nrt.a(null, "", "0X8009941", "0X8009941", 0, 0, "", "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pvl
 * JD-Core Version:    0.7.0.1
 */