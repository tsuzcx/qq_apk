package com.tencent.mobileqq.campuscircle;

import abpl;
import abpm;
import abpn;
import abpo;
import abpp;
import abpq;
import abpr;
import abps;
import abpt;
import abpu;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.DynamicGridView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.PrefixXEditText;
import com.tencent.widget.ScrollView;
import com.tencent.widget.ScrollView.OnScrollStateChangedListener;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CampusCirclePublishActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener, EmoticonCallback, ActionSheet.OnButtonClickListener, ScrollView.OnScrollStateChangedListener, XPanelContainer.PanelCallback
{
  int jdField_a_of_type_Int = 0;
  abpu jdField_a_of_type_Abpu;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new abpm(this);
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new abpn(this);
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new abpr(this);
  public ViewGroup a;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public CampusCircleHandler a;
  public CampusCircleManager a;
  CampusCircleObserver jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver = new abps(this);
  CampusCirclePublishActivity.PublicityTopic jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic = null;
  CampusTopic jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic = null;
  TopicAdapter jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter;
  SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  public WeakReferenceHandler a;
  public ActionSheet a;
  public DynamicGridView a;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  public PrefixXEditText a;
  public ScrollView a;
  XPanelContainer jdField_a_of_type_ComTencentWidgetXPanelContainer;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  public ViewGroup b;
  ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  public ViewGroup c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  boolean jdField_d_of_type_Boolean = false;
  public int e;
  boolean e;
  public int f = 0;
  int g = 0;
  
  public CampusCirclePublishActivity()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130842351);
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 1)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131433396));
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130842352);
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 3)) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131433395));
  }
  
  @TargetApi(14)
  private void b(CampusTopic paramCampusTopic)
  {
    if ((paramCampusTopic != null) && (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic != null) && (paramCampusTopic.id == this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic.id)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("CampusCircle", 4, "updateTopicLine same topic");
      }
    }
    do
    {
      CampusTopic localCampusTopic;
      do
      {
        return;
        localCampusTopic = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic;
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic = paramCampusTopic;
        if (QLog.isDevelopLevel()) {
          QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "updateTopicLine mIsWindowShow: %b pre: %s cur: %s", new Object[] { Boolean.valueOf(this.jdField_e_of_type_Boolean), localCampusTopic, this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic }));
        }
        if (!this.jdField_e_of_type_Boolean) {
          break label378;
        }
        if ((localCampusTopic != null) || (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic, this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic);
        if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
        {
          this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 2.0F });
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
        }
        if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
          this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
        }
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      } while (!QLog.isDevelopLevel());
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "start animation-1 %s", new Object[] { this.jdField_a_of_type_AndroidAnimationValueAnimator }));
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic != null) || (localCampusTopic == null)) {
        break;
      }
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 2.0F, 1.0F, 0.0F });
        this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
        this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
        this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
      }
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    } while (!QLog.isDevelopLevel());
    QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "start animation-2 %s", new Object[] { this.jdField_b_of_type_AndroidAnimationValueAnimator }));
    return;
    i();
    return;
    label378:
    i();
  }
  
  @TargetApi(14)
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic == null)
    {
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.notifyDataSetChanged();
    }
    for (int i = this.f;; i = this.jdField_e_of_type_Int)
    {
      this.jdField_c_of_type_AndroidViewViewGroup.setAlpha(1.0F);
      this.jdField_b_of_type_AndroidViewViewGroup.setAlpha(1.0F);
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      localLayoutParams.width = -1;
      if (localLayoutParams.height != i)
      {
        localLayoutParams.height = i;
        this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "doUpdateTopicLine cur: %s height: %d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic, Integer.valueOf(localLayoutParams.height) }));
      }
      return;
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic, this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic);
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        if (QLog.isDevelopLevel()) {
          QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "picPhotoActionSheet click  %d", new Object[] { Integer.valueOf(paramInt) }));
        }
        return;
        paramView = new ArrayList();
        int i = 0;
        while (i < this.jdField_a_of_type_Abpu.a())
        {
          localObject = (String)this.jdField_a_of_type_Abpu.getItem(i);
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
            paramView.add(localObject);
          }
          i += 1;
        }
        Object localObject = new Intent(this, PhotoListActivity.class);
        ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getClass().getName());
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", false);
        ((Intent)localObject).putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
        ((Intent)localObject).putExtra("album_enter_directly", true);
        ((Intent)localObject).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
        ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramView);
        startActivity((Intent)localObject);
        AlbumUtil.a(this, true, true);
        a("0X800809B");
      }
    }
    if (this.jdField_a_of_type_Abpu.a() < 9) {}
    for (;;)
    {
      try
      {
        f();
        a("0X800809C");
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        continue;
      }
      a(true, 0, "最多只能选择9张图片", 0);
    }
  }
  
  public View a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "onCreatePanel panelId: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (paramInt == 3)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(this, this);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setBackgroundColor(getResources().getColor(2131493381));
      }
      return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
    }
    return null;
  }
  
  void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, "initAsync");
    }
    ThreadManager.post(new abpo(this), 5, null, true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "onPanelChanged oldPanel: %d  newPanel: %d hasFocus: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.hasFocus()) }));
    }
    if ((paramInt1 == 0) && (paramInt2 != 0) && (!this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.hasFocus()))
    {
      this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.requestFocus();
      this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.setSelection(this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.getText().length());
    }
    if (paramInt2 == 1) {
      a(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt2;
      if (this.jdField_b_of_type_Int == 0) {
        break;
      }
      this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      if (paramInt2 == 3) {
        a(1);
      }
    }
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  void a(CampusTopic paramCampusTopic)
  {
    Resources localResources = getResources();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_e_of_type_Int = localResources.getDimensionPixelSize(2131559412);
    this.f = (this.jdField_e_of_type_Int * 2 + 1);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131364074));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)findViewById(2131363769));
    this.jdField_a_of_type_ComTencentWidgetPrefixXEditText = ((PrefixXEditText)findViewById(2131368332));
    this.jdField_a_of_type_ComTencentWidgetDynamicGridView = ((DynamicGridView)findViewById(2131368830));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131364075));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131369919));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131369920));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369921));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131369913));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369914));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369910));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369909));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369918));
    this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366645).setOnClickListener(this);
    ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369911)).setOnClickListener(this);
    h();
    int i = localResources.getColor(2131493382);
    getTitleBarView().setBackgroundDrawable(localResources.getDrawable(2130842360));
    if (this.mSystemBarComp == null) {
      setImmersiveStatus(i);
    }
    for (;;)
    {
      setTitle("");
      setLeftButton(2131433015, this);
      this.leftViewNotBack.setBackgroundDrawable(null);
      this.leftViewNotBack.setTextSize(1, 17.0F);
      this.leftViewNotBack.setTextColor(localResources.getColorStateList(2131494127));
      setRightButton(2131438296, this);
      this.rightViewText.setBackgroundDrawable(null);
      this.rightViewText.setTextSize(1, 17.0F);
      this.rightViewText.setTextColor(localResources.getColorStateList(2131494127));
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(3);
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic != null) && (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic.jdField_a_of_type_JavaLangString != null))
        {
          this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.setPrefix(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic.jdField_a_of_type_JavaLangString, Color.parseColor("#00a5e0"));
          this.g = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic.jdField_a_of_type_JavaLangString.length();
        }
        this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.setEditableFactory(QQTextBuilder.a);
        localObject = this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.getPaint().getFontMetrics();
        float f1 = ((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top;
        i = (int)(1.4F * f1 * 4.0F) + (int)(0.5F * f1);
        this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
        if (QLog.isDevelopLevel()) {
          QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "initUI oneLineHeight: %f %d", new Object[] { Float.valueOf(f1), Integer.valueOf(i) }));
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject;
          int j;
          int k;
          int m;
          localThrowable.printStackTrace();
          QLog.e("CampusCircle", 1, "input set error", localThrowable);
        }
      }
      this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.addTextChangedListener(this);
      this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.setMovementMethod(ScrollingMovementMethod.getInstance());
      this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.setOnTouchListener(new abpl(this));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetPrefixXEditText);
      a(0);
      localObject = localResources.getDisplayMetrics();
      i = localResources.getDimensionPixelSize(2131559405);
      j = localResources.getDimensionPixelSize(2131559404);
      k = ((DisplayMetrics)localObject).widthPixels - j * 2 - this.jdField_a_of_type_ComTencentWidgetDynamicGridView.getListPaddingLeft() - this.jdField_a_of_type_ComTencentWidgetDynamicGridView.getListPaddingRight();
      m = (k - i * 2) / 3;
      if (QLog.isDevelopLevel()) {
        QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "verticalSpace: %d marginLR: %d availableSpace: %d widthPixels: %d mColumn: %d density: %f left: %d right: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(((DisplayMetrics)localObject).widthPixels), Integer.valueOf(3), Float.valueOf(((DisplayMetrics)localObject).density), Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetDynamicGridView.getListPaddingLeft()), Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetDynamicGridView.getListPaddingRight()) }));
      }
      this.jdField_a_of_type_Abpu = new abpu(this, this, 3, m);
      this.jdField_a_of_type_ComTencentWidgetDynamicGridView.setColumnWidth(m);
      this.jdField_a_of_type_ComTencentWidgetDynamicGridView.setExpendable(true);
      this.jdField_a_of_type_ComTencentWidgetDynamicGridView.setAdapter(this.jdField_a_of_type_Abpu);
      this.jdField_a_of_type_ComTencentWidgetDynamicGridView.setOnDragListener(this.jdField_a_of_type_Abpu);
      this.jdField_a_of_type_ComTencentWidgetDynamicGridView.setOnDropListener(this.jdField_a_of_type_Abpu);
      this.jdField_a_of_type_ComTencentWidgetDynamicGridView.setOnItemClickListener(this.jdField_a_of_type_Abpu);
      this.jdField_a_of_type_ComTencentWidgetDynamicGridView.setOnItemLongClickListener(this.jdField_a_of_type_Abpu);
      this.jdField_a_of_type_Abpu.a();
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter = new TopicAdapter(this, 0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c("从相册选择");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c("拍照");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOnScrollStateChangedListener(this);
      b(paramCampusTopic);
      a();
      return;
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusBarColor(i);
      this.mSystemBarComp.setStatusColor(i);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(this.app, this, this.jdField_a_of_type_ComTencentWidgetPrefixXEditText, null);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void a(ScrollView paramScrollView, int paramInt)
  {
    if ((this.jdField_b_of_type_Int != 0) && (this.jdField_d_of_type_Int == 0) && (paramInt != 0)) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(6);
    }
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    ThreadManager.post(new abpt(this, paramString), 5, null, false);
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        CampusTopic localCampusTopic = (CampusTopic)paramList.get(i);
        if ((localCampusTopic == null) || (localCampusTopic.title == null) || (localCampusTopic.title.length() == 0)) {
          paramList.remove(i);
        }
        i -= 1;
      }
    } while (paramList.size() <= 0);
    Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 2, 0, 0, paramList).sendToTarget();
  }
  
  void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2, this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
    QQToast.a(BaseApplication.getContext(), paramInt1, paramString, 0).a();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.getText().toString().length() > this.g) {}
    while (this.jdField_a_of_type_Abpu.a() > 0) {
      return false;
    }
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (((this.jdField_c_of_type_Int <= this.g) && (paramEditable.length() > this.g)) || ((this.jdField_c_of_type_Int > this.g) && (paramEditable.length() <= this.g))) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(3);
    }
  }
  
  public void b()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentWidgetPrefixXEditText);
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramCharSequence.length();
  }
  
  public void c() {}
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.a())
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(7);
      }
    }
    for (;;)
    {
      if (QLog.isDebugVersion()) {
        QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "cancelPublish mIsPublishing: %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
      }
      return;
      a(true, 1, "取消失败", 0);
      continue;
      if (a()) {
        Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 8, 0, 0, null).sendToTarget();
      } else {
        DialogUtil.a(this, getString(2131438936), 2131433015, 2131437726, new abpp(this), new abpq(this)).show();
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "doOnActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      return;
      if ((!android.text.TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Abpu.a() < 9))
      {
        this.jdField_b_of_type_Boolean = true;
        Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 1, 1, 0, this.jdField_a_of_type_JavaLangString).sendToTarget();
        continue;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringArrayListExtra("delpics");
          if ((paramIntent != null) && (paramIntent.size() > 0))
          {
            Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 1, 3, 0, paramIntent).sendToTarget();
            continue;
            if (paramIntent != null)
            {
              paramIntent = CampusTopic.convertFromJSONString(paramIntent.getStringExtra("topic"));
              if (paramIntent != null) {
                b(paramIntent);
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  protected boolean doOnCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 911	com/tencent/mobileqq/app/IphoneTitleBarActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   5: istore 4
    //   7: aconst_null
    //   8: astore 7
    //   10: iconst_0
    //   11: istore_2
    //   12: aconst_null
    //   13: astore 6
    //   15: aload_0
    //   16: invokevirtual 915	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:getIntent	()Landroid/content/Intent;
    //   19: invokevirtual 919	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   22: ldc_w 921
    //   25: invokevirtual 925	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_1
    //   29: aload_1
    //   30: invokestatic 301	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifne +560 -> 593
    //   36: new 927	org/json/JSONObject
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 929	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 8
    //   46: aload 8
    //   48: ldc_w 931
    //   51: invokevirtual 935	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   54: ifeq +534 -> 588
    //   57: aload 8
    //   59: ldc_w 931
    //   62: invokevirtual 938	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   65: istore_2
    //   66: aload 8
    //   68: ldc_w 940
    //   71: invokevirtual 935	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   74: ifeq +508 -> 582
    //   77: aload 8
    //   79: ldc_w 940
    //   82: invokevirtual 941	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 6
    //   87: aload 8
    //   89: ldc_w 943
    //   92: invokevirtual 935	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   95: ifeq +481 -> 576
    //   98: aload 8
    //   100: ldc_w 943
    //   103: invokevirtual 941	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 5
    //   108: aload 7
    //   110: astore_1
    //   111: iload_2
    //   112: ifeq +64 -> 176
    //   115: aload 7
    //   117: astore_1
    //   118: aload 6
    //   120: invokestatic 301	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +53 -> 176
    //   126: new 149	com/tencent/mobileqq/campuscircle/CampusTopic
    //   129: dup
    //   130: invokespecial 944	com/tencent/mobileqq/campuscircle/CampusTopic:<init>	()V
    //   133: astore_1
    //   134: aload_1
    //   135: iload_2
    //   136: putfield 152	com/tencent/mobileqq/campuscircle/CampusTopic:id	I
    //   139: aload_1
    //   140: aload 6
    //   142: putfield 795	com/tencent/mobileqq/campuscircle/CampusTopic:title	Ljava/lang/String;
    //   145: aload 5
    //   147: aload_1
    //   148: invokestatic 948	com/tencent/mobileqq/campuscircle/CampusTopic:parseTopicInfo	(Ljava/lang/String;Lcom/tencent/mobileqq/campuscircle/CampusTopic;)V
    //   151: aload_1
    //   152: getfield 951	com/tencent/mobileqq/campuscircle/CampusTopic:iconUrl	Ljava/lang/String;
    //   155: invokestatic 301	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne +13 -> 171
    //   161: aload_1
    //   162: getfield 954	com/tencent/mobileqq/campuscircle/CampusTopic:grayIconUrl	Ljava/lang/String;
    //   165: invokestatic 301	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifeq +285 -> 453
    //   171: aload_1
    //   172: iconst_1
    //   173: putfield 957	com/tencent/mobileqq/campuscircle/CampusTopic:topicType	I
    //   176: aload 8
    //   178: ldc_w 959
    //   181: invokevirtual 935	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   184: ifeq +327 -> 511
    //   187: aload 8
    //   189: ldc_w 959
    //   192: invokevirtual 941	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 7
    //   197: new 927	org/json/JSONObject
    //   200: dup
    //   201: aload 7
    //   203: invokespecial 929	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   206: astore 8
    //   208: iconst_0
    //   209: istore_3
    //   210: aconst_null
    //   211: astore 7
    //   213: aload 8
    //   215: ldc_w 960
    //   218: invokevirtual 935	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   221: ifeq +12 -> 233
    //   224: aload 8
    //   226: ldc_w 960
    //   229: invokevirtual 938	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   232: istore_3
    //   233: aload 8
    //   235: ldc_w 961
    //   238: invokevirtual 935	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   241: ifeq +13 -> 254
    //   244: aload 8
    //   246: ldc_w 961
    //   249: invokevirtual 941	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   252: astore 7
    //   254: iload_3
    //   255: ifeq +50 -> 305
    //   258: aload 7
    //   260: invokestatic 301	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   263: ifne +42 -> 305
    //   266: aload_0
    //   267: new 575	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic
    //   270: dup
    //   271: invokespecial 962	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic:<init>	()V
    //   274: putfield 86	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic	Lcom/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic;
    //   277: aload_0
    //   278: getfield 86	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic	Lcom/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic;
    //   281: iload_3
    //   282: putfield 963	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic:jdField_a_of_type_Int	I
    //   285: aload 7
    //   287: ldc_w 965
    //   290: invokevirtual 968	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   293: ifeq +168 -> 461
    //   296: aload_0
    //   297: getfield 86	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic	Lcom/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic;
    //   300: aload 7
    //   302: putfield 577	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   305: invokestatic 971	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +81 -> 389
    //   311: invokestatic 171	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   314: astore 8
    //   316: aload_0
    //   317: getfield 86	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic	Lcom/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic;
    //   320: ifnonnull +194 -> 514
    //   323: iconst_0
    //   324: istore_3
    //   325: aload_0
    //   326: getfield 86	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic	Lcom/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic;
    //   329: ifnonnull +196 -> 525
    //   332: ldc_w 973
    //   335: astore 7
    //   337: ldc 160
    //   339: iconst_2
    //   340: aload 8
    //   342: ldc_w 975
    //   345: bipush 6
    //   347: anewarray 175	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: iload_2
    //   353: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   356: aastore
    //   357: dup
    //   358: iconst_1
    //   359: aload 6
    //   361: aastore
    //   362: dup
    //   363: iconst_2
    //   364: aload 5
    //   366: aastore
    //   367: dup
    //   368: iconst_3
    //   369: aload_1
    //   370: aastore
    //   371: dup
    //   372: iconst_4
    //   373: iload_3
    //   374: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aastore
    //   378: dup
    //   379: iconst_5
    //   380: aload 7
    //   382: aastore
    //   383: invokestatic 187	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   386: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: aload_0
    //   390: ldc_w 976
    //   393: invokevirtual 979	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:setContentView	(I)V
    //   396: aload_0
    //   397: aload_0
    //   398: getfield 771	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   401: sipush 215
    //   404: invokevirtual 985	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   407: checkcast 852	com/tencent/mobileqq/campuscircle/CampusCircleManager
    //   410: putfield 850	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager	Lcom/tencent/mobileqq/campuscircle/CampusCircleManager;
    //   413: aload_0
    //   414: getfield 850	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager	Lcom/tencent/mobileqq/campuscircle/CampusCircleManager;
    //   417: invokevirtual 986	com/tencent/mobileqq/campuscircle/CampusCircleManager:a	()V
    //   420: aload_0
    //   421: aload_0
    //   422: getfield 771	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   425: bipush 108
    //   427: invokevirtual 989	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   430: checkcast 991	com/tencent/mobileqq/campuscircle/CampusCircleHandler
    //   433: putfield 993	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleHandler	Lcom/tencent/mobileqq/campuscircle/CampusCircleHandler;
    //   436: aload_0
    //   437: aload_1
    //   438: invokevirtual 995	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:a	(Lcom/tencent/mobileqq/campuscircle/CampusTopic;)V
    //   441: aload_0
    //   442: aload_0
    //   443: getfield 110	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver	Lcom/tencent/mobileqq/campuscircle/CampusCircleObserver;
    //   446: iconst_1
    //   447: invokevirtual 999	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;Z)V
    //   450: iload 4
    //   452: ireturn
    //   453: aload_1
    //   454: iconst_2
    //   455: putfield 957	com/tencent/mobileqq/campuscircle/CampusTopic:topicType	I
    //   458: goto -282 -> 176
    //   461: aload_0
    //   462: getfield 86	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic	Lcom/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic;
    //   465: new 1001	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 1002	java/lang/StringBuilder:<init>	()V
    //   472: aload 7
    //   474: invokevirtual 1006	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: ldc_w 965
    //   480: invokevirtual 1006	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 1007	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: putfield 577	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   489: goto -184 -> 305
    //   492: astore 7
    //   494: invokestatic 971	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   497: ifeq +14 -> 511
    //   500: ldc 160
    //   502: iconst_2
    //   503: ldc_w 1009
    //   506: aload 7
    //   508: invokestatic 1011	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   511: goto -206 -> 305
    //   514: aload_0
    //   515: getfield 86	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic	Lcom/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic;
    //   518: getfield 963	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic:jdField_a_of_type_Int	I
    //   521: istore_3
    //   522: goto -197 -> 325
    //   525: aload_0
    //   526: getfield 86	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic	Lcom/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic;
    //   529: getfield 577	com/tencent/mobileqq/campuscircle/CampusCirclePublishActivity$PublicityTopic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   532: astore 7
    //   534: goto -197 -> 337
    //   537: astore 5
    //   539: aconst_null
    //   540: astore_1
    //   541: invokestatic 971	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +14 -> 558
    //   547: ldc 160
    //   549: iconst_2
    //   550: ldc_w 1013
    //   553: aload 5
    //   555: invokestatic 1011	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   558: goto -169 -> 389
    //   561: astore 5
    //   563: goto -22 -> 541
    //   566: astore 5
    //   568: goto -27 -> 541
    //   571: astore 5
    //   573: goto -32 -> 541
    //   576: aconst_null
    //   577: astore 5
    //   579: goto -471 -> 108
    //   582: aconst_null
    //   583: astore 6
    //   585: goto -498 -> 87
    //   588: iconst_0
    //   589: istore_2
    //   590: goto -524 -> 66
    //   593: aconst_null
    //   594: astore_1
    //   595: aconst_null
    //   596: astore 5
    //   598: goto -293 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	this	CampusCirclePublishActivity
    //   0	601	1	paramBundle	android.os.Bundle
    //   11	579	2	i	int
    //   209	313	3	j	int
    //   5	446	4	bool	boolean
    //   106	259	5	str1	String
    //   537	17	5	localException1	Exception
    //   561	1	5	localException2	Exception
    //   566	1	5	localException3	Exception
    //   571	1	5	localException4	Exception
    //   577	20	5	localObject1	Object
    //   13	571	6	str2	String
    //   8	465	7	str3	String
    //   492	15	7	localException5	Exception
    //   532	1	7	str4	String
    //   44	297	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   197	208	492	java/lang/Exception
    //   213	233	492	java/lang/Exception
    //   233	254	492	java/lang/Exception
    //   258	305	492	java/lang/Exception
    //   461	489	492	java/lang/Exception
    //   15	66	537	java/lang/Exception
    //   66	87	537	java/lang/Exception
    //   87	108	537	java/lang/Exception
    //   118	134	537	java/lang/Exception
    //   134	171	561	java/lang/Exception
    //   171	176	561	java/lang/Exception
    //   453	458	561	java/lang/Exception
    //   176	197	566	java/lang/Exception
    //   494	511	566	java/lang/Exception
    //   305	323	571	java/lang/Exception
    //   325	332	571	java/lang/Exception
    //   337	389	571	java/lang/Exception
    //   514	522	571	java/lang/Exception
    //   525	534	571	java/lang/Exception
  }
  
  public void doOnDestroy()
  {
    this.jdField_d_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
    this.jdField_a_of_type_ComTencentWidgetScrollView.setOnScrollStateChangedListener(null);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver);
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.b();
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(null);
    this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.setMovementMethod(null);
    this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.setOnTouchListener(null);
    this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.removeTextChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetPrefixXEditText.setPrefix(null, 0);
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.a();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    int i;
    String str;
    if (QLog.isDevelopLevel())
    {
      Locale localLocale = Locale.getDefault();
      if (localArrayList == null)
      {
        i = 0;
        if (localArrayList != null) {
          break label111;
        }
        str = null;
        label39:
        QLog.i("CampusCircle", 4, String.format(localLocale, "doOnNewIntent size: %d paths: %s", new Object[] { Integer.valueOf(i), str }));
      }
    }
    else
    {
      if ((localArrayList == null) || (localArrayList.size() <= 0)) {
        break label120;
      }
      this.jdField_b_of_type_Boolean = true;
      Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 1, 2, 0, localArrayList).sendToTarget();
    }
    label111:
    label120:
    do
    {
      return;
      i = localArrayList.size();
      break;
      str = localArrayList.toString();
      break label39;
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if ((!android.text.TextUtils.isEmpty(paramIntent)) && (this.jdField_a_of_type_Abpu.a() < 9))
      {
        this.jdField_b_of_type_Boolean = true;
        Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 1, 1, 0, paramIntent).sendToTarget();
      }
    } while (!QLog.isColorLevel());
    QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "doOnNewIntent path: %s", new Object[] { paramIntent }));
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "doOnResume mNeedScrollDown: %b", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    }
    h();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "doOnWindowFocusChanged isFocused: %b mNeedScrollDown: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    if ((paramBoolean) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(9, 100L);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void e()
  {
    if (QLog.isDebugVersion()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "publish mIsPublishing:%b mIsDestroy:%b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_d_of_type_Boolean) }));
    }
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleHandler.a().jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic == null))
    {
      a(true, 0, "请选择一个版块", 0);
      return;
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      a(true, 1, "当前无网络，请检查网络连接后重试。", 200);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    int i;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
    {
      i = 1;
      localObject3 = TroopBarUtils.a(this.jdField_a_of_type_ComTencentWidgetPrefixXEditText);
      localObject2 = localObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic != null)
      {
        localObject2 = localObject3;
        if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic.jdField_a_of_type_JavaLangString != null)
        {
          localObject1 = localObject3;
          if (((String)localObject3).startsWith(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic.jdField_a_of_type_JavaLangString)) {
            localObject1 = ((String)localObject3).substring(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic.jdField_a_of_type_JavaLangString.length());
          }
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.i("CampusCircle", 2, String.format(Locale.getDefault(), "publish content: %s, title: %s", new Object[] { localObject1, this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic.jdField_a_of_type_JavaLangString }));
            localObject2 = localObject1;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic != null) {
        break label394;
      }
    }
    label394:
    for (int j = 0;; j = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic.id)
    {
      localObject3 = this.app.c();
      localObject1 = new CampusCircleManager.CampusTopicReq();
      ((CampusCircleManager.CampusTopicReq)localObject1).anonymousFlag = i;
      ((CampusCircleManager.CampusTopicReq)localObject1).content = ((String)localObject2);
      ((CampusCircleManager.CampusTopicReq)localObject1).feedType = j;
      ((CampusCircleManager.CampusTopicReq)localObject1).uin = ((String)localObject3);
      ((CampusCircleManager.CampusTopicReq)localObject1).retryCnt = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic != null) {
        ((CampusCircleManager.CampusTopicReq)localObject1).publicityTopicId = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCirclePublishActivity$PublicityTopic.jdField_a_of_type_Int;
      }
      i = 0;
      while (i < this.jdField_a_of_type_Abpu.a())
      {
        localObject2 = (String)this.jdField_a_of_type_Abpu.getItem(i);
        if ((localObject2 != null) && (!android.text.TextUtils.isEmpty((CharSequence)localObject2)))
        {
          localObject3 = new CampusCircleManager.PicInfo();
          ((CampusCircleManager.PicInfo)localObject3).path = ((String)localObject2);
          ((CampusCircleManager.CampusTopicReq)localObject1).picInfos.add(localObject3);
        }
        i += 1;
      }
      i = 0;
      break;
    }
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.a((CampusCircleManager.CampusTopicReq)localObject1);
    if (((CampusCircleManager.CampusTopicReq)localObject1).picInfos.size() > 0) {
      a(false, 0, "正在上传图片", 800);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(7, 300000L);
      a("0X800809E");
      return;
      a(false, 0, "正在发表", 800);
    }
  }
  
  protected void f()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      a(true, 1, getString(2131434793), 0);
    }
    for (;;)
    {
      return;
      if (!Utils.a())
      {
        a(true, 1, getString(2131434770), 0);
        return;
      }
      Object localObject = new File(AppConstants.aV);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = PlusPanelUtils.a(AppConstants.aV);
      boolean bool = ShortVideoGuideUtil.c(this.app);
      Intent localIntent;
      if ((bool) && (this.jdField_c_of_type_Boolean))
      {
        localIntent = new Intent(BaseApplicationImpl.getContext(), NewFlowCameraActivity.class);
        localIntent.putExtra("qcamera_photo_filepath", (String)localObject);
        localIntent.putExtra("flow_camera_use_filter_function", true);
        localIntent.putExtra("support_photo_shot", true);
        localIntent.putExtra("support_video_shot", false);
        localIntent.putExtra("flow_camera_video_mode", false);
        localIntent.putExtra("flow_camera_capture_mode", true);
        localIntent.putExtra("extra.busi_type", 7);
        localIntent.putExtra("edit_video_type", 10008);
        localIntent.putExtra("support_photo_merge", true);
        localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", getClass().getName());
        localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        startActivity(localIntent);
      }
      while (QLog.isColorLevel())
      {
        QLog.i("CampusCircle", 2, String.format(Locale.getDefault(), "takePhoto bSupportPtv: %b path: %s", new Object[] { Boolean.valueOf(bool), localObject }));
        return;
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        localIntent.putExtra("output", Uri.fromFile(new File((String)localObject)));
        localIntent.putExtra("android.intent.extra.videoQuality", 100);
        try
        {
          startActivityForResult(localIntent, 1);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          a(true, 1, getString(2131434793), 0);
        }
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    InputMethodUtil.b(this.jdField_a_of_type_ComTencentWidgetPrefixXEditText);
    overridePendingTransition(0, 2131034122);
  }
  
  public void g()
  {
    Intent localIntent = new Intent(this, CampusCircleBaseActivity.class);
    localIntent.putExtra("tag_busi_id", 1);
    startActivityForResult(localIntent, 3);
  }
  
  protected void h()
  {
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369911);
    if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleHandler.a().jdField_c_of_type_Int == 1)
    {
      localTextView.setText(String.format(Locale.getDefault(), "%s(必选)", new Object[] { getString(2131438952) }));
      return;
    }
    localTextView.setText(2131438952);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    case 4: 
    case 10: 
    default: 
    case 1: 
    case 11: 
    case 2: 
    case 3: 
      boolean bool1;
      boolean bool2;
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              if (QLog.isDevelopLevel()) {
                QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "MSG_REFRESH_GRID_VIEW arg1: %d obj: %s", new Object[] { Integer.valueOf(paramMessage.arg1), paramMessage.obj }));
              }
              switch (paramMessage.arg1)
              {
              default: 
                return true;
              }
            } while ((!(paramMessage.obj instanceof String)) || (this.jdField_a_of_type_Abpu.a() >= 9));
            this.jdField_a_of_type_Abpu.a(this.jdField_a_of_type_Abpu.a(), paramMessage.obj);
            this.jdField_a_of_type_Abpu.a();
            return true;
          } while (!(paramMessage.obj instanceof ArrayList));
          paramMessage = (ArrayList)paramMessage.obj;
          this.jdField_a_of_type_Abpu.d();
          int i = 0;
          while ((i < paramMessage.size()) && (this.jdField_a_of_type_Abpu.a() < 9))
          {
            localObject = (String)paramMessage.get(i);
            if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
              this.jdField_a_of_type_Abpu.a(this.jdField_a_of_type_Abpu.a(), localObject);
            }
            i += 1;
          }
          this.jdField_a_of_type_Abpu.a();
          return true;
        } while (!(paramMessage.obj instanceof ArrayList));
        paramMessage = ((ArrayList)paramMessage.obj).iterator();
        while (paramMessage.hasNext())
        {
          localObject = (String)paramMessage.next();
          this.jdField_a_of_type_Abpu.d(localObject);
        }
        this.jdField_a_of_type_Abpu.a();
        return true;
        b((CampusTopic)paramMessage.obj);
        return true;
        if ((paramMessage.obj instanceof ArrayList))
        {
          paramMessage = (ArrayList)paramMessage.obj;
          this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.a(paramMessage);
        }
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.notifyDataSetChanged();
        return true;
        bool1 = a();
        bool2 = this.rightViewText.isEnabled();
        if ((bool1) && (bool2))
        {
          this.rightViewText.setEnabled(false);
          return true;
        }
      } while ((bool1) || (bool2));
      this.rightViewText.setEnabled(true);
      return true;
    case 5: 
      if (paramMessage.arg1 == 100)
      {
        a(true, 0, "内容含有敏感信息，请重新输入。", 0);
        return true;
      }
      a(true, 0, "发表失败，请稍后重试。", 0);
      return true;
    case 6: 
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return true;
    case 7: 
      if (QLog.isColorLevel()) {
        QLog.i("CampusCircle", 2, "MSG_PUBLISH_TIMEOUT");
      }
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver.a(false, 1, this.app.c(), "", null);
      CampusCircleHelper.a(this.app.getAccount(), "actPublishCampusFeed", 3, this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.a);
      return true;
    case 8: 
      if (QLog.isColorLevel()) {
        QLog.i("CampusCircle", 2, String.format(Locale.getDefault(), "MSG_EXIT code: %d, msg: %s", new Object[] { Integer.valueOf(paramMessage.arg1), paramMessage.obj }));
      }
      if ((paramMessage.obj instanceof String))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("result", (String)paramMessage.obj);
        setResult(paramMessage.arg1, (Intent)localObject);
      }
      for (;;)
      {
        finish();
        return true;
        setResult(paramMessage.arg1);
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, "MSG_SCROLL_DOWN");
    }
    this.jdField_a_of_type_ComTencentWidgetScrollView.fullScroll(130);
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      d();
      return true;
    }
    if (this.jdField_b_of_type_Int != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return true;
    }
    d();
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    TextView localTextView;
    if (paramCompoundButton == this.jdField_a_of_type_AndroidWidgetCheckBox)
    {
      paramCompoundButton = getResources();
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label43;
      }
    }
    label43:
    for (paramCompoundButton = paramCompoundButton.getColorStateList(2131493375);; paramCompoundButton = paramCompoundButton.getColorStateList(2131493373))
    {
      localTextView.setTextColor(paramCompoundButton);
      a("0X800809D");
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.leftViewNotBack)
    {
      a("0X800809F");
      d();
    }
    do
    {
      return;
      if (paramView == this.rightViewText)
      {
        e();
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton)
      {
        if (this.jdField_a_of_type_Int == 1)
        {
          a(0);
          return;
        }
        a(1);
        return;
      }
      if (paramView == this.jdField_b_of_type_AndroidWidgetImageButton)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        a("0X800809A");
        return;
      }
      if (paramView.getId() == 2131366645)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic != null) {
          this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.a(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic);
        }
        Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 11, 0, 0, null).sendToTarget();
        return;
      }
    } while (paramView.getId() != 2131369911);
    g();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (CampusTopic)this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.getItem(paramInt);
    if (paramAdapterView == this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusTopic) {
      g();
    }
    while (paramAdapterView == null) {
      return;
    }
    Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 11, 0, 0, paramAdapterView).sendToTarget();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void q()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, "onHideAllPanel");
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public void setting() {}
  
  public boolean showPreview()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "showPreview %b", new Object[] { Boolean.valueOf(super.showPreview()) }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCirclePublishActivity
 * JD-Core Version:    0.7.0.1
 */