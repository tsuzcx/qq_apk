package com.tencent.mobileqq.kandian.biz.daily;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.FileUtils;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyShareView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyImageView;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDailyShareFragment
  extends PublicBaseFragment
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  ProteusItemView jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView;
  private DynamicItemViewHelper jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private String b;
  
  private Bitmap a(View paramView)
  {
    if ((paramView.getWidth() != 0) && (paramView.getHeight() != 0))
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      paramView.draw(localCanvas);
      return localBitmap;
    }
    QLog.e("ReadInJoyDailyShareFragment", 1, "can not createBitmap");
    return null;
  }
  
  private static String a(Date paramDate)
  {
    return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(paramDate);
  }
  
  private void a()
  {
    Object localObject1 = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((JSONObject)localObject1).optString("qr_code_url");
    localObject1 = null;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = TroopShareUtility.a((String)localObject2, getBaseActivity().getResources(), 540, 0, false);
    }
    if (localObject1 != null)
    {
      localObject2 = (ViewBase)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView.a().getViewIdMapping().get("id_kandian_share_qr_code");
      if ((localObject2 instanceof ReadInjoyImageView)) {
        ((ImageView)((ViewBase)localObject2).getNativeView()).setImageBitmap((Bitmap)localObject1);
      }
    }
  }
  
  private boolean a(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {
      return false;
    }
    try
    {
      ImageUtil.a(paramBitmap, new File(paramString));
      return true;
    }
    catch (IOException paramBitmap)
    {
      QLog.e("ReadInJoyDailyShareFragment", 1, paramBitmap, new Object[0]);
    }
    return false;
  }
  
  private void b()
  {
    ViewBase localViewBase = (ViewBase)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView.a().getViewIdMapping().get("id_share_choice");
    if ((localViewBase instanceof ReadInJoyShareView)) {
      ((ReadInJoyShareView)localViewBase).a(new ReadInJoyDailyShareFragment.1(this, localViewBase));
    }
  }
  
  private void c()
  {
    if (TextUtils.isEmpty(this.b))
    {
      View localView = ((ViewBase)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView.a().getViewIdMapping().get("id_check_container")).getNativeView();
      if (localView != null)
      {
        this.jdField_a_of_type_JavaLangString = AppConstants.SDCARD_IMG_SAVE;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("kandiandaily-");
        localStringBuilder.append(a(Calendar.getInstance().getTime()));
        localStringBuilder.append(".png");
        this.b = localStringBuilder.toString();
        FileUtils.a(new File(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_AndroidGraphicsBitmap = a(localView);
        a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.b);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getBaseActivity() != null) {
      paramBundle = getBaseActivity().getIntent();
    } else {
      paramBundle = null;
    }
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStringExtra("share_info_intent");
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramBundle);
        paramBundle = new StringBuilder();
        paramBundle.append("shareinfo is ");
        paramBundle.append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
        QLog.d("ReadInJoyDailyShareFragment", 1, paramBundle.toString());
      }
      catch (JSONException paramBundle)
      {
        QLog.e("ReadInJoyDailyShareFragment", 1, paramBundle, new Object[0]);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(getBaseActivity());
    ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(getBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper = new DynamicItemViewHelper();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
    RIJDtReportHelper.a.a(getBaseActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560169, paramViewGroup, false);
    paramViewGroup = (ScrollView)paramLayoutInflater.findViewById(2131377386);
    if (paramViewGroup != null)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper;
      if (paramBundle != null)
      {
        JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
        if (localJSONObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView = paramBundle.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localJSONObject);
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView;
          if (paramBundle != null)
          {
            paramViewGroup.addView(paramBundle, -1, -1);
          }
          else
          {
            getBaseActivity().finish();
            return paramLayoutInflater;
          }
        }
      }
    }
    a();
    b();
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyShareFragment
 * JD-Core Version:    0.7.0.1
 */