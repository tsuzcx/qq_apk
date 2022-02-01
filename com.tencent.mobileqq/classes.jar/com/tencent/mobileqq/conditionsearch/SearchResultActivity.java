package com.tencent.mobileqq.conditionsearch;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.ISearchListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchResultActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  static final boolean jdField_a_of_type_Boolean = AppSetting.d;
  private static List<CondFitUser> jdField_b_of_type_JavaUtilList = null;
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new SearchResultActivity.1(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  ConditionSearchManager.ISearchListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener = new SearchResultActivity.3(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  SearchResultActivity.DataAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$DataAdapter;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new SearchResultActivity.2(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  List<CondFitUser> jdField_a_of_type_JavaUtilList;
  Set<Long> jdField_a_of_type_JavaUtilSet;
  int jdField_b_of_type_Int = 0;
  private int c;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131560092, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      Drawable localDrawable = getResources().getDrawable(2130839540);
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
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131298917));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    }
  }
  
  private void c()
  {
    Object localObject = (ViewGroup)findViewById(2131377159);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131377297);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131369487);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("key_keyword");
    int i = localIntent.getIntExtra("key_age_index1", 0);
    int j = localIntent.getIntExtra("key_age_index2", 0);
    int k = localIntent.getIntExtra("key_sex_index", 0);
    String[] arrayOfString1 = localIntent.getStringArrayExtra("key_loc_code");
    String[] arrayOfString2 = localIntent.getStringArrayExtra("key_home_code");
    int m = localIntent.getIntExtra("key_xingzuo_index", 0);
    int n = localIntent.getIntExtra("key_job_index", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(true, str, k, i, j, arrayOfString1, arrayOfString2, n, m, 2);
  }
  
  private void e()
  {
    if (!NetworkUtil.d(this))
    {
      this.jdField_b_of_type_Int = 4;
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$DataAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(false, null, 0, 0, 0, null, null, 0, 0, 3);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchResultActivity", 2, localException, new Object[0]);
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$DataAdapter.notifyDataSetChanged();
    }
  }
  
  String a(SearchResultActivity.ItemViewHolder paramItemViewHolder, CondFitUser paramCondFitUser)
  {
    int j = -15550475;
    StringBuilder localStringBuilder = new StringBuilder();
    paramItemViewHolder.jdField_a_of_type_JavaLangString = (paramCondFitUser.lUIN + "");
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramCondFitUser.strNick);
    localStringBuilder.append(paramCondFitUser.strNick);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramCondFitUser.locDesc)[1];
    Object localObject1 = localObject2;
    if (((String)localObject2).equals("不限")) {
      localObject1 = "";
    }
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String)localObject1);
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
        paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setColorFormat(j);
        paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
        paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(paramCondFitUser.dwAge + "");
        label273:
        if (QLog.isColorLevel()) {
          QLog.i("SearchResultActivity", 2, "bindView jobId=" + paramCondFitUser.iOccupationId);
        }
        if ((paramCondFitUser.iOccupationId <= 0) || (paramCondFitUser.iOccupationId >= ConditionSearchManager.e.length - 1)) {
          break label878;
        }
        paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(ConditionSearchManager.e[paramCondFitUser.iOccupationId]);
        paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setColorFormat(ConditionSearchManager.b[paramCondFitUser.iOccupationId]);
        paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
        localStringBuilder.append(ConditionSearchManager.e[paramCondFitUser.iOccupationId]);
        label380:
        if ((paramCondFitUser.cConstellationId <= 0) || (paramCondFitUser.cConstellationId >= ConditionSearchManager.c.length)) {
          break label890;
        }
        paramItemViewHolder.c.setText(ConditionSearchManager.c[paramCondFitUser.cConstellationId]);
        paramItemViewHolder.c.setColorFormat(-6065741);
        paramItemViewHolder.c.setVisibility(0);
        localStringBuilder.append(ConditionSearchManager.c[paramCondFitUser.cConstellationId]);
        label445:
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label902;
        }
        paramItemViewHolder.d.setVisibility(0);
        paramItemViewHolder.d.setText((CharSequence)localObject2);
        paramItemViewHolder.d.setColorFormat(-8291118);
      }
      break;
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramItemViewHolder.jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = ImageUtil.c();
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramItemViewHolder.jdField_a_of_type_JavaLangString, 1, true, (byte)1);
          localObject1 = localObject2;
        }
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramCondFitUser.personalSignature);
      localStringBuilder.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
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
      ((StringBuilder)localObject1).append("| sign:").append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
      if (QLog.isColorLevel()) {
        QLog.d("SearchResultActivity", 2, ((StringBuilder)localObject1).toString());
      }
      return localStringBuilder.toString();
      i = 2130840673;
      localObject1 = HardCodeUtil.a(2131713596);
      break;
      i = 2130840672;
      j = -38511;
      localObject1 = HardCodeUtil.a(2131713615);
      break;
      paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setColorFormat(j);
      paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
      paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(paramCondFitUser.dwAge + "");
      break label273;
      label878:
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(8);
      break label380;
      label890:
      paramItemViewHolder.c.setVisibility(8);
      break label445;
      label902:
      paramItemViewHolder.d.setVisibility(8);
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
    setContentView(2131561151);
    setContentBackgroundResource(2130838979);
    setTitle(2131691138);
    setLeftViewName(2131690778);
    c();
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
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
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.c = ((int)DisplayUtils.a(this, 12.0F));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377356));
    this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
    try
    {
      a();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$DataAdapter = new SearchResultActivity.DataAdapter(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$DataAdapter);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    int i;
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof SearchResultActivity.ItemViewHolder)) {
        break label165;
      }
      localObject1 = (SearchResultActivity.ItemViewHolder)localObject1;
      if (!this.app.getCurrentAccountUin().equals(((SearchResultActivity.ItemViewHolder)localObject1).jdField_a_of_type_JavaLangString)) {
        break label128;
      }
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8006F0C", "0X8006F0C", 0, 0, "", "", "", "");
      Object localObject2 = new ProfileActivity.AllInOne(((SearchResultActivity.ItemViewHolder)localObject1).jdField_a_of_type_JavaLangString, i);
      ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((SearchResultActivity.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 87;
      ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject2);
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label128:
        localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localObject2 == null) || (!((FriendsManager)localObject2).b(((SearchResultActivity.ItemViewHolder)localObject1).jdField_a_of_type_JavaLangString))) {
          break label203;
        }
        i = 1;
        break;
        label165:
        if (((localObject1 instanceof SearchResultActivity.MoreViewHolder)) && ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 4)))
        {
          this.jdField_b_of_type_Int = 1;
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$DataAdapter.notifyDataSetChanged();
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
        if ((localObject != null) && ((localObject instanceof SearchResultActivity.ItemViewHolder)))
        {
          localObject = (SearchResultActivity.ItemViewHolder)localObject;
          if (((SearchResultActivity.ItemViewHolder)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
            ((SearchResultActivity.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$DataAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.SearchResultActivity
 * JD-Core Version:    0.7.0.1
 */