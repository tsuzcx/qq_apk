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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
import com.tencent.mobileqq.qroute.QRoute;
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
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  
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
  
  private long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() == 3) {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSubscribeID);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return 0L;
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a;
    if (((IReadInJoyModel)localObject).a() == 3)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (((IReadInJoyModel)localObject).a().mSubscribeInfoObj.bytes_test.has()) {
        try
        {
          String str = ((IReadInJoyModel)localObject).a().mSubscribeInfoObj.bytes_test.get().toStringUtf8();
          localObject = str;
          if (str.length() > 4) {
            localObject = str.substring(0, 4);
          }
          ((TextView)this.jdField_a_of_type_AndroidViewView).setText((CharSequence)localObject);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(((String)localObject).trim())))
          {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            return;
          }
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        catch (Exception localException)
        {
          QLog.w("ComponentHeaderSubscribe", 1, "read field error", localException);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((TextView)this.jdField_a_of_type_AndroidViewView).setText(HardCodeUtil.a(2131702456));
          return;
        }
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setText(HardCodeUtil.a(2131702474));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(RIJStringUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSubscribeName));
  }
  
  private void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ReadInJoyConstants.k);
    ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(a()).getBytes(), 2));
    localObject = ((StringBuilder)localObject).toString();
    ReadInJoyUtils.a(getContext(), (String)localObject);
    g();
  }
  
  private void g()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
        localJSONObject.put("feeds_source", RIJFeedsType.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()));
        localJSONObject.put("kandian_mode", RIJAppSetting.a());
        String str3 = RIJFeedsType.d(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a());
        if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c()))
        {
          String str1 = "0X8009357";
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", str1, str1, 0, 0, str3, "", "", localJSONObject.toString(), false);
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
    return LayoutInflater.from(paramContext).inflate(2131560160, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131376015));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376031));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378105);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    int i;
    if ((paramIReadInJoyModel.a()) && (paramIReadInJoyModel.a() == 3)) {
      i = 0;
    } else {
      i = 8;
    }
    setVisibility(i);
    if ((paramIReadInJoyModel.a()) && (paramIReadInJoyModel.a() == 3))
    {
      setImage();
      e();
      d();
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.setVisibility(8);
  }
  
  public void setImage()
  {
    long l = a();
    if (l != 0L) {
      if (RIJQQAppInterfaceUtil.a()) {
        this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, String.valueOf(l), 1));
      } else {
        this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(l));
      }
    }
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(new ComponentHeaderSubscribe.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderSubscribe
 * JD-Core Version:    0.7.0.1
 */