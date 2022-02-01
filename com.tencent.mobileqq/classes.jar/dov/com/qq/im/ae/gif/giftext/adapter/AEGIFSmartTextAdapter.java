package dov.com.qq.im.ae.gif.giftext.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.gif.giftext.AEGIFSmartTextData;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextMvp;
import java.util.ArrayList;

public class AEGIFSmartTextAdapter
  extends RecyclerView.Adapter<AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder>
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AEGIFTextMvp jdField_a_of_type_DovComQqImAeGifGiftextAEGIFTextMvp;
  private ArrayList<AEGIFSmartTextData> jdField_a_of_type_JavaUtilArrayList;
  
  public AEGIFSmartTextAdapter(Context paramContext, AEGIFTextMvp paramAEGIFTextMvp)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFTextMvp = paramAEGIFTextMvp;
    a(this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFTextMvp.a());
    a(this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFTextMvp.a());
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private void a(ArrayList<AEGIFSmartTextData> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558614, paramViewGroup, false);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(4);
    }
    return new AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder(paramViewGroup);
  }
  
  public void a()
  {
    AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder localQIMGIFSmartTextViewHolder = (AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_Int);
    if (localQIMGIFSmartTextViewHolder != null) {
      localQIMGIFSmartTextViewHolder.a(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int >= 0) {
        ((AEGIFSmartTextData)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int - 1)).a(false);
      }
      this.jdField_a_of_type_Int = -1;
      return;
      if (this.jdField_a_of_type_Int >= 0) {
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder paramQIMGIFSmartTextViewHolder, int paramInt)
  {
    if (paramQIMGIFSmartTextViewHolder.getLayoutPosition() == 0)
    {
      localObject = new FrameLayout.LayoutParams(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 33.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 33.0F));
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 51.0F), 0);
      paramQIMGIFSmartTextViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      EventCollector.getInstance().onRecyclerBindViewHolder(paramQIMGIFSmartTextViewHolder, paramInt, getItemId(paramInt));
      return;
    }
    Object localObject = ((AEGIFSmartTextData)this.jdField_a_of_type_JavaUtilArrayList.get(paramQIMGIFSmartTextViewHolder.getLayoutPosition() - 1)).a;
    paramQIMGIFSmartTextViewHolder.a.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Int == paramQIMGIFSmartTextViewHolder.getLayoutPosition()) {
      paramQIMGIFSmartTextViewHolder.a(true);
    }
    for (;;)
    {
      paramQIMGIFSmartTextViewHolder.itemView.setOnClickListener(new AEGIFSmartTextAdapter.1(this, paramQIMGIFSmartTextViewHolder, (String)localObject));
      break;
      paramQIMGIFSmartTextViewHolder.a(false);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt != 0) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.adapter.AEGIFSmartTextAdapter
 * JD-Core Version:    0.7.0.1
 */