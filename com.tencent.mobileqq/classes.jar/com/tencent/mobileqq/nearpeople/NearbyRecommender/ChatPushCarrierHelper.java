package com.tencent.mobileqq.nearpeople.NearbyRecommender;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RishState;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.nearpeople.IChatPushCarrier;
import com.tencent.mobileqq.nearpeople.api.INearbyRecommenderUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.mobileqq.util.DisplayUtil;
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
  implements View.OnClickListener, DecodeTaskCompletionListener, IChatPushCarrier
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  HashMap<Long, Boolean> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  int c = 0;
  
  public ChatPushCarrierHelper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561228, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373294));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378852));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getRuntimeService(IQQAvatarService.class, "")).getInstance(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(QQManagerFactory.STATUS_MANAGER));
    paramContext = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
    if (paramContext != null)
    {
      paramContext = paramContext.getString("key_nearbyrecommender_title", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694412));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext);
    }
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, SingleLineTextView paramSingleLineTextView)
  {
    paramImageView.setVisibility(8);
    paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131167124));
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130850860);
        paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131167200));
        return;
      }
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130850860);
        paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131167200));
        return;
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      if ((paramVipBaseInfo != null) && (paramVipBaseInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130851196);
        paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131167200));
      }
    }
  }
  
  private void a(SingleLineTextView paramSingleLineTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.c == 0) {
      this.c = ((int)(paramSingleLineTextView.getTextSize() * 1.1F + 0.5F));
    }
    paramInt = this.c;
    localStatableBitmapDrawable.setBounds(0, 0, paramInt, paramInt);
    paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(localStatableBitmapDrawable, null);
  }
  
  private void a(SingleLineTextView paramSingleLineTextView, RespEncounterInfo paramRespEncounterInfo)
  {
    if (paramRespEncounterInfo.richState != null)
    {
      RichStatus localRichStatus = RichStatus.parseStatus(paramRespEncounterInfo.richState.vState);
      localRichStatus.time = paramRespEncounterInfo.richState.uModifyTime;
      paramRespEncounterInfo = localRichStatus;
    }
    else
    {
      paramRespEncounterInfo = null;
    }
    if ((paramRespEncounterInfo != null) && (!paramRespEncounterInfo.isEmpty()))
    {
      if (!TextUtils.isEmpty(paramRespEncounterInfo.actionText)) {
        a(paramSingleLineTextView, paramRespEncounterInfo.actionId);
      } else {
        paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      }
      this.jdField_b_of_type_Int = paramRespEncounterInfo.actionId;
      paramSingleLineTextView.setText(paramRespEncounterInfo.toSpannableString(null));
      paramSingleLineTextView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_Int = 0;
    paramSingleLineTextView.setVisibility(8);
  }
  
  public View a(RespEncounterInfo paramRespEncounterInfo)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559476, null);
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
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  public void a(RespEncounterInfo paramRespEncounterInfo, ImageView paramImageView)
  {
    try
    {
      String str;
      Boolean localBoolean;
      if (paramRespEncounterInfo.tiny_id > 0L)
      {
        str = String.valueOf(paramRespEncounterInfo.tiny_id);
        if (this.jdField_a_of_type_Boolean)
        {
          localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramRespEncounterInfo.tiny_id));
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramRespEncounterInfo.tiny_id), Boolean.valueOf(true));
            ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.execute(new ChatPushCarrierHelper.1(this, str, paramRespEncounterInfo));
          }
        }
        paramRespEncounterInfo = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(32, str, 202);
        if (paramRespEncounterInfo == null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeStrangeFace(str, 202, true, false);
          }
          if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.f());
          }
          paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          return;
        }
        paramImageView.setImageBitmap(paramRespEncounterInfo);
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
            ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.execute(new ChatPushCarrierHelper.2(this, str, paramRespEncounterInfo));
          }
        }
        paramRespEncounterInfo = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(32, str, 200);
        if (paramRespEncounterInfo == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeStrangeFace(str, 200, true, false);
          if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.f());
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
    }
  }
  
  public void a(View paramView, RespEncounterInfo paramRespEncounterInfo)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131368343);
    SingleLineTextView localSingleLineTextView1 = (SingleLineTextView)paramView.findViewById(2131378461);
    Object localObject4 = (ImageView)paramView.findViewById(2131363064);
    ImageView localImageView5 = (ImageView)paramView.findViewById(2131368727);
    Object localObject1 = (TextView)paramView.findViewById(2131378524);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131380937);
    SingleLineTextView localSingleLineTextView2 = (SingleLineTextView)paramView.findViewById(2131365453);
    Object localObject2 = (SingleLineTextView)paramView.findViewById(2131378723);
    Object localObject3 = paramView.findViewById(2131369478);
    TextView localTextView = (TextView)paramView.findViewById(2131371828);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131372550);
    ImageView localImageView4 = (ImageView)paramView.findViewById(2131364471);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131377106);
    View localView = paramView.findViewById(2131369564);
    paramView = (SingleLineTextView)paramView.findViewById(2131368858);
    this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167124);
    if (!TextUtils.isEmpty(paramRespEncounterInfo.strNick)) {
      localSingleLineTextView1.setText(paramRespEncounterInfo.strNick.trim());
    } else {
      localSingleLineTextView1.setText("");
    }
    if (paramRespEncounterInfo.authFlag == 1) {
      ((ImageView)localObject4).setVisibility(0);
    } else {
      ((ImageView)localObject4).setVisibility(8);
    }
    ((TextView)localObject1).setVisibility(8);
    if (paramRespEncounterInfo.god_flag == 1)
    {
      ((TextView)localObject1).setVisibility(0);
      localImageView5.setVisibility(0);
      if (paramRespEncounterInfo.cSex == 1)
      {
        localImageView5.setBackgroundResource(2130846084);
        localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845677);
        ((TextView)localObject1).setBackgroundDrawable(BizTroopUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), -17883, (Drawable)localObject4));
        ((TextView)localObject1).setText(HardCodeUtil.a(2131701921));
      }
      else
      {
        localImageView5.setBackgroundResource(2130846084);
        localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845677);
        ((TextView)localObject1).setBackgroundDrawable(BizTroopUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), -17883, (Drawable)localObject4));
        ((TextView)localObject1).setText(HardCodeUtil.a(2131701924));
      }
    }
    else
    {
      localImageView5.setVisibility(8);
    }
    ((SingleLineTextView)localObject2).setText(paramRespEncounterInfo.strDescription);
    ((SingleLineTextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0);
    ((View)localObject3).setVisibility(8);
    localTextView.setVisibility(8);
    int j = this.jdField_a_of_type_Int - (int)(this.jdField_a_of_type_Float * 189.0F);
    localObject1 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
    localObject2 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    localObject3 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
    double d;
    if ((localObject3 != null) && (((VipOpenInfo)localObject3).bOpen)) {
      d = Math.ceil(this.jdField_a_of_type_Float * 33.5F);
    }
    for (;;)
    {
      i = j - (int)d;
      break;
      if ((localObject1 != null) && (((VipOpenInfo)localObject1).bOpen))
      {
        d = Math.ceil(this.jdField_a_of_type_Float * 33.5F);
      }
      else
      {
        i = j;
        if (localObject2 == null) {
          break;
        }
        i = j;
        if (!((VipOpenInfo)localObject2).bOpen) {
          break;
        }
        d = Math.ceil(this.jdField_a_of_type_Float * 28.5F);
      }
    }
    j = i;
    if (paramRespEncounterInfo.authFlag == 1) {
      j = i - (int)Math.ceil(this.jdField_a_of_type_Float * 20.0F);
    }
    int i = j;
    if (paramRespEncounterInfo.watch_color != 0) {
      i = j - (int)Math.ceil(this.jdField_a_of_type_Float * 16.0F);
    }
    localSingleLineTextView1.setMaxWidth(i);
    localObject1 = new StringBuilder();
    i = paramRespEncounterInfo.cSex;
    if (i != 0)
    {
      if (i == 1) {
        ((StringBuilder)localObject1).append("女");
      }
    }
    else {
      ((StringBuilder)localObject1).append("男");
    }
    if (paramRespEncounterInfo.cAge != 0)
    {
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(String.valueOf(paramRespEncounterInfo.cAge));
    }
    if (paramRespEncounterInfo.constellation != 0)
    {
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(ProfileCardUtil.a(paramRespEncounterInfo.constellation));
    }
    if ((paramRespEncounterInfo.profession_id > 0) && (paramRespEncounterInfo.profession_id < 14))
    {
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(com.tencent.mobileqq.util.NearbyProfileUtil.e[paramRespEncounterInfo.profession_id]);
    }
    if (((StringBuilder)localObject1).length() > 0)
    {
      paramView.setText(((StringBuilder)localObject1).toString());
      if (AppSetting.d) {
        paramView.setContentDescription(((StringBuilder)localObject1).toString());
      }
      paramView.setVisibility(0);
      i = 1;
    }
    else
    {
      paramView.setVisibility(8);
      i = 0;
    }
    if (paramRespEncounterInfo.charm_shown == 1)
    {
      if (localImageView4.getVisibility() != 0) {
        localImageView4.setVisibility(0);
      }
      j = paramRespEncounterInfo.charm_level;
      if (j != 4)
      {
        if (j != 5)
        {
          if (j != 6) {
            localImageView4.setImageResource(2130845596);
          } else {
            localImageView4.setImageResource(2130845600);
          }
        }
        else {
          localImageView4.setImageResource(2130845599);
        }
      }
      else {
        localImageView4.setImageResource(2130845598);
      }
      if (AppSetting.d) {
        localImageView4.setContentDescription(HardCodeUtil.a(2131701923));
      }
    }
    else if (localImageView4.getVisibility() != 4)
    {
      localImageView4.setVisibility(4);
    }
    if (paramRespEncounterInfo.watch_color == 0) {
      localView.setVisibility(8);
    } else {
      localView.setVisibility(0);
    }
    if (paramRespEncounterInfo.nFaceNum >= 6)
    {
      i += 1;
      localImageView3.setVisibility(0);
    }
    else
    {
      localImageView3.setVisibility(8);
    }
    if (i > 0) {
      localLinearLayout.setVisibility(0);
    } else {
      localLinearLayout.setVisibility(8);
    }
    a(paramRespEncounterInfo.vipBaseInfo, localImageView2, localSingleLineTextView1);
    a(paramRespEncounterInfo, localImageView1);
    a(localSingleLineTextView2, paramRespEncounterInfo);
  }
  
  public void a(List<RespEncounterInfo> paramList)
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
    paramView = (FriendsManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool;
    if (paramView != null) {
      bool = paramView.b(Long.toString(((RespEncounterInfo)localObject).lEctID));
    } else {
      bool = false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
    localIntent.putExtra("uin", Long.toString(((RespEncounterInfo)localObject).lEctID));
    localIntent.putExtra("from_where_to_aio", "nearby_recommend_people");
    if (bool) {
      localIntent.putExtra("uintype", 0);
    } else {
      localIntent.putExtra("uintype", 1001);
    }
    localIntent.putExtra("rich_accost_sig", ((RespEncounterInfo)localObject).sig);
    paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131694393);
    if ("0".equals(String.valueOf(((RespEncounterInfo)localObject).cSex))) {
      paramView = String.format(paramView, new Object[] { HardCodeUtil.a(2131701922) });
    } else {
      paramView = String.format(paramView, new Object[] { HardCodeUtil.a(2131701920) });
    }
    ((INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class)).addGrayTipsMsg(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, Long.toString(((RespEncounterInfo)localObject).lEctID), Long.toString(((RespEncounterInfo)localObject).lEctID), paramView, 1001, true, true);
    ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivity(localIntent);
    paramView = Long.toString(((RespEncounterInfo)localObject).lEctID);
    localObject = ((INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class)).getReasonTypeAndUins(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app);
    ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "0X80055FC", "0X80055FC", 0, 0, localObject[0], paramView, "", "");
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", type=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(",avatar= ");
      ((StringBuilder)localObject1).append(paramBitmap);
      QLog.d("CarrierHelper", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBitmap != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        return;
      }
      paramInt2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
        if (localObject2 != null)
        {
          localObject1 = (RespEncounterInfo)((View)localObject2).getTag();
          localObject2 = (ImageView)((View)localObject2).findViewById(16908294);
          if ((localObject2 != null) && (localObject1 != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(Long.toString(((RespEncounterInfo)localObject1).lEctID))))
          {
            ((ImageView)localObject2).setImageBitmap(paramBitmap);
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper
 * JD-Core Version:    0.7.0.1
 */