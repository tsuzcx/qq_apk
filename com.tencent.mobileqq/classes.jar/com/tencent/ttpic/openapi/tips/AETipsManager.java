package com.tencent.ttpic.openapi.tips;

import android.os.Handler;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.cosfun.CosFun;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.AR_MATERIAL_TYPE;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AETipsManager
{
  public static final int MSG_CP_MATERIAL_DETECT_LESS_THAN_TWO_FACE = 1009;
  public static final int MSG_CP_MATERIAL_DETECT_TWO_OR_MORE_THAN_TWO_FACE = 1010;
  public static final int MSG_HIDE_NO_BODY_TIPS = 1019;
  public static final int MSG_HIDE_NO_FACE_TIPS = 1018;
  public static final int MSG_SHOW_NO_BODY_TIPS = 1017;
  public static final int MSG_SHOW_NO_FACE_TIPS = 1004;
  private static final String TAG = AETipsManager.class.getSimpleName();
  private static final AETipsManager ourInstance = new AETipsManager();
  private HashMap<Integer, String> actionTipsMap = new HashMap();
  private String customTipIcon;
  private String customTipText;
  private String defaultTipText;
  private double faceDetScale;
  private VideoPreviewFaceOutlineDetector faceDetector;
  private int height;
  private boolean isPhoneSupport = true;
  private boolean isShowBody;
  private boolean isShowFace;
  private boolean mIsBodyBeautyItemEnabled = false;
  private boolean mIsCosmeticItemEnabled = false;
  private boolean mIsVideoItemEnabled = false;
  private VideoMaterial mVideoMaterial;
  private Handler uiHandler;
  private int width;
  
  public static AETipsManager getInstance()
  {
    return ourInstance;
  }
  
  public void checkVideoShowBodyView()
  {
    boolean bool;
    if ((this.mVideoMaterial != null) && (VideoMaterialUtil.isBodyDetectMaterial(this.mVideoMaterial)))
    {
      if ((this.mVideoMaterial == null) || ((!this.mVideoMaterial.isSegmentRequired()) && (!this.mVideoMaterial.isNeedFreezeFrame()) && (!this.mVideoMaterial.hasMultiViewer()))) {
        break label72;
      }
      bool = this.isShowBody;
    }
    for (;;)
    {
      showBodyTips(bool, this.uiHandler, 1017);
      return;
      label72:
      if (!this.isShowBody) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public void checkVideoShowFaceView()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((this.mVideoMaterial != null) && (VideoMaterialUtil.isBodyDetectMaterial(this.mVideoMaterial))) {
      return;
    }
    if (this.mVideoMaterial != null) {
      this.mIsVideoItemEnabled = true;
    }
    label82:
    Object localObject;
    while ((this.mVideoMaterial != null) && (getFaceDetector() != null) && (this.mVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_MORPHING.value)) {
      if (!getFaceDetector().detectExpression(PTFaceAttr.PTExpression.FACE_DETECT.value))
      {
        bool1 = true;
        showFaceTips(bool1, this.uiHandler, 1004);
        return;
        this.mIsVideoItemEnabled = false;
      }
      else
      {
        localObject = getFaceDetector().getFaceAngles(0);
        if ((localObject == null) || (localObject.length < 2)) {
          break label786;
        }
      }
    }
    label776:
    label779:
    label786:
    for (bool1 = PTFaceAttr.isPositiveFace((float[])localObject, getFaceDetector().getAllPoints(0), this.width, this.height, this.faceDetScale);; bool1 = false)
    {
      if (!bool1)
      {
        bool1 = true;
        break label82;
        if ((this.mVideoMaterial != null) && ((this.mVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH_DUP.value) || (this.mVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH.value)))
        {
          if ((getFaceDetector() != null) && (!getFaceDetector().detectExpression(PTFaceAttr.PTExpression.FACE_DETECT.value))) {}
          for (;;)
          {
            showFaceTips(bool1, this.uiHandler, 1004);
            return;
            bool1 = false;
          }
        }
        if ((this.mVideoMaterial != null) && (this.mVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.NORMAL.value))
        {
          localObject = this.mVideoMaterial.getItemList();
          if (localObject == null) {
            break label776;
          }
          localObject = ((List)localObject).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (((StickerItem)((Iterator)localObject).next()).type != VideoFilterFactory.POSITION_TYPE.DYNAMIC.type);
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label779;
          }
          if ((getFaceDetector() != null) && (!getFaceDetector().detectExpression(PTFaceAttr.PTExpression.FACE_DETECT.value))) {}
          for (bool1 = bool2;; bool1 = false)
          {
            showFaceTips(bool1, this.uiHandler, 1004);
            return;
          }
          if ((getFaceDetector() != null) && (!getFaceDetector().isLastFrameDetectFaces()))
          {
            if ((this.mIsCosmeticItemEnabled) && (this.mIsBodyBeautyItemEnabled))
            {
              sendNoFaceMessageDelay(this.uiHandler, 1004);
              return;
            }
            if (this.mIsCosmeticItemEnabled)
            {
              sendNoFaceMessageDelay(this.uiHandler, 1004);
              return;
            }
            if ((this.mIsBodyBeautyItemEnabled) && (!this.mIsVideoItemEnabled))
            {
              removeNoFaceMessageShow(this.uiHandler, 1004);
              return;
            }
            if ((this.mIsVideoItemEnabled) && (this.mVideoMaterial != null) && (this.mVideoMaterial.needFaceInfo()))
            {
              sendNoFaceMessageDelay(this.uiHandler, 1004);
              return;
            }
            Log.i(TAG, "checkVideoShowFaceView VideoItem[" + this.mIsVideoItemEnabled + "] Cosmetic[" + this.mIsCosmeticItemEnabled + "] bodyBeauty[" + this.mIsBodyBeautyItemEnabled + "]");
            if (this.uiHandler == null) {
              break;
            }
            if (this.uiHandler.hasMessages(1004))
            {
              this.uiHandler.removeMessages(1004);
              this.uiHandler.sendEmptyMessage(1018);
            }
            if (!this.uiHandler.hasMessages(1017)) {
              break;
            }
            this.uiHandler.removeMessages(1017);
            this.uiHandler.sendEmptyMessage(1019);
            return;
          }
          if (getFaceDetector() == null) {
            break;
          }
          i = getFaceDetector().getFaceCount();
          if ((this.uiHandler != null) && (this.uiHandler.hasMessages(1004)))
          {
            this.uiHandler.removeMessages(1004);
            this.uiHandler.sendEmptyMessage(1018);
          }
          if ((this.uiHandler == null) || (!VideoMaterialUtil.isCpValueMaterial(this.mVideoMaterial))) {
            break;
          }
          if (i < 2)
          {
            if (this.uiHandler.hasMessages(1009)) {
              break;
            }
            this.uiHandler.sendEmptyMessage(1009);
            return;
          }
          if (this.uiHandler.hasMessages(1009)) {
            this.uiHandler.removeMessages(1009);
          }
          if (this.uiHandler.hasMessages(1010)) {
            break;
          }
          this.uiHandler.sendEmptyMessage(1010);
          return;
        }
        break;
      }
      bool1 = false;
      break label82;
    }
  }
  
  public String getActionTipString(int paramInt)
  {
    if (this.actionTipsMap == null) {
      return "";
    }
    if (this.actionTipsMap.containsKey(Integer.valueOf(paramInt))) {
      return (String)this.actionTipsMap.get(Integer.valueOf(paramInt));
    }
    return "";
  }
  
  public String getCustomTipIcon()
  {
    return this.customTipIcon;
  }
  
  public String getCustomTipText()
  {
    return this.customTipText;
  }
  
  public VideoPreviewFaceOutlineDetector getFaceDetector()
  {
    return this.faceDetector;
  }
  
  public VideoMaterial getVideoMaterial()
  {
    return this.mVideoMaterial;
  }
  
  public void isBodyDetected(boolean paramBoolean)
  {
    this.isShowBody = paramBoolean;
  }
  
  public void isPhoneSupport(boolean paramBoolean)
  {
    this.isPhoneSupport = paramBoolean;
  }
  
  public void pickUpTheBestTips(VideoMaterial paramVideoMaterial)
  {
    this.mVideoMaterial = paramVideoMaterial;
    if ((VideoMaterialUtil.isCosFunMaterial(this.mVideoMaterial)) && (this.mVideoMaterial.getCosFun().getTipsAnim() != null))
    {
      this.customTipText = "";
      this.customTipIcon = "";
    }
    while (this.mVideoMaterial == null) {
      return;
    }
    if ((!this.isPhoneSupport) || (!DeviceUtils.hasDeviceNormal(AEModule.getContext())))
    {
      this.customTipText = "当前机型不支持该挂件特效";
      this.customTipIcon = "";
      return;
    }
    if (((this.mVideoMaterial.getTipsIcon() != null) && (!this.mVideoMaterial.getTipsIcon().equals(""))) || ((this.mVideoMaterial.getTipsText() != null) && (!this.mVideoMaterial.getTipsText().equals(""))))
    {
      this.customTipIcon = this.mVideoMaterial.getTipsIcon();
      this.customTipText = this.mVideoMaterial.getTipsText();
      return;
    }
    int j = this.mVideoMaterial.getTriggerType();
    int i = j;
    if (j <= 0)
    {
      i = j;
      if (this.mVideoMaterial.getArParticleType() == VideoMaterialUtil.AR_MATERIAL_TYPE.CLICKABLE.value) {
        i = PTFaceAttr.PTExpression.TRY_CLICK_SCREEN.value;
      }
    }
    this.customTipText = getActionTipString(i);
    this.customTipIcon = "";
  }
  
  public void removeNoFaceMessageShow(Handler paramHandler, int paramInt)
  {
    if ((paramHandler != null) && (paramHandler.hasMessages(paramInt)))
    {
      paramHandler.removeMessages(paramInt);
      paramHandler.sendEmptyMessage(1018);
    }
  }
  
  public void sendNoFaceMessageDelay(Handler paramHandler, int paramInt)
  {
    if ((paramHandler != null) && (!paramHandler.hasMessages(paramInt)))
    {
      paramHandler.removeMessages(1018);
      paramHandler.sendEmptyMessageDelayed(paramInt, 2000L);
    }
  }
  
  public void setFaceDetector(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    this.faceDetector = paramVideoPreviewFaceOutlineDetector;
  }
  
  public void setUIHandler(Handler paramHandler, int paramInt1, int paramInt2, double paramDouble)
  {
    this.uiHandler = paramHandler;
    this.width = paramInt1;
    this.height = paramInt2;
    this.faceDetScale = paramDouble;
  }
  
  public void setVideoMaterial(VideoMaterial paramVideoMaterial)
  {
    try
    {
      pickUpTheBestTips(paramVideoMaterial);
      return;
    }
    finally
    {
      paramVideoMaterial = finally;
      throw paramVideoMaterial;
    }
  }
  
  public void showBodyTips(boolean paramBoolean, Handler paramHandler, int paramInt)
  {
    if (paramBoolean) {
      if ((paramHandler != null) && (!paramHandler.hasMessages(paramInt)))
      {
        paramHandler.removeMessages(1019);
        paramHandler.sendEmptyMessageDelayed(paramInt, 2000L);
      }
    }
    while ((paramHandler == null) || (!paramHandler.hasMessages(paramInt))) {
      return;
    }
    paramHandler.removeMessages(paramInt);
    paramHandler.sendEmptyMessage(1019);
  }
  
  public void showFaceTips(boolean paramBoolean, Handler paramHandler, int paramInt)
  {
    if (paramBoolean) {
      if ((paramHandler != null) && (!paramHandler.hasMessages(paramInt)))
      {
        paramHandler.removeMessages(1018);
        paramHandler.sendEmptyMessageDelayed(paramInt, 2000L);
      }
    }
    while ((paramHandler == null) || (!paramHandler.hasMessages(paramInt))) {
      return;
    }
    paramHandler.removeMessages(paramInt);
    paramHandler.sendEmptyMessage(1018);
  }
  
  public void updateActionTipsString(HashMap<Integer, String> paramHashMap)
  {
    this.actionTipsMap = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.tips.AETipsManager
 * JD-Core Version:    0.7.0.1
 */