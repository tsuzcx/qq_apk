package com.tencent.widget;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ActionSheet
  extends ReportDialog
{
  public static final int BLUE_BOLD_STYLE_BTN = 6;
  public static final int BLUE_STYLE_BTN = 5;
  public static final int CUSTOM_TEXT_COLOR_BTN = 9;
  public static final int DEFAULT_STYLE_BTN = 0;
  public static final int DEFAULT_TWO_LINES_STYLE_BTN = 65537;
  public static final int GRAY_STYLE_BTN = 7;
  @Deprecated
  public static final int GREEN_STYLE_BTN = 2;
  @Deprecated
  public static final int GREY_STYLE_BTN = 4;
  public static final String ICON_PREFIX = "icon";
  public static final int REAL_BLUE_STYLE_BTN = 8;
  public static final int RED_STYLE_BTN = 3;
  public static final int SELECTOR_TYPE_BG = 0;
  public static final int SELECTOR_TYPE_BOTTOM = 3;
  public static final int SELECTOR_TYPE_BOTTOM_RADIUS_REAL = 4;
  public static final int SELECTOR_TYPE_MIDDLE = 2;
  public static final int SELECTOR_TYPE_SINGLE = 0;
  public static final int SELECTOR_TYPE_TOP = 1;
  public static final int STYLE_BTN_LEFT_URL_ICON = 10;
  public static final int STYPE_BTN_PUBLIC_ACCOUNT_TITLE = 11;
  public static final String TAG = "ActionSheet";
  private static final int TEXT_COLOR_MASK = 65535;
  @Deprecated
  public static final int WHITE_STYLE_BTN = 1;
  private TranslateAnimation animation;
  private int mAccuseIconColor = 0;
  private int mAccuseText;
  private HashMap<CharSequence, ActionMenuItem> mActionMenuMap = new HashMap();
  private RelativeLayout mActionView;
  private int mAnimationTime = 300;
  private View.OnClickListener mBtnClickListener = new ActionSheet.8(this);
  private ActionSheet.OnButtonClickListener mButtonsListener = null;
  private ActionSheet.OnButtonClickListenerV2 mButtonsListenerV2 = null;
  private Button mCancelBtn;
  private CharSequence mCancelText;
  private boolean mCloseAutoRead = false;
  public LinearLayout mContentContainer;
  private ArrayList<Pair<CharSequence, Integer>> mContents;
  private Context mContext;
  private int mCurrentSelectedViewId = -1;
  public View.OnClickListener mDefaultDismissListener = new ActionSheet.9(this);
  private boolean mDismissFinish = true;
  private ActionSheet.OnDismissListener mDismissListener = null;
  private Map<Integer, URLDrawable> mFetchDrawableMap = new HashMap();
  private Map<Integer, ActionSheet.OnTextImageFetchedListener> mFetchListenerMap = new HashMap();
  private Handler mHandler;
  private boolean mHasCustomeHeader;
  private HashMap<Integer, Integer> mIconsLayoutLeftMap = new HashMap();
  private HashMap<Integer, Drawable> mIconsLeftMap = new HashMap();
  private HashMap<Integer, Drawable> mIconsMap = new HashMap();
  private List<Integer> mIds = new ArrayList();
  private LayoutInflater mInflater;
  private boolean mIsMenuMode;
  public boolean mIsReady;
  private boolean mIsRoundCornerTop = false;
  private CharSequence mMainTitle;
  private ActionSheet.onPreShowListener mOnPreShowListener = null;
  private SparseArray<View> mRadioButtonMap;
  private boolean mRadioGroupMode = false;
  protected Resources mResources;
  private ViewGroup mRootView;
  private CharSequence mSecondaryTitle;
  private boolean mShowAnimation = true;
  private SparseArray<Integer> mSubTextColorArray = new SparseArray();
  protected boolean mSupportBottomRadius = false;
  private HashMap<Integer, String> mTextColorMap = new HashMap();
  private HashSet<Integer> mUncheckeable;
  public Object mUserData;
  private ActionSheet.WatchDismissActions mWatchDismissListener = null;
  private TextView mainTitleText;
  private View.OnClickListener onBottomAccuseListener;
  private View.OnClickListener onBottomCancelListener;
  
  protected ActionSheet(Context paramContext)
  {
    this(paramContext, false, false);
  }
  
  protected ActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, true, -1, null);
  }
  
  @TargetApi(14)
  protected ActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramContext, 2131755400);
    Window localWindow = getWindow();
    if (Build.VERSION.SDK_INT >= 14) {
      localWindow.setDimAmount(0.5F);
    }
    this.mContext = paramContext;
    this.mIsMenuMode = paramBoolean1;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mResources = paramContext.getResources();
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramBoolean3) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      localWindow.addFlags(67108864);
    }
    if (paramBoolean2)
    {
      requestWindowFeature(1);
      localWindow.setFlags(1024, 1024);
      if (Build.VERSION.SDK_INT >= 28)
      {
        paramContext = localWindow.getAttributes();
        paramContext.layoutInDisplayCutoutMode = 1;
        localWindow.setAttributes(paramContext);
      }
    }
    ImmersiveUtils.clearCoverForStatus(localWindow, true);
    paramContext = this.mInflater;
    if (paramInt == -1) {
      paramInt = 2131558465;
    }
    this.mRootView = ((ViewGroup)paramContext.inflate(paramInt, null));
    if (paramLayoutParams != null) {
      super.setContentView(this.mRootView, paramLayoutParams);
    } else {
      super.setContentView(this.mRootView);
    }
    this.mActionView = ((RelativeLayout)this.mRootView.findViewById(2131361984));
    this.mContentContainer = ((LinearLayout)this.mRootView.findViewById(2131361992));
    this.mRootView.getChildAt(0).setOnClickListener(this.mDefaultDismissListener);
    this.mActionView.setOnClickListener(null);
    this.onBottomCancelListener = this.mDefaultDismissListener;
  }
  
  private CharSequence buildLeftUrlIconCharSequence(CharSequence paramCharSequence, Drawable paramDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("icon");
    localStringBuilder.append(paramCharSequence);
    paramCharSequence = new SpannableStringBuilder(localStringBuilder.toString());
    paramDrawable.setBounds(0, 0, QQUIDelegate.a(getContext(), 20.0F), QQUIDelegate.a(getContext(), 20.0F));
    paramDrawable = new VerticalCenterImageSpan(paramDrawable, 0);
    paramDrawable.setPadding(QQUIDelegate.a(getContext(), 6.5F), QQUIDelegate.a(getContext(), 6.5F));
    paramCharSequence.setSpan(paramDrawable, 0, 4, 18);
    return paramCharSequence;
  }
  
  public static ActionSheet create(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
    }
    return paramContext;
  }
  
  public static ActionSheet create(Context paramContext, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramContext = new ActionSheet(paramContext, false, false, true, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
    }
    return paramContext;
  }
  
  public static ActionSheet create(Context paramContext, boolean paramBoolean)
  {
    paramContext = new ActionSheet(paramContext, false, false, paramBoolean, -1, null);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
    }
    return paramContext;
  }
  
  public static ActionSheet createFullScreenDialog(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false, true);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
    }
    return paramContext;
  }
  
  public static ActionSheet createFullScreenDialog(Context paramContext, boolean paramBoolean)
  {
    paramContext = new ActionSheet(paramContext, false, true, paramBoolean, -1, null);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
    }
    return paramContext;
  }
  
  public static ActionSheet createFullScreenMenuSheet(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, true, true);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
    }
    return paramContext;
  }
  
  public static ActionSheet createMenuSheet(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, true, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755012);
    }
    return paramContext;
  }
  
  private void handleLeftUrlButtonStyle(Pair<CharSequence, Integer> paramPair, TextView paramTextView)
  {
    if (paramPair != null)
    {
      if (paramTextView == null) {
        return;
      }
      if ((((Integer)paramPair.second).intValue() == 10) && (paramPair.first != null))
      {
        setOnTextImageFetched((CharSequence)paramPair.first, new ActionSheet.2(this, paramTextView));
        if (this.mFetchDrawableMap.containsKey(Integer.valueOf(((CharSequence)paramPair.first).hashCode())))
        {
          URLDrawable localURLDrawable = (URLDrawable)this.mFetchDrawableMap.get(Integer.valueOf(((CharSequence)paramPair.first).hashCode()));
          if (localURLDrawable != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("prepareContentViews ");
            localStringBuilder.append(localURLDrawable);
            QLog.i("ActionSheet", 1, localStringBuilder.toString());
            if (localURLDrawable.getStatus() == 1)
            {
              paramTextView.setText(buildLeftUrlIconCharSequence((CharSequence)paramPair.first, localURLDrawable));
              return;
            }
            handleLeftUrlDrawable(localURLDrawable, paramPair, paramTextView);
          }
        }
      }
    }
  }
  
  private void handleLeftUrlDrawable(URLDrawable paramURLDrawable, Pair<CharSequence, Integer> paramPair, TextView paramTextView)
  {
    if ((paramURLDrawable != null) && (paramPair != null))
    {
      if (paramTextView == null) {
        return;
      }
      paramURLDrawable.setURLDrawableListener(new ActionSheet.3(this, paramTextView, paramPair));
      paramURLDrawable.setDownloadListener(new ActionSheet.4(this));
      ThreadManagerV2.executeOnSubThread(new ActionSheet.5(this, paramURLDrawable));
    }
  }
  
  private void handlePublicAccountButtonStyle(Pair<CharSequence, Integer> paramPair, TextView paramTextView)
  {
    if (paramPair != null)
    {
      if (paramTextView == null) {
        return;
      }
      if (((Integer)paramPair.second).intValue() == 11) {
        paramTextView.setTextSize(12.0F);
      }
    }
  }
  
  private void prepareContentViews()
  {
    if (this.mIsReady) {
      return;
    }
    Object localObject2;
    int i;
    if (this.mMainTitle != null)
    {
      localObject1 = this.mInflater.inflate(getActionSheetTitleLayoutId(), null);
      ((View)localObject1).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130837659));
      ((View)localObject1).setOnClickListener(new ActionSheet.1(this));
      this.mainTitleText = ((TextView)((View)localObject1).findViewById(2131362003));
      this.mainTitleText.setVisibility(0);
      this.mainTitleText.setMaxLines(2147483647);
      this.mainTitleText.setText(this.mMainTitle);
      this.mainTitleText.setContentDescription(this.mMainTitle);
      if (this.mSecondaryTitle != null)
      {
        localObject2 = (TextView)((View)localObject1).findViewById(2131362000);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.mSecondaryTitle);
        ((TextView)localObject2).setContentDescription(this.mSecondaryTitle);
      }
      this.mContentContainer.addView((View)localObject1, 0);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (this.mHasCustomeHeader) {
      i = 1;
    }
    Object localObject1 = this.mContents;
    Object localObject3;
    if (localObject1 != null)
    {
      int j = i + ((ArrayList)localObject1).size();
      int k = this.mContents.size();
      if ((k != this.mIds.size()) && (this.mIds.size() != 0)) {
        throw new IllegalArgumentException("buttons size and custom ids size not match");
      }
      i = 0;
      while (i < k)
      {
        Pair localPair = (Pair)this.mContents.get(i);
        if (((Integer)localPair.second).intValue() == 65537)
        {
          localObject2 = this.mInflater.inflate(getActionSheetCommonButtonLayoutId(), null);
          localObject3 = (TextView)((View)localObject2).findViewById(2131361989);
          localObject1 = (TextView)((View)localObject2).findViewById(2131378114);
          localObject4 = ((CharSequence)localPair.first).toString();
          int m = ((String)localObject4).indexOf('\n');
          if ((m >= 0) && (m < ((CharSequence)localPair.first).length()))
          {
            ((TextView)localObject3).setText(((String)localObject4).substring(0, m));
            ((TextView)localObject1).setText(((String)localObject4).substring(m + 1));
            ((View)localObject2).findViewById(2131364170).setContentDescription(((TextView)localObject3).getText());
          }
          else
          {
            ((TextView)localObject3).setText((CharSequence)localPair.first);
          }
          localObject4 = (Integer)this.mSubTextColorArray.get(i);
          if (localObject4 != null) {
            ((TextView)localObject1).setTextColor(((Integer)localObject4).intValue());
          }
          AccessibilityUtil.b(((View)localObject2).findViewById(2131364170), LinearLayout.class.getName());
        }
        else
        {
          localObject1 = this.mInflater.inflate(2131558468, null);
          localObject4 = (TextView)((View)localObject1).findViewById(2131361989);
          ((TextView)localObject4).setText((CharSequence)localPair.first);
          AccessibilityUtil.b((View)localObject4, Button.class.getName());
          if (((Integer)localPair.second).intValue() == 11)
          {
            handlePublicAccountButtonStyle(localPair, (TextView)localObject4);
            localObject2 = localObject1;
            localObject3 = localObject4;
          }
          else
          {
            localObject2 = localObject1;
            localObject3 = localObject4;
            if (((Integer)localPair.second).intValue() == 10)
            {
              handleLeftUrlButtonStyle(localPair, (TextView)localObject4);
              localObject3 = localObject4;
              localObject2 = localObject1;
            }
          }
        }
        localObject1 = this.mActionMenuMap;
        if ((localObject1 != null) && (((HashMap)localObject1).size() > 0))
        {
          localObject1 = (ActionMenuItem)this.mActionMenuMap.get(localPair.first);
          if ((localObject1 != null) && (((ActionMenuItem)localObject1).viewid != 0)) {
            ((TextView)localObject3).setId(((ActionMenuItem)localObject1).viewid);
          }
        }
        localObject1 = (ImageView)((View)localObject2).findViewById(2131362001);
        Object localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject4).rightMargin = QQUIDelegate.a(this.mContext, 15.0F);
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        if (this.mIconsMap.containsKey(Integer.valueOf(i)))
        {
          ((ImageView)localObject1).setVisibility(0);
          ((ImageView)localObject1).setImageDrawable((Drawable)this.mIconsMap.get(Integer.valueOf(i)));
        }
        else
        {
          ((ImageView)localObject1).setImageDrawable(null);
          ((ImageView)localObject1).setVisibility(8);
        }
        localObject1 = (ImageView)((View)localObject2).findViewById(2131362002);
        localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        if ((this.mIconsLayoutLeftMap.containsKey(Integer.valueOf(i))) && (((Integer)this.mIconsLayoutLeftMap.get(Integer.valueOf(i))).intValue() == 0))
        {
          ((RelativeLayout.LayoutParams)localObject4).width = QQUIDelegate.a(this.mContext, 28.0F);
          ((RelativeLayout.LayoutParams)localObject4).height = QQUIDelegate.a(this.mContext, 28.0F);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15);
        }
        ((RelativeLayout.LayoutParams)localObject4).rightMargin = QQUIDelegate.a(this.mContext, 5.0F);
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        if (this.mIconsLeftMap.containsKey(Integer.valueOf(i)))
        {
          ((ImageView)localObject1).setVisibility(0);
          ((ImageView)localObject1).setImageDrawable((Drawable)this.mIconsLeftMap.get(Integer.valueOf(i)));
        }
        else
        {
          ((ImageView)localObject1).setImageDrawable(null);
          ((ImageView)localObject1).setVisibility(8);
        }
        if (((Integer)localPair.second).intValue() == 9)
        {
          if (this.mTextColorMap.containsKey(Integer.valueOf(i))) {
            ((TextView)localObject3).setTextColor(Color.parseColor((String)this.mTextColorMap.get(Integer.valueOf(i))));
          }
        }
        else {
          ((TextView)localObject3).setTextColor(getActionButtonColorByType(((Integer)localPair.second).intValue()));
        }
        if ((this.mSupportBottomRadius) && (j > 1) && (i == k - 1) && (this.mCancelText == null)) {
          localObject1 = getSelectorByType(4);
        } else if ((i == 0) && (j == k) && (j == 1)) {
          localObject1 = getSelectorByType(0);
        } else if ((i == 0) && (j == k) && (j > 1))
        {
          if (this.mIsRoundCornerTop) {
            localObject1 = getSelectorByType(1);
          } else {
            localObject1 = getSelectorByType(3);
          }
        }
        else if ((i == k - 1) && (j > 1)) {
          localObject1 = getSelectorByType(0);
        } else {
          localObject1 = getSelectorByType(3);
        }
        ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
        if (i < this.mIds.size()) {
          ((View)localObject2).setId(((Integer)this.mIds.get(i)).intValue());
        } else {
          ((View)localObject2).setId(i);
        }
        ((View)localObject2).setOnClickListener(this.mBtnClickListener);
        this.mContentContainer.addView((View)localObject2);
        if (this.mRadioGroupMode)
        {
          if (this.mRadioButtonMap == null) {
            this.mRadioButtonMap = new SparseArray();
          }
          this.mRadioButtonMap.append(i, localObject2);
          if (i == this.mCurrentSelectedViewId)
          {
            ((View)localObject2).findViewById(2131361990).setVisibility(0);
            updateRadioGroupButtonDesc((TextView)localObject3, true);
          }
          else
          {
            updateRadioGroupButtonDesc((TextView)localObject3, false);
          }
        }
        i += 1;
      }
    }
    if (this.mCancelText != null)
    {
      localObject1 = this.mInflater.inflate(getActionSheetCancelButtonLayoutId(), null);
      if (this.mAccuseText != 0)
      {
        localObject2 = (Button)((View)localObject1).findViewById(2131361987);
        ((Button)localObject2).setVisibility(0);
        ((Button)localObject2).setText(this.mAccuseText);
        ((Button)localObject2).setTextColor(this.mAccuseIconColor);
        ((Button)localObject2).setContentDescription(this.mCancelText);
        localObject3 = this.onBottomAccuseListener;
        if (localObject3 != null) {
          ((Button)localObject2).setOnClickListener((View.OnClickListener)localObject3);
        }
      }
      localObject2 = (Button)((View)localObject1).findViewById(2131361988);
      ((Button)localObject2).setOnClickListener(this.onBottomCancelListener);
      ((Button)localObject2).setText(this.mCancelText);
      ((Button)localObject2).setContentDescription(this.mCancelText);
      this.mContentContainer.addView((View)localObject1);
    }
    this.mIsReady = true;
  }
  
  private void setOnTextImageFetched(CharSequence paramCharSequence, ActionSheet.OnTextImageFetchedListener paramOnTextImageFetchedListener)
  {
    if (paramCharSequence != null)
    {
      if (paramOnTextImageFetchedListener == null) {
        return;
      }
      int i = paramCharSequence.hashCode();
      this.mFetchListenerMap.put(Integer.valueOf(i), paramOnTextImageFetchedListener);
    }
  }
  
  private void updateRadioGroupButtonDesc(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getContext().getString(2131691130));
      localStringBuilder.append(paramTextView.getText());
      paramTextView.setContentDescription(localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getContext().getString(2131691132));
    localStringBuilder.append(paramTextView.getText());
    paramTextView.setContentDescription(localStringBuilder.toString());
  }
  
  public void addAccuseButton(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      this.mAccuseText = paramInt1;
      this.mAccuseIconColor = getActionButtonColorByType(paramInt2);
    }
  }
  
  public void addButton(int paramInt)
  {
    addButton(this.mResources.getText(paramInt), 0);
  }
  
  public void addButton(int paramInt1, int paramInt2)
  {
    addButton(this.mResources.getText(paramInt1), paramInt2);
  }
  
  public void addButton(int paramInt1, int paramInt2, @IdRes int paramInt3)
  {
    this.mIds.add(Integer.valueOf(paramInt3));
    addButton(paramInt1, paramInt2);
  }
  
  public void addButton(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    if (paramCharSequence != null)
    {
      if (this.mContents == null) {
        this.mContents = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt2));
      if (!this.mContents.contains(paramCharSequence)) {
        this.mContents.add(paramInt1, paramCharSequence);
      }
      if (!this.mRadioGroupMode) {
        return;
      }
      throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
    }
  }
  
  public void addButton(ActionMenuItem paramActionMenuItem, int paramInt)
  {
    if (paramActionMenuItem == null) {
      return;
    }
    this.mActionMenuMap.put(paramActionMenuItem.content, paramActionMenuItem);
    addButton(paramActionMenuItem.content, paramInt);
  }
  
  public void addButton(CharSequence paramCharSequence)
  {
    addButton(paramCharSequence, 0);
  }
  
  public void addButton(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence != null)
    {
      if (this.mContents == null) {
        this.mContents = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.mContents.contains(paramCharSequence)) {
        this.mContents.add(paramCharSequence);
      }
      if (!this.mRadioGroupMode) {
        return;
      }
      throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
    }
  }
  
  public void addButton(CharSequence paramCharSequence, int paramInt1, @IdRes int paramInt2)
  {
    addButton(paramCharSequence, paramInt1, paramInt2, Integer.valueOf(this.mResources.getColor(2131165231)));
  }
  
  public void addButton(CharSequence paramCharSequence, int paramInt1, @IdRes int paramInt2, Integer paramInteger)
  {
    this.mIds.add(Integer.valueOf(paramInt2));
    addButton(paramCharSequence, paramInt1);
    this.mSubTextColorArray.put(this.mContents.size() - 1, paramInteger);
  }
  
  public void addButton(CharSequence paramCharSequence, int paramInt, String paramString)
  {
    if (paramCharSequence != null)
    {
      if (this.mContents == null) {
        this.mContents = new ArrayList();
      }
      if (TextUtils.isEmpty(paramString)) {
        paramInt = 0;
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.mContents.contains(paramCharSequence)) {
        this.mContents.add(paramCharSequence);
      }
      if (paramInt == 9) {
        this.mTextColorMap.put(Integer.valueOf(this.mContents.size() - 1), paramString);
      }
      if (!this.mRadioGroupMode) {
        return;
      }
      throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
    }
  }
  
  public void addButtonWithIcon(CharSequence paramCharSequence, Drawable paramDrawable, int paramInt)
  {
    if (this.mContents == null) {
      this.mContents = new ArrayList();
    }
    paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
    if (!this.mContents.contains(paramCharSequence)) {
      this.mContents.add(paramCharSequence);
    }
    this.mIconsMap.put(Integer.valueOf(this.mContents.size() - 1), paramDrawable);
  }
  
  public void addButtonWithLeftIcon(String paramString, int paramInt1, int paramInt2)
  {
    if (this.mContents == null) {
      this.mContents = new ArrayList();
    }
    Object localObject = this.mResources.getDrawable(paramInt1);
    if (localObject == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("icon");
    localStringBuilder.append(paramString);
    paramString = new SpannableStringBuilder(localStringBuilder.toString());
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    localObject = new VerticalCenterImageSpan((Drawable)localObject, 0);
    ((VerticalCenterImageSpan)localObject).setPadding(0, QQUIDelegate.a(getContext(), 10.0F));
    paramString.setSpan(localObject, 0, 4, 18);
    paramString = new Pair(paramString, Integer.valueOf(paramInt2));
    if (!this.mContents.contains(paramString)) {
      this.mContents.add(paramString);
    }
  }
  
  public void addButtonWithLeftIcon(String paramString1, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.mContents == null) {
      this.mContents = new ArrayList();
    }
    if (paramDrawable == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      paramInt2 = 0;
    }
    paramString1 = new Pair(paramString1, Integer.valueOf(paramInt2));
    if (!this.mContents.contains(paramString1)) {
      this.mContents.add(paramString1);
    }
    if (paramInt2 == 9) {
      this.mTextColorMap.put(Integer.valueOf(this.mContents.size() - 1), paramString2);
    }
    this.mIconsLeftMap.put(Integer.valueOf(this.mContents.size() - 1), paramDrawable);
    this.mIconsLayoutLeftMap.put(Integer.valueOf(this.mContents.size() - 1), Integer.valueOf(paramInt1));
  }
  
  public void addButtonWithLeftUrlIcon(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    if (this.mContents == null) {
      this.mContents = new ArrayList();
    }
    Object localObject1 = new ColorDrawable(0);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
    localObject2 = URLDrawable.getDrawable(paramString2, (URLDrawable.URLDrawableOptions)localObject2);
    if (localObject2 != null) {
      ThreadManagerV2.executeOnSubThread(new ActionSheet.10(this, (URLDrawable)localObject2));
    }
    if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 1))
    {
      paramString2 = new Pair(buildLeftUrlIconCharSequence(paramString1, (Drawable)localObject2), Integer.valueOf(10));
    }
    else
    {
      localObject1 = new Pair(paramString1, Integer.valueOf(10));
      paramString2 = (String)localObject1;
      if (localObject2 != null)
      {
        this.mFetchDrawableMap.put(Integer.valueOf(paramString1.hashCode()), localObject2);
        paramString2 = (String)localObject1;
      }
    }
    if (!this.mContents.contains(paramString2)) {
      this.mContents.add(paramString2);
    }
  }
  
  public void addButtonWithRightIcon(String paramString, int paramInt1, int paramInt2)
  {
    if (this.mContents == null) {
      this.mContents = new ArrayList();
    }
    Object localObject1 = this.mResources.getDrawable(paramInt1);
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("icon");
    localObject2 = new SpannableStringBuilder(((StringBuilder)localObject2).toString());
    ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
    localObject1 = new VerticalCenterImageSpan((Drawable)localObject1, 0);
    ((VerticalCenterImageSpan)localObject1).setPadding(QQUIDelegate.a(getContext(), 10.0F), 0);
    ((SpannableStringBuilder)localObject2).setSpan(localObject1, paramString.length(), ((SpannableStringBuilder)localObject2).length(), 18);
    paramString = new Pair(localObject2, Integer.valueOf(paramInt2));
    if (!this.mContents.contains(paramString)) {
      this.mContents.add(paramString);
    }
  }
  
  public void addCancelButton(int paramInt)
  {
    addCancelButton(this.mResources.getText(paramInt));
  }
  
  public void addCancelButton(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.mCancelText = paramCharSequence;
    }
  }
  
  public void addRadioButton(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    addRadioButton(this.mResources.getText(paramInt1), paramInt2, paramBoolean);
  }
  
  public void addRadioButton(int paramInt, boolean paramBoolean)
  {
    addRadioButton(paramInt, 0, paramBoolean);
  }
  
  public void addRadioButton(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    addRadioButton(paramCharSequence, paramInt, paramBoolean, true);
  }
  
  public void addRadioButton(CharSequence paramCharSequence, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCharSequence != null)
    {
      if (!this.mRadioGroupMode)
      {
        ArrayList localArrayList = this.mContents;
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          throw new UnsupportedOperationException("ActionSheet is in normal button mode,shouldn't call addRadioButton!");
        }
      }
      if (this.mContents == null) {
        this.mContents = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.mContents.contains(paramCharSequence)) {
        this.mContents.add(paramCharSequence);
      }
      if (!paramBoolean2)
      {
        if (this.mUncheckeable == null) {
          this.mUncheckeable = new HashSet();
        }
        this.mUncheckeable.add(Integer.valueOf(this.mContents.size() - 1));
      }
      else if (paramBoolean1)
      {
        this.mCurrentSelectedViewId = (this.mContents.size() - 1);
      }
      this.mRadioGroupMode = true;
    }
  }
  
  public void addRadioButton(CharSequence paramCharSequence, boolean paramBoolean)
  {
    addRadioButton(paramCharSequence, 0, paramBoolean);
  }
  
  public void addView(View paramView)
  {
    this.mContentContainer.addView(paramView);
  }
  
  public void addViewCustomeTitle(View paramView)
  {
    this.mHasCustomeHeader = true;
    this.mContentContainer.addView(paramView);
  }
  
  public void clear()
  {
    this.mIsReady = false;
    this.mContents.clear();
    this.mActionMenuMap.clear();
    this.mIconsMap.clear();
    this.mIconsLeftMap.clear();
    this.mIconsLayoutLeftMap.clear();
    this.mTextColorMap.clear();
    this.mActionView.removeAllViews();
  }
  
  public void clearAllRadioBtnCheckStatus()
  {
    this.mCurrentSelectedViewId = -1;
    Object localObject = this.mRadioButtonMap;
    if (localObject == null) {
      return;
    }
    int j = ((SparseArray)localObject).size();
    int i = 0;
    while (i < j)
    {
      localObject = (View)this.mRadioButtonMap.valueAt(i);
      if (localObject != null)
      {
        ((View)localObject).findViewById(2131361990).setVisibility(8);
        updateRadioGroupButtonDesc((TextView)((View)localObject).findViewById(2131361989), false);
      }
      i += 1;
    }
  }
  
  public void disableAccessibilityForRootView()
  {
    ViewCompat.setImportantForAccessibility(this.mRootView.getChildAt(0), 2);
    ViewCompat.setImportantForAccessibility(this.mActionView, 2);
  }
  
  public void dismiss()
  {
    ActionSheet.WatchDismissActions localWatchDismissActions = this.mWatchDismissListener;
    if (localWatchDismissActions != null) {
      localWatchDismissActions.onDismissOperations();
    }
    if (this.mDismissFinish)
    {
      this.mDismissFinish = false;
      this.mHandler.postDelayed(new ActionSheet.7(this), 0L);
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((this.mCloseAutoRead) && (paramAccessibilityEvent.getEventType() == 32)) {
      return true;
    }
    super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Dialog.class.getName());
    return false;
  }
  
  protected int getActionButtonColorByType(int paramInt)
  {
    paramInt &= 0xFFFF;
    if (paramInt != 11)
    {
      switch (paramInt)
      {
      default: 
        return this.mResources.getColor(2131165226);
      case 8: 
        return this.mResources.getColor(2131165741);
      case 7: 
        return this.mResources.getColor(2131165226);
      case 6: 
        return this.mResources.getColor(2131165226);
      case 5: 
        return this.mResources.getColor(2131165226);
      case 4: 
        return this.mResources.getColor(2131165226);
      case 3: 
        return this.mResources.getColor(2131165230);
      case 2: 
        return this.mResources.getColor(2131165226);
      case 1: 
        return this.mResources.getColor(2131165226);
      }
      return this.mResources.getColor(2131165226);
    }
    return this.mResources.getColor(2131165232);
  }
  
  public RelativeLayout getActionContentView()
  {
    return this.mActionView;
  }
  
  public ActionMenuItem getActionMenuItem(int paramInt)
  {
    return getActionMenuItem(getContent(paramInt));
  }
  
  public ActionMenuItem getActionMenuItem(CharSequence paramCharSequence)
  {
    HashMap localHashMap = this.mActionMenuMap;
    if (localHashMap == null) {
      return null;
    }
    return (ActionMenuItem)localHashMap.get(paramCharSequence);
  }
  
  protected int getActionSheetCancelButtonLayoutId()
  {
    return 2131558467;
  }
  
  protected int getActionSheetCommonButtonLayoutId()
  {
    return 2131558470;
  }
  
  protected int getActionSheetTitleLayoutId()
  {
    return 2131558469;
  }
  
  public String getContent(int paramInt)
  {
    Object localObject = this.mContents;
    if ((localObject != null) && (paramInt < ((ArrayList)localObject).size()))
    {
      localObject = (Pair)this.mContents.get(paramInt);
      if (localObject != null) {
        return ((CharSequence)((Pair)localObject).first).toString();
      }
    }
    return null;
  }
  
  public ViewGroup getRootView()
  {
    return this.mRootView;
  }
  
  public Drawable getSelectorByType(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return this.mResources.getDrawable(2130837658);
          }
          return this.mResources.getDrawable(2130837662);
        }
        return this.mResources.getDrawable(2130837658);
      }
      return this.mResources.getDrawable(2130837677);
    }
    return this.mResources.getDrawable(2130837655);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.mIsMenuMode) {}
    try
    {
      dismiss();
      label11:
      return super.onPrepareOptionsMenu(paramMenu);
    }
    catch (Exception localException)
    {
      break label11;
    }
  }
  
  public void preInitView()
  {
    this.mRootView.setVisibility(8);
    prepareContentViews();
  }
  
  public void registerWatchDisMissActionListener(ActionSheet.WatchDismissActions paramWatchDismissActions)
  {
    this.mWatchDismissListener = paramWatchDismissActions;
  }
  
  public void reset()
  {
    clear();
    this.mMainTitle = null;
    this.mSecondaryTitle = null;
    this.mCancelText = null;
    this.mAccuseText = 0;
    this.mButtonsListener = null;
    this.mButtonsListenerV2 = null;
  }
  
  public void setActionContentView(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      this.mActionView.removeAllViews();
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      this.mActionView.addView(paramView, localLayoutParams);
    }
  }
  
  public void setAnimationTime(int paramInt)
  {
    if (paramInt > 0) {
      this.mAnimationTime = paramInt;
    }
  }
  
  public void setCloseAutoRead(boolean paramBoolean)
  {
    this.mCloseAutoRead = paramBoolean;
  }
  
  public void setContentView(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setContentView(View paramView)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  @Deprecated
  public void setHeaderView(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      this.mContentContainer.addView(paramView, 0, localLayoutParams);
    }
  }
  
  public void setMainTitle(int paramInt)
  {
    setMainTitle(this.mResources.getText(paramInt));
  }
  
  public void setMainTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.mMainTitle = paramCharSequence;
    }
  }
  
  public void setOnBottomAccuseListener(View.OnClickListener paramOnClickListener)
  {
    this.onBottomAccuseListener = paramOnClickListener;
  }
  
  public void setOnBottomCancelListener(View.OnClickListener paramOnClickListener)
  {
    this.onBottomCancelListener = paramOnClickListener;
  }
  
  public void setOnButtonClickListener(ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    this.mButtonsListener = paramOnButtonClickListener;
  }
  
  public void setOnButtonClickListenerV2(ActionSheet.OnButtonClickListenerV2 paramOnButtonClickListenerV2)
  {
    this.mButtonsListenerV2 = paramOnButtonClickListenerV2;
  }
  
  public void setOnDismissListener(ActionSheet.OnDismissListener paramOnDismissListener)
  {
    this.mDismissListener = paramOnDismissListener;
  }
  
  public void setOnPreShowListener(ActionSheet.onPreShowListener paramonPreShowListener)
  {
    this.mOnPreShowListener = paramonPreShowListener;
  }
  
  public void setOutsideDismissEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mRootView.setOnClickListener(this.mDefaultDismissListener);
      return;
    }
    this.mRootView.setOnClickListener(null);
  }
  
  public void setOutsideDismissEnableCompat(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.mRootView;
    if ((localViewGroup != null) && (localViewGroup.getChildAt(0) != null))
    {
      if (paramBoolean)
      {
        this.mRootView.getChildAt(0).setOnClickListener(this.mDefaultDismissListener);
        return;
      }
      this.mRootView.getChildAt(0).setOnClickListener(null);
    }
  }
  
  public void setRadioButtonChecked(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject = this.mContents;
      if ((localObject != null) && (paramInt < ((ArrayList)localObject).size()))
      {
        this.mCurrentSelectedViewId = paramInt;
        localObject = this.mRadioButtonMap;
        if (localObject != null)
        {
          localObject = (View)((SparseArray)localObject).get(this.mCurrentSelectedViewId);
          if (localObject != null)
          {
            ((View)localObject).findViewById(2131361990).setVisibility(0);
            updateRadioGroupButtonDesc((TextView)((View)localObject).findViewById(2131361989), true);
          }
        }
      }
    }
  }
  
  public void setRoundCornerTop(boolean paramBoolean)
  {
    this.mIsRoundCornerTop = paramBoolean;
  }
  
  public void setSecondaryTitle(int paramInt)
  {
    setSecondaryTitle(this.mResources.getText(paramInt));
  }
  
  public void setSecondaryTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.mSecondaryTitle = paramCharSequence;
    }
  }
  
  public void setSupportBottomRadius(boolean paramBoolean)
  {
    this.mSupportBottomRadius = paramBoolean;
  }
  
  public void setTitle(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitleEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    TextView localTextView = this.mainTitleText;
    if (localTextView != null)
    {
      localTextView.setMaxLines(1);
      this.mainTitleText.setEllipsize(paramTruncateAt);
      int i = QQUIDelegate.a(this.mContext, 18.0F);
      this.mainTitleText.setPadding(i, 0, i, 0);
    }
  }
  
  public void show()
  {
    this.mRootView.setVisibility(4);
    super.show();
    prepareContentViews();
    this.mHandler.postDelayed(new ActionSheet.6(this), 0L);
  }
  
  /* Error */
  public void superDismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1020	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 1025	com/tencent/qqperf/monitor/memory/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 1025	com/tencent/qqperf/monitor/memory/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   14: aload_1
    //   15: athrow
    //   16: astore_1
    //   17: goto -13 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	20	0	this	ActionSheet
    //   9	6	1	localObject	Object
    //   16	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   0	4	16	java/lang/Exception
  }
  
  public void updateAllButton()
  {
    this.mIsReady = false;
    this.mContentContainer.removeAllViews();
    prepareContentViews();
  }
  
  public void updateButton(int paramInt, CharSequence paramCharSequence)
  {
    updateButton(paramInt, paramCharSequence, 0);
  }
  
  public void updateButton(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      Object localObject = this.mContents;
      if ((localObject != null) && (paramInt1 < ((ArrayList)localObject).size()))
      {
        localObject = this.mContentContainer.findViewById(paramInt1);
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(2131361989);
          if ((localObject != null) && (TextView.class.isInstance(localObject)))
          {
            localObject = (TextView)localObject;
            ((TextView)localObject).setText(paramCharSequence);
            ((TextView)localObject).setTextColor(getActionButtonColorByType(paramInt2));
            paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt2));
            this.mContents.set(paramInt1, paramCharSequence);
          }
        }
      }
    }
  }
  
  public void updateUI()
  {
    this.mIsReady = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      invalidateOptionsMenu();
      return;
    }
    this.mActionView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ActionSheet
 * JD-Core Version:    0.7.0.1
 */