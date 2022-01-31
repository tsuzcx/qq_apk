package com.tencent.mobileqq.troop.createNewTroop;

import aepi;
import alof;
import altm;
import alud;
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
import ayme;
import aymf;
import ayml;
import aymm;
import aynq;
import ayqi;
import azqs;
import bbne;
import bbno;
import bbnp;
import bbnq;
import bbnr;
import bbns;
import bbnt;
import bbnu;
import bbnv;
import bbnw;
import bbnx;
import bboi;
import bbqu;
import bbrd;
import bbrf;
import bcpx;
import bczz;
import bdbb;
import bdgc;
import bdhj;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class NewTroopContactView
  extends AbsNewTroopBaseView
  implements View.OnClickListener, ayqi, bbrd
{
  protected float a;
  protected int a;
  protected long a;
  protected altm a;
  protected Dialog a;
  public Bitmap a;
  private final Handler jdField_a_of_type_AndroidOsHandler = new bbno(this);
  protected View a;
  protected InputMethodManager a;
  protected Button a;
  public EditText a;
  public FrameLayout a;
  public GridView a;
  protected ImageView a;
  protected RelativeLayout a;
  public bbne a;
  public bbnx a;
  public bboi a;
  public bdbb a;
  public ContactSearchFragment a;
  public CustomHorizontalScrollView a;
  InputMethodRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout;
  protected QQBlurView a;
  public PinnedFooterExpandableListView a;
  public ArrayList<String> a;
  public boolean a;
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
  
  public NewTroopContactView(NewTroopCreateActivity paramNewTroopCreateActivity)
  {
    super(paramNewTroopCreateActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.jdField_a_of_type_JavaLangString = paramString1;
    localResultRecord.b = paramString2;
    localResultRecord.jdField_a_of_type_Int = paramInt;
    localResultRecord.c = paramString3;
    return localResultRecord;
  }
  
  private ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
      i += 1;
    }
    return localArrayList;
  }
  
  private void b(String paramString)
  {
    int i = 0;
    while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
        this.jdField_c_of_type_JavaUtilArrayList.remove(i);
      }
      i += 1;
    }
    m();
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (this.jdField_c_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Int) {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label67;
      }
    }
    label67:
    for (int i = this.jdField_a_of_type_JavaUtilArrayList.size();; i = 0)
    {
      d(String.format(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getString(2131695096), new Object[] { Integer.valueOf(i + this.jdField_a_of_type_Int) }));
      bool = true;
      return bool;
    }
  }
  
  private void d(String paramString)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 2000)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, paramString, 2000).b(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getTitleBarHeight());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private void o()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getIntent().getBooleanExtra("isExpandFirst", true);
    this.jdField_a_of_type_Bbne = new bbne(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, bool);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_Bbne);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167140);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getResources().getDrawable(2130839302));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_Bbne);
    this.jdField_a_of_type_Altm = new bbnp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_Bboi = new bboi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new bbnq(this));
    this.jdField_a_of_type_Bbne.a(this.jdField_a_of_type_Bboi);
  }
  
  @TargetApi(19)
  private void p()
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (Build.VERSION.SDK_INT >= 24) {}
    for (boolean bool = true;; bool = false)
    {
      localQQBlurView.setEnableBlur(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130849530);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new bbnr(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
      return;
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void r()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_only_troop_or_discussion_member", true);
    localIntent.putExtra("param_entrance", 27);
    localIntent.putExtra("param_selected_records_for_create_discussion", this.jdField_c_of_type_JavaUtilArrayList);
    localIntent.putExtra("param_overload_tips_include_default_count", true);
    localIntent.putExtra("param_title", this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getString(2131691330));
    localIntent.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getString(2131719712));
    localIntent.putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getString(2131719713));
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_min", 0);
    localIntent.putExtra("multi_chat", true);
    localIntent.putExtra("param_exit_animation", 2);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.setFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivityForResult(localIntent, 1300);
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.overridePendingTransition(2130772271, 0);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_chose", 0, 0, "", "" + this.jdField_c_of_type_Int, "", "");
  }
  
  private void s()
  {
    ResultRecord localResultRecord = null;
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0) {
      localResultRecord = (ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_JavaUtilArrayList.size() - 1);
    }
    this.jdField_a_of_type_Bboi.a(localResultRecord);
  }
  
  public static void setCreateTroopButtonEnable(Button paramButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Context localContext = paramButton.getContext();
      paramButton.setBackgroundResource(2130839108);
      paramButton.setTextColor(localContext.getResources().getColor(2131166934));
      paramButton.setAlpha(1.0F);
    }
    for (;;)
    {
      paramButton.setEnabled(paramBoolean);
      return;
      paramButton.setTextColor(Color.parseColor("#ffffff"));
      paramButton.setBackgroundResource(2130849481);
      paramButton.setAlpha(0.5F);
    }
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 4194309, null, this.jdField_b_of_type_JavaUtilArrayList, this);
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "grptab", "select_exp", 0, 0, "", "" + this.jdField_c_of_type_Int, "", "");
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_Boolean = false;
      }
    }
    else
    {
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "grptab", "select_clk", 0, 0, "", "" + this.jdField_c_of_type_Int, "", "");
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1300) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {
        a(paramIntent, true);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.finish();
    }
    do
    {
      return;
      paramInt = bbrf.a(paramInt);
    } while (paramInt == 0);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, 1, paramInt, 0).b(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getTitleBarHeight());
  }
  
  public void a(View paramView)
  {
    aynq localaynq = (aynq)paramView.getTag(2131379971);
    if (localaynq == null) {
      return;
    }
    String str1 = localaynq.b();
    String str2 = localaynq.a().toString();
    paramView = "-1";
    label52:
    int i;
    if ((localaynq instanceof ayme))
    {
      paramView = ((ayme)localaynq).e();
      if (((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(str1))) || (a(str1)) || (b())) {
        break label165;
      }
      if (!(localaynq instanceof ayme)) {
        break label167;
      }
      i = 2;
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_c_of_type_JavaUtilArrayList.add(a(str1, str2, i, paramView));
      }
      m();
      this.jdField_a_of_type_Bbne.notifyDataSetChanged();
      b(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      s();
      return;
      if (!(localaynq instanceof ayml)) {
        break label52;
      }
      paramView = ((ayml)localaynq).jdField_a_of_type_JavaLangString;
      break label52;
      label165:
      break;
      label167:
      if ((localaynq instanceof ayml)) {
        i = 1;
      } else if ((localaynq instanceof aymf)) {
        i = 0;
      } else if ((localaynq instanceof aymm))
      {
        if (str1.startsWith("+")) {
          i = 4;
        } else {
          i = 0;
        }
      }
      else {
        i = -1;
      }
    }
  }
  
  public void a(NewTroopCreateActivity paramNewTroopCreateActivity)
  {
    super.a(paramNewTroopCreateActivity);
    g();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    h();
    i();
    l();
    o();
    this.jdField_a_of_type_AndroidGraphicsBitmap = bdhj.a();
    this.jdField_a_of_type_Bdbb = new bdbb(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bdbb.a(this.jdField_a_of_type_Bbnx);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "exp_person", 0, 0, "", "" + this.jdField_c_of_type_Int, "", "");
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
    if (QLog.isColorLevel()) {
      QLog.i("createNewTroop.NewTroopContactView", 2, "onRelationTroopItemClick: troopUin:" + paramString);
    }
    c(paramString);
    this.jdField_a_of_type_Bboi.d();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      r();
    }
  }
  
  protected boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))
    {
      q();
      return true;
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
      q();
    }
    return super.a();
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if (((ResultRecord)this.jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool = false;
    if (a(paramString1)) {
      b(paramString1);
    }
    for (;;)
    {
      b(bool);
      m();
      return bool;
      if (!b())
      {
        bool = true;
        this.jdField_c_of_type_JavaUtilArrayList.add(a(paramString1, paramString2, paramInt, paramString3));
      }
    }
  }
  
  public boolean a(List<ResultRecord> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
    }
    HashSet localHashSet = new HashSet(this.jdField_c_of_type_JavaUtilArrayList.size());
    Object localObject = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((ResultRecord)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add((String)((Iterator)localObject).next());
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (ResultRecord)paramList.next();
      if (!localHashSet.contains(((ResultRecord)localObject).jdField_a_of_type_JavaLangString))
      {
        if (b()) {
          break;
        }
        this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
      }
    }
    b(true);
    m();
    s();
    return true;
  }
  
  public void b(int paramInt, String paramString) {}
  
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
    this.jdField_a_of_type_Bbnx.notifyDataSetChanged();
  }
  
  public void c(String paramString)
  {
    bcpx.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, paramString, true);
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.finish();
  }
  
  protected void d()
  {
    super.d();
    this.jdField_e_of_type_Boolean = true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidWidgetEditText.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    if ((paramMotionEvent.getX() >= i) && (paramMotionEvent.getX() <= i + this.jdField_a_of_type_AndroidWidgetEditText.getWidth()) && (paramMotionEvent.getY() >= j) && (paramMotionEvent.getY() > j + this.jdField_a_of_type_AndroidWidgetEditText.getHeight())) {}
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
      q();
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
    }
    if (this.jdField_a_of_type_Bbne != null) {
      this.jdField_a_of_type_Bbne.b();
    }
    bbqu localbbqu = (bbqu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if (localbbqu != null) {
      localbbqu.a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
  }
  
  public void f()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList.size() < 1) {}
    bbqu localbbqu;
    do
    {
      do
      {
        return;
      } while (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1500L);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      localbbqu = (bbqu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    } while (localbbqu == null);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("group_type", 1);
      ((JSONObject)localObject).put("name", bdgc.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) + alud.a(2131707963));
      ((JSONObject)localObject).put("classify", 10010);
      ((JSONObject)localObject).put("isJumpAio", 1);
      ((JSONObject)localObject).put("create_source", this.jdField_c_of_type_Int);
      localbbqu.a(((JSONObject)localObject).toString(), 5);
      localObject = new ArrayList(this.jdField_c_of_type_JavaUtilArrayList.size());
      ((ArrayList)localObject).addAll(this.jdField_c_of_type_JavaUtilArrayList);
      localbbqu.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, (ArrayList)localObject);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_now", 0, 0, "", "" + this.jdField_c_of_type_Int, "", "");
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  protected void g()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("param_uins_selected_default");
    this.jdField_b_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("param_uins_hide");
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(alof.aC);
    this.jdField_a_of_type_Int = localIntent.getIntExtra("param_max", 2147483647);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("param_min", 1);
    this.jdField_c_of_type_Int = localIntent.getIntExtra("create_source", 0);
  }
  
  @TargetApi(14)
  protected void h()
  {
    a(2131560426);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131371102));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364925);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView = ((CustomHorizontalScrollView)findViewById(2131376208));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131376375));
    bczz.a(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376221));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)findViewById(2131365862));
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getLayoutInflater().inflate(2131560252, null);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(localLinearLayout);
    TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity);
    localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, aepi.a(68.0F, getResources())));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addFooterView(localTextView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131375722));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131376271));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localLinearLayout.findViewById(2131363551));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131363599));
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131363594));
    this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131363553));
    this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131363595));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131363554));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getString(2131689738));
    this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getString(2131689738));
    this.f = ((Button)findViewById(2131364924));
    this.f.setOnClickListener(this);
    setCreateTroopButtonEnable(this.f, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363384));
    if (Build.VERSION.SDK_INT >= 19) {
      p();
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
    this.jdField_a_of_type_Bbnx = new bbnx(this, this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Bbnx);
    this.jdField_a_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new bbns(this));
  }
  
  protected void j()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_Float * 40.0F));
    int i = (int)(this.jdField_a_of_type_Float * 40.0F);
    int j = (int)(this.jdField_a_of_type_Float * 10.0F);
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0) {
      if (this.jdField_c_of_type_JavaUtilArrayList.size() < 5)
      {
        i = (int)((this.jdField_c_of_type_JavaUtilArrayList.size() * 40 + this.jdField_c_of_type_JavaUtilArrayList.size() * 10) * this.jdField_a_of_type_Float) + (int)(this.jdField_a_of_type_Float * 10.0F);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(i, 0, j, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
      return;
      i = (int)(230.0F * this.jdField_a_of_type_Float);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  protected void k()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bbnt(this));
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getSystemService("input_method"));
    }
    k();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new bbnu(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bbnv(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(new bbnw(this));
  }
  
  protected void m()
  {
    String str = null;
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    ResultRecord localResultRecord;
    if (localIterator.hasNext())
    {
      localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.jdField_a_of_type_Int != 5) {
        break label231;
      }
      if (i >= 3) {
        new StringBuilder().append(str).append("…").toString();
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.a(a(), this.jdField_a_of_type_JavaUtilArrayList);
      }
      i = this.jdField_c_of_type_JavaUtilArrayList.size();
      if (i <= 0) {
        break label196;
      }
      str = MessageFormat.format(alud.a(2131707964), new Object[] { Integer.valueOf(i) });
      this.f.setText(str);
      this.f.setContentDescription(str);
      setCreateTroopButtonEnable(this.f, true);
      return;
    }
    if (str == null)
    {
      str = localResultRecord.b;
      label157:
      i += 1;
    }
    label196:
    label231:
    for (;;)
    {
      break;
      str = str + "、" + localResultRecord.b;
      break label157;
      this.f.setText(alud.a(2131707965));
      this.f.setContentDescription(alud.a(2131707961));
      setCreateTroopButtonEnable(this.f, false);
      return;
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363554: 
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, CreateFaceToFaceDiscussionActivity.class);
      paramView.putExtra("create_source", this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivity(paramView);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_face", 0, 0, "", "" + this.jdField_c_of_type_Int, "", "");
      return;
    case 2131363595: 
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.a(false);
      return;
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView
 * JD-Core Version:    0.7.0.1
 */