import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$topicAdapter$1", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ColumnInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$MyTopicViewHolder;", "bindViewHolder", "", "topicInfo", "holder", "createView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewGroup", "Landroid/view/ViewGroup;", "createViewHolder", "itemView", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rpv
  extends rpj<ColumnInfo, rpu>
{
  public rpv(Context paramContext)
  {
    super(localContext);
  }
  
  @NotNull
  public View a(@NotNull Context paramContext, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = LayoutInflater.from(paramContext).inflate(2131560215, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…  false\n                )");
    return paramContext;
  }
  
  @NotNull
  public rpu a(@NotNull Context paramContext, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramContext = (TextView)paramView.findViewById(2131378800);
    TextView localTextView = (TextView)paramView.findViewById(2131378965);
    paramView = (ImageView)paramView.findViewById(2131369207);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "titleText");
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "introView");
    Intrinsics.checkExpressionValueIsNotNull(paramView, "coverView");
    return new rpu(paramContext, localTextView, paramView);
  }
  
  public void a(@NotNull ColumnInfo paramColumnInfo, @NotNull rpu paramrpu)
  {
    Intrinsics.checkParameterIsNotNull(paramColumnInfo, "topicInfo");
    Intrinsics.checkParameterIsNotNull(paramrpu, "holder");
    paramrpu.a().setImageDrawable((Drawable)URLDrawable.getDrawable(paramColumnInfo.coverUrl, URLDrawable.URLDrawableOptions.obtain()));
    Drawable localDrawable = a().getResources().getDrawable(2130843060);
    localDrawable.setBounds(0, 0, UIUtils.dip2px(a(), 15.0F), UIUtils.dip2px(a(), 15.0F));
    TextView localTextView = paramrpu.a();
    localTextView.setText((CharSequence)paramColumnInfo.title);
    localTextView.setCompoundDrawablePadding(UIUtils.dip2px(localTextView.getContext(), 3.0F));
    localTextView.setCompoundDrawables(localDrawable, null, null, null);
    paramColumnInfo = a().getResources().getString(2131717502, new Object[] { Integer.valueOf(paramColumnInfo.videoCount), Integer.valueOf(paramColumnInfo.subscribeCount) });
    paramrpu.b().setText((CharSequence)paramColumnInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpv
 * JD-Core Version:    0.7.0.1
 */