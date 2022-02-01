package com.tencent.tkd.topicsdk.kdcommunity;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.widget.RoundBackgroundLinearLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "selectedCommunityId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "dataList", "", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "getSelectedCommunityId", "()Ljava/lang/String;", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setData", "", "list", "", "CommunityHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class KDCommunityAdapter
  extends BaseAdapter
{
  private final List<CommunityInfo> a;
  @NotNull
  private final Context b;
  @NotNull
  private final String c;
  
  public KDCommunityAdapter(@NotNull Context paramContext, @NotNull String paramString)
  {
    this.b = paramContext;
    this.c = paramString;
    this.a = ((List)new ArrayList());
  }
  
  public final void a(@NotNull List<CommunityInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    this.a.clear();
    this.a.addAll((Collection)paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  @NotNull
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @NotNull
  public View getView(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.b).inflate(R.layout.G, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(localView, "LayoutInflater.from(cont…nity_item, parent, false)");
      paramView = localView.findViewById(R.id.ao);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.titleView)");
      paramView = (TextView)paramView;
      paramViewGroup = localView.findViewById(R.id.k);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "view.findViewById(R.id.descriptionView)");
      localView.setTag(new KDCommunityAdapter.CommunityHolder(null, paramView, (TextView)paramViewGroup, 1, null));
    }
    paramView = localView.getTag();
    if (paramView != null)
    {
      paramViewGroup = (KDCommunityAdapter.CommunityHolder)paramView;
      paramView = (CommunityInfo)this.a.get(paramInt);
      paramViewGroup.a(paramView);
      paramViewGroup.b().setText((CharSequence)paramView.getTitle());
      paramViewGroup.c().setText((CharSequence)paramView.getIntro());
      if ((localView instanceof RoundBackgroundLinearLayout))
      {
        paramView = paramViewGroup.a();
        if (paramView != null) {
          paramView = paramView.getCommunityId();
        } else {
          paramView = null;
        }
        if (Intrinsics.areEqual(paramView, this.c))
        {
          ((RoundBackgroundLinearLayout)localView).setRoundBackgroundColor(Color.parseColor("#FF00CAFC"));
          paramViewGroup.b().setTextColor(Color.parseColor("#FFFFFFFF"));
          paramViewGroup.c().setTextColor(Color.parseColor("#FFFFFFFF"));
          return localView;
        }
        ((RoundBackgroundLinearLayout)localView).setRoundBackgroundColor(Color.parseColor("#FFFFFFFF"));
        paramViewGroup.b().setTextColor(Color.parseColor("#FF03081A"));
        paramViewGroup.c().setTextColor(Color.parseColor("#FF878B99"));
      }
      return localView;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.kdcommunity.KDCommunityAdapter.CommunityHolder");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.KDCommunityAdapter
 * JD-Core Version:    0.7.0.1
 */