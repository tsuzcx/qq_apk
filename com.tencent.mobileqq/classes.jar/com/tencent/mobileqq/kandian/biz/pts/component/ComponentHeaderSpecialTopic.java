package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class ComponentHeaderSpecialTopic
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private KandianUrlImageView e;
  private TextView f;
  
  public ComponentHeaderSpecialTopic(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderSpecialTopic(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderSpecialTopic(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private URL a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.mHeaderIconUrl == null)
    {
      try
      {
        String str = ((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_icon_url.get();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject = null;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        QLog.w("ComponentHeaderSpecialTopic", 1, "ReadInJoyHeader special topic icon url empty");
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      Object localObject = RIJConvertString2URL.b((String)localObject);
      paramAbsBaseArticleInfo.mHeaderIconUrl = ((URL)localObject);
      return localObject;
    }
    return paramAbsBaseArticleInfo.mHeaderIconUrl;
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.d();
        localJSONObject.put("feeds_source", paramString);
        localJSONObject.put("kandian_mode", RIJAppSetting.b());
        String str = RIJFeedsType.m(this.a.a.k());
        if (ReadinjoyReportUtils.d(this.a.a.m()))
        {
          paramString = "0X8009357";
          PublicAccountReportUtils.a(null, "CliOper", "", "", paramString, paramString, 0, 0, str, "", "", localJSONObject.toString(), false);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = "0X800744D";
    }
  }
  
  private String b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      paramAbsBaseArticleInfo = ((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
      paramAbsBaseArticleInfo = null;
    }
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
      QLog.w("ComponentHeaderSpecialTopic", 1, "ReadInJoyHeader special topic title empty");
    }
    return paramAbsBaseArticleInfo;
  }
  
  private String c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      paramAbsBaseArticleInfo = ((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_jump_url.get();
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
      paramAbsBaseArticleInfo = null;
    }
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
      QLog.w("ComponentHeaderSpecialTopic", 1, "ReadInJoyHeader special topic url empty");
    }
    return paramAbsBaseArticleInfo;
  }
  
  private void e()
  {
    String str = c(this.a.a.k());
    if (!TextUtils.isEmpty(str)) {
      ReadInJoyUtils.a(getContext(), str);
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626194, this, true);
  }
  
  public void a()
  {
    super.a();
    setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.e = ((KandianUrlImageView)findViewById(2131444240));
    this.f = ((TextView)findViewById(2131444231));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    int i;
    if ((paramIReadInJoyModel.a()) && (paramIReadInJoyModel.b() == 1)) {
      i = 0;
    } else {
      i = 8;
    }
    setVisibility(i);
    if ((paramIReadInJoyModel.a()) && (paramIReadInJoyModel.b() == 1))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.k();
      if (paramIReadInJoyModel.b() != 1) {
        return;
      }
      paramIReadInJoyModel = a(localAbsBaseArticleInfo);
      if (paramIReadInJoyModel == null)
      {
        this.e.setVisibility(8);
      }
      else
      {
        this.e.setVisibility(0);
        ReadInJoyDisplayUtils.a(this.e, paramIReadInJoyModel, getContext());
      }
      this.f.setText(b(localAbsBaseArticleInfo));
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131444231) && (i != 2131444240))
    {
      if (paramView == this) {
        e();
      }
    }
    else {
      e();
    }
    a(RIJFeedsType.k(this.a.a.k()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderSpecialTopic
 * JD-Core Version:    0.7.0.1
 */