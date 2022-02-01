package dov.com.qq.im.aeeditor.module.text;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class AEEditorColorAdapter
  extends RecyclerView.Adapter<AEEditorColorAdapter.VH>
{
  private int jdField_a_of_type_Int = -1;
  private final AEEditorEditColorSelected jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorEditColorSelected;
  private String jdField_a_of_type_JavaLangString = "";
  private final List<Integer> jdField_a_of_type_JavaUtilList;
  private String b = "";
  
  public AEEditorColorAdapter(String paramString, List<Integer> paramList, AEEditorEditColorSelected paramAEEditorEditColorSelected)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorEditColorSelected = paramAEEditorEditColorSelected;
  }
  
  private int a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
    }
    return 0;
  }
  
  private void b(AEEditorColorAdapter.VH paramVH, int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      paramVH.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    paramVH.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public AEEditorColorAdapter.VH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEEditorColorAdapter.VH(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558569, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt >= 0) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorEditColorSelected.a(this.jdField_a_of_type_JavaLangString, a(paramInt), paramInt, this.b);
    }
  }
  
  public void a(AEEditorColorAdapter.VH paramVH, int paramInt)
  {
    paramVH.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(AEEditorColorSelectorView.a(paramVH.jdField_a_of_type_AndroidWidgetImageView, false, a(paramInt)));
    paramVH.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEEditorColorAdapter.1(this, paramInt, paramVH));
    if (paramInt == 0)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramVH.itemView.getLayoutParams();
      localMarginLayoutParams.leftMargin = localMarginLayoutParams.rightMargin;
      paramVH.itemView.setLayoutParams(localMarginLayoutParams);
    }
    b(paramVH, paramInt);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramVH, paramInt, getItemId(paramInt));
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorColorAdapter
 * JD-Core Version:    0.7.0.1
 */