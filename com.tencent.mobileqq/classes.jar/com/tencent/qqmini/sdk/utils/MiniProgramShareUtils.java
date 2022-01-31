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
    if (paramString4 != null) {
      localStAdaptShareInfoReq.picUrl.set(paramString4);
    }
    if (paramString5 != null) {
      localStAdaptShareInfoReq.vidUrl.set(paramString5);
    }
    if (paramString6 != null) {
      localStAdaptShareInfoReq.jumpUrl.set(paramString6);
    }
    if (paramString7 != null) {
      localStAdaptShareInfoReq.iconUrl.set(paramString7);
    }
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
      if ((paramString11 != null) && (paramString12 != null))
      {
        paramString1 = new MiniProgramShare.StTemplateInfo();
        paramString1.templateId.set(paramString11);
        paramString1.templateData.set(paramString12);
        localStAdaptShareInfoReq.template.set(paramString1);
      }
      if ((paramInt6 == 5) && (paramString13 != null)) {
        localStAdaptShareInfoReq.rcvOpenId.set(paramString13);
      }
      return localStAdaptShareInfoReq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniProgramShareUtils
 * JD-Core Version:    0.7.0.1
 */