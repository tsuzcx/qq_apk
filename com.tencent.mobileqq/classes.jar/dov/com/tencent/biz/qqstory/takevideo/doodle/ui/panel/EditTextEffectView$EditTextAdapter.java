package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import aojz;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.List;

public class EditTextEffectView$EditTextAdapter
  extends RecyclerView.Adapter
{
  public OnHolderItemClickListener a;
  public DynamicTextConfigManager a;
  List jdField_a_of_type_JavaUtilList;
  
  public EditTextEffectView$EditTextAdapter(EditTextEffectView paramEditTextEffectView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)QIMManager.a(7));
  }
  
  public aojz a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aojz(LayoutInflater.from(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.getContext()).inflate(2130970731, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener);
  }
  
  public void a(aojz paramaojz, int paramInt)
  {
    DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = (DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramaojz.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = localDynamicTextConfigBean;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramaojz.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (paramInt % 3 == 0)
    {
      localMarginLayoutParams.leftMargin = 0;
      localMarginLayoutParams.rightMargin = (EditTextEffectView.d / 2);
      if (paramInt / 3 != 0) {
        break label201;
      }
      localMarginLayoutParams.topMargin = 0;
      localMarginLayoutParams.bottomMargin = (EditTextEffectView.e / 2);
      label75:
      paramaojz.b.setVisibility(8);
      if (localDynamicTextConfigBean.text_id != this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.jdField_a_of_type_Int) {
        break label257;
      }
      paramaojz.c.setVisibility(0);
      label106:
      paramaojz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(localDynamicTextConfigBean.iconDrawableId);
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(localDynamicTextConfigBean)) {
        break label269;
      }
      paramaojz.d.setVisibility(8);
    }
    for (;;)
    {
      paramaojz.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      paramaojz.jdField_a_of_type_Int = paramInt;
      return;
      if (paramInt % 3 == 2)
      {
        localMarginLayoutParams.leftMargin = (EditTextEffectView.d / 2);
        localMarginLayoutParams.rightMargin = 0;
        break;
      }
      localMarginLayoutParams.leftMargin = (EditTextEffectView.d / 2);
      localMarginLayoutParams.rightMargin = (EditTextEffectView.d / 2);
      break;
      label201:
      if (paramInt / 3 == getItemCount() / 3)
      {
        localMarginLayoutParams.topMargin = (EditTextEffectView.e / 2);
        localMarginLayoutParams.bottomMargin = EditTextEffectView.e;
        break label75;
      }
      localMarginLayoutParams.topMargin = (EditTextEffectView.e / 2);
      localMarginLayoutParams.bottomMargin = (EditTextEffectView.e / 2);
      break label75;
      label257:
      paramaojz.c.setVisibility(8);
      break label106;
      label269:
      paramaojz.d.setVisibility(0);
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView.EditTextAdapter
 * JD-Core Version:    0.7.0.1
 */