package com.tencent.mobileqq.colornote.settings;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;
import mqq.app.AppRuntime;

class BaseSectionAdapter$2
  implements HistoryFormItem.OnIconClickListener
{
  BaseSectionAdapter$2(BaseSectionAdapter paramBaseSectionAdapter, HistoryFormItem paramHistoryFormItem) {}
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    ColorNoteCurd localColorNoteCurd = new ColorNoteCurd();
    if ((((IColorNoteHelper)BaseSectionAdapter.c(this.b).getRuntimeService(IColorNoteHelper.class, "all")).canAddColorNote()) && (this.a.b()))
    {
      Object localObject = null;
      ColorNote localColorNote2 = (ColorNote)BaseSectionAdapter.a(this.b).get(paramInt);
      try
      {
        ColorNote localColorNote1 = (ColorNote)localColorNote2.clone();
        localObject = localColorNote1;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        localCloneNotSupportedException.printStackTrace();
      }
      if (localObject != null)
      {
        localObject.setType(0);
        localColorNoteCurd.a(localObject.parseBundle());
      }
      this.a.setEnable(false);
      BaseSectionAdapter.a(this.b, localColorNote2, paramInt);
      QQToast.makeText(paramView.getContext(), 2, HardCodeUtil.a(2131887856), 500).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.BaseSectionAdapter.2
 * JD-Core Version:    0.7.0.1
 */