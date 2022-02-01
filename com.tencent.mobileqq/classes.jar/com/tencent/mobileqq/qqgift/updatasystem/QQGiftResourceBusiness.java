package com.tencent.mobileqq.qqgift.updatasystem;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;

public class QQGiftResourceBusiness
  extends QQVasUpdateBusiness
{
  public int a(String paramString, int paramInt)
  {
    Object localObject;
    if (paramInt == 1) {
      localObject = ".panel.zip";
    } else if (paramInt == 2) {
      localObject = ".animation.zip";
    } else {
      localObject = "";
    }
    try
    {
      int i = paramString.length() - ((String)localObject).length();
      if (i < 9)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getId error, scid:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", type:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", suffix:");
        localStringBuilder.append((String)localObject);
        QLog.e("QQGiftResourceBusiness", 1, localStringBuilder.toString());
        return 0;
      }
      paramInt = Integer.parseInt(paramString.substring(9, i));
      return paramInt;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get id throw exception e:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("QQGiftResourceBusiness", 1, ((StringBuilder)localObject).toString());
    }
    return 0;
  }
  
  protected String a()
  {
    return "Gift";
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      localObject = ".panel.zip";
    }
    else
    {
      if (paramInt2 != 2) {
        break label56;
      }
      localObject = ".animation.zip";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("livegift.");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
    label56:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getScid error! suffix is empty! id:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", type:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.e("QQGiftResourceBusiness", 1, ((StringBuilder)localObject).toString());
    return super.b(paramInt1);
  }
  
  @Deprecated
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public long getBid()
  {
    return 311L;
  }
  
  public String getFrom()
  {
    return "downloadGiftResource";
  }
  
  public void onLoadFail(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    if ((paramUpdateListenerParams.mBusinessUpdateParams != null) && (paramUpdateListenerParams.mBusinessUpdateParams.mBid == 311L)) {
      super.onLoadFail(paramUpdateListenerParams);
    }
  }
  
  public void onLoadSuccess(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    if ((paramUpdateListenerParams.mBusinessUpdateParams != null) && (paramUpdateListenerParams.mBusinessUpdateParams.mBid == 311L)) {
      super.onLoadSuccess(paramUpdateListenerParams);
    }
  }
  
  public void onProgress(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    if ((paramUpdateListenerParams.mBusinessUpdateParams != null) && (paramUpdateListenerParams.mBusinessUpdateParams.mBid == 311L)) {
      super.onProgress(paramUpdateListenerParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness
 * JD-Core Version:    0.7.0.1
 */