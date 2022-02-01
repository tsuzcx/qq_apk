package dov.com.qq.im.ae.gif.giftext.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.data.AEMaterialWrapper;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import java.util.List;

public class AEGIFStickerAdapter
  extends RecyclerView.Adapter<AEGIFStickerAdapter.ViewHolder>
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AEGIFStickerAdapter.OnMaterialClickCallback jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter$OnMaterialClickCallback;
  private List<AEMaterialWrapper> jdField_a_of_type_JavaUtilList;
  private int b = 0;
  
  public AEGIFStickerAdapter(Context paramContext, List<AEMaterialWrapper> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private void b(int paramInt)
  {
    int i;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
      i = localLinearLayoutManager.findFirstVisibleItemPosition();
      i = (localLinearLayoutManager.findLastVisibleItemPosition() - i + 1) / 2 + i;
      if (paramInt <= i) {
        break label62;
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(DisplayUtil.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 70.0F), 0);
    }
    label62:
    while (paramInt >= i) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(-DisplayUtil.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 70.0F), 0);
  }
  
  private void c(int paramInt)
  {
    int j;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
      int i = localLinearLayoutManager.findFirstVisibleItemPosition();
      j = (localLinearLayoutManager.findLastVisibleItemPosition() - i + 1) / 2 + i;
      if ((paramInt >= i) && (paramInt <= j)) {
        break label58;
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
    }
    label58:
    do
    {
      return;
      if (paramInt > j)
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(DisplayUtil.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 70.0F), 0);
        return;
      }
    } while (paramInt >= j);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(-DisplayUtil.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 70.0F), 0);
  }
  
  public AEGIFStickerAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    return new AEGIFStickerAdapter.ViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558615, paramViewGroup, false));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
  
  public void a(int paramInt)
  {
    AEQLog.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside], position=" + paramInt + ", mClickedPos=" + this.jdField_a_of_type_Int + ", mActivatedPos=" + this.b);
    AEMaterialWrapper localAEMaterialWrapper = (AEMaterialWrapper)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    if ((localAEMaterialWrapper.jdField_a_of_type_Int == 2) || (localAEMaterialWrapper.b == 1))
    {
      AEQLog.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside] materialWrapper.state == STATE_DOWNLOADED || materialWrapper.type == AEMaterialWrapper.TYPE_PLACEHOLDER");
      if (paramInt != this.b)
      {
        if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
        }
        int i = this.b;
        this.b = paramInt;
        notifyItemChanged(paramInt);
        notifyItemChanged(i);
      }
      return;
    }
    AEQLog.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside] materialWrapper.state != STATE_DOWNLOADED");
  }
  
  public void a(@NonNull AEMaterialWrapper paramAEMaterialWrapper, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramAEMaterialWrapper);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Int = this.b;
      notifyItemChanged(i);
    }
    do
    {
      return;
      if (paramAEMaterialWrapper.jdField_a_of_type_Int != 2) {
        break;
      }
    } while (i != this.jdField_a_of_type_Int);
    c(i);
    int j = this.b;
    this.b = i;
    notifyItemChanged(i);
    notifyItemChanged(j);
    AEBaseReportParam.a().n(paramAEMaterialWrapper.jdField_a_of_type_JavaLangString);
    AEBaseDataReporter.a().ag();
    AEQLog.b("AEGIFStickerAdapter", "[notifyDownloadStateChanged], gifMaterialDownloaded, id=" + paramAEMaterialWrapper.jdField_a_of_type_JavaLangString);
    return;
    notifyItemChanged(i);
  }
  
  public void a(AEGIFStickerAdapter.OnMaterialClickCallback paramOnMaterialClickCallback)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter$OnMaterialClickCallback = paramOnMaterialClickCallback;
  }
  
  public void a(AEGIFStickerAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1 = (AEMaterialWrapper)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((AEMaterialWrapper)localObject1).b == 1)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838025);
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramViewHolder.itemView.setOnClickListener(new AEGIFStickerAdapter.1(this, paramInt, (AEMaterialWrapper)localObject1));
      if (paramInt != this.b) {
        break label250;
      }
      AEBaseReportParam.a().n(((AEMaterialWrapper)localObject1).jdField_a_of_type_JavaLangString);
      localObject1 = paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      ((ViewGroup.LayoutParams)localObject1).height = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130838046);
      paramViewHolder.b.setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838049);
      localObject2 = VasApngUtil.getApngURLDrawable(((AEMaterialWrapper)localObject1).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.thumbUrl, new int[] { 0 }, (Drawable)localObject2);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      switch (((AEMaterialWrapper)localObject1).jdField_a_of_type_Int)
      {
      default: 
        break;
      case 0: 
      case 2: 
        paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break;
      case 1: 
        paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        break;
        label250:
        localObject1 = paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
        ((ViewGroup.LayoutParams)localObject1).height = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
        paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130838045);
        paramViewHolder.b.setVisibility(4);
      }
    }
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
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.adapter.AEGIFStickerAdapter
 * JD-Core Version:    0.7.0.1
 */