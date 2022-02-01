package com.tencent.mobileqq.colornote.settings;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.ColorNoteHelper;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class BaseSectionAdapter$2
  implements HistoryFormItem.OnIconClickListener
{
  BaseSectionAdapter$2(BaseSectionAdapter paramBaseSectionAdapter, HistoryFormItem paramHistoryFormItem) {}
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    ColorNoteCurd localColorNoteCurd = new ColorNoteCurd();
    ColorNote localColorNote2;
    if ((ColorNoteHelper.a()) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a())) {
      localColorNote2 = (ColorNote)BaseSectionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsBaseSectionAdapter).get(paramInt);
    }
    try
    {
      ColorNote localColorNote1 = (ColorNote)localColorNote2.clone();
      if (localColorNote1 != null)
      {
        localColorNote1.setType(0);
        localColorNoteCurd.a(localColorNote1.parseBundle());
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.setEnable(false);
      BaseSectionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsBaseSectionAdapter, localColorNote2, paramInt);
      QQToast.a(paramView.getContext(), 2, HardCodeUtil.a(2131690997), 500).a();
      return;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.BaseSectionAdapter.2
 * JD-Core Version:    0.7.0.1
 */