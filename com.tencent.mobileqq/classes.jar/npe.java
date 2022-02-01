import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class npe
  implements ney
{
  public npe(AVGameRoomCenterFragment paramAVGameRoomCenterFragment) {}
  
  public void a(View paramView, nel paramnel, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BannerClick", 2, "Banner click");
    }
    if (paramnel == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramnel = ((neh)paramnel).a();
          } while ((paramnel == null) || (paramnel.size() == 0) || (paramInt >= paramnel.size()));
          paramView = paramView.getContext();
          paramnel = ((nph)paramnel.get(0)).b;
        } while (paramnel == null);
        if (paramnel.startsWith("http"))
        {
          bdla.b(AVGameRoomCenterFragment.a(this.a).app, "dc00898", "", "", "0X800B494", "0X800B494", 1, 0, "", "", "", "");
          Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
          localIntent.putExtra("url", paramnel);
          paramView.startActivity(localIntent);
          return;
        }
      } while (!paramnel.startsWith("mqqapi"));
      bdla.b(AVGameRoomCenterFragment.a(this.a).app, "dc00898", "", "", "0X800B494", "0X800B494", 2, 0, "", "", "", "");
      paramView = new aosq().a(AVGameRoomCenterFragment.a(this.a).app, AVGameRoomCenterFragment.a(this.a), paramnel);
    } while (!(paramView instanceof aosp));
    ((aosp)paramView).a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npe
 * JD-Core Version:    0.7.0.1
 */