package dov.com.qq.im.ae.play;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import blup;
import bmbc;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.openapi.model.TextWMElement;
import com.tencent.ttpic.openapi.util.WMTextDrawer;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.edit.NodeText;
import java.io.File;

public class EditTextViewer
  extends ImageView
  implements View.OnClickListener
{
  private static final int DEFAUT_TEXT_MAX_COUNT = 10;
  private static final String TAG = EditTextViewer.class.getSimpleName();
  private EditTextViewer.OnDownloadDialogListener downloadDialogLister;
  private boolean inited;
  private boolean isAnimationPlaying;
  private boolean isFirstRender = true;
  private EditTextViewer.OnSaveTextInfoListener listener;
  private int mActionBarHeight;
  private Activity mActivity;
  private LayerDrawable mAnimationDrawable;
  private Drawable mAnimationSolidDrawable;
  private Bitmap mBlankBitmap;
  private EditTextDialog mEditTextDialog;
  private boolean mIsTextSelected;
  private String mLastUseText;
  private Matrix mMatrix = new Matrix();
  private NodeItem mNodeItem = new NodeItem();
  private String mTemplateID;
  private TextWMElement mTextWMElement = new TextWMElement();
  private ValueAnimator mValueAnimator;
  private String materialId;
  
  public EditTextViewer(Context paramContext)
  {
    super(paramContext);
    this.mActivity = ((Activity)paramContext);
    setOnClickListener(this);
    this.isFirstRender = true;
    setBackgroundDrawable(getResources().getDrawable(2130837691));
    this.mAnimationDrawable = ((LayerDrawable)getResources().getDrawable(2130837690));
    this.mAnimationSolidDrawable = this.mAnimationDrawable.findDrawableByLayerId(2131368422);
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
    if (this.mBlankBitmap == null) {
      this.mBlankBitmap = Bitmap.createBitmap(this.mTextWMElement.width, this.mTextWMElement.height, Bitmap.Config.ARGB_8888);
    }
    this.mNodeItem.bitmap = this.mBlankBitmap;
  }
  
  private void drawText()
  {
    String str1 = this.mTextWMElement.fontName;
    String str2 = this.mTextWMElement.userValue;
    AppInterface localAppInterface = QQStoryContext.a();
    localAppInterface.addObserver(new EditTextViewer.4(this, localAppInterface, str2));
    ((blup)localAppInterface.getBusinessHandler(3)).a(str1, str2);
  }
  
  private String getValue()
  {
    String str;
    if (this.mTextWMElement.userValue != null) {
      str = this.mTextWMElement.userValue;
    }
    do
    {
      return str;
      str = "";
    } while (this.mTextWMElement.fmtstr == null);
    return new String(this.mTextWMElement.fmtstr);
  }
  
  private void hideDownloadDialog()
  {
    if (this.downloadDialogLister != null) {
      this.downloadDialogLister.hideDownloadDialog();
    }
  }
  
  private void onGetFontDataSuccess(GetFontDataRsp paramGetFontDataRsp)
  {
    paramGetFontDataRsp = saveFontFile(getContext(), paramGetFontDataRsp.FontData);
    if (!TextUtils.isEmpty(paramGetFontDataRsp))
    {
      this.mTextWMElement.fontName = paramGetFontDataRsp;
      this.mTextWMElement.isLocalFont = false;
    }
    try
    {
      this.mTextWMElement.wmTextDrawer.drawTextToBitmap(this.mTextWMElement, getValue(), false, true);
      this.mNodeItem.bitmap = this.mTextWMElement.getBitmap();
      if (!TextUtils.isEmpty(paramGetFontDataRsp))
      {
        deleteSingleFile(paramGetFontDataRsp);
        this.mTextWMElement.fontName = this.mNodeItem.nodeTextGroup.fontName;
        this.mTextWMElement.isLocalFont = true;
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.e(TAG, "drawText of drawTextToBitmap Error, maybe use a recycle bitmap!");
      }
    }
  }
  
  private String saveFontFile(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "";
    }
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "temp.ttf";
    FileUtils.writeFile(paramArrayOfByte, paramContext);
    return paramContext;
  }
  
  private void showDownloadDialog()
  {
    if (this.downloadDialogLister != null) {
      this.downloadDialogLister.showDownloadDialog();
    }
  }
  
  private void showTextEditDlg()
  {
    if (this.mTextWMElement != null)
    {
      this.mEditTextDialog = new EditTextDialog(this.mActivity);
      this.mEditTextDialog.setEditMaxLength(this.mNodeItem.nodeTextMaxCount);
      this.mEditTextDialog.setDefaultEditText(this.mTextWMElement, this.isFirstRender);
      this.mEditTextDialog.setOnConfirmClickListener(new EditTextViewer.1(this));
      this.mEditTextDialog.show();
      this.mEditTextDialog.setOnDismissListener(new EditTextViewer.2(this));
    }
  }
  
  private void toastInUIThread(int paramInt)
  {
    this.mActivity.runOnUiThread(new EditTextViewer.5(this, paramInt));
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
  
  public void clearTextWMElement()
  {
    if (this.mTextWMElement != null) {
      this.mTextWMElement.clear();
    }
  }
  
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
    boolean bool2 = false;
    if (this.mTextWMElement == null)
    {
      this.inited = false;
      return;
    }
    label64:
    boolean bool1;
    if (TextUtils.isEmpty(this.mNodeItem.nodeTextGroup.id))
    {
      this.mTextWMElement.id = ("text" + this.mNodeItem.nodeID);
      this.mTextWMElement.relativeID = this.mNodeItem.nodeTextGroup.relativeID;
      this.mTextWMElement.relativeAnchor = this.mNodeItem.nodeTextGroup.relativeAnchor;
      this.mTextWMElement.anchor = this.mNodeItem.nodeTextGroup.anchor;
      this.mTextWMElement.offsetX = this.mNodeItem.nodeTextGroup.offsetX;
      this.mTextWMElement.offsetY = this.mNodeItem.nodeTextGroup.offsetY;
      this.mTextWMElement.width = this.mNodeItem.nodeTextGroup.width;
      this.mTextWMElement.height = this.mNodeItem.nodeTextGroup.height;
      this.mTextWMElement.edittype = this.mNodeItem.nodeTextGroup.editType;
      this.mTextWMElement.fontSize = this.mNodeItem.nodeTextGroup.fontSize;
      this.mTextWMElement.fontFit = this.mNodeItem.nodeTextGroup.fontFit;
      this.mTextWMElement.wmtype = this.mNodeItem.nodeTextGroup.wmtype;
      this.mTextWMElement.fmtstr = this.mNodeItem.nodeTextGroup.fmtstr;
      this.mTextWMElement.fontName = this.mNodeItem.nodeTextGroup.fontName;
      this.mTextWMElement.color = this.mNodeItem.nodeTextGroup.color;
      this.mTextWMElement.alignment = this.mNodeItem.nodeTextGroup.alignment;
      this.mTextWMElement.vertical = this.mNodeItem.nodeTextGroup.vertical;
      TextWMElement localTextWMElement = this.mTextWMElement;
      if (this.mNodeItem.nodeTextGroup.fontBold != 0) {
        break label592;
      }
      bool1 = false;
      label356:
      localTextWMElement.fontBold = bool1;
      localTextWMElement = this.mTextWMElement;
      if (this.mNodeItem.nodeTextGroup.fontItalics != 0) {
        break label597;
      }
      bool1 = bool2;
      label381:
      localTextWMElement.fontItalics = bool1;
      this.mTextWMElement.strokeColor = this.mNodeItem.nodeTextGroup.strokeColor;
      this.mTextWMElement.strokeSize = this.mNodeItem.nodeTextGroup.strokeSize;
      this.mTextWMElement.outerStrokeColor = this.mNodeItem.nodeTextGroup.outerStrokeColor;
      this.mTextWMElement.outerStrokeSize = this.mNodeItem.nodeTextGroup.outerStrokeSize;
      if (!TextUtils.isEmpty(this.mNodeItem.nodeTextGroup.shadowColor)) {
        break label602;
      }
    }
    label592:
    label597:
    label602:
    for (this.mTextWMElement.shadowColor = "#00000000";; this.mTextWMElement.shadowColor = this.mNodeItem.nodeTextGroup.shadowColor)
    {
      this.mTextWMElement.shadowDx = this.mNodeItem.nodeTextGroup.shadowDx;
      this.mTextWMElement.shadowDy = this.mNodeItem.nodeTextGroup.shadowDy;
      this.mTextWMElement.blurAmount = this.mNodeItem.nodeTextGroup.blurAmount;
      this.mTextWMElement.numberSource = "";
      this.mTextWMElement.init();
      this.inited = true;
      if (this.mNodeItem.nodeTextMaxCount > 0) {
        break;
      }
      this.mNodeItem.nodeTextMaxCount = 10;
      return;
      this.mTextWMElement.id = this.mNodeItem.nodeTextGroup.id;
      break label64;
      bool1 = true;
      break label356;
      bool1 = true;
      break label381;
    }
  }
  
  public void onClick(View paramView)
  {
    if (!this.inited) {
      initTextWMElement();
    }
    showTextEditDlg();
    setTextSelected(false);
    bmbc.a().f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDraw(Canvas paramCanvas)
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
    if (!DeviceUtils.isNetworkAvailable(AEModule.getContext())) {
      QQToast.a(getContext(), 2131689773, 1).a();
    }
    label131:
    for (;;)
    {
      return;
      if (!this.inited) {
        initTextWMElement();
      }
      if (TextUtils.isEmpty(paramString)) {}
      for (this.mTextWMElement.userValue = "";; this.mTextWMElement.userValue = paramString)
      {
        if (this.mTextWMElement.userValue.equals(this.mLastUseText)) {
          break label131;
        }
        if (!TextUtils.isEmpty(this.mTextWMElement.userValue)) {
          break label133;
        }
        this.mLastUseText = this.mTextWMElement.userValue;
        drawBlankText();
        updateParams();
        if (this.listener == null) {
          break;
        }
        this.listener.onCompleteTextEdit(this.mNodeItem);
        return;
      }
    }
    label133:
    showDownloadDialog();
    new Thread(new EditTextViewer.3(this)).start();
  }
  
  public Bitmap renderBitmap()
  {
    if (!this.inited) {
      initTextWMElement();
    }
    try
    {
      this.mTextWMElement.wmTextDrawer.drawTextToBitmap(this.mTextWMElement, getValue(), false, true);
      return this.mTextWMElement.getBitmap();
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.e(TAG, "renderBitmap of drawTextToBitmap Error, maybe use a recycle bitmap!");
      }
    }
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
      this.mValueAnimator.addUpdateListener(new EditTextViewer.6(this));
      this.mValueAnimator.addListener(new EditTextViewer.7(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.EditTextViewer
 * JD-Core Version:    0.7.0.1
 */