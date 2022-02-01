package dov.com.qq.im.ae.camera.ui.poi;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class AESelectionLocationAdapter
  extends RecyclerView.Adapter<AESelectionLocationAdapter.AESelectionHolder>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AESelectionLocationAdapter.LocationData jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter$LocationData;
  private AESelectionLocationAdapter.SelectListener jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter$SelectListener;
  ArrayList<AESelectionLocationAdapter.LocationData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public AESelectionLocationAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public AESelectionLocationAdapter.AESelectionHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AESelectionLocationAdapter.AESelectionHolder(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558490, paramViewGroup, false), this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(AESelectionLocationAdapter.AESelectionHolder paramAESelectionHolder, int paramInt)
  {
    paramAESelectionHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramAESelectionHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    int i = ((AESelectionLocationAdapter.LocationData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    paramAESelectionHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((AESelectionLocationAdapter.LocationData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
    paramAESelectionHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(new AESelectionLocationAdapter.1(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramAESelectionHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(AESelectionLocationAdapter.SelectListener paramSelectListener)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiPoiAESelectionLocationAdapter$SelectListener = paramSelectListener;
  }
  
  public void a(List<AESelectionLocationAdapter.LocationData> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return super.getItemId(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.poi.AESelectionLocationAdapter
 * JD-Core Version:    0.7.0.1
 */