package dov.com.qq.im.ae.play;

import aevv;
import aevw;
import afur;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.ColorDrawable;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import biaj;
import bkgk;
import bndh;
import bndt;
import bnqb;
import bnwv;
import bnww;
import bnwx;
import bnwy;
import bnyh;
import bnyz;
import bnzb;
import bpgu;
import bqio;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener;
import com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer;
import com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView;
import cooperation.qzone.QzoneFeedsPluginProxyActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import zkr;

public class AEVideoShelfPreviewFragment
  extends PublicBaseFragment
  implements aevw, View.OnClickListener, IVideoShelfPlayerListener
{
  private static PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private static final String jdField_a_of_type_JavaLangString = AEVideoShelfPreviewFragment.class.getSimpleName();
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  biaj jdField_a_of_type_Biaj;
  private VideoShelfEngine jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine;
  private VideoShelfPlayView jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, int[]> jdField_a_of_type_JavaUtilHashMap;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private double jdField_b_of_type_Double;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean = true;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean;
  private String jdField_h_of_type_JavaLangString;
  private volatile boolean jdField_h_of_type_Boolean;
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = ThumbnailUtils.createVideoThumbnail(paramString, paramInt2);
    paramInt2 = paramString.getWidth();
    int i = paramString.getHeight();
    if (paramInt2 > paramInt1)
    {
      i = (int)(1.0D * i * paramInt1 / paramInt2);
      paramInt2 = paramInt1;
    }
    for (paramInt1 = i;; paramInt1 = i) {
      return ThumbnailUtils.extractThumbnail(paramString, paramInt2, paramInt1, 2);
    }
  }
  
  private biaj a()
  {
    biaj localbiaj = new biaj(getActivity());
    localbiaj.a(afur.a(50.0F, getActivity().getResources()));
    localbiaj.a(true);
    localbiaj.c(false);
    localbiaj.f(-1);
    localbiaj.e(0);
    localbiaj.d(-15550475);
    localbiaj.g(3);
    localbiaj.jdField_f_of_type_Boolean = true;
    localbiaj.jdField_f_of_type_Int = 2;
    localbiaj.e(true);
    localbiaj.a(new bnwx(this));
    return localbiaj;
  }
  
  private void a()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getActivity().getWindow();
      if (localObject != null) {
        ((Window)localObject).setStatusBarColor(-16777216);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getActivity().findViewById(2131372680));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0(fps)");
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-65536);
    this.jdField_a_of_type_AndroidViewView = getActivity().findViewById(2131380537);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView = ((VideoShelfPlayView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380545));
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setOnPlayerListener(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372643);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)getActivity().findViewById(2131365789));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.getViewTreeObserver().addOnGlobalLayoutListener(new bnwv(this));
    getActivity().findViewById(2131363205).setOnClickListener(this);
    Object localObject = (TextView)getActivity().findViewById(2131363896);
    ((TextView)localObject).setOnClickListener(this);
    ((TextView)localObject).setText(2131689747);
    b();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Biaj == null) {
      return;
    }
    this.jdField_a_of_type_Biaj.a();
    this.jdField_a_of_type_Biaj.c(paramInt);
    this.jdField_a_of_type_Biaj.b(true);
    this.jdField_a_of_type_Biaj.d(false);
    this.jdField_a_of_type_Biaj.a(paramInt + "%");
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    bnzb.c(jdField_a_of_type_JavaLangString, "Merge Video step onError");
    this.jdField_b_of_type_Long = 0L;
    onError(paramInt1, paramString, null);
    this.jdField_b_of_type_Boolean = false;
    a(getActivity(), false);
  }
  
  public static void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("jump_in_from", paramInt);
    aevv.a(paramContext, paramIntent, PublicFragmentActivityForPeak.class, AEVideoShelfPreviewFragment.class);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(536870922, jdField_a_of_type_JavaLangString);
      jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      bnzb.b(jdField_a_of_type_JavaLangString, "keepScreenOn!");
      return;
    }
    if (jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    }
    bnzb.b(jdField_a_of_type_JavaLangString, "keepScreenOff!");
  }
  
  private void a(Intent paramIntent)
  {
    VideoShelfPlayView localVideoShelfPlayView;
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      if (this.jdField_d_of_type_Int == 2) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      localVideoShelfPlayView = this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView;
      if (this.jdField_d_of_type_Boolean) {
        break label95;
      }
    }
    boolean bool2;
    label95:
    for (boolean bool1 = true;; bool1 = false)
    {
      localVideoShelfPlayView.setVideoType(bool1);
      this.jdField_a_of_type_Boolean = false;
      if (!this.jdField_d_of_type_Boolean) {
        break label100;
      }
      bool2 = a(paramIntent);
      if (bool2) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.start();
      }
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break;
    }
    label100:
    this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("FinalVideoPath");
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {}
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setVideoFilePath(this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      bool2 = bool1;
      break;
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView == null))
    {
      bnzb.c(jdField_a_of_type_JavaLangString, "pagFileInit error");
      return false;
    }
    this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("pagFilePath");
    this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("audioFilePath");
    if (paramIntent.getBooleanExtra("isFromAsset", false))
    {
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setAudioPathFromAsset(this.jdField_f_of_type_JavaLangString, getActivity().getAssets());
      }
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setVideoFilePathFromAsset(this.jdField_e_of_type_JavaLangString, getActivity().getAssets());
      }
    }
    for (;;)
    {
      Object localObject = paramIntent.getExtras();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getSerializable("nodeImgList");
        if ((localObject instanceof HashMap))
        {
          this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localObject);
          this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setParam("imgGroup", new Object[] { this.jdField_a_of_type_JavaUtilHashMap });
        }
      }
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("videoOutWidth", 540);
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("videoOutHeight", 960);
      return true;
      bnzb.c(jdField_a_of_type_JavaLangString, "pagFileInit Asset Path error");
      return false;
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setAudioPath(this.jdField_f_of_type_JavaLangString);
      }
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setVideoFilePath(this.jdField_e_of_type_JavaLangString);
    }
    bnzb.c(jdField_a_of_type_JavaLangString, "pagFileInit not Asset Path error");
    return false;
  }
  
  @TargetApi(14)
  private void b()
  {
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(getActivity());
    Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
      if (Build.VERSION.SDK_INT >= 14) {
        ((Window)localObject).setDimAmount(0.0F);
      }
    }
    this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561876);
    localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372926);
    this.jdField_a_of_type_Biaj = a();
    ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Biaj);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371338)).setText(2131689760);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new bnww(this));
    this.jdField_a_of_type_Biaj.c(0);
  }
  
  private void b(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 200L)
    {
      bkgk.a(new AEVideoShelfPreviewFragment.9(this, paramInt));
      this.jdField_a_of_type_Long = l;
    }
  }
  
  private void b(Intent paramIntent)
  {
    this.jdField_f_of_type_Boolean = true;
    this.jdField_d_of_type_Int = paramIntent.getIntExtra("jump_in_from", 0);
    this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("MaterialPath");
    this.jdField_h_of_type_JavaLangString = paramIntent.getStringExtra("MaterialName");
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("MaterialId");
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("loc_play_show_take_same_name");
    }
    getActivity().getIntent().putExtra("key_camera_material_name", this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoList");
    this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("from", true);
    this.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("isNeedEditButton", false);
    this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("usePagPreview", false);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void e()
  {
    if (2 == this.jdField_a_of_type_Int)
    {
      g();
      return;
    }
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.resume();
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.pause();
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0(fps)");
  }
  
  private void h()
  {
    if (this.jdField_d_of_type_Int == 2)
    {
      getActivity().finish();
      return;
    }
    AEVideoShelfEditFragment.a(getActivity(), 22, this.jdField_g_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, 3);
  }
  
  private void i()
  {
    bkgk.a(new AEVideoShelfPreviewFragment.6(this));
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine == null) {
      return;
    }
    Object localObject1 = new File(this.jdField_f_of_type_JavaLangString);
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = AEVideoShelfEditFragment.a(BaseApplicationImpl.getContext());; bool = true)
    {
      label76:
      String str;
      StringBuilder localStringBuilder;
      if ((((File)localObject1).exists()) && (this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.toLowerCase().endsWith(".m4a")))
      {
        if (!bool) {
          break label263;
        }
        localObject1 = bndh.a(bndh.a());
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder().append("outputDir: ").append((String)localObject1);
        if (!new File((String)localObject1).exists()) {
          break label292;
        }
      }
      label263:
      label292:
      for (Object localObject2 = " exist";; localObject2 = " not exist")
      {
        bnzb.b(str, (String)localObject2);
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_JavaUtilTimer.schedule(new AEVideoShelfPreviewFragment.7(this), 0L, 200L);
        if (bqio.a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath(), this.jdField_f_of_type_JavaLangString, (String)localObject1, 0) == 0)
        {
          localObject2 = new File(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath());
          if (((File)localObject2).exists())
          {
            bnzb.b(jdField_a_of_type_JavaLangString, "finishAudioVideoMerge done");
            ((File)localObject2).delete();
          }
          this.jdField_b_of_type_JavaLangString = ((String)localObject1);
        }
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
        if ((!bool) || (this.jdField_b_of_type_JavaLangString == null)) {
          break;
        }
        zkr.a(BaseApplication.getContext(), new File(this.jdField_b_of_type_JavaLangString));
        return;
        localObject1 = bndh.a(bndt.jdField_e_of_type_JavaLangString + File.separator);
        break label76;
      }
    }
  }
  
  private void k()
  {
    bnzb.b(jdField_a_of_type_JavaLangString, "Merge Video step onStartGenerate");
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    bkgk.a(new AEVideoShelfPreviewFragment.8(this));
  }
  
  private void l()
  {
    bnzb.b(jdField_a_of_type_JavaLangString, "Merge Video step onCancelCompleted");
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        ((File)localObject).delete();
        bnzb.b(jdField_a_of_type_JavaLangString, "onCancelCompleted---delete temp video because user cancel");
      }
    }
    bkgk.a(new AEVideoShelfPreviewFragment.10(this));
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine == null) {}
      try
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine = new VideoShelfEngine(false);
        Object localObject = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine;
        if (localObject != null)
        {
          localObject = this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.getPlayer();
          if ((localObject instanceof PagShelfPlayer))
          {
            localObject = (PagShelfPlayer)localObject;
            this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setSrcPath(this.jdField_e_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setParam("PagVideoShelfProcessor_4", this.jdField_a_of_type_JavaUtilHashMap);
            this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setOutputVideoPath(ShortVideoUtils.c());
            this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setCallback(new bnwy(this));
            this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.save(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
            this.jdField_b_of_type_Boolean = true;
            return;
          }
        }
      }
      catch (PagNotSupportSystemException localPagNotSupportSystemException)
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine = null;
        bnzb.d(jdField_a_of_type_JavaLangString, localPagNotSupportSystemException.getMessage());
        bkgk.a(new AEVideoShelfPreviewFragment.11(this), 2000L);
      }
    }
  }
  
  public String a()
  {
    Bitmap localBitmap = a(this.jdField_b_of_type_JavaLangString, 300, 1);
    Object localObject = new File(bndt.jdField_d_of_type_JavaLangString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = bndt.jdField_d_of_type_JavaLangString + File.separator + Md5Utils.getMD5(this.jdField_b_of_type_JavaLangString) + ".jpg";
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(new File((String)localObject));
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
      localFileOutputStream.close();
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
    return null;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 22) {
      if (paramInt2 == -1)
      {
        b(paramIntent);
        a(paramIntent);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 21);
      bnyh.a().a(this.jdField_c_of_type_JavaLangString);
    } while (paramInt2 != -1);
    if ((bnqb.b(getActivity())) || (bnqb.d(getActivity().getIntent()))) {}
    for (paramIntent = new Intent(getActivity(), QzoneFeedsPluginProxyActivity.class);; paramIntent = new Intent(getActivity(), SplashActivity.class))
    {
      paramIntent.addFlags(67108864);
      paramIntent.addFlags(536870912);
      startActivity(paramIntent);
      return;
    }
  }
  
  public void onBackPressed()
  {
    getActivity().finish();
    bnyh.a().d();
  }
  
  public void onChangVideoSize(int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (bnyz.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363205: 
        onBackPressed();
        break;
      case 2131380537: 
        e();
        break;
      case 2131363896: 
        if (!this.jdField_a_of_type_Boolean)
        {
          g();
          this.jdField_c_of_type_Boolean = true;
          if (!this.jdField_b_of_type_Boolean) {
            m();
          } else {
            i();
          }
        }
        else
        {
          bpgu.a(getActivity(), this.jdField_b_of_type_JavaLangString, a(), bnqb.b(getActivity()), "caller_aecamera");
        }
        break;
      case 2131365789: 
        h();
        bnyh.a().e();
      }
    }
  }
  
  public void onCompletion()
  {
    if (this.jdField_b_of_type_Long > 0L) {}
    for (long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;; l = 0L)
    {
      this.jdField_b_of_type_Long = 0L;
      j();
      bkgk.a(new AEVideoShelfPreviewFragment.5(this, l));
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = true;
      bnzb.b(jdField_a_of_type_JavaLangString, "Merge Video step onCompletion");
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558495, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setOnPlayerListener(null);
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.stop();
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView = null;
    a(getActivity(), false);
    super.onDestroy();
  }
  
  public boolean onError(int paramInt, String paramString, Object paramObject)
  {
    int i = 1;
    if (-3 == paramInt) {
      return true;
    }
    paramObject = null;
    long l2 = -1L;
    if (this.jdField_e_of_type_JavaLangString != null) {
      paramObject = new File(this.jdField_e_of_type_JavaLangString);
    }
    long l1 = l2;
    if (paramObject != null)
    {
      l1 = l2;
      if (paramObject.exists())
      {
        l1 = l2;
        if (paramObject.isFile()) {
          l1 = paramObject.length();
        }
      }
    }
    if (this.jdField_e_of_type_JavaLangString == null) {}
    for (;;)
    {
      bnzb.d(jdField_a_of_type_JavaLangString, "Fun video videoShelfPlayView onError: what: " + paramInt + ", extra: " + paramString + ", FilePath: " + this.jdField_e_of_type_JavaLangString + ", FileSize: " + l1 + " dirInfo: " + i);
      return false;
      if (this.jdField_e_of_type_JavaLangString.contains(File.separator))
      {
        paramObject = this.jdField_e_of_type_JavaLangString.substring(0, this.jdField_e_of_type_JavaLangString.lastIndexOf(File.separator));
        if (new File(paramObject).exists())
        {
          if (DeviceUtils.canWriteFile(paramObject, false)) {
            i = 0;
          } else {
            i = 3;
          }
        }
        else {
          i = 2;
        }
      }
      else
      {
        i = -1;
      }
    }
  }
  
  public void onPause()
  {
    Log.i("VideoShelfPlayView", "onPause...");
    g();
    if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine != null) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.cancelSave();
      }
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
    }
    super.onPause();
  }
  
  public void onPrepared(IVideoShelfPlayer paramIVideoShelfPlayer)
  {
    if (paramIVideoShelfPlayer == null) {
      return;
    }
    paramIVideoShelfPlayer.setLooping(true);
    this.jdField_a_of_type_Int = 2;
  }
  
  public void onResume()
  {
    Log.i("VideoShelfPlayView", "onResume...");
    super.onResume();
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.flush();
    if (this.jdField_f_of_type_Boolean)
    {
      if ((2 == this.jdField_a_of_type_Int) || (1 == this.jdField_a_of_type_Int)) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.postDelayed(new AEVideoShelfPreviewFragment.4(this), 200L);
      }
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  public void onUpdateRate(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramLong + "(fps)");
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    a();
    paramView = getActivity().getIntent();
    if (paramView == null) {
      return;
    }
    b(paramView);
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment
 * JD-Core Version:    0.7.0.1
 */