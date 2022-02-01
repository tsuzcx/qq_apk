package dov.com.qq.im.aeeditor.module.frame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import java.util.ArrayList;
import java.util.List;

public class AEFrameColorListAdapter
  extends RecyclerView.Adapter<AEFrameColorListAdapter.ViewHolder>
{
  private AEFrameColorListAdapter.OnFrameColorSelectedListener jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter$OnFrameColorSelectedListener;
  private String jdField_a_of_type_JavaLangString = null;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public AEFrameColorListAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEFrameColorListAdapter.ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558575, paramViewGroup, false));
  }
  
  public void a(AEFrameColorListAdapter.OnFrameColorSelectedListener paramOnFrameColorSelectedListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter$OnFrameColorSelectedListener = paramOnFrameColorSelectedListener;
  }
  
  public void a(AEFrameColorListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    int k = 0;
    int j = 0;
    Object localObject;
    boolean bool;
    if (paramInt == 0)
    {
      i = 1;
      if (i != 0) {
        break label179;
      }
      localObject = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      paramViewHolder.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.parseColor((String)localObject));
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewHolder.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable);
      paramViewHolder.b.setImageResource(2130837854);
      bool = ((String)localObject).equals(this.jdField_a_of_type_JavaLangString);
      ImageView localImageView = paramViewHolder.c;
      if (!bool) {
        break label172;
      }
      label87:
      localImageView.setVisibility(j);
      AEReportUtils.g((String)localObject);
      localObject = paramViewHolder.b.getLayoutParams();
      if (i == 0) {
        break label290;
      }
    }
    label283:
    label290:
    for (int i = UIUtils.a(paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getContext(), 22.0F);; i = UIUtils.a(paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getContext(), 37.0F))
    {
      ((ViewGroup.LayoutParams)localObject).height = i;
      ((ViewGroup.LayoutParams)localObject).width = i;
      paramViewHolder.itemView.setOnClickListener(new AEFrameColorListAdapter.1(this, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      i = 0;
      break;
      label172:
      j = 8;
      break label87;
      label179:
      bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
      paramViewHolder.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(paramViewHolder.itemView.getContext().getResources().getColor(2131165223));
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewHolder.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable);
      paramViewHolder.b.setImageResource(2130837910);
      localObject = paramViewHolder.b;
      if (bool)
      {
        j = 8;
        label245:
        ((ImageView)localObject).setVisibility(j);
        localObject = paramViewHolder.c;
        if (!bool) {
          break label283;
        }
      }
      for (j = k;; j = 8)
      {
        ((ImageView)localObject).setVisibility(j);
        break;
        j = 0;
        break label245;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_JavaUtilList.remove("#FFFFFF");
    }
    this.jdField_a_of_type_JavaUtilList.add("#FFFFFF");
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.frame.AEFrameColorListAdapter
 * JD-Core Version:    0.7.0.1
 */