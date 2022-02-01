package com.tencent.mobileqq.kandian.biz.ugc.selecttopic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/ugc/selecttopic/SelectTopicView$topicAdapter$1", "Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/BaseSelectAdapter;", "Lcom/tencent/mobileqq/kandian/repo/db/struct/ColumnInfo;", "Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/SelectTopicView$MyTopicViewHolder;", "bindViewHolder", "", "topicInfo", "holder", "createView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewGroup", "Landroid/view/ViewGroup;", "createViewHolder", "itemView", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SelectTopicView$topicAdapter$1
  extends BaseSelectAdapter<ColumnInfo, SelectTopicView.MyTopicViewHolder>
{
  SelectTopicView$topicAdapter$1(Context paramContext)
  {
    super(localContext);
  }
  
  @NotNull
  public View a(@NotNull Context paramContext, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = LayoutInflater.from(paramContext).inflate(2131560221, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…  false\n                )");
    return paramContext;
  }
  
  @NotNull
  public SelectTopicView.MyTopicViewHolder a(@NotNull Context paramContext, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramContext = (TextView)paramView.findViewById(2131378876);
    TextView localTextView = (TextView)paramView.findViewById(2131379035);
    paramView = (ImageView)paramView.findViewById(2131369331);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "titleText");
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "introView");
    Intrinsics.checkExpressionValueIsNotNull(paramView, "coverView");
    return new SelectTopicView.MyTopicViewHolder(paramContext, localTextView, paramView);
  }
  
  public void a(@NotNull ColumnInfo paramColumnInfo, @NotNull SelectTopicView.MyTopicViewHolder paramMyTopicViewHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramColumnInfo, "topicInfo");
    Intrinsics.checkParameterIsNotNull(paramMyTopicViewHolder, "holder");
    paramMyTopicViewHolder.a().setImageDrawable((Drawable)URLDrawable.getDrawable(paramColumnInfo.coverUrl, URLDrawable.URLDrawableOptions.obtain()));
    Drawable localDrawable = a().getResources().getDrawable(2130843153);
    localDrawable.setBounds(0, 0, UIUtils.a(a(), 15.0F), UIUtils.a(a(), 15.0F));
    TextView localTextView = paramMyTopicViewHolder.a();
    localTextView.setText((CharSequence)paramColumnInfo.title);
    localTextView.setCompoundDrawablePadding(UIUtils.a(localTextView.getContext(), 3.0F));
    localTextView.setCompoundDrawables(localDrawable, null, null, null);
    paramColumnInfo = a().getResources().getString(2131718034, new Object[] { Integer.valueOf(paramColumnInfo.videoCount), Integer.valueOf(paramColumnInfo.subscribeCount) });
    paramMyTopicViewHolder.b().setText((CharSequence)paramColumnInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selecttopic.SelectTopicView.topicAdapter.1
 * JD-Core Version:    0.7.0.1
 */