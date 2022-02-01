package dov.com.qq.im.ae.play;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.offlineset.OfflineFileUpdater;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.VideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeGroup;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import com.tencent.ttpic.videoshelf.parser.TemplateParser;
import dov.com.qq.im.ae.AEPath.PLAY.CACHE;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.entry.AECameraLauncher;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEFastClickThrottle;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.PicChooseJumpUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.light.device.OfflineConfig;

public class AETemplateInfoFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, PublicFragmentActivityCallBackInterface
{
  public static final String CACHE_DIR = AEPath.PLAY.CACHE.b;
  public static final String PREFERENCE_K_QUDONG_LAST_CRAZY_FACE_PHOTO = "ae_preference_k_qudong_last_crazy_face_photo";
  public static final int REQUEST_CODE_TAKE_FACE_PHOTO = 1024;
  private static final String TAG = "AETemplateInfoFragment";
  private List<String> crazyFaceMaterials;
  private boolean isCrazyFace;
  private ArrayList<String> mCropPhotoCacheList = new ArrayList();
  private boolean mHasTextNode = false;
  private boolean mIsEnglish = false;
  private boolean mIsSimpleChinese = true;
  private ImageView mLastImg;
  private ViewGroup mLastLayout;
  private Bitmap mLastPhoto;
  private String mLastPhotoPath;
  private Dialog mLoadingDialog;
  private String mMaterialId;
  private String mMaterialName;
  private String mMaterialPath;
  private boolean mNeedPlayVideo = true;
  private TextView mNextButton;
  private List<NodeGroup> mNodeGroupList = new ArrayList();
  private FrameLayout mPlayerContainer;
  private AETemplateInfoFragment.PlayerListener mPlayerListener;
  private TextView mPlayerRateView;
  private ArrayList<String> mSelectedPhotoList;
  private boolean mSurfaceReady = false;
  private String mTakeSameName;
  private VideoShelfTemplate mTemplate;
  private TextView mTipsTextView;
  private TextView mTitleTextView;
  private IVideoShelfPlayer mVideoPlayer;
  private int mVideoPosition;
  private TextureView mVideoView;
  private String playShowTabName = "";
  private ImageView playerStatusView;
  private int screenHeight;
  private int screenWidth;
  private Dialog tipDialog;
  
