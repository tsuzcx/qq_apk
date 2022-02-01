package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;

public class ComponentHeaderSubscribe
  extends ComponentHeaderBase
{
  private FixSizeImageView e;
  private TextView f;
  private View g;
  
  public ComponentHeaderSubscribe(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderSubscribe(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderSubscribe(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void e()
  {
    Object localObject = this.a.a;
    if (((IReadInJoyModel)localObject).b() == 3)
    {
      this.g.setVisibility(0);
      if (((IReadInJoyModel)localObject).k().mSubscribeInfoObj.bytes_test.has()) {
        try
        {
          String str = ((IReadInJoyModel)localObject).k().mSubscribeInfoObj.bytes_test.get().toStringUtf8();
          localObject = str;
          if (str.length() > 4) {
            localObject = str.substring(0, 4);
          }
          ((TextView)this.g).setText((CharSequence)localObject);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(((String)localObject).trim())))
          {
            this.g.setVisibility(0);
            return;
          }
          this.g.setVisibility(8);
          return;
        }
        catch (Exception localException)
        {
          QLog.w("ComponentHeaderSubscribe", 1, "read field error", localException);
          this.g.setVisibility(0);
          ((TextView)this.g).setText(HardCodeUtil.a(2131900458));
          return;
        }
      }
      this.g.setVisibility(0);
      ((TextView)this.g).setText(HardCodeUtil.a(2131900476));
      return;
    }
    this.g.setVisibility(8);
  }
  
  private void f()
  {
    this.f.setText(RIJStringUtils.a(this.a.a.k().mSubscribeName));
  }
  
  private void g()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ReadInJoyConstants.l);
    ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(getUin()).getBytes(), 2));
    localObject = ((StringBuilder)localObject).toString();
    ReadInJoyUtils.a(getContext(), (String)localObject);
    h();
  }
  
  private long getUin()
  {
    if (this.a.a.b() == 3) {
      try
      {
        long l = Long.parseLong(this.a.a.k().mSubscribeID);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return 0L;
  }
  
  private void h()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.d();
        localJSONObject.put("feeds_source", RIJFeedsType.k(this.a.a.k()));
        localJSONObject.put("kandian_mode", RIJAppSetting.b());
        String str3 = RIJFeedsType.m(this.a.a.k());
        if (ReadinjoyReportUtils.d(this.a.a.m()))
        {
          String str1 = "0X8009357";
          PublicAccountReportUtils.a(null, "CliOper", "", "", str1, str1, 0, 0, str3, "", "", localJSONObject.toString(), false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      String str2 = "0X800744D";
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626207, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.e = ((FixSizeImageView)findViewById(2131444215));
    this.f = ((TextView)findViewById(2131444231));
    this.g = findViewById(2131446611);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    int i;
    if ((paramIReadInJoyModel.a()) && (paramIReadInJoyModel.b() == 3)) {
      i = 0;
    } else {
      i = 8;
    }
    setVisibility(i);
    if ((paramIReadInJoyModel.a()) && (paramIReadInJoyModel.b() == 3))
    {
      setImage();
      f();
      e();
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
  }
  
  public void b()
  {
    super.b();
    this.d.setVisibility(8);
  }
  
  public void setImage()
  {
    long l = getUin();
    if (l != 0L) {
      if (RIJQQAppInterfaceUtil.g()) {
        this.e.setImageDrawable(SearchUtils.a(this.c, String.valueOf(l), 1));
      } else {
        this.e.setImageBitmap(this.b.d(l));
      }
    }
    this.e.setOnClickListener(new ComponentHeaderSubscribe.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderSubscribe
 * JD-Core Version:    0.7.0.1
 */