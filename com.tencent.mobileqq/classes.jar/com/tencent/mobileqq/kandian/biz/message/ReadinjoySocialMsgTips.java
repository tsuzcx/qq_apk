package com.tencent.mobileqq.kandian.biz.message;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl.Companion;
import com.tencent.mobileqq.kandian.glue.report.RIJMsgReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

public class ReadinjoySocialMsgTips
  implements ReadinjoySocialMsgUI
{
  private static Drawable k;
  private static Drawable l;
  private View a;
  private ReadInJoyHeadImageView b;
  private View c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private View.OnClickListener g;
  private Activity h;
  private KandianMsgBoxRedPntInfo i;
  private int j = 0;
  private int m;
  
  public ReadinjoySocialMsgTips(Activity paramActivity, View paramView)
  {
    this.h = paramActivity;
    this.a = paramView;
    d();
  }
  
  private void d()
  {
    k = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842705));
    l = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842706));
    this.a.setVisibility(8);
    this.b = ((ReadInJoyHeadImageView)this.a.findViewById(2131435219));
    this.b.setRound(true);
    this.b.setImagePlaceHolder(k);
    this.d = ((TextView)this.a.findViewById(2131431322));
    this.e = ((TextView)this.a.findViewById(2131438940));
    this.c = this.a.findViewById(2131446149);
    this.f = ((ImageView)this.a.findViewById(2131428790));
    this.a.setOnClickListener(new ReadinjoySocialMsgTips.1(this));
  }
  
  private String e()
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.addSessionId().addKandianMode().addKandianModeNew().addFolderStatus().addOS().addVersion();
    localReportR5Builder.addStringNotThrow("message_reddot_style", RIJMsgBoxUtils.b());
    try
    {
      localReportR5Builder.addType(Aladdin.getConfig(431).getIntegerFromString("msg_ui_style", 0));
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getReportR5] e = ");
      localStringBuilder.append(localJSONException);
      QLog.e("ReadinjoySocialMsgTips", 1, localStringBuilder.toString());
    }
    localReportR5Builder.addChannelId(this.m);
    return localReportR5Builder.build();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.g = paramOnClickListener;
  }
  
  public void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if ((paramKandianMsgBoxRedPntInfo != null) && (!paramKandianMsgBoxRedPntInfo.equals(this.i)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set msg info , count : ");
      ((StringBuilder)localObject).append(RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(paramKandianMsgBoxRedPntInfo));
      ((StringBuilder)localObject).append(", uin : ");
      ((StringBuilder)localObject).append(paramKandianMsgBoxRedPntInfo.mUin);
      ((StringBuilder)localObject).append(", seq : ");
      ((StringBuilder)localObject).append(paramKandianMsgBoxRedPntInfo.mSeq);
      QLog.d("ReadinjoySocialMsgTips", 2, ((StringBuilder)localObject).toString());
      this.j += 1;
      if (this.j % 2 == 0) {
        this.b.setImagePlaceHolder(l);
      } else {
        this.b.setImagePlaceHolder(k);
      }
      this.i = paramKandianMsgBoxRedPntInfo;
      if (this.i.mMsgType == 2)
      {
        if (!TextUtils.isEmpty(this.i.mIconUrl))
        {
          this.b.setImage(RIJConvertString2URL.b(this.i.mIconUrl));
        }
        else
        {
          localObject = (Animatable)this.b.getResources().getDrawable(2130844000);
          this.b.setImageDrawable((Drawable)localObject);
          if (this.i.canDoAnimation) {
            ((Animatable)localObject).start();
          }
        }
      }
      else if (!TextUtils.isEmpty(this.i.mIconUrl)) {
        this.b.setImage(RIJConvertString2URL.b(this.i.mIconUrl));
      } else if (this.i.mUin > 0L) {
        this.b.setHeadImgByUin(this.i.mUin);
      }
      if (Aladdin.getConfig(431).getIntegerFromString("msg_ui_style", 0) == 1)
      {
        this.d.setText(paramKandianMsgBoxRedPntInfo.mMsgText);
        this.e.setText(ReadInJoyHelper.e(RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(paramKandianMsgBoxRedPntInfo)));
        this.e.setVisibility(0);
        this.f.setImageResource(2130842160);
        this.f.clearColorFilter();
        ((LinearLayout.LayoutParams)this.c.getLayoutParams()).bottomMargin = 0;
      }
      else
      {
        localObject = this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ReadInJoyHelper.d(RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(paramKandianMsgBoxRedPntInfo)));
        localStringBuilder.append(HardCodeUtil.a(2131910297));
        ((TextView)localObject).setText(localStringBuilder.toString());
        this.e.setVisibility(8);
        this.f.setImageResource(2130844412);
        this.f.setColorFilter(this.a.getResources().getColor(2131165564), PorterDuff.Mode.SRC_IN);
        ((LinearLayout.LayoutParams)this.c.getLayoutParams()).bottomMargin = DisplayUtil.a(this.h, 8.0F);
      }
      this.i.canDoAnimation = false;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("210 msgInfo is null ! ");
    ((StringBuilder)localObject).append(paramKandianMsgBoxRedPntInfo);
    QLog.d("ReadinjoySocialMsgTips", 2, ((StringBuilder)localObject).toString());
  }
  
  public void b()
  {
    if ((this.a != null) && (this.i != null) && (RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(this.i) > 0))
    {
      this.a.setVisibility(0);
      String str = e();
      PublicAccountReportUtils.a(null, "", "0X800824A", "0X800824A", 0, 0, "", "", "", RIJMsgReport.a.a(str), false);
    }
  }
  
  public void c()
  {
    this.h = null;
    this.b = null;
    this.a = null;
    this.d = null;
    this.g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.ReadinjoySocialMsgTips
 * JD-Core Version:    0.7.0.1
 */