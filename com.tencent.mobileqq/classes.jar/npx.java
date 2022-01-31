import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountBrowser.12.1;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.qphone.base.util.QLog;

public class npx
  extends oxe
{
  public npx(PublicAccountBrowser paramPublicAccountBrowser) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (PublicAccountBrowser.a(this.a) != null))
    {
      Object localObject = new int[2];
      PublicAccountBrowser.a(this.a).getLocationInWindow((int[])localObject);
      if (PublicAccountBrowser.b(this.a) == null)
      {
        PublicAccountBrowser.b(this.a, new RIJRedPacketPopupView(this.a));
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout)this.a.findViewById(2131363457)).addView(PublicAccountBrowser.b(this.a), (ViewGroup.LayoutParams)localObject);
      }
      PublicAccountBrowser.b(this.a).a(false);
      PublicAccountBrowser.b(this.a).b(false);
      PublicAccountBrowser.b(this.a).setText(paramString);
      PublicAccountBrowser.b(this.a).setVisibility(4);
      PublicAccountBrowser.b(this.a).post(new PublicAccountBrowser.12.1(this, paramString));
      PublicAccountBrowser.b(this.a, true);
      return;
    }
    QLog.i("PublicAccountBrowser", 1, " red packet task do not get Tips!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     npx
 * JD-Core Version:    0.7.0.1
 */