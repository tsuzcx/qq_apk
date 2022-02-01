package dov.com.tencent.mobileqq.activity.richmedia;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

public class QzoneEditPicturePartSave
  extends EditPicSave
{
  private View a;
  
  public QzoneEditPicturePartSave(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public void a()
  {
    super.a();
    this.a = a(2131375844);
    ((Button)a(2131367196)).setOnClickListener(new QzoneEditPicturePartSave.1(this));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    paramObject = this.a;
    if ((paramInt == 0) || (paramInt == 4)) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramObject.setVisibility(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPicturePartSave
 * JD-Core Version:    0.7.0.1
 */