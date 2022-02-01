package dov.com.qq.im.aeeditor.module.autotemplate;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.aeeditor.module.filter.AdapterUtil;
import java.util.ArrayList;
import java.util.List;

public class AEAutoTemplateCategoryAdapter
  extends RecyclerView.Adapter<AEAutoTemplateCategoryAdapter.VH>
{
  private int jdField_a_of_type_Int = -1;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AEAutoTemplateCategoryAdapter.OnItemClickListener jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateCategoryAdapter$OnItemClickListener;
  private List<MetaCategory> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public AEAutoTemplateCategoryAdapter.VH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEAutoTemplateCategoryAdapter.VH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558564, paramViewGroup, false));
  }
  
  public List<MetaCategory> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt >= 0) {
      AdapterUtil.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramInt, false);
    }
    notifyDataSetChanged();
  }
  
  public void a(AEAutoTemplateCategoryAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateCategoryAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(AEAutoTemplateCategoryAdapter.VH paramVH, int paramInt)
  {
    paramVH.a.setText(((MetaCategory)this.jdField_a_of_type_JavaUtilList.get(paramInt)).name);
    paramVH.a.setOnClickListener(new AEAutoTemplateCategoryAdapter.1(this, paramInt));
    if (this.jdField_a_of_type_Int == paramInt)
    {
      paramVH.a.setTextColor(paramVH.itemView.getContext().getResources().getColor(2131166282));
      paramVH.a.setTypeface(Typeface.defaultFromStyle(1));
    }
    for (;;)
    {
      AEReportUtils.j(((MetaCategory)this.jdField_a_of_type_JavaUtilList.get(paramInt)).id);
      EventCollector.getInstance().onRecyclerBindViewHolder(paramVH, paramInt, getItemId(paramInt));
      return;
      paramVH.a.setTextColor(paramVH.itemView.getContext().getResources().getColor(2131166284));
      paramVH.a.setTypeface(Typeface.defaultFromStyle(0));
    }
  }
  
  public void a(List<MetaCategory> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
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
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */