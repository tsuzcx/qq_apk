import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class rmr
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, rde, rne
{
  private static final String jdField_a_of_type_JavaLangString = rmr.class.getSimpleName();
  public int a;
  protected Activity a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new rmt(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new bhow(this.jdField_a_of_type_AndroidOsHandler$Callback);
  private View jdField_a_of_type_AndroidViewView;
  @Nullable
  protected ViewGroup a;
  private ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  @Nullable
  protected TextView a;
  public VideoInfo a;
  private VideoFeedsGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private Map<Integer, Bitmap> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private rfs jdField_a_of_type_Rfs;
  protected rnd a;
  protected rng a;
  protected rnr a;
  public boolean a;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  @Nullable
  protected ViewGroup b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  @Nullable
  public TextView b;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  @Nullable
  protected ViewGroup c;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  @Nullable
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_f_of_type_AndroidViewViewGroup;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_g_of_type_AndroidViewViewGroup;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_h_of_type_AndroidViewViewGroup;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_i_of_type_AndroidViewViewGroup;
  @Nullable
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_j_of_type_AndroidViewViewGroup;
  @Nullable
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_k_of_type_AndroidViewViewGroup;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_l_of_type_AndroidViewViewGroup;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_m_of_type_AndroidViewViewGroup;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  private ViewGroup n;
  
  public rmr(View paramView, Activity paramActivity, int paramInt)
  {
    super(paramView);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131364642));
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131379680));
    this.jdField_l_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_d_of_type_AndroidViewViewGroup.getParent());
    this.jdField_c_of_type_Int = this.jdField_l_of_type_AndroidViewViewGroup.indexOfChild(this.jdField_d_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)paramView.findViewById(2131367125));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131364890));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363038));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363039);
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131368320));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131376277));
    this.jdField_j_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131363395));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364956));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378173));
    this.jdField_k_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131366986));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366987));
    this.jdField_g_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131379597));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379826));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377973));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379713));
    this.n = ((ViewGroup)paramView.findViewById(2131379623));
    this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379715));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366988));
    this.jdField_i_of_type_AndroidViewViewGroup = ((LinearLayout)paramView.findViewById(2131364338));
    this.jdField_h_of_type_AndroidViewViewGroup = ((LinearLayout)paramView.findViewById(2131366985));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372057));
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = bdkf.b(50.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = bdkf.b(50.0F);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365818));
    this.jdField_f_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131372058));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371417));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366332));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369078));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131379621);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131370844);
    this.jdField_d_of_type_AndroidViewView.setAlpha(otp.a());
    this.jdField_m_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131366711));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366697));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366700));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131366705));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366707));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366704));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131366721));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131366696));
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    }
    if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
      this.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
    }
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130842611;
    }
    return 2130842612;
  }
  
  private void a()
  {
    rdm.b(this.jdField_d_of_type_AndroidViewView, 8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_m_of_type_AndroidViewViewGroup.setAlpha(0.35F);
  }
  
  private void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    rnv localrnv = new rnv();
    localrnv.jdField_a_of_type_AndroidWidgetSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    localrnv.jdField_b_of_type_AndroidWidgetSeekBar = this.jdField_b_of_type_AndroidWidgetSeekBar;
    localrnv.jdField_a_of_type_AndroidViewViewGroup = this.jdField_g_of_type_AndroidViewViewGroup;
    localrnv.jdField_a_of_type_AndroidWidgetTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    localrnv.jdField_b_of_type_AndroidWidgetTextView = this.jdField_d_of_type_AndroidWidgetTextView;
    localrnv.jdField_a_of_type_ComTencentImageURLImageView = this.jdField_b_of_type_ComTencentImageURLImageView;
    localrnv.jdField_a_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView;
    localrnv.jdField_c_of_type_AndroidWidgetTextView = this.jdField_g_of_type_AndroidWidgetTextView;
    localrnv.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    localrnv.jdField_b_of_type_AndroidViewViewGroup = this.jdField_f_of_type_AndroidViewViewGroup;
    localrnv.jdField_d_of_type_AndroidWidgetTextView = this.jdField_e_of_type_AndroidWidgetTextView;
    localrnv.jdField_e_of_type_AndroidWidgetTextView = this.jdField_f_of_type_AndroidWidgetTextView;
    localrnv.jdField_f_of_type_AndroidWidgetTextView = this.jdField_h_of_type_AndroidWidgetTextView;
    if ((this instanceof oda))
    {
      this.jdField_a_of_type_Rnr = new odb(new odd(), localrnv, paramVideoFeedsPlayManager, false);
      return;
    }
    this.jdField_a_of_type_Rnr = new rnr(localrnv, paramVideoFeedsPlayManager, false);
  }
  
  private void a(VideoFeedsPlayManager paramVideoFeedsPlayManager, rac paramrac)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(paramVideoFeedsPlayManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(paramrac);
  }
  
  private boolean a(ImageView paramImageView, URL paramURL)
  {
    boolean bool = true;
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    int i2 = ((Intent)localObject).getIntExtra("item_width", 0);
    int i1 = ((Intent)localObject).getIntExtra("item_height", 0);
    i2 = ((Intent)localObject).getIntExtra("item_image_width", i2);
    i1 = ((Intent)localObject).getIntExtra("item_image_height", i1);
    if ((i2 == 0) || (i1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "innerTryLoadExtraCoverCache: width or height = 0");
      }
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        localObject = new sfg();
        ((sfg)localObject).jdField_a_of_type_JavaNetURL = ors.a(paramURL.toString());
        ((sfg)localObject).jdField_a_of_type_Int = i2;
        ((sfg)localObject).jdField_b_of_type_Int = i1;
        localObject = sff.a().a((sfg)localObject);
        if ((localObject == null) || (((sfc)localObject).a() == null)) {
          break;
        }
        paramImageView.setImageDrawable(new sfn(((sfc)localObject).a()));
      } while (!QLog.isDevelopLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "innerTryLoadExtraCoverCache: ImageManager hitCache");
      return true;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i2;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i1;
      paramURL = URLDrawable.getDrawable(paramURL, (URLDrawable.URLDrawableOptions)localObject);
      if ((paramURL == null) || (paramURL.getStatus() != 1)) {
        break;
      }
      paramImageView.setImageDrawable(paramURL);
    } while (!QLog.isDevelopLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "innerTryLoadExtraCoverCache: urlDrawable hitCache");
    return true;
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "innerTryLoadExtraCoverCache: missCache");
    }
    return false;
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_Rfs == null)
    {
      this.jdField_a_of_type_Rfs = new rfs();
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz = this.jdField_a_of_type_Rnr;
    }
    this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_Rfs.jdField_a_of_type_AndroidViewViewGroup = this.jdField_e_of_type_AndroidViewViewGroup;
    this.jdField_a_of_type_Rfs.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Rfs.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Rfs.jdField_a_of_type_AndroidOsBundle.putInt("video_feeds_index", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Rfs.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Rfs.jdField_b_of_type_Boolean = true;
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    int i1 = otp.b();
    if (i1 > 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, i1 * 1000);
      return;
    }
    View localView = this.jdField_d_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (i1 = 0;; i1 = 300)
    {
      rdm.a(localView, 0, i1);
      this.jdField_m_of_type_AndroidViewViewGroup.setAlpha(0.2F);
      return;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    g();
    f();
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindow().addContentView(this.jdField_d_of_type_AndroidViewViewGroup, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    this.jdField_l_of_type_AndroidViewViewGroup.addView(this.jdField_d_of_type_AndroidViewViewGroup, this.jdField_c_of_type_Int);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn != null)) {
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn.c();
    }
    if ((this.jdField_d_of_type_AndroidViewViewGroup.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.jdField_d_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_d_of_type_AndroidViewViewGroup);
    }
    if ((this.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn != null)) {
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn.d();
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewAnimationScaleAnimation == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = localScaleAnimation;
    }
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new rms(this, paramBoolean));
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
    }
    rdm.b(this.jdField_j_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r, "赞");
  }
  
  private void g()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_d_of_type_AndroidViewViewGroup.getLayoutParams();
    if (this.jdField_a_of_type_Boolean) {
      localLayoutParams.height = -1;
    }
    for (localLayoutParams.width = -1;; localLayoutParams.width = -1)
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.height = rna.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    this.jdField_a_of_type_Rnr.a(true);
    this.jdField_a_of_type_Rnr.a();
  }
  
  private void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      rdm.a(this.jdField_g_of_type_AndroidViewViewGroup, 0);
      rdm.a(this.jdField_f_of_type_AndroidViewViewGroup, 0);
      if (!this.jdField_a_of_type_Boolean) {
        rdm.b(this.n, 0);
      }
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      g(paramBoolean);
      return;
      rdm.a(this.jdField_g_of_type_AndroidViewViewGroup, 8);
      if (this.jdField_a_of_type_Rng.a(this)) {
        rdm.a(this.jdField_f_of_type_AndroidViewViewGroup, 8);
      }
      rdm.b(this.n, 8);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected Drawable a(int paramInt)
  {
    Bitmap localBitmap;
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
    {
      localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), paramInt);
      if (localBitmap == null) {
        return this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(paramInt);
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localBitmap);
    }
    for (;;)
    {
      return new BitmapDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), localBitmap);
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    }
  }
  
  public VideoInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  }
  
  public rfs a()
  {
    return this.jdField_a_of_type_Rfs;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Rnr.a(false);
    if (this.jdField_g_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(100.0F * paramFloat));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramFloat == 0.0F) {
        this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1500L);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
      continue;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)(100.0F * paramFloat));
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 0) && (!this.jdField_a_of_type_Rng.a(this))) {
      d(false);
    }
    while (otp.b() <= 0) {
      return;
    }
    a();
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_Rng.a(this)) {
      if (this.jdField_g_of_type_AndroidViewViewGroup.getVisibility() != 8) {
        break label33;
      }
    }
    label33:
    for (boolean bool = true;; bool = false)
    {
      h(bool);
      return;
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Rng.a(this))) {
      return;
    }
    if (this.jdField_a_of_type_Rng != null)
    {
      paramView = new int[2];
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.getLocationInWindow(paramView);
      this.jdField_a_of_type_Rng.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramView[0] + paramInt1, paramView[1] + paramInt2);
    }
    f(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_p_of_type_Boolean);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    b(paramVideoInfo);
    c();
    b();
    if (bngs.b())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity))
      {
        this.jdField_h_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
        rna.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_h_of_type_AndroidViewViewGroup);
      }
    }
    else {
      return;
    }
    this.jdField_h_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    rna.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_h_of_type_AndroidViewViewGroup);
  }
  
  public void a(rng paramrng, rnd paramrnd, VideoFeedsPlayManager paramVideoFeedsPlayManager, rac paramrac)
  {
    this.jdField_a_of_type_Rng = paramrng;
    this.jdField_a_of_type_Rnd = paramrnd;
    a(paramVideoFeedsPlayManager);
    a(paramVideoFeedsPlayManager, paramrac);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
      }
      return;
      if ((!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 8)) {
        d(false);
      }
      h(false);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    rdm.b(this.n, 0);
  }
  
  public void b()
  {
    rdm.b(this.jdField_i_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e, "评论");
    if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    VideoFeedsAccessibilityHelper.a(this.jdField_i_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e);
    rdm.b(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f, "Biu");
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    rdm.b(this.jdField_j_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r, "赞");
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(a(a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_p_of_type_Boolean)));
    }
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_p_of_type_Boolean);
  }
  
  public void b(View paramView) {}
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    e(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_h_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(a(2130841444));
      if ((bngs.b()) && (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity))) {
        rna.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_j_of_type_AndroidViewViewGroup);
      }
    }
    for (;;)
    {
      h(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(paramBoolean);
      return;
      this.jdField_j_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      continue;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      this.jdField_h_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(a(2130841445));
      this.jdField_j_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    }
  }
  
  public void c()
  {
    rdm.a(this.jdField_d_of_type_AndroidViewView, 8, 0);
    d(true);
    int i1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject1 = this.jdField_d_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).height = rna.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    ((ViewGroup.LayoutParams)localObject1).width = -1;
    this.jdField_d_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a();
    Object localObject2;
    if (localObject1 != null)
    {
      if ((this.jdField_a_of_type_Int != 0) || (!a(this.jdField_b_of_type_ComTencentImageURLImageView, (URL)localObject1)))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = rdm.b(this.jdField_a_of_type_AndroidAppActivity)[0];
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i1;
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165307));
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165307));
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      }
      rdm.a(this.jdField_b_of_type_ComTencentImageURLImageView, 0, 0);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity)) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() != null)) {
        break label486;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      rdm.a(this.jdField_c_of_type_AndroidWidgetTextView, 0L);
      rdm.a(this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000);
      rdm.a(this.jdField_m_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000);
      this.jdField_f_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_Rnr.a(0);
      this.jdField_g_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_k_of_type_AndroidViewViewGroup.setTag(this);
      this.jdField_k_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_i_of_type_AndroidViewViewGroup.setTag(this);
      this.jdField_i_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c);
      this.jdField_k_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.n.setVisibility(0);
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(rna.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_p_of_type_Int));
      }
      this.jdField_l_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c);
      this.jdField_l_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      return;
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      break;
      label486:
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject1).setDecodeHandler(bcuq.w);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentImageURLImageView.clearAnimation();
    g();
    f();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Rnd.a(this.jdField_d_of_type_AndroidViewViewGroup, 0, new FrameLayout.LayoutParams(this.jdField_d_of_type_AndroidViewViewGroup.getLayoutParams()));
      return;
    }
    this.jdField_l_of_type_AndroidViewViewGroup.addView(this.jdField_d_of_type_AndroidViewViewGroup, this.jdField_c_of_type_Int);
    this.jdField_c_of_type_AndroidViewView.clearAnimation();
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void d()
  {
    rdm.b(this.jdField_i_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e, "评论");
    VideoFeedsAccessibilityHelper.a(this.jdField_i_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e);
    rdm.b(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f, "Biu");
    VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f);
    rdm.b(this.jdField_j_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r, "赞");
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(a(a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_p_of_type_Boolean)));
    }
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_p_of_type_Boolean);
    this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c);
    this.jdField_l_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c);
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(rna.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_p_of_type_Int));
    }
  }
  
  public void e() {}
  
  public void onClick(View paramView)
  {
    rmr localrmr = (rmr)paramView.getTag();
    switch (paramView.getId())
    {
    default: 
    case 2131370844: 
    case 2131366986: 
    case 2131364338: 
    case 2131372057: 
    case 2131366721: 
    case 2131366696: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (this.jdField_a_of_type_Rng.a(this));
            this.jdField_a_of_type_Rnd.c(this.jdField_a_of_type_Int);
            return;
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Rnd.d();
              return;
            }
            this.jdField_a_of_type_Rnd.c();
            return;
            this.jdField_a_of_type_Rnd.d();
            return;
          } while (this.jdField_a_of_type_Rng == null);
          this.jdField_a_of_type_Rng.h();
          return;
        } while (this.jdField_a_of_type_Rng == null);
        this.jdField_a_of_type_Rng.i();
        return;
      } while (this.jdField_a_of_type_Rng == null);
      this.jdField_a_of_type_Rng.e(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      return;
    }
    if (this.jdField_a_of_type_Rng != null) {
      this.jdField_a_of_type_Rng.f(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    f(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_p_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rmr
 * JD-Core Version:    0.7.0.1
 */