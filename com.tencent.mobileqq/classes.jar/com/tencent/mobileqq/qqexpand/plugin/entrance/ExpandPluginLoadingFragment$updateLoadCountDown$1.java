package com.tencent.mobileqq.qqexpand.plugin.entrance;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandPluginLoadingFragment$updateLoadCountDown$1
  implements Runnable
{
  ExpandPluginLoadingFragment$updateLoadCountDown$1(ExpandPluginLoadingFragment paramExpandPluginLoadingFragment, int paramInt) {}
  
  public final void run()
  {
    TextView localTextView = ExpandPluginLoadingFragment.d(this.this$0);
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    localTextView = ExpandPluginLoadingFragment.d(this.this$0);
    if (localTextView != null)
    {
      Object localObject = StringCompanionObject.INSTANCE;
      localObject = BaseApplicationImpl.context;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.context");
      localObject = ((BaseApplication)localObject).getResources().getString(2131698872);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.cont…friend_plugin_count_down)");
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.a);
      localObject = String.format((String)localObject, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      localTextView.setText((CharSequence)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLoadingFragment.updateLoadCountDown.1
 * JD-Core Version:    0.7.0.1
 */