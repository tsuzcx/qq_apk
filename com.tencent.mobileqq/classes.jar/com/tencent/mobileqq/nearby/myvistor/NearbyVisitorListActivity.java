package com.tencent.mobileqq.nearby.myvistor;

import aezz;
import afaa;
import afac;
import afae;
import afaf;
import afag;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.IIconDecoder;
import com.tencent.mobileqq.util.IIconDecoder.IIconListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView.OnScrollChangeListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.List;

public class NearbyVisitorListActivity
  extends NearbyTitleBarActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, ListView.OnScrollChangeListener
{
  public int a;
  public long a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afae(this);
  View jdField_a_of_type_AndroidViewView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  NearbyHandler jdField_a_of_type_ComTencentMobileqqAppNearbyHandler;
  private NearbyObserver jdField_a_of_type_ComTencentMobileqqAppNearbyObserver = new afac(this);
  NearbyVisitorAdapter jdField_a_of_type_ComTencentMobileqqNearbyMyvistorNearbyVisitorAdapter;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private IIconDecoder.IIconListener jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder$IIconListener = new afag(this);
  public IIconDecoder a;
  public PullRefreshHeader a;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new afaf(this);
  public PinnedHeaderExpandableListView a;
  String jdField_a_of_type_JavaLangString;
  public List a;
  public boolean a;
  public byte[] a;
  int jdField_b_of_type_Int = 0;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  public boolean b;
  int jdField_c_of_type_Int;
  public long c;
  View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  public long d;
  View d;
  View e;
  View f;
  
  public NearbyVisitorListActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_Int = 0;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {}
    View localView;
    TextView localTextView2;
    ViewGroup.LayoutParams localLayoutParams;
    label199:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Int = paramInt;
          if (b()) {
            break label408;
          }
          localTextView1 = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370568);
          localView = this.jdField_c_of_type_AndroidViewView.findViewById(2131370569);
          localTextView2 = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370570);
          localView.setOnClickListener(this);
          localLayoutParams = this.jdField_c_of_type_AndroidViewView.getLayoutParams();
          localLayoutParams.height = DisplayUtil.a(this, 122.0F);
          if (paramInt != 1) {
            break label199;
          }
          if (this.jdField_c_of_type_Int > 3) {
            break;
          }
          localTextView1.setVisibility(8);
          localView.setVisibility(0);
          localLayoutParams.height = DisplayUtil.a(this, 61.0F);
          localTextView2.setText(2131438325);
        } while (!AppSetting.jdField_b_of_type_Boolean);
        localTextView1.setContentDescription(getString(2131438327));
        localView.setContentDescription(getString(2131438325) + "，连按两次来打开");
        return;
        localTextView1.setVisibility(8);
        localView.setVisibility(8);
      } while (!AppSetting.jdField_b_of_type_Boolean);
      localTextView1.setContentDescription(getString(2131438326));
      return;
    } while (paramInt != 2);
    if (this.jdField_c_of_type_Int <= 3)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() < 20)
      {
        localTextView1.setText(2131438326);
        localTextView2.setText(2131438325);
      }
      for (;;)
      {
        localView.setVisibility(0);
        localTextView1.setVisibility(0);
        if (!AppSetting.jdField_b_of_type_Boolean) {
          break;
        }
        localTextView1.setContentDescription(localTextView1.getText());
        localView.setContentDescription(getString(2131438324) + "，连按两次来打开");
        return;
        localTextView1.setText(getString(2131438323, new Object[] { Integer.valueOf(20) }));
        localTextView2.setText(2131438324);
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() < 200) {
      localTextView1.setText(2131438326);
    }
    for (;;)
    {
      localTextView1.setVisibility(0);
      localView.setVisibility(8);
      localLayoutParams.height = DisplayUtil.a(this, 61.0F);
      if (!AppSetting.jdField_b_of_type_Boolean) {
        break;
      }
      localTextView1.setContentDescription(localTextView1.getText());
      return;
      localTextView1.setText(getString(2131438322, new Object[] { Integer.valueOf(200) }));
    }
    label408:
    TextView localTextView1 = (TextView)this.e.findViewById(2131370564);
    ((TextView)this.e.findViewById(2131370565)).setOnClickListener(this);
    localTextView1.setText(a(this.jdField_b_of_type_Long));
  }
  
  private void a(boolean paramBoolean)
  {
    int j = 8;
    TextView localTextView = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131365010);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_d_of_type_AndroidViewView.findViewById(2131363054);
    ImageView localImageView = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131365199);
    if (paramBoolean)
    {
      i = 2131436558;
      localTextView.setText(i);
      if (!paramBoolean) {
        break label89;
      }
      i = 0;
      label64:
      localProgressBar.setVisibility(i);
      if (!paramBoolean) {
        break label95;
      }
    }
    label89:
    label95:
    for (int i = j;; i = 0)
    {
      localImageView.setVisibility(i);
      return;
      i = 2131433953;
      break;
      i = 8;
      break label64;
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      QQToast.a(this, getString(2131438440), 0).b(getTitleBarHeight());
      return;
    }
    if (!NetworkUtil.d(this))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.springBackOverScrollHeaderView();
      QQToast.a(this, 1, getString(2131434365), 0).b(getTitleBarHeight());
    }
    startTitleProgress();
    if (!paramBoolean1) {
      a(true);
    }
    this.jdField_b_of_type_Boolean = true;
    if (paramBoolean1) {
      this.jdField_a_of_type_ArrayOfByte = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(NearbyDataManager.a, this.jdField_a_of_type_ArrayOfByte);
  }
  
  private void c()
  {
    ThreadManager.postImmediately(new afaa(this), null, true);
  }
  
  private void d()
  {
    String str;
    if (this.jdField_b_of_type_Long > 0L)
    {
      if (this.centerView.getVisibility() == 0) {
        this.centerView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.jdField_b_of_type_Long <= 99999L)
      {
        str = String.format(getString(2131438441), new Object[] { Long.valueOf(this.jdField_b_of_type_Long) });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label180;
      }
      startTitleProgress();
      return;
      str = String.format(getString(2131438442), new Object[] { Float.valueOf((float)this.jdField_b_of_type_Long / 10000.0F) });
      break;
      if (this.centerView.getVisibility() == 8) {
        this.centerView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    label180:
    stopTitleProgress();
  }
  
  public SpannableString a(long paramLong)
  {
    String str = String.valueOf(paramLong - 4L);
    SpannableString localSpannableString = new SpannableString("还有" + str + "人\n是你的访客");
    localSpannableString.setSpan(new AbsoluteSizeSpan(18, true), 2, str.length() + 2, 33);
    return localSpannableString;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 + paramInt2 == paramInt3) && (paramInt3 > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 1) && (!this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int != 1)) {
      if (NetworkUtil.d(this)) {}
    }
    while ((paramInt1 + paramInt2 != paramInt3) || (paramInt3 <= 0))
    {
      return;
      b(false, true);
    }
    if (paramInt1 != 0)
    {
      a(2);
      return;
    }
    a(1);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt) {
      this.jdField_b_of_type_Int = paramInt;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    TextView localTextView;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (this.f == null) {
        this.f = ((ViewStub)findViewById(2131370842)).inflate();
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      localTextView = (TextView)this.f.findViewById(2131365559);
      if (this.jdField_c_of_type_Int <= 3)
      {
        localTextView.setText(2131438320);
        Button localButton = (Button)this.f.findViewById(2131370567);
        localButton.setOnClickListener(this);
        if (AppSetting.jdField_b_of_type_Boolean)
        {
          localTextView.setContentDescription(getString(2131438320));
          localButton.setContentDescription("如何提升等级，按钮，连按两次来打开。");
        }
        this.f.setVisibility(0);
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        a(false);
      }
      d();
      if ((!paramBoolean2) || (this.jdField_a_of_type_ComTencentMobileqqNearbyMyvistorNearbyVisitorAdapter == null)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyMyvistorNearbyVisitorAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_c_of_type_Long, this.jdField_d_of_type_Long, b());
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqNearbyMyvistorNearbyVisitorAdapter.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.a(i);
        i += 1;
      }
      localTextView.setText(2131438319);
      if (!AppSetting.jdField_b_of_type_Boolean) {
        break;
      }
      localTextView.setContentDescription(getString(2131438319));
      break;
      if (paramBoolean2)
      {
        if (this.f != null) {
          this.f.setVisibility(8);
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        if (!b())
        {
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            this.jdField_d_of_type_AndroidViewView.setVisibility(0);
            this.e.setVisibility(8);
          }
          else
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            this.e.setVisibility(8);
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          this.e.setVisibility(0);
        }
      }
      else
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.e.setVisibility(8);
      }
    }
  }
  
  protected void b()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747");
    startActivity(localIntent);
  }
  
  public boolean b()
  {
    if ((this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_Long > 4L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.tribeAppDownload", 2, "isNeedShowDownloadLayout, isNeedShow=" + this.jdField_c_of_type_Boolean + ", mTotalVisitorCount=" + this.jdField_b_of_type_Long + ", url=" + this.jdField_a_of_type_JavaLangString);
      }
      return bool;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970501);
    paramBundle = getIntent();
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("glamourLevel", 0);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("download_tribe_app_url");
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("is_show_tribeapp_download_layout", false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.tribeAppDownload", 2, "NearbyVisitorListActivity-doOnCreate , mTribeAppDownloadPageUrl=" + this.jdField_a_of_type_JavaLangString);
    }
    setTitle(2131438318);
    setLeftViewName(2131432425);
    if (this.titleRoot != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.titleRoot.findViewById(2131363399));
      ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363489)).setText(2131438318);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363490));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder.a(this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder$IIconListener);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131370841));
    paramBundle = getResources().getDrawable(2130838596);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOverscrollHeader(paramBundle);
    paramBundle = getResources().getDrawable(2130838219);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setContentBackground(paramBundle, false, true);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131370843);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130969515, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131558434));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130970460, null);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370571);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370572);
    this.e = this.jdField_b_of_type_AndroidViewView.findViewById(2131370573);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqNearbyMyvistorNearbyVisitorAdapter = new NearbyVisitorAdapter(this, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyMyvistorNearbyVisitorAdapter);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOnScrollChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131370843);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOnGroupClickListener(new aezz(this));
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler = ((NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2131034129, 2131034130);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        b();
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.reportClickEvent("CliOper", "", "", "0X80061AA", "0X80061AA", 0, 0, "", "", "", "");
        return;
        b();
        if (this.jdField_a_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.reportClickEvent("CliOper", "", "", "0X80061A9", "0X80061A9", 0, 0, "", "", "", "");
          return;
        }
      } while (this.jdField_a_of_type_Int != 2);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.reportClickEvent("CliOper", "", "", "0X80061A8", "0X80061A8", 0, 0, "", "", "", "");
      return;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    paramView = this.jdField_a_of_type_JavaLangString + "&from=" + 3;
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView);
    startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.tribeAppDownload", 2, "open download page, url=" + paramView);
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "app_down", "visit_down", 0, 0, "", "", "", "");
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    int i = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      Object localObject;
      if (paramInt1 < i)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.getChildAt(paramInt1);
        if (localObject == null) {
          break label178;
        }
        localObject = ((View)localObject).getTag();
        if (!(localObject instanceof NearbyVisitorAdapter.ChildItemHolder)) {
          break label178;
        }
        localObject = (NearbyVisitorAdapter.ChildItemHolder)localObject;
        if (!((Boolean)((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.getTag()).booleanValue()) {
          break label97;
        }
        if ((paramString == null) || (paramInt2 != ((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_Int) || (!paramString.equals(((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_JavaLangString))) {
          break label178;
        }
      }
      label97:
      do
      {
        return;
        if ((paramString == null) || (paramInt2 != ((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_Int) || (!paramString.equals(((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_JavaLangString))) {
          break;
        }
        ((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        ((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setTag(Boolean.valueOf(true));
      } while (!QLog.isColorLevel());
      QLog.d("Q.nearby.visitor", 2, "face updated, uin=" + paramString);
      return;
      label178:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity
 * JD-Core Version:    0.7.0.1
 */