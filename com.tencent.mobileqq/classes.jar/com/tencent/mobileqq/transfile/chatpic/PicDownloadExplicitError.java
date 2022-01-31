package com.tencent.mobileqq.transfile.chatpic;

import alnp;
import alpw;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import awfd;
import baub;
import baui;
import baul;
import bava;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.CustomError;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class PicDownloadExplicitError
  extends CustomError
{
  public static final String C2C_PIC_REQUEST_EXPIRED_DESC = "T_208";
  public static final String GROUP_PIC_EXPIRED_DESC = "H_404_-6101";
  public static final String GROUP_PIC_REQUEST_EXPIRED_DESC = "T_203";
  public static final String GROUP_PIC_REQUEST_QUERY_INDEX_TIMEOUT_DESC = "T_206";
  public static final String TAG = "PicDownloadExplicitError";
  private static final Map<Integer, bava> a = new HashMap();
  private int mErrCode;
  
  static
  {
    a.put(Integer.valueOf(1), new bava(2130837966, 2131690023));
    a.put(Integer.valueOf(2), new bava(-1, 2131690024));
    a.put(Integer.valueOf(3), new bava(-1, 2131690025));
  }
  
  private PicDownloadExplicitError(int paramInt)
  {
    this.mErrCode = paramInt;
  }
  
  private static PicDownloadExplicitError a(awfd paramawfd)
  {
    return null;
  }
  
  private static PicDownloadExplicitError a(baui parambaui)
  {
    Object localObject = parambaui.jdField_a_of_type_Baub;
    long l;
    String str;
    if (localObject != null)
    {
      l = parambaui.jdField_a_of_type_Long;
      str = parambaui.jdField_a_of_type_JavaLangString;
      int i = ((baub)localObject).jdField_a_of_type_Int;
      localObject = ((baub)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        if ((alpw.a((MessageRecord)localObject)) || (alnp.a((MessageRecord)localObject))) {
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
          parambaui = new PicDownloadExplicitError(1);
        }
      }
    }
    for (;;)
    {
      return parambaui;
      if (parambaui.jdField_a_of_type_Long == 9302L)
      {
        parambaui = new PicDownloadExplicitError(2);
      }
      else
      {
        if ((l == 9039L) || (l == 9040L))
        {
          parambaui = new PicDownloadExplicitError(3);
          continue;
          if (l == -9527L)
          {
            if ("T_208".equals(str)) {
              parambaui = new PicDownloadExplicitError(1);
            }
          }
          else
          {
            if (parambaui.jdField_a_of_type_Long == 9302L)
            {
              parambaui = new PicDownloadExplicitError(2);
              continue;
            }
            if ((l == 9039L) || (l == 9040L))
            {
              parambaui = new PicDownloadExplicitError(3);
              continue;
            }
          }
        }
        label311:
        parambaui = null;
      }
    }
  }
  
  private String a()
  {
    bava localbava = (bava)a.get(Integer.valueOf(this.mErrCode));
    if (localbava != null)
    {
      int i = localbava.b();
      if (i > 0) {
        return BaseApplicationImpl.getApplication().getResources().getString(i);
      }
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131690023);
  }
  
  public static String getFailedTip(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStateError() instanceof PicDownloadExplicitError)) {
      return ((PicDownloadExplicitError)paramURLDrawable.getStateError()).a();
    }
    return null;
  }
  
  public static PicDownloadExplicitError getPicError(Object paramObject)
  {
    if ((paramObject instanceof baui)) {
      return a((baui)paramObject);
    }
    if ((paramObject instanceof awfd)) {
      return a((awfd)paramObject);
    }
    return null;
  }
  
  public Drawable getFailedDrawable()
  {
    bava localbava = (bava)a.get(Integer.valueOf(this.mErrCode));
    if (localbava != null)
    {
      int i = localbava.a();
      if (i > 0) {
        return baul.a(i);
      }
    }
    return baul.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError
 * JD-Core Version:    0.7.0.1
 */