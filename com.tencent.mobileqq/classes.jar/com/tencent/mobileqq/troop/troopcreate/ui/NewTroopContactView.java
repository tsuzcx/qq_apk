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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.service.troop.TroopConstants.CreateTroopSource;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService.TroopCreateCallback;
import com.tencent.mobileqq.troop.api.troopcreate.IQQBase;
import com.tencent.mobileqq.troop.createtroopblacklist.api.ICreateTroopBlackListUtilApi;
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
  protected Button A;
  protected Button B;
  protected Button C;
  protected Button D;
  protected Button E;
  protected Button F;
  protected FriendObserver G;
  protected boolean H;
  protected QQBlurView I;
  protected int J = 0;
  RelationFriendsTroopViewHelper K;
  long L = 0L;
  private IQQBase M = (IQQBase)this.b.getRuntimeService(IQQBase.class, "");
  private final Handler N = new NewTroopContactView.1(this);
  private ICreateTroopForUI O = (ICreateTroopForUI)this.b.getRuntimeService(ICreateTroopForUI.class, "");
  private boolean P = true;
  private boolean Q = true;
  public ArrayList<String> c;
  public ArrayList<String> d;
  protected FrameLayout e;
  public EditText f;
  protected boolean g = true;
  protected CustomHorizontalScrollView h;
  protected GridView i;
  InputMethodRelativeLayout j;
  protected View k;
  protected ImageView l;
  protected int m;
  protected int n;
  public ArrayList<ResultRecord> o = new ArrayList();
  protected NewTroopContactView.GridViewAdapter p;
  protected float q;
  protected Dialog r;
  protected IFaceDecoder s;
  protected Bitmap t;
  protected InputMethodManager u = null;
  protected boolean v;
  protected long w = 0L;
  protected PinnedFooterExpandableListView x;
  public PinnedHeaderExpandableListView.ExpandableListAdapter y;
  protected RelativeLayout z;
  
  public NewTroopContactView(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
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
  
  private void c(String paramString)
  {
    int i1 = 0;
    while (i1 < this.o.size())
    {
      if (((ResultRecord)this.o.get(i1)).uin.equals(paramString)) {
        this.o.remove(i1);
      }
      i1 += 1;
    }
    n();
  }
  
  private void d(String paramString)
  {
    if (System.currentTimeMillis() - this.w > 2000)
    {
      QQToast.makeText(this.a, paramString, 2000).show(this.a.getTitleBarHeight());
      this.w = System.currentTimeMillis();
    }
  }
  
  private void q()
  {
    boolean bool = this.a.getIntent().getBooleanExtra("isExpandFirst", true);
    this.y = this.O.getContactListAdapter(this, this.b, this.x, bool);
    this.x.setAdapter(this.y);
    this.x.setSelector(2131168376);
    this.x.setGroupIndicator(this.a.getResources().getDrawable(2130839673));
    this.x.setOnScrollListener((AbsListView.OnScrollListener)this.y);
    this.G = new NewTroopContactView.2(this);
    this.b.addObserver(this.G);
    this.K = new RelationFriendsTroopViewHelper(this.b, this.x, new NewTroopContactView.3(this));
    this.O.setRelationFriendTroopHelper(this.K);
  }
  
  @TargetApi(19)
  private void r()
  {
    this.H = ThemeUtil.isDefaultOrDIYTheme(false);
    if (!this.H)
    {
      this.I.setVisibility(8);
      if ("1103".equals(ThemeUtil.curThemeId)) {
        this.k.setBackgroundColor(-15921907);
      }
      return;
    }
    this.I.setVisibility(0);
    this.I.a(this.x);
    QQBlurView localQQBlurView = this.I;
    localQQBlurView.b(localQQBlurView);
    this.I.c(-1);
    localQQBlurView = this.I;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    localQQBlurView.setEnableBlur(bool);
    this.I.b(0);
    this.I.a(8.0F);
    this.I.a(8);
    this.I.setDisableBlurDrawableRes(2130852377);
    this.I.a(new NewTroopContactView.4(this));
    this.I.d();
    this.I.a();
    this.k.setBackgroundColor(0);
  }
  
  private void s()
  {
    this.u.hideSoftInputFromWindow(this.a.getWindow().peekDecorView().getWindowToken(), 0);
    this.f.setText("");
    this.f.clearFocus();
    this.e.setVisibility(8);
    this.v = false;
  }
  
  public static void setCreateTroopButtonEnable(Button paramButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Context localContext = paramButton.getContext();
      paramButton.setBackgroundResource(2130839460);
      paramButton.setTextColor(localContext.getResources().getColor(2131168041));
      paramButton.setAlpha(1.0F);
    }
    else
    {
      paramButton.setTextColor(Color.parseColor("#ffffff"));
      paramButton.setBackgroundResource(2130852170);
      if (ThemeUtil.isDefaultTheme())
      {
        paramButton.setAlpha(0.5F);
      }
      else
      {
        paramButton.setTextColor(paramButton.getContext().getResources().getColor(2131168041));
        paramButton.setBackgroundResource(2130852171);
      }
    }
    paramButton.setEnabled(paramBoolean);
  }
  
  private void t()
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("param_only_troop_or_discussion_member", true);
    ((Intent)localObject).putExtra("param_entrance", 27);
    ((Intent)localObject).putExtra("param_selected_records_for_create_discussion", this.o);
    ((Intent)localObject).putExtra("param_overload_tips_include_default_count", true);
    ((Intent)localObject).putExtra("param_title", this.a.getString(2131888224));
    ((Intent)localObject).putExtra("param_done_button_wording", this.a.getString(2131916209));
    ((Intent)localObject).putExtra("param_done_button_highlight_wording", this.a.getString(2131916210));
    ((Intent)localObject).putExtra("param_max", 99);
    ((Intent)localObject).putExtra("param_min", 0);
    ((Intent)localObject).putExtra("multi_chat", true);
    ((Intent)localObject).putExtra("param_exit_animation", this.M.getAnimationTypeR2L());
    ((Intent)localObject).putExtra("param_back_button_side", this.M.getBackButtonSideL());
    ((Intent)localObject).setFlags(603979776);
    TroopCreateUtils.a(this.a, (Intent)localObject, "/base/selectMember", 1300);
    this.a.overridePendingTransition(2130772412, 0);
    localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.J);
    ReportController.b((AppRuntime)localObject, "dc00899", "Grp_create_new", "", "create_page", "clk_chose", 0, 0, "", localStringBuilder.toString(), "", "");
  }
  
  public void a()
  {
    super.a();
    if (this.Q)
    {
      this.Q = false;
      AppInterface localAppInterface = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.J);
      ReportController.b(localAppInterface, "dc00899", "Grp_create", "", "grptab", "select_exp", 0, 0, "", localStringBuilder.toString(), "", "");
      if (this.P)
      {
        this.P = false;
        return;
      }
      localAppInterface = this.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.J);
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
    getIntentExtras();
    this.q = getResources().getDisplayMetrics().density;
    h();
    i();
    l();
    q();
    this.t = BaseImageUtil.k();
    this.s = ((IQQAvatarService)this.b.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.b);
    this.s.setDecodeTaskCompletionListener(this.p);
    paramQBaseActivity = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.J);
    ReportController.b(paramQBaseActivity, "dc00899", "Grp_create_new", "", "create_page", "exp_person", 0, 0, "", localStringBuilder.toString(), "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      t();
    }
  }
  
  public boolean a(String paramString)
  {
    int i1 = 0;
    while (i1 < this.o.size())
    {
      if (((ResultRecord)this.o.get(i1)).uin.equals(paramString)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public boolean a(List<ResultRecord> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.o.clear();
    }
    HashSet localHashSet = new HashSet(this.o.size());
    Object localObject = this.o.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    localObject = this.c;
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
        if (m()) {
          break;
        }
        this.o.add(localObject);
      }
    }
    b(true);
    n();
    p();
    return true;
  }
  
  public void b(String paramString)
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
    this.K.d();
  }
  
  public void b(boolean paramBoolean)
  {
    this.i.setNumColumns(this.o.size());
    ViewGroup.LayoutParams localLayoutParams = this.i.getLayoutParams();
    localLayoutParams.width = ((int)((this.o.size() * 40 + this.o.size() * 10) * this.q));
    this.i.setLayoutParams(localLayoutParams);
    j();
    if (paramBoolean) {
      this.N.sendEmptyMessageDelayed(2, 200L);
    }
    this.p.notifyDataSetChanged();
  }
  
  public boolean b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool2 = a(paramString1);
    boolean bool1 = false;
    if (bool2)
    {
      c(paramString1);
    }
    else if (!m())
    {
      bool1 = true;
      this.o.add(a(paramString1, paramString2, paramInt, paramString3));
    }
    b(bool1);
    n();
    return bool1;
  }
  
  public void d()
  {
    super.d();
    this.Q = true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EditText localEditText = this.f;
    if (localEditText == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int[] arrayOfInt = new int[2];
    localEditText.getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[0];
    int i2 = arrayOfInt[1];
    if ((paramMotionEvent.getX() >= i1) && (paramMotionEvent.getX() <= i1 + this.f.getWidth()) && (paramMotionEvent.getY() >= i2))
    {
      paramMotionEvent.getY();
      this.f.getHeight();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    if (this.f.hasFocus()) {
      s();
    }
    Object localObject = this.r;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.r.dismiss();
    }
    localObject = this.s;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    if (this.y != null) {
      this.O.destoryAdapter();
    }
    localObject = (ITroopCreateService)this.b.getRuntimeService(ITroopCreateService.class, "");
    if (localObject != null) {
      ((ITroopCreateService)localObject).releaseCreateCallback(this);
    }
    this.b.removeObserver(this.G);
  }
  
  public boolean f()
  {
    if (!TextUtils.isEmpty(this.f.getText()))
    {
      s();
      return true;
    }
    if (this.f.hasFocus()) {
      s();
    }
    return super.f();
  }
  
  public void g()
  {
    if (this.o.size() < 1) {
      return;
    }
    if (System.currentTimeMillis() - this.L < 1500L) {
      return;
    }
    this.L = System.currentTimeMillis();
    Object localObject1 = (ITroopCreateService)this.b.getRuntimeService(ITroopCreateService.class, "");
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("group_type", 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.M.getAccountNickName(this.b, this.b.getCurrentAccountUin()));
      localStringBuilder.append(HardCodeUtil.a(2131905394));
      ((JSONObject)localObject2).put("name", localStringBuilder.toString());
      ((JSONObject)localObject2).put("classify", 10010);
      ((JSONObject)localObject2).put("isJumpAio", 1);
      ((JSONObject)localObject2).put("create_source", this.J);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    ((ITroopCreateInfoService)this.b.getRuntimeService(ITroopCreateInfoService.class, "")).refreshCreateInfo(((JSONObject)localObject2).toString(), 5);
    localObject2 = new ArrayList(this.o.size());
    ((ArrayList)localObject2).addAll(this.o);
    ((ITroopCreateService)localObject1).startCreateTroop(this, this.a, (ArrayList)localObject2);
    localObject1 = this.b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.J);
    ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_create_new", "", "create_page", "clk_now", 0, 0, "", ((StringBuilder)localObject2).toString(), "", "");
  }
  
  protected void getIntentExtras()
  {
    Intent localIntent = this.a.getIntent();
    this.c = localIntent.getStringArrayListExtra("param_uins_selected_default");
    this.d = localIntent.getStringArrayListExtra("param_uins_hide");
    if (this.d == null) {
      this.d = new ArrayList();
    }
    this.d.add(AppConstants.BABY_Q_UIN);
    this.m = localIntent.getIntExtra("param_max", 2147483647);
    this.n = localIntent.getIntExtra("param_min", 1);
    this.J = localIntent.getIntExtra("create_source", 0);
  }
  
  public ArrayList<String> getResultUins()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.o.size())
    {
      localArrayList.add(((ResultRecord)this.o.get(i1)).uin);
      i1 += 1;
    }
    return localArrayList;
  }
  
  @TargetApi(14)
  protected void h()
  {
    setContentView(2131626681);
    this.j = ((InputMethodRelativeLayout)findViewById(2131439260));
    this.k = findViewById(2131431508);
    this.h = ((CustomHorizontalScrollView)findViewById(2131445370));
    this.i = ((GridView)findViewById(2131445556));
    AccessibilityUtil.a(this.h, false);
    this.l = ((ImageView)findViewById(2131445381));
    this.x = ((PinnedFooterExpandableListView)findViewById(2131432646));
    LinearLayout localLinearLayout = (LinearLayout)this.a.getLayoutInflater().inflate(2131626503, null);
    this.x.addHeaderView(localLinearLayout);
    TextView localTextView = new TextView(this.a);
    localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, Utils.a(68.0F, getResources())));
    this.x.addFooterView(localTextView);
    this.e = ((FrameLayout)findViewById(2131444724));
    this.e.setVisibility(8);
    this.f = ((EditText)findViewById(2131445437));
    this.z = ((RelativeLayout)localLinearLayout.findViewById(2131429849));
    this.z.setVisibility(8);
    this.B = ((Button)localLinearLayout.findViewById(2131429901));
    this.B.setVisibility(8);
    this.E = ((Button)localLinearLayout.findViewById(2131429895));
    this.E.setVisibility(8);
    this.D = ((Button)localLinearLayout.findViewById(2131429852));
    this.D.setVisibility(8);
    this.A = ((Button)localLinearLayout.findViewById(2131429896));
    this.A.setOnClickListener(this);
    this.C = ((Button)localLinearLayout.findViewById(2131429853));
    this.C.setOnClickListener(this);
    this.C.setText(this.a.getString(2131886294));
    this.C.setContentDescription(this.a.getString(2131886294));
    this.F = ((Button)findViewById(2131431507));
    this.F.setOnClickListener(this);
    setCreateTroopButtonEnable(this.F, false);
    this.I = ((QQBlurView)findViewById(2131429645));
    if (Build.VERSION.SDK_INT >= 19) {
      r();
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void i()
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.h.setOverScrollMode(2);
      this.i.setOverScrollMode(2);
    }
    this.p = new NewTroopContactView.GridViewAdapter(this, this.a);
    this.i.setAdapter(this.p);
    this.i.setSmoothScrollbarEnabled(false);
    this.i.setOnItemClickListener(new NewTroopContactView.5(this));
  }
  
  protected void j()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.q * 40.0F));
    float f1 = this.q;
    int i1 = (int)(40.0F * f1);
    int i2 = (int)(f1 * 10.0F);
    if (this.o.size() > 0)
    {
      if (this.o.size() < 5)
      {
        f1 = this.o.size() * 40 + this.o.size() * 10;
        float f2 = this.q;
        i1 = (int)(f1 * f2) + (int)(f2 * 10.0F);
      }
      else
      {
        i1 = (int)(this.q * 230.0F);
      }
      this.l.setVisibility(8);
    }
    else
    {
      this.l.setVisibility(0);
    }
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(i1, 0, i2, 0);
    this.f.setLayoutParams(localLayoutParams);
  }
  
  protected void k()
  {
    this.f.setOnFocusChangeListener(new NewTroopContactView.6(this));
  }
  
  public void l()
  {
    if (this.u == null) {
      this.u = ((InputMethodManager)this.a.getSystemService("input_method"));
    }
    k();
    this.f.setOnKeyListener(new NewTroopContactView.7(this));
    this.f.addTextChangedListener(new NewTroopContactView.8(this));
    this.e.setOnTouchListener(new NewTroopContactView.9(this));
  }
  
  public boolean m()
  {
    if (this.o.size() >= this.m)
    {
      ArrayList localArrayList = this.c;
      int i1;
      if (localArrayList != null) {
        i1 = localArrayList.size();
      } else {
        i1 = 0;
      }
      d(String.format(this.a.getString(2131892365), new Object[] { Integer.valueOf(i1 + this.m) }));
      return true;
    }
    return false;
  }
  
  public void n()
  {
    Object localObject2 = this.o.iterator();
    Object localObject1 = null;
    int i1 = 0;
    while (((Iterator)localObject2).hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
      if (localResultRecord.type == 5)
      {
        if (i1 >= 3)
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
        i1 += 1;
      }
    }
    localObject1 = this.O;
    if (localObject1 != null) {
      ((ICreateTroopForUI)localObject1).setSelectedAndJoinedUins(getResultUins(), this.c);
    }
    i1 = this.o.size();
    if (i1 > 0)
    {
      localObject1 = MessageFormat.format(HardCodeUtil.a(2131905395), new Object[] { Integer.valueOf(i1) });
      this.F.setText((CharSequence)localObject1);
      this.F.setContentDescription((CharSequence)localObject1);
      setCreateTroopButtonEnable(this.F, true);
      return;
    }
    this.F.setText(HardCodeUtil.a(2131905396));
    this.F.setContentDescription(HardCodeUtil.a(2131905392));
    setCreateTroopButtonEnable(this.F, false);
  }
  
  public void o()
  {
    EditText localEditText = this.f;
    if (localEditText != null)
    {
      localEditText.clearFocus();
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.f.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131429853)
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("create_source", this.J);
      TroopCreateUtils.a(this.a, (Intent)localObject, "/base/face2faceDiscussion");
      localObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.J);
      ReportController.b((AppRuntime)localObject, "dc00899", "Grp_create_new", "", "create_page", "clk_face", 0, 0, "", localStringBuilder.toString(), "", "");
    }
    else if (i1 == 2131429896)
    {
      this.O.setTabBarVisible(false, this.a);
    }
    else if (i1 == 2131431507)
    {
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreateTroopCompletely(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString1)))
    {
      this.a.finish();
      return;
    }
    int i1 = TroopCreateInfo.TroopCreateResult.a(paramInt);
    if (i1 != 0)
    {
      if (((ICreateTroopBlackListUtilApi)QRoute.api(ICreateTroopBlackListUtilApi.class)).checkAndHandleCreateGroupBlackListResult(getContext(), this.b, paramString2, paramInt)) {
        return;
      }
      QQToast.makeText(this.a, 1, i1, 0).show(this.a.getTitleBarHeight());
    }
  }
  
  public void onInviteComplete(int paramInt, String paramString) {}
  
  public void onReusedTroop(String paramString)
  {
    this.O.jump2Aio(this.a, paramString, true);
    this.a.finish();
  }
  
  public void p()
  {
    Object localObject;
    if (this.o.size() > 0)
    {
      localObject = this.o;
      localObject = (ResultRecord)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    }
    else
    {
      localObject = null;
    }
    this.K.a((ResultRecord)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView
 * JD-Core Version:    0.7.0.1
 */