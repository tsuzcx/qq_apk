import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class nij
  implements mzi
{
  public nij(AVGameRoomCenterFragment paramAVGameRoomCenterFragment) {}
  
  public void a(View paramView, myy parammyy, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BannerClick", 2, "Banner click");
    }
    if (parammyy == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            parammyy = ((myv)parammyy).a();
          } while ((parammyy == null) || (parammyy.size() == 0) || (paramInt >= parammyy.size()));
          paramView = paramView.getContext();
          parammyy = ((nil)parammyy.get(0)).b;
        } while (parammyy == null);
        if (parammyy.startsWith("http"))
        {
          bcef.b(AVGameRoomCenterFragment.a(this.a).app, "dc00898", "", "", "0X800B494", "0X800B494", 1, 0, "", "", "", "");
          Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
          localIntent.putExtra("url", parammyy);
          paramView.startActivity(localIntent);
          return;
        }
      } while (!parammyy.startsWith("mqqapi"));
      bcef.b(AVGameRoomCenterFragment.a(this.a).app, "dc00898", "", "", "0X800B494", "0X800B494", 2, 0, "", "", "", "");
      paramView = new anpx().a(AVGameRoomCenterFragment.a(this.a).app, AVGameRoomCenterFragment.a(this.a), parammyy);
    } while (!(paramView instanceof anpw));
    ((anpw)paramView).a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nij
 * JD-Core Version:    0.7.0.1
 */