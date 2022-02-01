package com.tencent.mobileqq.kandian.biz.diandian.entryview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.report.RIJEntryViewReport;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.selecttopic.SlidingUpDialog;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.adapter.entryview.BizEntryDialogView;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/diandian/entryview/RIJEntryViewUtils;", "", "()V", "ENABLE_UPLOAD_IMAGE_TEXT", "", "ENABLE_UPLOAD_VIDEO", "NO_PERMISSION", "", "SHOW_ENTRY_VIEW", "TAG", "UGC_PERMISSION", "UPLOAD_AUTH_IMAGE_TEXT", "UPLOAD_AUTH_VIDEO", "VIDEO_PERMISSION", "VIDEO_UGC_PERMISSION", "callEntryViewClickAction", "", "activity", "Landroid/app/Activity;", "type", "columnInfo", "Lcom/tencent/mobileqq/kandian/repo/db/struct/ColumnInfo;", "kdCommunityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "from", "callback", "requestCode", "getConfigFromAladdin", "", "nameSpace", "keyString", "getMainTLAladdinConfig", "getPersonalCenterAladdinConfig", "showEntryDialog", "showEntryView", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJEntryViewUtils
{
  public static final RIJEntryViewUtils a = new RIJEntryViewUtils();
  
  private final void a(Activity paramActivity, ColumnInfo paramColumnInfo, CommunityInfo paramCommunityInfo, int paramInt1, String paramString, int paramInt2)
  {
    BizEntryDialogView localBizEntryDialogView = new BizEntryDialogView((Context)paramActivity, false, 2, null);
    SlidingUpDialog localSlidingUpDialog = new SlidingUpDialog(paramActivity, (View)localBizEntryDialogView, false, new RelativeLayout.LayoutParams(-1, paramActivity.getResources().getDimensionPixelOffset(2131298815)));
    localBizEntryDialogView.setLeftClickListener((Function0)new RIJEntryViewUtils.showEntryDialog..inlined.let.lambda.1(paramActivity, paramColumnInfo, paramCommunityInfo, paramInt1, paramString, paramInt2, localSlidingUpDialog));
    localBizEntryDialogView.setRightClickListener((Function0)new RIJEntryViewUtils.showEntryDialog..inlined.let.lambda.2(paramActivity, paramColumnInfo, paramCommunityInfo, paramInt1, paramString, paramInt2, localSlidingUpDialog));
    localBizEntryDialogView.setCancelClickListener((Function0)new RIJEntryViewUtils.showEntryDialog..inlined.let.lambda.3(paramActivity, paramColumnInfo, paramCommunityInfo, paramInt1, paramString, paramInt2, localSlidingUpDialog));
    localSlidingUpDialog.show();
    RIJEntryViewReport.a("0X800BBD2");
    RIJEntryViewReport.a("0X800BBD3", 2);
    RIJEntryViewReport.a("0X800BBCF", 2);
  }
  
  private final boolean a(int paramInt, String paramString)
  {
    return Aladdin.getConfig(paramInt).getIntegerFromString(paramString, 0) == 1;
  }
  
  public final int a()
  {
    boolean bool1 = a(469, "enable_upload_video");
    boolean bool2 = a(469, "enable_upload_image_text");
    if ((bool1) && (bool2)) {
      return 3;
    }
    if (bool2) {
      return 2;
    }
    if (bool1) {
      return 1;
    }
    return 0;
  }
  
  public final void a(@NotNull Activity paramActivity, int paramInt1, @Nullable ColumnInfo paramColumnInfo, @Nullable CommunityInfo paramCommunityInfo, int paramInt2, @Nullable String paramString, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          QLog.e("RIJEntryViewUtils", 1, "No Permission for publisher");
          return;
        }
        a(paramActivity, paramColumnInfo, paramCommunityInfo, paramInt2, paramString, paramInt3);
        return;
      }
      RIJUgcUtils.a(paramActivity, paramInt2);
      return;
    }
    RIJUgcUtils.a(paramActivity, paramColumnInfo, paramCommunityInfo, paramInt2, paramString, paramInt3);
  }
  
  public final boolean a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(469);
    long l = RIJUserLevelModule.getInstance().getCurrentUserLevelInfo(7).level;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAladdinConfig.getIntegerFromString("enable_publisher_entrance", 0) == 1)
    {
      bool1 = bool2;
      if (l > 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final int b()
  {
    boolean bool1 = a(446, "upload_auth_video");
    boolean bool2 = a(446, "upload_auth_image_text");
    if ((bool1) && (bool2)) {
      return 3;
    }
    if (bool2) {
      return 2;
    }
    if (bool1) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils
 * JD-Core Version:    0.7.0.1
 */