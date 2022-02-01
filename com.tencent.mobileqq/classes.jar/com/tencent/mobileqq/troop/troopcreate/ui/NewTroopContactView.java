package com.tencent.mobileqq.troop.troopcreate.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.service.troop.TroopConstants.CreateTroopSource;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService.TroopCreateCallback;
import com.tencent.mobileqq.troop.api.troopcreate.IQQBase;
import com.tencent.mobileqq.troop.data.TroopCreateInfo.TroopCreateResult;
import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopcreate.tempapi.ICreateTroopForUI;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.PinnedFooterExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class NewTroopContactView
  extends AbsNewTroopBaseView
  implements View.OnClickListener, TroopConstants.CreateTroopSource, ITroopCreateInfoService.TroopCreateCallback
{
  protected float a;
  protected int a;
  protected long a;
  protected Dialog a;
  protected Bitmap a;
  private final Handler jdField_a_of_type_AndroidOsHandler = new NewTroopContactView.1(this);
  protected View a;
  protected InputMethodManager a;
  protected Button a;
  public EditText a;
  protected FrameLayout a;
  protected GridView a;
  protected ImageView a;
  protected RelativeLayout a;
  protected IFaceDecoder a;
  protected FriendObserver a;
  private IQQBase jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateIQQBase = (IQQBase)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQBase.class, "");
  private ICreateTroopForUI jdField_a_of_type_ComTencentMobileqqTroopTroopcreateTempapiICreateTroopForUI = (ICreateTroopForUI)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ICreateTroopForUI.class, "");
  protected NewTroopContactView.GridViewAdapter a;
  RelationFriendsTroopViewHelper jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper;
  protected CustomHorizontalScrollView a;
  InputMethodRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout;
  protected QQBlurView a;
  protected PinnedFooterExpandableListView a;
  public PinnedHeaderExpandableListView.ExpandableListAdapter a;
  public ArrayList<String> a;
  protected boolean a;
  protected int b;
  long b;
  protected Button b;
  public ArrayList<String> b;
  protected boolean b;
  protected int c;
  protected Button c;
  public ArrayList<ResultRecord> c;
  protected boolean c;
  protected Button d;
  private boolean d;
  protected Button e;
  private boolean e;
  protected Button f;
  
  public NewTroopContactView(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.uin = paramString1;
    localResultRecord.name = paramString2;
    localResultRecord.type = paramInt;
    localResultRecord.groupUin = paramString3;
    return localResultRecord;
  }
  
  private void b(String paramString)
  {
    int i = 0;
    while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(i)).uin.equals(paramString)) {
        this.jdField_c_of_type_JavaUtilArrayList.remove(i);
      }
      i += 1;
    }
    m();
  }
  
  private void c(String paramString)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 2000)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramString, 2000).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private void p()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("isExpandFirst", true);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateTempapiICreateTroopForUI.getContactListAdapter(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, bool);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839483));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener((AbsListView.OnScrollListener)this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new NewTroopContactView.2(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper = new RelationFriendsTroopViewHelper(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new NewTroopContactView.3(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateTempapiICreateTroopForUI.setRelationFriendTroopHelper(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper);
  }
  
  @TargetApi(19)
  private void q()
  {
    this.jdField_c_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      if ("1103".equals(ThemeUtil.curThemeId)) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-15921907);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView);
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    localQQBlurView.b(localQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    localQQBlurView.setEnableBlur(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130850581);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new NewTroopContactView.4(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void s()
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("param_only_troop_or_discussion_member", true);
    ((Intent)localObject).putExtra("param_entrance", 27);
    ((Intent)localObject).putExtra("param_selected_records_for_create_discussion", this.jdField_c_of_type_JavaUtilArrayList);
    ((Intent)localObject).putExtra("param_overload_tips_include_default_count", true);
    ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131691274));
    ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131718707));
    ((Intent)localObject).putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131718708));
    ((Intent)localObject).putExtra("param_max", 99);
    ((Intent)localObject).putExtra("param_min", 0);
    ((Intent)localObject).putExtra("multi_chat", true);
    ((Intent)localObject).putExtra("param_exit_animation", this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateIQQBase.getAnimationTypeR2L());
    ((Intent)localObject).putExtra("param_back_button_side", this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateIQQBase.getBackButtonSideL());
    ((Intent)localObject).setFlags(603979776);
    TroopCreateUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (Intent)localObject, "/base/selectMember", 1300);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.overridePendingTransition(2130772320, 0);
    localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    ReportController.b((AppRuntime)localObject, "dc00899", "Grp_create_new", "", "create_page", "clk_chose", 0, 0, "", localStringBuilder.toString(), "", "");
  }
  
  public static void setCreateTroopButtonEnable(Button paramButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Context localContext = paramButton.getContext();
      paramButton.setBackgroundResource(2130839280);
      paramButton.setTextColor(localContext.getResources().getColor(2131167089));
      paramButton.setAlpha(1.0F);
    }
    else
    {
      paramButton.setTextColor(Color.parseColor("#ffffff"));
      paramButton.setBackgroundResource(2130850379);
      if (ThemeUtil.isDefaultTheme())
      {
        paramButton.setAlpha(0.5F);
      }
      else
      {
        paramButton.setTextColor(paramButton.getContext().getResources().getColor(2131167089));
        paramButton.setBackgroundResource(2130850380);
      }
    }
    paramButton.setEnabled(paramBoolean);
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(i)).uin);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      ReportController.b(localAppInterface, "dc00899", "Grp_create", "", "grptab", "select_exp", 0, 0, "", localStringBuilder.toString(), "", "");
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        return;
      }
      localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      ReportController.b(localAppInterface, "dc00899", "Grp_create", "", "grptab", "select_clk", 0, 0, "", localStringBuilder.toString(), "", "");
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1300) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {
        a(paramIntent, true);
      }
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    super.a(paramQBaseActivity);
    g();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    h();
    i();
    l();
    p();
    this.jdField_a_of_type_AndroidGraphicsBitmap = BaseImageUtil.f();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView$GridViewAdapter);
    paramQBaseActivity = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    ReportController.b(paramQBaseActivity, "dc00899", "Grp_create_new", "", "create_page", "exp_person", 0, 0, "", localStringBuilder.toString(), "", "");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("createNewTroop.NewTroopContactView", 2, "onRelationTroopItemClick: empty");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRelationTroopItemClick: troopUin:");
      localStringBuilder.append(paramString);
      QLog.i("createNewTroop.NewTroopContactView", 2, localStringBuilder.toString());
    }
    onReusedTroop(paramString);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper.d();
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      s();
    }
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))
    {
      r();
      return true;
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
      r();
    }
    return super.a();
  }
  
  public boolean a(String paramString)
  {
    int i = 0;
    while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(i)).uin.equals(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool2 = a(paramString1);
    boolean bool1 = false;
    if (bool2)
    {
      b(paramString1);
    }
    else if (!b())
    {
      bool1 = true;
      this.jdField_c_of_type_JavaUtilArrayList.add(a(paramString1, paramString2, paramInt, paramString3));
    }
    b(bool1);
    m();
    return bool1;
  }
  
  public boolean a(List<ResultRecord> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
    }
    HashSet localHashSet = new HashSet(this.jdField_c_of_type_JavaUtilArrayList.size());
    Object localObject = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add((String)((Iterator)localObject).next());
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (ResultRecord)paramList.next();
      if (!localHashSet.contains(((ResultRecord)localObject).uin))
      {
        if (b()) {
          break;
        }
        this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
      }
    }
    b(true);
    m();
    o();
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(this.jdField_c_of_type_JavaUtilArrayList.size());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    localLayoutParams.width = ((int)((this.jdField_c_of_type_JavaUtilArrayList.size() * 40 + this.jdField_c_of_type_JavaUtilArrayList.size() * 10) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(localLayoutParams);
    j();
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 200L);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView$GridViewAdapter.notifyDataSetChanged();
  }
  
  public boolean b()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Int)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      int i;
      if (localArrayList != null) {
        i = localArrayList.size();
      } else {
        i = 0;
      }
      c(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131694673), new Object[] { Integer.valueOf(i + this.jdField_a_of_type_Int) }));
      return true;
    }
    return false;
  }
  
  public void d()
  {
    super.d();
    this.jdField_e_of_type_Boolean = true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int[] arrayOfInt = new int[2];
    localEditText.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    if ((paramMotionEvent.getX() >= i) && (paramMotionEvent.getX() <= i + this.jdField_a_of_type_AndroidWidgetEditText.getWidth()) && (paramMotionEvent.getY() >= j))
    {
      paramMotionEvent.getY();
      this.jdField_a_of_type_AndroidWidgetEditText.getHeight();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
      r();
    }
    Object localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    if (this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateTempapiICreateTroopForUI.destoryAdapter();
    }
    localObject = (ITroopCreateService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopCreateService.class, "");
    if (localObject != null) {
      ((ITroopCreateService)localObject).releaseCreateCallback(this);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
  }
  
  public void f()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList.size() < 1) {
      return;
    }
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1500L) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    Object localObject1 = (ITroopCreateService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopCreateService.class, "");
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("group_type", 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateIQQBase.getAccountNickName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
      localStringBuilder.append(HardCodeUtil.a(2131707579));
      ((JSONObject)localObject2).put("name", localStringBuilder.toString());
      ((JSONObject)localObject2).put("classify", 10010);
      ((JSONObject)localObject2).put("isJumpAio", 1);
      ((JSONObject)localObject2).put("create_source", this.jdField_c_of_type_Int);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    ((ITroopCreateInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopCreateInfoService.class, "")).refreshCreateInfo(((JSONObject)localObject2).toString(), 5);
    localObject2 = new ArrayList(this.jdField_c_of_type_JavaUtilArrayList.size());
    ((ArrayList)localObject2).addAll(this.jdField_c_of_type_JavaUtilArrayList);
    ((ITroopCreateService)localObject1).startCreateTroop(this, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (ArrayList)localObject2);
    localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.jdField_c_of_type_Int);
    ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_create_new", "", "create_page", "clk_now", 0, 0, "", ((StringBuilder)localObject2).toString(), "", "");
  }
  
  protected void g()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("param_uins_selected_default");
    this.jdField_b_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("param_uins_hide");
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(AppConstants.BABY_Q_UIN);
    this.jdField_a_of_type_Int = localIntent.getIntExtra("param_max", 2147483647);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("param_min", 1);
    this.jdField_c_of_type_Int = localIntent.getIntExtra("create_source", 0);
  }
  
  @TargetApi(14)
  protected void h()
  {
    a(2131560636);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131371823));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365324);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView = ((CustomHorizontalScrollView)findViewById(2131377006));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131377178));
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377017));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)findViewById(2131366345));
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getLayoutInflater().inflate(2131560458, null);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(localLinearLayout);
    TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, Utils.a(68.0F, getResources())));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addFooterView(localTextView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131376483));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131377068));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localLinearLayout.findViewById(2131363899));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131363945));
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131363940));
    this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131363901));
    this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131363941));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131363902));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131689682));
    this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131689682));
    this.f = ((Button)findViewById(2131365323));
    this.f.setOnClickListener(this);
    setCreateTroopButtonEnable(this.f, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363722));
    if (Build.VERSION.SDK_INT >= 19) {
      q();
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void i()
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView$GridViewAdapter = new NewTroopContactView.GridViewAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView$GridViewAdapter);
    this.jdField_a_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new NewTroopContactView.5(this));
  }
  
  protected void j()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_Float * 40.0F));
    float f1 = this.jdField_a_of_type_Float;
    int i = (int)(40.0F * f1);
    int j = (int)(f1 * 10.0F);
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      if (this.jdField_c_of_type_JavaUtilArrayList.size() < 5)
      {
        f1 = this.jdField_c_of_type_JavaUtilArrayList.size() * 40 + this.jdField_c_of_type_JavaUtilArrayList.size() * 10;
        float f2 = this.jdField_a_of_type_Float;
        i = (int)(f1 * f2) + (int)(f2 * 10.0F);
      }
      else
      {
        i = (int)(this.jdField_a_of_type_Float * 230.0F);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(i, 0, j, 0);
    this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
  }
  
  protected void k()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new NewTroopContactView.6(this));
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSystemService("input_method"));
    }
    k();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new NewTroopContactView.7(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new NewTroopContactView.8(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(new NewTroopContactView.9(this));
  }
  
  public void m()
  {
    Object localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    Object localObject1 = null;
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
      if (localResultRecord.type == 5)
      {
        if (i >= 3)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("…");
          ((StringBuilder)localObject2).toString();
          break;
        }
        if (localObject1 == null)
        {
          localObject1 = localResultRecord.name;
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("、");
          localStringBuilder.append(localResultRecord.name);
          localObject1 = localStringBuilder.toString();
        }
        i += 1;
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateTempapiICreateTroopForUI;
    if (localObject1 != null) {
      ((ICreateTroopForUI)localObject1).setSelectedAndJoinedUins(a(), this.jdField_a_of_type_JavaUtilArrayList);
    }
    i = this.jdField_c_of_type_JavaUtilArrayList.size();
    if (i > 0)
    {
      localObject1 = MessageFormat.format(HardCodeUtil.a(2131707580), new Object[] { Integer.valueOf(i) });
      this.f.setText((CharSequence)localObject1);
      this.f.setContentDescription((CharSequence)localObject1);
      setCreateTroopButtonEnable(this.f, true);
      return;
    }
    this.f.setText(HardCodeUtil.a(2131707581));
    this.f.setContentDescription(HardCodeUtil.a(2131707577));
    setCreateTroopButtonEnable(this.f, false);
  }
  
  public void n()
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText != null)
    {
      localEditText.clearFocus();
      ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
  }
  
  public void o()
  {
    Object localObject;
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject = this.jdField_c_of_type_JavaUtilArrayList;
      localObject = (ResultRecord)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    }
    else
    {
      localObject = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper.a((ResultRecord)localObject);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131363902)
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("create_source", this.jdField_c_of_type_Int);
      TroopCreateUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (Intent)localObject, "/base/face2faceDiscussion");
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      ReportController.b((AppRuntime)localObject, "dc00899", "Grp_create_new", "", "create_page", "clk_face", 0, 0, "", localStringBuilder.toString(), "", "");
    }
    else if (i == 2131363941)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateTempapiICreateTroopForUI.setTabBarVisible(false, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    }
    else if (i == 2131365323)
    {
      f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreateTroopCompletely(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      return;
    }
    paramInt = TroopCreateInfo.TroopCreateResult.a(paramInt);
    if (paramInt != 0) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, paramInt, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
    }
  }
  
  public void onInviteComplete(int paramInt, String paramString) {}
  
  public void onReusedTroop(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateTempapiICreateTroopForUI.jump2Aio(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramString, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView
 * JD-Core Version:    0.7.0.1
 */