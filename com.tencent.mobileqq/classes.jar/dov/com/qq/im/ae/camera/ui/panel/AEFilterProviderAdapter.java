package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.core.AEFilterManagerHolder;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.util.ArrayList;
import java.util.List;

public class AEFilterProviderAdapter
  extends RecyclerView.Adapter<AEFilterProviderAdapter.ViewHolder>
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private AEFilterProviderAdapter.OnItemClickListener jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter$OnItemClickListener;
  List<QIMFilterCategoryItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public AEFilterProviderAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private boolean a()
  {
    AEFilterProcessTex localAEFilterProcessTex = AEFilterManagerHolder.getAEFilterManager();
    if (localAEFilterProcessTex == null) {
      return true;
    }
    return localAEFilterProcessTex.a;
  }
  
  public AEFilterProviderAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEFilterProviderAdapter.ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558484, paramViewGroup, false));
  }
  
  public void a(AEFilterProviderAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(AEFilterProviderAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1 = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    QIMFilterCategoryItem localQIMFilterCategoryItem;
    Object localObject2;
    if (localObject1 != null)
    {
      localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localObject2 = VideoFilterTools.a().c(this.jdField_a_of_type_Int);
      if (localObject2 == null) {
        break label282;
      }
    }
    label260:
    label272:
    label282:
    for (boolean bool1 = TextUtils.equals(((QIMFilterCategoryItem)localObject2).a, localQIMFilterCategoryItem.a);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        if (((localObject2 == null) || (((QIMFilterCategoryItem)localObject2).d())) && (localQIMFilterCategoryItem.d())) {
          bool2 = true;
        }
      }
      else
      {
        if ((!bool2) || (!a())) {
          break label260;
        }
        AEFilterProviderAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
        label117:
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844682);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844682);
        if (paramInt != 0) {
          break label272;
        }
      }
      for (localObject1 = "https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none2.png";; localObject1 = ((QIMFilterCategoryItem)localObject1).d)
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        if (((URLDrawable)localObject1).getStatus() == 2) {
          ((URLDrawable)localObject1).restartDownload();
        }
        AEFilterProviderAdapter.ViewHolder.b(paramViewHolder).setImageDrawable((Drawable)localObject1);
        AEFilterProviderAdapter.ViewHolder.a(paramViewHolder).setText(localQIMFilterCategoryItem.b);
        if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter$OnItemClickListener != null) {
          paramViewHolder.itemView.setOnClickListener(new AEFilterProviderAdapter.1(this, paramViewHolder));
        }
        paramViewHolder.itemView.setTag(localQIMFilterCategoryItem);
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        bool2 = false;
        break;
        AEFilterProviderAdapter.ViewHolder.a(paramViewHolder).setVisibility(8);
        break label117;
      }
    }
  }
  
  public void a(List<QIMFilterCategoryItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderAdapter
 * JD-Core Version:    0.7.0.1
 */