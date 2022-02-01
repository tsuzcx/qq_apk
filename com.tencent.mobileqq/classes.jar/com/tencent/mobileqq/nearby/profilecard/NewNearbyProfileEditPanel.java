package com.tencent.mobileqq.nearby.profilecard;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyTag;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyTag.ChildDetail;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyTag.Data;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyTag.Detail;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.SetNearbyTagReq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NewNearbyProfileEditPanel;", "Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileEditPanel;", "activity", "Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;", "(Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;)V", "adapter", "Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileImageEditAdapter;", "cacheNearbyTag", "Lcom/tencent/nowsummarycard/NowSummaryCard$NearbyTag;", "needUpdateProfile", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "addPhoto", "info", "Lcom/tencent/mobileqq/picbrowser/PicInfo;", "bindData", "", "card", "Lcom/tencent/mobileqq/data/NearbyPeopleCard;", "bindPhotoData", "deletetView", "v", "Landroid/view/View;", "picInfo", "getContentLayoutId", "", "getPicInfo", "", "initPhotoUI", "view", "isProfileChanged", "newLabelEditCtrl", "Lcom/tencent/mobileqq/nearby/profilecard/NewLabelEditCtrl;", "onInterestsChanged", "nearbyTag", "onSaveNearbyProfileCard", "bundle", "Landroid/os/Bundle;", "scrollToRight", "setEditPanelTitle", "setNearbyTagInfo", "setPhotos", "updatePhotoUI", "updateTextColor", "textView", "Landroid/widget/TextView;", "hotpot", "Companion", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NewNearbyProfileEditPanel
  extends NearbyProfileEditPanel
{
  public static final NewNearbyProfileEditPanel.Companion X = new NewNearbyProfileEditPanel.Companion(null);
  private static WeakReference<NewNearbyProfileEditPanel> ac = new WeakReference(null);
  private RecyclerView Y;
  private final NearbyProfileImageEditAdapter Z;
  private NowSummaryCard.NearbyTag aa;
  private boolean ab;
  
  public NewNearbyProfileEditPanel(@NotNull NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    ac = new WeakReference(this);
    this.Z = new NearbyProfileImageEditAdapter(this);
  }
  
  private final void z()
  {
    Object localObject2 = (Map)new LinkedHashMap();
    Object localObject1 = this.aa;
    if (localObject1 == null) {
      localObject1 = this.G.nearbyTag;
    }
    if (localObject1 != null)
    {
      localObject1 = ((NowSummaryCard.NearbyTag)localObject1).data;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      if (localObject1 != null)
      {
        localObject1 = ((PBRepeatMessageField)localObject1).get();
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (NowSummaryCard.NearbyTag.Data)((Iterator)localObject1).next();
            localObject3 = (List)new ArrayList();
            localObject5 = ((NowSummaryCard.NearbyTag.Data)localObject4).detail.get();
            Intrinsics.checkExpressionValueIsNotNull(localObject5, "data.detail.get()");
            localObject5 = ((Iterable)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = ((NowSummaryCard.NearbyTag.Detail)((Iterator)localObject5).next()).child_detail.get();
              Intrinsics.checkExpressionValueIsNotNull(localObject6, "detail.child_detail.get()");
              localObject6 = ((Iterable)localObject6).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                localObject7 = (NowSummaryCard.NearbyTag.ChildDetail)((Iterator)localObject6).next();
                if (((NowSummaryCard.NearbyTag.ChildDetail)localObject7).checked.get())
                {
                  localObject7 = ((NowSummaryCard.NearbyTag.ChildDetail)localObject7).name.get();
                  Intrinsics.checkExpressionValueIsNotNull(localObject7, "name");
                  ((List)localObject3).add(localObject7);
                }
              }
            }
            if ((((Collection)localObject3).isEmpty() ^ true))
            {
              localObject4 = ((NowSummaryCard.NearbyTag.Data)localObject4).name.get();
              Intrinsics.checkExpressionValueIsNotNull(localObject4, "name");
              ((Map)localObject2).put(localObject4, localObject3);
            }
          }
        }
      }
      this.a.findViewById(2131435864).setOnClickListener((View.OnClickListener)new NewNearbyProfileEditPanel.setNearbyTagInfo..inlined.apply.lambda.1(this));
      if (((Map)localObject2).isEmpty()) {
        return;
      }
      localObject1 = (ViewGroup)this.a.findViewById(2131435865);
      ((ViewGroup)localObject1).removeAllViews();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "layout");
      Object localObject3 = LayoutInflater.from(((ViewGroup)localObject1).getContext());
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject6 = (String)((Map.Entry)localObject4).getKey();
        localObject7 = (List)((Map.Entry)localObject4).getValue();
        localObject4 = ((LayoutInflater)localObject3).inflate(1946484753, (ViewGroup)localObject1, false);
        localObject5 = (ViewGroup)((View)localObject4).findViewById(1946419226);
        Object localObject8 = (TextView)((View)localObject4).findViewById(1946419231);
        Intrinsics.checkExpressionValueIsNotNull(localObject8, "text");
        ((TextView)localObject8).setText((CharSequence)localObject6);
        localObject6 = ((Iterable)localObject7).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (String)((Iterator)localObject6).next();
          localObject8 = ((LayoutInflater)localObject3).inflate(1946484752, (ViewGroup)localObject5, false);
          TextView localTextView = (TextView)((View)localObject8).findViewById(1946419231);
          Intrinsics.checkExpressionValueIsNotNull(localTextView, "itemText");
          localTextView.setText((CharSequence)localObject7);
          ((ViewGroup)localObject5).addView((View)localObject8);
        }
        ((ViewGroup)localObject1).addView((View)localObject4);
      }
    }
  }
  
  protected void a(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    super.a(paramBundle);
    Object localObject1 = this.aa;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.G;
      if (localObject2 != null) {
        ((NearbyPeopleCard)localObject2).nearbyTag = ((NowSummaryCard.NearbyTag)localObject1);
      }
    }
    localObject1 = this.G;
    if (localObject1 != null)
    {
      localObject1 = ((NearbyPeopleCard)localObject1).nearbyTag;
      if (localObject1 != null)
      {
        localObject1 = ((NowSummaryCard.NearbyTag)localObject1).data;
        if (localObject1 != null)
        {
          localObject2 = ((PBRepeatMessageField)localObject1).get();
          if (localObject2 != null)
          {
            localObject1 = (Set)new LinkedHashSet();
            localObject2 = ((Iterable)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = ((NowSummaryCard.NearbyTag.Data)((Iterator)localObject2).next()).detail.get();
              Intrinsics.checkExpressionValueIsNotNull(localObject3, "data.detail.get()");
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                Object localObject4 = ((NowSummaryCard.NearbyTag.Detail)((Iterator)localObject3).next()).child_detail.get();
                Intrinsics.checkExpressionValueIsNotNull(localObject4, "detail.child_detail.get()");
                localObject4 = ((Iterable)localObject4).iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  Object localObject5 = (NowSummaryCard.NearbyTag.ChildDetail)((Iterator)localObject4).next();
                  if (((NowSummaryCard.NearbyTag.ChildDetail)localObject5).checked.get())
                  {
                    localObject5 = ((NowSummaryCard.NearbyTag.ChildDetail)localObject5).id.get();
                    Intrinsics.checkExpressionValueIsNotNull(localObject5, "it.id.get()");
                    ((Set)localObject1).add(localObject5);
                  }
                }
              }
            }
            if (((Set)localObject1).isEmpty()) {
              return;
            }
            this.ab = true;
            localObject2 = new cmd0x9c9.SetNearbyTagReq();
            ((cmd0x9c9.SetNearbyTagReq)localObject2).tag_id.addAll((Collection)localObject1);
            paramBundle.putByteArray("interests", ((cmd0x9c9.SetNearbyTagReq)localObject2).toByteArray());
          }
        }
      }
    }
  }
  
  protected void a(@Nullable View paramView, @Nullable PicInfo paramPicInfo)
  {
    paramView = (Collection)this.Z.a();
    if (paramView != null)
    {
      TypeIntrinsics.asMutableCollection(paramView).remove(paramPicInfo);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
  }
  
  protected void a(@Nullable TextView paramTextView, boolean paramBoolean) {}
  
  public void a(@NotNull NearbyPeopleCard paramNearbyPeopleCard)
  {
    Intrinsics.checkParameterIsNotNull(paramNearbyPeopleCard, "card");
    super.a(paramNearbyPeopleCard);
    z();
  }
  
  public final void a(@NotNull NowSummaryCard.NearbyTag paramNearbyTag)
  {
    Intrinsics.checkParameterIsNotNull(paramNearbyTag, "nearbyTag");
    this.aa = paramNearbyTag;
    z();
  }
  
  public boolean a(@NotNull PicInfo paramPicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPicInfo, "info");
    this.Z.a().add(paramPicInfo);
    m();
    return true;
  }
  
  protected int b()
  {
    return 2131627565;
  }
  
  protected void b(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramView = paramView.findViewById(2131444519);
    RecyclerView localRecyclerView = (RecyclerView)paramView;
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(localRecyclerView.getContext(), 0, false));
    localRecyclerView.setAdapter((RecyclerView.Adapter)this.Z);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById<Recycl…itPanel.adapter\n        }");
    this.Y = localRecyclerView;
  }
  
  public boolean d()
  {
    if (this.aa != null) {
      return true;
    }
    return super.d();
  }
  
  public void e()
  {
    RecyclerView localRecyclerView = this.Y;
    if (localRecyclerView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    }
    localRecyclerView.scrollToPosition(this.Z.a().size() - 1);
  }
  
  public boolean h()
  {
    return this.ab;
  }
  
  protected void l()
  {
    NearbyProfileImageEditAdapter localNearbyProfileImageEditAdapter = this.Z;
    List localList = localNearbyProfileImageEditAdapter.a();
    localList.clear();
    ArrayList localArrayList = this.J;
    Intrinsics.checkExpressionValueIsNotNull(localArrayList, "this@NewNearbyProfileEditPanel.mPicInfo");
    localList.addAll((Collection)localArrayList);
    localNearbyProfileImageEditAdapter.notifyDataSetChanged();
  }
  
  protected void n()
  {
    l();
  }
  
  @NotNull
  protected List<PicInfo> p()
  {
    return this.Z.a();
  }
  
  protected void q() {}
  
  protected void r()
  {
    super.r();
    int i = Color.parseColor("#03081A");
    ((TextView)this.h.findViewById(2131436182)).setTextColor(i);
    ((TextView)this.h.findViewById(2131436211)).setTextColor(i);
  }
  
  @NotNull
  protected NewLabelEditCtrl x()
  {
    return new NewLabelEditCtrl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileEditPanel
 * JD-Core Version:    0.7.0.1
 */