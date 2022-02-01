package com.tencent.mobileqq.nearby.profilecard;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyTag;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$Companion;", "", "()V", "ARG_NEARBY_TAG", "", "SP_SAVE_NEARBY_TAG", "TAG", "showDialog", "", "nearbyTag", "Lcom/tencent/nowsummarycard/NowSummaryCard$NearbyTag;", "activity", "Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyInterestsChooseDialog$Companion
{
  public final boolean a(@Nullable NowSummaryCard.NearbyTag paramNearbyTag, @NotNull NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramNearbyPeopleProfileActivity, "activity");
    if (paramNearbyTag == null)
    {
      QLog.w("NearbyInterestsChooseDialog", 1, "showDialog error: null nearbyTag");
      return false;
    }
    Object localObject = paramNearbyPeopleProfileActivity.getSupportFragmentManager();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.supportFragmentManager");
    NearbyProfileReportKt.a(paramNearbyPeopleProfileActivity);
    paramNearbyPeopleProfileActivity = new NearbyInterestsChooseDialog();
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("ARG_NEARBY_TAG", paramNearbyTag.toByteArray());
    paramNearbyPeopleProfileActivity.setArguments(localBundle);
    paramNearbyTag = ((FragmentManager)localObject).beginTransaction();
    localObject = ((FragmentManager)localObject).findFragmentByTag("NearbyInterestsChooseDialog");
    if (localObject != null)
    {
      QLog.i("NearbyInterestsChooseDialog", 1, "showDialog: remove existing dialog");
      paramNearbyTag.remove((Fragment)localObject);
    }
    paramNearbyTag.add((Fragment)paramNearbyPeopleProfileActivity, "NearbyInterestsChooseDialog");
    paramNearbyTag.commitAllowingStateLoss();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyInterestsChooseDialog.Companion
 * JD-Core Version:    0.7.0.1
 */