package cooperation.qqreader.host;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Window;
import bixf;

public class ActivityWrapper
{
  private Activity a;
  
  public ActivityWrapper(Context paramContext)
  {
    this.a = bixf.a(paramContext);
  }
  
  public void finish()
  {
    if (this.a != null) {
      this.a.finish();
    }
  }
  
  public Context getContext()
  {
    return this.a;
  }
  
  public Window getWindow()
  {
    if (this.a != null) {
      return this.a.getWindow();
    }
    return null;
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (this.a != null) {
      this.a.startActivity(paramIntent);
    }
  }
  
  @RequiresApi(api=16)
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.startActivity(paramIntent, paramBundle);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.a != null) {
      this.a.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  @RequiresApi(api=16)
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.startActivityForResult(paramIntent, paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.ActivityWrapper
 * JD-Core Version:    0.7.0.1
 */