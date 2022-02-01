package cooperation.qzone.contentbox;

import amtj;
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
  public static int[] defaultIcon = { 2130848366, 2130848362, 2130848371 };
  public static String[] defaultScheme = { "mqqzone://arouse/writemood", "mqqzone://arouse/uploadphoto", "mqqzone://arouse/takevideo" };
  public static String[] defaultTitle = { QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PlusMood", "说说"), QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PlusAlbum", "相册"), QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PlusShoot", "拍摄") };
  public Context context;
  public Activity fragment;
  Animation.AnimationListener mAnimationListener = new PlusMenuContainer.1(this);
  RelativeLayout mContainer;
  private volatile boolean mIsPlusPannelAnimating;
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
    this.reminder.setId(2131375592);
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
        localObject2 = new RelativeLayout.LayoutParams(ViewUtils.getScreenWidth(), ImmersiveUtils.getStatusBarHeight(this.context));
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setBackgroundColor(getResources().getColor(2131165547));
        this.mContainer.addView((View)localObject1);
      }
      localObject1 = new ImageView(this.context);
      ((ImageView)localObject1).setId(2131375588);
      ((ImageView)localObject1).setContentDescription(amtj.a(2131707409));
      localObject2 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(35.0F), ViewUtils.dip2px(35.0F));
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, ImmersiveUtils.getStatusBarHeight(this.context) + ViewUtils.dpToPx(8.0F), ViewUtils.dpToPx(10.0F), 0);
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setPadding(ViewUtils.dpToPx(6.0F), ViewUtils.dpToPx(6.0F), 0, ViewUtils.dpToPx(6.0F));
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER);
      ((ImageView)localObject1).setImageResource(2130848376);
      this.mContainer.addView((View)localObject1);
      ((ImageView)localObject1).setOnClickListener(this.plusItemClickListener);
      this.operationItemViews = new ArrayList(3);
      localObject1 = new LinearLayout(this.context);
      ((LinearLayout)localObject1).setId(2131375591);
      ((LinearLayout)localObject1).setWeightSum(3.0F);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131375588);
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (LayoutInflater)this.context.getSystemService("layout_inflater");
      int i = 0;
      while (i < 3)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)((LayoutInflater)localObject2).inflate(2131562345, null);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0F);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131375419);
        TextView localTextView = (TextView)localRelativeLayout.findViewById(2131375421);
        localImageView.setImageDrawable(getResources().getDrawable(defaultIcon[i]));
        localTextView.setText(defaultTitle[i]);
        localTextView.setTextColor(getResources().getColor(2131166700));
        localRelativeLayout.setTag(defaultScheme[i]);
        ((LinearLayout)localObject1).addView(localRelativeLayout, localLayoutParams);
        this.operationItemViews.add(localRelativeLayout);
        localRelativeLayout.setOnClickListener(this.plusItemClickListener);
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QZLog.e("PlusMenuContainer", "set statusBar mask exception.", localException);
      }
      this.mContainer.addView(localException);
      FrameLayout localFrameLayout = new FrameLayout(this.context);
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131375591);
      localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localFrameLayout.setBackgroundResource(2130848402);
      this.mContainer.addView(localFrameLayout);
      addView(this.mContainer);
      this.mhidebBarAnimation = AnimationUtils.loadAnimation(this.context, 2130772125);
      this.mhidebBarAnimation.setAnimationListener(this.mAnimationListener);
      this.mhideBgAnimation = AnimationUtils.loadAnimation(this.context, 2130772111);
      this.mhideBgAnimation.setAnimationListener(this.mAnimationListener);
      setVisibility(8);
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.fragment = paramActivity;
  }
  
  public void show()
  {
    setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(this.context, 2130772122);
    this.mContainer.clearAnimation();
    this.mContainer.startAnimation(localAnimation);
    this.reminder.startAnimation(AnimationUtils.loadAnimation(this.context, 2130772110));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.PlusMenuContainer
 * JD-Core Version:    0.7.0.1
 */