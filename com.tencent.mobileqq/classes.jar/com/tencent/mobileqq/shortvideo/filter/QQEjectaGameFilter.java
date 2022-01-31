package com.tencent.mobileqq.shortvideo.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.ttpic.openapi.model.BuckleFrameItem;
import com.tencent.util.PhoneProperty;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class QQEjectaGameFilter
  extends QQBaseFilter
{
  private boolean isInited = false;
  private int lastFaceCanvasTextureId;
  private BuckleFrameItem mBbuckleFrameItem = new BuckleFrameItem();
  private LinkedList<FaceInfo> mCurrentFaceInfo;
  public int mDetectFaceCount = 0;
  QQEjectaGameFilter.EjectaTextureCallBack mEjectaTextureCallBack;
  private RenderBuffer mFaceRenderBuffer;
  private VideoFilterBase mFlipFilter = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  public Frame mFlipFrame = new Frame();
  private int[] mFlipTextureID = new int[1];
  private int mNodType = 0;
  private QQGameBuckleFaceFilter mQQGameBuckleFaceFilter;
  private RenderBuffer mRenderFBO;
  private int mSelectFaceIndex = -1;
  private int mShookType = 0;
  private int[] tex = { -1 };
  TextureRender textureRender;
  private int videoHeight = 1280;
  private int videoWidth = 720;
  
  public QQEjectaGameFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    initTexture();
    this.mQQGameBuckleFaceFilter = new QQGameBuckleFaceFilter();
    this.mQQGameBuckleFaceFilter.init();
  }
  
  private int analysisNodHead(LinkedList<FaceInfo> paramLinkedList)
  {
    int j = 0;
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 1)) {
      return 0;
    }
    FaceInfo localFaceInfo = (FaceInfo)paramLinkedList.getFirst();
    int i;
    if ((localFaceInfo.pitch > 5.0F) && (hasNod(paramLinkedList, true))) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramLinkedList.clear();
        paramLinkedList.addFirst(localFaceInfo);
      }
      return i;
      i = j;
      if (localFaceInfo.pitch < -5.0F)
      {
        i = j;
        if (hasNod(paramLinkedList, false)) {
          i = -1;
        }
      }
    }
  }
  
  private int analysisShookHead(LinkedList<FaceInfo> paramLinkedList)
  {
    int j = 0;
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 1)) {
      return 0;
    }
    FaceInfo localFaceInfo = (FaceInfo)paramLinkedList.getFirst();
    int i;
    if ((localFaceInfo.yaw > 5.0F) && (hasShook(paramLinkedList, true))) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramLinkedList.clear();
        paramLinkedList.addFirst(localFaceInfo);
      }
      return i;
      i = j;
      if (localFaceInfo.yaw < -5.0F)
      {
        i = j;
        if (hasShook(paramLinkedList, false)) {
          i = -1;
        }
      }
    }
  }
  
  private void buckleFaceToFaceCanvas(List<PointF> paramList, float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    flipInputTexture();
    int i = paramArrayOfInt[0];
    int j = paramArrayOfInt[1];
    int k = paramArrayOfInt[2];
    if ((this.mFaceRenderBuffer == null) || (this.lastFaceCanvasTextureId != i))
    {
      if (this.mFaceRenderBuffer != null) {
        this.mFaceRenderBuffer.destroy();
      }
      this.mFaceRenderBuffer = new RenderBuffer(j, k, 33986);
      this.mFaceRenderBuffer.setTexId(i);
    }
    this.lastFaceCanvasTextureId = i;
    this.mFaceRenderBuffer.bind();
    this.mBbuckleFrameItem.size = new double[] { j, k };
    this.mBbuckleFrameItem.nosePoint = new double[] { j / 2, k / 2 };
    this.mBbuckleFrameItem.faceWidth = j;
    this.mBbuckleFrameItem.faceAngle = 0.0D;
    this.mQQGameBuckleFaceFilter.computeFaceRectAndUpdateShader(paramList, paramArrayOfFloat, this.mBbuckleFrameItem);
    this.mQQGameBuckleFaceFilter.drawTexture(this.mFlipTextureID[0]);
    this.mFaceRenderBuffer.unbind();
  }
  
  private void detectFaceDirection()
  {
    int j = 0;
    Object localObject = getQQFilterRenderManager();
    if ((localObject == null) || (((QQFilterRenderManager)localObject).getFaceAttr() == null)) {
      return;
    }
    localObject = ((QQFilterRenderManager)localObject).getFaceAttr().getShookFaceInfos();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if ((this.mCurrentFaceInfo == null) || (this.mCurrentFaceInfo.size() == 0) || (this.mDetectFaceCount != ((List)localObject).size()))
      {
        this.mCurrentFaceInfo = ((LinkedList)((List)localObject).get(0));
        this.mSelectFaceIndex = 0;
        this.mShookType = 0;
        this.mNodType = 0;
      }
      if (((this.mShookType == 0) && (this.mNodType == 0)) || (this.mCurrentFaceInfo == null) || (this.mCurrentFaceInfo.size() <= 0)) {
        break label272;
      }
      this.mSelectFaceIndex = selectFace(this.mCurrentFaceInfo, (List)localObject);
      if ((this.mSelectFaceIndex < 0) || (this.mSelectFaceIndex >= ((List)localObject).size())) {
        break label272;
      }
      this.mCurrentFaceInfo = ((LinkedList)((List)localObject).get(this.mSelectFaceIndex));
    }
    label272:
    for (int i = 1;; i = 0)
    {
      this.mShookType = 0;
      this.mNodType = 0;
      if (i == 0)
      {
        this.mShookType = analysisShookHead(this.mCurrentFaceInfo);
        this.mNodType = analysisNodHead(this.mCurrentFaceInfo);
      }
      if (localObject == null) {}
      for (i = j;; i = ((List)localObject).size())
      {
        this.mDetectFaceCount = i;
        this.mEjectaTextureCallBack.onDetectFaceDirection(this.mShookType, this.mNodType);
        return;
        this.mCurrentFaceInfo = null;
        this.mSelectFaceIndex = -1;
        break;
      }
    }
  }
  
  private void flipInputTexture()
  {
    if (!this.isInited) {
      GLES20.glGenTextures(this.mFlipTextureID.length, this.mFlipTextureID, 0);
    }
    try
    {
      this.mFlipFilter.clearGLSLSelf();
      this.mFlipFilter.ApplyGLSLFilter();
      this.mFlipFilter.setRotationAndFlip(0, false, true);
      label44:
      this.isInited = true;
      return;
      this.mFlipFilter.RenderProcess(this.mInputTextureID, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight(), this.mFlipTextureID[0], 0.0D, this.mFlipFrame);
      return;
    }
    catch (Error localError)
    {
      break label44;
    }
  }
  
  private double getWindowScale()
  {
    if ((getQQFilterRenderManager().getFaceDetectWidth() == 0) || (getQQFilterRenderManager().getFilterWidth() == 0)) {
      return 0.25D;
    }
    return getQQFilterRenderManager().getFaceDetectWidth() * 1.0F / getQQFilterRenderManager().getFilterWidth();
  }
  
  private boolean hasNod(LinkedList<FaceInfo> paramLinkedList, boolean paramBoolean)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0)) {
      return false;
    }
    FaceInfo localFaceInfo1 = (FaceInfo)paramLinkedList.getFirst();
    paramLinkedList = paramLinkedList.listIterator();
    while (paramLinkedList.hasNext())
    {
      FaceInfo localFaceInfo2 = (FaceInfo)paramLinkedList.next();
      if (paramBoolean)
      {
        if (localFaceInfo1.pitch - localFaceInfo2.pitch > 10.0F) {
          return true;
        }
      }
      else if (localFaceInfo1.pitch - localFaceInfo2.pitch < -10.0F) {
        return true;
      }
    }
    return false;
  }
  
  private boolean hasShook(LinkedList<FaceInfo> paramLinkedList, boolean paramBoolean)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0)) {
      return false;
    }
    FaceInfo localFaceInfo1 = (FaceInfo)paramLinkedList.getFirst();
    paramLinkedList = paramLinkedList.listIterator();
    while (paramLinkedList.hasNext())
    {
      FaceInfo localFaceInfo2 = (FaceInfo)paramLinkedList.next();
      if (paramBoolean)
      {
        if (localFaceInfo1.yaw - localFaceInfo2.yaw > 10.0F) {
          return true;
        }
      }
      else if (localFaceInfo1.yaw - localFaceInfo2.yaw < -10.0F) {
        return true;
      }
    }
    return false;
  }
  
  private void initTexture()
  {
    if (this.mRenderFBO != null) {
      this.mRenderFBO.destroy();
    }
    if (this.textureRender != null) {
      this.textureRender.release();
    }
    this.mRenderFBO = new RenderBuffer(this.videoWidth, this.videoHeight, 33986);
    this.textureRender = new TextureRender();
  }
  
  private int selectFace(LinkedList<FaceInfo> paramLinkedList, List<LinkedList<FaceInfo>> paramList)
  {
    int k;
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      k = -1;
      return k;
    }
    float f1 = ((PointF)((FaceInfo)paramLinkedList.getFirst()).points.get(9)).x;
    int i = 0;
    label44:
    if (i < paramList.size())
    {
      paramLinkedList = (LinkedList)paramList.get(i);
      float f2;
      int j;
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        f2 = ((PointF)((FaceInfo)paramLinkedList.getFirst()).points.get(9)).x;
        if (this.mShookType != 1) {
          break label139;
        }
        if (f2 <= f1) {
          break label160;
        }
        j = 1;
      }
      for (;;)
      {
        k = i;
        if (j != 0) {
          break;
        }
        i += 1;
        break label44;
        if ((this.mShookType == -1) && (f2 < f1)) {
          j = 1;
        } else {
          j = 0;
        }
      }
    }
    label139:
    label160:
    return -1;
  }
  
  public void onDrawFrame()
  {
    int k = 0;
    if (this.mEjectaTextureCallBack != null) {
      this.tex = this.mEjectaTextureCallBack.onDrawFrame();
    }
    if ((this.tex == null) || (this.tex.length == 0)) {
      this.mOutputTextureID = this.mInputTextureID;
    }
    do
    {
      return;
      i = 0;
      int j = 0;
      while (i < this.tex.length)
      {
        if (this.tex[i] > 0) {
          j = 1;
        }
        i += 1;
      }
      if (j == 0)
      {
        this.mOutputTextureID = this.mInputTextureID;
        return;
      }
      if (this.mEjectaTextureCallBack != null)
      {
        if (this.mEjectaTextureCallBack.hasRegisteredEvent("FaceDirectionDetect")) {
          detectFaceDirection();
        }
        boolean bool = this.mEjectaTextureCallBack.hasRegisteredEvent("FaceDetect");
        int[] arrayOfInt = this.mEjectaTextureCallBack.getFaceCanvasTexture();
        if ((bool) || (arrayOfInt != null))
        {
          List localList1 = getQQFilterRenderManager().getFaceAttr().getAllFacePoints();
          if (bool) {
            this.mEjectaTextureCallBack.onDetectFace(localList1);
          }
          if ((localList1 != null) && (localList1.size() > 0) && (arrayOfInt != null))
          {
            List localList2 = getQQFilterRenderManager().getFaceAttr().getAllFaceAngles();
            if ((localList2 != null) && (!localList2.isEmpty())) {
              buckleFaceToFaceCanvas((List)localList1.get(0), (float[])localList2.get(0), arrayOfInt);
            }
          }
        }
      }
      this.mRenderFBO.bind();
      try
      {
        this.textureRender.drawTexture(3553, this.mInputTextureID, null, null);
        GLES20.glFlush();
        i = k;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.mRenderFBO.unbind();
          this.mOutputTextureID = this.mRenderFBO.getTexId();
          continue;
          i += 1;
        }
      }
      if (i < this.tex.length)
      {
        if (this.tex[i] <= 0) {
          break;
        }
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 771);
        this.textureRender.drawTexture(3553, this.tex[i], null, null);
        GLES20.glDisable(3042);
        break;
      }
      GLES20.glGetError();
      this.mRenderFBO.unbind();
      this.mOutputTextureID = this.mRenderFBO.getTexId();
    } while (!PhoneProperty.instance().isCannotReuseFrameBuffer());
    this.mFlipFrame.clear();
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    this.mQQGameBuckleFaceFilter.updateFilterSize(paramInt1, paramInt2, getWindowScale());
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    this.mFlipFrame.clear();
    this.mFlipFilter.clearGLSLSelf();
    GLES20.glDeleteTextures(1, this.mFlipTextureID, 0);
    if (this.mFaceRenderBuffer != null) {
      this.mFaceRenderBuffer.destroy();
    }
    if (this.mQQGameBuckleFaceFilter != null) {
      this.mQQGameBuckleFaceFilter.destroy();
    }
  }
  
  protected void parseSpecificParam()
  {
    if ((this.mSpecificParam != null) && ((this.mSpecificParam instanceof QQEjectaGameFilter.EjectaTextureCallBack))) {
      this.mEjectaTextureCallBack = ((QQEjectaGameFilter.EjectaTextureCallBack)this.mSpecificParam);
    }
  }
  
  public void updateNextFrame(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    this.tex[0] = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQEjectaGameFilter
 * JD-Core Version:    0.7.0.1
 */