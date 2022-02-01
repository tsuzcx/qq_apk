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
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView;
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
  private static boolean jdField_i_of_type_Boolean = false;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
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
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private ProfileContentTitleView jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileContentTitleView;
  private ProfileCardTemplate jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate;
  private ExtendFriendGradientFootView jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientFootView;
  protected ExtendFriendGradientTextView a;
  protected ExpandVoiceView a;
  private VasRes jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
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
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  public TextView g;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private boolean k;
  private boolean l;
  
  public ProfileCardExtendFriendView(Context paramContext)
  {
    super(paramContext);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -16777216;
    this.jdField_b_of_type_Int = -1;
    this.jdField_j_of_type_Boolean = false;
    this.k = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileContentTitleView = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  public ProfileCardExtendFriendView(Context paramContext, ProfileCardTemplate paramProfileCardTemplate, boolean paramBoolean)
  {
    super(paramContext);
    boolean bool = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -16777216;
    this.jdField_b_of_type_Int = -1;
    this.jdField_j_of_type_Boolean = false;
    this.k = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileContentTitleView = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramProfileCardTemplate != null) {
      bool = true;
    }
    this.jdField_c_of_type_Boolean = bool;
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate = paramProfileCardTemplate;
    c();
  }
  
  private void a(int paramInt)
  {
    float f1 = this.jdField_a_of_type_Float;
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = GradientDrawableUtils.a(paramInt, f1, f1, f1, f1);
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_g_of_type_Int > 0)
    {
      if (this.jdField_f_of_type_Int <= 0) {
        return;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      }
      int m;
      if (this.jdField_a_of_type_Boolean) {
        m = AIOUtils.b(10.0F, getResources());
      } else if (this.jdField_b_of_type_Boolean) {
        m = AIOUtils.b(20.0F, getResources());
      } else {
        m = AIOUtils.b(44.0F, getResources());
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0, 0.0F, this.jdField_f_of_type_Int - 0, this.jdField_g_of_type_Int - m);
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          a(872415231);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(1912864773);
          this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(1912864779), null);
        }
        else
        {
          a(-1711276033);
        }
      }
      else if (paramBoolean2)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(1912864775);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(1912864781), null);
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
        float f1 = this.jdField_f_of_type_Int / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        paramView = new Matrix();
        paramView.setScale(f1, f1);
        BitmapShader localBitmapShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        localBitmapShader.setLocalMatrix(paramView);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localBitmapShader);
      }
      paramView = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
      if (paramView != null) {
        paramView.setBounds(0, 0, this.jdField_f_of_type_Int - 0, this.jdField_g_of_type_Int - m);
      }
      paramView = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.width = (this.jdField_f_of_type_Int - 0);
      paramView.height = (this.jdField_g_of_type_Int - m);
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(1912995848, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(1912930374));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(1912930378));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(1912930375));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(1912930331));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(1912930335));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(1912930336));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView = ((ExtendFriendGradientTextView)this.jdField_a_of_type_AndroidViewView.findViewById(1912930373));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.setCardView(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(1912930332));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(1912930315));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(1912930316));
    this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView = ((ExpandVoiceView)this.jdField_a_of_type_AndroidViewView.findViewById(1912930330));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView;
    ((ExpandVoiceView)localObject).jdField_a_of_type_Boolean = true;
    ((ExpandVoiceView)localObject).setMode(2);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setActivity((QBaseActivity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(1912930377));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(1912930379));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(1912930376));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(1912930311));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(1912930320));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(1912930337));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientFootView = ((ExtendFriendGradientFootView)this.jdField_a_of_type_AndroidViewView.findViewById(1912930321));
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(1912930384);
    int m = getResources().getDisplayMetrics().widthPixels / 2;
    int n = AIOUtils.b(38.0F, getResources());
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.width = (m - n);
    localLayoutParams.leftMargin = AIOUtils.b(10.0F, getResources());
    ((View)localObject).setLayoutParams(localLayoutParams);
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(1912930384));
    this.jdField_a_of_type_Float = AIOUtils.b(3.0F, getResources());
    addOnLayoutChangeListener(new ProfileCardExtendFriendView.1(this));
  }
  
  private void d()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inSampleSize = 2;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("=")) && (ExpandResourceUtil.b != null) && (ExpandResourceUtil.b.length > 0) && (ExpandResourceUtil.d != null) && (ExpandResourceUtil.d.length > 0))
    {
      int m = this.jdField_a_of_type_JavaLangString.indexOf('=');
      m = this.jdField_a_of_type_JavaLangString.substring(m + 1).toUpperCase().charAt(0);
      int n = ExpandResourceUtil.d.length;
      localObject = ExpandResourceUtil.b[(m % n)];
    }
    else
    {
      localObject = "expand_summary_bg.png";
    }
    Object localObject = ExpandResourceUtil.a(ExpandResourceUtil.a((String)localObject), localOptions);
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BackgroundUtil.a(getResources(), (Bitmap)localObject, -2565928, 0.2F, false);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
    new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap).drawColor(-1);
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView;
    if (localObject != null)
    {
      this.jdField_e_of_type_Boolean = false;
      ((ExtendFriendGradientTextView)localObject).setFold(false);
      if ((this.jdField_j_of_type_Boolean) && (this.jdField_i_of_type_Int != 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileContentTitleView;
        if (localObject != null) {
          ((ProfileContentTitleView)localObject).updateViewHeight(this.jdField_j_of_type_Int);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientFootView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setRotation(180.0F);
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      ((ImageView)localObject).setPadding(((ImageView)localObject).getPaddingLeft(), AIOUtils.b(16.0F, getResources()), this.jdField_b_of_type_AndroidWidgetImageView.getPaddingRight(), AIOUtils.b(6.0F, getResources()));
    }
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView;
    if (localObject != null)
    {
      this.jdField_e_of_type_Boolean = true;
      if ((this.jdField_j_of_type_Boolean) && (this.jdField_i_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileContentTitleView != null))
      {
        ((ExtendFriendGradientTextView)localObject).setFold(true ^ this.jdField_e_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileContentTitleView.updateViewHeight(this.jdField_i_of_type_Int);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.setFold(this.jdField_e_of_type_Boolean);
        this.k = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientFootView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setRotation(0.0F);
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      ((ImageView)localObject).setPadding(((ImageView)localObject).getPaddingLeft(), AIOUtils.b(6.0F, getResources()), this.jdField_b_of_type_AndroidWidgetImageView.getPaddingRight(), AIOUtils.b(16.0F, getResources()));
    }
  }
  
  private void g()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    if ((localContext instanceof QBaseActivity))
    {
      if ((((AllInOne)((QBaseActivity)localContext).getIntent().getParcelableExtra("AllInOne")).pa == 96) && (this.l))
      {
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(new Intent("com.tencent.mobileqq.search.finish"));
        ((QBaseActivity)this.jdField_a_of_type_AndroidContentContext).finish();
        return;
      }
      ((IExpandEntrance)QRoute.api(IExpandEntrance.class)).enterExpand(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick("6");
    }
  }
  
  public void a()
  {
    if (SimpleUIUtil.a()) {
      return;
    }
    if (!jdField_i_of_type_Boolean)
    {
      localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((localObject != null) && (((Card)localObject).declaration == null)) {
        ((IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      }
      jdField_i_of_type_Boolean = false;
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if ((((localObject instanceof QBaseActivity)) && (localObject == null)) || (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(1913061376);
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(1913061382);
      }
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(1913061383);
      }
      if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(1913061384);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ProfileCardExtendFriendView.3(this));
    }
    if (!((QBaseActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
    VasWebviewUtil.a("strangers_makefriend", "card_click", "", 0, "", "");
  }
  
  public void a(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%d", new Object[] { Integer.valueOf(paramCard.popularity) }));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleGetSummaryCard--vExtendCard 111 popularity=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetTextView);
    ((StringBuilder)localObject).append(" declaration=");
    ((StringBuilder)localObject).append(paramCard.declaration);
    ((StringBuilder)localObject).append(" voiceUrl=");
    ((StringBuilder)localObject).append(paramCard.voiceUrl);
    ((StringBuilder)localObject).append(" updateTime=");
    ((StringBuilder)localObject).append(paramCard.updateTime);
    ((StringBuilder)localObject).append(" duration=");
    ((StringBuilder)localObject).append(this.jdField_h_of_type_Int);
    ((StringBuilder)localObject).append("fontId = ");
    ((StringBuilder)localObject).append(paramCard.fontId);
    ((StringBuilder)localObject).append("fontType = ");
    ((StringBuilder)localObject).append(paramCard.fontType);
    ((StringBuilder)localObject).append("clothesId= ");
    ((StringBuilder)localObject).append(paramCard.clothesId);
    QLog.d("BusinessCard_CardHandler", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.jdField_a_of_type_JavaLangString == null) {
      localObject = "";
    } else {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.jdField_a_of_type_JavaLangString;
    }
    if ((paramCard.declaration != null) && (!((String)localObject).equals(paramCard.declaration)))
    {
      a(false);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.setContent(paramCard.declaration);
    }
    this.jdField_a_of_type_JavaLangString = paramCard.voiceUrl;
    this.jdField_a_of_type_Boolean = paramCard.uin.equals(paramQQAppInterface.getCurrentAccountUin());
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = getContext().getString(1913061381);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(this);
    }
    else
    {
      localObject = (IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      localObject = String.format(getContext().getString(1913061380), new Object[] { ((IExpandManager)localObject).d() });
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVoiceDuration(paramCard.extendFriendVoiceDuration);
      this.jdField_h_of_type_Int = paramCard.extendFriendVoiceDuration;
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVoiceUrl(this.jdField_a_of_type_JavaLangString);
    }
    else
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    a(this.jdField_a_of_type_AndroidViewView, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    } else if (this.jdField_b_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    } else {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    b(paramCard, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientFootView.setColor(this.jdField_b_of_type_Int);
    if (!SimpleUIUtil.a())
    {
      setClothes(paramCard.clothesId);
      setFont(paramCard.fontId, paramCard.fontType);
    }
    if ((!this.jdField_h_of_type_Boolean) && (!this.jdField_g_of_type_Boolean)) {
      paramCard = "1";
    } else {
      paramCard = "2";
    }
    VasWebviewUtil.a("strangers_makefriend", "card_show", "", 0, "", paramCard);
  }
  
  public void a(ITemplateUtils paramITemplateUtils)
  {
    ProfileCardTemplate localProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate;
    if (localProfileCardTemplate != null)
    {
      paramITemplateUtils.updateViewAttr(this.jdField_d_of_type_AndroidWidgetTextView, "color", localProfileCardTemplate, "commonItemContentColor");
      paramITemplateUtils.updateViewAttr(this.jdField_f_of_type_AndroidWidgetTextView, "color", localProfileCardTemplate, "commonItemContentColor");
      paramITemplateUtils.updateViewAttr(this.jdField_e_of_type_AndroidWidgetTextView, "color", localProfileCardTemplate, "commonItemContentColor");
      paramITemplateUtils.updateViewAttr(this.jdField_a_of_type_AndroidWidgetTextView, "color", localProfileCardTemplate, "commonItemContentColor");
      paramITemplateUtils.updateViewAttr(this.jdField_b_of_type_AndroidWidgetTextView, "color", localProfileCardTemplate, "commonItemContentColor");
      paramITemplateUtils.updateViewAttr(this.jdField_c_of_type_AndroidWidgetTextView, "color", localProfileCardTemplate, "commonItemContentColor");
      paramITemplateUtils = localProfileCardTemplate.templateAttr.get("commonItemContentColor");
      if (paramITemplateUtils != null)
      {
        if ((paramITemplateUtils instanceof ColorStateList))
        {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.setTextColor(((ColorStateList)paramITemplateUtils).getDefaultColor());
          return;
        }
        if ((paramITemplateUtils instanceof String))
        {
          paramITemplateUtils = (String)paramITemplateUtils;
          if (paramITemplateUtils.startsWith("#")) {
            this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.setTextColor(Color.parseColor(paramITemplateUtils));
          }
        }
      }
    }
    else if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167056));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167056));
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167056));
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.setTextColor(getResources().getColor(2131167056));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167056));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167056));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167056));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientFootView.setVisibility(0);
      localObject = this.jdField_e_of_type_AndroidWidgetLinearLayout;
      ((LinearLayout)localObject).setPadding(((LinearLayout)localObject).getPaddingLeft(), this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingTop(), this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
      if (this.jdField_f_of_type_Boolean)
      {
        f();
        return;
      }
      e();
      return;
    }
    if ((!paramBoolean) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView;
      ((ExtendFriendGradientTextView)localObject).b = null;
      ((ExtendFriendGradientTextView)localObject).jdField_a_of_type_Boolean = false;
      ((ExtendFriendGradientTextView)localObject).setMaxLines(50);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientFootView.setVisibility(8);
      localObject = this.jdField_e_of_type_AndroidWidgetLinearLayout;
      ((LinearLayout)localObject).setPadding(((LinearLayout)localObject).getPaddingLeft(), this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingTop(), this.jdField_e_of_type_AndroidWidgetLinearLayout.getPaddingRight(), AIOUtils.b(16.0F, getResources()));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intent localIntent = new Intent();
    localObject = new ExtendFriendInfo((Card)localObject);
    if (paramBoolean1)
    {
      ((ExtendFriendInfo)localObject).jdField_e_of_type_Int = this.jdField_c_of_type_Int;
      ((ExtendFriendInfo)localObject).jdField_b_of_type_Boolean = true;
    }
    if (paramBoolean2)
    {
      ((ExtendFriendInfo)localObject).jdField_f_of_type_Int = this.jdField_e_of_type_Int;
      ((ExtendFriendInfo)localObject).jdField_c_of_type_Boolean = true;
    }
    localIntent.putExtra("key_extend_friend_info", (Parcelable)localObject);
    ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 4097);
  }
  
  public void b()
  {
    ExpandVoiceView localExpandVoiceView = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView;
    if (localExpandVoiceView != null) {
      localExpandVoiceView.b();
    }
  }
  
  public void b(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    if ((!TextUtils.isEmpty(paramCard.schoolName)) && (!TextUtils.isEmpty(paramCard.schoolId)))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      String str = paramCard.schoolName;
      int m;
      if (paramCard.authState == 2L) {
        m = 1912864769;
      } else {
        m = 1912864770;
      }
      Context localContext = getContext();
      ProfileCardExtendFriendView.4 local4;
      if (this.jdField_a_of_type_Boolean) {
        local4 = new ProfileCardExtendFriendView.4(this, paramCard);
      } else {
        local4 = null;
      }
      localTextView.setText(ProfileCardUtil.a(str, false, m, 1912799233, 1912799232, localContext, paramQQAppInterface, local4));
      this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_b_of_type_AndroidWidgetLinearLayout.post(new ProfileCardExtendFriendView.5(this, paramCard));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localObject != null)
    {
      Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      if ((localPaint != null) && (!this.jdField_j_of_type_Boolean))
      {
        float f1 = this.jdField_a_of_type_Float;
        paramCanvas.drawRoundRect((RectF)localObject, f1, f1, localPaint);
        break label58;
      }
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
    if (localObject != null) {
      ((GradientDrawable)localObject).draw(paramCanvas);
    }
    label58:
    super.dispatchDraw(paramCanvas);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    int m;
    if (paramView.getId() == 1912930316)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = new Intent();
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataCard;
        if (localObject != null)
        {
          localObject = new ExtendFriendInfo((Card)localObject);
          ((ExtendFriendInfo)localObject).jdField_c_of_type_Int = this.jdField_c_of_type_Int;
          ((ExtendFriendInfo)localObject).jdField_d_of_type_Int = this.jdField_e_of_type_Int;
          paramView.putExtra("key_extend_friend_info", (Parcelable)localObject);
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DE", "0X80092DE", 1, 0, "", "", "", "");
          ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, 4097);
        }
      }
      else
      {
        boolean bool = ExpandChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (this.l) {
          m = 1;
        } else {
          m = 2;
        }
        ReportController.b(paramView, "dc00898", "", "", "0X80092E5", "0X80092E5", m, 0, "", "", "", "");
        g();
      }
    }
    else
    {
      if (paramView.getId() == 1912930330)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.b();
          return;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DD", "0X80092DD", 0, 0, "", "", "", "");
        }
        else
        {
          m = (this.jdField_h_of_type_Int - 1) / 10;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E4", "0X80092E4", m + 1, 0, "", "", "", "");
        }
        ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#data_page#zl_voice", true, -1L, -1L, null, true, true);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.a();
        return;
      }
      if (paramView.getId() == 1912930332)
      {
        if (this.jdField_e_of_type_Boolean)
        {
          e();
          return;
        }
        f();
        return;
      }
      if (paramView.getId() == 1912930377)
      {
        if (this.jdField_a_of_type_Boolean) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DC", "0X80092DC", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E6", "0X80092E6", 0, 0, "", "", "", "");
        }
        paramView = new Intent(getContext(), QQBrowserActivity.class);
        paramView.putExtra("url", "https://sqimg.qq.com/qq_product_operations/popularRule/popularRules.html");
        getContext().startActivity(paramView);
        return;
      }
      if (paramView.getId() == 1912930320) {
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = new Intent();
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataCard;
          if (localObject != null)
          {
            localObject = new ExtendFriendInfo((Card)localObject);
            ((ExtendFriendInfo)localObject).jdField_c_of_type_Int = this.jdField_c_of_type_Int;
            ((ExtendFriendInfo)localObject).jdField_d_of_type_Int = this.jdField_e_of_type_Int;
            paramView.putExtra("key_extend_friend_info", (Parcelable)localObject);
          }
          if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DE", "0X80092DE", 2, 0, "", "", "", "");
            ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, 4097);
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
    VasRes localVasRes = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
    if (localVasRes != null) {
      localVasRes.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes = null;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_g_of_type_Int = paramInt2;
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      a(localView, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    }
    invalidate();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if ((m != 1) && (m != 3)) {
        return false;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return false;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    return false;
  }
  
  public void setClothes(int paramInt)
  {
    if (this.jdField_e_of_type_Int == paramInt) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_h_of_type_Boolean = false;
      this.jdField_e_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackground(null);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
    }
    if (paramInt > 10000)
    {
      this.jdField_e_of_type_Int = paramInt;
      this.jdField_h_of_type_Boolean = true;
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getBackground() instanceof VasResDrawable))
      {
        ((VasResDrawable)this.jdField_a_of_type_AndroidWidgetFrameLayout.getBackground()).a(paramInt);
        return;
      }
      VasResDrawable localVasResDrawable = new VasResDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
      SignatureAdapter localSignatureAdapter = new SignatureAdapter(localVasResDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2130846313);
      localSignatureAdapter.a(true);
      localSignatureAdapter.a(new ProfileCardExtendFriendView.2(this));
      localVasResDrawable.a(localSignatureAdapter);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(localVasResDrawable);
    }
  }
  
  public void setDiyCard(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void setETTextColorFromClothes(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    if ((paramSignatureTemplateInfo != null) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.e)))
    {
      this.jdField_a_of_type_Int = Color.parseColor(paramSignatureTemplateInfo.e);
      ExtendFriendGradientTextView localExtendFriendGradientTextView = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView;
      if (localExtendFriendGradientTextView != null)
      {
        int m = this.jdField_a_of_type_Int;
        if (m != 0) {
          localExtendFriendGradientTextView.setTextColor(m);
        }
      }
    }
    if ((paramSignatureTemplateInfo != null) && (paramSignatureTemplateInfo.t != null) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.t)))
    {
      this.jdField_b_of_type_Int = Color.parseColor(paramSignatureTemplateInfo.t);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientFootView.setColor(this.jdField_b_of_type_Int);
      if (SignTextEditFragment.a(this.jdField_b_of_type_Int))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
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
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView.setFont(0, System.currentTimeMillis());
    this.jdField_g_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes = new VasRes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1);
      localObject = new SignatureFontAdapter(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
      localExtendFriendGradientTextView = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView;
      ((SignatureFontAdapter)localObject).a(localExtendFriendGradientTextView, localExtendFriendGradientTextView.getTextSize(), true);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a((VasResAdapter)localObject);
      ((SignatureFontAdapter)localObject).a(-1);
      return;
    }
    localObject = (SignatureFontAdapter)((VasRes)localObject).a();
    ExtendFriendGradientTextView localExtendFriendGradientTextView = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendGradientTextView;
    ((SignatureFontAdapter)localObject).a(localExtendFriendGradientTextView, localExtendFriendGradientTextView.getTextSize(), true);
    ((SignatureFontAdapter)this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a()).a(paramInt1, paramInt2);
  }
  
  public void setFromExtendFriend(boolean paramBoolean)
  {
    this.l = paramBoolean;
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
  
  public void setProfileCardFavorShowView(ProfileContentTitleView paramProfileContentTitleView)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewProfileContentTitleView = paramProfileContentTitleView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView
 * JD-Core Version:    0.7.0.1
 */