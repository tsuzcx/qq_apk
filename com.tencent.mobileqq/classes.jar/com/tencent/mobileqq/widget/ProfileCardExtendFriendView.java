package com.tencent.mobileqq.widget;

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
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.extendfriend.utils.BackgroundUtil;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil;
import com.tencent.mobileqq.extendfriend.utils.GradientDrawableUtils;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendGradientTextView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.concurrent.ConcurrentHashMap;

public class ProfileCardExtendFriendView
  extends LinearLayout
  implements View.OnClickListener, View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected ImageView a;
  public LinearLayout a;
  protected TextView a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  protected ExtendFriendGradientTextView a;
  protected ExtendFriendVoiceView a;
  private ProfileCardTemplate jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  protected TextView b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  protected TextView c;
  private boolean jdField_c_of_type_Boolean;
  protected TextView d;
  private boolean d;
  public TextView e;
  private boolean e;
  
  public ProfileCardExtendFriendView(Context paramContext)
  {
    super(paramContext);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  public ProfileCardExtendFriendView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  public ProfileCardExtendFriendView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  public ProfileCardExtendFriendView(Context paramContext, ProfileCardTemplate paramProfileCardTemplate, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramProfileCardTemplate != null) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_c_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = paramProfileCardTemplate;
      b();
      return;
      bool = false;
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = GradientDrawableUtils.a(paramInt, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
  }
  
  private void a(View paramView, ProfileCardTemplate paramProfileCardTemplate, boolean paramBoolean)
  {
    if (paramProfileCardTemplate != null)
    {
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardTemplate, "commonItemContentColor");
      ProfileCardTemplate.a(this.jdField_d_of_type_AndroidWidgetTextView, "color", paramProfileCardTemplate, "commonItemContentColor");
      ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramProfileCardTemplate, "commonItemContentColor");
      ProfileCardTemplate.a(this.jdField_a_of_type_AndroidWidgetTextView, "color", paramProfileCardTemplate, "commonItemContentColor");
      paramView = paramProfileCardTemplate.a.get("commonItemContentColor");
      if (paramView != null)
      {
        if (!(paramView instanceof ColorStateList)) {
          break label88;
        }
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(((ColorStateList)paramView).getDefaultColor());
      }
    }
    label88:
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
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131494214));
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131494214));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131494214));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextColor(getResources().getColor(2131494214));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131494214));
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_b_of_type_Int <= 0) || (this.jdField_a_of_type_Int <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    }
    int i = AIOUtils.a(12.0F, getResources());
    int j = AIOUtils.a(44.0F, getResources());
    this.jdField_a_of_type_AndroidGraphicsRectF.set(i, 0.0F, this.jdField_a_of_type_Int - i, this.jdField_b_of_type_Int - j);
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        a(872415231);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842509);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130842516), null);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setBounds(i, 0, this.jdField_a_of_type_Int - i, this.jdField_b_of_type_Int - j);
      }
      paramView = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.width = (this.jdField_a_of_type_Int - i * 2);
      paramView.height = (this.jdField_b_of_type_Int - j);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
      return;
      a(-1711276033);
      continue;
      if (paramBoolean2)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842511);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(2130842518), null);
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
        c();
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          a(869849304);
        }
        float f = this.jdField_a_of_type_Int / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        paramView = new Matrix();
        paramView.setScale(f, f);
        BitmapShader localBitmapShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        localBitmapShader.setLocalMatrix(paramView);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localBitmapShader);
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970549, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371117));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView = ((ExtendFriendGradientTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371121));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setTextSize((int)TypedValue.applyDimension(2, 17.0F, FontSettingManager.a));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371122));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371123));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371124));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370086));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(2);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371116));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371119));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371120));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371114));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371113));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365597));
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371118);
    int i = getResources().getDisplayMetrics().widthPixels / 2;
    int j = AIOUtils.a(38.0F, getResources());
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = (i - j);
    localLayoutParams.leftMargin = AIOUtils.a(10.0F, getResources());
    localView.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371118));
    this.jdField_a_of_type_Float = AIOUtils.a(3.0F, getResources());
    a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, this.jdField_c_of_type_Boolean);
  }
  
  private void c()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inSampleSize = 2;
    int i;
    int j;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("=")) && (ExtendFriendResourceUtil.b != null) && (ExtendFriendResourceUtil.b.length > 0) && (ExtendFriendResourceUtil.d != null) && (ExtendFriendResourceUtil.d.length > 0))
    {
      i = this.jdField_a_of_type_JavaLangString.indexOf('=');
      i = this.jdField_a_of_type_JavaLangString.substring(i + 1).toUpperCase().charAt(0);
      j = ExtendFriendResourceUtil.d.length;
    }
    for (Object localObject = ExtendFriendResourceUtil.b[(i % j)];; localObject = "expand_summary_bg.png")
    {
      localObject = ExtendFriendResourceUtil.a(ExtendFriendResourceUtil.a((String)localObject), localOptions);
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = BackgroundUtil.a(getResources(), (Bitmap)localObject, -2565928, 0.2F, false);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
    new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap).drawColor(-1);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setMaxLines(50);
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setFold(this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_AndroidWidgetImageView.setRotation(180.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(this.jdField_a_of_type_AndroidWidgetImageView.getPaddingLeft(), AIOUtils.a(16.0F, getResources()), this.jdField_a_of_type_AndroidWidgetImageView.getPaddingRight(), AIOUtils.a(6.0F, getResources()));
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setMaxLines(10);
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setFold(this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_AndroidWidgetImageView.setRotation(0.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(this.jdField_a_of_type_AndroidWidgetImageView.getPaddingLeft(), AIOUtils.a(6.0F, getResources()), this.jdField_a_of_type_AndroidWidgetImageView.getPaddingRight(), AIOUtils.a(16.0F, getResources()));
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FriendProfileCardActivity))
    {
      if ((((ProfileActivity.AllInOne)((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).getIntent().getParcelableExtra("AllInOne")).jdField_a_of_type_Int == 96) && (((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).j)) {
        ((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).finish();
      }
    }
    else {
      return;
    }
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, ExtendFriendFragment.class);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b();
    }
  }
  
  public void a(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%d", new Object[] { Integer.valueOf(paramCard.popularity) }));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    int i = View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels - AIOUtils.a(26.0F, getResources()) * 2, -2147483648);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setText(paramCard.declaration);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.measure(i, j);
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.a() > 10) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_c_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), this.jdField_c_of_type_AndroidWidgetLinearLayout.getPaddingTop(), this.jdField_c_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
      if (this.jdField_e_of_type_Boolean)
      {
        e();
        this.jdField_a_of_type_JavaLangString = paramCard.voiceUrl;
        this.jdField_a_of_type_Boolean = paramCard.uin.equals(paramQQAppInterface.getCurrentAccountUin());
        if (!this.jdField_a_of_type_Boolean) {
          break label367;
        }
        paramQQAppInterface = getContext().getString(2131439331);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(this);
        label222:
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label406;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramCard.extendFriendVoiceDuration);
        this.jdField_c_of_type_Int = paramCard.extendFriendVoiceDuration;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(this.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramQQAppInterface);
      return;
      d();
      break;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendGradientTextView.setMaxLines(50);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_c_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), this.jdField_c_of_type_AndroidWidgetLinearLayout.getPaddingTop(), this.jdField_c_of_type_AndroidWidgetLinearLayout.getPaddingRight(), AIOUtils.a(16.0F, getResources()));
      this.jdField_d_of_type_Boolean = false;
      break;
      label367:
      paramQQAppInterface = (ExtendFriendManager)paramQQAppInterface.getManager(263);
      paramQQAppInterface = String.format(getContext().getString(2131439330), new Object[] { paramQQAppInterface.a() });
      break label222;
      label406:
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsRectF != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null)) {
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
    if (paramView.getId() == 2131371124) {
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = new Intent();
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          paramView.putExtra("key_extend_friend_info", new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.jdField_a_of_type_ComTencentMobileqqDataCard));
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DE", "0X80092DE", 1, 0, "", "", "", "");
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
        if (((FriendProfileCardActivity)this.jdField_a_of_type_AndroidContentContext).j) {}
        for (int i = 1;; i = 2)
        {
          ReportController.b(paramView, "dc00898", "", "", "0X80092E5", "0X80092E5", i, 0, "", "", "", "");
          f();
          return;
        }
        if (paramView.getId() == 2131370086)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a())
          {
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b();
            return;
          }
          if (this.jdField_a_of_type_Boolean) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DD", "0X80092DD", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a();
            return;
            i = (this.jdField_c_of_type_Int - 1) / 10;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E4", "0X80092E4", i + 1, 0, "", "", "", "");
          }
        }
        if (paramView.getId() == 2131371122)
        {
          if (this.jdField_d_of_type_Boolean)
          {
            d();
            return;
          }
          e();
          return;
        }
        if (paramView.getId() == 2131371116)
        {
          if (this.jdField_a_of_type_Boolean) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DC", "0X80092DC", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            paramView = new Intent(getContext(), QQBrowserActivity.class);
            paramView.putExtra("url", "https://sqimg.qq.com/qq_product_operations/popularRule/popularRules.html");
            getContext().startActivity(paramView);
            return;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E6", "0X80092E6", 0, 0, "", "", "", "");
          }
        }
      } while (paramView.getId() != 2131371113);
      paramView = new Intent();
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
        paramView.putExtra("key_extend_friend_info", new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.jdField_a_of_type_ComTencentMobileqqDataCard));
      }
    } while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DE", "0X80092DE", 2, 0, "", "", "", "");
    PublicFragmentActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, ExtendFriendEditFragment.class, 4097);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return false;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return false;
  }
  
  public void setFold(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardExtendFriendView
 * JD-Core Version:    0.7.0.1
 */