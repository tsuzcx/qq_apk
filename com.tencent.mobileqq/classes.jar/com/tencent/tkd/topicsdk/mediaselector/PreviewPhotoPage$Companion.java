package com.tencent.tkd.topicsdk.mediaselector;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/PreviewPhotoPage$Companion;", "", "()V", "MAX_SELECT_NUM", "", "PHOTO_DIR", "PHOTO_LIST", "POSITION", "SELECTED_PHOTO_LIST", "TAG", "openForResult", "", "context", "Landroid/app/Activity;", "requestCode", "", "position", "photoList", "", "selectedPhotoList", "maxSelectNum", "dir", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PreviewPhotoPage$Companion
{
  public final void a(@NotNull Activity paramActivity, int paramInt1, int paramInt2, @NotNull List<String> paramList1, @NotNull List<String> paramList2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "context");
    Intrinsics.checkParameterIsNotNull(paramList1, "photoList");
    Intrinsics.checkParameterIsNotNull(paramList2, "selectedPhotoList");
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("photo_list", new ArrayList((Collection)paramList1));
    localBundle.putStringArrayList("selected_photo_list", new ArrayList((Collection)paramList2));
    localBundle.putInt("position", paramInt2);
    localBundle.putInt("max_select_num", paramInt3);
    TopicSDKHelperKt.a(paramActivity, PreviewPhotoPage.class, paramInt1, localBundle, null, null, 48, null);
  }
  
  public final void a(@NotNull Activity paramActivity, @NotNull String paramString, int paramInt1, int paramInt2, @NotNull List<String> paramList, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "dir");
    Intrinsics.checkParameterIsNotNull(paramList, "selectedPhotoList");
    Bundle localBundle = new Bundle();
    localBundle.putString("photo_dir", paramString);
    localBundle.putStringArrayList("selected_photo_list", new ArrayList((Collection)paramList));
    localBundle.putInt("position", paramInt1);
    localBundle.putInt("max_select_num", paramInt3);
    TopicSDKHelperKt.a(paramActivity, PreviewPhotoPage.class, paramInt2, localBundle, null, null, 48, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.PreviewPhotoPage.Companion
 * JD-Core Version:    0.7.0.1
 */