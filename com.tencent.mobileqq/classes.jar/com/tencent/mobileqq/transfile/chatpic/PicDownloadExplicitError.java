package com.tencent.mobileqq.transfile.chatpic;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.image.CustomError;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferResult;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class PicDownloadExplicitError
  extends CustomError
{
  public static final String C2C_PIC_REQUEST_EXPIRED_DESC = "T_208";
  private static final int ERROR_EXPIRED = 1;
  private static final int ERROR_IO = 3;
  private static final int ERROR_PARAM_CHECK = 2;
  public static final String GROUP_PIC_EXPIRED_DESC = "H_404_-6101";
  public static final String GROUP_PIC_REQUEST_EXPIRED_DESC = "T_203";
  public static final String GROUP_PIC_REQUEST_QUERY_INDEX_TIMEOUT_DESC = "T_206";
  private static final Map<Integer, PicDownloadExplicitError.ExplicitError> M_MAP = new HashMap();
  public static final String TAG = "PicDownloadExplicitError";
  private int mErrCode;
  
  static
  {
    M_MAP.put(Integer.valueOf(1), new PicDownloadExplicitError.ExplicitError(2130838023, 2131689920));
    M_MAP.put(Integer.valueOf(2), new PicDownloadExplicitError.ExplicitError(-1, 2131689921));
    M_MAP.put(Integer.valueOf(3), new PicDownloadExplicitError.ExplicitError(-1, 2131689922));
  }
  
  private PicDownloadExplicitError(int paramInt)
  {
    this.mErrCode = paramInt;
  }
  
  private static PicDownloadExplicitError getError(PicResult paramPicResult)
  {
    return null;
  }
  
  private static PicDownloadExplicitError getError(TransferResult paramTransferResult)
  {
    Object localObject = paramTransferResult.mOrigReq;
    if (localObject != null)
    {
      long l = paramTransferResult.mErrCode;
      String str = paramTransferResult.mErrDesc;
      int i = ((TransferRequest)localObject).mUinType;
      localObject = ((TransferRequest)localObject).mRec;
      if (((localObject instanceof MessageForPic)) && (FlashPicHelper.a((MessageForPic)localObject))) {
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getError,errCode:");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" errDesc:");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" uinType:");
        ((StringBuilder)localObject).append(i);
        QLog.d("PicDownloadExplicitError", 2, ((StringBuilder)localObject).toString());
      }
      if ((i != 1) && (i != 3000))
      {
        if (l == -9527L)
        {
          if (!"T_208".equals(str)) {
            break label312;
          }
          paramTransferResult = new PicDownloadExplicitError(1);
        }
        else
        {
          if (paramTransferResult.mErrCode == 9302L) {
            return new PicDownloadExplicitError(2);
          }
          if ((l != 9039L) && (l != 9040L)) {
            break label312;
          }
          return new PicDownloadExplicitError(3);
        }
      }
      else
      {
        if (l != -9527L) {
          break label267;
        }
        if ((!"H_404_-6101".equals(str)) && (!"T_203".equals(str)) && (!"T_206".equals(str))) {
          break label312;
        }
        paramTransferResult = new PicDownloadExplicitError(1);
      }
      return paramTransferResult;
      label267:
      if (paramTransferResult.mErrCode == 9302L) {
        return new PicDownloadExplicitError(2);
      }
      if ((l == 9039L) || (l == 9040L)) {
        return new PicDownloadExplicitError(3);
      }
    }
    label312:
    return null;
  }
  
  private String getFailedTip()
  {
    PicDownloadExplicitError.ExplicitError localExplicitError = (PicDownloadExplicitError.ExplicitError)M_MAP.get(Integer.valueOf(this.mErrCode));
    if (localExplicitError != null)
    {
      int i = localExplicitError.getTipResId();
      if (i > 0) {
        return BaseApplication.getContext().getResources().getString(i);
      }
    }
    return BaseApplication.getContext().getResources().getString(2131689920);
  }
  
  public static String getFailedTip(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStateError() instanceof PicDownloadExplicitError)) {
      return ((PicDownloadExplicitError)paramURLDrawable.getStateError()).getFailedTip();
    }
    return null;
  }
  
  public static PicDownloadExplicitError getPicError(Object paramObject)
  {
    if ((paramObject instanceof TransferResult)) {
      return getError((TransferResult)paramObject);
    }
    if ((paramObject instanceof PicResult)) {
      return getError((PicResult)paramObject);
    }
    return null;
  }
  
  protected Drawable getFailedDrawable()
  {
    PicDownloadExplicitError.ExplicitError localExplicitError = (PicDownloadExplicitError.ExplicitError)M_MAP.get(Integer.valueOf(this.mErrCode));
    if (localExplicitError != null)
    {
      int i = localExplicitError.getDrawableResId();
      if (i > 0) {
        return CommonImageCacheHelper.a(null, i);
      }
    }
    return CommonImageCacheHelper.a("static://CommonFailedDrawable", 2130838025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError
 * JD-Core Version:    0.7.0.1
 */