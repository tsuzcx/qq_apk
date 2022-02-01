package com.tencent.mobileqq.qqexpand.plugin.entrance;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qqexpand.utils.ExpandReportUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandPluginLoadingFragment$updateLoadingStatus$1
  implements Runnable
{
  ExpandPluginLoadingFragment$updateLoadingStatus$1(ExpandPluginLoadingFragment paramExpandPluginLoadingFragment, LoadingStatus paramLoadingStatus, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    ExpandPluginLoadingFragment.a(this.this$0, this.a);
    Object localObject = this.a;
    int i = ExpandPluginLoadingFragment.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          this.this$0.d(2);
          return;
        }
        ExpandPluginLoadingFragment.g(this.this$0).setVisibility(0);
        localObject = this.this$0;
        if ((this.b == 0) && (ExpandPluginLoadingFragment.i((ExpandPluginLoadingFragment)localObject) != 0)) {
          i = ExpandPluginLoadingFragment.i(this.this$0);
        } else {
          i = this.b;
        }
        ExpandPluginLoadingFragment.a((ExpandPluginLoadingFragment)localObject, i);
        localObject = ExpandPluginLoadingFragment.a(this.this$0);
        if (localObject != null) {
          ((TextView)localObject).setText(2131896847);
        }
        localObject = ExpandPluginLoadingFragment.b(this.this$0);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = ExpandPluginLoadingFragment.b(this.this$0);
        if (localObject != null) {
          ((TextView)localObject).setText(2131896848);
        }
        localObject = ExpandPluginLoadingFragment.c(this.this$0);
        if (localObject != null) {
          ((URLImageView)localObject).setVisibility(8);
        }
        localObject = ExpandPluginLoadingFragment.d(this.this$0);
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = ExpandPluginLoadingFragment.e(this.this$0);
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(8);
        }
        localObject = ExpandPluginLoadingFragment.f(this.this$0);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = ExpandPluginLoadingFragment.h(this.this$0);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        localObject = (Map)new HashMap();
        ((Map)localObject).put("load_error", String.valueOf(this.c));
        ((Map)localObject).put("error_reason", String.valueOf(this.b));
        ExpandReportUtils.a("expose#launch_download_error_page#view", true, -1L, -1L, (Map)localObject, true, true);
        return;
      }
      ExpandPluginLoadingFragment.g(this.this$0).setVisibility(0);
      localObject = ExpandPluginLoadingFragment.a(this.this$0);
      if (localObject != null) {
        ((TextView)localObject).setText(2131896847);
      }
      localObject = ExpandPluginLoadingFragment.b(this.this$0);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = ExpandPluginLoadingFragment.b(this.this$0);
      if (localObject != null) {
        ((TextView)localObject).setText(2131896849);
      }
      localObject = ExpandPluginLoadingFragment.c(this.this$0);
      if (localObject != null) {
        ((URLImageView)localObject).setVisibility(8);
      }
      localObject = ExpandPluginLoadingFragment.d(this.this$0);
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = ExpandPluginLoadingFragment.e(this.this$0);
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(8);
      }
      localObject = ExpandPluginLoadingFragment.f(this.this$0);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = ExpandPluginLoadingFragment.h(this.this$0);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      ExpandReportUtils.a("expose#launch_network_error_page#view", true, -1L, -1L, null, true, true);
      return;
    }
    localObject = ExpandPluginLoadingFragment.a(this.this$0);
    if (localObject != null) {
      ((TextView)localObject).setText(2131896846);
    }
    localObject = ExpandPluginLoadingFragment.b(this.this$0);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = ExpandPluginLoadingFragment.c(this.this$0);
    if (localObject != null) {
      ((URLImageView)localObject).setVisibility(0);
    }
    localObject = ExpandPluginLoadingFragment.d(this.this$0);
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = ExpandPluginLoadingFragment.e(this.this$0);
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(0);
    }
    localObject = ExpandPluginLoadingFragment.f(this.this$0);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLoadingFragment.updateLoadingStatus.1
 * JD-Core Version:    0.7.0.1
 */