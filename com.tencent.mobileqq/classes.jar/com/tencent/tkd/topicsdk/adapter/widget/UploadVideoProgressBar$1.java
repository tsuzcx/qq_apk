package com.tencent.tkd.topicsdk.adapter.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class UploadVideoProgressBar$1
  implements View.OnClickListener
{
  UploadVideoProgressBar$1(UploadVideoProgressBar paramUploadVideoProgressBar) {}
  
  public final void onClick(View paramView)
  {
    paramView = UploadVideoProgressBar.a(this.a);
    int i = UploadVideoProgressBar.WhenMappings.a[paramView.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          UploadVideoProgressBar.b(this.a);
          UploadVideoProgressBar.a(this.a, ReportEventElement.BUTTON_PROGRESSBAR_RETRY);
        }
      }
      else
      {
        UploadVideoProgressBar.b(this.a);
        UploadVideoProgressBar.a(this.a, ReportEventElement.BUTTON_PROGRESSBAR_UPLOAD);
      }
    }
    else
    {
      UploadVideoProgressBar.a(this.a);
      this.a.b();
      UploadVideoProgressBar.a(this.a, ReportEventElement.BUTTON_PROGRESSBAR_PAUSE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.UploadVideoProgressBar.1
 * JD-Core Version:    0.7.0.1
 */