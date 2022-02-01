package com.tencent.qqmini.sdk.widget.actionsheet;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
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
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R.color;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.R.style;
import com.tencent.qqmini.sdk.core.utils.AccessibilityUtil;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.VerticalCenterImageSpan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ActionSheet
  extends ReportDialog
{
  public static final int BLUE_BOLD_STYLE_BTN = 6;
  public static final int BLUE_STYLE_BTN = 5;
  public static final int CUSTOM_TEXT_COLOR_BTN = 9;
  public static final int DEFAULT_STYLE_BTN = 0;
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
  public static final String TAG = "ActionSheet";
  @Deprecated
  public static final int WHITE_STYLE_BTN = 1;
  private TranslateAnimation animation;
  private HashMap<CharSequence, ActionMenuItem> mActionMenuMap = new HashMap();
  private RelativeLayout mActionView;
  private int mAnimationTime = 300;
  private View.OnClickListener mBtnClickListener = new ActionSheet.1(this);
  private ActionSheet.OnButtonClickListener mButtonsListener = null;
  private ActionSheet.OnButtonClickListenerV2 mButtonsListenerV2 = null;
  private Button mCancelBtn;
  private CharSequence mCancelText;
  private boolean mCloseAutoRead = false;
  public LinearLayout mContentContainer;
  private ArrayList<Pair<CharSequence, Integer>> mContents;
  private Context mContext;
  private int mCurrentSelectedViewId = -1;
  private View.OnClickListener mDefaultDismissListener = new ActionSheet.2(this);
  private boolean mDismissFinish = true;
  private ActionSheet.OnDismissListener mDismissListener = null;
  private Handler mHandler;
  private boolean mHasCustomeHeader;
  private HashMap<Integer, Integer> mIconsLayoutLeftMap = new HashMap();
  private HashMap<Integer, Drawable> mIconsLeftMap = new HashMap();
  private HashMap<Integer, Drawable> mIconsMap = new HashMap();
  private LayoutInflater mInflater;
  private boolean mIsMenuMode;
  public boolean mIsReady;
  private CharSequence mMainTitle;
  private ActionSheet.onPreShowListener mOnPreShowListener = null;
  private SparseArray<View> mRadioButtonMap;
  private boolean mRadioGroupMode = false;
  private Resources mResources;
  private ViewGroup mRootView;
  private CharSequence mSecondaryTitle;
  private boolean mShowAnimation = true;
  protected boolean mSupportBottomRadius = false;
  private HashMap<Integer, String> mTextColorMap = new HashMap();
  private HashSet<Integer> mUncheckeable;
  public Object mUserData;
  private ActionSheet.WatchDismissActions mWatchDismissListener = null;
  private TextView mainTitleText;
  private View.OnClickListener onBottomCancelListener;
  
  protected ActionSheet(Context paramContext)
  {
    this(paramContext, false, false);
  }
  
  protected ActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, true);
  }
  
  @TargetApi(14)
  protected ActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, R.style.mini_sdk_MenuDialogStyle);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    this.mContext = paramContext;
    this.mIsMenuMode = paramBoolean1;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mResources = paramContext.getResources();
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramBoolean3) && (DisplayUtil.isImmersiveSupported)) {
      getWindow().addFlags(67108864);
    }
    if (paramBoolean2)
    {
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
    }
    DisplayUtil.clearCoverForStatus(getWindow(), true);
    this.mRootView = ((ViewGroup)this.mInflater.inflate(R.layout.mini_sdk_action_sheet_base, null));
    super.setContentView(this.mRootView);
    this.mActionView = ((RelativeLayout)this.mRootView.findViewById(R.id.action_sheet_actionView));
    this.mContentContainer = ((LinearLayout)this.mRootView.findViewById(R.id.action_sheet_contentView));
    this.mRootView.getChildAt(0).setOnClickListener(this.mDefaultDismissListener);
    this.mActionView.setOnClickListener(null);
    this.onBottomCancelListener = this.mDefaultDismissListener;
  }
  
  private void addCanelIfNeeded()
  {
    if (this.mCancelText != null)
    {
      View localView = this.mInflater.inflate(R.layout.mini_sdk_action_sheet_cancel_button, null);
      Button localButton = (Button)localView.findViewById(R.id.action_sheet_btnCancel);
      localButton.setOnClickListener(this.onBottomCancelListener);
      localButton.setText(this.mCancelText);
      localButton.setContentDescription(this.mCancelText);
      this.mContentContainer.addView(localView);
    }
  }
  
  public static ActionSheet create(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(R.style.mini_sdk_ActionSheetAnimation);
    }
    return paramContext;
  }
  
  public static ActionSheet create(Context paramContext, boolean paramBoolean)
  {
    paramContext = new ActionSheet(paramContext, false, false, paramBoolean);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(R.style.mini_sdk_ActionSheetAnimation);
    }
    return paramContext;
  }
  
  public static ActionSheet createFullScreenDialog(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false, true);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(R.style.mini_sdk_ActionSheetAnimation);
    }
    return paramContext;
  }
  
  public static ActionSheet createFullScreenDialog(Context paramContext, boolean paramBoolean)
  {
    paramContext = new ActionSheet(paramContext, false, true, paramBoolean);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(R.style.mini_sdk_ActionSheetAnimation);
    }
    return paramContext;
  }
  
  public static ActionSheet createFullScreenMenuSheet(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, true, true);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(R.style.mini_sdk_ActionSheetAnimation);
    }
    return paramContext;
  }
  
  public static ActionSheet createMenuSheet(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, true, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(R.style.mini_sdk_ActionSheetAnimation);
    }
    return paramContext;
  }
  
  private int getActionButtonColorByType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
    case 0: 
      return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
    case 1: 
      return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
    case 2: 
      return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
    case 4: 
      return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
    case 3: 
      return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_red);
    case 5: 
      return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
    case 6: 
      return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
    case 7: 
      return this.mResources.getColor(R.color.mini_sdk_action_sheet_button_black);
    }
    return this.mResources.getColor(R.color.mini_sdk_item_press_color);
  }
  
  private void prepareContentViews()
  {
    if (this.mIsReady) {
      return;
    }
    View localView;
    TextView localTextView;
    if (this.mMainTitle != null)
    {
      localView = this.mInflater.inflate(R.layout.mini_sdk_action_sheet_title, null);
      localView.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.mini_sdk_actionsheet_bottom_bg_normal));
      localView.setOnClickListener(new ActionSheet.3(this));
      this.mainTitleText = ((TextView)localView.findViewById(R.id.action_sheet_title));
      this.mainTitleText.setVisibility(0);
      this.mainTitleText.setMaxLines(2147483647);
      this.mainTitleText.setText(this.mMainTitle);
      this.mainTitleText.setContentDescription(this.mMainTitle);
      if (this.mSecondaryTitle != null)
      {
        localTextView = (TextView)localView.findViewById(R.id.action_sheet_secondary_title);
        localTextView.setVisibility(0);
        localTextView.setText(this.mSecondaryTitle);
        localTextView.setContentDescription(this.mSecondaryTitle);
      }
      this.mContentContainer.addView(localView, 0);
    }
    for (int i = 1;; i = 0)
    {
      if (this.mHasCustomeHeader) {
        i = 1;
      }
      if (this.mContents != null)
      {
        int k = this.mContents.size();
        int m = this.mContents.size();
        int j = 0;
        while (j < m)
        {
          localView = this.mInflater.inflate(R.layout.mini_sdk_action_sheet_common_button, null);
          localTextView = (TextView)localView.findViewById(R.id.action_sheet_button);
          Pair localPair = (Pair)this.mContents.get(j);
          localTextView.setText((CharSequence)localPair.first);
          AccessibilityUtil.changeAccessibilityForView(localTextView, Button.class.getName());
          setTextViewId(localTextView, localPair);
          updateShowIcon(j, localView);
          setTextColor(j, localTextView, localPair);
          setSelector(i + k, m, j, localView);
          localView.setId(j);
          localView.setOnClickListener(this.mBtnClickListener);
          this.mContentContainer.addView(localView);
          updateRadioIfNeeded(j, localView, localTextView);
          j += 1;
        }
      }
      addCanelIfNeeded();
      this.mIsReady = true;
      return;
    }
  }
  
  private void setSelector(int paramInt1, int paramInt2, int paramInt3, View paramView)
  {
    Drawable localDrawable;
    if ((this.mSupportBottomRadius) && (paramInt1 > 1) && (paramInt3 == paramInt2 - 1) && (this.mCancelText == null)) {
      localDrawable = getSelectorByType(4);
    }
    for (;;)
    {
      paramView.setBackgroundDrawable(localDrawable);
      return;
      if ((paramInt3 == 0) && (paramInt1 == paramInt2) && (paramInt1 == 1)) {
        localDrawable = getSelectorByType(0);
      } else if ((paramInt3 == 0) && (paramInt1 == paramInt2) && (paramInt1 > 1)) {
        localDrawable = getSelectorByType(3);
      } else if ((paramInt3 == paramInt2 - 1) && (paramInt1 > 1)) {
        localDrawable = getSelectorByType(0);
      } else {
        localDrawable = getSelectorByType(3);
      }
    }
  }
  
  private void setTextColor(int paramInt, TextView paramTextView, Pair<CharSequence, Integer> paramPair)
  {
    if (((Integer)paramPair.second).intValue() == 9)
    {
      if (this.mTextColorMap.containsKey(Integer.valueOf(paramInt))) {
        paramTextView.setTextColor(Color.parseColor((String)this.mTextColorMap.get(Integer.valueOf(paramInt))));
      }
      return;
    }
    paramTextView.setTextColor(getActionButtonColorByType(((Integer)paramPair.second).intValue()));
  }
  
  private void setTextViewId(TextView paramTextView, Pair<CharSequence, Integer> paramPair)
  {
    if ((this.mActionMenuMap != null) && (this.mActionMenuMap.size() > 0))
    {
      paramPair = (ActionMenuItem)this.mActionMenuMap.get(paramPair.first);
      if ((paramPair != null) && (paramPair.viewid != 0)) {
        paramTextView.setId(paramPair.viewid);
      }
    }
  }
  
  private void updateRadioGroupButtonDesc(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramTextView.setContentDescription(getContext().getString(R.string.mini_sdk_content_desc_selected) + paramTextView.getText());
      return;
    }
    paramTextView.setContentDescription(getContext().getString(R.string.mini_sdk_content_desc_unselected) + paramTextView.getText());
  }
  
  private void updateRadioIfNeeded(int paramInt, View paramView, TextView paramTextView)
  {
    if (this.mRadioGroupMode)
    {
      if (this.mRadioButtonMap == null) {
        this.mRadioButtonMap = new SparseArray();
      }
      this.mRadioButtonMap.append(paramInt, paramView);
      if (paramInt == this.mCurrentSelectedViewId)
      {
        paramView.findViewById(R.id.action_sheet_checkedIcon).setVisibility(0);
        updateRadioGroupButtonDesc(paramTextView, true);
      }
    }
    else
    {
      return;
    }
    updateRadioGroupButtonDesc(paramTextView, false);
  }
  
  private void updateShowIcon(int paramInt, View paramView)
  {
    Object localObject = (ImageView)paramView.findViewById(R.id.action_sheet_showIcon);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    localLayoutParams.rightMargin = DisplayUtil.dip2px(this.mContext, 15.0F);
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    if (this.mIconsMap.containsKey(Integer.valueOf(paramInt)))
    {
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setImageDrawable((Drawable)this.mIconsMap.get(Integer.valueOf(paramInt)));
    }
    for (;;)
    {
      paramView = (ImageView)paramView.findViewById(R.id.action_sheet_showIcon_Left);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if ((this.mIconsLayoutLeftMap.containsKey(Integer.valueOf(paramInt))) && (((Integer)this.mIconsLayoutLeftMap.get(Integer.valueOf(paramInt))).intValue() == 0))
      {
        ((RelativeLayout.LayoutParams)localObject).width = DisplayUtil.dip2px(this.mContext, 28.0F);
        ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.dip2px(this.mContext, 28.0F);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
      }
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(this.mContext, 5.0F);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (!this.mIconsLeftMap.containsKey(Integer.valueOf(paramInt))) {
        break;
      }
      paramView.setVisibility(0);
      paramView.setImageDrawable((Drawable)this.mIconsLeftMap.get(Integer.valueOf(paramInt)));
      return;
      ((ImageView)localObject).setImageDrawable(null);
      ((ImageView)localObject).setVisibility(8);
    }
    paramView.setImageDrawable(null);
    paramView.setVisibility(8);
  }
  
  public void addButton(int paramInt)
  {
    addButton(this.mResources.getText(paramInt), 0);
  }
  
  public void addButton(int paramInt1, int paramInt2)
  {
    addButton(this.mResources.getText(paramInt1), paramInt2);
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
      if (this.mRadioGroupMode) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
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
      if (this.mRadioGroupMode) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
    }
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
      if (this.mRadioGroupMode) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
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
    if (localObject == null) {}
    do
    {
      return;
      paramString = new SpannableStringBuilder("icon" + paramString);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      localObject = new VerticalCenterImageSpan((Drawable)localObject, 0);
      ((VerticalCenterImageSpan)localObject).setPadding(0, DisplayUtil.dip2px(this.mContext, 10.0F));
      paramString.setSpan(localObject, 0, "icon".length(), 18);
      paramString = new Pair(paramString, Integer.valueOf(paramInt2));
    } while (this.mContents.contains(paramString));
    this.mContents.add(paramString);
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
  
  public void addButtonWithRightIcon(String paramString, int paramInt1, int paramInt2)
  {
    if (this.mContents == null) {
      this.mContents = new ArrayList();
    }
    Object localObject = this.mResources.getDrawable(paramInt1);
    if (localObject == null) {}
    do
    {
      return;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString + "icon");
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      localObject = new VerticalCenterImageSpan((Drawable)localObject, 0);
      ((VerticalCenterImageSpan)localObject).setPadding(DisplayUtil.dip2px(this.mContext, 10.0F), 0);
      localSpannableStringBuilder.setSpan(localObject, paramString.length(), localSpannableStringBuilder.length(), 18);
      paramString = new Pair(localSpannableStringBuilder, Integer.valueOf(paramInt2));
    } while (this.mContents.contains(paramString));
    this.mContents.add(paramString);
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
      if ((!this.mRadioGroupMode) && (this.mContents != null) && (this.mContents.size() > 0)) {
        throw new UnsupportedOperationException("ActionSheet is in normal button mode,shouldn't call addRadioButton!");
      }
      if (this.mContents == null) {
        this.mContents = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.mContents.contains(paramCharSequence)) {
        this.mContents.add(paramCharSequence);
      }
      if (paramBoolean2) {
        break label139;
      }
      if (this.mUncheckeable == null) {
        this.mUncheckeable = new HashSet();
      }
      this.mUncheckeable.add(Integer.valueOf(this.mContents.size() - 1));
    }
    for (;;)
    {
      this.mRadioGroupMode = true;
      return;
      label139:
      if (paramBoolean1) {
        this.mCurrentSelectedViewId = (this.mContents.size() - 1);
      }
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
    if (this.mRadioButtonMap == null) {}
    for (;;)
    {
      return;
      int j = this.mRadioButtonMap.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)this.mRadioButtonMap.valueAt(i);
        if (localView != null)
        {
          localView.findViewById(R.id.action_sheet_checkedIcon).setVisibility(8);
          updateRadioGroupButtonDesc((TextView)localView.findViewById(R.id.action_sheet_button), false);
        }
        i += 1;
      }
    }
  }
  
  public void disableAccessibilityForRootView()
  {
    ViewCompat.setImportantForAccessibility(this.mRootView.getChildAt(0), 2);
    ViewCompat.setImportantForAccessibility(this.mActionView, 2);
  }
  
  public void dismiss()
  {
    if (this.mWatchDismissListener != null) {
      this.mWatchDismissListener.onDismissOperations();
    }
    if (this.mDismissFinish)
    {
      this.mDismissFinish = false;
      this.mHandler.postDelayed(new ActionSheet.5(this), 0L);
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
    if (this.mActionMenuMap == null) {
      return null;
    }
    return (ActionMenuItem)this.mActionMenuMap.get(paramCharSequence);
  }
  
  public String getContent(int paramInt)
  {
    if ((this.mContents != null) && (paramInt < this.mContents.size()))
    {
      Pair localPair = (Pair)this.mContents.get(paramInt);
      if (localPair != null) {
        return ((CharSequence)localPair.first).toString();
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
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return this.mResources.getDrawable(R.drawable.mini_sdk_actionsheet_bottom);
    case 0: 
      return this.mResources.getDrawable(R.drawable.mini_sdk_actionsheet_bg);
    case 3: 
      return this.mResources.getDrawable(R.drawable.mini_sdk_actionsheet_bottom);
    }
    return this.mResources.getDrawable(R.drawable.mini_sdk_actionsheet_bottom_radius);
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
    if ((this.mRootView != null) && (this.mRootView.getChildAt(0) != null))
    {
      if (paramBoolean) {
        this.mRootView.getChildAt(0).setOnClickListener(this.mDefaultDismissListener);
      }
    }
    else {
      return;
    }
    this.mRootView.getChildAt(0).setOnClickListener(null);
  }
  
  public void setRadioButtonChecked(int paramInt)
  {
    if ((paramInt >= 0) && (this.mContents != null) && (paramInt < this.mContents.size()))
    {
      this.mCurrentSelectedViewId = paramInt;
      if (this.mRadioButtonMap != null)
      {
        View localView = (View)this.mRadioButtonMap.get(this.mCurrentSelectedViewId);
        if (localView != null)
        {
          localView.findViewById(R.id.action_sheet_checkedIcon).setVisibility(0);
          updateRadioGroupButtonDesc((TextView)localView.findViewById(R.id.action_sheet_button), true);
        }
      }
    }
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
    if (this.mainTitleText != null)
    {
      this.mainTitleText.setMaxLines(1);
      this.mainTitleText.setEllipsize(paramTruncateAt);
      int i = DisplayUtil.dip2px(this.mContext, 18.0F);
      this.mainTitleText.setPadding(i, 0, i, 0);
    }
  }
  
  public void show()
  {
    this.mRootView.setVisibility(0);
    super.show();
    prepareContentViews();
    this.mHandler.postDelayed(new ActionSheet.4(this), 0L);
  }
  
  /* Error */
  public void superDismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 876	android/app/Dialog:dismiss	()V
    //   4: return
    //   5: astore_1
    //   6: aload_1
    //   7: athrow
    //   8: astore_1
    //   9: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10	0	this	ActionSheet
    //   5	2	1	localObject	Object
    //   8	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	5	finally
    //   0	4	8	java/lang/Exception
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
    if ((paramInt1 >= 0) && (this.mContents != null) && (paramInt1 < this.mContents.size()))
    {
      Object localObject = this.mContentContainer.findViewById(paramInt1);
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(R.id.action_sheet_button);
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
 * Qualified Name:     com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet
 * JD-Core Version:    0.7.0.1
 */