package com.tencent.mobileqq.nearpeople.NearbyRecommender;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RishState;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import afmq;
import afmr;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class ChatPushCarrierHelper
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  public FaceDecoder a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  int c = 0;
  
  public ChatPushCarrierHelper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970441, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370708));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370707));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidContentContext, ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(14));
    paramContext = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
    if (paramContext != null)
    {
      paramContext = paramContext.getString("key_nearbyrecommender_title", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131437397));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext);
    }
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, SingleLineTextView paramSingleLineTextView)
  {
    paramImageView.setVisibility(8);
    paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131494250));
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo == null) || (!localVipOpenInfo.bOpen)) {
        break label83;
      }
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130845982);
      paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131494295));
    }
    label83:
    do
    {
      return;
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    } while ((paramVipBaseInfo == null) || (!paramVipBaseInfo.bOpen));
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2130846210);
    paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131494295));
  }
  
  private void a(SingleLineTextView paramSingleLineTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.c == 0) {
      this.c = ((int)(paramSingleLineTextView.a() * 1.1F + 0.5F));
    }
    localStatableBitmapDrawable.setBounds(0, 0, this.c, this.c);
    paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(localStatableBitmapDrawable, null);
  }
  
  private void a(SingleLineTextView paramSingleLineTextView, RespEncounterInfo paramRespEncounterInfo)
  {
    RichStatus localRichStatus;
    if (paramRespEncounterInfo.richState != null)
    {
      localRichStatus = RichStatus.parseStatus(paramRespEncounterInfo.richState.vState);
      localRichStatus.time = paramRespEncounterInfo.richState.uModifyTime;
    }
    for (paramRespEncounterInfo = localRichStatus;; paramRespEncounterInfo = null)
    {
      if ((paramRespEncounterInfo != null) && (!paramRespEncounterInfo.isEmpty()))
      {
        if (!TextUtils.isEmpty(paramRespEncounterInfo.actionText)) {
          a(paramSingleLineTextView, paramRespEncounterInfo.actionId);
        }
        for (;;)
        {
          this.jdField_b_of_type_Int = paramRespEncounterInfo.actionId;
          paramSingleLineTextView.setText(paramRespEncounterInfo.toSpannableString(null));
          paramSingleLineTextView.setVisibility(0);
          return;
          paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        }
      }
      this.jdField_b_of_type_Int = 0;
      paramSingleLineTextView.setVisibility(8);
      return;
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public View a(RespEncounterInfo paramRespEncounterInfo)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969109, null);
    if ((localView != null) && (paramRespEncounterInfo != null))
    {
      localView.setTag(paramRespEncounterInfo);
      localView.setOnClickListener(this);
      a(localView, paramRespEncounterInfo);
    }
    return localView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  public void a(RespEncounterInfo paramRespEncounterInfo, ImageView paramImageView)
  {
    String str;
    Boolean localBoolean;
    try
    {
      if (paramRespEncounterInfo.tiny_id > 0L)
      {
        str = String.valueOf(paramRespEncounterInfo.tiny_id);
        if (this.jdField_a_of_type_Boolean)
        {
          localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramRespEncounterInfo.tiny_id));
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramRespEncounterInfo.tiny_id), Boolean.valueOf(true));
            ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.a(new afmq(this, str, paramRespEncounterInfo));
          }
        }
        paramRespEncounterInfo = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, str, 202);
        if (paramRespEncounterInfo == null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 202, true, false);
          }
          if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
          }
          paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          return;
        }
        paramImageView.setImageBitmap(paramRespEncounterInfo);
        return;
      }
    }
    catch (Throwable paramRespEncounterInfo)
    {
      paramRespEncounterInfo.printStackTrace();
      return;
    }
    if (paramRespEncounterInfo.lEctID > 0L)
    {
      str = String.valueOf(paramRespEncounterInfo.lEctID);
      if (this.jdField_a_of_type_Boolean)
      {
        localBoolean = (Boolean)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramRespEncounterInfo.lEctID));
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
        {
          this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramRespEncounterInfo.lEctID), Boolean.valueOf(true));
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.a(new afmr(this, str, paramRespEncounterInfo));
        }
      }
      paramRespEncounterInfo = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, str, 200);
      if (paramRespEncounterInfo == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 200, true, false);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
        }
        paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        return;
      }
      paramImageView.setImageBitmap(paramRespEncounterInfo);
    }
  }
  
  public void a(View paramView, RespEncounterInfo paramRespEncounterInfo)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131362701);
    SingleLineTextView localSingleLineTextView1 = (SingleLineTextView)paramView.findViewById(2131363873);
    Object localObject3 = (ImageView)paramView.findViewById(2131365180);
    ImageView localImageView5 = (ImageView)paramView.findViewById(2131365175);
    Object localObject1 = (TextView)paramView.findViewById(2131365176);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131364842);
    SingleLineTextView localSingleLineTextView2 = (SingleLineTextView)paramView.findViewById(2131364847);
    Object localObject2 = (SingleLineTextView)paramView.findViewById(2131365193);
    View localView2 = paramView.findViewById(2131365196);
    TextView localTextView = (TextView)paramView.findViewById(2131365197);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131365190);
    ImageView localImageView4 = (ImageView)paramView.findViewById(2131370392);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131365182);
    View localView1 = paramView.findViewById(2131365181);
    paramView = (SingleLineTextView)paramView.findViewById(2131365184);
    this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494250);
    label222:
    int i;
    if (!TextUtils.isEmpty(paramRespEncounterInfo.strNick))
    {
      localSingleLineTextView1.setText(paramRespEncounterInfo.strNick.trim());
      if (paramRespEncounterInfo.authFlag != 1) {
        break label766;
      }
      ((ImageView)localObject3).setVisibility(0);
      ((TextView)localObject1).setVisibility(8);
      if (paramRespEncounterInfo.god_flag != 1) {
        break label830;
      }
      ((TextView)localObject1).setVisibility(0);
      localImageView5.setVisibility(0);
      if (paramRespEncounterInfo.cSex != 1) {
        break label776;
      }
      localImageView5.setBackgroundResource(2130843038);
      localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842744);
      ((TextView)localObject1).setBackgroundDrawable(TroopUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources(), -17883, (Drawable)localObject3));
      ((TextView)localObject1).setText("女神");
      label308:
      ((SingleLineTextView)localObject2).setText(paramRespEncounterInfo.strDescription);
      ((SingleLineTextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0);
      localView2.setVisibility(8);
      localTextView.setVisibility(8);
      i = this.jdField_a_of_type_Int - (int)(189.0F * this.jdField_a_of_type_Float);
      localObject1 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      localObject2 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      if ((localObject1 == null) || (!((VipOpenInfo)localObject1).bOpen)) {
        break label840;
      }
      i -= (int)Math.ceil(33.5F * this.jdField_a_of_type_Float);
    }
    label1030:
    for (;;)
    {
      label424:
      int j = i;
      if (paramRespEncounterInfo.authFlag == 1) {
        j = i - (int)Math.ceil(20.0F * this.jdField_a_of_type_Float);
      }
      i = j;
      if (paramRespEncounterInfo.watch_color != 0) {
        i = j - (int)Math.ceil(16.0F * this.jdField_a_of_type_Float);
      }
      localSingleLineTextView1.setMaxWidth(i);
      i = 0;
      localObject1 = new StringBuilder();
      switch (paramRespEncounterInfo.cSex)
      {
      default: 
        label524:
        if (paramRespEncounterInfo.cAge != 0) {
          ((StringBuilder)localObject1).append(" ").append(String.valueOf(paramRespEncounterInfo.cAge));
        }
        if (paramRespEncounterInfo.constellation == 0)
        {
          label557:
          if ((paramRespEncounterInfo.profession_id > 0) && (paramRespEncounterInfo.profession_id < 14)) {
            break label918;
          }
          label573:
          if (((StringBuilder)localObject1).length() <= 0) {
            break label941;
          }
          i = 1;
          paramView.setText(((StringBuilder)localObject1).toString());
          if (AppSetting.b) {
            paramView.setContentDescription(((StringBuilder)localObject1).toString());
          }
          paramView.setVisibility(0);
          label612:
          if (paramRespEncounterInfo.charm_shown != 1) {
            break label983;
          }
          if (localImageView4.getVisibility() != 0) {
            localImageView4.setVisibility(0);
          }
          switch (paramRespEncounterInfo.charm_level)
          {
          default: 
            localImageView4.setImageResource(2130842659);
            label672:
            if (AppSetting.b) {
              localImageView4.setContentDescription("拥有魅力勋章");
            }
            label686:
            if (paramRespEncounterInfo.watch_color == 0)
            {
              localView1.setVisibility(8);
              label700:
              if (paramRespEncounterInfo.nFaceNum < 6) {
                break label1010;
              }
              i += 1;
              localImageView3.setVisibility(0);
              label719:
              if (i <= 0) {
                break label1020;
              }
              localLinearLayout.setVisibility(0);
            }
            break;
          }
        }
        break;
      }
      for (;;)
      {
        a(paramRespEncounterInfo.vipBaseInfo, localImageView2, localSingleLineTextView1);
        a(paramRespEncounterInfo, localImageView1);
        a(localSingleLineTextView2, paramRespEncounterInfo);
        return;
        localSingleLineTextView1.setText("");
        break;
        label766:
        ((ImageView)localObject3).setVisibility(8);
        break label222;
        label776:
        localImageView5.setBackgroundResource(2130843038);
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842744);
        ((TextView)localObject1).setBackgroundDrawable(TroopUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources(), -17883, (Drawable)localObject3));
        ((TextView)localObject1).setText("男神");
        break label308;
        label830:
        localImageView5.setVisibility(8);
        break label308;
        label840:
        if ((localObject2 == null) || (!((VipOpenInfo)localObject2).bOpen)) {
          break label1030;
        }
        i -= (int)Math.ceil(28.5F * this.jdField_a_of_type_Float);
        break label424;
        ((StringBuilder)localObject1).append("男");
        break label524;
        ((StringBuilder)localObject1).append("女");
        break label524;
        ((StringBuilder)localObject1).append(" ").append(ProfileCardUtil.a(paramRespEncounterInfo.constellation));
        break label557;
        label918:
        ((StringBuilder)localObject1).append(" ").append(com.tencent.mobileqq.util.NearbyProfileUtil.e[paramRespEncounterInfo.profession_id]);
        break label573;
        label941:
        paramView.setVisibility(8);
        break label612;
        localImageView4.setImageResource(2130842661);
        break label672;
        localImageView4.setImageResource(2130842662);
        break label672;
        localImageView4.setImageResource(2130842663);
        break label672;
        label983:
        if (localImageView4.getVisibility() == 4) {
          break label686;
        }
        localImageView4.setVisibility(4);
        break label686;
        localView1.setVisibility(0);
        break label700;
        label1010:
        localImageView3.setVisibility(8);
        break label719;
        label1020:
        localLinearLayout.setVisibility(8);
      }
    }
  }
  
  public void a(List paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      RespEncounterInfo localRespEncounterInfo = (RespEncounterInfo)paramList.get(i);
      View localView = a(localRespEncounterInfo);
      if ((localView != null) && (localRespEncounterInfo != null)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, new LinearLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (RespEncounterInfo)paramView.getTag();
    paramView = (FriendsManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(50);
    if (paramView != null) {}
    for (boolean bool = paramView.b(Long.toString(((RespEncounterInfo)localObject).lEctID));; bool = false)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      localIntent.putExtra("uin", Long.toString(((RespEncounterInfo)localObject).lEctID));
      localIntent.putExtra("from_where_to_aio", "nearby_recommend_people");
      if (bool)
      {
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("rich_accost_sig", ((RespEncounterInfo)localObject).sig);
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131437735);
        if (!"0".equals(String.valueOf(((RespEncounterInfo)localObject).cSex))) {
          break label279;
        }
      }
      label279:
      for (paramView = String.format(paramView, new Object[] { "他" });; paramView = String.format(paramView, new Object[] { "她" }))
      {
        NearbyRecommenderUtils.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, Long.toString(((RespEncounterInfo)localObject).lEctID), Long.toString(((RespEncounterInfo)localObject).lEctID), paramView, 1001, true, true);
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivity(localIntent);
        paramView = Long.toString(((RespEncounterInfo)localObject).lEctID);
        localObject = NearbyRecommenderUtils.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app);
        ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "0X80055FC", "0X80055FC", 0, 0, localObject[0], paramView, "", "");
        return;
        localIntent.putExtra("uintype", 1001);
        break;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CarrierHelper", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())) {
      return;
    }
    paramInt2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    paramInt1 = 0;
    label80:
    Object localObject;
    if (paramInt1 < paramInt2)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
      if (localObject != null) {
        break label107;
      }
    }
    label107:
    RespEncounterInfo localRespEncounterInfo;
    do
    {
      paramInt1 += 1;
      break label80;
      break;
      localRespEncounterInfo = (RespEncounterInfo)((View)localObject).getTag();
      localObject = (ImageView)((View)localObject).findViewById(16908294);
    } while ((localObject == null) || (localRespEncounterInfo == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(Long.toString(localRespEncounterInfo.lEctID))));
    ((ImageView)localObject).setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper
 * JD-Core Version:    0.7.0.1
 */