import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$topicAdapter$1", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ColumnInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$MyTopicViewHolder;", "bindViewHolder", "", "topicInfo", "holder", "createView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewGroup", "Landroid/view/ViewGroup;", "createViewHolder", "itemView", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class riv
  extends rij<ColumnInfo, riu>
{
  public riv(Context paramContext)
  {
    super(localContext);
  }
  
  @NotNull
  public View a(@NotNull Context paramContext, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = LayoutInflater.from(paramContext).inflate(2131560208, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…  false\n                )");
    return paramContext;
  }
  
  @NotNull
  public riu a(@NotNull Context paramContext, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramContext = (TextView)paramView.findViewById(2131379030);
    TextView localTextView = (TextView)paramView.findViewById(2131379196);
    paramView = (ImageView)paramView.findViewById(2131369184);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "titleText");
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "introView");
    Intrinsics.checkExpressionValueIsNotNull(paramView, "coverView");
    return new riu(paramContext, localTextView, paramView);
  }
  
  public void a(@NotNull ColumnInfo paramColumnInfo, @NotNull riu paramriu)
  {
    Intrinsics.checkParameterIsNotNull(paramColumnInfo, "topicInfo");
    Intrinsics.checkParameterIsNotNull(paramriu, "holder");
    paramriu.a().setImageDrawable((Drawable)URLDrawable.getDrawable(paramColumnInfo.coverUrl, URLDrawable.URLDrawableOptions.obtain()));
    Drawable localDrawable = a().getResources().getDrawable(2130843006);
    localDrawable.setBounds(0, 0, zps.a(a(), 15.0F), zps.a(a(), 15.0F));
    TextView localTextView = paramriu.a();
    localTextView.setText((CharSequence)paramColumnInfo.title);
    localTextView.setCompoundDrawablePadding(zps.a(localTextView.getContext(), 3.0F));
    localTextView.setCompoundDrawables(localDrawable, null, null, null);
    paramColumnInfo = a().getResources().getString(2131717271, new Object[] { Integer.valueOf(paramColumnInfo.videoCount), Integer.valueOf(paramColumnInfo.subscribeCount) });
    paramriu.b().setText((CharSequence)paramColumnInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     riv
 * JD-Core Version:    0.7.0.1
 */