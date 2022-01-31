package dov.com.qq.im.ae.camera.ui.watermark;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.ttpic.openapi.model.WMElement;
import java.util.ArrayList;
import java.util.List;

public class WatermarkListView
  extends ScrollView
{
  private RecyclerView.Adapter<RecyclerView.ViewHolder> jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private List<RecyclerView.ViewHolder> jdField_a_of_type_JavaUtilList;
  
  public WatermarkListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WatermarkListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WatermarkListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramContext);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public RecyclerView.Adapter<RecyclerView.ViewHolder> a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  }
  
  public RecyclerView.ViewHolder a(int paramInt)
  {
    return (RecyclerView.ViewHolder)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> paramAdapter, List<WMElement> paramList)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter = paramAdapter;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i = 0;
    while (i < paramAdapter.getItemCount())
    {
      paramList = paramAdapter.onCreateViewHolder(this.jdField_a_of_type_AndroidWidgetLinearLayout, 0);
      paramAdapter.onBindViewHolder(paramList, i);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList.itemView, localLayoutParams);
      this.jdField_a_of_type_JavaUtilList.add(paramList);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkListView
 * JD-Core Version:    0.7.0.1
 */