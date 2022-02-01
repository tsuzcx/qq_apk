package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Context;
import android.net.Uri;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQFileUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.filemanager.util.QQFileUtilsImpl;

public class QFileUtilsImpl
  implements IQFileUtils
{
  public boolean checkComplexMessage(MessageRecord paramMessageRecord)
  {
    return QQFileUtilsImpl.a(paramMessageRecord);
  }
  
  public boolean copyFileToMediaStore(Context paramContext, String paramString, Uri paramUri)
  {
    return QQFileUtilsImpl.a(paramContext, paramString, paramUri);
  }
  
  public void correctFileEntityInfo(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity, MessageRecord paramMessageRecord)
  {
    QQFileUtilsImpl.a(paramBaseQQAppInterface, paramFileManagerEntity, paramMessageRecord);
  }
  
  public String getAIOFileBubbleShowName(Context paramContext, int paramInt1, int paramInt2, TextView paramTextView1, TextView paramTextView2, String paramString1, String paramString2)
  {
    return QQFileUtilsImpl.a(paramContext, paramInt1, paramInt2, paramTextView1, paramTextView2, paramString1, paramString2);
  }
  
  public int getAIOFileBubbleShowType(int paramInt1, int paramInt2)
  {
    return QQFileUtilsImpl.a(paramInt1, paramInt2);
  }
  
  public int getIPStackType()
  {
    return QQFileUtilsImpl.a();
  }
  
  public int getIpAddrType(String paramString)
  {
    return QQFileUtilsImpl.b(paramString);
  }
  
  public int getIpAddrTypeOfUrl(String paramString)
  {
    return QQFileUtilsImpl.a(paramString);
  }
  
  public int getReportIPStackType()
  {
    return QQFileUtilsImpl.b();
  }
  
  public int getReportLoginIPStackType()
  {
    return QQFileUtilsImpl.c();
  }
  
  public boolean isShowSendtoWxFaild(Context paramContext, String paramString)
  {
    return QQFileUtilsImpl.a(paramContext, paramString);
  }
  
  public void setFileDescription(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    QQFileUtilsImpl.a(paramContext, paramTextView, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramTipsClickedInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QFileUtilsImpl
 * JD-Core Version:    0.7.0.1
 */