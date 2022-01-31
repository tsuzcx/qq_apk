package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.smtt.sdk.ValueCallback;
import java.lang.ref.WeakReference;

class TBSActivityPicker$2
  implements View.OnClickListener
{
  TBSActivityPicker$2(TBSActivityPicker paramTBSActivityPicker) {}
  
  public void onClick(View paramView)
  {
    Object localObject = TBSActivityPicker.access$000(this.this$0).getCheckedActivityInfo();
    if ((localObject == null) || (((BrowsingActivityInfo)localObject).getResolveInfo() == null)) {
      return;
    }
    paramView = TBSActivityPicker.access$100(this.this$0);
    Context localContext = this.this$0.getContext();
    localObject = ((BrowsingActivityInfo)localObject).getResolveInfo().activityInfo.packageName;
    paramView.setPackage((String)localObject);
    if ("com.tencent.mtt".equals(localObject))
    {
      paramView.putExtra("ChannelID", localContext.getApplicationContext().getPackageName());
      paramView.putExtra("PosID", "4");
    }
    if ((localContext != null) && (localContext.getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24)) {
      paramView.addFlags(1);
    }
    if (!TextUtils.isEmpty(TBSActivityPicker.access$200(this.this$0))) {
      paramView.putExtra("big_brother_source_key", TBSActivityPicker.access$200(this.this$0));
    }
    localContext.startActivity(paramView);
    if (TBSActivityPicker.mIntentCallback.get() != null) {
      ((ValueCallback)TBSActivityPicker.mIntentCallback.get()).onReceiveValue("once");
    }
    this.this$0.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.TBSActivityPicker.2
 * JD-Core Version:    0.7.0.1
 */