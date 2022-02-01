package com.tencent.tkd.topicsdk.selectowner;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.R.drawable;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.list.CommonListAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/selectowner/SelectTopicView$mTopicAdapter$1", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "Lcom/tencent/tkd/topicsdk/selectowner/SelectTopicView$MyTopicViewHolder;", "bindViewHolder", "", "position", "", "bean", "holder", "itemView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "createView", "context", "Landroid/content/Context;", "viewGroup", "createViewHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectTopicView$mTopicAdapter$1
  extends CommonListAdapter<TopicInfo, SelectTopicView.MyTopicViewHolder>
{
  SelectTopicView$mTopicAdapter$1(Context paramContext)
  {
    super(localContext);
  }
  
  @NotNull
  public View a(@NotNull Context paramContext, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.m, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…      false\n            )");
    return paramContext;
  }
  
  public void a(int paramInt, @NotNull TopicInfo paramTopicInfo, @NotNull SelectTopicView.MyTopicViewHolder paramMyTopicViewHolder, @NotNull View paramView, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "bean");
    Intrinsics.checkParameterIsNotNull(paramMyTopicViewHolder, "holder");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramView = b().getResources().getDrawable(R.drawable.d);
    paramView.setBounds(0, 0, DisplayUtils.a.a(b(), 15.0F), DisplayUtils.a.a(b(), 15.0F));
    paramViewGroup = paramMyTopicViewHolder.a();
    paramViewGroup.setText((CharSequence)paramTopicInfo.getTitle());
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    paramViewGroup.setCompoundDrawablePadding(localDisplayUtils.a(localContext, 3.0F));
    paramViewGroup.setCompoundDrawables(paramView, null, null, null);
    paramMyTopicViewHolder.b().setText((CharSequence)paramTopicInfo.getIntro());
    com.tencent.tkd.topicsdk.framework.bridge.ImageLoader.a.a(b()).a(paramMyTopicViewHolder.c()).a(paramTopicInfo.getCoverUrl());
    if ((this.a.getSelectedTopicId() == ((TopicInfo)a().get(paramInt)).getTopicId()) && (this.a.getSelectedTopicId() != 0L))
    {
      paramMyTopicViewHolder.d().setVisibility(0);
      return;
    }
    paramMyTopicViewHolder.d().setVisibility(4);
  }
  
  @NotNull
  public SelectTopicView.MyTopicViewHolder b(@NotNull Context paramContext, @NotNull View paramView, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramContext = (TextView)paramView.findViewById(R.id.ap);
    paramViewGroup = (TextView)paramView.findViewById(R.id.aq);
    ImageView localImageView = (ImageView)paramView.findViewById(R.id.C);
    paramView = (ImageView)paramView.findViewById(R.id.E);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "titleText");
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "introView");
    Intrinsics.checkExpressionValueIsNotNull(paramView, "coverImageView");
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "checkView");
    return new SelectTopicView.MyTopicViewHolder(paramContext, paramViewGroup, paramView, localImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.SelectTopicView.mTopicAdapter.1
 * JD-Core Version:    0.7.0.1
 */