package com.tencent.qqmini.sdk.utils;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare.StTemplateInfo;
import com.tencent.mobileqq.pb.PBStringField;

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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniProgramShareUtils
 * JD-Core Version:    0.7.0.1
 */