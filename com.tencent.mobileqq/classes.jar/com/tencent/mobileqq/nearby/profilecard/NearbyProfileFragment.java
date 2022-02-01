package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.NearbyPeopleCard.HiWanItem;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearby.FaceScoreConfig;
import com.tencent.mobileqq.nearby.FaceScoreUtils;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyFaceScoreManager;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
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
import com.tencent.mobileqq.theme.ThemeUtil;
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
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.CustomImgView;
import cooperation.troop.NearbyVideoChatProxyActivity;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0xac5.cmd0xac5.MasterState;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyProfileFragment
  extends ReportV4Fragment
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
  
  private void a(List<StrangerInfo> paramList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("updateVistorHeader visitor count:");
      if (paramList != null) {
        break label103;
      }
    }
    label103:
    for (int i = 0;; i = paramList.size())
    {
      QLog.d("Q.nearby.visitor", 2, i);
      localObject1 = NearbyMineHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new Object[] { Integer.valueOf(4105), "100510.100523" });
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
      if ((paramList != null) && (paramList.size() != 0)) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    if (paramList.size() > 3) {}
    int j;
    for (i = 3;; i = paramList.size())
    {
      localObject1 = new ArrayList(3);
      j = 0;
      while (j < i)
      {
        localObject2 = (StrangerInfo)paramList.get(j);
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
        j += 1;
      }
    }
    int k = ((List)localObject1).size();
    paramList = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (((RelativeLayout.LayoutParams)localObject2).width != this.jdField_a_of_type_Int * k + (k - 1) * this.jdField_b_of_type_Int) {
      ((RelativeLayout.LayoutParams)localObject2).width = (this.jdField_a_of_type_Int * k + (k - 1) * this.jdField_b_of_type_Int);
    }
    for (i = 1;; i = 0)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c()) && (((RelativeLayout.LayoutParams)localObject2).rightMargin != AIOUtils.a(35.0F, paramList)))
      {
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(35.0F, paramList);
        j = 1;
      }
      for (;;)
      {
        if (j != 0) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i = 0;
        while (i < k)
        {
          localObject2 = new LinearLayout.LayoutParams(AIOUtils.a(30.0F, paramList), AIOUtils.a(30.0F, paramList));
          ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(5.0F, paramList);
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
        j = i;
        if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c())
        {
          j = i;
          if (((RelativeLayout.LayoutParams)localObject2).rightMargin != AIOUtils.a(45.0F, paramList))
          {
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(45.0F, paramList);
            j = 1;
          }
        }
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
      return;
    }
    int i;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get() != null) && (((cmd0xac5.NearbyNowData)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get() != null))
    {
      i = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get()).uint32_state.get();
      localObject = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get()).bytes_jump_url.get().toStringUtf8();
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if (i == 0)
      {
        i = 1;
        this.g.setText(HardCodeUtil.a(2131707280));
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 3) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
      for (;;)
      {
        if (!NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app)) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(new NearbyProfileFragment.1(this, (String)localObject, i));
        if (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0) {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131370393).setVisibility(8);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
        b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
        i = ((Resources)localObject).getColor(2131167033);
        int j = ((Resources)localObject).getColor(2131167119);
        localObject = new StringBuilder();
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company = StringUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company))
        {
          ((StringBuilder)localObject).append(new QQText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company, 1, 16));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_company", 0, 0, "", "", "", "");
          ((StringBuilder)localObject).append("  ");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job < NearbyProfileUtil.d.length))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_work", 0, 0, "", "", "", "");
          ((StringBuilder)localObject).append(NearbyProfileUtil.d[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
          ((StringBuilder)localObject).append("  ");
        }
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college = StringUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
        {
          ((StringBuilder)localObject).append(new QQText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, 1, 16));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_school", 0, 0, "", "", "", "");
        }
        if (((StringBuilder)localObject).length() > 0)
        {
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i);
          label590:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig == null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig = FaceScoreUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface());
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig.a()) {
            break label1335;
          }
          ((NearbyFaceScoreManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(QQManagerFactory.FACE_SCORE_MANAGER)).a(new NearbyProfileFragment.2(this));
          label648:
          a();
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2) {
            break label1358;
          }
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType != 1) {
            break label1346;
          }
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          label700:
          if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
            break label1505;
          }
          this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsgForTribar;
        }
        for (this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTipsForTribar;; this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTips)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardTopicLabelCtrl != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardTopicLabelCtrl.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getCommonTagInfos() != null)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getCommonTagInfos();
            this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl.a(new InterestTag[] { localObject });
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getCommonTagInfos());
            ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370096)).setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131698960, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.commonLabels.size()) }));
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "coninterest_exp", 0, 0, "", "", "", "");
          }
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag = new InterestTag[LabelDisplayCtrl.a.length];
          i = 0;
          while (i < LabelDisplayCtrl.a.length)
          {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i] = new InterestTag(LabelDisplayCtrl.a[i]);
            i += 1;
          }
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view").a(new String[] { "", "" + (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1), "1" }).a();
          break;
          if (i == 1)
          {
            i = 3;
            this.g.setText(HardCodeUtil.a(2131707372));
            new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view").a(new String[] { "", "" + (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1), "3" }).a();
            break;
          }
          if (i != 2) {
            break label1665;
          }
          i = 2;
          this.g.setText(HardCodeUtil.a(2131707297));
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 3)
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            break;
          }
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view").a(new String[] { "", "" + (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1), "2" }).a();
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e != 2) {
            break label590;
          }
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694525));
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(j);
          break label590;
          label1335:
          a(this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig);
          break label648;
          label1346:
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          break label700;
          label1358:
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new NearbyProfileFragment.3(this));
          localObject = TroopGiftAioPanelData.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 1);
          if (localObject == null)
          {
            localObject = null;
            label1397:
            if (localObject == null) {
              break label1472;
            }
            this.jdField_d_of_type_AndroidWidgetTextView.setText(((GiftConfigManager.TextEntryItem)localObject).jdField_a_of_type_JavaLangString);
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new NearbyProfileFragment.5(this, (GiftConfigManager.TextEntryItem)localObject));
            ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "my_point", 0, 0, "", "", "", "");
            break;
            localObject = ((TroopGiftAioPanelData)localObject).a;
            break label1397;
            label1472:
            ((TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(1402, new NearbyProfileFragment.4(this));
          }
          label1505:
          this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsg;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag);
        if (this.jdField_a_of_type_AndroidViewView.findViewById(2131370096).getVisibility() != 0) {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131370390).setVisibility(8);
        }
        if ((this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131370400).setVisibility(8);
        }
        if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) || (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidViewView.findViewById(2131370400).setVisibility(8);
        return;
        label1665:
        i = -1;
      }
      localObject = "";
      i = 0;
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    int i = ((Resources)localObject1).getColor(2131167033);
    int j = ((Resources)localObject1).getColor(2131167119);
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType == 0)
    {
      if (paramArrayOfByte != null) {}
      try
      {
        localObject1 = RichStatus.parseStatus(paramArrayOfByte);
        paramArrayOfByte = (byte[])localObject2;
        if (localObject1 != null) {
          paramArrayOfByte = ((RichStatus)localObject1).toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165357));
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
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
          {
            paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(((RichStatus)localObject1).actionId, 200);
            paramArrayOfByte = new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
            j = (int)(this.f.getTextSize() * 1.1F + 0.5F);
            paramArrayOfByte.setBounds(0, 0, j, j);
            paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
            paramArrayOfByte.setOffset(-0.1F);
            ((SpannableStringBuilder)localObject2).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
            this.f.setText((CharSequence)localObject2);
            this.f.setTextColor(i);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
            return;
          }
        }
      }
      catch (RuntimeException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          QLog.e("NearbyProfileFragment", 1, "RichStatus parseStatus error: " + paramArrayOfByte);
          localObject1 = null;
          continue;
          paramArrayOfByte = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130849983);
        }
        paramArrayOfByte = StringUtil.d(((SpannableString)localObject2).toString());
        if (!TextUtils.isEmpty(paramArrayOfByte))
        {
          this.f.setText(paramArrayOfByte.trim());
          this.f.setTextColor(i);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2)
        {
          this.f.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694525));
          this.f.setTextColor(j);
          return;
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
      }
    }
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
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      QLog.i("NearbyProfileFragment", 1, "setXuanyan wx error, e=" + paramArrayOfByte.toString());
      return;
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  protected int a()
  {
    return 2131561381;
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
    ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), Integer.valueOf(1));
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
    Object localObject;
    label107:
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime.split(" ")[0];
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
        break label358;
      }
      localObject = "1";
      str = this.jdField_a_of_type_JavaLangString + "&tinyid=" + paramLong + "&distance=" + str + "&_from=" + (String)localObject;
      localIntent.putExtra("url", str);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProfileFragment", 2, "openFaceScorePage, url = " + str);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
      i = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaLangString;
      if (2 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e) {
        break label366;
      }
    }
    label358:
    label366:
    for (String str = "1";; str = "2")
    {
      FaceScoreUtils.a("clk_data", (String)localObject, new String[] { str, i + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1 + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording });
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance;
      break;
      localObject = "0";
      break label107;
    }
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
    label127:
    int i;
    label210:
    label218:
    label228:
    String str1;
    if (!this.jdField_c_of_type_Boolean)
    {
      boolean bool = ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).equals("1000");
      if ((!paramFaceScoreConfig.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.entryAbility == 0)) {
        break label594;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e != 1)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording)) {
          break label572;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording);
        if (bool)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWordingColor != 0) {
            break label468;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#000000"));
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130841495);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWording)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2)) {
          break label560;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWording);
        if (bool)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWordingColor != 0) {
            break label514;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#000000"));
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        i = 1;
        if (i != 0)
        {
          i = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
          String str2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaLangString;
          if (2 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e) {
            break label586;
          }
          str1 = "1";
          label284:
          FaceScoreUtils.a("exp_data", str2, new String[] { str1, i + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1 + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording });
        }
      }
      label365:
      if (2 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e) {
        break label606;
      }
      this.jdField_a_of_type_JavaLangString = paramFaceScoreConfig.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.entryAbility != 1)) {
        break label628;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break;
      }
      paramFaceScoreConfig = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      paramFaceScoreConfig.rightMargin = 15;
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramFaceScoreConfig);
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
      label468:
      str1 = "#" + Integer.toHexString(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWordingColor);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(str1));
      break label127;
      label514:
      str1 = "#" + Integer.toHexString(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWordingColor);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(str1));
      break label210;
      label560:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label218;
      label572:
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      i = 0;
      break label228;
      label586:
      str1 = "2";
      break label284;
      label594:
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break label365;
      label606:
      if (3 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e) {
        this.jdField_a_of_type_JavaLangString = paramFaceScoreConfig.c;
      }
    }
    label628:
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  public void a(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel = paramNearbyProfileDisplayPanel;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    if (paramArrayOfByte == null) {
      return;
    }
    nearby.Cmd0x1RspBody localCmd0x1RspBody = new nearby.Cmd0x1RspBody();
    for (;;)
    {
      try
      {
        localCmd0x1RspBody.mergeFrom(paramArrayOfByte);
        this.jdField_a_of_type_ArrayOfByte = localCmd0x1RspBody.bytes_chat_sig.get().toByteArray();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getMsgCache().h(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ArrayOfByte);
        if (localCmd0x1RspBody.uint32_if_mask_gift.get() != 1) {
          break label135;
        }
        this.jdField_d_of_type_Boolean = bool;
        if (!localCmd0x1RspBody.bytes_mask_gift_reason.has()) {
          break;
        }
        this.jdField_b_of_type_JavaLangString = localCmd0x1RspBody.bytes_mask_gift_reason.get().toStringUtf8();
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("NearbyProfileFragment", 2, "Cmd0x1RspBody error !:" + paramArrayOfByte);
      return;
      label135:
      bool = false;
    }
  }
  
  public int b()
  {
    int j = 1;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 1;
      if (!this.jdField_b_of_type_Boolean) {
        break label32;
      }
    }
    for (;;)
    {
      return i << 7 | j << 1;
      i = 0;
      break;
      label32:
      j = 0;
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getActivity() instanceof NearbyPeopleProfileActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = ((NearbyPeopleProfileActivity)getActivity());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetRelativeLayout)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Long > 0L) {
        break label72;
      }
      NearbyFaceScoreManager localNearbyFaceScoreManager = (NearbyFaceScoreManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(QQManagerFactory.FACE_SCORE_MANAGER);
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaLangString);
      localNearbyFaceScoreManager.a(l, new NearbyProfileFragment.8(this, l));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label72:
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Long);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) == 35) {
      bool = true;
    }
    this.jdField_c_of_type_Boolean = bool;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131297481);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131297480);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363856);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370223));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380714));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370137));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379179));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379198));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370148));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370110));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379153));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368915));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364016));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364017));
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView.findViewById(2131381100);
      paramViewGroup = (LinearLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
      paramViewGroup.height = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 90.0F);
      paramLayoutInflater.setLayoutParams(paramViewGroup);
    }
    this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366556));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366554);
    this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366555));
    paramLayoutInflater = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370135);
    paramViewGroup = this.jdField_a_of_type_AndroidViewView.findViewById(2131370136);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl = new LabelDisplayCtrl();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramLayoutInflater, paramViewGroup);
    paramLayoutInflater = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370095);
    paramViewGroup = this.jdField_a_of_type_AndroidViewView.findViewById(2131370096);
    this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl = new LabelDisplayCtrl();
    this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardLabelDisplayCtrl.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramLayoutInflater, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379258));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370221));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381732));
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_e_of_type_AndroidWidgetRelativeLayout).b(21).d(30).a();
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381732));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardTopicLabelCtrl = new TopicLabelCtrl();
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardTopicLabelCtrl;
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    paramBundle = this.jdField_a_of_type_AndroidViewView;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2) {}
    for (boolean bool = true;; bool = false)
    {
      paramLayoutInflater.a(paramViewGroup, paramBundle, bool);
      this.jdField_e_of_type_Boolean = true;
      b();
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1;
    if ((paramView.getTag() instanceof NearbyProfileFragment.ViewHolder))
    {
      localObject2 = ((NearbyProfileFragment.ViewHolder)paramView.getTag()).a;
      if (((NearbyPeopleCard.HiWanItem)localObject2).type != 101) {
        break label288;
      }
      localObject1 = (NearbyVideoChatManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
      if (localObject1 == null) {
        break label189;
      }
      localObject1 = ((NearbyVideoChatManager)localObject1).a();
      if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.isVideoChatting()) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getAVNotifyCenter().k())) {
        break label164;
      }
    }
    label164:
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230);
      ((QQCustomDialog)localObject1).setMessage(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131695877));
      ((QQCustomDialog)localObject1).setNegativeButton(HardCodeUtil.a(2131707300), new NearbyProfileFragment.6(this));
      ((QQCustomDialog)localObject1).show();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, null, (String)localObject1, null, 0);
    label189:
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    label214:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2)
    {
      localObject1 = "1";
      str = "" + ((NearbyPeopleCard.HiWanItem)localObject2).type;
      if (((NearbyPeopleCard.HiWanItem)localObject2).status != 1) {
        break label550;
      }
    }
    label288:
    label550:
    for (Object localObject2 = "1";; localObject2 = "2")
    {
      ReportController.b((AppRuntime)localObject3, "dc00899", "grp_lbs", "", "recent_play", "module_click", 0, 0, (String)localObject1, str, (String)localObject2, "");
      break;
      if ((((NearbyPeopleCard.HiWanItem)localObject2).type == 102) && (!TextUtils.isEmpty(((NearbyPeopleCard.HiWanItem)localObject2).url)))
      {
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", ((NearbyPeopleCard.HiWanItem)localObject2).url);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        break label189;
      }
      if (((NearbyPeopleCard.HiWanItem)localObject2).status == 1)
      {
        localObject1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ((NearbyPeopleCard.HiWanItem)localObject2).url);
        if (localObject1 == null) {
          break label189;
        }
        ((JumpAction)localObject1).a();
        break label189;
      }
      localObject1 = new StringBuilder("https://now.qq.com/qq/interact/index.html?");
      localObject3 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
      if (localObject3 == null) {
        break label189;
      }
      localObject3 = ((SosoLbsInfo)localObject3).mLocation;
      if (localObject3 != null) {
        ((StringBuilder)localObject1).append("longitude=").append(((SosoLocation)localObject3).mLon02).append("&latitude=").append(((SosoLocation)localObject3).mLat02).append("&_wv=536870914").append("&tab=").append(((NearbyPeopleCard.HiWanItem)localObject2).type).append("&_proxy=1");
      }
      localObject3 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      ((Intent)localObject3).putExtra("url", ((StringBuilder)localObject1).toString());
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject3);
      break label189;
      localObject1 = "2";
      break label214;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment
 * JD-Core Version:    0.7.0.1
 */