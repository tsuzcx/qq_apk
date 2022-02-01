package cooperation.qzone.contentbox;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

public class PlusMenuContainer
  extends RelativeLayout
{
  public static final String TAG = "PlusMenuContainer";
  public static int[] defaultIcon = { 2130848694, 2130848690, 2130848699 };
  public static String[] defaultScheme = { "mqqzone://arouse/writemood", "mqqzone://arouse/uploadphoto", "mqqzone://arouse/takevideo" };
  public static String[] defaultTitle = { QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PlusMood", "说说"), QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PlusAlbum", "相册"), QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PlusShoot", "拍摄") };
  public Context context;
  public Activity fragment;
  Animation.AnimationListener mAnimationListener = new PlusMenuContainer.1(this);
  RelativeLayout mContainer;
  private volatile boolean mIsPlusPannelAnimating = false;
  private Animation mhideBgAnimation;
  private Animation mhidebBarAnimation;
  public ArrayList<View> operationItemViews;
  private View.OnClickListener plusItemClickListener = new PlusMenuContainer.2(this);
  View reminder;
  
  public PlusMenuContainer(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
  }
  
  public PlusMenuContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public PlusMenuContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  public void hide()
  {
    if (getVisibility() != 0)
    {
      QZLog.d("PlusMenuContainer", 1, "this.getVisibility() != VISIBLE");
      return;
    }
    if (this.mIsPlusPannelAnimating)
    {
      QZLog.d("PlusMenuContainer", 1, "animation is not end yet.");
      return;
    }
    this.mIsPlusPannelAnimating = true;
    this.mContainer.startAnimation(this.mhidebBarAnimation);
    this.reminder.startAnimation(this.mhideBgAnimation);
  }
  
  public void initView()
  {
    this.reminder = new View(this.context);
    this.reminder.setId(2131375727);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.reminder.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.reminder.setBackgroundColor(0);
    if (Build.VERSION.SDK_INT >= 16) {
      ViewCompat.setImportantForAccessibility(this.reminder, 2);
    }
    addView(this.reminder);
    this.reminder.setOnClickListener(this.plusItemClickListener);
    this.mContainer = new RelativeLayout(this.context);
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    this.mContainer.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.mContainer.setBackgroundColor(Color.parseColor("#ffffffff"));
    try
    {
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (!IPluginAdapterProxy.getProxy().isNightMode()))
      {
        localObject1 = new View(this.context);
        localObject3 = new RelativeLayout.LayoutParams(ViewUtils.a(), ImmersiveUtils.getStatusBarHeight(this.context));
        ((RelativeLayout.LayoutParams)localObject3).addRule(10);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setBackgroundColor(getResources().getColor(2131165529));
        this.mContainer.addView((View)localObject1);
      }
    }
    catch (Exception localException)
    {
      QZLog.e("PlusMenuContainer", "set statusBar mask exception.", localException);
    }
    Object localObject2 = new ImageView(this.context);
    ((ImageView)localObject2).setId(2131375723);
    ((ImageView)localObject2).setContentDescription(HardCodeUtil.a(2131708292));
    Object localObject3 = new RelativeLayout.LayoutParams(ViewUtils.a(35.0F), ViewUtils.a(35.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(0, ImmersiveUtils.getStatusBarHeight(this.context) + ViewUtils.b(8.0F), ViewUtils.b(10.0F), 0);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setPadding(ViewUtils.b(6.0F), ViewUtils.b(6.0F), 0, ViewUtils.b(6.0F));
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER);
    ((ImageView)localObject2).setImageResource(2130848704);
    this.mContainer.addView((View)localObject2);
    ((ImageView)localObject2).setOnClickListener(this.plusItemClickListener);
    this.operationItemViews = new ArrayList(3);
    localObject2 = new LinearLayout(this.context);
    ((LinearLayout)localObject2).setId(2131375726);
    ((LinearLayout)localObject2).setWeightSum(3.0F);
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131375723);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject3 = (LayoutInflater)this.context.getSystemService("layout_inflater");
    int i = 0;
    while (i < 3)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((LayoutInflater)localObject3).inflate(2131562387, null);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0F);
      ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131375554);
      TextView localTextView = (TextView)localRelativeLayout.findViewById(2131375556);
      localImageView.setImageDrawable(getResources().getDrawable(defaultIcon[i]));
      localTextView.setText(defaultTitle[i]);
      localTextView.setTextColor(getResources().getColor(2131166733));
      localRelativeLayout.setTag(defaultScheme[i]);
      ((LinearLayout)localObject2).addView(localRelativeLayout, localLayoutParams);
      this.operationItemViews.add(localRelativeLayout);
      localRelativeLayout.setOnClickListener(this.plusItemClickListener);
      i += 1;
    }
    this.mContainer.addView((View)localObject2);
    localObject2 = new FrameLayout(this.context);
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131375726);
    ((FrameLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((FrameLayout)localObject2).setBackgroundResource(2130848752);
    this.mContainer.addView((View)localObject2);
    addView(this.mContainer);
    this.mhidebBarAnimation = AnimationUtils.loadAnimation(this.context, 2130772166);
    this.mhidebBarAnimation.setAnimationListener(this.mAnimationListener);
    this.mhideBgAnimation = AnimationUtils.loadAnimation(this.context, 2130772152);
    this.mhideBgAnimation.setAnimationListener(this.mAnimationListener);
    setVisibility(8);
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.fragment = paramActivity;
  }
  
  public void show()
  {
    setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(this.context, 2130772163);
    this.mContainer.clearAnimation();
    this.mContainer.startAnimation(localAnimation);
    this.reminder.startAnimation(AnimationUtils.loadAnimation(this.context, 2130772151));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.PlusMenuContainer
 * JD-Core Version:    0.7.0.1
 */