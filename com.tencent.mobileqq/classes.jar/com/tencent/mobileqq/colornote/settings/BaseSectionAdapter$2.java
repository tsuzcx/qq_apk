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
    if ((((IColorNoteHelper)BaseSectionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsBaseSectionAdapter).getRuntimeService(IColorNoteHelper.class, "all")).canAddColorNote()) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a()))
    {
      Object localObject = null;
      ColorNote localColorNote2 = (ColorNote)BaseSectionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsBaseSectionAdapter).get(paramInt);
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
      this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.setEnable(false);
      BaseSectionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsBaseSectionAdapter, localColorNote2, paramInt);
      QQToast.a(paramView.getContext(), 2, HardCodeUtil.a(2131690917), 500).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.BaseSectionAdapter.2
 * JD-Core Version:    0.7.0.1
 */