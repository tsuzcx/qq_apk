package com.tencent.mobileqq.mini.ui;

import NS_MINI_FILE_MATERIAL.MiniAppFileMaterial.AppMaterialInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.common.ui.LoadingMoreRecyclerAdapter;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.widget.RoundRectURLImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListAdapter;", "Lcom/tencent/mobileqq/mini/common/ui/LoadingMoreRecyclerAdapter;", "Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListAdapter$ItemViewHolder;", "()V", "mAppList", "Ljava/util/ArrayList;", "LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$AppMaterialInfo;", "Lkotlin/collections/ArrayList;", "mItemClickListener", "Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListAdapter$OnItemClickListener;", "mMimeType", "", "addData", "", "appList", "", "doGetItemCount", "", "doOnBindViewHolder", "holder", "position", "doOnCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getMiniAppConfigForReport", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "data", "onViewAttachedToWindow", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "reportItemClickedOrExposed", "isClick", "", "setData", "setItemClickListener", "listener", "setMimeType", "mimeType", "ItemViewHolder", "OnItemClickListener", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class FileMaterialAppListAdapter
  extends LoadingMoreRecyclerAdapter<FileMaterialAppListAdapter.ItemViewHolder>
{
  private final ArrayList<MiniAppFileMaterial.AppMaterialInfo> mAppList = new ArrayList();
  private FileMaterialAppListAdapter.OnItemClickListener mItemClickListener;
  private String mMimeType;
  
  private final MiniAppConfig getMiniAppConfigForReport(MiniAppFileMaterial.AppMaterialInfo paramAppMaterialInfo)
  {
    MiniAppConfig localMiniAppConfig = new MiniAppConfig(new MiniAppInfo());
    localMiniAppConfig.config.appId = paramAppMaterialInfo.appid.get();
    localMiniAppConfig.launchParam.scene = 1173;
    return localMiniAppConfig;
  }
  
  private final void reportItemClickedOrExposed(MiniAppFileMaterial.AppMaterialInfo paramAppMaterialInfo, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "click";
    } else {
      str = "expo";
    }
    MiniProgramLpReportDC04239.reportAsync(getMiniAppConfigForReport(paramAppMaterialInfo), "aio_file", "miniprogram_list", str, this.mMimeType);
  }
  
  @UiThread
  public final void addData(@NotNull List<MiniAppFileMaterial.AppMaterialInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "appList");
    this.mAppList.addAll((Collection)paramList);
    notifyItemRangeInserted(this.mAppList.size() - paramList.size(), paramList.size());
  }
  
  public int doGetItemCount()
  {
    return this.mAppList.size();
  }
  
  public void doOnBindViewHolder(@NotNull FileMaterialAppListAdapter.ItemViewHolder paramItemViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramItemViewHolder, "holder");
    Object localObject = this.mAppList.get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mAppList[position]");
    localObject = (MiniAppFileMaterial.AppMaterialInfo)localObject;
    paramItemViewHolder.setData((MiniAppFileMaterial.AppMaterialInfo)localObject);
    if (!TextUtils.isEmpty((CharSequence)((MiniAppFileMaterial.AppMaterialInfo)localObject).icon.get())) {
      paramItemViewHolder.getIvIcon().setImageDrawable((Drawable)URLDrawable.getDrawable(((MiniAppFileMaterial.AppMaterialInfo)localObject).icon.get(), null));
    }
    paramItemViewHolder.getTvTitle().setText((CharSequence)((MiniAppFileMaterial.AppMaterialInfo)localObject).name.get());
    paramItemViewHolder.getTvDesc().setText((CharSequence)((MiniAppFileMaterial.AppMaterialInfo)localObject).desc.get());
    boolean bool = Intrinsics.areEqual(((MiniAppFileMaterial.AppMaterialInfo)localObject).vt.get(), String.valueOf(1));
    localObject = paramItemViewHolder.getIvExpTips();
    if (bool) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    ((ImageView)localObject).setVisibility(paramInt);
    paramItemViewHolder.itemView.setOnClickListener((View.OnClickListener)new FileMaterialAppListAdapter.doOnBindViewHolder.2(this, paramItemViewHolder));
  }
  
  @NotNull
  public FileMaterialAppListAdapter.ItemViewHolder doOnCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2030370816, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "view");
    return new FileMaterialAppListAdapter.ItemViewHolder(paramViewGroup);
  }
  
  public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder paramViewHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "holder");
    super.onViewAttachedToWindow(paramViewHolder);
    if ((paramViewHolder instanceof FileMaterialAppListAdapter.ItemViewHolder)) {
      reportItemClickedOrExposed(((FileMaterialAppListAdapter.ItemViewHolder)paramViewHolder).getData(), false);
    }
  }
  
  @UiThread
  public final void setData(@NotNull List<MiniAppFileMaterial.AppMaterialInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "appList");
    this.mAppList.clear();
    this.mAppList.addAll((Collection)paramList);
    notifyDataSetChanged();
  }
  
  public final void setItemClickListener(@Nullable FileMaterialAppListAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClickListener = paramOnItemClickListener;
  }
  
  public final void setMimeType(@Nullable String paramString)
  {
    this.mMimeType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.FileMaterialAppListAdapter
 * JD-Core Version:    0.7.0.1
 */