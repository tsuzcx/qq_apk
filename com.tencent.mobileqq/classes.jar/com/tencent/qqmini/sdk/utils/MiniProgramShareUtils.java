package com.tencent.qqmini.sdk.utils;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare.StTemplateInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class MiniProgramShareUtils
{
  public static final String MINI_APP_SHARE_APPID = "miniAppShareAppid";
  public static final String MINI_APP_SHARE_APP_TYPE = "miniAppShareAppType";
  public static final String MINI_APP_SHARE_DEST_ID = "miniAppShareDestId";
  public static final String MINI_APP_SHARE_DEST_TYPE = "miniAppShareDestType";
  public static final String MINI_APP_SHARE_FROM = "miniAppShareFrom";
  public static final int MINI_APP_SHARE_FROM_DETAIL = 10;
  public static final int MINI_APP_SHARE_FROM_INNER_BUTTON = 11;
  public static final int MINI_APP_SHARE_FROM_MORE_BUTTON = 12;
  public static final String MINI_APP_SHARE_SCENE = "miniAppShareScene";
  public static final String MINI_APP_SHARE_TYPE = "miniAppShareType";
  
  public static MiniProgramShare.StAdaptShareInfoReq newShareInfoRequest(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, String paramString5, String paramString6, String paramString7, COMM.StCommonExt paramStCommonExt, int paramInt5, String paramString8, int paramInt6, boolean paramBoolean, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    MiniProgramShare.StAdaptShareInfoReq localStAdaptShareInfoReq = new MiniProgramShare.StAdaptShareInfoReq();
    if (paramString1 != null) {
      localStAdaptShareInfoReq.appid.set(paramString1);
    }
    if (paramString2 != null) {
      localStAdaptShareInfoReq.title.set(paramString2);
    }
    if (paramString3 != null) {
      localStAdaptShareInfoReq.desc.set(paramString3);
    }
    localStAdaptShareInfoReq.time.set(paramInt1);
    localStAdaptShareInfoReq.scene.set(paramInt2);
    localStAdaptShareInfoReq.templetType.set(paramInt3);
    localStAdaptShareInfoReq.businessType.set(paramInt4);
    setUrl(paramString4, paramString5, paramString6, paramString7, localStAdaptShareInfoReq);
    if (paramStCommonExt != null) {
      localStAdaptShareInfoReq.extInfo.set(paramStCommonExt);
    }
    localStAdaptShareInfoReq.verType.set(paramInt5);
    if (paramString8 != null) {
      localStAdaptShareInfoReq.versionId.set(paramString8);
    }
    localStAdaptShareInfoReq.shareType.set(paramInt6);
    paramString1 = localStAdaptShareInfoReq.withShareTicket;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.set(paramInt1);
      if (paramString9 != null) {
        localStAdaptShareInfoReq.webURL.set(paramString9);
      }
      if (paramString10 != null) {
        localStAdaptShareInfoReq.appidRich.set(paramString10);
      }
      setTemplate(paramString11, paramString12, localStAdaptShareInfoReq);
      if ((paramInt6 == 5) && (paramString13 != null)) {
        localStAdaptShareInfoReq.rcvOpenId.set(paramString13);
      }
      return localStAdaptShareInfoReq;
    }
  }
  
  private static void setTemplate(String paramString1, String paramString2, MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      MiniProgramShare.StTemplateInfo localStTemplateInfo = new MiniProgramShare.StTemplateInfo();
      localStTemplateInfo.templateId.set(paramString1);
      localStTemplateInfo.templateData.set(paramString2);
      paramStAdaptShareInfoReq.template.set(localStTemplateInfo);
    }
  }
  
  private static void setUrl(String paramString1, String paramString2, String paramString3, String paramString4, MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq)
  {
    if (paramString1 != null) {
      paramStAdaptShareInfoReq.picUrl.set(paramString1);
    }
    if (paramString2 != null) {
      paramStAdaptShareInfoReq.vidUrl.set(paramString2);
    }
    if (paramString3 != null) {
      paramStAdaptShareInfoReq.jumpUrl.set(paramString3);
    }
    if (paramString4 != null) {
      paramStAdaptShareInfoReq.iconUrl.set(paramString4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniProgramShareUtils
 * JD-Core Version:    0.7.0.1
 */