package com.tencent.mobileqq.studyroom.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class StudyRoomQShadowLauncher$initLoadingView$1
  implements Runnable
{
  StudyRoomQShadowLauncher$initLoadingView$1(StudyRoomQShadowLauncher paramStudyRoomQShadowLauncher) {}
  
  public final void run()
  {
    View localView = LayoutInflater.from(StudyRoomQShadowLauncher.a(this.this$0)).inflate(2131562873, null);
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    Object localObject2 = (Drawable)new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
    localObject1 = URLDrawable.getDrawable("https://downv6.qq.com/innovate/qq/loading.png", (URLDrawable.URLDrawableOptions)localObject1);
    ((ImageView)localView.findViewById(2131370378)).setImageDrawable((Drawable)localObject1);
    localView.findViewById(2131367940).setOnClickListener((View.OnClickListener)new StudyRoomQShadowLauncher.initLoadingView.1.1(this));
    localObject1 = this.this$0;
    localObject2 = localView.findViewById(2131367941);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.gvideo_maintext)");
    StudyRoomQShadowLauncher.a((StudyRoomQShadowLauncher)localObject1, (TextView)localObject2);
    localObject1 = this.this$0;
    localObject2 = localView.findViewById(2131367946);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.gvideo_subtext)");
    StudyRoomQShadowLauncher.b((StudyRoomQShadowLauncher)localObject1, (TextView)localObject2);
    localObject1 = this.this$0;
    localObject2 = localView.findViewById(2131367945);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.gvideo_red_button)");
    StudyRoomQShadowLauncher.a((StudyRoomQShadowLauncher)localObject1, (Button)localObject2);
    localObject1 = this.this$0;
    localObject2 = localView.findViewById(2131367944);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.gvideo_progressbar)");
    StudyRoomQShadowLauncher.a((StudyRoomQShadowLauncher)localObject1, (ProgressBar)localObject2);
    StudyRoomQShadowLauncher.a(this.this$0).onShowLoadingView(localView);
    StudyRoomQShadowLauncher.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher.initLoadingView.1
 * JD-Core Version:    0.7.0.1
 */