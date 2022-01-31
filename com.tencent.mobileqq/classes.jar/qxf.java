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

public abstract class qxf
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, qod, qxs
{
  private static final String jdField_a_of_type_JavaLangString = qxf.class.getSimpleName();
  public int a;
  public Activity a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new qxh(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new bfnk(this.jdField_a_of_type_AndroidOsHandler$Callback);
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
  private qqo jdField_a_of_type_Qqo;
  protected qxr a;
  protected qxu a;
  protected qyj a;
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
  @Nullable
  protected ViewGroup d;
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
  private ViewGroup o;
  
  public qxf(View paramView, Activity paramActivity, int paramInt)
  {
    super(paramView);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131364565));
    this.jdField_f_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131379010));
    this.jdField_m_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_e_of_type_AndroidViewViewGroup.getParent());
    this.jdField_c_of_type_Int = this.jdField_m_of_type_AndroidViewViewGroup.indexOfChild(this.jdField_e_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)paramView.findViewById(2131366998));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131364810));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363003));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363004);
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131368174));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131375780));
    this.jdField_k_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131363357));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364870));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377631));
    this.jdField_l_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131366873));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366874));
    this.jdField_h_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131378939));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379128));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377436));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379033));
    this.o = ((ViewGroup)paramView.findViewById(2131378962));
    this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379035));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366875));
    this.jdField_j_of_type_AndroidViewViewGroup = ((LinearLayout)paramView.findViewById(2131364272));
    this.jdField_i_of_type_AndroidViewViewGroup = ((LinearLayout)paramView.findViewById(2131366872));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371739));
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = bbkx.b(50.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = bbkx.b(50.0F);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365735));
    this.jdField_g_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131371740));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371104));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366244));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368849));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131378961);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131370539);
    this.jdField_d_of_type_AndroidViewView.setAlpha(oph.a());
    this.n = ((ViewGroup)paramView.findViewById(2131366597));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366581));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366585));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131366590));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366592));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366589));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131366607));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131366580));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131366593));
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
      return 2130842439;
    }
    return 2130842440;
  }
  
  private void a()
  {
    qol.b(this.jdField_d_of_type_AndroidViewView, 8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.n.setAlpha(0.35F);
  }
  
  private void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    qyn localqyn = new qyn();
    localqyn.jdField_a_of_type_AndroidWidgetSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    localqyn.jdField_b_of_type_AndroidWidgetSeekBar = this.jdField_b_of_type_AndroidWidgetSeekBar;
    localqyn.jdField_a_of_type_AndroidViewViewGroup = this.jdField_h_of_type_AndroidViewViewGroup;
    localqyn.jdField_a_of_type_AndroidWidgetTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    localqyn.jdField_b_of_type_AndroidWidgetTextView = this.jdField_d_of_type_AndroidWidgetTextView;
    localqyn.jdField_a_of_type_ComTencentImageURLImageView = this.jdField_b_of_type_ComTencentImageURLImageView;
    localqyn.jdField_a_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView;
    localqyn.jdField_c_of_type_AndroidWidgetTextView = this.jdField_g_of_type_AndroidWidgetTextView;
    localqyn.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    localqyn.jdField_b_of_type_AndroidViewViewGroup = this.jdField_g_of_type_AndroidViewViewGroup;
    localqyn.jdField_d_of_type_AndroidWidgetTextView = this.jdField_e_of_type_AndroidWidgetTextView;
    localqyn.jdField_e_of_type_AndroidWidgetTextView = this.jdField_f_of_type_AndroidWidgetTextView;
    localqyn.jdField_f_of_type_AndroidWidgetTextView = this.jdField_h_of_type_AndroidWidgetTextView;
    if ((this instanceof nzt))
    {
      this.jdField_a_of_type_Qyj = new nzu(new nzw(), localqyn, paramVideoFeedsPlayManager, false);
      return;
    }
    this.jdField_a_of_type_Qyj = new qyj(localqyn, paramVideoFeedsPlayManager, false);
  }
  
  private void a(VideoFeedsPlayManager paramVideoFeedsPlayManager, qky paramqky)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(paramVideoFeedsPlayManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(paramqky);
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
        localObject = new rpk();
        ((rpk)localObject).jdField_a_of_type_JavaNetURL = onk.a(paramURL.toString());
        ((rpk)localObject).jdField_a_of_type_Int = i2;
        ((rpk)localObject).jdField_b_of_type_Int = i1;
        localObject = rpj.a().a((rpk)localObject);
        if ((localObject == null) || (((rpg)localObject).a() == null)) {
          break;
        }
        paramImageView.setImageDrawable(new rpr(((rpg)localObject).a()));
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
    if (this.jdField_a_of_type_Qqo == null)
    {
      this.jdField_a_of_type_Qqo = new qqo();
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv = this.jdField_a_of_type_Qyj;
    }
    this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_Qqo.jdField_a_of_type_AndroidViewViewGroup = this.jdField_f_of_type_AndroidViewViewGroup;
    this.jdField_a_of_type_Qqo.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Qqo.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Qqo.jdField_a_of_type_AndroidOsBundle.putInt("video_feeds_index", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Qqo.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Qqo.jdField_b_of_type_Boolean = true;
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    int i1 = oph.b();
    if (i1 > 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, i1 * 1000);
      return;
    }
    View localView = this.jdField_d_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (i1 = 0;; i1 = 300)
    {
      qol.a(localView, 0, i1);
      this.n.setAlpha(0.2F);
      return;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    g();
    f();
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindow().addContentView(this.jdField_e_of_type_AndroidViewViewGroup, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    this.jdField_m_of_type_AndroidViewViewGroup.addView(this.jdField_e_of_type_AndroidViewViewGroup, this.jdField_c_of_type_Int);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub != null)) {
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub.c();
    }
    if ((this.jdField_e_of_type_AndroidViewViewGroup.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.jdField_e_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_e_of_type_AndroidViewViewGroup);
    }
    if ((this.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub != null)) {
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub.d();
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
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new qxg(this, paramBoolean));
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
    }
    qol.b(this.jdField_j_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.u, "赞");
  }
  
  private void g()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_e_of_type_AndroidViewViewGroup.getLayoutParams();
    if (this.jdField_a_of_type_Boolean) {
      localLayoutParams.height = -1;
    }
    for (localLayoutParams.width = -1;; localLayoutParams.width = -1)
    {
      this.jdField_e_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.height = qxo.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
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
    this.jdField_a_of_type_Qyj.a(true);
    this.jdField_a_of_type_Qyj.a();
  }
  
  private void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      qol.a(this.jdField_h_of_type_AndroidViewViewGroup, 0);
      qol.a(this.jdField_g_of_type_AndroidViewViewGroup, 0);
      if (!this.jdField_a_of_type_Boolean) {
        qol.b(this.o, 0);
      }
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      g(paramBoolean);
      return;
      qol.a(this.jdField_h_of_type_AndroidViewViewGroup, 8);
      if (this.jdField_a_of_type_Qxu.a(this)) {
        qol.a(this.jdField_g_of_type_AndroidViewViewGroup, 8);
      }
      qol.b(this.o, 8);
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
  
  public qqo a()
  {
    return this.jdField_a_of_type_Qqo;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Qyj.a(false);
    if (this.jdField_h_of_type_AndroidViewViewGroup.getVisibility() == 0)
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
    if ((paramInt == 0) && (!this.jdField_a_of_type_Qxu.a(this))) {
      d(false);
    }
    while (oph.b() <= 0) {
      return;
    }
    a();
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_Qxu.a(this)) {
      if (this.jdField_h_of_type_AndroidViewViewGroup.getVisibility() != 8) {
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
    if ((this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_Qxu.a(this))) {
      return;
    }
    if (this.jdField_a_of_type_Qxu != null)
    {
      paramView = new int[2];
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.getLocationInWindow(paramView);
      this.jdField_a_of_type_Qxu.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramView[0] + paramInt1, paramView[1] + paramInt2);
    }
    f(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.l);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    b(paramVideoInfo);
    c();
    b();
    if (bkur.b())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity))
      {
        this.jdField_i_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
        qxo.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_i_of_type_AndroidViewViewGroup);
      }
    }
    else {
      return;
    }
    this.jdField_i_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    qxo.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_i_of_type_AndroidViewViewGroup);
  }
  
  public void a(qxu paramqxu, qxr paramqxr, VideoFeedsPlayManager paramVideoFeedsPlayManager, qky paramqky)
  {
    this.jdField_a_of_type_Qxu = paramqxu;
    this.jdField_a_of_type_Qxr = paramqxr;
    a(paramVideoFeedsPlayManager);
    a(paramVideoFeedsPlayManager, paramqky);
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
    qol.b(this.o, 0);
  }
  
  public void b()
  {
    qol.b(this.jdField_i_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e, "评论");
    if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    VideoFeedsAccessibilityHelper.a(this.jdField_i_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e);
    qol.b(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f, "Biu");
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f);
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (!rmc.a().b())) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    qol.b(this.jdField_j_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.u, "赞");
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(a(a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.l)));
    }
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.u, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.l);
  }
  
  public void b(View paramView) {}
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    e(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_i_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(a(2130841326));
      if ((bkur.b()) && (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity))) {
        qxo.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_k_of_type_AndroidViewViewGroup);
      }
    }
    for (;;)
    {
      h(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(paramBoolean);
      return;
      this.jdField_k_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      continue;
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      this.jdField_i_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(a(2130841327));
      this.jdField_k_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    }
  }
  
  public void c()
  {
    qol.a(this.jdField_d_of_type_AndroidViewView, 8, 0);
    d(true);
    int i1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject1 = this.jdField_e_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).height = qxo.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    ((ViewGroup.LayoutParams)localObject1).width = -1;
    this.jdField_e_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a();
    Object localObject2;
    if (localObject1 != null)
    {
      if ((this.jdField_a_of_type_Int != 0) || (!a(this.jdField_b_of_type_ComTencentImageURLImageView, (URL)localObject1)))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = qol.b(this.jdField_a_of_type_AndroidAppActivity)[0];
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i1;
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165275));
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165275));
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      }
      qol.a(this.jdField_b_of_type_ComTencentImageURLImageView, 0, 0);
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
      qol.a(this.jdField_c_of_type_AndroidWidgetTextView, 0L);
      qol.a(this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000);
      qol.a(this.jdField_m_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000);
      this.jdField_g_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_Qyj.a(0);
      this.jdField_h_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_l_of_type_AndroidViewViewGroup.setTag(this);
      this.jdField_l_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_j_of_type_AndroidViewViewGroup.setTag(this);
      this.jdField_j_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c);
      this.jdField_k_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.o.setVisibility(0);
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(qxo.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.s));
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
      ((URLDrawable)localObject1).setDecodeHandler(bavi.w);
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
      this.jdField_a_of_type_Qxr.a(this.jdField_e_of_type_AndroidViewViewGroup, 0, new FrameLayout.LayoutParams(this.jdField_e_of_type_AndroidViewViewGroup.getLayoutParams()));
      return;
    }
    this.jdField_m_of_type_AndroidViewViewGroup.addView(this.jdField_e_of_type_AndroidViewViewGroup, this.jdField_c_of_type_Int);
    this.jdField_c_of_type_AndroidViewView.clearAnimation();
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void d()
  {
    qol.b(this.jdField_i_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e, "评论");
    VideoFeedsAccessibilityHelper.a(this.jdField_i_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e);
    qol.b(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f, "Biu");
    VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f);
    qol.b(this.jdField_j_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.u, "赞");
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(a(a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.l)));
    }
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.u, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.l);
    this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c);
    this.jdField_l_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c);
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(qxo.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.s));
    }
  }
  
  public void e() {}
  
  public void onClick(View paramView)
  {
    qxf localqxf = (qxf)paramView.getTag();
    switch (paramView.getId())
    {
    default: 
    case 2131370539: 
    case 2131366873: 
    case 2131364272: 
    case 2131371739: 
    case 2131366607: 
    case 2131366580: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (this.jdField_a_of_type_Qxu.a(this));
            this.jdField_a_of_type_Qxr.c(this.jdField_a_of_type_Int);
            return;
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Qxr.d();
              return;
            }
            this.jdField_a_of_type_Qxr.c();
            return;
            this.jdField_a_of_type_Qxr.d();
            return;
          } while (this.jdField_a_of_type_Qxu == null);
          this.jdField_a_of_type_Qxu.h();
          return;
        } while (this.jdField_a_of_type_Qxu == null);
        this.jdField_a_of_type_Qxu.i();
        return;
      } while (this.jdField_a_of_type_Qxu == null);
      this.jdField_a_of_type_Qxu.e(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      return;
    }
    if (this.jdField_a_of_type_Qxu != null) {
      this.jdField_a_of_type_Qxu.f(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    f(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxf
 * JD-Core Version:    0.7.0.1
 */