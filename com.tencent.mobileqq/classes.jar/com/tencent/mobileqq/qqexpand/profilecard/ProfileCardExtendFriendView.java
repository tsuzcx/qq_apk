package com.tencent.mobileqq.qqexpand.profilecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.BackgroundUtil;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.mobileqq.qqexpand.utils.GradientDrawableUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendGradientFootView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendGradientTextView;
import com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.concurrent.ConcurrentHashMap;

public class ProfileCardExtendFriendView
  extends LinearLayout
  implements View.OnClickListener, View.OnTouchListener
{
  private static boolean aa = false;
  private LinearLayout A;
  private LinearLayout B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private View G;
  private FrameLayout H;
  private ImageView I;
  private ExtendFriendGradientFootView J;
  private Paint K;
  private Bitmap L;
  private RectF M;
  private float N;
  private GradientDrawable O;
  private int P;
  private int Q;
  private ProfileCardTemplate R;
  private QQAppInterface S;
  private int T;
  private VasRes U;
  private ActionSheet V;
  private boolean W;
  private boolean Z;
  protected TextView a;
  private boolean ab;
  private boolean ac;
  private int ad;
  private int ae;
  private ProfileContentTitleView af;
  private boolean ag;
  protected TextView b;
  protected TextView c;
  protected ImageView d;
  protected LinearLayout e;
  protected LinearLayout f;
  protected ExtendFriendGradientTextView g;
  protected ImageView h;
  protected TextView i;
  protected TextView j;
  protected TextView k;
  protected OldExpandVoiceView l;
  public LinearLayout m;
  public TextView n;
  int o;
  int p;
  int q;
  int r;
  int s;
  private LayoutInflater t;
  private String u;
  private boolean v;
  private boolean w;
  private boolean x;
  private Context y;
  private Card z;
  
  public ProfileCardExtendFriendView(Context paramContext)
  {
    super(paramContext);
    this.E = false;
    this.F = true;
    this.W = false;
    this.Z = false;
    this.o = -16777216;
    this.p = -1;
    this.ab = false;
    this.ac = false;
    this.ad = 0;
    this.ae = 0;
    this.af = null;
    this.y = paramContext;
    c();
  }
  
  public ProfileCardExtendFriendView(Context paramContext, ProfileCardTemplate paramProfileCardTemplate, boolean paramBoolean)
  {
    super(paramContext);
    boolean bool = false;
    this.E = false;
    this.F = true;
    this.W = false;
    this.Z = false;
    this.o = -16777216;
    this.p = -1;
    this.ab = false;
    this.ac = false;
    this.ad = 0;
    this.ae = 0;
    this.af = null;
    this.y = paramContext;
    if (paramProfileCardTemplate != null) {
      bool = true;
    }
    this.C = bool;
    this.D = paramBoolean;
    this.R = paramProfileCardTemplate;
    c();
  }
  
  private void a(int paramInt)
  {
    float f1 = this.N;
    this.O = GradientDrawableUtils.a(paramInt, f1, f1, f1, f1);
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.Q > 0)
    {
      if (this.P <= 0) {
        return;
      }
      if (this.M == null) {
        this.M = new RectF();
      }
      int i1;
      if ((!this.v) && (this.x))
      {
        if (this.w) {
          i1 = AIOUtils.b(20.0F, getResources());
        } else {
          i1 = AIOUtils.b(44.0F, getResources());
        }
      }
      else {
        i1 = AIOUtils.b(10.0F, getResources());
      }
      this.M.set(0, 0.0F, this.P - 0, this.Q - i1);
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          a(872415231);
          this.h.setImageResource(1912864785);
          this.i.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(1912864791), null);
        }
        else
        {
          a(-1711276033);
        }
      }
      else if (paramBoolean2)
      {
        this.h.setImageResource(1912864787);
        this.i.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(1912864793), null);
        a(184549375);
      }
      else
      {
        if (this.K == null)
        {
          this.K = new Paint(1);
          this.K.setStyle(Paint.Style.FILL);
          this.K.setAntiAlias(true);
        }
        d();
        if (this.L == null) {
          a(869849304);
        }
        float f1 = this.P / this.L.getWidth();
        paramView = new Matrix();
        paramView.setScale(f1, f1);
        BitmapShader localBitmapShader = new BitmapShader(this.L, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        localBitmapShader.setLocalMatrix(paramView);
        this.K.setShader(localBitmapShader);
      }
      paramView = this.O;
      if (paramView != null) {
        paramView.setBounds(0, 0, this.P - 0, this.Q - i1);
      }
      paramView = (FrameLayout.LayoutParams)this.I.getLayoutParams();
      paramView.width = (this.P - 0);
      paramView.height = (this.Q - i1);
      this.I.setLayoutParams(paramView);
    }
  }
  
  private void c()
  {
    this.t = LayoutInflater.from(getContext());
    this.G = this.t.inflate(1912995852, this, true);
    this.a = ((TextView)this.G.findViewById(1912930448));
    this.b = ((TextView)this.G.findViewById(1912930452));
    this.c = ((TextView)this.G.findViewById(1912930449));
    this.d = ((ImageView)this.G.findViewById(1912930368));
    this.e = ((LinearLayout)this.G.findViewById(1912930373));
    this.f = ((LinearLayout)this.G.findViewById(1912930374));
    this.g = ((ExtendFriendGradientTextView)this.G.findViewById(1912930447));
    this.g.setCardView(this);
    this.h = ((ImageView)this.G.findViewById(1912930369));
    this.h.setOnClickListener(this);
    this.m = ((LinearLayout)this.G.findViewById(1912930336));
    this.n = ((TextView)this.m.findViewById(1912930337));
    this.n.setOnClickListener(this);
    this.l = ((OldExpandVoiceView)this.G.findViewById(1912930367));
    Object localObject = this.l;
    ((OldExpandVoiceView)localObject).a = true;
    ((OldExpandVoiceView)localObject).setMode(2);
    this.l.setOnClickListener(this);
    this.l.setActivity((QBaseActivity)this.y);
    this.i = ((TextView)this.G.findViewById(1912930451));
    this.i.setOnClickListener(this);
    this.j = ((TextView)this.G.findViewById(1912930453));
    this.k = ((TextView)this.G.findViewById(1912930450));
    this.B = ((LinearLayout)this.G.findViewById(1912930329));
    this.H = ((FrameLayout)this.G.findViewById(1912930343));
    this.I = ((ImageView)this.G.findViewById(1912930377));
    this.J = ((ExtendFriendGradientFootView)this.G.findViewById(1912930344));
    localObject = this.G.findViewById(1912930459);
    int i1 = getResources().getDisplayMetrics().widthPixels / 2;
    int i2 = AIOUtils.b(38.0F, getResources());
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.width = (i1 - i2);
    localLayoutParams.leftMargin = AIOUtils.b(10.0F, getResources());
    ((View)localObject).setLayoutParams(localLayoutParams);
    this.A = ((LinearLayout)this.G.findViewById(1912930459));
    this.N = AIOUtils.b(3.0F, getResources());
    addOnLayoutChangeListener(new ProfileCardExtendFriendView.1(this));
  }
  
  private void d()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inSampleSize = 2;
    if ((!TextUtils.isEmpty(this.u)) && (this.u.contains("=")) && (ExpandResourceUtil.b != null) && (ExpandResourceUtil.b.length > 0) && (ExpandResourceUtil.d != null) && (ExpandResourceUtil.d.length > 0))
    {
      int i1 = this.u.indexOf('=');
      i1 = this.u.substring(i1 + 1).toUpperCase().charAt(0);
      int i2 = ExpandResourceUtil.d.length;
      localObject = ExpandResourceUtil.b[(i1 % i2)];
    }
    else
    {
      localObject = "expand_summary_bg.png";
    }
    Object localObject = ExpandResourceUtil.a(ExpandResourceUtil.a((String)localObject), localOptions);
    if (localObject != null)
    {
      this.L = BackgroundUtil.a(getResources(), (Bitmap)localObject, -2565928, 0.2F, false);
      return;
    }
    this.L = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
    new Canvas(this.L).drawColor(-1);
  }
  
  private void e()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      this.E = false;
      ((ExtendFriendGradientTextView)localObject).setFold(false);
      if ((this.ab) && (this.ad != 0))
      {
        localObject = this.af;
        if (localObject != null) {
          ((ProfileContentTitleView)localObject).updateViewHeight(this.ae);
        }
      }
      this.J.setVisibility(8);
      this.h.setRotation(180.0F);
      localObject = this.h;
      ((ImageView)localObject).setPadding(((ImageView)localObject).getPaddingLeft(), AIOUtils.b(16.0F, getResources()), this.h.getPaddingRight(), AIOUtils.b(6.0F, getResources()));
    }
  }
  
  private void f()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      this.E = true;
      if ((this.ab) && (this.ad != 0) && (this.af != null))
      {
        ((ExtendFriendGradientTextView)localObject).setFold(true ^ this.E);
        this.af.updateViewHeight(this.ad);
      }
      else
      {
        this.g.setFold(this.E);
        this.ac = true;
      }
      this.J.setVisibility(0);
      this.h.setRotation(0.0F);
      localObject = this.h;
      ((ImageView)localObject).setPadding(((ImageView)localObject).getPaddingLeft(), AIOUtils.b(6.0F, getResources()), this.h.getPaddingRight(), AIOUtils.b(16.0F, getResources()));
    }
  }
  
  private void g()
  {
    Context localContext = this.y;
    if ((localContext instanceof QBaseActivity))
    {
      if ((((AllInOne)((QBaseActivity)localContext).getIntent().getParcelableExtra("AllInOne")).pa == 96) && (this.ag))
      {
        this.y.sendBroadcast(new Intent("com.tencent.mobileqq.search.finish"));
        ((QBaseActivity)this.y).finish();
        return;
      }
      ((IExpandEntrance)QRoute.api(IExpandEntrance.class)).enterExpand(this.y, this.S, 5);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick("6");
    }
  }
  
  public void a()
  {
    if (SimpleUIUtil.e()) {
      return;
    }
    if (!aa)
    {
      localObject = ((FriendsManager)this.S.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.S.getCurrentAccountUin());
      if ((localObject != null) && (((Card)localObject).declaration == null)) {
        ((IExpandHandler)this.S.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.S.getCurrentAccountUin(), false);
      }
      aa = false;
    }
    Object localObject = this.y;
    if ((((localObject instanceof QBaseActivity)) && (localObject == null)) || (this.g == null)) {
      return;
    }
    if (this.V == null)
    {
      this.V = ActionSheet.create(this.y);
      this.V.addCancelButton(1913061377);
      if (this.Z) {
        this.V.addButton(1913061386);
      }
      if (this.W) {
        this.V.addButton(1913061387);
      }
      if ((!this.W) && (!this.Z)) {
        this.V.addButton(1913061388);
      }
      this.V.setOnButtonClickListener(new ProfileCardExtendFriendView.3(this));
    }
    if (!((QBaseActivity)this.y).isFinishing()) {
      this.V.show();
    }
    VasWebviewUtil.a("strangers_makefriend", "card_click", "", 0, "", "");
  }
  
  public void a(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    this.z = paramCard;
    this.a.setText(String.format("%d", new Object[] { Integer.valueOf(paramCard.popularity) }));
    this.S = paramQQAppInterface;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleGetSummaryCard--vExtendCard 111 popularity=");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" declaration=");
    ((StringBuilder)localObject).append(paramCard.declaration);
    ((StringBuilder)localObject).append(" voiceUrl=");
    ((StringBuilder)localObject).append(paramCard.voiceUrl);
    ((StringBuilder)localObject).append(" updateTime=");
    ((StringBuilder)localObject).append(paramCard.updateTime);
    ((StringBuilder)localObject).append(" duration=");
    ((StringBuilder)localObject).append(this.T);
    ((StringBuilder)localObject).append("fontId = ");
    ((StringBuilder)localObject).append(paramCard.fontId);
    ((StringBuilder)localObject).append("fontType = ");
    ((StringBuilder)localObject).append(paramCard.fontType);
    ((StringBuilder)localObject).append("clothesId= ");
    ((StringBuilder)localObject).append(paramCard.clothesId);
    QLog.d("BusinessCard_CardHandler", 1, ((StringBuilder)localObject).toString());
    if (this.g.a == null) {
      localObject = "";
    } else {
      localObject = this.g.a;
    }
    if ((paramCard.declaration != null) && (!((String)localObject).equals(paramCard.declaration)))
    {
      a(false);
      this.g.setContent(paramCard.declaration);
    }
    this.x = ExpandChatUtil.b(paramQQAppInterface);
    this.u = paramCard.voiceUrl;
    this.v = paramCard.uin.equals(paramQQAppInterface.getCurrentAccountUin());
    if (this.v)
    {
      localObject = getContext().getString(1913061385);
      this.H.setOnClickListener(this);
      this.H.setOnTouchListener(this);
    }
    else
    {
      localObject = (IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      localObject = String.format(getContext().getString(1913061384), new Object[] { ((IExpandManager)localObject).w() });
      this.H.setOnClickListener(this);
    }
    if (!TextUtils.isEmpty(this.u))
    {
      this.A.setVisibility(0);
      this.l.setVoiceDuration(paramCard.extendFriendVoiceDuration);
      this.T = paramCard.extendFriendVoiceDuration;
      this.l.setVoiceUrl(this.u);
    }
    else
    {
      this.A.setVisibility(8);
    }
    a(this.G, this.C, this.D);
    this.n.setText((CharSequence)localObject);
    if ((!this.v) && (this.x))
    {
      if (this.w) {
        this.m.setVisibility(8);
      } else {
        this.m.setVisibility(0);
      }
    }
    else {
      this.m.setVisibility(8);
    }
    b(paramCard, paramQQAppInterface);
    this.J.setColor(this.p);
    if (!SimpleUIUtil.e())
    {
      setClothes(paramCard.clothesId);
      setFont(paramCard.fontId, paramCard.fontType);
    }
    if ((!this.Z) && (!this.W)) {
      paramCard = "1";
    } else {
      paramCard = "2";
    }
    VasWebviewUtil.a("strangers_makefriend", "card_show", "", 0, "", paramCard);
  }
  
  public void a(ITemplateUtils paramITemplateUtils)
  {
    ProfileCardTemplate localProfileCardTemplate = this.R;
    if (localProfileCardTemplate != null)
    {
      paramITemplateUtils.updateViewAttr(this.i, "color", localProfileCardTemplate, "commonItemContentColor");
      paramITemplateUtils.updateViewAttr(this.k, "color", localProfileCardTemplate, "commonItemContentColor");
      paramITemplateUtils.updateViewAttr(this.j, "color", localProfileCardTemplate, "commonItemContentColor");
      paramITemplateUtils.updateViewAttr(this.a, "color", localProfileCardTemplate, "commonItemContentColor");
      paramITemplateUtils.updateViewAttr(this.b, "color", localProfileCardTemplate, "commonItemContentColor");
      paramITemplateUtils.updateViewAttr(this.c, "color", localProfileCardTemplate, "commonItemContentColor");
      paramITemplateUtils = localProfileCardTemplate.templateAttr.get("commonItemContentColor");
      if (paramITemplateUtils != null)
      {
        if ((paramITemplateUtils instanceof ColorStateList))
        {
          this.g.setTextColor(((ColorStateList)paramITemplateUtils).getDefaultColor());
          return;
        }
        if ((paramITemplateUtils instanceof String))
        {
          paramITemplateUtils = (String)paramITemplateUtils;
          if (paramITemplateUtils.startsWith("#")) {
            this.g.setTextColor(Color.parseColor(paramITemplateUtils));
          }
        }
      }
    }
    else if (this.D)
    {
      this.i.setTextColor(getResources().getColor(2131167993));
      this.k.setTextColor(getResources().getColor(2131167993));
      this.j.setTextColor(getResources().getColor(2131167993));
      this.g.setTextColor(getResources().getColor(2131167993));
      this.a.setTextColor(getResources().getColor(2131167993));
      this.b.setTextColor(getResources().getColor(2131167993));
      this.c.setTextColor(getResources().getColor(2131167993));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      this.h.setVisibility(0);
      this.J.setVisibility(0);
      localObject = this.B;
      ((LinearLayout)localObject).setPadding(((LinearLayout)localObject).getPaddingLeft(), this.B.getPaddingTop(), this.B.getPaddingRight(), 0);
      if (this.F)
      {
        f();
        return;
      }
      e();
      return;
    }
    if ((!paramBoolean) && (this.h.getVisibility() != 0))
    {
      localObject = this.g;
      ((ExtendFriendGradientTextView)localObject).b = null;
      ((ExtendFriendGradientTextView)localObject).c = false;
      ((ExtendFriendGradientTextView)localObject).setMaxLines(50);
      this.h.setVisibility(8);
      this.J.setVisibility(8);
      localObject = this.B;
      ((LinearLayout)localObject).setPadding(((LinearLayout)localObject).getPaddingLeft(), this.B.getPaddingTop(), this.B.getPaddingRight(), AIOUtils.b(16.0F, getResources()));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = ((FriendsManager)this.S.getManager(QQManagerFactory.FRIENDS_MANAGER)).g(this.S.getCurrentAccountUin());
    Intent localIntent = new Intent();
    localObject = new ExtendFriendInfo((Card)localObject);
    if (paramBoolean1)
    {
      ((ExtendFriendInfo)localObject).h = this.q;
      ((ExtendFriendInfo)localObject).j = true;
    }
    if (paramBoolean2)
    {
      ((ExtendFriendInfo)localObject).i = this.s;
      ((ExtendFriendInfo)localObject).k = true;
    }
    localIntent.putExtra("key_extend_friend_info", (Parcelable)localObject);
    ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult((Activity)this.y, localIntent, 4097);
  }
  
  public void b()
  {
    OldExpandVoiceView localOldExpandVoiceView = this.l;
    if (localOldExpandVoiceView != null) {
      localOldExpandVoiceView.c();
    }
  }
  
  public void b(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    if ((!TextUtils.isEmpty(paramCard.schoolName)) && (!TextUtils.isEmpty(paramCard.schoolId)))
    {
      this.e.setVisibility(0);
      TextView localTextView = this.c;
      String str = paramCard.schoolName;
      int i1;
      if (paramCard.authState == 2L) {
        i1 = 1912864777;
      } else {
        i1 = 1912864781;
      }
      Context localContext = getContext();
      ProfileCardExtendFriendView.4 local4;
      if (this.v) {
        local4 = new ProfileCardExtendFriendView.4(this, paramCard);
      } else {
        local4 = null;
      }
      localTextView.setText(ProfileCardUtil.a(str, false, i1, 1912799236, 1912799235, localContext, paramQQAppInterface, local4));
      this.c.setMovementMethod(LinkMovementMethod.getInstance());
      this.f.post(new ProfileCardExtendFriendView.5(this, paramCard));
      return;
    }
    this.e.setVisibility(8);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = this.M;
    if (localObject != null)
    {
      Paint localPaint = this.K;
      if ((localPaint != null) && (!this.ab))
      {
        float f1 = this.N;
        paramCanvas.drawRoundRect((RectF)localObject, f1, f1, localPaint);
        break label58;
      }
    }
    localObject = this.O;
    if (localObject != null) {
      ((GradientDrawable)localObject).draw(paramCanvas);
    }
    label58:
    super.dispatchDraw(paramCanvas);
  }
  
  public ETTextView getInfo()
  {
    return this.g;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    int i1;
    if (paramView.getId() == 1912930337)
    {
      if (this.v)
      {
        paramView = new Intent();
        localObject = this.z;
        if (localObject != null)
        {
          localObject = new ExtendFriendInfo((Card)localObject);
          ((ExtendFriendInfo)localObject).f = this.q;
          ((ExtendFriendInfo)localObject).g = this.s;
          paramView.putExtra("key_extend_friend_info", (Parcelable)localObject);
        }
        if ((this.y instanceof Activity))
        {
          ReportController.b(this.S, "dc00898", "", "", "0X80092DE", "0X80092DE", 1, 0, "", "", "", "");
          ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult((Activity)this.y, paramView, 4097);
        }
      }
      else
      {
        boolean bool = ExpandChatUtil.b(this.S);
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("click extend_friend_more_text showEntry = ");
          paramView.append(bool);
          QLog.d("ProfileCardExtendFriendView", 2, paramView.toString());
        }
        if (!bool) {
          return;
        }
        paramView = this.S;
        if (this.ag) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        ReportController.b(paramView, "dc00898", "", "", "0X80092E5", "0X80092E5", i1, 0, "", "", "", "");
        g();
      }
    }
    else
    {
      if (paramView.getId() == 1912930367)
      {
        if (this.l.a())
        {
          this.l.c();
          return;
        }
        if (this.v)
        {
          ReportController.b(this.S, "dc00898", "", "", "0X80092DD", "0X80092DD", 0, 0, "", "", "", "");
        }
        else
        {
          i1 = (this.T - 1) / 10;
          ReportController.b(this.S, "dc00898", "", "", "0X80092E4", "0X80092E4", i1 + 1, 0, "", "", "", "");
        }
        ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#data_page#zl_voice", true, -1L, -1L, null, true, true);
        this.l.b();
        return;
      }
      if (paramView.getId() == 1912930369)
      {
        if (this.E)
        {
          e();
          return;
        }
        f();
        return;
      }
      if (paramView.getId() == 1912930451)
      {
        if (this.v) {
          ReportController.b(this.S, "dc00898", "", "", "0X80092DC", "0X80092DC", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.S, "dc00898", "", "", "0X80092E6", "0X80092E6", 0, 0, "", "", "", "");
        }
        paramView = new Intent(getContext(), QQBrowserActivity.class);
        paramView.putExtra("url", "https://sqimg.qq.com/qq_product_operations/popularRule/popularRules.html");
        getContext().startActivity(paramView);
        return;
      }
      if (paramView.getId() == 1912930343) {
        if (this.v)
        {
          paramView = new Intent();
          localObject = this.z;
          if (localObject != null)
          {
            localObject = new ExtendFriendInfo((Card)localObject);
            ((ExtendFriendInfo)localObject).f = this.q;
            ((ExtendFriendInfo)localObject).g = this.s;
            paramView.putExtra("key_extend_friend_info", (Parcelable)localObject);
          }
          if ((this.y instanceof Activity))
          {
            ReportController.b(this.S, "dc00898", "", "", "0X80092DE", "0X80092DE", 2, 0, "", "", "", "");
            ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult((Activity)this.y, paramView, 4097);
          }
        }
        else
        {
          a();
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    VasRes localVasRes = this.U;
    if (localVasRes != null) {
      localVasRes.a();
    }
    this.U = null;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.P = paramInt1;
    this.Q = paramInt2;
    View localView = this.G;
    if (localView != null) {
      a(localView, this.C, this.D);
    }
    invalidate();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 3)) {
        return false;
      }
      this.I.setVisibility(8);
      return false;
    }
    this.I.setVisibility(0);
    return false;
  }
  
  public void setClothes(int paramInt)
  {
    if (this.s == paramInt) {
      return;
    }
    if (paramInt == 0)
    {
      this.Z = false;
      this.s = paramInt;
      this.H.setBackground(null);
      this.g.setTextColor(-16777216);
      this.a.setTextColor(-16777216);
      this.i.setTextColor(-16777216);
      this.j.setTextColor(-16777216);
      this.k.setTextColor(-16777216);
      return;
    }
    if (paramInt > 10000)
    {
      this.s = paramInt;
      this.Z = true;
      if ((this.H.getBackground() instanceof VasResDrawable))
      {
        ((VasResDrawable)this.H.getBackground()).a(paramInt);
        return;
      }
      VasResDrawable localVasResDrawable = new VasResDrawable(this.S, paramInt);
      SignatureAdapter localSignatureAdapter = new SignatureAdapter(localVasResDrawable, this.S, 2130847784);
      localSignatureAdapter.a(true);
      localSignatureAdapter.a(new ProfileCardExtendFriendView.2(this));
      localVasResDrawable.a(localSignatureAdapter);
      this.H.setBackgroundDrawable(localVasResDrawable);
    }
  }
  
  public void setDiyCard(boolean paramBoolean)
  {
    this.ab = paramBoolean;
  }
  
  public void setETTextColorFromClothes(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    if ((paramSignatureTemplateInfo != null) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.j)))
    {
      this.o = Color.parseColor(paramSignatureTemplateInfo.j);
      ExtendFriendGradientTextView localExtendFriendGradientTextView = this.g;
      if (localExtendFriendGradientTextView != null)
      {
        int i1 = this.o;
        if (i1 != 0) {
          localExtendFriendGradientTextView.setTextColor(i1);
        }
      }
    }
    if ((paramSignatureTemplateInfo != null) && (paramSignatureTemplateInfo.A != null) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.A)))
    {
      this.p = Color.parseColor(paramSignatureTemplateInfo.A);
      this.J.setColor(this.p);
      if (SignTextEditFragment.a(this.p))
      {
        this.a.setTextColor(-1);
        this.i.setTextColor(-1);
        this.j.setTextColor(-1);
        this.k.setTextColor(-1);
        this.b.setTextColor(-1);
        this.c.setTextColor(-1);
        return;
      }
      this.a.setTextColor(-16777216);
      this.i.setTextColor(-16777216);
      this.j.setTextColor(-16777216);
      this.k.setTextColor(-16777216);
      this.b.setTextColor(-16777216);
      this.c.setTextColor(-16777216);
    }
  }
  
  public void setFold(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }
  
  public void setFont(int paramInt1, int paramInt2)
  {
    if (this.q == paramInt1) {
      return;
    }
    if (paramInt1 == 0)
    {
      this.W = false;
      this.q = paramInt1;
      this.r = paramInt2;
      this.g.setVisibility(0);
      this.g.setFont(0, System.currentTimeMillis());
      return;
    }
    this.q = paramInt1;
    this.r = paramInt2;
    this.g.setVisibility(0);
    this.g.setFont(0, System.currentTimeMillis());
    this.W = true;
    Object localObject = this.U;
    if (localObject == null)
    {
      this.U = new VasRes(this.S, paramInt1);
      localObject = new SignatureFontAdapter(this.U, this.S, paramInt2);
      localExtendFriendGradientTextView = this.g;
      ((SignatureFontAdapter)localObject).a(localExtendFriendGradientTextView, localExtendFriendGradientTextView.getTextSize(), true);
      this.U.a((VasResAdapter)localObject);
      ((SignatureFontAdapter)localObject).a(-1);
      return;
    }
    localObject = (SignatureFontAdapter)((VasRes)localObject).c();
    ExtendFriendGradientTextView localExtendFriendGradientTextView = this.g;
    ((SignatureFontAdapter)localObject).a(localExtendFriendGradientTextView, localExtendFriendGradientTextView.getTextSize(), true);
    ((SignatureFontAdapter)this.U.c()).a(paramInt1, paramInt2);
  }
  
  public void setFromExtendFriend(boolean paramBoolean)
  {
    this.ag = paramBoolean;
  }
  
  public void setIsFromLimitChat(boolean paramBoolean)
  {
    this.w = paramBoolean;
    if ((!this.v) && (this.x))
    {
      if (this.w)
      {
        this.m.setVisibility(8);
        return;
      }
      this.m.setVisibility(0);
      return;
    }
    this.m.setVisibility(8);
  }
  
  public void setProfileCardFavorShowView(ProfileContentTitleView paramProfileContentTitleView)
  {
    this.af = paramProfileContentTitleView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView
 * JD-Core Version:    0.7.0.1
 */