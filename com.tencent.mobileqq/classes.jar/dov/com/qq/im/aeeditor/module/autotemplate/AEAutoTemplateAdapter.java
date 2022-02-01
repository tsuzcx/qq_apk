package dov.com.qq.im.aeeditor.module.autotemplate;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.filter.AdapterUtil;
import java.util.ArrayList;
import java.util.List;

public class AEAutoTemplateAdapter
  extends RecyclerView.Adapter<AEAutoTemplateAdapter.VH>
{
  private int jdField_a_of_type_Int = -1;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AEAutoTemplateAdapter.DownLoadPackageListener jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter$DownLoadPackageListener;
  private AEAutoTemplateAdapter.OnItemClickListener jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter$OnItemClickListener;
  private AEAutoTemplateAdapter.ReloadListener jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter$ReloadListener;
  private List<AEEditorAutoTemplateBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  
  public AEAutoTemplateAdapter.VH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEAutoTemplateAdapter.VH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558565, paramViewGroup, false));
  }
  
  public List<AEEditorAutoTemplateBean> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt >= 0) {
      AdapterUtil.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramInt, false);
    }
    notifyDataSetChanged();
  }
  
  public void a(AEAutoTemplateAdapter.DownLoadPackageListener paramDownLoadPackageListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter$DownLoadPackageListener = paramDownLoadPackageListener;
  }
  
  public void a(AEAutoTemplateAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(AEAutoTemplateAdapter.ReloadListener paramReloadListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter$ReloadListener = paramReloadListener;
  }
  
  public void a(AEAutoTemplateAdapter.VH paramVH, int paramInt)
  {
    AEEditorAutoTemplateBean localAEEditorAutoTemplateBean = (AEEditorAutoTemplateBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    AEQLog.a("AEAutoTemplateAdapter", "[onBindViewHolder] autoTemplateBean.thumbUrl = " + localAEEditorAutoTemplateBean.thumbUrl);
    if (localAEEditorAutoTemplateBean.thumbUrl.isEmpty())
    {
      paramVH.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837927);
      if (this.jdField_a_of_type_Boolean)
      {
        paramVH.b.setVisibility(0);
        paramVH.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        paramVH.b.setOnClickListener(new AEAutoTemplateAdapter.1(this));
        label97:
        if (TextUtils.isEmpty(localAEEditorAutoTemplateBean.name)) {
          break label277;
        }
        paramVH.jdField_a_of_type_AndroidWidgetTextView.setText(localAEEditorAutoTemplateBean.name);
        label118:
        paramVH.itemView.setOnClickListener(new AEAutoTemplateAdapter.2(this, paramInt, localAEEditorAutoTemplateBean));
        if (this.jdField_a_of_type_Int != paramInt) {
          break label289;
        }
        paramVH.c.setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramVH, paramInt, getItemId(paramInt));
      return;
      paramVH.b.setVisibility(8);
      Animation localAnimation = AnimationUtils.loadAnimation(paramVH.itemView.getContext(), 2130772010);
      paramVH.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimation);
      break;
      paramVH.b.setVisibility(8);
      paramVH.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      UIUtils.a(paramVH.jdField_a_of_type_AndroidWidgetImageView, localAEEditorAutoTemplateBean.thumbUrl, UIUtils.a(paramVH.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), UIUtils.a(paramVH.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), paramVH.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources().getDrawable(2130837927), null);
      AEReportUtils.l(localAEEditorAutoTemplateBean.id);
      break label97;
      label277:
      paramVH.jdField_a_of_type_AndroidWidgetTextView.setText("");
      break label118;
      label289:
      paramVH.c.setVisibility(8);
    }
  }
  
  public void a(AEEditorAutoTemplateBean paramAEEditorAutoTemplateBean)
  {
    if (paramAEEditorAutoTemplateBean == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((((AEEditorAutoTemplateBean)this.jdField_a_of_type_JavaUtilList.get(i)).parentId.equals(paramAEEditorAutoTemplateBean.parentId)) && (((AEEditorAutoTemplateBean)this.jdField_a_of_type_JavaUtilList.get(i)).id.equals(paramAEEditorAutoTemplateBean.id)))
        {
          a(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(List<AEEditorAutoTemplateBean> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.b = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyItemRangeChanged(0, this.b);
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
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */