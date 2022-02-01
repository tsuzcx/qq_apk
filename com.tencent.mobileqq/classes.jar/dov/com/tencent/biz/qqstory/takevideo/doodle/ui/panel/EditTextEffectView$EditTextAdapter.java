package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.text.DynamicTextBuilder;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.List;

public class EditTextEffectView$EditTextAdapter
  extends RecyclerView.Adapter<EditTextEffectView.EditTextHolder>
{
  public OnHolderItemClickListener a;
  public DynamicTextConfigManager a;
  List<DynamicTextConfigManager.DynamicTextConfigBean> jdField_a_of_type_JavaUtilList;
  
  public EditTextEffectView$EditTextAdapter(EditTextEffectView paramEditTextEffectView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)QIMManager.a(7));
  }
  
  public EditTextEffectView.EditTextHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new EditTextEffectView.EditTextHolder(LayoutInflater.from(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.getContext()).inflate(2131561794, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener);
  }
  
  public void a(EditTextEffectView.EditTextHolder paramEditTextHolder, int paramInt)
  {
    Object localObject = (DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramEditTextHolder.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = ((DynamicTextConfigManager.DynamicTextConfigBean)localObject);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramEditTextHolder.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localMarginLayoutParams.leftMargin = EditTextEffectView.b;
    localMarginLayoutParams.bottomMargin = EditTextEffectView.jdField_a_of_type_Int;
    localMarginLayoutParams.topMargin = EditTextEffectView.c;
    paramEditTextHolder.b.setVisibility(8);
    if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id == this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView.d)
    {
      paramEditTextHolder.c.setVisibility(0);
      paramEditTextHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).iconDrawableId);
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject)) {
        break label206;
      }
      paramEditTextHolder.d.setVisibility(8);
      label117:
      paramEditTextHolder.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      paramEditTextHolder.jdField_a_of_type_Int = paramInt;
      localObject = DynamicTextBuilder.a(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id);
      if (localObject == null) {
        break label217;
      }
      paramEditTextHolder.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131703731) + (String)localObject + HardCodeUtil.a(2131703732));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramEditTextHolder, paramInt, getItemId(paramInt));
      return;
      paramEditTextHolder.c.setVisibility(8);
      break;
      label206:
      paramEditTextHolder.d.setVisibility(0);
      break label117;
      label217:
      paramEditTextHolder.jdField_a_of_type_AndroidViewView.setContentDescription(null);
    }
  }
  
  public void a(List<DynamicTextConfigManager.DynamicTextConfigBean> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView.EditTextAdapter
 * JD-Core Version:    0.7.0.1
 */