import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/CommentLinkView$LinkAdatper$ViewHolder;", "", "root", "Landroid/view/View;", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/CommentLinkView$LinkAdatper;Landroid/view/View;)V", "vDelete", "getVDelete", "()Landroid/view/View;", "vDescription", "Landroid/widget/TextView;", "getVDescription", "()Landroid/widget/TextView;", "vIcon", "Lcom/tencent/biz/pubaccount/readinjoy/proteus/view/impl/NativeReadInjoyImageView;", "getVIcon", "()Lcom/tencent/biz/pubaccount/readinjoy/proteus/view/impl/NativeReadInjoyImageView;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class oya
{
  @NotNull
  private final View jdField_a_of_type_AndroidViewView;
  @NotNull
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private final NativeReadInjoyImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  
  public oya(View paramView)
  {
    paramView = localObject.findViewById(2131368236);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "root.findViewById(R.id.icon)");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)paramView);
    paramView = localObject.findViewById(2131365445);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "root.findViewById(R.id.description)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView);
    paramView = localObject.findViewById(2131365396);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "root.findViewById(R.id.delete)");
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  @NotNull
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  @NotNull
  public final NativeReadInjoyImageView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oya
 * JD-Core Version:    0.7.0.1
 */