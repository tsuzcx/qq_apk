package dov.com.qq.im.aeeditor.module.filter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import dov.com.qq.im.ae.view.AEDownLoadingView;

public class FiltersAdapter$VH
  extends RecyclerView.ViewHolder
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AEDownLoadingView jdField_a_of_type_DovComQqImAeViewAEDownLoadingView;
  ImageView b;
  ImageView c;
  ImageView d;
  ImageView e;
  ImageView f;
  
  public FiltersAdapter$VH(FiltersAdapter paramFiltersAdapter, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368754));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379105));
    this.b = ((ImageView)paramView.findViewById(2131377706));
    this.c = ((ImageView)paramView.findViewById(2131365998));
    this.d = ((ImageView)paramView.findViewById(2131365994));
    this.e = ((ImageView)paramView.findViewById(2131370733));
    this.f = ((ImageView)paramView.findViewById(2131370736));
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131373580));
    int i = AIOUtils.a(6.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    int j = AIOUtils.a(2.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    int k = AIOUtils.a(16.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgCorner(k / 2);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgColor(0);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressColor(-1);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.a(false);
  }
  
  public void a(AEEditorFilterBean paramAEEditorFilterBean)
  {
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(paramAEEditorFilterBean.getProgress());
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.FiltersAdapter.VH
 * JD-Core Version:    0.7.0.1
 */