package dov.com.qq.im.aeeditor.module.filter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/module/filter/AdapterUtil;", "", "()V", "scrollToPositionAndLayoutCenter", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "targetPosition", "", "fixScrollTime", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AdapterUtil
{
  public static final AdapterUtil a = new AdapterUtil();
  
  @JvmStatic
  public static final void a(@Nullable RecyclerView paramRecyclerView, int paramInt, boolean paramBoolean)
  {
    if (paramRecyclerView == null) {
      return;
    }
    Object localObject = paramRecyclerView.getLayoutManager();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
    }
    localObject = (LinearLayoutManager)localObject;
    paramRecyclerView.post((Runnable)new AdapterUtil.scrollToPositionAndLayoutCenter.1((LinearSmoothScroller)new AdapterUtil.scrollToPositionAndLayoutCenter.scroller.1((LinearLayoutManager)localObject, paramBoolean, paramRecyclerView, paramRecyclerView.getContext()), paramInt, (LinearLayoutManager)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AdapterUtil
 * JD-Core Version:    0.7.0.1
 */