package dov.com.qq.im.ae.play;

import aeow;
import aeox;
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
import bisa;
import bkyq;
import bmwf;
import bmwt;
import bnlb;
import bnqm;
import bnrf;
import bnrh;
import bove;
import bptd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import zeb;

public class AEVideoShelfPreviewFragment
  extends PublicBaseFragment
  implements aeox, View.OnClickListener, IVideoShelfPlayerListener
{
  private static final int AUDIO_UPDATE_PROGRESS_TIME = 200;
  public static final String FROM = "from";
  private static final long INTERVAL_UPDATE_PROGRESS = 200L;
  public static final String IS_NEED_EDIT_BTN = "isNeedEditButton";
  private static final double PROCESS_STEP = 0.3D;
  public static final int REQUEST_CODE_EDIT = 22;
  private static final int STATUS_NONE = 0;
  private static final int STATUS_PLAY = 2;
  private static final int STATUS_READY = 1;
  private static final String TAG = AEVideoShelfPreviewFragment.class.getSimpleName();
  private static final int VIDEO_DEFAULT_HEIGHT = 960;
  private static final int VIDEO_DEFAULT_WIDTH = 540;
  private static PowerManager.WakeLock wakeLock;
  private Button editButton;
  private boolean isFromNewVideo;
  private String mAudioPath;
  private volatile boolean mCancelGenerateByUser;
  private Dialog mDialog;
  private VideoShelfEngine mEngine;
  private long mGenerateBegin;
  private boolean mHadEncodedStart;
  private String mInputVideo;
  private boolean mIsFirstVideoPlay = true;
  private boolean mIsNeedEditBtn;
  private boolean mIsNeedShowdialog;
  private boolean mIsPagPreview;
  private boolean mIsVideoComplete;
  private int mJumpFrom;
  private long mLastUpdateProgressTimeMs;
  private String mMaterialId;
  private String mMaterialName;
  private int mOutVideoHeight;
  private int mOutVideoWidth;
  private HashMap<String, int[]> mPagSettings;
  private TextView mPlayerRateView;
  private double mSaveDialogProcessLowValue;
  private double mSaveDialogProgress;
  private ArrayList<String> mSelectedPhotoList;
  private String mTakeSameName;
  private String mTemplatePath;
  private Timer mTimer;
  private String mVideoPath;
  private View playButton;
  bisa ppd;
  private int status = 0;
  private View videoGroup;
  private VideoShelfPlayView videoView;
  
  private void bindData(Intent paramIntent)
  {
    VideoShelfPlayView localVideoShelfPlayView;
    if (this.mIsNeedEditBtn)
    {
      this.editButton.setVisibility(0);
      if (this.mJumpFrom == 2) {
        this.editButton.setVisibility(8);
      }
      localVideoShelfPlayView = this.videoView;
      if (this.mIsPagPreview) {
        break label95;
      }
    }
    boolean bool2;
    label95:
    for (boolean bool1 = true;; bool1 = false)
    {
      localVideoShelfPlayView.setVideoType(bool1);
      this.mIsVideoComplete = false;
      if (!this.mIsPagPreview) {
        break label100;
      }
      bool2 = pagFileInit(paramIntent);
      if (bool2) {
        this.videoView.start();
      }
      return;
      this.editButton.setVisibility(8);
      break;
    }
    label100:
    this.mInputVideo = paramIntent.getStringExtra("FinalVideoPath");
    if (!TextUtils.isEmpty(this.mInputVideo)) {}
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.videoView.setVideoFilePath(this.mInputVideo);
      this.mIsVideoComplete = true;
      this.mVideoPath = this.mInputVideo;
      bool2 = bool1;
      break;
    }
  }
  
  private bisa createProgressPie()
  {
    bisa localbisa = new bisa(getActivity());
    localbisa.a(AIOUtils.dp2px(50.0F, getActivity().getResources()));
    localbisa.a(true);
    localbisa.c(false);
    localbisa.g(-1);
    localbisa.f(0);
    localbisa.d(-15550475);
    localbisa.i(3);
    localbisa.jdField_f_of_type_Boolean = true;
    localbisa.jdField_f_of_type_Int = 2;
    localbisa.e(true);
    localbisa.a(new AEVideoShelfPreviewFragment.3(this));
    return localbisa;
  }
  
  private void dismissProgressDialog()
  {
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
  }
  
  private void finishAudioVideoMerge()
  {
    if (this.mEngine == null) {
      return;
    }
    if (this.mAudioPath != null) {}
    for (Object localObject1 = new File(this.mAudioPath);; localObject1 = null)
    {
      if (Build.VERSION.SDK_INT >= 23) {}
      for (boolean bool = AEVideoShelfEditFragment.hasStoragePermission(BaseApplicationImpl.getContext());; bool = true)
      {
        label87:
        String str;
        StringBuilder localStringBuilder;
        if ((localObject1 != null) && (((File)localObject1).exists()) && (this.mAudioPath != null) && (this.mAudioPath.toLowerCase().endsWith(".m4a")))
        {
          if (!bool) {
            break label274;
          }
          localObject1 = bmwf.a(bmwf.a());
          str = TAG;
          localStringBuilder = new StringBuilder().append("outputDir: ").append((String)localObject1);
          if (!new File((String)localObject1).exists()) {
            break label303;
          }
        }
        label274:
        label303:
        for (Object localObject2 = " exist";; localObject2 = " not exist")
        {
          bnrh.b(str, (String)localObject2);
          this.mTimer = new Timer();
          this.mTimer.schedule(new AEVideoShelfPreviewFragment.7(this), 0L, 200L);
          if (bptd.a(this.mEngine.getOutputVideoPath(), this.mAudioPath, (String)localObject1, 0) == 0)
          {
            localObject2 = new File(this.mEngine.getOutputVideoPath());
            if (((File)localObject2).exists())
            {
              bnrh.b(TAG, "finishAudioVideoMerge done");
              ((File)localObject2).delete();
            }
            this.mVideoPath = ((String)localObject1);
          }
          this.mTimer.cancel();
          this.mTimer = null;
          if ((!bool) || (this.mVideoPath == null)) {
            break;
          }
          zeb.a(BaseApplication.getContext(), new File(this.mVideoPath));
          return;
          localObject1 = bmwf.a(bmwt.e + File.separator);
          break label87;
        }
      }
    }
  }
  
  public static Bitmap getVideoThumbnail(String paramString, int paramInt1, int paramInt2)
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
  
  private void initData(Intent paramIntent)
  {
    this.mIsFirstVideoPlay = true;
    this.mJumpFrom = paramIntent.getIntExtra("jump_in_from", 0);
    this.mTemplatePath = paramIntent.getStringExtra("MaterialPath");
    this.mMaterialName = paramIntent.getStringExtra("MaterialName");
    this.mMaterialId = paramIntent.getStringExtra("MaterialId");
    if (TextUtils.isEmpty(this.mTakeSameName)) {
      this.mTakeSameName = paramIntent.getStringExtra("loc_play_show_take_same_name");
    }
    getActivity().getIntent().putExtra("key_camera_material_name", this.mTakeSameName);
    this.mSelectedPhotoList = paramIntent.getStringArrayListExtra("PhotoList");
    this.isFromNewVideo = paramIntent.getBooleanExtra("from", true);
    this.mIsNeedEditBtn = paramIntent.getBooleanExtra("isNeedEditButton", false);
    this.mIsPagPreview = paramIntent.getBooleanExtra("usePagPreview", false);
  }
  
  @TargetApi(14)
  private void initProgressDialog()
  {
    this.mDialog = new ReportDialog(getActivity());
    Object localObject = this.mDialog.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
      if (Build.VERSION.SDK_INT >= 14) {
        ((Window)localObject).setDimAmount(0.0F);
      }
    }
    this.mDialog.requestWindowFeature(1);
    this.mDialog.setContentView(2131561862);
    localObject = (ImageView)this.mDialog.findViewById(2131373219);
    this.ppd = createProgressPie();
    ((ImageView)localObject).setImageDrawable(this.ppd);
    ((TextView)this.mDialog.findViewById(2131371598)).setText(2131689785);
    this.mDialog.setCancelable(true);
    this.mDialog.setCanceledOnTouchOutside(false);
    this.mDialog.setOnCancelListener(new AEVideoShelfPreviewFragment.2(this));
    this.ppd.c(0);
  }
  
  private void initView()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getActivity().getWindow();
      if (localObject != null) {
        ((Window)localObject).setStatusBarColor(-16777216);
      }
    }
    this.mPlayerRateView = ((TextView)getActivity().findViewById(2131372953));
    this.mPlayerRateView.setText("0(fps)");
    this.mPlayerRateView.setTextColor(-65536);
    this.videoGroup = getActivity().findViewById(2131380789);
    this.videoGroup.setOnClickListener(this);
    this.videoView = ((VideoShelfPlayView)this.videoGroup.findViewById(2131380797));
    this.videoView.setOnPlayerListener(this);
    this.playButton = this.videoGroup.findViewById(2131372915);
    this.editButton = ((Button)getActivity().findViewById(2131365963));
    this.editButton.setOnClickListener(this);
    this.videoView.getViewTreeObserver().addOnGlobalLayoutListener(new AEVideoShelfPreviewFragment.1(this));
    getActivity().findViewById(2131363323).setOnClickListener(this);
    Object localObject = (TextView)getActivity().findViewById(2131364020);
    ((TextView)localObject).setOnClickListener(this);
    ((TextView)localObject).setText(2131689772);
    initProgressDialog();
  }
  
  private void jumpToEditFragment()
  {
    if (this.mJumpFrom == 2)
    {
      getActivity().finish();
      return;
    }
    AEVideoShelfEditFragment.jumpToMeForResult(getActivity(), 22, this.mTemplatePath, this.mMaterialId, this.mMaterialName, this.mSelectedPhotoList, 3);
  }
  
  public static void jumpToMe(Context paramContext, Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("jump_in_from", paramInt);
    aeow.a(paramContext, paramIntent, PublicFragmentActivityForPeak.class, AEVideoShelfPreviewFragment.class);
  }
  
  public static void keepScreenOn(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(536870922, TAG);
      wakeLock.acquire();
      bnrh.b(TAG, "keepScreenOn!");
      return;
    }
    if (wakeLock != null)
    {
      wakeLock.release();
      wakeLock = null;
    }
    bnrh.b(TAG, "keepScreenOff!");
  }
  
  private void onCancelCompleted()
  {
    bnrh.b(TAG, "Merge Video step onCancelCompleted");
    this.mGenerateBegin = 0L;
    this.mHadEncodedStart = false;
    this.mIsNeedShowdialog = false;
    Object localObject = this.mEngine.getOutputVideoPath();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        ((File)localObject).delete();
        bnrh.b(TAG, "onCancelCompleted---delete temp video because user cancel");
      }
    }
    bkyq.a(new AEVideoShelfPreviewFragment.10(this));
    this.mIsVideoComplete = false;
  }
  
  private void onError(int paramInt1, int paramInt2, String paramString)
  {
    bnrh.c(TAG, "Merge Video step onError");
    this.mGenerateBegin = 0L;
    onError(paramInt1, paramString, null);
    this.mHadEncodedStart = false;
    keepScreenOn(getActivity(), false);
  }
  
  private void onProgress(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.mLastUpdateProgressTimeMs > 200L)
    {
      bkyq.a(new AEVideoShelfPreviewFragment.9(this, paramInt));
      this.mLastUpdateProgressTimeMs = l;
    }
  }
  
  private void onStartGenerate()
  {
    bnrh.b(TAG, "Merge Video step onStartGenerate");
    this.mGenerateBegin = System.currentTimeMillis();
    bkyq.a(new AEVideoShelfPreviewFragment.8(this));
  }
  
  private boolean pagFileInit(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.videoView == null))
    {
      bnrh.c(TAG, "pagFileInit error");
      return false;
    }
    this.mInputVideo = paramIntent.getStringExtra("pagFilePath");
    this.mAudioPath = paramIntent.getStringExtra("audioFilePath");
    if (paramIntent.getBooleanExtra("isFromAsset", false))
    {
      if (!TextUtils.isEmpty(this.mAudioPath)) {
        this.videoView.setAudioPathFromAsset(this.mAudioPath, getActivity().getAssets());
      }
      if (!TextUtils.isEmpty(this.mInputVideo)) {
        this.videoView.setVideoFilePathFromAsset(this.mInputVideo, getActivity().getAssets());
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
          this.mPagSettings = ((HashMap)localObject);
          this.videoView.setParam("imgGroup", new Object[] { this.mPagSettings });
        }
      }
      this.mOutVideoWidth = paramIntent.getIntExtra("videoOutWidth", 540);
      this.mOutVideoHeight = paramIntent.getIntExtra("videoOutHeight", 960);
      return true;
      bnrh.c(TAG, "pagFileInit Asset Path error");
      return false;
      if (!TextUtils.isEmpty(this.mAudioPath)) {
        this.videoView.setAudioPath(this.mAudioPath);
      }
      if (TextUtils.isEmpty(this.mInputVideo)) {
        break;
      }
      this.videoView.setVideoFilePath(this.mInputVideo);
    }
    bnrh.c(TAG, "pagFileInit not Asset Path error");
    return false;
  }
  
  private void pauseVideo()
  {
    this.status = 1;
    this.videoView.pause();
    this.playButton.setVisibility(0);
    this.mPlayerRateView.setText("0(fps)");
  }
  
  private void playVideo()
  {
    this.status = 2;
    this.videoView.resume();
    this.playButton.setVisibility(8);
  }
  
  private void saveVideoTemplate()
  {
    if (this.videoView == null) {}
    for (;;)
    {
      return;
      if (this.mEngine == null) {}
      try
      {
        this.mEngine = new VideoShelfEngine(false);
        Object localObject = this.mEngine;
        if (localObject != null)
        {
          localObject = this.videoView.getPlayer();
          if ((localObject instanceof PagShelfPlayer))
          {
            localObject = (PagShelfPlayer)localObject;
            this.mEngine.setSrcPath(this.mInputVideo);
            this.mEngine.setParam("PagVideoShelfProcessor_4", this.mPagSettings);
            this.mEngine.setOutputVideoPath(ShortVideoUtils.getLocalShortVideoPath());
            this.mEngine.setCallback(new AEVideoShelfPreviewFragment.EngineCallback(this));
            this.mEngine.save(this.mOutVideoWidth, this.mOutVideoHeight);
            this.mHadEncodedStart = true;
            return;
          }
        }
      }
      catch (PagNotSupportSystemException localPagNotSupportSystemException)
      {
        this.mEngine = null;
        bnrh.d(TAG, localPagNotSupportSystemException.getMessage());
        bkyq.a(new AEVideoShelfPreviewFragment.11(this), 2000L);
      }
    }
  }
  
  private void showDialogIfNeed()
  {
    bkyq.a(new AEVideoShelfPreviewFragment.6(this));
  }
  
  private void showProgressDialog()
  {
    if (this.mDialog != null) {
      this.mDialog.show();
    }
  }
  
  private void toggleVideoStatus()
  {
    if (2 == this.status)
    {
      pauseVideo();
      return;
    }
    playVideo();
  }
  
  private void updateProgress(int paramInt)
  {
    if (this.ppd == null) {
      return;
    }
    this.ppd.a();
    this.ppd.c(paramInt);
    this.ppd.b(true);
    this.ppd.d(false);
    this.ppd.a(paramInt + "%");
  }
  
  public String getThumbPath()
  {
    Bitmap localBitmap = getVideoThumbnail(this.mVideoPath, 300, 1);
    Object localObject = new File(bmwt.d);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = bmwt.d + File.separator + Md5Utils.getMD5(this.mVideoPath) + ".jpg";
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
        initData(paramIntent);
        bindData(paramIntent);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 21);
      bnqm.a().a(this.mMaterialId);
    } while (paramInt2 != -1);
    if ((bnlb.b(getActivity())) || (bnlb.d(getActivity().getIntent()))) {}
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
    bnqm.a().d();
  }
  
  public void onChangVideoSize(int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (bnrf.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363323: 
        onBackPressed();
        break;
      case 2131380789: 
        toggleVideoStatus();
        break;
      case 2131364020: 
        if (!this.mIsVideoComplete)
        {
          pauseVideo();
          this.mIsNeedShowdialog = true;
          if (!this.mHadEncodedStart) {
            saveVideoTemplate();
          } else {
            showDialogIfNeed();
          }
        }
        else
        {
          bove.a(getActivity(), this.mVideoPath, getThumbPath(), bnlb.b(getActivity()), "caller_aecamera");
        }
        break;
      case 2131365963: 
        jumpToEditFragment();
        bnqm.a().e();
      }
    }
  }
  
  public void onCompletion()
  {
    if (this.mGenerateBegin > 0L) {}
    for (long l = System.currentTimeMillis() - this.mGenerateBegin;; l = 0L)
    {
      this.mGenerateBegin = 0L;
      finishAudioVideoMerge();
      bkyq.a(new AEVideoShelfPreviewFragment.5(this, l));
      this.mHadEncodedStart = false;
      this.mIsVideoComplete = true;
      bnrh.b(TAG, "Merge Video step onCompletion");
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558506, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.mPagSettings != null) {
      this.mPagSettings.clear();
    }
    if (this.mSelectedPhotoList != null) {
      this.mSelectedPhotoList.clear();
    }
    this.videoView.setOnPlayerListener(null);
    this.videoView.stop();
    this.videoView = null;
    keepScreenOn(getActivity(), false);
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
    if (this.mInputVideo != null) {
      paramObject = new File(this.mInputVideo);
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
    if (this.mInputVideo == null) {}
    for (;;)
    {
      bnrh.d(TAG, "Fun video videoShelfPlayView onError: what: " + paramInt + ", extra: " + paramString + ", FilePath: " + this.mInputVideo + ", FileSize: " + l1 + " dirInfo: " + i);
      return false;
      if (this.mInputVideo.contains(File.separator))
      {
        paramObject = this.mInputVideo.substring(0, this.mInputVideo.lastIndexOf(File.separator));
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
    pauseVideo();
    if ((this.mHadEncodedStart) || (!this.mIsVideoComplete))
    {
      if (this.mEngine != null) {
        this.mEngine.cancelSave();
      }
      this.mHadEncodedStart = false;
      this.mIsNeedShowdialog = false;
    }
    super.onPause();
  }
  
  public void onPrepared(IVideoShelfPlayer paramIVideoShelfPlayer)
  {
    if (paramIVideoShelfPlayer == null) {
      return;
    }
    paramIVideoShelfPlayer.setLooping(true);
    this.status = 2;
  }
  
  public void onResume()
  {
    Log.i("VideoShelfPlayView", "onResume...");
    super.onResume();
    this.videoView.flush();
    if (this.mIsFirstVideoPlay)
    {
      if ((2 == this.status) || (1 == this.status)) {
        this.videoView.postDelayed(new AEVideoShelfPreviewFragment.4(this), 200L);
      }
      this.mIsFirstVideoPlay = false;
    }
  }
  
  public void onUpdateRate(long paramLong)
  {
    this.mPlayerRateView.setText(paramLong + "(fps)");
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    initView();
    paramView = getActivity().getIntent();
    if (paramView == null) {
      return;
    }
    initData(paramView);
    bindData(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment
 * JD-Core Version:    0.7.0.1
 */