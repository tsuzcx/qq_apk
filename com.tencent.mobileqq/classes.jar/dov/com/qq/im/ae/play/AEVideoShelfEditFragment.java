package dov.com.qq.im.ae.play;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.util.CosFunUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.edit.NodeText;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeGroup;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import com.tencent.ttpic.videoshelf.parser.TemplateParser;
import com.tencent.util.UiThreadUtil;
import dov.com.qq.im.ae.AEPath;
import dov.com.qq.im.ae.AEPath.PLAY.CACHE;
import dov.com.qq.im.ae.AEPath.PLAY.FILES;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEFastClickThrottle;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import org.light.device.OfflineConfig;

public class AEVideoShelfEditFragment
  extends PublicBaseFragment
  implements View.OnClickListener, PublicFragmentActivityCallBackInterface, EditTextViewer.OnDownloadDialogListener, EditTextViewer.OnSaveTextInfoListener, FaceImageViewer.OnSaveScrollInfoListener, ScaleMoveImageViewer.OnSaveScrollInfoListener
{
  private static int AUDIO_UPDATE_PROGRESS_TIME = 200;
  private static final long INTERVAL_UPDATE_PROGRESS = 200L;
  private static final int INVALID_NODEGROUPID = -1;
  private static double PROCESS_STEP = 0.3D;
  private static final String TAG = "AEVideoShelfEditFrag";
  private static final float WIDTH_BY_DESIGNER_USED = 720.0F;
  private static final int ZINDEX_BOUND = 10000;
  private static final float spacingInPixels = 12.0F;
  private static PowerManager.WakeLock wakeLock;
  private final String IMAGE_MULTI_FACE = "1";
  private final String IMAGE_NO_FACE = "2";
  private final String IMAGE_SINGLE_FACE = "0";
  private String mAudioPath;
  private Bitmap mBackgroundBitmap;
  private ImageView mBackgroundImageView;
  private List<Bitmap> mBitmaps = new ArrayList();
  private RecyclerView mBoxRecycleView;
  private View mButtonCancel;
  private View mButtonChangeImage;
  private TextView mButtonOk;
  private RelativeLayout mCenterView;
  private int mCenterViewHeight = 0;
  private int mCenterViewWidth = 0;
  private int mCurrentFaceImageViewerNodeId = 0;
  private Dialog mDialog;
  private VideoShelfEngine mEngine;
  private HashSet<FaceImageViewer> mFaceImageViewerSet = new HashSet();
  private String mFinalVideoPath;
  private long mGenerateBegin;
  private HashSet<ScaleMoveImageViewer> mImageViewerSet = new HashSet();
  private Boolean mIsSavingVideo = Boolean.valueOf(false);
  private int mJumpFrom;
  private long mLastUpdateProgressTimeMs;
  private Dialog mLoadingDialog;
  private String mMaterialId;
  private List<NodeGroup> mNodeGroupList = new ArrayList();
  private SparseIntArray mNodeSourceMap = new SparseIntArray();
  private VideoListAdapter.OnVideoNodeClickedListener mOnVideoNodeClickedListener = new AEVideoShelfEditFragment.20(this);
  private int mPrePos = 0;
  private double mProgress = 0.0D;
  private Map<String, Bitmap> mSourceBitmaps = new HashMap();
  private ArrayList<String> mSourcePhotoList;
  private String mTakeSameName;
  private VideoShelfTemplate mTemplate;
  private String mTemplatePath;
  private HashSet<EditTextViewer> mTextViewerSet = new HashSet();
  private Timer mTimer = new Timer();
  private VideoListAdapter mVideoListAdapter;
  private String outputDir;
  private String playShowTabName;
  ProgressPieDrawable ppd;
  
  private void checkJumpToPreview(Intent paramIntent)
  {
    if (this.mJumpFrom == 3)
    {
      getActivity().setResult(-1, paramIntent);
      getActivity().finish();
      return;
    }
    AEVideoShelfPreviewFragment.jumpToMe(getActivity(), paramIntent, 2);
  }
  
  private void clearTempFiles()
  {
    Object localObject1 = new File(this.outputDir);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).list();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          localObject2 = new File(this.outputDir, (String)localObject2);
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
          i += 1;
        }
      }
    }
  }
  
  private ProgressPieDrawable createProgressPie()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(getActivity());
    localProgressPieDrawable.a(AIOUtils.a(50.0F, getActivity().getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.g(-1);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.i(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new AEVideoShelfEditFragment.3(this));
    return localProgressPieDrawable;
  }
  
  private void detectFaceInternal(FaceImageViewer paramFaceImageViewer, Bitmap paramBitmap)
  {
    paramBitmap = FaceChangeUtils.detectFace(paramBitmap, 0.1666666666666667D);
    int i = paramBitmap.getFaceCount();
    Object localObject1 = new ArrayList();
    paramBitmap = paramBitmap.getFaceInfoList().iterator();
    Object localObject2;
    while (paramBitmap.hasNext())
    {
      localObject2 = (FaceInfo)paramBitmap.next();
      CosFunUtil.scale(((FaceInfo)localObject2).points, 1.0D / 0.1666666666666667D);
      FaceOffUtil.getFullCoords(((FaceInfo)localObject2).points, 1.5F);
      Object localObject3 = (PointF)((FaceInfo)localObject2).points.get(99);
      PointF localPointF = (PointF)((FaceInfo)localObject2).points.get(103);
      localObject3 = new FaceParam((int)((PointF)localObject3).x, (int)((PointF)localObject3).y, (int)localPointF.x, (int)localPointF.y);
      ((FaceParam)localObject3).angles = ((FaceInfo)localObject2).angles;
      ((List)localObject1).add(localObject3);
    }
    AEQLog.a("AEVideoShelfEditFrag", "[PlayShow] onFaceImageChanged faceCount = " + i);
    if (i >= 1)
    {
      paramBitmap = (FaceParam)((List)localObject1).get(0);
      localObject2 = ((List)localObject1).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (FaceParam)((Iterator)localObject2).next();
        if (((FaceParam)localObject1).getArea() <= paramBitmap.getArea()) {
          break label284;
        }
        paramBitmap = (Bitmap)localObject1;
      }
    }
    label284:
    for (;;)
    {
      break;
      UiThreadUtil.a(new AEVideoShelfEditFragment.10(this, paramFaceImageViewer, paramBitmap));
      return;
      UiThreadUtil.a(new AEVideoShelfEditFragment.11(this));
      return;
    }
  }
  
  private void dismissProgressDialog()
  {
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
  }
  
  public static int dp2px(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  private NodeItem findNodeItemById(NodeGroup paramNodeGroup, int paramInt)
  {
    paramNodeGroup = paramNodeGroup.nodeItemList.iterator();
    while (paramNodeGroup.hasNext())
    {
      NodeItem localNodeItem = (NodeItem)paramNodeGroup.next();
      if (paramInt == localNodeItem.nodeID) {
        return localNodeItem;
      }
    }
    return null;
  }
  
  private void finishAudioVideoMerge()
  {
    if ((this.mTemplate == null) || (this.mEngine == null)) {
      return;
    }
    this.mFinalVideoPath = this.mEngine.getOutputVideoPath();
    this.mAudioPath = this.mTemplate.getAudioPath();
    if (this.mAudioPath != null) {}
    for (Object localObject1 = new File(this.mAudioPath);; localObject1 = null)
    {
      boolean bool = hasStoragePermission(BaseApplicationImpl.getContext());
      label108:
      StringBuilder localStringBuilder;
      if ((localObject1 != null) && (((File)localObject1).exists()) && (this.mAudioPath != null) && (this.mAudioPath.toLowerCase().endsWith(".m4a")))
      {
        if (!bool) {
          break label290;
        }
        localObject1 = AEPath.a(AEPath.a());
        localStringBuilder = new StringBuilder().append("outputDir: ").append((String)localObject1);
        if (!new File((String)localObject1).exists()) {
          break label319;
        }
      }
      label290:
      label319:
      for (Object localObject2 = " exist";; localObject2 = " not exist")
      {
        AEQLog.b("AEVideoShelfEditFrag", (String)localObject2);
        this.mTimer = new Timer();
        this.mTimer.schedule(new AEVideoShelfEditFragment.16(this), 0L, AUDIO_UPDATE_PROGRESS_TIME);
        if (HwVideoMerge.a(this.mEngine.getOutputVideoPath(), this.mAudioPath, (String)localObject1, 0) == 0)
        {
          localObject2 = new File(this.mEngine.getOutputVideoPath());
          if (((File)localObject2).exists())
          {
            AEQLog.b("AEVideoShelfEditFrag", "finishAudioVideoMerge done!");
            ((File)localObject2).delete();
          }
          this.mFinalVideoPath = ((String)localObject1);
        }
        this.mTimer.cancel();
        this.mTimer = null;
        if ((!bool) || (this.mFinalVideoPath == null)) {
          break;
        }
        FileUtils.a(BaseApplication.getContext(), new File(this.mFinalVideoPath));
        return;
        localObject1 = AEPath.a(AEPath.PLAY.FILES.f + File.separator);
        break label108;
      }
    }
  }
  
  private boolean finishEditTemplate()
  {
    Object localObject4 = null;
    int k = 0;
    Iterator localIterator = this.mImageViewerSet.iterator();
    Object localObject2 = null;
    int j = 0;
    Object localObject3;
    Object localObject1;
    int i;
    if (localIterator.hasNext())
    {
      localObject3 = (ScaleMoveImageViewer)localIterator.next();
      localObject1 = localObject2;
      i = j;
      if (!((ScaleMoveImageViewer)localObject3).isImageSelected())
      {
        if (localObject2 != null) {
          break label90;
        }
        localObject1 = localObject3;
        i = 1;
      }
    }
    label192:
    for (;;)
    {
      localObject2 = localObject1;
      j = i;
      if (i != 0) {
        break;
      }
      ((ScaleMoveImageViewer)localObject3).updateCropBitmap();
      localObject2 = localObject1;
      j = i;
      break;
      label90:
      if (localObject2.getNodeGroupID() > ((ScaleMoveImageViewer)localObject3).getNodeGroupID())
      {
        localObject1 = localObject3;
        i = 1;
        continue;
        localIterator = this.mFaceImageViewerSet.iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (FaceImageViewer)localIterator.next();
          localObject1 = localObject4;
          i = k;
          if (!((FaceImageViewer)localObject3).isImageSelected())
          {
            if (localObject4 != null) {
              break label192;
            }
            localObject1 = localObject3;
            i = 1;
          }
        }
        for (;;)
        {
          localObject4 = localObject1;
          k = i;
          if (i != 0) {
            break;
          }
          ((FaceImageViewer)localObject3).updateCropBitmap();
          localObject4 = localObject1;
          k = i;
          break;
          if (localObject4.getNodeGroupID() > ((FaceImageViewer)localObject3).getNodeGroupID())
          {
            localObject1 = localObject3;
            i = 1;
            continue;
            if ((j != 0) && (localObject2 != null)) {}
            for (i = Math.max(localObject2.getNodeGroupID(), -1);; i = -1)
            {
              if ((k != 0) && (localObject4 != null)) {
                Math.max(localObject4.getNodeGroupID(), i);
              }
              return true;
            }
          }
          else
          {
            i = 1;
            localObject1 = localObject4;
          }
        }
      }
      else
      {
        i = 1;
        localObject1 = localObject2;
      }
    }
  }
  
  private static Bitmap getBitmapFromView(RelativeLayout paramRelativeLayout, int paramInt1, int paramInt2)
  {
    if (paramRelativeLayout == null) {
      return null;
    }
    paramRelativeLayout.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    paramRelativeLayout.draw(new Canvas(localBitmap));
    paramRelativeLayout = Bitmap.createScaledBitmap(localBitmap, paramInt1 / 4, paramInt2 / 4, false);
    localBitmap.recycle();
    return paramRelativeLayout;
  }
  
  private Bitmap getCenterViewBitmap()
  {
    Bitmap localBitmap2;
    if ((this.mCenterViewWidth > 0) && (this.mCenterViewHeight > 0))
    {
      localBitmap2 = Bitmap.createBitmap(this.mCenterViewWidth, this.mCenterViewHeight, Bitmap.Config.ARGB_8888);
      if (!BitmapUtils.isLegal(localBitmap2))
      {
        Log.e("AEVideoShelfEditFrag", "CenterView bitmap is null");
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap2);
      localBitmap1 = localBitmap2;
      if (this.mCenterView != null) {
        this.mCenterView.draw(localCanvas);
      }
    }
    for (Bitmap localBitmap1 = localBitmap2;; localBitmap1 = null) {
      return localBitmap1;
    }
  }
  
  private FaceImageViewer getFaceImageViewByNodeId(int paramInt)
  {
    Iterator localIterator = this.mFaceImageViewerSet.iterator();
    while (localIterator.hasNext())
    {
      FaceImageViewer localFaceImageViewer = (FaceImageViewer)localIterator.next();
      if (localFaceImageViewer.getNodeID() == paramInt) {
        return localFaceImageViewer;
      }
    }
    return null;
  }
  
  private ScaleMoveImageViewer getImageViewByNodeId(int paramInt)
  {
    Iterator localIterator = this.mImageViewerSet.iterator();
    while (localIterator.hasNext())
    {
      ScaleMoveImageViewer localScaleMoveImageViewer = (ScaleMoveImageViewer)localIterator.next();
      if (localScaleMoveImageViewer.getNodeID() == paramInt) {
        return localScaleMoveImageViewer;
      }
    }
    return null;
  }
  
  private void goNext()
  {
    if (finishEditTemplate())
    {
      if (!isNeedRealTimePlay()) {
        saveVideoTemplate();
      }
    }
    else {
      return;
    }
    startVideoTemplateSaveActivity(true);
  }
  
  static boolean hasStoragePermission(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    return PermissionUtils.isStorePermissionEnable(paramContext);
  }
  
  private void hideLoading()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()) && (this.mLoadingDialog != null) && (this.mLoadingDialog.isShowing())) {
      this.mLoadingDialog.dismiss();
    }
  }
  
  private void imageLayout(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    NodeItem localNodeItem = null;
    int i;
    int j;
    if ((paramImageView instanceof ScaleMoveImageViewer))
    {
      localNodeItem = ((ScaleMoveImageViewer)paramImageView).getNode();
      if (localNodeItem != null)
      {
        i = (int)(localNodeItem.maskRect.left * paramInt1);
        j = (int)(localNodeItem.maskRect.top * paramInt2);
        paramInt1 = (int)(localNodeItem.maskRect.right * paramInt1);
        paramInt2 = (int)(localNodeItem.maskRect.bottom * paramInt2);
        paramImageView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - j, 1073741824));
        paramImageView.layout(i, j, paramInt1, paramInt2);
        if (!(paramImageView instanceof ScaleMoveImageViewer)) {
          break label179;
        }
        ((ScaleMoveImageViewer)paramImageView).updateMatrix(Math.abs(paramInt1 - i), Math.abs(paramInt2 - j));
      }
    }
    label179:
    do
    {
      return;
      if ((paramImageView instanceof FaceImageViewer))
      {
        localNodeItem = ((FaceImageViewer)paramImageView).getNode();
        break;
      }
      if (!(paramImageView instanceof EditTextViewer)) {
        break;
      }
      localNodeItem = ((EditTextViewer)paramImageView).getNode();
      break;
      if ((paramImageView instanceof FaceImageViewer))
      {
        ((FaceImageViewer)paramImageView).updateMatrix(Math.abs(paramInt1 - i), Math.abs(paramInt2 - j));
        return;
      }
    } while (!(paramImageView instanceof EditTextViewer));
    ((EditTextViewer)paramImageView).updateMatrix(Math.abs(paramInt1 - i), Math.abs(paramInt2 - j));
    paramInt1 = getResources().getDimensionPixelSize(2131296739);
    ((EditTextViewer)paramImageView).setActionBarHeight(paramInt1);
  }
  
  private void initAllNodeViewer()
  {
    this.mNodeSourceMap.clear();
    Iterator localIterator1 = this.mNodeGroupList.iterator();
    int i = 0;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((NodeGroup)localIterator1.next()).nodeItemList.iterator();
      while (localIterator2.hasNext())
      {
        NodeItem localNodeItem = (NodeItem)localIterator2.next();
        Object localObject;
        if (localNodeItem.type == 0)
        {
          localObject = new ScaleMoveImageViewer(getActivity());
          ((ScaleMoveImageViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new AEVideoShelfEditFragment.6(this, (ScaleMoveImageViewer)localObject, localNodeItem));
          ((ScaleMoveImageViewer)localObject).setOnSaveScrollInfoListener(this);
          ((ScaleMoveImageViewer)localObject).setNodeInfo(localNodeItem);
          ((ScaleMoveImageViewer)localObject).setMovable(false);
          ((ScaleMoveImageViewer)localObject).setImageSelected(false);
          this.mImageViewerSet.add(localObject);
          if ((this.mSourcePhotoList != null) && (i < this.mSourcePhotoList.size()))
          {
            onImageChanged(localNodeItem.nodeID, (String)this.mSourcePhotoList.get(i), false);
            this.mNodeSourceMap.put(localNodeItem.nodeID, i);
            i += 1;
          }
        }
        else
        {
          if (localNodeItem.type == 1)
          {
            localObject = new EditTextViewer(getActivity());
            ((EditTextViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new AEVideoShelfEditFragment.7(this, (EditTextViewer)localObject, localNodeItem));
            ((EditTextViewer)localObject).setOnSaveTextInfoListener(this);
            ((EditTextViewer)localObject).setOnDownloadDialogListener(this);
            ((EditTextViewer)localObject).setNodeInfo(localNodeItem);
            if (localNodeItem.bitmap != null) {
              ((EditTextViewer)localObject).setImageBitmap(localNodeItem.bitmap);
            }
            for (;;)
            {
              ((EditTextViewer)localObject).setNodeBitmap(localNodeItem.bitmap);
              ((EditTextViewer)localObject).setTextSelected(true);
              ((EditTextViewer)localObject).setMaterialId(this.mMaterialId);
              this.mTextViewerSet.add(localObject);
              break;
              Bitmap localBitmap = ((EditTextViewer)localObject).renderBitmap();
              if ((localBitmap != null) && (!localBitmap.isRecycled()))
              {
                ((EditTextViewer)localObject).setImageBitmap(localBitmap);
                localNodeItem.bitmap = localBitmap;
                ((EditTextViewer)localObject).setImageBitmap(localNodeItem.bitmap);
              }
            }
          }
          if (localNodeItem.type == 2)
          {
            localObject = new FaceImageViewer(getActivity());
            ((FaceImageViewer)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new AEVideoShelfEditFragment.8(this, (FaceImageViewer)localObject, localNodeItem));
            ((FaceImageViewer)localObject).setOnSaveScrollInfoListener(this);
            ((FaceImageViewer)localObject).setNodeInfo(localNodeItem);
            ((FaceImageViewer)localObject).setMovable(false);
            ((FaceImageViewer)localObject).setImageSelected(false);
            this.mFaceImageViewerSet.add(localObject);
            if ((this.mSourcePhotoList != null) && (i < this.mSourcePhotoList.size()))
            {
              onFaceImageChanged(localNodeItem.nodeID, (String)this.mSourcePhotoList.get(i), false);
              this.mNodeSourceMap.put(localNodeItem.nodeID, i);
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private void initBackgroundImageView()
  {
    this.mBackgroundImageView = new ImageView(getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.mBackgroundImageView.setLayoutParams(localLayoutParams);
  }
  
  private void initCenterView(int paramInt)
  {
    NodeGroup localNodeGroup = (NodeGroup)this.mNodeGroupList.get(paramInt);
    this.mCenterView.removeAllViews();
    Iterator localIterator = this.mImageViewerSet.iterator();
    paramInt = 0;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (ScaleMoveImageViewer)localIterator.next();
      if ((((ScaleMoveImageViewer)localObject).getNodeGroupID() != localNodeGroup.nodeGroupID) || (((ScaleMoveImageViewer)localObject).getNode().zIndex >= 10000)) {
        break label462;
      }
      this.mCenterView.addView((View)localObject);
      paramInt = 1;
    }
    label462:
    for (;;)
    {
      break;
      localIterator = this.mTextViewerSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (EditTextViewer)localIterator.next();
        if ((((EditTextViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject).getNode().zIndex < 10000)) {
          this.mCenterView.addView((View)localObject);
        }
      }
      localIterator = this.mFaceImageViewerSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (FaceImageViewer)localIterator.next();
        if ((((FaceImageViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject).getNode().zIndex < 10000)) {
          this.mCenterView.addView((View)localObject);
        }
      }
      setBackgroundImage(localNodeGroup);
      this.mCenterView.addView(this.mBackgroundImageView);
      localIterator = this.mImageViewerSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ScaleMoveImageViewer)localIterator.next();
        if ((((ScaleMoveImageViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((ScaleMoveImageViewer)localObject).getNode().zIndex >= 10000))
        {
          this.mCenterView.addView((View)localObject);
          paramInt = 1;
        }
      }
      localIterator = this.mTextViewerSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (EditTextViewer)localIterator.next();
        if ((((EditTextViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject).getNode().zIndex >= 10000)) {
          this.mCenterView.addView((View)localObject);
        }
      }
      localIterator = this.mFaceImageViewerSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (FaceImageViewer)localIterator.next();
        if ((((FaceImageViewer)localObject).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject).getNode().zIndex >= 10000)) {
          this.mCenterView.addView((View)localObject);
        }
      }
      if (paramInt != 0)
      {
        this.mButtonChangeImage.setVisibility(0);
        return;
      }
      this.mButtonChangeImage.setVisibility(8);
      return;
    }
  }
  
  private void initData()
  {
    Intent localIntent = getActivity().getIntent();
    if (localIntent == null) {
      return;
    }
    this.mJumpFrom = localIntent.getIntExtra("jump_in_from", 0);
    this.playShowTabName = localIntent.getStringExtra("loc_play_show_tab_name");
    this.mTemplatePath = localIntent.getStringExtra("MaterialPath");
    this.mMaterialId = localIntent.getStringExtra("MaterialId");
    this.mSourcePhotoList = localIntent.getStringArrayListExtra("PhotoList");
    this.mTakeSameName = localIntent.getStringExtra("loc_play_show_take_same_name");
    this.mTemplate = TemplateParser.parse(getActivity(), this.mTemplatePath);
    if (this.mTemplate == null)
    {
      AEQLog.c("AEVideoShelfEditFrag", "parse template Error!");
      return;
    }
    try
    {
      this.mEngine = new VideoShelfEngine(this.mTemplate.getVersion());
      if (this.mEngine == null)
      {
        AEQLog.c("AEVideoShelfEditFrag", "init Engine Error!");
        return;
      }
    }
    catch (PagNotSupportSystemException localPagNotSupportSystemException)
    {
      for (;;)
      {
        this.mEngine = null;
        AEQLog.d("AEVideoShelfEditFrag", localPagNotSupportSystemException.getMessage());
        UiThreadUtil.a(new AEVideoShelfEditFragment.4(this), 2000L);
      }
      new AEVideoShelfEditFragment.5(this).execute(new Void[0]);
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
        Object localObject1 = (MaskNodeGroup)this.mTemplate.getNodeGroupList().get(i);
        NodeGroup localNodeGroup = new NodeGroup();
        localNodeGroup.nodeCoverImage = ((MaskNodeGroup)localObject1).getNodeGroupCoverImage();
        localNodeGroup.nodeGroupID = ((MaskNodeGroup)localObject1).getNodeGroupID();
        localNodeGroup.nodeDefaultMaskCoverImage = ((MaskNodeGroup)localObject1).getNodeGroupMaskImage();
        localObject1 = ((MaskNodeGroup)localObject1).getNodeList();
        localNodeGroup.nodeItemList = new ArrayList();
        int j = 0;
        if (j < ((List)localObject1).size())
        {
          Object localObject2 = (MaskNodeItem)((List)localObject1).get(j);
          NodeItem localNodeItem = new NodeItem();
          localNodeItem.nodeID = ((MaskNodeItem)localObject2).getNodeID();
          Object localObject3 = ((MaskNodeItem)localObject2).getNodeDefaultMaskCoverImage();
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            if (((MaskNodeItem)localObject2).getType() == 1) {
              localNodeItem.coverURL = null;
            }
          }
          for (;;)
          {
            localObject3 = ((MaskNodeItem)localObject2).getMaskRect();
            localNodeItem.maskRect.set(localObject3[0], localObject3[1], localObject3[0] + localObject3[2], localObject3[1] + localObject3[3]);
            localNodeItem.once = true;
            localNodeItem.type = ((MaskNodeItem)localObject2).getType();
            localNodeItem.nodeGroupID = ((MaskNodeItem)localObject2).getNodeGroupID();
            localNodeItem.zIndex = ((MaskNodeItem)localObject2).getZIndex();
            localNodeItem.indexLayerForPag = ((MaskNodeItem)localObject2).getIndexLayerForPag();
            localNodeItem.nodeTextMaxCount = ((MaskNodeItem)localObject2).getNodeTextMaxCount();
            if (!TextUtils.isEmpty(localNodeItem.coverURL))
            {
              String str = this.mTemplate.getMaterialPath() + File.separator + localNodeItem.coverURL;
              localNodeItem.bitmap = BitmapUtils.decodeSampleBitmap(getActivity(), str, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
              localNodeItem.bitmap = VideoShelfBitmapUtils.rotateWithExif(localNodeItem.bitmap, str);
            }
            if (((MaskNodeItem)localObject2).getNodeTextGroup() != null)
            {
              localNodeItem.nodeTextGroup.copyFrom(((MaskNodeItem)localObject2).getNodeTextGroup());
              if (TextUtils.isEmpty(localNodeItem.nodeTextGroup.fmtstr))
              {
                localNodeItem.nodeTextGroup.fmtstr = "请输入文字";
                if ((localNodeItem.type == 1) && (localNodeItem.bitmap != null) && (!localNodeItem.bitmap.isRecycled()))
                {
                  localNodeItem.bitmap.recycle();
                  localNodeItem.bitmap = null;
                }
              }
              if ((TextUtils.isEmpty(localNodeItem.coverURL)) && (localNodeItem.type == 1) && (localNodeItem.bitmap != null) && (!localNodeItem.bitmap.isRecycled()))
              {
                localNodeItem.bitmap.recycle();
                localNodeItem.bitmap = null;
              }
              localNodeItem.nodeTextGroup.width = ((int)(this.mTemplate.getVideoWidth() * localObject3[2]));
              localObject2 = localNodeItem.nodeTextGroup;
              float f = this.mTemplate.getVideoHeight();
              ((NodeText)localObject2).height = ((int)(localObject3[3] * f));
              localNodeItem.nodeTextGroup.fontSize = (localNodeItem.nodeTextGroup.fontSize * this.mTemplate.getVideoWidth() / 720.0F);
            }
            this.mBitmaps.add(localNodeItem.bitmap);
            localNodeGroup.nodeItemList.add(localNodeItem);
            j += 1;
            break;
            localNodeItem.coverURL = localNodeGroup.nodeDefaultMaskCoverImage;
            continue;
            localNodeItem.coverURL = ((String)localObject3);
          }
        }
        this.mNodeGroupList.add(localNodeGroup);
        i += 1;
      }
    }
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
    this.mDialog.setContentView(2131561994);
    localObject = (ImageView)this.mDialog.findViewById(2131373545);
    this.ppd = createProgressPie();
    ((ImageView)localObject).setImageDrawable(this.ppd);
    ((TextView)this.mDialog.findViewById(2131371908)).setText(2131689825);
    this.mDialog.setCancelable(true);
    this.mDialog.setCanceledOnTouchOutside(false);
    this.mDialog.setOnCancelListener(new AEVideoShelfEditFragment.2(this));
    this.ppd.c(0);
  }
  
  private void initSelectedFacePosition(FaceImageViewer paramFaceImageViewer, FaceParam paramFaceParam)
  {
    float f1 = 1.0F;
    float f5 = paramFaceImageViewer.getWidth();
    float f6 = paramFaceImageViewer.getHeight();
    float f2 = (float)Math.toDegrees(paramFaceParam.angles[2]);
    float f3 = f5 / 2.0F;
    float f4 = (paramFaceParam.mFace.left + paramFaceParam.mFace.right) / 2;
    f6 /= 2.0F;
    float f7 = (paramFaceParam.mFace.top + paramFaceParam.mFace.bottom) / 2;
    float f8 = paramFaceParam.mFace.width();
    if (f8 > 0.0F) {
      f1 = f5 / f8;
    }
    paramFaceImageViewer.transformCurrentMatrix(f1, f2 * 1.0F, f3 - f4, f6 - f7);
  }
  
  private void initSoftInputMode()
  {
    Window localWindow = getActivity().getWindow();
    if (localWindow != null) {
      localWindow.setSoftInputMode(48);
    }
  }
  
  private void initView()
  {
    this.mButtonCancel = getActivity().findViewById(2131363402);
    this.mButtonOk = ((TextView)getActivity().findViewById(2131364119));
    this.mButtonOk.setText(2131689811);
    this.mButtonOk.setOnClickListener(this);
    this.mButtonCancel.setOnClickListener(this);
    this.mButtonChangeImage = getActivity().findViewById(2131366128);
    this.mButtonChangeImage.setOnClickListener(this);
    this.mCenterView = ((RelativeLayout)getActivity().findViewById(2131364526));
    this.mBoxRecycleView = ((RecyclerView)getActivity().findViewById(2131363825));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
    localLinearLayoutManager.setOrientation(0);
    this.mBoxRecycleView.addItemDecoration(new AEVideoShelfEditFragment.SpacesItemDecoration(this, dp2px(getActivity(), 12.0F)));
    this.mBoxRecycleView.setLayoutManager(localLinearLayoutManager);
    this.mCenterView.getViewTreeObserver().addOnGlobalLayoutListener(new AEVideoShelfEditFragment.1(this));
    initProgressDialog();
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
  
  public static void jumpToMe(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList, int paramInt, String paramString5)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString2);
    localIntent.putExtra("MaterialId", paramString3);
    localIntent.putExtra("MaterialName", paramString4);
    localIntent.putExtra("loc_play_show_tab_name", paramString1);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.getFromType(paramContext));
    localIntent.putStringArrayListExtra("PhotoList", paramArrayList);
    localIntent.putExtra("jump_in_from", paramInt);
    localIntent.putExtra("loc_play_show_take_same_name", paramString5);
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivityForPeak.class, AEVideoShelfEditFragment.class);
  }
  
  public static void jumpToMeForResult(Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString1);
    localIntent.putExtra("MaterialId", paramString2);
    localIntent.putExtra("MaterialName", paramString3);
    localIntent.putStringArrayListExtra("PhotoList", paramArrayList);
    localIntent.putExtra("jump_in_from", paramInt2);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivityForPeak.class, AEVideoShelfEditFragment.class, paramInt1);
  }
  
  private void jumpToPagRealtimePreview()
  {
    Log.i("AEVideoShelfEditFrag", "未合成视频，将直接实时预览。");
    AEQLog.b("AEVideoShelfEditFrag", "未合成视频，将直接实时预览。");
    if (this.mTemplate == null) {
      return;
    }
    new AEVideoShelfEditFragment.12(this).execute(new Void[0]);
  }
  
  public static void keepScreenOn(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(536870918, AEVideoShelfEditFragment.class.getSimpleName());
      wakeLock.acquire();
      AEQLog.b("AEVideoShelfEditFrag", "keepScreenOn!");
      return;
    }
    if (wakeLock != null)
    {
      wakeLock.release();
      wakeLock = null;
    }
    AEQLog.b("AEVideoShelfEditFrag", "keepScreenOff!");
  }
  
  private static void layoutView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824));
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  private void loadAllSrcBitmaps()
  {
    if ((this.mSourcePhotoList == null) || (this.mSourcePhotoList.isEmpty())) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mSourcePhotoList.size())
      {
        String str = (String)this.mSourcePhotoList.get(i);
        this.mSourceBitmaps.put(str, BitmapUtils.decodeSampleBitmap(getActivity(), str, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight()));
        i += 1;
      }
    }
  }
  
  private void onFaceImageChanged(int paramInt, String paramString, boolean paramBoolean)
  {
    this.mCurrentFaceImageViewerNodeId = paramInt;
    FaceImageViewer localFaceImageViewer = getFaceImageViewByNodeId(this.mCurrentFaceImageViewerNodeId);
    if (localFaceImageViewer == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(paramString));
        Bitmap localBitmap2 = (Bitmap)this.mSourceBitmaps.get(paramString);
        localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          localBitmap1 = BitmapUtils.decodeSampleBitmap(getActivity(), paramString, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
          this.mSourceBitmaps.put(paramString, localBitmap1);
        }
      } while (!BitmapUtils.isLegal(localBitmap1));
      Bitmap localBitmap1 = VideoShelfBitmapUtils.rotateWithExif(localBitmap1, paramString);
      paramString = localBitmap1;
      if (localBitmap1.getWidth() == 1)
      {
        paramString = localBitmap1;
        if (localBitmap1.getHeight() == 1) {
          paramString = BitmapUtils.scaleBitmap(localBitmap1, 2.0F, true);
        }
      }
      localFaceImageViewer.setNodeBitmap(paramString);
      localFaceImageViewer.setImageBitmap(paramString);
      localFaceImageViewer.setImageSelected(true);
      localFaceImageViewer.setMovable(true);
      localFaceImageViewer.setScaleType(ImageView.ScaleType.MATRIX);
      localFaceImageViewer.clearSeclected();
      FaceChangeUtils.runInGLThread(new AEVideoShelfEditFragment.9(this, localFaceImageViewer, paramString), false, "");
    } while (!paramBoolean);
    updateRVListItem(localFaceImageViewer.getNodeGroupID());
  }
  
  private void onFirstImageViewClick(View paramView)
  {
    int i = ((NodeGroup)this.mNodeGroupList.get(this.mPrePos)).nodeGroupID;
    if (this.mImageViewerSet != null)
    {
      Iterator localIterator = this.mImageViewerSet.iterator();
      while (localIterator.hasNext())
      {
        ScaleMoveImageViewer localScaleMoveImageViewer = (ScaleMoveImageViewer)localIterator.next();
        if (localScaleMoveImageViewer.getNodeGroupID() == i) {
          localScaleMoveImageViewer.onClick(paramView);
        }
      }
    }
  }
  
  private void onImageChanged(int paramInt, String paramString)
  {
    onImageChanged(paramInt, paramString, true);
  }
  
  private void onImageChanged(int paramInt, String paramString, boolean paramBoolean)
  {
    ScaleMoveImageViewer localScaleMoveImageViewer = getImageViewByNodeId(paramInt);
    if (localScaleMoveImageViewer == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(paramString));
        Bitmap localBitmap2 = (Bitmap)this.mSourceBitmaps.get(paramString);
        localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          localBitmap1 = BitmapUtils.decodeSampleBitmap(getActivity(), paramString, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
          this.mSourceBitmaps.put(paramString, localBitmap1);
        }
      } while (!BitmapUtils.isLegal(localBitmap1));
      Bitmap localBitmap1 = VideoShelfBitmapUtils.rotateWithExif(localBitmap1, paramString);
      paramString = localBitmap1;
      if (localBitmap1.getWidth() == 1)
      {
        paramString = localBitmap1;
        if (localBitmap1.getHeight() == 1) {
          paramString = BitmapUtils.scaleBitmap(localBitmap1, 2.0F, true);
        }
      }
      localScaleMoveImageViewer.setNodeBitmap(paramString);
      localScaleMoveImageViewer.setImageBitmap(paramString);
      localScaleMoveImageViewer.setImageSelected(true);
      localScaleMoveImageViewer.setMovable(true);
      localScaleMoveImageViewer.clearSeclected();
    } while (!paramBoolean);
    updateRVListItem(localScaleMoveImageViewer.getNodeGroupID());
  }
  
  /* Error */
  private String saveMyBitmap(int paramInt, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 524	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: getfield 373	dov/com/qq/im/ae/play/AEVideoShelfEditFragment:outputDir	Ljava/lang/String;
    //   11: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: getstatic 675	java/io/File:separator	Ljava/lang/String;
    //   17: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc_w 1480
    //   23: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokestatic 1486	java/lang/System:currentTimeMillis	()J
    //   29: invokevirtual 1489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: ldc_w 1491
    //   35: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_1
    //   39: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: ldc_w 1493
    //   45: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 4
    //   53: new 371	java/io/File
    //   56: dup
    //   57: aload 4
    //   59: invokespecial 375	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore_3
    //   63: aload_3
    //   64: invokevirtual 1496	java/io/File:createNewFile	()Z
    //   67: pop
    //   68: new 1498	java/io/FileOutputStream
    //   71: dup
    //   72: aload_3
    //   73: invokespecial 1501	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   76: astore_3
    //   77: aload_2
    //   78: getstatic 1507	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   81: bipush 100
    //   83: aload_3
    //   84: invokevirtual 1511	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   87: pop
    //   88: aload_3
    //   89: invokevirtual 1514	java/io/FileOutputStream:flush	()V
    //   92: aload_3
    //   93: invokevirtual 1517	java/io/FileOutputStream:close	()V
    //   96: aload 4
    //   98: areturn
    //   99: astore 5
    //   101: ldc 33
    //   103: new 524	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 1519
    //   113: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 5
    //   118: invokevirtual 1520	java/io/IOException:toString	()Ljava/lang/String;
    //   121: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 1028	dov/com/qq/im/ae/util/AEQLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto -62 -> 68
    //   133: astore_3
    //   134: aload_3
    //   135: invokevirtual 1523	java/io/FileNotFoundException:printStackTrace	()V
    //   138: ldc 33
    //   140: new 524	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 1525
    //   150: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_3
    //   154: invokevirtual 1526	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   157: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 1028	dov/com/qq/im/ae/util/AEQLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aconst_null
    //   167: astore_3
    //   168: goto -91 -> 77
    //   171: astore_2
    //   172: aload_2
    //   173: invokevirtual 1527	java/lang/Exception:printStackTrace	()V
    //   176: ldc 33
    //   178: new 524	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 1529
    //   188: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: invokevirtual 1530	java/lang/Exception:toString	()Ljava/lang/String;
    //   195: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 1028	dov/com/qq/im/ae/util/AEQLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 1531	java/io/IOException:printStackTrace	()V
    //   211: ldc 33
    //   213: new 524	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 1533
    //   223: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_2
    //   227: invokevirtual 1520	java/io/IOException:toString	()Ljava/lang/String;
    //   230: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 1028	dov/com/qq/im/ae/util/AEQLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto -147 -> 92
    //   242: astore_2
    //   243: aload_2
    //   244: invokevirtual 1531	java/io/IOException:printStackTrace	()V
    //   247: ldc 33
    //   249: new 524	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 1535
    //   259: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_2
    //   263: invokevirtual 1520	java/io/IOException:toString	()Ljava/lang/String;
    //   266: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 1028	dov/com/qq/im/ae/util/AEQLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload 4
    //   277: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	AEVideoShelfEditFragment
    //   0	278	1	paramInt	int
    //   0	278	2	paramBitmap	Bitmap
    //   62	31	3	localObject1	Object
    //   133	21	3	localFileNotFoundException	java.io.FileNotFoundException
    //   167	1	3	localObject2	Object
    //   51	225	4	str	String
    //   99	18	5	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   63	68	99	java/io/IOException
    //   68	77	133	java/io/FileNotFoundException
    //   77	88	171	java/lang/Exception
    //   88	92	206	java/io/IOException
    //   92	96	242	java/io/IOException
  }
  
  private void saveVideoTemplate()
  {
    if ((this.mTemplate == null) || (this.mEngine == null)) {
      return;
    }
    this.mEngine.setVideoFrameItemList(this.mTemplate.getFrameList());
    this.mEngine.setNodeGroupItemList(this.mNodeGroupList);
    this.mEngine.setVideoTemplateType(this.mTemplate.getVideoTemplateType());
    String str = null;
    switch (this.mTemplate.getVersion())
    {
    }
    for (;;)
    {
      this.mEngine.setSrcPath(str);
      this.mEngine.setOutputVideoPath(ShortVideoUtils.getLocalShortVideoPath());
      this.mEngine.setCallback(new AEVideoShelfEditFragment.EngineCallback(this));
      this.mEngine.setLutPath(this.mTemplate.getFilterLutPath());
      if (this.mTemplate.getWatermarkRect() != null) {
        this.mEngine.setWatermarkRect(this.mTemplate.getWatermarkRect());
      }
      this.mIsSavingVideo = Boolean.valueOf(true);
      this.mEngine.save(this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
      return;
      str = this.mTemplate.getVideoPath();
      continue;
      str = this.mTemplate.getPagFilePath();
    }
  }
  
  private void setBackgroundImage(NodeGroup paramNodeGroup)
  {
    if ((this.mBackgroundBitmap != null) && (!this.mBackgroundBitmap.isRecycled())) {
      this.mBackgroundBitmap.recycle();
    }
    if (this.mTemplate == null) {
      return;
    }
    paramNodeGroup = this.mTemplate.getMaterialPath() + File.separator + paramNodeGroup.nodeDefaultMaskCoverImage;
    this.mBackgroundBitmap = VideoShelfBitmapUtils.rotateWithExif(BitmapUtils.decodeSampleBitmap(getActivity(), paramNodeGroup, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight()), paramNodeGroup);
    this.mBackgroundImageView.setImageBitmap(this.mBackgroundBitmap);
  }
  
  private void setListViewBg(int paramInt)
  {
    if (this.mBoxRecycleView != null)
    {
      VideoListAdapter localVideoListAdapter = (VideoListAdapter)this.mBoxRecycleView.getAdapter();
      Bitmap localBitmap = getCenterViewBitmap();
      if ((localVideoListAdapter != null) && (BitmapUtils.isLegal(localBitmap)))
      {
        localVideoListAdapter.setThumbBackground(paramInt, localBitmap);
        localVideoListAdapter.updateThumbBackground();
      }
    }
  }
  
  private void setListViewBg(RelativeLayout paramRelativeLayout, int paramInt)
  {
    if (this.mBoxRecycleView != null)
    {
      VideoListAdapter localVideoListAdapter = (VideoListAdapter)this.mBoxRecycleView.getAdapter();
      paramRelativeLayout = getBitmapFromView(paramRelativeLayout, paramRelativeLayout.getWidth(), paramRelativeLayout.getHeight());
      if ((localVideoListAdapter != null) && (BitmapUtils.isLegal(paramRelativeLayout)))
      {
        localVideoListAdapter.setThumbBackground(paramInt, paramRelativeLayout);
        localVideoListAdapter.updateThumbBackground();
      }
    }
  }
  
  private void setOffscreenView(ViewGroup paramViewGroup, int paramInt)
  {
    NodeGroup localNodeGroup = (NodeGroup)this.mNodeGroupList.get(paramInt);
    paramViewGroup.removeAllViews();
    Object localObject1 = this.mImageViewerSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ScaleMoveImageViewer)((Iterator)localObject1).next();
      if ((((ScaleMoveImageViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((ScaleMoveImageViewer)localObject2).getNode().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        imageLayout((ImageView)localObject2, this.mCenterViewWidth, this.mCenterViewHeight);
      }
    }
    localObject1 = this.mTextViewerSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditTextViewer)((Iterator)localObject1).next();
      if ((((EditTextViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject2).getNode().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        imageLayout((ImageView)localObject2, this.mCenterViewWidth, this.mCenterViewHeight);
      }
    }
    localObject1 = this.mFaceImageViewerSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FaceImageViewer)((Iterator)localObject1).next();
      if ((((FaceImageViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject2).getNode().zIndex < 10000))
      {
        paramViewGroup.addView((View)localObject2);
        imageLayout((ImageView)localObject2, this.mCenterViewWidth, this.mCenterViewHeight);
      }
    }
    localObject1 = this.mTemplate.getMaterialPath() + File.separator + localNodeGroup.nodeDefaultMaskCoverImage;
    localObject1 = VideoShelfBitmapUtils.rotateWithExif(BitmapUtils.decodeSampleBitmap(getActivity(), (String)localObject1, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight()), (String)localObject1);
    Object localObject2 = new ImageView(getActivity());
    ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
    paramViewGroup.addView((View)localObject2);
    int i;
    float f;
    if (localObject1 != null)
    {
      paramInt = ((Bitmap)localObject1).getWidth();
      i = ((Bitmap)localObject1).getHeight();
      f = paramInt / i;
      if (f >= this.mCenterViewWidth / this.mCenterViewWidth) {
        break label550;
      }
      i = this.mCenterViewWidth;
      paramInt = (int)(this.mCenterViewWidth / f);
    }
    for (;;)
    {
      ((ImageView)localObject2).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824));
      ((ImageView)localObject2).layout((this.mCenterViewWidth - i) / 2, (this.mCenterViewHeight - paramInt) / 2, (i + this.mCenterViewWidth) / 2, (paramInt + this.mCenterViewHeight) / 2);
      localObject1 = this.mImageViewerSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ScaleMoveImageViewer)((Iterator)localObject1).next();
        if ((((ScaleMoveImageViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((ScaleMoveImageViewer)localObject2).getNode().zIndex >= 10000))
        {
          paramViewGroup.addView((View)localObject2);
          imageLayout((ImageView)localObject2, this.mCenterViewWidth, this.mCenterViewHeight);
        }
      }
      label550:
      paramInt = this.mCenterViewHeight;
      i = (int)(this.mCenterViewHeight * f);
    }
    localObject1 = this.mTextViewerSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditTextViewer)((Iterator)localObject1).next();
      if ((((EditTextViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((EditTextViewer)localObject2).getNode().zIndex >= 10000))
      {
        paramViewGroup.addView((View)localObject2);
        imageLayout((ImageView)localObject2, this.mCenterViewWidth, this.mCenterViewHeight);
      }
    }
    localObject1 = this.mFaceImageViewerSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FaceImageViewer)((Iterator)localObject1).next();
      if ((((FaceImageViewer)localObject2).getNodeGroupID() == localNodeGroup.nodeGroupID) && (((FaceImageViewer)localObject2).getNode().zIndex >= 10000))
      {
        paramViewGroup.addView((View)localObject2);
        imageLayout((ImageView)localObject2, this.mCenterViewWidth, this.mCenterViewHeight);
      }
    }
  }
  
  private void showLoading(String paramString)
  {
    Object localObject = getActivity();
    if ((localObject != null) && (!((FragmentActivity)localObject).isFinishing()))
    {
      if (this.mLoadingDialog == null)
      {
        this.mLoadingDialog = new ReportDialog((Context)localObject, 2131755842);
        this.mLoadingDialog.setCancelable(false);
        this.mLoadingDialog.setCanceledOnTouchOutside(false);
        this.mLoadingDialog.setContentView(2131559683);
      }
      localObject = (TextView)this.mLoadingDialog.findViewById(2131373066);
      if (TextUtils.isEmpty(paramString)) {
        break label98;
      }
      ((TextView)localObject).setText(paramString);
    }
    for (;;)
    {
      this.mLoadingDialog.show();
      return;
      label98:
      ((TextView)localObject).setText(2131694890);
    }
  }
  
  private void showProgressDialog()
  {
    if (this.mDialog != null) {
      this.mDialog.show();
    }
  }
  
  private void startVideoTemplateSaveActivity(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Log.i("AEVideoShelfEditFrag", "已经合成完视频，不进行实时预览。");
      AEQLog.b("AEVideoShelfEditFrag", "已经合成完视频，不进行实时预览。");
      if ((this.mTemplate == null) || (this.mFinalVideoPath == null)) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("from", true);
      localIntent.putExtra("MaterialId", this.mMaterialId);
      localIntent.putExtra("FinalVideoPath", this.mFinalVideoPath);
      localIntent.putExtra("usePagPreview", paramBoolean);
      localIntent.putExtra("MaterialPath", this.mTemplatePath);
      localIntent.putExtra("MaterialName", this.mTemplate.getVideoName());
      localIntent.putStringArrayListExtra("PhotoList", this.mSourcePhotoList);
      localIntent.putExtra("loc_play_show_tab_name", this.playShowTabName);
      localIntent.putExtra("loc_play_show_material_id", this.mMaterialId);
      localIntent.putExtra("loc_play_show_take_same_name", this.mTakeSameName);
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.getFromType(getActivity()));
      localIntent.putExtra("isNeedEditButton", true);
      checkJumpToPreview(localIntent);
      this.mIsSavingVideo = Boolean.valueOf(false);
      return;
    }
    jumpToPagRealtimePreview();
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
  
  private void updateRVListItem(int paramInt)
  {
    this.mBoxRecycleView.postDelayed(new AEVideoShelfEditFragment.19(this, paramInt), 100L);
  }
  
  public void hideDownloadDialog()
  {
    hideLoading();
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
  
  public void onBackPressed()
  {
    getActivity().finish();
  }
  
  public void onCancelCompleted()
  {
    AEQLog.b("AEVideoShelfEditFrag", "Merge Video step onCancelCompleted");
    this.mGenerateBegin = 0L;
    UiThreadUtil.a(new AEVideoShelfEditFragment.18(this));
  }
  
  public void onClick(View paramView)
  {
    if (AEFastClickThrottle.a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = paramView.getId();
      if (i == 2131363402)
      {
        onBackPressed();
      }
      else if (i == 2131364119)
      {
        goNext();
        AEBaseDataReporter.a().g();
      }
      else if (i == 2131366128)
      {
        onFirstImageViewClick(paramView);
      }
    }
  }
  
  public void onCompleteTextEdit(NodeItem paramNodeItem)
  {
    updateRVListItem(paramNodeItem.nodeGroupID);
  }
  
  public void onCompleted()
  {
    AEQLog.b("AEVideoShelfEditFrag", "Merge Video step onCompleted");
    if (this.mGenerateBegin > 0L) {}
    for (long l = System.currentTimeMillis() - this.mGenerateBegin;; l = 0L)
    {
      this.mGenerateBegin = 0L;
      finishAudioVideoMerge();
      UiThreadUtil.a(new AEVideoShelfEditFragment.15(this, l));
      startVideoTemplateSaveActivity(false);
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558512, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.mBoxRecycleView != null) {
      this.mBoxRecycleView.setAdapter(null);
    }
    if (this.mVideoListAdapter != null) {
      this.mVideoListAdapter.clearBitmaps();
    }
    this.mVideoListAdapter = null;
    if ((this.mBackgroundBitmap != null) && (!this.mBackgroundBitmap.isRecycled())) {
      this.mBackgroundBitmap.recycle();
    }
    if (this.mButtonCancel != null) {
      this.mButtonCancel.setOnClickListener(null);
    }
    if (this.mButtonOk != null) {
      this.mButtonOk.setOnClickListener(null);
    }
    if (this.mButtonChangeImage != null) {
      this.mButtonChangeImage.setOnClickListener(null);
    }
    Iterator localIterator = this.mBitmaps.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Bitmap)localIterator.next();
      if (BitmapUtils.isLegal((Bitmap)localObject)) {
        ((Bitmap)localObject).recycle();
      }
    }
    localIterator = this.mSourceBitmaps.entrySet().iterator();
    while (localIterator.hasNext()) {
      BitmapUtils.recycle((Bitmap)((Map.Entry)localIterator.next()).getValue());
    }
    this.mSourceBitmaps.clear();
    localIterator = this.mImageViewerSet.iterator();
    while (localIterator.hasNext()) {
      ((ScaleMoveImageViewer)localIterator.next()).clearBitmaps();
    }
    localIterator = this.mTextViewerSet.iterator();
    while (localIterator.hasNext())
    {
      localObject = (EditTextViewer)localIterator.next();
      ((EditTextViewer)localObject).clearBitmaps();
      ((EditTextViewer)localObject).setOnDownloadDialogListener(null);
    }
    localIterator = this.mFaceImageViewerSet.iterator();
    while (localIterator.hasNext()) {
      ((FaceImageViewer)localIterator.next()).clearBitmaps();
    }
    dismissProgressDialog();
    keepScreenOn(getActivity(), false);
    super.onDestroy();
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    this.mGenerateBegin = 0L;
    UiThreadUtil.a(new AEVideoShelfEditFragment.17(this));
    AEQLog.c("AEVideoShelfEditFrag", "Merge Video step onError");
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent == null) {
      break label9;
    }
    label9:
    label162:
    for (;;)
    {
      return;
      if (paramIntent.getIntExtra("pic_result_back_type", -1) == 1)
      {
        String str = paramIntent.getStringExtra("PhotoConst.SELECTED_PATHS");
        int i = paramIntent.getIntExtra("pic_choose_in_node_id", 0);
        paramIntent = findNodeItemById((NodeGroup)this.mNodeGroupList.get(this.mPrePos), i);
        if (paramIntent == null) {
          break;
        }
        if (paramIntent.type == 0) {
          onImageChanged(i, str);
        }
        for (;;)
        {
          if ((TextUtils.isEmpty(str)) || (this.mNodeSourceMap.indexOfKey(i) < 0)) {
            break label162;
          }
          i = this.mNodeSourceMap.get(i);
          if ((this.mSourcePhotoList == null) || (i < 0) || (i >= this.mSourcePhotoList.size())) {
            break;
          }
          this.mSourcePhotoList.remove(i);
          this.mSourcePhotoList.add(i, str);
          return;
          if (paramIntent.type == 2) {
            onFaceImageChanged(i, str, true);
          }
        }
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mIsSavingVideo.booleanValue()) {
      this.mEngine.cancelSave();
    }
  }
  
  public void onProgress(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.mLastUpdateProgressTimeMs > 200L)
    {
      UiThreadUtil.a(new AEVideoShelfEditFragment.14(this, paramInt));
      this.mLastUpdateProgressTimeMs = l;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.mImageViewerSet.iterator();
    while (localIterator.hasNext()) {
      ((ScaleMoveImageViewer)localIterator.next()).clearSeclected();
    }
    localIterator = this.mTextViewerSet.iterator();
    while (localIterator.hasNext()) {
      EditTextViewer localEditTextViewer = (EditTextViewer)localIterator.next();
    }
    localIterator = this.mFaceImageViewerSet.iterator();
    while (localIterator.hasNext()) {
      ((FaceImageViewer)localIterator.next()).clearSeclected();
    }
    clearTempFiles();
  }
  
  public void onSaveScrollInfo(NodeItem paramNodeItem)
  {
    int k = 0;
    NodeGroup localNodeGroup = new NodeGroup();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.mNodeGroupList.size()) {
        break;
      }
      if (paramNodeItem.nodeGroupID == ((NodeGroup)this.mNodeGroupList.get(i)).nodeGroupID) {
        localNodeGroup = (NodeGroup)this.mNodeGroupList.get(i);
      }
      i += 1;
    }
    while (j < localNodeGroup.nodeItemList.size())
    {
      if (paramNodeItem.nodeID == ((NodeItem)localNodeGroup.nodeItemList.get(j)).nodeID)
      {
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).once = paramNodeItem.once;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).matrix.set(paramNodeItem.matrix);
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).bitmap = paramNodeItem.bitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).cropBitmap = paramNodeItem.cropBitmap;
      }
      j += 1;
    }
  }
  
  public void onSaveTextInfo(NodeItem paramNodeItem)
  {
    int k = 0;
    NodeGroup localNodeGroup = new NodeGroup();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.mNodeGroupList.size()) {
        break;
      }
      if (paramNodeItem.nodeGroupID == ((NodeGroup)this.mNodeGroupList.get(i)).nodeGroupID) {
        localNodeGroup = (NodeGroup)this.mNodeGroupList.get(i);
      }
      i += 1;
    }
    while (j < localNodeGroup.nodeItemList.size())
    {
      if (paramNodeItem.nodeID == ((NodeItem)localNodeGroup.nodeItemList.get(j)).nodeID)
      {
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).once = paramNodeItem.once;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).bitmap = paramNodeItem.bitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).cropBitmap = paramNodeItem.cropBitmap;
        ((NodeItem)localNodeGroup.nodeItemList.get(j)).nodeTextMaxCount = paramNodeItem.nodeTextMaxCount;
      }
      j += 1;
    }
  }
  
  public void onStartGenerate()
  {
    AEQLog.b("AEVideoShelfEditFrag", "Merge Video step onStartGenerate");
    this.mGenerateBegin = System.currentTimeMillis();
    UiThreadUtil.a(new AEVideoShelfEditFragment.13(this));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    initData();
    initView();
    initSoftInputMode();
    this.outputDir = AEPath.PLAY.CACHE.c;
    paramView = new File(this.outputDir);
    if (!paramView.exists()) {
      paramView.mkdirs();
    }
  }
  
  public void showDownloadDialog()
  {
    showLoading(getResources().getString(2131689820));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfEditFragment
 * JD-Core Version:    0.7.0.1
 */