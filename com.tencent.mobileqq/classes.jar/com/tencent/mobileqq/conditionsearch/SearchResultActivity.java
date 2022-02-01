package com.tencent.mobileqq.conditionsearch;

import Override;
import SummaryCard.CondFitUser;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import anrz;
import ansf;
import anvk;
import anvx;
import aqty;
import aqtz;
import aqua;
import aqub;
import aquc;
import aqud;
import bbvn;
import bdla;
import bhdz;
import bheg;
import bkys;
import bldp;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchResultActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  public static final boolean a;
  private static List<CondFitUser> b;
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aqty(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  anrz jdField_a_of_type_Anrz;
  ansf jdField_a_of_type_Ansf = new aqua(this);
  public aqub a;
  bbvn jdField_a_of_type_Bbvn;
  private bldp jdField_a_of_type_Bldp = new aqtz(this);
  FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public XListView a;
  public List<CondFitUser> a;
  Set<Long> jdField_a_of_type_JavaUtilSet;
  public int b;
  private int c;
  
  static
  {
    jdField_a_of_type_Boolean = AppSetting.c;
  }
  
  public SearchResultActivity()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131560016, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      Drawable localDrawable = getResources().getDrawable(2130839461);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setHeaderBgDrawable(localDrawable);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt4, int paramInt5, List<CondFitUser> paramList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, SearchResultActivity.class);
    localIntent.putExtra("key_keyword", paramString);
    localIntent.putExtra("key_age_index1", paramInt1);
    localIntent.putExtra("key_age_index2", paramInt2);
    localIntent.putExtra("key_sex_index", paramInt3);
    localIntent.putExtra("key_loc_code", paramArrayOfString1);
    localIntent.putExtra("key_home_code", paramArrayOfString2);
    localIntent.putExtra("key_xingzuo_index", paramInt5);
    localIntent.putExtra("key_job_index", paramInt4);
    localIntent.putExtra("key_has_more", paramBoolean);
    jdField_b_of_type_JavaUtilList = paramList;
    paramContext.startActivity(localIntent);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131298830));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_Bldp);
    }
  }
  
  private void c()
  {
    Object localObject = (ViewGroup)findViewById(2131376760);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131376890);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131369231);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Anrz.c(this.jdField_a_of_type_Ansf);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("key_keyword");
    int i = localIntent.getIntExtra("key_age_index1", 0);
    int j = localIntent.getIntExtra("key_age_index2", 0);
    int k = localIntent.getIntExtra("key_sex_index", 0);
    String[] arrayOfString1 = localIntent.getStringArrayExtra("key_loc_code");
    String[] arrayOfString2 = localIntent.getStringArrayExtra("key_home_code");
    int m = localIntent.getIntExtra("key_xingzuo_index", 0);
    int n = localIntent.getIntExtra("key_job_index", 0);
    this.jdField_a_of_type_Anrz.a(true, str, k, i, j, arrayOfString1, arrayOfString2, n, m, 2);
  }
  
  private void e()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      this.jdField_b_of_type_Int = 4;
      this.jdField_a_of_type_Aqub.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Anrz.c(this.jdField_a_of_type_Ansf);
    try
    {
      this.jdField_a_of_type_Anrz.a(false, null, 0, 0, 0, null, null, 0, 0, 3);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchResultActivity", 2, localException, new Object[0]);
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Aqub.notifyDataSetChanged();
    }
  }
  
  public String a(aquc paramaquc, CondFitUser paramCondFitUser)
  {
    int j = -15550475;
    StringBuilder localStringBuilder = new StringBuilder();
    paramaquc.jdField_a_of_type_JavaLangString = (paramCondFitUser.lUIN + "");
    paramaquc.jdField_a_of_type_AndroidWidgetTextView.setText(paramCondFitUser.strNick);
    localStringBuilder.append(paramCondFitUser.strNick);
    Object localObject2 = this.jdField_a_of_type_Anrz.a(paramCondFitUser.locDesc)[1];
    Object localObject1 = localObject2;
    if (((String)localObject2).equals("不限")) {
      localObject1 = "";
    }
    String[] arrayOfString = this.jdField_a_of_type_Anrz.a((String)localObject1);
    localObject2 = arrayOfString[1];
    localObject1 = localObject2;
    if (((String)localObject2).equals("不限")) {
      localObject1 = arrayOfString[0];
    }
    localObject2 = localObject1;
    if (((String)localObject1).equals("不限")) {
      localObject2 = "";
    }
    localObject1 = "";
    int i;
    switch (paramCondFitUser.cSex)
    {
    default: 
      i = 0;
      localStringBuilder.append((String)localObject1).append(String.format("%s岁", new Object[] { Long.valueOf(paramCondFitUser.dwAge) })).append((String)localObject2);
      if (i == 0)
      {
        paramaquc.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setColorFormat(j);
        paramaquc.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
        paramaquc.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(paramCondFitUser.dwAge + "");
        label273:
        if (QLog.isColorLevel()) {
          QLog.i("SearchResultActivity", 2, "bindView jobId=" + paramCondFitUser.iOccupationId);
        }
        if ((paramCondFitUser.iOccupationId <= 0) || (paramCondFitUser.iOccupationId >= anrz.e.length - 1)) {
          break label872;
        }
        paramaquc.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(anrz.e[paramCondFitUser.iOccupationId]);
        paramaquc.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setColorFormat(anrz.b[paramCondFitUser.iOccupationId]);
        paramaquc.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
        localStringBuilder.append(anrz.e[paramCondFitUser.iOccupationId]);
        label380:
        if ((paramCondFitUser.cConstellationId <= 0) || (paramCondFitUser.cConstellationId >= anrz.c.length)) {
          break label884;
        }
        paramaquc.c.setText(anrz.c[paramCondFitUser.cConstellationId]);
        paramaquc.c.setColorFormat(-6065741);
        paramaquc.c.setVisibility(0);
        localStringBuilder.append(anrz.c[paramCondFitUser.cConstellationId]);
        label445:
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label896;
        }
        paramaquc.d.setVisibility(0);
        paramaquc.d.setText((CharSequence)localObject2);
        paramaquc.d.setColorFormat(-8291118);
      }
      break;
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramaquc.jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = bheg.a();
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramaquc.jdField_a_of_type_JavaLangString, 1, true, (byte)1);
          localObject1 = localObject2;
        }
      }
      paramaquc.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      paramaquc.jdField_b_of_type_AndroidWidgetTextView.setText(paramCondFitUser.personalSignature);
      localStringBuilder.append(paramaquc.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
      localObject1 = new StringBuilder("bindview | uin:");
      ((StringBuilder)localObject1).append(paramCondFitUser.lUIN);
      ((StringBuilder)localObject1).append("| nickname:").append(paramCondFitUser.strNick);
      ((StringBuilder)localObject1).append("| sex:").append(paramCondFitUser.cSex);
      ((StringBuilder)localObject1).append("| age:").append(paramCondFitUser.dwAge);
      ((StringBuilder)localObject1).append("| country:").append(paramCondFitUser.dwCountry);
      ((StringBuilder)localObject1).append("| province:").append(paramCondFitUser.dwProvince);
      ((StringBuilder)localObject1).append("| city:").append(paramCondFitUser.dwCity);
      ((StringBuilder)localObject1).append("| occupation:").append(paramCondFitUser.iOccupationId);
      ((StringBuilder)localObject1).append("| horoscope:").append(paramCondFitUser.cConstellationId);
      ((StringBuilder)localObject1).append("| sign:").append(paramaquc.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
      if (QLog.isColorLevel()) {
        QLog.d("SearchResultActivity", 2, ((StringBuilder)localObject1).toString());
      }
      return localStringBuilder.toString();
      i = 2130840536;
      localObject1 = anvx.a(2131713100);
      break;
      i = 2130840535;
      j = -38511;
      localObject1 = anvx.a(2131713119);
      break;
      paramaquc.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setColorFormat(j);
      paramaquc.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      paramaquc.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
      paramaquc.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(paramCondFitUser.dwAge + "");
      break label273;
      label872:
      paramaquc.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(8);
      break label380;
      label884:
      paramaquc.c.setVisibility(8);
      break label445;
      label896:
      paramaquc.d.setVisibility(8);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561063);
    setContentBackgroundResource(2130838911);
    setTitle(2131691031);
    setLeftViewName(2131690676);
    c();
    this.jdField_a_of_type_AndroidOsHandler = new bkys(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (getIntent().getBooleanExtra("key_has_more", false)) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_JavaUtilList = jdField_b_of_type_JavaUtilList;
      jdField_b_of_type_JavaUtilList = null;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
        break;
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Bbvn = ((bbvn)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_Anrz = ((anrz)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.c = ((int)bhdz.a(this, 12.0F));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131376947));
    this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
    try
    {
      a();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      this.jdField_a_of_type_Aqub = new aqub(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aqub);
      return true;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchResultActivity", 2, "infate failure:", paramBundle);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
    }
    if (this.jdField_a_of_type_Anrz != null) {
      this.jdField_a_of_type_Anrz.d(this.jdField_a_of_type_Ansf);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    int i;
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof aquc)) {
        break label165;
      }
      localObject1 = (aquc)localObject1;
      if (!this.app.getCurrentAccountUin().equals(((aquc)localObject1).jdField_a_of_type_JavaLangString)) {
        break label128;
      }
      i = 0;
    }
    for (;;)
    {
      bdla.b(this.app, "CliOper", "", "", "0X8006F0C", "0X8006F0C", 0, 0, "", "", "", "");
      Object localObject2 = new ProfileActivity.AllInOne(((aquc)localObject1).jdField_a_of_type_JavaLangString, i);
      ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((aquc)localObject1).jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 87;
      ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject2);
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label128:
        localObject2 = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localObject2 == null) || (!((anvk)localObject2).b(((aquc)localObject1).jdField_a_of_type_JavaLangString))) {
          break label203;
        }
        i = 1;
        break;
        label165:
        if (((localObject1 instanceof aqud)) && ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 4)))
        {
          this.jdField_b_of_type_Int = 1;
          this.jdField_a_of_type_Aqub.notifyDataSetChanged();
        }
      }
      label203:
      i = 75;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Int == 0))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof aquc)))
        {
          localObject = (aquc)localObject;
          if (((aquc)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
            ((aquc)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
    }
    this.jdField_a_of_type_Aqub.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.SearchResultActivity
 * JD-Core Version:    0.7.0.1
 */