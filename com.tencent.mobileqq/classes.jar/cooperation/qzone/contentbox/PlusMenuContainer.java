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
import anni;
import bgtn;
import blwy;
import blwz;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

public class PlusMenuContainer
  extends RelativeLayout
{
  public static int[] a;
  public static String[] a;
  public static String[] b;
  public Activity a;
  public Context a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new blwz(this);
  View jdField_a_of_type_AndroidViewView;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new blwy(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public ArrayList<View> a;
  private volatile boolean jdField_a_of_type_Boolean;
  private Animation b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PlusMood", "说说"), QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PlusAlbum", "相册"), QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PlusShoot", "拍摄") };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130848436, 2130848432, 2130848441 };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "mqqzone://arouse/writemood", "mqqzone://arouse/uploadphoto", "mqqzone://arouse/takevideo" };
  }
  
  public PlusMenuContainer(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public PlusMenuContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public PlusMenuContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView.setId(2131375684);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
    if (Build.VERSION.SDK_INT >= 16) {
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_AndroidViewView, 2);
    }
    addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#ffffffff"));
    try
    {
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (!IPluginAdapterProxy.getProxy().isNightMode()))
      {
        localObject1 = new View(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new RelativeLayout.LayoutParams(bgtn.a(), ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext));
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setBackgroundColor(getResources().getColor(2131165539));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
      }
      localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject1).setId(2131375680);
      ((ImageView)localObject1).setContentDescription(anni.a(2131707068));
      localObject2 = new RelativeLayout.LayoutParams(bgtn.a(35.0F), bgtn.a(35.0F));
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext) + bgtn.b(8.0F), bgtn.b(10.0F), 0);
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setPadding(bgtn.b(6.0F), bgtn.b(6.0F), 0, bgtn.b(6.0F));
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER);
      ((ImageView)localObject1).setImageResource(2130848446);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
      ((ImageView)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(3);
      localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject1).setId(2131375683);
      ((LinearLayout)localObject1).setWeightSum(3.0F);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131375680);
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater");
      int i = 0;
      while (i < 3)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)((LayoutInflater)localObject2).inflate(2131562428, null);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0F);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131375511);
        TextView localTextView = (TextView)localRelativeLayout.findViewById(2131375513);
        localImageView.setImageDrawable(getResources().getDrawable(jdField_a_of_type_ArrayOfInt[i]));
        localTextView.setText(jdField_a_of_type_ArrayOfJavaLangString[i]);
        localTextView.setTextColor(getResources().getColor(2131166677));
        localRelativeLayout.setTag(jdField_b_of_type_ArrayOfJavaLangString[i]);
        ((LinearLayout)localObject1).addView(localRelativeLayout, localLayoutParams);
        this.jdField_a_of_type_JavaUtilArrayList.add(localRelativeLayout);
        localRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QZLog.e("PlusMenuContainer", "set statusBar mask exception.", localException);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localException);
      FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131375683);
      localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localFrameLayout.setBackgroundResource(2130848472);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localFrameLayout);
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772117);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772105);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      setVisibility(8);
    }
  }
  
  public void b()
  {
    if (getVisibility() != 0)
    {
      QZLog.d("PlusMenuContainer", 1, "this.getVisibility() != VISIBLE");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QZLog.d("PlusMenuContainer", 1, "animation is not end yet.");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
  }
  
  public void c()
  {
    setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772114);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimation);
    this.jdField_a_of_type_AndroidViewView.startAnimation(AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772104));
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.PlusMenuContainer
 * JD-Core Version:    0.7.0.1
 */