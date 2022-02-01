package com.tencent.mobileqq.filemanager.api;

import android.content.Context;
import android.net.Uri;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQFileUtils
  extends QRouteApi
{
  public abstract boolean checkComplexMessage(MessageRecord paramMessageRecord);
  
  public abstract boolean copyFileToMediaStore(Context paramContext, String paramString, Uri paramUri);
  
  public abstract void correctFileEntityInfo(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity, MessageRecord paramMessageRecord);
  
  public abstract String getAIOFileBubbleShowName(Context paramContext, int paramInt1, int paramInt2, TextView paramTextView1, TextView paramTextView2, String paramString1, String paramString2);
  
  public abstract int getAIOFileBubbleShowType(int paramInt1, int paramInt2);
  
  public abstract int getIPStackType();
  
  public abstract int getIpAddrType(String paramString);
  
  public abstract int getIpAddrTypeOfUrl(String paramString);
  
  public abstract int getReportIPStackType();
  
  public abstract int getReportLoginIPStackType();
  
  public abstract boolean isShowSendtoWxFaild(Context paramContext, String paramString);
  
  public abstract void setFileDescription(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQFileUtils
 * JD-Core Version:    0.7.0.1
 */