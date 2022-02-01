import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$MyTopicViewHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "titleText", "Landroid/widget/TextView;", "introView", "coverView", "Landroid/widget/ImageView;", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/ImageView;)V", "getCoverView", "()Landroid/widget/ImageView;", "getIntroView", "()Landroid/widget/TextView;", "getTitleText", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class scj
  extends sbz
{
  @NotNull
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private final TextView b;
  
  public scj(@NotNull TextView paramTextView1, @NotNull TextView paramTextView2, @NotNull ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView1;
    this.b = paramTextView2;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  @NotNull
  public final ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scj
 * JD-Core Version:    0.7.0.1
 */