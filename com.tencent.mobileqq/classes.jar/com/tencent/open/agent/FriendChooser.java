package com.tencent.open.agent;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
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
import bbwg;
import bbwh;
import bbwi;
import bbwj;
import bbwk;
import bbwm;
import bbwn;
import bbwp;
import bbzv;
import bcab;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.widget.XListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class FriendChooser
  extends BaseActivity
  implements View.OnClickListener, Animation.AnimationListener, bcab
{
  public float a;
  public int a;
  final Handler a;
  protected View a;
  protected ViewStub a;
  protected AlphaAnimation a;
  protected TranslateAnimation a;
  public InputMethodManager a;
  protected Button a;
  public EditText a;
  public GridView a;
  public HorizontalScrollView a;
  protected ImageButton a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  public bbwk a;
  protected bbwn a;
  public bbzv a;
  public InnerFrameManager a;
  protected XListView a;
  protected String a;
  public ArrayList<String> a;
  public List<Friend> a;
  public boolean a;
  protected int b;
  protected View b;
  protected TranslateAnimation b;
  protected Button b;
  protected TextView b;
  protected String b;
  public ArrayList<Friend> b;
  protected View c;
  protected Button c;
  protected TextView c;
  protected String c;
  protected TextView d;
  protected TextView e;
  
  public FriendChooser()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 99999;
    this.jdField_b_of_type_Int = 99999;
    this.jdField_a_of_type_AndroidOsHandler = new bbwj(this);
  }
  
  protected int a()
  {
    return 0;
  }
  
  public abstract String a();
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = super.getString(2131653390);
    this.jdField_b_of_type_JavaLangString = super.getString(2131625357);
    this.jdField_c_of_type_JavaLangString = super.getString(2131625357);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.d.setVisibility(0);
    this.d.setText(2131624327);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  protected void a(Friend paramFriend)
  {
    boolean bool;
    if (this.jdField_a_of_type_Bbzv.a(paramFriend.jdField_a_of_type_JavaLangString))
    {
      bool = false;
      this.jdField_b_of_type_JavaUtilArrayList.remove(paramFriend);
      this.jdField_a_of_type_Bbzv.b(paramFriend.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      b(bool);
      e();
      return;
      if (this.jdField_a_of_type_Bbzv.c() >= this.jdField_a_of_type_Int)
      {
        h();
        return;
      }
      bool = true;
      this.jdField_b_of_type_JavaUtilArrayList.add(paramFriend);
      this.jdField_a_of_type_Bbzv.a(paramFriend.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramString.equals("")) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbwn.notifyDataSetChanged();
      return;
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
          if ((paramString.equals(localFriend.f)) || (paramString.equals(localFriend.g)) || (paramString.equals(localFriend.jdField_c_of_type_JavaLangString)) || (paramString.equals(localFriend.jdField_b_of_type_JavaLangString))) {
            localArrayList1.add(localFriend);
          } else if (((localFriend.jdField_c_of_type_JavaLangString != null) && (localFriend.jdField_c_of_type_JavaLangString.indexOf(paramString) >= 0)) || ((localFriend.jdField_b_of_type_JavaLangString != null) && (localFriend.jdField_b_of_type_JavaLangString.indexOf(paramString) >= 0)) || (localFriend.f.indexOf(paramString) >= 0) || (localFriend.g.indexOf(paramString) >= 0)) {
            localArrayList2.add(localFriend);
          }
        }
        Collections.sort(localArrayList2, new bbwm(this));
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
      }
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      } else {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.jdField_a_of_type_Bbwn.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean)
  {
    int i = this.jdField_b_of_type_JavaUtilArrayList.size();
    if (i <= 1) {}
    for (String str = this.jdField_b_of_type_JavaLangString; paramBoolean; str = MessageFormat.format(this.jdField_c_of_type_JavaLangString, new Object[] { Integer.valueOf(i) }))
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
      IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetTextView);
      if (!paramBoolean2) {
        break label76;
      }
      this.d.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
      label76:
      this.d.setVisibility(4);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetTextView);
      if (!paramBoolean2) {
        break label85;
      }
      this.d.setVisibility(0);
      this.d.setText(paramString3);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
      label85:
      this.d.setVisibility(4);
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void b()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_Bbwk = new bbwk(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Bbwk);
    this.jdField_a_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetButton.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new bbwg(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.e.setText(this.jdField_b_of_type_JavaUtilArrayList.size() + "/" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(this.jdField_b_of_type_JavaUtilArrayList.size());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    localLayoutParams.width = ((int)((this.jdField_b_of_type_JavaUtilArrayList.size() * 36 + this.jdField_b_of_type_JavaUtilArrayList.size() * 10) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(localLayoutParams);
    if (this.jdField_a_of_type_Bbzv.c() == this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 200L);
      }
      this.jdField_a_of_type_Bbwk.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void c()
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
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300167));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302060));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297934));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131309439);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131309972));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131305203);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bbwp(this));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838503);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_Bbwn = new bbwn(this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bbwn);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new bbwh(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new bbwi(this));
  }
  
  public void e()
  {
    this.e.setText(this.jdField_b_of_type_JavaUtilArrayList.size() + "/" + this.jdField_a_of_type_Int);
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
    }
    while (paramAnimation != this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      d();
    }
    this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      f();
      return true;
    }
    switch (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())
    {
    default: 
      return super.onBackEvent();
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetTextView) {
      onBackEvent();
    }
    do
    {
      return;
      if (paramView == this.d)
      {
        super.finish();
        return;
      }
      if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
      {
        g();
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
        return;
      }
      if (paramView == this.jdField_c_of_type_AndroidWidgetButton)
      {
        f();
        return;
      }
    } while (paramView != this.jdField_b_of_type_AndroidViewView);
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.onCreate(paramBundle);
    super.setTheme(2131689611);
    super.setContentView(a());
    OpenAppClient.a(this.app);
    this.jdField_a_of_type_Bbzv = bbzv.a();
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131311553);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302847));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302804));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302806));
    this.d = ((TextView)super.findViewById(2131302832));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131305374));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)super.findViewById(2131309966));
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)super.findViewById(2131305382));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)super.findViewById(2131309900));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)super.findViewById(2131310056));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131299738));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131299739));
    this.e = ((TextView)super.findViewById(2131310028));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131305094));
    a();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.app);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
    b();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.d();
    if (this.jdField_a_of_type_Bbwn != null) {
      this.jdField_a_of_type_Bbwn = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.b();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a();
  }
  
  public void onStart()
  {
    super.onStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void onStop()
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