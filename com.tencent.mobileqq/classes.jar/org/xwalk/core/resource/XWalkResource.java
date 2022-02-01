package org.xwalk.core.resource;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;

public class XWalkResource
  extends Resources
{
  private WeakReference<Context> mWeChatContext;
  
  public XWalkResource(Resources paramResources, Context paramContext)
  {
    super(paramResources.getAssets(), paramContext.getResources().getDisplayMetrics(), paramResources.getConfiguration());
    this.mWeChatContext = new WeakReference(paramContext);
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    Context localContext = (Context)this.mWeChatContext.get();
    if (localContext != null) {
      return localContext.getResources().getDisplayMetrics();
    }
    return super.getDisplayMetrics();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.updateConfiguration(paramConfiguration, getDisplayMetrics());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.resource.XWalkResource
 * JD-Core Version:    0.7.0.1
 */