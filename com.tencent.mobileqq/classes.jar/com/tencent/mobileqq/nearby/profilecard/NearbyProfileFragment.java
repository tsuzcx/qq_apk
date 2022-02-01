package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.troopgift.GiftConfigManager.TextEntryItem;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.NearbyPeopleCard.HiWanItem;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearby.FaceScoreConfig;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyFaceScoreManager;
import com.tencent.mobileqq.nearby.api.FaceScoreUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearpeople.api.INearbyMineHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.utils.NearbyVideoChatManager;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import cooperation.troop.NearbyVideoChatProxyActivity;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0xac5.cmd0xac5.MasterState;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyProfileFragment
  extends BaseFragment
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected URLImageView a;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  protected FaceScoreConfig a;
  LabelDisplayCtrl jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl;
  NearbyPeopleProfileActivity jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
  NearbyProfileDisplayPanel jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel;
  private TopicLabelCtrl jdField_a_of_type_ComTencentMobileqqNearbyProfilecardTopicLabelCtrl;
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  protected String a;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  InterestTag[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  LabelDisplayCtrl jdField_b_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private TextView f;
  private TextView g;
  private TextView h;
  
  private List<StrangerInfo> a(List<Object> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof StrangerInfo)) {
        localArrayList.add((StrangerInfo)localObject);
      }
    }
    return localArrayList;
  }
  
  private void a(List<StrangerInfo> paramList)
  {
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateVistorHeader visitor count:");
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("Q.nearby.visitor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).buildRedTouchAppInfo(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new Object[] { Integer.valueOf(4105), "100510.100523" });
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramList.size() > 3) {
        i = 3;
      } else {
        i = paramList.size();
      }
      localObject1 = new ArrayList(3);
      int j = 0;
      while (j < i)
      {
        localObject2 = (StrangerInfo)paramList.get(j);
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
        j += 1;
      }
      int k = ((List)localObject1).size();
      paramList = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
      Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      i = ((RelativeLayout.LayoutParams)localObject2).width;
      j = this.jdField_a_of_type_Int;
      int m = k - 1;
      int n = this.jdField_b_of_type_Int;
      if (i != k * j + m * n)
      {
        ((RelativeLayout.LayoutParams)localObject2).width = (j * k + m * n);
        i = 1;
      }
      else
      {
        i = 0;
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c()) && (((RelativeLayout.LayoutParams)localObject2).rightMargin != AIOUtils.b(35.0F, paramList))) {}
      for (((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(35.0F, paramList);; ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(45.0F, paramList))
      {
        j = 1;
        break;
        j = i;
        if (!this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c()) {
          break;
        }
        j = i;
        if (((RelativeLayout.LayoutParams)localObject2).rightMargin == AIOUtils.b(45.0F, paramList)) {
          break;
        }
      }
      if (j != 0) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      i = 0;
      while (i < k)
      {
        localObject2 = new LinearLayout.LayoutParams(AIOUtils.b(30.0F, paramList), AIOUtils.b(30.0F, paramList));
        ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(5.0F, paramList);
        StrangerInfo localStrangerInfo = (StrangerInfo)((List)localObject1).get(i);
        if (localStrangerInfo != null)
        {
          CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
          Drawable localDrawable = localCustomImgView.a();
          if ((localDrawable != null) && ((localDrawable instanceof AsynLoadDrawable))) {
            ((AsynLoadDrawable)localDrawable).cancel();
          }
          localCustomImgView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 200, String.valueOf(localStrangerInfo.tinyId), true));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject2);
        }
        i += 1;
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((NearbyPeopleCard)localObject1).nearbyNowData;
    int k = 0;
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get() != null) && (((cmd0xac5.NearbyNowData)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get() != null))
    {
      j = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get()).uint32_state.get();
      localObject1 = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get()).bytes_jump_url.get().toStringUtf8();
    }
    else
    {
      localObject1 = "";
      j = 0;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    int i = -1;
    StringBuilder localStringBuilder;
    if (j == 0)
    {
      this.g.setText(HardCodeUtil.a(2131707305));
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      else
      {
        localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1);
        ((ReportTask)localObject2).a(new String[] { "", localStringBuilder.toString(), "1" }).a();
      }
      i = 1;
    }
    else if (j == 1)
    {
      this.g.setText(HardCodeUtil.a(2131707397));
      localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1);
      ((ReportTask)localObject2).a(new String[] { "", localStringBuilder.toString(), "3" }).a();
      i = 3;
    }
    else if (j == 2)
    {
      this.g.setText(HardCodeUtil.a(2131707322));
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      else
      {
        localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1);
        ((ReportTask)localObject2).a(new String[] { "", localStringBuilder.toString(), "2" }).a();
      }
      i = 2;
    }
    if (!NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app)) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new NearbyProfileFragment.1(this, (String)localObject1, i));
    if (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370055).setVisibility(8);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
    b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    i = ((Resources)localObject1).getColor(2131167056);
    int j = ((Resources)localObject1).getColor(2131167144);
    localObject1 = new StringBuilder();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    ((NearbyPeopleCard)localObject2).company = StringUtil.d(((NearbyPeopleCard)localObject2).company);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company))
    {
      ((StringBuilder)localObject1).append(new QQText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company, 1, 16));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_company", 0, 0, "", "", "", "");
      ((StringBuilder)localObject1).append("  ");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job < NearbyProfileUtil.d.length))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_work", 0, 0, "", "", "", "");
      ((StringBuilder)localObject1).append(NearbyProfileUtil.d[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
      ((StringBuilder)localObject1).append("  ");
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    ((NearbyPeopleCard)localObject2).college = StringUtil.d(((NearbyPeopleCard)localObject2).college);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
    {
      ((StringBuilder)localObject1).append(new QQText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, 1, 16));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_school", 0, 0, "", "", "", "");
    }
    if (((StringBuilder)localObject1).length() > 0)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694490));
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(j);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig = FaceScoreUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig.a()) {
      ((NearbyFaceScoreManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(QQManagerFactory.FACE_SCORE_MANAGER)).a(new NearbyProfileFragment.2(this));
    } else {
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig);
    }
    a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2)
    {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType == 1) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    else
    {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new NearbyProfileFragment.3(this));
      localObject1 = TroopGiftAioPanelData.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 1);
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((TroopGiftAioPanelData)localObject1).a;
      }
      if (localObject1 != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(((GiftConfigManager.TextEntryItem)localObject1).jdField_a_of_type_JavaLangString);
      } else {
        ((TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(1402, new NearbyProfileFragment.4(this));
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new NearbyProfileFragment.5(this, (GiftConfigManager.TextEntryItem)localObject1));
      ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "my_point", 0, 0, "", "", "", "");
    }
    if (NearbyProfileCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from))
    {
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsgForTribar;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTipsForTribar;
    }
    else
    {
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsg;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTips;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardTopicLabelCtrl;
    if (localObject1 != null) {
      ((TopicLabelCtrl)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getCommonTagInfos() != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getCommonTagInfos();
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl.a(new InterestTag[] { localObject1 });
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getCommonTagInfos());
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369774)).setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131699039, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.commonLabels.size()) }));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "coninterest_exp", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag = new InterestTag[LabelDisplayCtrl.a.length];
    i = k;
    while (i < LabelDisplayCtrl.a.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i] = new InterestTag(LabelDisplayCtrl.a[i]);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag);
    if (this.jdField_a_of_type_AndroidViewView.findViewById(2131369774).getVisibility() != 0) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370052).setVisibility(8);
    }
    if ((this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370060).setVisibility(8);
    }
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370060).setVisibility(8);
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    int i = ((Resources)localObject1).getColor(2131167056);
    int j = ((Resources)localObject1).getColor(2131167144);
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType == 0)
    {
      if (paramArrayOfByte != null)
      {
        Object localObject2 = null;
        try
        {
          localObject1 = RichStatus.parseStatus(paramArrayOfByte);
        }
        catch (RuntimeException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("RichStatus parseStatus error: ");
          ((StringBuilder)localObject1).append(paramArrayOfByte);
          QLog.e("NearbyProfileFragment", 1, ((StringBuilder)localObject1).toString());
          localObject1 = null;
        }
        paramArrayOfByte = (byte[])localObject2;
        if (localObject1 != null) {
          paramArrayOfByte = ((RichStatus)localObject1).toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165327));
        }
        localObject2 = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          localObject2 = new SpannableString("");
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((RichStatus)localObject1).actionText)))
        {
          localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
          ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mStatusManager != null) {
            paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mStatusManager.a(((RichStatus)localObject1).actionId, 200);
          } else {
            paramArrayOfByte = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130849881);
          }
          paramArrayOfByte = new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
          j = (int)(this.f.getTextSize() * 1.1F + 0.5F);
          paramArrayOfByte.setBounds(0, 0, j, j);
          paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
          paramArrayOfByte.setOffset(-0.1F);
          ((SpannableStringBuilder)localObject2).setSpan(paramArrayOfByte, 0, 3, 17);
          this.f.setText((CharSequence)localObject2);
          this.f.setTextColor(i);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
          return;
        }
        paramArrayOfByte = StringUtil.d(((SpannableString)localObject2).toString());
        if (!TextUtils.isEmpty(paramArrayOfByte))
        {
          this.f.setText(paramArrayOfByte.trim());
          this.f.setTextColor(i);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
        {
          this.f.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694490));
          this.f.setTextColor(j);
          return;
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    else {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        if (!TextUtils.isEmpty(paramArrayOfByte))
        {
          this.f.setText(paramArrayOfByte.trim());
          this.f.setTextColor(i);
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          return;
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setXuanyan wx error, e=");
        ((StringBuilder)localObject1).append(paramArrayOfByte.toString());
        QLog.i("NearbyProfileFragment", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  protected int a()
  {
    return 2131561220;
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void a()
  {
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentUin())));
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_nick.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_stranger_nick.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_gender.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_god_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_age.set(1);
    localReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localReqBody.uint32_req_likeinfo.set(1);
    localReqBody.uint32_req_pansocialinfo.set(1);
    localReqBody.uint32_req_giftinfo.set(1);
    localReqBody.uint32_req_configinfo.set(1);
    localReqBody.uint32_req_visitor.set(3);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1643);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.f());
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new NearbyProfileFragment.7(this), ((oidb_sso.OIDBSSOPkg)localObject).toByteArray(), "OidbSvc.0x66b");
  }
  
  public void a(long paramLong)
  {
    ((INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a().put(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), Integer.valueOf(1));
    Object localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime.split(" ")[0];
    } else {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance;
    }
    boolean bool = NearbyProfileCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from);
    Object localObject3 = "1";
    if (bool) {
      localObject2 = "1";
    } else {
      localObject2 = "0";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&tinyid=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("&distance=");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("&_from=");
    localStringBuilder.append((String)localObject2);
    Object localObject1 = localStringBuilder.toString();
    ((Intent)localObject4).putExtra("url", (String)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("openFaceScorePage, url = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("NearbyProfileFragment", 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject4);
    int i = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mUin;
    if (2 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode) {
      localObject1 = localObject3;
    } else {
      localObject1 = "2";
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(i);
    ((StringBuilder)localObject3).append("");
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1);
    ((StringBuilder)localObject4).append("");
    FaceScoreUtils.a("clk_data", (String)localObject2, new String[] { localObject1, localObject3, ((StringBuilder)localObject4).toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording });
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.jdField_e_of_type_Boolean) {
      b();
    }
  }
  
  public void a(FaceScoreConfig paramFaceScoreConfig)
  {
    if (paramFaceScoreConfig == null) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      boolean bool = ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).equals("1000");
      if ((paramFaceScoreConfig.a) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.entryAbility != 0))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 1)
        {
          Object localObject1;
          int i;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording))
          {
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording);
            if (bool) {
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWordingColor == 0)
              {
                this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#000000"));
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("#");
                ((StringBuilder)localObject1).append(Integer.toHexString(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWordingColor));
                localObject1 = ((StringBuilder)localObject1).toString();
                this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor((String)localObject1));
              }
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130841376);
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWording)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2))
            {
              this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWording);
              if (bool) {
                if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWordingColor == 0)
                {
                  this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#000000"));
                }
                else
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("#");
                  ((StringBuilder)localObject1).append(Integer.toHexString(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWordingColor));
                  localObject1 = ((StringBuilder)localObject1).toString();
                  this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor((String)localObject1));
                }
              }
              this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            else
            {
              this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            i = 1;
          }
          else
          {
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            i = 0;
          }
          if (i != 0)
          {
            i = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
            String str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mUin;
            if (2 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode) {
              localObject1 = "1";
            } else {
              localObject1 = "2";
            }
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append("");
            localObject2 = ((StringBuilder)localObject2).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1);
            localStringBuilder.append("");
            FaceScoreUtils.a("exp_data", str, new String[] { localObject1, localObject2, localStringBuilder.toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording });
          }
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (2 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode) {
        this.jdField_a_of_type_JavaLangString = paramFaceScoreConfig.jdField_b_of_type_JavaLangString;
      } else if (3 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode) {
        this.jdField_a_of_type_JavaLangString = paramFaceScoreConfig.c;
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.entryAbility != 1))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        paramFaceScoreConfig = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        paramFaceScoreConfig.rightMargin = 15;
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramFaceScoreConfig);
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void a(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel = paramNearbyProfileDisplayPanel;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject = new nearby.Cmd0x1RspBody();
    try
    {
      ((nearby.Cmd0x1RspBody)localObject).mergeFrom(paramArrayOfByte);
      this.jdField_a_of_type_ArrayOfByte = ((nearby.Cmd0x1RspBody)localObject).bytes_chat_sig.get().toByteArray();
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getMsgCache().h(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ArrayOfByte);
      int i = ((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_gift.get();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.jdField_d_of_type_Boolean = bool;
      if (((nearby.Cmd0x1RspBody)localObject).bytes_mask_gift_reason.has()) {
        this.jdField_b_of_type_JavaLangString = ((nearby.Cmd0x1RspBody)localObject).bytes_mask_gift_reason.get().toStringUtf8();
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cmd0x1RspBody error !:");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.w("NearbyProfileFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public int b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getBaseActivity() instanceof NearbyPeopleProfileActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = ((NearbyPeopleProfileActivity)getBaseActivity());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetRelativeLayout)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mTinyId <= 0L)
      {
        paramView = (NearbyFaceScoreManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(QQManagerFactory.FACE_SCORE_MANAGER);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mUin);
        paramView.a(l, new NearbyProfileFragment.8(this, l));
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mTinyId);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getIntent();
    boolean bool = false;
    if (paramBundle.getIntExtra("frome_where", 0) == 35) {
      bool = true;
    }
    this.jdField_c_of_type_Boolean = bool;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131297470);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131297469);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = a();
    boolean bool = false;
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(i, paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363784);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369891));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379982));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369808));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378542));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378561));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369819));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369787));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378518));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368641));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363943));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363944));
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView.findViewById(2131380357);
      paramViewGroup = (LinearLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
      paramViewGroup.height = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 90.0F);
      paramLayoutInflater.setLayoutParams(paramViewGroup);
    }
    this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366433));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366431);
    this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366432));
    paramLayoutInflater = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369806);
    paramViewGroup = this.jdField_a_of_type_AndroidViewView.findViewById(2131369807);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl = new LabelDisplayCtrl();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramLayoutInflater, paramViewGroup);
    paramLayoutInflater = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369773);
    paramViewGroup = this.jdField_a_of_type_AndroidViewView.findViewById(2131369774);
    this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl = new LabelDisplayCtrl();
    this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramLayoutInflater, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378619));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369889));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380964));
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_e_of_type_AndroidWidgetRelativeLayout).b(21).d(30).a();
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380964));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardTopicLabelCtrl = new TopicLabelCtrl();
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardTopicLabelCtrl;
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    paramBundle = this.jdField_a_of_type_AndroidViewView;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
      bool = true;
    }
    paramLayoutInflater.a(paramViewGroup, paramBundle, bool);
    this.jdField_e_of_type_Boolean = true;
    b();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramView.getTag() instanceof NearbyProfileFragment.ViewHolder))
    {
      paramView = ((NearbyProfileFragment.ViewHolder)paramView.getTag()).a;
      if (paramView.type == 101)
      {
        paramAdapterView = (NearbyVideoChatManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
        if (paramAdapterView != null)
        {
          paramAdapterView = paramAdapterView.a();
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.isVideoChatting()) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getAVNotifyCenter().k())) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          if (paramInt != 0)
          {
            paramAdapterView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230);
            paramAdapterView.setMessage(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131695889));
            paramAdapterView.setNegativeButton(HardCodeUtil.a(2131707325), new NearbyProfileFragment.6(this));
            paramAdapterView.show();
            return;
          }
          NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, null, paramAdapterView, null, 0);
        }
      }
      else if ((paramView.type == 102) && (!TextUtils.isEmpty(paramView.url)))
      {
        paramAdapterView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        paramAdapterView.putExtra("url", paramView.url);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramAdapterView);
      }
      else if (paramView.status == 1)
      {
        paramAdapterView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramView.url);
        if (paramAdapterView != null) {
          paramAdapterView.a();
        }
      }
      else
      {
        paramAdapterView = new StringBuilder("https://now.qq.com/qq/interact/index.html?");
        localObject1 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
        if (localObject1 != null)
        {
          localObject1 = ((SosoLbsInfo)localObject1).mLocation;
          if (localObject1 != null)
          {
            paramAdapterView.append("longitude=");
            paramAdapterView.append(((SosoLocation)localObject1).mLon02);
            paramAdapterView.append("&latitude=");
            paramAdapterView.append(((SosoLocation)localObject1).mLat02);
            paramAdapterView.append("&_wv=536870914");
            paramAdapterView.append("&tab=");
            paramAdapterView.append(paramView.type);
            paramAdapterView.append("&_proxy=1");
          }
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramAdapterView.toString());
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        }
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
        paramAdapterView = "1";
      } else {
        paramAdapterView = "2";
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramView.type);
      localObject2 = ((StringBuilder)localObject2).toString();
      if (paramView.status == 1) {
        paramView = "1";
      } else {
        paramView = "2";
      }
      ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "recent_play", "module_click", 0, 0, paramAdapterView, (String)localObject2, paramView, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment
 * JD-Core Version:    0.7.0.1
 */