  static
  {
    File localFile = new File(CACHE_DIR);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private String buildTips(VideoShelfTemplate paramVideoShelfTemplate)
  {
    int i = 0;
    if (paramVideoShelfTemplate == null) {}
    Object localObject1;
    do
    {
      return "";
      localObject1 = paramVideoShelfTemplate.getTipTemplate();
    } while ((localObject1 == null) || (localObject1.length == 0));
    int j = localObject1[0];
    Object localObject2 = getResources();
    paramVideoShelfTemplate = "";
    if (localObject2 != null) {
      paramVideoShelfTemplate = String.format("需选择%d张图片", new Object[] { Integer.valueOf(j) });
    }
    if (j == 0) {
      paramVideoShelfTemplate = "";
    }
    if (localObject1.length > 1) {
      i = localObject1[1];
    }
    if (i > 0)
    {
      localObject1 = "可修改文字";
      if ((TextUtils.isEmpty(paramVideoShelfTemplate)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!this.mIsEnglish)) {
        break label147;
      }
    }
    label147:
    for (localObject2 = " ";; localObject2 = "")
    {
      return paramVideoShelfTemplate + (String)localObject2 + (String)localObject1;
      localObject1 = "";
      break;
    }
  }
  
  private void cancelTipDialog()
  {
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
  }
  
  private void changeFace(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.crazyFaceMaterials == null) || (this.crazyFaceMaterials.isEmpty())) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = BitmapUtils.decodeSampleBitmap(getActivity(), paramString, this.screenWidth, this.screenHeight);
    } while (localBitmap == null);
    AECameraPrefsUtil.a().a("ae_preference_k_qudong_last_crazy_face_photo", paramString, 0);
    showLoading(true);
    long l = System.currentTimeMillis();
    this.mNeedPlayVideo = false;
    pauseVideo();
    FaceChangeUtils.change(localBitmap, this.crazyFaceMaterials, new AETemplateInfoFragment.5(this, paramString, localBitmap, l));
  }
  
  private String cropHeadOfImage(String paramString)
  {
    Object localObject1 = new File(paramString);
    Object localObject2 = new File(AEPath.PLAY.CACHE.a);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    String str = ((File)localObject2).getPath() + File.separator + "crop_" + ((File)localObject1).getName();
    localObject1 = BitmapUtils.decodeSampleBitmap(getActivity(), paramString, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
    if (!BitmapUtils.isLegal((Bitmap)localObject1)) {}
    do
    {
      return paramString;
      localObject2 = VideoShelfBitmapUtils.rotateWithExif((Bitmap)localObject1, paramString);
      localObject1 = localObject2;
      if (((Bitmap)localObject2).getWidth() == 1)
      {
        localObject1 = localObject2;
        if (((Bitmap)localObject2).getHeight() == 1) {
          localObject1 = BitmapUtils.scaleBitmap((Bitmap)localObject2, 2.0F, true);
        }
      }
      localObject2 = new boolean[1];
      localObject2[0] = 0;
      FaceChangeUtils.cropFace((Bitmap)localObject1, new AETemplateInfoFragment.4(this, (boolean[])localObject2, str), true);
    } while (localObject2[0] == 0);
    return str;
  }
  
  public static int dp2px(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int getFromType(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return ((Activity)paramContext).getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    }
    return AECameraEntry.a.a();
  }
  
  private void initData()
  {
    this.screenWidth = DisplayUtil.a(getActivity());
    this.screenHeight = DisplayUtil.b(getActivity());
    Intent localIntent = getActivity().getIntent();
    if (localIntent != null)
    {
      this.mMaterialPath = localIntent.getStringExtra("MaterialPath");
      this.mMaterialId = localIntent.getStringExtra("MaterialId");
      this.mMaterialName = localIntent.getStringExtra("MaterialName");
      this.playShowTabName = localIntent.getStringExtra("loc_play_show_tab_name");
      this.mTakeSameName = localIntent.getStringExtra("loc_play_show_take_same_name");
    }
    if ((this.mTemplate == null) && (!TextUtils.isEmpty(this.mMaterialPath))) {
      loadTemplate(this.mMaterialPath);
    }
    if (this.mTemplate != null)
    {
      this.crazyFaceMaterials = this.mTemplate.getCrazyFaceList();
      if ((this.crazyFaceMaterials == null) || (this.crazyFaceMaterials.isEmpty())) {
        break label255;
      }
    }
    label255:
    for (boolean bool = true;; bool = false)
    {
      this.isCrazyFace = bool;
      if (this.isCrazyFace)
      {
        this.mLastPhotoPath = AECameraPrefsUtil.a().a("ae_preference_k_qudong_last_crazy_face_photo", null, 0);
        if (!TextUtils.isEmpty(this.mLastPhotoPath))
        {
          int i = getActivity().getResources().getDimensionPixelSize(2131296381);
          int j = getActivity().getResources().getDimensionPixelSize(2131296382);
          this.mLastPhoto = BitmapUtils.decodeSampleBitmap(getActivity(), this.mLastPhotoPath, j, i);
        }
      }
      OfflineFileUpdater.setHttpClient(new UrlConHttpClient());
      OfflineFileUpdater.checkOfflineFile();
      return;
    }
  }
  
  private void initNodeGroup()
  {
    if (this.mTemplate == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mTemplate.getNodeGroupList().size())
      {
        Object localObject = (MaskNodeGroup)this.mTemplate.getNodeGroupList().get(i);
        NodeGroup localNodeGroup = new NodeGroup();
        localNodeGroup.nodeGroupID = ((MaskNodeGroup)localObject).getNodeGroupID();
        localObject = ((MaskNodeGroup)localObject).getNodeList();
        localNodeGroup.nodeItemList = new ArrayList();
        int j = 0;
        while (j < ((List)localObject).size())
        {
          MaskNodeItem localMaskNodeItem = (MaskNodeItem)((List)localObject).get(j);
          NodeItem localNodeItem = new NodeItem();
          localNodeItem.nodeID = localMaskNodeItem.getNodeID();
          localNodeItem.type = localMaskNodeItem.getType();
          localNodeItem.nodeGroupID = localMaskNodeItem.getNodeGroupID();
          localNodeItem.zIndex = localMaskNodeItem.getZIndex();
          localNodeItem.indexLayerForPag = localMaskNodeItem.getIndexLayerForPag();
          localNodeGroup.nodeItemList.add(localNodeItem);
          j += 1;
        }
        this.mNodeGroupList.add(localNodeGroup);
        i += 1;
      }
    }
  }
  
  private void initView()
  {
    View localView = getView();
    this.mNextButton = ((TextView)localView.findViewById(2131372251));
    this.mLastImg = ((ImageView)localView.findViewById(2131368943));
    this.mLastLayout = ((ViewGroup)localView.findViewById(2131370138));
    this.mNextButton.setOnClickListener(this);
    this.mLastLayout.setOnClickListener(this);
    this.mTitleTextView = ((TextView)localView.findViewById(2131379432));
    this.mTipsTextView = ((TextView)localView.findViewById(2131379394));
    this.mPlayerRateView = ((TextView)localView.findViewById(2131373279));
    if (isDebugVersion())
    {
      this.mPlayerRateView.setVisibility(0);
      this.mPlayerRateView.setText("0(fps)");
      this.mPlayerRateView.setTextColor(-65536);
    }
    this.playerStatusView = ((ImageView)localView.findViewById(2131373280));
    this.mVideoView = ((TextureView)localView.findViewById(2131373463));
    this.mVideoView.setKeepScreenOn(true);
    this.mPlayerContainer = ((FrameLayout)localView.findViewById(2131373266));
    this.mPlayerContainer.getViewTreeObserver().addOnGlobalLayoutListener(new AETemplateInfoFragment.1(this));
    this.mVideoView.setOnClickListener(this);
    this.mVideoView.setSurfaceTextureListener(new AETemplateInfoFragment.PlayerSurfaceTextureCallback(this));
    this.mPlayerListener = new AETemplateInfoFragment.PlayerListener(this);
    if (this.isCrazyFace)
    {
      if (this.mLastPhoto != null)
      {
        this.mLastLayout.setVisibility(0);
        this.mLastImg.setImageBitmap(this.mLastPhoto);
        this.mNextButton.setTextColor(-16777216);
        this.mNextButton.setBackgroundResource(2130837704);
        this.mNextButton.setText(2131689818);
        this.mTipsTextView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.mTipsTextView.setText(2131689815);
    this.mTipsTextView.setVisibility(0);
  }
  
  private boolean isDebugVersion()
  {
    return false;
  }
  
  private boolean isNeedRealTimePlay()
  {
    boolean bool = true;
    if (this.mTemplate == null) {
      return false;
    }
    if ((this.mTemplate.getPagFileName() != null) && (this.mTemplate.getPagFilePath() != null) && (this.mTemplate.getPreviewVideoType() == 1) && (!OfflineConfig.isNotSuptPagRealTime())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void jumpToEdit()
  {
    if (this.mTemplate == null) {
      return;
    }
    AEVideoShelfEditFragment.jumpToMe(getActivity(), this.playShowTabName, this.mTemplate.getMaterialPath(), this.mMaterialId, this.mTemplate.getVideoName(), this.mSelectedPhotoList, 1, this.mTakeSameName);
  }
  
  public static void jumpToMe(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString2);
    localIntent.putExtra("MaterialId", paramString3);
    localIntent.putExtra("MaterialName", paramString4);
    localIntent.putExtra("loc_play_show_tab_name", paramString1);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", getFromType(paramContext));
    localIntent.putExtra("loc_play_show_take_same_name", paramString5);
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivityForPeak.class, AETemplateInfoFragment.class);
  }
  
  private void jumpToPagRealtimePreview(boolean paramBoolean)
  {
    int i = 0;
    Log.i("AETemplateInfoFragment", "未合成视频，将直接实时预览。");
    AEQLog.b("AETemplateInfoFragment", "未合成视频，将直接实时预览。");
    if (this.mTemplate == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("from", true);
    HashMap localHashMap;
    Iterator localIterator1;
    if (!paramBoolean)
    {
      paramBoolean = true;
      localIntent.putExtra("isNeedEditButton", paramBoolean);
      localIntent.putExtra("usePagPreview", true);
      localIntent.putExtra("videoOutWidth", this.mTemplate.getVideoWidth());
      localIntent.putExtra("videoOutHeight", this.mTemplate.getVideoHeight());
      localIntent.putExtra("pagFilePath", this.mTemplate.getPagFilePath());
      localIntent.putExtra("audioFilePath", this.mTemplate.getAudioPath());
      localIntent.putExtra("MaterialPath", this.mTemplate.getMaterialPath());
      localIntent.putExtra("MaterialName", this.mTemplate.getVideoName());
      localIntent.putExtra("loc_play_show_tab_name", this.playShowTabName);
      localIntent.putExtra("loc_play_show_material_id", this.mMaterialId);
      localIntent.putExtra("loc_play_show_take_same_name", this.mTakeSameName);
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", getFromType(getActivity()));
      localIntent.putStringArrayListExtra("PhotoList", this.mSelectedPhotoList);
      localIntent.putExtra("MaterialId", this.mMaterialId);
      initNodeGroup();
      localHashMap = new HashMap();
      localIterator1 = this.mNodeGroupList.iterator();
    }
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label416;
      }
      Iterator localIterator2 = ((NodeGroup)localIterator1.next()).nodeItemList.iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          NodeItem localNodeItem = (NodeItem)localIterator2.next();
          if ((this.mSelectedPhotoList != null) && (i < this.mSelectedPhotoList.size()))
          {
            localObject = (String)this.mSelectedPhotoList.get(i);
            if (localNodeItem.type == 2)
            {
              localObject = cropHeadOfImage((String)this.mSelectedPhotoList.get(i));
              this.mCropPhotoCacheList.add(localObject);
            }
            localHashMap.put(localObject, localNodeItem.indexLayerForPag);
            i += 1;
            continue;
            paramBoolean = false;
            break;
          }
        }
      }
    }
    label416:
    Object localObject = new Bundle();
    ((Bundle)localObject).putSerializable("nodeImgList", localHashMap);
    localIntent.putExtras((Bundle)localObject);
    AEVideoShelfPreviewFragment.jumpToMe(getActivity(), localIntent, 1);
  }
  
  private void loadTemplate(String paramString)
  {
    try
    {
      if (this.mTemplate == null) {
        this.mTemplate = TemplateParser.parse(getActivity(), paramString);
      }
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      AEQLog.c("AETemplateInfoFragment", "loadTemplate Error!");
    }
  }
  
  private void onNext()
  {
    int i1 = 1;
    if ((this.mTemplate == null) || (TextUtils.isEmpty(this.mTemplate.getMaterialPath())))
    {
      AEQLog.c("AETemplateInfoFragment", "onNext template Error!");
      return;
    }
    if (this.isCrazyFace)
    {
      startTakeFacePhotoNext();
      return;
    }
    int k = 0;
    int j = 0;
    int m;
    for (int i = 0; k < this.mTemplate.getNodeGroupList().size(); i = m)
    {
      int n = j;
      m = i;
      if (this.mTemplate.getNodeGroupList().get(k) != null)
      {
        n = j;
        m = i;
        if (((MaskNodeGroup)this.mTemplate.getNodeGroupList().get(k)).getNodeList() != null)
        {
          m = 0;
          if (m < ((MaskNodeGroup)this.mTemplate.getNodeGroupList().get(k)).getNodeList().size())
          {
            if (((MaskNodeItem)((MaskNodeGroup)this.mTemplate.getNodeGroupList().get(k)).getNodeList().get(m)).getType() != 1) {
              i += 1;
            }
            for (;;)
            {
              m += 1;
              break;
              j += 1;
            }
          }
          m = i;
          n = j;
        }
      }
      k += 1;
      j = n;
    }
    boolean bool;
    if (j > 0)
    {
      bool = true;
      this.mHasTextNode = bool;
      if ((j <= 0) || (i != 0)) {
        break label262;
      }
    }
    label262:
    for (j = i1;; j = 0)
    {
      if (j == 0) {
        break label267;
      }
      jumpToEdit();
      return;
      bool = false;
      break;
    }
    label267:
    startAlumNext(i);
  }
  
  private void onPlayError()
  {
    AEQLog.c("AETemplateInfoFragment", "onPlayError!");
  }
  
  private void pauseVideo()
  {
    if (this.mVideoPlayer != null)
    {
      if (this.mVideoPlayer.isPlaying())
      {
        this.mVideoPlayer.pause();
        QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---pauseVideo done");
        videoViewStatusPause();
        return;
      }
      QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---pauseVideo enter, mVideoPlayer is not playing");
      return;
    }
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---pauseVideo enter, mVideoPlayer is null");
  }
  
  private void playVideo()
  {
    if ((this.mTemplate == null) || (this.mVideoPlayer == null)) {
      return;
    }
    this.mVideoPlayer.reset();
    this.mVideoPlayer.setVideoShelfPlayerListener(this.mPlayerListener);
    String str2 = this.mTemplate.getPreviewVideoPath();
    String str1 = null;
    if ((this.mVideoPlayer instanceof PagShelfPlayer))
    {
      str2 = this.mTemplate.getPagFilePath();
      str1 = this.mTemplate.getAudioPath();
    }
    if (this.mTemplate.isFromAssets())
    {
      this.mVideoPlayer.setDataSource(getActivity().getAssets(), str2);
      if ((str1 != null) && (FileUtils.exists(str1))) {
        this.mVideoPlayer.setParam("pagShelfPlayerAudioFilePath", new Object[] { Boolean.valueOf(true), getActivity().getAssets(), str1 });
      }
    }
    for (;;)
    {
      this.mVideoPlayer.prepare();
      this.mVideoPlayer.seekTo(this.mVideoPosition);
      if (!this.mNeedPlayVideo) {
        break;
      }
      this.mVideoPlayer.start();
      QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---mVideoPlayer.start() in playVideo");
      return;
      this.mVideoPlayer.setDataSource(str2);
      if ((str1 != null) && (FileUtils.exists(str1))) {
        this.mVideoPlayer.setParam("pagShelfPlayerAudioFilePath", new Object[] { Boolean.valueOf(false), str1 });
      }
    }
  }
  
  private void popNotSupportPagToast(String paramString) {}
  
  private void previewTemplate()
  {
    if (this.mTemplate != null)
    {
      showTemplate();
      playVideo();
    }
  }
  
  private void resumeVideoToStart()
  {
    if (this.mVideoPlayer != null) {
      onPlayComplete();
    }
  }
  
  public static void sendPickedPhotosToMe(Context paramContext, Intent paramIntent)
  {
    paramIntent.addFlags(67108864);
    paramIntent.addFlags(536870912);
    paramIntent.putExtra("VIDEO_STORY_FROM_TYPE", getFromType(paramContext));
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, PublicFragmentActivityForPeak.class, AETemplateInfoFragment.class);
  }
  
  private void showFirstEntryTipDialog()
  {
    if (this.tipDialog != null) {
      if (this.tipDialog.isShowing()) {
        this.tipDialog.dismiss();
      }
    }
    for (;;)
    {
      if (!this.tipDialog.isShowing()) {
        this.tipDialog.show();
      }
      return;
      this.tipDialog = new ReportDialog(getActivity(), 2131755842);
      this.tipDialog.setCancelable(true);
      this.tipDialog.setCanceledOnTouchOutside(true);
      this.tipDialog.setContentView(2131558529);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getActivity().getResources().getDrawable(2131167374);
      localObject = URLDrawable.getDrawable("https://dl.url.cn/myapp/qq_desk/qqrm/videofilter/Pturenwu/tipss.png", (URLDrawable.URLDrawableOptions)localObject);
      URLImageView localURLImageView = (URLImageView)this.tipDialog.findViewById(2131369473);
      TextView localTextView = (TextView)this.tipDialog.findViewById(2131380159);
      localURLImageView.setImageDrawable((Drawable)localObject);
      this.tipDialog.show();
      localTextView.setOnClickListener(new AETemplateInfoFragment.3(this));
    }
  }
  
  private void showLoading(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      if (!paramBoolean) {
        break label76;
      }
      if (this.mLoadingDialog == null)
      {
        this.mLoadingDialog = new ReportDialog(localFragmentActivity, 2131755842);
        this.mLoadingDialog.setCancelable(false);
        this.mLoadingDialog.setCanceledOnTouchOutside(false);
        this.mLoadingDialog.setContentView(2131559683);
      }
      this.mLoadingDialog.show();
    }
    label76:
    while ((this.mLoadingDialog == null) || (!this.mLoadingDialog.isShowing())) {
      return;
    }
    this.mLoadingDialog.dismiss();
  }
  
  private void showTemplate()
  {
    if (this.mIsSimpleChinese)
    {
      this.mTitleTextView.setText(this.mTemplate.getName());
      this.mTipsTextView.setText(this.mTemplate.getTip());
      return;
    }
    this.mTitleTextView.setText(this.mMaterialName);
    getActivity().findViewById(2131365682).setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mTipsTextView.getLayoutParams();
    this.mTipsTextView.setLines(2);
    localLayoutParams.height = ((int)(32.0F * this.mTipsTextView.getContext().getResources().getDisplayMetrics().density));
    this.mTipsTextView.setLayoutParams(localLayoutParams);
    this.mTipsTextView.setText(buildTips(this.mTemplate));
  }
  
  private void startAlumNext(int paramInt)
  {
    PicChooseJumpUtil.a(getActivity(), paramInt);
  }
  
  private void startPreviewNext()
  {
    showLoading(true);
    jumpToPagRealtimePreview(false);
    showLoading(false);
  }
  
  private void startTakeFacePhotoNext()
  {
    if (!isNeedRealTimePlay())
    {
      QQToast.a(getActivity(), getActivity().getString(2131689808), 0).a();
      return;
    }
    if (AECameraPrefsUtil.a().a("key_first_change_face_click_flag", true, 0))
    {
      AECameraPrefsUtil.a().a("key_first_change_face_click_flag", false, 0);
      showFirstEntryTipDialog();
      return;
    }
    AECameraLauncher.a(getActivity(), 1024, AECameraEntry.I.a(), null);
  }
  
  private void stopVideo()
  {
    if (this.mVideoPlayer != null)
    {
      if (this.mVideoPlayer.isPlaying())
      {
        this.mVideoPlayer.stop();
        QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---stopVideo done");
      }
      try
      {
        for (;;)
        {
          this.mVideoPlayer.setSurface(null);
          this.mVideoPosition = this.mVideoPlayer.getCurrentPosition();
          videoViewStatusPause();
          this.mNeedPlayVideo = false;
          this.mVideoPlayer = null;
          return;
          QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---stopVideo enter, mVideoPlayer is not playing");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AEQLog.a("AETemplateInfoFragment", "mVideoPlayer.setSurface(null) raise exception: ", localException);
        }
      }
    }
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---stopVideo enter, mVideoPlayer is null");
  }
  
  private void surfaceTextureAvailable(SurfaceTexture paramSurfaceTexture)
  {
    int j = 1;
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---surfaceTextureAvailable");
    this.mSurfaceReady = true;
    if ((this.mTemplate == null) && (!TextUtils.isEmpty(this.mMaterialPath))) {
      loadTemplate(this.mMaterialPath);
    }
    label164:
    for (;;)
    {
      try
      {
        if (this.mVideoPlayer == null)
        {
          if ((this.mTemplate == null) || (this.mTemplate.getVersion() != 1)) {
            break label164;
          }
          i = j;
          if (this.mTemplate.getPreviewVideoPath() != null)
          {
            if (FileUtils.exists(this.mTemplate.getPreviewVideoPath())) {
              break label164;
            }
            i = j;
          }
          if (i != 0)
          {
            localObject = new PagShelfPlayer();
            this.mVideoPlayer = ((IVideoShelfPlayer)localObject);
          }
        }
        else
        {
          this.mVideoPlayer.setSurface(new Surface(paramSurfaceTexture));
          previewTemplate();
          return;
        }
        Object localObject = new VideoShelfPlayer();
        continue;
        int i = 0;
      }
      catch (PagNotSupportSystemException paramSurfaceTexture)
      {
        AEQLog.d("AETemplateInfoFragment", paramSurfaceTexture.getMessage());
        popNotSupportPagToast("pag版本过低");
        return;
      }
    }
  }
  
  private void surfaceTextureDestroyed()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---surfaceTextureDestroyed");
    this.mSurfaceReady = false;
    stopVideo();
  }
  
  private void toastInUIThread(String paramString)
  {
    getActivity().runOnUiThread(new AETemplateInfoFragment.6(this, paramString));
  }
  
  private void toggleVideoStatus()
  {
    if (this.mVideoPlayer != null)
    {
      if (this.mVideoPlayer.isPlaying())
      {
        this.mVideoPlayer.pause();
        videoViewStatusPause();
      }
    }
    else {
      return;
    }
    this.mNeedPlayVideo = true;
    this.mVideoPlayer.start();
    videoViewStatusPlay();
  }
  
  private void videoViewStatusPause()
  {
    this.playerStatusView.setVisibility(0);
  }
  
  private void videoViewStatusPlay()
  {
    this.playerStatusView.setVisibility(8);
  }
  
  public int getContentLayoutId()
  {
    return 2131558513;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1024) && (paramInt2 == -1)) {
      changeFace(paramIntent.getExtras().getString("take_photo_path"));
    }
  }
  
  public void onBackPressed()
  {
    getActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    if (AEFastClickThrottle.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364248: 
        onBackPressed();
        break;
      case 2131372251: 
        onNext();
        if (!this.isCrazyFace) {
          AEBaseDataReporter.a().M();
        } else {
          AEBaseDataReporter.a().N();
        }
        break;
      case 2131370138: 
        changeFace(this.mLastPhotoPath);
        AEBaseDataReporter.a().O();
        break;
      case 2131373463: 
        toggleVideoStatus();
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onDestroy");
    stopVideo();
    super.onDestroy();
    cancelTipDialog();
    BitmapUtils.recycle(this.mLastPhoto);
    Iterator localIterator = this.mCropPhotoCacheList.iterator();
    while (localIterator.hasNext()) {
      FileUtils.delete((String)localIterator.next());
    }
    if (QLog.isDebugVersion()) {
      QLog.d("AETemplateInfoFragment", 4, "submit clear temp files task");
    }
    ThreadManagerV2.excute(new AETemplateInfoFragment.2(this), 64, null, false);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent == null) {}
    while (paramIntent.getIntExtra("pic_result_back_type", -1) != 0) {
      return;
    }
    this.mSelectedPhotoList = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
    if ((isNeedRealTimePlay()) && (!this.mHasTextNode))
    {
      startPreviewNext();
      return;
    }
    jumpToEdit();
  }
  
  public void onPause()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onPause");
    super.onPause();
    this.mNeedPlayVideo = false;
    pauseVideo();
  }
  
  public void onPlayComplete()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onPlayComplete");
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.seekTo(0);
    }
    videoViewStatusPause();
    this.mNeedPlayVideo = false;
    if (isDebugVersion()) {
      this.mPlayerRateView.setText("0(fps)");
    }
  }
  
  public void onResume()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onResume");
    super.onResume();
    resumeVideoToStart();
  }
  
  public void onUpdateRate(long paramLong)
  {
    if (isDebugVersion()) {
      this.mPlayerRateView.setText(paramLong + "(fps)");
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.vg.setTitle("模板详情");
    if (!FeatureManager.Features.PAG.init())
    {
      AEQLog.d("AETemplateInfoFragment", "pag相关so未初始化成功");
      QQToast.a(getActivity(), "pag相关so未初始化成功", 0).a();
      return;
    }
    initData();
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETemplateInfoFragment
 * JD-Core Version:    0.7.0.1
 */