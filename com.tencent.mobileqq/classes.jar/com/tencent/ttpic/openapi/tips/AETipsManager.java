package com.tencent.ttpic.openapi.tips;

import android.os.Handler;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.cosfun.CosFun;
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
  private static final String TAG = "AETipsManager";
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
    VideoMaterial localVideoMaterial = this.mVideoMaterial;
    if ((localVideoMaterial != null) && (localVideoMaterial.needBodyDetect()))
    {
      localVideoMaterial = this.mVideoMaterial;
      boolean bool;
      if ((localVideoMaterial != null) && ((localVideoMaterial.needBodySegment()) || (this.mVideoMaterial.isNeedFreezeFrame()) || (this.mVideoMaterial.hasMultiViewer()))) {
        bool = this.isShowBody;
      } else {
        bool = this.isShowBody ^ true;
      }
      showBodyTips(bool, this.uiHandler, 1017);
    }
  }
  
  public void checkVideoShowFaceView()
  {
    Object localObject = this.mVideoMaterial;
    if ((localObject != null) && (((VideoMaterial)localObject).needBodyDetect())) {
      return;
    }
    localObject = this.mVideoMaterial;
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    if (localObject != null) {
      this.mIsVideoItemEnabled = true;
    } else {
      this.mIsVideoItemEnabled = false;
    }
    if ((this.mVideoMaterial != null) && (getFaceDetector() != null))
    {
      if (!getFaceDetector().detectExpression(PTFaceAttr.PTExpression.FACE_DETECT.value))
      {
        bool1 = bool2;
      }
      else
      {
        localObject = getFaceDetector().getFaceAngles(0);
        if ((localObject != null) && (localObject.length >= 2)) {
          bool1 = PTFaceAttr.isPositiveFace((float[])localObject, getFaceDetector().getAllPoints(0), this.width, this.height, this.faceDetScale);
        } else {
          bool1 = false;
        }
        if (!bool1) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      showFaceTips(bool1, this.uiHandler, 1004);
      return;
    }
    localObject = this.mVideoMaterial;
    if (localObject != null)
    {
      if ((getFaceDetector() == null) || (getFaceDetector().detectExpression(PTFaceAttr.PTExpression.FACE_DETECT.value))) {
        bool1 = false;
      }
      showFaceTips(bool1, this.uiHandler, 1004);
      return;
    }
    int i;
    if (localObject != null)
    {
      localObject = ((VideoMaterial)localObject).getItemList();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((StickerItem)((Iterator)localObject).next()).type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type)
          {
            i = 1;
            break label280;
          }
        }
      }
      i = 0;
      label280:
      if (i != 0)
      {
        if ((getFaceDetector() != null) && (!getFaceDetector().detectExpression(PTFaceAttr.PTExpression.FACE_DETECT.value))) {
          bool1 = bool3;
        } else {
          bool1 = false;
        }
        showFaceTips(bool1, this.uiHandler, 1004);
      }
    }
    else if ((getFaceDetector() != null) && (!getFaceDetector().isLastFrameDetectFaces()))
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
      if (this.mIsVideoItemEnabled)
      {
        localObject = this.mVideoMaterial;
        if ((localObject != null) && (((VideoMaterial)localObject).needFaceInfo()))
        {
          sendNoFaceMessageDelay(this.uiHandler, 1004);
          return;
        }
      }
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkVideoShowFaceView VideoItem[");
      localStringBuilder.append(this.mIsVideoItemEnabled);
      localStringBuilder.append("] Cosmetic[");
      localStringBuilder.append(this.mIsCosmeticItemEnabled);
      localStringBuilder.append("] bodyBeauty[");
      localStringBuilder.append(this.mIsBodyBeautyItemEnabled);
      localStringBuilder.append("]");
      Log.i((String)localObject, localStringBuilder.toString());
      localObject = this.uiHandler;
      if (localObject != null)
      {
        if (((Handler)localObject).hasMessages(1004))
        {
          this.uiHandler.removeMessages(1004);
          this.uiHandler.sendEmptyMessage(1018);
        }
        if (this.uiHandler.hasMessages(1017))
        {
          this.uiHandler.removeMessages(1017);
          this.uiHandler.sendEmptyMessage(1019);
        }
      }
    }
    else
    {
      if (getFaceDetector() == null) {
        return;
      }
      i = getFaceDetector().getFaceCount();
      localObject = this.uiHandler;
      if ((localObject != null) && (((Handler)localObject).hasMessages(1004)))
      {
        this.uiHandler.removeMessages(1004);
        this.uiHandler.sendEmptyMessage(1018);
      }
      localObject = this.uiHandler;
      if ((localObject != null) && (this.mVideoMaterial != null)) {
        if (i < 2)
        {
          if (!((Handler)localObject).hasMessages(1009)) {
            this.uiHandler.sendEmptyMessage(1009);
          }
        }
        else
        {
          if (((Handler)localObject).hasMessages(1009)) {
            this.uiHandler.removeMessages(1009);
          }
          if (!this.uiHandler.hasMessages(1010)) {
            this.uiHandler.sendEmptyMessage(1010);
          }
        }
      }
    }
  }
  
  public String getActionTipString(int paramInt)
  {
    HashMap localHashMap = this.actionTipsMap;
    String str = "";
    if (localHashMap == null) {
      return "";
    }
    if (localHashMap.containsKey(Integer.valueOf(paramInt))) {
      str = (String)this.actionTipsMap.get(Integer.valueOf(paramInt));
    }
    return str;
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
    paramVideoMaterial = this.mVideoMaterial;
    if ((paramVideoMaterial != null) && (paramVideoMaterial.isCosFunMaterial()) && (this.mVideoMaterial.getCosFun().getTipsAnim() != null))
    {
      this.customTipText = "";
      this.customTipIcon = "";
      return;
    }
    if (this.mVideoMaterial != null)
    {
      if ((this.isPhoneSupport) && (DeviceUtils.hasDeviceNormal(AEModule.getContext())))
      {
        if (this.mVideoMaterial.getTipsIcon() != null)
        {
          this.customTipIcon = this.mVideoMaterial.getTipsIcon();
          this.customTipText = this.mVideoMaterial.getTipsText();
          return;
        }
        this.customTipIcon = "";
        return;
      }
      this.customTipText = "当前机型不支持该挂件特效";
      this.customTipIcon = "";
    }
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
    if (paramBoolean)
    {
      if ((paramHandler != null) && (!paramHandler.hasMessages(paramInt)))
      {
        paramHandler.removeMessages(1019);
        paramHandler.sendEmptyMessageDelayed(paramInt, 2000L);
      }
    }
    else if ((paramHandler != null) && (paramHandler.hasMessages(paramInt)))
    {
      paramHandler.removeMessages(paramInt);
      paramHandler.sendEmptyMessage(1019);
    }
  }
  
  public void showFaceTips(boolean paramBoolean, Handler paramHandler, int paramInt)
  {
    if (paramBoolean)
    {
      if ((paramHandler != null) && (!paramHandler.hasMessages(paramInt)))
      {
        paramHandler.removeMessages(1018);
        paramHandler.sendEmptyMessageDelayed(paramInt, 2000L);
      }
    }
    else if ((paramHandler != null) && (paramHandler.hasMessages(paramInt)))
    {
      paramHandler.removeMessages(paramInt);
      paramHandler.sendEmptyMessage(1018);
    }
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