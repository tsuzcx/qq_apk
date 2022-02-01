package dov.com.qq.im.aeeditor.view.reorder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/view/reorder/ReorderContainerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "adapter", "Ldov/com/qq/im/aeeditor/view/reorder/ReorderContainerView$SpacingAdapter;", "getAdapter", "()Ldov/com/qq/im/aeeditor/view/reorder/ReorderContainerView$SpacingAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dragUUID", "dragViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemTouchHelper", "Lcom/tencent/widget/itemtouchhelper/ItemTouchHelper;", "linearLayoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "reorderListener", "Ldov/com/qq/im/aeeditor/view/reorder/ReorderListener;", "getReorderListener", "()Ldov/com/qq/im/aeeditor/view/reorder/ReorderListener;", "setReorderListener", "(Ldov/com/qq/im/aeeditor/view/reorder/ReorderListener;)V", "screenWidth", "getScreenWidth", "()I", "screenWidth$delegate", "targetIndex", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "initial", "", "scrollToTarget", "uuid", "point", "Landroid/graphics/Point;", "startDrag", "index", "submitList", "data", "", "Lcom/tencent/weseevideo/camera/mvauto/redo/CutModelKt;", "SpacingAdapter", "SpacingVH", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ReorderContainerView
  extends RecyclerView
{
  private int jdField_a_of_type_Int;
  private final LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private ItemTouchHelper jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper;
  @Nullable
  private ReorderListener jdField_a_of_type_DovComQqImAeeditorViewReorderReorderListener;
  private final String jdField_a_of_type_JavaLangString = "ReorderContainerView";
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)ReorderContainerView.adapter.2.INSTANCE);
  private String jdField_b_of_type_JavaLangString;
  private final Lazy jdField_b_of_type_KotlinLazy;
  
  @JvmOverloads
  public ReorderContainerView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public ReorderContainerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public ReorderContainerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_KotlinLazy = LazyKt.lazy((Function0)new ReorderContainerView.screenWidth.2(paramContext));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_Int = -1;
  }
  
  private final ReorderContainerView.SpacingAdapter a()
  {
    return (ReorderContainerView.SpacingAdapter)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  public final int a(@NotNull String paramString, @NotNull Point paramPoint)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    Intrinsics.checkParameterIsNotNull(paramPoint, "point");
    this.jdField_b_of_type_JavaLangString = paramString;
    int i = a().a(paramString);
    int j = paramPoint.x;
    int k = ViewUtils.dip2px(-45.0F);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.scrollToPositionWithOffset(i + 1, j + k);
    return i;
  }
  
  @Nullable
  public final ReorderListener a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderListener;
  }
  
  public final void a()
  {
    setLayoutManager((RecyclerView.LayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    setAdapter((RecyclerView.Adapter)a());
    addItemDecoration((RecyclerView.ItemDecoration)new SpacesItemDecoration(getResources().getDimensionPixelSize(2131296323)));
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper = new ItemTouchHelper((ItemTouchHelper.Callback)new ReorderContainerView.initial.itemTouchCallback.1(this, 51, 0));
    ItemTouchHelper localItemTouchHelper = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper;
    if (localItemTouchHelper != null) {
      localItemTouchHelper.attachToRecyclerView((RecyclerView)this);
    }
  }
  
  public final void a(int paramInt)
  {
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "startDrag() called with: index = [" + paramInt + ']');
    RecyclerView.ViewHolder localViewHolder = findViewHolderForLayoutPosition(paramInt + 1);
    if (localViewHolder != null)
    {
      ItemTouchHelper localItemTouchHelper = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper;
      if (localItemTouchHelper != null) {
        localItemTouchHelper.startDrag(localViewHolder);
      }
      AEQLog.b(this.jdField_a_of_type_JavaLangString, "startDrag() called with: vh = [$]");
    }
  }
  
  public final void a(@NotNull List<CutModelKt> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "data");
    a().a(paramList);
  }
  
  public boolean dispatchTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    AEQLog.a(this.jdField_a_of_type_JavaLangString, "dispatchTouchEvent: width: " + getWidth() + ", height: " + getHeight());
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "dispatchTouchEvent() called with: ev = [" + paramMotionEvent + ']');
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final void setReorderListener(@Nullable ReorderListener paramReorderListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderListener = paramReorderListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.reorder.ReorderContainerView
 * JD-Core Version:    0.7.0.1
 */