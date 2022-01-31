import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.BiuLikeFusionManager.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.BiuLikeFusionManager.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.BiuLikeFusionManager.5;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class rlz
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  private rlz()
  {
    rma localrma = new rma(this);
    osj.a().a(localrma);
  }
  
  private int a()
  {
    return Aladdin.getConfig(238).getIntegerFromString("likeBiuFusion_guideCount", 3);
  }
  
  private long a()
  {
    return Aladdin.getConfig(238).getLongFromString("android_likeBiuFusion_guide_show_cnt", 3600000L);
  }
  
  private String a()
  {
    return Aladdin.getConfig(238).getString("black_wording", BaseApplicationImpl.getContext().getString(2131718353));
  }
  
  public static rlz a()
  {
    return rmd.a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private void a(int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putInt("fusion_biu_guide_has_shown_times_" + onh.a(), paramInt).apply();
  }
  
  private void a(long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putLong("fusion_biu_guide_last_show_time_stamp_" + onh.a(), paramLong).apply();
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (!b()) {
      return;
    }
    if (paramBoolean) {
      bcql.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getString(2131718407), 0).a();
    }
    for (;;)
    {
      osj.a().a(paramBoolean, paramLong, this.jdField_a_of_type_Int, paramString);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
      bcql.a(BaseApplicationImpl.getContext(), 1, BaseApplicationImpl.getContext().getString(2131718405), 0).a();
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (!b()) {
      return;
    }
    if (paramBoolean) {
      bcql.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getString(2131718398), 0).a();
    }
    for (;;)
    {
      osj.a().a(paramBoolean, this.jdField_a_of_type_Int, paramString);
      osg.a().b(true);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
      bcql.a(BaseApplicationImpl.getContext(), 1, BaseApplicationImpl.getContext().getString(2131718397), 0).a();
    }
  }
  
  private int b()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt("fusion_biu_guide_has_shown_times_" + onh.a(), 0);
  }
  
  private long b()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getLong("fusion_biu_guide_last_show_time_stamp_" + onh.a(), 0L);
  }
  
  private String b()
  {
    return Aladdin.getConfig(238).getString("blue_wording", BaseApplicationImpl.getContext().getString(2131718354));
  }
  
  private String c()
  {
    return Aladdin.getConfig(238).getString("guide_wording", BaseApplicationImpl.getContext().getString(2131718350));
  }
  
  public SpannableString a(Context paramContext)
  {
    String str1 = a();
    String str2 = b();
    SpannableString localSpannableString = new SpannableString("  " + str1 + " " + str2 + "  ");
    Drawable localDrawable = paramContext.getResources().getDrawable(2130841249);
    localDrawable.setBounds(0, 0, vpm.b(paramContext, 20.0F), vpm.b(paramContext, 20.0F));
    localSpannableString.setSpan(new wdv(localDrawable), 0, 1, 17);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF03081B")), 2, str1.length() + 2, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF376099")), str1.length() + 2 + 1, str1.length() + 2 + 1 + str2.length(), 33);
    localDrawable = paramContext.getResources().getDrawable(2130841243);
    localDrawable.setBounds(0, 0, vpm.b(paramContext, 6.0F), vpm.b(paramContext, 10.0F));
    localSpannableString.setSpan(new wdv(localDrawable), str1.length() + 2 + 1 + str2.length() + 1, str1.length() + 2 + 1 + str2.length() + 2, 17);
    return localSpannableString;
  }
  
  public void a(Context paramContext, long paramLong, int paramInt1, int paramInt2, ArticleInfo paramArticleInfo, int paramInt3, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new BiuLikeFusionManager.2(this), 5000L);
    osg.a().a(paramLong, paramInt1, paramInt2, paramArticleInfo);
  }
  
  public void a(Context paramContext, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new BiuLikeFusionManager.3(this), 5000L);
    paramContext = new ArticleInfo();
    paramContext.mFeedId = paramLong1;
    paramContext.publishUin = paramLong2;
    paramContext.mFeedType = paramInt1;
    rmr.a(paramContext, new rmb(this, paramString));
  }
  
  public void a(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramImageView == null) {}
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 26) {}
      try
      {
        ((Vibrator)BaseApplicationImpl.getContext().getSystemService("vibrator")).vibrate(10L);
        if ((bbfj.a()) && (paramBoolean)) {
          continue;
        }
        if (this.jdField_a_of_type_AndroidViewAnimationScaleAnimation == null)
        {
          ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);
          localScaleAnimation.setDuration(140L);
          localScaleAnimation.setRepeatCount(1);
          localScaleAnimation.setRepeatMode(2);
          localScaleAnimation.setInterpolator(new DecelerateInterpolator());
          this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = localScaleAnimation;
        }
        this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new rmc(this));
        paramImageView.clearAnimation();
        paramImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void a(FastWebActivity paramFastWebActivity, long paramLong, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new BiuLikeFusionManager.5(this), 5000L);
    paramFastWebActivity.a(0, 0, false, true, true, paramLong);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", onh.a());
      localJSONObject.put("rowkey", paramString);
      if (paramInt1 != 0) {
        localJSONObject.put("channelid", paramInt1);
      }
      localJSONObject.put("like_biu_content_type", paramInt2);
      localJSONObject.put("like_biu_page", paramInt3);
      nol.a(null, null, "0X800A91C", "0X800A91C", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    long l = System.currentTimeMillis();
    if ((l - b() >= a()) && (b()) && (b() < a()))
    {
      a(b() + 1);
      a(l);
      return true;
    }
    return false;
  }
  
  public SpannableString b(Context paramContext)
  {
    String str = "  " + c();
    SpannableString localSpannableString = new SpannableString(str);
    Drawable localDrawable = paramContext.getResources().getDrawable(2130841248);
    localDrawable.setBounds(0, 0, vpm.b(paramContext, 24.0F), vpm.b(paramContext, 24.0F));
    localSpannableString.setSpan(new wdv(localDrawable), 0, 1, 17);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF262626")), 2, str.length(), 33);
    return localSpannableString;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", onh.a());
      localJSONObject.put("rowkey", paramString);
      if (paramInt1 != 0) {
        localJSONObject.put("channelid", paramInt1);
      }
      localJSONObject.put("like_biu_content_type", paramInt2);
      localJSONObject.put("like_biu_page", paramInt3);
      nol.a(null, null, "0X800A91D", "0X800A91D", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean b()
  {
    return Aladdin.getConfig(238).getIntegerFromString("likeBiuFusion_gray", 0) == 1;
  }
  
  public SpannableString c(Context paramContext)
  {
    String str = "  " + c();
    SpannableString localSpannableString = new SpannableString(str);
    Drawable localDrawable = paramContext.getResources().getDrawable(2130841248);
    localDrawable.setBounds(0, 0, vpm.b(paramContext, 24.0F), vpm.b(paramContext, 24.0F));
    localSpannableString.setSpan(new wdv(localDrawable), 0, 1, 17);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 2, str.length(), 33);
    return localSpannableString;
  }
  
  public SpannableString d(Context paramContext)
  {
    String str1 = a();
    String str2 = b();
    SpannableString localSpannableString = new SpannableString("  " + str1 + " " + str2 + "  ");
    Drawable localDrawable = paramContext.getResources().getDrawable(2130841249);
    localDrawable.setBounds(0, 0, vpm.b(paramContext, 20.0F), vpm.b(paramContext, 20.0F));
    localSpannableString.setSpan(new wdv(localDrawable), 0, 1, 17);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#66FFFFFF")), 2, str1.length() + 2, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), str1.length() + 2 + 1, str1.length() + 2 + 1 + str2.length(), 33);
    localDrawable = paramContext.getResources().getDrawable(2130841244);
    localDrawable.setBounds(0, 0, vpm.b(paramContext, 6.0F), vpm.b(paramContext, 10.0F));
    localSpannableString.setSpan(new wdv(localDrawable), str1.length() + 2 + 1 + str2.length() + 1, str1.length() + 2 + 1 + str2.length() + 2, 17);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rlz
 * JD-Core Version:    0.7.0.1
 */