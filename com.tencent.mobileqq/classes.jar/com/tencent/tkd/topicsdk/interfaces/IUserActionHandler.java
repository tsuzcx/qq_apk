package com.tencent.tkd.topicsdk.interfaces;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.coverselect.CoverSelectData;
import com.tencent.tkd.weibo.bean.EditObject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/interfaces/IUserActionHandler;", "Lcom/tencent/tkd/topicsdk/interfaces/Releasable;", "onAtButtonClicked", "", "activity", "Landroid/app/Activity;", "inputBundle", "Landroid/os/Bundle;", "callback", "Lkotlin/Function2;", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "editObjects", "outputBundle", "onLocationButtonClicked", "originLocationInfo", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "Lkotlin/Function1;", "newLocationInfo", "onPublishButtonClicked", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "onTopicButtonClicked", "editObject", "onTopicCoverChangeClicked", "", "coverPath", "onVideoCoverSelectClicked", "coverSelectData", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "result", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface IUserActionHandler
  extends Releasable
{
  public static final IUserActionHandler.Companion b = IUserActionHandler.Companion.a;
  
  public abstract void a(@NotNull Activity paramActivity, @Nullable Bundle paramBundle, @NotNull Function2<? super ArrayList<EditObject>, ? super Bundle, Unit> paramFunction2);
  
  public abstract void a(@NotNull Activity paramActivity, @Nullable LocationInfo paramLocationInfo, @NotNull Function1<? super LocationInfo, Unit> paramFunction1);
  
  public abstract void a(@NotNull Activity paramActivity, @NotNull PublishArticleInfo paramPublishArticleInfo);
  
  public abstract void a(@NotNull Activity paramActivity, @NotNull CoverSelectData paramCoverSelectData, @NotNull Function1<? super CoverSelectData, Unit> paramFunction1);
  
  public abstract void b(@NotNull Activity paramActivity, @Nullable Bundle paramBundle, @NotNull Function2<? super EditObject, ? super Bundle, Unit> paramFunction2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.interfaces.IUserActionHandler
 * JD-Core Version:    0.7.0.1
 */