package com.tencent.open.agent;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.open.adapter.IOpenAppClient;
import com.tencent.open.adapter.OpenAppClientImpl;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public abstract class FriendChooser
  extends QBaseActivity
  implements View.OnClickListener, Animation.AnimationListener, ImageLoader.ImageLoadListener
{
  @ConfigInject(configPath="Business/opensdk-api/src/main/resources/Inject_open_app_client.yml", version=1)
  private static ArrayList<Class<? extends IOpenAppClient>> c;
  protected float a;
  protected int a;
  final Handler a;
  protected View a;
  protected ViewStub a;
  protected AlphaAnimation a;
  protected TranslateAnimation a;
  protected InputMethodManager a;
  protected Button a;
  protected EditText a;
  protected GridView a;
  protected HorizontalScrollView a;
  protected ImageButton a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected InnerFrameManager a;
  protected FriendChooser.GridViewAdapter a;
  protected FriendChooser.SearchResultAdapter a;
  protected FriendDataManager a;
  protected XListView a;
  protected String a;
  protected ArrayList<String> a;
  protected List<Friend> a;
  public boolean a;
  protected int b;
  protected View b;
  protected TranslateAnimation b;
  protected Button b;
  protected TextView b;
  protected String b;
  protected ArrayList<Friend> b;
  protected View c;
  protected Button c;
  protected TextView c;
  protected String c;
  protected TextView d;
  protected TextView e;
  
  static
  {
    jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    jdField_c_of_type_JavaUtilArrayList.add(OpenAppClientImpl.class);
  }
  
  public FriendChooser()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_a_of_type_Int = 99999;
    this.jdField_b_of_type_Int = 99999;
    this.jdField_a_of_type_AndroidOsHandler = new FriendChooser.4(this);
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  public abstract String a();
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = super.getString(2131718716);
    this.jdField_b_of_type_JavaLangString = super.getString(2131690971);
    this.jdField_c_of_type_JavaLangString = super.getString(2131690971);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.d.setVisibility(0);
    this.d.setText(2131689823);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  protected void a(Friend paramFriend)
  {
    boolean bool;
    if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramFriend.jdField_a_of_type_JavaLangString))
    {
      bool = false;
      this.jdField_b_of_type_JavaUtilArrayList.remove(paramFriend);
      this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.b(paramFriend.jdField_a_of_type_JavaLangString);
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c() >= this.jdField_a_of_type_Int)
      {
        h();
        return;
      }
      bool = true;
      this.jdField_b_of_type_JavaUtilArrayList.add(paramFriend);
      this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramFriend.jdField_a_of_type_JavaLangString);
    }
    b(bool);
    e();
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((!paramString.equals("")) && (paramString.trim().length() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      Object localObject = ((OpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a();
      if (localObject != null)
      {
        paramString = paramString.toLowerCase();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friend localFriend = (Friend)((Iterator)localObject).next();
          if ((!paramString.equals(localFriend.f)) && (!paramString.equals(localFriend.g)) && (!paramString.equals(localFriend.jdField_c_of_type_JavaLangString)) && (!paramString.equals(localFriend.jdField_b_of_type_JavaLangString)))
          {
            if (((localFriend.jdField_c_of_type_JavaLangString != null) && (localFriend.jdField_c_of_type_JavaLangString.indexOf(paramString) >= 0)) || ((localFriend.jdField_b_of_type_JavaLangString != null) && (localFriend.jdField_b_of_type_JavaLangString.indexOf(paramString) >= 0)) || (localFriend.f.indexOf(paramString) >= 0) || (localFriend.g.indexOf(paramString) >= 0)) {
              localArrayList2.add(localFriend);
            }
          }
          else {
            localArrayList1.add(localFriend);
          }
        }
        Collections.sort(localArrayList2, new FriendChooser.MyComparator(this));
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
      }
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      } else {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter.notifyDataSetChanged();
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean)
  {
    int i = this.jdField_b_of_type_JavaUtilArrayList.size();
    String str;
    if (i <= 1) {
      str = this.jdField_b_of_type_JavaLangString;
    } else {
      str = MessageFormat.format(this.jdField_c_of_type_JavaLangString, new Object[] { Integer.valueOf(i) });
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setText(str);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(str);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      a(this.jdField_b_of_type_AndroidWidgetTextView);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    if (paramBoolean2) {
      this.d.setVisibility(0);
    } else {
      this.d.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      a(this.jdField_b_of_type_AndroidWidgetTextView);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    if (paramBoolean2)
    {
      this.d.setVisibility(0);
      this.d.setText(paramString3);
    }
    else
    {
      this.d.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
  }
  
  @SuppressLint({"NewApi"})
  protected void b()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$GridViewAdapter = new FriendChooser.GridViewAdapter(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$GridViewAdapter);
    this.jdField_a_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetButton.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new FriendChooser.1(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  protected void b(boolean paramBoolean)
  {
    Object localObject = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList.size());
    localStringBuilder.append("/");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    ((TextView)localObject).setText(localStringBuilder.toString());
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(this.jdField_b_of_type_JavaUtilArrayList.size());
    localObject = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)((this.jdField_b_of_type_JavaUtilArrayList.size() * 36 + this.jdField_b_of_type_JavaUtilArrayList.size() * 10) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c() == this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 200L);
    }
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$GridViewAdapter.notifyDataSetChanged();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)super.getSystemService("input_method"));
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_AndroidViewView.getHeight());
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight() + this.jdField_a_of_type_AndroidViewView.getHeight());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.toggleSoftInput(0, 0);
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368340));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363868));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376483);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377082));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371921);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new FriendChooser.SearchTextWatcher(this));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838739);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter = new FriendChooser.SearchResultAdapter(this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new FriendChooser.2(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new FriendChooser.3(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void e()
  {
    TextView localTextView = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList.size());
    localStringBuilder.append("/");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localTextView.setText(localStringBuilder.toString());
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      a(true);
      return;
    }
    a(false);
  }
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.jdField_a_of_type_AndroidViewView.getHeight(), 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected abstract void g();
  
  public abstract void h();
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation)
    {
      paramAnimation = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramAnimation);
      return;
    }
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        d();
      }
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected boolean onBackEvent()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0))
    {
      f();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 1) {
      return super.onBackEvent();
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetTextView)
    {
      onBackEvent();
    }
    else if (paramView == this.d)
    {
      super.finish();
    }
    else if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
    {
      g();
    }
    else if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
    }
    else if (paramView == this.jdField_c_of_type_AndroidWidgetButton)
    {
      f();
    }
    else if (paramView == this.jdField_b_of_type_AndroidViewView)
    {
      f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.onCreate(paramBundle);
    super.setTheme(2131755317);
    super.setContentView(a());
    AppRuntime localAppRuntime = getAppRuntime();
    try
    {
      ((IOpenAppClient)((Class)jdField_c_of_type_JavaUtilArrayList.get(0)).newInstance()).a((AppInterface)localAppRuntime);
    }
    catch (Exception paramBundle)
    {
      QLog.e("qqBaseActivity", 1, paramBundle, new Object[0]);
    }
    this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager = FriendDataManager.a();
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131378803);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369249));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369202));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369204));
    this.d = ((TextView)super.findViewById(2131369233));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131372128));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)super.findViewById(2131377076));
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)super.findViewById(2131372136));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)super.findViewById(2131377006));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)super.findViewById(2131377178));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365797));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365798));
    this.e = ((TextView)super.findViewById(2131377143));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131371803));
    a();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    paramBundle = null;
    if ((localAppRuntime instanceof BaseQQAppInterface)) {
      paramBundle = (BaseQQAppInterface)localAppRuntime;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
    b();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.d();
    if (this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter = null;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.b();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a();
  }
  
  protected void onStart()
  {
    super.onStart();
    getWindow().setSoftInputMode(16);
  }
  
  protected void onStop()
  {
    super.onStop();
    super.getWindow().setSoftInputMode(48);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser
 * JD-Core Version:    0.7.0.1
 */