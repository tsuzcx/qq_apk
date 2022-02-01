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
  Context a;
  View b;
  LinearLayout c;
  TextView d;
  int e;
  float f;
  HashMap<Long, Boolean> g = new HashMap();
  HashMap<Long, Boolean> h = new HashMap();
  boolean i = false;
  BitmapDrawable j;
  IFaceDecoder k;
  int l;
  int m = 0;
  StatusManager n;
  
  public ChatPushCarrierHelper(Context paramContext)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a).inflate(2131627584, null);
    this.c = ((LinearLayout)this.b.findViewById(2131440903));
    this.d = ((TextView)this.b.findViewById(2131447552));
    this.e = this.a.getResources().getDisplayMetrics().widthPixels;
    this.f = this.a.getResources().getDisplayMetrics().density;
    this.k = ((IQQAvatarService)((BaseActivity)this.a).app.getRuntimeService(IQQAvatarService.class, "")).getInstance(((BaseActivity)this.a).app);
    this.k.setDecodeTaskCompletionListener(this);
    this.n = ((StatusManager)((BaseActivity)this.a).app.getManager(QQManagerFactory.STATUS_MANAGER));
    paramContext = ((BaseActivity)this.a).app.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
    if (paramContext != null)
    {
      paramContext = paramContext.getString("key_nearbyrecommender_title", this.a.getResources().getString(2131892091));
      this.d.setText(paramContext);
    }
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, SingleLineTextView paramSingleLineTextView)
  {
    paramImageView.setVisibility(8);
    paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131168102));
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130852711);
        paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131168185));
        return;
      }
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130852711);
        paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131168185));
        return;
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      if ((paramVipBaseInfo != null) && (paramVipBaseInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130853452);
        paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131168185));
      }
    }
  }
  
  private void a(SingleLineTextView paramSingleLineTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(this.a.getResources(), this.n.a(paramInt, 200), false, false);
    if (this.m == 0) {
      this.m = ((int)(paramSingleLineTextView.getTextSize() * 1.1F + 0.5F));
    }
    paramInt = this.m;
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
      this.l = paramRespEncounterInfo.actionId;
      paramSingleLineTextView.setText(paramRespEncounterInfo.toSpannableString(null));
      paramSingleLineTextView.setVisibility(0);
      return;
    }
    this.l = 0;
    paramSingleLineTextView.setVisibility(8);
  }
  
  public View a(RespEncounterInfo paramRespEncounterInfo)
  {
    View localView = LayoutInflater.from(this.a).inflate(2131625496, null);
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
    IFaceDecoder localIFaceDecoder = this.k;
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
        if (this.i)
        {
          localBoolean = (Boolean)this.g.get(Long.valueOf(paramRespEncounterInfo.tiny_id));
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            this.g.put(Long.valueOf(paramRespEncounterInfo.tiny_id), Boolean.valueOf(true));
            ((BaseActivity)this.a).app.execute(new ChatPushCarrierHelper.1(this, str, paramRespEncounterInfo));
          }
        }
        paramRespEncounterInfo = this.k.getBitmapFromCache(32, str, 202);
        if (paramRespEncounterInfo == null)
        {
          if (!this.k.isPausing()) {
            this.k.requestDecodeStrangeFace(str, 202, true, false);
          }
          if (this.j == null) {
            this.j = ((BitmapDrawable)ImageUtil.m());
          }
          paramImageView.setImageDrawable(this.j);
          return;
        }
        paramImageView.setImageBitmap(paramRespEncounterInfo);
        return;
      }
      if (paramRespEncounterInfo.lEctID > 0L)
      {
        str = String.valueOf(paramRespEncounterInfo.lEctID);
        if (this.i)
        {
          localBoolean = (Boolean)this.h.get(Long.valueOf(paramRespEncounterInfo.lEctID));
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            this.h.put(Long.valueOf(paramRespEncounterInfo.lEctID), Boolean.valueOf(true));
            ((BaseActivity)this.a).app.execute(new ChatPushCarrierHelper.2(this, str, paramRespEncounterInfo));
          }
        }
        paramRespEncounterInfo = this.k.getBitmapFromCache(32, str, 200);
        if (paramRespEncounterInfo == null)
        {
          this.k.requestDecodeStrangeFace(str, 200, true, false);
          if (this.j == null) {
            this.j = ((BitmapDrawable)ImageUtil.m());
          }
          paramImageView.setImageDrawable(this.j);
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
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131435219);
    SingleLineTextView localSingleLineTextView1 = (SingleLineTextView)paramView.findViewById(2131447063);
    Object localObject4 = (ImageView)paramView.findViewById(2131428898);
    ImageView localImageView5 = (ImageView)paramView.findViewById(2131435640);
    Object localObject1 = (TextView)paramView.findViewById(2131447144);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131449927);
    SingleLineTextView localSingleLineTextView2 = (SingleLineTextView)paramView.findViewById(2131431661);
    Object localObject2 = (SingleLineTextView)paramView.findViewById(2131447382);
    Object localObject3 = paramView.findViewById(2131436549);
    TextView localTextView = (TextView)paramView.findViewById(2131439266);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131440088);
    ImageView localImageView4 = (ImageView)paramView.findViewById(2131430528);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131445477);
    View localView = paramView.findViewById(2131436667);
    paramView = (SingleLineTextView)paramView.findViewById(2131435792);
    this.a.getResources().getColor(2131168102);
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
        localImageView5.setBackgroundResource(2130847554);
        localObject4 = this.a.getResources().getDrawable(2130847146);
        ((TextView)localObject1).setBackgroundDrawable(BizTroopUtil.a(this.a.getResources(), -17883, (Drawable)localObject4));
        ((TextView)localObject1).setText(HardCodeUtil.a(2131899937));
      }
      else
      {
        localImageView5.setBackgroundResource(2130847554);
        localObject4 = this.a.getResources().getDrawable(2130847146);
        ((TextView)localObject1).setBackgroundDrawable(BizTroopUtil.a(this.a.getResources(), -17883, (Drawable)localObject4));
        ((TextView)localObject1).setText(HardCodeUtil.a(2131899940));
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
    int i2 = this.e - (int)(this.f * 189.0F);
    localObject1 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
    localObject2 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    localObject3 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
    double d1;
    if ((localObject3 != null) && (((VipOpenInfo)localObject3).bOpen)) {
      d1 = Math.ceil(this.f * 33.5F);
    }
    for (;;)
    {
      i1 = i2 - (int)d1;
      break;
      if ((localObject1 != null) && (((VipOpenInfo)localObject1).bOpen))
      {
        d1 = Math.ceil(this.f * 33.5F);
      }
      else
      {
        i1 = i2;
        if (localObject2 == null) {
          break;
        }
        i1 = i2;
        if (!((VipOpenInfo)localObject2).bOpen) {
          break;
        }
        d1 = Math.ceil(this.f * 28.5F);
      }
    }
    i2 = i1;
    if (paramRespEncounterInfo.authFlag == 1) {
      i2 = i1 - (int)Math.ceil(this.f * 20.0F);
    }
    int i1 = i2;
    if (paramRespEncounterInfo.watch_color != 0) {
      i1 = i2 - (int)Math.ceil(this.f * 16.0F);
    }
    localSingleLineTextView1.setMaxWidth(i1);
    localObject1 = new StringBuilder();
    i1 = paramRespEncounterInfo.cSex;
    if (i1 != 0)
    {
      if (i1 == 1) {
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
      ((StringBuilder)localObject1).append(com.tencent.mobileqq.util.NearbyProfileUtil.f[paramRespEncounterInfo.profession_id]);
    }
    if (((StringBuilder)localObject1).length() > 0)
    {
      paramView.setText(((StringBuilder)localObject1).toString());
      if (AppSetting.e) {
        paramView.setContentDescription(((StringBuilder)localObject1).toString());
      }
      paramView.setVisibility(0);
      i1 = 1;
    }
    else
    {
      paramView.setVisibility(8);
      i1 = 0;
    }
    if (paramRespEncounterInfo.charm_shown == 1)
    {
      if (localImageView4.getVisibility() != 0) {
        localImageView4.setVisibility(0);
      }
      i2 = paramRespEncounterInfo.charm_level;
      if (i2 != 4)
      {
        if (i2 != 5)
        {
          if (i2 != 6) {
            localImageView4.setImageResource(2130847060);
          } else {
            localImageView4.setImageResource(2130847064);
          }
        }
        else {
          localImageView4.setImageResource(2130847063);
        }
      }
      else {
        localImageView4.setImageResource(2130847062);
      }
      if (AppSetting.e) {
        localImageView4.setContentDescription(HardCodeUtil.a(2131899939));
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
      i1 += 1;
      localImageView3.setVisibility(0);
    }
    else
    {
      localImageView3.setVisibility(8);
    }
    if (i1 > 0) {
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
    int i1 = 0;
    while (i1 < paramList.size())
    {
      RespEncounterInfo localRespEncounterInfo = (RespEncounterInfo)paramList.get(i1);
      View localView = a(localRespEncounterInfo);
      if ((localView != null) && (localRespEncounterInfo != null)) {
        this.c.addView(localView, new LinearLayout.LayoutParams(-1, DisplayUtil.a(this.a, 84.0F)));
      }
      i1 += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (RespEncounterInfo)paramView.getTag();
    paramView = (FriendsManager)((BaseActivity)this.a).app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool;
    if (paramView != null) {
      bool = paramView.n(Long.toString(((RespEncounterInfo)localObject).lEctID));
    } else {
      bool = false;
    }
    Intent localIntent = new Intent(this.a, ChatActivity.class);
    localIntent.putExtra("uin", Long.toString(((RespEncounterInfo)localObject).lEctID));
    localIntent.putExtra("from_where_to_aio", "nearby_recommend_people");
    if (bool) {
      localIntent.putExtra("uintype", 0);
    } else {
      localIntent.putExtra("uintype", 1001);
    }
    localIntent.putExtra("rich_accost_sig", ((RespEncounterInfo)localObject).sig);
    paramView = this.a.getString(2131892072);
    if ("0".equals(String.valueOf(((RespEncounterInfo)localObject).cSex))) {
      paramView = String.format(paramView, new Object[] { HardCodeUtil.a(2131899938) });
    } else {
      paramView = String.format(paramView, new Object[] { HardCodeUtil.a(2131899936) });
    }
    ((INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class)).addGrayTipsMsg(((BaseActivity)this.a).app, Long.toString(((RespEncounterInfo)localObject).lEctID), Long.toString(((RespEncounterInfo)localObject).lEctID), paramView, 1001, true, true);
    ((BaseActivity)this.a).startActivity(localIntent);
    paramView = Long.toString(((RespEncounterInfo)localObject).lEctID);
    localObject = ((INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class)).getReasonTypeAndUins(((BaseActivity)this.a).app);
    ReportController.b(((BaseActivity)this.a).app, "CliOper", "", "", "0X80055FC", "0X80055FC", 0, 0, localObject[0], paramView, "", "");
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
      if (this.k.isPausing()) {
        return;
      }
      paramInt2 = this.c.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject2 = this.c.getChildAt(paramInt1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper
 * JD-Core Version:    0.7.0.1
 */