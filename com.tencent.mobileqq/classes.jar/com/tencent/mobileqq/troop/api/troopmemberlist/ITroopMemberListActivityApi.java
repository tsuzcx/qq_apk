package com.tencent.mobileqq.troop.api.troopmemberlist;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface ITroopMemberListActivityApi
  extends QRouteApi
{
  public static final int USER_TYPE_SVIP = 2;
  public static final int USER_TYPE_VIP = 1;
  public static final int USER_TYPE_YEAR_SVIP = 4;
  public static final int USER_TYPE_YEAR_VIP = 3;
  public static final int VIP_TYPE_SUPERVIP = 3;
  
  public abstract void clothEffectView(Context paramContext, ViewGroup paramViewGroup, int paramInt, String paramString);
  
  public abstract SpannableString createColorNickText(CharSequence paramCharSequence, int paramInt);
  
  public abstract String getAccountNickName(AppInterface paramAppInterface, String paramString);
  
  public abstract IAddFrdStateMngProxy getAddFrdStateMngProxy(AppInterface paramAppInterface);
  
  public abstract int getBigClubFlag(int paramInt);
  
  public abstract String getConfigContentForTag(String paramString1, String paramString2);
  
  public abstract int getCurrentUserVipType(AppInterface paramAppInterface);
  
  public abstract Drawable getDefaultTroopFaceDrawableNew();
  
  public abstract IFacePreloadBaseAdapterProxy getFacePreloadBaseAdapterProxy(IFacePreloadBaseAdapter paramIFacePreloadBaseAdapter, Context paramContext, AppInterface paramAppInterface, Object paramObject, int paramInt, boolean paramBoolean);
  
  public abstract Object getFriendListObserverForAddFrd(IFriendListObserverForAddFrdProxy paramIFriendListObserverForAddFrdProxy);
  
  public abstract int getVipTypeByFlag(int paramInt);
  
  public abstract void handleRichLevel(int paramInt, byte paramByte, Object paramObject);
  
  public abstract int hrExtra(long paramLong);
  
  public abstract boolean isHRConf(long paramLong);
  
  public abstract boolean isNoRight(int paramInt);
  
  public abstract boolean isPSTNConf(long paramLong);
  
  public abstract void openTroopFileBrowserActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void openTroopmemberCard(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt, Bundle paramBundle);
  
  public abstract void reportDC00087(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract void requestGiftMemberList(AppInterface paramAppInterface, String paramString, ITroopMemberListActivityApi.TroopGiftCallbackTemp paramTroopGiftCallbackTemp);
  
  public abstract void setColorText(AppInterface paramAppInterface, TextView paramTextView, Spannable paramSpannable);
  
  public abstract void setCustomCloth(TextView paramTextView, Context paramContext, int paramInt, boolean paramBoolean);
  
  public abstract void startEditUniqueTitleActivity(Activity paramActivity, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2);
  
  public abstract void startSelectMemberActivity(Activity paramActivity, String paramString1, String paramString2, int paramInt);
  
  public abstract void startSelectTroopMemberFragment(Activity paramActivity, boolean paramBoolean, String paramString, int paramInt);
  
  public abstract void startTroopMemberHistoryFragment(Activity paramActivity, String paramString1, String paramString2);
  
  public abstract void startTroopMemberHistoryFragment(Context paramContext, String paramString, ArrayList<String> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
 * JD-Core Version:    0.7.0.1
 */