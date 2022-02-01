package dov.com.qq.im.aeeditor.module.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerGroup;
import dov.com.qq.im.aeeditor.module.filter.AdapterUtil;
import java.util.ArrayList;
import java.util.List;

public class AETextStickerCategoryAdapter
  extends RecyclerView.Adapter<AETextStickerCategoryAdapter.VH>
{
  private int jdField_a_of_type_Int = -1;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AETextStickerCategoryAdapter.OnItemClickListener jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerCategoryAdapter$OnItemClickListener;
  private List<AEEditorPagStickerGroup> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public AETextStickerCategoryAdapter.VH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AETextStickerCategoryAdapter.VH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558599, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt >= 0) {
      AdapterUtil.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramInt, false);
    }
    notifyDataSetChanged();
  }
  
  public void a(AETextStickerCategoryAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerCategoryAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(AETextStickerCategoryAdapter.VH paramVH, int paramInt)
  {
    paramVH.a.setText(((AEEditorPagStickerGroup)this.jdField_a_of_type_JavaUtilList.get(paramInt)).stickerGroupName);
    paramVH.a.setOnClickListener(new AETextStickerCategoryAdapter.1(this, paramInt));
    if (this.jdField_a_of_type_Int == paramInt)
    {
      paramVH.a.setTextColor(paramVH.itemView.getContext().getResources().getColor(2131166282));
      paramVH.a.setTypeface(Typeface.defaultFromStyle(1));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramVH, paramInt, getItemId(paramInt));
      return;
      paramVH.a.setTextColor(paramVH.itemView.getContext().getResources().getColor(2131166284));
      paramVH.a.setTypeface(Typeface.defaultFromStyle(0));
    }
  }
  
  public void a(List<AEEditorPagStickerGroup> paramList)
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
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AETextStickerCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */