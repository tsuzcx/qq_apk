package com.tencent.mobileqq.nearby.interestTag;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.profilecard.LabelEditCtrl;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV.IOnSizeChangeCallback;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

@RoutePage(desc="交友资料卡编辑态，选择兴趣标签页面", path="/nearby/choose/interesttag")
public class ChooseInterestTagActivity
  extends IphoneTitleBarActivity
{
  private static final String[] DEFAULT_BG_COLOR = { "#77C6F4", "#FFA366", "#333333", "#5DC2A2" };
  private static final int FETCH_COUNT_ONE_TIME = 30;
  private static final int FETCH_POS_NO_MORE = -1;
  public static final String LOG_TAG = "choose_interest_tag";
  private static final int REQ_PERSON_FLAG = 1;
  private ArrayList<InterestTagInfo> mChoosedInterestTagInfos = new ArrayList();
  private View.OnClickListener mChoosedItemViewOnClickListener = new ChooseInterestTagActivity.11(this);
  private int mDelKeyPressTime = 0;
  private EditText mEtIntput;
  private View.OnKeyListener mEtOnKeyListener = new ChooseInterestTagActivity.8(this);
  private int mFetchPos = 0;
  private MonitorSizeChangeHSV mHsvContent;
  private int mHsvHeight;
  private int mHsvRightMargin;
  private InterestTagAdapter mInterestTagAdapter;
  private List<InterestTagInfo> mInterestTagInfos = new ArrayList();
  private InterestTagItemView.IInterestTagItemViewCallback mInterestTagItemViewCallback = new ChooseInterestTagActivity.14(this);
  private boolean mIsFoodOrSport = false;
  private boolean mIsFromJudge = false;
  private boolean mIsFromNearby = false;
  private boolean mIsHasFooterView = false;
  private boolean mIsNetToastShowing = false;
  private boolean mIsToastShowing = false;
  private String mKeywrod = "";
  private LayoutInflater mLayoutInflater;
  private View mLayoutInitLoading;
  private LinearLayout mLayoutPicGallary;
  private View mLayoutSearchLoading;
  private LinearLayout mLoadMoreFooterView;
  private ListView mLvContent;
  private INearbyCardHandler mNearbyCardHandler;
  private NearbyCardObserver mNearbyCardObserver = new ChooseInterestTagActivity.6(this);
  private QQProgressNotifier mNotifier;
  private View.OnClickListener mOnClickListener = new ChooseInterestTagActivity.10(this);
  private MonitorSizeChangeHSV.IOnSizeChangeCallback mOnHsvSizeChangeCallback = new ChooseInterestTagActivity.9(this);
  private AbsListView.OnScrollListener mOnLvScrollListener = new ChooseInterestTagActivity.7(this);
  private ShowTagNamePopupWindow.IShowTagNamePopupWindowCallback mPopupwindowCallback = new ChooseInterestTagActivity.12(this);
  private View mRecommendTitleDivider;
  private RelativeLayout mRlInput;
  private RelativeLayout mRlTips;
  private float mScreenDensity;
  private int mSearchFetchPos = 0;
  private List<InterestTagInfo> mSearchedInterestTagInfos = new ArrayList();
  private int mTagType = -1;
  private TextView mTextSearchResultTips;
  private TextWatcher mTextWatcher = new ChooseInterestTagActivity.13(this);
  private TextView mTxvInitLoadingContent;
  private TextView mTxvRecommendTitle;
  private TextView mTxvSearchLoadingContent;
  private TextView mTxvTipsContent;
  private Handler mUIHandler = new ChooseInterestTagActivity.5(this);
  private View mViewDivider;
  
  private void addView2Choosed(InterestTagInfo paramInterestTagInfo)
  {
    if (this.mHsvContent.getVisibility() != 0)
    {
      this.mHsvContent.setVisibility(0);
      if (this.mIsFoodOrSport)
      {
        localObject = (RelativeLayout.LayoutParams)this.mHsvContent.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).height = this.mHsvHeight;
        this.mHsvContent.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (RelativeLayout.LayoutParams)this.mRlInput.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).height = this.mHsvHeight;
        double d = this.mScreenDensity * 10.0F;
        Double.isNaN(d);
        int i = (int)(d + 0.5D);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
        ((RelativeLayout.LayoutParams)localObject).topMargin = i;
        this.mRlInput.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    boolean bool;
    if (this.mChoosedInterestTagInfos.size() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramInterestTagInfo = createChoosedItemView(paramInterestTagInfo, bool);
    this.mLayoutPicGallary.addView(paramInterestTagInfo);
    Object localObject = new AlphaAnimation(0.1F, 1.0F);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setDuration(70L);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setAnimationListener(new ChooseInterestTagActivity.3(this));
    paramInterestTagInfo.startAnimation(localAnimationSet);
    if (this.mChoosedInterestTagInfos.isEmpty())
    {
      this.rightViewText.setEnabled(false);
      if (!this.mIsFoodOrSport) {
        this.mEtIntput.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130842412), null, null, null);
      }
    }
    else
    {
      this.rightViewText.setEnabled(true);
      if (!this.mIsFoodOrSport) {
        this.mEtIntput.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    reportAddOrRemoveTag(true);
  }
  
  private void addView2Choosed(List<InterestTagInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      int i = 0;
      for (;;)
      {
        int j = paramList.size();
        boolean bool = true;
        if (i >= j) {
          break;
        }
        Object localObject = (InterestTagInfo)paramList.get(i);
        if (i != 0) {
          bool = false;
        }
        localObject = createChoosedItemView((InterestTagInfo)localObject, bool);
        j = this.mLayoutPicGallary.getChildCount();
        this.mLayoutPicGallary.addView((View)localObject, j);
        i += 1;
      }
      this.mUIHandler.postDelayed(new ChooseInterestTagActivity.2(this), 100L);
      if (this.mChoosedInterestTagInfos.isEmpty())
      {
        this.rightViewText.setEnabled(false);
        if (!this.mIsFoodOrSport) {
          this.mEtIntput.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130842412), null, null, null);
        }
      }
      else
      {
        this.rightViewText.setEnabled(true);
        if (!this.mIsFoodOrSport) {
          this.mEtIntput.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
      }
    }
  }
  
  private View createChoosedItemView(InterestTagInfo paramInterestTagInfo, boolean paramBoolean)
  {
    boolean bool = this.mIsFromNearby;
    int j = 5;
    int k = 0;
    Object localObject1 = null;
    TextView localTextView = null;
    Object localObject2;
    if (!bool)
    {
      i = this.mTagType;
      if ((i != 3) && (i != 2) && (i != 1) && (i != 4))
      {
        URLImageView localURLImageView = new URLImageView(this);
        d = this.mScreenDensity * 40.0F;
        Double.isNaN(d);
        localObject2 = new LinearLayout.LayoutParams((int)(d + 0.5D), this.mHsvHeight);
        d = this.mScreenDensity * 10.0F;
        Double.isNaN(d);
        ((LinearLayout.LayoutParams)localObject2).leftMargin = ((int)(d + 0.5D));
        localURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localURLImageView.setTag(paramInterestTagInfo);
        localURLImageView.setOnClickListener(this.mChoosedItemViewOnClickListener);
        localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (this.mTagType == 7)
        {
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setColor(getResources().getColor(2131165886));
          ((GradientDrawable)localObject2).setCornerRadius(this.mScreenDensity * 10.0F);
          ((GradientDrawable)localObject2).setShape(0);
          i = getResources().getDimensionPixelSize(2131297462);
          ((GradientDrawable)localObject2).setSize(i, i);
        }
        else
        {
          localObject2 = getResources().getDrawable(2131165886);
        }
        if (!TextUtils.isEmpty(paramInterestTagInfo.tagIconUrl))
        {
          try
          {
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            if (this.mTagType == 5)
            {
              i = getResources().getDimensionPixelSize(2131297464);
              ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
            }
            else
            {
              i = getResources().getDimensionPixelSize(2131297462);
              ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
            }
            j = getResources().getDimensionPixelSize(2131297463);
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = j;
            ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
            paramInterestTagInfo = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramInterestTagInfo.tagIconUrl), (URLDrawable.URLDrawableOptions)localObject1);
            try
            {
              if (this.mTagType == 7)
              {
                paramInterestTagInfo.setTag(URLDrawableDecodeHandler.b(j, i, (int)(this.mScreenDensity * 10.0F)));
                paramInterestTagInfo.setDecodeHandler(URLDrawableDecodeHandler.c);
              }
              ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = null;
              ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = null;
              localObject1 = paramInterestTagInfo;
            }
            catch (Exception localException3) {}
            localObject1 = paramInterestTagInfo;
          }
          catch (Exception localException4)
          {
            paramInterestTagInfo = localTextView;
          }
          if (QLog.isColorLevel())
          {
            QLog.i("choose_interest_tag", 2, localException4.toString());
            localObject1 = paramInterestTagInfo;
          }
        }
        if (localObject1 == null) {
          localObject1 = localObject2;
        }
        localURLImageView.setImageDrawable((Drawable)localObject1);
        return localURLImageView;
      }
    }
    View localView = this.mLayoutInflater.inflate(2131561229, null);
    localTextView = (TextView)localView.findViewById(2131379994);
    if (localTextView != null)
    {
      if (paramInterestTagInfo.tagName == null) {
        localObject1 = "";
      } else {
        localObject1 = paramInterestTagInfo.tagName.trim();
      }
      localObject2 = localObject1;
      if (((String)localObject1).length() > 6)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((String)localObject1).substring(0, 6));
        ((StringBuilder)localObject2).append("...");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localTextView.setSingleLine(true);
      localTextView.setText((CharSequence)localObject2);
      if (this.mIsFromNearby)
      {
        i = LabelEditCtrl.a(this.mTagType);
        if (i != -1)
        {
          i = Color.parseColor(LabelEditCtrl.b[i]);
          break label647;
        }
      }
      else
      {
        try
        {
          i = Color.parseColor(paramInterestTagInfo.tagTextColor);
        }
        catch (Exception localException1)
        {
          if (QLog.isDevelopLevel()) {
            localException1.printStackTrace();
          }
        }
      }
      i = -1;
      label647:
      localTextView.setTextColor(i);
    }
    if (this.mIsFromNearby)
    {
      int m = LabelEditCtrl.a(this.mTagType);
      i = k;
      if (m != -1) {
        i = Color.parseColor(LabelEditCtrl.a[m]);
      }
    }
    else
    {
      k = Color.parseColor(DEFAULT_BG_COLOR[(this.mTagType - 1)]);
      try
      {
        i = Color.parseColor(paramInterestTagInfo.tagBgColor);
      }
      catch (Exception localException2)
      {
        i = k;
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parse tagBgClor: ");
          ((StringBuilder)localObject2).append(localException2.getMessage());
          QLog.d("choose_interest_tag", 4, ((StringBuilder)localObject2).toString());
          i = k;
        }
      }
    }
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(i);
    localGradientDrawable.setCornerRadius(getResources().getDimensionPixelSize(2131298938));
    localView.setBackgroundDrawable(localGradientDrawable);
    localView.setTag(paramInterestTagInfo);
    paramInterestTagInfo = new LinearLayout.LayoutParams(-2, (int)DisplayUtils.a(this, 17.0F));
    int i = j;
    if (paramBoolean) {
      i = 10;
    }
    double d = i * this.mScreenDensity;
    Double.isNaN(d);
    paramInterestTagInfo.leftMargin = ((int)(d + 0.5D));
    localView.setLayoutParams(paramInterestTagInfo);
    localView.setOnClickListener(this.mChoosedItemViewOnClickListener);
    return localView;
  }
  
  private void hideNotifer()
  {
    QQProgressNotifier localQQProgressNotifier = this.mNotifier;
    if (localQQProgressNotifier != null) {
      localQQProgressNotifier.b();
    }
  }
  
  private void initData()
  {
    Intent localIntent = getIntent();
    Object localObject = getIntent();
    int i = -1;
    if (localObject != null) {
      i = getIntent().getIntExtra("interest_tag_type", -1);
    }
    this.mTagType = i;
    i = this.mTagType;
    if ((i < 1) || (i > 7))
    {
      finish();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("tagType is wrong. ");
        ((StringBuilder)localObject).append(this.mTagType);
        QLog.i("choose_interest_tag", 2, ((StringBuilder)localObject).toString());
      }
    }
    int j = 0;
    if (localIntent != null) {
      this.mIsFromNearby = localIntent.getBooleanExtra("is_from_nearby", false);
    }
    boolean bool;
    if (getIntent() == null) {
      bool = false;
    } else {
      bool = getIntent().getBooleanExtra("is_from_judge", false);
    }
    this.mIsFromJudge = bool;
    if (this.mIsFromJudge)
    {
      this.mRlTips.setVisibility(0);
      i = this.mTagType;
      if (i == 3) {
        localObject = HardCodeUtil.a(2131702032);
      } else if (i == 5) {
        localObject = HardCodeUtil.a(2131702010);
      } else if (i == 6) {
        localObject = HardCodeUtil.a(2131701996);
      } else if (i == 2) {
        localObject = HardCodeUtil.a(2131702015);
      } else if (i == 7) {
        localObject = HardCodeUtil.a(2131702013);
      } else if (i == 4) {
        localObject = HardCodeUtil.a(2131701991);
      } else if (i == 1) {
        localObject = HardCodeUtil.a(2131701995);
      } else {
        localObject = "";
      }
      this.mTxvTipsContent.setText((CharSequence)localObject);
    }
    i = this.mTagType;
    if ((i != 2) && (i != 4)) {
      bool = false;
    } else {
      bool = true;
    }
    this.mIsFoodOrSport = bool;
    if (this.mIsFoodOrSport) {
      i = 10;
    } else {
      i = 100;
    }
    this.mHsvRightMargin = i;
    localObject = (RelativeLayout.LayoutParams)this.mHsvContent.getLayoutParams();
    float f = this.mScreenDensity;
    double d = this.mHsvRightMargin * f;
    Double.isNaN(d);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(d + 0.5D));
    i = this.mTagType;
    if (i == 5)
    {
      d = f * 50.0F;
      Double.isNaN(d);
      this.mHsvHeight = ((int)(d + 0.5D));
    }
    else if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
    {
      d = f * 40.0F;
      Double.isNaN(d);
      this.mHsvHeight = ((int)(d + 0.5D));
    }
    else
    {
      d = this.mScreenDensity * 26.0F;
      Double.isNaN(d);
      this.mHsvHeight = ((int)(d + 0.5D));
    }
    if (this.mIsFoodOrSport)
    {
      this.mRlInput.setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)this.mRlInput.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = 1;
      ((RelativeLayout.LayoutParams)localObject).width = 1;
      i = j;
      if (this.mIsFromJudge)
      {
        d = this.mScreenDensity * 7.0F;
        Double.isNaN(d);
        i = (int)(d + 0.5D);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
    }
    else
    {
      localObject = (RelativeLayout.LayoutParams)this.mRlInput.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = this.mHsvHeight;
      d = this.mScreenDensity * 10.0F;
      Double.isNaN(d);
      i = (int)(d + 0.5D);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
    }
    this.mLayoutPicGallary.getLayoutParams().height = this.mHsvHeight;
    this.mLayoutPicGallary.setGravity(16);
    if (localIntent != null)
    {
      localObject = localIntent.getParcelableArrayListExtra("choosed_interest_tags");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        Collections.reverse((List)localObject);
        this.mChoosedInterestTagInfos.addAll((Collection)localObject);
      }
      updateChoosedTags();
    }
    this.mNotifier = new QQProgressNotifier(this);
    this.mNearbyCardHandler = ((INearbyCardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER));
    ThreadManager.getFileThreadHandler().post(new ChooseInterestTagActivity.1(this));
  }
  
  private void initTitle()
  {
    String str3 = HardCodeUtil.a(2131701992);
    int i = this.mTagType;
    String str2 = "";
    String str1;
    if (i == 3)
    {
      str2 = HardCodeUtil.a(2131702002);
      str1 = HardCodeUtil.a(2131702030);
      this.mTxvRecommendTitle.setVisibility(8);
      this.mRecommendTitleDivider.setVisibility(8);
    }
    else if (i == 5)
    {
      str2 = HardCodeUtil.a(2131701993);
      str1 = HardCodeUtil.a(2131702001);
      this.mTxvRecommendTitle.setVisibility(0);
      this.mRecommendTitleDivider.setVisibility(0);
    }
    else if (i == 6)
    {
      str2 = HardCodeUtil.a(2131702025);
      str1 = HardCodeUtil.a(2131702019);
      this.mTxvRecommendTitle.setVisibility(0);
      this.mRecommendTitleDivider.setVisibility(0);
    }
    else if (i == 2)
    {
      str2 = HardCodeUtil.a(2131701998);
      str1 = HardCodeUtil.a(2131702022);
      this.mTxvRecommendTitle.setVisibility(8);
      this.mRecommendTitleDivider.setVisibility(8);
    }
    else if (i == 7)
    {
      str2 = HardCodeUtil.a(2131701997);
      str1 = HardCodeUtil.a(2131702023);
      this.mTxvRecommendTitle.setVisibility(0);
      this.mRecommendTitleDivider.setVisibility(0);
    }
    else if (i == 4)
    {
      str1 = HardCodeUtil.a(2131702031);
      str2 = HardCodeUtil.a(2131702003);
      this.mTxvRecommendTitle.setVisibility(8);
      this.mRecommendTitleDivider.setVisibility(8);
    }
    else if (i == 1)
    {
      str2 = HardCodeUtil.a(2131702000);
      str1 = HardCodeUtil.a(2131702009);
      this.mTxvRecommendTitle.setVisibility(0);
      this.mRecommendTitleDivider.setVisibility(0);
      str3 = HardCodeUtil.a(2131701994);
    }
    else
    {
      str1 = "";
    }
    this.mEtIntput.setHint(str3);
    if (!this.mIsFromJudge) {
      str1 = str2;
    }
    setTitle(str1);
    if (this.mIsFromJudge)
    {
      setLeftViewName(2131690728);
      this.leftView.setOnClickListener(this.mOnClickListener);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(HardCodeUtil.a(2131702014));
      this.rightViewText.setOnClickListener(this.mOnClickListener);
      return;
    }
    setLeftViewName(2131690529);
    this.leftView.setOnClickListener(this.mOnClickListener);
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(8);
  }
  
  @TargetApi(9)
  private void initViews()
  {
    this.mLayoutInflater = LayoutInflater.from(this);
    this.mEtIntput = ((EditText)findViewById(2131366321));
    this.mHsvContent = ((MonitorSizeChangeHSV)findViewById(2131368321));
    this.mLayoutPicGallary = ((LinearLayout)findViewById(2131370286));
    this.mLvContent = ((ListView)findViewById(2131370503));
    this.mRlInput = ((RelativeLayout)findViewById(2131376694));
    this.mLayoutInitLoading = findViewById(2131376693);
    this.mLayoutSearchLoading = findViewById(2131376734);
    this.mTxvInitLoadingContent = ((TextView)findViewById(2131380072));
    this.mTxvSearchLoadingContent = ((TextView)findViewById(2131380081));
    this.mRlTips = ((RelativeLayout)findViewById(2131376747));
    this.mTxvTipsContent = ((TextView)findViewById(2131380092));
    this.mViewDivider = findViewById(2131380360);
    this.mTxvRecommendTitle = ((TextView)findViewById(2131380080));
    this.mRecommendTitleDivider = findViewById(2131380370);
    this.mTextSearchResultTips = ((TextView)findViewById(2131380082));
    this.mLayoutInitLoading.setVisibility(0);
    int i = getResources().getColor(2131166377);
    this.mViewDivider.setBackgroundColor(i);
    this.mRecommendTitleDivider.setBackgroundColor(i);
    this.mLoadMoreFooterView = ((LinearLayout)LayoutInflater.from(this).inflate(2131559469, null));
    updateLoadMoreFooterView(false, true);
    if (!this.mIsFoodOrSport)
    {
      this.mEtIntput.addTextChangedListener(this.mTextWatcher);
      this.mEtIntput.setOnKeyListener(this.mEtOnKeyListener);
      this.mEtIntput.setOnClickListener(this.mOnClickListener);
      if (AppSetting.d) {
        this.mEtIntput.setContentDescription(HardCodeUtil.a(2131702024));
      }
    }
    this.mHsvContent.setOnSizeChangeCallback(this.mOnHsvSizeChangeCallback);
    this.mLvContent.setOnScrollListener(this.mOnLvScrollListener);
    this.mEtIntput.clearFocus();
    if (Build.VERSION.SDK_INT >= 9) {
      this.mLvContent.setOverScrollMode(2);
    }
    this.mScreenDensity = getResources().getDisplayMetrics().density;
  }
  
  private boolean isInterestTagChoosed(InterestTagInfo paramInterestTagInfo)
  {
    return this.mChoosedInterestTagInfos.contains(paramInterestTagInfo);
  }
  
  @TargetApi(11)
  private void onDelKeyPressedTimeChanged(int paramInt)
  {
    Object localObject;
    if ((this.mDelKeyPressTime == 1) && (paramInt == 0))
    {
      if (this.mLayoutPicGallary.getChildCount() > 0)
      {
        localObject = this.mLayoutPicGallary;
        localObject = ((LinearLayout)localObject).getChildAt(((LinearLayout)localObject).getChildCount() - 1);
        if (Build.VERSION.SDK_INT >= 11) {
          ((View)localObject).setAlpha(1.0F);
        }
      }
      this.mDelKeyPressTime = 0;
      return;
    }
    if ((this.mDelKeyPressTime == 0) && (paramInt == 1))
    {
      if (this.mLayoutPicGallary.getChildCount() > 0)
      {
        localObject = this.mLayoutPicGallary;
        localObject = ((LinearLayout)localObject).getChildAt(((LinearLayout)localObject).getChildCount() - 1);
        if (Build.VERSION.SDK_INT >= 11) {
          ((View)localObject).setAlpha(0.5F);
        }
      }
      this.mDelKeyPressTime = 1;
      return;
    }
    if (paramInt == 2)
    {
      if ((this.mLayoutPicGallary.getChildCount() > 0) && (!this.mChoosedInterestTagInfos.isEmpty()))
      {
        localObject = this.mChoosedInterestTagInfos;
        localObject = (InterestTagInfo)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
        removeViewFromChoosed((InterestTagInfo)localObject);
        updateItemChooseStatus((InterestTagInfo)localObject);
      }
      this.mDelKeyPressTime = 0;
    }
  }
  
  private void removeViewFromChoosed(InterestTagInfo paramInterestTagInfo)
  {
    if (paramInterestTagInfo == null) {
      return;
    }
    int j = this.mLayoutPicGallary.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.mLayoutPicGallary.getChildAt(i);
      if (((InterestTagInfo)localView.getTag()).equals(paramInterestTagInfo))
      {
        paramInterestTagInfo = new AlphaAnimation(1.0F, 0.1F);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation(paramInterestTagInfo);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setDuration(70L);
        localAnimationSet.setInterpolator(new AccelerateInterpolator());
        localAnimationSet.setAnimationListener(new ChooseInterestTagActivity.4(this, localView));
        localView.startAnimation(localAnimationSet);
        break;
      }
      i += 1;
    }
    if (this.mChoosedInterestTagInfos.isEmpty())
    {
      this.rightViewText.setEnabled(false);
      if (!this.mIsFoodOrSport) {
        this.mEtIntput.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130842412), null, null, null);
      }
    }
    else
    {
      this.rightViewText.setEnabled(true);
      if (!this.mIsFoodOrSport) {
        this.mEtIntput.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    reportAddOrRemoveTag(false);
  }
  
  private void reportAddOrRemoveTag(boolean paramBoolean)
  {
    if (this.mIsFromNearby)
    {
      QQAppInterface localQQAppInterface = this.app;
      String str;
      if (paramBoolean) {
        str = "add_tag";
      } else {
        str = "del_tag";
      }
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", str, 0, 0, "", "", "", String.valueOf(this.mTagType));
    }
  }
  
  private void showNotifer(int paramInt1, String paramString, int paramInt2)
  {
    if ((this.mNotifier != null) && (!isFinishing())) {
      this.mNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  private void toast(String paramString)
  {
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
  }
  
  private void updateChoosedTags()
  {
    Object localObject = this.mChoosedInterestTagInfos;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      if (this.mHsvContent.getVisibility() != 0)
      {
        this.mHsvContent.setVisibility(0);
        if (this.mIsFoodOrSport)
        {
          localObject = (RelativeLayout.LayoutParams)this.mHsvContent.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = this.mHsvHeight;
          this.mHsvContent.setLayoutParams((ViewGroup.LayoutParams)localObject);
          localObject = (RelativeLayout.LayoutParams)this.mRlInput.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = this.mHsvHeight;
          double d = this.mScreenDensity * 10.0F;
          Double.isNaN(d);
          int i = (int)(d + 0.5D);
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
          ((RelativeLayout.LayoutParams)localObject).topMargin = i;
          this.mRlInput.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      addView2Choosed(this.mChoosedInterestTagInfos);
      return;
    }
    this.mLayoutPicGallary.removeAllViews();
    if (this.mHsvContent.getVisibility() != 8) {
      this.mHsvContent.setVisibility(8);
    }
    this.rightViewText.setEnabled(false);
  }
  
  private void updateItemChooseStatus(InterestTagInfo paramInterestTagInfo)
  {
    int j = this.mLvContent.getFirstVisiblePosition();
    int k = this.mLvContent.getLastVisiblePosition();
    int i = j;
    while (i <= k)
    {
      View localView = this.mLvContent.getChildAt(i - j);
      if ((localView != null) && ((localView instanceof InterestTagItemView)) && (paramInterestTagInfo.equals(localView.getTag()))) {
        ((InterestTagItemView)localView).a();
      }
      i += 1;
    }
  }
  
  private void updateLoadMoreFooterView(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.mLoadMoreFooterView;
    if (localObject == null) {
      return;
    }
    if ((!paramBoolean2) && (this.mIsHasFooterView))
    {
      this.mLvContent.removeFooterView((View)localObject);
      this.mIsHasFooterView = false;
    }
    else if ((paramBoolean2) && (!this.mIsHasFooterView))
    {
      this.mLvContent.addFooterView(this.mLoadMoreFooterView);
      this.mIsHasFooterView = true;
    }
    localObject = (TextView)this.mLoadMoreFooterView.findViewById(2131371517);
    ProgressBar localProgressBar = (ProgressBar)this.mLoadMoreFooterView.findViewById(2131376345);
    ImageView localImageView = (ImageView)this.mLoadMoreFooterView.findViewById(2131370354);
    if (localImageView.getVisibility() != 8) {
      localImageView.setVisibility(8);
    }
    if (paramBoolean1)
    {
      ((TextView)localObject).setTextColor(getResources().getColor(2131167138));
      ((TextView)localObject).setText(HardCodeUtil.a(2131702021));
      localProgressBar.setVisibility(0);
      this.mLoadMoreFooterView.setOnClickListener(this.mOnClickListener);
      return;
    }
    if (paramBoolean2)
    {
      ((TextView)localObject).setTextColor(getResources().getColor(2131167203));
      ((TextView)localObject).setText(HardCodeUtil.a(2131702007));
      localProgressBar.setVisibility(8);
      this.mLoadMoreFooterView.setOnClickListener(this.mOnClickListener);
      return;
    }
    ((TextView)localObject).setTextColor(getResources().getColor(2131167138));
    ((TextView)localObject).setText(HardCodeUtil.a(2131702029));
    localProgressBar.setVisibility(8);
    this.mLoadMoreFooterView.setOnClickListener(null);
  }
  
  public void doOnBackPressed()
  {
    if (!this.mIsFromJudge)
    {
      Intent localIntent2 = getIntent();
      Intent localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      Collections.reverse(this.mChoosedInterestTagInfos);
      localIntent1.putParcelableArrayListExtra("choosed_interest_tags", this.mChoosedInterestTagInfos);
      localIntent1.putExtra("interest_tag_type", this.mTagType);
      setResult(-1, localIntent1);
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561178);
    getWindow().setBackgroundDrawable(getResources().getDrawable(2130845058));
    initViews();
    addObserver(this.mNearbyCardObserver);
    initData();
    initTitle();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.mNearbyCardObserver);
    QQProgressNotifier localQQProgressNotifier = this.mNotifier;
    if (localQQProgressNotifier != null) {
      localQQProgressNotifier.b();
    }
  }
  
  public void finish()
  {
    InputMethodUtil.b(this.mEtIntput);
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity
 * JD-Core Version:    0.7.0.1
 */