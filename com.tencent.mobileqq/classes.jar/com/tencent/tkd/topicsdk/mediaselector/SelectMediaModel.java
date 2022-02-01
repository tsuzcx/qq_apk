package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/SelectMediaModel;", "Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "loadMedias", "", "panelType", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "callback", "Lkotlin/Function2;", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/Media;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "mediaList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mediaMap", "loadPhotos", "loadVideos", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectMediaModel
  implements IMediaContract.IModel
{
  public static final SelectMediaModel.Companion a = new SelectMediaModel.Companion(null);
  private final Context b;
  
  public SelectMediaModel(@NotNull Context paramContext)
  {
    this.b = paramContext;
  }
  
  private final void a(Context paramContext, Function2<? super ArrayList<Media>, ? super HashMap<String, ArrayList<Media>>, Unit> paramFunction2)
  {
    MediaDataManager.a.a(paramContext, paramFunction2);
  }
  
  private final void b(Context paramContext, Function2<? super ArrayList<Media>, ? super HashMap<String, ArrayList<Media>>, Unit> paramFunction2)
  {
    MediaDataManager.a.b(paramContext, paramFunction2);
  }
  
  public void a(@NotNull PanelType paramPanelType, @NotNull Function2<? super ArrayList<Media>, ? super HashMap<String, ArrayList<Media>>, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType, "panelType");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    int i = SelectMediaModel.WhenMappings.$EnumSwitchMapping$0[paramPanelType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("no support panelType=");
        localStringBuilder.append(paramPanelType);
        TLog.a("SelectMediaModel", localStringBuilder.toString());
        paramFunction2.invoke(new ArrayList(), new HashMap());
        return;
      }
      b(this.b, paramFunction2);
      return;
    }
    a(this.b, paramFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.SelectMediaModel
 * JD-Core Version:    0.7.0.1
 */