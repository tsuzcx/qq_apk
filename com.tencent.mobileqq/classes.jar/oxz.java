import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentLinkView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/CommentLinkView$LinkAdatper;", "Landroid/widget/BaseAdapter;", "Landroid/view/View$OnClickListener;", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/CommentLinkView;)V", "getCount", "", "getItem", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/BaseCommentData$CommentLinkData;", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onClick", "", "v", "ViewHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oxz
  extends BaseAdapter
  implements View.OnClickListener
{
  @NotNull
  public BaseCommentData.CommentLinkData a(int paramInt)
  {
    return (BaseCommentData.CommentLinkData)CommentLinkView.a(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return CommentLinkView.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @NotNull
  public View getView(int paramInt, @Nullable View paramView, @NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    View localView;
    Object localObject;
    String str;
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131560102, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(localView, "contentView");
      localObject = new oya(this, localView);
      ((oya)localObject).a().setOnClickListener((View.OnClickListener)this);
      localView.setTag(localObject);
      BaseCommentData.CommentLinkData localCommentLinkData = a(paramInt);
      ((oya)localObject).a().setTag(localCommentLinkData);
      ((oya)localObject).a().setText((CharSequence)localCommentLinkData.wording);
      str = localCommentLinkData.iconUrl;
      if (str != null)
      {
        if (((CharSequence)str).length() != 0) {
          break label229;
        }
        i = 1;
        label128:
        if (i == 0) {
          break label256;
        }
      }
      switch (localCommentLinkData.type)
      {
      default: 
        i = 2130842825;
        label168:
        ((oya)localObject).a().setImageResource(i);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = paramView.getTag();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentLinkView.LinkAdatper.ViewHolder");
      }
      localObject = (oya)localObject;
      localView = paramView;
      break;
      label229:
      i = 0;
      break label128;
      i = 2130842821;
      break label168;
      i = 2130842823;
      break label168;
      i = 2130842825;
      break label168;
      label256:
      ((oya)localObject).a().setImageSrc(str);
    }
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    Object localObject = paramView.getTag();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData");
    }
    localObject = (BaseCommentData.CommentLinkData)localObject;
    CommentLinkView.a(this.a).remove(localObject);
    notifyDataSetChanged();
    localObject = this.a.a();
    if (localObject != null) {
      ((oyb)localObject).c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxz
 * JD-Core Version:    0.7.0.1
 */