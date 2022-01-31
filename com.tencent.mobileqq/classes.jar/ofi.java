import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

@SuppressLint({"ViewConstructor"})
class ofi
  extends RelativeLayout
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  @Nullable
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new ofk(this));
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ApngDrawable.OnPlayRepeatListener jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener;
  @Nullable
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private VPNGImageView jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
  @Nullable
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private rjn jdField_a_of_type_Rjn;
  private rjo jdField_a_of_type_Rjo = new ofj(this);
  private boolean jdField_a_of_type_Boolean;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean = true;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean = true;
  
  public ofi(Activity paramActivity, @Nullable ListView paramListView, String paramString)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramActivity.getWindow().getDecorView());
    this.jdField_a_of_type_JavaLangString = paramString;
    e();
  }
  
  @Nullable
  private Bitmap a(@Nullable View paramView, boolean paramBoolean)
  {
    Canvas localCanvas = null;
    Object localObject4 = null;
    Bitmap localBitmap1 = null;
    Object localObject2;
    Object localObject3;
    if (paramView != null)
    {
      paramView.setDrawingCacheEnabled(true);
      paramView.buildDrawingCache();
      localObject2 = localCanvas;
      localObject3 = localObject4;
    }
    try
    {
      Bitmap localBitmap2 = paramView.getDrawingCache();
      localObject2 = localCanvas;
      localObject3 = localObject4;
      localBitmap1 = Bitmap.createBitmap(localBitmap2.getWidth(), localBitmap2.getHeight(), localBitmap2.getConfig());
      localObject2 = localBitmap1;
      localObject3 = localBitmap1;
      localCanvas = new Canvas(localBitmap1);
      if (!paramBoolean)
      {
        localObject2 = localBitmap1;
        localObject3 = localBitmap1;
        localCanvas.drawColor(Color.parseColor("#f8f8f8"));
      }
      localObject2 = localBitmap1;
      localObject3 = localBitmap1;
      localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, null);
      return localBitmap1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("KandianAdPandent", 2, "buildBitmapFromView, error" + localException.getMessage());
        localException.printStackTrace();
      }
      return localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("KandianAdPandent", 2, "buildBitmapFromView, error" + localOutOfMemoryError.getMessage());
        localOutOfMemoryError.printStackTrace();
      }
      return localObject3;
    }
    finally
    {
      paramView.setDrawingCacheEnabled(false);
      paramView.destroyDrawingCache();
    }
  }
  
  @Nullable
  private View a()
  {
    localObject2 = null;
    View localView = null;
    int j;
    int k;
    int i;
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      k = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      i = j;
    }
    for (;;)
    {
      localObject2 = localView;
      if (i <= k) {
        localObject2 = localView;
      }
      try
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter().getItem(i);
        localObject2 = localView;
        if ((localObject3 instanceof AdvertisementInfo))
        {
          localObject2 = localView;
          localObject3 = (AdvertisementInfo)localObject3;
          localObject2 = localView;
          if (oek.a().a != null)
          {
            localObject2 = localView;
            if (((AdvertisementInfo)localObject3).mAdAid == oek.a().a.mAdAid)
            {
              localObject2 = localView;
              localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i - j);
              localObject2 = localView;
              QLog.d("KandianAdPandent", 2, "hideAdsWithAnim, find AdvertisementInfo, targetPos=" + i + ", targetItemView=" + localView);
              localObject2 = localView;
              return localObject2;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1 = localObject2;
        }
      }
      i += 1;
    }
  }
  
  private void a(String paramString)
  {
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setVisibility(0);
    g();
    Object localObject = new MediaMetadataRetriever();
    try
    {
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      localObject = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_b_of_type_AndroidViewViewGroup.getWidth() * 1.778F));
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setVideo(paramString, false, 1, new ofl(this));
      c();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("KandianAdPandent", 2, "MediaMetadataRetriever exception " + localException);
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("audio"));
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      b();
      return;
    case 3: 
      a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    b(this.jdField_a_of_type_JavaLangString);
  }
  
  private void b(String paramString)
  {
    a(false);
    g();
    if (QLog.isColorLevel()) {
      QLog.d("KandianAdPandent", 2, new Object[] { "initTVKVideoController with path:", paramString });
    }
    if (!TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidAppActivity)) {
      QLog.e("KandianAdPandent", 2, "sdk NOT installed");
    }
    this.jdField_a_of_type_Rjn = new rjn(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_Rjn.b();
    this.jdField_c_of_type_AndroidViewView.setId(2131368953);
    if (this.jdField_c_of_type_AndroidViewView != null) {
      a(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_a_of_type_Rjn.b(2);
    this.jdField_a_of_type_Rjn.a((IVideoViewBase)this.jdField_c_of_type_AndroidViewView);
    this.jdField_a_of_type_Rjn.a(this.jdField_a_of_type_Rjo);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Rjn.a(null, paramString, 4, 1L, 0L, 0);
    this.jdField_a_of_type_Rjn.a().setOutputMute(false);
    c();
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2131560051, this, true);
    setId(2131369000);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131371661));
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView = ((VPNGImageView)findViewById(2131368950));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371656));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368802));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368799));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368800));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371662);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131371669);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368985));
    ((ImmersiveTitleBar2)findViewById(2131378120)).a(0);
    setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void f()
  {
    boolean bool2 = true;
    label43:
    label104:
    TVK_IMediaPlayer localTVK_IMediaPlayer;
    if (!this.jdField_c_of_type_Boolean)
    {
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      if (!this.jdField_c_of_type_Boolean) {
        break label142;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130848912));
      if ((this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer() != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.isPlaying()))
      {
        if (!this.jdField_c_of_type_Boolean) {
          break label165;
        }
        this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.setVolume(1.0F, 1.0F);
      }
      if (this.jdField_a_of_type_Rjn != null)
      {
        localTVK_IMediaPlayer = this.jdField_a_of_type_Rjn.a();
        if (this.jdField_c_of_type_Boolean) {
          break label183;
        }
      }
    }
    label142:
    label165:
    label183:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localTVK_IMediaPlayer.setOutputMute(bool1);
      return;
      bool1 = false;
      break;
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130848911));
      break label43;
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.setVolume(0.0F, 0.0F);
      break label104;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
    QLog.d("KandianAdPandent", 2, "current volume =  " + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_Int / 5.0F);
    QLog.d("KandianAdPandent", 2, "current volume =  " + this.jdField_a_of_type_Int + "intervalVolume = " + this.jdField_a_of_type_Float);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject3 = a();
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.findViewById(16908307);
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131379430);
    int i;
    int j;
    if (localObject3 != null)
    {
      i = ((View)localObject3).getHeight();
      j = a((View)localObject3, this.jdField_b_of_type_AndroidViewViewGroup);
    }
    for (;;)
    {
      QLog.d("KandianAdPandent", 2, "hideAdsWithAnim, targetFeedsItemTop=" + j + ", targetFeedsItemHeight=" + i);
      if ((j >= 0) && (i > 0)) {}
      for (int k = 1; k != 0; k = 0)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = a((View)localObject3, false);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          localObject3 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
          ((ViewGroup.LayoutParams)localObject3).height = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
          this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
        }
        this.jdField_c_of_type_AndroidGraphicsBitmap = a((View)localObject2, true);
        if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap);
          localObject3 = this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).height = this.jdField_c_of_type_AndroidGraphicsBitmap.getHeight();
          ((ViewGroup.LayoutParams)localObject3).width = this.jdField_c_of_type_AndroidGraphicsBitmap.getWidth();
          this.jdField_c_of_type_AndroidWidgetImageView.setY(((View)localObject2).getY());
          this.jdField_c_of_type_AndroidWidgetImageView.requestLayout();
        }
        this.jdField_b_of_type_AndroidGraphicsBitmap = a((View)localObject1, true);
        if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
          localObject2 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).height = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
          ((ViewGroup.LayoutParams)localObject2).width = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
          this.jdField_b_of_type_AndroidWidgetImageView.setY(((View)localObject1).getY());
          this.jdField_b_of_type_AndroidWidgetImageView.requestLayout();
        }
        i = i / 2 + j - getHeight() / 2;
        QLog.d("KandianAdPandent", 2, "hideAdsWithAnim, centerDiff=" + i);
        localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.2F, 1.0F });
        localObject3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.2F, 1.0F });
        Object localObject4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
        Object localObject5 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, i });
        localObject1 = new AnimatorSet();
        ((AnimatorSet)localObject1).play((Animator)localObject2).with((Animator)localObject3).with((Animator)localObject4).with((Animator)localObject5);
        ((AnimatorSet)localObject1).setDuration(600L);
        localObject3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "alpha", new float[] { 1.0F, 0.0F });
        localObject4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "scaleY", new float[] { 1.0F, 0.8F });
        localObject5 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "scaleY", new float[] { 1.0F, 0.8F });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", new float[] { 0.0F, i });
        localObject2 = new AnimatorSet();
        ((AnimatorSet)localObject2).play((Animator)localObject3).with(localObjectAnimator).with((Animator)localObject4).with((Animator)localObject5);
        ((AnimatorSet)localObject2).setDuration(600L);
        localObject3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 0.5F, 0.0F });
        ((ObjectAnimator)localObject3).setDuration(600L);
        localObject5 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { 1.0F, 0.0F });
        localObject4 = new AnimatorSet();
        ((AnimatorSet)localObject4).play((Animator)localObject5).after(150L);
        ((AnimatorSet)localObject4).setDuration(150L);
        localObject5 = new AnimatorSet();
        ((AnimatorSet)localObject5).setInterpolator(new AccelerateDecelerateInterpolator());
        ((AnimatorSet)localObject5).playTogether(new Animator[] { localObject1, localObject2, localObject3, localObject4 });
        ((AnimatorSet)localObject5).start();
        this.jdField_a_of_type_Boolean = true;
        ((AnimatorSet)localObject5).addListener(new ofm(this));
        return;
      }
      i();
      return;
      j = -1;
      i = 0;
    }
  }
  
  private void i()
  {
    a();
  }
  
  public int a(View paramView1, View paramView2)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i > 30) {
        return j;
      }
      j = paramView1.getTop() + j;
      paramView1 = (View)paramView1.getParent();
      if ((paramView1 == null) || (paramView1 == paramView2)) {
        return j;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    if (getParent() != null)
    {
      ((ViewGroup)getParent()).removeView(this);
      this.jdField_b_of_type_Boolean = false;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      localObject = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localObject instanceof ApngDrawable))
      {
        localObject = (ApngDrawable)localObject;
        ((ApngDrawable)localObject).removeOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener);
        ((ApngDrawable)localObject).setOnPlayRepeatListener(null);
      }
    }
    if (NetConnInfoCenter.getServerTimeMillis() - oek.a().a() >= 1000L) {
      oek.a().b();
    }
    oek.a().a(2);
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
      if ((localObject instanceof bhtf))
      {
        localObject = ((bhtf)localObject).getWrappedAdapter();
        if ((localObject instanceof rqj)) {
          ((rqj)localObject).a(this.jdField_a_of_type_ComTencentWidgetListView, 0);
        }
      }
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onRelease();
    }
    if (this.jdField_a_of_type_Rjn != null)
    {
      this.jdField_a_of_type_Rjn.i();
      this.jdField_a_of_type_Rjn.j();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_a_of_type_Int, 4);
      oek.a().c();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("KandianAdPandentMask", 2, "audioManager setStreamVolume error :" + localException.toString());
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369000) == null)
    {
      b(paramInt);
      this.jdField_b_of_type_AndroidViewViewGroup.addView(this);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(View paramView)
  {
    if ((paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup))) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    a(this.jdField_c_of_type_AndroidViewView);
    a(this.jdField_d_of_type_AndroidWidgetImageView);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = -1;
    localLayoutParams.width = -1;
    localLayoutParams.addRule(13, -1);
    paramViewGroup.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 27.0F);
    localLayoutParams.width = bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 72.0F);
    localLayoutParams.rightMargin = bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    localLayoutParams.topMargin = bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 60.0F);
    localLayoutParams.addRule(11, -1);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 26.0F);
    localLayoutParams.width = bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 26.0F);
    localLayoutParams.rightMargin = bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 2.0F);
    localLayoutParams.addRule(6, 2131368985);
    localLayoutParams.addRule(8, 2131368985);
    localLayoutParams.addRule(0, 2131368985);
    paramViewGroup.addView(this.jdField_d_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  void b() {}
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer() != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a != null))
    {
      if (!paramBoolean) {
        break label70;
      }
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onResume();
    }
    label70:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Rjn != null)
        {
          if (!paramBoolean) {
            break;
          }
          if (this.jdField_a_of_type_Rjn.d()) {
            this.jdField_a_of_type_Rjn.f();
          }
        }
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.isPlaying()) {
          this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onPause();
        }
      }
    } while (!this.jdField_a_of_type_Rjn.c());
    this.jdField_a_of_type_Rjn.h();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, 0, 4);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      int i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
      if (i >= this.jdField_a_of_type_Int) {
        this.jdField_d_of_type_Boolean = false;
      }
      i = (int)Math.ceil(i + this.jdField_a_of_type_Float);
      QLog.d("KandianAdPandent", 2, "updateVolume setVolume =  " + i);
      this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, i, 4);
    }
  }
  
  public void onClick(View paramView)
  {
    long l;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131369000: 
      oek.a().b(1);
      obl localobl = oek.a().a.mAdvertisementExtInfo;
      if (this.jdField_c_of_type_Boolean)
      {
        paramView = "1";
        localobl.f = paramView;
        if ((this.jdField_a_of_type_ComTencentWidgetListView == null) || (this.jdField_a_of_type_ComTencentWidgetListView.getAdapter() == null) || (!(this.jdField_a_of_type_ComTencentWidgetListView.getAdapter() instanceof bhtf))) {
          break label349;
        }
        paramView = (bhtf)this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
        if ((paramView.getWrappedAdapter() == null) || (!(paramView.getWrappedAdapter() instanceof rqi))) {
          break label349;
        }
        paramView = (rqi)paramView.getWrappedAdapter();
        if (paramView != null)
        {
          paramView.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = szl.a(getContext(), oek.a().a, paramView, 0, false, null);
          if (paramView.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) {
            break label242;
          }
          l = SystemClock.elapsedRealtime();
          label178:
          paramView.jdField_a_of_type_Long = l;
        }
      }
      break;
    }
    for (;;)
    {
      oek.a().a.clickPos = 11;
      szl.a(this.jdField_a_of_type_AndroidAppActivity, oek.a().a, paramView, 0, false, false, null);
      oek.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.pauseVideo();
      }
      i();
      return;
      paramView = "0";
      break;
      label242:
      l = -2147483648L;
      break label178;
      oek.a().b(noy.B);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.pauseVideo();
      }
      this.jdField_c_of_type_Boolean = false;
      f();
      h();
      return;
      if (this.jdField_c_of_type_Boolean)
      {
        oek.a().a.mAdvertisementExtInfo.f = "0";
        oek.a().b(noy.C);
      }
      for (;;)
      {
        f();
        return;
        oek.a().a.mAdvertisementExtInfo.f = "1";
        oek.a().b(noy.D);
      }
      label349:
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ofi
 * JD-Core Version:    0.7.0.1
 */