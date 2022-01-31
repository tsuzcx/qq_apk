package com.tencent.qqmini.sdk.runtime.widget.media;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import bgls;
import bglu;
import bgok;
import bhiw;
import bhkp;
import bhkq;
import bhkr;
import bhky;
import com.tencent.qqmini.sdk.core.widget.media.VideoGestureLayout;
import com.tencent.qqmini.sdk.core.widget.media.VideoGestureRelativeLayout;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppLivePlayer
  extends FrameLayout
  implements View.OnClickListener
{
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public bgls a;
  private bhky jdField_a_of_type_Bhky;
  private VideoGestureLayout jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureLayout;
  private VideoGestureRelativeLayout jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout;
  private Object jdField_a_of_type_JavaLangObject;
  public String a;
  public WeakReference<Activity> a;
  public boolean a;
  public int b;
  long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  private int c;
  public boolean c;
  private int d;
  public boolean d;
  private int e;
  public boolean e;
  public boolean f = true;
  boolean g = false;
  private boolean h;
  
  public MiniAppLivePlayer(@NonNull Context paramContext)
  {
    this(paramContext, null);
    a(paramContext);
  }
  
  public MiniAppLivePlayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 8;
    this.jdField_d_of_type_Int = 8;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_Int = -1;
    a(paramContext);
  }
  
  private void a(Activity paramActivity)
  {
    int i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = 5894;
      if (Build.VERSION.SDK_INT < 19) {
        break label64;
      }
      i |= 0x800;
    }
    for (;;)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
      return;
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      i = 1798;
      break;
      label64:
      i |= 0x1;
    }
  }
  
  private void a(Context paramContext)
  {
    if (this.h) {
      return;
    }
    this.h = true;
    setTag("MiniAppLivePlayer");
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559357, null);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout = ((VideoGestureRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369306));
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout.setContentDescription("video_container");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379799));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372094));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureLayout = new VideoGestureLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureLayout.setContentDescription("VideoGestureLayout");
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  /* Error */
  private static void b(android.graphics.Bitmap paramBitmap, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 196	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 198	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 201	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 204	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 210	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: bipush 100
    //   24: invokestatic 216	java/lang/Math:min	(II)I
    //   27: aload_1
    //   28: invokevirtual 222	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 225	java/io/BufferedOutputStream:flush	()V
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 228	java/io/BufferedOutputStream:close	()V
    //   44: return
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 228	java/io/BufferedOutputStream:close	()V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: return
    //   60: astore_1
    //   61: goto -5 -> 56
    //   64: astore_0
    //   65: goto -17 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramBitmap	android.graphics.Bitmap
    //   0	68	1	paramFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   0	16	45	finally
    //   40	44	58	java/lang/Exception
    //   52	56	60	java/lang/Exception
    //   16	36	64	finally
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaLangObject = bhiw.a("com.tencent.rtmp.ui.TXCloudVideoView", bhiw.a(new Class[] { Context.class }), new Object[] { getContext() });
    if (this.jdField_a_of_type_JavaLangObject == null)
    {
      QMLog.e("MiniAppLivePlayer", "tXCloudVideoView is null?! ");
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout.removeAllViews();
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout.setBackgroundColor(-16777216);
    localLayoutParams = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 100.0F), DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 100.0F));
    localLayoutParams.gravity = 17;
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureLayout, localLayoutParams);
  }
  
  private void d()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("livePlayerId", this.jdField_a_of_type_Long);
      localJSONObject.put("direction", "");
      localJSONObject.put("fullScreen", this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Bgls.a().a("onLivePlayerFullScreenChange", localJSONObject.toString(), this.jdField_a_of_type_Int);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniAppLivePlayer.4(this));
  }
  
  public void a(bgok parambgok, JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppLivePlayer", "initLivePlayerSettings isFullScreen: " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    c();
    this.jdField_a_of_type_Bhky = new bhky(getContext());
    this.jdField_a_of_type_Bhky.a(this.jdField_a_of_type_JavaLangObject, paramJSONObject);
    this.jdField_a_of_type_Bhky.a(new bhkp(this, parambgok));
    this.jdField_a_of_type_Bhky.a(new bhkq(this, parambgok));
  }
  
  public void a(String paramString, bgok parambgok, JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_Bhky == null) {
      return;
    }
    if ("requestFullScreen".equalsIgnoreCase(paramString))
    {
      a();
      parambgok.a();
      return;
    }
    if ("exitFullScreen".equalsIgnoreCase(paramString))
    {
      b();
      parambgok.a();
      return;
    }
    if ("snapshot".equalsIgnoreCase(paramString))
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramJSONObject != null)
      {
        paramString = paramJSONObject.optString("quality");
        bool1 = bool2;
        if (paramString != null)
        {
          bool1 = bool2;
          if (paramString.equalsIgnoreCase("compressed")) {
            bool1 = true;
          }
        }
      }
      a("operateLivePlayer", bool1, parambgok);
      return;
    }
    this.jdField_a_of_type_Bhky.a(paramString, paramJSONObject);
    parambgok.a();
  }
  
  public void a(String paramString, boolean paramBoolean, bgok parambgok)
  {
    if (this.jdField_a_of_type_Bhky == null) {
      return;
    }
    QMLog.e("MiniAppLivePlayer", "takePhoto invoke");
    this.jdField_a_of_type_Bhky.a(new bhkr(this, paramString, parambgok));
    this.jdField_a_of_type_Bhky.a(paramBoolean);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppLivePlayer", "updateLivePlayerSetting isFullScreen: " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Bhky == null) {
      return;
    }
    this.jdField_a_of_type_Bhky.a(paramJSONObject);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 == DisplayUtil.getRealHeight(getContext())) && (paramInt2 == ImmersiveUtils.getScreenWidth());
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniAppLivePlayer.5(this));
  }
  
  public void onClick(View paramView) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.media.MiniAppLivePlayer
 * JD-Core Version:    0.7.0.1
 */