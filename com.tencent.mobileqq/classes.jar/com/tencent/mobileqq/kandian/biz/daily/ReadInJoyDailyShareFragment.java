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
  ProteusItemView a;
  private JSONObject b;
  private VafContext c;
  private DynamicItemViewHelper d;
  private String e;
  private Bitmap f;
  private String g;
  
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
    Object localObject1 = this.b;
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
      localObject2 = (ViewBase)this.a.getContainer().getViewIdMapping().get("id_kandian_share_qr_code");
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
    ViewBase localViewBase = (ViewBase)this.a.getContainer().getViewIdMapping().get("id_share_choice");
    if ((localViewBase instanceof ReadInJoyShareView)) {
      ((ReadInJoyShareView)localViewBase).a(new ReadInJoyDailyShareFragment.1(this, localViewBase));
    }
  }
  
  private void c()
  {
    if (TextUtils.isEmpty(this.g))
    {
      View localView = ((ViewBase)this.a.getContainer().getViewIdMapping().get("id_check_container")).getNativeView();
      if (localView != null)
      {
        this.e = AppConstants.SDCARD_IMG_SAVE;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.e);
        localStringBuilder.append("kandiandaily-");
        localStringBuilder.append(a(Calendar.getInstance().getTime()));
        localStringBuilder.append(".png");
        this.g = localStringBuilder.toString();
        FileUtils.a(new File(this.e));
        this.f = a(localView);
        a(this.f, this.g);
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
        this.b = new JSONObject(paramBundle);
        paramBundle = new StringBuilder();
        paramBundle.append("shareinfo is ");
        paramBundle.append(this.b.toString());
        QLog.d("ReadInJoyDailyShareFragment", 1, paramBundle.toString());
      }
      catch (JSONException paramBundle)
      {
        QLog.e("ReadInJoyDailyShareFragment", 1, paramBundle, new Object[0]);
      }
    }
    this.c = new ReadInjoyContext();
    this.c.setContext(getBaseActivity());
    ProteusSupportUtil.a(this.c, "default_feeds");
    this.c.setCurActivity(getBaseActivity());
    this.d = new DynamicItemViewHelper();
    this.d.a(this.c);
    RIJDtReportHelper.a.a(getBaseActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131626216, paramViewGroup, false);
    paramViewGroup = (ScrollView)paramLayoutInflater.findViewById(2131445785);
    if (paramViewGroup != null)
    {
      paramBundle = this.d;
      if (paramBundle != null)
      {
        JSONObject localJSONObject = this.b;
        if (localJSONObject != null)
        {
          this.a = paramBundle.a(this.c, localJSONObject);
          paramBundle = this.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyShareFragment
 * JD-Core Version:    0.7.0.1
 */