package dov.com.qq.im.aeeditor.module.filter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.ae.view.AEDownLoadingView;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import java.io.File;
import java.util.List;

public class FiltersAdapter
  extends RecyclerView.Adapter<FiltersAdapter.VH>
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private FiltersAdapter.FilterListener jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter$FilterListener;
  private List<AEEditorFilterBean> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  
  public FiltersAdapter(List<AEEditorFilterBean> paramList, int paramInt, FiltersAdapter.FilterListener paramFilterListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramInt;
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter$FilterListener = paramFilterListener;
    this.jdField_a_of_type_Boolean = AEThemeUtil.a();
  }
  
  public int a()
  {
    return this.b;
  }
  
  @NonNull
  public FiltersAdapter.VH a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new FiltersAdapter.VH(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558583, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    notifyDataSetChanged();
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new FiltersAdapter.1(this, paramInt));
    }
  }
  
  public void a(@NonNull FiltersAdapter.VH paramVH, int paramInt)
  {
    AEEditorFilterBean localAEEditorFilterBean = (AEEditorFilterBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i;
    if (paramInt == this.b)
    {
      i = 1;
      if (i == 0) {
        break label241;
      }
      paramVH.b.setVisibility(0);
      paramVH.b.setBackgroundResource(2130837929);
      paramVH.c.setVisibility(8);
      paramVH.d.setVisibility(8);
      paramVH.e.setVisibility(8);
      paramVH.f.setVisibility(8);
      paramVH.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      label91:
      if (localAEEditorFilterBean.type != AEEditorFilterBean.FilterID.NON) {
        break label519;
      }
      paramVH.jdField_a_of_type_AndroidWidgetTextView.setText(2131692528);
      if (i == 0) {
        break label507;
      }
      paramVH.b.setImageResource(2130837973);
      paramVH.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      label132:
      paramVH.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837931);
      paramVH.c.setVisibility(8);
      paramVH.d.setVisibility(8);
      paramVH.e.setVisibility(8);
      paramVH.f.setVisibility(8);
      paramVH.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      label186:
      if (this.jdField_a_of_type_Int != 10001) {
        break label708;
      }
      AEReportUtils.b(localAEEditorFilterBean.getEffectId());
    }
    for (;;)
    {
      paramVH.itemView.setOnClickListener(new FiltersAdapter.2(this, localAEEditorFilterBean, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramVH, paramInt, getItemId(paramInt));
      return;
      i = 0;
      break;
      label241:
      paramVH.b.setVisibility(4);
      String str = AEEditorResourceManager.a().b(localAEEditorFilterBean);
      if ((localAEEditorFilterBean.getEditorEffectItem().getPreDownload() != 0) || (localAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK))
      {
        paramVH.c.setVisibility(8);
        paramVH.d.setVisibility(8);
        paramVH.e.setVisibility(8);
        paramVH.f.setVisibility(8);
        paramVH.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
        break label91;
      }
      if (((!TextUtils.isEmpty(str)) && (new File(str).exists())) || (localAEEditorFilterBean.getProgress() == 100))
      {
        paramVH.c.setVisibility(8);
        paramVH.d.setVisibility(8);
        paramVH.e.setVisibility(8);
        paramVH.f.setVisibility(8);
        paramVH.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
        break label91;
      }
      if (localAEEditorFilterBean.getProgress() >= 0)
      {
        paramVH.c.setVisibility(8);
        paramVH.d.setVisibility(8);
        paramVH.e.setVisibility(0);
        paramVH.f.setVisibility(0);
        paramVH.a(localAEEditorFilterBean);
        break label91;
      }
      paramVH.c.setVisibility(0);
      paramVH.d.setVisibility(0);
      paramVH.e.setVisibility(8);
      paramVH.f.setVisibility(8);
      paramVH.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      break label91;
      label507:
      paramVH.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837751);
      break label132;
      label519:
      if (localAEEditorFilterBean.type == AEEditorFilterBean.FilterID.AIFilter)
      {
        paramVH.jdField_a_of_type_AndroidWidgetTextView.setText(2131692523);
        if (i != 0) {
          paramVH.b.setImageResource(2130837973);
        }
        paramVH.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837747);
        paramVH.c.setVisibility(8);
        paramVH.d.setVisibility(8);
        paramVH.e.setVisibility(8);
        paramVH.f.setVisibility(8);
        paramVH.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
        break label186;
      }
      paramVH.jdField_a_of_type_AndroidWidgetTextView.setText(localAEEditorFilterBean.getName());
      if (i != 0)
      {
        if (localAEEditorFilterBean.getEditorEffectItem().getHideAlphaBar() == 1) {
          break label696;
        }
        paramVH.b.setImageResource(2130837757);
      }
      for (;;)
      {
        paramVH.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130837931);
        UIUtils.a(paramVH.jdField_a_of_type_AndroidWidgetImageView, localAEEditorFilterBean.getPicUrl(), UIUtils.a(paramVH.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), UIUtils.a(paramVH.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), null, null);
        break;
        label696:
        paramVH.b.setImageResource(2130837973);
      }
      label708:
      if (this.jdField_a_of_type_Int == 10002) {
        AEReportUtils.n(localAEEditorFilterBean.getEffectId());
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.FiltersAdapter
 * JD-Core Version:    0.7.0.1
 */