package com.tencent.mobileqq.widget;

import aekt;
import aloz;
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
import apwv;
import apwx;
import aqcp;
import aqcy;
import aqdm;
import awmr;
import azib;
import azmj;
import bcyw;
import bdpm;
import bdqs;
import bdrj;
import bdrm;
import beob;
import beoc;
import beod;
import beoe;
import bhpy;
import com.etrump.mixlayout.ETTextView;
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
import com.tencent.qphone.base.util.QLog;
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
  private awmr jdField_a_of_type_Awmr;
  private bdqs jdField_a_of_type_Bdqs;
  private bhpy jdField_a_of_type_Bhpy;
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
  
  public ProfileCardExtendFriendView(Context paramContext, awmr paramawmr, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramawmr != null) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Awmr = paramawmr;
      c();
      return;
      bool = false;
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = aqdm.a(paramInt, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
  }
  
  private void a(View paramView, awmr paramawmr, boolean paramBoolean)
  {
    if (paramawmr != null)
    {
      awmr.a(this.jdField_d_of_type_AndroidWidgetTextView, "color", paramawmr, "commonItemContentColor");
      awmr.a(this.jdField_f_of_type_AndroidWidgetTextView, "color", paramawmr, "commonItemContentColor");
      awmr.a(this.jdField_e_of_type_AndroidWidgetTextView, "color", paramawmr, "commonItemContentColor");
      awmr.a(this.jdField_a_of_type_AndroidWidgetTextView, "color", paramawmr, "commonItemContentColor");
      awmr.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramawmr, "commonItemContentColor");
      awmr.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramawmr, "commonItemContentColor");
      paramView = paramawmr.a.get("commonItemContentColor");
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
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166901));
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166901));
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166901));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(getResources().getColor(2131166901));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166901));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166901));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166901));
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
      m = aekt.a(f1, getResources());
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0, 0.0F, this.jdField_f_of_type_Int - 0, this.jdField_g_of_type_Int - m);
      if (!paramBoolean1) {
        break label208;
      }
      if (!paramBoolean2) {
        break label199;
      }
      a(872415231);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844683);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130844690), null);
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
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844685);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130844692), null);
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
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561168, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378869));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378991));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378926));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368690));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369690));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369691));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView = ((ExtendFriendGradientTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378791));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setCardView(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368743));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365886));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131365887));
    this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368159));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(2);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378989));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378992));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378986));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365628));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366440));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370067));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView = ((ExtendFriendGradientFootView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366691));
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131380005);
    int m = getResources().getDisplayMetrics().widthPixels / 2;
    int n = aekt.a(38.0F, getResources());
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = (m - n);
    localLayoutParams.leftMargin = aekt.a(10.0F, getResources());
    localView.setLayoutParams(localLayoutParams);
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380005));
    this.jdField_a_of_type_Float = aekt.a(3.0F, getResources());
    a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Awmr, this.jdField_d_of_type_Boolean);
    addOnLayoutChangeListener(new beob(this));
  }
  
  private void d()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inSampleSize = 2;
    int m;
    int n;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("=")) && (aqcy.b != null) && (aqcy.b.length > 0) && (aqcy.d != null) && (aqcy.d.length > 0))
    {
      m = this.jdField_a_of_type_JavaLangString.indexOf('=');
      m = this.jdField_a_of_type_JavaLangString.substring(m + 1).toUpperCase().charAt(0);
      n = aqcy.d.length;
    }
    for (Object localObject = aqcy.b[(m % n)];; localObject = "expand_summary_bg.png")
    {
      localObject = aqcy.a(aqcy.a((String)localObject), localOptions);
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = aqcp.a(getResources(), (Bitmap)localObject, -2565928, 0.2F, false);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(this.jdField_b_of_type_AndroidWidgetImageView.getPaddingLeft(), aekt.a(16.0F, getResources()), this.jdField_b_of_type_AndroidWidgetImageView.getPaddingRight(), aekt.a(6.0F, getResources()));
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
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(this.jdField_b_of_type_AndroidWidgetImageView.getPaddingLeft(), aekt.a(6.0F, getResources()), this.jdField_b_of_type_AndroidWidgetImageView.getPaddingRight(), aekt.a(16.0F, getResources()));
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
      if ((((ProfileActivity.AllInOne)((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).getIntent().getParcelableExtra("AllInOne")).jdField_a_of_type_Int == 96) && (((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).k))
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
  
  public ETTextView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView;
  }
  
  public void a()
  {
    if (azib.b()) {}
    do
    {
      do
      {
        return;
        if (!jdField_i_of_type_Boolean)
        {
          if (((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).declaration == null) {
            ((apwv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
          }
          jdField_i_of_type_Boolean = false;
        }
      } while ((((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_AndroidContentContext == null)) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView == null));
      if (this.jdField_a_of_type_Bhpy == null)
      {
        this.jdField_a_of_type_Bhpy = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_Bhpy.c(2131690648);
        if (this.jdField_h_of_type_Boolean) {
          this.jdField_a_of_type_Bhpy.b(2131719803);
        }
        if (this.jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_Bhpy.b(2131719804);
        }
        if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean)) {
          this.jdField_a_of_type_Bhpy.b(2131719805);
        }
        this.jdField_a_of_type_Bhpy.a(new beod(this));
      }
    } while (((BaseActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing());
    this.jdField_a_of_type_Bhpy.show();
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
        break label407;
      }
      localObject = getContext().getString(2131699334);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(this);
      label263:
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label454;
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramCard.extendFriendVoiceDuration);
      this.jdField_h_of_type_Int = paramCard.extendFriendVoiceDuration;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(this.jdField_a_of_type_JavaLangString);
      label312:
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
      this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (!this.jdField_a_of_type_Boolean) {
        break label466;
      }
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      b(paramCard, paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientFootView.setColor(this.jdField_b_of_type_Int);
      if (!azib.b())
      {
        setClothes(paramCard.clothesId);
        setFont(paramCard.fontId, paramCard.fontType);
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.jdField_a_of_type_JavaLangString;
      break;
      label407:
      localObject = (apwx)paramQQAppInterface.getManager(264);
      localObject = String.format(getContext().getString(2131699333), new Object[] { ((apwx)localObject).a() });
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      break label263;
      label454:
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label312;
      label466:
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      } else {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
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
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingTop(), this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingRight(), aekt.a(16.0F, getResources()));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
      m = 2130844679;
      localContext = getContext();
      if (!this.jdField_a_of_type_Boolean) {
        break label147;
      }
    }
    label147:
    for (beoe localbeoe = new beoe(this, paramCard);; localbeoe = null)
    {
      localTextView.setText(bcyw.a(str, false, m, 2131298187, 2131298186, localContext, paramQQAppInterface, localbeoe));
      this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_b_of_type_AndroidWidgetLinearLayout.post(new ProfileCardExtendFriendView.5(this, paramCard));
      return;
      m = 2130844680;
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
    ExtendFriendProfileEditFragment.ExtendFriendInfo localExtendFriendInfo;
    if (paramView.getId() == 2131365887) {
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = new Intent();
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
        {
          localExtendFriendInfo = new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.jdField_a_of_type_ComTencentMobileqqDataCard);
          localExtendFriendInfo.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
          localExtendFriendInfo.jdField_d_of_type_Int = this.jdField_e_of_type_Int;
          paramView.putExtra("key_extend_friend_info", localExtendFriendInfo);
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DE", "0X80092DE", 1, 0, "", "", "", "");
          PublicFragmentActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, ExtendFriendEditFragment.class, 4097);
        }
      }
    }
    do
    {
      do
      {
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).k) {}
        for (int m = 1;; m = 2)
        {
          azmj.b(paramView, "dc00898", "", "", "0X80092E5", "0X80092E5", m, 0, "", "", "", "");
          g();
          return;
        }
        if (paramView.getId() == 2131368159)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a())
          {
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b();
            return;
          }
          if (this.jdField_a_of_type_Boolean) {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DD", "0X80092DD", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a();
            return;
            m = (this.jdField_h_of_type_Int - 1) / 10;
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E4", "0X80092E4", m + 1, 0, "", "", "", "");
          }
        }
        if (paramView.getId() == 2131368743)
        {
          if (this.jdField_e_of_type_Boolean)
          {
            e();
            return;
          }
          f();
          return;
        }
        if (paramView.getId() == 2131378989)
        {
          if (this.jdField_a_of_type_Boolean) {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DC", "0X80092DC", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            paramView = new Intent(getContext(), QQBrowserActivity.class);
            paramView.putExtra("url", "https://sqimg.qq.com/qq_product_operations/popularRule/popularRules.html");
            getContext().startActivity(paramView);
            return;
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E6", "0X80092E6", 0, 0, "", "", "", "");
          }
        }
      } while (paramView.getId() != 2131366440);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      paramView = new Intent();
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        localExtendFriendInfo = new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.jdField_a_of_type_ComTencentMobileqqDataCard);
        localExtendFriendInfo.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
        localExtendFriendInfo.jdField_d_of_type_Int = this.jdField_e_of_type_Int;
        paramView.putExtra("key_extend_friend_info", localExtendFriendInfo);
      }
    } while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity));
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DE", "0X80092DE", 2, 0, "", "", "", "");
    PublicFragmentActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, ExtendFriendEditFragment.class, 4097);
    return;
    a();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Bdqs != null) {
      this.jdField_a_of_type_Bdqs.a();
    }
    this.jdField_a_of_type_Bdqs = null;
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
    bdrj localbdrj = new bdrj(localVasResDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2130845639);
    localbdrj.a(true);
    localbdrj.a(new beoc(this));
    localVasResDrawable.a(localbdrj);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(localVasResDrawable);
  }
  
  public void setDiyCard(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void setETTextColorFromClothes(bdpm parambdpm)
  {
    if ((parambdpm.e != null) && (!TextUtils.isEmpty(parambdpm.e)))
    {
      this.jdField_a_of_type_Int = Color.parseColor(parambdpm.e);
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView != null) && (this.jdField_a_of_type_Int != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(this.jdField_a_of_type_Int);
      }
    }
    if ((parambdpm != null) && (parambdpm.t != null) && (!TextUtils.isEmpty(parambdpm.t)))
    {
      this.jdField_b_of_type_Int = Color.parseColor(parambdpm.t);
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
    if (this.jdField_a_of_type_Bdqs == null)
    {
      this.jdField_a_of_type_Bdqs = new bdqs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1);
      bdrm localbdrm = new bdrm(this.jdField_a_of_type_Bdqs, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
      localbdrm.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.getTextSize(), true);
      this.jdField_a_of_type_Bdqs.a(localbdrm);
      localbdrm.a(-1);
      return;
    }
    ((bdrm)this.jdField_a_of_type_Bdqs.a()).a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.getTextSize(), true);
    ((bdrm)this.jdField_a_of_type_Bdqs.a()).a(paramInt1, paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardExtendFriendView
 * JD-Core Version:    0.7.0.1
 */