package com.tencent.mobileqq.nearby.profilecard;

import aciy;
import ajjy;
import alzo;
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
import ascp;
import ascq;
import ascz;
import asdf;
import asfc;
import asfj;
import asjg;
import asse;
import aste;
import asxu;
import asxv;
import asxw;
import asxx;
import asxy;
import asxz;
import asya;
import asyb;
import asyc;
import asyd;
import asyl;
import atcm;
import avev;
import awao;
import awqx;
import awrb;
import axkd;
import azgp;
import azjq;
import azvk;
import azvq;
import azvv;
import azwp;
import azyf;
import azyk;
import azzz;
import babr;
import bacn;
import bade;
import bafb;
import baip;
import bbkk;
import bbmy;
import bboi;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.NearbyPeopleCard.HiWanItem;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import cooperation.troop.NearbyVideoChatProxyActivity;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mmj;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0xac5.cmd0xac5.MasterState;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import wms;
import wnc;

public class NearbyProfileFragment
  extends Fragment
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ascp a;
  asse jdField_a_of_type_Asse;
  aste jdField_a_of_type_Aste;
  private asyl jdField_a_of_type_Asyl;
  protected URLImageView a;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  public NearbyPeopleProfileActivity a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  protected String a;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  asjg[] jdField_a_of_type_ArrayOfAsjg;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  asse jdField_b_of_type_Asse;
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
      localObject1 = atcm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new Object[] { Integer.valueOf(4105), "100510.100523" });
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
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
      if ((!this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a()) && (((RelativeLayout.LayoutParams)localObject2).rightMargin != aciy.a(35.0F, paramList)))
      {
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = aciy.a(35.0F, paramList);
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
          localObject2 = new LinearLayout.LayoutParams(aciy.a(30.0F, paramList), aciy.a(30.0F, paramList));
          ((LinearLayout.LayoutParams)localObject2).rightMargin = aciy.a(5.0F, paramList);
          StrangerInfo localStrangerInfo = (StrangerInfo)((List)localObject1).get(i);
          if (localStrangerInfo != null)
          {
            CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
            Drawable localDrawable = localCustomImgView.a();
            if ((localDrawable != null) && ((localDrawable instanceof azvk))) {
              ((azvk)localDrawable).a();
            }
            localCustomImgView.setImageDrawable(azwp.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 202, String.valueOf(localStrangerInfo.tinyId), true));
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject2);
          }
          i += 1;
        }
        j = i;
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a())
        {
          j = i;
          if (((RelativeLayout.LayoutParams)localObject2).rightMargin != aciy.a(45.0F, paramList))
          {
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = aciy.a(45.0F, paramList);
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
  
  private byte[] a()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_Int != 51) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().m(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.length != 0) {}
    }
    else
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_Int == 51) {
        localObject2 = this.jdField_a_of_type_ArrayOfByte;
      }
    }
    if ((localObject2 == null) && (QLog.isColorLevel())) {
      QLog.e("Q.nearby_people_card.", 2, "nearbySig is null ");
    }
    return localObject2;
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
        this.g.setText(ajjy.a(2131641481));
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 3) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
      for (;;)
      {
        if (!alzo.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app)) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(new asxu(this, (String)localObject, i));
        if (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0) {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131303544).setVisibility(8);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
        b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
        i = ((Resources)localObject).getColor(2131101260);
        int j = ((Resources)localObject).getColor(2131101338);
        localObject = new StringBuilder();
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company = baip.d(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company))
        {
          ((StringBuilder)localObject).append(new axkd(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company, 1, 16));
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_company", 0, 0, "", "", "", "");
          ((StringBuilder)localObject).append("  ");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job < azyf.d.length))
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_work", 0, 0, "", "", "", "");
          ((StringBuilder)localObject).append(azyf.d[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
          ((StringBuilder)localObject).append("  ");
        }
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college = baip.d(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
        {
          ((StringBuilder)localObject).append(new axkd(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, 1, 16));
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_school", 0, 0, "", "", "", "");
        }
        if (((StringBuilder)localObject).length() > 0)
        {
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i);
          label590:
          if (this.jdField_a_of_type_Ascp == null) {
            this.jdField_a_of_type_Ascp = ascq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface());
          }
          if (!this.jdField_a_of_type_Ascp.a()) {
            break label1335;
          }
          ((asdf)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(204)).a(new asxv(this));
          label648:
          a();
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2) {
            break label1427;
          }
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType != 1) {
            break label1346;
          }
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
            break label1572;
          }
          this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsgForTribar;
        }
        for (this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTipsForTribar;; this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTips)
        {
          if (this.jdField_a_of_type_Asyl != null) {
            this.jdField_a_of_type_Asyl.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getCommonTagInfos() != null)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getCommonTagInfos();
            this.jdField_b_of_type_Asse.a(new asjg[] { localObject });
            this.jdField_a_of_type_Asse.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getCommonTagInfos());
            ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303268)).setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131633439, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.commonLabels.size()) }));
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "coninterest_exp", 0, 0, "", "", "", "");
          }
          this.jdField_a_of_type_ArrayOfAsjg = new asjg[asse.a.length];
          i = 0;
          while (i < asse.a.length)
          {
            this.jdField_a_of_type_ArrayOfAsjg[i] = new asjg(asse.a[i]);
            i += 1;
          }
          new awrb(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view").a(new String[] { "", "" + (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1), "1" }).a();
          break;
          if (i == 1)
          {
            i = 3;
            this.g.setText(ajjy.a(2131641573));
            new awrb(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view").a(new String[] { "", "" + (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1), "3" }).a();
            break;
          }
          if (i != 2) {
            break label1732;
          }
          i = 2;
          this.g.setText(ajjy.a(2131641498));
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 3)
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            break;
          }
          new awrb(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view").a(new String[] { "", "" + (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1), "2" }).a();
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e != 2) {
            break label590;
          }
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131629036));
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(j);
          break label590;
          label1335:
          a(this.jdField_a_of_type_Ascp);
          break label648;
          label1346:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
            this.jdField_d_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641570));
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new asxw(this));
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
              this.jdField_d_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641505));
            } else {
              this.jdField_d_of_type_AndroidWidgetTextView.setText("送TA礼物");
            }
          }
          label1427:
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new asxx(this));
          localObject = wnc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 1);
          if (localObject == null)
          {
            localObject = null;
            label1465:
            if (localObject == null) {
              break label1540;
            }
            this.jdField_d_of_type_AndroidWidgetTextView.setText(((wms)localObject).jdField_a_of_type_JavaLangString);
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new asxz(this, (wms)localObject));
            awqx.b(null, "dc00899", "grp_lbs", "", "rank_data", "my_point", 0, 0, "", "", "", "");
            break;
            localObject = ((wnc)localObject).a;
            break label1465;
            label1540:
            ((azjq)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(113)).a(1402, new asxy(this));
          }
          label1572:
          this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsg;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(this.jdField_a_of_type_ArrayOfAsjg);
        this.jdField_a_of_type_Asse.a(this.jdField_a_of_type_ArrayOfAsjg);
        if (this.jdField_a_of_type_AndroidViewView.findViewById(2131303268).getVisibility() != 0) {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131303541).setVisibility(8);
        }
        if ((this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131303552).setVisibility(8);
        }
        if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) || (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidViewView.findViewById(2131303552).setVisibility(8);
        return;
        label1732:
        i = -1;
      }
      localObject = "";
      i = 0;
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    int i = ((Resources)localObject2).getColor(2131101260);
    int j = ((Resources)localObject2).getColor(2131101338);
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType == 0)
    {
      if (paramArrayOfByte != null)
      {
        localObject2 = RichStatus.parseStatus(paramArrayOfByte);
        paramArrayOfByte = (byte[])localObject1;
        if (localObject2 != null) {
          paramArrayOfByte = ((RichStatus)localObject2).toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131099738));
        }
        localObject1 = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          localObject1 = new SpannableString("");
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if ((localObject2 == null) || (TextUtils.isEmpty(((RichStatus)localObject2).actionText))) {
          break label363;
        }
        localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject1).insert(0, "[S] ");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Avev == null) {
          break label346;
        }
      }
      label346:
      for (paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Avev.a(((RichStatus)localObject2).actionId, 200);; paramArrayOfByte = azvq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130848301))
      {
        paramArrayOfByte = new bboi(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
        j = (int)(this.f.getTextSize() * 1.1F + 0.5F);
        paramArrayOfByte.setBounds(0, 0, j, j);
        paramArrayOfByte = new bbkk(paramArrayOfByte, 0);
        paramArrayOfByte.a(-0.1F);
        ((SpannableStringBuilder)localObject1).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
        this.f.setText((CharSequence)localObject1);
        this.f.setTextColor(i);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
        return;
      }
      label363:
      paramArrayOfByte = baip.d(((SpannableString)localObject1).toString());
      if (!TextUtils.isEmpty(paramArrayOfByte))
      {
        this.f.setText(paramArrayOfByte.trim());
        this.f.setTextColor(i);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2)
      {
        this.f.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131629036));
        this.f.setTextColor(j);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
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
  
  private int c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      return 1001;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) != 0L) {
      return 0;
    }
    return azyk.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
  }
  
  protected int a()
  {
    return 2131495313;
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
    localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.c())));
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
    mmj.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new asyb(this), ((oidb_sso.OIDBSSOPkg)localObject).toByteArray(), "OidbSvc.0x66b");
  }
  
  public void a(long paramLong)
  {
    ((ascz)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(106)).d.put(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, Integer.valueOf(1));
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
    Object localObject;
    label103:
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime.split(" ")[0];
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
        break label354;
      }
      localObject = "1";
      str = this.jdField_a_of_type_JavaLangString + "&tinyid=" + paramLong + "&distance=" + str + "&_from=" + (String)localObject;
      localIntent.putExtra("url", str);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProfileFragment", 2, "openFaceScorePage, url = " + str);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
      i = ((Integer)asfc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_JavaLangString;
      if (2 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e) {
        break label362;
      }
    }
    label354:
    label362:
    for (String str = "1";; str = "2")
    {
      ascq.a("clk_data", (String)localObject, new String[] { str, i + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1 + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording });
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance;
      break;
      localObject = "0";
      break label103;
    }
  }
  
  public void a(ascp paramascp)
  {
    if (paramascp == null) {
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
      if ((!paramascp.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.entryAbility == 0)) {
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
        this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130840870);
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
          i = ((Integer)asfc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
          String str2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_JavaLangString;
          if (2 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e) {
            break label586;
          }
          str1 = "1";
          label284:
          ascq.a("exp_data", str2, new String[] { str1, i + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1 + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording });
        }
      }
      label365:
      if (2 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e) {
        break label606;
      }
      this.jdField_a_of_type_JavaLangString = paramascp.jdField_b_of_type_JavaLangString;
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
      paramascp = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      paramascp.rightMargin = 15;
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramascp);
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
        this.jdField_a_of_type_JavaLangString = paramascp.c;
      }
    }
    label628:
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  public void a(aste paramaste)
  {
    this.jdField_a_of_type_Aste = paramaste;
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.jdField_e_of_type_Boolean) {
      b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.g))
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_b_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
      }
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    NearbyPeopleProfileActivity.m += 1;
    String str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    Object localObject2 = azzz.a(a());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int i;
    if (Friends.isValidUin(str))
    {
      localObject2 = asfj.a(str);
      str = ((String)localObject1).toLowerCase();
      if (c() == 10002)
      {
        i = 6;
        if (!paramBoolean) {
          break label330;
        }
        localObject1 = "near.card.like";
        label139:
        localObject1 = String.format("https://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { localObject2, str, Integer.valueOf(i), localObject1, "" });
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("portraitOnly", true);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        i = azyf.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h);
        if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
          break label355;
        }
        i = 6;
      }
    }
    label330:
    label355:
    for (;;)
    {
      awqx.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_gift", 0, 0, "", "", "", "");
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052BA", "0X80052BA", i, 0, "", "", "", "");
      return;
      i = 1;
      break;
      localObject1 = "near.card.s";
      break label139;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131628028));
      return;
    }
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
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().i(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ArrayOfByte);
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
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Long <= 0L)
      {
        paramView = (asdf)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(204);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_JavaLangString);
        paramView.a(l, new asyc(this, l));
      }
    }
    else {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Long);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) == 35) {
      bool = true;
    }
    this.jdField_c_of_type_Boolean = bool;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131166182);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131166181);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297855);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303394));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312596));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303310));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311303));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311322));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303321));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303282));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311279));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302335));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298002));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298003));
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView.findViewById(2131312971);
      paramViewGroup = (LinearLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
      paramViewGroup.height = azvv.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 90.0F);
      paramLayoutInflater.setLayoutParams(paramViewGroup);
    }
    this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300263));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300261);
    this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300262));
    paramLayoutInflater = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303306);
    paramViewGroup = this.jdField_a_of_type_AndroidViewView.findViewById(2131303307);
    this.jdField_a_of_type_Asse = new asse();
    this.jdField_a_of_type_Asse.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramLayoutInflater, paramViewGroup);
    paramLayoutInflater = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303267);
    paramViewGroup = this.jdField_a_of_type_AndroidViewView.findViewById(2131303268);
    this.jdField_b_of_type_Asse = new asse();
    this.jdField_b_of_type_Asse.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramLayoutInflater, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311382));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303392));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131313459));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_e_of_type_AndroidWidgetRelativeLayout).a(21).c(30).a();
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131313459));
    this.jdField_a_of_type_Asyl = new asyl();
    paramLayoutInflater = this.jdField_a_of_type_Asyl;
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    paramBundle = this.jdField_a_of_type_AndroidViewView;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2) {}
    for (boolean bool = true;; bool = false)
    {
      paramLayoutInflater.a(paramViewGroup, paramBundle, bool);
      this.jdField_e_of_type_Boolean = true;
      b();
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramView.getTag() instanceof asyd))
    {
      paramView = ((asyd)paramView.getTag()).a;
      if (paramView.type != 101) {
        break label255;
      }
      paramAdapterView = (azgp)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(224);
      if (paramAdapterView == null) {
        break label164;
      }
      paramAdapterView = paramAdapterView.a();
      if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.c()) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().k())) {
        break label141;
      }
    }
    label141:
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      paramAdapterView = babr.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230);
      paramAdapterView.setMessage(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131630481));
      paramAdapterView.setNegativeButton(ajjy.a(2131641501), new asya(this));
      paramAdapterView.show();
      return;
    }
    NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, null, paramAdapterView, null, 0);
    label164:
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    label188:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2)
    {
      paramAdapterView = "1";
      str = "" + paramView.type;
      if (paramView.status != 1) {
        break label487;
      }
    }
    label487:
    for (paramView = "1";; paramView = "2")
    {
      awqx.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "recent_play", "module_click", 0, 0, paramAdapterView, str, paramView, "");
      return;
      label255:
      if ((paramView.type == 102) && (!TextUtils.isEmpty(paramView.url)))
      {
        paramAdapterView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        paramAdapterView.putExtra("url", paramView.url);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramAdapterView);
        break;
      }
      if (paramView.status == 1)
      {
        paramAdapterView = bade.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramView.url);
        if (paramAdapterView == null) {
          break;
        }
        paramAdapterView.c();
        break;
      }
      paramAdapterView = new StringBuilder("https://now.qq.com/qq/interact/index.html?");
      localObject = SosoInterface.b();
      if (localObject == null) {
        break;
      }
      localObject = ((SosoInterface.SosoLbsInfo)localObject).a;
      if (localObject != null) {
        paramAdapterView.append("longitude=").append(((SosoInterface.SosoLocation)localObject).b).append("&latitude=").append(((SosoInterface.SosoLocation)localObject).a).append("&_wv=536870914").append("&tab=").append(paramView.type).append("&_proxy=1");
      }
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramAdapterView.toString());
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
      break;
      paramAdapterView = "2";
      break label188;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment
 * JD-Core Version:    0.7.0.1
 */