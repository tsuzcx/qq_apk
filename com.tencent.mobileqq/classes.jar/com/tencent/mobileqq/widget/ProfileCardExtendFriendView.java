package com.tencent.mobileqq.widget;

import agej;
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
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
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
import anyw;
import asvg;
import asvi;
import atbf;
import atca;
import atcj;
import atcv;
import azxy;
import bdgb;
import bdll;
import bhhz;
import bhzd;
import biai;
import biba;
import bibd;
import bjap;
import bjaq;
import bjar;
import bjas;
import blir;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendGradientFootView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendGradientTextView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

public class ProfileCardExtendFriendView
  extends LinearLayout
  implements View.OnClickListener, View.OnTouchListener
{
  private static boolean jdField_i_of_type_Boolean;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -16777216;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  private azxy jdField_a_of_type_Azxy;
  private biai jdField_a_of_type_Biai;
  private blir jdField_a_of_type_Blir;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private ExtendFriendGradientFootView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView;
  protected ExtendFriendGradientTextView a;
  protected ExtendFriendVoiceView a;
  private ProfileCardFavorShowView jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorShowView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = -1;
  protected ImageView b;
  protected LinearLayout b;
  protected TextView b;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  public LinearLayout c;
  protected TextView c;
  private boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  protected TextView d;
  private boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  protected TextView e;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  protected TextView f;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  public TextView g;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private boolean k;
  
  public ProfileCardExtendFriendView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  public ProfileCardExtendFriendView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  public ProfileCardExtendFriendView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  public ProfileCardExtendFriendView(Context paramContext, azxy paramazxy, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramazxy != null) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Azxy = paramazxy;
      c();
      return;
      bool = false;
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = atcv.a(paramInt, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
  }
  
  private void a(View paramView, azxy paramazxy, boolean paramBoolean)
  {
    if (paramazxy != null)
    {
      azxy.a(this.jdField_d_of_type_AndroidWidgetTextView, "color", paramazxy, "commonItemContentColor");
      azxy.a(this.jdField_f_of_type_AndroidWidgetTextView, "color", paramazxy, "commonItemContentColor");
      azxy.a(this.jdField_e_of_type_AndroidWidgetTextView, "color", paramazxy, "commonItemContentColor");
      azxy.a(this.jdField_a_of_type_AndroidWidgetTextView, "color", paramazxy, "commonItemContentColor");
      azxy.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramazxy, "commonItemContentColor");
      azxy.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramazxy, "commonItemContentColor");
      paramView = paramazxy.a.get("commonItemContentColor");
      if (paramView != null)
      {
        if (!(paramView instanceof ColorStateList)) {
          break label112;
        }
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(((ColorStateList)paramView).getDefaultColor());
      }
    }
    label112:
    while (!paramBoolean)
    {
      do
      {
        do
        {
          return;
        } while (!(paramView instanceof String));
        paramView = (String)paramView;
      } while (!paramView.startsWith("#"));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(Color.parseColor(paramView));
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166990));
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166990));
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166990));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(getResources().getColor(2131166990));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166990));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166990));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166990));
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_g_of_type_Int <= 0) || (this.jdField_f_of_type_Int <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    }
    float f1;
    int m;
    if (this.jdField_a_of_type_Boolean)
    {
      f1 = 10.0F;
      m = agej.a(f1, getResources());
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0, 0.0F, this.jdField_f_of_type_Int - 0, this.jdField_g_of_type_Int - m);
      if (!paramBoolean1) {
        break label208;
      }
      if (!paramBoolean2) {
        break label199;
      }
      a(872415231);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845162);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130845169), null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setBounds(0, 0, this.jdField_f_of_type_Int - 0, this.jdField_g_of_type_Int - m);
      }
      paramView = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.width = (this.jdField_f_of_type_Int + 0);
      paramView.height = (this.jdField_g_of_type_Int - m);
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
      return;
      f1 = 44.0F;
      break;
      label199:
      a(-1711276033);
      continue;
      label208:
      if (paramBoolean2)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845164);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130845171), null);
        a(184549375);
      }
      else
      {
        if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
        {
          this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
          this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
          this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        }
        d();
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          a(869849304);
        }
        f1 = this.jdField_f_of_type_Int / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        paramView = new Matrix();
        paramView.setScale(f1, f1);
        BitmapShader localBitmapShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        localBitmapShader.setLocalMatrix(paramView);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localBitmapShader);
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561450, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379998));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380148));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380063));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369127));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370236));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370237));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView = ((ExtendFriendGradientTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379902));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setCardView(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369189));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366188));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131366189));
    this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368570));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(2);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380146));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380149));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380142));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365909));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366757));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370633));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView = ((ExtendFriendGradientFootView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367014));
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381204);
    int m = getResources().getDisplayMetrics().widthPixels / 2;
    int n = agej.a(38.0F, getResources());
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = (m - n);
    localLayoutParams.leftMargin = agej.a(10.0F, getResources());
    localView.setLayoutParams(localLayoutParams);
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381204));
    this.jdField_a_of_type_Float = agej.a(3.0F, getResources());
    a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Azxy, this.jdField_d_of_type_Boolean);
    addOnLayoutChangeListener(new bjap(this));
  }
  
  private void d()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inSampleSize = 2;
    int m;
    int n;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("=")) && (atcj.b != null) && (atcj.b.length > 0) && (atcj.d != null) && (atcj.d.length > 0))
    {
      m = this.jdField_a_of_type_JavaLangString.indexOf('=');
      m = this.jdField_a_of_type_JavaLangString.substring(m + 1).toUpperCase().charAt(0);
      n = atcj.d.length;
    }
    for (Object localObject = atcj.b[(m % n)];; localObject = "expand_summary_bg.png")
    {
      localObject = atcj.a(atcj.a((String)localObject), localOptions);
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = atca.a(getResources(), (Bitmap)localObject, -2565928, 0.2F, false);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
    new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap).drawColor(-1);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView != null)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setFold(false);
      if ((this.jdField_j_of_type_Boolean) && (this.jdField_i_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorShowView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorShowView.a(this.jdField_j_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setRotation(180.0F);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(this.jdField_b_of_type_AndroidWidgetImageView.getPaddingLeft(), agej.a(16.0F, getResources()), this.jdField_b_of_type_AndroidWidgetImageView.getPaddingRight(), agej.a(6.0F, getResources()));
    }
  }
  
  private void f()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView != null)
    {
      this.jdField_e_of_type_Boolean = true;
      if ((!this.jdField_j_of_type_Boolean) || (this.jdField_i_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorShowView == null)) {
        break label126;
      }
      ExtendFriendGradientTextView localExtendFriendGradientTextView = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView;
      if (this.jdField_e_of_type_Boolean) {
        break label121;
      }
      localExtendFriendGradientTextView.setFold(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorShowView.a(this.jdField_i_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setRotation(0.0F);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(this.jdField_b_of_type_AndroidWidgetImageView.getPaddingLeft(), agej.a(6.0F, getResources()), this.jdField_b_of_type_AndroidWidgetImageView.getPaddingRight(), agej.a(16.0F, getResources()));
      return;
      label121:
      bool = false;
      break;
      label126:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setFold(this.jdField_e_of_type_Boolean);
      this.k = true;
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FriendProfileCardActivity))
    {
      if ((((ProfileActivity.AllInOne)((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).getIntent().getParcelableExtra("AllInOne")).jdField_a_of_type_Int == 96) && (((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).jdField_e_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(new Intent("com.tencent.mobileqq.search.finish"));
        ((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).finish();
      }
    }
    else {
      return;
    }
    ExtendFriendPublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a()
  {
    if (bdgb.b()) {}
    do
    {
      return;
      if (!jdField_i_of_type_Boolean)
      {
        if (((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).declaration == null) {
          ((asvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
        }
        jdField_i_of_type_Boolean = false;
      }
    } while ((((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_AndroidContentContext == null)) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView == null));
    if (this.jdField_a_of_type_Blir == null)
    {
      this.jdField_a_of_type_Blir = blir.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Blir.c(2131690580);
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_Blir.b(2131717922);
      }
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_Blir.b(2131717923);
      }
      if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean)) {
        this.jdField_a_of_type_Blir.b(2131717924);
      }
      this.jdField_a_of_type_Blir.a(new bjar(this));
    }
    if (!((BaseActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) {
      this.jdField_a_of_type_Blir.show();
    }
    VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_click", "", 0, "", "");
  }
  
  public void a(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%d", new Object[] { Integer.valueOf(paramCard.popularity) }));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    QLog.d("BusinessCard_CardHandler", 1, "handleGetSummaryCard--vExtendCard 111 popularity=" + this.jdField_a_of_type_AndroidWidgetTextView + " declaration=" + paramCard.declaration + " voiceUrl=" + paramCard.voiceUrl + " updateTime=" + paramCard.updateTime + " duration=" + this.jdField_h_of_type_Int + "fontId = " + paramCard.fontId + "fontType = " + paramCard.fontType + "clothesId= " + paramCard.clothesId);
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.jdField_a_of_type_JavaLangString == null)
    {
      localObject = "";
      if ((paramCard.declaration != null) && (!((String)localObject).equals(paramCard.declaration)))
      {
        a(false);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setContent(paramCard.declaration);
      }
      this.jdField_a_of_type_JavaLangString = paramCard.voiceUrl;
      this.jdField_a_of_type_Boolean = paramCard.uin.equals(paramQQAppInterface.getCurrentAccountUin());
      if (!this.jdField_a_of_type_Boolean) {
        break label442;
      }
      localObject = getContext().getString(2131698064);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(this);
      label263:
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label489;
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramCard.extendFriendVoiceDuration);
      this.jdField_h_of_type_Int = paramCard.extendFriendVoiceDuration;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(this.jdField_a_of_type_JavaLangString);
      label312:
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
      this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (!this.jdField_a_of_type_Boolean) {
        break label501;
      }
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      label352:
      b(paramCard, paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setColor(this.jdField_b_of_type_Int);
      if (!bdgb.b())
      {
        setClothes(paramCard.clothesId);
        setFont(paramCard.fontId, paramCard.fontType);
      }
      if ((!this.jdField_h_of_type_Boolean) && (!this.jdField_g_of_type_Boolean)) {
        break label531;
      }
    }
    label531:
    for (paramCard = "2";; paramCard = "1")
    {
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_show", "", 0, "", paramCard);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.jdField_a_of_type_JavaLangString;
      break;
      label442:
      localObject = (asvi)paramQQAppInterface.getManager(264);
      localObject = String.format(getContext().getString(2131698063), new Object[] { ((asvi)localObject).a() });
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      break label263;
      label489:
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label312;
      label501:
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label352;
      }
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      break label352;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingTop(), this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
      if (this.jdField_f_of_type_Boolean) {
        f();
      }
    }
    while ((paramBoolean) || (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      return;
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.b = null;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setMaxLines(50);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingTop(), this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingRight(), agej.a(16.0F, getResources()));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intent localIntent = new Intent();
    localObject = new ExtendFriendProfileEditFragment.ExtendFriendInfo((Card)localObject);
    if (paramBoolean1)
    {
      ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).jdField_e_of_type_Int = this.jdField_c_of_type_Int;
      ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).jdField_b_of_type_Boolean = true;
    }
    if (paramBoolean2)
    {
      ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).jdField_f_of_type_Int = this.jdField_e_of_type_Int;
      ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).jdField_c_of_type_Boolean = true;
    }
    localIntent.putExtra("key_extend_friend_info", (Parcelable)localObject);
    PublicFragmentActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, ExtendFriendEditFragment.class, 4097);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b();
    }
  }
  
  public void b(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(paramCard.schoolName)) || (TextUtils.isEmpty(paramCard.schoolId)))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    String str = paramCard.schoolName;
    int m;
    Context localContext;
    if (paramCard.authState == 2L)
    {
      m = 2130845158;
      localContext = getContext();
      if (!this.jdField_a_of_type_Boolean) {
        break label147;
      }
    }
    label147:
    for (bjas localbjas = new bjas(this, paramCard);; localbjas = null)
    {
      localTextView.setText(bhhz.a(str, false, m, 2131298282, 2131298281, localContext, paramQQAppInterface, localbjas));
      this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_b_of_type_AndroidWidgetLinearLayout.post(new ProfileCardExtendFriendView.5(this, paramCard));
      return;
      m = 2130845159;
      break;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsRectF != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null) && (!this.jdField_j_of_type_Boolean)) {
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      return;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    ExtendFriendProfileEditFragment.ExtendFriendInfo localExtendFriendInfo;
    if (paramView.getId() == 2131366189) {
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = new Intent();
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
        {
          localExtendFriendInfo = new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.jdField_a_of_type_ComTencentMobileqqDataCard);
          localExtendFriendInfo.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
          localExtendFriendInfo.jdField_d_of_type_Int = this.jdField_e_of_type_Int;
          ((Intent)localObject).putExtra("key_extend_friend_info", localExtendFriendInfo);
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DE", "0X80092DE", 1, 0, "", "", "", "");
          PublicFragmentActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, ExtendFriendEditFragment.class, 4097);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      boolean bool = atbf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardExtendFriendView", 2, "click extend_friend_more_text showEntry = " + bool);
      }
      if (bool)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).jdField_e_of_type_Boolean) {}
        for (int m = 1;; m = 2)
        {
          bdll.b((QQAppInterface)localObject, "dc00898", "", "", "0X80092E5", "0X80092E5", m, 0, "", "", "", "");
          g();
          break;
        }
        if (paramView.getId() == 2131368570)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a())
          {
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b();
          }
          else
          {
            if (this.jdField_a_of_type_Boolean) {
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DD", "0X80092DD", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a();
              break;
              m = (this.jdField_h_of_type_Int - 1) / 10;
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E4", "0X80092E4", m + 1, 0, "", "", "", "");
            }
          }
        }
        else if (paramView.getId() == 2131369189)
        {
          if (this.jdField_e_of_type_Boolean) {
            e();
          } else {
            f();
          }
        }
        else
        {
          if (paramView.getId() == 2131380146)
          {
            if (this.jdField_a_of_type_Boolean) {
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DC", "0X80092DC", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              localObject = new Intent(getContext(), QQBrowserActivity.class);
              ((Intent)localObject).putExtra("url", "https://sqimg.qq.com/qq_product_operations/popularRule/popularRules.html");
              getContext().startActivity((Intent)localObject);
              break;
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E6", "0X80092E6", 0, 0, "", "", "", "");
            }
          }
          if (paramView.getId() == 2131366757) {
            if (this.jdField_a_of_type_Boolean)
            {
              localObject = new Intent();
              if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
              {
                localExtendFriendInfo = new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.jdField_a_of_type_ComTencentMobileqqDataCard);
                localExtendFriendInfo.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
                localExtendFriendInfo.jdField_d_of_type_Int = this.jdField_e_of_type_Int;
                ((Intent)localObject).putExtra("key_extend_friend_info", localExtendFriendInfo);
              }
              if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
              {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DE", "0X80092DE", 2, 0, "", "", "", "");
                PublicFragmentActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, ExtendFriendEditFragment.class, 4097);
              }
            }
            else
            {
              a();
            }
          }
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Biai != null) {
      this.jdField_a_of_type_Biai.a();
    }
    this.jdField_a_of_type_Biai = null;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_g_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    }
    invalidate();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return false;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    return false;
  }
  
  public void setClothes(int paramInt)
  {
    if (this.jdField_e_of_type_Int == paramInt) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        this.jdField_h_of_type_Boolean = false;
        this.jdField_e_of_type_Int = paramInt;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackground(null);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        return;
      }
    } while (paramInt <= 10000);
    this.jdField_e_of_type_Int = paramInt;
    this.jdField_h_of_type_Boolean = true;
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getBackground() instanceof VasResDrawable))
    {
      ((VasResDrawable)this.jdField_a_of_type_AndroidWidgetFrameLayout.getBackground()).b(paramInt);
      return;
    }
    VasResDrawable localVasResDrawable = new VasResDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
    biba localbiba = new biba(localVasResDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2130846136);
    localbiba.a(true);
    localbiba.a(new bjaq(this));
    localVasResDrawable.a(localbiba);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(localVasResDrawable);
  }
  
  public void setDiyCard(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void setETTextColorFromClothes(bhzd parambhzd)
  {
    if ((parambhzd.e != null) && (!TextUtils.isEmpty(parambhzd.e)))
    {
      this.jdField_a_of_type_Int = Color.parseColor(parambhzd.e);
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView != null) && (this.jdField_a_of_type_Int != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(this.jdField_a_of_type_Int);
      }
    }
    if ((parambhzd != null) && (parambhzd.t != null) && (!TextUtils.isEmpty(parambhzd.t)))
    {
      this.jdField_b_of_type_Int = Color.parseColor(parambhzd.t);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setColor(this.jdField_b_of_type_Int);
      if (SignTextEditFragment.a(this.jdField_b_of_type_Int))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  public void setFold(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setFont(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_Int == paramInt1) {
      return;
    }
    if (paramInt1 == 0)
    {
      this.jdField_g_of_type_Boolean = false;
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setFont(0, System.currentTimeMillis());
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_a_of_type_Biai == null)
    {
      this.jdField_a_of_type_Biai = new biai(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1);
      bibd localbibd = new bibd(this.jdField_a_of_type_Biai, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
      localbibd.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.getTextSize(), true);
      this.jdField_a_of_type_Biai.a(localbibd);
      localbibd.a(-1);
      return;
    }
    ((bibd)this.jdField_a_of_type_Biai.a()).a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.getTextSize(), true);
    ((bibd)this.jdField_a_of_type_Biai.a()).a(paramInt1, paramInt2);
  }
  
  public void setIsFromLimitChat(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void setProfileCardFavorShowView(ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorShowView = paramProfileCardFavorShowView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardExtendFriendView
 * JD-Core Version:    0.7.0.1
 */