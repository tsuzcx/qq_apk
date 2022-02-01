package com.tencent.mobileqq.transfile.chatpic;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.CustomError;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferResult;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
    M_MAP.put(Integer.valueOf(1), new PicDownloadExplicitError.ExplicitError(2130838182, 2131690005));
    M_MAP.put(Integer.valueOf(2), new PicDownloadExplicitError.ExplicitError(-1, 2131690006));
    M_MAP.put(Integer.valueOf(3), new PicDownloadExplicitError.ExplicitError(-1, 2131690007));
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
    long l;
    String str;
    if (localObject != null)
    {
      l = paramTransferResult.mErrCode;
      str = paramTransferResult.mErrDesc;
      int i = ((TransferRequest)localObject).mUinType;
      localObject = ((TransferRequest)localObject).mRec;
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        if ((HotChatHelper.a((MessageRecord)localObject)) || (FlashPicHelper.a((MessageRecord)localObject))) {
          return null;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicDownloadExplicitError", 2, "getError,errCode:" + l + " errDesc:" + str + " uinType:" + i);
      }
      if ((i == 1) || (i == 3000)) {
        if (l == -9527L)
        {
          if ((!"H_404_-6101".equals(str)) && (!"T_203".equals(str)) && (!"T_206".equals(str))) {
            break label311;
          }
          paramTransferResult = new PicDownloadExplicitError(1);
        }
      }
    }
    for (;;)
    {
      return paramTransferResult;
      if (paramTransferResult.mErrCode == 9302L)
      {
        paramTransferResult = new PicDownloadExplicitError(2);
      }
      else
      {
        if ((l == 9039L) || (l == 9040L))
        {
          paramTransferResult = new PicDownloadExplicitError(3);
          continue;
          if (l == -9527L)
          {
            if ("T_208".equals(str)) {
              paramTransferResult = new PicDownloadExplicitError(1);
            }
          }
          else
          {
            if (paramTransferResult.mErrCode == 9302L)
            {
              paramTransferResult = new PicDownloadExplicitError(2);
              continue;
            }
            if ((l == 9039L) || (l == 9040L))
            {
              paramTransferResult = new PicDownloadExplicitError(3);
              continue;
            }
          }
        }
        label311:
        paramTransferResult = null;
      }
    }
  }
  
  private String getFailedTip()
  {
    PicDownloadExplicitError.ExplicitError localExplicitError = (PicDownloadExplicitError.ExplicitError)M_MAP.get(Integer.valueOf(this.mErrCode));
    if (localExplicitError != null)
    {
      int i = localExplicitError.getTipResId();
      if (i > 0) {
        return BaseApplicationImpl.getApplication().getResources().getString(i);
      }
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131690005);
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
  
  public Drawable getFailedDrawable()
  {
    PicDownloadExplicitError.ExplicitError localExplicitError = (PicDownloadExplicitError.ExplicitError)M_MAP.get(Integer.valueOf(this.mErrCode));
    if (localExplicitError != null)
    {
      int i = localExplicitError.getDrawableResId();
      if (i > 0) {
        return URLDrawableHelper.getResourceDrawable(i);
      }
    }
    return URLDrawableHelper.getFailedDrawable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError
 * JD-Core Version:    0.7.0.1
 */