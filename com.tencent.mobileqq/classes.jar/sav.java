import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.RadioGroup;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment;
import java.util.ArrayList;

public class sav
  implements ViewPager.OnPageChangeListener
{
  public sav(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  private void a(int paramInt)
  {
    if (paramInt == FolderBaseTabFragment.a)
    {
      if (ServiceAccountFolderActivityNew.a(this.a)) {}
      for (str = "1";; str = "2")
      {
        xhe.b("auth_discover", "tofollow", 0, 0, new String[] { str });
        return;
      }
    }
    if (ServiceAccountFolderActivityNew.a(this.a)) {}
    for (String str = "1";; str = "2")
    {
      xhe.b("auth_follow", "todiscover", 0, 0, new String[] { str });
      return;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    wio.a();
    a(paramInt);
    if ((ServiceAccountFolderActivityNew.a(this.a) != null) && (ServiceAccountFolderActivityNew.a(this.a).getChildCount() > paramInt))
    {
      ServiceAccountFolderActivityNew.a(this.a).getChildAt(paramInt).performClick();
      ServiceAccountFolderActivityNew.a(this.a, false);
    }
    ((FolderBaseTabFragment)ServiceAccountFolderActivityNew.a(this.a).get(paramInt)).a(this.a, paramInt);
    long l1;
    long l2;
    if (ServiceAccountFolderActivityNew.a(this.a) > 0L)
    {
      l1 = System.currentTimeMillis();
      l2 = ServiceAccountFolderActivityNew.a(this.a);
      if (ServiceAccountFolderActivityNew.a(this.a) != FolderBaseTabFragment.a) {
        break label173;
      }
    }
    label173:
    for (String str = "auth_follow";; str = "auth_discover")
    {
      xhe.a(str, "exp", 0, 0, new String[] { String.valueOf(l1 - l2) });
      ServiceAccountFolderActivityNew.a(this.a, 0L);
      ServiceAccountFolderActivityNew.a(this.a, System.currentTimeMillis());
      ServiceAccountFolderActivityNew.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sav
 * JD-Core Version:    0.7.0.1
 */