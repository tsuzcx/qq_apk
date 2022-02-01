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
  
  public int a()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return 0;
    }
    return LocationDetailActivity.a(localLocationDetailActivity);
  }
  
  public void a()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    LocationDetailActivity.b(localLocationDetailActivity);
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
  
  public void b()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    LocationDetailActivity.c(localLocationDetailActivity);
  }
  
  public void c()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    if (localLocationDetailActivity.c()) {
      localLocationDetailActivity.finish();
    }
  }
  
  public void d()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    localLocationDetailActivity.h();
  }
  
  public void e()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    Intent localIntent = LocationDetailActivity.d(localLocationDetailActivity);
    if (localIntent != null)
    {
      ForwardBaseOption.a(localLocationDetailActivity, localIntent, 103);
      return;
    }
    QQToast.a(localLocationDetailActivity, 2131692205, 1, 2000).b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity.LocationActions
 * JD-Core Version:    0.7.0.1
 */