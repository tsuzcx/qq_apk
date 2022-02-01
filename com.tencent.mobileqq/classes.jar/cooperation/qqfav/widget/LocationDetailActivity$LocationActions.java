package cooperation.qqfav.widget;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class LocationDetailActivity$LocationActions
  extends FavoriteActionSheet.DefaultActions
{
  private WeakReference<LocationDetailActivity> a;
  
  public LocationDetailActivity$LocationActions(LocationDetailActivity paramLocationDetailActivity)
  {
    this.a = new WeakReference(paramLocationDetailActivity);
  }
  
  public void a()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    LocationDetailActivity.g(localLocationDetailActivity);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    localLocationDetailActivity.a(paramBundle);
  }
  
  public void c()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    LocationDetailActivity.i(localLocationDetailActivity);
  }
  
  public void d()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    if (localLocationDetailActivity.k()) {
      localLocationDetailActivity.finish();
    }
  }
  
  public void e()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    localLocationDetailActivity.l();
  }
  
  public int f()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return 0;
    }
    return LocationDetailActivity.h(localLocationDetailActivity);
  }
  
  public void g()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    Intent localIntent = LocationDetailActivity.j(localLocationDetailActivity);
    if (localIntent != null)
    {
      ForwardBaseOption.a(localLocationDetailActivity, localIntent, 103);
      return;
    }
    QQToast.makeText(localLocationDetailActivity, 2131889192, 1, 2000).show(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity.LocationActions
 * JD-Core Version:    0.7.0.1
 */