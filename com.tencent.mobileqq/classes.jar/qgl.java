import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteSwiperEventDispatcher.handleSwiperDrag.1;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteSwiperEventDispatcher.handleSwiperItemExposure.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.SplashActivity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteSwiperEventDispatcher;", "", "()V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "articleInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "Lkotlin/collections/HashMap;", "positionMap", "", "getBehaviorTypeAndStayTimeMillis", "Landroid/util/Pair;", "", "channelId", "handleSwiperDrag", "", "identifier", "dataSet", "view", "Landroid/view/View;", "handleSwiperItemExposure", "folderStatus", "Builder", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qgl
{
  public static final qgn a;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private sel jdField_a_of_type_Sel;
  private HashMap<String, ArticleInfo> b = new HashMap();
  
  static
  {
    jdField_a_of_type_Qgn = new qgn(null);
  }
  
  private final Pair<Integer, Long> a(int paramInt)
  {
    long l2 = 0L;
    int j = 0;
    int i = 0;
    Object localObject = this.jdField_a_of_type_Sel;
    if (localObject != null)
    {
      localObject = ((sel)localObject).a();
      if (!(localObject instanceof ReadInJoyNewFeedsActivity)) {
        break label274;
      }
      localObject = this.jdField_a_of_type_Sel;
      if (localObject == null) {
        break label72;
      }
    }
    label72:
    for (localObject = ((sel)localObject).a();; localObject = null)
    {
      if (localObject != null) {
        break label78;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity");
      localObject = null;
      break;
    }
    label78:
    long l1;
    if (((ReadInJoyNewFeedsActivity)localObject).a() > 0L)
    {
      localObject = this.jdField_a_of_type_Sel;
      if (localObject != null) {}
      for (localObject = ((sel)localObject).a(); localObject == null; localObject = null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity");
      }
      l1 = ((ReadInJoyNewFeedsActivity)localObject).a();
      localObject = this.jdField_a_of_type_Sel;
      if (localObject == null) {
        break label233;
      }
    }
    label233:
    for (localObject = ((sel)localObject).a();; localObject = null)
    {
      if (localObject != null) {
        break label239;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity");
      l1 = System.currentTimeMillis();
      localObject = this.jdField_a_of_type_Sel;
      if (localObject != null) {}
      for (localObject = ((sel)localObject).a(); localObject == null; localObject = null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity");
      }
      l1 -= ((ReadInJoyNewFeedsActivity)localObject).b();
      break;
    }
    label239:
    if (((ReadInJoyNewFeedsActivity)localObject).b()) {
      paramInt = 0;
    }
    label398:
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt), Long.valueOf(l1));
      paramInt = 1;
      continue;
      label274:
      localObject = this.jdField_a_of_type_Sel;
      if (localObject != null)
      {
        localObject = ((sel)localObject).a();
        label292:
        if (!(localObject instanceof SplashActivity)) {
          break label370;
        }
        localObject = this.jdField_a_of_type_Sel;
        if (localObject == null) {
          break label359;
        }
        localObject = ((sel)localObject).a();
        label318:
        localObject = ozs.a((Context)localObject);
        if (localObject == null) {
          break label398;
        }
        if (((ReadinjoyTabFrame)localObject).b == 0) {
          break label365;
        }
      }
      label359:
      label365:
      for (paramInt = j;; paramInt = 1)
      {
        l1 = ((ReadinjoyTabFrame)localObject).a();
        break;
        localObject = null;
        break label292;
        localObject = null;
        break label318;
      }
      label370:
      if (pbd.c(paramInt))
      {
        l1 = l2;
        paramInt = i;
        if (oyc.b() == 0)
        {
          paramInt = 1;
          l1 = l2;
        }
      }
      else
      {
        paramInt = -1;
        l1 = l2;
      }
    }
  }
  
  public final void a(@Nullable String paramString, @NotNull HashMap<String, String> paramHashMap, @Nullable View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "dataSet");
    bkdz.a((Runnable)new PTSLiteSwiperEventDispatcher.handleSwiperDrag.1(paramString, paramHashMap));
  }
  
  public final void a(@Nullable String paramString1, @NotNull HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "dataSet");
    bkdz.a((Runnable)new PTSLiteSwiperEventDispatcher.handleSwiperItemExposure.1(this, paramString1, paramString2, paramHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgl
 * JD-Core Version:    0.7.0.1
 */