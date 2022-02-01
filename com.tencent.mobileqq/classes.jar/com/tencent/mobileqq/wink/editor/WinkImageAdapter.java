package com.tencent.mobileqq.wink.editor;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/WinkImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/editor/WinkImageAdapter$WinkImageViewHolder;", "mediaModels", "", "Lcom/tencent/videocut/model/MediaModel;", "showAreaWidth", "", "showAreaHeight", "(Ljava/util/List;II)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "WinkImageViewHolder", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkImageAdapter
  extends RecyclerView.Adapter<WinkImageAdapter.WinkImageViewHolder>
{
  public static final WinkImageAdapter.Companion a = new WinkImageAdapter.Companion(null);
  private final List<MediaModel> b;
  private final int c;
  private final int d;
  
  public WinkImageAdapter(@NotNull List<MediaModel> paramList, int paramInt1, int paramInt2)
  {
    this.b = paramList;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  @NotNull
  public WinkImageAdapter.WinkImageViewHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628248, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "root");
    return new WinkImageAdapter.WinkImageViewHolder(paramViewGroup);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(@NotNull WinkImageAdapter.WinkImageViewHolder paramWinkImageViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkImageViewHolder, "holder");
    Object localObject1 = (Collection)((MediaModel)this.b.get(paramInt)).videos;
    int i;
    if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      AEQLog.c("WinkImageAdapter", "[onBindViewHolder] invalid videos");
      return;
    }
    localObject1 = paramWinkImageViewHolder.itemView;
    ((View)localObject1).setOnClickListener((View.OnClickListener)WinkImageAdapter.onBindViewHolder.1.1.a);
    ((View)localObject1).setOnTouchListener((View.OnTouchListener)WinkImageAdapter.onBindViewHolder.1.2.a);
    ResourceModel localResourceModel = ((MediaClip)((MediaModel)this.b.get(paramInt)).videos.get(0)).resource;
    if (localResourceModel != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onBindViewHolder] w=");
      localObject1 = localResourceModel.size;
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = Float.valueOf(((SizeF)localObject1).width);
      } else {
        localObject1 = null;
      }
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", h=");
      SizeF localSizeF = localResourceModel.size;
      localObject1 = localObject2;
      if (localSizeF != null) {
        localObject1 = Float.valueOf(localSizeF.height);
      }
      localStringBuilder.append(localObject1);
      AEQLog.a("WinkImageAdapter", localStringBuilder.toString());
      paramWinkImageViewHolder.a(localResourceModel, this.c, this.d);
    }
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkImageAdapter
 * JD-Core Version:    0.7.0.1
 */