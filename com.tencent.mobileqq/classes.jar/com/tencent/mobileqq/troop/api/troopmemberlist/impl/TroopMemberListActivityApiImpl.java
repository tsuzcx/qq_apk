package com.tencent.mobileqq.troop.api.troopmemberlist.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.api.troopmemberlist.IAddFrdStateMngProxy;
import com.tencent.mobileqq.troop.api.troopmemberlist.IFacePreloadBaseAdapter;
import com.tencent.mobileqq.troop.api.troopmemberlist.IFacePreloadBaseAdapterProxy;
import com.tencent.mobileqq.troop.api.troopmemberlist.IFriendListObserverForAddFrdProxy;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi.TroopGiftCallbackTemp;
import com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment;
import com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.troophonor.VasTroopHonorRichHandler;
import com.tencent.mobileqq.vas.troopnick.TroopNickNameHelper;
import com.tencent.widget.ListView;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;

public class TroopMemberListActivityApiImpl
  implements ITroopMemberListActivityApi
{
  public void clothEffectView(Context paramContext, ViewGroup paramViewGroup, int paramInt, String paramString)
  {
    new VasTroopHonorRichHandler().a(paramContext, paramViewGroup, paramInt, paramString);
  }
  
  public SpannableString createColorNickText(CharSequence paramCharSequence, int paramInt)
  {
    return new ColorNickText(paramCharSequence, paramInt).a();
  }
  
  public String getAccountNickName(AppInterface paramAppInterface, String paramString)
  {
    return ContactUtils.e((QQAppInterface)paramAppInterface, paramString);
  }
  
  public IAddFrdStateMngProxy getAddFrdStateMngProxy(AppInterface paramAppInterface)
  {
    return new AddFrdStateMngProxy((QQAppInterface)paramAppInterface);
  }
  
  public int getBigClubFlag(int paramInt)
  {
    return VipUtils.b(paramInt);
  }
  
  public String getConfigContentForTag(String paramString1, String paramString2)
  {
    return CfgProcess.a(paramString1, "troop_member_list_config");
  }
  
  public int getCurrentUserVipType(AppInterface paramAppInterface)
  {
    return ((ISVIPHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
  }
  
  public Drawable getDefaultTroopFaceDrawableNew()
  {
    return ImageUtil.a();
  }
  
  public IFacePreloadBaseAdapterProxy getFacePreloadBaseAdapterProxy(IFacePreloadBaseAdapter paramIFacePreloadBaseAdapter, Context paramContext, AppInterface paramAppInterface, Object paramObject, int paramInt, boolean paramBoolean)
  {
    return new FacePreloadBaseAdapterProxy(paramIFacePreloadBaseAdapter, paramContext, (QQAppInterface)paramAppInterface, (ListView)paramObject, paramInt, paramBoolean);
  }
  
  public Object getFriendListObserverForAddFrd(IFriendListObserverForAddFrdProxy paramIFriendListObserverForAddFrdProxy)
  {
    return new TroopMemberListActivityApiImpl.2(this, paramIFriendListObserverForAddFrdProxy);
  }
  
  public int getVipTypeByFlag(int paramInt)
  {
    return VipUtils.a(paramInt);
  }
  
  public void handleRichLevel(int paramInt, byte paramByte, Object paramObject)
  {
    new VasTroopHonorRichHandler().a(paramInt, paramByte, (TroopMemberRankItem)paramObject);
  }
  
  public int hrExtra(long paramLong)
  {
    return QAVHrMeeting.a(paramLong);
  }
  
  public boolean isHRConf(long paramLong)
  {
    return QAVHrMeeting.b(paramLong);
  }
  
  public boolean isNoRight(int paramInt)
  {
    return QAVHrMeeting.a(paramInt);
  }
  
  public boolean isPSTNConf(long paramLong)
  {
    return QAVHrMeeting.a(paramLong);
  }
  
  public void openTroopFileBrowserActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.a, paramString1);
    localIntent.putExtra("filter_member_name", paramString2);
    localIntent.putExtra("filter_uin", Long.valueOf(paramString3));
    localIntent.putExtra("folderPath", "/");
    localIntent.putExtra("param_from", 6000);
    TroopFileProxyActivity.a(paramActivity, localIntent, paramString4);
  }
  
  public void openTroopmemberCard(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    TroopMemberCardUtils.a((QQAppInterface)paramAppInterface, paramContext, paramString1, paramString2, 1, paramInt, paramBundle);
  }
  
  public void reportDC00087(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    GameCenterUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void requestGiftMemberList(AppInterface paramAppInterface, String paramString, ITroopMemberListActivityApi.TroopGiftCallbackTemp paramTroopGiftCallbackTemp)
  {
    ((TroopGiftManager)paramAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(paramString, new TroopMemberListActivityApiImpl.1(this, paramTroopGiftCallbackTemp));
  }
  
  public void setColorText(AppInterface paramAppInterface, TextView paramTextView, Spannable paramSpannable)
  {
    ColorNickManager.a((QQAppInterface)paramAppInterface, paramTextView, paramSpannable);
  }
  
  public void setCustomCloth(TextView paramTextView, Context paramContext, int paramInt, boolean paramBoolean)
  {
    TroopNickNameHelper.a(paramTextView, paramContext, paramInt, paramBoolean);
  }
  
  public void startEditUniqueTitleActivity(Activity paramActivity, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    paramActivity.startActivityForResult(EditUniqueTitleActivity.a(paramActivity, 1, paramString1, paramString2, paramInt1, paramString3), paramInt2);
  }
  
  public void startSelectMemberActivity(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_from", 30);
    localIntent.putExtra("group_uin", paramString1);
    localIntent.putExtra("param_groupcode", paramString2);
    localIntent.putExtra("param_from", 30);
    localIntent.putExtra("param_subtype", 4);
    localIntent.putExtra("param_entrance", 30);
    localIntent.putExtra("param_max", paramInt);
    localIntent.putExtra("param_exit_animation", 3);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(paramActivity, localIntent);
  }
  
  public void startSelectTroopMemberFragment(Activity paramActivity, boolean paramBoolean, String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("onlyloadLocalData", paramBoolean);
    localBundle.putInt("from", 1);
    SelectTroopMemberFragment.a(paramActivity, localBundle, paramString, paramInt);
  }
  
  public void startTroopMemberHistoryFragment(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", paramString1);
    localIntent.putExtra("member_uin", paramString2);
    PublicFragmentActivity.a(paramActivity, localIntent, TroopMemberHistoryFragment.class);
  }
  
  public void startTroopMemberHistoryFragment(Context paramContext, String paramString, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", paramString);
    localIntent.putExtra("members_uin", paramArrayList);
    PublicFragmentActivity.a(paramContext, localIntent, TroopMemberHistoryFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopmemberlist.impl.TroopMemberListActivityApiImpl
 * JD-Core Version:    0.7.0.1
 */