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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.ISearchListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559963, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      Drawable localDrawable = getResources().getDrawable(2130839396);
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
    XListView localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localXListView != null)
    {
      localXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131298921));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    }
  }
  
  private void c()
  {
    Object localObject = (ViewGroup)findViewById(2131376636);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131376752);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131369202);
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
    if (!NetworkUtil.isNetSupport(this))
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
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramCondFitUser.lUIN);
    ((StringBuilder)localObject1).append("");
    paramItemViewHolder.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramCondFitUser.strNick);
    localStringBuilder1.append(paramCondFitUser.strNick);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramCondFitUser.locDesc)[1];
    localObject1 = localObject2;
    if (((String)localObject2).equals("不限")) {
      localObject1 = "";
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String)localObject1);
    localObject1 = localObject2[1];
    if (((String)localObject1).equals("不限")) {
      localObject1 = localObject2[0];
    }
    localObject2 = localObject1;
    if (((String)localObject1).equals("不限")) {
      localObject2 = "";
    }
    int i = paramCondFitUser.cSex;
    int j = -15550475;
    if (i != 1)
    {
      if (i != 2)
      {
        localObject1 = "";
        i = 0;
      }
      else
      {
        i = 2130840547;
        j = -38511;
        localObject1 = HardCodeUtil.a(2131713582);
      }
    }
    else
    {
      i = 2130840548;
      localObject1 = HardCodeUtil.a(2131713563);
    }
    localStringBuilder1.append((String)localObject1);
    localStringBuilder1.append(String.format("%s岁", new Object[] { Long.valueOf(paramCondFitUser.dwAge) }));
    localStringBuilder1.append((String)localObject2);
    StringBuilder localStringBuilder2;
    if (i == 0)
    {
      paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setColorFormat(j);
      paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
      localObject1 = paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramCondFitUser.dwAge);
      localStringBuilder2.append("");
      ((InterestLabelTextView)localObject1).setText(localStringBuilder2.toString());
    }
    else
    {
      paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setColorFormat(j);
      paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
      localObject1 = paramItemViewHolder.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramCondFitUser.dwAge);
      localStringBuilder2.append("");
      ((InterestLabelTextView)localObject1).setText(localStringBuilder2.toString());
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bindView jobId=");
      ((StringBuilder)localObject1).append(paramCondFitUser.iOccupationId);
      QLog.i("SearchResultActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramCondFitUser.iOccupationId > 0) && (paramCondFitUser.iOccupationId < ConditionSearchManager.e.length - 1))
    {
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(ConditionSearchManager.e[paramCondFitUser.iOccupationId]);
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setColorFormat(ConditionSearchManager.b[paramCondFitUser.iOccupationId]);
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
      localStringBuilder1.append(ConditionSearchManager.e[paramCondFitUser.iOccupationId]);
    }
    else
    {
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(8);
    }
    if ((paramCondFitUser.cConstellationId > 0) && (paramCondFitUser.cConstellationId < ConditionSearchManager.c.length))
    {
      paramItemViewHolder.c.setText(ConditionSearchManager.c[paramCondFitUser.cConstellationId]);
      paramItemViewHolder.c.setColorFormat(-6065741);
      paramItemViewHolder.c.setVisibility(0);
      localStringBuilder1.append(ConditionSearchManager.c[paramCondFitUser.cConstellationId]);
    }
    else
    {
      paramItemViewHolder.c.setVisibility(8);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramItemViewHolder.d.setVisibility(0);
      paramItemViewHolder.d.setText((CharSequence)localObject2);
      paramItemViewHolder.d.setColorFormat(-8291118);
    }
    else
    {
      paramItemViewHolder.d.setVisibility(8);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramItemViewHolder.jdField_a_of_type_JavaLangString);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = ImageUtil.f();
      localObject1 = localObject2;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramItemViewHolder.jdField_a_of_type_JavaLangString, 1, true, (byte)1);
        localObject1 = localObject2;
      }
    }
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramCondFitUser.personalSignature);
    localStringBuilder1.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
    localObject1 = new StringBuilder("bindview | uin:");
    ((StringBuilder)localObject1).append(paramCondFitUser.lUIN);
    ((StringBuilder)localObject1).append("| nickname:");
    ((StringBuilder)localObject1).append(paramCondFitUser.strNick);
    ((StringBuilder)localObject1).append("| sex:");
    ((StringBuilder)localObject1).append(paramCondFitUser.cSex);
    ((StringBuilder)localObject1).append("| age:");
    ((StringBuilder)localObject1).append(paramCondFitUser.dwAge);
    ((StringBuilder)localObject1).append("| country:");
    ((StringBuilder)localObject1).append(paramCondFitUser.dwCountry);
    ((StringBuilder)localObject1).append("| province:");
    ((StringBuilder)localObject1).append(paramCondFitUser.dwProvince);
    ((StringBuilder)localObject1).append("| city:");
    ((StringBuilder)localObject1).append(paramCondFitUser.dwCity);
    ((StringBuilder)localObject1).append("| occupation:");
    ((StringBuilder)localObject1).append(paramCondFitUser.iOccupationId);
    ((StringBuilder)localObject1).append("| horoscope:");
    ((StringBuilder)localObject1).append(paramCondFitUser.cConstellationId);
    ((StringBuilder)localObject1).append("| sign:");
    ((StringBuilder)localObject1).append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultActivity", 2, ((StringBuilder)localObject1).toString());
    }
    return localStringBuilder1.toString();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
    if (localObject != null) {
      ((ConditionSearchManager)localObject).d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null)
    {
      boolean bool = localObject1 instanceof SearchResultActivity.ItemViewHolder;
      int i = 1;
      if (bool)
      {
        localObject1 = (SearchResultActivity.ItemViewHolder)localObject1;
        if (this.app.getCurrentAccountUin().equals(((SearchResultActivity.ItemViewHolder)localObject1).jdField_a_of_type_JavaLangString))
        {
          i = 0;
        }
        else
        {
          localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if ((localObject2 == null) || (!((FriendsManager)localObject2).b(((SearchResultActivity.ItemViewHolder)localObject1).jdField_a_of_type_JavaLangString))) {
            i = 75;
          }
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8006F0C", "0X8006F0C", 0, 0, "", "", "", "");
        Object localObject2 = new AllInOne(((SearchResultActivity.ItemViewHolder)localObject1).jdField_a_of_type_JavaLangString, i);
        ((AllInOne)localObject2).nickname = ((SearchResultActivity.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.getText().toString();
        ((AllInOne)localObject2).profileEntryType = 87;
        ProfileUtils.openProfileCard(this, (AllInOne)localObject2);
      }
      else if ((localObject1 instanceof SearchResultActivity.MoreViewHolder))
      {
        i = this.jdField_b_of_type_Int;
        if ((i == 3) || (i == 4))
        {
          this.jdField_b_of_type_Int = 1;
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchSearchResultActivity$DataAdapter.notifyDataSetChanged();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.SearchResultActivity
 * JD-Core Version:    0.7.0.1
 */