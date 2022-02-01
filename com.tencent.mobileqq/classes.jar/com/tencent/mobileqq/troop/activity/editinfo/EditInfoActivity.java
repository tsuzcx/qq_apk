package com.tencent.mobileqq.troop.activity.editinfo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.editservice.EditFriendRemarkService;
import com.tencent.mobileqq.activity.editservice.EditMyNickService;
import com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.Builder;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.editservice.EditTroopFingerMemoService;
import com.tencent.mobileqq.troop.activity.editservice.EditTroopNameService;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.onSizeChangeListenner;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@RoutePage(desc="编辑提交界面", path="/base/activity/editInfoActivity")
public class EditInfoActivity
  extends QIphoneTitleBarActivity
  implements IEditInfoActivity, InputMethodLinearLayout.onSizeChangeListenner
{
  public static final int EDIT_NORMAL_HEIGHT = 149;
  public static final String PARAMS_KEY_NEED_HIDE_COUSER_WHEN_EMOJ = "key_need_hide_couser_when_emoj";
  private static final String TAG = "EditInfoActivity";
  @ConfigInject(configPath="/Business/qqtroop-impl/src/main/resources/Inject_editInfo_map.yml", version=4)
  public static HashMap<String, Class<? extends IEditInfoApi>> mInjectEditInfos = new HashMap();
  IEditInfoApi editInfoApi;
  Drawable mAnimDrawable3;
  private AppRuntime mApp;
  private boolean mCanPostNull;
  private int mCountType = 0;
  private String mDefStr;
  private EditText mEditInfo;
  private int mEditMode = 0;
  LinearLayout mEmojLayout = null;
  SystemAndEmojiUniversalPanel mEmojPanel = null;
  protected int mFromFlag = -1;
  private String mHitStr;
  private boolean mIsEditMode;
  boolean mIsFullScreen = false;
  protected boolean mIsShowEmojiboard = false;
  private final int mMaxLimitMode = 0;
  private int mMaxNum = 90;
  boolean mNeedEmo = false;
  private TextView mNum;
  private String mRightStr;
  InputMethodLinearLayout mRoot;
  protected int mSubType = -1;
  ImageView mSwitchButton;
  private String mTitleStr;
  protected int mType = -1;
  
  static
  {
    mInjectEditInfos.put("5", EditTroopMemberNickService.class);
    mInjectEditInfos.put("4", EditFriendRemarkService.class);
    mInjectEditInfos.put("3", EditMyNickService.class);
    mInjectEditInfos.put("2", EditTroopFingerMemoService.class);
    mInjectEditInfos.put("1", EditTroopNameService.class);
  }
  
  private void dispatchEvent(int paramInt)
  {
    Object localObject = this.editInfoApi;
    if (localObject != null)
    {
      ((IEditInfoApi)localObject).a(paramInt);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("editInfoApi == null type = ");
      ((StringBuilder)localObject).append(getIntent().getIntExtra("edit_type", 0));
      QLog.i("EditInfoActivity", 2, ((StringBuilder)localObject).toString());
    }
    finish();
  }
  
  public static IEditInfoApi getApi(int paramInt)
  {
    Object localObject1 = String.valueOf(paramInt);
    Object localObject2 = mInjectEditInfos;
    if (localObject2 != null)
    {
      if (((HashMap)localObject2).size() <= 0) {
        return null;
      }
      localObject2 = (Class)mInjectEditInfos.get(localObject1);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getApi, clazz=null, type=");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("EditInfoActivity", 2, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
      try
      {
        localObject1 = ((Class)localObject2).getDeclaredConstructor(new Class[0]);
        ((Constructor)localObject1).setAccessible(true);
        localObject1 = (IEditInfoApi)((Constructor)localObject1).newInstance(new Object[0]);
        return localObject1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getApi Exception");
          ((StringBuilder)localObject2).append(localException);
          QLog.d("EditInfoActivity", 2, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
    }
    return null;
  }
  
  private int getLength(QQText paramQQText)
  {
    int i;
    if (paramQQText != null)
    {
      Object localObject = this.editInfoApi;
      if (localObject == null) {
        return 0;
      }
      try
      {
        if (this.mCountType == 2) {
          i = ((IEditInfoApi)localObject).a();
        } else if (this.mCountType == 0) {
          i = paramQQText.toString().getBytes("utf-8").length;
        } else {
          i = paramQQText.toString().length();
        }
      }
      catch (Exception paramQQText)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getLength error");
          ((StringBuilder)localObject).append(paramQQText);
          QLog.e("EditInfoActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    else
    {
      return 0;
    }
    return i;
  }
  
  private void initData()
  {
    Intent localIntent = getIntent();
    this.editInfoApi.a(localIntent);
    this.mEditMode = localIntent.getIntExtra("edit_mode", this.mEditMode);
    this.mMaxNum = localIntent.getIntExtra("max_num", this.mMaxNum);
    this.mDefStr = localIntent.getStringExtra("default_text");
    this.mHitStr = localIntent.getStringExtra("default_hint");
    this.mTitleStr = localIntent.getStringExtra("title");
    this.mIsFullScreen = localIntent.getBooleanExtra("full_screen", false);
    this.mRightStr = localIntent.getStringExtra("right_btn");
    this.mCountType = localIntent.getIntExtra("count_type", 0);
    this.mCanPostNull = localIntent.getBooleanExtra("canPostNull", true);
    this.mIsEditMode = localIntent.getBooleanExtra("edit_mode", true);
    this.mNeedEmo = localIntent.getBooleanExtra("support_emotion", false);
    this.mType = localIntent.getIntExtra("edit_type", 0);
  }
  
  private void initEditInfo()
  {
    int i = this.mEditMode;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          finish();
          return;
        }
        showAutoEditer();
      }
      else
      {
        showMultiEditer();
      }
    }
    else {
      showSingEditer();
    }
    this.mEditInfo.setOnClickListener(this.editInfoApi.a());
    if (!this.mIsEditMode) {
      noEdit();
    }
  }
  
  private void initEditInfoApi()
  {
    Intent localIntent = getIntent();
    this.editInfoApi = getApi(localIntent.getIntExtra("edit_type", 0));
    Object localObject = this.editInfoApi;
    if (localObject != null)
    {
      ((IEditInfoApi)localObject).a(this);
      dispatchEvent(0);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initEditInfoApi error:");
      ((StringBuilder)localObject).append(localIntent.getIntExtra("edit_type", 0));
      QLog.e("EditInfoActivity", 2, ((StringBuilder)localObject).toString());
    }
    finish();
  }
  
  private void initEditNum()
  {
    this.mEditInfo = ((EditText)super.findViewById(2131366086));
    this.mNum = ((TextView)super.findViewById(2131366087));
    this.mEditInfo.addTextChangedListener(new EditInfoActivity.5(this));
    initEditStr();
  }
  
  private void initTitleBar()
  {
    Object localObject = findViewById(2131376636);
    if ((localObject instanceof NavBarCommon))
    {
      NavBarCommon localNavBarCommon = (NavBarCommon)localObject;
      localObject = this.mTitleStr;
      if (localObject != null) {
        localNavBarCommon.setTitle((CharSequence)localObject);
      }
      localObject = this.mRightStr;
      if (localObject == null) {
        localObject = getString(2131696100);
      }
      localNavBarCommon.setRightButton((String)localObject);
      localNavBarCommon.setOnItemSelectListener(this.editInfoApi.a());
      if (!this.mIsEditMode) {
        localNavBarCommon.setRightViewTextVisible(8);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("EditInfoActivity", 2, "NavBarCommon=null");
    }
  }
  
  private void initUi()
  {
    initEditInfo();
    initTitleBar();
    RelativeLayout localRelativeLayout1 = (RelativeLayout)super.findViewById(2131366072);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)super.findViewById(2131366047);
    View localView = findViewById(2131364829);
    if (localView == null) {
      setContentBackgroundResource(2130838739);
    } else if (ThemeUtil.isInNightMode(this.mApp)) {
      localView.setVisibility(0);
    } else {
      localView.setVisibility(8);
    }
    this.editInfoApi.a(localRelativeLayout1, this.mEditInfo, localRelativeLayout2);
  }
  
  private void noEdit()
  {
    this.mNum.setVisibility(4);
    this.mEditInfo.clearFocus();
    this.mEditInfo.setFocusable(false);
    this.mEditInfo.setFocusableInTouchMode(false);
    this.mEditInfo.setOnLongClickListener(new EditInfoActivity.1(this));
    this.mEditInfo.setLongClickable(false);
    this.mEditInfo.setTextIsSelectable(false);
    this.mEditInfo.setCustomSelectionActionModeCallback(null);
  }
  
  private void showAutoEditer()
  {
    showSingEditer();
  }
  
  private void showMultiEditer()
  {
    super.setContentView(2131559082);
    this.mRoot = ((InputMethodLinearLayout)super.findViewById(2131376809));
    this.mRoot.setOnSizeChangedListenner(this);
    initEditNum();
    if (!this.mIsFullScreen)
    {
      this.mEditInfo.getLayoutParams().height = ((int)DisplayUtils.a(this, 149.0F));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mRoot.findViewById(2131366073).getLayoutParams();
      localLayoutParams.height = ((int)DisplayUtils.a(this, 151.0F));
      localLayoutParams.weight = 0.0F;
    }
    this.mEditInfo.setEditableFactory(new EditInfoActivity.2(this));
    if (this.mNeedEmo) {
      initEmoj();
    }
  }
  
  private void showSingEditer()
  {
    super.setContentView(2131559083);
    initEditNum();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    IEditInfoApi localIEditInfoApi = this.editInfoApi;
    if (localIEditInfoApi != null) {
      localIEditInfoApi.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mApp = MobileQQ.sMobileQQ.waitAppRuntime(null);
    super.doOnCreate(paramBundle);
    initEditInfoApi();
    if (this.editInfoApi == null)
    {
      finish();
      return false;
    }
    initData();
    initUi();
    if (!this.mIsEditMode) {
      getWindow().setSoftInputMode(3);
    }
    return true;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    dispatchEvent(2);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.mIsEditMode)
    {
      this.mEditInfo.requestFocus();
      showInputMethod();
    }
    else
    {
      hideInputMethod();
    }
    dispatchEvent(1);
  }
  
  public void finish()
  {
    dispatchEvent(3);
    hideInputMethod();
    super.finish();
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public String getText()
  {
    EditText localEditText = this.mEditInfo;
    if (localEditText != null) {
      return localEditText.getText().toString();
    }
    return null;
  }
  
  public TextView getTipsView()
  {
    return (TextView)findViewById(2131366085);
  }
  
  public void hideInputMethod()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  void initEditStr()
  {
    this.mEditInfo.setHint(this.mHitStr);
    if (!TextUtils.isEmpty(this.mDefStr))
    {
      this.mEditInfo.setText(this.mDefStr);
      Selection.setSelection(this.mEditInfo.getEditableText(), this.mEditInfo.getText().length());
    }
  }
  
  void initEmoj()
  {
    this.mEmojLayout = ((LinearLayout)super.findViewById(2131366151));
    this.mSwitchButton = ((ImageView)findViewById(2131378167));
    this.mSwitchButton.setVisibility(0);
    this.mSwitchButton.setOnClickListener(new EditInfoActivity.3(this));
    this.mEmojPanel = new SystemAndEmojiUniversalPanel.Builder(this).setFilterSysFaceBeyond255Enable(true).setEmoticonCallback(this.editInfoApi.a()).setShowDeleteButton(this.mEditInfo).create(((IEmoticonMainPanelAppService)QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(this.mApp));
    this.mEmojPanel.setVisibility(0);
    this.mEmojLayout.addView(this.mEmojPanel);
    this.mEditInfo.setOnClickListener(new EditInfoActivity.4(this));
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void loadingProgress(boolean paramBoolean)
  {
    if (this.centerView == null) {
      this.centerView = ((TextView)findViewById(2131369249));
    }
    if (paramBoolean)
    {
      this.rightViewText.setEnabled(false);
      if (this.mAnimDrawable3 == null)
      {
        this.mAnimDrawable3 = getResources().getDrawable(2130839401);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.mAnimDrawable3, null, null, null);
        ((Animatable)this.mAnimDrawable3).start();
      }
    }
    else
    {
      this.rightViewText.setEnabled(true);
      Drawable localDrawable = this.mAnimDrawable3;
      if (localDrawable != null)
      {
        ((Animatable)localDrawable).stop();
        this.mAnimDrawable3 = null;
        this.centerView.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onFinish()
  {
    finish();
  }
  
  public void onFinishForResult(int paramInt, Intent paramIntent)
  {
    hideInputMethod();
    if (paramIntent != null) {
      paramIntent.putExtra("edit_type", this.mType);
    }
    setResult(paramInt, paramIntent);
    finish();
  }
  
  public void onSizeChange(boolean paramBoolean)
  {
    if (this.mRoot == null) {
      return;
    }
    LinearLayout localLinearLayout;
    if (paramBoolean)
    {
      localLinearLayout = this.mEmojLayout;
      if ((localLinearLayout != null) && (this.mSwitchButton != null))
      {
        localLinearLayout.setVisibility(8);
        this.mSwitchButton.setImageResource(2130848134);
        this.mSwitchButton.setContentDescription(HardCodeUtil.a(2131703791));
      }
    }
    else if (this.mIsShowEmojiboard)
    {
      localLinearLayout = this.mEmojLayout;
      if (localLinearLayout != null) {
        localLinearLayout.setVisibility(0);
      }
    }
  }
  
  public void showInputMethod()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((this.mEditInfo != null) && (this.mIsEditMode))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditInfoActivity", 2, "showInputMethod()");
      }
      localInputMethodManager.showSoftInput(this.mEditInfo, 2);
    }
  }
  
  public void updateEditTextAndNum(CharSequence paramCharSequence)
  {
    paramCharSequence = new QQText(paramCharSequence, 3);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      this.mNum.setText(String.valueOf(this.mMaxNum));
      this.mNum.setTextColor(Color.rgb(119, 119, 119));
      this.rightViewText.setEnabled(this.mCanPostNull);
      return;
    }
    int i = getLength(paramCharSequence);
    String str = String.valueOf(this.mMaxNum - i);
    paramCharSequence = str;
    if (str.length() > 4)
    {
      paramCharSequence = new StringBuilder();
      paramCharSequence.append(str.substring(0, 2));
      paramCharSequence.append("…");
      paramCharSequence = paramCharSequence.toString();
    }
    this.mNum.setText(paramCharSequence);
    if (i > this.mMaxNum)
    {
      this.mNum.setTextColor(-65536);
      this.rightViewText.setEnabled(false);
      return;
    }
    this.mNum.setTextColor(Color.rgb(119, 119, 119));
    this.rightViewText.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editinfo.EditInfoActivity
 * JD-Core Version:    0.7.0.1
 */