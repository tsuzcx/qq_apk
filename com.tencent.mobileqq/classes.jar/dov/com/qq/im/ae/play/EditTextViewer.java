package dov.com.qq.im.ae.play;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.edit.NodeText;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import java.io.File;
import org.light.device.LightDeviceUtils;

public class EditTextViewer
  extends ImageView
  implements View.OnClickListener
{
  private static final int DEFAUT_TEXT_MAX_COUNT = 10;
  private static final String TAG = EditTextViewer.class.getSimpleName();
  private EditTextViewer.OnDownloadDialogListener downloadDialogLister;
  private boolean inited = false;
  private boolean isAnimationPlaying = false;
  private boolean isFirstRender = true;
  private EditTextViewer.OnSaveTextInfoListener listener;
  private int mActionBarHeight = 0;
  private Activity mActivity;
  private LayerDrawable mAnimationDrawable;
  private Drawable mAnimationSolidDrawable;
  private Bitmap mBlankBitmap;
  private EditTextDialog mEditTextDialog;
  private boolean mIsTextSelected = false;
  private String mLastUseText;
  private Matrix mMatrix = new Matrix();
  private NodeItem mNodeItem = new NodeItem();
  private String mTemplateID;
  private ValueAnimator mValueAnimator;
  private String materialId;
  
  public EditTextViewer(Context paramContext)
  {
    super(paramContext);
    this.mActivity = ((Activity)paramContext);
    setOnClickListener(this);
    this.isFirstRender = true;
    setBackgroundDrawable(getResources().getDrawable(2130837714));
    this.mAnimationDrawable = ((LayerDrawable)getResources().getDrawable(2130837713));
    this.mAnimationSolidDrawable = this.mAnimationDrawable.findDrawableByLayerId(2131368809);
  }
  
  private boolean deleteSingleFile(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.exists())
    {
      bool1 = bool2;
      if (paramString.isFile())
      {
        bool1 = bool2;
        if (paramString.delete()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void drawAnimationIfNeed(Canvas paramCanvas)
  {
    if (!this.isAnimationPlaying) {
      return;
    }
    this.mAnimationDrawable.setBounds(0, 0, getWidth(), getHeight());
    this.mAnimationDrawable.draw(paramCanvas);
  }
  
  private void drawBlankText()
  {
    this.mNodeItem.bitmap = this.mBlankBitmap;
  }
  
  private void drawText() {}
  
  private String getValue()
  {
    return "";
  }
  
  private void hideDownloadDialog()
  {
    if (this.downloadDialogLister != null) {
      this.downloadDialogLister.hideDownloadDialog();
    }
  }
  
  private void onGetFontDataSuccess(GetFontDataRsp paramGetFontDataRsp)
  {
    saveFontFile(getContext(), paramGetFontDataRsp.FontData);
  }
  
  private String saveFontFile(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "";
    }
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "temp.ttf";
    FileUtils.a(paramArrayOfByte, paramContext);
    return paramContext;
  }
  
  private void showDownloadDialog()
  {
    if (this.downloadDialogLister != null) {
      this.downloadDialogLister.showDownloadDialog();
    }
  }
  
  private void showTextEditDlg() {}
  
  private void toastInUIThread(int paramInt)
  {
    this.mActivity.runOnUiThread(new EditTextViewer.1(this, paramInt));
  }
  
  private void updateParams()
  {
    this.mNodeItem.cropBitmap = null;
    if (this.mNodeItem.bitmap != null) {
      setImageBitmap(this.mNodeItem.bitmap);
    }
    if (this.listener != null) {
      this.listener.onSaveTextInfo(this.mNodeItem);
    }
    setTextSelected(true);
    this.isFirstRender = false;
  }
  
  public void clearBitmaps()
  {
    if ((this.mNodeItem.bitmap != null) && (!this.mNodeItem.bitmap.isRecycled())) {
      this.mNodeItem.bitmap.recycle();
    }
    if ((this.mNodeItem.cropBitmap != null) && (!this.mNodeItem.cropBitmap.isRecycled())) {
      this.mNodeItem.cropBitmap.recycle();
    }
    setImageBitmap(null);
    clearTextWMElement();
    this.inited = false;
  }
  
  public void clearTextWMElement() {}
  
  public NodeItem getNode()
  {
    return this.mNodeItem;
  }
  
  public int getNodeGroupID()
  {
    return this.mNodeItem.nodeGroupID;
  }
  
  public void initTextWMElement()
  {
    this.inited = true;
    if (this.mNodeItem.nodeTextMaxCount <= 0) {
      this.mNodeItem.nodeTextMaxCount = 10;
    }
  }
  
  public void onClick(View paramView)
  {
    if (!this.inited) {
      initTextWMElement();
    }
    showTextEditDlg();
    setTextSelected(false);
    AEBaseDataReporter.a().f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    label197:
    for (;;)
    {
      try
      {
        int m;
        int i;
        int n;
        int k;
        if ((this.mNodeItem.bitmap != null) && (getWidth() != 0) && (getHeight() != 0))
        {
          m = this.mNodeItem.bitmap.getWidth();
          i = this.mNodeItem.bitmap.getHeight();
          n = getWidth();
          k = getHeight();
          if (this.mNodeItem.nodeTextGroup == null) {
            break label197;
          }
          if ("left".equals(this.mNodeItem.nodeTextGroup.alignment))
          {
            i = k / 2 - i / 2;
            this.mMatrix.postTranslate(j, i);
            setImageMatrix(this.mMatrix);
          }
        }
        else
        {
          super.onDraw(paramCanvas);
          drawAnimationIfNeed(paramCanvas);
          return;
        }
        if ("right".equals(this.mNodeItem.nodeTextGroup.alignment))
        {
          j = n - m;
          i = k / 2 - i / 2;
        }
        else
        {
          j = n / 2 - m / 2;
          k /= 2;
          i /= 2;
          i = k - i;
          continue;
          i = 0;
        }
      }
      catch (Throwable paramCanvas)
      {
        return;
      }
    }
  }
  
  public void renderAndSaveTexture(String paramString)
  {
    if (!LightDeviceUtils.isNetworkAvailable(AEModule.getContext())) {
      QQToast.a(getContext(), 2131689822, 1).a();
    }
    while (this.inited) {
      return;
    }
    initTextWMElement();
  }
  
  public Bitmap renderBitmap()
  {
    if (!this.inited) {
      initTextWMElement();
    }
    return null;
  }
  
  public void setActionBarHeight(int paramInt)
  {
    this.mActionBarHeight = paramInt;
  }
  
  public void setMaterialId(String paramString)
  {
    this.materialId = paramString;
  }
  
  public void setNodeBitmap(Bitmap paramBitmap)
  {
    this.mNodeItem.bitmap = paramBitmap;
  }
  
  public void setNodeInfo(NodeItem paramNodeItem)
  {
    this.mNodeItem.nodeID = paramNodeItem.nodeID;
    this.mNodeItem.nodeGroupID = paramNodeItem.nodeGroupID;
    this.mNodeItem.once = paramNodeItem.once;
    this.mNodeItem.maskRect = paramNodeItem.maskRect;
    this.mNodeItem.nodeTextMaxCount = paramNodeItem.nodeTextMaxCount;
    this.mNodeItem.zIndex = paramNodeItem.zIndex;
    this.mNodeItem.nodeTextGroup.copyFrom(paramNodeItem.nodeTextGroup);
  }
  
  public void setOnDownloadDialogListener(EditTextViewer.OnDownloadDialogListener paramOnDownloadDialogListener)
  {
    this.downloadDialogLister = paramOnDownloadDialogListener;
  }
  
  public void setOnSaveTextInfoListener(EditTextViewer.OnSaveTextInfoListener paramOnSaveTextInfoListener)
  {
    this.listener = paramOnSaveTextInfoListener;
  }
  
  public void setTemplateID(String paramString)
  {
    this.mTemplateID = paramString;
  }
  
  public void setTextSelected(boolean paramBoolean)
  {
    this.mIsTextSelected = paramBoolean;
  }
  
  public void startAnimaterIfNeed()
  {
    if (this.mValueAnimator == null)
    {
      this.mValueAnimator = ValueAnimator.ofInt(new int[] { 150, 0 });
      this.mValueAnimator.setDuration(700L);
      this.mValueAnimator.setRepeatCount(4);
      this.mValueAnimator.setInterpolator(new DecelerateInterpolator());
      this.mValueAnimator.setRepeatMode(2);
      this.mValueAnimator.addUpdateListener(new EditTextViewer.2(this));
      this.mValueAnimator.addListener(new EditTextViewer.3(this));
    }
    if (this.mValueAnimator.isRunning()) {
      this.mValueAnimator.cancel();
    }
    this.mValueAnimator.start();
  }
  
  public void updateMatrix(int paramInt1, int paramInt2)
  {
    int i = 0;
    int k = this.mNodeItem.bitmap.getWidth();
    int j = this.mNodeItem.bitmap.getHeight();
    if (this.mNodeItem.nodeTextGroup != null) {
      if ("left".equals(this.mNodeItem.nodeTextGroup.alignment))
      {
        paramInt1 = paramInt2 / 2 - j / 2;
        paramInt2 = i;
      }
    }
    for (;;)
    {
      this.mMatrix.postTranslate(paramInt2, paramInt1);
      setImageMatrix(this.mMatrix);
      return;
      if ("right".equals(this.mNodeItem.nodeTextGroup.alignment))
      {
        i = paramInt1 - k;
        paramInt1 = paramInt2 / 2 - j / 2;
        paramInt2 = i;
      }
      else
      {
        i = paramInt1 / 2 - k / 2;
        paramInt1 = paramInt2 / 2 - j / 2;
        paramInt2 = i;
        continue;
        paramInt1 = 0;
        paramInt2 = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.EditTextViewer
 * JD-Core Version:    0.7.0.1
 */