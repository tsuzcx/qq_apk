package com.tencent.mobileqq.winkpublish.part;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishLabelViewModel.UpdateLabelInfoOnChange;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class PublishLabelPart$9
  implements Observer<PublishLabelViewModel.UpdateLabelInfoOnChange>
{
  PublishLabelPart$9(PublishLabelPart paramPublishLabelPart) {}
  
  public void a(@Nullable PublishLabelViewModel.UpdateLabelInfoOnChange paramUpdateLabelInfoOnChange)
  {
    Object localObject1 = paramUpdateLabelInfoOnChange.a;
    int i = paramUpdateLabelInfoOnChange.b;
    paramUpdateLabelInfoOnChange = PublishLabelPart.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onChanged... updateSize:");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(" labelInfos:");
    QLog.d(paramUpdateLabelInfoOnChange, 1, new Object[] { ((StringBuilder)localObject2).toString(), ((ArrayList)localObject1).toString() });
    if (PublishLabelPart.j(this.a) != null)
    {
      if (((ArrayList)localObject1).size() > 0)
      {
        if (PublishLabelPart.j(this.a).getVisibility() != 0)
        {
          PublishLabelPart.b(this.a).notifyDataSetChanged();
          PublishLabelPart.k(this.a).scrollToPosition(0);
          PublishLabelPart.j(this.a).setVisibility(0);
          paramUpdateLabelInfoOnChange = ValueAnimator.ofFloat(new float[] { 0.0F, ViewUtils.dip2px(19.0F) });
          paramUpdateLabelInfoOnChange.addUpdateListener(new PublishLabelPart.9.1(this));
          localObject1 = ObjectAnimator.ofFloat(PublishLabelPart.j(this.a), "translationY", new float[] { -ViewUtils.dip2px(16.0F), 0.0F });
          localObject2 = new AnimatorSet();
          ((AnimatorSet)localObject2).setDuration(200L);
          ((AnimatorSet)localObject2).play(paramUpdateLabelInfoOnChange).with((Animator)localObject1);
          ((AnimatorSet)localObject2).start();
          return;
        }
        if (i > 0)
        {
          if (i >= 2) {
            PublishLabelPart.k(this.a).getItemAnimator().setAddDuration(400L);
          } else {
            PublishLabelPart.k(this.a).getItemAnimator().setAddDuration(200L);
          }
          PublishLabelPart.b(this.a).notifyItemRangeInserted(0, i);
          PublishLabelPart.k(this.a).scrollToPosition(0);
          return;
        }
        PublishLabelPart.b(this.a).notifyDataSetChanged();
        return;
      }
      if (PublishLabelPart.j(this.a).getVisibility() != 8) {
        PublishLabelPart.j(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLabelPart.9
 * JD-Core Version:    0.7.0.1
 */