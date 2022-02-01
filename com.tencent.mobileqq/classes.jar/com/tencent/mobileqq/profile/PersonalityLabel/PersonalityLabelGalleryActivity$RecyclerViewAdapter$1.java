package com.tencent.mobileqq.profile.PersonalityLabel;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class PersonalityLabelGalleryActivity$RecyclerViewAdapter$1
  implements ActionSheet.OnButtonClickListener
{
  PersonalityLabelGalleryActivity$RecyclerViewAdapter$1(PersonalityLabelGalleryActivity.RecyclerViewAdapter paramRecyclerViewAdapter, PLUploadManager.UploadItem paramUploadItem) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        paramView = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.j(this.b.a).get(Long.valueOf(PersonalityLabelGalleryActivity.RecyclerViewAdapter.a(this.b)));
        if (paramView == null)
        {
          this.b.a.r.superDismiss();
          return;
        }
        int j = -1;
        paramInt = 0;
        int i;
        for (;;)
        {
          i = j;
          if (paramInt >= paramView.personalityLabelPhotos.size()) {
            break;
          }
          if (((PersonalityLabelPhoto)paramView.personalityLabelPhotos.get(paramInt)).uniseq == this.a.c.uniseq)
          {
            paramView.personalityLabelPhotos.remove(paramInt);
            i = paramInt;
            break;
          }
          paramInt += 1;
        }
        if (i < 0)
        {
          this.b.a.r.superDismiss();
          return;
        }
        paramView.photoCount -= 1;
        PersonalityLabelGalleryActivity.a(this.b.a, PersonalityLabelGalleryActivity.RecyclerViewAdapter.a(this.b), paramView);
        this.b.a.q.b(PersonalityLabelGalleryActivity.RecyclerViewAdapter.a(this.b), this.a.c);
      }
    }
    else {
      this.b.a.q.a(PersonalityLabelGalleryActivity.RecyclerViewAdapter.a(this.b), this.a.c);
    }
    this.b.a.r.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.RecyclerViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */