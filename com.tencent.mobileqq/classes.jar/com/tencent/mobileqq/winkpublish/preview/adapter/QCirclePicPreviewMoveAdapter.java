package com.tencent.mobileqq.winkpublish.preview.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.winkpublish.bean.QCirclePicPreviewBean;
import com.tencent.mobileqq.winkpublish.widget.SquareImageView;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.List;

public class QCirclePicPreviewMoveAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private ArrayList<QCirclePicPreviewBean> a;
  private LayoutInflater b;
  private int c;
  private QCirclePicPreviewMoveAdapter.PicOperationListener d;
  
  private void b(int paramInt)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (paramInt >= 0)
    {
      if (paramInt > ((ArrayList)localObject).size()) {
        return;
      }
      this.a.remove(paramInt);
      notifyItemRemoved(paramInt);
      notifyItemRangeChanged(paramInt, getItemCount() - paramInt);
      localObject = this.d;
      if (localObject != null) {
        ((QCirclePicPreviewMoveAdapter.PicOperationListener)localObject).a(paramInt);
      }
    }
  }
  
  public ArrayList<QCirclePicPreviewBean> a()
  {
    ArrayList localArrayList = this.a;
    if (localArrayList != null) {
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList = this.a;
    if (localArrayList == null) {
      return;
    }
    if (paramInt >= 0)
    {
      if (paramInt > localArrayList.size()) {
        return;
      }
      this.a.remove(paramInt);
      notifyItemRemoved(paramInt);
      notifyItemRangeChanged(paramInt, getItemCount() - paramInt, "payload");
    }
  }
  
  public void a(List<QCirclePicPreviewBean> paramList)
  {
    if ((this.a != null) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      this.a.addAll(paramList);
      notifyItemRangeInserted(this.a.size() - paramList.size(), paramList.size());
      if (this.a.size() == this.c) {
        notifyDataSetChanged();
      }
    }
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.a;
    if (localArrayList == null) {
      return 1;
    }
    int i = localArrayList.size();
    int j = this.c;
    if (i >= j) {
      return j;
    }
    return i + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    ArrayList localArrayList = this.a;
    if (localArrayList == null) {
      return 102;
    }
    int i = localArrayList.size();
    if (i >= this.c) {
      return 101;
    }
    if (paramInt == i) {
      return 102;
    }
    return 101;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder.getItemViewType() == 101)
    {
      QCirclePicPreviewBean localQCirclePicPreviewBean = (QCirclePicPreviewBean)this.a.get(paramInt);
      paramViewHolder = (QCirclePicPreviewMoveAdapter.PicViewHolder)paramViewHolder;
      paramViewHolder.itemView.setVisibility(0);
      Drawable localDrawable = QCirclePicPreviewMoveAdapter.PicViewHolder.a(paramViewHolder).getContext().getResources().getDrawable(2130853309);
      paramViewHolder = new Option().setFailDrawable(localDrawable).setLoadingDrawable(localDrawable).setTargetView(QCirclePicPreviewMoveAdapter.PicViewHolder.a(paramViewHolder)).setUrl(localQCirclePicPreviewBean.a());
      QCircleFeedPicLoader.g().loadImage(paramViewHolder, null);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt, List<Object> paramList)
  {
    if (paramList.isEmpty())
    {
      onBindViewHolder(paramViewHolder, paramInt);
      return;
    }
    int i = paramViewHolder.getItemViewType();
    if (i == 101)
    {
      ((QCirclePicPreviewMoveAdapter.PicViewHolder)paramViewHolder).itemView.setVisibility(0);
      return;
    }
    if (i == 102) {
      onBindViewHolder(paramViewHolder, paramInt);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 101) {
      return new QCirclePicPreviewMoveAdapter.PicViewHolder(this, this.b.inflate(2131627215, paramViewGroup, false));
    }
    if (paramInt == 102) {
      return new QCirclePicPreviewMoveAdapter.PicAddViewHolder(this, this.b.inflate(2131627214, paramViewGroup, false));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.preview.adapter.QCirclePicPreviewMoveAdapter
 * JD-Core Version:    0.7.0.1
 */