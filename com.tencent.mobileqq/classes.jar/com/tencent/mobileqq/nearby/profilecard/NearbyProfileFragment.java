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
  private TextView A;
  private TextView B;
  private RelativeLayout C;
  private TextView D;
  private View E;
  private TextView F;
  private RedTouch G;
  private LinearLayout H;
  private boolean I;
  private String J;
  private boolean K;
  private TopicLabelCtrl L;
  public boolean a;
  public boolean b;
  NearbyPeopleProfileActivity c;
  NearbyProfileDisplayPanel d;
  protected NearbyPeopleCard e;
  protected FaceScoreConfig f;
  protected String g;
  InterestTag[] h;
  protected View i;
  protected URLImageView j;
  RelativeLayout k;
  TextView l;
  LabelDisplayCtrl m;
  LabelDisplayCtrl n;
  RelativeLayout o;
  RelativeLayout p;
  RelativeLayout q;
  boolean r = false;
  private int s;
  private int t;
  private byte[] u;
  private View v;
  private TextView w;
  private LinearLayout x;
  private TextView y;
  private TextView z;
  
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
  
  private boolean a(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() != 0);
  }
  
  private void b(List<StrangerInfo> paramList)
  {
    int i1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateVistorHeader visitor count:");
      if (paramList == null) {
        i1 = 0;
      } else {
        i1 = paramList.size();
      }
      ((StringBuilder)localObject1).append(i1);
      QLog.d("Q.nearby.visitor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).buildRedTouchAppInfo(this.c.app, new Object[] { Integer.valueOf(4105), "100510.100523" });
    this.G.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramList.size() > 3) {
        i1 = 3;
      } else {
        i1 = paramList.size();
      }
      localObject1 = new ArrayList(3);
      int i2 = 0;
      while (i2 < i1)
      {
        localObject2 = (StrangerInfo)paramList.get(i2);
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
        i2 += 1;
      }
      int i3 = ((List)localObject1).size();
      paramList = this.c.getResources();
      Object localObject2 = (RelativeLayout.LayoutParams)this.H.getLayoutParams();
      i1 = ((RelativeLayout.LayoutParams)localObject2).width;
      i2 = this.s;
      int i4 = i3 - 1;
      int i5 = this.t;
      if (i1 != i3 * i2 + i4 * i5)
      {
        ((RelativeLayout.LayoutParams)localObject2).width = (i2 * i3 + i4 * i5);
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
      if ((!this.G.h()) && (((RelativeLayout.LayoutParams)localObject2).rightMargin != AIOUtils.b(35.0F, paramList))) {}
      for (((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(35.0F, paramList);; ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(45.0F, paramList))
      {
        i2 = 1;
        break;
        i2 = i1;
        if (!this.G.h()) {
          break;
        }
        i2 = i1;
        if (((RelativeLayout.LayoutParams)localObject2).rightMargin == AIOUtils.b(45.0F, paramList)) {
          break;
        }
      }
      if (i2 != 0) {
        this.H.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      i1 = 0;
      while (i1 < i3)
      {
        localObject2 = new LinearLayout.LayoutParams(AIOUtils.b(30.0F, paramList), AIOUtils.b(30.0F, paramList));
        ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(5.0F, paramList);
        StrangerInfo localStrangerInfo = (StrangerInfo)((List)localObject1).get(i1);
        if (localStrangerInfo != null)
        {
          CustomImgView localCustomImgView = new CustomImgView(this.c);
          Drawable localDrawable = localCustomImgView.getDrawable();
          if ((localDrawable != null) && ((localDrawable instanceof AsynLoadDrawable))) {
            ((AsynLoadDrawable)localDrawable).cancel();
          }
          localCustomImgView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.c.app, 200, String.valueOf(localStrangerInfo.tinyId), true));
          this.H.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject2);
        }
        i1 += 1;
      }
      if (this.H.getVisibility() != 0) {
        this.H.setVisibility(0);
      }
      return;
    }
    this.H.setVisibility(8);
  }
  
  protected int a()
  {
    return 2131627574;
  }
  
  public void a(long paramLong)
  {
    ((INearbyCardManager)this.c.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).f().put(String.valueOf(this.e.tinyId), Integer.valueOf(1));
    Object localObject4 = new Intent(this.c, QQBrowserActivity.class);
    if (!TextUtils.isEmpty(this.e.aioDistanceAndTime)) {
      localObject1 = this.e.aioDistanceAndTime.split(" ")[0];
    } else {
      localObject1 = this.e.distance;
    }
    boolean bool = NearbyProfileCardUtils.a(this.c.from);
    Object localObject3 = "1";
    if (bool) {
      localObject2 = "1";
    } else {
      localObject2 = "0";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.g);
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
    this.c.startActivity((Intent)localObject4);
    int i1 = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.c.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    Object localObject2 = this.c.mUin;
    if (2 == this.c.mMode) {
      localObject1 = localObject3;
    } else {
      localObject1 = "2";
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(i1);
    ((StringBuilder)localObject3).append("");
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.e.gender + 1);
    ((StringBuilder)localObject4).append("");
    FaceScoreUtils.a("clk_data", (String)localObject2, new String[] { localObject1, localObject3, ((StringBuilder)localObject4).toString(), this.e.faceScoreWording });
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.e = paramNearbyPeopleCard;
    if (this.K) {
      e();
    }
  }
  
  public void a(FaceScoreConfig paramFaceScoreConfig)
  {
    if (paramFaceScoreConfig == null) {
      return;
    }
    if (!this.r)
    {
      boolean bool = ThemeUtil.getUserCurrentThemeId(this.c.app).equals("1000");
      if ((paramFaceScoreConfig.a) && (this.e.entryAbility != 0))
      {
        this.o.setVisibility(0);
        if (this.c.mMode != 1)
        {
          Object localObject1;
          int i1;
          if (!TextUtils.isEmpty(this.e.faceScoreWording))
          {
            this.o.setVisibility(0);
            this.w.setText(this.e.faceScoreWording);
            if (bool) {
              if (this.e.faceScoreWordingColor == 0)
              {
                this.w.setTextColor(Color.parseColor("#000000"));
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("#");
                ((StringBuilder)localObject1).append(Integer.toHexString(this.e.faceScoreWordingColor));
                localObject1 = ((StringBuilder)localObject1).toString();
                this.w.setTextColor(Color.parseColor((String)localObject1));
              }
            }
            this.w.setVisibility(0);
            this.j.setBackgroundResource(2130842210);
            if ((!TextUtils.isEmpty(this.e.faceScoreTailWording)) && (this.c.mMode != 2))
            {
              this.y.setText(this.e.faceScoreTailWording);
              if (bool) {
                if (this.e.faceScoreTailWordingColor == 0)
                {
                  this.y.setTextColor(Color.parseColor("#000000"));
                }
                else
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("#");
                  ((StringBuilder)localObject1).append(Integer.toHexString(this.e.faceScoreTailWordingColor));
                  localObject1 = ((StringBuilder)localObject1).toString();
                  this.y.setTextColor(Color.parseColor((String)localObject1));
                }
              }
              this.y.setVisibility(0);
            }
            else
            {
              this.y.setVisibility(8);
            }
            this.x.setVisibility(0);
            i1 = 1;
          }
          else
          {
            this.o.setVisibility(8);
            i1 = 0;
          }
          if (i1 != 0)
          {
            i1 = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.c.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
            String str = this.c.mUin;
            if (2 == this.c.mMode) {
              localObject1 = "1";
            } else {
              localObject1 = "2";
            }
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(i1);
            ((StringBuilder)localObject2).append("");
            localObject2 = ((StringBuilder)localObject2).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.e.gender + 1);
            localStringBuilder.append("");
            FaceScoreUtils.a("exp_data", str, new String[] { localObject1, localObject2, localStringBuilder.toString(), this.e.faceScoreWording });
          }
        }
      }
      else
      {
        this.o.setVisibility(8);
      }
      if (2 == this.c.mMode) {
        this.g = paramFaceScoreConfig.e;
      } else if (3 == this.c.mMode) {
        this.g = paramFaceScoreConfig.f;
      }
      if ((!TextUtils.isEmpty(this.g)) && (this.e.entryAbility != 1))
      {
        this.o.setOnClickListener(this);
        return;
      }
      this.o.setOnClickListener(null);
      this.x.setVisibility(8);
      if (this.w.getVisibility() == 0)
      {
        paramFaceScoreConfig = (RelativeLayout.LayoutParams)this.w.getLayoutParams();
        paramFaceScoreConfig.rightMargin = 15;
        this.w.setLayoutParams(paramFaceScoreConfig);
      }
      return;
    }
    this.o.setVisibility(8);
  }
  
  public void a(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    this.d = paramNearbyProfileDisplayPanel;
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
      this.u = ((nearby.Cmd0x1RspBody)localObject).bytes_chat_sig.get().toByteArray();
      this.c.app.getMsgCache().h(this.e.uin, this.u);
      int i1 = ((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_gift.get();
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      this.I = bool;
      if (((nearby.Cmd0x1RspBody)localObject).bytes_mask_gift_reason.has()) {
        this.J = ((nearby.Cmd0x1RspBody)localObject).bytes_mask_gift_reason.get().toStringUtf8();
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
  
  protected void a(InterestTag[] paramArrayOfInterestTag)
  {
    if (this.e.getCommonTagInfos() != null)
    {
      InterestTag localInterestTag = this.e.getCommonTagInfos();
      this.n.a(new InterestTag[] { localInterestTag });
      this.m.a(this.e.getCommonTagInfos());
      ((TextView)this.i.findViewById(2131436902)).setText(this.c.getResources().getString(2131897048, new Object[] { Integer.valueOf(this.e.commonLabels.size()) }));
      ReportController.b(this.c.app, "dc00899", "grp_lbs", "", "data_card", "coninterest_exp", 0, 0, "", "", "", "");
    }
    this.m.a(paramArrayOfInterestTag);
  }
  
  public View b()
  {
    return this.v;
  }
  
  protected void b(byte[] paramArrayOfByte)
  {
    Object localObject1 = this.c.getResources();
    int i1 = ((Resources)localObject1).getColor(2131167993);
    int i2 = ((Resources)localObject1).getColor(2131168125);
    if (this.e.nowUserType == 0)
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
          paramArrayOfByte = ((RichStatus)localObject1).toSpannableString(null, -8947849, this.c.getResources().getColor(2131165564));
        }
        localObject2 = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          localObject2 = new SpannableString("");
        }
        this.q.setVisibility(0);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((RichStatus)localObject1).actionText)))
        {
          localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
          ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
          if (this.c.mStatusManager != null) {
            paramArrayOfByte = this.c.mStatusManager.a(((RichStatus)localObject1).actionId, 200);
          } else {
            paramArrayOfByte = BitmapManager.a(this.c.getResources(), 2130851609);
          }
          paramArrayOfByte = new StatableBitmapDrawable(this.c.getResources(), paramArrayOfByte, false, false);
          i2 = (int)(this.B.getTextSize() * 1.1F + 0.5F);
          paramArrayOfByte.setBounds(0, 0, i2, i2);
          paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
          paramArrayOfByte.setOffset(-0.1F);
          ((SpannableStringBuilder)localObject2).setSpan(paramArrayOfByte, 0, 3, 17);
          this.B.setText((CharSequence)localObject2);
          this.B.setTextColor(i1);
          ReportController.b(this.c.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
          ReportController.b(this.c.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
          return;
        }
        paramArrayOfByte = StringUtil.trim(((SpannableString)localObject2).toString());
        if (!TextUtils.isEmpty(paramArrayOfByte))
        {
          this.B.setText(paramArrayOfByte.trim());
          this.B.setTextColor(i1);
          return;
        }
        if (this.c.mMode == 2)
        {
          this.B.setText(this.c.getResources().getString(2131892172));
          this.B.setTextColor(i2);
          return;
        }
        this.q.setVisibility(8);
      }
    }
    else {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        if (!TextUtils.isEmpty(paramArrayOfByte))
        {
          this.B.setText(paramArrayOfByte.trim());
          this.B.setTextColor(i1);
          this.q.setVisibility(0);
          return;
        }
        this.q.setVisibility(8);
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
  
  protected void c()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.i.findViewById(2131436941);
    View localView = this.i.findViewById(2131436942);
    this.m = new LabelDisplayCtrl();
    this.m.a(this.c, localLinearLayout, localView);
    localLinearLayout = (LinearLayout)this.i.findViewById(2131436901);
    localView = this.i.findViewById(2131436902);
    this.n = new LabelDisplayCtrl();
    this.n.a(this.c, localLinearLayout, localView);
  }
  
  protected void d()
  {
    int i2;
    String str;
    if ((this.e.nearbyNowData != null) && (this.e.nearbyNowData.get() != null) && (((cmd0xac5.NearbyNowData)this.e.nearbyNowData.get()).master_state.get() != null))
    {
      i2 = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.e.nearbyNowData.get()).master_state.get()).uint32_state.get();
      str = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.e.nearbyNowData.get()).master_state.get()).bytes_jump_url.get().toStringUtf8();
    }
    else
    {
      str = "";
      i2 = 0;
    }
    this.E.setVisibility(0);
    int i1 = -1;
    ReportTask localReportTask;
    StringBuilder localStringBuilder;
    if (i2 == 0)
    {
      this.D.setText(HardCodeUtil.a(2131905130));
      if (this.c.mMode == 3)
      {
        this.E.setVisibility(8);
      }
      else
      {
        localReportTask = new ReportTask(this.c.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.e.gender + 1);
        localReportTask.a(new String[] { "", localStringBuilder.toString(), "1" }).a();
      }
      i1 = 1;
    }
    else if (i2 == 1)
    {
      this.D.setText(HardCodeUtil.a(2131905215));
      localReportTask = new ReportTask(this.c.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.e.gender + 1);
      localReportTask.a(new String[] { "", localStringBuilder.toString(), "3" }).a();
      i1 = 3;
    }
    else if (i2 == 2)
    {
      this.D.setText(HardCodeUtil.a(2131905146));
      if (this.c.mMode == 3)
      {
        this.E.setVisibility(8);
      }
      else
      {
        localReportTask = new ReportTask(this.c.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.e.gender + 1);
        localReportTask.a(new String[] { "", localStringBuilder.toString(), "2" }).a();
      }
      i1 = 2;
    }
    if (!NearbyDataManager.c(this.c.app)) {
      this.E.setVisibility(8);
    }
    this.E.setOnClickListener(new NearbyProfileFragment.1(this, str, i1));
    if (this.E.getVisibility() != 0) {
      this.i.findViewById(2131437216).setVisibility(8);
    }
    if (this.f == null) {
      this.f = FaceScoreUtils.a(this.c.getAppInterface());
    }
    if (this.f.a())
    {
      ((NearbyFaceScoreManager)this.c.getAppInterface().getManager(QQManagerFactory.FACE_SCORE_MANAGER)).a(new NearbyProfileFragment.2(this));
      return;
    }
    a(this.f);
  }
  
  protected void e()
  {
    if (this.e == null) {
      return;
    }
    d();
    a(this.e.nearbyInfo);
    b(this.e.xuanYan);
    g();
    h();
    f();
    TopicLabelCtrl localTopicLabelCtrl = this.L;
    if (localTopicLabelCtrl != null) {
      localTopicLabelCtrl.a(this.e.nearbyNowData);
    }
    this.h = new InterestTag[LabelDisplayCtrl.e.length];
    int i1 = 0;
    while (i1 < LabelDisplayCtrl.e.length)
    {
      this.h[i1] = new InterestTag(LabelDisplayCtrl.e[i1]);
      i1 += 1;
    }
    this.e.getTagInfos(this.h);
    a(this.h);
    if (a(this.i.findViewById(2131436902))) {
      this.i.findViewById(2131437213).setVisibility(8);
    }
    if ((a(this.q)) && (a(this.p))) {
      this.i.findViewById(2131437221).setVisibility(8);
    }
    if ((a(this.o)) && (a(this.k)) && (a(this.C))) {
      this.i.findViewById(2131437221).setVisibility(8);
    }
  }
  
  protected void f()
  {
    this.k.setVisibility(0);
    if (this.c.mMode != 2)
    {
      this.C.setVisibility(8);
      this.k.setVisibility(8);
    }
    else
    {
      this.C.setVisibility(8);
      this.C.setOnClickListener(new NearbyProfileFragment.3(this));
      Object localObject = TroopGiftAioPanelData.b(this.c, 1);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((TroopGiftAioPanelData)localObject).u;
      }
      if (localObject != null) {
        this.z.setText(((GiftConfigManager.TextEntryItem)localObject).a);
      } else {
        ((TroopGiftManager)this.c.app.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(1402, new NearbyProfileFragment.4(this));
      }
      this.k.setOnClickListener(new NearbyProfileFragment.5(this, (GiftConfigManager.TextEntryItem)localObject));
      ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "my_point", 0, 0, "", "", "", "");
    }
    if (NearbyProfileCardUtils.a(this.c.from))
    {
      this.I = this.e.isForbidSendGiftMsgForTribar;
      this.J = this.e.disableSendGiftBtnTipsForTribar;
      return;
    }
    this.I = this.e.isForbidSendGiftMsg;
    this.J = this.e.disableSendGiftBtnTips;
  }
  
  protected void g()
  {
    Object localObject = this.c.getResources();
    int i1 = ((Resources)localObject).getColor(2131167993);
    int i2 = ((Resources)localObject).getColor(2131168125);
    localObject = new StringBuilder();
    NearbyPeopleCard localNearbyPeopleCard = this.e;
    localNearbyPeopleCard.company = StringUtil.trim(localNearbyPeopleCard.company);
    if (!TextUtils.isEmpty(this.e.company))
    {
      ((StringBuilder)localObject).append(new QQText(this.e.company, 1, 16));
      ReportController.b(this.c.app, "dc00899", "grp_lbs", "", "data_card", "exp_company", 0, 0, "", "", "", "");
      ((StringBuilder)localObject).append("  ");
    }
    if ((this.e.job > 0) && (this.e.job < NearbyProfileUtil.e.length))
    {
      ReportController.b(this.c.app, "dc00899", "grp_lbs", "", "data_card", "exp_work", 0, 0, "", "", "", "");
      ((StringBuilder)localObject).append(NearbyProfileUtil.e[this.e.job]);
      ((StringBuilder)localObject).append("  ");
    }
    localNearbyPeopleCard = this.e;
    localNearbyPeopleCard.college = StringUtil.trim(localNearbyPeopleCard.college);
    if (!TextUtils.isEmpty(this.e.college))
    {
      ((StringBuilder)localObject).append(new QQText(this.e.college, 1, 16));
      ReportController.b(this.c.app, "dc00899", "grp_lbs", "", "data_card", "exp_school", 0, 0, "", "", "", "");
    }
    if (((StringBuilder)localObject).length() > 0)
    {
      this.p.setVisibility(0);
      this.A.setText(((StringBuilder)localObject).toString());
      this.A.setTextColor(i1);
      return;
    }
    if (this.c.mMode == 2)
    {
      this.p.setVisibility(0);
      this.A.setText(this.c.getResources().getString(2131892172));
      this.A.setTextColor(i2);
    }
  }
  
  public void h()
  {
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(this.c.app.getCurrentUin())));
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
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.h());
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    ProtoUtils.a(this.c.app, new NearbyProfileFragment.7(this), ((oidb_sso.OIDBSSOPkg)localObject).toByteArray(), "OidbSvc.0x66b");
  }
  
  public int i()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getBaseActivity() instanceof NearbyPeopleProfileActivity)) {
      this.c = ((NearbyPeopleProfileActivity)getBaseActivity());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.o)
    {
      if (this.c.mTinyId <= 0L)
      {
        paramView = (NearbyFaceScoreManager)this.c.getAppInterface().getManager(QQManagerFactory.FACE_SCORE_MANAGER);
        long l1 = Long.parseLong(this.c.mUin);
        paramView.a(l1, new NearbyProfileFragment.8(this, l1));
        return;
      }
      a(this.c.mTinyId);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.c.getIntent();
    boolean bool = false;
    if (paramBundle.getIntExtra("frome_where", 0) == 35) {
      bool = true;
    }
    this.r = bool;
    this.s = this.c.getResources().getDimensionPixelSize(2131298121);
    this.t = this.c.getResources().getDimensionPixelSize(2131298120);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i1 = a();
    boolean bool = false;
    this.i = paramLayoutInflater.inflate(i1, paramViewGroup, false);
    this.v = this.i.findViewById(2131429717);
    this.q = ((RelativeLayout)this.i.findViewById(2131437030));
    this.B = ((TextView)this.i.findViewById(2131448885));
    this.p = ((RelativeLayout)this.i.findViewById(2131436943));
    this.A = ((TextView)this.i.findViewById(2131447166));
    this.z = ((TextView)this.i.findViewById(2131447186));
    this.k = ((RelativeLayout)this.i.findViewById(2131436954));
    this.o = ((RelativeLayout)this.i.findViewById(2131436917));
    this.w = ((TextView)this.i.findViewById(2131447136));
    this.j = ((URLImageView)this.i.findViewById(2131435553));
    this.x = ((LinearLayout)this.i.findViewById(2131429899));
    this.y = ((TextView)this.i.findViewById(2131429900));
    if (this.r)
    {
      this.o.setVisibility(8);
      paramLayoutInflater = this.i.findViewById(2131449301);
      paramViewGroup = (LinearLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
      paramViewGroup.height = DisplayUtil.a(this.c, 90.0F);
      paramLayoutInflater.setLayoutParams(paramViewGroup);
    }
    this.D = ((TextView)this.i.findViewById(2131432749));
    this.E = this.i.findViewById(2131432747);
    this.F = ((TextView)this.i.findViewById(2131432748));
    c();
    this.l = ((TextView)this.i.findViewById(2131447250));
    this.C = ((RelativeLayout)this.i.findViewById(2131437028));
    this.H = ((LinearLayout)this.i.findViewById(2131449954));
    this.G = new RedTouch(this.c, this.C).c(21).b(30.0F).a();
    this.H = ((LinearLayout)this.i.findViewById(2131449954));
    this.L = new TopicLabelCtrl();
    paramLayoutInflater = this.L;
    paramViewGroup = this.c.app;
    paramBundle = this.i;
    if (this.c.mMode == 2) {
      bool = true;
    }
    paramLayoutInflater.a(paramViewGroup, paramBundle, bool);
    this.K = true;
    e();
    return this.i;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramView.getTag() instanceof NearbyProfileFragment.ViewHolder))
    {
      paramView = ((NearbyProfileFragment.ViewHolder)paramView.getTag()).a;
      if (paramView.type == 101)
      {
        paramAdapterView = (NearbyVideoChatManager)this.c.app.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
        if (paramAdapterView != null)
        {
          paramAdapterView = paramAdapterView.a();
          if ((this.c.app.isVideoChatting()) && (!this.c.app.getAVNotifyCenter().D())) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          if (paramInt != 0)
          {
            paramAdapterView = DialogUtil.a(this.c, 230);
            paramAdapterView.setMessage(this.c.getString(2131893650));
            paramAdapterView.setNegativeButton(HardCodeUtil.a(2131899883), new NearbyProfileFragment.6(this));
            paramAdapterView.show();
            return;
          }
          NearbyVideoChatProxyActivity.a(this.c.app, this.c, null, paramAdapterView, null, 0);
        }
      }
      else if ((paramView.type == 102) && (!TextUtils.isEmpty(paramView.url)))
      {
        paramAdapterView = new Intent(this.c, QQBrowserActivity.class);
        paramAdapterView.putExtra("url", paramView.url);
        this.c.startActivity(paramAdapterView);
      }
      else if (paramView.status == 1)
      {
        paramAdapterView = JumpParser.a(this.c.app, this.c, paramView.url);
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
          localObject1 = new Intent(this.c, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramAdapterView.toString());
          this.c.startActivity((Intent)localObject1);
        }
      }
      Object localObject1 = this.c.app;
      if (this.c.mMode == 2) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment
 * JD-Core Version:    0.7.0.1
 */